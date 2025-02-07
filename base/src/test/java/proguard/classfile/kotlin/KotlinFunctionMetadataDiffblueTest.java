package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import proguard.classfile.LibraryMember;
import proguard.classfile.LibraryMethod;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.Flavor;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinFunctionVisitor;
import proguard.classfile.kotlin.visitor.KotlinTypeVisitor;
import proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor;
import proguard.classfile.visitor.MemberVisitor;

class KotlinFunctionMetadataDiffblueTest {
  /**
   * Test {@link KotlinFunctionMetadata#KotlinFunctionMetadata(KotlinFunctionFlags, String)}.
   *
   * <p>Method under test: {@link KotlinFunctionMetadata#KotlinFunctionMetadata(KotlinFunctionFlags,
   * String)}
   */
  @Test
  @DisplayName("Test new KotlinFunctionMetadata(KotlinFunctionFlags, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFunctionMetadata.<init>(proguard.classfile.kotlin.flags.KotlinFunctionFlags, java.lang.String)"
  })
  void testNewKotlinFunctionMetadata() {
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
    KotlinFunctionMetadata actualKotlinFunctionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");

    // Assert
    assertNull(actualKotlinFunctionMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinFunctionMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinFunctionMetadata#accept(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinFunctionVisitor)} with {@code clazz}, {@code kotlinDeclarationContainerMetadata}, {@code
   * kotlinFunctionVisitor}.
   *
   * <p>Method under test: {@link KotlinFunctionMetadata#accept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinFunctionVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinDeclarationContainerMetadata, KotlinFunctionVisitor) with 'clazz', 'kotlinDeclarationContainerMetadata', 'kotlinFunctionVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFunctionMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.visitor.KotlinFunctionVisitor)"
  })
  void testAcceptWithClazzKotlinDeclarationContainerMetadataKotlinFunctionVisitor() {
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
    KotlinFunctionMetadata kotlinFunctionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinFunctionVisitor kotlinFunctionVisitor = mock(KotlinFunctionVisitor.class);
    doNothing()
        .when(kotlinFunctionVisitor)
        .visitFunction(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any());

    // Act
    kotlinFunctionMetadata.accept(clazz, kotlinDeclarationContainerMetadata, kotlinFunctionVisitor);

    // Assert
    verify(kotlinFunctionVisitor)
        .visitFunction(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinFunctionMetadata.class));
  }

  /**
   * Test {@link KotlinFunctionMetadata#accept(Clazz, KotlinSyntheticClassKindMetadata,
   * KotlinFunctionVisitor)} with {@code clazz}, {@code kotlinSyntheticClassKindMetadata}, {@code
   * kotlinFunctionVisitor}.
   *
   * <p>Method under test: {@link KotlinFunctionMetadata#accept(Clazz,
   * KotlinSyntheticClassKindMetadata, KotlinFunctionVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, KotlinSyntheticClassKindMetadata, KotlinFunctionVisitor) with 'clazz', 'kotlinSyntheticClassKindMetadata', 'kotlinFunctionVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFunctionMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata, proguard.classfile.kotlin.visitor.KotlinFunctionVisitor)"
  })
  void testAcceptWithClazzKotlinSyntheticClassKindMetadataKotlinFunctionVisitor() {
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
    KotlinFunctionMetadata kotlinFunctionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");
    LibraryClass clazz = new LibraryClass();
    KotlinSyntheticClassKindMetadata kotlinSyntheticClassKindMetadata =
        new KotlinSyntheticClassKindMetadata(new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR);

    KotlinFunctionVisitor kotlinFunctionVisitor = mock(KotlinFunctionVisitor.class);
    doNothing()
        .when(kotlinFunctionVisitor)
        .visitSyntheticFunction(
            Mockito.<Clazz>any(),
            Mockito.<KotlinSyntheticClassKindMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any());

    // Act
    kotlinFunctionMetadata.accept(clazz, kotlinSyntheticClassKindMetadata, kotlinFunctionVisitor);

    // Assert
    verify(kotlinFunctionVisitor)
        .visitSyntheticFunction(
            isA(Clazz.class),
            isA(KotlinSyntheticClassKindMetadata.class),
            isA(KotlinFunctionMetadata.class));
  }

  /**
   * Test {@link KotlinFunctionMetadata#returnTypeAccept(Clazz, KotlinMetadata, KotlinTypeVisitor)}.
   *
   * <p>Method under test: {@link KotlinFunctionMetadata#returnTypeAccept(Clazz, KotlinMetadata,
   * KotlinTypeVisitor)}
   */
  @Test
  @DisplayName("Test returnTypeAccept(Clazz, KotlinMetadata, KotlinTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFunctionMetadata.returnTypeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testReturnTypeAccept() {
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
    KotlinFunctionMetadata kotlinFunctionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitFunctionReturnType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinFunctionMetadata.returnTypeAccept(clazz, kotlinMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitFunctionReturnType(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isNull());
  }

  /**
   * Test {@link KotlinFunctionMetadata#receiverTypeAccept(Clazz, KotlinMetadata,
   * KotlinTypeVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinTypeVisitor#visitFunctionReceiverType(Clazz, KotlinMetadata,
   *       KotlinFunctionMetadata, KotlinTypeMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinFunctionMetadata#receiverTypeAccept(Clazz, KotlinMetadata,
   * KotlinTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test receiverTypeAccept(Clazz, KotlinMetadata, KotlinTypeVisitor); then calls visitFunctionReceiverType(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinTypeMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFunctionMetadata.receiverTypeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testReceiverTypeAccept_thenCallsVisitFunctionReceiverType() {
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
    KotlinFunctionMetadata kotlinFunctionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");
    kotlinFunctionMetadata.receiverType = KotlinTypeMetadata.starProjection();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitFunctionReceiverType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinFunctionMetadata.receiverTypeAccept(clazz, kotlinMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitFunctionReceiverType(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinTypeMetadata.class));
  }

  /**
   * Test {@link KotlinFunctionMetadata#versionRequirementAccept(Clazz, KotlinMetadata,
   * KotlinVersionRequirementVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinVersionRequirementVisitor#visitFunctionVersionRequirement(Clazz,
   *       KotlinMetadata, KotlinFunctionMetadata, KotlinVersionRequirementMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinFunctionMetadata#versionRequirementAccept(Clazz,
   * KotlinMetadata, KotlinVersionRequirementVisitor)}
   */
  @Test
  @DisplayName(
      "Test versionRequirementAccept(Clazz, KotlinMetadata, KotlinVersionRequirementVisitor); then calls visitFunctionVersionRequirement(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinVersionRequirementMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFunctionMetadata.versionRequirementAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor)"
  })
  void testVersionRequirementAccept_thenCallsVisitFunctionVersionRequirement() {
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
    KotlinFunctionMetadata kotlinFunctionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");
    kotlinFunctionMetadata.versionRequirement = new KotlinVersionRequirementMetadata();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinVersionRequirementVisitor kotlinVersionRequirementVisitor =
        mock(KotlinVersionRequirementVisitor.class);
    doNothing()
        .when(kotlinVersionRequirementVisitor)
        .visitFunctionVersionRequirement(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinVersionRequirementMetadata>any());

    // Act
    kotlinFunctionMetadata.versionRequirementAccept(
        clazz, kotlinMetadata, kotlinVersionRequirementVisitor);

    // Assert
    verify(kotlinVersionRequirementVisitor)
        .visitFunctionVersionRequirement(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinVersionRequirementMetadata.class));
  }

  /**
   * Test {@link KotlinFunctionMetadata#referencedMethodAccept(Clazz, MemberVisitor)} with {@code
   * clazz}, {@code methodVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinFunctionMetadata#referencedMethodAccept(Clazz,
   * MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedMethodAccept(Clazz, MemberVisitor) with 'clazz', 'methodVisitor'; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFunctionMetadata.referencedMethodAccept(proguard.classfile.Clazz, proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedMethodAcceptWithClazzMethodVisitor_thenCallsAccept() {
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
    KotlinFunctionFlags flags = new KotlinFunctionFlags(visibility, modality);

    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    doNothing().when(libraryMethod).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    KotlinFunctionMetadata kotlinFunctionMetadata = new KotlinFunctionMetadata(flags, "Name");
    kotlinFunctionMetadata.referencedMethod = libraryMethod;
    kotlinFunctionMetadata.referencedMethodClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinFunctionMetadata.referencedMethodAccept(clazz, new AttributeSorter());

    // Assert
    verify(libraryMethod).accept(isA(Clazz.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link KotlinFunctionMetadata#referencedMethodAccept(MemberVisitor)} with {@code
   * methodVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinFunctionMetadata#referencedMethodAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedMethodAccept(MemberVisitor) with 'methodVisitor'; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFunctionMetadata.referencedMethodAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedMethodAcceptWithMethodVisitor_thenCallsAccept() {
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
    KotlinFunctionFlags flags = new KotlinFunctionFlags(visibility, modality);

    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    doNothing().when(libraryMethod).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    KotlinFunctionMetadata kotlinFunctionMetadata = new KotlinFunctionMetadata(flags, "Name");
    kotlinFunctionMetadata.referencedMethod = libraryMethod;
    kotlinFunctionMetadata.referencedMethodClass = new LibraryClass();

    // Act
    kotlinFunctionMetadata.referencedMethodAccept(new AttributeSorter());

    // Assert
    verify(libraryMethod).accept(isA(Clazz.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link KotlinFunctionMetadata#referencedDefaultMethodAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinFunctionMetadata#referencedDefaultMethodAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedDefaultMethodAccept(MemberVisitor); then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFunctionMetadata.referencedDefaultMethodAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedDefaultMethodAccept_thenCallsAccept() {
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
    KotlinFunctionFlags flags = new KotlinFunctionFlags(visibility, modality);

    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    doNothing().when(libraryMethod).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    KotlinFunctionMetadata kotlinFunctionMetadata = new KotlinFunctionMetadata(flags, "Name");
    kotlinFunctionMetadata.referencedDefaultMethod = libraryMethod;
    kotlinFunctionMetadata.referencedDefaultMethodClass = new LibraryClass();

    // Act
    kotlinFunctionMetadata.referencedDefaultMethodAccept(new AttributeSorter());

    // Assert
    verify(libraryMethod).accept(isA(Clazz.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link KotlinFunctionMetadata#referencedDefaultImplementationMethodAccept(MemberVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinFunctionMetadata#referencedDefaultImplementationMethodAccept(MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedDefaultImplementationMethodAccept(MemberVisitor); then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFunctionMetadata.referencedDefaultImplementationMethodAccept(proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedDefaultImplementationMethodAccept_thenCallsAccept() {
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
    KotlinFunctionFlags flags = new KotlinFunctionFlags(visibility, modality);

    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    doNothing().when(libraryMethod).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    KotlinFunctionMetadata kotlinFunctionMetadata = new KotlinFunctionMetadata(flags, "Name");
    kotlinFunctionMetadata.referencedDefaultImplementationMethodClass = new LibraryClass();
    kotlinFunctionMetadata.referencedDefaultImplementationMethod = libraryMethod;

    // Act
    kotlinFunctionMetadata.referencedDefaultImplementationMethodAccept(new AttributeSorter());

    // Assert
    verify(libraryMethod).accept(isA(Clazz.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link KotlinFunctionMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin function(Name)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinFunctionMetadata#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Kotlin function(Name)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinFunctionMetadata.toString()"
  })
  void testToString_thenReturnKotlinFunctionName() {
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
    assertEquals(
        "Kotlin function(Name)",
        (new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name"))
            .toString());
  }
}
