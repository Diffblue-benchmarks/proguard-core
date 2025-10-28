package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ModulePackagesAttributeDiffblueTest {
  /**
   * Method under test: {@link ModulePackagesAttribute#ModulePackagesAttribute()}
   */
  @Test
  public void testNewModulePackagesAttribute() {
    // Arrange and Act
    ModulePackagesAttribute actualModulePackagesAttribute = new ModulePackagesAttribute();

    // Assert
    assertNull(actualModulePackagesAttribute.getProcessingInfo());
    assertEquals(0, actualModulePackagesAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link ModulePackagesAttribute#ModulePackagesAttribute(int, int, int[])}
   */
  @Test
  public void testNewModulePackagesAttribute2() {
    // Arrange and Act
    ModulePackagesAttribute actualModulePackagesAttribute = new ModulePackagesAttribute(1, 3, new int[]{1, 0, 1, 0});

    // Assert
    assertNull(actualModulePackagesAttribute.getProcessingInfo());
    assertEquals(0, actualModulePackagesAttribute.getProcessingFlags());
  }
}
