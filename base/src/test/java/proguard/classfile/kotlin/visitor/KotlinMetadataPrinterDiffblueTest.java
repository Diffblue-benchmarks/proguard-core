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
import proguard.classfile.kotlin.KotlinContractMetadata;
import proguard.classfile.kotlin.KotlinDeclarationContainerMetadata;
import proguard.classfile.kotlin.KotlinEffectMetadata;
import proguard.classfile.kotlin.KotlinFileFacadeKindMetadata;
import proguard.classfile.kotlin.KotlinFunctionMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;

class KotlinMetadataPrinterDiffblueTest {
  /**
   * Test {@link KotlinMetadataPrinter#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinDeclarationContainerMetadata#delegatedPropertiesAccept(Clazz,
   *       KotlinPropertyVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinMetadataPrinter#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata); then calls delegatedPropertiesAccept(Clazz, KotlinPropertyVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataPrinter.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata_thenCallsDelegatedPropertiesAccept() {
    // Arrange
    KotlinMetadataPrinter kotlinMetadataPrinter = new KotlinMetadataPrinter();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .delegatedPropertiesAccept(Mockito.<Clazz>any(), Mockito.<KotlinPropertyVisitor>any());
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .functionsAccept(Mockito.<Clazz>any(), Mockito.<KotlinFunctionVisitor>any());
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .propertiesAccept(Mockito.<Clazz>any(), Mockito.<KotlinPropertyVisitor>any());
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .typeAliasesAccept(Mockito.<Clazz>any(), Mockito.<KotlinTypeAliasVisitor>any());

    // Act
    kotlinMetadataPrinter.visitKotlinDeclarationContainerMetadata(
        clazz, kotlinDeclarationContainerMetadata);

    // Assert
    verify(kotlinDeclarationContainerMetadata)
        .delegatedPropertiesAccept(isA(Clazz.class), isA(KotlinPropertyVisitor.class));
    verify(kotlinDeclarationContainerMetadata)
        .functionsAccept(isA(Clazz.class), isA(KotlinFunctionVisitor.class));
    verify(kotlinDeclarationContainerMetadata)
        .propertiesAccept(isA(Clazz.class), isA(KotlinPropertyVisitor.class));
    verify(kotlinDeclarationContainerMetadata)
        .typeAliasesAccept(isA(Clazz.class), isA(KotlinTypeAliasVisitor.class));
  }

  /**
   * Test {@link KotlinMetadataPrinter#visitKotlinFileFacadeMetadata(Clazz,
   * KotlinFileFacadeKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinDeclarationContainerMetadata#delegatedPropertiesAccept(Clazz,
   *       KotlinPropertyVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataPrinter#visitKotlinFileFacadeMetadata(Clazz,
   * KotlinFileFacadeKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinFileFacadeMetadata(Clazz, KotlinFileFacadeKindMetadata); then calls delegatedPropertiesAccept(Clazz, KotlinPropertyVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataPrinter.visitKotlinFileFacadeMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinFileFacadeKindMetadata)"
  })
  void testVisitKotlinFileFacadeMetadata_thenCallsDelegatedPropertiesAccept() {
    // Arrange
    KotlinMetadataPrinter kotlinMetadataPrinter = new KotlinMetadataPrinter();
    LibraryClass clazz =
        new LibraryClass(
            47,
            "_____________________________________________________________________",
            "_____________________________________________________________________");

    KotlinFileFacadeKindMetadata kotlinFileFacadeKindMetadata =
        mock(KotlinFileFacadeKindMetadata.class);
    doNothing()
        .when(kotlinFileFacadeKindMetadata)
        .delegatedPropertiesAccept(Mockito.<Clazz>any(), Mockito.<KotlinPropertyVisitor>any());
    doNothing()
        .when(kotlinFileFacadeKindMetadata)
        .functionsAccept(Mockito.<Clazz>any(), Mockito.<KotlinFunctionVisitor>any());
    doNothing()
        .when(kotlinFileFacadeKindMetadata)
        .propertiesAccept(Mockito.<Clazz>any(), Mockito.<KotlinPropertyVisitor>any());
    doNothing()
        .when(kotlinFileFacadeKindMetadata)
        .typeAliasesAccept(Mockito.<Clazz>any(), Mockito.<KotlinTypeAliasVisitor>any());

    // Act
    kotlinMetadataPrinter.visitKotlinFileFacadeMetadata(clazz, kotlinFileFacadeKindMetadata);

    // Assert
    verify(kotlinFileFacadeKindMetadata)
        .delegatedPropertiesAccept(isA(Clazz.class), isA(KotlinPropertyVisitor.class));
    verify(kotlinFileFacadeKindMetadata)
        .functionsAccept(isA(Clazz.class), isA(KotlinFunctionVisitor.class));
    verify(kotlinFileFacadeKindMetadata)
        .propertiesAccept(isA(Clazz.class), isA(KotlinPropertyVisitor.class));
    verify(kotlinFileFacadeKindMetadata)
        .typeAliasesAccept(isA(Clazz.class), isA(KotlinTypeAliasVisitor.class));
  }

  /**
   * Test {@link KotlinMetadataPrinter#visitContract(Clazz, KotlinMetadata, KotlinFunctionMetadata,
   * KotlinContractMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinContractMetadata#effectsAccept(Clazz, KotlinMetadata,
   *       KotlinFunctionMetadata, KotlinEffectVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataPrinter#visitContract(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinContractMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitContract(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinContractMetadata); then calls effectsAccept(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinEffectVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataPrinter.visitContract(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinContractMetadata)"
  })
  void testVisitContract_thenCallsEffectsAccept() {
    // Arrange
    KotlinMetadataPrinter kotlinMetadataPrinter = new KotlinMetadataPrinter();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
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
    KotlinFunctionMetadata kotlinFunctionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");

    KotlinContractMetadata kotlinContractMetadata = mock(KotlinContractMetadata.class);
    doNothing()
        .when(kotlinContractMetadata)
        .effectsAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinEffectVisitor>any());

    // Act
    kotlinMetadataPrinter.visitContract(
        clazz, kotlinMetadata, kotlinFunctionMetadata, kotlinContractMetadata);

    // Assert
    verify(kotlinContractMetadata)
        .effectsAccept(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinEffectVisitor.class));
  }

  /**
   * Test {@link KotlinMetadataPrinter#visitEffect(Clazz, KotlinMetadata, KotlinFunctionMetadata,
   * KotlinContractMetadata, KotlinEffectMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinEffectMetadata#conclusionOfConditionalEffectAccept(Clazz,
   *       KotlinEffectExprVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataPrinter#visitEffect(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinContractMetadata, KotlinEffectMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitEffect(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinContractMetadata, KotlinEffectMetadata); then calls conclusionOfConditionalEffectAccept(Clazz, KotlinEffectExprVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinMetadataPrinter.visitEffect(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinContractMetadata, proguard.classfile.kotlin.KotlinEffectMetadata)"
  })
  void testVisitEffect_thenCallsConclusionOfConditionalEffectAccept() {
    // Arrange
    KotlinMetadataPrinter kotlinMetadataPrinter = new KotlinMetadataPrinter();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
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
    KotlinFunctionMetadata kotlinFunctionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");

    KotlinContractMetadata kotlinContractMetadata = new KotlinContractMetadata();
    KotlinEffectMetadata kotlinEffectMetadata = mock(KotlinEffectMetadata.class);
    doNothing()
        .when(kotlinEffectMetadata)
        .conclusionOfConditionalEffectAccept(
            Mockito.<Clazz>any(), Mockito.<KotlinEffectExprVisitor>any());
    doNothing()
        .when(kotlinEffectMetadata)
        .constructorArgumentAccept(Mockito.<Clazz>any(), Mockito.<KotlinEffectExprVisitor>any());

    // Act
    kotlinMetadataPrinter.visitEffect(
        clazz,
        kotlinMetadata,
        kotlinFunctionMetadata,
        kotlinContractMetadata,
        kotlinEffectMetadata);

    // Assert
    verify(kotlinEffectMetadata)
        .conclusionOfConditionalEffectAccept(isA(Clazz.class), isA(KotlinEffectExprVisitor.class));
    verify(kotlinEffectMetadata)
        .constructorArgumentAccept(isA(Clazz.class), isA(KotlinEffectExprVisitor.class));
  }
}
