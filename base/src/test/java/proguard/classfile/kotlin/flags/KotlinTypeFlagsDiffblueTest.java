package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class KotlinTypeFlagsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link KotlinTypeFlags}
   */
  @Test
  public void testNewKotlinTypeFlags() {
    // Arrange and Act
    KotlinTypeFlags actualKotlinTypeFlags = new KotlinTypeFlags();

    // Assert
    assertFalse(actualKotlinTypeFlags.isDefinitelyNonNull);
    assertFalse(actualKotlinTypeFlags.isNullable);
    assertFalse(actualKotlinTypeFlags.isSuspend);
  }
}
