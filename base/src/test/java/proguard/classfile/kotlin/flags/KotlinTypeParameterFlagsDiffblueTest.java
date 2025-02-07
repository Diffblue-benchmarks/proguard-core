package proguard.classfile.kotlin.flags;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinTypeParameterFlagsDiffblueTest {
  /**
   * Test new {@link KotlinTypeParameterFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinTypeParameterFlags}
   */
  @Test
  @DisplayName("Test new KotlinTypeParameterFlags (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.kotlin.flags.KotlinTypeParameterFlags.<init>()"})
  void testNewKotlinTypeParameterFlags() {
    // Arrange, Act and Assert
    assertFalse((new KotlinTypeParameterFlags()).isReified);
  }
}
