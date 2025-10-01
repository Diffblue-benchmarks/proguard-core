package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BootstrapMethodInfoDiffblueTest {
  /**
   * Test {@link BootstrapMethodInfo#BootstrapMethodInfo()}.
   *
   * <p>Method under test: {@link BootstrapMethodInfo#BootstrapMethodInfo()}
   */
  @Test
  @DisplayName("Test new BootstrapMethodInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodInfo.<init>()",
    "void BootstrapMethodInfo.<init>(int, int, int[])"
  })
  void testNewBootstrapMethodInfo() {
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
  @DisplayName("Test new BootstrapMethodInfo(int, int, int[]); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodInfo.<init>()",
    "void BootstrapMethodInfo.<init>(int, int, int[])"
  })
  void testNewBootstrapMethodInfo_whenOne() {
    // Arrange and Act
    BootstrapMethodInfo actualBootstrapMethodInfo =
        new BootstrapMethodInfo(1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualBootstrapMethodInfo.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodInfo.getProcessingFlags());
  }
}
