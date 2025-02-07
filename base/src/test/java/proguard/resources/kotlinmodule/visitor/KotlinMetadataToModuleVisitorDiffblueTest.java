package proguard.resources.kotlinmodule.visitor;

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
import proguard.resources.kotlinmodule.KotlinModule;

class KotlinMetadataToModuleVisitorDiffblueTest {
  /**
   * Test {@link KotlinMetadataToModuleVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinModule#accept(KotlinModuleVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataToModuleVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata); then calls accept(KotlinModuleVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.visitor.KotlinMetadataToModuleVisitor.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata_thenCallsAccept() {
    // Arrange
    KotlinMetadataToModuleVisitor kotlinMetadataToModuleVisitor =
        new KotlinMetadataToModuleVisitor(mock(KotlinModuleVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinModule kotlinModule = mock(KotlinModule.class);
    doNothing().when(kotlinModule).accept(Mockito.<KotlinModuleVisitor>any());
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    kotlinDeclarationContainerMetadata.referencedModule = kotlinModule;

    // Act
    kotlinMetadataToModuleVisitor.visitKotlinDeclarationContainerMetadata(
        clazz, kotlinDeclarationContainerMetadata);

    // Assert
    verify(kotlinModule).accept(isA(KotlinModuleVisitor.class));
  }

  /**
   * Test {@link KotlinMetadataToModuleVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinDeclarationContainerMetadata#moduleAccept(KotlinModuleVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataToModuleVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata); then calls moduleAccept(KotlinModuleVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.visitor.KotlinMetadataToModuleVisitor.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata_thenCallsModuleAccept() {
    // Arrange
    KotlinMetadataToModuleVisitor kotlinMetadataToModuleVisitor =
        new KotlinMetadataToModuleVisitor(mock(KotlinModuleVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .moduleAccept(Mockito.<KotlinModuleVisitor>any());

    // Act
    kotlinMetadataToModuleVisitor.visitKotlinDeclarationContainerMetadata(
        clazz, kotlinDeclarationContainerMetadata);

    // Assert
    verify(kotlinDeclarationContainerMetadata).moduleAccept(isA(KotlinModuleVisitor.class));
  }
}
