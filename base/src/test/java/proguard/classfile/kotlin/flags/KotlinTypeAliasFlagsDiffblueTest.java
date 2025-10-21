package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinTypeAliasFlagsDiffblueTest {
  /**
   * Test {@link KotlinTypeAliasFlags#KotlinTypeAliasFlags(KotlinVisibilityFlags)}.
   *
   * <p>Method under test: {@link KotlinTypeAliasFlags#KotlinTypeAliasFlags(KotlinVisibilityFlags)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinTypeAliasFlags.<init>(KotlinVisibilityFlags)"})
  public void testNewKotlinTypeAliasFlags() {
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
