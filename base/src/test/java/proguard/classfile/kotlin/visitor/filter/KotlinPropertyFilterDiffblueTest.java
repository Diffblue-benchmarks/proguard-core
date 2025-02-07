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
import proguard.classfile.kotlin.KotlinPropertyMetadata;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinPropertyVisitor;

class KotlinPropertyFilterDiffblueTest {
  /**
   * Test {@link KotlinPropertyFilter#visitAnyProperty(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinPropertyMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinPropertyFilter#visitAnyProperty(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyProperty(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinPropertyFilter.visitAnyProperty(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata)"
  })
  void testVisitAnyProperty_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinPropertyMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinPropertyMetadata>any())).thenReturn(false);
    KotlinPropertyFilter kotlinPropertyFilter =
        new KotlinPropertyFilter(predicate, mock(KotlinPropertyVisitor.class));
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

    // Act
    kotlinPropertyFilter.visitAnyProperty(
        clazz,
        kotlinDeclarationContainerMetadata,
        new KotlinPropertyMetadata(
            flags, "Name", getterFlags, new KotlinPropertyAccessorFlags(visibility3, modality3)));

    // Assert
    verify(predicate).test(isA(KotlinPropertyMetadata.class));
  }

  /**
   * Test {@link KotlinPropertyFilter#visitAnyProperty(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinPropertyMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   *   <li>Then calls {@link KotlinPropertyVisitor#visitAnyProperty(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinPropertyMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinPropertyFilter#visitAnyProperty(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinPropertyMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyProperty(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata); given Predicate test(Object) return 'true'; then calls visitAnyProperty(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinPropertyFilter.visitAnyProperty(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata)"
  })
  void testVisitAnyProperty_givenPredicateTestReturnTrue_thenCallsVisitAnyProperty() {
    // Arrange
    Predicate<KotlinPropertyMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinPropertyMetadata>any())).thenReturn(true);
    KotlinPropertyVisitor acceptedPropertyVisitor = mock(KotlinPropertyVisitor.class);
    doNothing()
        .when(acceptedPropertyVisitor)
        .visitAnyProperty(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinPropertyMetadata>any());
    KotlinPropertyFilter kotlinPropertyFilter =
        new KotlinPropertyFilter(predicate, acceptedPropertyVisitor);
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

    // Act
    kotlinPropertyFilter.visitAnyProperty(
        clazz,
        kotlinDeclarationContainerMetadata,
        new KotlinPropertyMetadata(
            flags, "Name", getterFlags, new KotlinPropertyAccessorFlags(visibility3, modality3)));

    // Assert
    verify(predicate).test(isA(KotlinPropertyMetadata.class));
    verify(acceptedPropertyVisitor)
        .visitAnyProperty(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinPropertyMetadata.class));
  }
}
