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
import proguard.classfile.kotlin.flags.KotlinFunctionFlags;
import proguard.classfile.kotlin.flags.KotlinModalityFlags;
import proguard.classfile.kotlin.flags.KotlinVisibilityFlags;
import proguard.classfile.kotlin.visitor.KotlinContractVisitor;

class KotlinContractMetadataDiffblueTest {
  /**
   * Test {@link KotlinContractMetadata#accept(Clazz, KotlinMetadata, KotlinFunctionMetadata,
   * KotlinContractVisitor)}.
   *
   * <p>Method under test: {@link KotlinContractMetadata#accept(Clazz, KotlinMetadata,
   * KotlinFunctionMetadata, KotlinContractVisitor)}
   */
  @Test
  @DisplayName("Test accept(Clazz, KotlinMetadata, KotlinFunctionMetadata, KotlinContractVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinContractMetadata.accept(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinMetadata, proguard.classfile.kotlin.KotlinFunctionMetadata, proguard.classfile.kotlin.visitor.KotlinContractVisitor)"
  })
  void testAccept() {
    // Arrange
    KotlinContractMetadata kotlinContractMetadata = new KotlinContractMetadata();
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

    KotlinContractVisitor kotlinContractVisitor = mock(KotlinContractVisitor.class);
    doNothing()
        .when(kotlinContractVisitor)
        .visitContract(
            Mockito.<Clazz>any(),
            Mockito.<KotlinMetadata>any(),
            Mockito.<KotlinFunctionMetadata>any(),
            Mockito.<KotlinContractMetadata>any());

    // Act
    kotlinContractMetadata.accept(
        clazz, kotlinMetadata, kotlinFunctionMetadata, kotlinContractVisitor);

    // Assert
    verify(kotlinContractVisitor)
        .visitContract(
            isA(Clazz.class),
            isA(KotlinMetadata.class),
            isA(KotlinFunctionMetadata.class),
            isA(KotlinContractMetadata.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link KotlinContractMetadata}
   *   <li>{@link KotlinContractMetadata#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinContractMetadata.<init>()",
    "java.lang.String proguard.classfile.kotlin.KotlinContractMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    KotlinContractMetadata actualKotlinContractMetadata = new KotlinContractMetadata();

    // Assert
    assertEquals("Kotlin contract", actualKotlinContractMetadata.toString());
    assertNull(actualKotlinContractMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinContractMetadata.getProcessingFlags());
  }
}
