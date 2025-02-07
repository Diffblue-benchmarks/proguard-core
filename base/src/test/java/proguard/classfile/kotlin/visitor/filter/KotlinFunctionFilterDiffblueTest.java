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
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.Flavor;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinFunctionVisitor;

class KotlinFunctionFilterDiffblueTest {
  /**
   * Test {@link KotlinFunctionFilter#visitFunction(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinFunctionMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinFunctionFilter#visitFunction(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinFunctionMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunction(Clazz, KotlinDeclarationContainerMetadata, KotlinFunctionMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinFunctionFilter.visitFunction(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata)"
  })
  void testVisitFunction_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinFunctionMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinFunctionMetadata>any())).thenReturn(false);
    KotlinFunctionFilter kotlinFunctionFilter =
        new KotlinFunctionFilter(predicate, mock(KotlinFunctionVisitor.class));
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

    // Act
    kotlinFunctionFilter.visitFunction(
        clazz,
        kotlinDeclarationContainerMetadata,
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name"));

    // Assert
    verify(predicate).test(isA(KotlinFunctionMetadata.class));
  }

  /**
   * Test {@link KotlinFunctionFilter#visitFunction(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinFunctionMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link KotlinFunctionVisitor#visitFunction(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinFunctionMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinFunctionFilter#visitFunction(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinFunctionMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitFunction(Clazz, KotlinDeclarationContainerMetadata, KotlinFunctionMetadata); given Predicate test(Object) return 'true'; then calls visitFunction(Clazz, KotlinDeclarationContainerMetadata, KotlinFunctionMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinFunctionFilter.visitFunction(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata)"
  })
  void testVisitFunction_givenPredicateTestReturnTrue_thenCallsVisitFunction() {
    // Arrange
    Predicate<KotlinFunctionMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinFunctionMetadata>any())).thenReturn(true);
    KotlinFunctionVisitor kotlinFunctionVisitor = mock(KotlinFunctionVisitor.class);
    doNothing()
        .when(kotlinFunctionVisitor)
        .visitFunction(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any());
    KotlinFunctionFilter kotlinFunctionFilter =
        new KotlinFunctionFilter(predicate, kotlinFunctionVisitor);
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

    // Act
    kotlinFunctionFilter.visitFunction(
        clazz,
        kotlinDeclarationContainerMetadata,
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name"));

    // Assert
    verify(predicate).test(isA(KotlinFunctionMetadata.class));
    verify(kotlinFunctionVisitor)
        .visitFunction(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinFunctionMetadata.class));
  }

  /**
   * Test {@link KotlinFunctionFilter#visitSyntheticFunction(Clazz,
   * KotlinSyntheticClassKindMetadata, KotlinFunctionMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinFunctionFilter#visitSyntheticFunction(Clazz,
   * KotlinSyntheticClassKindMetadata, KotlinFunctionMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticFunction(Clazz, KotlinSyntheticClassKindMetadata, KotlinFunctionMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinFunctionFilter.visitSyntheticFunction(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata)"
  })
  void testVisitSyntheticFunction_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinFunctionMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinFunctionMetadata>any())).thenReturn(false);
    KotlinFunctionFilter kotlinFunctionFilter =
        new KotlinFunctionFilter(predicate, mock(KotlinFunctionVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinSyntheticClassKindMetadata kotlinSyntheticClassKindMetadata =
        new KotlinSyntheticClassKindMetadata(new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR);

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

    // Act
    kotlinFunctionFilter.visitSyntheticFunction(
        clazz,
        kotlinSyntheticClassKindMetadata,
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name"));

    // Assert
    verify(predicate).test(isA(KotlinFunctionMetadata.class));
  }

  /**
   * Test {@link KotlinFunctionFilter#visitSyntheticFunction(Clazz,
   * KotlinSyntheticClassKindMetadata, KotlinFunctionMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinFunctionVisitor#visitSyntheticFunction(Clazz,
   *       KotlinSyntheticClassKindMetadata, KotlinFunctionMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinFunctionFilter#visitSyntheticFunction(Clazz,
   * KotlinSyntheticClassKindMetadata, KotlinFunctionMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitSyntheticFunction(Clazz, KotlinSyntheticClassKindMetadata, KotlinFunctionMetadata); then calls visitSyntheticFunction(Clazz, KotlinSyntheticClassKindMetadata, KotlinFunctionMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinFunctionFilter.visitSyntheticFunction(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata)"
  })
  void testVisitSyntheticFunction_thenCallsVisitSyntheticFunction() {
    // Arrange
    Predicate<KotlinFunctionMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinFunctionMetadata>any())).thenReturn(true);
    KotlinFunctionVisitor kotlinFunctionVisitor = mock(KotlinFunctionVisitor.class);
    doNothing()
        .when(kotlinFunctionVisitor)
        .visitSyntheticFunction(
            Mockito.<Clazz>any(),
            Mockito.<KotlinSyntheticClassKindMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any());
    KotlinFunctionFilter kotlinFunctionFilter =
        new KotlinFunctionFilter(predicate, kotlinFunctionVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinSyntheticClassKindMetadata kotlinSyntheticClassKindMetadata =
        new KotlinSyntheticClassKindMetadata(new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR);

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

    // Act
    kotlinFunctionFilter.visitSyntheticFunction(
        clazz,
        kotlinSyntheticClassKindMetadata,
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name"));

    // Assert
    verify(predicate).test(isA(KotlinFunctionMetadata.class));
    verify(kotlinFunctionVisitor)
        .visitSyntheticFunction(
            isA(Clazz.class),
            isA(KotlinSyntheticClassKindMetadata.class),
            isA(KotlinFunctionMetadata.class));
  }
}
