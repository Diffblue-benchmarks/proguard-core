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
import proguard.classfile.LibraryMember;
import proguard.classfile.LibraryMethod;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.kotlin.flags.KotlinConstructorFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinConstructorVisitor;
import proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor;
import proguard.classfile.visitor.MemberVisitor;

class KotlinConstructorMetadataDiffblueTest {
  /**
   * Test {@link KotlinConstructorMetadata#KotlinConstructorMetadata(KotlinConstructorFlags)}.
   *
   * <p>Method under test: {@link
   * KotlinConstructorMetadata#KotlinConstructorMetadata(KotlinConstructorFlags)}
   */
  @Test
  @DisplayName("Test new KotlinConstructorMetadata(KotlinConstructorFlags)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinConstructorMetadata.<init>(proguard.classfile.kotlin.flags.KotlinConstructorFlags)"
  })
  void testNewKotlinConstructorMetadata() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;

    // Act
    KotlinConstructorMetadata actualKotlinConstructorMetadata =
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility));

    // Assert
    assertNull(actualKotlinConstructorMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinConstructorMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinConstructorMetadata#accept(Clazz, KotlinClassKindMetadata,
   * KotlinConstructorVisitor)}.
   *
   * <p>Method under test: {@link KotlinConstructorMetadata#accept(Clazz, KotlinClassKindMetadata,
   * KotlinConstructorVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, KotlinClassKindMetadata, KotlinConstructorVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinConstructorMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinClassKindMetadata, proguard.classfile.kotlin.visitor.KotlinConstructorVisitor)"
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
    KotlinConstructorMetadata kotlinConstructorMetadata =
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility));
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinClassKindMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinConstructorVisitor kotlinConstructorVisitor = mock(KotlinConstructorVisitor.class);
    doNothing()
        .when(kotlinConstructorVisitor)
        .visitConstructor(
            Mockito.<Clazz>any(),
            Mockito.<KotlinClassKindMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any());

    // Act
    kotlinConstructorMetadata.accept(clazz, kotlinClassKindMetadata, kotlinConstructorVisitor);

    // Assert
    verify(kotlinConstructorVisitor)
        .visitConstructor(
            isA(Clazz.class),
            isA(KotlinClassKindMetadata.class),
            isA(KotlinConstructorMetadata.class));
  }

  /**
   * Test {@link KotlinConstructorMetadata#versionRequirementAccept(Clazz, KotlinMetadata,
   * KotlinVersionRequirementVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       KotlinVersionRequirementVisitor#visitConstructorVersionRequirement(Clazz, KotlinMetadata,
   *       KotlinConstructorMetadata, KotlinVersionRequirementMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstructorMetadata#versionRequirementAccept(Clazz,
   * KotlinMetadata, KotlinVersionRequirementVisitor)}
   */
  @Test
  @DisplayName(
      "Test versionRequirementAccept(Clazz, KotlinMetadata, KotlinVersionRequirementVisitor); then calls visitConstructorVersionRequirement(Clazz, KotlinMetadata, KotlinConstructorMetadata, KotlinVersionRequirementMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinConstructorMetadata.versionRequirementAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor)"
  })
  void testVersionRequirementAccept_thenCallsVisitConstructorVersionRequirement() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinConstructorMetadata kotlinConstructorMetadata =
        new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility));
    kotlinConstructorMetadata.versionRequirement = new KotlinVersionRequirementMetadata();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinVersionRequirementVisitor kotlinVersionRequirementVisitor =
        mock(KotlinVersionRequirementVisitor.class);
    doNothing()
        .when(kotlinVersionRequirementVisitor)
        .visitConstructorVersionRequirement(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinConstructorMetadata>any(),
            Mockito.<KotlinVersionRequirementMetadata>any());

    // Act
    kotlinConstructorMetadata.versionRequirementAccept(
        clazz, kotlinMetadata, kotlinVersionRequirementVisitor);

    // Assert
    verify(kotlinVersionRequirementVisitor)
        .visitConstructorVersionRequirement(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinConstructorMetadata.class),
            isA(KotlinVersionRequirementMetadata.class));
  }

  /**
   * Test {@link KotlinConstructorMetadata#referencedMethodAccept(Clazz, MemberVisitor)}.
   *
   * <ul>
   *   <li>Given {@link LibraryMethod} {@link LibraryMember#accept(Clazz, MemberVisitor)} does
   *       nothing.
   *   <li>Then calls {@link LibraryMember#accept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstructorMetadata#referencedMethodAccept(Clazz,
   * MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test referencedMethodAccept(Clazz, MemberVisitor); given LibraryMethod accept(Clazz, MemberVisitor) does nothing; then calls accept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinConstructorMetadata.referencedMethodAccept(proguard.classfile.Clazz, proguard.classfile.visitor.MemberVisitor)"
  })
  void testReferencedMethodAccept_givenLibraryMethodAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinConstructorFlags flags = new KotlinConstructorFlags(visibility);
    LibraryMethod libraryMethod = mock(LibraryMethod.class);
    doNothing().when(libraryMethod).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    KotlinConstructorMetadata kotlinConstructorMetadata = new KotlinConstructorMetadata(flags);
    kotlinConstructorMetadata.referencedMethod = libraryMethod;
    LibraryClass clazz = new LibraryClass();

    // Act
    kotlinConstructorMetadata.referencedMethodAccept(clazz, new AttributeSorter());

    // Assert
    verify(libraryMethod).accept(isA(Clazz.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link KotlinConstructorMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin constructor}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstructorMetadata#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Kotlin constructor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinConstructorMetadata.toString()"
  })
  void testToString_thenReturnKotlinConstructor() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;

    // Act and Assert
    assertEquals(
        "Kotlin constructor",
        (new KotlinConstructorMetadata(new KotlinConstructorFlags(visibility))).toString());
  }

  /**
   * Test {@link KotlinConstructorMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin secondary constructor}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinConstructorMetadata#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Kotlin secondary constructor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinConstructorMetadata.toString()"
  })
  void testToString_thenReturnKotlinSecondaryConstructor() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinConstructorFlags flags = new KotlinConstructorFlags(visibility);
    KotlinVisibilityFlags visibility2 = new KotlinVisibilityFlags();
    visibility2.isInternal = true;
    visibility2.isLocal = true;
    visibility2.isPrivate = true;
    visibility2.isPrivateToThis = true;
    visibility2.isProtected = true;
    visibility2.isPublic = true;
    KotlinConstructorFlags kotlinConstructorFlags = new KotlinConstructorFlags(visibility2);
    kotlinConstructorFlags.isSecondary = true;
    KotlinConstructorMetadata kotlinConstructorMetadata = new KotlinConstructorMetadata(flags);
    kotlinConstructorMetadata.flags = kotlinConstructorFlags;

    // Act and Assert
    assertEquals("Kotlin secondary constructor", kotlinConstructorMetadata.toString());
  }
}
