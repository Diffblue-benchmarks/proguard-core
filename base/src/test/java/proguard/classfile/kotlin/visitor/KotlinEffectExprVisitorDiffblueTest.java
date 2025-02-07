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
import proguard.classfile.kotlin.KotlinEffectExpressionMetadata;
import proguard.classfile.kotlin.KotlinEffectInvocationKind;
import proguard.classfile.kotlin.KotlinEffectMetadata;
import proguard.classfile.kotlin.KotlinEffectType;

class KotlinEffectExprVisitorDiffblueTest {
  /**
   * Test {@link KotlinEffectExprVisitor#visitAndRHSExpression(Clazz, KotlinEffectMetadata,
   * KotlinEffectExpressionMetadata, KotlinEffectExpressionMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinEffectExpressionMetadata#andRightHandSideAccept(Clazz,
   *       KotlinEffectMetadata, KotlinEffectExprVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinEffectExprVisitor#visitAndRHSExpression(Clazz,
   * KotlinEffectMetadata, KotlinEffectExpressionMetadata, KotlinEffectExpressionMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAndRHSExpression(Clazz, KotlinEffectMetadata, KotlinEffectExpressionMetadata, KotlinEffectExpressionMetadata); then calls andRightHandSideAccept(Clazz, KotlinEffectMetadata, KotlinEffectExprVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinEffectExprVisitor.visitAndRHSExpression(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinEffectMetadata, proguard.classfile.kotlin.KotlinEffectExpressionMetadata, proguard.classfile.kotlin.KotlinEffectExpressionMetadata)"
  })
  void testVisitAndRHSExpression_thenCallsAndRightHandSideAccept() {
    // Arrange
    AllTypeVisitor allTypeVisitor = new AllTypeVisitor(mock(KotlinTypeVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinEffectMetadata kotlinEffectMetadata =
        new KotlinEffectMetadata(
            KotlinEffectType.RETURNS_CONSTANT, KotlinEffectInvocationKind.AT_MOST_ONCE);

    KotlinEffectExpressionMetadata lhs = new KotlinEffectExpressionMetadata();
    KotlinEffectExpressionMetadata rhs = mock(KotlinEffectExpressionMetadata.class);
    doNothing()
        .when(rhs)
        .andRightHandSideAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinEffectMetadata>any(),
            Mockito.<KotlinEffectExprVisitor>any());
    doNothing()
        .when(rhs)
        .orRightHandSideAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinEffectMetadata>any(),
            Mockito.<KotlinEffectExprVisitor>any());
    doNothing().when(rhs).typeOfIsAccept(Mockito.<Clazz>any(), Mockito.<KotlinTypeVisitor>any());

    // Act
    allTypeVisitor.visitAndRHSExpression(clazz, kotlinEffectMetadata, lhs, rhs);

    // Assert
    verify(rhs)
        .andRightHandSideAccept(
            isA(Clazz.class), isA(KotlinEffectMetadata.class), isA(KotlinEffectExprVisitor.class));
    verify(rhs)
        .orRightHandSideAccept(
            isA(Clazz.class), isA(KotlinEffectMetadata.class), isA(KotlinEffectExprVisitor.class));
    verify(rhs).typeOfIsAccept(isA(Clazz.class), isA(KotlinTypeVisitor.class));
  }

  /**
   * Test {@link KotlinEffectExprVisitor#visitOrRHSExpression(Clazz, KotlinEffectMetadata,
   * KotlinEffectExpressionMetadata, KotlinEffectExpressionMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinEffectExpressionMetadata#andRightHandSideAccept(Clazz,
   *       KotlinEffectMetadata, KotlinEffectExprVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinEffectExprVisitor#visitOrRHSExpression(Clazz,
   * KotlinEffectMetadata, KotlinEffectExpressionMetadata, KotlinEffectExpressionMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitOrRHSExpression(Clazz, KotlinEffectMetadata, KotlinEffectExpressionMetadata, KotlinEffectExpressionMetadata); then calls andRightHandSideAccept(Clazz, KotlinEffectMetadata, KotlinEffectExprVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinEffectExprVisitor.visitOrRHSExpression(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinEffectMetadata, proguard.classfile.kotlin.KotlinEffectExpressionMetadata, proguard.classfile.kotlin.KotlinEffectExpressionMetadata)"
  })
  void testVisitOrRHSExpression_thenCallsAndRightHandSideAccept() {
    // Arrange
    AllTypeVisitor allTypeVisitor = new AllTypeVisitor(mock(KotlinTypeVisitor.class));
    LibraryClass clazz = new LibraryClass();
    KotlinEffectMetadata kotlinEffectMetadata =
        new KotlinEffectMetadata(
            KotlinEffectType.RETURNS_CONSTANT, KotlinEffectInvocationKind.AT_MOST_ONCE);

    KotlinEffectExpressionMetadata lhs = new KotlinEffectExpressionMetadata();
    KotlinEffectExpressionMetadata rhs = mock(KotlinEffectExpressionMetadata.class);
    doNothing()
        .when(rhs)
        .andRightHandSideAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinEffectMetadata>any(),
            Mockito.<KotlinEffectExprVisitor>any());
    doNothing()
        .when(rhs)
        .orRightHandSideAccept(
            Mockito.<Clazz>any(),
            Mockito.<KotlinEffectMetadata>any(),
            Mockito.<KotlinEffectExprVisitor>any());
    doNothing().when(rhs).typeOfIsAccept(Mockito.<Clazz>any(), Mockito.<KotlinTypeVisitor>any());

    // Act
    allTypeVisitor.visitOrRHSExpression(clazz, kotlinEffectMetadata, lhs, rhs);

    // Assert
    verify(rhs)
        .andRightHandSideAccept(
            isA(Clazz.class), isA(KotlinEffectMetadata.class), isA(KotlinEffectExprVisitor.class));
    verify(rhs)
        .orRightHandSideAccept(
            isA(Clazz.class), isA(KotlinEffectMetadata.class), isA(KotlinEffectExprVisitor.class));
    verify(rhs).typeOfIsAccept(isA(Clazz.class), isA(KotlinTypeVisitor.class));
  }
}
