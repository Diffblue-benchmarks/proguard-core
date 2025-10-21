package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.TargetInfo;
import proguard.classfile.attribute.preverification.VerificationType;
import proguard.classfile.attribute.preverification.VerificationTypeFactory;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.SwitchInstruction;
import proguard.classfile.instruction.TableSwitchInstruction;
import proguard.classfile.instruction.VariableInstruction;

public class CodeAttributeComposerDiffblueTest {
  /**
   * Test {@link CodeAttributeComposer#CodeAttributeComposer()}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#CodeAttributeComposer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.<init>()"})
  public void testNewCodeAttributeComposer() {
    // Arrange, Act and Assert
    assertEquals(0, (new CodeAttributeComposer()).getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#CodeAttributeComposer(boolean, boolean, boolean)}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#CodeAttributeComposer(boolean, boolean,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.<init>(boolean, boolean, boolean)"})
  public void testNewCodeAttributeComposer2() {
    // Arrange, Act and Assert
    assertEquals(0, (new CodeAttributeComposer(true, true, true)).getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#CodeAttributeComposer(boolean, boolean, boolean, boolean)}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#CodeAttributeComposer(boolean, boolean,
   * boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.<init>(boolean, boolean, boolean, boolean)"})
  public void testNewCodeAttributeComposer3() {
    // Arrange, Act and Assert
    assertEquals(0, (new CodeAttributeComposer(true, true, true, true)).getCodeLength());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeAttributeComposer#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link CodeAttributeComposer#visitAnyInstruction(Clazz, Method, CodeAttribute, int,
   *       Instruction)}
   *   <li>{@link CodeAttributeComposer#visitAnyTargetInfo(Clazz, TypeAnnotation, TargetInfo)}
   *   <li>{@link CodeAttributeComposer#visitAnyVerificationType(Clazz, Method, CodeAttribute, int,
   *       VerificationType)}
   *   <li>{@link CodeAttributeComposer#getCodeLength()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "int CodeAttributeComposer.getCodeLength()",
    "void CodeAttributeComposer.visitAnyAttribute(Clazz, Attribute)",
    "void CodeAttributeComposer.visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction)",
    "void CodeAttributeComposer.visitAnyTargetInfo(Clazz, TypeAnnotation, TargetInfo)",
    "void CodeAttributeComposer.visitAnyVerificationType(Clazz, Method, CodeAttribute, int, VerificationType)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();

    // Act
    codeAttributeComposer.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());
    LibraryClass clazz2 = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    codeAttributeComposer.visitAnyInstruction(
        clazz2, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));
    LibraryClass clazz3 = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    codeAttributeComposer.visitAnyTargetInfo(
        clazz3, typeAnnotation, new CatchTargetInfo((byte) 'A'));
    LibraryClass clazz4 = new LibraryClass();
    LibraryMethod method2 = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute2 = new CodeAttribute(1);
    codeAttributeComposer.visitAnyVerificationType(
        clazz4, method2, codeAttribute2, 2, VerificationTypeFactory.createDoubleType());

    // Assert
    assertEquals(0, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(3, codeAttributeComposer.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction2() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    ConstantInstruction instruction = new ConstantInstruction((byte) 'A', 1);

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(3, codeAttributeComposer.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction3() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LookUpSwitchInstruction instruction =
        new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 2, 1, 2}, new int[] {1, 2, 1, 2});

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(44, codeAttributeComposer.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction4() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    SimpleInstruction instruction = new SimpleInstruction((byte) 'A');

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, codeAttributeComposer.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction5() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    TableSwitchInstruction instruction =
        new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[] {1, 2, 1, 2});

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(20, codeAttributeComposer.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction6() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    VariableInstruction instruction = new VariableInstruction((byte) 'A');

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, codeAttributeComposer.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction7() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    BranchInstruction instruction = new BranchInstruction((byte) -89, Integer.MIN_VALUE);

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("goto_w", instruction.getName());
    assertEquals((byte) -56, instruction.opcode);
    assertEquals(5, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction8() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    ConstantInstruction instruction = new ConstantInstruction((byte) 19, 1);

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("ldc", instruction.getName());
    assertEquals((byte) 18, instruction.opcode);
    assertEquals(2, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction9() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    ConstantInstruction instruction = new ConstantInstruction((byte) -71, 1);

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("invokeinterface", instruction.getName());
    assertEquals((byte) -71, instruction.opcode);
    assertEquals(5, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction10() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    ConstantInstruction instruction = new ConstantInstruction((byte) -59, 1);

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("multianewarray", instruction.getName());
    assertEquals((byte) -59, instruction.opcode);
    assertEquals(4, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction11() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    ConstantInstruction instruction = new ConstantInstruction((byte) -70, 1);

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("invokedynamic", instruction.getName());
    assertEquals((byte) -70, instruction.opcode);
    assertEquals(5, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction12() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    codeAttributeComposer.appendInstructions(
        new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    LookUpSwitchInstruction instruction =
        new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 2, 1, 2}, new int[] {1, 2, 1, 2});

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(44, codeAttributeComposer.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstruction(Instruction)} with {@code instruction}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction()} Name is {@code nop}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstruction(Instruction)"})
  public void testAppendInstructionWithInstruction_thenVariableInstructionNameIsNop() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    VariableInstruction instruction = new VariableInstruction();

    // Act
    codeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("nop", instruction.getName());
    assertEquals((byte) 0, instruction.opcode);
    assertEquals(2, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#endCodeFragment()}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#endCodeFragment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.endCodeFragment()"})
  public void testEndCodeFragment() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new CodeAttributeComposer()).endCodeFragment());
  }

  /**
   * Test {@link CodeAttributeComposer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CodeAttributeComposer.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeComposer.visitBranchInstruction(
                clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeComposer#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CodeAttributeComposer.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeComposer.visitBranchInstruction(
                clazz, method, codeAttribute, -1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Test {@link CodeAttributeComposer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CodeAttributeComposer.visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)"
  })
  public void testVisitAnySwitchInstruction_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeComposer.visitAnySwitchInstruction(
                clazz, method, codeAttribute, 2, new LookUpSwitchInstruction()));
  }

  /**
   * Test {@link CodeAttributeComposer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int,
   * SwitchInstruction)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#visitAnySwitchInstruction(Clazz, Method,
   * CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CodeAttributeComposer.visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)"
  })
  public void testVisitAnySwitchInstruction_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            codeAttributeComposer.visitAnySwitchInstruction(
                clazz, method, codeAttribute, -1, new LookUpSwitchInstruction()));
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions = new Instruction[] {new BranchInstruction((byte) 'A', 1)};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof BranchInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(3, codeAttributeComposer.getCodeLength());
    assertEquals('A', ((BranchInstruction) instruction).opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions2() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions = new Instruction[] {new ConstantInstruction((byte) 'A', 1)};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof ConstantInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(3, codeAttributeComposer.getCodeLength());
    assertEquals('A', ((ConstantInstruction) instruction).opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions3() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions = new Instruction[] {new VariableInstruction((byte) 'A')};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof VariableInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, codeAttributeComposer.getCodeLength());
    assertEquals(1, instructions.length);
    assertEquals('A', ((VariableInstruction) instruction).opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions4() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    codeAttributeComposer.appendInstructions(
        new Instruction[] {new BranchInstruction((byte) 'A', 1)});
    Instruction[] instructions =
        new Instruction[] {
          new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 2, 1, 2}, new int[] {1, 2, 1, 2})
        };

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof LookUpSwitchInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(44, codeAttributeComposer.getCodeLength());
    assertEquals('A', ((LookUpSwitchInstruction) instruction).opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element {@link LookUpSwitchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions_thenFirstElementLookUpSwitchInstruction() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions =
        new Instruction[] {
          new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 2, 1, 2}, new int[] {1, 2, 1, 2})
        };

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof LookUpSwitchInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(44, codeAttributeComposer.getCodeLength());
    assertEquals('A', ((LookUpSwitchInstruction) instruction).opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element Name is {@code goto_w}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions_thenFirstElementNameIsGotoW() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions =
        new Instruction[] {new BranchInstruction((byte) -89, Integer.MIN_VALUE)};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof BranchInstruction);
    assertEquals("goto_w", instruction.getName());
    assertEquals((byte) -56, ((BranchInstruction) instruction).opcode);
    assertEquals(1, instructions.length);
    assertEquals(5, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element Name is {@code invokedynamic}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions_thenFirstElementNameIsInvokedynamic() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions = new Instruction[] {new ConstantInstruction((byte) -70, 1)};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof ConstantInstruction);
    assertEquals("invokedynamic", instruction.getName());
    assertEquals((byte) -70, ((ConstantInstruction) instruction).opcode);
    assertEquals(1, instructions.length);
    assertEquals(5, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element Name is {@code invokeinterface}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions_thenFirstElementNameIsInvokeinterface() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions = new Instruction[] {new ConstantInstruction((byte) -71, 1)};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof ConstantInstruction);
    assertEquals("invokeinterface", instruction.getName());
    assertEquals((byte) -71, ((ConstantInstruction) instruction).opcode);
    assertEquals(1, instructions.length);
    assertEquals(5, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element Name is {@code ldc}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions_thenFirstElementNameIsLdc() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions = new Instruction[] {new ConstantInstruction((byte) 19, 1)};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof ConstantInstruction);
    assertEquals("ldc", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals((byte) 18, ((ConstantInstruction) instruction).opcode);
    assertEquals(2, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element Name is {@code multianewarray}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions_thenFirstElementNameIsMultianewarray() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions = new Instruction[] {new ConstantInstruction((byte) -59, 1)};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof ConstantInstruction);
    assertEquals("multianewarray", instruction.getName());
    assertEquals((byte) -59, ((ConstantInstruction) instruction).opcode);
    assertEquals(1, instructions.length);
    assertEquals(4, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element Name is {@code nop}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions_thenFirstElementNameIsNop() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions = new Instruction[] {new VariableInstruction()};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof VariableInstruction);
    assertEquals("nop", instruction.getName());
    assertEquals((byte) 0, ((VariableInstruction) instruction).opcode);
    assertEquals(1, instructions.length);
    assertEquals(2, codeAttributeComposer.getCodeLength());
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element {@link SimpleInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions_thenFirstElementSimpleInstruction() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions = new Instruction[] {new SimpleInstruction((byte) 'A')};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof SimpleInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, codeAttributeComposer.getCodeLength());
    assertEquals(1, instructions.length);
    assertEquals('A', ((SimpleInstruction) instruction).opcode);
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element {@link TableSwitchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CodeAttributeComposer.appendInstructions(Instruction[])"})
  public void testAppendInstructions_thenFirstElementTableSwitchInstruction() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    Instruction[] instructions =
        new Instruction[] {new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[] {1, 2, 1, 2})};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof TableSwitchInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(20, codeAttributeComposer.getCodeLength());
    assertEquals('A', ((TableSwitchInstruction) instruction).opcode);
  }
}
