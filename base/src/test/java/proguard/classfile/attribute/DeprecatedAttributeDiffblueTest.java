package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeprecatedAttributeDiffblueTest {
  /**
   * Test {@link DeprecatedAttribute#DeprecatedAttribute()}.
   *
   * <p>Method under test: {@link DeprecatedAttribute#DeprecatedAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeprecatedAttribute.<init>()", "void DeprecatedAttribute.<init>(int)"})
  public void testNewDeprecatedAttribute() {
    // Arrange and Act
    DeprecatedAttribute actualDeprecatedAttribute = new DeprecatedAttribute();

    // Assert
    assertNull(actualDeprecatedAttribute.getProcessingInfo());
    assertEquals(0, actualDeprecatedAttribute.getProcessingFlags());
  }

  /**
   * Test {@link DeprecatedAttribute#DeprecatedAttribute(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link DeprecatedAttribute#DeprecatedAttribute(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeprecatedAttribute.<init>()", "void DeprecatedAttribute.<init>(int)"})
  public void testNewDeprecatedAttribute_whenOne() {
    // Arrange and Act
    DeprecatedAttribute actualDeprecatedAttribute = new DeprecatedAttribute(1);

    // Assert
    assertNull(actualDeprecatedAttribute.getProcessingInfo());
    assertEquals(0, actualDeprecatedAttribute.getProcessingFlags());
  }
}
