package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SourceDirAttributeDiffblueTest {
  /**
   * Test {@link SourceDirAttribute#SourceDirAttribute()}.
   *
   * <p>Method under test: {@link SourceDirAttribute#SourceDirAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SourceDirAttribute.<init>()",
    "void SourceDirAttribute.<init>(int, int)"
  })
  public void testNewSourceDirAttribute() {
    // Arrange and Act
    SourceDirAttribute actualSourceDirAttribute = new SourceDirAttribute();

    // Assert
    assertNull(actualSourceDirAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDirAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SourceDirAttribute#SourceDirAttribute(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SourceDirAttribute#SourceDirAttribute(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SourceDirAttribute.<init>()",
    "void SourceDirAttribute.<init>(int, int)"
  })
  public void testNewSourceDirAttribute_whenOne() {
    // Arrange and Act
    SourceDirAttribute actualSourceDirAttribute = new SourceDirAttribute(1, 1);

    // Assert
    assertNull(actualSourceDirAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDirAttribute.getProcessingFlags());
  }
}
