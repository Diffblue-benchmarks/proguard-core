package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinEffectExpressionFlagsDiffblueTest {
  /**
   * Test new {@link KotlinEffectExpressionFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * KotlinEffectExpressionFlags}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinEffectExpressionFlags.<init>()"})
  public void testNewKotlinEffectExpressionFlags() {
    // Arrange and Act
    KotlinEffectExpressionFlags actualKotlinEffectExpressionFlags =
        new KotlinEffectExpressionFlags();

    // Assert
    assertFalse(actualKotlinEffectExpressionFlags.isNegated);
    assertFalse(actualKotlinEffectExpressionFlags.isNullCheckPredicate);
  }
}
