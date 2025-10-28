package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.TableSwitchInstruction;
import proguard.classfile.instruction.VariableInstruction;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.resources.file.ResourceFile;

public class CompactCodeAttributeComposerDiffblueTest {
  /**
   * Method under test: {@link CompactCodeAttributeComposer#getTargetClass()}
   */
  @Test
  public void testGetTargetClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass, (new CompactCodeAttributeComposer(targetClass)).getTargetClass());
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#getCodeLength()}
   */
  @Test
  public void testGetCodeLength() {
    // Arrange, Act and Assert
    assertEquals(0, (new CompactCodeAttributeComposer(new ProgramClass())).getCodeLength());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  public void testConvertToTargetType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(90, 1, new Constant[]{new ClassConstant()}, 90, 90, 90));

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult = compactCodeAttributeComposer
        .convertToTargetType("Source Type", "Target Type");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertToTargetTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  public void testConvertToTargetType2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(90, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 90, 90, 90));

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult = compactCodeAttributeComposer
        .convertToTargetType("Source Type", "Target Type");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertToTargetTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  public void testConvertToTargetType3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(90, 3, new Constant[]{new ClassConstant()}, 90, 90, 90));

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult = compactCodeAttributeComposer
        .convertToTargetType("java/lang/Short", "Target Type");

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertToTargetTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  public void testConvertToTargetType4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(90, 3, new Constant[]{new ClassConstant()}, 90, 90, 90));

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult = compactCodeAttributeComposer
        .convertToTargetType("(S)Ljava/lang/Short;", "Target Type");

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertToTargetTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  public void testConvertToTargetType5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(90, 1, new Constant[]{new ClassConstant()}, 90, 90, 90));
    compactCodeAttributeComposer.putstatic("(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;");

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult = compactCodeAttributeComposer
        .convertToTargetType("Source Type", "Target Type");

    // Assert
    assertEquals(6, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertToTargetTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  public void testConvertToTargetType6() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(90, 1, new Constant[]{new ClassConstant()}, 90, 90, 90));
    compactCodeAttributeComposer.putstatic("java/lang/Short", "java/lang/Short", "java/lang/Short");
    compactCodeAttributeComposer.putstatic("(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;");

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult = compactCodeAttributeComposer
        .convertToTargetType("Source Type", "Target Type");

    // Assert
    assertEquals(9, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertToTargetTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  public void testConvertToTargetType7() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(90, 1, new Constant[]{new ClassConstant()}, 90, 90, 90));
    compactCodeAttributeComposer.putstatic("(S)Ljava/lang/Short;", "valueOf", "(S)Ljava/lang/Short;");

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult = compactCodeAttributeComposer
        .convertToTargetType("Source Type", "Target Type");

    // Assert
    assertEquals(6, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertToTargetTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#boxPrimitiveType(char)}
   */
  @Test
  public void testBoxPrimitiveType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.boxPrimitiveType('A'));
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('A', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('S', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('B', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('C', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('D', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType6() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('F', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType7() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('J', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType8() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('S', 'S');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType9() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('S', 'D');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType10() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('S', 'F');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType11() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('S', 'B');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType12() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('S', 'C');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  public void testConvertPrimitiveType13() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult = compactCodeAttributeComposer
        .convertPrimitiveType('S', 'J');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}
   */
  @Test
  public void testUnboxPrimitiveType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(compactCodeAttributeComposer,
        compactCodeAttributeComposer.unboxPrimitiveType("Source Type", "Target Type"));
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}
   */
  @Test
  public void testUnboxPrimitiveType2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(66, 1, new Constant[]{new ClassConstant()}, 66, 66, 66));

    // Act
    CompactCodeAttributeComposer actualUnboxPrimitiveTypeResult = compactCodeAttributeComposer
        .unboxPrimitiveType("Source Type", "Source Type");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualUnboxPrimitiveTypeResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}
   */
  @Test
  public void testUnboxPrimitiveType3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(66, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 66, 66, 66));

    // Act
    CompactCodeAttributeComposer actualUnboxPrimitiveTypeResult = compactCodeAttributeComposer
        .unboxPrimitiveType("Source Type", "Source Type");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualUnboxPrimitiveTypeResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#reset()}
   */
  @Test
  public void testReset() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.reset());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#beginCodeFragment(int)}
   */
  @Test
  public void testBeginCodeFragment() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.beginCodeFragment(3));
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#beginCodeFragment(int)}
   */
  @Test
  public void testBeginCodeFragment2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(compactCodeAttributeComposer,
        compactCodeAttributeComposer.beginCodeFragment(ClassEstimates.TYPICAL_CODE_LENGTH));
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult = compactCodeAttributeComposer
        .appendInstructions(new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult = compactCodeAttributeComposer
        .appendInstructions(new Instruction[]{new ConstantInstruction((byte) 'A', 1)});

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult = compactCodeAttributeComposer.appendInstructions(
        new Instruction[]{new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 2, 1, 2}, new int[]{1, 2, 1, 2})});

    // Assert
    assertEquals(44, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult = compactCodeAttributeComposer
        .appendInstructions(new Instruction[]{new SimpleInstruction((byte) 'A')});

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult = compactCodeAttributeComposer
        .appendInstructions(new Instruction[]{new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[]{1, 2, 1, 2})});

    // Assert
    assertEquals(20, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions6() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult = compactCodeAttributeComposer
        .appendInstructions(new Instruction[]{new VariableInstruction((byte) 'A')});

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions7() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult = compactCodeAttributeComposer
        .appendInstructions(new Instruction[]{new VariableInstruction()});

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions8() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());
    BranchInstruction branchInstruction = new BranchInstruction((byte) -89, Integer.MIN_VALUE);

    Instruction[] instructions = new Instruction[]{branchInstruction};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult = compactCodeAttributeComposer
        .appendInstructions(instructions);

    // Assert
    assertEquals(1, instructions.length);
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionsResult);
    assertSame(branchInstruction, instructions[0]);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult = compactCodeAttributeComposer
        .appendInstruction(new BranchInstruction((byte) 'A', 1));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult = compactCodeAttributeComposer
        .appendInstruction(new ConstantInstruction((byte) 'A', 1));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult = compactCodeAttributeComposer
        .appendInstruction(new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 2, 1, 2}, new int[]{1, 2, 1, 2}));

    // Assert
    assertEquals(44, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult = compactCodeAttributeComposer
        .appendInstruction(new SimpleInstruction((byte) 'A'));

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult = compactCodeAttributeComposer
        .appendInstruction(new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[]{1, 2, 1, 2}));

    // Assert
    assertEquals(20, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction6() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult = compactCodeAttributeComposer
        .appendInstruction(new VariableInstruction((byte) 'A'));

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction7() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult = compactCodeAttributeComposer
        .appendInstruction(new VariableInstruction());

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction8() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());
    BranchInstruction instruction = new BranchInstruction((byte) -89, Integer.MIN_VALUE);

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult = compactCodeAttributeComposer
        .appendInstruction(instruction);

    // Assert
    assertEquals("goto_w", instruction.getName());
    assertEquals((byte) -56, instruction.opcode);
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendInstructionResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#nop()}
   */
  @Test
  public void testNop() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNopResult = compactCodeAttributeComposer.nop();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNopResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#aconst_null()}
   */
  @Test
  public void testAconst_null() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAconst_nullResult = compactCodeAttributeComposer.aconst_null();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAconst_nullResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iconst(int)}
   */
  @Test
  public void testIconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconstResult = compactCodeAttributeComposer.iconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iconst(int)}
   */
  @Test
  public void testIconst2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconstResult = compactCodeAttributeComposer.iconst(6);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iconst(int)}
   */
  @Test
  public void testIconst3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconstResult = compactCodeAttributeComposer.iconst(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iconst_m1()}
   */
  @Test
  public void testIconst_m1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_m1Result = compactCodeAttributeComposer.iconst_m1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_m1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iconst_0()}
   */
  @Test
  public void testIconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_0Result = compactCodeAttributeComposer.iconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iconst_1()}
   */
  @Test
  public void testIconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_1Result = compactCodeAttributeComposer.iconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iconst_2()}
   */
  @Test
  public void testIconst_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_2Result = compactCodeAttributeComposer.iconst_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iconst_3()}
   */
  @Test
  public void testIconst_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_3Result = compactCodeAttributeComposer.iconst_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_3Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iconst_4()}
   */
  @Test
  public void testIconst_4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_4Result = compactCodeAttributeComposer.iconst_4();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_4Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iconst_5()}
   */
  @Test
  public void testIconst_5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_5Result = compactCodeAttributeComposer.iconst_5();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_5Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  public void testLconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  public void testLconst2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(0);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  public void testLconst3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(7);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  public void testLconst4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(8);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lconst_0()}
   */
  @Test
  public void testLconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconst_0Result = compactCodeAttributeComposer.lconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconst_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lconst_1()}
   */
  @Test
  public void testLconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconst_1Result = compactCodeAttributeComposer.lconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconst_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fconst(int)}
   */
  @Test
  public void testFconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconstResult = compactCodeAttributeComposer.fconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fconst(int)}
   */
  @Test
  public void testFconst2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconstResult = compactCodeAttributeComposer.fconst(5);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fconst(int)}
   */
  @Test
  public void testFconst3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconstResult = compactCodeAttributeComposer.fconst(6);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fconst_0()}
   */
  @Test
  public void testFconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconst_0Result = compactCodeAttributeComposer.fconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconst_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fconst_1()}
   */
  @Test
  public void testFconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconst_1Result = compactCodeAttributeComposer.fconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconst_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fconst_2()}
   */
  @Test
  public void testFconst_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconst_2Result = compactCodeAttributeComposer.fconst_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconst_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  public void testDconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  public void testDconst2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(2);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  public void testDconst3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(3);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  public void testDconst4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(0);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dconst_0()}
   */
  @Test
  public void testDconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconst_0Result = compactCodeAttributeComposer.dconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconst_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dconst_1()}
   */
  @Test
  public void testDconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconst_1Result = compactCodeAttributeComposer.dconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconst_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#bipush(int)}
   */
  @Test
  public void testBipush() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBipushResult = compactCodeAttributeComposer.bipush(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBipushResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#bipush(int)}
   */
  @Test
  public void testBipush2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBipushResult = compactCodeAttributeComposer
        .bipush(ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBipushResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#bipush(int)}
   */
  @Test
  public void testBipush3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBipushResult = compactCodeAttributeComposer.bipush(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBipushResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#sipush(int)}
   */
  @Test
  public void testSipush() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSipushResult = compactCodeAttributeComposer.sipush(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSipushResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#sipush(int)}
   */
  @Test
  public void testSipush2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSipushResult = compactCodeAttributeComposer.sipush(17);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSipushResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#sipush(int)}
   */
  @Test
  public void testSipush3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSipushResult = compactCodeAttributeComposer.sipush(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSipushResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(float)}
   */
  @Test
  public void testLdc() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(4, 1, new Constant[]{new ClassConstant()}, 4, 4, 4));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc(10.0f);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(float)}
   */
  @Test
  public void testLdc2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(4, 0, new Constant[]{new ClassConstant()}, 4, 4, 4));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc(10.0f);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(float)}
   */
  @Test
  public void testLdc3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(4, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 4, 4, 4));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc(10.0f);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(int)}
   */
  @Test
  public void testLdc4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(3, 1, new Constant[]{new ClassConstant()}, 3, 3, 3));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc(42);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(int)}
   */
  @Test
  public void testLdc5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(3, 0, new Constant[]{new ClassConstant()}, 3, 3, 3));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc(42);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(int)}
   */
  @Test
  public void testLdc6() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(3, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 3, 3, 3));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc(42);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(Object)}
   */
  @Test
  public void testLdc7() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(99, 1, new Constant[]{new ClassConstant()}, 99, 99, 99));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc((Object) "Primitive Array");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(Object)}
   */
  @Test
  public void testLdc8() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(99, 0, new Constant[]{new ClassConstant()}, 99, 99, 99));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc((Object) "Primitive Array");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(Object)}
   */
  @Test
  public void testLdc9() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(99, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 99, 99, 99));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc((Object) "Primitive Array");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(String)}
   */
  @Test
  public void testLdc10() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc("String");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(String)}
   */
  @Test
  public void testLdc11() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc("String");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(String, Clazz)}
   */
  @Test
  public void testLdc12() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc("Type Name", new LibraryClass());

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(String, Clazz)}
   */
  @Test
  public void testLdc13() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc("Type Name", new LibraryClass());

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#ldc(String, Clazz, Member)}
   */
  @Test
  public void testLdc14() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#ldc(String, Clazz, Member)}
   */
  @Test
  public void testLdc15() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#ldc(String, ResourceFile)}
   */
  @Test
  public void testLdc16() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc("String",
        new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#ldc(String, ResourceFile)}
   */
  @Test
  public void testLdc17() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc("String",
        new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(Clazz)}
   */
  @Test
  public void testLdc18() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc((Clazz) new LibraryClass());

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(Clazz, Member)}
   */
  @Test
  public void testLdc19() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(Clazz, Member)}
   */
  @Test
  public void testLdc20() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(ResourceFile)}
   */
  @Test
  public void testLdc21() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc(new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc(ResourceFile)}
   */
  @Test
  public void testLdc22() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdcResult = compactCodeAttributeComposer.ldc(new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_(int)}
   */
  @Test
  public void testLdc_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_Result = compactCodeAttributeComposer.ldc_(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_(int)}
   */
  @Test
  public void testLdc_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_Result = compactCodeAttributeComposer
        .ldc_(ClassEstimates.TYPICAL_CODE_LENGTH);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(float)}
   */
  @Test
  public void testLdc_w() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(4, 1, new Constant[]{new ClassConstant()}, 4, 4, 4));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w(10.0f);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(float)}
   */
  @Test
  public void testLdc_w2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(4, 0, new Constant[]{new ClassConstant()}, 4, 4, 4));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w(10.0f);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(float)}
   */
  @Test
  public void testLdc_w3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(4, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 4, 4, 4));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w(10.0f);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(int)}
   */
  @Test
  public void testLdc_w4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(3, 1, new Constant[]{new ClassConstant()}, 3, 3, 3));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w(42);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(int)}
   */
  @Test
  public void testLdc_w5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(3, 0, new Constant[]{new ClassConstant()}, 3, 3, 3));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w(42);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(int)}
   */
  @Test
  public void testLdc_w6() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(3, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 3, 3, 3));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w(42);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(Object)}
   */
  @Test
  public void testLdc_w7() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(99, 1, new Constant[]{new ClassConstant()}, 99, 99, 99));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w((Object) "Primitive Array");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(Object)}
   */
  @Test
  public void testLdc_w8() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(99, 0, new Constant[]{new ClassConstant()}, 99, 99, 99));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w((Object) "Primitive Array");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(Object)}
   */
  @Test
  public void testLdc_w9() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(99, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 99, 99, 99));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w((Object) "Primitive Array");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(String)}
   */
  @Test
  public void testLdc_w10() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w("String");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(String)}
   */
  @Test
  public void testLdc_w11() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w("String");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, Clazz)}
   */
  @Test
  public void testLdc_w12() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w("Type Name",
        new LibraryClass());

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, Clazz)}
   */
  @Test
  public void testLdc_w13() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w("Type Name",
        new LibraryClass());

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#ldc_w(String, Clazz, Member)}
   */
  @Test
  public void testLdc_w14() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#ldc_w(String, Clazz, Member)}
   */
  @Test
  public void testLdc_w15() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w("String", referencedClass,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#ldc_w(String, ResourceFile)}
   */
  @Test
  public void testLdc_w16() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w("String",
        new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#ldc_w(String, ResourceFile)}
   */
  @Test
  public void testLdc_w17() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w("String",
        new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(Clazz)}
   */
  @Test
  public void testLdc_w18() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w((Clazz) new LibraryClass());

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(Clazz, Member)}
   */
  @Test
  public void testLdc_w19() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(Clazz, Member)}
   */
  @Test
  public void testLdc_w20() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer.ldc_w(clazz,
        new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(ResourceFile)}
   */
  @Test
  public void testLdc_w21() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer
        .ldc_w(new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w(ResourceFile)}
   */
  @Test
  public void testLdc_w22() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult = compactCodeAttributeComposer
        .ldc_w(new ResourceFile("foo.txt", 3L));

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w_(int)}
   */
  @Test
  public void testLdc_w_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_w_Result = compactCodeAttributeComposer.ldc_w_(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_w_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc_w_(int)}
   */
  @Test
  public void testLdc_w_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_w_Result = compactCodeAttributeComposer
        .ldc_w_(ClassEstimates.TYPICAL_CODE_LENGTH);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_w_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc2_w(double)}
   */
  @Test
  public void testLdc2_w() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(6, 1, new Constant[]{new ClassConstant()}, 6, 6, 6));

    // Act
    CompactCodeAttributeComposer actualLdc2_wResult = compactCodeAttributeComposer.ldc2_w(10.0d);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc2_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc2_w(double)}
   */
  @Test
  public void testLdc2_w2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(6, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 6, 6, 6));

    // Act
    CompactCodeAttributeComposer actualLdc2_wResult = compactCodeAttributeComposer.ldc2_w(10.0d);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc2_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc2_w(int)}
   */
  @Test
  public void testLdc2_w3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc2_wResult = compactCodeAttributeComposer.ldc2_w(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc2_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc2_w(long)}
   */
  @Test
  public void testLdc2_w4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(5, 1, new Constant[]{new ClassConstant()}, 5, 5, 5));

    // Act
    CompactCodeAttributeComposer actualLdc2_wResult = compactCodeAttributeComposer.ldc2_w(42L);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc2_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldc2_w(long)}
   */
  @Test
  public void testLdc2_w5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(5, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 5, 5, 5));

    // Act
    CompactCodeAttributeComposer actualLdc2_wResult = compactCodeAttributeComposer.ldc2_w(42L);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc2_wResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iload(int)}
   */
  @Test
  public void testIload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIloadResult = compactCodeAttributeComposer.iload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iload(int)}
   */
  @Test
  public void testIload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIloadResult = compactCodeAttributeComposer.iload(21);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lload(int)}
   */
  @Test
  public void testLload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLloadResult = compactCodeAttributeComposer.lload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lload(int)}
   */
  @Test
  public void testLload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLloadResult = compactCodeAttributeComposer.lload(22);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fload(int)}
   */
  @Test
  public void testFload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFloadResult = compactCodeAttributeComposer.fload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fload(int)}
   */
  @Test
  public void testFload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFloadResult = compactCodeAttributeComposer.fload(23);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dload(int)}
   */
  @Test
  public void testDload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDloadResult = compactCodeAttributeComposer.dload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dload(int)}
   */
  @Test
  public void testDload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDloadResult = compactCodeAttributeComposer.dload(24);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#aload(int)}
   */
  @Test
  public void testAload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAloadResult = compactCodeAttributeComposer.aload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#aload(int)}
   */
  @Test
  public void testAload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAloadResult = compactCodeAttributeComposer.aload(25);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iload_0()}
   */
  @Test
  public void testIload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_0Result = compactCodeAttributeComposer.iload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iload_1()}
   */
  @Test
  public void testIload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_1Result = compactCodeAttributeComposer.iload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iload_2()}
   */
  @Test
  public void testIload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_2Result = compactCodeAttributeComposer.iload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iload_3()}
   */
  @Test
  public void testIload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_3Result = compactCodeAttributeComposer.iload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_3Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lload_0()}
   */
  @Test
  public void testLload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_0Result = compactCodeAttributeComposer.lload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lload_1()}
   */
  @Test
  public void testLload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_1Result = compactCodeAttributeComposer.lload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lload_2()}
   */
  @Test
  public void testLload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_2Result = compactCodeAttributeComposer.lload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lload_3()}
   */
  @Test
  public void testLload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_3Result = compactCodeAttributeComposer.lload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_3Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fload_0()}
   */
  @Test
  public void testFload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_0Result = compactCodeAttributeComposer.fload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fload_1()}
   */
  @Test
  public void testFload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_1Result = compactCodeAttributeComposer.fload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fload_2()}
   */
  @Test
  public void testFload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_2Result = compactCodeAttributeComposer.fload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fload_3()}
   */
  @Test
  public void testFload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_3Result = compactCodeAttributeComposer.fload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_3Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dload_0()}
   */
  @Test
  public void testDload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_0Result = compactCodeAttributeComposer.dload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dload_1()}
   */
  @Test
  public void testDload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_1Result = compactCodeAttributeComposer.dload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dload_2()}
   */
  @Test
  public void testDload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_2Result = compactCodeAttributeComposer.dload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dload_3()}
   */
  @Test
  public void testDload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_3Result = compactCodeAttributeComposer.dload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_3Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#aload_0()}
   */
  @Test
  public void testAload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_0Result = compactCodeAttributeComposer.aload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#aload_1()}
   */
  @Test
  public void testAload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_1Result = compactCodeAttributeComposer.aload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#aload_2()}
   */
  @Test
  public void testAload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_2Result = compactCodeAttributeComposer.aload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#aload_3()}
   */
  @Test
  public void testAload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_3Result = compactCodeAttributeComposer.aload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_3Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iaload()}
   */
  @Test
  public void testIaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIaloadResult = compactCodeAttributeComposer.iaload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIaloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#laload()}
   */
  @Test
  public void testLaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLaloadResult = compactCodeAttributeComposer.laload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLaloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#faload()}
   */
  @Test
  public void testFaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFaloadResult = compactCodeAttributeComposer.faload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFaloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#daload()}
   */
  @Test
  public void testDaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDaloadResult = compactCodeAttributeComposer.daload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDaloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#aaload()}
   */
  @Test
  public void testAaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAaloadResult = compactCodeAttributeComposer.aaload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAaloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#baload()}
   */
  @Test
  public void testBaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBaloadResult = compactCodeAttributeComposer.baload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBaloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#caload()}
   */
  @Test
  public void testCaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCaloadResult = compactCodeAttributeComposer.caload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCaloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#saload()}
   */
  @Test
  public void testSaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSaloadResult = compactCodeAttributeComposer.saload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSaloadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#istore(int)}
   */
  @Test
  public void testIstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstoreResult = compactCodeAttributeComposer.istore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#istore(int)}
   */
  @Test
  public void testIstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstoreResult = compactCodeAttributeComposer.istore(54);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lstore(int)}
   */
  @Test
  public void testLstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstoreResult = compactCodeAttributeComposer.lstore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lstore(int)}
   */
  @Test
  public void testLstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstoreResult = compactCodeAttributeComposer.lstore(55);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fstore(int)}
   */
  @Test
  public void testFstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstoreResult = compactCodeAttributeComposer.fstore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fstore(int)}
   */
  @Test
  public void testFstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstoreResult = compactCodeAttributeComposer.fstore(56);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dstore(int)}
   */
  @Test
  public void testDstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstoreResult = compactCodeAttributeComposer.dstore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dstore(int)}
   */
  @Test
  public void testDstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstoreResult = compactCodeAttributeComposer.dstore(57);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#astore(int)}
   */
  @Test
  public void testAstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstoreResult = compactCodeAttributeComposer.astore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#astore(int)}
   */
  @Test
  public void testAstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstoreResult = compactCodeAttributeComposer.astore(58);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#istore_0()}
   */
  @Test
  public void testIstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_0Result = compactCodeAttributeComposer.istore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#istore_1()}
   */
  @Test
  public void testIstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_1Result = compactCodeAttributeComposer.istore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#istore_2()}
   */
  @Test
  public void testIstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_2Result = compactCodeAttributeComposer.istore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#istore_3()}
   */
  @Test
  public void testIstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_3Result = compactCodeAttributeComposer.istore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_3Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lstore_0()}
   */
  @Test
  public void testLstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_0Result = compactCodeAttributeComposer.lstore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lstore_1()}
   */
  @Test
  public void testLstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_1Result = compactCodeAttributeComposer.lstore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lstore_2()}
   */
  @Test
  public void testLstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_2Result = compactCodeAttributeComposer.lstore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lstore_3()}
   */
  @Test
  public void testLstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_3Result = compactCodeAttributeComposer.lstore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_3Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fstore_0()}
   */
  @Test
  public void testFstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_0Result = compactCodeAttributeComposer.fstore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fstore_1()}
   */
  @Test
  public void testFstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_1Result = compactCodeAttributeComposer.fstore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fstore_2()}
   */
  @Test
  public void testFstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_2Result = compactCodeAttributeComposer.fstore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fstore_3()}
   */
  @Test
  public void testFstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_3Result = compactCodeAttributeComposer.fstore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_3Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dstore_0()}
   */
  @Test
  public void testDstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_0Result = compactCodeAttributeComposer.dstore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dstore_1()}
   */
  @Test
  public void testDstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_1Result = compactCodeAttributeComposer.dstore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dstore_2()}
   */
  @Test
  public void testDstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_2Result = compactCodeAttributeComposer.dstore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dstore_3()}
   */
  @Test
  public void testDstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_3Result = compactCodeAttributeComposer.dstore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_3Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#astore_0()}
   */
  @Test
  public void testAstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_0Result = compactCodeAttributeComposer.astore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_0Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#astore_1()}
   */
  @Test
  public void testAstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_1Result = compactCodeAttributeComposer.astore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#astore_2()}
   */
  @Test
  public void testAstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_2Result = compactCodeAttributeComposer.astore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#astore_3()}
   */
  @Test
  public void testAstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_3Result = compactCodeAttributeComposer.astore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_3Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iastore()}
   */
  @Test
  public void testIastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIastoreResult = compactCodeAttributeComposer.iastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIastoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lastore()}
   */
  @Test
  public void testLastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLastoreResult = compactCodeAttributeComposer.lastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLastoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fastore()}
   */
  @Test
  public void testFastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFastoreResult = compactCodeAttributeComposer.fastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFastoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dastore()}
   */
  @Test
  public void testDastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDastoreResult = compactCodeAttributeComposer.dastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDastoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#aastore()}
   */
  @Test
  public void testAastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAastoreResult = compactCodeAttributeComposer.aastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAastoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#bastore()}
   */
  @Test
  public void testBastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBastoreResult = compactCodeAttributeComposer.bastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBastoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#castore()}
   */
  @Test
  public void testCastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCastoreResult = compactCodeAttributeComposer.castore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCastoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#sastore()}
   */
  @Test
  public void testSastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSastoreResult = compactCodeAttributeComposer.sastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSastoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pop()}
   */
  @Test
  public void testPop() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPopResult = compactCodeAttributeComposer.pop();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPopResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pop2()}
   */
  @Test
  public void testPop2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPop2Result = compactCodeAttributeComposer.pop2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPop2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dup()}
   */
  @Test
  public void testDup() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDupResult = compactCodeAttributeComposer.dup();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDupResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dup_x1()}
   */
  @Test
  public void testDup_x1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup_x1Result = compactCodeAttributeComposer.dup_x1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup_x1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dup_x2()}
   */
  @Test
  public void testDup_x2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup_x2Result = compactCodeAttributeComposer.dup_x2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup_x2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dup2()}
   */
  @Test
  public void testDup2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup2Result = compactCodeAttributeComposer.dup2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dup2_x1()}
   */
  @Test
  public void testDup2_x1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup2_x1Result = compactCodeAttributeComposer.dup2_x1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup2_x1Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dup2_x2()}
   */
  @Test
  public void testDup2_x2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup2_x2Result = compactCodeAttributeComposer.dup2_x2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup2_x2Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#swap()}
   */
  @Test
  public void testSwap() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSwapResult = compactCodeAttributeComposer.swap();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSwapResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iadd()}
   */
  @Test
  public void testIadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIaddResult = compactCodeAttributeComposer.iadd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIaddResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ladd()}
   */
  @Test
  public void testLadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLaddResult = compactCodeAttributeComposer.ladd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLaddResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fadd()}
   */
  @Test
  public void testFadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFaddResult = compactCodeAttributeComposer.fadd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFaddResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dadd()}
   */
  @Test
  public void testDadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDaddResult = compactCodeAttributeComposer.dadd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDaddResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#isub()}
   */
  @Test
  public void testIsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIsubResult = compactCodeAttributeComposer.isub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIsubResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lsub()}
   */
  @Test
  public void testLsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLsubResult = compactCodeAttributeComposer.lsub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLsubResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fsub()}
   */
  @Test
  public void testFsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFsubResult = compactCodeAttributeComposer.fsub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFsubResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dsub()}
   */
  @Test
  public void testDsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDsubResult = compactCodeAttributeComposer.dsub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDsubResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#imul()}
   */
  @Test
  public void testImul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualImulResult = compactCodeAttributeComposer.imul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualImulResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lmul()}
   */
  @Test
  public void testLmul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLmulResult = compactCodeAttributeComposer.lmul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLmulResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fmul()}
   */
  @Test
  public void testFmul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFmulResult = compactCodeAttributeComposer.fmul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFmulResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dmul()}
   */
  @Test
  public void testDmul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDmulResult = compactCodeAttributeComposer.dmul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDmulResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#idiv()}
   */
  @Test
  public void testIdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIdivResult = compactCodeAttributeComposer.idiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIdivResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ldiv()}
   */
  @Test
  public void testLdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdivResult = compactCodeAttributeComposer.ldiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdivResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fdiv()}
   */
  @Test
  public void testFdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFdivResult = compactCodeAttributeComposer.fdiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFdivResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ddiv()}
   */
  @Test
  public void testDdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDdivResult = compactCodeAttributeComposer.ddiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDdivResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#irem()}
   */
  @Test
  public void testIrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIremResult = compactCodeAttributeComposer.irem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIremResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lrem()}
   */
  @Test
  public void testLrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLremResult = compactCodeAttributeComposer.lrem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLremResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#frem()}
   */
  @Test
  public void testFrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFremResult = compactCodeAttributeComposer.frem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFremResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#drem()}
   */
  @Test
  public void testDrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDremResult = compactCodeAttributeComposer.drem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDremResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ineg()}
   */
  @Test
  public void testIneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInegResult = compactCodeAttributeComposer.ineg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInegResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lneg()}
   */
  @Test
  public void testLneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLnegResult = compactCodeAttributeComposer.lneg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLnegResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fneg()}
   */
  @Test
  public void testFneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFnegResult = compactCodeAttributeComposer.fneg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFnegResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dneg()}
   */
  @Test
  public void testDneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDnegResult = compactCodeAttributeComposer.dneg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDnegResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ishl()}
   */
  @Test
  public void testIshl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIshlResult = compactCodeAttributeComposer.ishl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIshlResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lshl()}
   */
  @Test
  public void testLshl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLshlResult = compactCodeAttributeComposer.lshl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLshlResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ishr()}
   */
  @Test
  public void testIshr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIshrResult = compactCodeAttributeComposer.ishr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIshrResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lshr()}
   */
  @Test
  public void testLshr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLshrResult = compactCodeAttributeComposer.lshr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLshrResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iushr()}
   */
  @Test
  public void testIushr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIushrResult = compactCodeAttributeComposer.iushr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIushrResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lushr()}
   */
  @Test
  public void testLushr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLushrResult = compactCodeAttributeComposer.lushr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLushrResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iand()}
   */
  @Test
  public void testIand() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIandResult = compactCodeAttributeComposer.iand();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIandResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#land()}
   */
  @Test
  public void testLand() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLandResult = compactCodeAttributeComposer.land();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLandResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ior()}
   */
  @Test
  public void testIor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIorResult = compactCodeAttributeComposer.ior();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIorResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lor()}
   */
  @Test
  public void testLor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLorResult = compactCodeAttributeComposer.lor();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLorResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ixor()}
   */
  @Test
  public void testIxor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIxorResult = compactCodeAttributeComposer.ixor();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIxorResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lxor()}
   */
  @Test
  public void testLxor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLxorResult = compactCodeAttributeComposer.lxor();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLxorResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iinc(int, int)}
   */
  @Test
  public void testIinc() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIincResult = compactCodeAttributeComposer.iinc(1, 1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIincResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#iinc(int, int)}
   */
  @Test
  public void testIinc2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIincResult = compactCodeAttributeComposer.iinc(26, 1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIincResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#i2l()}
   */
  @Test
  public void testI2l() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2lResult = compactCodeAttributeComposer.i2l();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2lResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#i2f()}
   */
  @Test
  public void testI2f() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2fResult = compactCodeAttributeComposer.i2f();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2fResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#i2d()}
   */
  @Test
  public void testI2d() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2dResult = compactCodeAttributeComposer.i2d();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2dResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#l2i()}
   */
  @Test
  public void testL2i() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualL2iResult = compactCodeAttributeComposer.l2i();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualL2iResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#l2f()}
   */
  @Test
  public void testL2f() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualL2fResult = compactCodeAttributeComposer.l2f();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualL2fResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#l2d()}
   */
  @Test
  public void testL2d() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualL2dResult = compactCodeAttributeComposer.l2d();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualL2dResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#f2i()}
   */
  @Test
  public void testF2i() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualF2iResult = compactCodeAttributeComposer.f2i();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualF2iResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#f2l()}
   */
  @Test
  public void testF2l() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualF2lResult = compactCodeAttributeComposer.f2l();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualF2lResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#f2d()}
   */
  @Test
  public void testF2d() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualF2dResult = compactCodeAttributeComposer.f2d();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualF2dResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#d2i()}
   */
  @Test
  public void testD2i() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualD2iResult = compactCodeAttributeComposer.d2i();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualD2iResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#d2l()}
   */
  @Test
  public void testD2l() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualD2lResult = compactCodeAttributeComposer.d2l();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualD2lResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#d2f()}
   */
  @Test
  public void testD2f() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualD2fResult = compactCodeAttributeComposer.d2f();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualD2fResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#i2b()}
   */
  @Test
  public void testI2b() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2bResult = compactCodeAttributeComposer.i2b();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2bResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#i2c()}
   */
  @Test
  public void testI2c() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2cResult = compactCodeAttributeComposer.i2c();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2cResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#i2s()}
   */
  @Test
  public void testI2s() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2sResult = compactCodeAttributeComposer.i2s();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2sResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lcmp()}
   */
  @Test
  public void testLcmp() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLcmpResult = compactCodeAttributeComposer.lcmp();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLcmpResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fcmpl()}
   */
  @Test
  public void testFcmpl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFcmplResult = compactCodeAttributeComposer.fcmpl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFcmplResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#fcmpg()}
   */
  @Test
  public void testFcmpg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFcmpgResult = compactCodeAttributeComposer.fcmpg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFcmpgResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dcmpl()}
   */
  @Test
  public void testDcmpl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDcmplResult = compactCodeAttributeComposer.dcmpl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDcmplResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dcmpg()}
   */
  @Test
  public void testDcmpg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDcmpgResult = compactCodeAttributeComposer.dcmpg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDcmpgResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ret(int)}
   */
  @Test
  public void testRet() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualRetResult = compactCodeAttributeComposer.ret(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualRetResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ret(int)}
   */
  @Test
  public void testRet2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualRetResult = compactCodeAttributeComposer.ret(26);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualRetResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#ireturn()}
   */
  @Test
  public void testIreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIreturnResult = compactCodeAttributeComposer.ireturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIreturnResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#lreturn()}
   */
  @Test
  public void testLreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLreturnResult = compactCodeAttributeComposer.lreturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLreturnResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#freturn()}
   */
  @Test
  public void testFreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFreturnResult = compactCodeAttributeComposer.freturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFreturnResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#dreturn()}
   */
  @Test
  public void testDreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDreturnResult = compactCodeAttributeComposer.dreturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDreturnResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#areturn()}
   */
  @Test
  public void testAreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAreturnResult = compactCodeAttributeComposer.areturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAreturnResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#return_()}
   */
  @Test
  public void testReturn_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualReturn_Result = compactCodeAttributeComposer.return_();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualReturn_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#return_(String)}
   */
  @Test
  public void testReturn_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualReturn_Result = compactCodeAttributeComposer.return_("Internal Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualReturn_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#return_(String)}
   */
  @Test
  public void testReturn_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualReturn_Result = compactCodeAttributeComposer.return_("()I");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualReturn_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#getstatic(int)}
   */
  @Test
  public void testGetstatic() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualGetstaticResult = compactCodeAttributeComposer.getstatic(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetstaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#getstatic(String, String, String)}
   */
  @Test
  public void testGetstatic2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualGetstaticResult = compactCodeAttributeComposer.getstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetstaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#getstatic(String, String, String)}
   */
  @Test
  public void testGetstatic3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualGetstaticResult = compactCodeAttributeComposer.getstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetstaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#getstatic(String, String, String, Clazz, Field)}
   */
  @Test
  public void testGetstatic4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualGetstaticResult = compactCodeAttributeComposer.getstatic("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetstaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#getstatic(String, String, String, Clazz, Field)}
   */
  @Test
  public void testGetstatic5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualGetstaticResult = compactCodeAttributeComposer.getstatic("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetstaticResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#putstatic(int)}
   */
  @Test
  public void testPutstatic() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPutstaticResult = compactCodeAttributeComposer.putstatic(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutstaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#putstatic(String, String, String)}
   */
  @Test
  public void testPutstatic2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPutstaticResult = compactCodeAttributeComposer.putstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutstaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#putstatic(String, String, String)}
   */
  @Test
  public void testPutstatic3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPutstaticResult = compactCodeAttributeComposer.putstatic("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutstaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#putstatic(String, String, String, Clazz, Field)}
   */
  @Test
  public void testPutstatic4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualPutstaticResult = compactCodeAttributeComposer.putstatic("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutstaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#putstatic(String, String, String, Clazz, Field)}
   */
  @Test
  public void testPutstatic5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualPutstaticResult = compactCodeAttributeComposer.putstatic("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutstaticResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#getfield(int)}
   */
  @Test
  public void testGetfield() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualGetfieldResult = compactCodeAttributeComposer.getfield(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetfieldResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#getfield(String, String, String)}
   */
  @Test
  public void testGetfield2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualGetfieldResult = compactCodeAttributeComposer.getfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetfieldResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#getfield(String, String, String)}
   */
  @Test
  public void testGetfield3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualGetfieldResult = compactCodeAttributeComposer.getfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetfieldResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#getfield(String, String, String, Clazz, Field)}
   */
  @Test
  public void testGetfield4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualGetfieldResult = compactCodeAttributeComposer.getfield("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetfieldResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#getfield(String, String, String, Clazz, Field)}
   */
  @Test
  public void testGetfield5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualGetfieldResult = compactCodeAttributeComposer.getfield("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetfieldResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#putfield(int)}
   */
  @Test
  public void testPutfield() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPutfieldResult = compactCodeAttributeComposer.putfield(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutfieldResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#putfield(String, String, String)}
   */
  @Test
  public void testPutfield2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPutfieldResult = compactCodeAttributeComposer.putfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutfieldResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#putfield(String, String, String)}
   */
  @Test
  public void testPutfield3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPutfieldResult = compactCodeAttributeComposer.putfield("Class Name", "Name",
        "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutfieldResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#putfield(String, String, String, Clazz, Field)}
   */
  @Test
  public void testPutfield4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualPutfieldResult = compactCodeAttributeComposer.putfield("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutfieldResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#putfield(String, String, String, Clazz, Field)}
   */
  @Test
  public void testPutfield5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualPutfieldResult = compactCodeAttributeComposer.putfield("Class Name", "Name",
        "Descriptor", referencedClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutfieldResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#invokevirtual(int)}
   */
  @Test
  public void testInvokevirtual() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokevirtualResult = compactCodeAttributeComposer.invokevirtual(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokevirtual(String, String, String)}
   */
  @Test
  public void testInvokevirtual2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokevirtualResult = compactCodeAttributeComposer.invokevirtual("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokevirtual(String, String, String)}
   */
  @Test
  public void testInvokevirtual3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokevirtualResult = compactCodeAttributeComposer.invokevirtual("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokevirtual(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokevirtual4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualInvokevirtualResult = compactCodeAttributeComposer.invokevirtual("Class Name",
        "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokevirtualResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokevirtual(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokevirtual5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualInvokevirtualResult = compactCodeAttributeComposer.invokevirtual("Class Name",
        "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokevirtualResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#invokespecial(int)}
   */
  @Test
  public void testInvokespecial() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokespecialResult = compactCodeAttributeComposer.invokespecial(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokespecialResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokespecial(String, String, String)}
   */
  @Test
  public void testInvokespecial2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokespecialResult = compactCodeAttributeComposer.invokespecial("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokespecialResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokespecial(String, String, String)}
   */
  @Test
  public void testInvokespecial3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokespecialResult = compactCodeAttributeComposer.invokespecial("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokespecialResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokespecial(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokespecial4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualInvokespecialResult = compactCodeAttributeComposer.invokespecial("Class Name",
        "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokespecialResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokespecial(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokespecial5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualInvokespecialResult = compactCodeAttributeComposer.invokespecial("Class Name",
        "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokespecialResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#invokestatic(int)}
   */
  @Test
  public void testInvokestatic() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokestaticResult = compactCodeAttributeComposer.invokestatic(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokestatic(String, String, String)}
   */
  @Test
  public void testInvokestatic2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokestaticResult = compactCodeAttributeComposer.invokestatic("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokestatic(String, String, String)}
   */
  @Test
  public void testInvokestatic3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokestaticResult = compactCodeAttributeComposer.invokestatic("Class Name",
        "Name", "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokestatic(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokestatic4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualInvokestaticResult = compactCodeAttributeComposer.invokestatic("Class Name",
        "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokestatic(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokestatic5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualInvokestaticResult = compactCodeAttributeComposer.invokestatic("Class Name",
        "Name", "Descriptor", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokestaticResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String)}
   */
  @Test
  public void testInvokestatic_interface() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokestatic_interfaceResult = compactCodeAttributeComposer
        .invokestatic_interface("Class Name", "Name", "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokestatic_interfaceResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String)}
   */
  @Test
  public void testInvokestatic_interface2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokestatic_interfaceResult = compactCodeAttributeComposer
        .invokestatic_interface("Class Name", "Name", "Descriptor");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokestatic_interfaceResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokestatic_interface3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualInvokestatic_interfaceResult = compactCodeAttributeComposer
        .invokestatic_interface("Class Name", "Name", "Descriptor", referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokestatic_interfaceResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokestatic_interface4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualInvokestatic_interfaceResult = compactCodeAttributeComposer
        .invokestatic_interface("Class Name", "Name", "Descriptor", referencedClass,
            new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokestatic_interfaceResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokeinterface(int, int)}
   */
  @Test
  public void testInvokeinterface() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokeinterfaceResult = compactCodeAttributeComposer.invokeinterface(1, 1);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokeinterface(int, int)}
   */
  @Test
  public void testInvokeinterface2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokeinterfaceResult = compactCodeAttributeComposer
        .invokeinterface(ClassEstimates.TYPICAL_CODE_LENGTH, 1);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokeinterface(String, String, String)}
   */
  @Test
  public void testInvokeinterface3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokeinterfaceResult = compactCodeAttributeComposer
        .invokeinterface("Class Name", "Name", "()I");

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokeinterface(String, String, String)}
   */
  @Test
  public void testInvokeinterface4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokeinterfaceResult = compactCodeAttributeComposer
        .invokeinterface("Class Name", "Name", "()I");

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokeinterface(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokeinterface5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualInvokeinterfaceResult = compactCodeAttributeComposer
        .invokeinterface("Class Name", "Name", "()I", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokeinterfaceResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokeinterface(String, String, String, Clazz, Method)}
   */
  @Test
  public void testInvokeinterface6() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    CompactCodeAttributeComposer actualInvokeinterfaceResult = compactCodeAttributeComposer
        .invokeinterface("Class Name", "Name", "()I", referencedClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokeinterfaceResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#invokedynamic(int)}
   */
  @Test
  public void testInvokedynamic() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokedynamicResult = compactCodeAttributeComposer.invokedynamic(1);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokedynamicResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#invokedynamic(int)}
   */
  @Test
  public void testInvokedynamic2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokedynamicResult = compactCodeAttributeComposer
        .invokedynamic(ClassEstimates.TYPICAL_CODE_LENGTH);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokedynamicResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokedynamic(int, String, String, Clazz[])}
   */
  @Test
  public void testInvokedynamic3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokedynamicResult = compactCodeAttributeComposer.invokedynamic(1, "Name",
        "Descriptor", new Clazz[]{new LibraryClass()});

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokedynamicResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#invokedynamic(int, String, String, Clazz[])}
   */
  @Test
  public void testInvokedynamic4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInvokedynamicResult = compactCodeAttributeComposer.invokedynamic(1, "Name",
        "Descriptor", new Clazz[]{new LibraryClass()});

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokedynamicResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#new_(int)}
   */
  @Test
  public void testNew_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNew_Result = compactCodeAttributeComposer.new_(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNew_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#new_(String)}
   */
  @Test
  public void testNew_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualNew_Result = compactCodeAttributeComposer.new_("Class Name");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNew_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#new_(String)}
   */
  @Test
  public void testNew_3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualNew_Result = compactCodeAttributeComposer.new_("Class Name");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNew_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#new_(String, Clazz)}
   */
  @Test
  public void testNew_4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualNew_Result = compactCodeAttributeComposer.new_("Class Name", new LibraryClass());

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNew_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#new_(String, Clazz)}
   */
  @Test
  public void testNew_5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualNew_Result = compactCodeAttributeComposer.new_("Class Name", new LibraryClass());

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNew_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#new_(Clazz)}
   */
  @Test
  public void testNew_6() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualNew_Result = compactCodeAttributeComposer.new_(new LibraryClass());

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNew_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#newarray(int)}
   */
  @Test
  public void testNewarray() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNewarrayResult = compactCodeAttributeComposer.newarray(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNewarrayResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#newarray(int)}
   */
  @Test
  public void testNewarray2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNewarrayResult = compactCodeAttributeComposer.newarray(-68);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNewarrayResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#newarray(int)}
   */
  @Test
  public void testNewarray3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNewarrayResult = compactCodeAttributeComposer.newarray(6);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNewarrayResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#anewarray(int)}
   */
  @Test
  public void testAnewarray() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAnewarrayResult = compactCodeAttributeComposer.anewarray(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAnewarrayResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#anewarray(String, Clazz)}
   */
  @Test
  public void testAnewarray2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAnewarrayResult = compactCodeAttributeComposer.anewarray("Class Name",
        new LibraryClass());

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAnewarrayResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#anewarray(String, Clazz)}
   */
  @Test
  public void testAnewarray3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAnewarrayResult = compactCodeAttributeComposer.anewarray("Class Name",
        new LibraryClass());

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAnewarrayResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#arraylength()}
   */
  @Test
  public void testArraylength() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualArraylengthResult = compactCodeAttributeComposer.arraylength();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualArraylengthResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#athrow()}
   */
  @Test
  public void testAthrow() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAthrowResult = compactCodeAttributeComposer.athrow();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAthrowResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#checkcast(int)}
   */
  @Test
  public void testCheckcast() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCheckcastResult = compactCodeAttributeComposer.checkcast(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCheckcastResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#checkcast(String)}
   */
  @Test
  public void testCheckcast2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualCheckcastResult = compactCodeAttributeComposer.checkcast("Class Name");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCheckcastResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#checkcast(String)}
   */
  @Test
  public void testCheckcast3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualCheckcastResult = compactCodeAttributeComposer.checkcast("Class Name");

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCheckcastResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#checkcast(String, Clazz)}
   */
  @Test
  public void testCheckcast4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualCheckcastResult = compactCodeAttributeComposer.checkcast("Class Name",
        new LibraryClass());

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCheckcastResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#checkcast(String, Clazz)}
   */
  @Test
  public void testCheckcast5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualCheckcastResult = compactCodeAttributeComposer.checkcast("Class Name",
        new LibraryClass());

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCheckcastResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#instanceof_(int)}
   */
  @Test
  public void testInstanceof_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInstanceof_Result = compactCodeAttributeComposer.instanceof_(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInstanceof_Result);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#instanceof_(String, Clazz)}
   */
  @Test
  public void testInstanceof_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInstanceof_Result = compactCodeAttributeComposer.instanceof_("Class Name",
        new LibraryClass());

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInstanceof_Result);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#instanceof_(String, Clazz)}
   */
  @Test
  public void testInstanceof_3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualInstanceof_Result = compactCodeAttributeComposer.instanceof_("Class Name",
        new LibraryClass());

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInstanceof_Result);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#monitorenter()}
   */
  @Test
  public void testMonitorenter() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMonitorenterResult = compactCodeAttributeComposer.monitorenter();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMonitorenterResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#monitorexit()}
   */
  @Test
  public void testMonitorexit() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMonitorexitResult = compactCodeAttributeComposer.monitorexit();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMonitorexitResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#wide()}
   */
  @Test
  public void testWide() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualWideResult = compactCodeAttributeComposer.wide();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualWideResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#multianewarray(int, int)}
   */
  @Test
  public void testMultianewarray() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMultianewarrayResult = compactCodeAttributeComposer.multianewarray(1, 1);

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMultianewarrayResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#multianewarray(int, int)}
   */
  @Test
  public void testMultianewarray2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMultianewarrayResult = compactCodeAttributeComposer
        .multianewarray(ClassEstimates.TYPICAL_CODE_LENGTH, 1);

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMultianewarrayResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#multianewarray(String, Clazz, int)}
   */
  @Test
  public void testMultianewarray3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualMultianewarrayResult = compactCodeAttributeComposer.multianewarray("Class Name",
        new LibraryClass(), 1);

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMultianewarrayResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#multianewarray(String, Clazz, int)}
   */
  @Test
  public void testMultianewarray4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualMultianewarrayResult = compactCodeAttributeComposer.multianewarray("Class Name",
        new LibraryClass(), 1);

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMultianewarrayResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#pushPrimitive(Object, char)}
   */
  @Test
  public void testPushPrimitive() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new CompactCodeAttributeComposer(new ProgramClass())).pushPrimitive("Primitive", 'A'));
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  public void testPushInt() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(42);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  public void testPushInt2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(-1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  public void testPushInt3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  public void testPushInt4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(2);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  public void testPushInt5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(3);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  public void testPushInt6() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(4);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  public void testPushInt7() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(0);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  public void testPushInt8() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(5);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  public void testPushInt9() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  public void testPushFloat() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult = compactCodeAttributeComposer.pushFloat(10.0f);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushFloatResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  public void testPushFloat2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 0, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult = compactCodeAttributeComposer.pushFloat(10.0f);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushFloatResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  public void testPushFloat3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult = compactCodeAttributeComposer.pushFloat(10.0f);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushFloatResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  public void testPushFloat4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult = compactCodeAttributeComposer.pushFloat(1.0f);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushFloatResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  public void testPushFloat5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult = compactCodeAttributeComposer.pushFloat(2.0f);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushFloatResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  public void testPushFloat6() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult = compactCodeAttributeComposer.pushFloat(0.0f);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushFloatResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  public void testPushLong() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(42, 1, new Constant[]{new ClassConstant()}, 42, 42, 42));

    // Act
    CompactCodeAttributeComposer actualPushLongResult = compactCodeAttributeComposer.pushLong(42L);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushLongResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  public void testPushLong2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(42, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 42, 42, 42));

    // Act
    CompactCodeAttributeComposer actualPushLongResult = compactCodeAttributeComposer.pushLong(42L);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushLongResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  public void testPushLong3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(42, 3, new Constant[]{new ClassConstant()}, 42, 42, 42));

    // Act
    CompactCodeAttributeComposer actualPushLongResult = compactCodeAttributeComposer.pushLong(1L);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushLongResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  public void testPushLong4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(42, 3, new Constant[]{new ClassConstant()}, 42, 42, 42));

    // Act
    CompactCodeAttributeComposer actualPushLongResult = compactCodeAttributeComposer.pushLong(0L);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushLongResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  public void testPushDouble() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushDoubleResult = compactCodeAttributeComposer.pushDouble(10.0d);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushDoubleResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  public void testPushDouble2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushDoubleResult = compactCodeAttributeComposer.pushDouble(10.0d);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushDoubleResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  public void testPushDouble3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushDoubleResult = compactCodeAttributeComposer.pushDouble(1.0d);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushDoubleResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  public void testPushDouble4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushDoubleResult = compactCodeAttributeComposer.pushDouble(0.0d);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushDoubleResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#pushNewArray(String, int)}
   */
  @Test
  public void testPushNewArray() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(-1, 1, new Constant[]{new ClassConstant()}, -1, -1, -1));

    // Act
    CompactCodeAttributeComposer actualPushNewArrayResult = compactCodeAttributeComposer
        .pushNewArray("Element Type Or Class Name", 3);

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushNewArrayResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#pushNewArray(String, int)}
   */
  @Test
  public void testPushNewArray2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(-1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, -1, -1, -1));

    // Act
    CompactCodeAttributeComposer actualPushNewArrayResult = compactCodeAttributeComposer
        .pushNewArray("Element Type Or Class Name", 3);

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushNewArrayResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  public void testLoad() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'A');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  public void testLoad2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(66, 'A');

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  public void testLoad3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'B');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  public void testLoad4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'D');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  public void testLoad5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'F');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  public void testLoad6() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'J');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#load(int, String)}
   */
  @Test
  public void testLoad7() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, "Internal Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#load(int, String)}
   */
  @Test
  public void testLoad8() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(66, "Internal Type");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#load(int, String)}
   */
  @Test
  public void testLoad9() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, "()I");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  public void testStore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'A');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  public void testStore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(66, 'A');

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  public void testStore3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'B');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  public void testStore4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'D');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  public void testStore5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'F');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  public void testStore6() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'J');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#store(int, String)}
   */
  @Test
  public void testStore7() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, "Internal Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#store(int, String)}
   */
  @Test
  public void testStore8() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(66, "Internal Type");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#store(int, String)}
   */
  @Test
  public void testStore9() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, "()I");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Method under test: {@link CompactCodeAttributeComposer#storeToArray(String)}
   */
  @Test
  public void testStoreToArray() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreToArrayResult = compactCodeAttributeComposer.storeToArray("Element Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreToArrayResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions()}
   */
  @Test
  public void testAppendPrintIntegerInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(89, 1, new Constant[]{new ClassConstant()}, 89, 89, 89));

    // Act
    CompactCodeAttributeComposer actualAppendPrintIntegerInstructionsResult = compactCodeAttributeComposer
        .appendPrintIntegerInstructions();

    // Assert
    assertEquals(8, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintIntegerInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions()}
   */
  @Test
  public void testAppendPrintIntegerInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(89, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 89, 89, 89));

    // Act
    CompactCodeAttributeComposer actualAppendPrintIntegerInstructionsResult = compactCodeAttributeComposer
        .appendPrintIntegerInstructions();

    // Assert
    assertEquals(8, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintIntegerInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions(String)}
   */
  @Test
  public void testAppendPrintIntegerInstructions3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintIntegerInstructionsResult = compactCodeAttributeComposer
        .appendPrintIntegerInstructions("Not all who wander are lost");

    // Assert
    assertEquals(ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintIntegerInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions(String)}
   */
  @Test
  public void testAppendPrintIntegerInstructions4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintIntegerInstructionsResult = compactCodeAttributeComposer
        .appendPrintIntegerInstructions("Not all who wander are lost");

    // Assert
    assertEquals(ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintIntegerInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions()}
   */
  @Test
  public void testAppendPrintIntegerHexInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(89, 1, new Constant[]{new ClassConstant()}, 89, 89, 89));

    // Act
    CompactCodeAttributeComposer actualAppendPrintIntegerHexInstructionsResult = compactCodeAttributeComposer
        .appendPrintIntegerHexInstructions();

    // Assert
    assertEquals(11, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintIntegerHexInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions()}
   */
  @Test
  public void testAppendPrintIntegerHexInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(89, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 89, 89, 89));

    // Act
    CompactCodeAttributeComposer actualAppendPrintIntegerHexInstructionsResult = compactCodeAttributeComposer
        .appendPrintIntegerHexInstructions();

    // Assert
    assertEquals(11, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintIntegerHexInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions(String)}
   */
  @Test
  public void testAppendPrintIntegerHexInstructions3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintIntegerHexInstructionsResult = compactCodeAttributeComposer
        .appendPrintIntegerHexInstructions("0123456789ABCDEF");

    // Assert
    assertEquals(19, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintIntegerHexInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions(String)}
   */
  @Test
  public void testAppendPrintIntegerHexInstructions4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintIntegerHexInstructionsResult = compactCodeAttributeComposer
        .appendPrintIntegerHexInstructions("0123456789ABCDEF");

    // Assert
    assertEquals(19, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintIntegerHexInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintLongInstructions()}
   */
  @Test
  public void testAppendPrintLongInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(92, 1, new Constant[]{new ClassConstant()}, 92, 92, 92));

    // Act
    CompactCodeAttributeComposer actualAppendPrintLongInstructionsResult = compactCodeAttributeComposer
        .appendPrintLongInstructions();

    // Assert
    assertEquals(9, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintLongInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintLongInstructions()}
   */
  @Test
  public void testAppendPrintLongInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(92, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 92, 92, 92));

    // Act
    CompactCodeAttributeComposer actualAppendPrintLongInstructionsResult = compactCodeAttributeComposer
        .appendPrintLongInstructions();

    // Assert
    assertEquals(9, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintLongInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintLongInstructions(String)}
   */
  @Test
  public void testAppendPrintLongInstructions3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintLongInstructionsResult = compactCodeAttributeComposer
        .appendPrintLongInstructions("Not all who wander are lost");

    // Assert
    assertEquals(17, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintLongInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintLongInstructions(String)}
   */
  @Test
  public void testAppendPrintLongInstructions4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintLongInstructionsResult = compactCodeAttributeComposer
        .appendPrintLongInstructions("Not all who wander are lost");

    // Assert
    assertEquals(17, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintLongInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintStringInstructions()}
   */
  @Test
  public void testAppendPrintStringInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(89, 1, new Constant[]{new ClassConstant()}, 89, 89, 89));

    // Act
    CompactCodeAttributeComposer actualAppendPrintStringInstructionsResult = compactCodeAttributeComposer
        .appendPrintStringInstructions();

    // Assert
    assertEquals(8, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintStringInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintStringInstructions()}
   */
  @Test
  public void testAppendPrintStringInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(89, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 89, 89, 89));

    // Act
    CompactCodeAttributeComposer actualAppendPrintStringInstructionsResult = compactCodeAttributeComposer
        .appendPrintStringInstructions();

    // Assert
    assertEquals(8, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintStringInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintStringInstructions(String)}
   */
  @Test
  public void testAppendPrintStringInstructions3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintStringInstructionsResult = compactCodeAttributeComposer
        .appendPrintStringInstructions("Not all who wander are lost");

    // Assert
    assertEquals(ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintStringInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintStringInstructions(String)}
   */
  @Test
  public void testAppendPrintStringInstructions4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintStringInstructionsResult = compactCodeAttributeComposer
        .appendPrintStringInstructions("Not all who wander are lost");

    // Assert
    assertEquals(ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintStringInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintObjectInstructions()}
   */
  @Test
  public void testAppendPrintObjectInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(89, 1, new Constant[]{new ClassConstant()}, 89, 89, 89));

    // Act
    CompactCodeAttributeComposer actualAppendPrintObjectInstructionsResult = compactCodeAttributeComposer
        .appendPrintObjectInstructions();

    // Assert
    assertEquals(8, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintObjectInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintObjectInstructions()}
   */
  @Test
  public void testAppendPrintObjectInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(89, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 89, 89, 89));

    // Act
    CompactCodeAttributeComposer actualAppendPrintObjectInstructionsResult = compactCodeAttributeComposer
        .appendPrintObjectInstructions();

    // Assert
    assertEquals(8, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintObjectInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintObjectInstructions(String)}
   */
  @Test
  public void testAppendPrintObjectInstructions3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintObjectInstructionsResult = compactCodeAttributeComposer
        .appendPrintObjectInstructions("Not all who wander are lost");

    // Assert
    assertEquals(ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintObjectInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintObjectInstructions(String)}
   */
  @Test
  public void testAppendPrintObjectInstructions4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintObjectInstructionsResult = compactCodeAttributeComposer
        .appendPrintObjectInstructions("Not all who wander are lost");

    // Assert
    assertEquals(ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintObjectInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions()}
   */
  @Test
  public void testAppendPrintStackTraceInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(89, 1, new Constant[]{new ClassConstant()}, 89, 89, 89));

    // Act
    CompactCodeAttributeComposer actualAppendPrintStackTraceInstructionsResult = compactCodeAttributeComposer
        .appendPrintStackTraceInstructions();

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintStackTraceInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions()}
   */
  @Test
  public void testAppendPrintStackTraceInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(89, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 89, 89, 89));

    // Act
    CompactCodeAttributeComposer actualAppendPrintStackTraceInstructionsResult = compactCodeAttributeComposer
        .appendPrintStackTraceInstructions();

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintStackTraceInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions(String)}
   */
  @Test
  public void testAppendPrintStackTraceInstructions3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintStackTraceInstructionsResult = compactCodeAttributeComposer
        .appendPrintStackTraceInstructions("Not all who wander are lost");

    // Assert
    assertEquals(12, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintStackTraceInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions(String)}
   */
  @Test
  public void testAppendPrintStackTraceInstructions4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintStackTraceInstructionsResult = compactCodeAttributeComposer
        .appendPrintStackTraceInstructions("Not all who wander are lost");

    // Assert
    assertEquals(12, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintStackTraceInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintInstructions(String)}
   */
  @Test
  public void testAppendPrintInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintInstructionsResult = compactCodeAttributeComposer
        .appendPrintInstructions("Not all who wander are lost");

    // Assert
    assertEquals(8, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintInstructionsResult);
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#appendPrintInstructions(String)}
   */
  @Test
  public void testAppendPrintInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer = new CompactCodeAttributeComposer(
        new ProgramClass(1, 3, new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualAppendPrintInstructionsResult = compactCodeAttributeComposer
        .appendPrintInstructions("Not all who wander are lost");

    // Assert
    assertEquals(8, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAppendPrintInstructionsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ConstantPoolEditor, CodeAttributeComposer)}
   *   <li>{@link CompactCodeAttributeComposer#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link CompactCodeAttributeComposer#getConstantPoolEditor()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(
        constantPoolEditor, new CodeAttributeComposer());
    LibraryClass clazz = new LibraryClass();
    actualCompactCodeAttributeComposer.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert that nothing has changed
    assertSame(constantPoolEditor, actualCompactCodeAttributeComposer.getConstantPoolEditor());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)}
   */
  @Test
  public void testNewCompactCodeAttributeComposer() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(targetClass);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)}
   */
  @Test
  public void testNewCompactCodeAttributeComposer2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(targetClass);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewCompactCodeAttributeComposer3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(targetClass,
        KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewCompactCodeAttributeComposer4() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 1;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(targetClass,
        null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewCompactCodeAttributeComposer5() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(targetClass,
        null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean, boolean)}
   */
  @Test
  public void testNewCompactCodeAttributeComposer6() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(targetClass,
        true, true, true);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean, boolean)}
   */
  @Test
  public void testNewCompactCodeAttributeComposer7() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(targetClass,
        true, true, true);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean, boolean, ClassPool, ClassPool)}
   */
  @Test
  public void testNewCompactCodeAttributeComposer8() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(targetClass,
        true, true, true, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean, boolean, ClassPool, ClassPool)}
   */
  @Test
  public void testNewCompactCodeAttributeComposer9() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 1;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(targetClass,
        true, true, true, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean, boolean, ClassPool, ClassPool)}
   */
  @Test
  public void testNewCompactCodeAttributeComposer10() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(targetClass,
        true, true, true, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Method under test:
   * {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ConstantPoolEditor, boolean, boolean, boolean)}
   */
  @Test
  public void testNewCompactCodeAttributeComposer11() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer = new CompactCodeAttributeComposer(
        constantPoolEditor, true, true, true);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(constantPoolEditor, actualCompactCodeAttributeComposer.getConstantPoolEditor());
  }
}
