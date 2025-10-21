package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinPropertyAccessorFlagsDiffblueTest {
  /**
   * Test {@link KotlinPropertyAccessorFlags#KotlinPropertyAccessorFlags(KotlinVisibilityFlags,
   * KotlinModalityFlags)}.
   *
   * <p>Method under test: {@link
   * KotlinPropertyAccessorFlags#KotlinPropertyAccessorFlags(KotlinVisibilityFlags,
   * KotlinModalityFlags)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinPropertyAccessorFlags.<init>(KotlinVisibilityFlags, KotlinModalityFlags)"
  })
  public void testNewKotlinPropertyAccessorFlags() {
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
    KotlinPropertyAccessorFlags actualKotlinPropertyAccessorFlags =
        new KotlinPropertyAccessorFlags(visibility, modality);

    // Assert
    assertFalse(actualKotlinPropertyAccessorFlags.hasAnnotations);
    assertFalse(actualKotlinPropertyAccessorFlags.isDefault);
    assertFalse(actualKotlinPropertyAccessorFlags.isExternal);
    assertFalse(actualKotlinPropertyAccessorFlags.isInline);
    KotlinModalityFlags kotlinModalityFlags = actualKotlinPropertyAccessorFlags.modality;
    assertTrue(kotlinModalityFlags.isAbstract);
    assertTrue(kotlinModalityFlags.isFinal);
    assertTrue(kotlinModalityFlags.isOpen);
    assertTrue(kotlinModalityFlags.isSealed);
    KotlinVisibilityFlags kotlinVisibilityFlags = actualKotlinPropertyAccessorFlags.visibility;
    assertTrue(kotlinVisibilityFlags.isInternal);
    assertTrue(kotlinVisibilityFlags.isLocal);
    assertTrue(kotlinVisibilityFlags.isPrivate);
    assertTrue(kotlinVisibilityFlags.isPrivateToThis);
    assertTrue(kotlinVisibilityFlags.isProtected);
    assertTrue(kotlinVisibilityFlags.isPublic);
  }
}
