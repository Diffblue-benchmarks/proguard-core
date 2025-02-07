package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.FieldSignature;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinPropertyVisitor;
import proguard.classfile.kotlin.visitor.KotlinTypeVisitor;
import proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor;

class KotlinPropertyMetadataDiffblueTest {
  /**
   * Test {@link KotlinPropertyMetadata#KotlinPropertyMetadata(KotlinPropertyFlags, String,
   * KotlinPropertyAccessorFlags, KotlinPropertyAccessorFlags)}.
   *
   * <p>Method under test: {@link KotlinPropertyMetadata#KotlinPropertyMetadata(KotlinPropertyFlags,
   * String, KotlinPropertyAccessorFlags, KotlinPropertyAccessorFlags)}
   */
  @Test
  @DisplayName(
      "Test new KotlinPropertyMetadata(KotlinPropertyFlags, String, KotlinPropertyAccessorFlags, KotlinPropertyAccessorFlags)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinPropertyMetadata.<init>(proguard.classfile.kotlin.flags.KotlinPropertyFlags, java.lang.String, proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags, proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags)"
  })
  void testNewKotlinPropertyMetadata() {
    // Arrange
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

    // Act
    KotlinPropertyMetadata actualKotlinPropertyMetadata =
        new KotlinPropertyMetadata(
            flags, "Name", getterFlags, new KotlinPropertyAccessorFlags(visibility3, modality3));

    // Assert
    assertNull(actualKotlinPropertyMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinPropertyMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinPropertyMetadata#accept(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinPropertyVisitor)}.
   *
   * <p>Method under test: {@link KotlinPropertyMetadata#accept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinPropertyMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.visitor.KotlinPropertyVisitor)"
  })
  void testAccept() {
    // Arrange
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
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinPropertyVisitor kotlinPropertyVisitor = mock(KotlinPropertyVisitor.class);
    doNothing()
        .when(kotlinPropertyVisitor)
        .visitProperty(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any());

    // Act
    kotlinPropertyMetadata.accept(clazz, kotlinDeclarationContainerMetadata, kotlinPropertyVisitor);

    // Assert
    verify(kotlinPropertyVisitor)
        .visitProperty(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class));
  }

  /**
   * Test {@link KotlinPropertyMetadata#acceptAsDelegated(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinPropertyVisitor)}.
   *
   * <p>Method under test: {@link KotlinPropertyMetadata#acceptAsDelegated(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyVisitor)}
   */
  @Test
  @DisplayName(
      "Test acceptAsDelegated(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinPropertyMetadata.acceptAsDelegated(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.visitor.KotlinPropertyVisitor)"
  })
  void testAcceptAsDelegated() {
    // Arrange
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
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinPropertyVisitor kotlinPropertyVisitor = mock(KotlinPropertyVisitor.class);
    doNothing()
        .when(kotlinPropertyVisitor)
        .visitDelegatedProperty(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any());

    // Act
    kotlinPropertyMetadata.acceptAsDelegated(
        clazz, kotlinDeclarationContainerMetadata, kotlinPropertyVisitor);

    // Assert
    verify(kotlinPropertyVisitor)
        .visitDelegatedProperty(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class));
  }

  /**
   * Test {@link KotlinPropertyMetadata#typeAccept(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinTypeVisitor)}.
   *
   * <p>Method under test: {@link KotlinPropertyMetadata#typeAccept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeVisitor)}
   */
  @Test
  @DisplayName("Test typeAccept(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinPropertyMetadata.typeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testTypeAccept() {
    // Arrange
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
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitPropertyType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinPropertyMetadata.typeAccept(clazz, kotlinDeclarationContainerMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitPropertyType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isNull());
  }

  /**
   * Test {@link KotlinPropertyMetadata#receiverTypeAccept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitPropertyReceiverType(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinPropertyMetadata#receiverTypeAccept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test receiverTypeAccept(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeVisitor); then calls visitPropertyReceiverType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinPropertyMetadata.receiverTypeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testReceiverTypeAccept_thenCallsVisitPropertyReceiverType() {
    // Arrange
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
    kotlinPropertyMetadata.receiverType = KotlinTypeMetadata.starProjection();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitPropertyReceiverType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinPropertyMetadata.receiverTypeAccept(
        clazz, kotlinDeclarationContainerMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitPropertyReceiverType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinPropertyMetadata#versionRequirementAccept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinVersionRequirementVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinVersionRequirementVisitor#visitPropertyVersionRequirement(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinPropertyMetadata,
   *       KotlinVersionRequirementMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinPropertyMetadata#versionRequirementAccept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinVersionRequirementVisitor)}
   */
  @Test
  @DisplayName(
      "Test versionRequirementAccept(Clazz, KotlinDeclarationContainerMetadata, KotlinVersionRequirementVisitor); then calls visitPropertyVersionRequirement(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinVersionRequirementMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinPropertyMetadata.versionRequirementAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor)"
  })
  void testVersionRequirementAccept_thenCallsVisitPropertyVersionRequirement() {
    // Arrange
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
    kotlinPropertyMetadata.versionRequirement = new KotlinVersionRequirementMetadata();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

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
    kotlinPropertyMetadata.versionRequirementAccept(
        clazz, kotlinDeclarationContainerMetadata, kotlinVersionRequirementVisitor);

    // Assert
    verify(kotlinVersionRequirementVisitor)
        .visitPropertyVersionRequirement(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinVersionRequirementMetadata.class));
  }

  /**
   * Test {@link KotlinPropertyMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin delegated property (Name | bg+)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinPropertyMetadata#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Kotlin delegated property (Name | bg+)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinPropertyMetadata.toString()"
  })
  void testToString_thenReturnKotlinDelegatedPropertyNameBg() {
    // Arrange
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
    KotlinPropertyAccessorFlags setterFlags =
        new KotlinPropertyAccessorFlags(visibility3, modality3);

    KotlinVisibilityFlags visibility4 = new KotlinVisibilityFlags();
    visibility4.isInternal = true;
    visibility4.isLocal = true;
    visibility4.isPrivate = true;
    visibility4.isPrivateToThis = true;
    visibility4.isProtected = true;
    visibility4.isPublic = true;
    KotlinModalityFlags modality4 = new KotlinModalityFlags();
    modality4.isAbstract = true;
    modality4.isFinal = true;
    modality4.isOpen = true;
    modality4.isSealed = true;
    KotlinPropertyFlags kotlinPropertyFlags = new KotlinPropertyFlags(visibility4, modality4);

    kotlinPropertyFlags.isDelegated = true;
    kotlinPropertyFlags.isVar = false;
    KotlinVisibilityFlags visibility5 = new KotlinVisibilityFlags();
    visibility5.isInternal = true;
    visibility5.isLocal = true;
    visibility5.isPrivate = true;
    visibility5.isPrivateToThis = true;
    visibility5.isProtected = true;
    visibility5.isPublic = true;
    KotlinModalityFlags modality5 = new KotlinModalityFlags();
    modality5.isAbstract = true;
    modality5.isFinal = true;
    modality5.isOpen = true;
    modality5.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags =
        new KotlinPropertyAccessorFlags(visibility5, modality5);

    kotlinPropertyAccessorFlags.isDefault = false;
    KotlinVisibilityFlags visibility6 = new KotlinVisibilityFlags();
    visibility6.isInternal = true;
    visibility6.isLocal = true;
    visibility6.isPrivate = true;
    visibility6.isPrivateToThis = true;
    visibility6.isProtected = true;
    visibility6.isPublic = true;
    KotlinModalityFlags modality6 = new KotlinModalityFlags();
    modality6.isAbstract = true;
    modality6.isFinal = true;
    modality6.isOpen = true;
    modality6.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags2 =
        new KotlinPropertyAccessorFlags(visibility6, modality6);

    kotlinPropertyAccessorFlags2.isDefault = false;
    KotlinPropertyMetadata kotlinPropertyMetadata =
        new KotlinPropertyMetadata(flags, "Name", getterFlags, setterFlags);
    kotlinPropertyMetadata.flags = kotlinPropertyFlags;
    kotlinPropertyMetadata.backingFieldSignature =
        new FieldSignature("Clazz Name", "Member Name", "Descriptor");
    kotlinPropertyMetadata.getterFlags = kotlinPropertyAccessorFlags;
    kotlinPropertyMetadata.setterFlags = kotlinPropertyAccessorFlags2;

    // Act and Assert
    assertEquals("Kotlin delegated property (Name | bg+)", kotlinPropertyMetadata.toString());
  }

  /**
   * Test {@link KotlinPropertyMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin property (Name | bg+)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinPropertyMetadata#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Kotlin property (Name | bg+)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinPropertyMetadata.toString()"
  })
  void testToString_thenReturnKotlinPropertyNameBg() {
    // Arrange
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
    KotlinPropertyAccessorFlags setterFlags =
        new KotlinPropertyAccessorFlags(visibility3, modality3);

    KotlinVisibilityFlags visibility4 = new KotlinVisibilityFlags();
    visibility4.isInternal = true;
    visibility4.isLocal = true;
    visibility4.isPrivate = true;
    visibility4.isPrivateToThis = true;
    visibility4.isProtected = true;
    visibility4.isPublic = true;
    KotlinModalityFlags modality4 = new KotlinModalityFlags();
    modality4.isAbstract = true;
    modality4.isFinal = true;
    modality4.isOpen = true;
    modality4.isSealed = true;
    KotlinPropertyFlags kotlinPropertyFlags = new KotlinPropertyFlags(visibility4, modality4);

    kotlinPropertyFlags.isDelegated = false;
    kotlinPropertyFlags.isVar = false;
    KotlinVisibilityFlags visibility5 = new KotlinVisibilityFlags();
    visibility5.isInternal = true;
    visibility5.isLocal = true;
    visibility5.isPrivate = true;
    visibility5.isPrivateToThis = true;
    visibility5.isProtected = true;
    visibility5.isPublic = true;
    KotlinModalityFlags modality5 = new KotlinModalityFlags();
    modality5.isAbstract = true;
    modality5.isFinal = true;
    modality5.isOpen = true;
    modality5.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags =
        new KotlinPropertyAccessorFlags(visibility5, modality5);

    kotlinPropertyAccessorFlags.isDefault = false;
    KotlinVisibilityFlags visibility6 = new KotlinVisibilityFlags();
    visibility6.isInternal = true;
    visibility6.isLocal = true;
    visibility6.isPrivate = true;
    visibility6.isPrivateToThis = true;
    visibility6.isProtected = true;
    visibility6.isPublic = true;
    KotlinModalityFlags modality6 = new KotlinModalityFlags();
    modality6.isAbstract = true;
    modality6.isFinal = true;
    modality6.isOpen = true;
    modality6.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags2 =
        new KotlinPropertyAccessorFlags(visibility6, modality6);

    kotlinPropertyAccessorFlags2.isDefault = false;
    KotlinPropertyMetadata kotlinPropertyMetadata =
        new KotlinPropertyMetadata(flags, "Name", getterFlags, setterFlags);
    kotlinPropertyMetadata.flags = kotlinPropertyFlags;
    kotlinPropertyMetadata.backingFieldSignature =
        new FieldSignature("Clazz Name", "Member Name", "Descriptor");
    kotlinPropertyMetadata.getterFlags = kotlinPropertyAccessorFlags;
    kotlinPropertyMetadata.setterFlags = kotlinPropertyAccessorFlags2;

    // Act and Assert
    assertEquals("Kotlin property (Name | bg+)", kotlinPropertyMetadata.toString());
  }

  /**
   * Test {@link KotlinPropertyMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin property (Name | bg)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinPropertyMetadata#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Kotlin property (Name | bg)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinPropertyMetadata.toString()"
  })
  void testToString_thenReturnKotlinPropertyNameBg2() {
    // Arrange
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
    KotlinPropertyAccessorFlags setterFlags =
        new KotlinPropertyAccessorFlags(visibility3, modality3);

    KotlinVisibilityFlags visibility4 = new KotlinVisibilityFlags();
    visibility4.isInternal = true;
    visibility4.isLocal = true;
    visibility4.isPrivate = true;
    visibility4.isPrivateToThis = true;
    visibility4.isProtected = true;
    visibility4.isPublic = true;
    KotlinModalityFlags modality4 = new KotlinModalityFlags();
    modality4.isAbstract = true;
    modality4.isFinal = true;
    modality4.isOpen = true;
    modality4.isSealed = true;
    KotlinPropertyFlags kotlinPropertyFlags = new KotlinPropertyFlags(visibility4, modality4);

    kotlinPropertyFlags.isDelegated = false;
    kotlinPropertyFlags.isVar = false;
    KotlinVisibilityFlags visibility5 = new KotlinVisibilityFlags();
    visibility5.isInternal = true;
    visibility5.isLocal = true;
    visibility5.isPrivate = true;
    visibility5.isPrivateToThis = true;
    visibility5.isProtected = true;
    visibility5.isPublic = true;
    KotlinModalityFlags modality5 = new KotlinModalityFlags();
    modality5.isAbstract = true;
    modality5.isFinal = true;
    modality5.isOpen = true;
    modality5.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags =
        new KotlinPropertyAccessorFlags(visibility5, modality5);

    kotlinPropertyAccessorFlags.isDefault = true;
    KotlinVisibilityFlags visibility6 = new KotlinVisibilityFlags();
    visibility6.isInternal = true;
    visibility6.isLocal = true;
    visibility6.isPrivate = true;
    visibility6.isPrivateToThis = true;
    visibility6.isProtected = true;
    visibility6.isPublic = true;
    KotlinModalityFlags modality6 = new KotlinModalityFlags();
    modality6.isAbstract = true;
    modality6.isFinal = true;
    modality6.isOpen = true;
    modality6.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags2 =
        new KotlinPropertyAccessorFlags(visibility6, modality6);

    kotlinPropertyAccessorFlags2.isDefault = false;
    KotlinPropertyMetadata kotlinPropertyMetadata =
        new KotlinPropertyMetadata(flags, "Name", getterFlags, setterFlags);
    kotlinPropertyMetadata.flags = kotlinPropertyFlags;
    kotlinPropertyMetadata.backingFieldSignature =
        new FieldSignature("Clazz Name", "Member Name", "Descriptor");
    kotlinPropertyMetadata.getterFlags = kotlinPropertyAccessorFlags;
    kotlinPropertyMetadata.setterFlags = kotlinPropertyAccessorFlags2;

    // Act and Assert
    assertEquals("Kotlin property (Name | bg)", kotlinPropertyMetadata.toString());
  }

  /**
   * Test {@link KotlinPropertyMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin property (Name | bg+s+)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinPropertyMetadata#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Kotlin property (Name | bg+s+)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinPropertyMetadata.toString()"
  })
  void testToString_thenReturnKotlinPropertyNameBgS() {
    // Arrange
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
    KotlinPropertyAccessorFlags setterFlags =
        new KotlinPropertyAccessorFlags(visibility3, modality3);

    KotlinVisibilityFlags visibility4 = new KotlinVisibilityFlags();
    visibility4.isInternal = true;
    visibility4.isLocal = true;
    visibility4.isPrivate = true;
    visibility4.isPrivateToThis = true;
    visibility4.isProtected = true;
    visibility4.isPublic = true;
    KotlinModalityFlags modality4 = new KotlinModalityFlags();
    modality4.isAbstract = true;
    modality4.isFinal = true;
    modality4.isOpen = true;
    modality4.isSealed = true;
    KotlinPropertyFlags kotlinPropertyFlags = new KotlinPropertyFlags(visibility4, modality4);

    kotlinPropertyFlags.isDelegated = false;
    kotlinPropertyFlags.isVar = true;
    KotlinVisibilityFlags visibility5 = new KotlinVisibilityFlags();
    visibility5.isInternal = true;
    visibility5.isLocal = true;
    visibility5.isPrivate = true;
    visibility5.isPrivateToThis = true;
    visibility5.isProtected = true;
    visibility5.isPublic = true;
    KotlinModalityFlags modality5 = new KotlinModalityFlags();
    modality5.isAbstract = true;
    modality5.isFinal = true;
    modality5.isOpen = true;
    modality5.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags =
        new KotlinPropertyAccessorFlags(visibility5, modality5);

    kotlinPropertyAccessorFlags.isDefault = false;
    KotlinVisibilityFlags visibility6 = new KotlinVisibilityFlags();
    visibility6.isInternal = true;
    visibility6.isLocal = true;
    visibility6.isPrivate = true;
    visibility6.isPrivateToThis = true;
    visibility6.isProtected = true;
    visibility6.isPublic = true;
    KotlinModalityFlags modality6 = new KotlinModalityFlags();
    modality6.isAbstract = true;
    modality6.isFinal = true;
    modality6.isOpen = true;
    modality6.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags2 =
        new KotlinPropertyAccessorFlags(visibility6, modality6);

    kotlinPropertyAccessorFlags2.isDefault = false;
    KotlinPropertyMetadata kotlinPropertyMetadata =
        new KotlinPropertyMetadata(flags, "Name", getterFlags, setterFlags);
    kotlinPropertyMetadata.flags = kotlinPropertyFlags;
    kotlinPropertyMetadata.backingFieldSignature =
        new FieldSignature("Clazz Name", "Member Name", "Descriptor");
    kotlinPropertyMetadata.getterFlags = kotlinPropertyAccessorFlags;
    kotlinPropertyMetadata.setterFlags = kotlinPropertyAccessorFlags2;

    // Act and Assert
    assertEquals("Kotlin property (Name | bg+s+)", kotlinPropertyMetadata.toString());
  }

  /**
   * Test {@link KotlinPropertyMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin property (Name | g+)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinPropertyMetadata#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Kotlin property (Name | g+)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinPropertyMetadata.toString()"
  })
  void testToString_thenReturnKotlinPropertyNameG() {
    // Arrange
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

    // Act and Assert
    assertEquals(
        "Kotlin property (Name | g+)",
        (new KotlinPropertyMetadata(
                flags,
                "Name",
                getterFlags,
                new KotlinPropertyAccessorFlags(visibility3, modality3)))
            .toString());
  }
}
