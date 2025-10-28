package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ConstantValueAttributeDiffblueTest {
  /**
   * Method under test: {@link ConstantValueAttribute#ConstantValueAttribute()}
   */
  @Test
  public void testNewConstantValueAttribute() {
    // Arrange and Act
    ConstantValueAttribute actualConstantValueAttribute = new ConstantValueAttribute();

    // Assert
    assertNull(actualConstantValueAttribute.getProcessingInfo());
    assertEquals(0, actualConstantValueAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link ConstantValueAttribute#ConstantValueAttribute(int, int)}
   */
  @Test
  public void testNewConstantValueAttribute2() {
    // Arrange and Act
    ConstantValueAttribute actualConstantValueAttribute = new ConstantValueAttribute(1, 1);

    // Assert
    assertNull(actualConstantValueAttribute.getProcessingInfo());
    assertEquals(0, actualConstantValueAttribute.getProcessingFlags());
  }
}
