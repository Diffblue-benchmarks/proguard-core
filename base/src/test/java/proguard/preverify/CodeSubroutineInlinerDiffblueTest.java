package proguard.preverify;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.visitor.ExceptionInfoVisitor;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.exception.ProguardCoreException;

class CodeSubroutineInlinerDiffblueTest {
  /**
   * Test {@link CodeSubroutineInliner#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link CodeSubroutineInliner#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.preverify.CodeSubroutineInliner.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute() throws UnsupportedEncodingException {
    // Arrange
    CodeSubroutineInliner codeSubroutineInliner = new CodeSubroutineInliner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            codeSubroutineInliner.visitCodeAttribute(
                clazz, method, new CodeAttribute(1, 3, 3, -1, "AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link CodeSubroutineInliner#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link CodeSubroutineInliner#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); when 'A'; then throw ProguardCoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.preverify.CodeSubroutineInliner.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_whenA_thenThrowProguardCoreException() {
    // Arrange
    CodeSubroutineInliner codeSubroutineInliner = new CodeSubroutineInliner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            codeSubroutineInliner.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(1, 3, 3, 3, new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test {@link CodeSubroutineInliner#visitCodeAttribute0(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#exceptionsAccept(Clazz, Method, ExceptionInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link CodeSubroutineInliner#visitCodeAttribute0(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute0(Clazz, Method, CodeAttribute); then calls exceptionsAccept(Clazz, Method, ExceptionInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.preverify.CodeSubroutineInliner.visitCodeAttribute0(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute0_thenCallsExceptionsAccept() {
    // Arrange
    CodeSubroutineInliner codeSubroutineInliner = new CodeSubroutineInliner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .exceptionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<ExceptionInfoVisitor>any());
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    codeSubroutineInliner.visitCodeAttribute0(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute)
        .exceptionsAccept(isA(Clazz.class), isA(Method.class), isA(ExceptionInfoVisitor.class));
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
  }
}
