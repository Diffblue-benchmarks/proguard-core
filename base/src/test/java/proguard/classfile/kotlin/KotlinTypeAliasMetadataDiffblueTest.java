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
import proguard.classfile.kotlin.flags.KotlinTypeAliasFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinTypeAliasVisitor;
import proguard.classfile.kotlin.visitor.KotlinTypeVisitor;
import proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor;

class KotlinTypeAliasMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinTypeAliasMetadata#KotlinTypeAliasMetadata(KotlinTypeAliasFlags, String)}
   *   <li>{@link KotlinTypeAliasMetadata#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinTypeAliasMetadata.<init>(proguard.classfile.kotlin.flags.KotlinTypeAliasFlags, java.lang.String)",
    "java.lang.String proguard.classfile.kotlin.KotlinTypeAliasMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;

    // Act
    KotlinTypeAliasMetadata actualKotlinTypeAliasMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");

    // Assert
    assertEquals("Kotlin type alias (Name)", actualKotlinTypeAliasMetadata.toString());
    assertNull(actualKotlinTypeAliasMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinTypeAliasMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinTypeAliasMetadata#accept(Clazz, KotlinDeclarationContainerMetadata,
   * KotlinTypeAliasVisitor)}.
   *
   * <p>Method under test: {@link KotlinTypeAliasMetadata#accept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeAliasVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeAliasVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinTypeAliasMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.visitor.KotlinTypeAliasVisitor)"
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
    KotlinTypeAliasMetadata kotlinTypeAliasMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeAliasVisitor kotlinTypeAliasVisitor = mock(KotlinTypeAliasVisitor.class);
    doNothing()
        .when(kotlinTypeAliasVisitor)
        .visitTypeAlias(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeAliasMetadata>any());

    // Act
    kotlinTypeAliasMetadata.accept(
        clazz, kotlinDeclarationContainerMetadata, kotlinTypeAliasVisitor);

    // Assert
    verify(kotlinTypeAliasVisitor)
        .visitTypeAlias(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeAliasMetadata.class));
  }

  /**
   * Test {@link KotlinTypeAliasMetadata#underlyingTypeAccept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeVisitor)}.
   *
   * <p>Method under test: {@link KotlinTypeAliasMetadata#underlyingTypeAccept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test underlyingTypeAccept(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinTypeAliasMetadata.underlyingTypeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testUnderlyingTypeAccept() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinTypeAliasMetadata kotlinTypeAliasMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitAliasUnderlyingType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeAliasMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinTypeAliasMetadata.underlyingTypeAccept(
        clazz, kotlinDeclarationContainerMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitAliasUnderlyingType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeAliasMetadata.class),
            isNull());
  }

  /**
   * Test {@link KotlinTypeAliasMetadata#expandedTypeAccept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeVisitor)}.
   *
   * <p>Method under test: {@link KotlinTypeAliasMetadata#expandedTypeAccept(Clazz,
   * KotlinDeclarationContainerMetadata, KotlinTypeVisitor)}
   */
  @Test
  @DisplayName(
      "Test expandedTypeAccept(Clazz, KotlinDeclarationContainerMetadata, KotlinTypeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinTypeAliasMetadata.expandedTypeAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.visitor.KotlinTypeVisitor)"
  })
  void testExpandedTypeAccept() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinTypeAliasMetadata kotlinTypeAliasMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinDeclarationContainerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinTypeVisitor kotlinTypeVisitor = mock(KotlinTypeVisitor.class);
    doNothing()
        .when(kotlinTypeVisitor)
        .visitAliasExpandedType(
            Mockito.<Clazz>any(),
            Mockito.<KotlinDeclarationContainerMetadata>any(),
            Mockito.<KotlinTypeAliasMetadata>any(),
            Mockito.<KotlinTypeMetadata>any());

    // Act
    kotlinTypeAliasMetadata.expandedTypeAccept(
        clazz, kotlinDeclarationContainerMetadata, kotlinTypeVisitor);

    // Assert
    verify(kotlinTypeVisitor)
        .visitAliasExpandedType(
            isA(Clazz.class),
            isA(KotlinDeclarationContainerMetadata.class),
            isA(KotlinTypeAliasMetadata.class),
            isNull());
  }

  /**
   * Test {@link KotlinTypeAliasMetadata#versionRequirementAccept(Clazz, KotlinMetadata,
   * KotlinVersionRequirementVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinVersionRequirementVisitor#visitTypeAliasVersionRequirement(Clazz,
   *       KotlinMetadata, KotlinTypeAliasMetadata, KotlinVersionRequirementMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeAliasMetadata#versionRequirementAccept(Clazz,
   * KotlinMetadata, KotlinVersionRequirementVisitor)}
   */
  @Test
  @DisplayName(
      "Test versionRequirementAccept(Clazz, KotlinMetadata, KotlinVersionRequirementVisitor); then calls visitTypeAliasVersionRequirement(Clazz, KotlinMetadata, KotlinTypeAliasMetadata, KotlinVersionRequirementMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinTypeAliasMetadata.versionRequirementAccept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.visitor.KotlinVersionRequirementVisitor)"
  })
  void testVersionRequirementAccept_thenCallsVisitTypeAliasVersionRequirement() {
    // Arrange
    KotlinVisibilityFlags visibility = new KotlinVisibilityFlags();
    visibility.isInternal = true;
    visibility.isLocal = true;
    visibility.isPrivate = true;
    visibility.isPrivateToThis = true;
    visibility.isProtected = true;
    visibility.isPublic = true;
    KotlinTypeAliasMetadata kotlinTypeAliasMetadata =
        new KotlinTypeAliasMetadata(new KotlinTypeAliasFlags(visibility), "Name");
    kotlinTypeAliasMetadata.versionRequirement = new KotlinVersionRequirementMetadata();
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinVersionRequirementVisitor kotlinVersionRequirementVisitor =
        mock(KotlinVersionRequirementVisitor.class);
    doNothing()
        .when(kotlinVersionRequirementVisitor)
        .visitTypeAliasVersionRequirement(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinTypeAliasMetadata>any(),
            Mockito.<KotlinVersionRequirementMetadata>any());

    // Act
    kotlinTypeAliasMetadata.versionRequirementAccept(
        clazz, kotlinMetadata, kotlinVersionRequirementVisitor);

    // Assert
    verify(kotlinVersionRequirementVisitor)
        .visitTypeAliasVersionRequirement(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinTypeAliasMetadata.class),
            isA(KotlinVersionRequirementMetadata.class));
  }
}
