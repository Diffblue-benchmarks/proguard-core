package proguard.dexfile.converter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;

public class DexFixDiffblueTest {
  /**
   * Method under test: {@link DexFix#isPrimitiveZero(String, Object)}
   */
  @Test
  public void testIsPrimitiveZero() {
    // Arrange, Act and Assert
    assertFalse(DexFix.isPrimitiveZero("The characteristics of someone or something", Constant.Null));
    assertFalse(DexFix.isPrimitiveZero(null, null));
    assertFalse(DexFix.isPrimitiveZero(null, 0));
    assertFalse(DexFix.isPrimitiveZero("", Constant.Null));
    assertFalse(DexFix.isPrimitiveZero("Desc", 10.0d));
    assertTrue(DexFix.isPrimitiveZero("Desc", 0.0d));
  }
}
