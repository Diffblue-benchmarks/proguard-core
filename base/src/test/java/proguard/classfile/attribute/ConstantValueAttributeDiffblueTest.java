package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConstantValueAttributeDiffblueTest {
  /**
   * Test {@link ConstantValueAttribute#ConstantValueAttribute()}.
   *
   * <p>Method under test: {@link ConstantValueAttribute#ConstantValueAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantValueAttribute.<init>()",
    "void ConstantValueAttribute.<init>(int, int)"
  })
  public void testNewConstantValueAttribute() {
    // Arrange and Act
    ConstantValueAttribute actualConstantValueAttribute = new ConstantValueAttribute();

    // Assert
    assertNull(actualConstantValueAttribute.getProcessingInfo());
    assertEquals(0, actualConstantValueAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ConstantValueAttribute#ConstantValueAttribute(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantValueAttribute#ConstantValueAttribute(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantValueAttribute.<init>()",
    "void ConstantValueAttribute.<init>(int, int)"
  })
  public void testNewConstantValueAttribute_whenOne() {
    // Arrange and Act
    ConstantValueAttribute actualConstantValueAttribute = new ConstantValueAttribute(1, 1);

    // Assert
    assertNull(actualConstantValueAttribute.getProcessingInfo());
    assertEquals(0, actualConstantValueAttribute.getProcessingFlags());
  }
}
