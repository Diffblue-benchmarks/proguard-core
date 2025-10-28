package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class ClassCounterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ClassCounter}
   *   <li>{@link ClassCounter#visitAnyClass(Clazz)}
   *   <li>{@link ClassCounter#getCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ClassCounter actualClassCounter = new ClassCounter();
    actualClassCounter.visitAnyClass(new LibraryClass());

    // Assert that nothing has changed
    assertEquals(1, actualClassCounter.getCount());
  }
}
