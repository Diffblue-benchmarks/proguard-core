package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;
import proguard.classfile.visitor.MemberVisitor;

class StringSharerDiffblueTest {
  /**
   * Test {@link StringSharer#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link StringSharer#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.StringSharer.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    StringSharer stringSharer = new StringSharer(1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> stringSharer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link StringSharer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link StringSharer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.StringSharer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsAccept() {
    // Arrange
    StringSharer stringSharer = new StringSharer(1);
    KotlinClassKindMetadata kotlinClassKindMetadata = mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinClassKindMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());
    ProgramClass programClass = new ProgramClass();
    programClass.kotlinMetadata = kotlinClassKindMetadata;
    programClass.u2constantPoolCount = 1;

    // Act
    stringSharer.visitProgramClass(programClass);

    // Assert
    verify(kotlinClassKindMetadata).accept(isA(Clazz.class), isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link StringSharer#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#constantPoolEntriesAccept(ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link StringSharer#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test visitProgramClass(ProgramClass); then calls constantPoolEntriesAccept(ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.StringSharer.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass_thenCallsConstantPoolEntriesAccept() {
    // Arrange
    StringSharer stringSharer = new StringSharer(1);
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).constantPoolEntriesAccept(Mockito.<ConstantVisitor>any());
    doNothing().when(programClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());

    // Act
    stringSharer.visitProgramClass(programClass);

    // Assert
    verify(programClass).constantPoolEntriesAccept(isA(ConstantVisitor.class));
    verify(programClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link StringSharer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#fieldsAccept(MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link StringSharer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName("Test visitLibraryClass(LibraryClass); then calls fieldsAccept(MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.StringSharer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_thenCallsFieldsAccept() {
    // Arrange
    StringSharer stringSharer = new StringSharer(1);
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing().when(libraryClass).fieldsAccept(Mockito.<MemberVisitor>any());
    doNothing().when(libraryClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());
    doNothing().when(libraryClass).methodsAccept(Mockito.<MemberVisitor>any());

    // Act
    stringSharer.visitLibraryClass(libraryClass);

    // Assert
    verify(libraryClass).fieldsAccept(isA(MemberVisitor.class));
    verify(libraryClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
    verify(libraryClass).methodsAccept(isA(MemberVisitor.class));
  }

  /**
   * Test {@link StringSharer#visitLibraryClass(LibraryClass)}.
   *
   * <ul>
   *   <li>When {@link KotlinMetadata} {@link KotlinMetadata#accept(Clazz, KotlinMetadataVisitor)}
   *       does nothing.
   *   <li>Then calls {@link KotlinMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link StringSharer#visitLibraryClass(LibraryClass)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryClass(LibraryClass); when KotlinMetadata accept(Clazz, KotlinMetadataVisitor) does nothing; then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.StringSharer.visitLibraryClass(proguard.classfile.LibraryClass)"
  })
  void testVisitLibraryClass_whenKotlinMetadataAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    StringSharer stringSharer = new StringSharer(1);
    KotlinMetadata kotlinMetadata = mock(KotlinMetadata.class);
    doNothing()
        .when(kotlinMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());

    // Act
    stringSharer.visitLibraryClass(
        new LibraryClass(1, "This Class Name", "Super Class Name", kotlinMetadata));

    // Assert
    verify(kotlinMetadata).accept(isA(Clazz.class), isA(KotlinMetadataVisitor.class));
  }
}
