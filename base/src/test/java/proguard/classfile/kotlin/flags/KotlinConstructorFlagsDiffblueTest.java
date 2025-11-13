package proguard.classfile.kotlin.flags;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinConstructorFlagsDiffblueTest {
  /**
   * Test {@link KotlinConstructorFlags#KotlinConstructorFlags(KotlinVisibilityFlags)}.
   *
   * <p>Method under test: {@link
   * KotlinConstructorFlags#KotlinConstructorFlags(KotlinVisibilityFlags)}
   */
  @Test
  @DisplayName("Test new KotlinConstructorFlags(KotlinVisibilityFlags)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KotlinConstructorFlags.<init>(KotlinVisibilityFlags)"})
  void testNewKotlinConstructorFlags() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;

    // Act
    KotlinConstructorFlags actualKotlinConstructorFlags = new KotlinConstructorFlags(visibility);

    // Assert
    assertFalse(actualKotlinConstructorFlags.hasAnnotations);
    assertFalse(actualKotlinConstructorFlags.hasNonStableParameterNames);
    assertFalse(actualKotlinConstructorFlags.isSecondary);
    KotlinVisibilityFlags kotlinVisibilityFlags = actualKotlinConstructorFlags.visibility;
    assertTrue(kotlinVisibilityFlags.isInternal);
    assertTrue(kotlinVisibilityFlags.isLocal);
    assertTrue(kotlinVisibilityFlags.isPrivate);
    assertTrue(kotlinVisibilityFlags.isPrivateToThis);
    assertTrue(kotlinVisibilityFlags.isProtected);
    assertTrue(kotlinVisibilityFlags.isPublic);
  }
}
