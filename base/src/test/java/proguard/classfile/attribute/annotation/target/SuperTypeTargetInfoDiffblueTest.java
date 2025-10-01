package proguard.classfile.attribute.annotation.target;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SuperTypeTargetInfoDiffblueTest {
  /**
   * Test {@link SuperTypeTargetInfo#SuperTypeTargetInfo()}.
   *
   * <p>Method under test: {@link SuperTypeTargetInfo#SuperTypeTargetInfo()}
   */
  @Test
  @DisplayName("Test new SuperTypeTargetInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SuperTypeTargetInfo.<init>()",
    "void SuperTypeTargetInfo.<init>(byte)",
    "void SuperTypeTargetInfo.<init>(byte, int)"
  })
  void testNewSuperTypeTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, new SuperTypeTargetInfo().getTargetType());
  }

  /**
   * Test {@link SuperTypeTargetInfo#SuperTypeTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link SuperTypeTargetInfo#SuperTypeTargetInfo(byte)}
   */
  @Test
  @DisplayName("Test new SuperTypeTargetInfo(byte); when 'A'; then return TargetType is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SuperTypeTargetInfo.<init>()",
    "void SuperTypeTargetInfo.<init>(byte)",
    "void SuperTypeTargetInfo.<init>(byte, int)"
  })
  void testNewSuperTypeTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', new SuperTypeTargetInfo((byte) 'A').getTargetType());
  }

  /**
   * Test {@link SuperTypeTargetInfo#SuperTypeTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link SuperTypeTargetInfo#SuperTypeTargetInfo(byte, int)}
   */
  @Test
  @DisplayName("Test new SuperTypeTargetInfo(byte, int); when one; then return TargetType is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SuperTypeTargetInfo.<init>()",
    "void SuperTypeTargetInfo.<init>(byte)",
    "void SuperTypeTargetInfo.<init>(byte, int)"
  })
  void testNewSuperTypeTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', new SuperTypeTargetInfo((byte) 'A', 1).getTargetType());
  }
}
