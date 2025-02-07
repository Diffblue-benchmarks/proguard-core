package proguard.resources.kotlinmodule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinModuleDiffblueTest {
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
  @DisplayName(
      "Test new KotlinModule(String, long); when '.kotlin_module'; then return name is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.resources.kotlinmodule.KotlinModule.<init>(java.lang.String, long)"
  })
  void testNewKotlinModule_whenKotlinModule_thenReturnNameIsEmptyString() {
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
