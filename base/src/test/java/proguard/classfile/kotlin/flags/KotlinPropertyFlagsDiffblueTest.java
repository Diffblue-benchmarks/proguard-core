package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class KotlinPropertyFlagsDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinPropertyFlags#KotlinPropertyFlags(KotlinVisibilityFlags, KotlinModalityFlags)}
   */
  @Test
  public void testNewKotlinPropertyFlags() {
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
