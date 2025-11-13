package proguard.classfile.attribute.annotation.target;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OffsetTargetInfoDiffblueTest {
  /**
   * Test {@link OffsetTargetInfo#OffsetTargetInfo()}.
   *
   * <p>Method under test: {@link OffsetTargetInfo#OffsetTargetInfo()}
   */
  @Test
  @DisplayName("Test new OffsetTargetInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OffsetTargetInfo.<init>()",
    "void OffsetTargetInfo.<init>(byte)",
    "void OffsetTargetInfo.<init>(byte, int)"
  })
  void testNewOffsetTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, new OffsetTargetInfo().getTargetType());
  }

  /**
   * Test {@link OffsetTargetInfo#OffsetTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link OffsetTargetInfo#OffsetTargetInfo(byte)}
   */
  @Test
  @DisplayName("Test new OffsetTargetInfo(byte); when 'A'; then return TargetType is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OffsetTargetInfo.<init>()",
    "void OffsetTargetInfo.<init>(byte)",
    "void OffsetTargetInfo.<init>(byte, int)"
  })
  void testNewOffsetTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', new OffsetTargetInfo((byte) 'A').getTargetType());
  }

  /**
   * Test {@link OffsetTargetInfo#OffsetTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link OffsetTargetInfo#OffsetTargetInfo(byte, int)}
   */
  @Test
  @DisplayName("Test new OffsetTargetInfo(byte, int); when two; then return TargetType is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OffsetTargetInfo.<init>()",
    "void OffsetTargetInfo.<init>(byte)",
    "void OffsetTargetInfo.<init>(byte, int)"
  })
  void testNewOffsetTargetInfo_whenTwo_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', new OffsetTargetInfo((byte) 'A', 2).getTargetType());
  }
}
