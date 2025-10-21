package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinCommonFlagsDiffblueTest {
  /**
   * Test new {@link KotlinCommonFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinCommonFlags}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinCommonFlags.<init>()"})
  public void testNewKotlinCommonFlags() {
    // Arrange, Act and Assert
    assertFalse((new KotlinCommonFlags()).hasAnnotations);
  }
}
