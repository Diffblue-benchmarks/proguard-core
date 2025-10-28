package proguard.classfile.kotlin.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class KotlinMetadataRemoverDiffblueTest {
  /**
   * Method under test: {@link KotlinMetadataRemover#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    KotlinMetadataRemover kotlinMetadataRemover = new KotlinMetadataRemover();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> kotlinMetadataRemover.visitAnyClass(new LibraryClass()));
  }
}
