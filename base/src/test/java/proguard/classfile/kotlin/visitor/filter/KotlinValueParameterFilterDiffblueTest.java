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
import proguard.classfile.kotlin.KotlinConstructorMetadata;
import proguard.classfile.kotlin.KotlinDeclarationContainerMetadata;
import proguard.classfile.kotlin.KotlinFunctionMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.KotlinPropertyMetadata;
import proguard.classfile.kotlin.KotlinValueParameterMetadata;
import proguard.classfile.kotlin.flags.KotlinConstructorFlags;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinValueParameterFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinValueParameterVisitor;

class KotlinValueParameterFilterDiffblueTest {
  /**
   * Test {@link KotlinValueParameterFilter#visitConstructorValParameter(Clazz,
   * KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinValueParameterFilter#visitConstructorValParameter(Clazz,
   * KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitConstructorValParameter(Clazz, KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinValueParameterFilter.visitConstructorValParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata)"
  })
  void testVisitConstructorValParameter_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinValueParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinValueParameterMetadata>any())).thenReturn(false);
    KotlinValueParameterFilter kotlinValueParameterFilter =
        new KotlinValueParameterFilter(predicate, mock(KotlinValueParameterVisitor.class));
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
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;

    // Act
    kotlinValueParameterFilter.visitConstructorValParameter(
        clazz,
        kotlinClassKindMetadata,
        kotlinConstructorMetadata,
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name"));

    // Assert
    verify(predicate).test(isA(KotlinValueParameterMetadata.class));
  }

  /**
   * Test {@link KotlinValueParameterFilter#visitConstructorValParameter(Clazz,
   * KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinValueParameterVisitor#visitConstructorValParameter(Clazz,
   *       KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinValueParameterFilter#visitConstructorValParameter(Clazz,
   * KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitConstructorValParameter(Clazz, KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata); then calls visitConstructorValParameter(Clazz, KotlinClassKindMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinValueParameterFilter.visitConstructorValParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata)"
  })
  void testVisitConstructorValParameter_thenCallsVisitConstructorValParameter() {
    // Arrange
    Predicate<KotlinValueParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinValueParameterMetadata>any())).thenReturn(true);
    KotlinValueParameterVisitor acceptedVisitor = mock(KotlinValueParameterVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitConstructorValParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinClassKindMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any());
    KotlinValueParameterFilter kotlinValueParameterFilter =
        new KotlinValueParameterFilter(predicate, acceptedVisitor);
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
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;

    // Act
    kotlinValueParameterFilter.visitConstructorValParameter(
        clazz,
        kotlinClassKindMetadata,
        kotlinConstructorMetadata,
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name"));

    // Assert
    verify(predicate).test(isA(KotlinValueParameterMetadata.class));
    verify(acceptedVisitor)
        .visitConstructorValParameter(
            isA(Clazz.class),
            isA(KotlinClassKindMetadata.class),
            isA(KotlinConstructorMetadata.class),
            isA(KotlinValueParameterMetadata.class));
  }

  /**
   * Test {@link KotlinValueParameterFilter#visitFunctionValParameter(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinValueParameterMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinValueParameterFilter#visitFunctionValParameter(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionValParameter(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinValueParameterFilter.visitFunctionValParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata)"
  })
  void testVisitFunctionValParameter_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinValueParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinValueParameterMetadata>any())).thenReturn(false);
    KotlinValueParameterFilter kotlinValueParameterFilter =
        new KotlinValueParameterFilter(predicate, mock(KotlinValueParameterVisitor.class));
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

    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;

    // Act
    kotlinValueParameterFilter.visitFunctionValParameter(
        clazz,
        kotlinMetadata,
        kotlinFunctionMetadata,
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name"));

    // Assert
    verify(predicate).test(isA(KotlinValueParameterMetadata.class));
  }

  /**
   * Test {@link KotlinValueParameterFilter#visitFunctionValParameter(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinValueParameterMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinValueParameterVisitor#visitFunctionValParameter(Clazz,
   *       KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinValueParameterFilter#visitFunctionValParameter(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionValParameter(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata); then calls visitFunctionValParameter(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinValueParameterFilter.visitFunctionValParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata)"
  })
  void testVisitFunctionValParameter_thenCallsVisitFunctionValParameter() {
    // Arrange
    Predicate<KotlinValueParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinValueParameterMetadata>any())).thenReturn(true);
    KotlinValueParameterVisitor acceptedVisitor = mock(KotlinValueParameterVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitFunctionValParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any());
    KotlinValueParameterFilter kotlinValueParameterFilter =
        new KotlinValueParameterFilter(predicate, acceptedVisitor);
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

    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;

    // Act
    kotlinValueParameterFilter.visitFunctionValParameter(
        clazz,
        kotlinMetadata,
        kotlinFunctionMetadata,
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name"));

    // Assert
    verify(predicate).test(isA(KotlinValueParameterMetadata.class));
    verify(acceptedVisitor)
        .visitFunctionValParameter(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinValueParameterMetadata.class));
  }

  /**
   * Test {@link KotlinValueParameterFilter#visitPropertyValParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinValueParameterFilter#visitPropertyValParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyValParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinValueParameterFilter.visitPropertyValParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata)"
  })
  void testVisitPropertyValParameter_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinValueParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinValueParameterMetadata>any())).thenReturn(false);
    KotlinValueParameterFilter kotlinValueParameterFilter =
        new KotlinValueParameterFilter(predicate, mock(KotlinValueParameterVisitor.class));
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

    KotlinValueParameterFlags flags2 = new KotlinValueParameterFlags();
    flags2.hasAnnotations = true;
    flags2.hasDefaultValue = true;
    flags2.isCrossInline = true;
    flags2.isNoInline = true;

    // Act
    kotlinValueParameterFilter.visitPropertyValParameter(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        new KotlinValueParameterMetadata(flags2, 1, "Parameter Name"));

    // Assert
    verify(predicate).test(isA(KotlinValueParameterMetadata.class));
  }

  /**
   * Test {@link KotlinValueParameterFilter#visitPropertyValParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinValueParameterVisitor#visitPropertyValParameter(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinPropertyMetadata,
   *       KotlinValueParameterMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinValueParameterFilter#visitPropertyValParameter(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyValParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata); then calls visitPropertyValParameter(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinValueParameterFilter.visitPropertyValParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata)"
  })
  void testVisitPropertyValParameter_thenCallsVisitPropertyValParameter() {
    // Arrange
    Predicate<KotlinValueParameterMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinValueParameterMetadata>any())).thenReturn(true);
    KotlinValueParameterVisitor acceptedVisitor = mock(KotlinValueParameterVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitPropertyValParameter(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any());
    KotlinValueParameterFilter kotlinValueParameterFilter =
        new KotlinValueParameterFilter(predicate, acceptedVisitor);
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

    KotlinValueParameterFlags flags2 = new KotlinValueParameterFlags();
    flags2.hasAnnotations = true;
    flags2.hasDefaultValue = true;
    flags2.isCrossInline = true;
    flags2.isNoInline = true;

    // Act
    kotlinValueParameterFilter.visitPropertyValParameter(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        new KotlinValueParameterMetadata(flags2, 1, "Parameter Name"));

    // Assert
    verify(predicate).test(isA(KotlinValueParameterMetadata.class));
    verify(acceptedVisitor)
        .visitPropertyValParameter(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinValueParameterMetadata.class));
  }
}
