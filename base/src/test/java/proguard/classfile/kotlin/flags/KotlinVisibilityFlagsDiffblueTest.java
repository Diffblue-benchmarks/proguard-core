package proguard.classfile.kotlin.flags;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinVisibilityFlagsDiffblueTest {
  /**
   * Test new {@link KotlinVisibilityFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinVisibilityFlags}
   */
  @Test
  @DisplayName("Test new KotlinVisibilityFlags (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.kotlin.flags.KotlinVisibilityFlags.<init>()"})
  void testNewKotlinVisibilityFlags() {
    // Arrange and Act
    KotlinVisibilityFlags actualKotlinVisibilityFlags = new KotlinVisibilityFlags();

    // Assert
    assertFalse(actualKotlinVisibilityFlags.isInternal);
    assertFalse(actualKotlinVisibilityFlags.isLocal);
    assertFalse(actualKotlinVisibilityFlags.isPrivate);
    assertFalse(actualKotlinVisibilityFlags.isPrivateToThis);
    assertFalse(actualKotlinVisibilityFlags.isProtected);
    assertFalse(actualKotlinVisibilityFlags.isPublic);
  }
}
