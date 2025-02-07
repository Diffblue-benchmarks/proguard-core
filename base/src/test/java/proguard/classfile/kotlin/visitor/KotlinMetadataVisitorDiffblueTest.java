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
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinDeclarationContainerMetadata;
import proguard.classfile.kotlin.KotlinFileFacadeKindMetadata;
import proguard.classfile.kotlin.KotlinMultiFileFacadeKindMetadata;
import proguard.classfile.kotlin.KotlinMultiFilePartKindMetadata;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.Flavor;

class KotlinMetadataVisitorDiffblueTest {
  /**
   * Test {@link KotlinMetadataVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataVisitor.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());
    MultiKotlinMetadataVisitor multiKotlinMetadataVisitor =
        new MultiKotlinMetadataVisitor(kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiKotlinMetadataVisitor.visitKotlinDeclarationContainerMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   * KotlinClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataVisitor.visitKotlinClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata)"
  })
  void testVisitKotlinClassMetadata_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());
    MultiKotlinMetadataVisitor multiKotlinMetadataVisitor =
        new MultiKotlinMetadataVisitor(kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiKotlinMetadataVisitor.visitKotlinClassMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinMetadataVisitor#visitKotlinFileFacadeMetadata(Clazz,
   * KotlinFileFacadeKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinFileFacadeMetadata(Clazz,
   *       KotlinFileFacadeKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataVisitor#visitKotlinFileFacadeMetadata(Clazz,
   * KotlinFileFacadeKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinFileFacadeMetadata(Clazz, KotlinFileFacadeKindMetadata); then calls visitKotlinFileFacadeMetadata(Clazz, KotlinFileFacadeKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataVisitor.visitKotlinFileFacadeMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinFileFacadeKindMetadata)"
  })
  void testVisitKotlinFileFacadeMetadata_thenCallsVisitKotlinFileFacadeMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinFileFacadeMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinFileFacadeKindMetadata>any());
    MultiKotlinMetadataVisitor multiKotlinMetadataVisitor =
        new MultiKotlinMetadataVisitor(kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiKotlinMetadataVisitor.visitKotlinFileFacadeMetadata(
        clazz, new KotlinFileFacadeKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn"));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinFileFacadeMetadata(isA(Clazz.class), isA(KotlinFileFacadeKindMetadata.class));
  }

  /**
   * Test {@link KotlinMetadataVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   *       KotlinSyntheticClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata); then calls visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataVisitor.visitKotlinSyntheticClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testVisitKotlinSyntheticClassMetadata_thenCallsVisitKotlinSyntheticClassMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinSyntheticClassMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinSyntheticClassKindMetadata>any());
    MultiKotlinMetadataVisitor multiKotlinMetadataVisitor =
        new MultiKotlinMetadataVisitor(kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiKotlinMetadataVisitor.visitKotlinSyntheticClassMetadata(
        clazz,
        new KotlinSyntheticClassKindMetadata(
            new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinSyntheticClassMetadata(
            isA(Clazz.class), isA(KotlinSyntheticClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinMetadataVisitor#visitKotlinMultiFileFacadeMetadata(Clazz,
   * KotlinMultiFileFacadeKindMetadata)}.
   *
   * <p>Method under test: {@link KotlinMetadataVisitor#visitKotlinMultiFileFacadeMetadata(Clazz,
   * KotlinMultiFileFacadeKindMetadata)}
   */
  @Test
  @DisplayName("Test visitKotlinMultiFileFacadeMetadata(Clazz, KotlinMultiFileFacadeKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataVisitor.visitKotlinMultiFileFacadeMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMultiFileFacadeKindMetadata)"
  })
  void testVisitKotlinMultiFileFacadeMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinMultiFileFacadeMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinMultiFileFacadeKindMetadata>any());
    MultiKotlinMetadataVisitor multiKotlinMetadataVisitor =
        new MultiKotlinMetadataVisitor(kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiKotlinMetadataVisitor.visitKotlinMultiFileFacadeMetadata(
        clazz,
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 4, 1, 4}, new String[] {"D1"}, 1, "Xs", "Pn"));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinMultiFileFacadeMetadata(
            isA(Clazz.class), isA(KotlinMultiFileFacadeKindMetadata.class));
  }

  /**
   * Test {@link KotlinMetadataVisitor#visitKotlinMultiFilePartMetadata(Clazz,
   * KotlinMultiFilePartKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinMultiFilePartMetadata(Clazz,
   *       KotlinMultiFilePartKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataVisitor#visitKotlinMultiFilePartMetadata(Clazz,
   * KotlinMultiFilePartKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinMultiFilePartMetadata(Clazz, KotlinMultiFilePartKindMetadata); then calls visitKotlinMultiFilePartMetadata(Clazz, KotlinMultiFilePartKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataVisitor.visitKotlinMultiFilePartMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMultiFilePartKindMetadata)"
  })
  void testVisitKotlinMultiFilePartMetadata_thenCallsVisitKotlinMultiFilePartMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinMultiFilePartMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinMultiFilePartKindMetadata>any());
    MultiKotlinMetadataVisitor multiKotlinMetadataVisitor =
        new MultiKotlinMetadataVisitor(kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiKotlinMetadataVisitor.visitKotlinMultiFilePartMetadata(
        clazz, new KotlinMultiFilePartKindMetadata(new int[] {1, 5, 1, 5}, 1, "Xs", "Pn"));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinMultiFilePartMetadata(
            isA(Clazz.class), isA(KotlinMultiFilePartKindMetadata.class));
  }
}
