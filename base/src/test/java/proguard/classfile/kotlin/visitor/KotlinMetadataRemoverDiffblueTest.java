package proguard.classfile.kotlin.visitor;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class KotlinMetadataRemoverDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataRemover.visitAnyClass(Clazz)"})
  public void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    KotlinMetadataRemover kotlinMetadataRemover = new KotlinMetadataRemover();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kotlinMetadataRemover.visitAnyClass(new LibraryClass()));
  }
}
