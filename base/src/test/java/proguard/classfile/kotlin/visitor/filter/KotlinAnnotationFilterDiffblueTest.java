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
import proguard.classfile.kotlin.KotlinAnnotation;
import proguard.classfile.kotlin.KotlinTypeAliasMetadata;
import proguard.classfile.kotlin.KotlinTypeMetadata;
import proguard.classfile.kotlin.KotlinTypeParameterMetadata;
import proguard.classfile.kotlin.KotlinTypeVariance;
import proguard.classfile.kotlin.flags.KotlinTypeAliasFlags;
import proguard.classfile.kotlin.flags.KotlinTypeParameterFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinAnnotationVisitor;

class KotlinAnnotationFilterDiffblueTest {
  /**
   * Test {@link KotlinAnnotationFilter#visitTypeAnnotation(Clazz, KotlinTypeMetadata,
   * KotlinAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationFilter#visitTypeAnnotation(Clazz,
   * KotlinTypeMetadata, KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAnnotation(Clazz, KotlinTypeMetadata, KotlinAnnotation); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinAnnotationFilter.visitTypeAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testVisitTypeAnnotation_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinAnnotation> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinAnnotation>any())).thenReturn(false);
    KotlinAnnotationFilter kotlinAnnotationFilter =
        new KotlinAnnotationFilter(predicate, mock(KotlinAnnotationVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata kotlinTypeMetadata = KotlinTypeMetadata.starProjection();

    // Act
    kotlinAnnotationFilter.visitTypeAnnotation(
        clazz, kotlinTypeMetadata, new KotlinAnnotation("Class Name"));

    // Assert
    verify(predicate).test(isA(KotlinAnnotation.class));
  }

  /**
   * Test {@link KotlinAnnotationFilter#visitTypeAnnotation(Clazz, KotlinTypeMetadata,
   * KotlinAnnotation)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinAnnotationVisitor#visitTypeAnnotation(Clazz, KotlinTypeMetadata,
   *       KotlinAnnotation)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationFilter#visitTypeAnnotation(Clazz,
   * KotlinTypeMetadata, KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAnnotation(Clazz, KotlinTypeMetadata, KotlinAnnotation); then calls visitTypeAnnotation(Clazz, KotlinTypeMetadata, KotlinAnnotation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinAnnotationFilter.visitTypeAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testVisitTypeAnnotation_thenCallsVisitTypeAnnotation() {
    // Arrange
    Predicate<KotlinAnnotation> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinAnnotation>any())).thenReturn(true);
    KotlinAnnotationVisitor acceptedKotlinAnnotationVisitor = mock(KotlinAnnotationVisitor.class);
    doNothing()
        .when(acceptedKotlinAnnotationVisitor)
        .visitTypeAnnotation(
            Mockito.<Clazz>any(),
            Mockito.<KotlinTypeMetadata>any(),
            Mockito.<KotlinAnnotation>any());
    KotlinAnnotationFilter kotlinAnnotationFilter =
        new KotlinAnnotationFilter(predicate, acceptedKotlinAnnotationVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata kotlinTypeMetadata = KotlinTypeMetadata.starProjection();

    // Act
    kotlinAnnotationFilter.visitTypeAnnotation(
        clazz, kotlinTypeMetadata, new KotlinAnnotation("Class Name"));

    // Assert
    verify(predicate).test(isA(KotlinAnnotation.class));
    verify(acceptedKotlinAnnotationVisitor)
        .visitTypeAnnotation(
            isA(Clazz.class), isA(KotlinTypeMetadata.class), isA(KotlinAnnotation.class));
  }

  /**
   * Test {@link KotlinAnnotationFilter#visitTypeParameterAnnotation(Clazz,
   * KotlinTypeParameterMetadata, KotlinAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationFilter#visitTypeParameterAnnotation(Clazz,
   * KotlinTypeParameterMetadata, KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitTypeParameterAnnotation(Clazz, KotlinTypeParameterMetadata, KotlinAnnotation); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinAnnotationFilter.visitTypeParameterAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeParameterMetadata, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testVisitTypeParameterAnnotation_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinAnnotation> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinAnnotation>any())).thenReturn(false);
    KotlinAnnotationFilter kotlinAnnotationFilter =
        new KotlinAnnotationFilter(predicate, mock(KotlinAnnotationVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterMetadata kotlinTypeParameterMetadata =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);

    // Act
    kotlinAnnotationFilter.visitTypeParameterAnnotation(
        clazz, kotlinTypeParameterMetadata, new KotlinAnnotation("Class Name"));

    // Assert
    verify(predicate).test(isA(KotlinAnnotation.class));
  }

  /**
   * Test {@link KotlinAnnotationFilter#visitTypeParameterAnnotation(Clazz,
   * KotlinTypeParameterMetadata, KotlinAnnotation)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinAnnotationVisitor#visitTypeParameterAnnotation(Clazz,
   *       KotlinTypeParameterMetadata, KotlinAnnotation)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationFilter#visitTypeParameterAnnotation(Clazz,
   * KotlinTypeParameterMetadata, KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitTypeParameterAnnotation(Clazz, KotlinTypeParameterMetadata, KotlinAnnotation); then calls visitTypeParameterAnnotation(Clazz, KotlinTypeParameterMetadata, KotlinAnnotation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinAnnotationFilter.visitTypeParameterAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeParameterMetadata, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testVisitTypeParameterAnnotation_thenCallsVisitTypeParameterAnnotation() {
    // Arrange
    Predicate<KotlinAnnotation> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinAnnotation>any())).thenReturn(true);
    KotlinAnnotationVisitor acceptedKotlinAnnotationVisitor = mock(KotlinAnnotationVisitor.class);
    doNothing()
        .when(acceptedKotlinAnnotationVisitor)
        .visitTypeParameterAnnotation(
            Mockito.<Clazz>any(),
            Mockito.<KotlinTypeParameterMetadata>any(),
            Mockito.<KotlinAnnotation>any());
    KotlinAnnotationFilter kotlinAnnotationFilter =
        new KotlinAnnotationFilter(predicate, acceptedKotlinAnnotationVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterMetadata kotlinTypeParameterMetadata =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);

    // Act
    kotlinAnnotationFilter.visitTypeParameterAnnotation(
        clazz, kotlinTypeParameterMetadata, new KotlinAnnotation("Class Name"));

    // Assert
    verify(predicate).test(isA(KotlinAnnotation.class));
    verify(acceptedKotlinAnnotationVisitor)
        .visitTypeParameterAnnotation(
            isA(Clazz.class), isA(KotlinTypeParameterMetadata.class), isA(KotlinAnnotation.class));
  }

  /**
   * Test {@link KotlinAnnotationFilter#visitTypeAliasAnnotation(Clazz, KotlinTypeAliasMetadata,
   * KotlinAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationFilter#visitTypeAliasAnnotation(Clazz,
   * KotlinTypeAliasMetadata, KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAliasAnnotation(Clazz, KotlinTypeAliasMetadata, KotlinAnnotation); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinAnnotationFilter.visitTypeAliasAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testVisitTypeAliasAnnotation_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinAnnotation> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinAnnotation>any())).thenReturn(false);
    KotlinAnnotationFilter kotlinAnnotationFilter =
        new KotlinAnnotationFilter(predicate, mock(KotlinAnnotationVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinTypeAliasMetadata kotlinTypeAliasMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");

    // Act
    kotlinAnnotationFilter.visitTypeAliasAnnotation(
        clazz, kotlinTypeAliasMetadata, new KotlinAnnotation("Class Name"));

    // Assert
    verify(predicate).test(isA(KotlinAnnotation.class));
  }

  /**
   * Test {@link KotlinAnnotationFilter#visitTypeAliasAnnotation(Clazz, KotlinTypeAliasMetadata,
   * KotlinAnnotation)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinAnnotationVisitor#visitTypeAliasAnnotation(Clazz,
   *       KotlinTypeAliasMetadata, KotlinAnnotation)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationFilter#visitTypeAliasAnnotation(Clazz,
   * KotlinTypeAliasMetadata, KotlinAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAliasAnnotation(Clazz, KotlinTypeAliasMetadata, KotlinAnnotation); then calls visitTypeAliasAnnotation(Clazz, KotlinTypeAliasMetadata, KotlinAnnotation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinAnnotationFilter.visitTypeAliasAnnotation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.KotlinAnnotation)"
  })
  void testVisitTypeAliasAnnotation_thenCallsVisitTypeAliasAnnotation() {
    // Arrange
    Predicate<KotlinAnnotation> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinAnnotation>any())).thenReturn(true);
    KotlinAnnotationVisitor acceptedKotlinAnnotationVisitor = mock(KotlinAnnotationVisitor.class);
    doNothing()
        .when(acceptedKotlinAnnotationVisitor)
        .visitTypeAliasAnnotation(
            Mockito.<Clazz>any(),
            Mockito.<KotlinTypeAliasMetadata>any(),
            Mockito.<KotlinAnnotation>any());
    KotlinAnnotationFilter kotlinAnnotationFilter =
        new KotlinAnnotationFilter(predicate, acceptedKotlinAnnotationVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinTypeAliasMetadata kotlinTypeAliasMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");

    // Act
    kotlinAnnotationFilter.visitTypeAliasAnnotation(
        clazz, kotlinTypeAliasMetadata, new KotlinAnnotation("Class Name"));

    // Assert
    verify(predicate).test(isA(KotlinAnnotation.class));
    verify(acceptedKotlinAnnotationVisitor)
        .visitTypeAliasAnnotation(
            isA(Clazz.class), isA(KotlinTypeAliasMetadata.class), isA(KotlinAnnotation.class));
  }
}
