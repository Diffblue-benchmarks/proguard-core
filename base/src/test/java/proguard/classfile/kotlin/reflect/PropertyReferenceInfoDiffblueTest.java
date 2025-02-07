package proguard.classfile.kotlin.reflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinDeclarationContainerMetadata;
import proguard.classfile.kotlin.KotlinPropertyMetadata;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class PropertyReferenceInfoDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.PropertyReferenceInfo.<init>(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinPropertyMetadata)",
    "proguard.classfile.kotlin.KotlinDeclarationContainerMetadata proguard.classfile.kotlin.reflect.PropertyReferenceInfo.getOwner()"
  })
  void testGettersAndSetters() {
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
  @DisplayName(
      "Test getName(); given KotlinVisibilityFlags (default constructor) isInternal is 'true'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.reflect.PropertyReferenceInfo.getName()"
  })
  void testGetName_givenKotlinVisibilityFlagsIsInternalIsTrue_thenReturnName() {
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

  /**
   * Test {@link PropertyReferenceInfo#accept(CallableReferenceInfoVisitor)}.
   *
   * <p>Method under test: {@link PropertyReferenceInfo#accept(CallableReferenceInfoVisitor)}
   */
  @Test
  @DisplayName("Test accept(CallableReferenceInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.PropertyReferenceInfo.accept(proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor)"
  })
  void testAccept() {
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
    PropertyReferenceInfo propertyReferenceInfo =
        new PropertyReferenceInfo(
            ownerClass,
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
            propertyMetadata);
    CallableReferenceInfoVisitor callableReferenceInfoVisitor =
        mock(CallableReferenceInfoVisitor.class);
    doNothing()
        .when(callableReferenceInfoVisitor)
        .visitPropertyReferenceInfo(Mockito.<PropertyReferenceInfo>any());

    // Act
    propertyReferenceInfo.accept(callableReferenceInfoVisitor);

    // Assert
    verify(callableReferenceInfoVisitor)
        .visitPropertyReferenceInfo(isA(PropertyReferenceInfo.class));
  }

  /**
   * Test {@link PropertyReferenceInfo#ownerAccept(KotlinMetadataVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyReferenceInfo#ownerAccept(KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName(
      "Test ownerAccept(KotlinMetadataVisitor); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.PropertyReferenceInfo.ownerAccept(proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testOwnerAccept_thenCallsVisitKotlinClassMetadata() {
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
    PropertyReferenceInfo propertyReferenceInfo =
        new PropertyReferenceInfo(
            ownerClass,
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
            propertyMetadata);
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());

    // Act
    propertyReferenceInfo.ownerAccept(kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }
}
