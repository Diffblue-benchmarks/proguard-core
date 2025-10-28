package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class SourceDebugExtensionAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link SourceDebugExtensionAttribute#SourceDebugExtensionAttribute()}
   */
  @Test
  public void testNewSourceDebugExtensionAttribute() {
    // Arrange and Act
    SourceDebugExtensionAttribute actualSourceDebugExtensionAttribute = new SourceDebugExtensionAttribute();

    // Assert
    assertNull(actualSourceDebugExtensionAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDebugExtensionAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link SourceDebugExtensionAttribute#SourceDebugExtensionAttribute(int, int, byte[])}
   */
  @Test
  public void testNewSourceDebugExtensionAttribute2() throws UnsupportedEncodingException {
    // Arrange and Act
    SourceDebugExtensionAttribute actualSourceDebugExtensionAttribute = new SourceDebugExtensionAttribute(1, 3,
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualSourceDebugExtensionAttribute.getProcessingInfo());
    assertEquals(0, actualSourceDebugExtensionAttribute.getProcessingFlags());
  }
}
