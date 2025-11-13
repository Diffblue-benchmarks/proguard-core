package proguard.classfile.instruction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VariableInstructionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return not Wide.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableInstruction#VariableInstruction()}
   *   <li>{@link VariableInstruction#isWide()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return not Wide")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VariableInstruction.<init>()",
    "void VariableInstruction.<init>(boolean)",
    "boolean VariableInstruction.isWide()"
  })
  void testGettersAndSetters_thenReturnNotWide() {
    // Arrange, Act and Assert
    assertFalse(new VariableInstruction().isWide());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Wide.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableInstruction#VariableInstruction(boolean)}
   *   <li>{@link VariableInstruction#isWide()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'; then return Wide")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VariableInstruction.<init>()",
    "void VariableInstruction.<init>(boolean)",
    "boolean VariableInstruction.isWide()"
  })
  void testGettersAndSetters_whenTrue_thenReturnWide() {
    // Arrange, Act and Assert
    assertTrue(new VariableInstruction(true).isWide());
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int, int)}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction#constant} is two hundred fifty-five.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  @DisplayName(
      "Test new VariableInstruction(byte, int, int); then return constant is two hundred fifty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int, int)"})
  void testNewVariableInstruction_thenReturnConstantIsTwoHundredFiftyFive() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction =
        new VariableInstruction(Instruction.OP_IINC, 65, 255);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertEquals(255, actualVariableInstruction.constant);
    assertEquals(65, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isWide());
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int)}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction#variableIndex} is minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  @DisplayName(
      "Test new VariableInstruction(byte, int); then return variableIndex is minus one hundred twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int)"})
  void testNewVariableInstruction_thenReturnVariableIndexIsMinusOneHundredTwentyFour() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', -124);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(-124, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isWide());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int, int)}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction#variableIndex} is minus one hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  @DisplayName(
      "Test new VariableInstruction(byte, int, int); then return variableIndex is minus one hundred twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int, int)"})
  void testNewVariableInstruction_thenReturnVariableIndexIsMinusOneHundredTwentyFour2() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', -124, 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(-124, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isWide());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  @DisplayName("Test new VariableInstruction(byte); when 'A'; then return Name is 'lstore_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte)"})
  void testNewVariableInstruction_whenA_thenReturnNameIsLstore2() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A');

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(2, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  @DisplayName(
      "Test new VariableInstruction(byte, int, int); when 'A'; then return Name is 'lstore_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int, int)"})
  void testNewVariableInstruction_whenA_thenReturnNameIsLstore22() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 1, 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int, int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return {@link VariableInstruction#constant} is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  @DisplayName(
      "Test new VariableInstruction(byte, int, int); when MIN_VALUE; then return constant is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int, int)"})
  void testNewVariableInstruction_whenMin_value_thenReturnConstantIsMin_value() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction =
        new VariableInstruction(Instruction.OP_IINC, 1, Integer.MIN_VALUE);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isLoad());
    assertTrue(actualVariableInstruction.isWide());
    assertEquals(Integer.MIN_VALUE, actualVariableInstruction.constant);
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link VariableInstruction#variableIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  @DisplayName(
      "Test new VariableInstruction(byte, int); when one; then return variableIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int)"})
  void testNewVariableInstruction_whenOne_thenReturnVariableIndexIsOne() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_IINC}.
   *   <li>Then return Name is {@code iinc}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  @DisplayName("Test new VariableInstruction(byte); when OP_IINC; then return Name is 'iinc'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte)"})
  void testNewVariableInstruction_whenOp_iinc_thenReturnNameIsIinc() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_IINC);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.variableIndex);
    assertTrue(actualVariableInstruction.isStore());
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_IINC}.
   *   <li>Then return Name is {@code iinc}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  @DisplayName("Test new VariableInstruction(byte, int); when OP_IINC; then return Name is 'iinc'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int)"})
  void testNewVariableInstruction_whenOp_iinc_thenReturnNameIsIinc2() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_IINC, 1);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertFalse(actualVariableInstruction.isCategory2());
    assertTrue(actualVariableInstruction.isLoad());
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int, int)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_IINC}.
   *   <li>Then return Name is {@code iinc}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  @DisplayName(
      "Test new VariableInstruction(byte, int, int); when OP_IINC; then return Name is 'iinc'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int, int)"})
  void testNewVariableInstruction_whenOp_iinc_thenReturnNameIsIinc3() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction =
        new VariableInstruction(Instruction.OP_IINC, 1, 1);

    // Assert
    assertEquals("iinc", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isLoad());
    assertEquals(Instruction.OP_IINC, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_ILOAD_1}.
   *   <li>Then return Name is {@code iload_1}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  @DisplayName("Test new VariableInstruction(byte); when OP_ILOAD_1; then return Name is 'iload_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte)"})
  void testNewVariableInstruction_whenOp_iload_1_thenReturnNameIsIload1() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_ILOAD_1);

    // Assert
    assertEquals("iload_1", actualVariableInstruction.getName());
    assertEquals(1, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertFalse(actualVariableInstruction.isStore());
    assertEquals(Instruction.OP_ILOAD_1, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_ILOAD_3}.
   *   <li>Then return Name is {@code iload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  @DisplayName("Test new VariableInstruction(byte); when OP_ILOAD_3; then return Name is 'iload_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte)"})
  void testNewVariableInstruction_whenOp_iload_3_thenReturnNameIsIload3() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_ILOAD_3);

    // Assert
    assertEquals("iload_3", actualVariableInstruction.getName());
    assertEquals(3, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isCategory2());
    assertFalse(actualVariableInstruction.isStore());
    assertEquals(Instruction.OP_ILOAD_3, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_LLOAD_0}.
   *   <li>Then return Name is {@code lload_0}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte)}
   */
  @Test
  @DisplayName("Test new VariableInstruction(byte); when OP_LLOAD_0; then return Name is 'lload_0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte)"})
  void testNewVariableInstruction_whenOp_lload_0_thenReturnNameIsLload0() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction(Instruction.OP_LLOAD_0);

    // Assert
    assertEquals("lload_0", actualVariableInstruction.getName());
    assertEquals(0, actualVariableInstruction.variableIndex);
    assertTrue(actualVariableInstruction.isCategory2());
    assertEquals(Instruction.OP_LLOAD_0, actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When sixty-five.
   *   <li>Then return {@link VariableInstruction#variableIndex} is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int)}
   */
  @Test
  @DisplayName(
      "Test new VariableInstruction(byte, int); when sixty-five; then return variableIndex is sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int)"})
  void testNewVariableInstruction_whenSixtyFive_thenReturnVariableIndexIsSixtyFive() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 65);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(65, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#VariableInstruction(byte, int, int)}.
   *
   * <ul>
   *   <li>When sixty-five.
   *   <li>Then return {@link VariableInstruction#variableIndex} is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#VariableInstruction(byte, int, int)}
   */
  @Test
  @DisplayName(
      "Test new VariableInstruction(byte, int, int); when sixty-five; then return variableIndex is sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.<init>(byte, int, int)"})
  void testNewVariableInstruction_whenSixtyFive_thenReturnVariableIndexIsSixtyFive2() {
    // Arrange and Act
    VariableInstruction actualVariableInstruction = new VariableInstruction((byte) 'A', 65, 1);

    // Assert
    assertEquals("lstore_2", actualVariableInstruction.getName());
    assertEquals(65, actualVariableInstruction.variableIndex);
    assertFalse(actualVariableInstruction.isLoad());
    assertFalse(actualVariableInstruction.isWide());
    assertTrue(actualVariableInstruction.isCategory2());
    assertEquals('A', actualVariableInstruction.opcode);
  }

  /**
   * Test {@link VariableInstruction#copy(VariableInstruction)}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code
   *       A}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#copy(VariableInstruction)}
   */
  @Test
  @DisplayName(
      "Test copy(VariableInstruction); then return VariableInstruction(byte) with opcode is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"VariableInstruction VariableInstruction.copy(VariableInstruction)"})
  void testCopy_thenReturnVariableInstructionWithOpcodeIsA() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act
    VariableInstruction actualCopyResult =
        variableInstruction.copy(new VariableInstruction((byte) 'A'));

    // Assert
    assertSame(variableInstruction, actualCopyResult);
  }

  /**
   * Test {@link VariableInstruction#isStore()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code 5}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#isStore()}
   */
  @Test
  @DisplayName(
      "Test isStore(); given VariableInstruction(byte) with opcode is '5'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableInstruction.isStore()"})
  void testIsStore_givenVariableInstructionWithOpcodeIs5_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new VariableInstruction((byte) '5').isStore());
  }

  /**
   * Test {@link VariableInstruction#isStore()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#isStore()}
   */
  @Test
  @DisplayName(
      "Test isStore(); given VariableInstruction(byte) with opcode is 'A'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableInstruction.isStore()"})
  void testIsStore_givenVariableInstructionWithOpcodeIsA_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new VariableInstruction((byte) 'A').isStore());
  }

  /**
   * Test {@link VariableInstruction#isStore()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_IINC}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#isStore()}
   */
  @Test
  @DisplayName(
      "Test isStore(); given VariableInstruction(byte) with opcode is OP_IINC; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableInstruction.isStore()"})
  void testIsStore_givenVariableInstructionWithOpcodeIsOp_iinc_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new VariableInstruction(Instruction.OP_IINC).isStore());
  }

  /**
   * Test {@link VariableInstruction#isLoad()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code 5}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#isLoad()}
   */
  @Test
  @DisplayName(
      "Test isLoad(); given VariableInstruction(byte) with opcode is '5'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableInstruction.isLoad()"})
  void testIsLoad_givenVariableInstructionWithOpcodeIs5_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new VariableInstruction((byte) '5').isLoad());
  }

  /**
   * Test {@link VariableInstruction#isLoad()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#isLoad()}
   */
  @Test
  @DisplayName(
      "Test isLoad(); given VariableInstruction(byte) with opcode is 'A'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VariableInstruction.isLoad()"})
  void testIsLoad_givenVariableInstructionWithOpcodeIsA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new VariableInstruction((byte) 'A').isLoad());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code 7}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName(
      "Test canonicalOpcode(); given VariableInstruction(byte) with opcode is 'A'; then return '7'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_givenVariableInstructionWithOpcodeIsA_thenReturn7() {
    // Arrange, Act and Assert
    assertEquals('7', new VariableInstruction((byte) 'A').canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code C}.
   *   <li>Then return {@code 8}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName(
      "Test canonicalOpcode(); given VariableInstruction(byte) with opcode is 'C'; then return '8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_givenVariableInstructionWithOpcodeIsC_thenReturn8() {
    // Arrange, Act and Assert
    assertEquals('8', new VariableInstruction((byte) 'C').canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code .}.
   *   <li>Then return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName(
      "Test canonicalOpcode(); given VariableInstruction(byte) with opcode is '.'; then return '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_givenVariableInstructionWithOpcodeIsDot_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals('.', new VariableInstruction((byte) '.').canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code G}.
   *   <li>Then return {@code 9}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName(
      "Test canonicalOpcode(); given VariableInstruction(byte) with opcode is 'G'; then return '9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_givenVariableInstructionWithOpcodeIsG_thenReturn9() {
    // Arrange, Act and Assert
    assertEquals('9', new VariableInstruction((byte) 'G').canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code K}.
   *   <li>Then return {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName(
      "Test canonicalOpcode(); given VariableInstruction(byte) with opcode is 'K'; then return ':'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_givenVariableInstructionWithOpcodeIsK_thenReturnColon() {
    // Arrange, Act and Assert
    assertEquals(':', new VariableInstruction((byte) 'K').canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code ;}.
   *   <li>Then return {@code 6}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName(
      "Test canonicalOpcode(); given VariableInstruction(byte) with opcode is ';'; then return '6'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_givenVariableInstructionWithOpcodeIsSemicolon_thenReturn6() {
    // Arrange, Act and Assert
    assertEquals('6', new VariableInstruction((byte) ';').canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_ALOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName("Test canonicalOpcode(); then return OP_ALOAD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnOp_aload() {
    // Arrange, Act and Assert
    assertEquals(Instruction.OP_ALOAD, new VariableInstruction((byte) '*').canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_DLOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName("Test canonicalOpcode(); then return OP_DLOAD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnOp_dload() {
    // Arrange, Act and Assert
    assertEquals(Instruction.OP_DLOAD, new VariableInstruction((byte) '&').canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_FLOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName("Test canonicalOpcode(); then return OP_FLOAD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnOp_fload() {
    // Arrange, Act and Assert
    assertEquals(Instruction.OP_FLOAD, new VariableInstruction((byte) '"').canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_ILOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName("Test canonicalOpcode(); then return OP_ILOAD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnOp_iload() {
    // Arrange, Act and Assert
    assertEquals(
        Instruction.OP_ILOAD, new VariableInstruction(Instruction.OP_ILOAD_0).canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_LLOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName("Test canonicalOpcode(); then return OP_LLOAD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte VariableInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnOp_lload() {
    // Arrange, Act and Assert
    assertEquals(
        Instruction.OP_LLOAD, new VariableInstruction(Instruction.OP_LLOAD_0).canonicalOpcode());
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code
   *       A}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then return VariableInstruction(byte) with opcode is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenReturnVariableInstructionWithOpcodeIsA() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_IINC}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then return VariableInstruction(byte) with opcode is OP_IINC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenReturnVariableInstructionWithOpcodeIsOp_iinc() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_IINC);

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ILOAD}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then return VariableInstruction(byte) with opcode is OP_ILOAD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenReturnVariableInstructionWithOpcodeIsOp_iload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ILOAD);
    variableInstruction.variableIndex = 26;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code 6} Name
   *       is {@code istore_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is '6' Name is 'istore_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIs6NameIsIstore3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) '6');
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("istore_3", variableInstruction.getName());
    assertEquals('>', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code 8} Name
   *       is {@code fstore_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is '8' Name is 'fstore_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIs8NameIsFstore3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) '8');
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("fstore_3", variableInstruction.getName());
    assertEquals('F', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code 9} Name
   *       is {@code dstore_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is '9' Name is 'dstore_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIs9NameIsDstore3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) '9');
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("dstore_3", variableInstruction.getName());
    assertEquals('J', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code &} Name
   *       is {@code dload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then VariableInstruction(byte) with opcode is '&' Name is 'dload_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsAmpersandNameIsDload3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) '&');
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("dload_3", variableInstruction.getName());
    assertEquals(')', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code *} Name
   *       is {@code aload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then VariableInstruction(byte) with opcode is '*' Name is 'aload_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsAsteriskNameIsAload3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) '*');
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("aload_3", variableInstruction.getName());
    assertEquals('-', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code C} Name
   *       is {@code fstore_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is 'C' Name is 'fstore_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsCNameIsFstore3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'C');
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("fstore_3", variableInstruction.getName());
    assertEquals('F', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code :} Name
   *       is {@code astore_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is ':' Name is 'astore_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsColonNameIsAstore3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) ':');
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("astore_3", variableInstruction.getName());
    assertEquals('N', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code .} Name
   *       is {@code iaload}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then VariableInstruction(byte) with opcode is '.' Name is 'iaload'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsDotNameIsIaload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) '.');
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("iaload", variableInstruction.getName());
    assertEquals('.', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ALOAD} Name is {@code aload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is OP_ALOAD Name is 'aload_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsOp_aloadNameIsAload3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ALOAD);
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("aload_3", variableInstruction.getName());
    assertEquals('-', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_DLOAD} Name is {@code dload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is OP_DLOAD Name is 'dload_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsOp_dloadNameIsDload3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_DLOAD);
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("dload_3", variableInstruction.getName());
    assertEquals(')', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_FLOAD} Name is {@code fload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is OP_FLOAD Name is 'fload_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsOp_floadNameIsFload3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_FLOAD);
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("fload_3", variableInstruction.getName());
    assertEquals('%', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ILOAD} Name is {@code aload}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is OP_ILOAD Name is 'aload'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsOp_iloadNameIsAload() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ILOAD);
    variableInstruction.variableIndex = -1;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("aload", variableInstruction.getName());
    assertEquals("aload", actualShrinkResult.getName());
    assertEquals(-1, ((VariableInstruction) actualShrinkResult).variableIndex);
    assertTrue(actualShrinkResult.isWide());
    assertTrue(variableInstruction.isWide());
    assertEquals(Instruction.OP_ALOAD, variableInstruction.opcode);
    assertEquals(Instruction.OP_ALOAD, ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ILOAD} Name is {@code iload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is OP_ILOAD Name is 'iload_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsOp_iloadNameIsIload3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ILOAD);
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof VariableInstruction);
    assertEquals("iload_3", variableInstruction.getName());
    assertEquals("iload_3", actualShrinkResult.getName());
    assertEquals(Instruction.OP_ILOAD_3, variableInstruction.opcode);
    assertEquals(Instruction.OP_ILOAD_3, ((VariableInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ILOAD_0} Name is {@code iload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is OP_ILOAD_0 Name is 'iload_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsOp_iload_0NameIsIload3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ILOAD_0);
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("iload_3", variableInstruction.getName());
    assertEquals(Instruction.OP_ILOAD_3, variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_LLOAD} Name is {@code lload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is OP_LLOAD Name is 'lload_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsOp_lloadNameIsLload3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_LLOAD);
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("lload_3", variableInstruction.getName());
    assertEquals('!', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_LLOAD_0} Name is {@code lload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is OP_LLOAD_0 Name is 'lload_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsOp_lload_0NameIsLload3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_LLOAD_0);
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("lload_3", variableInstruction.getName());
    assertEquals('!', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code "} Name
   *       is {@code fload_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is '\"' Name is 'fload_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsQuotationMarkNameIsFload3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) '"');
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("fload_3", variableInstruction.getName());
    assertEquals('%', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code ;} Name
   *       is {@code istore_3}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then VariableInstruction(byte) with opcode is ';' Name is 'istore_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction VariableInstruction.shrink()"})
  void testShrink_thenVariableInstructionWithOpcodeIsSemicolonNameIsIstore3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) ';');
    variableInstruction.variableIndex = 3;

    // Act
    Instruction actualShrinkResult = variableInstruction.shrink();

    // Assert
    assertEquals("istore_3", variableInstruction.getName());
    assertEquals('>', variableInstruction.opcode);
    assertSame(variableInstruction, actualShrinkResult);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}
   *       {@link VariableInstruction#constant} is zero.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then VariableInstruction(byte) with opcode is 'A' constant is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenVariableInstructionWithOpcodeIsAConstantIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act
    variableInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert that nothing has changed
    assertEquals(0, variableInstruction.constant);
    assertEquals(2, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code :}
   *       {@link VariableInstruction#constant} is zero.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then VariableInstruction(byte) with opcode is ':' constant is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenVariableInstructionWithOpcodeIsColonConstantIsZero() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) ':');
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(65, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code O}
   *       {@link VariableInstruction#constant} is zero.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then VariableInstruction(byte) with opcode is 'O' constant is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenVariableInstructionWithOpcodeIsOConstantIsZero() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'O');
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(65, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ALOAD} {@link VariableInstruction#constant} is zero.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then VariableInstruction(byte) with opcode is OP_ALOAD constant is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenVariableInstructionWithOpcodeIsOp_aloadConstantIsZero() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ALOAD);
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(65, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_IINC} {@link VariableInstruction#variableIndex} is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then VariableInstruction(byte) with opcode is OP_IINC variableIndex is sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenVariableInstructionWithOpcodeIsOp_iincVariableIndexIsSixtyFive() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_IINC);
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(65, variableInstruction.variableIndex);
    assertEquals(88, variableInstruction.constant);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ILOAD_0} {@link VariableInstruction#constant} is zero.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then VariableInstruction(byte) with opcode is OP_ILOAD_0 constant is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenVariableInstructionWithOpcodeIsOp_iload_0ConstantIsZero() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ILOAD_0);
    variableInstruction.wide = false;

    // Act
    variableInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert that nothing has changed
    assertEquals(0, variableInstruction.constant);
    assertEquals(0, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(boolean)} with wide is {@code true}
   *       {@link VariableInstruction#constant} is zero.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then VariableInstruction(boolean) with wide is 'true' constant is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenVariableInstructionWithWideIsTrueConstantIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(true);

    // Act
    variableInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals(0, variableInstruction.constant);
    assertEquals(16728, variableInstruction.variableIndex);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given VariableInstruction(byte) with opcode is 'A'; then 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenVariableInstructionWithOpcodeIsA_thenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    new VariableInstruction((byte) 'A').writeInfo(code, 2);

    // Assert that nothing has changed
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), code);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code O}
   *       {@link VariableInstruction#wide} is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given VariableInstruction(byte) with opcode is 'O' wide is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenVariableInstructionWithOpcodeIsOWideIsFalse() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'O');
    variableInstruction.wide = false;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', Instruction.OP_NOP, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ALOAD} {@link VariableInstruction#wide} is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given VariableInstruction(byte) with opcode is OP_ALOAD wide is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenVariableInstructionWithOpcodeIsOp_aloadWideIsFalse() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ALOAD);
    variableInstruction.wide = false;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', Instruction.OP_NOP, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_IINC} {@link VariableInstruction#wide} is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given VariableInstruction(byte) with opcode is OP_IINC wide is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenVariableInstructionWithOpcodeIsOp_iincWideIsFalse() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_IINC);
    variableInstruction.wide = false;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.OP_NOP, Instruction.OP_NOP, 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_IINC} {@link VariableInstruction#wide} is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given VariableInstruction(byte) with opcode is OP_IINC wide is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenVariableInstructionWithOpcodeIsOp_iincWideIsTrue() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_IINC);
    variableInstruction.wide = true;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {
          'A',
          'X',
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          Instruction.OP_NOP,
          'A',
          'X'
        },
        code);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then array of {@code byte} with {@code A} and {@code X} is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); then array of byte with 'A' and 'X' is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_thenArrayOfByteWithAAndXIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ILOAD_0);
    variableInstruction.wide = false;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    variableInstruction.writeInfo(code, 2);

    // Assert that nothing has changed
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), code);
  }

  /**
   * Test {@link VariableInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with {@code A} and
   *       {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with 'A' and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VariableInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithAAndX()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    new VariableInstruction(true).writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.OP_NOP, Instruction.OP_NOP, 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given VariableInstruction(byte) with opcode is 'A'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  void testLength_givenVariableInstructionWithOpcodeIsA_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new VariableInstruction((byte) 'A').length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code O}
   *       {@link VariableInstruction#wide} is {@code false}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given VariableInstruction(byte) with opcode is 'O' wide is 'false'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  void testLength_givenVariableInstructionWithOpcodeIsOWideIsFalse_thenReturnTwo() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'O');
    variableInstruction.wide = false;

    // Act and Assert
    assertEquals(2, variableInstruction.length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ALOAD} {@link VariableInstruction#wide} is {@code false}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given VariableInstruction(byte) with opcode is OP_ALOAD wide is 'false'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  void testLength_givenVariableInstructionWithOpcodeIsOp_aloadWideIsFalse_thenReturnTwo() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ALOAD);
    variableInstruction.wide = false;

    // Act and Assert
    assertEquals(2, variableInstruction.length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_IINC} {@link VariableInstruction#wide} is {@code true}.
   *   <li>Then return six.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given VariableInstruction(byte) with opcode is OP_IINC wide is 'true'; then return six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  void testLength_givenVariableInstructionWithOpcodeIsOp_iincWideIsTrue_thenReturnSix() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_IINC);
    variableInstruction.wide = true;

    // Act and Assert
    assertEquals(6, variableInstruction.length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ILOAD_0} {@link VariableInstruction#wide} is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given VariableInstruction(byte) with opcode is OP_ILOAD_0 wide is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  void testLength_givenVariableInstructionWithOpcodeIsOp_iload_0WideIsFalse() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ILOAD_0);
    variableInstruction.wide = false;

    // Act and Assert
    assertEquals(1, variableInstruction.length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(boolean)} with wide is {@code true}.
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given VariableInstruction(boolean) with wide is 'true'; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  void testLength_givenVariableInstructionWithWideIsTrue_thenReturnFour() {
    // Arrange, Act and Assert
    assertEquals(4, new VariableInstruction(true).length(2));
  }

  /**
   * Test {@link VariableInstruction#length(int)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#length(int)}
   */
  @Test
  @DisplayName("Test length(int); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int VariableInstruction.length(int)"})
  void testLength_thenReturnThree() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_IINC);
    variableInstruction.wide = false;

    // Act and Assert
    assertEquals(3, variableInstruction.length(2));
  }

  /**
   * Test {@link VariableInstruction#toString()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code lstore_2 v2}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given VariableInstruction(byte) with opcode is 'A'; then return 'lstore_2 v2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String VariableInstruction.toString()"})
  void testToString_givenVariableInstructionWithOpcodeIsA_thenReturnLstore2V2() {
    // Arrange, Act and Assert
    assertEquals("lstore_2 v2", new VariableInstruction((byte) 'A').toString());
  }

  /**
   * Test {@link VariableInstruction#toString()}.
   *
   * <ul>
   *   <li>Given {@link VariableInstruction#VariableInstruction(boolean)} with wide is {@code true}.
   *   <li>Then return {@code nop_w v0}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given VariableInstruction(boolean) with wide is 'true'; then return 'nop_w v0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String VariableInstruction.toString()"})
  void testToString_givenVariableInstructionWithWideIsTrue_thenReturnNopWV0() {
    // Arrange, Act and Assert
    assertEquals("nop_w v0", new VariableInstruction(true).toString());
  }

  /**
   * Test {@link VariableInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iinc v0, 0}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'iinc v0, 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String VariableInstruction.toString()"})
  void testToString_thenReturnIincV00() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_IINC);
    variableInstruction.wide = false;

    // Act and Assert
    assertEquals("iinc v0, 0", variableInstruction.toString());
  }

  /**
   * Test {@link VariableInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iinc_w v0, 0}.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'iinc_w v0, 0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String VariableInstruction.toString()"})
  void testToString_thenReturnIincWV00() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_IINC);
    variableInstruction.wide = true;

    // Act and Assert
    assertEquals("iinc_w v0, 0", variableInstruction.toString());
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}, and {@link VariableInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableInstruction#equals(Object)}
   *   <li>{@link VariableInstruction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');
    VariableInstruction variableInstruction2 = new VariableInstruction((byte) 'A');

    // Act and Assert
    assertEquals(variableInstruction, variableInstruction2);
    assertEquals(variableInstruction.hashCode(), variableInstruction2.hashCode());
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}, and {@link VariableInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableInstruction#equals(Object)}
   *   <li>{@link VariableInstruction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A');

    // Act and Assert
    assertEquals(variableInstruction, variableInstruction);
    int expectedHashCodeResult = variableInstruction.hashCode();
    assertEquals(expectedHashCodeResult, variableInstruction.hashCode());
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction(Instruction.OP_ICONST_M1);

    // Act and Assert
    assertNotEquals(variableInstruction, new VariableInstruction((byte) 'A'));
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A', 1);

    // Act and Assert
    assertNotEquals(variableInstruction, new VariableInstruction((byte) 'A'));
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VariableInstruction variableInstruction = new VariableInstruction((byte) 'A', -124);

    // Act and Assert
    assertNotEquals(variableInstruction, new VariableInstruction((byte) 'A'));
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VariableInstruction((byte) 'A'), null);
  }

  /**
   * Test {@link VariableInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VariableInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VariableInstruction.equals(Object)",
    "int VariableInstruction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VariableInstruction((byte) 'A'), "Different type to VariableInstruction");
  }
}
