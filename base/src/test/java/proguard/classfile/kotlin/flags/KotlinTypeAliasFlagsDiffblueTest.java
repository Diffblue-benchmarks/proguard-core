package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class KotlinTypeAliasFlagsDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinTypeAliasFlags#KotlinTypeAliasFlags(KotlinVisibilityFlags)}
   */
  @Test
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
