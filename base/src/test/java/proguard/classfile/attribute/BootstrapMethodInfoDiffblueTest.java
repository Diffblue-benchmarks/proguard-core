package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BootstrapMethodInfoDiffblueTest {
  /**
   * Test {@link BootstrapMethodInfo#BootstrapMethodInfo()}.
   *
   * <p>Method under test: {@link BootstrapMethodInfo#BootstrapMethodInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodInfo.<init>()",
    "void BootstrapMethodInfo.<init>(int, int, int[])"
  })
  public void testNewBootstrapMethodInfo() {
    // Arrange and Act
    BootstrapMethodInfo actualBootstrapMethodInfo = new BootstrapMethodInfo();

    // Assert
    assertNull(actualBootstrapMethodInfo.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodInfo.getProcessingFlags());
  }

  /**
   * Test {@link BootstrapMethodInfo#BootstrapMethodInfo(int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodInfo#BootstrapMethodInfo(int, int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodInfo.<init>()",
    "void BootstrapMethodInfo.<init>(int, int, int[])"
  })
  public void testNewBootstrapMethodInfo_whenOne() {
    // Arrange and Act
    BootstrapMethodInfo actualBootstrapMethodInfo =
        new BootstrapMethodInfo(1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualBootstrapMethodInfo.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodInfo.getProcessingFlags());
  }
}
