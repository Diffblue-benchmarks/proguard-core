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
import proguard.classfile.kotlin.KotlinMultiFilePartKindMetadata;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class KotlinMultiFilePartKindFilterDiffblueTest {
  /**
   * Test {@link KotlinMultiFilePartKindFilter#visitKotlinMultiFilePartMetadata(Clazz,
   * KotlinMultiFilePartKindMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMultiFilePartKindFilter#visitKotlinMultiFilePartMetadata(Clazz,
   * KotlinMultiFilePartKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinMultiFilePartMetadata(Clazz, KotlinMultiFilePartKindMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinMultiFilePartKindFilter.visitKotlinMultiFilePartMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMultiFilePartKindMetadata)"
  })
  void testVisitKotlinMultiFilePartMetadata_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinMultiFilePartKindMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinMultiFilePartKindMetadata>any())).thenReturn(false);
    KotlinMultiFilePartKindFilter kotlinMultiFilePartKindFilter =
        new KotlinMultiFilePartKindFilter(predicate, mock(KotlinMetadataVisitor.class));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMultiFilePartKindFilter.visitKotlinMultiFilePartMetadata(
        clazz, new KotlinMultiFilePartKindMetadata(new int[] {1, 5, 1, 5}, 1, "Xs", "Pn"));

    // Assert
    verify(predicate).test(isA(KotlinMultiFilePartKindMetadata.class));
  }

  /**
   * Test {@link KotlinMultiFilePartKindFilter#visitKotlinMultiFilePartMetadata(Clazz,
   * KotlinMultiFilePartKindMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMultiFilePartKindFilter#visitKotlinMultiFilePartMetadata(Clazz,
   * KotlinMultiFilePartKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinMultiFilePartMetadata(Clazz, KotlinMultiFilePartKindMetadata); given Predicate test(Object) return 'true'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinMultiFilePartKindFilter.visitKotlinMultiFilePartMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMultiFilePartKindMetadata)"
  })
  void testVisitKotlinMultiFilePartMetadata_givenPredicateTestReturnTrue_thenCallsTest() {
    // Arrange
    Predicate<KotlinMultiFilePartKindMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinMultiFilePartKindMetadata>any())).thenReturn(true);
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinMultiFilePartMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinMultiFilePartKindMetadata>any());
    KotlinMultiFilePartKindFilter kotlinMultiFilePartKindFilter =
        new KotlinMultiFilePartKindFilter(predicate, kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMultiFilePartKindFilter.visitKotlinMultiFilePartMetadata(
        clazz, new KotlinMultiFilePartKindMetadata(new int[] {1, 5, 1, 5}, 1, "Xs", "Pn"));

    // Assert
    verify(predicate).test(isA(KotlinMultiFilePartKindMetadata.class));
    verify(kotlinMetadataVisitor)
        .visitKotlinMultiFilePartMetadata(
            isA(Clazz.class), isA(KotlinMultiFilePartKindMetadata.class));
  }

  /**
   * Test {@link KotlinMultiFilePartKindFilter#visitKotlinMultiFilePartMetadata(Clazz,
   * KotlinMultiFilePartKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinMultiFilePartMetadata(Clazz,
   *       KotlinMultiFilePartKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMultiFilePartKindFilter#visitKotlinMultiFilePartMetadata(Clazz,
   * KotlinMultiFilePartKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinMultiFilePartMetadata(Clazz, KotlinMultiFilePartKindMetadata); then calls visitKotlinMultiFilePartMetadata(Clazz, KotlinMultiFilePartKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinMultiFilePartKindFilter.visitKotlinMultiFilePartMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMultiFilePartKindMetadata)"
  })
  void testVisitKotlinMultiFilePartMetadata_thenCallsVisitKotlinMultiFilePartMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinMultiFilePartMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinMultiFilePartKindMetadata>any());
    KotlinMultiFilePartKindFilter kotlinMultiFilePartKindFilter =
        new KotlinMultiFilePartKindFilter(kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMultiFilePartKindFilter.visitKotlinMultiFilePartMetadata(
        clazz, new KotlinMultiFilePartKindMetadata(new int[] {1, 5, 1, 5}, 1, "Xs", "Pn"));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinMultiFilePartMetadata(
            isA(Clazz.class), isA(KotlinMultiFilePartKindMetadata.class));
  }
}
