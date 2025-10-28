package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MethodParametersAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link MethodParametersAttribute#MethodParametersAttribute()}
   */
  @Test
  public void testNewMethodParametersAttribute() {
    // Arrange and Act
    MethodParametersAttribute actualMethodParametersAttribute = new MethodParametersAttribute();

    // Assert
    assertNull(actualMethodParametersAttribute.getProcessingInfo());
    assertEquals(0, actualMethodParametersAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link MethodParametersAttribute#MethodParametersAttribute(int, int, ParameterInfo[])}
   */
  @Test
  public void testNewMethodParametersAttribute2() {
    // Arrange and Act
    MethodParametersAttribute actualMethodParametersAttribute = new MethodParametersAttribute(1, 3,
        new ParameterInfo[]{new ParameterInfo(1, 1)});

    // Assert
    assertNull(actualMethodParametersAttribute.getProcessingInfo());
    assertEquals(0, actualMethodParametersAttribute.getProcessingFlags());
  }
}
