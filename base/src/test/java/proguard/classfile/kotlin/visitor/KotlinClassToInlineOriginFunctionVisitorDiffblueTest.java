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

class KotlinClassToInlineOriginFunctionVisitorDiffblueTest {
  /**
   * Test {@link
   * KotlinClassToInlineOriginFunctionVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinDeclarationContainerMetadata#functionsAccept(Clazz,
   *       KotlinFunctionVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinClassToInlineOriginFunctionVisitor#visitKotlinDeclarationContainerMetadata(Clazz,
   * KotlinDeclarationContainerMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitKotlinDeclarationContainerMetadata(Clazz, KotlinDeclarationContainerMetadata); then calls functionsAccept(Clazz, KotlinFunctionVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinClassToInlineOriginFunctionVisitor.visitKotlinDeclarationContainerMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata)"
  })
  void testVisitKotlinDeclarationContainerMetadata_thenCallsFunctionsAccept() {
    // Arrange
    KotlinClassToInlineOriginFunctionVisitor kotlinClassToInlineOriginFunctionVisitor =
        new KotlinClassToInlineOriginFunctionVisitor(
            "Anonymous Object Origin Name", mock(KotlinFunctionVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        mock(KotlinClassKindMetadata.class);
    doNothing()
        .when(kotlinDeclarationContainerMetadata)
        .functionsAccept(Mockito.<Clazz>any(), Mockito.<KotlinFunctionVisitor>any());

    // Act
    kotlinClassToInlineOriginFunctionVisitor.visitKotlinDeclarationContainerMetadata(
        clazz, kotlinDeclarationContainerMetadata);

    // Assert
    verify(kotlinDeclarationContainerMetadata)
        .functionsAccept(isA(Clazz.class), isA(KotlinFunctionVisitor.class));
  }
}
