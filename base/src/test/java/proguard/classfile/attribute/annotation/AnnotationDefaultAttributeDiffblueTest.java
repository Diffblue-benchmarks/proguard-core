package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class AnnotationDefaultAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link AnnotationDefaultAttribute#AnnotationDefaultAttribute()}
   */
  @Test
  public void testNewAnnotationDefaultAttribute() {
    // Arrange and Act
    AnnotationDefaultAttribute actualAnnotationDefaultAttribute = new AnnotationDefaultAttribute();

    // Assert
    assertNull(actualAnnotationDefaultAttribute.getProcessingInfo());
    assertEquals(0, actualAnnotationDefaultAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link AnnotationDefaultAttribute#AnnotationDefaultAttribute(int, ElementValue)}
   */
  @Test
  public void testNewAnnotationDefaultAttribute2() {
    // Arrange and Act
    AnnotationDefaultAttribute actualAnnotationDefaultAttribute = new AnnotationDefaultAttribute(1,
        new AnnotationElementValue());

    // Assert
    assertNull(actualAnnotationDefaultAttribute.getProcessingInfo());
    assertEquals(0, actualAnnotationDefaultAttribute.getProcessingFlags());
  }
}
