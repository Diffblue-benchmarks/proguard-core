package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class EnclosingMethodAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link EnclosingMethodAttribute#EnclosingMethodAttribute()}
   */
  @Test
  public void testNewEnclosingMethodAttribute() {
    // Arrange and Act
    EnclosingMethodAttribute actualEnclosingMethodAttribute = new EnclosingMethodAttribute();

    // Assert
    assertNull(actualEnclosingMethodAttribute.getProcessingInfo());
    assertEquals(0, actualEnclosingMethodAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link EnclosingMethodAttribute#EnclosingMethodAttribute(int, int, int)}
   */
  @Test
  public void testNewEnclosingMethodAttribute2() {
    // Arrange and Act
    EnclosingMethodAttribute actualEnclosingMethodAttribute = new EnclosingMethodAttribute(1, 1, 1);

    // Assert
    assertNull(actualEnclosingMethodAttribute.getProcessingInfo());
    assertEquals(0, actualEnclosingMethodAttribute.getProcessingFlags());
  }
}
