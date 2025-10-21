package proguard.dexfile.ir.ts.an;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SimpleLiveValueDiffblueTest {
  /**
   * Test {@link SimpleLiveValue#toRsp()}.
   *
   * <ul>
   *   <li>Given {@link SimpleLiveValue} (default constructor) {@link SimpleLiveValue#used} is
   *       {@code true}.
   *   <li>Then return {@code x}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleLiveValue#toRsp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char SimpleLiveValue.toRsp()"})
  public void testToRsp_givenSimpleLiveValueUsedIsTrue_thenReturnX() {
    // Arrange
    SimpleLiveValue simpleLiveValue = new SimpleLiveValue();
    simpleLiveValue.used = true;

    // Act and Assert
    assertEquals('x', simpleLiveValue.toRsp());
  }

  /**
   * Test {@link SimpleLiveValue#toRsp()}.
   *
   * <ul>
   *   <li>Given {@link SimpleLiveValue} (default constructor).
   *   <li>Then return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleLiveValue#toRsp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char SimpleLiveValue.toRsp()"})
  public void testToRsp_givenSimpleLiveValue_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals('.', (new SimpleLiveValue()).toRsp());
  }

  /**
   * Test new {@link SimpleLiveValue} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SimpleLiveValue}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleLiveValue.<init>()"})
  public void testNewSimpleLiveValue() {
    // Arrange and Act
    SimpleLiveValue actualSimpleLiveValue = new SimpleLiveValue();

    // Assert
    assertEquals('.', actualSimpleLiveValue.toRsp());
    assertNull(actualSimpleLiveValue.otherParents);
    assertNull(actualSimpleLiveValue.parent);
    assertFalse(actualSimpleLiveValue.used);
  }
}
