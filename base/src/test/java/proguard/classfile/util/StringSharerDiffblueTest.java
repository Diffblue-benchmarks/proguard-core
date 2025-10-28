package proguard.classfile.util;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class StringSharerDiffblueTest {
  /**
   * Method under test: {@link StringSharer#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    StringSharer stringSharer = new StringSharer(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> stringSharer.visitAnyClass(new LibraryClass()));
  }
}
