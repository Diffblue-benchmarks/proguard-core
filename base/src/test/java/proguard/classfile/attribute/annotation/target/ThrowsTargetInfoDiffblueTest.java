package proguard.classfile.attribute.annotation.target;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThrowsTargetInfoDiffblueTest {
  /**
   * Test {@link ThrowsTargetInfo#ThrowsTargetInfo()}.
   *
   * <p>Method under test: {@link ThrowsTargetInfo#ThrowsTargetInfo()}
   */
  @Test
  @DisplayName("Test new ThrowsTargetInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.ThrowsTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.ThrowsTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.ThrowsTargetInfo.<init>(byte, int)"
  })
  void testNewThrowsTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS, (new ThrowsTargetInfo()).getTargetType());
  }

  /**
   * Test {@link ThrowsTargetInfo#ThrowsTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ThrowsTargetInfo#ThrowsTargetInfo(byte)}
   */
  @Test
  @DisplayName("Test new ThrowsTargetInfo(byte); when 'A'; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.ThrowsTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.ThrowsTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.ThrowsTargetInfo.<init>(byte, int)"
  })
  void testNewThrowsTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new ThrowsTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link ThrowsTargetInfo#ThrowsTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ThrowsTargetInfo#ThrowsTargetInfo(byte, int)}
   */
  @Test
  @DisplayName("Test new ThrowsTargetInfo(byte, int); when one; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.ThrowsTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.ThrowsTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.ThrowsTargetInfo.<init>(byte, int)"
  })
  void testNewThrowsTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new ThrowsTargetInfo((byte) 'A', 1)).getTargetType());
  }
}
