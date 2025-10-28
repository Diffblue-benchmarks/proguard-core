package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.FieldSignature;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;

public class KotlinPropertyMetadataDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinPropertyMetadata#KotlinPropertyMetadata(KotlinPropertyFlags, String, KotlinPropertyAccessorFlags, KotlinPropertyAccessorFlags)}
   */
  @Test
  public void testNewKotlinPropertyMetadata() {
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
    KotlinPropertyFlags flags = new KotlinPropertyFlags(visibility, modality);

    KotlinVisibilityFlags visibility2 = new KotlinVisibilityFlags();
    visibility2.isInternal = true;
    visibility2.isLocal = true;
    visibility2.isPrivate = true;
    visibility2.isPrivateToThis = true;
    visibility2.isProtected = true;
    visibility2.isPublic = true;
    KotlinModalityFlags modality2 = new KotlinModalityFlags();
    modality2.isAbstract = true;
    modality2.isFinal = true;
    modality2.isOpen = true;
    modality2.isSealed = true;
    KotlinPropertyAccessorFlags getterFlags = new KotlinPropertyAccessorFlags(visibility2, modality2);

    KotlinVisibilityFlags visibility3 = new KotlinVisibilityFlags();
    visibility3.isInternal = true;
    visibility3.isLocal = true;
    visibility3.isPrivate = true;
    visibility3.isPrivateToThis = true;
    visibility3.isProtected = true;
    visibility3.isPublic = true;
    KotlinModalityFlags modality3 = new KotlinModalityFlags();
    modality3.isAbstract = true;
    modality3.isFinal = true;
    modality3.isOpen = true;
    modality3.isSealed = true;

    // Act
    KotlinPropertyMetadata actualKotlinPropertyMetadata = new KotlinPropertyMetadata(flags, "Name", getterFlags,
        new KotlinPropertyAccessorFlags(visibility3, modality3));

    // Assert
    assertNull(actualKotlinPropertyMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinPropertyMetadata.getProcessingFlags());
  }

  /**
   * Method under test: {@link KotlinPropertyMetadata#toString()}
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
    KotlinPropertyFlags flags = new KotlinPropertyFlags(visibility, modality);

    KotlinVisibilityFlags visibility2 = new KotlinVisibilityFlags();
    visibility2.isInternal = true;
    visibility2.isLocal = true;
    visibility2.isPrivate = true;
    visibility2.isPrivateToThis = true;
    visibility2.isProtected = true;
    visibility2.isPublic = true;
    KotlinModalityFlags modality2 = new KotlinModalityFlags();
    modality2.isAbstract = true;
    modality2.isFinal = true;
    modality2.isOpen = true;
    modality2.isSealed = true;
    KotlinPropertyAccessorFlags getterFlags = new KotlinPropertyAccessorFlags(visibility2, modality2);

    KotlinVisibilityFlags visibility3 = new KotlinVisibilityFlags();
    visibility3.isInternal = true;
    visibility3.isLocal = true;
    visibility3.isPrivate = true;
    visibility3.isPrivateToThis = true;
    visibility3.isProtected = true;
    visibility3.isPublic = true;
    KotlinModalityFlags modality3 = new KotlinModalityFlags();
    modality3.isAbstract = true;
    modality3.isFinal = true;
    modality3.isOpen = true;
    modality3.isSealed = true;

    // Act and Assert
    assertEquals("Kotlin property (Name | g+)", (new KotlinPropertyMetadata(flags, "Name", getterFlags,
        new KotlinPropertyAccessorFlags(visibility3, modality3))).toString());
  }

  /**
   * Method under test: {@link KotlinPropertyMetadata#toString()}
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
    KotlinPropertyFlags flags = new KotlinPropertyFlags(visibility, modality);

    KotlinVisibilityFlags visibility2 = new KotlinVisibilityFlags();
    visibility2.isInternal = true;
    visibility2.isLocal = true;
    visibility2.isPrivate = true;
    visibility2.isPrivateToThis = true;
    visibility2.isProtected = true;
    visibility2.isPublic = true;
    KotlinModalityFlags modality2 = new KotlinModalityFlags();
    modality2.isAbstract = true;
    modality2.isFinal = true;
    modality2.isOpen = true;
    modality2.isSealed = true;
    KotlinPropertyAccessorFlags getterFlags = new KotlinPropertyAccessorFlags(visibility2, modality2);

    KotlinVisibilityFlags visibility3 = new KotlinVisibilityFlags();
    visibility3.isInternal = true;
    visibility3.isLocal = true;
    visibility3.isPrivate = true;
    visibility3.isPrivateToThis = true;
    visibility3.isProtected = true;
    visibility3.isPublic = true;
    KotlinModalityFlags modality3 = new KotlinModalityFlags();
    modality3.isAbstract = true;
    modality3.isFinal = true;
    modality3.isOpen = true;
    modality3.isSealed = true;
    KotlinPropertyAccessorFlags setterFlags = new KotlinPropertyAccessorFlags(visibility3, modality3);

    KotlinVisibilityFlags visibility4 = new KotlinVisibilityFlags();
    visibility4.isInternal = true;
    visibility4.isLocal = true;
    visibility4.isPrivate = true;
    visibility4.isPrivateToThis = true;
    visibility4.isProtected = true;
    visibility4.isPublic = true;
    KotlinModalityFlags modality4 = new KotlinModalityFlags();
    modality4.isAbstract = true;
    modality4.isFinal = true;
    modality4.isOpen = true;
    modality4.isSealed = true;
    KotlinPropertyFlags kotlinPropertyFlags = new KotlinPropertyFlags(visibility4, modality4);

    kotlinPropertyFlags.isDelegated = false;
    kotlinPropertyFlags.isVar = false;
    KotlinVisibilityFlags visibility5 = new KotlinVisibilityFlags();
    visibility5.isInternal = true;
    visibility5.isLocal = true;
    visibility5.isPrivate = true;
    visibility5.isPrivateToThis = true;
    visibility5.isProtected = true;
    visibility5.isPublic = true;
    KotlinModalityFlags modality5 = new KotlinModalityFlags();
    modality5.isAbstract = true;
    modality5.isFinal = true;
    modality5.isOpen = true;
    modality5.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags = new KotlinPropertyAccessorFlags(visibility5, modality5);

    kotlinPropertyAccessorFlags.isDefault = false;
    KotlinVisibilityFlags visibility6 = new KotlinVisibilityFlags();
    visibility6.isInternal = true;
    visibility6.isLocal = true;
    visibility6.isPrivate = true;
    visibility6.isPrivateToThis = true;
    visibility6.isProtected = true;
    visibility6.isPublic = true;
    KotlinModalityFlags modality6 = new KotlinModalityFlags();
    modality6.isAbstract = true;
    modality6.isFinal = true;
    modality6.isOpen = true;
    modality6.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags2 = new KotlinPropertyAccessorFlags(visibility6, modality6);

    kotlinPropertyAccessorFlags2.isDefault = false;
    KotlinPropertyMetadata kotlinPropertyMetadata = new KotlinPropertyMetadata(flags, "Name", getterFlags, setterFlags);
    kotlinPropertyMetadata.flags = kotlinPropertyFlags;
    kotlinPropertyMetadata.backingFieldSignature = new FieldSignature("Clazz Name", "Member Name", "Descriptor");
    kotlinPropertyMetadata.getterFlags = kotlinPropertyAccessorFlags;
    kotlinPropertyMetadata.setterFlags = kotlinPropertyAccessorFlags2;

    // Act and Assert
    assertEquals("Kotlin property (Name | bg+)", kotlinPropertyMetadata.toString());
  }

  /**
   * Method under test: {@link KotlinPropertyMetadata#toString()}
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
    KotlinPropertyFlags flags = new KotlinPropertyFlags(visibility, modality);

    KotlinVisibilityFlags visibility2 = new KotlinVisibilityFlags();
    visibility2.isInternal = true;
    visibility2.isLocal = true;
    visibility2.isPrivate = true;
    visibility2.isPrivateToThis = true;
    visibility2.isProtected = true;
    visibility2.isPublic = true;
    KotlinModalityFlags modality2 = new KotlinModalityFlags();
    modality2.isAbstract = true;
    modality2.isFinal = true;
    modality2.isOpen = true;
    modality2.isSealed = true;
    KotlinPropertyAccessorFlags getterFlags = new KotlinPropertyAccessorFlags(visibility2, modality2);

    KotlinVisibilityFlags visibility3 = new KotlinVisibilityFlags();
    visibility3.isInternal = true;
    visibility3.isLocal = true;
    visibility3.isPrivate = true;
    visibility3.isPrivateToThis = true;
    visibility3.isProtected = true;
    visibility3.isPublic = true;
    KotlinModalityFlags modality3 = new KotlinModalityFlags();
    modality3.isAbstract = true;
    modality3.isFinal = true;
    modality3.isOpen = true;
    modality3.isSealed = true;
    KotlinPropertyAccessorFlags setterFlags = new KotlinPropertyAccessorFlags(visibility3, modality3);

    KotlinVisibilityFlags visibility4 = new KotlinVisibilityFlags();
    visibility4.isInternal = true;
    visibility4.isLocal = true;
    visibility4.isPrivate = true;
    visibility4.isPrivateToThis = true;
    visibility4.isProtected = true;
    visibility4.isPublic = true;
    KotlinModalityFlags modality4 = new KotlinModalityFlags();
    modality4.isAbstract = true;
    modality4.isFinal = true;
    modality4.isOpen = true;
    modality4.isSealed = true;
    KotlinPropertyFlags kotlinPropertyFlags = new KotlinPropertyFlags(visibility4, modality4);

    kotlinPropertyFlags.isDelegated = true;
    kotlinPropertyFlags.isVar = false;
    KotlinVisibilityFlags visibility5 = new KotlinVisibilityFlags();
    visibility5.isInternal = true;
    visibility5.isLocal = true;
    visibility5.isPrivate = true;
    visibility5.isPrivateToThis = true;
    visibility5.isProtected = true;
    visibility5.isPublic = true;
    KotlinModalityFlags modality5 = new KotlinModalityFlags();
    modality5.isAbstract = true;
    modality5.isFinal = true;
    modality5.isOpen = true;
    modality5.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags = new KotlinPropertyAccessorFlags(visibility5, modality5);

    kotlinPropertyAccessorFlags.isDefault = false;
    KotlinVisibilityFlags visibility6 = new KotlinVisibilityFlags();
    visibility6.isInternal = true;
    visibility6.isLocal = true;
    visibility6.isPrivate = true;
    visibility6.isPrivateToThis = true;
    visibility6.isProtected = true;
    visibility6.isPublic = true;
    KotlinModalityFlags modality6 = new KotlinModalityFlags();
    modality6.isAbstract = true;
    modality6.isFinal = true;
    modality6.isOpen = true;
    modality6.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags2 = new KotlinPropertyAccessorFlags(visibility6, modality6);

    kotlinPropertyAccessorFlags2.isDefault = false;
    KotlinPropertyMetadata kotlinPropertyMetadata = new KotlinPropertyMetadata(flags, "Name", getterFlags, setterFlags);
    kotlinPropertyMetadata.flags = kotlinPropertyFlags;
    kotlinPropertyMetadata.backingFieldSignature = new FieldSignature("Clazz Name", "Member Name", "Descriptor");
    kotlinPropertyMetadata.getterFlags = kotlinPropertyAccessorFlags;
    kotlinPropertyMetadata.setterFlags = kotlinPropertyAccessorFlags2;

    // Act and Assert
    assertEquals("Kotlin delegated property (Name | bg+)", kotlinPropertyMetadata.toString());
  }

  /**
   * Method under test: {@link KotlinPropertyMetadata#toString()}
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
    KotlinPropertyFlags flags = new KotlinPropertyFlags(visibility, modality);

    KotlinVisibilityFlags visibility2 = new KotlinVisibilityFlags();
    visibility2.isInternal = true;
    visibility2.isLocal = true;
    visibility2.isPrivate = true;
    visibility2.isPrivateToThis = true;
    visibility2.isProtected = true;
    visibility2.isPublic = true;
    KotlinModalityFlags modality2 = new KotlinModalityFlags();
    modality2.isAbstract = true;
    modality2.isFinal = true;
    modality2.isOpen = true;
    modality2.isSealed = true;
    KotlinPropertyAccessorFlags getterFlags = new KotlinPropertyAccessorFlags(visibility2, modality2);

    KotlinVisibilityFlags visibility3 = new KotlinVisibilityFlags();
    visibility3.isInternal = true;
    visibility3.isLocal = true;
    visibility3.isPrivate = true;
    visibility3.isPrivateToThis = true;
    visibility3.isProtected = true;
    visibility3.isPublic = true;
    KotlinModalityFlags modality3 = new KotlinModalityFlags();
    modality3.isAbstract = true;
    modality3.isFinal = true;
    modality3.isOpen = true;
    modality3.isSealed = true;
    KotlinPropertyAccessorFlags setterFlags = new KotlinPropertyAccessorFlags(visibility3, modality3);

    KotlinVisibilityFlags visibility4 = new KotlinVisibilityFlags();
    visibility4.isInternal = true;
    visibility4.isLocal = true;
    visibility4.isPrivate = true;
    visibility4.isPrivateToThis = true;
    visibility4.isProtected = true;
    visibility4.isPublic = true;
    KotlinModalityFlags modality4 = new KotlinModalityFlags();
    modality4.isAbstract = true;
    modality4.isFinal = true;
    modality4.isOpen = true;
    modality4.isSealed = true;
    KotlinPropertyFlags kotlinPropertyFlags = new KotlinPropertyFlags(visibility4, modality4);

    kotlinPropertyFlags.isDelegated = false;
    kotlinPropertyFlags.isVar = true;
    KotlinVisibilityFlags visibility5 = new KotlinVisibilityFlags();
    visibility5.isInternal = true;
    visibility5.isLocal = true;
    visibility5.isPrivate = true;
    visibility5.isPrivateToThis = true;
    visibility5.isProtected = true;
    visibility5.isPublic = true;
    KotlinModalityFlags modality5 = new KotlinModalityFlags();
    modality5.isAbstract = true;
    modality5.isFinal = true;
    modality5.isOpen = true;
    modality5.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags = new KotlinPropertyAccessorFlags(visibility5, modality5);

    kotlinPropertyAccessorFlags.isDefault = false;
    KotlinVisibilityFlags visibility6 = new KotlinVisibilityFlags();
    visibility6.isInternal = true;
    visibility6.isLocal = true;
    visibility6.isPrivate = true;
    visibility6.isPrivateToThis = true;
    visibility6.isProtected = true;
    visibility6.isPublic = true;
    KotlinModalityFlags modality6 = new KotlinModalityFlags();
    modality6.isAbstract = true;
    modality6.isFinal = true;
    modality6.isOpen = true;
    modality6.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags2 = new KotlinPropertyAccessorFlags(visibility6, modality6);

    kotlinPropertyAccessorFlags2.isDefault = false;
    KotlinPropertyMetadata kotlinPropertyMetadata = new KotlinPropertyMetadata(flags, "Name", getterFlags, setterFlags);
    kotlinPropertyMetadata.flags = kotlinPropertyFlags;
    kotlinPropertyMetadata.backingFieldSignature = new FieldSignature("Clazz Name", "Member Name", "Descriptor");
    kotlinPropertyMetadata.getterFlags = kotlinPropertyAccessorFlags;
    kotlinPropertyMetadata.setterFlags = kotlinPropertyAccessorFlags2;

    // Act and Assert
    assertEquals("Kotlin property (Name | bg+s+)", kotlinPropertyMetadata.toString());
  }

  /**
   * Method under test: {@link KotlinPropertyMetadata#toString()}
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
    KotlinPropertyFlags flags = new KotlinPropertyFlags(visibility, modality);

    KotlinVisibilityFlags visibility2 = new KotlinVisibilityFlags();
    visibility2.isInternal = true;
    visibility2.isLocal = true;
    visibility2.isPrivate = true;
    visibility2.isPrivateToThis = true;
    visibility2.isProtected = true;
    visibility2.isPublic = true;
    KotlinModalityFlags modality2 = new KotlinModalityFlags();
    modality2.isAbstract = true;
    modality2.isFinal = true;
    modality2.isOpen = true;
    modality2.isSealed = true;
    KotlinPropertyAccessorFlags getterFlags = new KotlinPropertyAccessorFlags(visibility2, modality2);

    KotlinVisibilityFlags visibility3 = new KotlinVisibilityFlags();
    visibility3.isInternal = true;
    visibility3.isLocal = true;
    visibility3.isPrivate = true;
    visibility3.isPrivateToThis = true;
    visibility3.isProtected = true;
    visibility3.isPublic = true;
    KotlinModalityFlags modality3 = new KotlinModalityFlags();
    modality3.isAbstract = true;
    modality3.isFinal = true;
    modality3.isOpen = true;
    modality3.isSealed = true;
    KotlinPropertyAccessorFlags setterFlags = new KotlinPropertyAccessorFlags(visibility3, modality3);

    KotlinVisibilityFlags visibility4 = new KotlinVisibilityFlags();
    visibility4.isInternal = true;
    visibility4.isLocal = true;
    visibility4.isPrivate = true;
    visibility4.isPrivateToThis = true;
    visibility4.isProtected = true;
    visibility4.isPublic = true;
    KotlinModalityFlags modality4 = new KotlinModalityFlags();
    modality4.isAbstract = true;
    modality4.isFinal = true;
    modality4.isOpen = true;
    modality4.isSealed = true;
    KotlinPropertyFlags kotlinPropertyFlags = new KotlinPropertyFlags(visibility4, modality4);

    kotlinPropertyFlags.isDelegated = false;
    kotlinPropertyFlags.isVar = false;
    KotlinVisibilityFlags visibility5 = new KotlinVisibilityFlags();
    visibility5.isInternal = true;
    visibility5.isLocal = true;
    visibility5.isPrivate = true;
    visibility5.isPrivateToThis = true;
    visibility5.isProtected = true;
    visibility5.isPublic = true;
    KotlinModalityFlags modality5 = new KotlinModalityFlags();
    modality5.isAbstract = true;
    modality5.isFinal = true;
    modality5.isOpen = true;
    modality5.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags = new KotlinPropertyAccessorFlags(visibility5, modality5);

    kotlinPropertyAccessorFlags.isDefault = true;
    KotlinVisibilityFlags visibility6 = new KotlinVisibilityFlags();
    visibility6.isInternal = true;
    visibility6.isLocal = true;
    visibility6.isPrivate = true;
    visibility6.isPrivateToThis = true;
    visibility6.isProtected = true;
    visibility6.isPublic = true;
    KotlinModalityFlags modality6 = new KotlinModalityFlags();
    modality6.isAbstract = true;
    modality6.isFinal = true;
    modality6.isOpen = true;
    modality6.isSealed = true;
    KotlinPropertyAccessorFlags kotlinPropertyAccessorFlags2 = new KotlinPropertyAccessorFlags(visibility6, modality6);

    kotlinPropertyAccessorFlags2.isDefault = false;
    KotlinPropertyMetadata kotlinPropertyMetadata = new KotlinPropertyMetadata(flags, "Name", getterFlags, setterFlags);
    kotlinPropertyMetadata.flags = kotlinPropertyFlags;
    kotlinPropertyMetadata.backingFieldSignature = new FieldSignature("Clazz Name", "Member Name", "Descriptor");
    kotlinPropertyMetadata.getterFlags = kotlinPropertyAccessorFlags;
    kotlinPropertyMetadata.setterFlags = kotlinPropertyAccessorFlags2;

    // Act and Assert
    assertEquals("Kotlin property (Name | bg)", kotlinPropertyMetadata.toString());
  }
}
