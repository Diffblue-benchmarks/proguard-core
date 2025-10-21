package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProvidesInfoDiffblueTest {
  /**
   * Test {@link ProvidesInfo#ProvidesInfo()}.
   *
   * <p>Method under test: {@link ProvidesInfo#ProvidesInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProvidesInfo.<init>()", "void ProvidesInfo.<init>(int, int, int[])"})
  public void testNewProvidesInfo() {
    // Arrange and Act
    ProvidesInfo actualProvidesInfo = new ProvidesInfo();

    // Assert
    assertNull(actualProvidesInfo.getProcessingInfo());
    assertEquals(0, actualProvidesInfo.getProcessingFlags());
  }

  /**
   * Test {@link ProvidesInfo#ProvidesInfo(int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ProvidesInfo#ProvidesInfo(int, int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProvidesInfo.<init>()", "void ProvidesInfo.<init>(int, int, int[])"})
  public void testNewProvidesInfo_whenOne() {
    // Arrange and Act
    ProvidesInfo actualProvidesInfo = new ProvidesInfo(1, 1, new int[] {1, 2, 1, 2});

    // Assert
    assertNull(actualProvidesInfo.getProcessingInfo());
    assertEquals(0, actualProvidesInfo.getProcessingFlags());
  }
}
