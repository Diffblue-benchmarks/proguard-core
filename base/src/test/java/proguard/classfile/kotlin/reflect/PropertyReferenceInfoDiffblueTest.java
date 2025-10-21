package proguard.classfile.kotlin.reflect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinDeclarationContainerMetadata;
import proguard.classfile.kotlin.KotlinPropertyMetadata;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;

public class PropertyReferenceInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PropertyReferenceInfo#PropertyReferenceInfo(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinPropertyMetadata)}
   *   <li>{@link PropertyReferenceInfo#getOwner()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void PropertyReferenceInfo.<init>(Clazz, KotlinDeclarationContainerMetadata, KotlinPropertyMetadata)",
    "KotlinDeclarationContainerMetadata PropertyReferenceInfo.getOwner()"
  })
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    KotlinClassKindMetadata ownerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

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
    KotlinPropertyAccessorFlags getterFlags =
        new KotlinPropertyAccessorFlags(visibility2, modality2);

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
    assertSame(
        ownerMetadata,
        (new PropertyReferenceInfo(
                ownerClass,
                ownerMetadata,
                new KotlinPropertyMetadata(
                    flags,
                    "Name",
                    getterFlags,
                    new KotlinPropertyAccessorFlags(visibility3, modality3))))
            .getOwner());
  }

  /**
   * Test {@link PropertyReferenceInfo#getName()}.
   *
   * <ul>
   *   <li>Given {@link KotlinVisibilityFlags} (default constructor) {@link
   *       KotlinVisibilityFlags#isInternal} is {@code true}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyReferenceInfo#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String PropertyReferenceInfo.getName()"})
  public void testGetName_givenKotlinVisibilityFlagsIsInternalIsTrue_thenReturnName() {
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
    KotlinPropertyAccessorFlags getterFlags =
        new KotlinPropertyAccessorFlags(visibility2, modality2);

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
    KotlinPropertyMetadata propertyMetadata =
        new KotlinPropertyMetadata(
            flags, "Name", getterFlags, new KotlinPropertyAccessorFlags(visibility3, modality3));

    LibraryClass ownerClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        "Name",
        (new PropertyReferenceInfo(
                ownerClass,
                new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
                propertyMetadata))
            .getName());
  }
}
