package proguard.classfile.util;

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
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.instruction.visitor.InstructionVisitor;

class PrimitiveArrayConstantReplacerDiffblueTest {
  /**
   * Test {@link PrimitiveArrayConstantReplacer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#constantPoolEntriesAccept(ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveArrayConstantReplacer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls constantPoolEntriesAccept(ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.PrimitiveArrayConstantReplacer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsConstantPoolEntriesAccept() {
    // Arrange
    PrimitiveArrayConstantReplacer primitiveArrayConstantReplacer =
        new PrimitiveArrayConstantReplacer();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).constantPoolEntriesAccept(Mockito.<ConstantVisitor>any());

    // Act
    primitiveArrayConstantReplacer.visitProgramClass(programClass);

    // Assert
    verify(programClass).constantPoolEntriesAccept(isA(ConstantVisitor.class));
  }

  /**
   * Test {@link PrimitiveArrayConstantReplacer#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#instructionsAccept(Clazz, Method, InstructionVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveArrayConstantReplacer#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls instructionsAccept(Clazz, Method, InstructionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.PrimitiveArrayConstantReplacer.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsInstructionsAccept() {
    // Arrange
    PrimitiveArrayConstantReplacer primitiveArrayConstantReplacer =
        new PrimitiveArrayConstantReplacer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    primitiveArrayConstantReplacer.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
  }
}
