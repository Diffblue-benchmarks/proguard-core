package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RuntimeVisibleParameterAnnotationsAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link RuntimeVisibleParameterAnnotationsAttribute#RuntimeVisibleParameterAnnotationsAttribute()}
   */
  @Test
  public void testNewRuntimeVisibleParameterAnnotationsAttribute() {
    // Arrange and Act
    RuntimeVisibleParameterAnnotationsAttribute actualRuntimeVisibleParameterAnnotationsAttribute = new RuntimeVisibleParameterAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link RuntimeVisibleParameterAnnotationsAttribute#RuntimeVisibleParameterAnnotationsAttribute(int, int, int[], Annotation[][])}
   */
  @Test
  public void testNewRuntimeVisibleParameterAnnotationsAttribute2() {
    // Arrange and Act
    RuntimeVisibleParameterAnnotationsAttribute actualRuntimeVisibleParameterAnnotationsAttribute = new RuntimeVisibleParameterAnnotationsAttribute(
        1, 3, new int[]{3, 1, 3, 1}, new Annotation[][]{new Annotation[]{new Annotation()}});

    // Assert
    assertNull(actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleParameterAnnotationsAttribute.getProcessingFlags());
  }
}
