package proguard.classfile.editor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;

class InstructionAdderDiffblueTest {
  /**
   * Test {@link InstructionAdder#visitAnyInstruction(Clazz, Method, CodeAttribute, int,
   * Instruction)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttributeComposer#appendInstruction(int, Instruction)}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionAdder#visitAnyInstruction(Clazz, Method, CodeAttribute,
   * int, Instruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction); then calls appendInstruction(int, Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionAdder.visitAnyInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.Instruction)"
  })
  void testVisitAnyInstruction_thenCallsAppendInstruction() {
    // Arrange
    CodeAttributeComposer targetComposer = mock(CodeAttributeComposer.class);
    doNothing().when(targetComposer).appendInstruction(anyInt(), Mockito.<Instruction>any());
    InstructionAdder instructionAdder = new InstructionAdder(new ProgramClass(), targetComposer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionAdder.visitAnyInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert
    verify(targetComposer).appendInstruction(eq(2), isA(Instruction.class));
  }

  /**
   * Test {@link InstructionAdder#visitConstantInstruction(Clazz, Method, CodeAttribute, int,
   * ConstantInstruction)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttributeComposer#appendInstruction(int, Instruction)}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionAdder#visitConstantInstruction(Clazz, Method,
   * CodeAttribute, int, ConstantInstruction)}
   */
  @Test
  @DisplayName(
      "Test visitConstantInstruction(Clazz, Method, CodeAttribute, int, ConstantInstruction); then calls appendInstruction(int, Instruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.InstructionAdder.visitConstantInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.ConstantInstruction)"
  })
  void testVisitConstantInstruction_thenCallsAppendInstruction() {
    // Arrange
    CodeAttributeComposer targetComposer = mock(CodeAttributeComposer.class);
    doNothing().when(targetComposer).appendInstruction(anyInt(), Mockito.<Instruction>any());
    InstructionAdder instructionAdder = new InstructionAdder(new ProgramClass(), targetComposer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    instructionAdder.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1));

    // Assert
    verify(targetComposer).appendInstruction(eq(2), isA(Instruction.class));
  }
}
