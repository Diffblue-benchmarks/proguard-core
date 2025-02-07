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
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class KotlinMetadataFilterDiffblueTest {
  /**
   * Test {@link KotlinMetadataFilter#KotlinMetadataFilter(KotlinMetadataVisitor,
   * KotlinMetadataVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataFilter#KotlinMetadataFilter(KotlinMetadataVisitor,
   * KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName(
      "Test new KotlinMetadataFilter(KotlinMetadataVisitor, KotlinMetadataVisitor); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinMetadataFilter.<init>(proguard.classfile.kotlin.visitor.KotlinMetadataVisitor, proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testNewKotlinMetadataFilter_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    KotlinMetadataVisitor acceptedVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());

    // Act
    KotlinMetadataFilter actualKotlinMetadataFilter =
        new KotlinMetadataFilter(acceptedVisitor, mock(KotlinMetadataVisitor.class));
    LibraryClass clazz = new LibraryClass();
    actualKotlinMetadataFilter.visitAnyKotlinMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(acceptedVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinMetadataFilter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataFilter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyKotlinMetadata(Clazz, KotlinMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinMetadataFilter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinMetadata>any())).thenReturn(false);
    KotlinMetadataFilter kotlinMetadataFilter =
        new KotlinMetadataFilter(predicate, mock(KotlinMetadataVisitor.class));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataFilter.visitAnyKotlinMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(predicate).test(isA(KotlinMetadata.class));
  }

  /**
   * Test {@link KotlinMetadataFilter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataFilter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyKotlinMetadata(Clazz, KotlinMetadata); given Predicate test(Object) return 'true'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinMetadataFilter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata_givenPredicateTestReturnTrue_thenCallsTest() {
    // Arrange
    Predicate<KotlinMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinMetadata>any())).thenReturn(true);
    KotlinMetadataVisitor acceptedVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());
    KotlinMetadataFilter kotlinMetadataFilter =
        new KotlinMetadataFilter(predicate, acceptedVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataFilter.visitAnyKotlinMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(predicate).test(isA(KotlinMetadata.class));
    verify(acceptedVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinMetadataFilter#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataFilter#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyKotlinMetadata(Clazz, KotlinMetadata); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinMetadataFilter.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    KotlinMetadataVisitor acceptedVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());
    KotlinMetadataFilter kotlinMetadataFilter =
        new KotlinMetadataFilter(acceptedVisitor, mock(KotlinMetadataVisitor.class));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataFilter.visitAnyKotlinMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(acceptedVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }
}
