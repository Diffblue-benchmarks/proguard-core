package proguard.classfile.constant.visitor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

public class ConstantCounterDiffblueTest {
  /**
   * Test {@link ConstantCounter#visitAnyConstant(Clazz, Constant)}.
   *
   * <p>Method under test: {@link ConstantCounter#visitAnyConstant(Clazz, Constant)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantCounter.visitAnyConstant(Clazz, Constant)"})
  public void testVisitAnyConstant() {
    // Arrange
    ConstantCounter constantCounter = new ConstantCounter();
    LibraryClass clazz = new LibraryClass();

    // Act
    constantCounter.visitAnyConstant(clazz, new ClassConstant());

    // Assert
    assertEquals(1, constantCounter.getCount());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ConstantCounter}
   *   <li>{@link ConstantCounter#getCount()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantCounter.<init>()", "int ConstantCounter.getCount()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConstantCounter()).getCount());
  }
}
