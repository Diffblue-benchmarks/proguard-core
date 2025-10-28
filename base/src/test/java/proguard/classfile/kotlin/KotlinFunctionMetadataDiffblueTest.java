package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;

public class KotlinFunctionMetadataDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinFunctionMetadata#KotlinFunctionMetadata(KotlinFunctionFlags, String)}
   */
  @Test
  public void testNewKotlinFunctionMetadata() {
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
    KotlinFunctionMetadata actualKotlinFunctionMetadata = new KotlinFunctionMetadata(
        new KotlinFunctionFlags(visibility, modality), "Name");

    // Assert
    assertNull(actualKotlinFunctionMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinFunctionMetadata.getProcessingFlags());
  }

  /**
   * Method under test: {@link KotlinFunctionMetadata#toString()}
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
    KotlinModalityFlags modality = new KotlinModalityFlags();
    modality.isAbstract = true;
    modality.isFinal = true;
    modality.isOpen = true;
    modality.isSealed = true;

    // Act and Assert
    assertEquals("Kotlin function(Name)",
        (new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name")).toString());
  }
}
