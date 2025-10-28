package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class KotlinClassFlagsDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinClassFlags#KotlinClassFlags(KotlinVisibilityFlags, KotlinModalityFlags)}
   */
  @Test
  public void testNewKotlinClassFlags() {
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
    KotlinClassFlags actualKotlinClassFlags = new KotlinClassFlags(visibility, modality);

    // Assert
    assertFalse(actualKotlinClassFlags.hasAnnotations);
    assertFalse(actualKotlinClassFlags.hasMethodBodiesInInterface);
    assertFalse(actualKotlinClassFlags.isAnnotationClass);
    assertFalse(actualKotlinClassFlags.isCompanionObject);
    assertFalse(actualKotlinClassFlags.isCompiledInCompatibilityMode);
    assertFalse(actualKotlinClassFlags.isData);
    assertFalse(actualKotlinClassFlags.isEnumClass);
    assertFalse(actualKotlinClassFlags.isEnumEntry);
    assertFalse(actualKotlinClassFlags.isExpect);
    assertFalse(actualKotlinClassFlags.isExternal);
    assertFalse(actualKotlinClassFlags.isFun);
    assertFalse(actualKotlinClassFlags.isInner);
    assertFalse(actualKotlinClassFlags.isInterface);
    assertFalse(actualKotlinClassFlags.isObject);
    assertFalse(actualKotlinClassFlags.isUsualClass);
    assertFalse(actualKotlinClassFlags.isValue);
    KotlinModalityFlags kotlinModalityFlags = actualKotlinClassFlags.modality;
    assertTrue(kotlinModalityFlags.isAbstract);
    assertTrue(kotlinModalityFlags.isFinal);
    assertTrue(kotlinModalityFlags.isOpen);
    assertTrue(kotlinModalityFlags.isSealed);
    KotlinVisibilityFlags kotlinVisibilityFlags = actualKotlinClassFlags.visibility;
    assertTrue(kotlinVisibilityFlags.isInternal);
    assertTrue(kotlinVisibilityFlags.isLocal);
    assertTrue(kotlinVisibilityFlags.isPrivate);
    assertTrue(kotlinVisibilityFlags.isPrivateToThis);
    assertTrue(kotlinVisibilityFlags.isProtected);
    assertTrue(kotlinVisibilityFlags.isPublic);
  }
}
