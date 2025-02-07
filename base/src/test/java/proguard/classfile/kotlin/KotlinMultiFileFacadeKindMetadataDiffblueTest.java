package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.visitor.KotlinMetadataVisitor;

class KotlinMultiFileFacadeKindMetadataDiffblueTest {
  /**
   * Test {@link KotlinMultiFileFacadeKindMetadata#KotlinMultiFileFacadeKindMetadata(int[],
   * String[], int, String, String)}.
   *
   * <p>Method under test: {@link
   * KotlinMultiFileFacadeKindMetadata#KotlinMultiFileFacadeKindMetadata(int[], String[], int,
   * String, String)}
   */
  @Test
  @DisplayName("Test new KotlinMultiFileFacadeKindMetadata(int[], String[], int, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinMultiFileFacadeKindMetadata.<init>(int[], java.lang.String[], int, java.lang.String, java.lang.String)"
  })
  void testNewKotlinMultiFileFacadeKindMetadata() {
    // Arrange and Act
    KotlinMultiFileFacadeKindMetadata actualKotlinMultiFileFacadeKindMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 4, 1, 4}, new String[] {"D1"}, 1, "Xs", "Pn");

    // Assert
    List<String> stringList = actualKotlinMultiFileFacadeKindMetadata.partClassNames;
    assertEquals(1, stringList.size());
    assertEquals("D1", stringList.get(0));
    assertEquals("Pn", actualKotlinMultiFileFacadeKindMetadata.pn);
    assertEquals("Xs", actualKotlinMultiFileFacadeKindMetadata.xs);
    assertNull(actualKotlinMultiFileFacadeKindMetadata.getProcessingInfo());
    assertNull(actualKotlinMultiFileFacadeKindMetadata.referencedPartClasses);
    assertEquals(0, actualKotlinMultiFileFacadeKindMetadata.getProcessingFlags());
    assertEquals(1, actualKotlinMultiFileFacadeKindMetadata.xi);
    assertEquals(4, actualKotlinMultiFileFacadeKindMetadata.k);
    assertArrayEquals(new int[] {1, 4, 1, 4}, actualKotlinMultiFileFacadeKindMetadata.mv);
  }

  /**
   * Test {@link KotlinMultiFileFacadeKindMetadata#accept(Clazz, KotlinMetadataVisitor)}.
   *
   * <p>Method under test: {@link KotlinMultiFileFacadeKindMetadata#accept(Clazz,
   * KotlinMetadataVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, KotlinMetadataVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinMultiFileFacadeKindMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.visitor.KotlinMetadataVisitor)"
  })
  void testAccept() {
    // Arrange
    KotlinMultiFileFacadeKindMetadata kotlinMultiFileFacadeKindMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 4, 1, 4}, new String[] {"D1"}, 1, "Xs", "Pn");
    LibraryClass clazz = new LibraryClass();
    KotlinMetadataVisitor kotlinMetadataVisitor = mock(KotlinMetadataVisitor.class);
    doNothing()
        .when(kotlinMetadataVisitor)
        .visitKotlinMultiFileFacadeMetadata(
            Mockito.<Clazz>any(), Mockito.<KotlinMultiFileFacadeKindMetadata>any());

    // Act
    kotlinMultiFileFacadeKindMetadata.accept(clazz, kotlinMetadataVisitor);

    // Assert
    verify(kotlinMetadataVisitor)
        .visitKotlinMultiFileFacadeMetadata(
            isA(Clazz.class), isA(KotlinMultiFileFacadeKindMetadata.class));
  }

  /**
   * Test {@link KotlinMultiFileFacadeKindMetadata#toString()}.
   *
   * <p>Method under test: {@link KotlinMultiFileFacadeKindMetadata#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.KotlinMultiFileFacadeKindMetadata.toString()"
  })
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Kotlin multi-file facade",
        (new KotlinMultiFileFacadeKindMetadata(
                new int[] {1, 4, 1, 4}, new String[] {"D1"}, 1, "Xs", "Pn"))
            .toString());
  }
}
