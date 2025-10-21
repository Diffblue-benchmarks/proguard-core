package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.flags.KotlinValueParameterFlags;

public class KotlinValueParameterMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       KotlinValueParameterMetadata#KotlinValueParameterMetadata(KotlinValueParameterFlags, int,
   *       String)}
   *   <li>{@link KotlinValueParameterMetadata#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinValueParameterMetadata.<init>(KotlinValueParameterFlags, int, String)",
    "String KotlinValueParameterMetadata.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;

    // Act
    KotlinValueParameterMetadata actualKotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");

    // Assert
    assertEquals(
        "Kotlin value parameter 'Parameter Name'", actualKotlinValueParameterMetadata.toString());
    assertNull(actualKotlinValueParameterMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinValueParameterMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinValueParameterMetadata#isVarArg()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#isVarArg()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinValueParameterMetadata.isVarArg()"})
  public void testIsVarArg_thenReturnFalse() {
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
   * Test {@link KotlinValueParameterMetadata#isVarArg()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinValueParameterMetadata#isVarArg()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinValueParameterMetadata.isVarArg()"})
  public void testIsVarArg_thenReturnTrue() {
    // Arrange
    KotlinValueParameterFlags flags = new KotlinValueParameterFlags();
    flags.hasAnnotations = true;
    flags.hasDefaultValue = true;
    flags.isCrossInline = true;
    flags.isNoInline = true;
    KotlinValueParameterMetadata kotlinValueParameterMetadata =
        new KotlinValueParameterMetadata(flags, 1, "Parameter Name");
    kotlinValueParameterMetadata.varArgElementType = KotlinTypeMetadata.starProjection();

    // Act and Assert
    assertTrue(kotlinValueParameterMetadata.isVarArg());
  }
}
