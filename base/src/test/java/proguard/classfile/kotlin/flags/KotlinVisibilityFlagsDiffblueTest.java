package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class KotlinVisibilityFlagsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link KotlinVisibilityFlags}
   */
  @Test
  public void testNewKotlinVisibilityFlags() {
    // Arrange and Act
    KotlinVisibilityFlags actualKotlinVisibilityFlags = new KotlinVisibilityFlags();

    // Assert
    assertFalse(actualKotlinVisibilityFlags.isInternal);
    assertFalse(actualKotlinVisibilityFlags.isLocal);
    assertFalse(actualKotlinVisibilityFlags.isPrivate);
    assertFalse(actualKotlinVisibilityFlags.isPrivateToThis);
    assertFalse(actualKotlinVisibilityFlags.isProtected);
    assertFalse(actualKotlinVisibilityFlags.isPublic);
  }
}
