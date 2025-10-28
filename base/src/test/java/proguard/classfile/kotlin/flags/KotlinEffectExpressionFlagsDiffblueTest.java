package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class KotlinEffectExpressionFlagsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link KotlinEffectExpressionFlags}
   */
  @Test
  public void testNewKotlinEffectExpressionFlags() {
    // Arrange and Act
    KotlinEffectExpressionFlags actualKotlinEffectExpressionFlags = new KotlinEffectExpressionFlags();

    // Assert
    assertFalse(actualKotlinEffectExpressionFlags.isNegated);
    assertFalse(actualKotlinEffectExpressionFlags.isNullCheckPredicate);
  }
}
