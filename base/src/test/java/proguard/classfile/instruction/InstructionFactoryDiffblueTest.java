package proguard.classfile.instruction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InstructionFactoryDiffblueTest {
  /**
   * Test {@link InstructionFactory#create(byte[], int)} with {@code code}, {@code offset}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@link VariableInstruction#constant} is {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test create(byte[], int) with 'code', 'offset'; when 'A'; then return constant is '16728'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte[], int)"})
  void testCreateWithCodeOffset_whenA_thenReturnConstantIs16728() {
    // Arrange and Act
    Instruction actualCreateResult =
        InstructionFactory.create(
            new byte[] {'A', 'X', Instruction.OP_WIDE, Instruction.OP_IINC, 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertTrue(actualCreateResult instanceof VariableInstruction);
    assertEquals("iinc", actualCreateResult.getName());
    assertEquals(16728, ((VariableInstruction) actualCreateResult).constant);
    assertEquals(16728, ((VariableInstruction) actualCreateResult).variableIndex);
    assertFalse(actualCreateResult.isCategory2());
    assertTrue(actualCreateResult.isWide());
    assertTrue(((VariableInstruction) actualCreateResult).isLoad());
    assertEquals(Instruction.OP_IINC, ((VariableInstruction) actualCreateResult).opcode);
  }

  /**
   * Test {@link InstructionFactory#create(byte[], int)} with {@code code}, {@code offset}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return Name is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test create(byte[], int) with 'code', 'offset'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return Name is 'lstore_2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte[], int)"})
  void testCreateWithCodeOffset_whenAxaxaxaxBytesIsUtf8_thenReturnNameIsLstore2()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertTrue(actualCreateResult instanceof VariableInstruction);
    assertEquals("lstore_2", actualCreateResult.getName());
    assertEquals(2, ((VariableInstruction) actualCreateResult).variableIndex);
    assertFalse(((VariableInstruction) actualCreateResult).isLoad());
    assertEquals('A', ((VariableInstruction) actualCreateResult).opcode);
  }

  /**
   * Test {@link InstructionFactory#create(byte[], int)} with {@code code}, {@code offset}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return {@link VariableInstruction#constant} is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test create(byte[], int) with 'code', 'offset'; when 'X'; then return constant is sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte[], int)"})
  void testCreateWithCodeOffset_whenX_thenReturnConstantIsSixtyFive() {
    // Arrange and Act
    Instruction actualCreateResult =
        InstructionFactory.create(
            new byte[] {'A', 'X', Instruction.OP_IINC, 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertTrue(actualCreateResult instanceof VariableInstruction);
    assertEquals("iinc", actualCreateResult.getName());
    assertEquals(65, ((VariableInstruction) actualCreateResult).constant);
    assertEquals(88, ((VariableInstruction) actualCreateResult).variableIndex);
    assertFalse(actualCreateResult.isCategory2());
    assertFalse(actualCreateResult.isWide());
    assertTrue(((VariableInstruction) actualCreateResult).isLoad());
    assertEquals(Instruction.OP_IINC, ((VariableInstruction) actualCreateResult).opcode);
  }

  /**
   * Test {@link InstructionFactory#create(byte[], int)} with {@code code}, {@code offset}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return {@link SimpleInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test create(byte[], int) with 'code', 'offset'; when 'X'; then return SimpleInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte[], int)"})
  void testCreateWithCodeOffset_whenX_thenReturnSimpleInstruction() {
    // Arrange and Act
    Instruction actualCreateResult =
        InstructionFactory.create(
            new byte[] {'A', 'X', Instruction.OP_WIDE, 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertTrue(actualCreateResult instanceof SimpleInstruction);
    assertEquals("pop2", actualCreateResult.getName());
    assertFalse(actualCreateResult.isWide());
    assertEquals('X', ((SimpleInstruction) actualCreateResult).opcode);
  }

  /**
   * Test {@link InstructionFactory#create(byte[], int)} with {@code code}, {@code offset}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test create(byte[], int) with 'code', 'offset'; when 'X'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte[], int)"})
  void testCreateWithCodeOffset_whenX_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> InstructionFactory.create(new byte[] {'A', 'X', -1, 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Test {@link InstructionFactory#create(byte, boolean)} with {@code opcode}, {@code wide}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@link VariableInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(byte, boolean) with 'opcode', 'wide'; when 'A'; then return VariableInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte, boolean)"})
  void testCreateWithOpcodeWide_whenA_thenReturnVariableInstruction() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create((byte) 'A', true);

    // Assert
    assertTrue(actualCreateResult instanceof VariableInstruction);
    assertEquals(0, ((VariableInstruction) actualCreateResult).variableIndex);
    assertFalse(((VariableInstruction) actualCreateResult).isStore());
    assertTrue(actualCreateResult.isWide());
    assertTrue(((VariableInstruction) actualCreateResult).isLoad());
  }

  /**
   * Test {@link InstructionFactory#create(byte, boolean)} with {@code opcode}, {@code wide}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_IFEQ}.
   *   <li>Then return {@link BranchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(byte, boolean) with 'opcode', 'wide'; when OP_IFEQ; then return BranchInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte, boolean)"})
  void testCreateWithOpcodeWide_whenOp_ifeq_thenReturnBranchInstruction() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_IFEQ, true);

    // Assert
    assertTrue(actualCreateResult instanceof BranchInstruction);
    assertEquals("nop", actualCreateResult.getName());
    assertEquals(0, ((BranchInstruction) actualCreateResult).branchOffset);
    assertFalse(actualCreateResult.isCategory2());
    assertFalse(actualCreateResult.isWide());
    assertEquals(Instruction.OP_NOP, ((BranchInstruction) actualCreateResult).opcode);
  }

  /**
   * Test {@link InstructionFactory#create(byte, boolean)} with {@code opcode}, {@code wide}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_IOR}.
   *   <li>Then return {@link SimpleInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(byte, boolean) with 'opcode', 'wide'; when OP_IOR; then return SimpleInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte, boolean)"})
  void testCreateWithOpcodeWide_whenOp_ior_thenReturnSimpleInstruction() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_IOR, true);

    // Assert
    assertTrue(actualCreateResult instanceof SimpleInstruction);
    assertEquals("nop", actualCreateResult.getName());
    assertEquals(0, ((SimpleInstruction) actualCreateResult).constant);
    assertFalse(actualCreateResult.isCategory2());
    assertFalse(actualCreateResult.isWide());
    assertEquals(Instruction.OP_NOP, ((SimpleInstruction) actualCreateResult).opcode);
  }

  /**
   * Test {@link InstructionFactory#create(byte, boolean)} with {@code opcode}, {@code wide}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_LOOKUPSWITCH}.
   *   <li>Then return {@link LookUpSwitchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(byte, boolean) with 'opcode', 'wide'; when OP_LOOKUPSWITCH; then return LookUpSwitchInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte, boolean)"})
  void testCreateWithOpcodeWide_whenOp_lookupswitch_thenReturnLookUpSwitchInstruction() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_LOOKUPSWITCH, true);

    // Assert
    assertTrue(actualCreateResult instanceof LookUpSwitchInstruction);
    assertNull(((LookUpSwitchInstruction) actualCreateResult).cases);
    assertNull(((LookUpSwitchInstruction) actualCreateResult).jumpOffsets);
    assertEquals(0, ((LookUpSwitchInstruction) actualCreateResult).defaultOffset);
  }

  /**
   * Test {@link InstructionFactory#create(byte, boolean)} with {@code opcode}, {@code wide}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_TABLESWITCH}.
   *   <li>Then return {@link TableSwitchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(byte, boolean) with 'opcode', 'wide'; when OP_TABLESWITCH; then return TableSwitchInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte, boolean)"})
  void testCreateWithOpcodeWide_whenOp_tableswitch_thenReturnTableSwitchInstruction() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_TABLESWITCH, true);

    // Assert
    assertTrue(actualCreateResult instanceof TableSwitchInstruction);
    assertNull(((TableSwitchInstruction) actualCreateResult).jumpOffsets);
    assertEquals(0, ((TableSwitchInstruction) actualCreateResult).defaultOffset);
    assertEquals(0, ((TableSwitchInstruction) actualCreateResult).highCase);
    assertEquals(0, ((TableSwitchInstruction) actualCreateResult).lowCase);
  }

  /**
   * Test {@link InstructionFactory#create(byte, boolean)} with {@code opcode}, {@code wide}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_WIDE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  @DisplayName(
      "Test create(byte, boolean) with 'opcode', 'wide'; when OP_WIDE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte, boolean)"})
  void testCreateWithOpcodeWide_whenOp_wide_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> InstructionFactory.create(Instruction.OP_WIDE, true));
  }

  /**
   * Test {@link InstructionFactory#create(byte)} with {@code opcode}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@link VariableInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  @DisplayName("Test create(byte) with 'opcode'; when 'A'; then return VariableInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte)"})
  void testCreateWithOpcode_whenA_thenReturnVariableInstruction() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create((byte) 'A');

    // Assert
    assertTrue(actualCreateResult instanceof VariableInstruction);
    assertEquals("lstore_2", actualCreateResult.getName());
    assertEquals(0, ((VariableInstruction) actualCreateResult).variableIndex);
    assertFalse(actualCreateResult.isWide());
    assertFalse(((VariableInstruction) actualCreateResult).isLoad());
    assertTrue(actualCreateResult.isCategory2());
    assertTrue(((VariableInstruction) actualCreateResult).isStore());
    assertEquals('A', ((VariableInstruction) actualCreateResult).opcode);
  }

  /**
   * Test {@link InstructionFactory#create(byte)} with {@code opcode}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_IFEQ}.
   *   <li>Then return {@link BranchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  @DisplayName("Test create(byte) with 'opcode'; when OP_IFEQ; then return BranchInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte)"})
  void testCreateWithOpcode_whenOp_ifeq_thenReturnBranchInstruction() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_IFEQ);

    // Assert
    assertTrue(actualCreateResult instanceof BranchInstruction);
    assertEquals("ifeq", actualCreateResult.getName());
    assertEquals(0, ((BranchInstruction) actualCreateResult).branchOffset);
    assertEquals(Instruction.OP_IFEQ, ((BranchInstruction) actualCreateResult).opcode);
  }

  /**
   * Test {@link InstructionFactory#create(byte)} with {@code opcode}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_IOR}.
   *   <li>Then return {@link SimpleInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  @DisplayName("Test create(byte) with 'opcode'; when OP_IOR; then return SimpleInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte)"})
  void testCreateWithOpcode_whenOp_ior_thenReturnSimpleInstruction() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_IOR);

    // Assert
    assertTrue(actualCreateResult instanceof SimpleInstruction);
    assertEquals("ior", actualCreateResult.getName());
    assertEquals(0, ((SimpleInstruction) actualCreateResult).constant);
    assertEquals(Instruction.OP_IOR, ((SimpleInstruction) actualCreateResult).opcode);
  }

  /**
   * Test {@link InstructionFactory#create(byte)} with {@code opcode}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_LOOKUPSWITCH}.
   *   <li>Then return {@link LookUpSwitchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  @DisplayName(
      "Test create(byte) with 'opcode'; when OP_LOOKUPSWITCH; then return LookUpSwitchInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte)"})
  void testCreateWithOpcode_whenOp_lookupswitch_thenReturnLookUpSwitchInstruction() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_LOOKUPSWITCH);

    // Assert
    assertTrue(actualCreateResult instanceof LookUpSwitchInstruction);
    assertEquals("lookupswitch", actualCreateResult.getName());
    assertNull(((LookUpSwitchInstruction) actualCreateResult).cases);
    assertEquals(
        Instruction.OP_LOOKUPSWITCH, ((LookUpSwitchInstruction) actualCreateResult).opcode);
  }

  /**
   * Test {@link InstructionFactory#create(byte)} with {@code opcode}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_TABLESWITCH}.
   *   <li>Then return {@link TableSwitchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  @DisplayName(
      "Test create(byte) with 'opcode'; when OP_TABLESWITCH; then return TableSwitchInstruction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte)"})
  void testCreateWithOpcode_whenOp_tableswitch_thenReturnTableSwitchInstruction() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_TABLESWITCH);

    // Assert
    assertTrue(actualCreateResult instanceof TableSwitchInstruction);
    assertEquals("tableswitch", actualCreateResult.getName());
    assertEquals(0, ((TableSwitchInstruction) actualCreateResult).highCase);
    assertEquals(0, ((TableSwitchInstruction) actualCreateResult).lowCase);
    assertEquals(Instruction.OP_TABLESWITCH, ((TableSwitchInstruction) actualCreateResult).opcode);
  }

  /**
   * Test {@link InstructionFactory#create(byte)} with {@code opcode}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_WIDE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  @DisplayName("Test create(byte) with 'opcode'; when OP_WIDE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Instruction InstructionFactory.create(byte)"})
  void testCreateWithOpcode_whenOp_wide_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> InstructionFactory.create(Instruction.OP_WIDE));
  }
}
