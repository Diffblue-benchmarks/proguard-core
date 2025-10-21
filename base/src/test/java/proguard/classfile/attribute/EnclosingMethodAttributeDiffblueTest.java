package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EnclosingMethodAttributeDiffblueTest {
  /**
   * Test {@link EnclosingMethodAttribute#EnclosingMethodAttribute()}.
   *
   * <p>Method under test: {@link EnclosingMethodAttribute#EnclosingMethodAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void EnclosingMethodAttribute.<init>()",
    "void EnclosingMethodAttribute.<init>(int, int, int)"
  })
  public void testNewEnclosingMethodAttribute() {
    // Arrange and Act
    EnclosingMethodAttribute actualEnclosingMethodAttribute = new EnclosingMethodAttribute();

    // Assert
    assertNull(actualEnclosingMethodAttribute.getProcessingInfo());
    assertEquals(0, actualEnclosingMethodAttribute.getProcessingFlags());
  }

  /**
   * Test {@link EnclosingMethodAttribute#EnclosingMethodAttribute(int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link EnclosingMethodAttribute#EnclosingMethodAttribute(int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void EnclosingMethodAttribute.<init>()",
    "void EnclosingMethodAttribute.<init>(int, int, int)"
  })
  public void testNewEnclosingMethodAttribute_whenOne() {
    // Arrange and Act
    EnclosingMethodAttribute actualEnclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);

    // Assert
    assertNull(actualEnclosingMethodAttribute.getProcessingInfo());
    assertEquals(0, actualEnclosingMethodAttribute.getProcessingFlags());
  }
}
