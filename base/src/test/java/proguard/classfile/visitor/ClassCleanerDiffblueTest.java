package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class ClassCleanerDiffblueTest {
  /**
   * Method under test: {@link ClassCleaner#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    ClassCleaner classCleaner = new ClassCleaner();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> classCleaner.visitAnyClass(new LibraryClass()));
  }
}
