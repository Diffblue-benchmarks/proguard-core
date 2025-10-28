package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.TargetInfo;

public class TypeAnnotationDiffblueTest {
  /**
   * Method under test: {@link TypeAnnotation#TypeAnnotation()}
   */
  @Test
  public void testNewTypeAnnotation() {
    // Arrange and Act
    TypeAnnotation actualTypeAnnotation = new TypeAnnotation();

    // Assert
    assertNull(actualTypeAnnotation.getProcessingInfo());
    assertEquals(0, actualTypeAnnotation.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link TypeAnnotation#TypeAnnotation(int, int, ElementValue[], TargetInfo, TypePathInfo[])}
   */
  @Test
  public void testNewTypeAnnotation2() {
    // Arrange
    CatchTargetInfo targetInfo = new CatchTargetInfo((byte) 'A');

    // Act
    TypeAnnotation actualTypeAnnotation = new TypeAnnotation(1, 3, new ElementValue[]{new AnnotationElementValue()},
        targetInfo, new TypePathInfo[]{new TypePathInfo(1, 1)});

    // Assert
    assertNull(actualTypeAnnotation.getProcessingInfo());
    assertEquals(0, actualTypeAnnotation.getProcessingFlags());
  }
}
