package proguard.classfile.kotlin.flags;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinEffectExpressionFlagsDiffblueTest {
  /**
   * Test new {@link KotlinEffectExpressionFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * KotlinEffectExpressionFlags}
   */
  @Test
  @DisplayName("Test new KotlinEffectExpressionFlags (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KotlinEffectExpressionFlags.<init>()"})
  void testNewKotlinEffectExpressionFlags() {
    // Arrange and Act
    KotlinEffectExpressionFlags actualKotlinEffectExpressionFlags =
        new KotlinEffectExpressionFlags();

    // Assert
    assertFalse(actualKotlinEffectExpressionFlags.isNegated);
    assertFalse(actualKotlinEffectExpressionFlags.isNullCheckPredicate);
  }
}
