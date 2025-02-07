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

class KotlinFileFacadeKindMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinFileFacadeKindMetadata#KotlinFileFacadeKindMetadata(int[], int, String,
   *       String)}
   *   <li>{@link KotlinFileFacadeKindMetadata#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFileFacadeKindMetadata.<init>(int[], int, java.lang.String, java.lang.String)",
    "java.lang.String proguard.classfile.kotlin.KotlinFileFacadeKindMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    KotlinFileFacadeKindMetadata actualKotlinFileFacadeKindMetadata =
        new KotlinFileFacadeKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    // Assert
    assertEquals("Kotlin file facade(null)", actualKotlinFileFacadeKindMetadata.toString());
    assertNull(actualKotlinFileFacadeKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinFileFacadeKindMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinFileFacadeKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   *
   * <p>Method under test: {@link KotlinFileFacadeKindMetadata#accept(Clazz, KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinFileFacadeKindMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testAccept() {
    // Arrange
    KotlinFileFacadeKindMetadata kotlinFileFacadeKindMetadata =
        new KotlinFileFacadeKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");
    LibraryClass clazz = new LibraryClass();
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinFileFacadeMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinFileFacadeKindMetadata>any());

    // Act
    kotlinFileFacadeKindMetadata.accept(clazz, kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinFileFacadeMetadata(isA(Clazz.class), isA(KotlinFileFacadeKindMetadata.class));
  }
}
