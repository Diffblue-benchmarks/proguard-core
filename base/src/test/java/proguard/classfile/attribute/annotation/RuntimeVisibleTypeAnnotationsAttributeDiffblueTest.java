package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class RuntimeVisibleTypeAnnotationsAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link RuntimeVisibleTypeAnnotationsAttribute#RuntimeVisibleTypeAnnotationsAttribute()}
   */
  @Test
  public void testNewRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange and Act
    RuntimeVisibleTypeAnnotationsAttribute actualRuntimeVisibleTypeAnnotationsAttribute = new RuntimeVisibleTypeAnnotationsAttribute();

    // Assert
    assertNull(actualRuntimeVisibleTypeAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleTypeAnnotationsAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link RuntimeVisibleTypeAnnotationsAttribute#RuntimeVisibleTypeAnnotationsAttribute(int, int, TypeAnnotation[])}
   */
  @Test
  public void testNewRuntimeVisibleTypeAnnotationsAttribute2() {
    // Arrange and Act
    RuntimeVisibleTypeAnnotationsAttribute actualRuntimeVisibleTypeAnnotationsAttribute = new RuntimeVisibleTypeAnnotationsAttribute(
        1, 3, new TypeAnnotation[]{new TypeAnnotation()});

    // Assert
    assertNull(actualRuntimeVisibleTypeAnnotationsAttribute.getProcessingInfo());
    assertEquals(0, actualRuntimeVisibleTypeAnnotationsAttribute.getProcessingFlags());
  }
}
