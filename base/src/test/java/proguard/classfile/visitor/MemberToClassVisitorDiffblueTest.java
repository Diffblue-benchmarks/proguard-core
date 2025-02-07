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

class MemberToClassVisitorDiffblueTest {
  /**
   * Test {@link MemberToClassVisitor#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <p>Method under test: {@link MemberToClassVisitor#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName("Test visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberToClassVisitor.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    MemberToClassVisitor memberToClassVisitor = new MemberToClassVisitor(classVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    memberToClassVisitor.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link MemberToClassVisitor#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberToClassVisitor#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberToClassVisitor.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitProgramClass(Mockito.<ProgramClass>any());
    MemberToClassVisitor memberToClassVisitor = new MemberToClassVisitor(classVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    memberToClassVisitor.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(classVisitor).visitProgramClass(isA(ProgramClass.class));
  }

  /**
   * Test {@link MemberToClassVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <p>Method under test: {@link MemberToClassVisitor#visitLibraryField(LibraryClass,
   * LibraryField)}
   */
  @Test
  @DisplayName("Test visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberToClassVisitor.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    MemberToClassVisitor memberToClassVisitor = new MemberToClassVisitor(classVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberToClassVisitor.visitLibraryField(libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link MemberToClassVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <p>Method under test: {@link MemberToClassVisitor#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName("Test visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberToClassVisitor.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    MemberToClassVisitor memberToClassVisitor = new MemberToClassVisitor(classVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberToClassVisitor.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
