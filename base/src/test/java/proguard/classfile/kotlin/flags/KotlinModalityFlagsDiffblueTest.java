package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinModalityFlagsDiffblueTest {
  /**
   * Test new {@link KotlinModalityFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinModalityFlags}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinModalityFlags.<init>()"})
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
