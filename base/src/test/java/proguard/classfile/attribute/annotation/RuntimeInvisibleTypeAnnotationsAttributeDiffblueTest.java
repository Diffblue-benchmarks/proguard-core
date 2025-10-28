package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RuntimeInvisibleTypeAnnotationsAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link RuntimeInvisibleTypeAnnotationsAttribute#RuntimeInvisibleTypeAnnotationsAttribute()}
   */
  @Test
  public void testNewRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange and Act
    RuntimeInvisibleTypeAnnotationsAttribute actualRuntimeInvisibleTypeAnnotationsAttribute = new RuntimeInvisibleTypeAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link RuntimeInvisibleTypeAnnotationsAttribute#RuntimeInvisibleTypeAnnotationsAttribute(int, int, TypeAnnotation[])}
   */
  @Test
  public void testNewRuntimeInvisibleTypeAnnotationsAttribute2() {
    // Arrange and Act
    RuntimeInvisibleTypeAnnotationsAttribute actualRuntimeInvisibleTypeAnnotationsAttribute = new RuntimeInvisibleTypeAnnotationsAttribute(
        1, 3, new TypeAnnotation[]{new TypeAnnotation()});

    // Assert
    assertNull(actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleTypeAnnotationsAttribute.getProcessingFlags());
  }
}
