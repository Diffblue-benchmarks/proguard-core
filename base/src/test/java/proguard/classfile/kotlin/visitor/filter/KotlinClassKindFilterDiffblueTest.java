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
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class KotlinClassKindFilterDiffblueTest {
  /**
   * Test {@link KotlinClassKindFilter#visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)}.
   *
   * <ul>
   *   <li>Given {@link KotlinClassKindFilter#KotlinClassKindFilter(KotlinMetadataVisitor)} with
   *       {@link KotlinMetadataVisitor}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindFilter#visitKotlinClassMetadata(Clazz,
   * KotlinClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata); given KotlinClassKindFilter(KotlinMetadataVisitor) with KotlinMetadataVisitor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinClassKindFilter.visitKotlinClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata)"
  })
  void testVisitKotlinClassMetadata_givenKotlinClassKindFilterWithKotlinMetadataVisitor() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());
    KotlinClassKindFilter kotlinClassKindFilter = new KotlinClassKindFilter(kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinClassKindFilter.visitKotlinClassMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinClassKindFilter#visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindFilter#visitKotlinClassMetadata(Clazz,
   * KotlinClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinClassKindFilter.visitKotlinClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata)"
  })
  void testVisitKotlinClassMetadata_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinClassKindMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinClassKindMetadata>any())).thenReturn(false);
    KotlinClassKindFilter kotlinClassKindFilter =
        new KotlinClassKindFilter(predicate, mock(KotlinMetadataVisitor.class));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinClassKindFilter.visitKotlinClassMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(predicate).test(isA(KotlinClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinClassKindFilter#visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindFilter#visitKotlinClassMetadata(Clazz,
   * KotlinClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata); given Predicate test(Object) return 'true'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinClassKindFilter.visitKotlinClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata)"
  })
  void testVisitKotlinClassMetadata_givenPredicateTestReturnTrue_thenCallsTest() {
    // Arrange
    Predicate<KotlinClassKindMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinClassKindMetadata>any())).thenReturn(true);
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());
    KotlinClassKindFilter kotlinClassKindFilter =
        new KotlinClassKindFilter(predicate, kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinClassKindFilter.visitKotlinClassMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(predicate).test(isA(KotlinClassKindMetadata.class));
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }
}
