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
import proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class LocalVariableReferenceInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocalVariableReferenceInfo#LocalVariableReferenceInfo(Clazz,
   *       KotlinDeclarationContainerMetadata, String, String)}
   *   <li>{@link LocalVariableReferenceInfo#getName()}
   *   <li>{@link LocalVariableReferenceInfo#getOwner()}
   *   <li>{@link LocalVariableReferenceInfo#getSignature()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.LocalVariableReferenceInfo.<init>(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinDeclarationContainerMetadata, java.lang.String, java.lang.String)",
    "java.lang.String proguard.classfile.kotlin.reflect.LocalVariableReferenceInfo.getName()",
    "proguard.classfile.kotlin.KotlinDeclarationContainerMetadata proguard.classfile.kotlin.reflect.LocalVariableReferenceInfo.getOwner()",
    "java.lang.String proguard.classfile.kotlin.reflect.LocalVariableReferenceInfo.getSignature()"
  })
  void testGettersAndSetters() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    KotlinClassKindMetadata ownerMetadata =
        new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act
    LocalVariableReferenceInfo actualLocalVariableReferenceInfo =
        new LocalVariableReferenceInfo(ownerClass, ownerMetadata, "Name", "Signature");
    String actualName = actualLocalVariableReferenceInfo.getName();
    KotlinDeclarationContainerMetadata actualOwner = actualLocalVariableReferenceInfo.getOwner();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Signature", actualLocalVariableReferenceInfo.getSignature());
    assertSame(ownerMetadata, actualOwner);
  }

  /**
   * Test {@link LocalVariableReferenceInfo#accept(CallableReferenceInfoVisitor)}.
   *
   * <p>Method under test: {@link LocalVariableReferenceInfo#accept(CallableReferenceInfoVisitor)}
   */
  @Test
  @DisplayName("Test accept(CallableReferenceInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.LocalVariableReferenceInfo.accept(proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor)"
  })
  void testAccept() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LocalVariableReferenceInfo localVariableReferenceInfo =
        new LocalVariableReferenceInfo(
            ownerClass,
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
            "Name",
            "Signature");
    CallableReferenceInfoVisitor callableReferenceInfoVisitor =
        mock(CallableReferenceInfoVisitor.class);
    doNothing()
        .when(callableReferenceInfoVisitor)
        .visitLocalVariableReferenceInfo(Mockito.<LocalVariableReferenceInfo>any());

    // Act
    localVariableReferenceInfo.accept(callableReferenceInfoVisitor);

    // Assert
    verify(callableReferenceInfoVisitor)
        .visitLocalVariableReferenceInfo(isA(LocalVariableReferenceInfo.class));
  }

  /**
   * Test {@link LocalVariableReferenceInfo#ownerAccept(KotlinMetadataVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableReferenceInfo#ownerAccept(KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName(
      "Test ownerAccept(KotlinMetadataVisitor); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.LocalVariableReferenceInfo.ownerAccept(proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testOwnerAccept_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LocalVariableReferenceInfo localVariableReferenceInfo =
        new LocalVariableReferenceInfo(
            ownerClass,
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
            "Name",
            "Signature");
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());

    // Act
    localVariableReferenceInfo.ownerAccept(kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }
}
