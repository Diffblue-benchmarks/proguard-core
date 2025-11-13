package proguard.classfile.kotlin.flags;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinTypeFlagsDiffblueTest {
  /**
   * Test new {@link KotlinTypeFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinTypeFlags}
   */
  @Test
  @DisplayName("Test new KotlinTypeFlags (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KotlinTypeFlags.<init>()"})
  void testNewKotlinTypeFlags() {
    // Arrange and Act
    KotlinTypeFlags actualKotlinTypeFlags = new KotlinTypeFlags();

    // Assert
    assertFalse(actualKotlinTypeFlags.isDefinitelyNonNull);
    assertFalse(actualKotlinTypeFlags.isNullable);
    assertFalse(actualKotlinTypeFlags.isSuspend);
  }
}
