package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExportsInfoDiffblueTest {
  /**
   * Test {@link ExportsInfo#ExportsInfo()}.
   *
   * <p>Method under test: {@link ExportsInfo#ExportsInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExportsInfo.<init>()", "void ExportsInfo.<init>(int, int, int, int[])"})
  public void testNewExportsInfo() {
    // Arrange and Act
    ExportsInfo actualExportsInfo = new ExportsInfo();

    // Assert
    assertNull(actualExportsInfo.getProcessingInfo());
    assertEquals(0, actualExportsInfo.getProcessingFlags());
  }

  /**
   * Test {@link ExportsInfo#ExportsInfo(int, int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ExportsInfo#ExportsInfo(int, int, int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExportsInfo.<init>()", "void ExportsInfo.<init>(int, int, int, int[])"})
  public void testNewExportsInfo_whenOne() {
    // Arrange and Act
    ExportsInfo actualExportsInfo = new ExportsInfo(1, 1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualExportsInfo.getProcessingInfo());
    assertEquals(0, actualExportsInfo.getProcessingFlags());
  }
}
