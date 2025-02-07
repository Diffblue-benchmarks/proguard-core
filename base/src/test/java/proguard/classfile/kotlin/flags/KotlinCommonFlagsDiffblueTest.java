package proguard.classfile.kotlin.flags;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinCommonFlagsDiffblueTest {
  /**
   * Test new {@link KotlinCommonFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinCommonFlags}
   */
  @Test
  @DisplayName("Test new KotlinCommonFlags (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.kotlin.flags.KotlinCommonFlags.<init>()"})
  void testNewKotlinCommonFlags() {
    // Arrange, Act and Assert
    assertFalse((new KotlinCommonFlags()).hasAnnotations);
  }
}
