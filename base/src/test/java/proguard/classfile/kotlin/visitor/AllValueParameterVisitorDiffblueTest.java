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

class AllValueParameterVisitorDiffblueTest {
  /**
   * Test {@link AllValueParameterVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AllValueParameterVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata); then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.AllValueParameterVisitor.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata_thenCallsAccept() {
    // Arrange
    AllValueParameterVisitor allValueParameterVisitor =
        new AllValueParameterVisitor(mock(KotlinValueParameterVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .functionsAccept(Mockito.<Clazz>any(), Mockito.<KotlinFunctionVisitor>any());

    // Act
    allValueParameterVisitor.visitKotlinDeclarationContainerMetadata(
        clazz, kotlinDeclarationContainerMetadata);

    // Assert
    verify(kotlinDeclarationContainerMetadata)
        .accept(isA(Clazz.class), isA(KotlinMetadataVisitor.class));
    verify(kotlinDeclarationContainerMetadata)
        .functionsAccept(isA(Clazz.class), isA(KotlinFunctionVisitor.class));
  }

  /**
   * Test {@link AllValueParameterVisitor#visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllValueParameterVisitor#visitKotlinClassMetadata(Clazz,
   * KotlinClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata); then calls accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.AllValueParameterVisitor.visitKotlinClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata)"
  })
  void testVisitKotlinClassMetadata_thenCallsAccept() {
    // Arrange
    AllValueParameterVisitor allValueParameterVisitor =
        new AllValueParameterVisitor(mock(KotlinValueParameterVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinClassKindMetadata = mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinClassKindMetadata)
        .accept(Mockito.<Clazz>any(), Mockito.<KotlinMetadataVisitor>any());
    doNothing()
        .when(kotlinClassKindMetadata)
        .constructorsAccept(Mockito.<Clazz>any(), Mockito.<KotlinConstructorVisitor>any());
    doNothing()
        .when(kotlinClassKindMetadata)
        .functionsAccept(Mockito.<Clazz>any(), Mockito.<KotlinFunctionVisitor>any());

    // Act
    allValueParameterVisitor.visitKotlinClassMetadata(clazz, kotlinClassKindMetadata);

    // Assert
    verify(kotlinClassKindMetadata).accept(isA(Clazz.class), isA(KotlinMetadataVisitor.class));
    verify(kotlinClassKindMetadata)
        .constructorsAccept(isA(Clazz.class), isA(KotlinConstructorVisitor.class));
    verify(kotlinClassKindMetadata)
        .functionsAccept(isA(Clazz.class), isA(KotlinFunctionVisitor.class));
  }

  /**
   * Test {@link AllValueParameterVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinSyntheticClassKindMetadata#functionsAccept(Clazz,
   *       KotlinFunctionVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AllValueParameterVisitor#visitKotlinSyntheticClassMetadata(Clazz,
   * KotlinSyntheticClassKindMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinSyntheticClassMetadata(Clazz, KotlinSyntheticClassKindMetadata); then calls functionsAccept(Clazz, KotlinFunctionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.AllValueParameterVisitor.visitKotlinSyntheticClassMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata)"
  })
  void testVisitKotlinSyntheticClassMetadata_thenCallsFunctionsAccept() {
    // Arrange
    AllValueParameterVisitor allValueParameterVisitor =
        new AllValueParameterVisitor(mock(KotlinValueParameterVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinSyntheticClassKindMetadata kotlinSyntheticClassKindMetadata =
        mock(KotlinSyntheticClassKindMetadata.class);
    doNothing()
        .when(kotlinSyntheticClassKindMetadata)
        .functionsAccept(Mockito.<Clazz>any(), Mockito.<KotlinFunctionVisitor>any());

    // Act
    allValueParameterVisitor.visitKotlinSyntheticClassMetadata(
        clazz, kotlinSyntheticClassKindMetadata);

    // Assert
    verify(kotlinSyntheticClassKindMetadata)
        .functionsAccept(isA(Clazz.class), isA(KotlinFunctionVisitor.class));
  }
}
