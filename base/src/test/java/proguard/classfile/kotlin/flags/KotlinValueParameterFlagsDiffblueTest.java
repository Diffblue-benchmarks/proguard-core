package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class KotlinValueParameterFlagsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link KotlinValueParameterFlags}
   */
  @Test
  public void testNewKotlinValueParameterFlags() {
    // Arrange and Act
    KotlinValueParameterFlags actualKotlinValueParameterFlags = new KotlinValueParameterFlags();

    // Assert
    assertFalse(actualKotlinValueParameterFlags.hasAnnotations);
    assertFalse(actualKotlinValueParameterFlags.hasDefaultValue);
    assertFalse(actualKotlinValueParameterFlags.isCrossInline);
    assertFalse(actualKotlinValueParameterFlags.isNoInline);
  }
}
