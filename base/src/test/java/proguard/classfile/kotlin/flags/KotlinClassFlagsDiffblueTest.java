package proguard.classfile.kotlin.flags;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KotlinClassFlagsDiffblueTest {
  /**
   * Test {@link KotlinClassFlags#KotlinClassFlags(KotlinVisibilityFlags, KotlinModalityFlags)}.
   *
   * <p>Method under test: {@link KotlinClassFlags#KotlinClassFlags(KotlinVisibilityFlags,
   * KotlinModalityFlags)}
   */
  @Test
  @DisplayName("Test new KotlinClassFlags(KotlinVisibilityFlags, KotlinModalityFlags)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.flags.KotlinClassFlags.<init>(proguard.classfile.kotlin.flags.KotlinVisibilityFlags, proguard.classfile.kotlin.flags.KotlinModalityFlags)"
  })
  void testNewKotlinClassFlags() {
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
