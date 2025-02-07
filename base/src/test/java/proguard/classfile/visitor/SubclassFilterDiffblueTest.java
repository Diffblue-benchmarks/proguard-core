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

class SubclassFilterDiffblueTest {
  /**
   * Test {@link SubclassFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link SubclassFilter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SubclassFilter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    SubclassFilter subclassFilter =
        new SubclassFilter(new LibraryClass(), mock(ClassVisitor.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> subclassFilter.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link SubclassFilter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()}.
   *   <li>When {@link ProgramClass#ProgramClass()} addSubClass {@link LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link SubclassFilter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); given LibraryClass(); when ProgramClass() addSubClass LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SubclassFilter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_givenLibraryClass_whenProgramClassAddSubClassLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    SubclassFilter subclassFilter = new SubclassFilter(new LibraryClass(), classVisitor);

    ProgramClass programClass = new ProgramClass();
    programClass.addSubClass(new LibraryClass());

    // Act
    subclassFilter.visitProgramClass(programClass);

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link SubclassFilter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link SubclassFilter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SubclassFilter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(classVisitor)
        .visitProgramClass(Mockito.<ProgramClass>any());
    SubclassFilter subclassFilter = new SubclassFilter(new LibraryClass(), classVisitor);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> subclassFilter.visitProgramClass(new ProgramClass()));
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link SubclassFilter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then calls {@link ClassVisitor#visitProgramClass(ProgramClass)}.
   * </ul>
   *
   * <p>Method under test: {@link SubclassFilter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); when ProgramClass(); then calls visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SubclassFilter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_whenProgramClass_thenCallsVisitProgramClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    SubclassFilter subclassFilter = new SubclassFilter(new LibraryClass(), classVisitor);

    // Act
    subclassFilter.visitProgramClass(new ProgramClass());

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link SubclassFilter#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()}.
   *   <li>When {@link LibraryClass#LibraryClass()} addSubClass {@link LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link SubclassFilter#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryClass(LibraryClass); given LibraryClass(); when LibraryClass() addSubClass LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SubclassFilter.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_givenLibraryClass_whenLibraryClassAddSubClassLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    SubclassFilter subclassFilter = new SubclassFilter(new LibraryClass(), classVisitor);

    LibraryClass libraryClass = new LibraryClass();
    libraryClass.addSubClass(new LibraryClass());

    // Act
    subclassFilter.visitLibraryClass(libraryClass);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link SubclassFilter#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link SubclassFilter#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SubclassFilter.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doThrow(new UnsupportedOperationException("foo"))
        .when(classVisitor)
        .visitLibraryClass(Mockito.<LibraryClass>any());
    SubclassFilter subclassFilter = new SubclassFilter(new LibraryClass(), classVisitor);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> subclassFilter.visitLibraryClass(new LibraryClass()));
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link SubclassFilter#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link SubclassFilter#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryClass(LibraryClass); when LibraryClass(); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.SubclassFilter.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_whenLibraryClass_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    SubclassFilter subclassFilter = new SubclassFilter(new LibraryClass(), classVisitor);

    // Act
    subclassFilter.visitLibraryClass(new LibraryClass());

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
