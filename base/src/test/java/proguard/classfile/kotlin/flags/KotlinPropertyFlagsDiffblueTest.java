package proguard.classfile.kotlin.flags;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinPropertyFlagsDiffblueTest {
  /**
   * Test {@link KotlinPropertyFlags#KotlinPropertyFlags(KotlinVisibilityFlags,
   * KotlinModalityFlags)}.
   *
   * <p>Method under test: {@link KotlinPropertyFlags#KotlinPropertyFlags(KotlinVisibilityFlags,
   * KotlinModalityFlags)}
   */
  @Test
  @DisplayName("Test new KotlinPropertyFlags(KotlinVisibilityFlags, KotlinModalityFlags)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KotlinPropertyFlags.<init>(KotlinVisibilityFlags, KotlinModalityFlags)"})
  void testNewKotlinPropertyFlags() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinModalityFlags modality = new KotlinModalityFlags();
    modality.isAbstract = true;
    modality.isFinal = true;
    modality.isOpen = true;
    modality.isSealed = true;

    // Act
    KotlinPropertyFlags actualKotlinPropertyFlags = new KotlinPropertyFlags(visibility, modality);

    // Assert
    assertFalse(actualKotlinPropertyFlags.hasAnnotations);
    assertFalse(actualKotlinPropertyFlags.hasConstant);
    assertFalse(actualKotlinPropertyFlags.isConst);
    assertFalse(actualKotlinPropertyFlags.isDeclared);
    assertFalse(actualKotlinPropertyFlags.isDelegated);
    assertFalse(actualKotlinPropertyFlags.isDelegation);
    assertFalse(actualKotlinPropertyFlags.isExpect);
    assertFalse(actualKotlinPropertyFlags.isExternal);
    assertFalse(actualKotlinPropertyFlags.isFakeOverride);
    assertFalse(actualKotlinPropertyFlags.isLateinit);
    assertFalse(actualKotlinPropertyFlags.isMovedFromInterfaceCompanion);
    assertFalse(actualKotlinPropertyFlags.isSynthesized);
    assertFalse(actualKotlinPropertyFlags.isVar);
    KotlinModalityFlags kotlinModalityFlags = actualKotlinPropertyFlags.modality;
    assertTrue(kotlinModalityFlags.isAbstract);
    assertTrue(kotlinModalityFlags.isFinal);
    assertTrue(kotlinModalityFlags.isOpen);
    assertTrue(kotlinModalityFlags.isSealed);
    KotlinVisibilityFlags kotlinVisibilityFlags = actualKotlinPropertyFlags.visibility;
    assertTrue(kotlinVisibilityFlags.isInternal);
    assertTrue(kotlinVisibilityFlags.isLocal);
    assertTrue(kotlinVisibilityFlags.isPrivate);
    assertTrue(kotlinVisibilityFlags.isPrivateToThis);
    assertTrue(kotlinVisibilityFlags.isProtected);
    assertTrue(kotlinVisibilityFlags.isPublic);
  }
}
