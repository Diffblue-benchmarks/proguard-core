package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinConstructorFlagsDiffblueTest {
  /**
   * Test {@link KotlinConstructorFlags#KotlinConstructorFlags(KotlinVisibilityFlags)}.
   *
   * <p>Method under test: {@link
   * KotlinConstructorFlags#KotlinConstructorFlags(KotlinVisibilityFlags)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinConstructorFlags.<init>(KotlinVisibilityFlags)"})
  public void testNewKotlinConstructorFlags() {
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
