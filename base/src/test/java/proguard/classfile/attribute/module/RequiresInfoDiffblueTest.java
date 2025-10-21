package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RequiresInfoDiffblueTest {
  /**
   * Test {@link RequiresInfo#RequiresInfo()}.
   *
   * <p>Method under test: {@link RequiresInfo#RequiresInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RequiresInfo.<init>()", "void RequiresInfo.<init>(int, int, int)"})
  public void testNewRequiresInfo() {
    // Arrange and Act
    RequiresInfo actualRequiresInfo = new RequiresInfo();

    // Assert
    assertNull(actualRequiresInfo.getProcessingInfo());
    assertEquals(0, actualRequiresInfo.getProcessingFlags());
  }

  /**
   * Test {@link RequiresInfo#RequiresInfo(int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link RequiresInfo#RequiresInfo(int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RequiresInfo.<init>()", "void RequiresInfo.<init>(int, int, int)"})
  public void testNewRequiresInfo_whenOne() {
    // Arrange and Act
    RequiresInfo actualRequiresInfo = new RequiresInfo(1, 1, 1);

    // Assert
    assertNull(actualRequiresInfo.getProcessingInfo());
    assertEquals(0, actualRequiresInfo.getProcessingFlags());
  }
}
