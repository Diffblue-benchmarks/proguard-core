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
import proguard.classfile.kotlin.KotlinFunctionMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.KotlinPropertyMetadata;
import proguard.classfile.kotlin.KotlinTypeAliasMetadata;
import proguard.classfile.kotlin.KotlinTypeParameterMetadata;
import proguard.classfile.kotlin.KotlinTypeVariance;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinTypeAliasFlags;
import proguard.classfile.kotlin.flags.KotlinTypeParameterFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;

class MultiKotlinTypeParameterVisitorDiffblueTest {
  /**
   * Test {@link MultiKotlinTypeParameterVisitor#visitClassTypeParameter(Clazz,
   * KotlinClassKindMetadata, KotlinTypeParameterMetadata)}.
   *
   * <p>Method under test: {@link MultiKotlinTypeParameterVisitor#visitClassTypeParameter(Clazz,
   * KotlinClassKindMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitClassTypeParameter(Clazz, KotlinClassKindMetadata, KotlinTypeParameterMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MultiKotlinTypeParameterVisitor.visitClassTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitClassTypeParameter() {
    // Arrange
    KotlinTypeParameterVisitor kotlinTypeParameterVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(kotlinTypeParameterVisitor)
        .visitClassTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinClassKindMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());
    MultiKotlinTypeParameterVisitor multiKotlinTypeParameterVisitor =
        new MultiKotlinTypeParameterVisitor(kotlinTypeParameterVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;

    // Act
    multiKotlinTypeParameterVisitor.visitClassTypeParameter(
        clazz,
        kotlinClassKindMetadata,
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(kotlinTypeParameterVisitor)
        .visitClassTypeParameter(
            isA(Clazz.class),
            isA(KotlinClassKindMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link MultiKotlinTypeParameterVisitor#visitPropertyTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterMetadata)}.
   *
   * <p>Method under test: {@link MultiKotlinTypeParameterVisitor#visitPropertyTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyTypeParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MultiKotlinTypeParameterVisitor.visitPropertyTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitPropertyTypeParameter() {
    // Arrange
    KotlinTypeParameterVisitor kotlinTypeParameterVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(kotlinTypeParameterVisitor)
        .visitPropertyTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());
    MultiKotlinTypeParameterVisitor multiKotlinTypeParameterVisitor =
        new MultiKotlinTypeParameterVisitor(kotlinTypeParameterVisitor);
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

    KotlinTypeParameterFlags flags2 = new KotlinTypeParameterFlags();
    flags2.isReified = true;

    // Act
    multiKotlinTypeParameterVisitor.visitPropertyTypeParameter(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        new KotlinTypeParameterMetadata(flags2, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(kotlinTypeParameterVisitor)
        .visitPropertyTypeParameter(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link MultiKotlinTypeParameterVisitor#visitFunctionTypeParameter(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeParameterMetadata)}.
   *
   * <p>Method under test: {@link MultiKotlinTypeParameterVisitor#visitFunctionTypeParameter(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionTypeParameter(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeParameterMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MultiKotlinTypeParameterVisitor.visitFunctionTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitFunctionTypeParameter() {
    // Arrange
    KotlinTypeParameterVisitor kotlinTypeParameterVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(kotlinTypeParameterVisitor)
        .visitFunctionTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());
    MultiKotlinTypeParameterVisitor multiKotlinTypeParameterVisitor =
        new MultiKotlinTypeParameterVisitor(kotlinTypeParameterVisitor);
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

    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;

    // Act
    multiKotlinTypeParameterVisitor.visitFunctionTypeParameter(
        clazz,
        kotlinMetadata,
        kotlinFunctionMetadata,
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(kotlinTypeParameterVisitor)
        .visitFunctionTypeParameter(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link MultiKotlinTypeParameterVisitor#visitAliasTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterMetadata)}.
   *
   * <p>Method under test: {@link MultiKotlinTypeParameterVisitor#visitAliasTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAliasTypeParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MultiKotlinTypeParameterVisitor.visitAliasTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitAliasTypeParameter() {
    // Arrange
    KotlinTypeParameterVisitor kotlinTypeParameterVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(kotlinTypeParameterVisitor)
        .visitAliasTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeAliasMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());
    MultiKotlinTypeParameterVisitor multiKotlinTypeParameterVisitor =
        new MultiKotlinTypeParameterVisitor(kotlinTypeParameterVisitor);
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
    KotlinTypeAliasMetadata kotlinTypeAliasMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");

    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;

    // Act
    multiKotlinTypeParameterVisitor.visitAliasTypeParameter(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinTypeAliasMetadata,
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(kotlinTypeParameterVisitor)
        .visitAliasTypeParameter(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeAliasMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }
}
