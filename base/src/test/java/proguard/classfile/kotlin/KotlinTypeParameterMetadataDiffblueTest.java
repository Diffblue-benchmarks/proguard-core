package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinTypeAliasFlags;
import proguard.classfile.kotlin.flags.KotlinTypeParameterFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinTypeParameterVisitor;

class KotlinTypeParameterMetadataDiffblueTest {
  /**
   * Test {@link KotlinTypeParameterMetadata#KotlinTypeParameterMetadata(KotlinTypeParameterFlags,
   * String, int, KotlinTypeVariance)}.
   *
   * <p>Method under test: {@link
   * KotlinTypeParameterMetadata#KotlinTypeParameterMetadata(KotlinTypeParameterFlags, String, int,
   * KotlinTypeVariance)}
   */
  @Test
  @DisplayName(
      "Test new KotlinTypeParameterMetadata(KotlinTypeParameterFlags, String, int, KotlinTypeVariance)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinTypeParameterMetadata.<init>(proguard.classfile.kotlin.flags.KotlinTypeParameterFlags, java.lang.String, int, proguard.classfile.kotlin.KotlinTypeVariance)"
  })
  void testNewKotlinTypeParameterMetadata() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;

    // Act
    KotlinTypeParameterMetadata actualKotlinTypeParameterMetadata =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);

    // Assert
    assertNull(actualKotlinTypeParameterMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinTypeParameterMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinTypeParameterMetadata#accept(Clazz, KotlinClassKindMetadata,
   * KotlinTypeParameterVisitor)} with {@code Clazz}, {@code KotlinClassKindMetadata}, {@code
   * KotlinTypeParameterVisitor}.
   *
   * <p>Method under test: {@link KotlinTypeParameterMetadata#accept(Clazz, KotlinClassKindMetadata,
   * KotlinTypeParameterVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinClassKindMetadata, KotlinTypeParameterVisitor) with 'Clazz', 'KotlinClassKindMetadata', 'KotlinTypeParameterVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinTypeParameterMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.visitor.KotlinTypeParameterVisitor)"
  })
  void testAcceptWithClazzKotlinClassKindMetadataKotlinTypeParameterVisitor() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterMetadata kotlinTypeParameterMetadata =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeParameterVisitor kotlinTypeParameterVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(kotlinTypeParameterVisitor)
        .visitClassTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinClassKindMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());

    // Act
    kotlinTypeParameterMetadata.accept(clazz, kotlinClassKindMetadata, kotlinTypeParameterVisitor);

    // Assert
    verify(kotlinTypeParameterVisitor)
        .visitClassTypeParameter(
            isA(Clazz.class),
            isA(KotlinClassKindMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link KotlinTypeParameterMetadata#accept(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinPropertyMetadata, KotlinTypeParameterVisitor)} with {@code Clazz}, {@code
   * KotlinDeclarationContainerMetadata}, {@code KotlinPropertyMetadata}, {@code
   * KotlinTypeParameterVisitor}.
   *
   * <p>Method under test: {@link KotlinTypeParameterMetadata#accept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterVisitor) with 'Clazz', 'KotlinDeclarationContainerMetadata', 'KotlinPropertyMetadata', 'KotlinTypeParameterVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinTypeParameterMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.visitor.KotlinTypeParameterVisitor)"
  })
  void
      testAcceptWithClazzKotlinDeclarationContainerMetadataKotlinPropertyMetadataKotlinTypeParameterVisitor() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterMetadata kotlinTypeParameterMetadata =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinModalityFlags modality = new KotlinModalityFlags();
    modality.isAbstract = true;
    modality.isFinal = true;
    modality.isOpen = true;
    modality.isSealed = true;
    KotlinPropertyFlags flags2 = new KotlinPropertyFlags(visibility, modality);

    KotlinVisibilityFlags visibility2 = new KotlinVisibilityFlags();
    visibility2.isInternal = true;
    visibility2.isLocal = true;
    visibility2.isPrivate = true;
    visibility2.isPrivateToThis = true;
    visibility2.isProtected = true;
    visibility2.isPublic = true;
    KotlinModalityFlags modality2 = new KotlinModalityFlags();
    modality2.isAbstract = true;
    modality2.isFinal = true;
    modality2.isOpen = true;
    modality2.isSealed = true;
    KotlinPropertyAccessorFlags getterFlags =
        new KotlinPropertyAccessorFlags(visibility2, modality2);

    KotlinVisibilityFlags visibility3 = new KotlinVisibilityFlags();
    visibility3.isInternal = true;
    visibility3.isLocal = true;
    visibility3.isPrivate = true;
    visibility3.isPrivateToThis = true;
    visibility3.isProtected = true;
    visibility3.isPublic = true;
    KotlinModalityFlags modality3 = new KotlinModalityFlags();
    modality3.isAbstract = true;
    modality3.isFinal = true;
    modality3.isOpen = true;
    modality3.isSealed = true;
    KotlinPropertyMetadata kotlinPropertyMetadata =
        new KotlinPropertyMetadata(
            flags2, "Name", getterFlags, new KotlinPropertyAccessorFlags(visibility3, modality3));

    KotlinTypeParameterVisitor kotlinTypeParameterVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(kotlinTypeParameterVisitor)
        .visitPropertyTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());

    // Act
    kotlinTypeParameterMetadata.accept(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        kotlinTypeParameterVisitor);

    // Assert
    verify(kotlinTypeParameterVisitor)
        .visitPropertyTypeParameter(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link KotlinTypeParameterMetadata#accept(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinTypeAliasMetadata, KotlinTypeParameterVisitor)} with {@code Clazz}, {@code
   * KotlinDeclarationContainerMetadata}, {@code KotlinTypeAliasMetadata}, {@code
   * KotlinTypeParameterVisitor}.
   *
   * <p>Method under test: {@link KotlinTypeParameterMetadata#accept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterVisitor) with 'Clazz', 'KotlinDeclarationContainerMetadata', 'KotlinTypeAliasMetadata', 'KotlinTypeParameterVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinTypeParameterMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.visitor.KotlinTypeParameterVisitor)"
  })
  void
      testAcceptWithClazzKotlinDeclarationContainerMetadataKotlinTypeAliasMetadataKotlinTypeParameterVisitor() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterMetadata kotlinTypeParameterMetadata =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinTypeAliasMetadata kotlinPropertyMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");

    KotlinTypeParameterVisitor kotlinTypeParameterVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(kotlinTypeParameterVisitor)
        .visitAliasTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeAliasMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());

    // Act
    kotlinTypeParameterMetadata.accept(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        kotlinTypeParameterVisitor);

    // Assert
    verify(kotlinTypeParameterVisitor)
        .visitAliasTypeParameter(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeAliasMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link KotlinTypeParameterMetadata#accept(Clazz, KotlinMetadata, KotlinFunctionMetadata,
   * KotlinTypeParameterVisitor)} with {@code Clazz}, {@code KotlinMetadata}, {@code
   * KotlinFunctionMetadata}, {@code KotlinTypeParameterVisitor}.
   *
   * <p>Method under test: {@link KotlinTypeParameterMetadata#accept(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeParameterVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeParameterVisitor) with 'Clazz', 'KotlinMetadata', 'KotlinFunctionMetadata', 'KotlinTypeParameterVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinTypeParameterMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.visitor.KotlinTypeParameterVisitor)"
  })
  void testAcceptWithClazzKotlinMetadataKotlinFunctionMetadataKotlinTypeParameterVisitor() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterMetadata kotlinTypeParameterMetadata =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinModalityFlags modality = new KotlinModalityFlags();
    modality.isAbstract = true;
    modality.isFinal = true;
    modality.isOpen = true;
    modality.isSealed = true;
    KotlinFunctionMetadata kotlinFunctionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");

    KotlinTypeParameterVisitor kotlinTypeParameterVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(kotlinTypeParameterVisitor)
        .visitFunctionTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());

    // Act
    kotlinTypeParameterMetadata.accept(
        clazz, kotlinMetadata, kotlinFunctionMetadata, kotlinTypeParameterVisitor);

    // Assert
    verify(kotlinTypeParameterVisitor)
        .visitFunctionTypeParameter(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link KotlinTypeParameterMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin constructor}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterMetadata#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Kotlin constructor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinTypeParameterMetadata.toString()"
  })
  void testToString_thenReturnKotlinConstructor() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterFlags kotlinTypeParameterFlags = new KotlinTypeParameterFlags();
    kotlinTypeParameterFlags.isReified = true;
    kotlinTypeParameterFlags.isReified = false;
    KotlinTypeParameterMetadata kotlinTypeParameterMetadata =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);
    kotlinTypeParameterMetadata.flags = kotlinTypeParameterFlags;

    // Act and Assert
    assertEquals("Kotlin constructor", kotlinTypeParameterMetadata.toString());
  }

  /**
   * Test {@link KotlinTypeParameterMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin primary constructor}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterMetadata#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Kotlin primary constructor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinTypeParameterMetadata.toString()"
  })
  void testToString_thenReturnKotlinPrimaryConstructor() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;

    // Act and Assert
    assertEquals(
        "Kotlin primary constructor",
        (new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT))
            .toString());
  }
}
