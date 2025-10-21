package proguard.analysis;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;

public class DominatorCalculatorDiffblueTest {
  /**
   * Test {@link DominatorCalculator#dominates(int, int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DominatorCalculator#dominates(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DominatorCalculator.dominates(int, int)"})
  public void testDominates_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    DominatorCalculator dominatorCalculator = new DominatorCalculator(true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method =
        new LibraryMethod(
            9008,
            "No dominator information known for offset %d",
            "No dominator information known for offset %d");

    dominatorCalculator.visitCodeAttribute(
        clazz, method, new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertTrue(dominatorCalculator.dominates(1, 1));
  }

  /**
   * Test {@link DominatorCalculator#dominates(int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DominatorCalculator#dominates(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DominatorCalculator.dominates(int, int)"})
  public void testDominates_whenTwo_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    DominatorCalculator dominatorCalculator = new DominatorCalculator(true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method =
        new LibraryMethod(
            9008,
            "No dominator information known for offset %d",
            "No dominator information known for offset %d");

    dominatorCalculator.visitCodeAttribute(
        clazz, method, new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertFalse(dominatorCalculator.dominates(2, 1));
  }

  /**
   * Test {@link DominatorCalculator#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link DominatorCalculator#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DominatorCalculator.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute() {
    // Arrange
    DominatorCalculator dominatorCalculator = new DominatorCalculator(true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    dominatorCalculator.visitCodeAttribute(
        clazz, method, new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2}));

    // Assert
    assertTrue(dominatorCalculator.dominates(1, 1));
  }
}
