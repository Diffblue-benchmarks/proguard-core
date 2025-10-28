package proguard.resources.kotlinmodule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class KotlinModuleDiffblueTest {
  /**
   * Method under test: {@link KotlinModule#KotlinModule(String, long)}
   */
  @Test
  public void testNewKotlinModule() {
    // Arrange and Act
    KotlinModule actualKotlinModule = new KotlinModule(".kotlin_module", 3L);

    // Assert
    assertEquals("", actualKotlinModule.name);
    assertEquals(".kotlin_module", actualKotlinModule.getFileName());
    assertNull(actualKotlinModule.getProcessingInfo());
    assertNull(actualKotlinModule.getFeatureName());
    assertNull(actualKotlinModule.version);
    assertEquals(0, actualKotlinModule.getProcessingFlags());
    assertEquals(3L, actualKotlinModule.getFileSize());
    assertTrue(actualKotlinModule.modulePackages.isEmpty());
    assertTrue(actualKotlinModule.getExtraFeatureNames().isEmpty());
    assertTrue(actualKotlinModule.references.isEmpty());
  }
}
