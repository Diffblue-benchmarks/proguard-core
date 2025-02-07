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
import proguard.classfile.kotlin.KotlinEffectExpressionMetadata;
import proguard.classfile.kotlin.KotlinFunctionMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.KotlinPropertyMetadata;
import proguard.classfile.kotlin.KotlinTypeAliasMetadata;
import proguard.classfile.kotlin.KotlinTypeMetadata;
import proguard.classfile.kotlin.KotlinTypeParameterMetadata;
import proguard.classfile.kotlin.KotlinTypeVariance;
import proguard.classfile.kotlin.KotlinValueParameterMetadata;
import proguard.classfile.kotlin.flags.KotlinConstructorFlags;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinTypeAliasFlags;
import proguard.classfile.kotlin.flags.KotlinTypeParameterFlags;
import proguard.classfile.kotlin.flags.KotlinValueParameterFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinTypeVisitor;

class KotlinTypeFilterDiffblueTest {
  /**
   * Test {@link KotlinTypeFilter#visitTypeUpperBound(Clazz, KotlinTypeMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitTypeUpperBound(Clazz, KotlinTypeMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitTypeUpperBound(Clazz, KotlinTypeMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitTypeUpperBound(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitTypeUpperBound_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata boundedType = KotlinTypeMetadata.starProjection();

    // Act
    kotlinTypeFilter.visitTypeUpperBound(clazz, boundedType, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitTypeUpperBound(Clazz, KotlinTypeMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitTypeUpperBound(Clazz, KotlinTypeMetadata,
   *       KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitTypeUpperBound(Clazz, KotlinTypeMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitTypeUpperBound(Clazz, KotlinTypeMetadata, KotlinTypeMetadata); then calls visitTypeUpperBound(Clazz, KotlinTypeMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitTypeUpperBound(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitTypeUpperBound_thenCallsVisitTypeUpperBound() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitTypeUpperBound(
            Mockito.<Clazz>any(),
            Mockito.<KotlinTypeMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata boundedType = KotlinTypeMetadata.starProjection();

    // Act
    kotlinTypeFilter.visitTypeUpperBound(clazz, boundedType, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitTypeUpperBound(
            isA(Clazz.class), isA(KotlinTypeMetadata.class), isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitAbbreviation(Clazz, KotlinTypeMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitAbbreviation(Clazz, KotlinTypeMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAbbreviation(Clazz, KotlinTypeMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitAbbreviation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitAbbreviation_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata kotlinTypeMetadata = KotlinTypeMetadata.starProjection();

    // Act
    kotlinTypeFilter.visitAbbreviation(
        clazz, kotlinTypeMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitAbbreviation(Clazz, KotlinTypeMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link KotlinTypeVisitor#visitAbbreviation(Clazz, KotlinTypeMetadata,
   *       KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitAbbreviation(Clazz, KotlinTypeMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAbbreviation(Clazz, KotlinTypeMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'true'; then calls visitAbbreviation(Clazz, KotlinTypeMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitAbbreviation(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitAbbreviation_givenPredicateTestReturnTrue_thenCallsVisitAbbreviation() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitAbbreviation(
            Mockito.<Clazz>any(),
            Mockito.<KotlinTypeMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata kotlinTypeMetadata = KotlinTypeMetadata.starProjection();

    // Act
    kotlinTypeFilter.visitAbbreviation(
        clazz, kotlinTypeMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitAbbreviation(
            isA(Clazz.class), isA(KotlinTypeMetadata.class), isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitParameterUpperBound(Clazz, KotlinTypeParameterMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitParameterUpperBound(Clazz,
   * KotlinTypeParameterMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitParameterUpperBound(Clazz, KotlinTypeParameterMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitParameterUpperBound(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitParameterUpperBound_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterMetadata boundedTypeParameter =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);

    // Act
    kotlinTypeFilter.visitParameterUpperBound(
        clazz, boundedTypeParameter, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitParameterUpperBound(Clazz, KotlinTypeParameterMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitParameterUpperBound(Clazz,
   *       KotlinTypeParameterMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitParameterUpperBound(Clazz,
   * KotlinTypeParameterMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitParameterUpperBound(Clazz, KotlinTypeParameterMetadata, KotlinTypeMetadata); then calls visitParameterUpperBound(Clazz, KotlinTypeParameterMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitParameterUpperBound(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitParameterUpperBound_thenCallsVisitParameterUpperBound() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitParameterUpperBound(
            Mockito.<Clazz>any(),
            Mockito.<KotlinTypeParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterMetadata boundedTypeParameter =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);

    // Act
    kotlinTypeFilter.visitParameterUpperBound(
        clazz, boundedTypeParameter, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitParameterUpperBound(
            isA(Clazz.class),
            isA(KotlinTypeParameterMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitTypeOfIsExpression(Clazz, KotlinEffectExpressionMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitTypeOfIsExpression(Clazz,
   * KotlinEffectExpressionMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitTypeOfIsExpression(Clazz, KotlinEffectExpressionMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitTypeOfIsExpression(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinEffectExpressionMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitTypeOfIsExpression_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinEffectExpressionMetadata kotlinEffectExprMetadata = new KotlinEffectExpressionMetadata();

    // Act
    kotlinTypeFilter.visitTypeOfIsExpression(
        clazz, kotlinEffectExprMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitTypeOfIsExpression(Clazz, KotlinEffectExpressionMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitTypeOfIsExpression(Clazz,
   *       KotlinEffectExpressionMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitTypeOfIsExpression(Clazz,
   * KotlinEffectExpressionMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitTypeOfIsExpression(Clazz, KotlinEffectExpressionMetadata, KotlinTypeMetadata); then calls visitTypeOfIsExpression(Clazz, KotlinEffectExpressionMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitTypeOfIsExpression(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinEffectExpressionMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitTypeOfIsExpression_thenCallsVisitTypeOfIsExpression() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitTypeOfIsExpression(
            Mockito.<Clazz>any(),
            Mockito.<KotlinEffectExpressionMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinEffectExpressionMetadata kotlinEffectExprMetadata = new KotlinEffectExpressionMetadata();

    // Act
    kotlinTypeFilter.visitTypeOfIsExpression(
        clazz, kotlinEffectExprMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitTypeOfIsExpression(
            isA(Clazz.class),
            isA(KotlinEffectExpressionMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitTypeArgument(Clazz, KotlinTypeMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitTypeArgument(Clazz, KotlinTypeMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitTypeArgument(Clazz, KotlinTypeMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitTypeArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitTypeArgument_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata kotlinTypeMetadata = KotlinTypeMetadata.starProjection();

    // Act
    kotlinTypeFilter.visitTypeArgument(
        clazz, kotlinTypeMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitTypeArgument(Clazz, KotlinTypeMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link KotlinTypeVisitor#visitTypeArgument(Clazz, KotlinTypeMetadata,
   *       KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitTypeArgument(Clazz, KotlinTypeMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitTypeArgument(Clazz, KotlinTypeMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'true'; then calls visitTypeArgument(Clazz, KotlinTypeMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitTypeArgument(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitTypeArgument_givenPredicateTestReturnTrue_thenCallsVisitTypeArgument() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitTypeArgument(
            Mockito.<Clazz>any(),
            Mockito.<KotlinTypeMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata kotlinTypeMetadata = KotlinTypeMetadata.starProjection();

    // Act
    kotlinTypeFilter.visitTypeArgument(
        clazz, kotlinTypeMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitTypeArgument(
            isA(Clazz.class), isA(KotlinTypeMetadata.class), isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitStarProjection(Clazz, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitStarProjection(Clazz, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitStarProjection(Clazz, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitStarProjection(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitStarProjection_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinTypeFilter.visitStarProjection(clazz, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitStarProjection(Clazz, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitStarProjection(Clazz, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitStarProjection(Clazz, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitStarProjection(Clazz, KotlinTypeMetadata); then calls visitStarProjection(Clazz, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitStarProjection(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitStarProjection_thenCallsVisitStarProjection() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitStarProjection(Mockito.<Clazz>any(), Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinTypeFilter.visitStarProjection(clazz, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor).visitStarProjection(isA(Clazz.class), isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitOuterClass(Clazz, KotlinTypeMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitOuterClass(Clazz, KotlinTypeMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitOuterClass(Clazz, KotlinTypeMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitOuterClass(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitOuterClass_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata innerClass = KotlinTypeMetadata.starProjection();

    // Act
    kotlinTypeFilter.visitOuterClass(clazz, innerClass, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitOuterClass(Clazz, KotlinTypeMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link KotlinTypeVisitor#visitOuterClass(Clazz, KotlinTypeMetadata,
   *       KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitOuterClass(Clazz, KotlinTypeMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitOuterClass(Clazz, KotlinTypeMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'true'; then calls visitOuterClass(Clazz, KotlinTypeMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitOuterClass(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitOuterClass_givenPredicateTestReturnTrue_thenCallsVisitOuterClass() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitOuterClass(
            Mockito.<Clazz>any(),
            Mockito.<KotlinTypeMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata innerClass = KotlinTypeMetadata.starProjection();

    // Act
    kotlinTypeFilter.visitOuterClass(clazz, innerClass, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitOuterClass(
            isA(Clazz.class), isA(KotlinTypeMetadata.class), isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitSuperType(Clazz, KotlinClassKindMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitSuperType(Clazz, KotlinClassKindMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitSuperType(Clazz, KotlinClassKindMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitSuperType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitSuperType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act
    kotlinTypeFilter.visitSuperType(clazz, kotlinMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitSuperType(Clazz, KotlinClassKindMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link KotlinTypeVisitor#visitSuperType(Clazz, KotlinClassKindMetadata,
   *       KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitSuperType(Clazz, KotlinClassKindMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitSuperType(Clazz, KotlinClassKindMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'true'; then calls visitSuperType(Clazz, KotlinClassKindMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitSuperType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitSuperType_givenPredicateTestReturnTrue_thenCallsVisitSuperType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitSuperType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinClassKindMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act
    kotlinTypeFilter.visitSuperType(clazz, kotlinMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitSuperType(
            isA(Clazz.class), isA(KotlinClassKindMetadata.class), isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitConstructorValParamType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitConstructorValParamType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitConstructorValParamType(Clazz, KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitConstructorValParamType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitConstructorValParamType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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
    KotlinConstructorMetadata kotlinConstructorMetadata =
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility));
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitConstructorValParamType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinConstructorMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitConstructorValParamType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitConstructorValParamType(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinConstructorMetadata,
   *       KotlinValueParameterMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitConstructorValParamType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitConstructorValParamType(Clazz, KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata); then calls visitConstructorValParamType(Clazz, KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitConstructorValParamType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitConstructorValParamType_thenCallsVisitConstructorValParamType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitConstructorValParamType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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
    KotlinConstructorMetadata kotlinConstructorMetadata =
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility));
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitConstructorValParamType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinConstructorMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitConstructorValParamType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinConstructorMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitConstructorValParamVarArgType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}.
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitConstructorValParamVarArgType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitConstructorValParamVarArgType(Clazz, KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitConstructorValParamVarArgType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitConstructorValParamVarArgType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitConstructorValParamVarArgType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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
    KotlinConstructorMetadata kotlinConstructorMetadata =
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility));
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitConstructorValParamVarArgType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinConstructorMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitConstructorValParamVarArgType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinConstructorMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitConstructorValParamVarArgType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitConstructorValParamVarArgType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitConstructorValParamVarArgType(Clazz, KotlinDeclarationContainerMetadata, KotlinConstructorMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitConstructorValParamVarArgType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitConstructorValParamVarArgType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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
    KotlinConstructorMetadata kotlinConstructorMetadata =
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility));
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitConstructorValParamVarArgType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinConstructorMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitPropertyType(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinPropertyMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitPropertyType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitPropertyType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitPropertyType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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

    // Act
    kotlinTypeFilter.visitPropertyType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitPropertyType(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinPropertyMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link KotlinTypeVisitor#visitPropertyType(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitPropertyType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'true'; then calls visitPropertyType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitPropertyType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitPropertyType_givenPredicateTestReturnTrue_thenCallsVisitPropertyType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitPropertyType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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

    // Act
    kotlinTypeFilter.visitPropertyType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitPropertyType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitPropertyReceiverType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitPropertyReceiverType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyReceiverType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitPropertyReceiverType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitPropertyReceiverType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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

    // Act
    kotlinTypeFilter.visitPropertyReceiverType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitPropertyReceiverType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitPropertyReceiverType(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitPropertyReceiverType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyReceiverType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata); then calls visitPropertyReceiverType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitPropertyReceiverType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitPropertyReceiverType_thenCallsVisitPropertyReceiverType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitPropertyReceiverType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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

    // Act
    kotlinTypeFilter.visitPropertyReceiverType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitPropertyReceiverType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitPropertyValParamType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitPropertyValParamType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyValParamType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitPropertyValParamType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitPropertyValParamType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags2, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitPropertyValParamType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitPropertyValParamType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitPropertyValParamType(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata,
   *       KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitPropertyValParamType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyValParamType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata); then calls visitPropertyValParamType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitPropertyValParamType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitPropertyValParamType_thenCallsVisitPropertyValParamType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitPropertyValParamType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags2, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitPropertyValParamType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitPropertyValParamType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitPropertyValParamVarArgType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitPropertyValParamVarArgType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyValParamVarArgType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitPropertyValParamVarArgType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitPropertyValParamVarArgType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags2, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitPropertyValParamVarArgType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitPropertyValParamVarArgType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitPropertyValParamVarArgType(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata,
   *       KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitPropertyValParamVarArgType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata,
   * KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyValParamVarArgType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata); then calls visitPropertyValParamVarArgType(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitPropertyValParamVarArgType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitPropertyValParamVarArgType_thenCallsVisitPropertyValParamVarArgType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitPropertyValParamVarArgType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags2, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitPropertyValParamVarArgType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinPropertyMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitPropertyValParamVarArgType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitFunctionReturnType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitFunctionReturnType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionReturnType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitFunctionReturnType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitFunctionReturnType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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

    // Act
    kotlinTypeFilter.visitFunctionReturnType(
        clazz, kotlinMetadata, kotlinFunctionMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitFunctionReturnType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitFunctionReturnType(Clazz, KotlinMetadata,
   *       KotlinFunctionMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitFunctionReturnType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionReturnType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata); then calls visitFunctionReturnType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitFunctionReturnType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitFunctionReturnType_thenCallsVisitFunctionReturnType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitFunctionReturnType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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

    // Act
    kotlinTypeFilter.visitFunctionReturnType(
        clazz, kotlinMetadata, kotlinFunctionMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitFunctionReturnType(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitFunctionReceiverType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitFunctionReceiverType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionReceiverType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitFunctionReceiverType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitFunctionReceiverType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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

    // Act
    kotlinTypeFilter.visitFunctionReceiverType(
        clazz, kotlinMetadata, kotlinFunctionMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitFunctionReceiverType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitFunctionReceiverType(Clazz, KotlinMetadata,
   *       KotlinFunctionMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitFunctionReceiverType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionReceiverType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata); then calls visitFunctionReceiverType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitFunctionReceiverType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitFunctionReceiverType_thenCallsVisitFunctionReceiverType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitFunctionReceiverType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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

    // Act
    kotlinTypeFilter.visitFunctionReceiverType(
        clazz, kotlinMetadata, kotlinFunctionMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitFunctionReceiverType(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitFunctionContextReceiverType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitFunctionContextReceiverType(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionContextReceiverType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitFunctionContextReceiverType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitFunctionContextReceiverType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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

    // Act
    kotlinTypeFilter.visitFunctionContextReceiverType(
        clazz, kotlinMetadata, kotlinFunctionMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitFunctionContextReceiverType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitFunctionContextReceiverType(Clazz,
   *       KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitFunctionContextReceiverType(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionContextReceiverType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata); then calls visitFunctionContextReceiverType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitFunctionContextReceiverType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitFunctionContextReceiverType_thenCallsVisitFunctionContextReceiverType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitFunctionContextReceiverType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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

    // Act
    kotlinTypeFilter.visitFunctionContextReceiverType(
        clazz, kotlinMetadata, kotlinFunctionMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitFunctionContextReceiverType(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitClassContextReceiverType(Clazz, KotlinMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitClassContextReceiverType(Clazz,
   * KotlinMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitClassContextReceiverType(Clazz, KotlinMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitClassContextReceiverType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitClassContextReceiverType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act
    kotlinTypeFilter.visitClassContextReceiverType(
        clazz, kotlinMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitClassContextReceiverType(Clazz, KotlinMetadata,
   * KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitClassContextReceiverType(Clazz, KotlinMetadata,
   *       KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitClassContextReceiverType(Clazz,
   * KotlinMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitClassContextReceiverType(Clazz, KotlinMetadata, KotlinTypeMetadata); then calls visitClassContextReceiverType(Clazz, KotlinMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitClassContextReceiverType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitClassContextReceiverType_thenCallsVisitClassContextReceiverType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitClassContextReceiverType(
            Mockito.<Clazz>any(), Mockito.<KotlinMetadata>any(), Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act
    kotlinTypeFilter.visitClassContextReceiverType(
        clazz, kotlinMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitClassContextReceiverType(
            isA(Clazz.class), isA(KotlinMetadata.class), isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitPropertyContextReceiverType(Clazz, KotlinMetadata,
   * KotlinPropertyMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitPropertyContextReceiverType(Clazz,
   * KotlinMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyContextReceiverType(Clazz, KotlinMetadata, KotlinPropertyMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitPropertyContextReceiverType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitPropertyContextReceiverType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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

    // Act
    kotlinTypeFilter.visitPropertyContextReceiverType(
        clazz, kotlinMetadata, kotlinPropertyMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitPropertyContextReceiverType(Clazz, KotlinMetadata,
   * KotlinPropertyMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitPropertyContextReceiverType(Clazz,
   *       KotlinMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitPropertyContextReceiverType(Clazz,
   * KotlinMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyContextReceiverType(Clazz, KotlinMetadata, KotlinPropertyMetadata, KotlinTypeMetadata); then calls visitPropertyContextReceiverType(Clazz, KotlinMetadata, KotlinPropertyMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitPropertyContextReceiverType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitPropertyContextReceiverType_thenCallsVisitPropertyContextReceiverType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitPropertyContextReceiverType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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

    // Act
    kotlinTypeFilter.visitPropertyContextReceiverType(
        clazz, kotlinMetadata, kotlinPropertyMetadata, KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitPropertyContextReceiverType(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinPropertyMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitFunctionValParamType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitFunctionValParamType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionValParamType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitFunctionValParamType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitFunctionValParamType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitFunctionValParamType(
        clazz,
        kotlinMetadata,
        kotlinFunctionMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitFunctionValParamType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitFunctionValParamType(Clazz, KotlinMetadata,
   *       KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitFunctionValParamType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionValParamType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata); then calls visitFunctionValParamType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitFunctionValParamType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitFunctionValParamType_thenCallsVisitFunctionValParamType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitFunctionValParamType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitFunctionValParamType(
        clazz,
        kotlinMetadata,
        kotlinFunctionMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitFunctionValParamType(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitFunctionValParamVarArgType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitFunctionValParamVarArgType(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionValParamVarArgType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitFunctionValParamVarArgType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitFunctionValParamVarArgType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitFunctionValParamVarArgType(
        clazz,
        kotlinMetadata,
        kotlinFunctionMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitFunctionValParamVarArgType(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitFunctionValParamVarArgType(Clazz,
   *       KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata,
   *       KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitFunctionValParamVarArgType(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionValParamVarArgType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata); then calls visitFunctionValParamVarArgType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinValueParameterMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitFunctionValParamVarArgType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinValueParameterMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitFunctionValParamVarArgType_thenCallsVisitFunctionValParamVarArgType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitFunctionValParamVarArgType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinValueParameterMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");

    // Act
    kotlinTypeFilter.visitFunctionValParamVarArgType(
        clazz,
        kotlinMetadata,
        kotlinFunctionMetadata,
        kotlinValueParameterMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitFunctionValParamVarArgType(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinValueParameterMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitAliasUnderlyingType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitAliasUnderlyingType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAliasUnderlyingType(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitAliasUnderlyingType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitAliasUnderlyingType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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

    // Act
    kotlinTypeFilter.visitAliasUnderlyingType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinTypeAliasMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitAliasUnderlyingType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitAliasUnderlyingType(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitAliasUnderlyingType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAliasUnderlyingType(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata); then calls visitAliasUnderlyingType(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitAliasUnderlyingType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitAliasUnderlyingType_thenCallsVisitAliasUnderlyingType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitAliasUnderlyingType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeAliasMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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

    // Act
    kotlinTypeFilter.visitAliasUnderlyingType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinTypeAliasMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitAliasUnderlyingType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeAliasMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitAliasExpandedType(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinTypeAliasMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitAliasExpandedType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAliasExpandedType(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitAliasExpandedType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitAliasExpandedType_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(false);
    KotlinTypeFilter kotlinTypeFilter =
        new KotlinTypeFilter(predicate, mock(KotlinTypeVisitor.class));
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

    // Act
    kotlinTypeFilter.visitAliasExpandedType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinTypeAliasMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinTypeFilter#visitAliasExpandedType(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinTypeAliasMetadata, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitAliasExpandedType(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeFilter#visitAliasExpandedType(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAliasExpandedType(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata); then calls visitAliasExpandedType(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeFilter.visitAliasExpandedType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitAliasExpandedType_thenCallsVisitAliasExpandedType() {
    // Arrange
    Predicate<KotlinTypeMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeMetadata>any())).thenReturn(true);
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitAliasExpandedType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeAliasMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());
    KotlinTypeFilter kotlinTypeFilter = new KotlinTypeFilter(predicate, kotlinTypeVisitor);
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

    // Act
    kotlinTypeFilter.visitAliasExpandedType(
        clazz,
        kotlinDeclarationContainerMetadata,
        kotlinTypeAliasMetadata,
        KotlinTypeMetadata.starProjection());

    // Assert
    verify(predicate).test(isA(KotlinTypeMetadata.class));
    verify(kotlinTypeVisitor)
        .visitAliasExpandedType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeAliasMetadata.class),
            isA(KotlinTypeMetadata.class));
  }
}
