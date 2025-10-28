package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class AnnotationElementValueDiffblueTest {
  /**
   * Method under test: {@link AnnotationElementValue#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(ElementValue.TAG_ANNOTATION, (new AnnotationElementValue()).getTag());
  }

  /**
   * Method under test: {@link AnnotationElementValue#AnnotationElementValue()}
   */
  @Test
  public void testNewAnnotationElementValue() {
    // Arrange and Act
    AnnotationElementValue actualAnnotationElementValue = new AnnotationElementValue();

    // Assert
    assertNull(actualAnnotationElementValue.getProcessingInfo());
    assertEquals(0, actualAnnotationElementValue.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link AnnotationElementValue#AnnotationElementValue(int, Annotation)}
   */
  @Test
  public void testNewAnnotationElementValue2() {
    // Arrange and Act
    AnnotationElementValue actualAnnotationElementValue = new AnnotationElementValue(1, new Annotation());

    // Assert
    assertNull(actualAnnotationElementValue.getProcessingInfo());
    Annotation annotation = actualAnnotationElementValue.annotationValue;
    assertNull(annotation.getProcessingInfo());
    assertEquals(0, actualAnnotationElementValue.getProcessingFlags());
    assertEquals(0, annotation.getProcessingFlags());
  }
}
