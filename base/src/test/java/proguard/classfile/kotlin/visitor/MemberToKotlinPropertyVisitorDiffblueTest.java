package proguard.classfile.kotlin.visitor;

import static org.mockito.ArgumentMatchers.isA;
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
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;
import proguard.classfile.kotlin.KotlinClassKindMetadata;

class MemberToKotlinPropertyVisitorDiffblueTest {
  /**
   * Test {@link MemberToKotlinPropertyVisitor#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberToKotlinPropertyVisitor#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MemberToKotlinPropertyVisitor.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsAccept() {
    // Arrange
    MemberToKotlinPropertyVisitor memberToKotlinPropertyVisitor =
        new MemberToKotlinPropertyVisitor(mock(KotlinPropertyVisitor.class));
    KotlinClassKindMetadata kotlinClassKindMetadata = mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinClassKindMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());
    ProgramClass programClass = new ProgramClass();
    programClass.kotlinMetadata = kotlinClassKindMetadata;

    // Act
    memberToKotlinPropertyVisitor.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(kotlinClassKindMetadata).accept(isA(Clazz.class), isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link MemberToKotlinPropertyVisitor#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#kotlinMetadataAccept(KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberToKotlinPropertyVisitor#visitProgramField(ProgramClass,
   * ProgramField)}
   */
  @Test
  @DisplayName(
      "Test visitProgramField(ProgramClass, ProgramField); then calls kotlinMetadataAccept(KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MemberToKotlinPropertyVisitor.visitProgramField(proguard.classfile.ProgramClass, proguard.classfile.ProgramField)"
  })
  void testVisitProgramField_thenCallsKotlinMetadataAccept() {
    // Arrange
    MemberToKotlinPropertyVisitor memberToKotlinPropertyVisitor =
        new MemberToKotlinPropertyVisitor(mock(KotlinPropertyVisitor.class));
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());

    // Act
    memberToKotlinPropertyVisitor.visitProgramField(programClass, new ProgramField());

    // Assert
    verify(programClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link MemberToKotlinPropertyVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberToKotlinPropertyVisitor#visitLibraryField(LibraryClass,
   * LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MemberToKotlinPropertyVisitor.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_thenCallsAccept() {
    // Arrange
    MemberToKotlinPropertyVisitor memberToKotlinPropertyVisitor =
        new MemberToKotlinPropertyVisitor(mock(KotlinPropertyVisitor.class));
    KotlinClassKindMetadata kotlinClassKindMetadata = mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinClassKindMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.kotlinMetadata = kotlinClassKindMetadata;

    // Act
    memberToKotlinPropertyVisitor.visitLibraryField(
        libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(kotlinClassKindMetadata).accept(isA(Clazz.class), isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link MemberToKotlinPropertyVisitor#visitLibraryField(LibraryClass, LibraryField)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#kotlinMetadataAccept(KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberToKotlinPropertyVisitor#visitLibraryField(LibraryClass,
   * LibraryField)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryField(LibraryClass, LibraryField); then calls kotlinMetadataAccept(KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MemberToKotlinPropertyVisitor.visitLibraryField(proguard.classfile.LibraryClass, proguard.classfile.LibraryField)"
  })
  void testVisitLibraryField_thenCallsKotlinMetadataAccept() {
    // Arrange
    MemberToKotlinPropertyVisitor memberToKotlinPropertyVisitor =
        new MemberToKotlinPropertyVisitor(mock(KotlinPropertyVisitor.class));
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing().when(libraryClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());

    // Act
    memberToKotlinPropertyVisitor.visitLibraryField(
        libraryClass, new LibraryField(1, "Name", "Descriptor"));

    // Assert
    verify(libraryClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link MemberToKotlinPropertyVisitor#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberToKotlinPropertyVisitor#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MemberToKotlinPropertyVisitor.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsAccept() {
    // Arrange
    MemberToKotlinPropertyVisitor memberToKotlinPropertyVisitor =
        new MemberToKotlinPropertyVisitor(mock(KotlinPropertyVisitor.class));
    KotlinClassKindMetadata kotlinClassKindMetadata = mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinClassKindMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());
    ProgramClass programClass = new ProgramClass();
    programClass.kotlinMetadata = kotlinClassKindMetadata;

    // Act
    memberToKotlinPropertyVisitor.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(kotlinClassKindMetadata).accept(isA(Clazz.class), isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link MemberToKotlinPropertyVisitor#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#kotlinMetadataAccept(KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberToKotlinPropertyVisitor#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then calls kotlinMetadataAccept(KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MemberToKotlinPropertyVisitor.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsKotlinMetadataAccept() {
    // Arrange
    MemberToKotlinPropertyVisitor memberToKotlinPropertyVisitor =
        new MemberToKotlinPropertyVisitor(mock(KotlinPropertyVisitor.class));
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());

    // Act
    memberToKotlinPropertyVisitor.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link MemberToKotlinPropertyVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberToKotlinPropertyVisitor#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MemberToKotlinPropertyVisitor.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsAccept() {
    // Arrange
    MemberToKotlinPropertyVisitor memberToKotlinPropertyVisitor =
        new MemberToKotlinPropertyVisitor(mock(KotlinPropertyVisitor.class));
    KotlinClassKindMetadata kotlinClassKindMetadata = mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinClassKindMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.kotlinMetadata = kotlinClassKindMetadata;

    // Act
    memberToKotlinPropertyVisitor.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(kotlinClassKindMetadata).accept(isA(Clazz.class), isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link MemberToKotlinPropertyVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#kotlinMetadataAccept(KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MemberToKotlinPropertyVisitor#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls kotlinMetadataAccept(KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MemberToKotlinPropertyVisitor.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsKotlinMetadataAccept() {
    // Arrange
    MemberToKotlinPropertyVisitor memberToKotlinPropertyVisitor =
        new MemberToKotlinPropertyVisitor(mock(KotlinPropertyVisitor.class));
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing().when(libraryClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());

    // Act
    memberToKotlinPropertyVisitor.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(libraryClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
  }
}
