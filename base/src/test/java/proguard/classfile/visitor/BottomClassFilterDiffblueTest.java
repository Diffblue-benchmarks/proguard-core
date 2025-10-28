package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.editor.AccessFixer;

public class BottomClassFilterDiffblueTest {
  /**
   * Method under test: {@link BottomClassFilter#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    AccessFixer bottomClassVisitor = new AccessFixer();
    BottomClassFilter bottomClassFilter = new BottomClassFilter(bottomClassVisitor, new AccessFixer());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> bottomClassFilter.visitAnyClass(new LibraryClass()));
  }
}
