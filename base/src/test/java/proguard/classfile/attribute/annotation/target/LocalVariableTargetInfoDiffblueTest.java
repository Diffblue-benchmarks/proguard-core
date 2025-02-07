package proguard.classfile.attribute.annotation.target;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LocalVariableTargetInfoDiffblueTest {
  /**
   * Test {@link LocalVariableTargetInfo#LocalVariableTargetInfo()}.
   *
   * <p>Method under test: {@link LocalVariableTargetInfo#LocalVariableTargetInfo()}
   */
  @Test
  @DisplayName("Test new LocalVariableTargetInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo.<init>(byte, int, proguard.classfile.attribute.annotation.target.LocalVariableTargetElement[])"
  })
  void testNewLocalVariableTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS,
        (new LocalVariableTargetInfo()).getTargetType());
  }

  /**
   * Test {@link LocalVariableTargetInfo#LocalVariableTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTargetInfo#LocalVariableTargetInfo(byte)}
   */
  @Test
  @DisplayName("Test new LocalVariableTargetInfo(byte); when 'A'; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo.<init>(byte, int, proguard.classfile.attribute.annotation.target.LocalVariableTargetElement[])"
  })
  void testNewLocalVariableTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new LocalVariableTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link LocalVariableTargetInfo#LocalVariableTargetInfo(byte, int,
   * LocalVariableTargetElement[])}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTargetInfo#LocalVariableTargetInfo(byte, int,
   * LocalVariableTargetElement[])}
   */
  @Test
  @DisplayName(
      "Test new LocalVariableTargetInfo(byte, int, LocalVariableTargetElement[]); when three; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo.<init>(byte, int, proguard.classfile.attribute.annotation.target.LocalVariableTargetElement[])"
  })
  void testNewLocalVariableTargetInfo_whenThree_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals(
        'A',
        (new LocalVariableTargetInfo(
                (byte) 'A',
                3,
                new LocalVariableTargetElement[] {new LocalVariableTargetElement(1, 3, 1)}))
            .getTargetType());
  }
}
