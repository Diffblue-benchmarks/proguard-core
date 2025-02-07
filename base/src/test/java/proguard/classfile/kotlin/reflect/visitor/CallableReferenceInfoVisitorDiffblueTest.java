package proguard.classfile.kotlin.reflect.visitor;

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
import proguard.classfile.kotlin.KotlinFunctionMetadata;
import proguard.classfile.kotlin.KotlinPropertyMetadata;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyAccessorFlags;
import proguard.classfile.kotlin.flags.KotlinPropertyFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.reflect.FunctionReferenceInfo;
import proguard.classfile.kotlin.reflect.LocalVariableReferenceInfo;
import proguard.classfile.kotlin.reflect.PropertyReferenceInfo;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class CallableReferenceInfoVisitorDiffblueTest {
  /**
   * Test {@link CallableReferenceInfoVisitor#visitFunctionReferenceInfo(FunctionReferenceInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CallableReferenceInfoVisitor#visitFunctionReferenceInfo(FunctionReferenceInfo)}
   */
  @Test
  @DisplayName(
      "Test visitFunctionReferenceInfo(FunctionReferenceInfo); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor.visitFunctionReferenceInfo(proguard.classfile.kotlin.reflect.FunctionReferenceInfo)"
  })
  void testVisitFunctionReferenceInfo_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());
    CallableReferenceInfoToOwnerVisitor callableReferenceInfoToOwnerVisitor =
        new CallableReferenceInfoToOwnerVisitor(kotlinMetadataVisitor);
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

    // Act
    callableReferenceInfoToOwnerVisitor.visitFunctionReferenceInfo(
        new FunctionReferenceInfo(
            ownerClass,
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
            functionMetadata));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }

  /**
   * Test {@link
   * CallableReferenceInfoVisitor#visitLocalVariableReferenceInfo(LocalVariableReferenceInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CallableReferenceInfoVisitor#visitLocalVariableReferenceInfo(LocalVariableReferenceInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableReferenceInfo(LocalVariableReferenceInfo); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor.visitLocalVariableReferenceInfo(proguard.classfile.kotlin.reflect.LocalVariableReferenceInfo)"
  })
  void testVisitLocalVariableReferenceInfo_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());
    CallableReferenceInfoToOwnerVisitor callableReferenceInfoToOwnerVisitor =
        new CallableReferenceInfoToOwnerVisitor(kotlinMetadataVisitor);
    LibraryClass ownerClass = new LibraryClass();

    // Act
    callableReferenceInfoToOwnerVisitor.visitLocalVariableReferenceInfo(
        new LocalVariableReferenceInfo(
            ownerClass,
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
            "Name",
            "Signature"));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }

  /**
   * Test {@link CallableReferenceInfoVisitor#visitPropertyReferenceInfo(PropertyReferenceInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CallableReferenceInfoVisitor#visitPropertyReferenceInfo(PropertyReferenceInfo)}
   */
  @Test
  @DisplayName(
      "Test visitPropertyReferenceInfo(PropertyReferenceInfo); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor.visitPropertyReferenceInfo(proguard.classfile.kotlin.reflect.PropertyReferenceInfo)"
  })
  void testVisitPropertyReferenceInfo_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());
    CallableReferenceInfoToOwnerVisitor callableReferenceInfoToOwnerVisitor =
        new CallableReferenceInfoToOwnerVisitor(kotlinMetadataVisitor);
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

    // Act
    callableReferenceInfoToOwnerVisitor.visitPropertyReferenceInfo(
        new PropertyReferenceInfo(
            ownerClass,
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
            propertyMetadata));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }
}
