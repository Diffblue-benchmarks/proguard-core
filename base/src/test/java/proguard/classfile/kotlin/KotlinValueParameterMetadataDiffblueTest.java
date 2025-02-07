package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.flags.KotlinConstructorFlags;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinValueParameterFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinTypeVisitor;
import proguard.classfile.kotlin.visitor.KotlinValueParameterVisitor;

class KotlinValueParameterMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       KotlinValueParameterMetadata#KotlinValueParameterMetadata(KotlinValueParameterFlags, int,
   *       String)}
   *   <li>{@link KotlinValueParameterMetadata#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinValueParameterMetadata.<init>(proguard.classfile.kotlin.flags.KotlinValueParameterFlags, int, java.lang.String)",
    "java.lang.String proguard.classfile.kotlin.KotlinValueParameterMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;

    // Act
    KotlinValueParameterMetadata actualKotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");

    // Assert
    assertEquals(
        "Kotlin value parameter 'Parameter Name'", actualKotlinValueParameterMetadata.toString());
    assertNull(actualKotlinValueParameterMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinValueParameterMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinValueParameterMetadata#accept(Clazz, KotlinClassKindMetadata,
   * KotlinConstructorMetadata, KotlinValueParameterVisitor)} with {@code clazz}, {@code
   * kotlinClassKindMetadata}, {@code kotlinConstructorMetadata}, {@code
   * kotlinValueParameterVisitor}.
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#accept(Clazz,
   * KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterVisitor) with 'clazz', 'kotlinClassKindMetadata', 'kotlinConstructorMetadata', 'kotlinValueParameterVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinValueParameterMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata, proguard.classfile.kotlin.visitor.KotlinValueParameterVisitor)"
  })
  void
      testAcceptWithClazzKotlinClassKindMetadataKotlinConstructorMetadataKotlinValueParameterVisitor() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinClassKindMetadata =
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
    KotlinValueParameterVisitor kotlinValueParameterVisitor =
        mock(KotlinValueParameterVisitor.class);
    doNothing()
        .when(kotlinValueParameterVisitor)
        .visitConstructorValParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinClassKindMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any());

    // Act
    kotlinValueParameterMetadata.accept(
        clazz, kotlinClassKindMetadata, kotlinConstructorMetadata, kotlinValueParameterVisitor);

    // Assert
    verify(kotlinValueParameterVisitor)
        .visitConstructorValParameter(
            isA(Clazz.class),
            isA(KotlinClassKindMetadata.class),
            isA(KotlinConstructorMetadata.class),
            isA(KotlinValueParameterMetadata.class));
  }

  /**
   * Test {@link KotlinValueParameterMetadata#accept(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinPropertyMetadata, KotlinValueParameterVisitor)} with {@code clazz}, {@code
   * kotlinDeclarationContainerMetadata}, {@code kotlinPropertyMetadata}, {@code
   * kotlinValueParameterVisitor}.
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#accept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterVisitor) with 'clazz', 'kotlinDeclarationContainerMetadata', 'kotlinPropertyMetadata', 'kotlinValueParameterVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinValueParameterMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.visitor.KotlinValueParameterVisitor)"
  })
  void
      testAcceptWithClazzKotlinDeclarationContainerMetadataKotlinPropertyMetadataKotlinValueParameterVisitor() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");
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

    KotlinValueParameterVisitor kotlinValueParameterVisitor =
        mock(KotlinValueParameterVisitor.class);
    doNothing()
        .when(kotlinValueParameterVisitor)
        .visitPropertyValParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any());

    // Act
    kotlinValueParameterMetadata.accept(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        kotlinValueParameterVisitor);

    // Assert
    verify(kotlinValueParameterVisitor)
        .visitPropertyValParameter(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinValueParameterMetadata.class));
  }

  /**
   * Test {@link KotlinValueParameterMetadata#accept(Clazz, KotlinMetadata, KotlinFunctionMetadata,
   * KotlinValueParameterVisitor)} with {@code clazz}, {@code kotlinMetadata}, {@code
   * kotlinFunctionMetadata}, {@code kotlinValueParameterVisitor}.
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#accept(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinValueParameterVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterVisitor) with 'clazz', 'kotlinMetadata', 'kotlinFunctionMetadata', 'kotlinValueParameterVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinValueParameterMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.visitor.KotlinValueParameterVisitor)"
  })
  void testAcceptWithClazzKotlinMetadataKotlinFunctionMetadataKotlinValueParameterVisitor() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");
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

    KotlinValueParameterVisitor kotlinValueParameterVisitor =
        mock(KotlinValueParameterVisitor.class);
    doNothing()
        .when(kotlinValueParameterVisitor)
        .visitFunctionValParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any());

    // Act
    kotlinValueParameterMetadata.accept(
        clazz, kotlinMetadata, kotlinFunctionMetadata, kotlinValueParameterVisitor);

    // Assert
    verify(kotlinValueParameterVisitor)
        .visitFunctionValParameter(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinValueParameterMetadata.class));
  }

  /**
   * Test {@link KotlinValueParameterMetadata#typeAccept(Clazz, KotlinClassKindMetadata,
   * KotlinConstructorMetadata, KotlinTypeVisitor)} with {@code clazz}, {@code
   * kotlinClassKindMetadata}, {@code kotlinConstructorMetadata}, {@code kotlinTypeVisitor}.
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#typeAccept(Clazz,
   * KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test typeAccept(Clazz, KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinTypeVisitor) with 'clazz', 'kotlinClassKindMetadata', 'kotlinConstructorMetadata', 'kotlinTypeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinValueParameterMetadata.typeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testTypeAcceptWithClazzKotlinClassKindMetadataKotlinConstructorMetadataKotlinTypeVisitor() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinClassKindMetadata =
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
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitConstructorValParamType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinValueParameterMetadata.typeAccept(
        clazz, kotlinClassKindMetadata, kotlinConstructorMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitConstructorValParamType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinConstructorMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isNull());
  }

  /**
   * Test {@link KotlinValueParameterMetadata#typeAccept(Clazz, KotlinClassKindMetadata,
   * KotlinConstructorMetadata, KotlinTypeVisitor)} with {@code clazz}, {@code
   * kotlinClassKindMetadata}, {@code kotlinConstructorMetadata}, {@code kotlinTypeVisitor}.
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#typeAccept(Clazz,
   * KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test typeAccept(Clazz, KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinTypeVisitor) with 'clazz', 'kotlinClassKindMetadata', 'kotlinConstructorMetadata', 'kotlinTypeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinValueParameterMetadata.typeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testTypeAcceptWithClazzKotlinClassKindMetadataKotlinConstructorMetadataKotlinTypeVisitor2() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");
    kotlinValueParameterMetadata.varArgElementType = KotlinTypeMetadata.starProjection();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinClassKindMetadata =
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
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitConstructorValParamVarArgType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    doNothing()
        .when(kotlinTypeVisitor)
        .visitConstructorValParamType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinValueParameterMetadata.typeAccept(
        clazz, kotlinClassKindMetadata, kotlinConstructorMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitConstructorValParamType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinConstructorMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isNull());
    verify(kotlinTypeVisitor)
        .visitConstructorValParamVarArgType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinConstructorMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinValueParameterMetadata#typeAccept(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinPropertyMetadata, KotlinTypeVisitor)} with {@code clazz}, {@code
   * kotlinDeclarationContainerMetadata}, {@code kotlinPropertyMetadata}, {@code kotlinTypeVisitor}.
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#typeAccept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test typeAccept(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeVisitor) with 'clazz', 'kotlinDeclarationContainerMetadata', 'kotlinPropertyMetadata', 'kotlinTypeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinValueParameterMetadata.typeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void
      testTypeAcceptWithClazzKotlinDeclarationContainerMetadataKotlinPropertyMetadataKotlinTypeVisitor() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");
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

    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitPropertyValParamType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinValueParameterMetadata.typeAccept(
        clazz, kotlinDeclarationContainerMetadata, kotlinPropertyMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitPropertyValParamType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isNull());
  }

  /**
   * Test {@link KotlinValueParameterMetadata#typeAccept(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinPropertyMetadata, KotlinTypeVisitor)} with {@code clazz}, {@code
   * kotlinDeclarationContainerMetadata}, {@code kotlinPropertyMetadata}, {@code kotlinTypeVisitor}.
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#typeAccept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test typeAccept(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeVisitor) with 'clazz', 'kotlinDeclarationContainerMetadata', 'kotlinPropertyMetadata', 'kotlinTypeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinValueParameterMetadata.typeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void
      testTypeAcceptWithClazzKotlinDeclarationContainerMetadataKotlinPropertyMetadataKotlinTypeVisitor2() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");
    kotlinValueParameterMetadata.varArgElementType = KotlinTypeMetadata.starProjection();
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

    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitPropertyValParamVarArgType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    doNothing()
        .when(kotlinTypeVisitor)
        .visitPropertyValParamType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinValueParameterMetadata.typeAccept(
        clazz, kotlinDeclarationContainerMetadata, kotlinPropertyMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitPropertyValParamType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isNull());
    verify(kotlinTypeVisitor)
        .visitPropertyValParamVarArgType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinValueParameterMetadata#typeAccept(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeVisitor)} with {@code clazz}, {@code kotlinMetadata}, {@code
   * kotlinFunctionMetadata}, {@code kotlinTypeVisitor}.
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#typeAccept(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test typeAccept(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeVisitor) with 'clazz', 'kotlinMetadata', 'kotlinFunctionMetadata', 'kotlinTypeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinValueParameterMetadata.typeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testTypeAcceptWithClazzKotlinMetadataKotlinFunctionMetadataKotlinTypeVisitor() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");
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

    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitFunctionValParamType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinValueParameterMetadata.typeAccept(
        clazz, kotlinMetadata, kotlinFunctionMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitFunctionValParamType(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isNull());
  }

  /**
   * Test {@link KotlinValueParameterMetadata#typeAccept(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeVisitor)} with {@code clazz}, {@code kotlinMetadata}, {@code
   * kotlinFunctionMetadata}, {@code kotlinTypeVisitor}.
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#typeAccept(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test typeAccept(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeVisitor) with 'clazz', 'kotlinMetadata', 'kotlinFunctionMetadata', 'kotlinTypeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinValueParameterMetadata.typeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testTypeAcceptWithClazzKotlinMetadataKotlinFunctionMetadataKotlinTypeVisitor2() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");
    kotlinValueParameterMetadata.varArgElementType = KotlinTypeMetadata.starProjection();
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

    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitFunctionValParamVarArgType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    doNothing()
        .when(kotlinTypeVisitor)
        .visitFunctionValParamType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinValueParameterMetadata.typeAccept(
        clazz, kotlinMetadata, kotlinFunctionMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitFunctionValParamType(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isNull());
    verify(kotlinTypeVisitor)
        .visitFunctionValParamVarArgType(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinValueParameterMetadata#isVarArg()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#isVarArg()}
   */
  @Test
  @DisplayName("Test isVarArg(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.kotlin.KotlinValueParameterMetadata.isVarArg()"})
  void testIsVarArg_thenReturnFalse() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;

    // Act and Assert
    assertFalse((new KotlinValueParameterMetadata(flags, 1, "Parameter Name")).isVarArg());
  }

  /**
   * Test {@link KotlinValueParameterMetadata#isVarArg()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#isVarArg()}
   */
  @Test
  @DisplayName("Test isVarArg(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.kotlin.KotlinValueParameterMetadata.isVarArg()"})
  void testIsVarArg_thenReturnTrue() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");
    kotlinValueParameterMetadata.varArgElementType = KotlinTypeMetadata.starProjection();

    // Act and Assert
    assertTrue(kotlinValueParameterMetadata.isVarArg());
  }
}
