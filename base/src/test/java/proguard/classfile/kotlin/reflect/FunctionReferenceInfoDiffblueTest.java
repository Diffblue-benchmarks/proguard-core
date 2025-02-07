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
import proguard.classfile.kotlin.KotlinFunctionMetadata;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class FunctionReferenceInfoDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.FunctionReferenceInfo.<init>(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata)",
    "proguard.classfile.kotlin.KotlinDeclarationContainerMetadata proguard.classfile.kotlin.reflect.FunctionReferenceInfo.getOwner()"
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
  @DisplayName(
      "Test getName(); given KotlinVisibilityFlags (default constructor) isInternal is 'true'; then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.reflect.FunctionReferenceInfo.getName()"
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

  /**
   * Test {@link FunctionReferenceInfo#accept(CallableReferenceInfoVisitor)}.
   *
   * <p>Method under test: {@link FunctionReferenceInfo#accept(CallableReferenceInfoVisitor)}
   */
  @Test
  @DisplayName("Test accept(CallableReferenceInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.FunctionReferenceInfo.accept(proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor)"
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
    KotlinFunctionMetadata functionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");

    LibraryClass ownerClass = new LibraryClass();
    FunctionReferenceInfo functionReferenceInfo =
        new FunctionReferenceInfo(
            ownerClass,
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
            functionMetadata);
    CallableReferenceInfoVisitor callableReferenceInfoVisitor =
        mock(CallableReferenceInfoVisitor.class);
    doNothing()
        .when(callableReferenceInfoVisitor)
        .visitFunctionReferenceInfo(Mockito.<FunctionReferenceInfo>any());

    // Act
    functionReferenceInfo.accept(callableReferenceInfoVisitor);

    // Assert
    verify(callableReferenceInfoVisitor)
        .visitFunctionReferenceInfo(isA(FunctionReferenceInfo.class));
  }

  /**
   * Test {@link FunctionReferenceInfo#ownerAccept(KotlinMetadataVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionReferenceInfo#ownerAccept(KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName(
      "Test ownerAccept(KotlinMetadataVisitor); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.FunctionReferenceInfo.ownerAccept(proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
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
    KotlinFunctionMetadata functionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");

    LibraryClass ownerClass = new LibraryClass();
    FunctionReferenceInfo functionReferenceInfo =
        new FunctionReferenceInfo(
            ownerClass,
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
            functionMetadata);
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());

    // Act
    functionReferenceInfo.ownerAccept(kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }
}
