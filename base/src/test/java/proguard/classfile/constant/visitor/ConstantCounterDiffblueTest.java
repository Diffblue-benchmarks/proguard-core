package proguard.classfile.constant.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

public class ConstantCounterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ConstantCounter}
   *   <li>{@link ConstantCounter#getCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConstantCounter()).getCount());
  }

  /**
   * Method under test: {@link ConstantCounter#visitAnyConstant(Clazz, Constant)}
   */
  @Test
  public void testVisitAnyConstant() {
    // Arrange
    ConstantCounter constantCounter = new ConstantCounter();
    LibraryClass clazz = new LibraryClass();

    // Act
    constantCounter.visitAnyConstant(clazz, new ClassConstant());

    // Assert
    assertEquals(1, constantCounter.getCount());
  }
}
