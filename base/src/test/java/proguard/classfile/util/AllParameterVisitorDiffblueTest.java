package proguard.classfile.util;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.visitor.ParameterVisitor;
import proguard.testutils.cpa.NamedField;

class AllParameterVisitorDiffblueTest {
  /**
   * Test {@link AllParameterVisitor#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link ParameterVisitor#visitParameter(Clazz, Member, int, int, int, int,
   *       String, Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AllParameterVisitor#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls visitParameter(Clazz, Member, int, int, int, int, String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.AllParameterVisitor.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsVisitParameter() {
    // Arrange
    ParameterVisitor parameterVisitor = mock(ParameterVisitor.class);
    doNothing()
        .when(parameterVisitor)
        .visitParameter(
            Mockito.<Clazz>any(),
            Mockito.<Member>any(),
            anyInt(),
            anyInt(),
            anyInt(),
            anyInt(),
            Mockito.<String>any(),
            Mockito.<Clazz>any());
    AllParameterVisitor allParameterVisitor = new AllParameterVisitor(true, parameterVisitor);
    ProgramClass programClass = new ProgramClass();

    // Act
    allParameterVisitor.visitProgramField(
        programClass, new NamedField("Field Name", "Field Descriptor"));

    // Assert
    verify(parameterVisitor)
        .visitParameter(
            isA(Clazz.class),
            isA(Member.class),
            eq(0),
            eq(1),
            eq(0),
            eq(1),
            eq("Field Descriptor"),
            isNull());
  }

  /**
   * Test {@link AllParameterVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Then calls {@link ParameterVisitor#visitParameter(Clazz, Member, int, int, int, int,
   *       String, Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link AllParameterVisitor#visitLibraryField(LibraryClass, LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); then calls visitParameter(Clazz, Member, int, int, int, int, String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.AllParameterVisitor.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_thenCallsVisitParameter() {
    // Arrange
    ParameterVisitor parameterVisitor = mock(ParameterVisitor.class);
    doNothing()
        .when(parameterVisitor)
        .visitParameter(
            Mockito.<Clazz>any(),
            Mockito.<Member>any(),
            anyInt(),
            anyInt(),
            anyInt(),
            anyInt(),
            Mockito.<String>any(),
            Mockito.<Clazz>any());
    AllParameterVisitor allParameterVisitor = new AllParameterVisitor(true, parameterVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    allParameterVisitor.visitLibraryField(libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(parameterVisitor)
        .visitParameter(
            isA(Clazz.class),
            isA(Member.class),
            eq(0),
            eq(1),
            eq(0),
            eq(1),
            eq("Descriptor"),
            isNull());
  }
}
