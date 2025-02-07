package proguard.classfile.attribute.annotation.target;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CatchTargetInfoDiffblueTest {
  /**
   * Test {@link CatchTargetInfo#CatchTargetInfo()}.
   *
   * <ul>
   *   <li>Then return TargetType is {@link TargetInfo#TARGET_TYPE_PARAMETER_GENERIC_CLASS}.
   * </ul>
   *
   * <p>Method under test: {@link CatchTargetInfo#CatchTargetInfo()}
   */
  @Test
  @DisplayName(
      "Test new CatchTargetInfo(); then return TargetType is TARGET_TYPE_PARAMETER_GENERIC_CLASS")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.CatchTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.CatchTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.CatchTargetInfo.<init>(byte, int)"
  })
  void testNewCatchTargetInfo_thenReturnTargetTypeIsTarget_type_parameter_generic_class() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new CatchTargetInfo()).getTargetType());
  }

  /**
   * Test {@link CatchTargetInfo#CatchTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link CatchTargetInfo#CatchTargetInfo(byte)}
   */
  @Test
  @DisplayName("Test new CatchTargetInfo(byte); when 'A'; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.CatchTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.CatchTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.CatchTargetInfo.<init>(byte, int)"
  })
  void testNewCatchTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new CatchTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link CatchTargetInfo#CatchTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link CatchTargetInfo#CatchTargetInfo(byte, int)}
   */
  @Test
  @DisplayName("Test new CatchTargetInfo(byte, int); when one; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.CatchTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.CatchTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.CatchTargetInfo.<init>(byte, int)"
  })
  void testNewCatchTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new CatchTargetInfo((byte) 'A', 1)).getTargetType());
  }
}
