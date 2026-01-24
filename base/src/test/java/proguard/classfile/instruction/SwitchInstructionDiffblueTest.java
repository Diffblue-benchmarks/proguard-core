package proguard.classfile.instruction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SwitchInstructionDiffblueTest {
  /**
   * Test {@link SwitchInstruction#copy(SwitchInstruction)}.
   *
   * <ul>
   *   <li>When {@link LookUpSwitchInstruction#LookUpSwitchInstruction()}.
   *   <li>Then return {@link LookUpSwitchInstruction#LookUpSwitchInstruction()}.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#copy(SwitchInstruction)}
   */
  @Test
  @DisplayName(
      "Test copy(SwitchInstruction); when LookUpSwitchInstruction(); then return LookUpSwitchInstruction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SwitchInstruction SwitchInstruction.copy(SwitchInstruction)"})
  void testCopy_whenLookUpSwitchInstruction_thenReturnLookUpSwitchInstruction() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();

    // Act
    SwitchInstruction actualCopyResult =
        lookUpSwitchInstruction.copy((SwitchInstruction) new LookUpSwitchInstruction());

    // Assert
    assertSame(lookUpSwitchInstruction, actualCopyResult);
  }

  /**
   * Test {@link SwitchInstruction#toString(int)} with {@code offset}.
   *
   * <ul>
   *   <li>Then return {@code [2] lstore_2 (4 offsets, default=255) (target=257)}.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#toString(int)}
   */
  @Test
  @DisplayName(
      "Test toString(int) with 'offset'; then return '[2] lstore_2 (4 offsets, default=255) (target=257)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SwitchInstruction.toString(int)"})
  void testToStringWithOffset_thenReturn2Lstore24OffsetsDefault255Target257() {
    // Arrange, Act and Assert
    assertEquals(
        "[2] lstore_2 (4 offsets, default=255) (target=257)",
        new LookUpSwitchInstruction(
                (byte) 'A', 255, new int[] {255, 1, 255, 1}, new int[] {255, 1, 255, 1})
            .toString(2));
  }

  /**
   * Test {@link SwitchInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code lstore_2 (4 offsets, default=255)}.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'lstore_2 (4 offsets, default=255)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SwitchInstruction.toString()"})
  void testToString_thenReturnLstore24OffsetsDefault255() {
    // Arrange, Act and Assert
    assertEquals(
        "lstore_2 (4 offsets, default=255)",
        new LookUpSwitchInstruction(
                (byte) 'A', 255, new int[] {255, 1, 255, 1}, new int[] {255, 1, 255, 1})
            .toString());
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}, and {@link SwitchInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction = new LookUpSwitchInstruction();
    LookUpSwitchInstruction lookUpSwitchInstruction2 = new LookUpSwitchInstruction();

    // Act and Assert
    assertEquals(lookUpSwitchInstruction, lookUpSwitchInstruction2);
    assertEquals(lookUpSwitchInstruction.hashCode(), lookUpSwitchInstruction2.hashCode());
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction =
        new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(lookUpSwitchInstruction, new LookUpSwitchInstruction());
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction =
        new LookUpSwitchInstruction(
            Instruction.OP_NOP, 1, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(lookUpSwitchInstruction, new LookUpSwitchInstruction());
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LookUpSwitchInstruction lookUpSwitchInstruction =
        new LookUpSwitchInstruction(
            Instruction.OP_NOP, 0, new int[] {1, 0, 1, 0}, new int[] {1, 0, 1, 0});

    // Act and Assert
    assertNotEquals(lookUpSwitchInstruction, new LookUpSwitchInstruction());
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookUpSwitchInstruction(), null);
  }

  /**
   * Test {@link SwitchInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SwitchInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SwitchInstruction.equals(Object)",
    "int SwitchInstruction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookUpSwitchInstruction(), "Different type to SwitchInstruction");
  }
}
