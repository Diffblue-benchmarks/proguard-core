package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.flags.KotlinConstructorFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;

public class KotlinConstructorMetadataDiffblueTest {
  /**
   * Test {@link KotlinConstructorMetadata#KotlinConstructorMetadata(KotlinConstructorFlags)}.
   *
   * <p>Method under test: {@link
   * KotlinConstructorMetadata#KotlinConstructorMetadata(KotlinConstructorFlags)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinConstructorMetadata.<init>(KotlinConstructorFlags)"})
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
    KotlinConstructorMetadata actualKotlinConstructorMetadata =
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility));

    // Assert
    assertNull(actualKotlinConstructorMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinConstructorMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinConstructorMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin constructor}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstructorMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KotlinConstructorMetadata.toString()"})
  public void testToString_thenReturnKotlinConstructor() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;

    // Act and Assert
    assertEquals(
        "Kotlin constructor",
        (new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility))).toString());
  }

  /**
   * Test {@link KotlinConstructorMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin secondary constructor}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstructorMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String KotlinConstructorMetadata.toString()"})
  public void testToString_thenReturnKotlinSecondaryConstructor() {
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
