package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.kotlin.flags.KotlinValueParameterFlags;

public class KotlinValueParameterMetadataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link KotlinValueParameterMetadata#KotlinValueParameterMetadata(KotlinValueParameterFlags, int, String)}
   *   <li>{@link KotlinValueParameterMetadata#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;

    // Act
    KotlinValueParameterMetadata actualKotlinValueParameterMetadata = new KotlinValueParameterMetadata(flags, 1,
        "Parameter Name");

    // Assert
    assertEquals("Kotlin value parameter 'Parameter Name'", actualKotlinValueParameterMetadata.toString());
    assertNull(actualKotlinValueParameterMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinValueParameterMetadata.getProcessingFlags());
  }

  /**
   * Method under test: {@link KotlinValueParameterMetadata#isVarArg()}
   */
  @Test
  public void testIsVarArg() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;

    // Act and Assert
    assertFalse((new KotlinValueParameterMetadata(flags, 1, "Parameter Name")).isVarArg());
  }

  /**
   * Method under test: {@link KotlinValueParameterMetadata#isVarArg()}
   */
  @Test
  public void testIsVarArg2() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata = new KotlinValueParameterMetadata(flags, 1,
        "Parameter Name");
    kotlinValueParameterMetadata.varArgElementType = KotlinTypeMetadata.starProjection();

    // Act and Assert
    assertTrue(kotlinValueParameterMetadata.isVarArg());
  }
}
