package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinDeclarationContainerMetadata;
import proguard.classfile.kotlin.KotlinTypeAliasMetadata;
import proguard.classfile.kotlin.KotlinTypeMetadata;
import proguard.classfile.kotlin.KotlinTypeParameterMetadata;
import proguard.classfile.kotlin.visitor.KotlinAnnotationVisitor;

class KmAnnotationIntegrityDiffblueTest {
  /**
   * Test {@link KmAnnotationIntegrity#visitAnyType(Clazz, KotlinTypeMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeMetadata#annotationsAccept(Clazz, KotlinAnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KmAnnotationIntegrity#visitAnyType(Clazz, KotlinTypeMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyType(Clazz, KotlinTypeMetadata); then calls annotationsAccept(Clazz, KotlinAnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.constraint.KmAnnotationIntegrity.visitAnyType(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeMetadata)"
  })
  void testVisitAnyType_thenCallsAnnotationsAccept() {
    // Arrange
    KmAnnotationIntegrity kmAnnotationIntegrity = new KmAnnotationIntegrity();
    LibraryClass clazz = new LibraryClass();
    KotlinTypeMetadata type = mock(KotlinTypeMetadata.class);
    doNothing()
        .when(type)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<KotlinAnnotationVisitor>any());

    // Act
    kmAnnotationIntegrity.visitAnyType(clazz, type);

    // Assert
    verify(type).annotationsAccept(isA(Clazz.class), isA(KotlinAnnotationVisitor.class));
  }

  /**
   * Test {@link KmAnnotationIntegrity#visitTypeAlias(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinTypeAliasMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeAliasMetadata#annotationsAccept(Clazz,
   *       KotlinAnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KmAnnotationIntegrity#visitTypeAlias(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAlias(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasMetadata); then calls annotationsAccept(Clazz, KotlinAnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.constraint.KmAnnotationIntegrity.visitTypeAlias(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinTypeAliasMetadata)"
  })
  void testVisitTypeAlias_thenCallsAnnotationsAccept() {
    // Arrange
    KmAnnotationIntegrity kmAnnotationIntegrity = new KmAnnotationIntegrity();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeAliasMetadata kotlinTypeAliasMetadata = mock(KotlinTypeAliasMetadata.class);
    doNothing()
        .when(kotlinTypeAliasMetadata)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<KotlinAnnotationVisitor>any());

    // Act
    kmAnnotationIntegrity.visitTypeAlias(
        clazz, kotlinDeclarationContainerMetadata, kotlinTypeAliasMetadata);

    // Assert
    verify(kotlinTypeAliasMetadata)
        .annotationsAccept(isA(Clazz.class), isA(KotlinAnnotationVisitor.class));
  }

  /**
   * Test {@link KmAnnotationIntegrity#visitAnyTypeParameter(Clazz, KotlinTypeParameterMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeParameterMetadata#annotationsAccept(Clazz,
   *       KotlinAnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KmAnnotationIntegrity#visitAnyTypeParameter(Clazz,
   * KotlinTypeParameterMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyTypeParameter(Clazz, KotlinTypeParameterMetadata); then calls annotationsAccept(Clazz, KotlinAnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.constraint.KmAnnotationIntegrity.visitAnyTypeParameter(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinTypeParameterMetadata)"
  })
  void testVisitAnyTypeParameter_thenCallsAnnotationsAccept() {
    // Arrange
    KmAnnotationIntegrity kmAnnotationIntegrity = new KmAnnotationIntegrity();
    LibraryClass clazz = new LibraryClass();
    KotlinTypeParameterMetadata kotlinTypeParameterMetadata =
        mock(KotlinTypeParameterMetadata.class);
    doNothing()
        .when(kotlinTypeParameterMetadata)
        .annotationsAccept(Mockito.<Clazz>any(), Mockito.<KotlinAnnotationVisitor>any());

    // Act
    kmAnnotationIntegrity.visitAnyTypeParameter(clazz, kotlinTypeParameterMetadata);

    // Assert
    verify(kotlinTypeParameterMetadata)
        .annotationsAccept(isA(Clazz.class), isA(KotlinAnnotationVisitor.class));
  }

  /**
   * Test new {@link KmAnnotationIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KmAnnotationIntegrity}
   */
  @Test
  @DisplayName("Test new KmAnnotationIntegrity (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.constraint.KmAnnotationIntegrity.<init>()"
  })
  void testNewKmAnnotationIntegrity() {
    // Arrange and Act
    KmAnnotationIntegrity actualKmAnnotationIntegrity = new KmAnnotationIntegrity();

    // Assert
    assertNull(actualKmAnnotationIntegrity.libraryClassPool);
    assertNull(actualKmAnnotationIntegrity.programClassPool);
    assertNull(actualKmAnnotationIntegrity.reporter);
  }
}
