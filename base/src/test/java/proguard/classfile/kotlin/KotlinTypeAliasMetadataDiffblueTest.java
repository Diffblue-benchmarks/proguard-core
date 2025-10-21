package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.flags.KotlinTypeAliasFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;

public class KotlinTypeAliasMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinTypeAliasMetadata#KotlinTypeAliasMetadata(KotlinTypeAliasFlags, String)}
   *   <li>{@link KotlinTypeAliasMetadata#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinTypeAliasMetadata.<init>(KotlinTypeAliasFlags, String)",
    "String KotlinTypeAliasMetadata.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;

    // Act
    KotlinTypeAliasMetadata actualKotlinTypeAliasMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");

    // Assert
    assertEquals("Kotlin type alias (Name)", actualKotlinTypeAliasMetadata.toString());
    assertNull(actualKotlinTypeAliasMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinTypeAliasMetadata.getProcessingFlags());
  }
}
