package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;

class BottomClassFilterDiffblueTest {
  /**
   * Test {@link BottomClassFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link BottomClassFilter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.BottomClassFilter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    BottomClassFilter bottomClassFilter =
        new BottomClassFilter(mock(ClassVisitor.class), mock(ClassVisitor.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bottomClassFilter.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link BottomClassFilter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Given {@link ClassVisitor} {@link ClassVisitor#visitProgramClass(ProgramClass)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link BottomClassFilter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); given ClassVisitor visitProgramClass(ProgramClass) does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.BottomClassFilter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_givenClassVisitorVisitProgramClassDoesNothing() {
    // Arrange
    ClassVisitor bottomClassVisitor = mock(ClassVisitor.class);
    doNothing().when(bottomClassVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    BottomClassFilter bottomClassFilter =
        new BottomClassFilter(bottomClassVisitor, mock(ClassVisitor.class));

    // Act
    bottomClassFilter.visitProgramClass(new ProgramClass());

    // Assert
    verify(bottomClassVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link BottomClassFilter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link BottomClassFilter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); when ProgramClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.BottomClassFilter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_whenProgramClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassVisitor bottomClassVisitor = mock(ClassVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(bottomClassVisitor)
        .visitProgramClass(Mockito.<ProgramClass>any());
    BottomClassFilter bottomClassFilter = new BottomClassFilter(bottomClassVisitor);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bottomClassFilter.visitProgramClass(new ProgramClass()));
    verify(bottomClassVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link BottomClassFilter#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Given {@link ClassVisitor} {@link ClassVisitor#visitLibraryClass(LibraryClass)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link BottomClassFilter#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryClass(LibraryClass); given ClassVisitor visitLibraryClass(LibraryClass) does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.BottomClassFilter.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_givenClassVisitorVisitLibraryClassDoesNothing() {
    // Arrange
    ClassVisitor bottomClassVisitor = mock(ClassVisitor.class);
    doNothing().when(bottomClassVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    BottomClassFilter bottomClassFilter =
        new BottomClassFilter(bottomClassVisitor, mock(ClassVisitor.class));

    // Act
    bottomClassFilter.visitLibraryClass(new LibraryClass());

    // Assert
    verify(bottomClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link BottomClassFilter#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link BottomClassFilter#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryClass(LibraryClass); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.BottomClassFilter.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassVisitor bottomClassVisitor = mock(ClassVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(bottomClassVisitor)
        .visitLibraryClass(Mockito.<LibraryClass>any());
    BottomClassFilter bottomClassFilter = new BottomClassFilter(bottomClassVisitor);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bottomClassFilter.visitLibraryClass(new LibraryClass()));
    verify(bottomClassVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
