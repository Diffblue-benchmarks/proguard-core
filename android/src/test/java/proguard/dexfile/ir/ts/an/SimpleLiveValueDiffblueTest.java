package proguard.dexfile.ir.ts.an;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleLiveValueDiffblueTest {
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
  @DisplayName(
      "Test toRsp(); given SimpleLiveValue (default constructor) used is 'true'; then return 'x'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char proguard.dexfile.ir.ts.an.SimpleLiveValue.toRsp()"})
  void testToRsp_givenSimpleLiveValueUsedIsTrue_thenReturnX() {
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
  @DisplayName("Test toRsp(); given SimpleLiveValue (default constructor); then return '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"char proguard.dexfile.ir.ts.an.SimpleLiveValue.toRsp()"})
  void testToRsp_givenSimpleLiveValue_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals('.', (new SimpleLiveValue()).toRsp());
  }

  /**
   * Test new {@link SimpleLiveValue} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SimpleLiveValue}
   */
  @Test
  @DisplayName("Test new SimpleLiveValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.ts.an.SimpleLiveValue.<init>()"})
  void testNewSimpleLiveValue() {
    // Arrange and Act
    SimpleLiveValue actualSimpleLiveValue = new SimpleLiveValue();

    // Assert
    assertEquals('.', actualSimpleLiveValue.toRsp());
    assertNull(actualSimpleLiveValue.otherParents);
    assertNull(actualSimpleLiveValue.parent);
    assertFalse(actualSimpleLiveValue.used);
  }
}
