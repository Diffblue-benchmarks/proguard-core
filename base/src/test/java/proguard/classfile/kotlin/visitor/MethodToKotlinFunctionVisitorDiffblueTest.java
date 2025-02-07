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
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.kotlin.KotlinClassKindMetadata;

class MethodToKotlinFunctionVisitorDiffblueTest {
  /**
   * Test {@link MethodToKotlinFunctionVisitor#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodToKotlinFunctionVisitor#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MethodToKotlinFunctionVisitor.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsAccept() {
    // Arrange
    MethodToKotlinFunctionVisitor methodToKotlinFunctionVisitor =
        new MethodToKotlinFunctionVisitor(mock(KotlinFunctionVisitor.class));
    KotlinClassKindMetadata kotlinClassKindMetadata = mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinClassKindMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());
    ProgramClass programClass = new ProgramClass();
    programClass.kotlinMetadata = kotlinClassKindMetadata;

    // Act
    methodToKotlinFunctionVisitor.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(kotlinClassKindMetadata).accept(isA(Clazz.class), isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link MethodToKotlinFunctionVisitor#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link ProgramClass#kotlinMetadataAccept(KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodToKotlinFunctionVisitor#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @DisplayName(
      "Test visitProgramMethod(ProgramClass, ProgramMethod); then calls kotlinMetadataAccept(KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MethodToKotlinFunctionVisitor.visitProgramMethod(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testVisitProgramMethod_thenCallsKotlinMetadataAccept() {
    // Arrange
    MethodToKotlinFunctionVisitor methodToKotlinFunctionVisitor =
        new MethodToKotlinFunctionVisitor(mock(KotlinFunctionVisitor.class));
    ProgramClass programClass = mock(ProgramClass.class);
    doNothing().when(programClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());

    // Act
    methodToKotlinFunctionVisitor.visitProgramMethod(programClass, new ProgramMethod());

    // Assert
    verify(programClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link MethodToKotlinFunctionVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodToKotlinFunctionVisitor#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MethodToKotlinFunctionVisitor.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsAccept() {
    // Arrange
    MethodToKotlinFunctionVisitor methodToKotlinFunctionVisitor =
        new MethodToKotlinFunctionVisitor(mock(KotlinFunctionVisitor.class));
    KotlinClassKindMetadata kotlinClassKindMetadata = mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinClassKindMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.kotlinMetadata = kotlinClassKindMetadata;

    // Act
    methodToKotlinFunctionVisitor.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(kotlinClassKindMetadata).accept(isA(Clazz.class), isA(KotlinMetadataVisitor.class));
  }

  /**
   * Test {@link MethodToKotlinFunctionVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#kotlinMetadataAccept(KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link MethodToKotlinFunctionVisitor#visitLibraryMethod(LibraryClass,
   * LibraryMethod)}
   */
  @Test
  @DisplayName(
      "Test visitLibraryMethod(LibraryClass, LibraryMethod); then calls kotlinMetadataAccept(KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MethodToKotlinFunctionVisitor.visitLibraryMethod(proguard.classfile.LibraryClass, proguard.classfile.LibraryMethod)"
  })
  void testVisitLibraryMethod_thenCallsKotlinMetadataAccept() {
    // Arrange
    MethodToKotlinFunctionVisitor methodToKotlinFunctionVisitor =
        new MethodToKotlinFunctionVisitor(mock(KotlinFunctionVisitor.class));
    LibraryClass libraryClass = mock(LibraryClass.class);
    doNothing().when(libraryClass).kotlinMetadataAccept(Mockito.<KotlinMetadataVisitor>any());

    // Act
    methodToKotlinFunctionVisitor.visitLibraryMethod(
        libraryClass, new LibraryMethod(1, "Name", "Descriptor"));

    // Assert
    verify(libraryClass).kotlinMetadataAccept(isA(KotlinMetadataVisitor.class));
  }
}
