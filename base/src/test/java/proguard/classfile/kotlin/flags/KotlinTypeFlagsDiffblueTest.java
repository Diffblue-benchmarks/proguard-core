package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinTypeFlagsDiffblueTest {
  /**
   * Test new {@link KotlinTypeFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinTypeFlags}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinTypeFlags.<init>()"})
  public void testNewKotlinTypeFlags() {
    // Arrange and Act
    KotlinTypeFlags actualKotlinTypeFlags = new KotlinTypeFlags();

    // Assert
    assertFalse(actualKotlinTypeFlags.isDefinitelyNonNull);
    assertFalse(actualKotlinTypeFlags.isNullable);
    assertFalse(actualKotlinTypeFlags.isSuspend);
  }
}
