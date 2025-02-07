package proguard.classfile.attribute.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.DominatorCalculator;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;

class AttributeProcessingFlagFilterDiffblueTest {
  /**
   * Test {@link AttributeProcessingFlagFilter#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>When {@link CodeAttribute} {@link CodeAttribute#accept(Clazz, Method, AttributeVisitor)}
   *       does nothing.
   *   <li>Then calls {@link CodeAttribute#accept(Clazz, Method, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributeProcessingFlagFilter#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); when CodeAttribute accept(Clazz, Method, AttributeVisitor) does nothing; then calls accept(Clazz, Method, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.visitor.AttributeProcessingFlagFilter.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_whenCodeAttributeAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    AttributeProcessingFlagFilter attributeProcessingFlagFilter =
        new AttributeProcessingFlagFilter(0, 1, new DominatorCalculator(true));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .accept(Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AttributeVisitor>any());

    // Act
    attributeProcessingFlagFilter.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute).accept(isA(Clazz.class), isA(Method.class), isA(AttributeVisitor.class));
  }
}
