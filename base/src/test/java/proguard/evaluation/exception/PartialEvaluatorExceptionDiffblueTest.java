package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import proguard.classfile.LibraryMember;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.visitor.ClassVisitor;
import proguard.classfile.visitor.MemberVisitor;

class PartialEvaluatorExceptionDiffblueTest {
  /**
   * Test {@link PartialEvaluatorException#PartialEvaluatorException(int, Throwable, Clazz, Method,
   * String, String[])}.
   *
   * <p>Method under test: {@link PartialEvaluatorException#PartialEvaluatorException(int,
   * Throwable, Clazz, Method, String, String[])}
   */
  @Test
  @DisplayName(
      "Test new PartialEvaluatorException(int, Throwable, Clazz, Method, String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.PartialEvaluatorException.<init>(int, java.lang.Throwable, proguard.classfile.Clazz, proguard.classfile.Method, java.lang.String, java.lang.String[])"
  })
  void testNewPartialEvaluatorException() {
    // Arrange
    Throwable cause = new Throwable();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    String[] errorParameters = new String[] {"An error occurred"};

    // Act
    PartialEvaluatorException actualPartialEvaluatorException =
        new PartialEvaluatorException(
            1, cause, clazz, method, "An error occurred", errorParameters);

    // Assert
    Object[] errorParameters2 = actualPartialEvaluatorException.getErrorParameters();
    assertTrue(errorParameters2 instanceof String[]);
    Clazz clazz2 = actualPartialEvaluatorException.getClazz();
    assertTrue(clazz2 instanceof LibraryClass);
    Method method2 = actualPartialEvaluatorException.getMethod();
    assertTrue(method2 instanceof LibraryMethod);
    assertEquals("An error occurred", actualPartialEvaluatorException.getLocalizedMessage());
    assertEquals("An error occurred", actualPartialEvaluatorException.getMessage());
    assertEquals(0, actualPartialEvaluatorException.getSuppressed().length);
    assertEquals(1, actualPartialEvaluatorException.getComponentErrorId());
    assertEquals(1, errorParameters2.length);
    assertSame(cause, actualPartialEvaluatorException.getCause());
    assertSame(clazz, clazz2);
    assertSame(method, method2);
    assertSame(errorParameters, errorParameters2);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PartialEvaluatorException#getClazz()}
   *   <li>{@link PartialEvaluatorException#getMethod()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Clazz proguard.evaluation.exception.PartialEvaluatorException.getClazz()",
    "proguard.classfile.Method proguard.evaluation.exception.PartialEvaluatorException.getMethod()"
  })
  void testGettersAndSetters() {
    // Arrange
    Throwable cause = new Throwable();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    PartialEvaluatorException partialEvaluatorException =
        new PartialEvaluatorException(
            1, cause, clazz, method, "An error occurred", "An error occurred");

    // Act
    Clazz actualClazz = partialEvaluatorException.getClazz();

    // Assert
    assertSame(clazz, actualClazz);
    assertSame(method, partialEvaluatorException.getMethod());
  }

  /**
   * Test {@link PartialEvaluatorException#classAccept(ClassVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluatorException#classAccept(ClassVisitor)}
   */
  @Test
  @DisplayName("Test classAccept(ClassVisitor); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.PartialEvaluatorException.classAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testClassAccept_thenCallsVisitLibraryClass() {
    // Arrange
    Throwable cause = new Throwable();
    LibraryClass clazz = new LibraryClass();
    PartialEvaluatorException partialEvaluatorException =
        new PartialEvaluatorException(
            1,
            cause,
            clazz,
            new LibraryMethod(1, "Name", "Descriptor"),
            "An error occurred",
            "An error occurred");
    ClassVisitor visitor = mock(ClassVisitor.class);
    doNothing().when(visitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    partialEvaluatorException.classAccept(visitor);

    // Assert
    verify(visitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link PartialEvaluatorException#methodAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryMethod} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluatorException#methodAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test methodAccept(MemberVisitor); given LibraryMethod accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.PartialEvaluatorException.methodAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testMethodAccept_givenLibraryMethodAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    Throwable cause = new Throwable();
    PartialEvaluatorException partialEvaluatorException =
        new PartialEvaluatorException(
            1, cause, new LibraryClass(), method, "An error occurred", "An error occurred");

    // Act
    partialEvaluatorException.methodAccept(new AttributeSorter());

    // Assert
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
  }
}
