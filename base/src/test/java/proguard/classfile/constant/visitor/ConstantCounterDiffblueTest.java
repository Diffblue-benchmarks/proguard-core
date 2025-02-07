package proguard.classfile.constant.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

class ConstantCounterDiffblueTest {
  /**
   * Test {@link ConstantCounter#visitAnyConstant(Clazz, Constant)}.
   *
   * <p>Method under test: {@link ConstantCounter#visitAnyConstant(Clazz, Constant)}
   */
  @Test
  @DisplayName("Test visitAnyConstant(Clazz, Constant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantCounter.visitAnyConstant(proguard.classfile.Clazz, proguard.classfile.constant.Constant)"
  })
  void testVisitAnyConstant() {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantCounter.<init>()",
    "int proguard.classfile.constant.visitor.ConstantCounter.getCount()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConstantCounter()).getCount());
  }
}
