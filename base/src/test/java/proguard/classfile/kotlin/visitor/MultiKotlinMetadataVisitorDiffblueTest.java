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
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinMetadata;

class MultiKotlinMetadataVisitorDiffblueTest {
  /**
   * Test {@link MultiKotlinMetadataVisitor#visitAnyKotlinMetadata(Clazz, KotlinMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link KotlinMetadataVisitor#visitKotlinClassMetadata(Clazz,
   *       KotlinClassKindMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link MultiKotlinMetadataVisitor#visitAnyKotlinMetadata(Clazz,
   * KotlinMetadata)}
   */
  @Test
  @DisplayName(
      "Test visitAnyKotlinMetadata(Clazz, KotlinMetadata); then calls visitKotlinClassMetadata(Clazz, KotlinClassKindMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.visitor.MultiKotlinMetadataVisitor.visitAnyKotlinMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata)"
  })
  void testVisitAnyKotlinMetadata_thenCallsVisitKotlinClassMetadata() {
    // Arrange
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(Mockito.<Clazz>any(), Mockito.<KotlinClassKindMetadata>any());
    MultiKotlinMetadataVisitor multiKotlinMetadataVisitor =
        new MultiKotlinMetadataVisitor(kotlinMetadataVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    multiKotlinMetadataVisitor.visitAnyKotlinMetadata(
        clazz, new KotlinClassKindMetadata(new int[] {1, -1, 1, -1}, 1, "Xs", "Pn"));

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinClassMetadata(isA(Clazz.class), isA(KotlinClassKindMetadata.class));
  }
}
