package proguard.classfile.kotlin.reflect.util;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.Flavor;
import proguard.classfile.kotlin.reflect.util.KotlinCallableReferenceInitializer.OptimizedCallableReferenceFilter;
import proguard.classfile.visitor.ClassVisitor;

class KotlinCallableReferenceInitializerDiffblueTest {
  /**
   * Test OptimizedCallableReferenceFilter {@link
   * OptimizedCallableReferenceFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link OptimizedCallableReferenceFilter#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test OptimizedCallableReferenceFilter visitAnyClass(Clazz); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.util.KotlinCallableReferenceInitializer$OptimizedCallableReferenceFilter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testOptimizedCallableReferenceFilterVisitAnyClass_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor optimizedVisitor = mock(ClassVisitor.class);
    doNothing().when(optimizedVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    OptimizedCallableReferenceFilter optimizedCallableReferenceFilter =
        new OptimizedCallableReferenceFilter(optimizedVisitor, mock(ClassVisitor.class));

    // Act
    optimizedCallableReferenceFilter.visitAnyClass(new LibraryClass(1, "getName", "getName"));

    // Assert
    verify(optimizedVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link KotlinCallableReferenceInitializer#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}.
   *
   * <p>Method under test: {@link
   * KotlinCallableReferenceInitializer#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName("Test visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.util.KotlinCallableReferenceInitializer.visitKotlinSyntheticClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testVisitKotlinSyntheticClassMetadata() {
    // Arrange
    KotlinCallableReferenceInitializer kotlinCallableReferenceInitializer =
        new KotlinCallableReferenceInitializer(null, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.extendsOrImplements(Mockito.<String>any())).thenReturn(true);

    // Act
    kotlinCallableReferenceInitializer.visitKotlinSyntheticClassMetadata(
        clazz,
        new KotlinSyntheticClassKindMetadata(
            new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR));

    // Assert
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).extendsOrImplements(eq("kotlin/jvm/internal/CallableReference"));
  }

  /**
   * Test {@link KotlinCallableReferenceInitializer#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinCallableReferenceInitializer#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata); given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.util.KotlinCallableReferenceInitializer.visitKotlinSyntheticClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testVisitKotlinSyntheticClassMetadata_givenFalse() {
    // Arrange
    KotlinCallableReferenceInitializer kotlinCallableReferenceInitializer =
        new KotlinCallableReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.extendsOrImplements(Mockito.<String>any())).thenReturn(false);

    // Act
    kotlinCallableReferenceInitializer.visitKotlinSyntheticClassMetadata(
        clazz,
        new KotlinSyntheticClassKindMetadata(
            new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR));

    // Assert
    verify(clazz).extendsOrImplements(eq("kotlin/jvm/internal/CallableReference"));
  }

  /**
   * Test {@link KotlinCallableReferenceInitializer#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link LibraryClass#accept(ClassVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinCallableReferenceInitializer#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata); given 'true'; then calls accept(ClassVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.util.KotlinCallableReferenceInitializer.visitKotlinSyntheticClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testVisitKotlinSyntheticClassMetadata_givenTrue_thenCallsAccept() {
    // Arrange
    KotlinCallableReferenceInitializer kotlinCallableReferenceInitializer =
        new KotlinCallableReferenceInitializer(
            KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).accept(Mockito.<ClassVisitor>any());
    when(clazz.extendsOrImplements(Mockito.<String>any())).thenReturn(true);

    // Act
    kotlinCallableReferenceInitializer.visitKotlinSyntheticClassMetadata(
        clazz,
        new KotlinSyntheticClassKindMetadata(
            new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR));

    // Assert
    verify(clazz).accept(isA(ClassVisitor.class));
    verify(clazz).extendsOrImplements(eq("kotlin/jvm/internal/CallableReference"));
  }
}
