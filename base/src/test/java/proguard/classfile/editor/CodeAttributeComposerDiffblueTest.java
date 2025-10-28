package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
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
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstruction(new BranchInstruction((byte) 'A', 1));

    // Assert
    assertEquals(3, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction2() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstruction(new ConstantInstruction((byte) 'A', 1));

    // Assert
    assertEquals(3, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction3() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer
        .appendInstruction(new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 2, 1, 2}, new int[]{1, 2, 1, 2}));

    // Assert
    assertEquals(44, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction4() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstruction(new SimpleInstruction((byte) 'A'));

    // Assert
    assertEquals(1, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction5() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstruction(new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[]{1, 2, 1, 2}));

    // Assert
    assertEquals(20, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction6() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstruction(new VariableInstruction((byte) 'A'));

    // Assert
    assertEquals(1, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction7() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstruction(new VariableInstruction());

    // Assert
    assertEquals(2, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction8() {
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
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction9() {
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
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction10() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstruction(new ConstantInstruction((byte) -71, 1));

    // Assert
    assertEquals(5, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction11() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstruction(new ConstantInstruction((byte) -59, 1));

    // Assert
    assertEquals(4, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction12() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstruction(new ConstantInstruction((byte) -70, 1));

    // Assert
    assertEquals(5, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  public void testAppendInstruction13() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    codeAttributeComposer.appendInstructions(new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    // Act
    codeAttributeComposer
        .appendInstruction(new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 2, 1, 2}, new int[]{1, 2, 1, 2}));

    // Assert
    assertEquals(44, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test: {@link CodeAttributeComposer#endCodeFragment()}
   */
  @Test
  public void testEndCodeFragment() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new CodeAttributeComposer()).endCodeFragment());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeComposer.visitBranchInstruction(clazz, method,
        codeAttribute, 2, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction2() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeComposer.visitBranchInstruction(clazz, method,
        codeAttribute, -1, new BranchInstruction((byte) 'A', 1)));
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  public void testVisitAnySwitchInstruction() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeComposer.visitAnySwitchInstruction(clazz, method,
        codeAttribute, 2, new LookUpSwitchInstruction()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction)}
   */
  @Test
  public void testVisitAnySwitchInstruction2() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> codeAttributeComposer.visitAnySwitchInstruction(clazz, method,
        codeAttribute, -1, new LookUpSwitchInstruction()));
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstructions(new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    // Assert
    assertEquals(3, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions2() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstructions(new Instruction[]{new ConstantInstruction((byte) 'A', 1)});

    // Assert
    assertEquals(3, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions3() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstructions(
        new Instruction[]{new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 2, 1, 2}, new int[]{1, 2, 1, 2})});

    // Assert
    assertEquals(44, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions4() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstructions(new Instruction[]{new SimpleInstruction((byte) 'A')});

    // Assert
    assertEquals(1, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions5() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer
        .appendInstructions(new Instruction[]{new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[]{1, 2, 1, 2})});

    // Assert
    assertEquals(20, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions6() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstructions(new Instruction[]{new VariableInstruction((byte) 'A')});

    // Assert
    assertEquals(1, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions7() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstructions(new Instruction[]{new VariableInstruction()});

    // Assert
    assertEquals(2, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions8() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    BranchInstruction branchInstruction = new BranchInstruction((byte) -89, Integer.MIN_VALUE);

    Instruction[] instructions = new Instruction[]{branchInstruction};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    assertEquals(1, instructions.length);
    assertEquals(5, codeAttributeComposer.getCodeLength());
    assertSame(branchInstruction, instructions[0]);
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions9() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    ConstantInstruction constantInstruction = new ConstantInstruction((byte) 19, 1);

    Instruction[] instructions = new Instruction[]{constantInstruction};

    // Act
    codeAttributeComposer.appendInstructions(instructions);

    // Assert
    assertEquals(1, instructions.length);
    assertEquals(2, codeAttributeComposer.getCodeLength());
    assertSame(constantInstruction, instructions[0]);
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions10() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstructions(new Instruction[]{new ConstantInstruction((byte) -71, 1)});

    // Assert
    assertEquals(5, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions11() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstructions(new Instruction[]{new ConstantInstruction((byte) -59, 1)});

    // Assert
    assertEquals(4, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions12() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();

    // Act
    codeAttributeComposer.appendInstructions(new Instruction[]{new ConstantInstruction((byte) -70, 1)});

    // Assert
    assertEquals(5, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test:
   * {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  public void testAppendInstructions13() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    codeAttributeComposer.appendInstructions(new Instruction[]{new BranchInstruction((byte) 'A', 1)});

    // Act
    codeAttributeComposer.appendInstructions(
        new Instruction[]{new LookUpSwitchInstruction((byte) 'A', 1, new int[]{1, 2, 1, 2}, new int[]{1, 2, 1, 2})});

    // Assert
    assertEquals(44, codeAttributeComposer.getCodeLength());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeAttributeComposer#visitAnyAttribute(Clazz, Attribute)}
   *   <li>
   * {@link CodeAttributeComposer#visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction)}
   *   <li>
   * {@link CodeAttributeComposer#visitAnyTargetInfo(Clazz, TypeAnnotation, TargetInfo)}
   *   <li>
   * {@link CodeAttributeComposer#visitAnyVerificationType(Clazz, Method, CodeAttribute, int, VerificationType)}
   *   <li>{@link CodeAttributeComposer#getCodeLength()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();

    // Act
    codeAttributeComposer.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());
    LibraryClass clazz2 = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    codeAttributeComposer.visitAnyInstruction(clazz2, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));
    LibraryClass clazz3 = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    codeAttributeComposer.visitAnyTargetInfo(clazz3, typeAnnotation, new CatchTargetInfo((byte) 'A'));
    LibraryClass clazz4 = new LibraryClass();
    LibraryMethod method2 = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute2 = new CodeAttribute(1);
    codeAttributeComposer.visitAnyVerificationType(clazz4, method2, codeAttribute2, 2,
        VerificationTypeFactory.createDoubleType());

    // Assert that nothing has changed
    assertEquals(0, codeAttributeComposer.getCodeLength());
  }

  /**
   * Method under test: {@link CodeAttributeComposer#CodeAttributeComposer()}
   */
  @Test
  public void testNewCodeAttributeComposer() {
    // Arrange, Act and Assert
    assertEquals(0, (new CodeAttributeComposer()).getCodeLength());
    assertEquals(0, (new CodeAttributeComposer(true, true, true)).getCodeLength());
    assertEquals(0, (new CodeAttributeComposer(true, true, true, true)).getCodeLength());
  }
}
