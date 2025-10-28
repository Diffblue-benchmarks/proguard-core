package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RuntimeInvisibleParameterAnnotationsAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link RuntimeInvisibleParameterAnnotationsAttribute#RuntimeInvisibleParameterAnnotationsAttribute()}
   */
  @Test
  public void testNewRuntimeInvisibleParameterAnnotationsAttribute() {
    // Arrange and Act
    RuntimeInvisibleParameterAnnotationsAttribute actualRuntimeInvisibleParameterAnnotationsAttribute = new RuntimeInvisibleParameterAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link RuntimeInvisibleParameterAnnotationsAttribute#RuntimeInvisibleParameterAnnotationsAttribute(int, int, int[], Annotation[][])}
   */
  @Test
  public void testNewRuntimeInvisibleParameterAnnotationsAttribute2() {
    // Arrange and Act
    RuntimeInvisibleParameterAnnotationsAttribute actualRuntimeInvisibleParameterAnnotationsAttribute = new RuntimeInvisibleParameterAnnotationsAttribute(
        1, 3, new int[]{3, 1, 3, 1}, new Annotation[][]{new Annotation[]{new Annotation()}});

    // Assert
    assertNull(actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeInvisibleParameterAnnotationsAttribute.getProcessingFlags());
  }
}
