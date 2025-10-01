package proguard.classfile.attribute.module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProvidesInfoDiffblueTest {
  /**
   * Test {@link ProvidesInfo#ProvidesInfo()}.
   *
   * <p>Method under test: {@link ProvidesInfo#ProvidesInfo()}
   */
  @Test
  @DisplayName("Test new ProvidesInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProvidesInfo.<init>()", "void ProvidesInfo.<init>(int, int, int[])"})
  void testNewProvidesInfo() {
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
  @DisplayName("Test new ProvidesInfo(int, int, int[]); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProvidesInfo.<init>()", "void ProvidesInfo.<init>(int, int, int[])"})
  void testNewProvidesInfo_whenOne() {
    // Arrange and Act
    ProvidesInfo actualProvidesInfo = new ProvidesInfo(1, 1, new int[] {1, 2, 1, 2});

    // Assert
    assertNull(actualProvidesInfo.getProcessingInfo());
    assertEquals(0, actualProvidesInfo.getProcessingFlags());
  }
}
