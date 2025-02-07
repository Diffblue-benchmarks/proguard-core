package proguard.classfile.kotlin.visitor.filter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.Flavor;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class KotlinSyntheticClassKindFilterDiffblueTest {
  /**
   * Test {@link KotlinSyntheticClassKindFilter#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinSyntheticClassKindFilter.visitKotlinSyntheticClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testVisitKotlinSyntheticClassMetadata_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinSyntheticClassKindMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinSyntheticClassKindMetadata>any())).thenReturn(false);
    KotlinSyntheticClassKindFilter kotlinSyntheticClassKindFilter =
        new KotlinSyntheticClassKindFilter(predicate, mock(KotlinMetadataVisitor.class));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinSyntheticClassKindFilter.visitKotlinSyntheticClassMetadata(
        clazz,
        new KotlinSyntheticClassKindMetadata(
            new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR));

    // Assert
    verify(predicate).test(isA(KotlinSyntheticClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata); given Predicate test(Object) return 'true'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinSyntheticClassKindFilter.visitKotlinSyntheticClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testVisitKotlinSyntheticClassMetadata_givenPredicateTestReturnTrue_thenCallsTest() {
    // Arrange
    Predicate<KotlinSyntheticClassKindMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinSyntheticClassKindMetadata>any())).thenReturn(true);
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinSyntheticClassMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinSyntheticClassKindMetadata>any());
    KotlinSyntheticClassKindFilter kotlinSyntheticClassKindFilter =
        new KotlinSyntheticClassKindFilter(predicate, kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinSyntheticClassKindFilter.visitKotlinSyntheticClassMetadata(
        clazz,
        new KotlinSyntheticClassKindMetadata(
            new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR));

    // Assert
    verify(predicate).test(isA(KotlinSyntheticClassKindMetadata.class));
    verify(kotlinMetadataVisitor)
        .visitKotlinSyntheticClassMetadata(
            isA(Clazz.class), isA(KotlinSyntheticClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   *       KotlinSyntheticClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata); then calls visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinSyntheticClassKindFilter.visitKotlinSyntheticClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testVisitKotlinSyntheticClassMetadata_thenCallsVisitKotlinSyntheticClassMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinSyntheticClassMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinSyntheticClassKindMetadata>any());
    KotlinSyntheticClassKindFilter kotlinSyntheticClassKindFilter =
        new KotlinSyntheticClassKindFilter(kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinSyntheticClassKindFilter.visitKotlinSyntheticClassMetadata(
        clazz,
        new KotlinSyntheticClassKindMetadata(
            new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinSyntheticClassMetadata(
            isA(Clazz.class), isA(KotlinSyntheticClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#isLambda(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isLambda(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName("Test isLambda(KotlinSyntheticClassKindMetadata); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.visitor.filter.KotlinSyntheticClassKindFilter.isLambda(proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testIsLambda_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        KotlinSyntheticClassKindFilter.isLambda(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR)));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#isLambda(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isLambda(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName("Test isLambda(KotlinSyntheticClassKindMetadata); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.visitor.filter.KotlinSyntheticClassKindFilter.isLambda(proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testIsLambda_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        KotlinSyntheticClassKindFilter.isLambda(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.LAMBDA)));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#isWhenMappings(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isWhenMappings(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName("Test isWhenMappings(KotlinSyntheticClassKindMetadata); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.visitor.filter.KotlinSyntheticClassKindFilter.isWhenMappings(proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testIsWhenMappings_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        KotlinSyntheticClassKindFilter.isWhenMappings(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR)));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#isWhenMappings(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isWhenMappings(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName("Test isWhenMappings(KotlinSyntheticClassKindMetadata); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.visitor.filter.KotlinSyntheticClassKindFilter.isWhenMappings(proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testIsWhenMappings_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        KotlinSyntheticClassKindFilter.isWhenMappings(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.WHEN_MAPPINGS)));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#isDefaultImpls(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isDefaultImpls(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName("Test isDefaultImpls(KotlinSyntheticClassKindMetadata); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.visitor.filter.KotlinSyntheticClassKindFilter.isDefaultImpls(proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testIsDefaultImpls_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        KotlinSyntheticClassKindFilter.isDefaultImpls(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR)));
  }

  /**
   * Test {@link KotlinSyntheticClassKindFilter#isDefaultImpls(KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindFilter#isDefaultImpls(KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName("Test isDefaultImpls(KotlinSyntheticClassKindMetadata); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.kotlin.visitor.filter.KotlinSyntheticClassKindFilter.isDefaultImpls(proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testIsDefaultImpls_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        KotlinSyntheticClassKindFilter.isDefaultImpls(
            new KotlinSyntheticClassKindMetadata(
                new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.DEFAULT_IMPLS)));
  }
}
