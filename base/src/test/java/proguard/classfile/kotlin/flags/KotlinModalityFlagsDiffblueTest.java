package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class KotlinModalityFlagsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link KotlinModalityFlags}
   */
  @Test
  public void testNewKotlinModalityFlags() {
    // Arrange and Act
    KotlinModalityFlags actualKotlinModalityFlags = new KotlinModalityFlags();

    // Assert
    assertFalse(actualKotlinModalityFlags.isAbstract);
    assertFalse(actualKotlinModalityFlags.isFinal);
    assertFalse(actualKotlinModalityFlags.isOpen);
    assertFalse(actualKotlinModalityFlags.isSealed);
  }
}
