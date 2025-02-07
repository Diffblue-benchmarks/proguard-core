package proguard.classfile.visitor;

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
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;
import proguard.classfile.editor.AttributeSorter;

class VariableMemberVisitorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableMemberVisitor#VariableMemberVisitor()}
   *   <li>{@link VariableMemberVisitor#setMemberVisitor(MemberVisitor)}
   *   <li>{@link VariableMemberVisitor#getMemberVisitor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.VariableMemberVisitor.<init>()",
    "void proguard.classfile.visitor.VariableMemberVisitor.<init>(proguard.classfile.visitor.MemberVisitor)",
    "proguard.classfile.visitor.MemberVisitor proguard.classfile.visitor.VariableMemberVisitor.getMemberVisitor()",
    "void proguard.classfile.visitor.VariableMemberVisitor.setMemberVisitor(proguard.classfile.visitor.MemberVisitor)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    VariableMemberVisitor actualVariableMemberVisitor = new VariableMemberVisitor();
    AttributeSorter memberVisitor = new AttributeSorter();
    actualVariableMemberVisitor.setMemberVisitor(memberVisitor);
    MemberVisitor actualMemberVisitor = actualVariableMemberVisitor.getMemberVisitor();

    // Assert
    assertTrue(actualMemberVisitor instanceof AttributeSorter);
    assertSame(memberVisitor, actualMemberVisitor);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link AttributeSorter} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VariableMemberVisitor#VariableMemberVisitor(MemberVisitor)}
   *   <li>{@link VariableMemberVisitor#setMemberVisitor(MemberVisitor)}
   *   <li>{@link VariableMemberVisitor#getMemberVisitor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when AttributeSorter (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.VariableMemberVisitor.<init>()",
    "void proguard.classfile.visitor.VariableMemberVisitor.<init>(proguard.classfile.visitor.MemberVisitor)",
    "proguard.classfile.visitor.MemberVisitor proguard.classfile.visitor.VariableMemberVisitor.getMemberVisitor()",
    "void proguard.classfile.visitor.VariableMemberVisitor.setMemberVisitor(proguard.classfile.visitor.MemberVisitor)"
  })
  void testGettersAndSetters_whenAttributeSorter() {
    // Arrange and Act
    VariableMemberVisitor actualVariableMemberVisitor =
        new VariableMemberVisitor(new AttributeSorter());
    AttributeSorter memberVisitor = new AttributeSorter();
    actualVariableMemberVisitor.setMemberVisitor(memberVisitor);
    MemberVisitor actualMemberVisitor = actualVariableMemberVisitor.getMemberVisitor();

    // Assert
    assertTrue(actualMemberVisitor instanceof AttributeSorter);
    assertSame(memberVisitor, actualMemberVisitor);
  }

  /**
   * Test {@link VariableMemberVisitor#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitProgramField(ProgramClass, ProgramField)}.
   * </ul>
   *
   * <p>Method under test: {@link VariableMemberVisitor#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls visitProgramField(ProgramClass, ProgramField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.VariableMemberVisitor.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsVisitProgramField() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());

    VariableMemberVisitor variableMemberVisitor = new VariableMemberVisitor();
    variableMemberVisitor.setMemberVisitor(memberVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    variableMemberVisitor.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(memberVisitor).visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
  }

  /**
   * Test {@link VariableMemberVisitor#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitProgramMethod(ProgramClass,
   *       ProgramMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link VariableMemberVisitor#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then calls visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.VariableMemberVisitor.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsVisitProgramMethod() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramMethod(Mockito.<ProgramClass>any(), Mockito.<ProgramMethod>any());

    VariableMemberVisitor variableMemberVisitor = new VariableMemberVisitor();
    variableMemberVisitor.setMemberVisitor(memberVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    variableMemberVisitor.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(memberVisitor).visitProgramMethod(isA(ProgramClass.class), isA(ProgramMethod.class));
  }

  /**
   * Test {@link VariableMemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link VariableMemberVisitor#visitLibraryField(LibraryClass,
   * LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.VariableMemberVisitor.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_thenCallsVisitLibraryField() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());

    VariableMemberVisitor variableMemberVisitor = new VariableMemberVisitor();
    variableMemberVisitor.setMemberVisitor(memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    variableMemberVisitor.visitLibraryField(
        libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }

  /**
   * Test {@link VariableMemberVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass,
   *       LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link VariableMemberVisitor#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.VariableMemberVisitor.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsVisitLibraryMethod() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());

    VariableMemberVisitor variableMemberVisitor = new VariableMemberVisitor();
    variableMemberVisitor.setMemberVisitor(memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    variableMemberVisitor.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }
}
