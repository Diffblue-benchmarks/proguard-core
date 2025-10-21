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
import proguard.classfile.kotlin.KotlinFunctionMetadata;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;

public class FunctionReferenceInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FunctionReferenceInfo#FunctionReferenceInfo(Clazz,
   *       KotlinDeclarationContainerMetadata, KotlinFunctionMetadata)}
   *   <li>{@link FunctionReferenceInfo#getOwner()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void FunctionReferenceInfo.<init>(Clazz, KotlinDeclarationContainerMetadata, KotlinFunctionMetadata)",
    "KotlinDeclarationContainerMetadata FunctionReferenceInfo.getOwner()"
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

    // Act and Assert
    assertSame(
        ownerMetadata,
        (new FunctionReferenceInfo(
                ownerClass,
                ownerMetadata,
                new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name")))
            .getOwner());
  }

  /**
   * Test {@link FunctionReferenceInfo#getName()}.
   *
   * <ul>
   *   <li>Given {@link KotlinVisibilityFlags} (default constructor) {@link
   *       KotlinVisibilityFlags#isInternal} is {@code true}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionReferenceInfo#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String FunctionReferenceInfo.getName()"})
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
    KotlinFunctionMetadata functionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");

    LibraryClass ownerClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        "Name",
        (new FunctionReferenceInfo(
                ownerClass,
                new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
                functionMetadata))
            .getName());
  }
}
