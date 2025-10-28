package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ExceptionsAttributeDiffblueTest {
  /**
   * Method under test: {@link ExceptionsAttribute#ExceptionsAttribute()}
   */
  @Test
  public void testNewExceptionsAttribute() {
    // Arrange and Act
    ExceptionsAttribute actualExceptionsAttribute = new ExceptionsAttribute();

    // Assert
    assertNull(actualExceptionsAttribute.getProcessingInfo());
    assertEquals(0, actualExceptionsAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link ExceptionsAttribute#ExceptionsAttribute(int, int, int[])}
   */
  @Test
  public void testNewExceptionsAttribute2() {
    // Arrange and Act
    ExceptionsAttribute actualExceptionsAttribute = new ExceptionsAttribute(1, 3, new int[]{1, 0, 1, 0});

    // Assert
    assertNull(actualExceptionsAttribute.getProcessingInfo());
    assertEquals(0, actualExceptionsAttribute.getProcessingFlags());
  }
}
