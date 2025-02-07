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
import proguard.classfile.kotlin.reflect.CallableReferenceInfo;
import proguard.classfile.kotlin.reflect.LocalVariableReferenceInfo;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class CallableReferenceInfoToOwnerVisitorDiffblueTest {
  /**
   * Test {@link
   * CallableReferenceInfoToOwnerVisitor#visitAnyCallableReferenceInfo(CallableReferenceInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CallableReferenceInfoToOwnerVisitor#visitAnyCallableReferenceInfo(CallableReferenceInfo)}
   */
  @Test
  @DisplayName(
      "Test visitAnyCallableReferenceInfo(CallableReferenceInfo); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoToOwnerVisitor.visitAnyCallableReferenceInfo(proguard.classfile.kotlin.reflect.CallableReferenceInfo)"
  })
  void testVisitAnyCallableReferenceInfo_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());
    CallableReferenceInfoToOwnerVisitor callableReferenceInfoToOwnerVisitor =
        new CallableReferenceInfoToOwnerVisitor(kotlinMetadataVisitor);
    LibraryClass ownerClass = new LibraryClass();

    // Act
    callableReferenceInfoToOwnerVisitor.visitAnyCallableReferenceInfo(
        new LocalVariableReferenceInfo(
            ownerClass,
            new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"),
            "Name",
            "Signature"));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }
}
