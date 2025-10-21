package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OpensInfoDiffblueTest {
  /**
   * Test {@link OpensInfo#OpensInfo()}.
   *
   * <p>Method under test: {@link OpensInfo#OpensInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OpensInfo.<init>()", "void OpensInfo.<init>(int, int, int, int[])"})
  public void testNewOpensInfo() {
    // Arrange and Act
    OpensInfo actualOpensInfo = new OpensInfo();

    // Assert
    assertNull(actualOpensInfo.getProcessingInfo());
    assertEquals(0, actualOpensInfo.getProcessingFlags());
  }

  /**
   * Test {@link OpensInfo#OpensInfo(int, int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link OpensInfo#OpensInfo(int, int, int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OpensInfo.<init>()", "void OpensInfo.<init>(int, int, int, int[])"})
  public void testNewOpensInfo_whenOne() {
    // Arrange and Act
    OpensInfo actualOpensInfo = new OpensInfo(1, 1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualOpensInfo.getProcessingInfo());
    assertEquals(0, actualOpensInfo.getProcessingFlags());
  }
}
