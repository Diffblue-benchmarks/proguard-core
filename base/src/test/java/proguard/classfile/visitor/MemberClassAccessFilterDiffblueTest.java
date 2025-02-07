package proguard.classfile.visitor;

import static org.mockito.ArgumentMatchers.isA;
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
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.editor.BootstrapMethodsAttributeShrinker;
import proguard.classfile.util.MethodLinker;
import proguard.util.SimpleProcessable;

class MemberClassAccessFilterDiffblueTest {
  /**
   * Test {@link MemberClassAccessFilter#MemberClassAccessFilter(Clazz, MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link LibraryClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#MemberClassAccessFilter(Clazz,
   * MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test new MemberClassAccessFilter(Clazz, MemberVisitor); given 'Name'; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.<init>(proguard.classfile.Clazz, proguard.classfile.visitor.MemberVisitor)"
  })
  void testNewMemberClassAccessFilter_givenName_thenCallsAccept() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());

    // Act
    new MemberClassAccessFilter(referencingClass, new AttributeSorter());

    // Assert
    verify(referencingClass).accept(isA(ClassVisitor.class));
    verify(referencingClass).getName();
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Given four.
   *   <li>When {@link ProgramField} {@link ProgramMember#getAccessFlags()} return four.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); given four; when ProgramField getAccessFlags() return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_givenFour_whenProgramFieldGetAccessFlagsReturnFour() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberVisitor memberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, memberVisitor);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());
    ProgramField programField = mock(ProgramField.class);
    when(programField.getAccessFlags()).thenReturn(4);

    // Act
    memberClassAccessFilter.visitProgramField(programClass, programField);

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass).getName();
    verify(programField).getAccessFlags();
    verify(memberVisitor).visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass} {@link LibraryClass#getName()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); given LibraryClass getName() return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_givenLibraryClassGetNameReturnFoo() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("foo");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, mock(MemberVisitor.class));
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());
    ProgramField programField = mock(ProgramField.class);
    when(programField.getAccessFlags()).thenReturn(2);

    // Act
    memberClassAccessFilter.visitProgramField(programClass, programField);

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass).getName();
    verify(programField).getAccessFlags();
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass} {@link LibraryClass#getName()} return {@code foo}.
   *   <li>Then calls {@link ProgramClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); given LibraryClass getName() return 'foo'; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_givenLibraryClassGetNameReturnFoo_thenCallsAccept() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("foo");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberVisitor memberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, memberVisitor);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());

    // Act
    memberClassAccessFilter.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass, atLeast(1)).getName();
    verify(memberVisitor).visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ProgramClass}.
   *   <li>Then calls {@link ProgramMember#getAccessFlags()}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); given one; when ProgramClass; then calls getAccessFlags()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_givenOne_whenProgramClass_thenCallsGetAccessFlags() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberVisitor memberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, memberVisitor);
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramField programField = mock(ProgramField.class);
    when(programField.getAccessFlags()).thenReturn(1);

    // Act
    memberClassAccessFilter.visitProgramField(programClass, programField);

    // Assert
    verify(referencingClass).accept(isA(ClassVisitor.class));
    verify(referencingClass).getName();
    verify(programField).getAccessFlags();
    verify(memberVisitor).visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ProgramField} {@link ProgramMember#getAccessFlags()} return two.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); given two; when ProgramField getAccessFlags() return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_givenTwo_whenProgramFieldGetAccessFlagsReturnTwo() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberVisitor memberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, memberVisitor);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());
    ProgramField programField = mock(ProgramField.class);
    when(programField.getAccessFlags()).thenReturn(2);

    // Act
    memberClassAccessFilter.visitProgramField(programClass, programField);

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass).getName();
    verify(programField).getAccessFlags();
    verify(memberVisitor).visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsAccept() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberVisitor memberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(memberVisitor)
        .visitProgramField(Mockito.<ProgramClass>any(), Mockito.<ProgramField>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, memberVisitor);
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());

    // Act
    memberClassAccessFilter.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass).getName();
    verify(memberVisitor).visitProgramField(isA(ProgramClass.class), isA(ProgramField.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, new BootstrapMethodsAttributeShrinker());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());

    // Act
    memberClassAccessFilter.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass).getName();
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName("Test visitProgramMethod(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod2() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, new AttributeSorter());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());

    // Act
    memberClassAccessFilter.visitProgramMethod(
        programClass, new ProgramMethod(7, 1, 1, new Clazz[] {new LibraryClass()}));

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass).getName();
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@code <clinit>}.
   *   <li>When {@link ProgramMethod} {@link ProgramMember#getName(Clazz)} return {@code <clinit>}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given '<clinit>'; when ProgramMethod getName(Clazz) return '<clinit>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenClinit_whenProgramMethodGetNameReturnClinit() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramMethod programMethod = mock(ProgramMethod.class);
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("<clinit>");
    when(programMethod.getAccessFlags()).thenReturn(1);

    // Act
    memberClassAccessFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(referencingClass).accept(isA(ClassVisitor.class));
    verify(referencingClass).getName();
    verify(programMethod).getAccessFlags();
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod).getName(isA(Clazz.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given four.
   *   <li>When {@link ProgramMethod} {@link ProgramMember#getAccessFlags()} return four.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given four; when ProgramMethod getAccessFlags() return four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenFour_whenProgramMethodGetAccessFlagsReturnFour() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());
    ProgramMethod programMethod = mock(ProgramMethod.class);
    when(programMethod.getProcessingInfo()).thenReturn("Processing Info");
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("Name");
    when(programMethod.getAccessFlags()).thenReturn(4);

    // Act
    memberClassAccessFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass).getName();
    verify(programMethod).getAccessFlags();
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod).getName(isA(Clazz.class));
    verify(programMethod, atLeast(1)).getProcessingInfo();
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@code <init>}.
   *   <li>When {@link ProgramMethod} {@link ProgramMember#getName(Clazz)} return {@code <init>}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given '<init>'; when ProgramMethod getName(Clazz) return '<init>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenInit_whenProgramMethodGetNameReturnInit() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramMethod programMethod = mock(ProgramMethod.class);
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("<init>");
    when(programMethod.getAccessFlags()).thenReturn(1);

    // Act
    memberClassAccessFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(referencingClass).accept(isA(ClassVisitor.class));
    verify(referencingClass).getName();
    verify(programMethod).getAccessFlags();
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod).getName(isA(Clazz.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass} {@link LibraryClass#getName()} return {@code <clinit>}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given LibraryClass getName() return '<clinit>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenLibraryClassGetNameReturnClinit() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("<clinit>");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());
    ProgramMethod programMethod = mock(ProgramMethod.class);
    when(programMethod.getAccessFlags()).thenReturn(2);

    // Act
    memberClassAccessFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass).getName();
    verify(programMethod).getAccessFlags();
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass} {@link LibraryClass#getName()} return {@code <clinit>}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given LibraryClass getName() return '<clinit>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenLibraryClassGetNameReturnClinit2() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("<clinit>");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());
    ProgramMethod programMethod = mock(ProgramMethod.class);
    when(programMethod.getProcessingInfo()).thenReturn("Processing Info");
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("Name");
    when(programMethod.getAccessFlags()).thenReturn(4);

    // Act
    memberClassAccessFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass, atLeast(1)).getName();
    verify(programMethod).getAccessFlags();
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod).getName(isA(Clazz.class));
    verify(programMethod, atLeast(1)).getProcessingInfo();
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ProgramMethod} {@link ProgramMember#getAccessFlags()} return two.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); given two; when ProgramMethod getAccessFlags() return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_givenTwo_whenProgramMethodGetAccessFlagsReturnTwo() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    when(programClass.getName()).thenReturn("Name");
    doNothing().when(programClass).accept(Mockito.<ClassVisitor>any());
    ProgramMethod programMethod = mock(ProgramMethod.class);
    when(programMethod.getProcessingInfo()).thenReturn("Processing Info");
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("Name");
    when(programMethod.getAccessFlags()).thenReturn(2);

    // Act
    memberClassAccessFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(programClass).accept(isA(ClassVisitor.class));
    verify(programClass).getName();
    verify(programMethod).getAccessFlags();
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod).getName(isA(Clazz.class));
    verify(programMethod, atLeast(1)).getProcessingInfo();
  }

  /**
   * Test {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass}.
   *   <li>Then calls {@link SimpleProcessable#getProcessingInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); when ProgramClass; then calls getProcessingInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_whenProgramClass_thenCallsGetProcessingInfo() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, new MethodLinker());
    ProgramClass programClass = mock(ProgramClass.class);
    ProgramMethod programMethod = mock(ProgramMethod.class);
    when(programMethod.getProcessingInfo()).thenReturn("Processing Info");
    when(programMethod.getDescriptor(Mockito.<Clazz>any())).thenReturn("Descriptor");
    when(programMethod.getName(Mockito.<Clazz>any())).thenReturn("Name");
    when(programMethod.getAccessFlags()).thenReturn(1);

    // Act
    memberClassAccessFilter.visitProgramMethod(programClass, programMethod);

    // Assert
    verify(referencingClass).accept(isA(ClassVisitor.class));
    verify(referencingClass).getName();
    verify(programMethod).getAccessFlags();
    verify(programMethod).getDescriptor(isA(Clazz.class));
    verify(programMethod).getName(isA(Clazz.class));
    verify(programMethod, atLeast(1)).getProcessingInfo();
  }

  /**
   * Test {@link MemberClassAccessFilter#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitLibraryField(LibraryClass,
   * LibraryField)}
   */
  @Test
  @DisplayName("Test visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, memberVisitor);
    LibraryClass libraryClass = new LibraryClass(7, "This Class Name", "Super Class Name");

    // Act
    memberClassAccessFilter.visitLibraryField(
        libraryClass, new LibraryField(7, "Name", "Descriptor"));

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(memberVisitor).visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass} {@link LibraryClass#getName()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitLibraryField(LibraryClass,
   * LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); given LibraryClass getName() return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_givenLibraryClassGetNameReturnFoo() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("foo");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, mock(MethodImplementationFilter.class));
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.getName()).thenReturn("Name");
    doNothing().when(libraryClass).accept(Mockito.<ClassVisitor>any());

    // Act
    memberClassAccessFilter.visitLibraryField(
        libraryClass, new LibraryField(2, "Name", "Descriptor"));

    // Assert
    verify(libraryClass).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(libraryClass).getName();
    verify(referencingClass, atLeast(1)).getName();
  }

  /**
   * Test {@link MemberClassAccessFilter#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitLibraryField(LibraryClass,
   * LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); given 'Name'; when LibraryClass getName() return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_givenName_whenLibraryClassGetNameReturnName() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, memberVisitor);
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.getName()).thenReturn("Name");
    doNothing().when(libraryClass).accept(Mockito.<ClassVisitor>any());

    // Act
    memberClassAccessFilter.visitLibraryField(
        libraryClass, new LibraryField(7, "Name", "Descriptor"));

    // Assert
    verify(libraryClass).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(libraryClass).getName();
    verify(referencingClass, atLeast(1)).getName();
    verify(memberVisitor).visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitLibraryField(LibraryClass,
   * LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); then calls visitLibraryField(LibraryClass, LibraryField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_thenCallsVisitLibraryField() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryField(Mockito.<LibraryClass>any(), Mockito.<LibraryField>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(new LibraryClass(), memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberClassAccessFilter.visitLibraryField(
        libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryField(isA(LibraryClass.class), isA(LibraryField.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName("Test visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, memberVisitor);
    LibraryClass libraryClass = new LibraryClass(7, "This Class Name", "Super Class Name");

    // Act
    memberClassAccessFilter.visitLibraryMethod(
        libraryClass, new LibraryMethod(7, "Name", "Descriptor"));

    // Assert
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).getName();
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass} {@link LibraryClass#getName()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); given LibraryClass getName() return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_givenLibraryClassGetNameReturnFoo() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("foo");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, mock(MethodImplementationFilter.class));
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.getName()).thenReturn("Name");
    doNothing().when(libraryClass).accept(Mockito.<ClassVisitor>any());

    // Act
    memberClassAccessFilter.visitLibraryMethod(
        libraryClass, new LibraryMethod(2, "Name", "Descriptor"));

    // Assert
    verify(libraryClass).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(libraryClass).getName();
    verify(referencingClass, atLeast(1)).getName();
  }

  /**
   * Test {@link MemberClassAccessFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); given 'Name'; when LibraryClass getName() return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_givenName_whenLibraryClassGetNameReturnName() {
    // Arrange
    LibraryClass referencingClass = mock(LibraryClass.class);
    when(referencingClass.getName()).thenReturn("Name");
    doNothing().when(referencingClass).accept(Mockito.<ClassVisitor>any());
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(referencingClass, memberVisitor);
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.getName()).thenReturn("Name");
    doNothing().when(libraryClass).accept(Mockito.<ClassVisitor>any());

    // Act
    memberClassAccessFilter.visitLibraryMethod(
        libraryClass, new LibraryMethod(7, "Name", "Descriptor"));

    // Assert
    verify(libraryClass).accept(isA(ClassVisitor.class));
    verify(referencingClass, atLeast(1)).accept(isA(ClassVisitor.class));
    verify(libraryClass).getName();
    verify(referencingClass, atLeast(1)).getName();
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }

  /**
   * Test {@link MemberClassAccessFilter#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodImplementationFilter#visitLibraryMethod(LibraryClass,
   *       LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberClassAccessFilter#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.MemberClassAccessFilter.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsVisitLibraryMethod() {
    // Arrange
    MethodImplementationFilter memberVisitor = mock(MethodImplementationFilter.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    MemberClassAccessFilter memberClassAccessFilter =
        new MemberClassAccessFilter(new LibraryClass(), memberVisitor);
    LibraryClass libraryClass = new LibraryClass();

    // Act
    memberClassAccessFilter.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }
}
