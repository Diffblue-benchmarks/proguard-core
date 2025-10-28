package proguard.classfile.instruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class InstructionUtilDiffblueTest {
  /**
   * Method under test: {@link InstructionUtil#internalTypeFromArrayType(byte)}
   */
  @Test
  public void testInternalTypeFromArrayType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> InstructionUtil.internalTypeFromArrayType((byte) 'A'));
    assertEquals('Z', InstructionUtil.internalTypeFromArrayType(Instruction.ARRAY_T_BOOLEAN));
    assertEquals('C', InstructionUtil.internalTypeFromArrayType(Instruction.ARRAY_T_CHAR));
    assertEquals('F', InstructionUtil.internalTypeFromArrayType(Instruction.ARRAY_T_FLOAT));
    assertEquals('D', InstructionUtil.internalTypeFromArrayType(Instruction.ARRAY_T_DOUBLE));
    assertEquals('B', InstructionUtil.internalTypeFromArrayType((byte) '\b'));
    assertEquals('S', InstructionUtil.internalTypeFromArrayType((byte) '\t'));
    assertEquals('I', InstructionUtil.internalTypeFromArrayType((byte) '\n'));
    assertEquals('J', InstructionUtil.internalTypeFromArrayType(Instruction.ARRAY_T_LONG));
  }

  /**
   * Method under test: {@link InstructionUtil#arrayTypeFromInternalType(char)}
   */
  @Test
  public void testArrayTypeFromInternalType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> InstructionUtil.arrayTypeFromInternalType('A'));
    assertEquals('\b', InstructionUtil.arrayTypeFromInternalType('B'));
    assertEquals(Instruction.ARRAY_T_CHAR, InstructionUtil.arrayTypeFromInternalType('C'));
    assertEquals(Instruction.ARRAY_T_DOUBLE, InstructionUtil.arrayTypeFromInternalType('D'));
    assertEquals(Instruction.ARRAY_T_FLOAT, InstructionUtil.arrayTypeFromInternalType('F'));
    assertEquals('\n', InstructionUtil.arrayTypeFromInternalType('I'));
    assertEquals(Instruction.ARRAY_T_LONG, InstructionUtil.arrayTypeFromInternalType('J'));
    assertEquals('\t', InstructionUtil.arrayTypeFromInternalType('S'));
    assertEquals(Instruction.ARRAY_T_BOOLEAN, InstructionUtil.arrayTypeFromInternalType('Z'));
  }

  /**
   * Method under test: {@link InstructionUtil#isStaticCall(byte)}
   */
  @Test
  public void testIsStaticCall() {
    // Arrange, Act and Assert
    assertFalse(InstructionUtil.isStaticCall((byte) 'A'));
    assertTrue(InstructionUtil.isStaticCall(Instruction.OP_INVOKESTATIC));
  }
}
