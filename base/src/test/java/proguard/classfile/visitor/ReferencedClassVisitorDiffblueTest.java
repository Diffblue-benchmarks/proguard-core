package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.editor.AccessFixer;

public class ReferencedClassVisitorDiffblueTest {
  /**
   * Method under test: {@link ReferencedClassVisitor#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    ReferencedClassVisitor referencedClassVisitor = new ReferencedClassVisitor(true, new AccessFixer());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> referencedClassVisitor.visitAnyClass(new LibraryClass()));
  }
}
