package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.kotlin.flags.KotlinConstructorFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;

public class KotlinConstructorMetadataDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinConstructorMetadata#KotlinConstructorMetadata(KotlinConstructorFlags)}
   */
  @Test
  public void testNewKotlinConstructorMetadata() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;

    // Act
    KotlinConstructorMetadata actualKotlinConstructorMetadata = new KotlinConstructorMetadata(
        new KotlinConstructorFlags(visibility));

    // Assert
    assertNull(actualKotlinConstructorMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinConstructorMetadata.getProcessingFlags());
  }

  /**
   * Method under test: {@link KotlinConstructorMetadata#toString()}
   */
  @Test
  public void testToString() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;

    // Act and Assert
    assertEquals("Kotlin constructor",
        (new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility))).toString());
  }

  /**
   * Method under test: {@link KotlinConstructorMetadata#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinConstructorFlags flags = new KotlinConstructorFlags(visibility);
    KotlinVisibilityFlags visibility2 = new KotlinVisibilityFlags();
    visibility2.isInternal = true;
    visibility2.isLocal = true;
    visibility2.isPrivate = true;
    visibility2.isPrivateToThis = true;
    visibility2.isProtected = true;
    visibility2.isPublic = true;
    KotlinConstructorFlags kotlinConstructorFlags = new KotlinConstructorFlags(visibility2);
    kotlinConstructorFlags.isSecondary = true;
    KotlinConstructorMetadata kotlinConstructorMetadata = new KotlinConstructorMetadata(flags);
    kotlinConstructorMetadata.flags = kotlinConstructorFlags;

    // Act and Assert
    assertEquals("Kotlin secondary constructor", kotlinConstructorMetadata.toString());
  }
}
