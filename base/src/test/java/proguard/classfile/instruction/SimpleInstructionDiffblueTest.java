package proguard.classfile.instruction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class SimpleInstructionDiffblueTest {
  /**
   * Test {@link SimpleInstruction#SimpleInstruction()}.
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction()}
   */
  @Test
  @DisplayName("Test new SimpleInstruction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>()"})
  void testNewSimpleInstruction() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction();

    // Assert
    assertEquals("nop", actualSimpleInstruction.getName());
    assertEquals(0, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertFalse(actualSimpleInstruction.isWide());
    assertEquals(Instruction.OP_NOP, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @DisplayName("Test new SimpleInstruction(byte); when 'A'; then return Name is 'lstore_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  void testNewSimpleInstruction_whenA_thenReturnNameIsLstore2() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) 'A');

    // Assert
    assertEquals("lstore_2", actualSimpleInstruction.getName());
    assertEquals(0, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('A', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName("Test new SimpleInstruction(byte, int); when 'A'; then return Name is 'lstore_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenA_thenReturnNameIsLstore22() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) 'A', 1);

    // Assert
    assertEquals("lstore_2", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('A', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_BOOLEAN}.
   *   <li>Then return Name is {@code iconst_1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @DisplayName(
      "Test new SimpleInstruction(byte); when ARRAY_T_BOOLEAN; then return Name is 'iconst_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  void testNewSimpleInstruction_whenArray_t_boolean_thenReturnNameIsIconst1() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_BOOLEAN);

    // Assert
    assertEquals("iconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_BOOLEAN, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_CHAR}.
   *   <li>Then return Name is {@code iconst_2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @DisplayName(
      "Test new SimpleInstruction(byte); when ARRAY_T_CHAR; then return Name is 'iconst_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  void testNewSimpleInstruction_whenArray_t_char_thenReturnNameIsIconst2() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_CHAR);

    // Assert
    assertEquals("iconst_2", actualSimpleInstruction.getName());
    assertEquals(2, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_CHAR, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_DOUBLE}.
   *   <li>Then return Name is {@code iconst_4}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @DisplayName(
      "Test new SimpleInstruction(byte); when ARRAY_T_DOUBLE; then return Name is 'iconst_4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  void testNewSimpleInstruction_whenArray_t_double_thenReturnNameIsIconst4() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_DOUBLE);

    // Assert
    assertEquals("iconst_4", actualSimpleInstruction.getName());
    assertEquals(4, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_DOUBLE, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_FLOAT}.
   *   <li>Then return Name is {@code iconst_3}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @DisplayName(
      "Test new SimpleInstruction(byte); when ARRAY_T_FLOAT; then return Name is 'iconst_3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  void testNewSimpleInstruction_whenArray_t_float_thenReturnNameIsIconst3() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_FLOAT);

    // Assert
    assertEquals("iconst_3", actualSimpleInstruction.getName());
    assertEquals(3, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_FLOAT, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_LONG}.
   *   <li>Then return Name is {@code fconst_1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName(
      "Test new SimpleInstruction(byte, int); when ARRAY_T_LONG; then return Name is 'fconst_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenArray_t_long_thenReturnNameIsFconst1() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_LONG, 1);

    // Assert
    assertEquals("fconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals('\f', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then return Name is {@code iconst_5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @DisplayName("Test new SimpleInstruction(byte); when backspace; then return Name is 'iconst_5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  void testNewSimpleInstruction_whenBackspace_thenReturnNameIsIconst5() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\b');

    // Assert
    assertEquals("iconst_5", actualSimpleInstruction.getName());
    assertEquals(5, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals('\b', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@link SimpleInstruction#constant} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName(
      "Test new SimpleInstruction(byte, int); when minus one; then return constant is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenMinusOne_thenReturnConstantIsMinusOne() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1, -1);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(-1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When minus sixty-eight.
   *   <li>Then return {@link SimpleInstruction#constant} is minus sixty-eight.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName(
      "Test new SimpleInstruction(byte, int); when minus sixty-eight; then return constant is minus sixty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenMinusSixtyEight_thenReturnConstantIsMinusSixtyEight() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction =
        new SimpleInstruction(Instruction.ARRAY_T_LONG, -68);

    // Assert
    assertEquals("fconst_0", actualSimpleInstruction.getName());
    assertEquals(-68, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_LONG, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When minus two.
   *   <li>Then return {@link SimpleInstruction#constant} is minus two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName(
      "Test new SimpleInstruction(byte, int); when minus two; then return constant is minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenMinusTwo_thenReturnConstantIsMinusTwo() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1, -2);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(-2, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_DCONST_0}.
   *   <li>Then return Name is {@code dconst_1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName(
      "Test new SimpleInstruction(byte, int); when OP_DCONST_0; then return Name is 'dconst_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenOp_dconst_0_thenReturnNameIsDconst1() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_DCONST_0, 1);

    // Assert
    assertEquals("dconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_DCONST_1, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_ICONST_M1}.
   *   <li>Then return Name is {@code iconst_m1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte)}
   */
  @Test
  @DisplayName(
      "Test new SimpleInstruction(byte); when OP_ICONST_M1; then return Name is 'iconst_m1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte)"})
  void testNewSimpleInstruction_whenOp_iconst_m1_thenReturnNameIsIconstM1() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(-1, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@link SimpleInstruction#constant} is six.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName("Test new SimpleInstruction(byte, int); when six; then return constant is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenSix_thenReturnConstantIsSix() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1, 6);

    // Assert
    assertEquals("iconst_m1", actualSimpleInstruction.getName());
    assertEquals(6, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_ICONST_M1, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When tab.
   *   <li>Then return Name is {@code lconst_1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName("Test new SimpleInstruction(byte, int); when tab; then return Name is 'lconst_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenTab_thenReturnNameIsLconst1() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\t', 1);

    // Assert
    assertEquals("lconst_1", actualSimpleInstruction.getName());
    assertEquals(1, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('\n', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@link SimpleInstruction#constant} is three.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName("Test new SimpleInstruction(byte, int); when three; then return constant is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenThree_thenReturnConstantIsThree() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_LONG, 3);

    // Assert
    assertEquals("fconst_0", actualSimpleInstruction.getName());
    assertEquals(3, actualSimpleInstruction.constant);
    assertFalse(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.ARRAY_T_LONG, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return Name is {@code dconst_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName("Test new SimpleInstruction(byte, int); when two; then return Name is 'dconst_0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenTwo_thenReturnNameIsDconst0() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_DCONST_0, 2);

    // Assert
    assertEquals("dconst_0", actualSimpleInstruction.getName());
    assertEquals(2, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_DCONST_0, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return Name is {@code lconst_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName("Test new SimpleInstruction(byte, int); when two; then return Name is 'lconst_0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenTwo_thenReturnNameIsLconst0() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\t', 2);

    // Assert
    assertEquals("lconst_0", actualSimpleInstruction.getName());
    assertEquals(2, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('\t', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Name is {@code dconst_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName("Test new SimpleInstruction(byte, int); when zero; then return Name is 'dconst_0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenZero_thenReturnNameIsDconst0() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction(Instruction.OP_DCONST_0, 0);

    // Assert
    assertEquals("dconst_0", actualSimpleInstruction.getName());
    assertEquals(0, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals(Instruction.OP_DCONST_0, actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#SimpleInstruction(byte, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Name is {@code lconst_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#SimpleInstruction(byte, int)}
   */
  @Test
  @DisplayName("Test new SimpleInstruction(byte, int); when zero; then return Name is 'lconst_0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.<init>(byte, int)"})
  void testNewSimpleInstruction_whenZero_thenReturnNameIsLconst0() {
    // Arrange and Act
    SimpleInstruction actualSimpleInstruction = new SimpleInstruction((byte) '\t', 0);

    // Assert
    assertEquals("lconst_0", actualSimpleInstruction.getName());
    assertEquals(0, actualSimpleInstruction.constant);
    assertTrue(actualSimpleInstruction.isCategory2());
    assertEquals('\t', actualSimpleInstruction.opcode);
  }

  /**
   * Test {@link SimpleInstruction#copy(SimpleInstruction)}.
   *
   * <ul>
   *   <li>Then return {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#copy(SimpleInstruction)}
   */
  @Test
  @DisplayName(
      "Test copy(SimpleInstruction); then return SimpleInstruction(byte) with opcode is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleInstruction SimpleInstruction.copy(SimpleInstruction)"})
  void testCopy_thenReturnSimpleInstructionWithOpcodeIsA() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act
    SimpleInstruction actualCopyResult = simpleInstruction.copy(new SimpleInstruction((byte) 'A'));

    // Assert
    assertSame(simpleInstruction, actualCopyResult);
  }

  /**
   * Test {@link SimpleInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName(
      "Test canonicalOpcode(); given SimpleInstruction(byte) with opcode is 'A'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte SimpleInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_givenSimpleInstructionWithOpcodeIsA_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals('A', new SimpleInstruction((byte) 'A').canonicalOpcode());
  }

  /**
   * Test {@link SimpleInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is tab.
   *   <li>Then return tab.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName(
      "Test canonicalOpcode(); given SimpleInstruction(byte) with opcode is tab; then return tab")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte SimpleInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_givenSimpleInstructionWithOpcodeIsTab_thenReturnTab() {
    // Arrange, Act and Assert
    assertEquals('\t', new SimpleInstruction((byte) '\t').canonicalOpcode());
  }

  /**
   * Test {@link SimpleInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#ARRAY_T_LONG}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName("Test canonicalOpcode(); then return ARRAY_T_LONG")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte SimpleInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnArray_t_long() {
    // Arrange, Act and Assert
    assertEquals(
        Instruction.ARRAY_T_LONG,
        new SimpleInstruction(Instruction.ARRAY_T_LONG).canonicalOpcode());
  }

  /**
   * Test {@link SimpleInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_DCONST_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName("Test canonicalOpcode(); then return OP_DCONST_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte SimpleInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnOp_dconst_0() {
    // Arrange, Act and Assert
    assertEquals(
        Instruction.OP_DCONST_0, new SimpleInstruction(Instruction.OP_DCONST_0).canonicalOpcode());
  }

  /**
   * Test {@link SimpleInstruction#canonicalOpcode()}.
   *
   * <ul>
   *   <li>Then return {@link Instruction#OP_ICONST_0}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#canonicalOpcode()}
   */
  @Test
  @DisplayName("Test canonicalOpcode(); then return OP_ICONST_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte SimpleInstruction.canonicalOpcode()"})
  void testCanonicalOpcode_thenReturnOp_iconst_0() {
    // Arrange, Act and Assert
    assertEquals(
        Instruction.OP_ICONST_0, new SimpleInstruction(Instruction.OP_ICONST_M1).canonicalOpcode());
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ICONST_M1} {@link SimpleInstruction#constant} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); given SimpleInstruction(byte) with opcode is OP_ICONST_M1 constant is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  void testShrink_givenSimpleInstructionWithOpcodeIsOp_iconst_m1ConstantIsMinusOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1);
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("iconst_m1", simpleInstruction.getName());
    assertEquals("iconst_m1", actualShrinkResult.getName());
    assertEquals(Instruction.OP_ICONST_M1, simpleInstruction.opcode);
    assertEquals(Instruction.OP_ICONST_M1, ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link SimpleInstruction#constant} is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then return constant is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  void testShrink_thenReturnConstantIsMin_value() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1);
    simpleInstruction.constant = Integer.MIN_VALUE;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("iconst_m1", simpleInstruction.getName());
    assertEquals("iconst_m1", actualShrinkResult.getName());
    assertEquals(Integer.MIN_VALUE, ((SimpleInstruction) actualShrinkResult).constant);
    assertEquals(Instruction.OP_ICONST_M1, simpleInstruction.opcode);
    assertEquals(Instruction.OP_ICONST_M1, ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link SimpleInstruction#constant} is minus two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then return constant is minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  void testShrink_thenReturnConstantIsMinusTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1);
    simpleInstruction.constant = -2;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("bipush", simpleInstruction.getName());
    assertEquals("bipush", actualShrinkResult.getName());
    assertEquals(-2, ((SimpleInstruction) actualShrinkResult).constant);
    assertEquals(Instruction.OP_BIPUSH, simpleInstruction.opcode);
    assertEquals(Instruction.OP_BIPUSH, ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link SimpleInstruction#constant} is six.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then return constant is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  void testShrink_thenReturnConstantIsSix() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1);
    simpleInstruction.constant = 6;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertTrue(actualShrinkResult instanceof SimpleInstruction);
    assertEquals("bipush", simpleInstruction.getName());
    assertEquals("bipush", actualShrinkResult.getName());
    assertEquals(6, ((SimpleInstruction) actualShrinkResult).constant);
    assertEquals(Instruction.OP_BIPUSH, simpleInstruction.opcode);
    assertEquals(Instruction.OP_BIPUSH, ((SimpleInstruction) actualShrinkResult).opcode);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then return {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then return SimpleInstruction(byte) with opcode is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  void testShrink_thenReturnSimpleInstructionWithOpcodeIsA() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#ARRAY_T_LONG} Name is {@code lconst_1}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then SimpleInstruction(byte) with opcode is ARRAY_T_LONG Name is 'lconst_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  void testShrink_thenSimpleInstructionWithOpcodeIsArray_t_longNameIsLconst1() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_LONG);
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertEquals("lconst_1", simpleInstruction.getName());
    assertTrue(simpleInstruction.isCategory2());
    assertEquals('\n', simpleInstruction.opcode);
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_DCONST_0} Name is {@code fconst_2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @DisplayName(
      "Test shrink(); then SimpleInstruction(byte) with opcode is OP_DCONST_0 Name is 'fconst_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  void testShrink_thenSimpleInstructionWithOpcodeIsOp_dconst_0NameIsFconst2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_DCONST_0);
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertEquals("fconst_2", simpleInstruction.getName());
    assertEquals('\r', simpleInstruction.opcode);
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Test {@link SimpleInstruction#shrink()}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is tab Name is {@code
   *       iconst_5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#shrink()}
   */
  @Test
  @DisplayName("Test shrink(); then SimpleInstruction(byte) with opcode is tab Name is 'iconst_5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction SimpleInstruction.shrink()"})
  void testShrink_thenSimpleInstructionWithOpcodeIsTabNameIsIconst5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) '\t');
    simpleInstruction.constant = -1;

    // Act
    Instruction actualShrinkResult = simpleInstruction.shrink();

    // Assert
    assertEquals("iconst_5", simpleInstruction.getName());
    assertEquals('\b', simpleInstruction.opcode);
    assertSame(simpleInstruction, actualShrinkResult);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} {@link
   *       SimpleInstruction#constant} is zero.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then SimpleInstruction(byte) with opcode is 'A' constant is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenSimpleInstructionWithOpcodeIsAConstantIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act
    simpleInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert that nothing has changed
    assertEquals(0, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#ARRAY_T_BOOLEAN} {@link SimpleInstruction#constant} is one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then SimpleInstruction(byte) with opcode is ARRAY_T_BOOLEAN constant is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenSimpleInstructionWithOpcodeIsArray_t_booleanConstantIsOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_BOOLEAN);

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert that nothing has changed
    assertEquals(1, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#ARRAY_T_CHAR} {@link SimpleInstruction#constant} is two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then SimpleInstruction(byte) with opcode is ARRAY_T_CHAR constant is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenSimpleInstructionWithOpcodeIsArray_t_charConstantIsTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_CHAR);

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert that nothing has changed
    assertEquals(2, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#ARRAY_T_DOUBLE} {@link SimpleInstruction#constant} is four.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then SimpleInstruction(byte) with opcode is ARRAY_T_DOUBLE constant is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenSimpleInstructionWithOpcodeIsArray_t_doubleConstantIsFour() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_DOUBLE);

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert that nothing has changed
    assertEquals(4, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#ARRAY_T_FLOAT} {@link SimpleInstruction#constant} is three.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then SimpleInstruction(byte) with opcode is ARRAY_T_FLOAT constant is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenSimpleInstructionWithOpcodeIsArray_t_floatConstantIsThree() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_FLOAT);

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert that nothing has changed
    assertEquals(3, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is backspace {@link
   *       SimpleInstruction#constant} is five.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then SimpleInstruction(byte) with opcode is backspace constant is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenSimpleInstructionWithOpcodeIsBackspaceConstantIsFive() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) '\b');

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert that nothing has changed
    assertEquals(5, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_BIPUSH} {@link SimpleInstruction#constant} is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then SimpleInstruction(byte) with opcode is OP_BIPUSH constant is sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenSimpleInstructionWithOpcodeIsOp_bipushConstantIsSixtyFive() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_BIPUSH);

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(65, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ICONST_M1} {@link SimpleInstruction#constant} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then SimpleInstruction(byte) with opcode is OP_ICONST_M1 constant is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenSimpleInstructionWithOpcodeIsOp_iconst_m1ConstantIsMinusOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1);

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert that nothing has changed
    assertEquals(-1, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_NEWARRAY} {@link SimpleInstruction#constant} is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then SimpleInstruction(byte) with opcode is OP_NEWARRAY constant is sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenSimpleInstructionWithOpcodeIsOp_newarrayConstantIsSixtyFive() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_NEWARRAY);

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(65, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#readInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_SIPUSH} {@link SimpleInstruction#constant} is {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#readInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test readInfo(byte[], int); then SimpleInstruction(byte) with opcode is OP_SIPUSH constant is '16728'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.readInfo(byte[], int)"})
  void testReadInfo_thenSimpleInstructionWithOpcodeIsOp_sipushConstantIs16728() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_SIPUSH);

    // Act
    simpleInstruction.readInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(16728, simpleInstruction.constant);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new SimpleInstruction((byte) 'A', 255).writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test writeInfo(byte[], int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_BOOLEAN);
    simpleInstruction.constant = -2;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte, int)} with opcode is {@code A} and
   *       constant is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte, int) with opcode is 'A' and constant is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsAAndConstantIsMin_value()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new SimpleInstruction((byte) 'A', Integer.MIN_VALUE)
                .writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte, int)} with opcode is {@code A} and
   *       constant is {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte, int) with opcode is 'A' and constant is SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsAAndConstantIsSize()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new SimpleInstruction((byte) 'A', Short.SIZE)
                .writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte) with opcode is 'A'; then 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsA_thenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    new SimpleInstruction((byte) 'A').writeInfo(code, 2);

    // Assert that nothing has changed
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), code);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#ARRAY_T_CHAR} {@link SimpleInstruction#constant} is minus two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte) with opcode is ARRAY_T_CHAR constant is minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsArray_t_charConstantIsMinusTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_CHAR);
    simpleInstruction.constant = -2;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#ARRAY_T_DOUBLE} {@link SimpleInstruction#constant} is minus two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte) with opcode is ARRAY_T_DOUBLE constant is minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsArray_t_doubleConstantIsMinusTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_DOUBLE);
    simpleInstruction.constant = -2;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#ARRAY_T_FLOAT} {@link SimpleInstruction#constant} is minus two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte) with opcode is ARRAY_T_FLOAT constant is minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsArray_t_floatConstantIsMinusTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_FLOAT);
    simpleInstruction.constant = -2;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is backspace {@link
   *       SimpleInstruction#constant} is minus two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte) with opcode is backspace constant is minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsBackspaceConstantIsMinusTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) '\b');
    simpleInstruction.constant = -2;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte, int)} with opcode is {@link
   *       Instruction#OP_BIPUSH} and constant is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte, int) with opcode is OP_BIPUSH and constant is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsOp_bipushAndConstantIsMin_value()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new SimpleInstruction(Instruction.OP_BIPUSH, Integer.MIN_VALUE)
                .writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_BIPUSH} {@link SimpleInstruction#constant} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte) with opcode is OP_BIPUSH constant is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsOp_bipushConstantIsMinusOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_BIPUSH);
    simpleInstruction.constant = -1;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', -1, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_BIPUSH} {@link SimpleInstruction#constant} is minus two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte) with opcode is OP_BIPUSH constant is minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsOp_bipushConstantIsMinusTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_BIPUSH);
    simpleInstruction.constant = -2;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', -2, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_BIPUSH} {@link SimpleInstruction#constant} is six.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte) with opcode is OP_BIPUSH constant is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsOp_bipushConstantIsSix() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_BIPUSH);
    simpleInstruction.constant = 6;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(
        new byte[] {'A', 'X', Instruction.ARRAY_T_FLOAT, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_ICONST_M1} {@link SimpleInstruction#constant} is minus two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte) with opcode is OP_ICONST_M1 constant is minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsOp_iconst_m1ConstantIsMinusTwo() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1);
    simpleInstruction.constant = -2;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> simpleInstruction.writeInfo(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_NEWARRAY} {@link SimpleInstruction#constant} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte) with opcode is OP_NEWARRAY constant is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsOp_newarrayConstantIsMinusOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_NEWARRAY);
    simpleInstruction.constant = -1;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', -1, 'X', 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link SimpleInstruction#writeInfo(byte[], int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_SIPUSH} {@link SimpleInstruction#constant} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test writeInfo(byte[], int); given SimpleInstruction(byte) with opcode is OP_SIPUSH constant is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleInstruction.writeInfo(byte[], int)"})
  void testWriteInfo_givenSimpleInstructionWithOpcodeIsOp_sipushConstantIsMinusOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_SIPUSH);
    simpleInstruction.constant = -1;
    byte[] code = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    simpleInstruction.writeInfo(code, 2);

    // Assert
    assertArrayEquals(new byte[] {'A', 'X', -1, -1, 'A', 'X', 'A', 'X'}, code);
  }

  /**
   * Test {@link SimpleInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given SimpleInstruction(byte) with opcode is 'A'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.length(int)"})
  void testLength_givenSimpleInstructionWithOpcodeIsA_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new SimpleInstruction((byte) 'A').length(2));
  }

  /**
   * Test {@link SimpleInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_BIPUSH}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given SimpleInstruction(byte) with opcode is OP_BIPUSH; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.length(int)"})
  void testLength_givenSimpleInstructionWithOpcodeIsOp_bipush_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, new SimpleInstruction(Instruction.OP_BIPUSH).length(2));
  }

  /**
   * Test {@link SimpleInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_NEWARRAY}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given SimpleInstruction(byte) with opcode is OP_NEWARRAY; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.length(int)"})
  void testLength_givenSimpleInstructionWithOpcodeIsOp_newarray_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, new SimpleInstruction(Instruction.OP_NEWARRAY).length(2));
  }

  /**
   * Test {@link SimpleInstruction#length(int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@link
   *       Instruction#OP_SIPUSH}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#length(int)}
   */
  @Test
  @DisplayName(
      "Test length(int); given SimpleInstruction(byte) with opcode is OP_SIPUSH; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.length(int)"})
  void testLength_givenSimpleInstructionWithOpcodeIsOp_sipush_thenReturnThree() {
    // Arrange, Act and Assert
    assertEquals(3, new SimpleInstruction(Instruction.OP_SIPUSH).length(2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test stackEntryIndexBefore(Clazz, int); given SimpleInstruction(byte) with opcode is 'A'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsA_thenReturnMinusOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act and Assert
    assertEquals(-1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 1));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test stackEntryIndexBefore(Clazz, int); given SimpleInstruction(byte) with opcode is '\\'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsBackslash() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) '\\');

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code ^}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test stackEntryIndexBefore(Clazz, int); given SimpleInstruction(byte) with opcode is '^'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsCircumflexAccent() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) '^');

    // Act and Assert
    assertEquals(2, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test stackEntryIndexBefore(Clazz, int); given SimpleInstruction(byte) with opcode is '['")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsLeftSquareBracket() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) '[');

    // Act and Assert
    assertEquals(2, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test stackEntryIndexBefore(Clazz, int); given SimpleInstruction(byte) with opcode is '['")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsLeftSquareBracket2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) '[');

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 3));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code ]}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test stackEntryIndexBefore(Clazz, int); given SimpleInstruction(byte) with opcode is ']'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsRightSquareBracket() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) ']');

    // Act and Assert
    assertEquals(2, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code ]}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test stackEntryIndexBefore(Clazz, int); given SimpleInstruction(byte) with opcode is ']'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsRightSquareBracket2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) ']');

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 3));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code _}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test stackEntryIndexBefore(Clazz, int); given SimpleInstruction(byte) with opcode is '_'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsUnderscore() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) '_');

    // Act and Assert
    assertEquals(-1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code Y}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test stackEntryIndexBefore(Clazz, int); given SimpleInstruction(byte) with opcode is 'Y'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsY_thenReturnZero() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'Y');

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code Z}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test stackEntryIndexBefore(Clazz, int); given SimpleInstruction(byte) with opcode is 'Z'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsZ_thenReturnOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'Z');

    // Act and Assert
    assertEquals(1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 1));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code Z}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test stackEntryIndexBefore(Clazz, int); given SimpleInstruction(byte) with opcode is 'Z'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_givenSimpleInstructionWithOpcodeIsZ_thenReturnZero() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'Z');

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 2));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName("Test stackEntryIndexBefore(Clazz, int); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_thenReturnOne() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) '\\');

    // Act and Assert
    assertEquals(1, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 1));
  }

  /**
   * Test {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}.
   *
   * <ul>
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#stackEntryIndexBefore(Clazz, int)}
   */
  @Test
  @DisplayName("Test stackEntryIndexBefore(Clazz, int); when four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleInstruction.stackEntryIndexBefore(Clazz, int)"})
  void testStackEntryIndexBefore_whenFour() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) '^');

    // Act and Assert
    assertEquals(0, simpleInstruction.stackEntryIndexBefore(new LibraryClass(), 4));
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Given {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A}.
   *   <li>Then return {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given SimpleInstruction(byte) with opcode is 'A'; then return 'lstore_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  void testToString_givenSimpleInstructionWithOpcodeIsA_thenReturnLstore2() {
    // Arrange, Act and Assert
    assertEquals("lstore_2", new SimpleInstruction((byte) 'A').toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code bipush 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'bipush 5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  void testToString_thenReturnBipush5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_BIPUSH);
    simpleInstruction.constant = 5;

    // Act and Assert
    assertEquals("bipush 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'iconst_5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  void testToString_thenReturnIconst5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) '\b');
    simpleInstruction.constant = 5;

    // Act and Assert
    assertEquals("iconst_5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_1 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'iconst_1 5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  void testToString_thenReturnIconst15() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_BOOLEAN);
    simpleInstruction.constant = 5;

    // Act and Assert
    assertEquals("iconst_1 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_2 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'iconst_2 5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  void testToString_thenReturnIconst25() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_CHAR);
    simpleInstruction.constant = 5;

    // Act and Assert
    assertEquals("iconst_2 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_3 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'iconst_3 5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  void testToString_thenReturnIconst35() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_FLOAT);
    simpleInstruction.constant = 5;

    // Act and Assert
    assertEquals("iconst_3 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_4 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'iconst_4 5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  void testToString_thenReturnIconst45() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.ARRAY_T_DOUBLE);
    simpleInstruction.constant = 5;

    // Act and Assert
    assertEquals("iconst_4 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code iconst_m1 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'iconst_m1 5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  void testToString_thenReturnIconstM15() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_ICONST_M1);
    simpleInstruction.constant = 5;

    // Act and Assert
    assertEquals("iconst_m1 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code newarray 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'newarray 5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  void testToString_thenReturnNewarray5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_NEWARRAY);
    simpleInstruction.constant = 5;

    // Act and Assert
    assertEquals("newarray 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#toString()}.
   *
   * <ul>
   *   <li>Then return {@code sipush 5}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'sipush 5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SimpleInstruction.toString()"})
  void testToString_thenReturnSipush5() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_SIPUSH);
    simpleInstruction.constant = 5;

    // Act and Assert
    assertEquals("sipush 5", simpleInstruction.toString());
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}, and {@link SimpleInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleInstruction#equals(Object)}
   *   <li>{@link SimpleInstruction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');
    SimpleInstruction simpleInstruction2 = new SimpleInstruction((byte) 'A');

    // Act and Assert
    assertEquals(simpleInstruction, simpleInstruction2);
    assertEquals(simpleInstruction.hashCode(), simpleInstruction2.hashCode());
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}, and {@link SimpleInstruction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SimpleInstruction#equals(Object)}
   *   <li>{@link SimpleInstruction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A');

    // Act and Assert
    assertEquals(simpleInstruction, simpleInstruction);
    int expectedHashCodeResult = simpleInstruction.hashCode();
    assertEquals(expectedHashCodeResult, simpleInstruction.hashCode());
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction(Instruction.OP_ACONST_NULL);

    // Act and Assert
    assertNotEquals(simpleInstruction, new SimpleInstruction((byte) 'A'));
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SimpleInstruction simpleInstruction = new SimpleInstruction((byte) 'A', 65);

    // Act and Assert
    assertNotEquals(simpleInstruction, new SimpleInstruction((byte) 'A'));
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleInstruction((byte) 'A'), null);
  }

  /**
   * Test {@link SimpleInstruction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SimpleInstruction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SimpleInstruction.equals(Object)",
    "int SimpleInstruction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleInstruction((byte) 'A'), "Different type to SimpleInstruction");
  }
}
