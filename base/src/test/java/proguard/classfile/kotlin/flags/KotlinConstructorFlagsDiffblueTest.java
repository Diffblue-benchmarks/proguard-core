package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class KotlinConstructorFlagsDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinConstructorFlags#KotlinConstructorFlags(KotlinVisibilityFlags)}
   */
  @Test
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
