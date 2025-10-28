package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ModuleMainClassAttributeDiffblueTest {
  /**
   * Method under test:
   * {@link ModuleMainClassAttribute#ModuleMainClassAttribute()}
   */
  @Test
  public void testNewModuleMainClassAttribute() {
    // Arrange and Act
    ModuleMainClassAttribute actualModuleMainClassAttribute = new ModuleMainClassAttribute();

    // Assert
    assertNull(actualModuleMainClassAttribute.getProcessingInfo());
    assertEquals(0, actualModuleMainClassAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link ModuleMainClassAttribute#ModuleMainClassAttribute(int, int)}
   */
  @Test
  public void testNewModuleMainClassAttribute2() {
    // Arrange and Act
    ModuleMainClassAttribute actualModuleMainClassAttribute = new ModuleMainClassAttribute(1, 1);

    // Assert
    assertNull(actualModuleMainClassAttribute.getProcessingInfo());
    assertEquals(0, actualModuleMainClassAttribute.getProcessingFlags());
  }
}
