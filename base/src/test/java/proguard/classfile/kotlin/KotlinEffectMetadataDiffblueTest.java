package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinEffectExprVisitor;
import proguard.classfile.kotlin.visitor.KotlinEffectVisitor;

class KotlinEffectMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinEffectMetadata#KotlinEffectMetadata(KotlinEffectType,
   *       KotlinEffectInvocationKind)}
   *   <li>{@link KotlinEffectMetadata#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinEffectMetadata.<init>(proguard.classfile.kotlin.KotlinEffectType, proguard.classfile.kotlin.KotlinEffectInvocationKind)",
    "java.lang.String proguard.classfile.kotlin.KotlinEffectMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    KotlinEffectMetadata actualKotlinEffectMetadata =
        new KotlinEffectMetadata(
            KotlinEffectType.RETURNS_CONSTANT, KotlinEffectInvocationKind.AT_MOST_ONCE);

    // Assert
    assertEquals("Kotlin contract effect", actualKotlinEffectMetadata.toString());
    assertNull(actualKotlinEffectMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinEffectMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinEffectMetadata#accept(Clazz, KotlinMetadata, KotlinFunctionMetadata,
   * KotlinContractMetadata, KotlinEffectVisitor)}.
   *
   * <p>Method under test: {@link KotlinEffectMetadata#accept(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinContractMetadata, KotlinEffectVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinContractMetadata, KotlinEffectVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinEffectMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.KotlinContractMetadata, proguard.classfile.kotlin.visitor.KotlinEffectVisitor)"
  })
  void testAccept() {
    // Arrange
    KotlinEffectMetadata kotlinEffectMetadata =
        new KotlinEffectMetadata(
            KotlinEffectType.RETURNS_CONSTANT, KotlinEffectInvocationKind.AT_MOST_ONCE);
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
    KotlinEffectVisitor kotlinEffectVisitor = mock(KotlinEffectVisitor.class);
    doNothing()
        .when(kotlinEffectVisitor)
        .visitEffect(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinContractMetadata>any(),
            Mockito.<KotlinEffectMetadata>any());

    // Act
    kotlinEffectMetadata.accept(
        clazz, kotlinMetadata, kotlinFunctionMetadata, kotlinContractMetadata, kotlinEffectVisitor);

    // Assert
    verify(kotlinEffectVisitor)
        .visitEffect(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinContractMetadata.class),
            isA(KotlinEffectMetadata.class));
  }

  /**
   * Test {@link KotlinEffectMetadata#conclusionOfConditionalEffectAccept(Clazz,
   * KotlinEffectExprVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinEffectExprVisitor#visitConclusionExpression(Clazz,
   *       KotlinEffectMetadata, KotlinEffectExpressionMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinEffectMetadata#conclusionOfConditionalEffectAccept(Clazz,
   * KotlinEffectExprVisitor)}
   */
  @Test
  @DisplayName(
      "Test conclusionOfConditionalEffectAccept(Clazz, KotlinEffectExprVisitor); then calls visitConclusionExpression(Clazz, KotlinEffectMetadata, KotlinEffectExpressionMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinEffectMetadata.conclusionOfConditionalEffectAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.visitor.KotlinEffectExprVisitor)"
  })
  void testConclusionOfConditionalEffectAccept_thenCallsVisitConclusionExpression() {
    // Arrange
    KotlinEffectMetadata kotlinEffectMetadata =
        new KotlinEffectMetadata(
            KotlinEffectType.RETURNS_CONSTANT, KotlinEffectInvocationKind.AT_MOST_ONCE);
    kotlinEffectMetadata.conclusionOfConditionalEffect = new KotlinEffectExpressionMetadata();
    LibraryClass clazz = new LibraryClass();
    KotlinEffectExprVisitor kotlinEffectExprVisitor = mock(KotlinEffectExprVisitor.class);
    doNothing()
        .when(kotlinEffectExprVisitor)
        .visitConclusionExpression(
            Mockito.<Clazz>any(),
            Mockito.<KotlinEffectMetadata>any(),
            Mockito.<KotlinEffectExpressionMetadata>any());

    // Act
    kotlinEffectMetadata.conclusionOfConditionalEffectAccept(clazz, kotlinEffectExprVisitor);

    // Assert
    verify(kotlinEffectExprVisitor)
        .visitConclusionExpression(
            isA(Clazz.class),
            isA(KotlinEffectMetadata.class),
            isA(KotlinEffectExpressionMetadata.class));
  }
}
