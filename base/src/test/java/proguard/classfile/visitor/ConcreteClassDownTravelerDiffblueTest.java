package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.editor.AccessFixer;

public class ConcreteClassDownTravelerDiffblueTest {
  /**
   * Method under test: {@link ConcreteClassDownTraveler#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    ConcreteClassDownTraveler concreteClassDownTraveler = new ConcreteClassDownTraveler(new AccessFixer());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> concreteClassDownTraveler.visitAnyClass(new LibraryClass()));
  }
}
