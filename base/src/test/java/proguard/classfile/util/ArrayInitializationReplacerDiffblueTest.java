package proguard.classfile.util;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import proguard.classfile.instruction.Instruction;
import proguard.classfile.visitor.MemberVisitor;

class ArrayInitializationReplacerDiffblueTest {
  /**
   * Test {@link ArrayInitializationReplacer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#methodsAccept(MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayInitializationReplacer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then calls methodsAccept(MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ArrayInitializationReplacer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsMethodsAccept() {
    // Arrange
    ArrayInitializationReplacer arrayInitializationReplacer = new ArrayInitializationReplacer();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    arrayInitializationReplacer.visitProgramClass(programClass);

    // Assert
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link ArrayInitializationReplacer#visitAnyInstruction(Clazz, Method, CodeAttribute, int,
   * Instruction)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then calls {@link Instruction#stackPushCount(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayInitializationReplacer#visitAnyInstruction(Clazz, Method,
   * CodeAttribute, int, Instruction)}
   */
  @Test
  @DisplayName(
      "Test visitAnyInstruction(Clazz, Method, CodeAttribute, int, Instruction); given three; then calls stackPushCount(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.ArrayInitializationReplacer.visitAnyInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.Instruction)"
  })
  void testVisitAnyInstruction_givenThree_thenCallsStackPushCount() {
    // Arrange
    ArrayInitializationReplacer arrayInitializationReplacer = new ArrayInitializationReplacer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    BranchInstruction instruction = mock(BranchInstruction.class);
    when(instruction.stackPushCount(Mockito.<Clazz>any())).thenReturn(3);

    // Act
    arrayInitializationReplacer.visitAnyInstruction(clazz, method, codeAttribute, 2, instruction);

    // Assert
    verify(instruction).stackPushCount(isA(Clazz.class));
  }
}
