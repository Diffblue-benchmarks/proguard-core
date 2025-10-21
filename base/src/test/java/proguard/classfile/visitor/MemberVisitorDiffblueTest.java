package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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

public class MemberVisitorDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberVisitor.visitAnyMember(Clazz, Member)"})
  public void testVisitAnyMember_thenThrowUnsupportedOperationException() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> attributeSorter.visitAnyMember(clazz, new LibraryField(1, "Name", "Descriptor")));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberVisitor.visitProgramMember(ProgramClass, ProgramMember)"})
  public void testVisitProgramMember_whenProgramField_thenThrowUnsupportedOperationException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberVisitor.visitLibraryMember(LibraryClass, LibraryMember)"})
  public void testVisitLibraryMember_thenThrowUnsupportedOperationException() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            attributeSorter.visitLibraryMember(
                libraryClass, new LibraryField(1, "Name", "Descriptor")));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberVisitor.visitLibraryField(LibraryClass, LibraryField)"})
  public void testVisitLibraryField_thenThrowUnsupportedOperationException() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            attributeSorter.visitLibraryField(
                libraryClass, new LibraryField(1, "Name", "Descriptor")));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberVisitor.visitLibraryMethod(LibraryClass, LibraryMethod)"})
  public void testVisitLibraryMethod_thenThrowUnsupportedOperationException() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            attributeSorter.visitLibraryMethod(
                libraryClass, new LibraryMethod(1, "Name", "Descriptor")));
  }
}
