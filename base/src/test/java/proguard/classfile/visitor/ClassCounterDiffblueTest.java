package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class ClassCounterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ClassCounter}
   *   <li>{@link ClassCounter#visitAnyClass(Clazz)}
   *   <li>{@link ClassCounter#getCount()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassCounter.<init>()",
    "int ClassCounter.getCount()",
    "void ClassCounter.visitAnyClass(Clazz)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ClassCounter actualClassCounter = new ClassCounter();
    actualClassCounter.visitAnyClass(new LibraryClass());

    // Assert
    assertEquals(1, actualClassCounter.getCount());
  }
}
