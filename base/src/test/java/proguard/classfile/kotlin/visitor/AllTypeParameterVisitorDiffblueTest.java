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

class AllTypeParameterVisitorDiffblueTest {
  /**
   * Test {@link AllTypeParameterVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinDeclarationContainerMetadata#delegatedPropertiesAccept(Clazz,
   *       KotlinPropertyVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AllTypeParameterVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata); then calls delegatedPropertiesAccept(Clazz, KotlinPropertyVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.AllTypeParameterVisitor.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata_thenCallsDelegatedPropertiesAccept() {
    // Arrange
    AllTypeParameterVisitor allTypeParameterVisitor =
        new AllTypeParameterVisitor(mock(KotlinTypeParameterVisitor.class));
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
    allTypeParameterVisitor.visitKotlinDeclarationContainerMetadata(
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
   * Test {@link AllTypeParameterVisitor#visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#typeParametersAccept(Clazz,
   *       KotlinTypeParameterVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllTypeParameterVisitor#visitKotlinClassMetadata(Clazz,
   * KotlinClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata); then calls typeParametersAccept(Clazz, KotlinTypeParameterVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.AllTypeParameterVisitor.visitKotlinClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata)"
  })
  void testVisitKotlinClassMetadata_thenCallsTypeParametersAccept() {
    // Arrange
    AllTypeParameterVisitor allTypeParameterVisitor =
        new AllTypeParameterVisitor(mock(KotlinTypeParameterVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinClassKindMetadata = mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinClassKindMetadata)
        .typeParametersAccept(Mockito.<Clazz>any(), Mockito.<KotlinTypeParameterVisitor>any());
    doNothing()
        .when(kotlinClassKindMetadata)
        .delegatedPropertiesAccept(Mockito.<Clazz>any(), Mockito.<KotlinPropertyVisitor>any());
    doNothing()
        .when(kotlinClassKindMetadata)
        .functionsAccept(Mockito.<Clazz>any(), Mockito.<KotlinFunctionVisitor>any());
    doNothing()
        .when(kotlinClassKindMetadata)
        .propertiesAccept(Mockito.<Clazz>any(), Mockito.<KotlinPropertyVisitor>any());
    doNothing()
        .when(kotlinClassKindMetadata)
        .typeAliasesAccept(Mockito.<Clazz>any(), Mockito.<KotlinTypeAliasVisitor>any());

    // Act
    allTypeParameterVisitor.visitKotlinClassMetadata(clazz, kotlinClassKindMetadata);

    // Assert
    verify(kotlinClassKindMetadata)
        .typeParametersAccept(isA(Clazz.class), isA(KotlinTypeParameterVisitor.class));
    verify(kotlinClassKindMetadata)
        .delegatedPropertiesAccept(isA(Clazz.class), isA(KotlinPropertyVisitor.class));
    verify(kotlinClassKindMetadata)
        .functionsAccept(isA(Clazz.class), isA(KotlinFunctionVisitor.class));
    verify(kotlinClassKindMetadata)
        .propertiesAccept(isA(Clazz.class), isA(KotlinPropertyVisitor.class));
    verify(kotlinClassKindMetadata)
        .typeAliasesAccept(isA(Clazz.class), isA(KotlinTypeAliasVisitor.class));
  }

  /**
   * Test {@link AllTypeParameterVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinSyntheticClassKindMetadata#functionsAccept(Clazz,
   *       KotlinFunctionVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllTypeParameterVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata); then calls functionsAccept(Clazz, KotlinFunctionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.AllTypeParameterVisitor.visitKotlinSyntheticClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testVisitKotlinSyntheticClassMetadata_thenCallsFunctionsAccept() {
    // Arrange
    AllTypeParameterVisitor allTypeParameterVisitor =
        new AllTypeParameterVisitor(mock(KotlinTypeParameterVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinSyntheticClassKindMetadata kotlinSyntheticClassKindMetadata =
        mock(KotlinSyntheticClassKindMetadata.class);
    doNothing()
        .when(kotlinSyntheticClassKindMetadata)
        .functionsAccept(Mockito.<Clazz>any(), Mockito.<KotlinFunctionVisitor>any());

    // Act
    allTypeParameterVisitor.visitKotlinSyntheticClassMetadata(
        clazz, kotlinSyntheticClassKindMetadata);

    // Assert
    verify(kotlinSyntheticClassKindMetadata)
        .functionsAccept(isA(Clazz.class), isA(KotlinFunctionVisitor.class));
  }
}
