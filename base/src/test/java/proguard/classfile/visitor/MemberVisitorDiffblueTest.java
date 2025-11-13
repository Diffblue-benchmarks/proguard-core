package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMember;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMember;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.editor.BootstrapMethodsAttributeShrinker;

class MemberVisitorDiffblueTest {
  /**
   * Test {@link MemberVisitor#visitAnyMember(Clazz, Member)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MemberVisitor#visitAnyMember(Clazz, Member)}
   */
  @Test
  @DisplayName("Test visitAnyMember(Clazz, Member); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberVisitor.visitAnyMember(Clazz, Member)"})
  void testVisitAnyMember_thenThrowUnsupportedOperationException() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> attributeSorter.visitAnyMember(clazz, member));
  }

  /**
   * Test {@link MemberVisitor#visitProgramMember(ProgramClass, ProgramMember)}.
   *
   * <ul>
   *   <li>When {@link ProgramField#ProgramField()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MemberVisitor#visitProgramMember(ProgramClass, ProgramMember)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMember(ProgramClass, ProgramMember); when ProgramField(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberVisitor.visitProgramMember(ProgramClass, ProgramMember)"})
  void testVisitProgramMember_whenProgramField_thenThrowUnsupportedOperationException() {
    // Arrange
    BootstrapMethodsAttributeShrinker bootstrapMethodsAttributeShrinker =
        new BootstrapMethodsAttributeShrinker();
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            bootstrapMethodsAttributeShrinker.visitProgramMember(programClass, new ProgramField()));
  }

  /**
   * Test {@link MemberVisitor#visitLibraryMember(LibraryClass, LibraryMember)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MemberVisitor#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMember(LibraryClass, LibraryMember); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberVisitor.visitLibraryMember(LibraryClass, LibraryMember)"})
  void testVisitLibraryMember_thenThrowUnsupportedOperationException() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryMember = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> attributeSorter.visitLibraryMember(libraryClass, libraryMember));
  }

  /**
   * Test {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberVisitor.visitLibraryField(LibraryClass, LibraryField)"})
  void testVisitLibraryField_thenThrowUnsupportedOperationException() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass libraryClass = new LibraryClass();
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> attributeSorter.visitLibraryField(libraryClass, libraryField));
  }

  /**
   * Test {@link MemberVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MemberVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemberVisitor.visitLibraryMethod(LibraryClass, LibraryMethod)"})
  void testVisitLibraryMethod_thenThrowUnsupportedOperationException() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass libraryClass = new LibraryClass();
    LibraryMethod libraryMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> attributeSorter.visitLibraryMethod(libraryClass, libraryMethod));
  }
}
