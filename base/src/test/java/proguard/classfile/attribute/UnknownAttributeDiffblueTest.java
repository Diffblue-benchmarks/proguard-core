package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class UnknownAttributeDiffblueTest {
  /**
   * Method under test: {@link UnknownAttribute#UnknownAttribute(int, int)}
   */
  @Test
  public void testNewUnknownAttribute() {
    // Arrange and Act
    UnknownAttribute actualUnknownAttribute = new UnknownAttribute(1, 3);

    // Assert
    assertNull(actualUnknownAttribute.getProcessingInfo());
    assertEquals(0, actualUnknownAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link UnknownAttribute#UnknownAttribute(int, int, byte[])}
   */
  @Test
  public void testNewUnknownAttribute2() throws UnsupportedEncodingException {
    // Arrange and Act
    UnknownAttribute actualUnknownAttribute = new UnknownAttribute(1, 3, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualUnknownAttribute.getProcessingInfo());
    assertEquals(0, actualUnknownAttribute.getProcessingFlags());
  }
}
