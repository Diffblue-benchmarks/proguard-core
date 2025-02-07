package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.editor.InitializerEditor.CodeBuilder;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.visitor.MemberVisitor;
import proguard.testutils.cpa.NamedMember;

class InitializerEditorDiffblueTest {
  /**
   * Test {@link InitializerEditor#addStaticInitializerInstructions(boolean, CodeBuilder)} with
   * {@code mergeIntoExistingInitializer}, {@code codeBuilder}.
   *
   * <p>Method under test: {@link InitializerEditor#addStaticInitializerInstructions(boolean,
   * CodeBuilder)}
   */
  @Test
  @DisplayName(
      "Test addStaticInitializerInstructions(boolean, CodeBuilder) with 'mergeIntoExistingInitializer', 'codeBuilder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InitializerEditor.addStaticInitializerInstructions(boolean, proguard.classfile.editor.InitializerEditor$CodeBuilder)"
  })
  void testAddStaticInitializerInstructionsWithMergeIntoExistingInitializerCodeBuilder() {
    // Arrange
    InitializerEditor initializerEditor =
        new InitializerEditor(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    CodeBuilder codeBuilder = mock(CodeBuilder.class);
    doNothing().when(codeBuilder).build(Mockito.<InstructionSequenceBuilder>any());

    // Act
    initializerEditor.addStaticInitializerInstructions(true, codeBuilder);

    // Assert
    verify(codeBuilder).build(isA(InstructionSequenceBuilder.class));
  }

  /**
   * Test {@link InitializerEditor#addStaticInitializerInstructions(boolean, CodeBuilder)} with
   * {@code mergeIntoExistingInitializer}, {@code codeBuilder}.
   *
   * <p>Method under test: {@link InitializerEditor#addStaticInitializerInstructions(boolean,
   * CodeBuilder)}
   */
  @Test
  @DisplayName(
      "Test addStaticInitializerInstructions(boolean, CodeBuilder) with 'mergeIntoExistingInitializer', 'codeBuilder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InitializerEditor.addStaticInitializerInstructions(boolean, proguard.classfile.editor.InitializerEditor$CodeBuilder)"
  })
  void testAddStaticInitializerInstructionsWithMergeIntoExistingInitializerCodeBuilder2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    InitializerEditor initializerEditor =
        new InitializerEditor(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    CodeBuilder codeBuilder = mock(CodeBuilder.class);
    doNothing().when(codeBuilder).build(Mockito.<InstructionSequenceBuilder>any());

    // Act
    initializerEditor.addStaticInitializerInstructions(true, codeBuilder);

    // Assert
    verify(codeBuilder).build(isA(InstructionSequenceBuilder.class));
  }

  /**
   * Test {@link InitializerEditor#addStaticInitializerInstructions(boolean, CodeBuilder)} with
   * {@code mergeIntoExistingInitializer}, {@code codeBuilder}.
   *
   * <p>Method under test: {@link InitializerEditor#addStaticInitializerInstructions(boolean,
   * CodeBuilder)}
   */
  @Test
  @DisplayName(
      "Test addStaticInitializerInstructions(boolean, CodeBuilder) with 'mergeIntoExistingInitializer', 'codeBuilder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InitializerEditor.addStaticInitializerInstructions(boolean, proguard.classfile.editor.InitializerEditor$CodeBuilder)"
  })
  void testAddStaticInitializerInstructionsWithMergeIntoExistingInitializerCodeBuilder3() {
    // Arrange
    CodeBuilder codeBuilder = mock(CodeBuilder.class);
    doNothing().when(codeBuilder).build(Mockito.<InstructionSequenceBuilder>any());

    InitializerEditor initializerEditor =
        new InitializerEditor(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    initializerEditor.addStaticInitializerInstructions(false, codeBuilder);
    CodeBuilder codeBuilder2 = mock(CodeBuilder.class);
    doNothing().when(codeBuilder2).build(Mockito.<InstructionSequenceBuilder>any());

    // Act
    initializerEditor.addStaticInitializerInstructions(true, codeBuilder2);

    // Assert
    verify(codeBuilder).build(isA(InstructionSequenceBuilder.class));
    verify(codeBuilder2).build(isA(InstructionSequenceBuilder.class));
  }

  /**
   * Test {@link InitializerEditor#addStaticInitializerInstructions(boolean, Instruction[])} with
   * {@code mergeIntoExistingInitializer}, {@code instructions}.
   *
   * <p>Method under test: {@link InitializerEditor#addStaticInitializerInstructions(boolean,
   * Instruction[])}
   */
  @Test
  @DisplayName(
      "Test addStaticInitializerInstructions(boolean, Instruction[]) with 'mergeIntoExistingInitializer', 'instructions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InitializerEditor.addStaticInitializerInstructions(boolean, proguard.classfile.instruction.Instruction[])"
  })
  void testAddStaticInitializerInstructionsWithMergeIntoExistingInitializerInstructions() {
    // Arrange
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ProgramMethod());
    InitializerEditor initializerEditor = new InitializerEditor(programClass);

    // Act
    initializerEditor.addStaticInitializerInstructions(
        true, new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    // Assert
    verify(programClass).findMethod(eq("<clinit>"), eq("()V"));
  }

  /**
   * Test {@link InitializerEditor#addStaticInitializerInstructions(boolean, Instruction[])} with
   * {@code mergeIntoExistingInitializer}, {@code instructions}.
   *
   * <p>Method under test: {@link InitializerEditor#addStaticInitializerInstructions(boolean,
   * Instruction[])}
   */
  @Test
  @DisplayName(
      "Test addStaticInitializerInstructions(boolean, Instruction[]) with 'mergeIntoExistingInitializer', 'instructions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InitializerEditor.addStaticInitializerInstructions(boolean, proguard.classfile.instruction.Instruction[])"
  })
  void testAddStaticInitializerInstructionsWithMergeIntoExistingInitializerInstructions2() {
    // Arrange
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new NamedMember("<clinit>", "<clinit>"));
    InitializerEditor initializerEditor = new InitializerEditor(programClass);

    // Act
    initializerEditor.addStaticInitializerInstructions(
        true, new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    // Assert
    verify(programClass).findMethod(eq("<clinit>"), eq("()V"));
  }

  /**
   * Test {@link InitializerEditor#addInitializerInstructions(CodeBuilder)} with {@code
   * codeBuilder}.
   *
   * <p>Method under test: {@link InitializerEditor#addInitializerInstructions(CodeBuilder)}
   */
  @Test
  @DisplayName("Test addInitializerInstructions(CodeBuilder) with 'codeBuilder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InitializerEditor.addInitializerInstructions(proguard.classfile.editor.InitializerEditor$CodeBuilder)"
  })
  void testAddInitializerInstructionsWithCodeBuilder() {
    // Arrange
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());
    when(programClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ProgramMethod());
    InitializerEditor initializerEditor = new InitializerEditor(programClass);
    CodeBuilder codeBuilder = mock(CodeBuilder.class);
    doNothing().when(codeBuilder).build(Mockito.<InstructionSequenceBuilder>any());

    // Act
    initializerEditor.addInitializerInstructions(codeBuilder);

    // Assert
    verify(programClass, atLeast(1)).findMethod(Mockito.<String>any(), Mockito.<String>any());
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
    verify(codeBuilder).build(isA(InstructionSequenceBuilder.class));
  }

  /**
   * Test {@link InitializerEditor#addInitializerInstructions(CodeBuilder)} with {@code
   * codeBuilder}.
   *
   * <p>Method under test: {@link InitializerEditor#addInitializerInstructions(CodeBuilder)}
   */
  @Test
  @DisplayName("Test addInitializerInstructions(CodeBuilder) with 'codeBuilder'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InitializerEditor.addInitializerInstructions(proguard.classfile.editor.InitializerEditor$CodeBuilder)"
  })
  void testAddInitializerInstructionsWithCodeBuilder2() {
    // Arrange
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());
    when(programClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new NamedMember("<init>", "<init>"));
    InitializerEditor initializerEditor = new InitializerEditor(programClass);
    CodeBuilder codeBuilder = mock(CodeBuilder.class);
    doNothing().when(codeBuilder).build(Mockito.<InstructionSequenceBuilder>any());

    // Act
    initializerEditor.addInitializerInstructions(codeBuilder);

    // Assert
    verify(programClass, atLeast(1)).findMethod(Mockito.<String>any(), Mockito.<String>any());
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
    verify(codeBuilder).build(isA(InstructionSequenceBuilder.class));
  }

  /**
   * Test {@link InitializerEditor#addInitializerInstructions(Instruction[])} with {@code
   * instructions}.
   *
   * <p>Method under test: {@link InitializerEditor#addInitializerInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test addInitializerInstructions(Instruction[]) with 'instructions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InitializerEditor.addInitializerInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAddInitializerInstructionsWithInstructions() {
    // Arrange
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());
    when(programClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ProgramMethod());
    InitializerEditor initializerEditor = new InitializerEditor(programClass);

    // Act
    initializerEditor.addInitializerInstructions(
        new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    // Assert
    verify(programClass, atLeast(1)).findMethod(Mockito.<String>any(), Mockito.<String>any());
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link InitializerEditor#addInitializerInstructions(Instruction[])} with {@code
   * instructions}.
   *
   * <p>Method under test: {@link InitializerEditor#addInitializerInstructions(Instruction[])}
   */
  @Test
  @DisplayName("Test addInitializerInstructions(Instruction[]) with 'instructions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InitializerEditor.addInitializerInstructions(proguard.classfile.instruction.Instruction[])"
  })
  void testAddInitializerInstructionsWithInstructions2() {
    // Arrange
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());
    when(programClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new NamedMember("<init>", "<init>"));
    InitializerEditor initializerEditor = new InitializerEditor(programClass);

    // Act
    initializerEditor.addInitializerInstructions(
        new Instruction[] {new BranchInstruction((byte) 'A', 1)});

    // Assert
    verify(programClass, atLeast(1)).findMethod(Mockito.<String>any(), Mockito.<String>any());
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
  }
}
