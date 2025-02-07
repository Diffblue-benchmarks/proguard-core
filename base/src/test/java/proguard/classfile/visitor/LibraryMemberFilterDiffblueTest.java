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

class LibraryMemberFilterDiffblueTest {
  /**
   * Test {@link LibraryMemberFilter#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryMemberFilter#visitLibraryField(LibraryClass, LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.LibraryMemberFilter.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_thenCallsVisitLibraryField() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    LibraryMemberFilter libraryMemberFilter = new LibraryMemberFilter(memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    libraryMemberFilter.visitLibraryField(libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }

  /**
   * Test {@link LibraryMemberFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass,
   *       LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link LibraryMemberFilter#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.LibraryMemberFilter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsVisitLibraryMethod() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    LibraryMemberFilter libraryMemberFilter = new LibraryMemberFilter(memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    libraryMemberFilter.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }
}
