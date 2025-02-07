package proguard.classfile.kotlin.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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

class AllKotlinAnnotationVisitorDiffblueTest {
  /**
   * Test {@link AllKotlinAnnotationVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AllKotlinAnnotationVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata); then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.AllKotlinAnnotationVisitor.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata_thenCallsAccept() {
    // Arrange
    AllKotlinAnnotationVisitor allKotlinAnnotationVisitor =
        new AllKotlinAnnotationVisitor(mock(KotlinAnnotationVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .typeAliasesAccept(Mockito.<Clazz>any(), Mockito.<KotlinTypeAliasVisitor>any());

    // Act
    allKotlinAnnotationVisitor.visitKotlinDeclarationContainerMetadata(
        clazz, kotlinDeclarationContainerMetadata);

    // Assert
    verify(kotlinDeclarationContainerMetadata, atLeast(1))
        .accept(isA(Clazz.class), Mockito.<KotlinMetadataVisitor>any());
    verify(kotlinDeclarationContainerMetadata)
        .typeAliasesAccept(isA(Clazz.class), isA(KotlinTypeAliasVisitor.class));
  }
}
