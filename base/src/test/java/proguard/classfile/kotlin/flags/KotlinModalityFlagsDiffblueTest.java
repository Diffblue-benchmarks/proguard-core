package proguard.classfile.kotlin.flags;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinModalityFlagsDiffblueTest {
  /**
   * Test new {@link KotlinModalityFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinModalityFlags}
   */
  @Test
  @DisplayName("Test new KotlinModalityFlags (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KotlinModalityFlags.<init>()"})
  void testNewKotlinModalityFlags() {
    // Arrange and Act
    KotlinModalityFlags actualKotlinModalityFlags = new KotlinModalityFlags();

    // Assert
    assertFalse(actualKotlinModalityFlags.isAbstract);
    assertFalse(actualKotlinModalityFlags.isFinal);
    assertFalse(actualKotlinModalityFlags.isOpen);
    assertFalse(actualKotlinModalityFlags.isSealed);
  }
}
