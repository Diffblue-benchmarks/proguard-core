package proguard.classfile.instruction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodHandleConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.PackageConstant;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.instruction.visitor.InstructionCounter;
import proguard.classfile.instruction.visitor.InstructionVisitor;

public class ConstantInstructionDiffblueTest {
  /**
   * Method under test: {@link ConstantInstruction#copy(ConstantInstruction)}
   */
  @Test
  public void testCopy() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertSame(constantInstruction, constantInstruction.copy(new ConstantInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}
   */
  @Test
  public void testMayInstanceThrowExceptions() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertFalse(constantInstruction.mayInstanceThrowExceptions(new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}
   */
  @Test
  public void testMayInstanceThrowExceptions2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC;

    // Act and Assert
    assertFalse(constantInstruction.mayInstanceThrowExceptions(new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}
   */
  @Test
  public void testMayInstanceThrowExceptions3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC_W;

    // Act and Assert
    assertFalse(constantInstruction.mayInstanceThrowExceptions(new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link ConstantInstruction#mayInstanceThrowExceptions(Clazz)}
   */
  @Test
  public void testMayInstanceThrowExceptions4() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction(Instruction.OP_INVOKEINTERFACE, 1);

    // Act and Assert
    assertTrue(constantInstruction.mayInstanceThrowExceptions(new LibraryClass()));
  }

  /**
   * Method under test: {@link ConstantInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode() {
    // Arrange, Act and Assert
    assertEquals('A', (new ConstantInstruction((byte) 'A', 1)).canonicalOpcode());
  }

  /**
   * Method under test: {@link ConstantInstruction#canonicalOpcode()}
   */
  @Test
  public void testCanonicalOpcode2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC_W;

    // Act and Assert
    assertEquals(Instruction.OP_LDC, constantInstruction.canonicalOpcode());
  }

  /**
   * Method under test: {@link ConstantInstruction#shrink()}
   */
  @Test
  public void testShrink() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act
    Instruction actualShrinkResult = constantInstruction.shrink();

    // Assert
    assertEquals("lstore_2", constantInstruction.getName());
    assertEquals('A', constantInstruction.opcode);
    assertSame(constantInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link ConstantInstruction#shrink()}
   */
  @Test
  public void testShrink2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC_W;

    // Act
    Instruction actualShrinkResult = constantInstruction.shrink();

    // Assert
    assertEquals("ldc", constantInstruction.getName());
    assertEquals(Instruction.OP_LDC, constantInstruction.opcode);
    assertSame(constantInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link ConstantInstruction#shrink()}
   */
  @Test
  public void testShrink3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', -71);

    // Act and Assert
    assertSame(constantInstruction, constantInstruction.shrink());
  }

  /**
   * Method under test: {@link ConstantInstruction#shrink()}
   */
  @Test
  public void testShrink4() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction(Instruction.OP_LDC, -71);

    // Act
    Instruction actualShrinkResult = constantInstruction.shrink();

    // Assert
    assertEquals("ldc_w", constantInstruction.getName());
    assertEquals(Instruction.OP_LDC_W, constantInstruction.opcode);
    assertSame(constantInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link ConstantInstruction#shrink()}
   */
  @Test
  public void testShrink5() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction(Instruction.OP_LDC, 65535);

    // Act
    Instruction actualShrinkResult = constantInstruction.shrink();

    // Assert
    assertEquals("ldc_w", constantInstruction.getName());
    assertEquals(Instruction.OP_LDC_W, constantInstruction.opcode);
    assertSame(constantInstruction, actualShrinkResult);
  }

  /**
   * Method under test: {@link ConstantInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo() throws UnsupportedEncodingException {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act
    constantInstruction.readInfo("AXAXAXAX".getBytes("UTF-8"), 2);

    // Assert
    assertEquals(0, constantInstruction.constant);
    assertEquals(16728, constantInstruction.constantIndex);
  }

  /**
   * Method under test: {@link ConstantInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC;

    // Act
    constantInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(0, constantInstruction.constant);
    assertEquals(65, constantInstruction.constantIndex);
  }

  /**
   * Method under test: {@link ConstantInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;

    // Act
    constantInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(16728, constantInstruction.constantIndex);
    assertEquals(65, constantInstruction.constant);
  }

  /**
   * Method under test: {@link ConstantInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo4() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEDYNAMIC;

    // Act
    constantInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(16728, constantInstruction.constant);
    assertEquals(16728, constantInstruction.constantIndex);
  }

  /**
   * Method under test: {@link ConstantInstruction#readInfo(byte[], int)}
   */
  @Test
  public void testReadInfo5() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEINTERFACE;

    // Act
    constantInstruction.readInfo(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2);

    // Assert
    assertEquals(16728, constantInstruction.constant);
    assertEquals(16728, constantInstruction.constantIndex);
  }

  /**
   * Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo() throws UnsupportedEncodingException {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_ACONST_NULL, code[3]);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals('A', code[4]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_ACONST_NULL, code[2]);
    assertEquals('A', code[4]);
    assertEquals('X', code[3]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_ACONST_NULL, code[3]);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals(Instruction.OP_NOP, code[4]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo4() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEDYNAMIC;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_ACONST_NULL, code[3]);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals(Instruction.OP_NOP, code[4]);
    assertEquals(Instruction.OP_NOP, code[5]);
  }

  /**
   * Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo5() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEINTERFACE;
    byte[] code = new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_ACONST_NULL, code[3]);
    assertEquals(Instruction.OP_NOP, code[2]);
    assertEquals(Instruction.OP_NOP, code[4]);
    assertEquals(Instruction.OP_NOP, code[5]);
  }

  /**
   * Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo6() throws UnsupportedEncodingException {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', -59);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo7() throws UnsupportedEncodingException {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction(Instruction.OP_MULTIANEWARRAY, -59);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> constantInstruction.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link ConstantInstruction#writeInfo(byte[], int)}
   */
  @Test
  public void testWriteInfo8() throws UnsupportedEncodingException {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction(Instruction.OP_MULTIANEWARRAY, 65535);
    byte[] code = "AXAXAXAX".getBytes("UTF-8");

    // Act
    constantInstruction.writeInfo(code, 2);

    // Assert
    assertEquals((byte) -1, code[2]);
    assertEquals((byte) -1, code[3]);
    assertEquals(8, code.length);
    assertEquals(Instruction.OP_NOP, code[4]);
    assertEquals('X', code[5]);
  }

  /**
   * Method under test: {@link ConstantInstruction#length(int)}
   */
  @Test
  public void testLength() {
    // Arrange, Act and Assert
    assertEquals(3, (new ConstantInstruction((byte) 'A', 1)).length(2));
  }

  /**
   * Method under test: {@link ConstantInstruction#length(int)}
   */
  @Test
  public void testLength2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_LDC;

    // Act and Assert
    assertEquals(2, constantInstruction.length(2));
  }

  /**
   * Method under test: {@link ConstantInstruction#length(int)}
   */
  @Test
  public void testLength3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;

    // Act and Assert
    assertEquals(4, constantInstruction.length(2));
  }

  /**
   * Method under test: {@link ConstantInstruction#length(int)}
   */
  @Test
  public void testLength4() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEDYNAMIC;

    // Act and Assert
    assertEquals(5, constantInstruction.length(2));
  }

  /**
   * Method under test: {@link ConstantInstruction#length(int)}
   */
  @Test
  public void testLength5() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEINTERFACE;

    // Act and Assert
    assertEquals(5, constantInstruction.length(2));
  }

  /**
   * Method under test:
   * {@link ConstantInstruction#accept(Clazz, Method, CodeAttribute, int, InstructionVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    InstructionCounter instructionVisitor = new InstructionCounter();

    // Act
    constantInstruction.accept(clazz, method, codeAttribute, 2, instructionVisitor);

    // Assert
    assertEquals(1, instructionVisitor.getCount());
  }

  /**
   * Method under test: {@link ConstantInstruction#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("lstore_2 #1", (new ConstantInstruction((byte) 'A', 1)).toString());
  }

  /**
   * Method under test: {@link ConstantInstruction#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;

    // Act and Assert
    assertEquals("multianewarray #1, 0", constantInstruction.toString());
  }

  /**
   * Method under test: {@link ConstantInstruction#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEDYNAMIC;

    // Act and Assert
    assertEquals("invokedynamic #1, 0", constantInstruction.toString());
  }

  /**
   * Method under test: {@link ConstantInstruction#toString()}
   */
  @Test
  public void testToString4() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEINTERFACE;

    // Act and Assert
    assertEquals("invokeinterface #1, 0", constantInstruction.toString());
  }

  /**
   * Method under test: {@link ConstantInstruction#toString(Clazz, int)}
   */
  @Test
  public void testToString5() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals("[2] lstore_2 #1 = ", constantInstruction.toString(new LibraryClass(), 2));
  }

  /**
   * Method under test: {@link ConstantInstruction#toString(Clazz, int)}
   */
  @Test
  public void testToString6() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;

    // Act and Assert
    assertEquals("[2] multianewarray #1, 0 = ", constantInstruction.toString(new LibraryClass(), 2));
  }

  /**
   * Method under test: {@link ConstantInstruction#toString(Clazz, int)}
   */
  @Test
  public void testToString7() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEDYNAMIC;

    // Act and Assert
    assertEquals("[2] invokedynamic #1, 0 = ", constantInstruction.toString(new LibraryClass(), 2));
  }

  /**
   * Method under test: {@link ConstantInstruction#toString(Clazz, int)}
   */
  @Test
  public void testToString8() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEINTERFACE;

    // Act and Assert
    assertEquals("[2] invokeinterface #1, 0 = ", constantInstruction.toString(new LibraryClass(), 2));
  }

  /**
   * Method under test: {@link ConstantInstruction#stackPopCount(Clazz)}
   */
  @Test
  public void testStackPopCount() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(2, constantInstruction.stackPopCount(new LibraryClass()));
  }

  /**
   * Method under test: {@link ConstantInstruction#stackPopCount(Clazz)}
   */
  @Test
  public void testStackPopCount2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_PUTSTATIC;

    // Act and Assert
    assertEquals(0, constantInstruction.stackPopCount(new LibraryClass()));
  }

  /**
   * Method under test: {@link ConstantInstruction#stackPopCount(Clazz)}
   */
  @Test
  public void testStackPopCount3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_INVOKEVIRTUAL;

    // Act and Assert
    assertEquals(1, constantInstruction.stackPopCount(new LibraryClass()));
  }

  /**
   * Method under test: {@link ConstantInstruction#stackPopCount(Clazz)}
   */
  @Test
  public void testStackPopCount4() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_MULTIANEWARRAY;

    // Act and Assert
    assertEquals(0, constantInstruction.stackPopCount(new LibraryClass()));
  }

  /**
   * Method under test: {@link ConstantInstruction#stackPushCount(Clazz)}
   */
  @Test
  public void testStackPushCount() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(0, constantInstruction.stackPushCount(new LibraryClass()));
  }

  /**
   * Method under test: {@link ConstantInstruction#stackPushCount(Clazz)}
   */
  @Test
  public void testStackPushCount2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    constantInstruction.opcode = Instruction.OP_GETSTATIC;

    // Act and Assert
    assertEquals(0, constantInstruction.stackPushCount(new LibraryClass()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConstantInstruction#equals(Object)}
   *   <li>{@link ConstantInstruction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);
    ConstantInstruction constantInstruction2 = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(constantInstruction, constantInstruction2);
    int expectedHashCodeResult = constantInstruction.hashCode();
    assertEquals(expectedHashCodeResult, constantInstruction2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConstantInstruction#equals(Object)}
   *   <li>{@link ConstantInstruction#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1);

    // Act and Assert
    assertEquals(constantInstruction, constantInstruction);
    int expectedHashCodeResult = constantInstruction.hashCode();
    assertEquals(expectedHashCodeResult, constantInstruction.hashCode());
  }

  /**
   * Method under test: {@link ConstantInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction(Instruction.OP_ACONST_NULL, 1);

    // Act and Assert
    assertNotEquals(constantInstruction, new ConstantInstruction((byte) 'A', 1));
  }

  /**
   * Method under test: {@link ConstantInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 65);

    // Act and Assert
    assertNotEquals(constantInstruction, new ConstantInstruction((byte) 'A', 1));
  }

  /**
   * Method under test: {@link ConstantInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 'A', 1, 65);

    // Act and Assert
    assertNotEquals(constantInstruction, new ConstantInstruction((byte) 'A', 1));
  }

  /**
   * Method under test: {@link ConstantInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConstantInstruction((byte) 'A', 1), null);
  }

  /**
   * Method under test: {@link ConstantInstruction#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConstantInstruction((byte) 'A', 1), "Different type to ConstantInstruction");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConstantInstruction#ConstantInstruction()}
   *   <li>{@link ConstantInstruction#visitClassConstant(Clazz, ClassConstant)}
   *   <li>{@link ConstantInstruction#visitDoubleConstant(Clazz, DoubleConstant)}
   *   <li>{@link ConstantInstruction#visitFloatConstant(Clazz, FloatConstant)}
   *   <li>{@link ConstantInstruction#visitIntegerConstant(Clazz, IntegerConstant)}
   *   <li>{@link ConstantInstruction#visitLongConstant(Clazz, LongConstant)}
   *   <li>
   * {@link ConstantInstruction#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   *   <li>
   * {@link ConstantInstruction#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   *   <li>{@link ConstantInstruction#visitModuleConstant(Clazz, ModuleConstant)}
   *   <li>{@link ConstantInstruction#visitPackageConstant(Clazz, PackageConstant)}
   *   <li>
   * {@link ConstantInstruction#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}
   *   <li>{@link ConstantInstruction#visitStringConstant(Clazz, StringConstant)}
   *   <li>{@link ConstantInstruction#visitUtf8Constant(Clazz, Utf8Constant)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ConstantInstruction actualConstantInstruction = new ConstantInstruction();
    LibraryClass clazz = new LibraryClass();
    actualConstantInstruction.visitClassConstant(clazz, new ClassConstant());
    LibraryClass clazz2 = new LibraryClass();
    actualConstantInstruction.visitDoubleConstant(clazz2, new DoubleConstant(10.0d));
    LibraryClass clazz3 = new LibraryClass();
    actualConstantInstruction.visitFloatConstant(clazz3, new FloatConstant(10.0f));
    LibraryClass clazz4 = new LibraryClass();
    actualConstantInstruction.visitIntegerConstant(clazz4, new IntegerConstant(42));
    LibraryClass clazz5 = new LibraryClass();
    actualConstantInstruction.visitLongConstant(clazz5, new LongConstant(42L));
    LibraryClass clazz6 = new LibraryClass();
    actualConstantInstruction.visitMethodHandleConstant(clazz6, new MethodHandleConstant(1, 1));
    LibraryClass clazz7 = new LibraryClass();
    actualConstantInstruction.visitMethodTypeConstant(clazz7, new MethodTypeConstant());
    LibraryClass clazz8 = new LibraryClass();
    actualConstantInstruction.visitModuleConstant(clazz8, new ModuleConstant(1));
    LibraryClass clazz9 = new LibraryClass();
    actualConstantInstruction.visitPackageConstant(clazz9, new PackageConstant(1));
    LibraryClass clazz10 = new LibraryClass();
    actualConstantInstruction.visitPrimitiveArrayConstant(clazz10, new PrimitiveArrayConstant());
    LibraryClass clazz11 = new LibraryClass();
    actualConstantInstruction.visitStringConstant(clazz11, new StringConstant());
    LibraryClass clazz12 = new LibraryClass();
    actualConstantInstruction.visitUtf8Constant(clazz12, new Utf8Constant("String"));

    // Assert that nothing has changed
    assertEquals("nop", actualConstantInstruction.getName());
    assertEquals(0, actualConstantInstruction.constant);
    assertEquals(0, actualConstantInstruction.constantIndex);
    assertFalse(actualConstantInstruction.isCategory2());
    assertFalse(actualConstantInstruction.isWide());
    assertEquals(Instruction.OP_NOP, actualConstantInstruction.opcode);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConstantInstruction#ConstantInstruction(byte, int)}
   *   <li>{@link ConstantInstruction#visitClassConstant(Clazz, ClassConstant)}
   *   <li>{@link ConstantInstruction#visitDoubleConstant(Clazz, DoubleConstant)}
   *   <li>{@link ConstantInstruction#visitFloatConstant(Clazz, FloatConstant)}
   *   <li>{@link ConstantInstruction#visitIntegerConstant(Clazz, IntegerConstant)}
   *   <li>{@link ConstantInstruction#visitLongConstant(Clazz, LongConstant)}
   *   <li>
   * {@link ConstantInstruction#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   *   <li>
   * {@link ConstantInstruction#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   *   <li>{@link ConstantInstruction#visitModuleConstant(Clazz, ModuleConstant)}
   *   <li>{@link ConstantInstruction#visitPackageConstant(Clazz, PackageConstant)}
   *   <li>
   * {@link ConstantInstruction#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}
   *   <li>{@link ConstantInstruction#visitStringConstant(Clazz, StringConstant)}
   *   <li>{@link ConstantInstruction#visitUtf8Constant(Clazz, Utf8Constant)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    ConstantInstruction actualConstantInstruction = new ConstantInstruction((byte) 'A', 1);
    LibraryClass clazz = new LibraryClass();
    actualConstantInstruction.visitClassConstant(clazz, new ClassConstant());
    LibraryClass clazz2 = new LibraryClass();
    actualConstantInstruction.visitDoubleConstant(clazz2, new DoubleConstant(10.0d));
    LibraryClass clazz3 = new LibraryClass();
    actualConstantInstruction.visitFloatConstant(clazz3, new FloatConstant(10.0f));
    LibraryClass clazz4 = new LibraryClass();
    actualConstantInstruction.visitIntegerConstant(clazz4, new IntegerConstant(42));
    LibraryClass clazz5 = new LibraryClass();
    actualConstantInstruction.visitLongConstant(clazz5, new LongConstant(42L));
    LibraryClass clazz6 = new LibraryClass();
    actualConstantInstruction.visitMethodHandleConstant(clazz6, new MethodHandleConstant(1, 1));
    LibraryClass clazz7 = new LibraryClass();
    actualConstantInstruction.visitMethodTypeConstant(clazz7, new MethodTypeConstant());
    LibraryClass clazz8 = new LibraryClass();
    actualConstantInstruction.visitModuleConstant(clazz8, new ModuleConstant(1));
    LibraryClass clazz9 = new LibraryClass();
    actualConstantInstruction.visitPackageConstant(clazz9, new PackageConstant(1));
    LibraryClass clazz10 = new LibraryClass();
    actualConstantInstruction.visitPrimitiveArrayConstant(clazz10, new PrimitiveArrayConstant());
    LibraryClass clazz11 = new LibraryClass();
    actualConstantInstruction.visitStringConstant(clazz11, new StringConstant());
    LibraryClass clazz12 = new LibraryClass();
    actualConstantInstruction.visitUtf8Constant(clazz12, new Utf8Constant("String"));

    // Assert that nothing has changed
    assertEquals("lstore_2", actualConstantInstruction.getName());
    assertEquals(0, actualConstantInstruction.constant);
    assertEquals(1, actualConstantInstruction.constantIndex);
    assertFalse(actualConstantInstruction.isWide());
    assertTrue(actualConstantInstruction.isCategory2());
    assertEquals('A', actualConstantInstruction.opcode);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConstantInstruction#ConstantInstruction(byte, int, int)}
   *   <li>{@link ConstantInstruction#visitClassConstant(Clazz, ClassConstant)}
   *   <li>{@link ConstantInstruction#visitDoubleConstant(Clazz, DoubleConstant)}
   *   <li>{@link ConstantInstruction#visitFloatConstant(Clazz, FloatConstant)}
   *   <li>{@link ConstantInstruction#visitIntegerConstant(Clazz, IntegerConstant)}
   *   <li>{@link ConstantInstruction#visitLongConstant(Clazz, LongConstant)}
   *   <li>
   * {@link ConstantInstruction#visitMethodHandleConstant(Clazz, MethodHandleConstant)}
   *   <li>
   * {@link ConstantInstruction#visitMethodTypeConstant(Clazz, MethodTypeConstant)}
   *   <li>{@link ConstantInstruction#visitModuleConstant(Clazz, ModuleConstant)}
   *   <li>{@link ConstantInstruction#visitPackageConstant(Clazz, PackageConstant)}
   *   <li>
   * {@link ConstantInstruction#visitPrimitiveArrayConstant(Clazz, PrimitiveArrayConstant)}
   *   <li>{@link ConstantInstruction#visitStringConstant(Clazz, StringConstant)}
   *   <li>{@link ConstantInstruction#visitUtf8Constant(Clazz, Utf8Constant)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters3() {
    // Arrange and Act
    ConstantInstruction actualConstantInstruction = new ConstantInstruction((byte) 'A', 1, 1);
    LibraryClass clazz = new LibraryClass();
    actualConstantInstruction.visitClassConstant(clazz, new ClassConstant());
    LibraryClass clazz2 = new LibraryClass();
    actualConstantInstruction.visitDoubleConstant(clazz2, new DoubleConstant(10.0d));
    LibraryClass clazz3 = new LibraryClass();
    actualConstantInstruction.visitFloatConstant(clazz3, new FloatConstant(10.0f));
    LibraryClass clazz4 = new LibraryClass();
    actualConstantInstruction.visitIntegerConstant(clazz4, new IntegerConstant(42));
    LibraryClass clazz5 = new LibraryClass();
    actualConstantInstruction.visitLongConstant(clazz5, new LongConstant(42L));
    LibraryClass clazz6 = new LibraryClass();
    actualConstantInstruction.visitMethodHandleConstant(clazz6, new MethodHandleConstant(1, 1));
    LibraryClass clazz7 = new LibraryClass();
    actualConstantInstruction.visitMethodTypeConstant(clazz7, new MethodTypeConstant());
    LibraryClass clazz8 = new LibraryClass();
    actualConstantInstruction.visitModuleConstant(clazz8, new ModuleConstant(1));
    LibraryClass clazz9 = new LibraryClass();
    actualConstantInstruction.visitPackageConstant(clazz9, new PackageConstant(1));
    LibraryClass clazz10 = new LibraryClass();
    actualConstantInstruction.visitPrimitiveArrayConstant(clazz10, new PrimitiveArrayConstant());
    LibraryClass clazz11 = new LibraryClass();
    actualConstantInstruction.visitStringConstant(clazz11, new StringConstant());
    LibraryClass clazz12 = new LibraryClass();
    actualConstantInstruction.visitUtf8Constant(clazz12, new Utf8Constant("String"));

    // Assert that nothing has changed
    assertEquals("lstore_2", actualConstantInstruction.getName());
    assertEquals(1, actualConstantInstruction.constant);
    assertEquals(1, actualConstantInstruction.constantIndex);
    assertFalse(actualConstantInstruction.isWide());
    assertTrue(actualConstantInstruction.isCategory2());
    assertEquals('A', actualConstantInstruction.opcode);
  }
}
