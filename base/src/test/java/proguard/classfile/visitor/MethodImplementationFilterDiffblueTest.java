package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.editor.BootstrapMethodsAttributeShrinker;
import proguard.classfile.editor.BridgeMethodFixer;
import proguard.classfile.util.MethodLinker;

class MethodImplementationFilterDiffblueTest {
  /**
   * Test {@link MethodImplementationFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MethodImplementationFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod() {
    // Arrange
    MethodImplementationFilter methodImplementationFilter =
        new MethodImplementationFilter(new BootstrapMethodsAttributeShrinker());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.mayHaveImplementations(Mockito.<Method>any())).thenReturn(true);

    // Act
    methodImplementationFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).mayHaveImplementations(isA(Method.class));
  }

  /**
   * Test {@link MethodImplementationFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MethodImplementationFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod2() {
    // Arrange
    MethodImplementationFilter methodImplementationFilter =
        new MethodImplementationFilter(new BridgeMethodFixer());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.mayHaveImplementations(Mockito.<Method>any())).thenReturn(true);

    // Act
    methodImplementationFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).mayHaveImplementations(isA(Method.class));
  }

  /**
   * Test {@link MethodImplementationFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MethodImplementationFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod3() {
    // Arrange
    MethodImplementationFilter methodImplementationFilter =
        new MethodImplementationFilter(new AttributeSorter());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.mayHaveImplementations(Mockito.<Method>any())).thenReturn(true);

    // Act
    methodImplementationFilter.visitProgramMethod(
        programClass, new ProgramMethod(1, 1, 1, new Clazz[] {new LibraryClass()}));

    // Assert
    verify(programClass).mayHaveImplementations(isA(Method.class));
  }

  /**
   * Test {@link MethodImplementationFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodImplementationFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod); then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsGetString() {
    // Arrange
    MethodImplementationFilter methodImplementationFilter =
        new MethodImplementationFilter(new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("String");
    when(programClass.mayHaveImplementations(Mockito.<Method>any())).thenReturn(true);

    // Act
    methodImplementationFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass, atLeast(1)).getString(eq(0));
    verify(programClass).mayHaveImplementations(isA(Method.class));
  }

  /**
   * Test {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link LibraryClass#mayHaveImplementations(Method)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); given 'true'; then calls mayHaveImplementations(Method)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationFilter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_givenTrue_thenCallsMayHaveImplementations() {
    // Arrange
    MethodImplementationTraveler memberVisitor = mock(MethodImplementationTraveler.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MethodImplementationFilter methodImplementationFilter =
        new MethodImplementationFilter(memberVisitor);
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.mayHaveImplementations(Mockito.<Method>any())).thenReturn(true);

    // Act
    methodImplementationFilter.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(libraryClass).mayHaveImplementations(isA(Method.class));
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }

  /**
   * Test {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass,
   *       LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationFilter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsVisitLibraryMethod() {
    // Arrange
    MethodImplementationTraveler memberVisitor = mock(MethodImplementationTraveler.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MethodImplementationFilter methodImplementationFilter =
        new MethodImplementationFilter(memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    methodImplementationFilter.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }
}
