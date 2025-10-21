package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SourceFileAttributeDiffblueTest {
  /**
   * Test {@link SourceFileAttribute#SourceFileAttribute()}.
   *
   * <p>Method under test: {@link SourceFileAttribute#SourceFileAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SourceFileAttribute.<init>()",
    "void SourceFileAttribute.<init>(int, int)"
  })
  public void testNewSourceFileAttribute() {
    // Arrange and Act
    SourceFileAttribute actualSourceFileAttribute = new SourceFileAttribute();

    // Assert
    assertNull(actualSourceFileAttribute.getProcessingInfo());
    assertEquals(0, actualSourceFileAttribute.getProcessingFlags());
  }

  /**
   * Test {@link SourceFileAttribute#SourceFileAttribute(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link SourceFileAttribute#SourceFileAttribute(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SourceFileAttribute.<init>()",
    "void SourceFileAttribute.<init>(int, int)"
  })
  public void testNewSourceFileAttribute_whenOne() {
    // Arrange and Act
    SourceFileAttribute actualSourceFileAttribute = new SourceFileAttribute(1, 1);

    // Assert
    assertNull(actualSourceFileAttribute.getProcessingInfo());
    assertEquals(0, actualSourceFileAttribute.getProcessingFlags());
  }
}
