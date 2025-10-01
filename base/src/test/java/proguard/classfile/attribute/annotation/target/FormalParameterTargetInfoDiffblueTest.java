package proguard.classfile.attribute.annotation.target;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FormalParameterTargetInfoDiffblueTest {
  /**
   * Test {@link FormalParameterTargetInfo#FormalParameterTargetInfo()}.
   *
   * <p>Method under test: {@link FormalParameterTargetInfo#FormalParameterTargetInfo()}
   */
  @Test
  @DisplayName("Test new FormalParameterTargetInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormalParameterTargetInfo.<init>()",
    "void FormalParameterTargetInfo.<init>(byte)",
    "void FormalParameterTargetInfo.<init>(byte, int)"
  })
  void testNewFormalParameterTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS,
        new FormalParameterTargetInfo().getTargetType());
  }

  /**
   * Test {@link FormalParameterTargetInfo#FormalParameterTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link FormalParameterTargetInfo#FormalParameterTargetInfo(byte)}
   */
  @Test
  @DisplayName("Test new FormalParameterTargetInfo(byte); when 'A'; then return TargetType is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormalParameterTargetInfo.<init>()",
    "void FormalParameterTargetInfo.<init>(byte)",
    "void FormalParameterTargetInfo.<init>(byte, int)"
  })
  void testNewFormalParameterTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', new FormalParameterTargetInfo((byte) 'A').getTargetType());
  }

  /**
   * Test {@link FormalParameterTargetInfo#FormalParameterTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link FormalParameterTargetInfo#FormalParameterTargetInfo(byte, int)}
   */
  @Test
  @DisplayName(
      "Test new FormalParameterTargetInfo(byte, int); when one; then return TargetType is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormalParameterTargetInfo.<init>()",
    "void FormalParameterTargetInfo.<init>(byte)",
    "void FormalParameterTargetInfo.<init>(byte, int)"
  })
  void testNewFormalParameterTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', new FormalParameterTargetInfo((byte) 'A', 1).getTargetType());
  }
}
