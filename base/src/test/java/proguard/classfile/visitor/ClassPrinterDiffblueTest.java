package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class ClassPrinterDiffblueTest {
  /**
   * Method under test: {@link ClassPrinter#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> classPrinter.visitAnyClass(new LibraryClass()));
  }
}
