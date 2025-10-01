package proguard.analysis;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DominatorCalculator.dominates(int, int)"})
  void testDominates_thenReturnTrue() {
    // Arrange
    DominatorCalculator dominatorCalculator = new DominatorCalculator(true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method =
        new LibraryMethod(
            9008,
            "No dominator information known for offset %d",
            "No dominator information known for offset %d");

    dominatorCalculator.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Act and Assert
    assertTrue(dominatorCalculator.dominates(0, 0));
  }

  /**
   * Test {@link DominatorCalculator#dominates(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DominatorCalculator#dominates(int, int)}
   */
  @Test
  @DisplayName("Test dominates(int, int); when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DominatorCalculator.dominates(int, int)"})
  void testDominates_whenOne_thenReturnFalse() {
    // Arrange
    DominatorCalculator dominatorCalculator = new DominatorCalculator(true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method =
        new LibraryMethod(
            9008,
            "No dominator information known for offset %d",
            "No dominator information known for offset %d");

    dominatorCalculator.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Act and Assert
    assertFalse(dominatorCalculator.dominates(1, 0));
  }

  /**
   * Test {@link DominatorCalculator#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link DominatorCalculator#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName("Test visitCodeAttribute(Clazz, Method, CodeAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DominatorCalculator.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  void testVisitCodeAttribute() {
    // Arrange
    DominatorCalculator dominatorCalculator = new DominatorCalculator(true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    dominatorCalculator.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    assertTrue(dominatorCalculator.dominates(1, 1));
  }
}
