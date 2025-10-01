package proguard.analysis.cpa.jvm.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InstructionClassifierDiffblueTest {
  /**
   * Test {@link InstructionClassifier#isReturn(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionClassifier#isReturn(byte)}
   */
  @Test
  @DisplayName("Test isReturn(byte); when 'A'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionClassifier.isReturn(byte)"})
  void testIsReturn_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isReturn((byte) 'A'));
  }

  /**
   * Test {@link InstructionClassifier#isReturn(byte)}.
   *
   * <ul>
   *   <li>When minus seventy-nine.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionClassifier#isReturn(byte)}
   */
  @Test
  @DisplayName("Test isReturn(byte); when minus seventy-nine; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionClassifier.isReturn(byte)"})
  void testIsReturn_whenMinusSeventyNine_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(InstructionClassifier.isReturn((byte) -79));
  }

  /**
   * Test {@link InstructionClassifier#isTypedReturn(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionClassifier#isTypedReturn(byte)}
   */
  @Test
  @DisplayName("Test isTypedReturn(byte); when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionClassifier.isTypedReturn(byte)"})
  void testIsTypedReturn_whenA() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isTypedReturn((byte) 'A'));
  }

  /**
   * Test {@link InstructionClassifier#isTypedReturn(byte)}.
   *
   * <ul>
   *   <li>When minus seventy-nine.
   * </ul>
   *
   * <p>Method under test: {@link InstructionClassifier#isTypedReturn(byte)}
   */
  @Test
  @DisplayName("Test isTypedReturn(byte); when minus seventy-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionClassifier.isTypedReturn(byte)"})
  void testIsTypedReturn_whenMinusSeventyNine() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isTypedReturn((byte) -79));
  }

  /**
   * Test {@link InstructionClassifier#isInvoke(byte)}.
   *
   * <p>Method under test: {@link InstructionClassifier#isInvoke(byte)}
   */
  @Test
  @DisplayName("Test isInvoke(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionClassifier.isInvoke(byte)"})
  void testIsInvoke() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isInvoke((byte) 'A'));
  }

  /**
   * Test {@link InstructionClassifier#isLongShift(byte)}.
   *
   * <p>Method under test: {@link InstructionClassifier#isLongShift(byte)}
   */
  @Test
  @DisplayName("Test isLongShift(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionClassifier.isLongShift(byte)"})
  void testIsLongShift() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isLongShift((byte) 'A'));
  }
}
