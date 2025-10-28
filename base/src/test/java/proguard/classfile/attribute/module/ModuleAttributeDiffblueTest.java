package proguard.classfile.attribute.module;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ModuleAttributeDiffblueTest {
  /**
   * Method under test: {@link ModuleAttribute#ModuleAttribute()}
   */
  @Test
  public void testNewModuleAttribute() {
    // Arrange and Act
    ModuleAttribute actualModuleAttribute = new ModuleAttribute();

    // Assert
    assertNull(actualModuleAttribute.getProcessingInfo());
    assertEquals(0, actualModuleAttribute.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link ModuleAttribute#ModuleAttribute(int, int, int, int, int, RequiresInfo[], int, ExportsInfo[], int, OpensInfo[], int, int[], int, ProvidesInfo[])}
   */
  @Test
  public void testNewModuleAttribute2() {
    // Arrange and Act
    ModuleAttribute actualModuleAttribute = new ModuleAttribute(1, 1, 1, 1, 3,
        new RequiresInfo[]{new RequiresInfo(1, 1, 1)}, 3, new ExportsInfo[]{new ExportsInfo()}, 3,
        new OpensInfo[]{new OpensInfo()}, 3, new int[]{1, 0, 1, 0}, 1, new ProvidesInfo[]{new ProvidesInfo()});

    // Assert
    assertNull(actualModuleAttribute.getProcessingInfo());
    assertEquals(0, actualModuleAttribute.getProcessingFlags());
  }
}
