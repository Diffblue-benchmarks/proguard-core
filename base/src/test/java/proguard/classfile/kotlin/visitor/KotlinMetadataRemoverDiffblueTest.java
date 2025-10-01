package proguard.classfile.kotlin.visitor;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class KotlinMetadataRemoverDiffblueTest {
  /**
   * Test {@link KotlinMetadataRemover#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataRemover#visitAnyClass(Clazz)}
   */
  @Test
  @DisplayName(
      "Test visitAnyClass(Clazz); when LibraryClass(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void KotlinMetadataRemover.visitAnyClass(Clazz)"})
  void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    KotlinMetadataRemover kotlinMetadataRemover = new KotlinMetadataRemover();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kotlinMetadataRemover.visitAnyClass(new LibraryClass()));
  }
}
