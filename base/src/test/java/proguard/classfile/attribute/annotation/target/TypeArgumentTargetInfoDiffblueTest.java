package proguard.classfile.attribute.annotation.target;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypeArgumentTargetInfoDiffblueTest {
  /**
   * Test {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo()}.
   *
   * <p>Method under test: {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo()}
   */
  @Test
  @DisplayName("Test new TypeArgumentTargetInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeArgumentTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.TypeArgumentTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.TypeArgumentTargetInfo.<init>(byte, int, int)"
  })
  void testNewTypeArgumentTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS,
        (new TypeArgumentTargetInfo()).getTargetType());
  }

  /**
   * Test {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo(byte)}
   */
  @Test
  @DisplayName("Test new TypeArgumentTargetInfo(byte); when 'A'; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeArgumentTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.TypeArgumentTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.TypeArgumentTargetInfo.<init>(byte, int, int)"
  })
  void testNewTypeArgumentTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeArgumentTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo(byte, int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeArgumentTargetInfo#TypeArgumentTargetInfo(byte, int, int)}
   */
  @Test
  @DisplayName(
      "Test new TypeArgumentTargetInfo(byte, int, int); when two; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeArgumentTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.TypeArgumentTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.TypeArgumentTargetInfo.<init>(byte, int, int)"
  })
  void testNewTypeArgumentTargetInfo_whenTwo_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeArgumentTargetInfo((byte) 'A', 2, 1)).getTargetType());
  }
}
