package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class BootstrapMethodsAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link BootstrapMethodsAttribute#BootstrapMethodsAttribute()}
   */
  @Test
  public void testNewBootstrapMethodsAttribute() {
    // Arrange and Act
    BootstrapMethodsAttribute actualBootstrapMethodsAttribute = new BootstrapMethodsAttribute();

    // Assert
    assertNull(actualBootstrapMethodsAttribute.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodsAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link BootstrapMethodsAttribute#BootstrapMethodsAttribute(int, int, BootstrapMethodInfo[])}
   */
  @Test
  public void testNewBootstrapMethodsAttribute2() {
    // Arrange and Act
    BootstrapMethodsAttribute actualBootstrapMethodsAttribute = new BootstrapMethodsAttribute(1, 3,
        new BootstrapMethodInfo[]{new BootstrapMethodInfo()});

    // Assert
    assertNull(actualBootstrapMethodsAttribute.getProcessingInfo());
    assertEquals(0, actualBootstrapMethodsAttribute.getProcessingFlags());
  }
}
