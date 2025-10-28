package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.kotlin.flags.KotlinClassFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;

public class KotlinClassKindMetadataDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinClassKindMetadata#KotlinClassKindMetadata(int[], int, String, String)}
   */
  @Test
  public void testNewKotlinClassKindMetadata() {
    // Arrange and Act
    KotlinClassKindMetadata actualKotlinClassKindMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1,
        "Xs", "Pn");

    // Assert
    assertNull(actualKotlinClassKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinClassKindMetadata.getProcessingFlags());
  }

  /**
   * Method under test: {@link KotlinClassKindMetadata#toString()}
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
    KotlinClassFlags kotlinClassFlags = new KotlinClassFlags(visibility, modality);

    kotlinClassFlags.isUsualClass = false;
    kotlinClassFlags.isInterface = false;
    kotlinClassFlags.isObject = false;
    kotlinClassFlags.isData = false;
    kotlinClassFlags.isCompanionObject = false;
    kotlinClassFlags.isEnumEntry = false;
    KotlinClassKindMetadata kotlinClassKindMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs",
        "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Method under test: {@link KotlinClassKindMetadata#toString()}
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
    KotlinModalityFlags modality = new KotlinModalityFlags();
    modality.isAbstract = true;
    modality.isFinal = true;
    modality.isOpen = true;
    modality.isSealed = true;
    KotlinClassFlags kotlinClassFlags = new KotlinClassFlags(visibility, modality);

    kotlinClassFlags.isUsualClass = false;
    kotlinClassFlags.isInterface = false;
    kotlinClassFlags.isObject = false;
    kotlinClassFlags.isData = false;
    kotlinClassFlags.isCompanionObject = false;
    kotlinClassFlags.isEnumEntry = false;
    KotlinClassKindMetadata kotlinClassKindMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs",
        "Pn");
    kotlinClassKindMetadata.companionObjectName = "foo";
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin accompanied class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  public void testToString3() {
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
    KotlinClassFlags kotlinClassFlags = new KotlinClassFlags(visibility, modality);

    kotlinClassFlags.isUsualClass = true;
    kotlinClassFlags.isInterface = false;
    kotlinClassFlags.isObject = false;
    kotlinClassFlags.isData = false;
    kotlinClassFlags.isCompanionObject = false;
    kotlinClassFlags.isEnumEntry = false;
    KotlinClassKindMetadata kotlinClassKindMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs",
        "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin usual class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  public void testToString4() {
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
    KotlinClassFlags kotlinClassFlags = new KotlinClassFlags(visibility, modality);

    kotlinClassFlags.isUsualClass = false;
    kotlinClassFlags.isInterface = true;
    kotlinClassFlags.isObject = false;
    kotlinClassFlags.isData = false;
    kotlinClassFlags.isCompanionObject = false;
    kotlinClassFlags.isEnumEntry = false;
    KotlinClassKindMetadata kotlinClassKindMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs",
        "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin interface class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  public void testToString5() {
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
    KotlinClassFlags kotlinClassFlags = new KotlinClassFlags(visibility, modality);

    kotlinClassFlags.isUsualClass = false;
    kotlinClassFlags.isInterface = false;
    kotlinClassFlags.isObject = true;
    kotlinClassFlags.isData = false;
    kotlinClassFlags.isCompanionObject = false;
    kotlinClassFlags.isEnumEntry = false;
    KotlinClassKindMetadata kotlinClassKindMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs",
        "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin object class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  public void testToString6() {
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
    KotlinClassFlags kotlinClassFlags = new KotlinClassFlags(visibility, modality);

    kotlinClassFlags.isUsualClass = false;
    kotlinClassFlags.isInterface = false;
    kotlinClassFlags.isObject = false;
    kotlinClassFlags.isData = true;
    kotlinClassFlags.isCompanionObject = false;
    kotlinClassFlags.isEnumEntry = false;
    KotlinClassKindMetadata kotlinClassKindMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs",
        "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin data data class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  public void testToString7() {
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
    KotlinClassFlags kotlinClassFlags = new KotlinClassFlags(visibility, modality);

    kotlinClassFlags.isUsualClass = false;
    kotlinClassFlags.isInterface = false;
    kotlinClassFlags.isObject = false;
    kotlinClassFlags.isData = false;
    kotlinClassFlags.isCompanionObject = true;
    kotlinClassFlags.isEnumEntry = false;
    KotlinClassKindMetadata kotlinClassKindMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs",
        "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin companion object class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  public void testToString8() {
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
    KotlinClassFlags kotlinClassFlags = new KotlinClassFlags(visibility, modality);

    kotlinClassFlags.isUsualClass = false;
    kotlinClassFlags.isInterface = false;
    kotlinClassFlags.isObject = false;
    kotlinClassFlags.isData = false;
    kotlinClassFlags.isCompanionObject = false;
    kotlinClassFlags.isEnumEntry = true;
    KotlinClassKindMetadata kotlinClassKindMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs",
        "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin enum entry class(null)", kotlinClassKindMetadata.toString());
  }
}
