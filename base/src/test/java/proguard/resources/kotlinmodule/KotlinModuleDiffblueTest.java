package proguard.resources.kotlinmodule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinModuleDiffblueTest {
  /**
   * Test {@link KotlinModule#KotlinModule(String, long)}.
   *
   * <ul>
   *   <li>When {@code .kotlin_module}.
   *   <li>Then return {@link KotlinModule#name} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link KotlinModule#KotlinModule(String, long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinModule.<init>(String, long)"})
  public void testNewKotlinModule_whenKotlinModule_thenReturnNameIsEmptyString() {
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
