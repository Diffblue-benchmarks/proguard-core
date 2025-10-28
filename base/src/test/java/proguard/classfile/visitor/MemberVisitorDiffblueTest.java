package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
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
   * Method under test: {@link MemberVisitor#visitAnyMember(Clazz, Member)}
   */
  @Test
  public void testVisitAnyMember() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> attributeSorter.visitAnyMember(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Method under test:
   * {@link MemberVisitor#visitProgramMember(ProgramClass, ProgramMember)}
   */
  @Test
  public void testVisitProgramMember() {
    // Arrange
    BootstrapMethodsAttributeShrinker bootstrapMethodsAttributeShrinker = new BootstrapMethodsAttributeShrinker();
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> bootstrapMethodsAttributeShrinker.visitProgramMember(programClass, new ProgramField()));
  }

  /**
   * Method under test:
   * {@link MemberVisitor#visitLibraryMember(LibraryClass, LibraryMember)}
   */
  @Test
  public void testVisitLibraryMember() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> attributeSorter.visitLibraryMember(libraryClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Method under test:
   * {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}
   */
  @Test
  public void testVisitLibraryField() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> attributeSorter.visitLibraryField(libraryClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Method under test:
   * {@link MemberVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}
   */
  @Test
  public void testVisitLibraryMethod() {
    // Arrange
    AttributeSorter attributeSorter = new AttributeSorter();
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> attributeSorter.visitLibraryMethod(libraryClass, new LibraryMethod(1, "Name", "Descriptor")));
  }
}
