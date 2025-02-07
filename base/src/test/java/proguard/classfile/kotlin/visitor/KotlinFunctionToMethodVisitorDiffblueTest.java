package proguard.classfile.kotlin.visitor;

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
import proguard.classfile.LibraryMethod;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinFunctionMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.visitor.MemberVisitor;

class KotlinFunctionToMethodVisitorDiffblueTest {
  /**
   * Test {@link KotlinFunctionToMethodVisitor#visitAnyFunction(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinFunctionMetadata#referencedMethodAccept(Clazz, MemberVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinFunctionToMethodVisitor#visitAnyFunction(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyFunction(Clazz, KotlinMetadata, KotlinFunctionMetadata); then calls referencedMethodAccept(Clazz, MemberVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinFunctionToMethodVisitor.visitAnyFunction(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata)"
  })
  void testVisitAnyFunction_thenCallsReferencedMethodAccept() {
    // Arrange
    KotlinFunctionToMethodVisitor kotlinFunctionToMethodVisitor =
        new KotlinFunctionToMethodVisitor(new AttributeSorter());
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    KotlinFunctionMetadata kotlinFunctionMetadata = mock(KotlinFunctionMetadata.class);
    doNothing()
        .when(kotlinFunctionMetadata)
        .referencedMethodAccept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());

    // Act
    kotlinFunctionToMethodVisitor.visitAnyFunction(clazz, kotlinMetadata, kotlinFunctionMetadata);

    // Assert
    verify(kotlinFunctionMetadata)
        .referencedMethodAccept(isA(Clazz.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link KotlinFunctionToMethodVisitor#visitAnyFunction(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link MemberVisitor#visitLibraryMethod(LibraryClass, LibraryMethod)}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinFunctionToMethodVisitor#visitAnyFunction(Clazz,
   * KotlinMetadata, KotlinFunctionMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyFunction(Clazz, KotlinMetadata, KotlinFunctionMetadata); then calls visitLibraryMethod(LibraryClass, LibraryMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.KotlinFunctionToMethodVisitor.visitAnyFunction(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata)"
  })
  void testVisitAnyFunction_thenCallsVisitLibraryMethod() {
    // Arrange
    MemberVisitor memberVisitor = mock(MemberVisitor.class);
    doNothing()
        .when(memberVisitor)
        .visitLibraryMethod(Mockito.<LibraryClass>any(), Mockito.<LibraryMethod>any());
    KotlinFunctionToMethodVisitor kotlinFunctionToMethodVisitor =
        new KotlinFunctionToMethodVisitor(memberVisitor);
    LibraryClass clazz = new LibraryClass();
    KotlinClassKindMetadata kotlinMetadata =
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
    KotlinFunctionMetadata kotlinFunctionMetadata =
        new KotlinFunctionMetadata(new KotlinFunctionFlags(visibility, modality), "Name");

    kotlinFunctionMetadata.referencedMethod = new LibraryMethod(1, "Name", "Descriptor");
    kotlinFunctionMetadata.referencedMethodClass = new LibraryClass();

    // Act
    kotlinFunctionToMethodVisitor.visitAnyFunction(clazz, kotlinMetadata, kotlinFunctionMetadata);

    // Assert
    verify(memberVisitor).visitLibraryMethod(isA(LibraryClass.class), isA(LibraryMethod.class));
  }
}
