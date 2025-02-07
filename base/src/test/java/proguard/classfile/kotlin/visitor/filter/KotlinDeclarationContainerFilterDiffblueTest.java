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
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class KotlinDeclarationContainerFilterDiffblueTest {
  /**
   * Test {@link KotlinDeclarationContainerFilter#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <p>Method under test: {@link
   * KotlinDeclarationContainerFilter#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinDeclarationContainerFilter.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata() {
    // Arrange
    KotlinMetadataVisitor acceptedVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitKotlinDeclarationContainerMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinDeclarationContainerMetadata>any());
    KotlinDeclarationContainerFilter kotlinDeclarationContainerFilter =
        new KotlinDeclarationContainerFilter(acceptedVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinDeclarationContainerFilter.visitKotlinDeclarationContainerMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(acceptedVisitor)
        .visitKotlinDeclarationContainerMetadata(
            isA(Clazz.class), isA(KotlinDeclarationContainerMetadata.class));
  }

  /**
   * Test {@link KotlinDeclarationContainerFilter#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinDeclarationContainerFilter#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata); given Predicate test(Object) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinDeclarationContainerFilter.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata_givenPredicateTestReturnFalse() {
    // Arrange
    Predicate<KotlinDeclarationContainerMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinDeclarationContainerMetadata>any())).thenReturn(false);
    KotlinDeclarationContainerFilter kotlinDeclarationContainerFilter =
        new KotlinDeclarationContainerFilter(predicate, mock(KotlinMetadataVisitor.class));
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinDeclarationContainerFilter.visitKotlinDeclarationContainerMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(predicate).test(isA(KotlinDeclarationContainerMetadata.class));
  }

  /**
   * Test {@link KotlinDeclarationContainerFilter#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinDeclarationContainerFilter#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata); given Predicate test(Object) return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.filter.KotlinDeclarationContainerFilter.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata_givenPredicateTestReturnTrue() {
    // Arrange
    Predicate<KotlinDeclarationContainerMetadata> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<KotlinDeclarationContainerMetadata>any())).thenReturn(true);
    KotlinMetadataVisitor acceptedVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(acceptedVisitor)
        .visitKotlinDeclarationContainerMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinDeclarationContainerMetadata>any());
    KotlinDeclarationContainerFilter kotlinDeclarationContainerFilter =
        new KotlinDeclarationContainerFilter(predicate, acceptedVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinDeclarationContainerFilter.visitKotlinDeclarationContainerMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(predicate).test(isA(KotlinDeclarationContainerMetadata.class));
    verify(acceptedVisitor)
        .visitKotlinDeclarationContainerMetadata(
            isA(Clazz.class), isA(KotlinDeclarationContainerMetadata.class));
  }
}
