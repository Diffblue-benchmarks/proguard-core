package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;
import proguard.classfile.editor.AttributeSorter;

class MethodFilterDiffblueTest {
  /**
   * Test {@link MethodFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitProgramField(ProgramClass, ProgramField)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodFilter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsVisitProgramField() {
    // Arrange
    MethodImplementationFilter fieldMemberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(fieldMemberVisitor)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());
    MethodFilter methodFilter = new MethodFilter(new AttributeSorter(), fieldMemberVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    methodFilter.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(fieldMemberVisitor).visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
  }

  /**
   * Test {@link MethodFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitProgramMethod(ProgramClass,
   *       ProgramMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodFilter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then calls visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsVisitProgramMethod() {
    // Arrange
    MethodImplementationFilter methodMemberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(methodMemberVisitor)
        .visitProgramMethod(Mockito.<ProgramClass>any(), Mockito.<ProgramMethod>any());
    MethodFilter methodFilter = new MethodFilter(methodMemberVisitor, new AttributeSorter());
    ProgramClass programClass = new ProgramClass();

    // Act
    methodFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(methodMemberVisitor)
        .visitProgramMethod(isA(ProgramClass.class), isA(ProgramMethod.class));
  }

  /**
   * Test {@link MethodFilter#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodFilter#visitLibraryField(LibraryClass, LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodFilter.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_thenCallsVisitLibraryField() {
    // Arrange
    MethodImplementationFilter fieldMemberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(fieldMemberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    MethodFilter methodFilter = new MethodFilter(new AttributeSorter(), fieldMemberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    methodFilter.visitLibraryField(libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(fieldMemberVisitor).visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }

  /**
   * Test {@link MethodFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass,
   *       LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodFilter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsVisitLibraryMethod() {
    // Arrange
    MethodImplementationFilter methodMemberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(methodMemberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MethodFilter methodFilter = new MethodFilter(methodMemberVisitor, new AttributeSorter());
    LibraryClass libraryClass = new LibraryClass();

    // Act
    methodFilter.visitLibraryMethod(libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(methodMemberVisitor)
        .visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }
}
