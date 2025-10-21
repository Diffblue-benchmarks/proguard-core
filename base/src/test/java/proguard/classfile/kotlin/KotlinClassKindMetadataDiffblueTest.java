package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.flags.KotlinClassFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;

public class KotlinClassKindMetadataDiffblueTest {
  /**
   * Test {@link KotlinClassKindMetadata#KotlinClassKindMetadata(int[], int, String, String)}.
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#KotlinClassKindMetadata(int[], int,
   * String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinClassKindMetadata.<init>(int[], int, String, String)"})
  public void testNewKotlinClassKindMetadata() {
    // Arrange and Act
    KotlinClassKindMetadata actualKotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Assert
    assertNull(actualKotlinClassKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinClassKindMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinClassKindMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin accompanied class(null)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinClassKindMetadata.toString()"})
  public void testToString_thenReturnKotlinAccompaniedClassNull() {
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
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.companionObjectName = "foo";
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin accompanied class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Test {@link KotlinClassKindMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin class(null)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinClassKindMetadata.toString()"})
  public void testToString_thenReturnKotlinClassNull() {
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
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Test {@link KotlinClassKindMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin companion object class(null)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinClassKindMetadata.toString()"})
  public void testToString_thenReturnKotlinCompanionObjectClassNull() {
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
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin companion object class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Test {@link KotlinClassKindMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin data data class(null)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinClassKindMetadata.toString()"})
  public void testToString_thenReturnKotlinDataDataClassNull() {
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
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin data data class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Test {@link KotlinClassKindMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin enum entry class(null)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinClassKindMetadata.toString()"})
  public void testToString_thenReturnKotlinEnumEntryClassNull() {
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
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin enum entry class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Test {@link KotlinClassKindMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin interface class(null)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinClassKindMetadata.toString()"})
  public void testToString_thenReturnKotlinInterfaceClassNull() {
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
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin interface class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Test {@link KotlinClassKindMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin object class(null)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinClassKindMetadata.toString()"})
  public void testToString_thenReturnKotlinObjectClassNull() {
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
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin object class(null)", kotlinClassKindMetadata.toString());
  }

  /**
   * Test {@link KotlinClassKindMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin usual class(null)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinClassKindMetadata.toString()"})
  public void testToString_thenReturnKotlinUsualClassNull() {
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
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.companionObjectName = null;
    kotlinClassKindMetadata.flags = kotlinClassFlags;

    // Act and Assert
    assertEquals("Kotlin usual class(null)", kotlinClassKindMetadata.toString());
  }
}
