package proguard.analysis;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;

class DominatorCalculatorDiffblueTest {
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
  @DisplayName("Test dominates(int, int); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.DominatorCalculator.dominates(int, int)"})
  void testDominates_thenReturnTrue() throws UnsupportedEncodingException {
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
  @DisplayName("Test dominates(int, int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.DominatorCalculator.dominates(int, int)"})
  void testDominates_whenTwo_thenReturnFalse() throws UnsupportedEncodingException {
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
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.DominatorCalculator.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute() {
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
