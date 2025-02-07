package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import proguard.classfile.LibraryMember;
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;

class MethodImplementationTravelerDiffblueTest {
  /**
   * Test {@link MethodImplementationTraveler#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod() {
    // Arrange
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(
            false, true, true, true, mock(MethodImplementationFilter.class));
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    methodImplementationTraveler.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass, atLeast(1)).getString(eq(0));
    verify(programClass)
        .hierarchyAccept(eq(false), eq(true), eq(true), eq(true), isA(ClassVisitor.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   *   <li>Then calls {@link ProgramMember#getDescriptor(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given 'Descriptor'; then calls getDescriptor(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenDescriptor_thenCallsGetDescriptor() {
    // Arrange
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(
            true, true, true, true, mock(MethodImplementationFilter.class));
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    ProgramMethod programMethod = mock(ProgramMethod.class);
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(programMethod.getAccessFlags()).thenReturn(1);
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("Name");
    doNothing()
        .when(programMethod)
        .accept(Mockito.<ProgramClass>any(), Mockito.<MemberVisitor>any());

    // Act
    methodImplementationTraveler.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programClass)
        .hierarchyAccept(eq(false), eq(true), eq(true), eq(true), isA(ClassVisitor.class));
    verify(programMethod).getAccessFlags();
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod, atLeast(1)).getName(isA(Clazz.class));
    verify(programMethod).accept(isA(ProgramClass.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@code <init>}.
   *   <li>When {@link ProgramClass} {@link ProgramClass#getString(int)} return {@code <init>}.
   * </ul>
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given '<init>'; when ProgramClass getString(int) return '<init>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenInit_whenProgramClassGetStringReturnInit() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramMethod(Mockito.<ProgramClass>any(), Mockito.<ProgramMethod>any());
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(true, true, true, true, memberVisitor);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getString(anyInt())).thenReturn("<init>");

    // Act
    methodImplementationTraveler.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).getString(eq(0));
    verify(memberVisitor).visitProgramMethod(isA(ProgramClass.class), isA(ProgramMethod.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link MethodImplementationFilter#visitProgramMethod(ProgramClass,
   *       ProgramMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given 'String'; then calls visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenString_thenCallsVisitProgramMethod() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramMethod(Mockito.<ProgramClass>any(), Mockito.<ProgramMethod>any());
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(true, true, true, true, memberVisitor);
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing()
        .when(programClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    when(programClass.getString(anyInt())).thenReturn("String");

    // Act
    methodImplementationTraveler.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass, atLeast(1)).getString(eq(0));
    verify(programClass)
        .hierarchyAccept(eq(false), eq(true), eq(true), eq(true), isA(ClassVisitor.class));
    verify(memberVisitor).visitProgramMethod(isA(ProgramClass.class), isA(ProgramMethod.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ProgramClass}.
   *   <li>Then calls {@link ProgramMember#getAccessFlags()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given two; when ProgramClass; then calls getAccessFlags()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenTwo_whenProgramClass_thenCallsGetAccessFlags() {
    // Arrange
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(
            true, true, true, true, mock(MethodImplementationFilter.class));
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramMethod programMethod = mock(ProgramMethod.class);
    when(programMethod.getAccessFlags()).thenReturn(2);
    doNothing()
        .when(programMethod)
        .accept(Mockito.<ProgramClass>any(), Mockito.<MemberVisitor>any());

    // Act
    methodImplementationTraveler.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(programMethod).getAccessFlags();
    verify(programMethod).accept(isA(ProgramClass.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName("Test visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(true, false, true, true, memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    methodImplementationTraveler.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName("Test visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod2() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(true, true, false, true, memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    methodImplementationTraveler.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName("Test visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod3() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(true, true, true, false, memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    methodImplementationTraveler.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName("Test visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod4() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(true, true, true, true, memberVisitor);
    LibraryClass libraryClass = mock(LibraryClass.class);

    // Act
    methodImplementationTraveler.visitLibraryMethod(
        libraryClass, new LibraryMethod(2, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName("Test visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod5() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(true, true, true, true, memberVisitor);
    LibraryClass libraryClass = mock(LibraryClass.class);

    // Act
    methodImplementationTraveler.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "<init>", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Given {@code Descriptor}.
   *   <li>Then calls {@link LibraryMember#getAccessFlags()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); given 'Descriptor'; then calls getAccessFlags()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_givenDescriptor_thenCallsGetAccessFlags() {
    // Arrange
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(
            true, true, true, true, mock(MethodImplementationFilter.class));
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing()
        .when(libraryClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());
    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    when(libraryMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(libraryMethod.getAccessFlags()).thenReturn(1);
    when(libraryMethod.getName(Mockito.<Clazz>any())).thenReturn("Name");
    doNothing()
        .when(libraryMethod)
        .accept(Mockito.<LibraryClass>any(), Mockito.<MemberVisitor>any());

    // Act
    methodImplementationTraveler.visitLibraryMethod(libraryClass, libraryMethod);

    // Assert
    verify(libraryClass)
        .hierarchyAccept(eq(false), eq(true), eq(true), eq(true), isA(ClassVisitor.class));
    verify(libraryMethod).getAccessFlags();
    verify(libraryMethod).getDescriptor(isA(Clazz.class));
    verify(libraryMethod, atLeast(1)).getName(isA(Clazz.class));
    verify(libraryMethod).accept(isA(LibraryClass.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#hierarchyAccept(boolean, boolean, boolean, boolean,
   *       ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls hierarchyAccept(boolean, boolean, boolean, boolean, ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsHierarchyAccept() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(true, true, true, true, memberVisitor);
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing()
        .when(libraryClass)
        .hierarchyAccept(
            anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<ClassVisitor>any());

    // Act
    methodImplementationTraveler.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(libraryClass)
        .hierarchyAccept(eq(false), eq(true), eq(true), eq(true), isA(ClassVisitor.class));
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }

  /**
   * Test {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass,
   *       LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodImplementationTraveler#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MethodImplementationTraveler.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsVisitLibraryMethod() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MethodImplementationTraveler methodImplementationTraveler =
        new MethodImplementationTraveler(true, true, true, true, memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    methodImplementationTraveler.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }
}
