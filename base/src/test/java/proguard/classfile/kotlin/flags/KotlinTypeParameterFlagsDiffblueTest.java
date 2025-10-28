package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class KotlinTypeParameterFlagsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link KotlinTypeParameterFlags}
   */
  @Test
  public void testNewKotlinTypeParameterFlags() {
    // Arrange, Act and Assert
    assertFalse((new KotlinTypeParameterFlags()).isReified);
  }
}
