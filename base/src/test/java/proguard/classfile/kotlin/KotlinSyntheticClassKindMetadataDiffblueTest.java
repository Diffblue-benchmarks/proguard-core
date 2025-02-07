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
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.Flavor;
import proguard.classfile.kotlin.reflect.LocalVariableReferenceInfo;
import proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class KotlinSyntheticClassKindMetadataDiffblueTest {
  /**
   * Test {@link KotlinSyntheticClassKindMetadata#KotlinSyntheticClassKindMetadata(int[], int,
   * String, String, Flavor)}.
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindMetadata#KotlinSyntheticClassKindMetadata(int[], int, String, String,
   * Flavor)}
   */
  @Test
  @DisplayName("Test new KotlinSyntheticClassKindMetadata(int[], int, String, String, Flavor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.<init>(int[], int, java.lang.String, java.lang.String, proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata$Flavor)"
  })
  void testNewKotlinSyntheticClassKindMetadata() {
    // Arrange and Act
    KotlinSyntheticClassKindMetadata actualKotlinSyntheticClassKindMetadata =
        new KotlinSyntheticClassKindMetadata(new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR);

    // Assert
    assertNull(actualKotlinSyntheticClassKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinSyntheticClassKindMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinSyntheticClassKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   *
   * <p>Method under test: {@link KotlinSyntheticClassKindMetadata#accept(Clazz,
   * KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testAccept() {
    // Arrange
    KotlinSyntheticClassKindMetadata kotlinSyntheticClassKindMetadata =
        new KotlinSyntheticClassKindMetadata(new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR);
    LibraryClass clazz = new LibraryClass();
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinSyntheticClassMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinSyntheticClassKindMetadata>any());

    // Act
    kotlinSyntheticClassKindMetadata.accept(clazz, kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinSyntheticClassMetadata(
            isA(Clazz.class), isA(KotlinSyntheticClassKindMetadata.class));
  }

  /**
   * Test {@link
   * KotlinSyntheticClassKindMetadata#callableReferenceInfoAccept(CallableReferenceInfoVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       CallableReferenceInfoVisitor#visitLocalVariableReferenceInfo(LocalVariableReferenceInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindMetadata#callableReferenceInfoAccept(CallableReferenceInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test callableReferenceInfoAccept(CallableReferenceInfoVisitor); then calls visitLocalVariableReferenceInfo(LocalVariableReferenceInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.callableReferenceInfoAccept(proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor)"
  })
  void testCallableReferenceInfoAccept_thenCallsVisitLocalVariableReferenceInfo() {
    // Arrange
    KotlinSyntheticClassKindMetadata kotlinSyntheticClassKindMetadata =
        new KotlinSyntheticClassKindMetadata(new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR);
    LibraryClass ownerClass = new LibraryClass();
    kotlinSyntheticClassKindMetadata.callableReferenceInfo =
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
    kotlinSyntheticClassKindMetadata.callableReferenceInfoAccept(callableReferenceInfoVisitor);

    // Assert
    verify(callableReferenceInfoVisitor)
        .visitLocalVariableReferenceInfo(isA(LocalVariableReferenceInfo.class));
  }
}
