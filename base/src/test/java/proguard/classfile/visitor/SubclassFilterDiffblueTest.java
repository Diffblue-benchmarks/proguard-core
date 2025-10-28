package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.editor.AccessFixer;

public class SubclassFilterDiffblueTest {
  /**
   * Method under test: {@link SubclassFilter#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    LibraryClass subclass = new LibraryClass();
    SubclassFilter subclassFilter = new SubclassFilter(subclass, new AccessFixer());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> subclassFilter.visitAnyClass(new LibraryClass()));
  }
}
