package proguard.classfile.kotlin;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.LibraryClass;
import proguard.classfile.visitor.ClassVisitor;
import proguard.resources.kotlinmodule.KotlinModule;
import proguard.resources.kotlinmodule.visitor.KotlinModuleVisitor;

class KotlinDeclarationContainerMetadataDiffblueTest {
  /**
   * Test {@link KotlinDeclarationContainerMetadata#moduleAccept(KotlinModuleVisitor)}.
   *
   * <ul>
   *   <li>Given {@link KotlinModule} {@link KotlinModule#accept(KotlinModuleVisitor)} does nothing.
   *   <li>Then calls {@link KotlinModule#accept(KotlinModuleVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinDeclarationContainerMetadata#moduleAccept(KotlinModuleVisitor)}
   */
  @Test
  @DisplayName(
      "Test moduleAccept(KotlinModuleVisitor); given KotlinModule accept(KotlinModuleVisitor) does nothing; then calls accept(KotlinModuleVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinDeclarationContainerMetadata.moduleAccept(proguard.resources.kotlinmodule.visitor.KotlinModuleVisitor)"
  })
  void testModuleAccept_givenKotlinModuleAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    KotlinModule kotlinModule = mock(KotlinModule.class);
    doNothing().when(kotlinModule).accept(Mockito.<KotlinModuleVisitor>any());
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.referencedModule = kotlinModule;

    // Act
    kotlinClassKindMetadata.moduleAccept(mock(KotlinModuleVisitor.class));

    // Assert
    verify(kotlinModule).accept(isA(KotlinModuleVisitor.class));
  }

  /**
   * Test {@link KotlinDeclarationContainerMetadata#referencedOwnerClassAccept(ClassVisitor)} with
   * {@code classVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link ClassVisitor#visitLibraryClass(LibraryClass)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinDeclarationContainerMetadata#referencedOwnerClassAccept(ClassVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedOwnerClassAccept(ClassVisitor) with 'classVisitor'; then calls visitLibraryClass(LibraryClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinDeclarationContainerMetadata.referencedOwnerClassAccept(proguard.classfile.visitor.ClassVisitor)"
  })
  void testReferencedOwnerClassAcceptWithClassVisitor_thenCallsVisitLibraryClass() {
    // Arrange
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.ownerReferencedClass = new LibraryClass();
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());

    // Act
    kotlinClassKindMetadata.referencedOwnerClassAccept(classVisitor);

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
