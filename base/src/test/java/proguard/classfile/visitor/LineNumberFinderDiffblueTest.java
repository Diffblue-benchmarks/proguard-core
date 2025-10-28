package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LineNumberTableAttribute;

public class LineNumberFinderDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LineNumberFinder#LineNumberFinder(int)}
   *   <li>{@link LineNumberFinder#visitAnyAttribute(Clazz, Attribute)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LineNumberFinder actualLineNumberFinder = new LineNumberFinder(2);
    LibraryClass clazz = new LibraryClass();
    actualLineNumberFinder.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert that nothing has changed
    assertEquals(-1, actualLineNumberFinder.lineNumber);
  }

  /**
   * Method under test:
   * {@link LineNumberFinder#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  public void testVisitLineNumberTableAttribute() {
    // Arrange
    LineNumberFinder lineNumberFinder = new LineNumberFinder(2);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    lineNumberFinder.visitLineNumberTableAttribute(clazz, method, codeAttribute, new LineNumberTableAttribute());

    // Assert
    assertEquals(0, lineNumberFinder.lineNumber);
  }
}
