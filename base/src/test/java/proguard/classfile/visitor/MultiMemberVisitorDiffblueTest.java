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

class MultiMemberVisitorDiffblueTest {
  /**
   * Test {@link MultiMemberVisitor#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitProgramField(ProgramClass, ProgramField)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiMemberVisitor#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MultiMemberVisitor.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsVisitProgramField() {
    // Arrange
    MethodImplementationFilter methodImplementationFilter = mock(MethodImplementationFilter.class);
    doNothing()
        .when(methodImplementationFilter)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());
    MultiMemberVisitor multiMemberVisitor = new MultiMemberVisitor(methodImplementationFilter);
    ProgramClass programClass = new ProgramClass();

    // Act
    multiMemberVisitor.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(methodImplementationFilter)
        .visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
  }

  /**
   * Test {@link MultiMemberVisitor#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitProgramMethod(ProgramClass,
   *       ProgramMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiMemberVisitor#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then calls visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MultiMemberVisitor.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsVisitProgramMethod() {
    // Arrange
    MethodImplementationFilter methodImplementationFilter = mock(MethodImplementationFilter.class);
    doNothing()
        .when(methodImplementationFilter)
        .visitProgramMethod(Mockito.<ProgramClass>any(), Mockito.<ProgramMethod>any());
    MultiMemberVisitor multiMemberVisitor = new MultiMemberVisitor(methodImplementationFilter);
    ProgramClass programClass = new ProgramClass();

    // Act
    multiMemberVisitor.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(methodImplementationFilter)
        .visitProgramMethod(isA(ProgramClass.class), isA(ProgramMethod.class));
  }

  /**
   * Test {@link MultiMemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiMemberVisitor#visitLibraryField(LibraryClass, LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MultiMemberVisitor.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_thenCallsVisitLibraryField() {
    // Arrange
    MethodImplementationFilter methodImplementationFilter = mock(MethodImplementationFilter.class);
    doNothing()
        .when(methodImplementationFilter)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    MultiMemberVisitor multiMemberVisitor = new MultiMemberVisitor(methodImplementationFilter);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    multiMemberVisitor.visitLibraryField(libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(methodImplementationFilter)
        .visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }

  /**
   * Test {@link MultiMemberVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass,
   *       LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiMemberVisitor#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MultiMemberVisitor.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsVisitLibraryMethod() {
    // Arrange
    MethodImplementationFilter methodImplementationFilter = mock(MethodImplementationFilter.class);
    doNothing()
        .when(methodImplementationFilter)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MultiMemberVisitor multiMemberVisitor = new MultiMemberVisitor(methodImplementationFilter);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    multiMemberVisitor.visitLibraryMethod(libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(methodImplementationFilter)
        .visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }
}
