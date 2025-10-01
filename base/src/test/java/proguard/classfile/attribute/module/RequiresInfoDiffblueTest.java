package proguard.classfile.attribute.module;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RequiresInfoDiffblueTest {
  /**
   * Test {@link RequiresInfo#RequiresInfo()}.
   *
   * <p>Method under test: {@link RequiresInfo#RequiresInfo()}
   */
  @Test
  @DisplayName("Test new RequiresInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RequiresInfo.<init>()", "void RequiresInfo.<init>(int, int, int)"})
  void testNewRequiresInfo() {
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
  @DisplayName("Test new RequiresInfo(int, int, int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RequiresInfo.<init>()", "void RequiresInfo.<init>(int, int, int)"})
  void testNewRequiresInfo_whenOne() {
    // Arrange and Act
    RequiresInfo actualRequiresInfo = new RequiresInfo(1, 1, 1);

    // Assert
    assertNull(actualRequiresInfo.getProcessingInfo());
    assertEquals(0, actualRequiresInfo.getProcessingFlags());
  }
}
