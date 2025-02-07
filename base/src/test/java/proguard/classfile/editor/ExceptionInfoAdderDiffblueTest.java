package proguard.classfile.editor;

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
import proguard.classfile.attribute.ExceptionInfo;

class ExceptionInfoAdderDiffblueTest {
  /**
   * Test {@link ExceptionInfoAdder#ExceptionInfoAdder(ProgramClass, CodeAttributeComposer)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttributeComposer#appendException(ExceptionInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionInfoAdder#ExceptionInfoAdder(ProgramClass,
   * CodeAttributeComposer)}
   */
  @Test
  @DisplayName(
      "Test new ExceptionInfoAdder(ProgramClass, CodeAttributeComposer); then calls appendException(ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ExceptionInfoAdder.<init>(proguard.classfile.ProgramClass, proguard.classfile.editor.CodeAttributeComposer)"
  })
  void testNewExceptionInfoAdder_thenCallsAppendException() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    CodeAttributeComposer targetComposer = mock(CodeAttributeComposer.class);
    doNothing().when(targetComposer).appendException(Mockito.<ExceptionInfo>any());

    // Act
    ExceptionInfoAdder actualExceptionInfoAdder =
        new ExceptionInfoAdder(targetClass, targetComposer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    actualExceptionInfoAdder.visitExceptionInfo(
        clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1));

    // Assert
    verify(targetComposer).appendException(isA(ExceptionInfo.class));
  }

  /**
   * Test {@link ExceptionInfoAdder#ExceptionInfoAdder(ProgramClass, CodeAttributeComposer)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttributeComposer#appendException(ExceptionInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionInfoAdder#ExceptionInfoAdder(ProgramClass,
   * CodeAttributeComposer)}
   */
  @Test
  @DisplayName(
      "Test new ExceptionInfoAdder(ProgramClass, CodeAttributeComposer); then calls appendException(ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ExceptionInfoAdder.<init>(proguard.classfile.ProgramClass, proguard.classfile.editor.CodeAttributeComposer)"
  })
  void testNewExceptionInfoAdder_thenCallsAppendException2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    CodeAttributeComposer targetComposer = mock(CodeAttributeComposer.class);
    doNothing().when(targetComposer).appendException(Mockito.<ExceptionInfo>any());

    // Act
    ExceptionInfoAdder actualExceptionInfoAdder =
        new ExceptionInfoAdder(targetClass, targetComposer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    actualExceptionInfoAdder.visitExceptionInfo(
        clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 0));

    // Assert
    verify(targetComposer).appendException(isA(ExceptionInfo.class));
  }

  /**
   * Test {@link ExceptionInfoAdder#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <p>Method under test: {@link ExceptionInfoAdder#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName("Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ExceptionInfoAdder.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo() {
    // Arrange
    CodeAttributeComposer targetComposer = mock(CodeAttributeComposer.class);
    doNothing().when(targetComposer).appendException(Mockito.<ExceptionInfo>any());
    ExceptionInfoAdder exceptionInfoAdder =
        new ExceptionInfoAdder(new ProgramClass(), targetComposer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    exceptionInfoAdder.visitExceptionInfo(
        clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 0));

    // Assert
    verify(targetComposer).appendException(isA(ExceptionInfo.class));
  }

  /**
   * Test {@link ExceptionInfoAdder#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttributeComposer#appendException(ExceptionInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionInfoAdder#visitExceptionInfo(Clazz, Method,
   * CodeAttribute, ExceptionInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo); then calls appendException(ExceptionInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ExceptionInfoAdder.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo_thenCallsAppendException() {
    // Arrange
    CodeAttributeComposer targetComposer = mock(CodeAttributeComposer.class);
    doNothing().when(targetComposer).appendException(Mockito.<ExceptionInfo>any());
    ExceptionInfoAdder exceptionInfoAdder =
        new ExceptionInfoAdder(new ProgramClass(), targetComposer);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    exceptionInfoAdder.visitExceptionInfo(
        clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1));

    // Assert
    verify(targetComposer).appendException(isA(ExceptionInfo.class));
  }
}
