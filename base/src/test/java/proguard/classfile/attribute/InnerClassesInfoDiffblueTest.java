package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InnerClassesInfoDiffblueTest {
  /**
   * Test {@link InnerClassesInfo#InnerClassesInfo()}.
   *
   * <p>Method under test: {@link InnerClassesInfo#InnerClassesInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InnerClassesInfo.<init>()",
    "void InnerClassesInfo.<init>(int, int, int, int)"
  })
  public void testNewInnerClassesInfo() {
    // Arrange and Act
    InnerClassesInfo actualInnerClassesInfo = new InnerClassesInfo();

    // Assert
    assertNull(actualInnerClassesInfo.getProcessingInfo());
    assertEquals(0, actualInnerClassesInfo.getProcessingFlags());
  }

  /**
   * Test {@link InnerClassesInfo#InnerClassesInfo(int, int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link InnerClassesInfo#InnerClassesInfo(int, int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InnerClassesInfo.<init>()",
    "void InnerClassesInfo.<init>(int, int, int, int)"
  })
  public void testNewInnerClassesInfo_whenOne() {
    // Arrange and Act
    InnerClassesInfo actualInnerClassesInfo = new InnerClassesInfo(1, 1, 1, 1);

    // Assert
    assertNull(actualInnerClassesInfo.getProcessingInfo());
    assertEquals(0, actualInnerClassesInfo.getProcessingFlags());
  }
}
