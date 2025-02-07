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
import proguard.classfile.kotlin.flags.KotlinConstructorFlags;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinTypeAliasFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor;

class KotlinVersionRequirementMetadataDiffblueTest {
  /**
   * Test {@link KotlinVersionRequirementMetadata#accept(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinPropertyMetadata, KotlinVersionRequirementVisitor)} with {@code clazz}, {@code
   * kotlinDeclarationContainerMetadata}, {@code kotlinPropertyMetadata}, {@code
   * kotlinVersionRequirementVisitor}.
   *
   * <p>Method under test: {@link KotlinVersionRequirementMetadata#accept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinVersionRequirementVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinVersionRequirementVisitor) with 'clazz', 'kotlinDeclarationContainerMetadata', 'kotlinPropertyMetadata', 'kotlinVersionRequirementVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinVersionRequirementMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor)"
  })
  void
      testAcceptWithClazzKotlinDeclarationContainerMetadataKotlinPropertyMetadataKotlinVersionRequirementVisitor() {
    // Arrange
    KotlinVersionRequirementMetadata kotlinVersionRequirementMetadata =
        new KotlinVersionRequirementMetadata();
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
    KotlinPropertyFlags flags = new KotlinPropertyFlags(visibility, modality);

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
            flags, "Name", getterFlags, new KotlinPropertyAccessorFlags(visibility3, modality3));

    KotlinVersionRequirementVisitor kotlinVersionRequirementVisitor =
        mock(KotlinVersionRequirementVisitor.class);
    doNothing()
        .when(kotlinVersionRequirementVisitor)
        .visitPropertyVersionRequirement(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinVersionRequirementMetadata>any());

    // Act
    kotlinVersionRequirementMetadata.accept(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        kotlinVersionRequirementVisitor);

    // Assert
    verify(kotlinVersionRequirementVisitor)
        .visitPropertyVersionRequirement(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinVersionRequirementMetadata.class));
  }

  /**
   * Test {@link KotlinVersionRequirementMetadata#accept(Clazz, KotlinMetadata,
   * KotlinConstructorMetadata, KotlinVersionRequirementVisitor)} with {@code clazz}, {@code
   * kotlinMetadata}, {@code kotlinConstructorMetadata}, {@code kotlinVersionRequirementVisitor}.
   *
   * <p>Method under test: {@link KotlinVersionRequirementMetadata#accept(Clazz, KotlinMetadata,
   * KotlinConstructorMetadata, KotlinVersionRequirementVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinMetadata, KotlinConstructorMetadata, KotlinVersionRequirementVisitor) with 'clazz', 'kotlinMetadata', 'kotlinConstructorMetadata', 'kotlinVersionRequirementVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinVersionRequirementMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata, proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor)"
  })
  void testAcceptWithClazzKotlinMetadataKotlinConstructorMetadataKotlinVersionRequirementVisitor() {
    // Arrange
    KotlinVersionRequirementMetadata kotlinVersionRequirementMetadata =
        new KotlinVersionRequirementMetadata();
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
    KotlinConstructorMetadata kotlinConstructorMetadata =
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility));
    KotlinVersionRequirementVisitor kotlinVersionRequirementVisitor =
        mock(KotlinVersionRequirementVisitor.class);
    doNothing()
        .when(kotlinVersionRequirementVisitor)
        .visitConstructorVersionRequirement(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any(),
            Mockito.<KotlinVersionRequirementMetadata>any());

    // Act
    kotlinVersionRequirementMetadata.accept(
        clazz, kotlinMetadata, kotlinConstructorMetadata, kotlinVersionRequirementVisitor);

    // Assert
    verify(kotlinVersionRequirementVisitor)
        .visitConstructorVersionRequirement(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinConstructorMetadata.class),
            isA(KotlinVersionRequirementMetadata.class));
  }

  /**
   * Test {@link KotlinVersionRequirementMetadata#accept(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinVersionRequirementVisitor)} with {@code clazz}, {@code
   * kotlinMetadata}, {@code kotlinFunctionMetadata}, {@code kotlinVersionRequirementVisitor}.
   *
   * <p>Method under test: {@link KotlinVersionRequirementMetadata#accept(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinVersionRequirementVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinVersionRequirementVisitor) with 'clazz', 'kotlinMetadata', 'kotlinFunctionMetadata', 'kotlinVersionRequirementVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinVersionRequirementMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor)"
  })
  void testAcceptWithClazzKotlinMetadataKotlinFunctionMetadataKotlinVersionRequirementVisitor() {
    // Arrange
    KotlinVersionRequirementMetadata kotlinVersionRequirementMetadata =
        new KotlinVersionRequirementMetadata();
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

    KotlinVersionRequirementVisitor kotlinVersionRequirementVisitor =
        mock(KotlinVersionRequirementVisitor.class);
    doNothing()
        .when(kotlinVersionRequirementVisitor)
        .visitFunctionVersionRequirement(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinVersionRequirementMetadata>any());

    // Act
    kotlinVersionRequirementMetadata.accept(
        clazz, kotlinMetadata, kotlinFunctionMetadata, kotlinVersionRequirementVisitor);

    // Assert
    verify(kotlinVersionRequirementVisitor)
        .visitFunctionVersionRequirement(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinVersionRequirementMetadata.class));
  }

  /**
   * Test {@link KotlinVersionRequirementMetadata#accept(Clazz, KotlinMetadata,
   * KotlinTypeAliasMetadata, KotlinVersionRequirementVisitor)} with {@code clazz}, {@code
   * kotlinMetadata}, {@code kotlinTypeAliasMetadata}, {@code kotlinVersionRequirementVisitor}.
   *
   * <p>Method under test: {@link KotlinVersionRequirementMetadata#accept(Clazz, KotlinMetadata,
   * KotlinTypeAliasMetadata, KotlinVersionRequirementVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinMetadata, KotlinTypeAliasMetadata, KotlinVersionRequirementVisitor) with 'clazz', 'kotlinMetadata', 'kotlinTypeAliasMetadata', 'kotlinVersionRequirementVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinVersionRequirementMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor)"
  })
  void testAcceptWithClazzKotlinMetadataKotlinTypeAliasMetadataKotlinVersionRequirementVisitor() {
    // Arrange
    KotlinVersionRequirementMetadata kotlinVersionRequirementMetadata =
        new KotlinVersionRequirementMetadata();
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
    KotlinTypeAliasMetadata kotlinTypeAliasMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");

    KotlinVersionRequirementVisitor kotlinVersionRequirementVisitor =
        mock(KotlinVersionRequirementVisitor.class);
    doNothing()
        .when(kotlinVersionRequirementVisitor)
        .visitTypeAliasVersionRequirement(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinTypeAliasMetadata>any(),
            Mockito.<KotlinVersionRequirementMetadata>any());

    // Act
    kotlinVersionRequirementMetadata.accept(
        clazz, kotlinMetadata, kotlinTypeAliasMetadata, kotlinVersionRequirementVisitor);

    // Assert
    verify(kotlinVersionRequirementVisitor)
        .visitTypeAliasVersionRequirement(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinTypeAliasMetadata.class),
            isA(KotlinVersionRequirementMetadata.class));
  }

  /**
   * Test {@link KotlinVersionRequirementMetadata#accept(Clazz, KotlinMetadata,
   * KotlinVersionRequirementVisitor)} with {@code clazz}, {@code kotlinMetadata}, {@code
   * kotlinVersionRequirementVisitor}.
   *
   * <p>Method under test: {@link KotlinVersionRequirementMetadata#accept(Clazz, KotlinMetadata,
   * KotlinVersionRequirementVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinMetadata, KotlinVersionRequirementVisitor) with 'clazz', 'kotlinMetadata', 'kotlinVersionRequirementVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinVersionRequirementMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor)"
  })
  void testAcceptWithClazzKotlinMetadataKotlinVersionRequirementVisitor() {
    // Arrange
    KotlinVersionRequirementMetadata kotlinVersionRequirementMetadata =
        new KotlinVersionRequirementMetadata();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinVersionRequirementVisitor kotlinVersionRequirementVisitor =
        mock(KotlinVersionRequirementVisitor.class);
    doNothing()
        .when(kotlinVersionRequirementVisitor)
        .visitClassVersionRequirement(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinVersionRequirementMetadata>any());

    // Act
    kotlinVersionRequirementMetadata.accept(clazz, kotlinMetadata, kotlinVersionRequirementVisitor);

    // Assert
    verify(kotlinVersionRequirementVisitor)
        .visitClassVersionRequirement(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinVersionRequirementMetadata.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link KotlinVersionRequirementMetadata}
   *   <li>{@link KotlinVersionRequirementMetadata#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinVersionRequirementMetadata.<init>()",
    "java.lang.String proguard.classfile.kotlin.KotlinVersionRequirementMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    KotlinVersionRequirementMetadata actualKotlinVersionRequirementMetadata =
        new KotlinVersionRequirementMetadata();

    // Assert
    assertEquals("Kotlin version req (0.0.0)", actualKotlinVersionRequirementMetadata.toString());
    assertNull(actualKotlinVersionRequirementMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinVersionRequirementMetadata.getProcessingFlags());
  }
}
