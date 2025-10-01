package proguard.classfile.attribute.module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExportsInfoDiffblueTest {
  /**
   * Test {@link ExportsInfo#ExportsInfo()}.
   *
   * <p>Method under test: {@link ExportsInfo#ExportsInfo()}
   */
  @Test
  @DisplayName("Test new ExportsInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExportsInfo.<init>()", "void ExportsInfo.<init>(int, int, int, int[])"})
  void testNewExportsInfo() {
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
  @DisplayName("Test new ExportsInfo(int, int, int, int[]); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ExportsInfo.<init>()", "void ExportsInfo.<init>(int, int, int, int[])"})
  void testNewExportsInfo_whenOne() {
    // Arrange and Act
    ExportsInfo actualExportsInfo = new ExportsInfo(1, 1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualExportsInfo.getProcessingInfo());
    assertEquals(0, actualExportsInfo.getProcessingFlags());
  }
}
