package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.editor.InstructionSequenceReplacer.Label;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.classfile.util.BranchTargetFinder;
import proguard.classfile.util.InstructionSequenceMatcher;

class InstructionSequenceReplacerDiffblueTest {
  /**
   * Test Label {@link Label#equals(Object)}, and {@link Label#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Label#equals(Object)}
   *   <li>{@link Label#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Label equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.InstructionSequenceReplacer$Label.equals(java.lang.Object)",
    "int proguard.classfile.editor.InstructionSequenceReplacer$Label.hashCode()"
  })
  void testLabelEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertEquals(labelResult, labelResult);
    int expectedHashCodeResult = labelResult.hashCode();
    assertEquals(expectedHashCodeResult, labelResult.hashCode());
  }

  /**
   * Test Label {@link Label#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Label#equals(Object)}
   */
  @Test
  @DisplayName("Test Label equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.InstructionSequenceReplacer$Label.equals(java.lang.Object)",
    "int proguard.classfile.editor.InstructionSequenceReplacer$Label.hashCode()"
  })
  void testLabelEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertNotEquals(labelResult, InstructionSequenceReplacer.label());
  }

  /**
   * Test Label {@link Label#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Label#equals(Object)}
   */
  @Test
  @DisplayName("Test Label equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.InstructionSequenceReplacer$Label.equals(java.lang.Object)",
    "int proguard.classfile.editor.InstructionSequenceReplacer$Label.hashCode()"
  })
  void testLabelEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InstructionSequenceReplacer.label(), null);
  }

  /**
   * Test Label {@link Label#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Label#equals(Object)}
   */
  @Test
  @DisplayName("Test Label equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.InstructionSequenceReplacer$Label.equals(java.lang.Object)",
    "int proguard.classfile.editor.InstructionSequenceReplacer$Label.hashCode()"
  })
  void testLabelEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InstructionSequenceReplacer.label(), "Different type to Label");
  }

  /**
   * Test Label {@link Label#length(int)}.
   *
   * <p>Method under test: {@link Label#length(int)}
   */
  @Test
  @DisplayName("Test Label length(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.editor.InstructionSequenceReplacer$Label.length(int)"})
  void testLabelLength() {
    // Arrange, Act and Assert
    assertEquals(0, InstructionSequenceReplacer.label().length(2));
  }

  /**
   * Test Label {@link Label#readInfo(byte[], int)}.
   *
   * <p>Method under test: {@link Label#readInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test Label readInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceReplacer$Label.readInfo(byte[], int)"
  })
  void testLabelReadInfo() throws UnsupportedEncodingException {
    // Arrange
    Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> labelResult.readInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test Label {@link Label#shrink()}.
   *
   * <p>Method under test: {@link Label#shrink()}
   */
  @Test
  @DisplayName("Test Label shrink()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.instruction.Instruction proguard.classfile.editor.InstructionSequenceReplacer$Label.shrink()"
  })
  void testLabelShrink() {
    // Arrange
    Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertSame(labelResult, labelResult.shrink());
  }

  /**
   * Test Label {@link Label#writeInfo(byte[], int)}.
   *
   * <p>Method under test: {@link Label#writeInfo(byte[], int)}
   */
  @Test
  @DisplayName("Test Label writeInfo(byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceReplacer$Label.writeInfo(byte[], int)"
  })
  void testLabelWriteInfo() throws UnsupportedEncodingException {
    // Arrange
    Label labelResult = InstructionSequenceReplacer.label();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> labelResult.writeInfo("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link InstructionSequenceReplacer#InstructionSequenceReplacer(InstructionSequenceMatcher,
   * Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)}.
   *
   * <p>Method under test: {@link
   * InstructionSequenceReplacer#InstructionSequenceReplacer(InstructionSequenceMatcher, Constant[],
   * Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)}
   */
  @Test
  @DisplayName(
      "Test new InstructionSequenceReplacer(InstructionSequenceMatcher, Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceReplacer.<init>(proguard.classfile.util.InstructionSequenceMatcher, proguard.classfile.constant.Constant[], proguard.classfile.instruction.Instruction[], proguard.classfile.util.BranchTargetFinder, proguard.classfile.editor.CodeAttributeEditor, proguard.classfile.instruction.visitor.InstructionVisitor)"
  })
  void testNewInstructionSequenceReplacer() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertSame(
        instructionSequenceMatcher,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .getInstructionSequenceMatcher());
  }

  /**
   * Test {@link InstructionSequenceReplacer#InstructionSequenceReplacer(InstructionSequenceMatcher,
   * Constant[], Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor,
   * InstructionVisitor)}.
   *
   * <p>Method under test: {@link
   * InstructionSequenceReplacer#InstructionSequenceReplacer(InstructionSequenceMatcher, Constant[],
   * Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor,
   * InstructionVisitor)}
   */
  @Test
  @DisplayName(
      "Test new InstructionSequenceReplacer(InstructionSequenceMatcher, Constant[], Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceReplacer.<init>(proguard.classfile.util.InstructionSequenceMatcher, proguard.classfile.constant.Constant[], proguard.classfile.instruction.Instruction[], proguard.classfile.constant.Constant[], proguard.classfile.instruction.Instruction[], proguard.classfile.util.BranchTargetFinder, proguard.classfile.editor.CodeAttributeEditor, proguard.classfile.instruction.visitor.InstructionVisitor)"
  })
  void testNewInstructionSequenceReplacer2() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertSame(
        instructionSequenceMatcher,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .getInstructionSequenceMatcher());
  }

  /**
   * Test {@link InstructionSequenceReplacer#InstructionSequenceReplacer(Constant[], Instruction[],
   * Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor)}.
   *
   * <p>Method under test: {@link
   * InstructionSequenceReplacer#InstructionSequenceReplacer(Constant[], Instruction[], Constant[],
   * Instruction[], BranchTargetFinder, CodeAttributeEditor)}
   */
  @Test
  @DisplayName(
      "Test new InstructionSequenceReplacer(Constant[], Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceReplacer.<init>(proguard.classfile.constant.Constant[], proguard.classfile.instruction.Instruction[], proguard.classfile.constant.Constant[], proguard.classfile.instruction.Instruction[], proguard.classfile.util.BranchTargetFinder, proguard.classfile.editor.CodeAttributeEditor)"
  })
  void testNewInstructionSequenceReplacer3() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();

    // Act and Assert
    assertFalse(
        (new InstructionSequenceReplacer(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                new CodeAttributeEditor()))
            .getInstructionSequenceMatcher()
            .isMatching());
  }

  /**
   * Test {@link InstructionSequenceReplacer#InstructionSequenceReplacer(Constant[], Instruction[],
   * Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)}.
   *
   * <p>Method under test: {@link
   * InstructionSequenceReplacer#InstructionSequenceReplacer(Constant[], Instruction[], Constant[],
   * Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)}
   */
  @Test
  @DisplayName(
      "Test new InstructionSequenceReplacer(Constant[], Instruction[], Constant[], Instruction[], BranchTargetFinder, CodeAttributeEditor, InstructionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceReplacer.<init>(proguard.classfile.constant.Constant[], proguard.classfile.instruction.Instruction[], proguard.classfile.constant.Constant[], proguard.classfile.instruction.Instruction[], proguard.classfile.util.BranchTargetFinder, proguard.classfile.editor.CodeAttributeEditor, proguard.classfile.instruction.visitor.InstructionVisitor)"
  })
  void testNewInstructionSequenceReplacer4() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertFalse(
        (new InstructionSequenceReplacer(
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .getInstructionSequenceMatcher()
            .isMatching());
  }

  /**
   * Test {@link InstructionSequenceReplacer#visitAnyInstruction(Clazz, Method, CodeAttribute, int,
   * Instruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#visitAnyInstruction(Clazz, Method,
   * CodeAttribute, int, Instruction)}
   */
  @Test
  @DisplayName("Test visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceReplacer.visitAnyInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.Instruction)"
  })
  void testVisitAnyInstruction() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = mock(InstructionSequenceMatcher.class);
    doNothing().when(instructionSequenceMatcher).reset();
    when(instructionSequenceMatcher.instructionCount()).thenReturn(0);
    when(instructionSequenceMatcher.matchedInstructionOffset(anyInt())).thenReturn(1);
    when(instructionSequenceMatcher.isMatching()).thenReturn(true);
    doNothing()
        .when(instructionSequenceMatcher)
        .visitBranchInstruction(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<BranchInstruction>any());
    Instruction instruction = mock(Instruction.class);
    doNothing()
        .when(instruction)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<InstructionVisitor>any());
    BranchTargetFinder branchTargetFinder = mock(BranchTargetFinder.class);
    when(branchTargetFinder.isTarget(anyInt())).thenReturn(true);
    CodeAttributeEditor codeAttributeEditor = mock(CodeAttributeEditor.class);
    doNothing()
        .when(codeAttributeEditor)
        .insertAfterInstruction(anyInt(), Mockito.<Instruction[]>any());
    InstructionSequenceReplacer instructionSequenceReplacer =
        new InstructionSequenceReplacer(
            instructionSequenceMatcher,
            new Constant[] {new ClassConstant()},
            new Instruction[] {instruction},
            branchTargetFinder,
            codeAttributeEditor,
            null);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceReplacer.visitAnyInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert
    verify(codeAttributeEditor).insertAfterInstruction(eq(1), isA(Instruction[].class));
    verify(instruction)
        .accept(
            isA(Clazz.class),
            isNull(),
            isA(CodeAttribute.class),
            eq(1),
            isA(InstructionVisitor.class));
    verify(branchTargetFinder).isTarget(eq(2));
    verify(instructionSequenceMatcher, atLeast(1)).instructionCount();
    verify(instructionSequenceMatcher).isMatching();
    verify(instructionSequenceMatcher, atLeast(1)).matchedInstructionOffset(eq(-1));
    verify(instructionSequenceMatcher).reset();
    verify(instructionSequenceMatcher)
        .visitBranchInstruction(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(BranchInstruction.class));
  }

  /**
   * Test {@link InstructionSequenceReplacer#visitAnyInstruction(Clazz, Method, CodeAttribute, int,
   * Instruction)}.
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#visitAnyInstruction(Clazz, Method,
   * CodeAttribute, int, Instruction)}
   */
  @Test
  @DisplayName("Test visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceReplacer.visitAnyInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.Instruction)"
  })
  void testVisitAnyInstruction2() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = mock(InstructionSequenceMatcher.class);
    doNothing().when(instructionSequenceMatcher).reset();
    when(instructionSequenceMatcher.instructionCount()).thenReturn(0);
    when(instructionSequenceMatcher.matchedInstructionOffset(anyInt())).thenReturn(1);
    when(instructionSequenceMatcher.isMatching()).thenReturn(true);
    doNothing()
        .when(instructionSequenceMatcher)
        .visitBranchInstruction(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<BranchInstruction>any());
    Instruction instruction = mock(Instruction.class);
    doNothing()
        .when(instruction)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<InstructionVisitor>any());
    BranchTargetFinder branchTargetFinder = mock(BranchTargetFinder.class);
    when(branchTargetFinder.isTarget(anyInt())).thenReturn(true);
    CodeAttributeEditor codeAttributeEditor = mock(CodeAttributeEditor.class);
    doNothing()
        .when(codeAttributeEditor)
        .insertAfterInstruction(anyInt(), Mockito.<Instruction[]>any());
    InstructionSequenceReplacer instructionSequenceReplacer =
        new InstructionSequenceReplacer(
            instructionSequenceMatcher,
            new Constant[] {new ClassConstant()},
            new Instruction[] {instruction},
            branchTargetFinder,
            codeAttributeEditor,
            new BootstrapMethodsAttributeShrinker());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceReplacer.visitAnyInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert
    verify(codeAttributeEditor).insertAfterInstruction(eq(1), isA(Instruction[].class));
    verify(instruction)
        .accept(
            isA(Clazz.class),
            isNull(),
            isA(CodeAttribute.class),
            eq(1),
            isA(InstructionVisitor.class));
    verify(branchTargetFinder).isTarget(eq(2));
    verify(instructionSequenceMatcher, atLeast(1)).instructionCount();
    verify(instructionSequenceMatcher).isMatching();
    verify(instructionSequenceMatcher, atLeast(1)).matchedInstructionOffset(eq(-1));
    verify(instructionSequenceMatcher).reset();
    verify(instructionSequenceMatcher)
        .visitBranchInstruction(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(BranchInstruction.class));
  }

  /**
   * Test {@link InstructionSequenceReplacer#visitAnyInstruction(Clazz, Method, CodeAttribute, int,
   * Instruction)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttributeEditor#isModified(int)}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#visitAnyInstruction(Clazz, Method,
   * CodeAttribute, int, Instruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction); then calls isModified(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceReplacer.visitAnyInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.Instruction)"
  })
  void testVisitAnyInstruction_thenCallsIsModified() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = mock(InstructionSequenceMatcher.class);
    doNothing().when(instructionSequenceMatcher).reset();
    when(instructionSequenceMatcher.instructionCount()).thenReturn(3);
    when(instructionSequenceMatcher.matchedInstructionOffset(anyInt())).thenReturn(1);
    when(instructionSequenceMatcher.isMatching()).thenReturn(true);
    doNothing()
        .when(instructionSequenceMatcher)
        .visitBranchInstruction(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<BranchInstruction>any());
    BranchTargetFinder branchTargetFinder = mock(BranchTargetFinder.class);
    when(branchTargetFinder.isTarget(anyInt())).thenReturn(true);
    CodeAttributeEditor codeAttributeEditor = mock(CodeAttributeEditor.class);
    when(codeAttributeEditor.isModified(anyInt())).thenReturn(true);
    InstructionSequenceReplacer instructionSequenceReplacer =
        new InstructionSequenceReplacer(
            instructionSequenceMatcher,
            new Constant[] {new ClassConstant()},
            new Instruction[] {mock(Instruction.class)},
            branchTargetFinder,
            codeAttributeEditor,
            new MaxStackSizeComputer());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceReplacer.visitAnyInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert
    verify(codeAttributeEditor).isModified(eq(1));
    verify(branchTargetFinder).isTarget(eq(2));
    verify(instructionSequenceMatcher).instructionCount();
    verify(instructionSequenceMatcher).isMatching();
    verify(instructionSequenceMatcher).matchedInstructionOffset(eq(0));
    verify(instructionSequenceMatcher).reset();
    verify(instructionSequenceMatcher)
        .visitBranchInstruction(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(BranchInstruction.class));
  }

  /**
   * Test {@link InstructionSequenceReplacer#visitAnyInstruction(Clazz, Method, CodeAttribute, int,
   * Instruction)}.
   *
   * <ul>
   *   <li>Then calls {@link InstructionSequenceMatcher#visitConstantInstruction(Clazz, Method,
   *       CodeAttribute, int, ConstantInstruction)}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#visitAnyInstruction(Clazz, Method,
   * CodeAttribute, int, Instruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction); then calls visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionSequenceReplacer.visitAnyInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.Instruction)"
  })
  void testVisitAnyInstruction_thenCallsVisitConstantInstruction() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = mock(InstructionSequenceMatcher.class);
    doNothing()
        .when(instructionSequenceMatcher)
        .visitConstantInstruction(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<ConstantInstruction>any());
    doNothing().when(instructionSequenceMatcher).reset();
    when(instructionSequenceMatcher.instructionCount()).thenReturn(0);
    when(instructionSequenceMatcher.matchedInstructionOffset(anyInt())).thenReturn(1);
    when(instructionSequenceMatcher.isMatching()).thenReturn(true);
    Instruction instruction = mock(Instruction.class);
    doNothing()
        .when(instruction)
        .accept(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            anyInt(),
            Mockito.<InstructionVisitor>any());
    BranchTargetFinder branchTargetFinder = mock(BranchTargetFinder.class);
    when(branchTargetFinder.isTarget(anyInt())).thenReturn(true);
    CodeAttributeEditor codeAttributeEditor = mock(CodeAttributeEditor.class);
    doNothing()
        .when(codeAttributeEditor)
        .insertAfterInstruction(anyInt(), Mockito.<Instruction[]>any());
    InstructionSequenceReplacer instructionSequenceReplacer =
        new InstructionSequenceReplacer(
            instructionSequenceMatcher,
            new Constant[] {new ClassConstant()},
            new Instruction[] {instruction},
            branchTargetFinder,
            codeAttributeEditor,
            new MaxStackSizeComputer());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionSequenceReplacer.visitAnyInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction());

    // Assert
    verify(codeAttributeEditor).insertAfterInstruction(eq(1), isA(Instruction[].class));
    verify(instruction)
        .accept(
            isA(Clazz.class),
            isNull(),
            isA(CodeAttribute.class),
            eq(1),
            isA(InstructionVisitor.class));
    verify(branchTargetFinder).isTarget(eq(2));
    verify(instructionSequenceMatcher, atLeast(1)).instructionCount();
    verify(instructionSequenceMatcher).isMatching();
    verify(instructionSequenceMatcher, atLeast(1)).matchedInstructionOffset(eq(-1));
    verify(instructionSequenceMatcher).reset();
    verify(instructionSequenceMatcher)
        .visitConstantInstruction(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            eq(2),
            isA(ConstantInstruction.class));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedArgument(int)} with {@code argument}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedArgument(int)}
   */
  @Test
  @DisplayName("Test matchedArgument(int) with 'argument'; when one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.InstructionSequenceReplacer.matchedArgument(int)"
  })
  void testMatchedArgumentWithArgument_whenOne_thenReturnOne() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        1,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedArgument(1));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedArgument(int)} with {@code argument}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#X}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedArgument(int)}
   */
  @Test
  @DisplayName("Test matchedArgument(int) with 'argument'; when X; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.InstructionSequenceReplacer.matchedArgument(int)"
  })
  void testMatchedArgumentWithArgument_whenX_thenReturnZero() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        0,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedArgument(InstructionSequenceReplacer.X));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedArgument(Clazz, int)} with {@code clazz}, {@code
   * argument}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedArgument(Clazz, int)}
   */
  @Test
  @DisplayName(
      "Test matchedArgument(Clazz, int) with 'clazz', 'argument'; when one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.InstructionSequenceReplacer.matchedArgument(proguard.classfile.Clazz, int)"
  })
  void testMatchedArgumentWithClazzArgument_whenOne_thenReturnOne() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    InstructionSequenceReplacer instructionSequenceReplacer =
        new InstructionSequenceReplacer(
            instructionSequenceMatcher,
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)},
            branchTargetFinder,
            codeAttributeEditor,
            new MaxStackSizeComputer());

    // Act and Assert
    assertEquals(1, instructionSequenceReplacer.matchedArgument(new LibraryClass(), 1));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedArgument(Clazz, Method, CodeAttribute, int,
   * int)} with {@code clazz}, {@code method}, {@code codeAttribute}, {@code offset}, {@code
   * argument}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedArgument(Clazz, Method,
   * CodeAttribute, int, int)}
   */
  @Test
  @DisplayName(
      "Test matchedArgument(Clazz, Method, CodeAttribute, int, int) with 'clazz', 'method', 'codeAttribute', 'offset', 'argument'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.InstructionSequenceReplacer.matchedArgument(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, int)"
  })
  void testMatchedArgumentWithClazzMethodCodeAttributeOffsetArgument_thenReturnOne() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    InstructionSequenceReplacer instructionSequenceReplacer =
        new InstructionSequenceReplacer(
            instructionSequenceMatcher,
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)},
            branchTargetFinder,
            codeAttributeEditor,
            new MaxStackSizeComputer());
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        1, instructionSequenceReplacer.matchedArgument(clazz, method, new CodeAttribute(1), 2, 1));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedConstantIndex(ProgramClass, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedConstantIndex(ProgramClass,
   * int)}
   */
  @Test
  @DisplayName("Test matchedConstantIndex(ProgramClass, int); when one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.InstructionSequenceReplacer.matchedConstantIndex(proguard.classfile.ProgramClass, int)"
  })
  void testMatchedConstantIndex_whenOne_thenReturnOne() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher = mock(InstructionSequenceMatcher.class);
    when(instructionSequenceMatcher.matchedConstantIndex(anyInt())).thenReturn(1);
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    InstructionSequenceReplacer instructionSequenceReplacer =
        new InstructionSequenceReplacer(
            instructionSequenceMatcher,
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)},
            branchTargetFinder,
            codeAttributeEditor,
            new MaxStackSizeComputer());

    // Act
    int actualMatchedConstantIndexResult =
        instructionSequenceReplacer.matchedConstantIndex(new ProgramClass(), 1);

    // Assert
    verify(instructionSequenceMatcher).matchedConstantIndex(eq(1));
    assertEquals(1, actualMatchedConstantIndexResult);
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@code -16777216}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @DisplayName("Test matchedBranchOffset(int, int); when '-16777216'; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.InstructionSequenceReplacer.matchedBranchOffset(int, int)"
  })
  void testMatchedBranchOffset_when16777216_thenReturnThree() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(-16777216, 3));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   *   <li>Then return {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @DisplayName(
      "Test matchedBranchOffset(int, int); when STRING_A_LENGTH; then return STRING_A_LENGTH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.InstructionSequenceReplacer.matchedBranchOffset(int, int)"
  })
  void testMatchedBranchOffset_whenString_a_length_thenReturnString_a_length() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        InstructionSequenceReplacer.STRING_A_LENGTH,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(2, InstructionSequenceReplacer.STRING_A_LENGTH));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#STRING_A_LENGTH}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @DisplayName("Test matchedBranchOffset(int, int); when STRING_A_LENGTH; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.InstructionSequenceReplacer.matchedBranchOffset(int, int)"
  })
  void testMatchedBranchOffset_whenString_a_length_thenReturnThree() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(InstructionSequenceReplacer.STRING_A_LENGTH, 3));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @DisplayName("Test matchedBranchOffset(int, int); when two; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.InstructionSequenceReplacer.matchedBranchOffset(int, int)"
  })
  void testMatchedBranchOffset_whenTwo_thenReturnThree() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(2, 3));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#X}.
   *   <li>Then return minus two.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @DisplayName("Test matchedBranchOffset(int, int); when X; then return minus two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.InstructionSequenceReplacer.matchedBranchOffset(int, int)"
  })
  void testMatchedBranchOffset_whenX_thenReturnMinusTwo() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        -2,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(2, InstructionSequenceReplacer.X));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}.
   *
   * <ul>
   *   <li>When {@link InstructionSequenceReplacer#X}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedBranchOffset(int, int)}
   */
  @Test
  @DisplayName("Test matchedBranchOffset(int, int); when X; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.editor.InstructionSequenceReplacer.matchedBranchOffset(int, int)"
  })
  void testMatchedBranchOffset_whenX_thenReturnThree() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 3)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertEquals(
        3,
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 3)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedBranchOffset(InstructionSequenceReplacer.X, 3));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with minus two and {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}
   */
  @Test
  @DisplayName(
      "Test matchedJumpOffsets(int, int[]); then return array of int with minus two and '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.classfile.editor.InstructionSequenceReplacer.matchedJumpOffsets(int, int[])"
  })
  void testMatchedJumpOffsets_thenReturnArrayOfIntWithMinusTwoAnd16777216() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertArrayEquals(
        new int[] {-2, -16777216, 1, -16777216},
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedJumpOffsets(
                2, new int[] {InstructionSequenceReplacer.X, -16777216, 1, -16777216}));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with one and {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}
   */
  @Test
  @DisplayName(
      "Test matchedJumpOffsets(int, int[]); then return array of int with one and '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.classfile.editor.InstructionSequenceReplacer.matchedJumpOffsets(int, int[])"
  })
  void testMatchedJumpOffsets_thenReturnArrayOfIntWithOneAnd16777216() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertArrayEquals(
        new int[] {1, -16777216, 1, -16777216},
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedJumpOffsets(2, new int[] {1, -16777216, 1, -16777216}));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with {@link InstructionSequenceReplacer#STRING_A_LENGTH}
   *       and {@code -16777216}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedJumpOffsets(int, int[])}
   */
  @Test
  @DisplayName(
      "Test matchedJumpOffsets(int, int[]); then return array of int with STRING_A_LENGTH and '-16777216'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.classfile.editor.InstructionSequenceReplacer.matchedJumpOffsets(int, int[])"
  })
  void testMatchedJumpOffsets_thenReturnArrayOfIntWithString_a_lengthAnd16777216() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertArrayEquals(
        new int[] {InstructionSequenceReplacer.STRING_A_LENGTH, -16777216, 1, -16777216},
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .matchedJumpOffsets(
                2,
                new int[] {InstructionSequenceReplacer.STRING_A_LENGTH, -16777216, 1, -16777216}));
  }

  /**
   * Test {@link InstructionSequenceReplacer#getInstructionSequenceMatcher()}.
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#getInstructionSequenceMatcher()}
   */
  @Test
  @DisplayName("Test getInstructionSequenceMatcher()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.util.InstructionSequenceMatcher proguard.classfile.editor.InstructionSequenceReplacer.getInstructionSequenceMatcher()"
  })
  void testGetInstructionSequenceMatcher() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act
    InstructionSequenceMatcher actualInstructionSequenceMatcher =
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .getInstructionSequenceMatcher();

    // Assert
    assertFalse(actualInstructionSequenceMatcher.isMatching());
    assertSame(instructionSequenceMatcher, actualInstructionSequenceMatcher);
  }

  /**
   * Test {@link InstructionSequenceReplacer#wasConstant(int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#wasConstant(int)}
   */
  @Test
  @DisplayName("Test wasConstant(int); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.editor.InstructionSequenceReplacer.wasConstant(int)"
  })
  void testWasConstant_thenReturnFalse() {
    // Arrange
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();

    // Act and Assert
    assertFalse(
        (new InstructionSequenceReplacer(
                instructionSequenceMatcher,
                new Constant[] {new ClassConstant()},
                new Instruction[] {new BranchInstruction((byte) 'A', 1)},
                branchTargetFinder,
                codeAttributeEditor,
                new MaxStackSizeComputer()))
            .wasConstant(1));
  }

  /**
   * Test {@link InstructionSequenceReplacer#matchedConstant(ProgramClass, int)}.
   *
   * <ul>
   *   <li>Then return {@link ClassConstant#ClassConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#matchedConstant(ProgramClass, int)}
   */
  @Test
  @DisplayName("Test matchedConstant(ProgramClass, int); then return ClassConstant()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.constant.Constant proguard.classfile.editor.InstructionSequenceReplacer.matchedConstant(proguard.classfile.ProgramClass, int)"
  })
  void testMatchedConstant_thenReturnClassConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    InstructionSequenceMatcher instructionSequenceMatcher =
        new InstructionSequenceMatcher(
            new Constant[] {classConstant, new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    CodeAttributeEditor codeAttributeEditor = new CodeAttributeEditor();
    InstructionSequenceReplacer instructionSequenceReplacer =
        new InstructionSequenceReplacer(
            instructionSequenceMatcher,
            new Constant[] {new ClassConstant()},
            new Instruction[] {new BranchInstruction((byte) 'A', 1)},
            branchTargetFinder,
            codeAttributeEditor,
            new MaxStackSizeComputer());
    ClassConstant classConstant2 = new ClassConstant();

    // Act and Assert
    assertSame(
        classConstant2,
        instructionSequenceReplacer.matchedConstant(
            new ProgramClass(
                InstructionSequenceReplacer.X,
                3,
                new Constant[] {classConstant2},
                InstructionSequenceReplacer.X,
                InstructionSequenceReplacer.X,
                InstructionSequenceReplacer.X),
            1));
  }

  /**
   * Test {@link InstructionSequenceReplacer#label()}.
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#label()}
   */
  @Test
  @DisplayName("Test label()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceReplacer$Label proguard.classfile.editor.InstructionSequenceReplacer.label()"
  })
  void testLabel() {
    // Arrange and Act
    Label actualLabelResult = InstructionSequenceReplacer.label();

    // Assert
    assertEquals("nop", actualLabelResult.getName());
    assertEquals((byte) 0, actualLabelResult.opcode);
    assertFalse(actualLabelResult.isCategory2());
  }

  /**
   * Test {@link InstructionSequenceReplacer#catch_(int, int, int)}.
   *
   * <p>Method under test: {@link InstructionSequenceReplacer#catch_(int, int, int)}
   */
  @Test
  @DisplayName("Test catch_(int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.InstructionSequenceReplacer$Label proguard.classfile.editor.InstructionSequenceReplacer.catch_(int, int, int)"
  })
  void testCatch_() {
    // Arrange and Act
    Label actualCatch_Result = InstructionSequenceReplacer.catch_(1, 3, 1);

    // Assert
    assertEquals("nop", actualCatch_Result.getName());
    assertEquals((byte) 0, actualCatch_Result.opcode);
    assertFalse(actualCatch_Result.isCategory2());
  }
}
