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
import proguard.classfile.kotlin.KotlinTypeAliasMetadata;
import proguard.classfile.kotlin.flags.KotlinTypeAliasFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinTypeAliasVisitor;

class KotlinTypeAliasFilterDiffblueTest {
  /**
   * Test {@link KotlinTypeAliasFilter#visitTypeAlias(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinTypeAliasMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   *   <li>Then calls {@link Predicate#test(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeAliasFilter#visitTypeAlias(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAlias(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata); given Predicate test(Object) return 'false'; then calls test(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeAliasFilter.visitTypeAlias(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata)"
  })
  void testVisitTypeAlias_givenPredicateTestReturnFalse_thenCallsTest() {
    // Arrange
    Predicate<KotlinTypeAliasMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeAliasMetadata>any())).thenReturn(false);
    KotlinTypeAliasFilter kotlinTypeAliasFilter =
        new KotlinTypeAliasFilter(predicate, mock(KotlinTypeAliasVisitor.class));
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

    // Act
    kotlinTypeAliasFilter.visitTypeAlias(
        clazz,
        kotlinDeclarationContainerMetadata,
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name"));

    // Assert
    verify(predicate).test(isA(KotlinTypeAliasMetadata.class));
  }

  /**
   * Test {@link KotlinTypeAliasFilter#visitTypeAlias(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinTypeAliasMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link KotlinTypeAliasVisitor#visitTypeAlias(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeAliasFilter#visitTypeAlias(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAlias(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata); given Predicate test(Object) return 'true'; then calls visitTypeAlias(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinTypeAliasFilter.visitTypeAlias(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata)"
  })
  void testVisitTypeAlias_givenPredicateTestReturnTrue_thenCallsVisitTypeAlias() {
    // Arrange
    Predicate<KotlinTypeAliasMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinTypeAliasMetadata>any())).thenReturn(true);
    KotlinTypeAliasVisitor acceptedVisitor = mock(KotlinTypeAliasVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitTypeAlias(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeAliasMetadata>any());
    KotlinTypeAliasFilter kotlinTypeAliasFilter =
        new KotlinTypeAliasFilter(predicate, acceptedVisitor);
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

    // Act
    kotlinTypeAliasFilter.visitTypeAlias(
        clazz,
        kotlinDeclarationContainerMetadata,
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name"));

    // Assert
    verify(predicate).test(isA(KotlinTypeAliasMetadata.class));
    verify(acceptedVisitor)
        .visitTypeAlias(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeAliasMetadata.class));
  }
}
