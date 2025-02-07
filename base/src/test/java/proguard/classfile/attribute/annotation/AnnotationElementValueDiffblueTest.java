package proguard.classfile.attribute.annotation;

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
import proguard.classfile.attribute.annotation.visitor.AllElementValueVisitor;
import proguard.classfile.attribute.annotation.visitor.ElementValueVisitor;

class AnnotationElementValueDiffblueTest {
  /**
   * Test {@link AnnotationElementValue#AnnotationElementValue()}.
   *
   * <p>Method under test: {@link AnnotationElementValue#AnnotationElementValue()}
   */
  @Test
  @DisplayName("Test new AnnotationElementValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.AnnotationElementValue.<init>()",
    "void proguard.classfile.attribute.annotation.AnnotationElementValue.<init>(int, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testNewAnnotationElementValue() {
    // Arrange and Act
    AnnotationElementValue actualAnnotationElementValue = new AnnotationElementValue();

    // Assert
    assertNull(actualAnnotationElementValue.getProcessingInfo());
    assertEquals(0, actualAnnotationElementValue.getProcessingFlags());
  }

  /**
   * Test {@link AnnotationElementValue#AnnotationElementValue(int, Annotation)}.
   *
   * <ul>
   *   <li>Then return {@link AnnotationElementValue#annotationValue} ProcessingInfo is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationElementValue#AnnotationElementValue(int, Annotation)}
   */
  @Test
  @DisplayName(
      "Test new AnnotationElementValue(int, Annotation); then return annotationValue ProcessingInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.AnnotationElementValue.<init>()",
    "void proguard.classfile.attribute.annotation.AnnotationElementValue.<init>(int, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testNewAnnotationElementValue_thenReturnAnnotationValueProcessingInfoIsNull() {
    // Arrange and Act
    AnnotationElementValue actualAnnotationElementValue =
        new AnnotationElementValue(1, new Annotation());

    // Assert
    assertNull(actualAnnotationElementValue.getProcessingInfo());
    Annotation annotation = actualAnnotationElementValue.annotationValue;
    assertNull(annotation.getProcessingInfo());
    assertEquals(0, actualAnnotationElementValue.getProcessingFlags());
    assertEquals(0, annotation.getProcessingFlags());
  }

  /**
   * Test {@link AnnotationElementValue#getTag()}.
   *
   * <p>Method under test: {@link AnnotationElementValue#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "char proguard.classfile.attribute.annotation.AnnotationElementValue.getTag()"
  })
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_ANNOTATION, (new AnnotationElementValue()).getTag());
  }

  /**
   * Test {@link AnnotationElementValue#accept(Clazz, Annotation, ElementValueVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link AllElementValueVisitor#visitAnnotationElementValue(Clazz, Annotation,
   *       AnnotationElementValue)}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationElementValue#accept(Clazz, Annotation,
   * ElementValueVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Annotation, ElementValueVisitor); then calls visitAnnotationElementValue(Clazz, Annotation, AnnotationElementValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.AnnotationElementValue.accept(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.visitor.ElementValueVisitor)"
  })
  void testAccept_thenCallsVisitAnnotationElementValue() {
    // Arrange
    AnnotationElementValue annotationElementValue = new AnnotationElementValue();
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();
    AllElementValueVisitor elementValueVisitor = mock(AllElementValueVisitor.class);
    doNothing()
        .when(elementValueVisitor)
        .visitAnnotationElementValue(
            Mockito.<Clazz>any(), Mockito.<Annotation>any(), Mockito.<AnnotationElementValue>any());

    // Act
    annotationElementValue.accept(clazz, annotation, elementValueVisitor);

    // Assert
    verify(elementValueVisitor)
        .visitAnnotationElementValue(
            isA(Clazz.class), isA(Annotation.class), isA(AnnotationElementValue.class));
  }
}
