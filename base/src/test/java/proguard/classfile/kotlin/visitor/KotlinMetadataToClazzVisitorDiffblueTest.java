package proguard.classfile.kotlin.visitor;

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
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.Flavor;
import proguard.classfile.visitor.ClassVisitor;

class KotlinMetadataToClazzVisitorDiffblueTest {
  /**
   * Test {@link KotlinMetadataToClazzVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataToClazzVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataToClazzVisitor.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinMetadataToClazzVisitor kotlinMetadataToClazzVisitor =
        new KotlinMetadataToClazzVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    kotlinDeclarationContainerMetadata.ownerReferencedClass = new LibraryClass();

    // Act
    kotlinMetadataToClazzVisitor.visitKotlinDeclarationContainerMetadata(
        clazz, kotlinDeclarationContainerMetadata);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link KotlinMetadataToClazzVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataToClazzVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata); then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataToClazzVisitor.visitKotlinSyntheticClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testVisitKotlinSyntheticClassMetadata_thenCallsVisitLibraryClass() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    KotlinMetadataToClazzVisitor kotlinMetadataToClazzVisitor =
        new KotlinMetadataToClazzVisitor(classVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinMetadataToClazzVisitor.visitKotlinSyntheticClassMetadata(
        clazz,
        new KotlinSyntheticClassKindMetadata(
            new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
