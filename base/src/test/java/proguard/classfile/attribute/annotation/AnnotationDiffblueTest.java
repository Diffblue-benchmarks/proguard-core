package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class AnnotationDiffblueTest {
  /**
   * Method under test: {@link Annotation#Annotation()}
   */
  @Test
  public void testNewAnnotation() {
    // Arrange and Act
    Annotation actualAnnotation = new Annotation();

    // Assert
    assertNull(actualAnnotation.getProcessingInfo());
    assertEquals(0, actualAnnotation.getProcessingFlags());
  }

  /**
   * Method under test: {@link Annotation#Annotation(int, int, ElementValue[])}
   */
  @Test
  public void testNewAnnotation2() {
    // Arrange and Act
    Annotation actualAnnotation = new Annotation(1, 3, new ElementValue[]{new AnnotationElementValue()});

    // Assert
    assertNull(actualAnnotation.getProcessingInfo());
    assertEquals(0, actualAnnotation.getProcessingFlags());
  }
}
