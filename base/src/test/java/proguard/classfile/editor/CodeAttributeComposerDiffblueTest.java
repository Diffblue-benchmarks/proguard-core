package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LineNumberTableAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.TypeAnnotationsAttribute;
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.TargetInfo;
import proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor;
import proguard.classfile.attribute.annotation.visitor.TypeAnnotationVisitor;
import proguard.classfile.attribute.preverification.VerificationType;
import proguard.classfile.attribute.preverification.VerificationTypeFactory;
import proguard.classfile.attribute.visitor.LineNumberInfoVisitor;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.SwitchInstruction;
import proguard.classfile.instruction.TableSwitchInstruction;
import proguard.classfile.instruction.VariableInstruction;

class CodeAttributeComposerDiffblueTest {
  /**
   * Test {@link CodeAttributeComposer#CodeAttributeComposer()}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#CodeAttributeComposer()}
   */
  @Test
  @DisplayName("Test new CodeAttributeComposer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.CodeAttributeComposer.<init>()"})
  void testNewCodeAttributeComposer() {
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
  @DisplayName("Test new CodeAttributeComposer(boolean, boolean, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.<init>(boolean, boolean, boolean)"
  })
  void testNewCodeAttributeComposer2() {
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
  @DisplayName("Test new CodeAttributeComposer(boolean, boolean, boolean, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.<init>(boolean, boolean, boolean, boolean)"
  })
  void testNewCodeAttributeComposer3() {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.CodeAttributeComposer.getCodeLength()",
    "void proguard.classfile.editor.CodeAttributeComposer.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)",
    "void proguard.classfile.editor.CodeAttributeComposer.visitAnyInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.Instruction)",
    "void proguard.classfile.editor.CodeAttributeComposer.visitAnyTargetInfo(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.TargetInfo)",
    "void proguard.classfile.editor.CodeAttributeComposer.visitAnyVerificationType(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.attribute.preverification.VerificationType)"
  })
  void testGettersAndSetters() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction2() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction3() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction4() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction5() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction6() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction7() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction8() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction9() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction10() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction11() {
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
  @DisplayName("Test appendInstruction(Instruction) with 'instruction'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction12() {
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
  @DisplayName(
      "Test appendInstruction(Instruction) with 'instruction'; then VariableInstruction() Name is 'nop'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstruction(proguard.classfile.instruction.Instruction)"
  })
  void testAppendInstructionWithInstruction_thenVariableInstructionNameIsNop() {
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
  @DisplayName("Test endCodeFragment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.editor.CodeAttributeComposer.endCodeFragment()"})
  void testEndCodeFragment() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> (new CodeAttributeComposer()).endCodeFragment());
  }

  /**
   * Test {@link CodeAttributeComposer#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link LineNumberTableAttribute#lineNumbersAccept(Clazz, Method,
   *       CodeAttribute, LineNumberInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute); then calls lineNumbersAccept(Clazz, Method, CodeAttribute, LineNumberInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.visitLineNumberTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute_thenCallsLineNumbersAccept() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LineNumberTableAttribute lineNumberTableAttribute = mock(LineNumberTableAttribute.class);
    doNothing()
        .when(lineNumberTableAttribute)
        .lineNumbersAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LineNumberInfoVisitor>any());

    // Act
    codeAttributeComposer.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, lineNumberTableAttribute);

    // Assert
    verify(lineNumberTableAttribute)
        .lineNumbersAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LineNumberInfoVisitor.class));
  }

  /**
   * Test {@link CodeAttributeComposer#visitAnyTypeAnnotationsAttribute(Clazz,
   * TypeAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link TypeAnnotationsAttribute#typeAnnotationsAccept(Clazz,
   *       TypeAnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#visitAnyTypeAnnotationsAttribute(Clazz,
   * TypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyTypeAnnotationsAttribute(Clazz, TypeAnnotationsAttribute); then calls typeAnnotationsAccept(Clazz, TypeAnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.visitAnyTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotationsAttribute)"
  })
  void testVisitAnyTypeAnnotationsAttribute_thenCallsTypeAnnotationsAccept() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    TypeAnnotationsAttribute typeAnnotationsAttribute = mock(TypeAnnotationsAttribute.class);
    doNothing()
        .when(typeAnnotationsAttribute)
        .typeAnnotationsAccept(Mockito.<Clazz>any(), Mockito.<TypeAnnotationVisitor>any());

    // Act
    codeAttributeComposer.visitAnyTypeAnnotationsAttribute(clazz, typeAnnotationsAttribute);

    // Assert
    verify(typeAnnotationsAttribute)
        .typeAnnotationsAccept(isA(Clazz.class), isA(TypeAnnotationVisitor.class));
  }

  /**
   * Test {@link CodeAttributeComposer#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * CodeAttributeComposer#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    RuntimeVisibleTypeAnnotationsAttribute runtimeVisibleTypeAnnotationsAttribute =
        mock(RuntimeVisibleTypeAnnotationsAttribute.class);
    doNothing()
        .when(runtimeVisibleTypeAnnotationsAttribute)
        .typeAnnotationsAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<TypeAnnotationVisitor>any());

    // Act
    codeAttributeComposer.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, runtimeVisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeVisibleTypeAnnotationsAttribute)
        .typeAnnotationsAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(TypeAnnotationVisitor.class));
  }

  /**
   * Test {@link CodeAttributeComposer#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * CodeAttributeComposer#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    RuntimeInvisibleTypeAnnotationsAttribute runtimeInvisibleTypeAnnotationsAttribute =
        mock(RuntimeInvisibleTypeAnnotationsAttribute.class);
    doNothing()
        .when(runtimeInvisibleTypeAnnotationsAttribute)
        .typeAnnotationsAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<TypeAnnotationVisitor>any());

    // Act
    codeAttributeComposer.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz, method, codeAttribute, runtimeInvisibleTypeAnnotationsAttribute);

    // Assert
    verify(runtimeInvisibleTypeAnnotationsAttribute)
        .typeAnnotationsAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(TypeAnnotationVisitor.class));
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
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction); when minus one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction_whenMinusOne_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.visitAnySwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SwitchInstruction)"
  })
  void testVisitAnySwitchInstruction_thenThrowIllegalArgumentException() {
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
  @DisplayName(
      "Test visitAnySwitchInstruction(Clazz, Method, CodeAttribute, int, SwitchInstruction); when minus one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.visitAnySwitchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.SwitchInstruction)"
  })
  void testVisitAnySwitchInstruction_whenMinusOne_thenThrowIllegalArgumentException() {
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
   * Test {@link CodeAttributeComposer#visitTypeAnnotation(Clazz, Method, CodeAttribute,
   * TypeAnnotation)} with {@code clazz}, {@code method}, {@code codeAttribute}, {@code
   * typeAnnotation}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#visitTypeAnnotation(Clazz, Method,
   * CodeAttribute, TypeAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAnnotation(Clazz, Method, CodeAttribute, TypeAnnotation) with 'clazz', 'method', 'codeAttribute', 'typeAnnotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.visitTypeAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.TypeAnnotation)"
  })
  void testVisitTypeAnnotationWithClazzMethodCodeAttributeTypeAnnotation() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = mock(TypeAnnotation.class);
    doNothing()
        .when(typeAnnotation)
        .targetInfoAccept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<TargetInfoVisitor>any());

    // Act
    codeAttributeComposer.visitTypeAnnotation(clazz, method, codeAttribute, typeAnnotation);

    // Assert
    verify(typeAnnotation)
        .targetInfoAccept(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(TargetInfoVisitor.class));
  }

  /**
   * Test {@link CodeAttributeComposer#visitTypeAnnotation(Clazz, TypeAnnotation)} with {@code
   * clazz}, {@code typeAnnotation}.
   *
   * <ul>
   *   <li>Then calls {@link TypeAnnotation#targetInfoAccept(Clazz, TargetInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link CodeAttributeComposer#visitTypeAnnotation(Clazz, TypeAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAnnotation(Clazz, TypeAnnotation) with 'clazz', 'typeAnnotation'; then calls targetInfoAccept(Clazz, TargetInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.visitTypeAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotation)"
  })
  void testVisitTypeAnnotationWithClazzTypeAnnotation_thenCallsTargetInfoAccept() {
    // Arrange
    CodeAttributeComposer codeAttributeComposer = new CodeAttributeComposer();
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = mock(TypeAnnotation.class);
    doNothing()
        .when(typeAnnotation)
        .targetInfoAccept(Mockito.<Clazz>any(), Mockito.<TargetInfoVisitor>any());

    // Act
    codeAttributeComposer.visitTypeAnnotation(clazz, typeAnnotation);

    // Assert
    verify(typeAnnotation).targetInfoAccept(isA(Clazz.class), isA(TargetInfoVisitor.class));
  }

  /**
   * Test {@link CodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <p>Method under test: {@link CodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test appendInstructions(Instruction[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions() {
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
  @DisplayName("Test appendInstructions(Instruction[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions2() {
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
  @DisplayName("Test appendInstructions(Instruction[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions3() {
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
  @DisplayName("Test appendInstructions(Instruction[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions4() {
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
  @DisplayName("Test appendInstructions(Instruction[]); then first element LookUpSwitchInstruction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementLookUpSwitchInstruction() {
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
  @DisplayName("Test appendInstructions(Instruction[]); then first element Name is 'goto_w'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementNameIsGotoW() {
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
  @DisplayName("Test appendInstructions(Instruction[]); then first element Name is 'invokedynamic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementNameIsInvokedynamic() {
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
  @DisplayName(
      "Test appendInstructions(Instruction[]); then first element Name is 'invokeinterface'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementNameIsInvokeinterface() {
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
  @DisplayName("Test appendInstructions(Instruction[]); then first element Name is 'ldc'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementNameIsLdc() {
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
  @DisplayName(
      "Test appendInstructions(Instruction[]); then first element Name is 'multianewarray'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementNameIsMultianewarray() {
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
  @DisplayName("Test appendInstructions(Instruction[]); then first element Name is 'nop'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementNameIsNop() {
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
  @DisplayName("Test appendInstructions(Instruction[]); then first element SimpleInstruction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementSimpleInstruction() {
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
  @DisplayName("Test appendInstructions(Instruction[]); then first element TableSwitchInstruction")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.CodeAttributeComposer.appendInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAppendInstructions_thenFirstElementTableSwitchInstruction() {
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
