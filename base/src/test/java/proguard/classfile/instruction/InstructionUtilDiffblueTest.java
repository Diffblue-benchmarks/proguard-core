package proguard.classfile.instruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InstructionUtilDiffblueTest {
  /**
   * Test {@link InstructionUtil#internalTypeFromArrayType(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#internalTypeFromArrayType(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char InstructionUtil.internalTypeFromArrayType(byte)"})
  public void testInternalTypeFromArrayType_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> InstructionUtil.internalTypeFromArrayType((byte) 'A'));
  }

  /**
   * Test {@link InstructionUtil#internalTypeFromArrayType(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_BOOLEAN}.
   *   <li>Then return {@code Z}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#internalTypeFromArrayType(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char InstructionUtil.internalTypeFromArrayType(byte)"})
  public void testInternalTypeFromArrayType_whenArray_t_boolean_thenReturnZ() {
    // Arrange, Act and Assert
    assertEquals('Z', InstructionUtil.internalTypeFromArrayType(Instruction.ARRAY_T_BOOLEAN));
  }

  /**
   * Test {@link InstructionUtil#internalTypeFromArrayType(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_CHAR}.
   *   <li>Then return {@code C}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#internalTypeFromArrayType(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char InstructionUtil.internalTypeFromArrayType(byte)"})
  public void testInternalTypeFromArrayType_whenArray_t_char_thenReturnC() {
    // Arrange, Act and Assert
    assertEquals('C', InstructionUtil.internalTypeFromArrayType(Instruction.ARRAY_T_CHAR));
  }

  /**
   * Test {@link InstructionUtil#internalTypeFromArrayType(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_DOUBLE}.
   *   <li>Then return {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#internalTypeFromArrayType(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char InstructionUtil.internalTypeFromArrayType(byte)"})
  public void testInternalTypeFromArrayType_whenArray_t_double_thenReturnD() {
    // Arrange, Act and Assert
    assertEquals('D', InstructionUtil.internalTypeFromArrayType(Instruction.ARRAY_T_DOUBLE));
  }

  /**
   * Test {@link InstructionUtil#internalTypeFromArrayType(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_FLOAT}.
   *   <li>Then return {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#internalTypeFromArrayType(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char InstructionUtil.internalTypeFromArrayType(byte)"})
  public void testInternalTypeFromArrayType_whenArray_t_float_thenReturnF() {
    // Arrange, Act and Assert
    assertEquals('F', InstructionUtil.internalTypeFromArrayType(Instruction.ARRAY_T_FLOAT));
  }

  /**
   * Test {@link InstructionUtil#internalTypeFromArrayType(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#ARRAY_T_LONG}.
   *   <li>Then return {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#internalTypeFromArrayType(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char InstructionUtil.internalTypeFromArrayType(byte)"})
  public void testInternalTypeFromArrayType_whenArray_t_long_thenReturnJ() {
    // Arrange, Act and Assert
    assertEquals('J', InstructionUtil.internalTypeFromArrayType(Instruction.ARRAY_T_LONG));
  }

  /**
   * Test {@link InstructionUtil#internalTypeFromArrayType(byte)}.
   *
   * <ul>
   *   <li>When backspace.
   *   <li>Then return {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#internalTypeFromArrayType(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char InstructionUtil.internalTypeFromArrayType(byte)"})
  public void testInternalTypeFromArrayType_whenBackspace_thenReturnB() {
    // Arrange, Act and Assert
    assertEquals('B', InstructionUtil.internalTypeFromArrayType((byte) '\b'));
  }

  /**
   * Test {@link InstructionUtil#internalTypeFromArrayType(byte)}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#internalTypeFromArrayType(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char InstructionUtil.internalTypeFromArrayType(byte)"})
  public void testInternalTypeFromArrayType_whenLf_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals('I', InstructionUtil.internalTypeFromArrayType((byte) '\n'));
  }

  /**
   * Test {@link InstructionUtil#internalTypeFromArrayType(byte)}.
   *
   * <ul>
   *   <li>When tab.
   *   <li>Then return {@code S}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#internalTypeFromArrayType(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char InstructionUtil.internalTypeFromArrayType(byte)"})
  public void testInternalTypeFromArrayType_whenTab_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals('S', InstructionUtil.internalTypeFromArrayType((byte) '\t'));
  }

  /**
   * Test {@link InstructionUtil#arrayTypeFromInternalType(char)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#arrayTypeFromInternalType(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte InstructionUtil.arrayTypeFromInternalType(char)"})
  public void testArrayTypeFromInternalType_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> InstructionUtil.arrayTypeFromInternalType('A'));
  }

  /**
   * Test {@link InstructionUtil#arrayTypeFromInternalType(char)}.
   *
   * <ul>
   *   <li>When {@code B}.
   *   <li>Then return backspace.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#arrayTypeFromInternalType(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte InstructionUtil.arrayTypeFromInternalType(char)"})
  public void testArrayTypeFromInternalType_whenB_thenReturnBackspace() {
    // Arrange, Act and Assert
    assertEquals('\b', InstructionUtil.arrayTypeFromInternalType('B'));
  }

  /**
   * Test {@link InstructionUtil#arrayTypeFromInternalType(char)}.
   *
   * <ul>
   *   <li>When {@code C}.
   *   <li>Then return {@link Instruction#ARRAY_T_CHAR}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#arrayTypeFromInternalType(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte InstructionUtil.arrayTypeFromInternalType(char)"})
  public void testArrayTypeFromInternalType_whenC_thenReturnArray_t_char() {
    // Arrange, Act and Assert
    assertEquals(Instruction.ARRAY_T_CHAR, InstructionUtil.arrayTypeFromInternalType('C'));
  }

  /**
   * Test {@link InstructionUtil#arrayTypeFromInternalType(char)}.
   *
   * <ul>
   *   <li>When {@code D}.
   *   <li>Then return {@link Instruction#ARRAY_T_DOUBLE}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#arrayTypeFromInternalType(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte InstructionUtil.arrayTypeFromInternalType(char)"})
  public void testArrayTypeFromInternalType_whenD_thenReturnArray_t_double() {
    // Arrange, Act and Assert
    assertEquals(Instruction.ARRAY_T_DOUBLE, InstructionUtil.arrayTypeFromInternalType('D'));
  }

  /**
   * Test {@link InstructionUtil#arrayTypeFromInternalType(char)}.
   *
   * <ul>
   *   <li>When {@code F}.
   *   <li>Then return {@link Instruction#ARRAY_T_FLOAT}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#arrayTypeFromInternalType(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte InstructionUtil.arrayTypeFromInternalType(char)"})
  public void testArrayTypeFromInternalType_whenF_thenReturnArray_t_float() {
    // Arrange, Act and Assert
    assertEquals(Instruction.ARRAY_T_FLOAT, InstructionUtil.arrayTypeFromInternalType('F'));
  }

  /**
   * Test {@link InstructionUtil#arrayTypeFromInternalType(char)}.
   *
   * <ul>
   *   <li>When {@code I}.
   *   <li>Then return lf.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#arrayTypeFromInternalType(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte InstructionUtil.arrayTypeFromInternalType(char)"})
  public void testArrayTypeFromInternalType_whenI_thenReturnLf() {
    // Arrange, Act and Assert
    assertEquals('\n', InstructionUtil.arrayTypeFromInternalType('I'));
  }

  /**
   * Test {@link InstructionUtil#arrayTypeFromInternalType(char)}.
   *
   * <ul>
   *   <li>When {@code J}.
   *   <li>Then return {@link Instruction#ARRAY_T_LONG}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#arrayTypeFromInternalType(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte InstructionUtil.arrayTypeFromInternalType(char)"})
  public void testArrayTypeFromInternalType_whenJ_thenReturnArray_t_long() {
    // Arrange, Act and Assert
    assertEquals(Instruction.ARRAY_T_LONG, InstructionUtil.arrayTypeFromInternalType('J'));
  }

  /**
   * Test {@link InstructionUtil#arrayTypeFromInternalType(char)}.
   *
   * <ul>
   *   <li>When {@code S}.
   *   <li>Then return tab.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#arrayTypeFromInternalType(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte InstructionUtil.arrayTypeFromInternalType(char)"})
  public void testArrayTypeFromInternalType_whenS_thenReturnTab() {
    // Arrange, Act and Assert
    assertEquals('\t', InstructionUtil.arrayTypeFromInternalType('S'));
  }

  /**
   * Test {@link InstructionUtil#arrayTypeFromInternalType(char)}.
   *
   * <ul>
   *   <li>When {@code Z}.
   *   <li>Then return {@link Instruction#ARRAY_T_BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#arrayTypeFromInternalType(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte InstructionUtil.arrayTypeFromInternalType(char)"})
  public void testArrayTypeFromInternalType_whenZ_thenReturnArray_t_boolean() {
    // Arrange, Act and Assert
    assertEquals(Instruction.ARRAY_T_BOOLEAN, InstructionUtil.arrayTypeFromInternalType('Z'));
  }

  /**
   * Test {@link InstructionUtil#isStaticCall(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#isStaticCall(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionUtil.isStaticCall(byte)"})
  public void testIsStaticCall_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(InstructionUtil.isStaticCall((byte) 'A'));
  }

  /**
   * Test {@link InstructionUtil#isStaticCall(byte)}.
   *
   * <ul>
   *   <li>When {@link Instruction#OP_INVOKESTATIC}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionUtil#isStaticCall(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionUtil.isStaticCall(byte)"})
  public void testIsStaticCall_whenOp_invokestatic_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(InstructionUtil.isStaticCall(Instruction.OP_INVOKESTATIC));
  }
}
