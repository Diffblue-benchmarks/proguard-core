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
import proguard.classfile.kotlin.flags.KotlinConstructorFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinConstructorVisitor;

class KotlinConstructorFilterDiffblueTest {
  /**
   * Test {@link KotlinConstructorFilter#visitConstructor(Clazz, KotlinClassKindMetadata,
   * KotlinConstructorMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstructorFilter#visitConstructor(Clazz,
   * KotlinClassKindMetadata, KotlinConstructorMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitConstructor(Clazz, KotlinClassKindMetadata, KotlinConstructorMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinConstructorFilter.visitConstructor(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata)"
  })
  void testVisitConstructor_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinConstructorMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinConstructorMetadata>any())).thenReturn(false);
    KotlinConstructorFilter kotlinConstructorFilter =
        new KotlinConstructorFilter(predicate, mock(KotlinConstructorVisitor.class));
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

    // Act
    kotlinConstructorFilter.visitConstructor(
        clazz,
        kotlinClassKindMetadata,
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility)));

    // Assert
    verify(predicate).test(isA(KotlinConstructorMetadata.class));
  }

  /**
   * Test {@link KotlinConstructorFilter#visitConstructor(Clazz, KotlinClassKindMetadata,
   * KotlinConstructorMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link KotlinConstructorVisitor#visitConstructor(Clazz,
   *       KotlinClassKindMetadata, KotlinConstructorMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstructorFilter#visitConstructor(Clazz,
   * KotlinClassKindMetadata, KotlinConstructorMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitConstructor(Clazz, KotlinClassKindMetadata, KotlinConstructorMetadata); given Predicate test(Object) return 'true'; then calls visitConstructor(Clazz, KotlinClassKindMetadata, KotlinConstructorMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinConstructorFilter.visitConstructor(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.KotlinConstructorMetadata)"
  })
  void testVisitConstructor_givenPredicateTestReturnTrue_thenCallsVisitConstructor() {
    // Arrange
    Predicate<KotlinConstructorMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinConstructorMetadata>any())).thenReturn(true);
    KotlinConstructorVisitor kotlinConstructorVisitor = mock(KotlinConstructorVisitor.class);
    doNothing()
        .when(kotlinConstructorVisitor)
        .visitConstructor(
            Mockito.<Clazz>any(),
            Mockito.<KotlinClassKindMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any());
    KotlinConstructorFilter kotlinConstructorFilter =
        new KotlinConstructorFilter(predicate, kotlinConstructorVisitor);
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

    // Act
    kotlinConstructorFilter.visitConstructor(
        clazz,
        kotlinClassKindMetadata,
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility)));

    // Assert
    verify(predicate).test(isA(KotlinConstructorMetadata.class));
    verify(kotlinConstructorVisitor)
        .visitConstructor(
            isA(Clazz.class),
            isA(KotlinClassKindMetadata.class),
            isA(KotlinConstructorMetadata.class));
  }
}
