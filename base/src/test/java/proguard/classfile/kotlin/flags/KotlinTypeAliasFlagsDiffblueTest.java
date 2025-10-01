package proguard.classfile.kotlin.flags;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinTypeAliasFlagsDiffblueTest {
  /**
   * Test {@link KotlinTypeAliasFlags#KotlinTypeAliasFlags(KotlinVisibilityFlags)}.
   *
   * <p>Method under test: {@link KotlinTypeAliasFlags#KotlinTypeAliasFlags(KotlinVisibilityFlags)}
   */
  @Test
  @DisplayName("Test new KotlinTypeAliasFlags(KotlinVisibilityFlags)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KotlinTypeAliasFlags.<init>(KotlinVisibilityFlags)"})
  void testNewKotlinTypeAliasFlags() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;

    // Act
    KotlinTypeAliasFlags actualKotlinTypeAliasFlags = new KotlinTypeAliasFlags(visibility);

    // Assert
    assertFalse(actualKotlinTypeAliasFlags.hasAnnotations);
    KotlinVisibilityFlags kotlinVisibilityFlags = actualKotlinTypeAliasFlags.visibility;
    assertTrue(kotlinVisibilityFlags.isInternal);
    assertTrue(kotlinVisibilityFlags.isLocal);
    assertTrue(kotlinVisibilityFlags.isPrivate);
    assertTrue(kotlinVisibilityFlags.isPrivateToThis);
    assertTrue(kotlinVisibilityFlags.isProtected);
    assertTrue(kotlinVisibilityFlags.isPublic);
  }
}
