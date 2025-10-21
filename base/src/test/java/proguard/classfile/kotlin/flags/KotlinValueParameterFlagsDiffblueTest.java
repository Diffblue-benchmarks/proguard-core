package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinValueParameterFlagsDiffblueTest {
  /**
   * Test new {@link KotlinValueParameterFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinValueParameterFlags}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinValueParameterFlags.<init>()"})
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
