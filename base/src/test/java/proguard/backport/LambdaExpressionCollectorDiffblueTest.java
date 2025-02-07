package proguard.backport;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.constant.InvokeDynamicConstant;

class LambdaExpressionCollectorDiffblueTest {
  /**
   * Test {@link LambdaExpressionCollector#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryClass#attributesAccept(AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link LambdaExpressionCollector#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then calls attributesAccept(AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.backport.LambdaExpressionCollector.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenCallsAttributesAccept() {
    // Arrange
    LambdaExpressionCollector lambdaExpressionCollector =
        new LambdaExpressionCollector(new HashMap<>());
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).attributesAccept(Mockito.<AttributeVisitor>any());

    // Act
    lambdaExpressionCollector.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant());

    // Assert
    verify(clazz).attributesAccept(isA(AttributeVisitor.class));
  }

  /**
   * Test {@link LambdaExpressionCollector#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link InvokeDynamicConstant#getBootstrapMethodAttributeIndex()}.
   * </ul>
   *
   * <p>Method under test: {@link LambdaExpressionCollector#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then calls getBootstrapMethodAttributeIndex()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.backport.LambdaExpressionCollector.visitInvokeDynamicConstant(proguard.classfile.Clazz, proguard.classfile.constant.InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenCallsGetBootstrapMethodAttributeIndex() {
    // Arrange
    LambdaExpressionCollector lambdaExpressionCollector =
        new LambdaExpressionCollector(new HashMap<>());
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).attributesAccept(Mockito.<AttributeVisitor>any());
    InvokeDynamicConstant invokeDynamicConstant = mock(InvokeDynamicConstant.class);
    when(invokeDynamicConstant.getBootstrapMethodAttributeIndex()).thenReturn(1);

    // Act
    lambdaExpressionCollector.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert
    verify(clazz).attributesAccept(isA(AttributeVisitor.class));
    verify(invokeDynamicConstant).getBootstrapMethodAttributeIndex();
  }
}
