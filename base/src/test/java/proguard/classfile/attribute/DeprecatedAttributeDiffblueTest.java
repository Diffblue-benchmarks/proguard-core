package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DeprecatedAttributeDiffblueTest {
  /**
   * Method under test: {@link DeprecatedAttribute#DeprecatedAttribute()}
   */
  @Test
  public void testNewDeprecatedAttribute() {
    // Arrange and Act
    DeprecatedAttribute actualDeprecatedAttribute = new DeprecatedAttribute();

    // Assert
    assertNull(actualDeprecatedAttribute.getProcessingInfo());
    assertEquals(0, actualDeprecatedAttribute.getProcessingFlags());
  }

  /**
   * Method under test: {@link DeprecatedAttribute#DeprecatedAttribute(int)}
   */
  @Test
  public void testNewDeprecatedAttribute2() {
    // Arrange and Act
    DeprecatedAttribute actualDeprecatedAttribute = new DeprecatedAttribute(1);

    // Assert
    assertNull(actualDeprecatedAttribute.getProcessingInfo());
    assertEquals(0, actualDeprecatedAttribute.getProcessingFlags());
  }
}
