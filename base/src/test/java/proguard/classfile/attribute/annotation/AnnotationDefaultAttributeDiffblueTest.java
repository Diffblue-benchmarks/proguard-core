package proguard.classfile.attribute.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;
import proguard.classfile.editor.ConstantPoolRemapper;

class AnnotationDefaultAttributeDiffblueTest {
  /**
   * Test {@link AnnotationDefaultAttribute#AnnotationDefaultAttribute()}.
   *
   * <p>Method under test: {@link AnnotationDefaultAttribute#AnnotationDefaultAttribute()}
   */
  @Test
  @DisplayName("Test new AnnotationDefaultAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.AnnotationDefaultAttribute.<init>()",
    "void proguard.classfile.attribute.annotation.AnnotationDefaultAttribute.<init>(int, proguard.classfile.attribute.annotation.ElementValue)"
  })
  void testNewAnnotationDefaultAttribute() {
    // Arrange and Act
    AnnotationDefaultAttribute actualAnnotationDefaultAttribute = new AnnotationDefaultAttribute();

    // Assert
    assertNull(actualAnnotationDefaultAttribute.getProcessingInfo());
    assertEquals(0, actualAnnotationDefaultAttribute.getProcessingFlags());
  }

  /**
   * Test {@link AnnotationDefaultAttribute#AnnotationDefaultAttribute(int, ElementValue)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationDefaultAttribute#AnnotationDefaultAttribute(int,
   * ElementValue)}
   */
  @Test
  @DisplayName("Test new AnnotationDefaultAttribute(int, ElementValue); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.AnnotationDefaultAttribute.<init>()",
    "void proguard.classfile.attribute.annotation.AnnotationDefaultAttribute.<init>(int, proguard.classfile.attribute.annotation.ElementValue)"
  })
  void testNewAnnotationDefaultAttribute_whenOne() {
    // Arrange and Act
    AnnotationDefaultAttribute actualAnnotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, new AnnotationElementValue());

    // Assert
    assertNull(actualAnnotationDefaultAttribute.getProcessingInfo());
    assertEquals(0, actualAnnotationDefaultAttribute.getProcessingFlags());
  }

  /**
   * Test {@link AnnotationDefaultAttribute#defaultValueAccept(Clazz, ElementValueVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotationElementValue#accept(Clazz, Annotation, ElementValueVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationDefaultAttribute#defaultValueAccept(Clazz,
   * ElementValueVisitor)}
   */
  @Test
  @DisplayName(
      "Test defaultValueAccept(Clazz, ElementValueVisitor); then calls accept(Clazz, Annotation, ElementValueVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.AnnotationDefaultAttribute.defaultValueAccept(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.visitor.ElementValueVisitor)"
  })
  void testDefaultValueAccept_thenCallsAccept() {
    // Arrange
    AnnotationElementValue defaultValue = mock(AnnotationElementValue.class);
    doNothing()
        .when(defaultValue)
        .accept(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<ElementValueVisitor>any());
    AnnotationDefaultAttribute annotationDefaultAttribute =
        new AnnotationDefaultAttribute(1, defaultValue);
    LibraryClass clazz = new LibraryClass();

    // Act
    annotationDefaultAttribute.defaultValueAccept(clazz, new ConstantPoolRemapper());

    // Assert
    verify(defaultValue)
        .accept(isA(Clazz.class), (Annotation) isNull(), isA(ElementValueVisitor.class));
  }

  /**
   * Test {@link AnnotationDefaultAttribute#accept(Clazz, Method, AttributeVisitor)} with {@code
   * clazz}, {@code method}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link AnnotationDefaultAttribute#accept(Clazz, Method,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, AttributeVisitor) with 'clazz', 'method', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.AnnotationDefaultAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodAttributeVisitor() {
    // Arrange
    AnnotationDefaultAttribute annotationDefaultAttribute = new AnnotationDefaultAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitAnnotationDefaultAttribute(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AnnotationDefaultAttribute>any());

    // Act
    annotationDefaultAttribute.accept(clazz, method, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitAnnotationDefaultAttribute(
            isA(Clazz.class), isA(Method.class), isA(AnnotationDefaultAttribute.class));
  }
}
