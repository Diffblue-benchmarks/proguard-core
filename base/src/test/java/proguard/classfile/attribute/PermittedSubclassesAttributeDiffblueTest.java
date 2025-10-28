package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PermittedSubclassesAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link PermittedSubclassesAttribute#PermittedSubclassesAttribute()}
   */
  @Test
  public void testNewPermittedSubclassesAttribute() {
    // Arrange and Act
    PermittedSubclassesAttribute actualPermittedSubclassesAttribute = new PermittedSubclassesAttribute();

    // Assert
    assertNull(actualPermittedSubclassesAttribute.getProcessingInfo());
    assertEquals(0, actualPermittedSubclassesAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link PermittedSubclassesAttribute#PermittedSubclassesAttribute(int, int, int[])}
   */
  @Test
  public void testNewPermittedSubclassesAttribute2() {
    // Arrange and Act
    PermittedSubclassesAttribute actualPermittedSubclassesAttribute = new PermittedSubclassesAttribute(1, 3,
        new int[]{1, 0, 1, 0});

    // Assert
    assertNull(actualPermittedSubclassesAttribute.getProcessingInfo());
    assertEquals(0, actualPermittedSubclassesAttribute.getProcessingFlags());
  }
}
