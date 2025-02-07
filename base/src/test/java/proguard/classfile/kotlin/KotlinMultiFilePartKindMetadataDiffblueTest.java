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

class KotlinMultiFilePartKindMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinMultiFilePartKindMetadata#KotlinMultiFilePartKindMetadata(int[], int,
   *       String, String)}
   *   <li>{@link KotlinMultiFilePartKindMetadata#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinMultiFilePartKindMetadata.<init>(int[], int, java.lang.String, java.lang.String)",
    "java.lang.String proguard.classfile.kotlin.KotlinMultiFilePartKindMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    KotlinMultiFilePartKindMetadata actualKotlinMultiFilePartKindMetadata =
        new KotlinMultiFilePartKindMetadata(new int[] {1, 5, 1, 5}, 1, "Xs", "Pn");

    // Assert
    assertEquals("Kotlin file part", actualKotlinMultiFilePartKindMetadata.toString());
    assertNull(actualKotlinMultiFilePartKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinMultiFilePartKindMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinMultiFilePartKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   *
   * <p>Method under test: {@link KotlinMultiFilePartKindMetadata#accept(Clazz,
   * KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinMultiFilePartKindMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testAccept() {
    // Arrange
    KotlinMultiFilePartKindMetadata kotlinMultiFilePartKindMetadata =
        new KotlinMultiFilePartKindMetadata(new int[] {1, 5, 1, 5}, 1, "Xs", "Pn");
    LibraryClass clazz = new LibraryClass();
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinMultiFilePartMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinMultiFilePartKindMetadata>any());

    // Act
    kotlinMultiFilePartKindMetadata.accept(clazz, kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinMultiFilePartMetadata(
            isA(Clazz.class), isA(KotlinMultiFilePartKindMetadata.class));
  }
}
