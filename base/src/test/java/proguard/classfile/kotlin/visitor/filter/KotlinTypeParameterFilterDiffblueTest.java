package proguard.classfile.kotlin.visitor.filter;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
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
import proguard.classfile.kotlin.visitor.KotlinTypeParameterVisitor;

class KotlinTypeParameterFilterDiffblueTest {
  /**
   * Test {@link KotlinTypeParameterFilter#visitClassTypeParameter(Clazz, KotlinClassKindMetadata,
   * KotlinTypeParameterMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterFilter#visitClassTypeParameter(Clazz,
   * KotlinClassKindMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitClassTypeParameter(Clazz, KotlinClassKindMetadata, KotlinTypeParameterMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeParameterFilter.visitClassTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitClassTypeParameter_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinTypeParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeParameterMetadata>any())).thenReturn(false);
    KotlinTypeParameterFilter kotlinTypeParameterFilter =
        new KotlinTypeParameterFilter(predicate, mock(KotlinTypeParameterVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;

    // Act
    kotlinTypeParameterFilter.visitClassTypeParameter(
        clazz,
        kotlinMetadata,
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(predicate).test(isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link KotlinTypeParameterFilter#visitClassTypeParameter(Clazz, KotlinClassKindMetadata,
   * KotlinTypeParameterMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeParameterVisitor#visitClassTypeParameter(Clazz,
   *       KotlinClassKindMetadata, KotlinTypeParameterMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterFilter#visitClassTypeParameter(Clazz,
   * KotlinClassKindMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitClassTypeParameter(Clazz, KotlinClassKindMetadata, KotlinTypeParameterMetadata); then calls visitClassTypeParameter(Clazz, KotlinClassKindMetadata, KotlinTypeParameterMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeParameterFilter.visitClassTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitClassTypeParameter_thenCallsVisitClassTypeParameter() {
    // Arrange
    Predicate<KotlinTypeParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeParameterMetadata>any())).thenReturn(true);
    KotlinTypeParameterVisitor acceptedVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitClassTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinClassKindMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());
    KotlinTypeParameterFilter kotlinTypeParameterFilter =
        new KotlinTypeParameterFilter(predicate, acceptedVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;

    // Act
    kotlinTypeParameterFilter.visitClassTypeParameter(
        clazz,
        kotlinMetadata,
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(predicate).test(isA(KotlinTypeParameterMetadata.class));
    verify(acceptedVisitor)
        .visitClassTypeParameter(
            isA(Clazz.class),
            isA(KotlinClassKindMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link KotlinTypeParameterFilter#visitPropertyTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterFilter#visitPropertyTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyTypeParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeParameterFilter.visitPropertyTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitPropertyTypeParameter_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinTypeParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeParameterMetadata>any())).thenReturn(false);
    KotlinTypeParameterFilter kotlinTypeParameterFilter =
        new KotlinTypeParameterFilter(predicate, mock(KotlinTypeParameterVisitor.class));
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
    kotlinTypeParameterFilter.visitPropertyTypeParameter(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        new KotlinTypeParameterMetadata(flags2, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(predicate).test(isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link KotlinTypeParameterFilter#visitPropertyTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeParameterVisitor#visitPropertyTypeParameter(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinPropertyMetadata,
   *       KotlinTypeParameterMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterFilter#visitPropertyTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyTypeParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterMetadata); then calls visitPropertyTypeParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeParameterMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeParameterFilter.visitPropertyTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitPropertyTypeParameter_thenCallsVisitPropertyTypeParameter() {
    // Arrange
    Predicate<KotlinTypeParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeParameterMetadata>any())).thenReturn(true);
    KotlinTypeParameterVisitor acceptedVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitPropertyTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());
    KotlinTypeParameterFilter kotlinTypeParameterFilter =
        new KotlinTypeParameterFilter(predicate, acceptedVisitor);
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
    kotlinTypeParameterFilter.visitPropertyTypeParameter(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        new KotlinTypeParameterMetadata(flags2, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(predicate).test(isA(KotlinTypeParameterMetadata.class));
    verify(acceptedVisitor)
        .visitPropertyTypeParameter(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link KotlinTypeParameterFilter#visitFunctionTypeParameter(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeParameterMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterFilter#visitFunctionTypeParameter(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionTypeParameter(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeParameterMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeParameterFilter.visitFunctionTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitFunctionTypeParameter_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinTypeParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeParameterMetadata>any())).thenReturn(false);
    KotlinTypeParameterFilter kotlinTypeParameterFilter =
        new KotlinTypeParameterFilter(predicate, mock(KotlinTypeParameterVisitor.class));
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
    kotlinTypeParameterFilter.visitFunctionTypeParameter(
        clazz,
        kotlinMetadata,
        kotlinFunctionMetadata,
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(predicate).test(isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link KotlinTypeParameterFilter#visitFunctionTypeParameter(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeParameterMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeParameterVisitor#visitFunctionTypeParameter(Clazz,
   *       KotlinMetadata, KotlinFunctionMetadata, KotlinTypeParameterMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterFilter#visitFunctionTypeParameter(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionTypeParameter(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeParameterMetadata); then calls visitFunctionTypeParameter(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeParameterMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeParameterFilter.visitFunctionTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitFunctionTypeParameter_thenCallsVisitFunctionTypeParameter() {
    // Arrange
    Predicate<KotlinTypeParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeParameterMetadata>any())).thenReturn(true);
    KotlinTypeParameterVisitor acceptedVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitFunctionTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());
    KotlinTypeParameterFilter kotlinTypeParameterFilter =
        new KotlinTypeParameterFilter(predicate, acceptedVisitor);
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
    kotlinTypeParameterFilter.visitFunctionTypeParameter(
        clazz,
        kotlinMetadata,
        kotlinFunctionMetadata,
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(predicate).test(isA(KotlinTypeParameterMetadata.class));
    verify(acceptedVisitor)
        .visitFunctionTypeParameter(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link KotlinTypeParameterFilter#visitAliasTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterFilter#visitAliasTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAliasTypeParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeParameterFilter.visitAliasTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitAliasTypeParameter_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinTypeParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeParameterMetadata>any())).thenReturn(false);
    KotlinTypeParameterFilter kotlinTypeParameterFilter =
        new KotlinTypeParameterFilter(predicate, mock(KotlinTypeParameterVisitor.class));
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
    kotlinTypeParameterFilter.visitAliasTypeParameter(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinTypeAliasMetadata,
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(predicate).test(isA(KotlinTypeParameterMetadata.class));
  }

  /**
   * Test {@link KotlinTypeParameterFilter#visitAliasTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeParameterVisitor#visitAliasTypeParameter(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata,
   *       KotlinTypeParameterMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterFilter#visitAliasTypeParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAliasTypeParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterMetadata); then calls visitAliasTypeParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeParameterMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeParameterFilter.visitAliasTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitAliasTypeParameter_thenCallsVisitAliasTypeParameter() {
    // Arrange
    Predicate<KotlinTypeParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeParameterMetadata>any())).thenReturn(true);
    KotlinTypeParameterVisitor acceptedVisitor = mock(KotlinTypeParameterVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitAliasTypeParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeAliasMetadata>any(),
            Mockito.<KotlinTypeParameterMetadata>any());
    KotlinTypeParameterFilter kotlinTypeParameterFilter =
        new KotlinTypeParameterFilter(predicate, acceptedVisitor);
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
    kotlinTypeParameterFilter.visitAliasTypeParameter(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinTypeAliasMetadata,
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT));

    // Assert
    verify(predicate).test(isA(KotlinTypeParameterMetadata.class));
    verify(acceptedVisitor)
        .visitAliasTypeParameter(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeAliasMetadata.class),
            isA(KotlinTypeParameterMetadata.class));
  }
}
