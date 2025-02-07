package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import proguard.classfile.attribute.BootstrapMethodInfo;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.classfile.visitor.ClassVisitor;
import proguard.classfile.visitor.MemberVisitor;

class BootstrapMethodsAttributeShrinkerDiffblueTest {
  /**
   * Test {@link BootstrapMethodsAttributeShrinker#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass} {@link ProgramClass#accept(ClassVisitor)} does nothing.
   *   <li>Then calls {@link ProgramClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodsAttributeShrinker#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); when ProgramClass accept(ClassVisitor) does nothing; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.BootstrapMethodsAttributeShrinker.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_whenProgramClassAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    BootstrapMethodsAttributeShrinker bootstrapMethodsAttributeShrinker =
        new BootstrapMethodsAttributeShrinker();
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());
    doNothing().when(programClass).attributesAccept(Mockito.<AttributeVisitor>any());
    doNothing().when(programClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    bootstrapMethodsAttributeShrinker.visitProgramClass(programClass);

    // Assert
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass).attributesAccept(isA(AttributeVisitor.class));
    verify(programClass).methodsAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link BootstrapMethodsAttributeShrinker#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#instructionsAccept(Clazz, Method, InstructionVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodsAttributeShrinker#visitCodeAttribute(Clazz,
   * Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls instructionsAccept(Clazz, Method, InstructionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.BootstrapMethodsAttributeShrinker.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsInstructionsAccept() {
    // Arrange
    BootstrapMethodsAttributeShrinker bootstrapMethodsAttributeShrinker =
        new BootstrapMethodsAttributeShrinker();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    bootstrapMethodsAttributeShrinker.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
  }

  /**
   * Test {@link BootstrapMethodsAttributeShrinker#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BootstrapMethodsAttributeShrinker#visitBootstrapMethodsAttribute(Clazz,
   * BootstrapMethodsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitBootstrapMethodsAttribute(Clazz, BootstrapMethodsAttribute); when ProgramClass(); then first element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.BootstrapMethodsAttributeShrinker.visitBootstrapMethodsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.BootstrapMethodsAttribute)"
  })
  void testVisitBootstrapMethodsAttribute_whenProgramClass_thenFirstElementIsNull() {
    // Arrange
    BootstrapMethodsAttributeShrinker bootstrapMethodsAttributeShrinker =
        new BootstrapMethodsAttributeShrinker();
    ProgramClass clazz = new ProgramClass();
    BootstrapMethodsAttribute bootstrapMethodsAttribute =
        new BootstrapMethodsAttribute(1, 1, new BootstrapMethodInfo[] {new BootstrapMethodInfo()});

    // Act
    bootstrapMethodsAttributeShrinker.visitBootstrapMethodsAttribute(
        clazz, bootstrapMethodsAttribute);

    // Assert
    BootstrapMethodInfo[] bootstrapMethodInfoArray = bootstrapMethodsAttribute.bootstrapMethods;
    assertNull(bootstrapMethodInfoArray[0]);
    assertEquals(0, bootstrapMethodsAttribute.u2bootstrapMethodsCount);
    assertEquals(1, bootstrapMethodInfoArray.length);
  }
}
