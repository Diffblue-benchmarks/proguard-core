package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinFunctionFlagsDiffblueTest {
  /**
   * Test {@link KotlinFunctionFlags#KotlinFunctionFlags(KotlinVisibilityFlags,
   * KotlinModalityFlags)}.
   *
   * <p>Method under test: {@link KotlinFunctionFlags#KotlinFunctionFlags(KotlinVisibilityFlags,
   * KotlinModalityFlags)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinFunctionFlags.<init>(KotlinVisibilityFlags, KotlinModalityFlags)"})
  public void testNewKotlinFunctionFlags() {
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
    KotlinFunctionFlags actualKotlinFunctionFlags = new KotlinFunctionFlags(visibility, modality);

    // Assert
    assertFalse(actualKotlinFunctionFlags.hasAnnotations);
    assertFalse(actualKotlinFunctionFlags.isDeclaration);
    assertFalse(actualKotlinFunctionFlags.isDelegation);
    assertFalse(actualKotlinFunctionFlags.isExpect);
    assertFalse(actualKotlinFunctionFlags.isExternal);
    assertFalse(actualKotlinFunctionFlags.isFakeOverride);
    assertFalse(actualKotlinFunctionFlags.isInfix);
    assertFalse(actualKotlinFunctionFlags.isInline);
    assertFalse(actualKotlinFunctionFlags.isOperator);
    assertFalse(actualKotlinFunctionFlags.isSuspend);
    assertFalse(actualKotlinFunctionFlags.isSynthesized);
    assertFalse(actualKotlinFunctionFlags.isTailrec);
    KotlinModalityFlags kotlinModalityFlags = actualKotlinFunctionFlags.modality;
    assertTrue(kotlinModalityFlags.isAbstract);
    assertTrue(kotlinModalityFlags.isFinal);
    assertTrue(kotlinModalityFlags.isOpen);
    assertTrue(kotlinModalityFlags.isSealed);
    KotlinVisibilityFlags kotlinVisibilityFlags = actualKotlinFunctionFlags.visibility;
    assertTrue(kotlinVisibilityFlags.isInternal);
    assertTrue(kotlinVisibilityFlags.isLocal);
    assertTrue(kotlinVisibilityFlags.isPrivate);
    assertTrue(kotlinVisibilityFlags.isPrivateToThis);
    assertTrue(kotlinVisibilityFlags.isProtected);
    assertTrue(kotlinVisibilityFlags.isPublic);
  }
}
