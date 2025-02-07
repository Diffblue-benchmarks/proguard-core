package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMember;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.kotlin.flags.KotlinClassFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;
import proguard.classfile.kotlin.visitor.KotlinTypeVisitor;
import proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor;
import proguard.classfile.visitor.MemberVisitor;

class KotlinClassKindMetadataDiffblueTest {
  /**
   * Test {@link KotlinClassKindMetadata#KotlinClassKindMetadata(int[], int, String, String)}.
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#KotlinClassKindMetadata(int[], int,
   * String, String)}
   */
  @Test
  @DisplayName("Test new KotlinClassKindMetadata(int[], int, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinClassKindMetadata.<init>(int[], int, java.lang.String, java.lang.String)"
  })
  void testNewKotlinClassKindMetadata() {
    // Arrange and Act
    KotlinClassKindMetadata actualKotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Assert
    assertNull(actualKotlinClassKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinClassKindMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinClassKindMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testAccept() {
    // Arrange
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    LibraryClass clazz = new LibraryClass();
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());

    // Act
    kotlinClassKindMetadata.accept(clazz, kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinClassKindMetadata#companionAccept(KotlinMetadataVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#companionAccept(KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName(
      "Test companionAccept(KotlinMetadataVisitor); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinClassKindMetadata.companionAccept(proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testCompanionAccept_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.referencedCompanionClass =
        new LibraryClass(
            1,
            "This Class Name",
            "Super Class Name",
            new KotlinClassKindMetadata(new int[] {1, 0, 1, 0}, 1, "Xs", "Pn"));
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());

    // Act
    kotlinClassKindMetadata.companionAccept(kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }

  /**
   * Test {@link KotlinClassKindMetadata#referencedCompanionFieldAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinClassKindMetadata#referencedCompanionFieldAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedCompanionFieldAccept(MemberVisitor); then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinClassKindMetadata.referencedCompanionFieldAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedCompanionFieldAccept_thenCallsAccept() {
    // Arrange
    LibraryField libraryField = mock(LibraryField.class);
    doNothing().when(libraryField).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.referencedClass = new LibraryClass();
    kotlinClassKindMetadata.referencedCompanionField = libraryField;

    // Act
    kotlinClassKindMetadata.referencedCompanionFieldAccept(new AttributeSorter());

    // Assert
    verify(libraryField).accept(isA(Clazz.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link KotlinClassKindMetadata#versionRequirementAccept(Clazz,
   * KotlinVersionRequirementVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinVersionRequirementVisitor#visitClassVersionRequirement(Clazz,
   *       KotlinMetadata, KotlinVersionRequirementMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinClassKindMetadata#versionRequirementAccept(Clazz,
   * KotlinVersionRequirementVisitor)}
   */
  @Test
  @DisplayName(
      "Test versionRequirementAccept(Clazz, KotlinVersionRequirementVisitor); then calls visitClassVersionRequirement(Clazz, KotlinMetadata, KotlinVersionRequirementMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinClassKindMetadata.versionRequirementAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor)"
  })
  void testVersionRequirementAccept_thenCallsVisitClassVersionRequirement() {
    // Arrange
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.versionRequirement = new KotlinVersionRequirementMetadata();
    LibraryClass clazz = new LibraryClass();
    KotlinVersionRequirementVisitor kotlinVersionRequirementVisitor =
        mock(KotlinVersionRequirementVisitor.class);
    doNothing()
        .when(kotlinVersionRequirementVisitor)
        .visitClassVersionRequirement(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinVersionRequirementMetadata>any());

    // Act
    kotlinClassKindMetadata.versionRequirementAccept(clazz, kotlinVersionRequirementVisitor);

    // Assert
    verify(kotlinVersionRequirementVisitor)
        .visitClassVersionRequirement(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinVersionRequirementMetadata.class));
  }

  /**
   * Test {@link KotlinClassKindMetadata#inlineClassUnderlyingPropertyTypeAccept(Clazz,
   * KotlinTypeVisitor)}.
   *
   * <p>Method under test: {@link
   * KotlinClassKindMetadata#inlineClassUnderlyingPropertyTypeAccept(Clazz, KotlinTypeVisitor)}
   */
  @Test
  @DisplayName("Test inlineClassUnderlyingPropertyTypeAccept(Clazz, KotlinTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinClassKindMetadata.inlineClassUnderlyingPropertyTypeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testInlineClassUnderlyingPropertyTypeAccept() {
    // Arrange
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    kotlinClassKindMetadata.underlyingPropertyType = KotlinTypeMetadata.starProjection();
    LibraryClass clazz = new LibraryClass();
    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitInlineClassUnderlyingPropertyType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinClassKindMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinClassKindMetadata.inlineClassUnderlyingPropertyTypeAccept(clazz, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitInlineClassUnderlyingPropertyType(
            isA(Clazz.class), isA(KotlinClassKindMetadata.class), isA(KotlinTypeMetadata.class));
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
  @DisplayName("Test toString(); then return 'Kotlin accompanied class(null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinClassKindMetadata.toString()"
  })
  void testToString_thenReturnKotlinAccompaniedClassNull() {
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
  @DisplayName("Test toString(); then return 'Kotlin class(null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinClassKindMetadata.toString()"
  })
  void testToString_thenReturnKotlinClassNull() {
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
  @DisplayName("Test toString(); then return 'Kotlin companion object class(null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinClassKindMetadata.toString()"
  })
  void testToString_thenReturnKotlinCompanionObjectClassNull() {
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
  @DisplayName("Test toString(); then return 'Kotlin data data class(null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinClassKindMetadata.toString()"
  })
  void testToString_thenReturnKotlinDataDataClassNull() {
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
  @DisplayName("Test toString(); then return 'Kotlin enum entry class(null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinClassKindMetadata.toString()"
  })
  void testToString_thenReturnKotlinEnumEntryClassNull() {
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
  @DisplayName("Test toString(); then return 'Kotlin interface class(null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinClassKindMetadata.toString()"
  })
  void testToString_thenReturnKotlinInterfaceClassNull() {
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
  @DisplayName("Test toString(); then return 'Kotlin object class(null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinClassKindMetadata.toString()"
  })
  void testToString_thenReturnKotlinObjectClassNull() {
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
  @DisplayName("Test toString(); then return 'Kotlin usual class(null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinClassKindMetadata.toString()"
  })
  void testToString_thenReturnKotlinUsualClassNull() {
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
