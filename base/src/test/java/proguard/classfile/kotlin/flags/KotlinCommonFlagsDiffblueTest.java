package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class KotlinCommonFlagsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link KotlinCommonFlags}
   */
  @Test
  public void testNewKotlinCommonFlags() {
    // Arrange, Act and Assert
    assertFalse((new KotlinCommonFlags()).hasAnnotations);
  }
}
