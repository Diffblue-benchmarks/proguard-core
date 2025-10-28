package proguard.classfile.util;

import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class ExternalTypeEnumerationDiffblueTest {
  /**
   * Method under test:
   * {@link ExternalTypeEnumeration#ExternalTypeEnumeration(String)}
   */
  @Test
  public void testNewExternalTypeEnumeration() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ExternalTypeEnumeration("Descriptor"));
  }

  /**
   * Method under test: {@link ExternalTypeEnumeration#setDescriptor(String)}
   */
  @Test
  public void testSetDescriptor() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ExternalTypeEnumeration()).setDescriptor("Descriptor"));
  }
}
