package proguard.classfile.kotlin.flags;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinValueParameterFlagsDiffblueTest {
  /**
   * Test new {@link KotlinValueParameterFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinValueParameterFlags}
   */
  @Test
  @DisplayName("Test new KotlinValueParameterFlags (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.kotlin.flags.KotlinValueParameterFlags.<init>()"})
  void testNewKotlinValueParameterFlags() {
    // Arrange and Act
    KotlinValueParameterFlags actualKotlinValueParameterFlags = new KotlinValueParameterFlags();

    // Assert
    assertFalse(actualKotlinValueParameterFlags.hasAnnotations);
    assertFalse(actualKotlinValueParameterFlags.hasDefaultValue);
    assertFalse(actualKotlinValueParameterFlags.isCrossInline);
    assertFalse(actualKotlinValueParameterFlags.isNoInline);
  }
}
