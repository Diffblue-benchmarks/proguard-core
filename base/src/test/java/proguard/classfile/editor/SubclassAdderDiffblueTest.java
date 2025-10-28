package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class SubclassAdderDiffblueTest {
  /**
   * Method under test: {@link SubclassAdder#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    LibraryClass subclass = new LibraryClass();
    SubclassAdder subclassAdder = new SubclassAdder(subclass);
    LibraryClass clazz = new LibraryClass();

    // Act
    subclassAdder.visitAnyClass(clazz);

    // Assert
    Clazz[] clazzArray = clazz.subClasses;
    assertEquals(1, clazzArray.length);
    assertEquals(1, clazz.subClassCount);
    assertSame(subclass, clazzArray[0]);
  }
}
