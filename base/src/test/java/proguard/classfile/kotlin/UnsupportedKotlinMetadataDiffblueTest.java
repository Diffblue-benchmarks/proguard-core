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
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class UnsupportedKotlinMetadataDiffblueTest {
  /**
   * Test {@link UnsupportedKotlinMetadata#UnsupportedKotlinMetadata(int, int[], int, String,
   * String)}.
   *
   * <p>Method under test: {@link UnsupportedKotlinMetadata#UnsupportedKotlinMetadata(int, int[],
   * int, String, String)}
   */
  @Test
  @DisplayName("Test new UnsupportedKotlinMetadata(int, int[], int, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.UnsupportedKotlinMetadata.<init>(int, int[], int, java.lang.String, java.lang.String)"
  })
  void testNewUnsupportedKotlinMetadata() {
    // Arrange and Act
    UnsupportedKotlinMetadata actualUnsupportedKotlinMetadata =
        new UnsupportedKotlinMetadata(1, new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Assert
    assertNull(actualUnsupportedKotlinMetadata.getProcessingInfo());
    assertEquals(0, actualUnsupportedKotlinMetadata.getProcessingFlags());
  }

  /**
   * Test {@link UnsupportedKotlinMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   *
   * <p>Method under test: {@link UnsupportedKotlinMetadata#accept(Clazz, KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.UnsupportedKotlinMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testAccept() {
    // Arrange
    UnsupportedKotlinMetadata unsupportedKotlinMetadata =
        new UnsupportedKotlinMetadata(1, new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");
    LibraryClass clazz = new LibraryClass();
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitUnsupportedKotlinMetadata(
            Mockito.<Clazz>any(), Mockito.<UnsupportedKotlinMetadata>any());

    // Act
    unsupportedKotlinMetadata.accept(clazz, kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitUnsupportedKotlinMetadata(isA(Clazz.class), isA(UnsupportedKotlinMetadata.class));
  }
}
