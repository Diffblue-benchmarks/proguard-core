package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinTypeParameterFlagsDiffblueTest {
  /**
   * Test new {@link KotlinTypeParameterFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinTypeParameterFlags}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinTypeParameterFlags.<init>()"})
  public void testNewKotlinTypeParameterFlags() {
    // Arrange, Act and Assert
    assertFalse((new KotlinTypeParameterFlags()).isReified);
  }
}
