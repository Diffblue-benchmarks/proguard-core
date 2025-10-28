package proguard.classfile.instruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class InstructionFactoryDiffblueTest {
  /**
   * Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  public void testCreate() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create((byte) 'A');

    // Assert
    assertTrue(actualCreateResult instanceof VariableInstruction);
    assertEquals("lstore_2", actualCreateResult.getName());
    assertEquals(0, ((VariableInstruction) actualCreateResult).constant);
    assertEquals(0, ((VariableInstruction) actualCreateResult).variableIndex);
    assertFalse(actualCreateResult.isWide());
    assertFalse(((VariableInstruction) actualCreateResult).isLoad());
    assertTrue(actualCreateResult.isCategory2());
    assertTrue(((VariableInstruction) actualCreateResult).isStore());
    assertEquals('A', ((VariableInstruction) actualCreateResult).opcode);
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  public void testCreate2() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_IOR);

    // Assert
    assertTrue(actualCreateResult instanceof SimpleInstruction);
    assertEquals("ior", actualCreateResult.getName());
    assertEquals(0, ((SimpleInstruction) actualCreateResult).constant);
    assertFalse(actualCreateResult.isCategory2());
    assertFalse(actualCreateResult.isWide());
    assertEquals(Instruction.OP_IOR, ((SimpleInstruction) actualCreateResult).opcode);
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  public void testCreate3() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_IFEQ);

    // Assert
    assertTrue(actualCreateResult instanceof BranchInstruction);
    assertEquals("ifeq", actualCreateResult.getName());
    assertEquals(0, ((BranchInstruction) actualCreateResult).branchOffset);
    assertFalse(actualCreateResult.isCategory2());
    assertFalse(actualCreateResult.isWide());
    assertEquals(Instruction.OP_IFEQ, ((BranchInstruction) actualCreateResult).opcode);
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  public void testCreate4() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_TABLESWITCH);

    // Assert
    assertTrue(actualCreateResult instanceof TableSwitchInstruction);
    assertEquals("tableswitch", actualCreateResult.getName());
    assertNull(((TableSwitchInstruction) actualCreateResult).jumpOffsets);
    assertEquals(0, ((TableSwitchInstruction) actualCreateResult).defaultOffset);
    assertEquals(0, ((TableSwitchInstruction) actualCreateResult).highCase);
    assertEquals(0, ((TableSwitchInstruction) actualCreateResult).lowCase);
    assertFalse(actualCreateResult.isCategory2());
    assertFalse(actualCreateResult.isWide());
    assertEquals(Instruction.OP_TABLESWITCH, ((TableSwitchInstruction) actualCreateResult).opcode);
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  public void testCreate5() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_LOOKUPSWITCH);

    // Assert
    assertTrue(actualCreateResult instanceof LookUpSwitchInstruction);
    assertEquals("lookupswitch", actualCreateResult.getName());
    assertNull(((LookUpSwitchInstruction) actualCreateResult).cases);
    assertNull(((LookUpSwitchInstruction) actualCreateResult).jumpOffsets);
    assertEquals(0, ((LookUpSwitchInstruction) actualCreateResult).defaultOffset);
    assertFalse(actualCreateResult.isCategory2());
    assertFalse(actualCreateResult.isWide());
    assertEquals(Instruction.OP_LOOKUPSWITCH, ((LookUpSwitchInstruction) actualCreateResult).opcode);
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte)}
   */
  @Test
  public void testCreate6() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> InstructionFactory.create(Instruction.OP_WIDE));
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  public void testCreate7() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create((byte) 'A', true);

    // Assert
    assertTrue(actualCreateResult instanceof VariableInstruction);
    assertEquals("nop", actualCreateResult.getName());
    assertEquals(0, ((VariableInstruction) actualCreateResult).constant);
    assertEquals(0, ((VariableInstruction) actualCreateResult).variableIndex);
    assertFalse(actualCreateResult.isCategory2());
    assertFalse(((VariableInstruction) actualCreateResult).isStore());
    assertTrue(actualCreateResult.isWide());
    assertTrue(((VariableInstruction) actualCreateResult).isLoad());
    assertEquals(Instruction.OP_NOP, ((VariableInstruction) actualCreateResult).opcode);
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  public void testCreate8() {
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
   * Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  public void testCreate9() {
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
   * Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  public void testCreate10() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_TABLESWITCH, true);

    // Assert
    assertTrue(actualCreateResult instanceof TableSwitchInstruction);
    assertEquals("nop", actualCreateResult.getName());
    assertNull(((TableSwitchInstruction) actualCreateResult).jumpOffsets);
    assertEquals(0, ((TableSwitchInstruction) actualCreateResult).defaultOffset);
    assertEquals(0, ((TableSwitchInstruction) actualCreateResult).highCase);
    assertEquals(0, ((TableSwitchInstruction) actualCreateResult).lowCase);
    assertFalse(actualCreateResult.isCategory2());
    assertFalse(actualCreateResult.isWide());
    assertEquals(Instruction.OP_NOP, ((TableSwitchInstruction) actualCreateResult).opcode);
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  public void testCreate11() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create(Instruction.OP_LOOKUPSWITCH, true);

    // Assert
    assertTrue(actualCreateResult instanceof LookUpSwitchInstruction);
    assertEquals("nop", actualCreateResult.getName());
    assertNull(((LookUpSwitchInstruction) actualCreateResult).cases);
    assertNull(((LookUpSwitchInstruction) actualCreateResult).jumpOffsets);
    assertEquals(0, ((LookUpSwitchInstruction) actualCreateResult).defaultOffset);
    assertFalse(actualCreateResult.isCategory2());
    assertFalse(actualCreateResult.isWide());
    assertEquals(Instruction.OP_NOP, ((LookUpSwitchInstruction) actualCreateResult).opcode);
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte, boolean)}
   */
  @Test
  public void testCreate12() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> InstructionFactory.create(Instruction.OP_WIDE, true));
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte[], int)}
   */
  @Test
  public void testCreate13() throws UnsupportedEncodingException {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory.create("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertTrue(actualCreateResult instanceof VariableInstruction);
    assertEquals("lstore_2", actualCreateResult.getName());
    assertEquals(0, ((VariableInstruction) actualCreateResult).constant);
    assertEquals(2, ((VariableInstruction) actualCreateResult).variableIndex);
    assertFalse(actualCreateResult.isWide());
    assertFalse(((VariableInstruction) actualCreateResult).isLoad());
    assertTrue(actualCreateResult.isCategory2());
    assertTrue(((VariableInstruction) actualCreateResult).isStore());
    assertEquals('A', ((VariableInstruction) actualCreateResult).opcode);
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte[], int)}
   */
  @Test
  public void testCreate14() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory
        .create(new byte[]{'A', 'X', Instruction.OP_WIDE, 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertTrue(actualCreateResult instanceof SimpleInstruction);
    assertEquals("pop2", actualCreateResult.getName());
    assertEquals(0, ((SimpleInstruction) actualCreateResult).constant);
    assertFalse(actualCreateResult.isWide());
    assertTrue(actualCreateResult.isCategory2());
    assertEquals('X', ((SimpleInstruction) actualCreateResult).opcode);
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte[], int)}
   */
  @Test
  public void testCreate15() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> InstructionFactory.create(new byte[]{'A', 'X', -1, 'X', 'A', 'X', 'A', 'X'}, 2));
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte[], int)}
   */
  @Test
  public void testCreate16() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory
        .create(new byte[]{'A', 'X', Instruction.OP_IINC, 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertTrue(actualCreateResult instanceof VariableInstruction);
    assertEquals("iinc", actualCreateResult.getName());
    assertEquals(65, ((VariableInstruction) actualCreateResult).constant);
    assertEquals(88, ((VariableInstruction) actualCreateResult).variableIndex);
    assertFalse(actualCreateResult.isCategory2());
    assertFalse(actualCreateResult.isWide());
    assertTrue(((VariableInstruction) actualCreateResult).isLoad());
    assertTrue(((VariableInstruction) actualCreateResult).isStore());
    assertEquals(Instruction.OP_IINC, ((VariableInstruction) actualCreateResult).opcode);
  }

  /**
   * Method under test: {@link InstructionFactory#create(byte[], int)}
   */
  @Test
  public void testCreate17() {
    // Arrange and Act
    Instruction actualCreateResult = InstructionFactory
        .create(new byte[]{'A', 'X', Instruction.OP_WIDE, Instruction.OP_IINC, 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertTrue(actualCreateResult instanceof VariableInstruction);
    assertEquals("iinc", actualCreateResult.getName());
    assertEquals(16728, ((VariableInstruction) actualCreateResult).constant);
    assertEquals(16728, ((VariableInstruction) actualCreateResult).variableIndex);
    assertFalse(actualCreateResult.isCategory2());
    assertTrue(actualCreateResult.isWide());
    assertTrue(((VariableInstruction) actualCreateResult).isLoad());
    assertTrue(((VariableInstruction) actualCreateResult).isStore());
    assertEquals(Instruction.OP_IINC, ((VariableInstruction) actualCreateResult).opcode);
  }
}
