package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LivenessAnalyzerDiffblueTest {
  /**
   * Test {@link LivenessAnalyzer#LivenessAnalyzer()}.
   *
   * <p>Method under test: {@link LivenessAnalyzer#LivenessAnalyzer()}
   */
  @Test
  @DisplayName("Test new LivenessAnalyzer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.LivenessAnalyzer.<init>()"})
  void testNewLivenessAnalyzer() {
    // Arrange, Act and Assert
    assertFalse((new LivenessAnalyzer()).isTraced(1));
  }

  /**
   * Test {@link LivenessAnalyzer#LivenessAnalyzer(PartialEvaluator, boolean, InitializationFinder,
   * boolean)}.
   *
   * <p>Method under test: {@link LivenessAnalyzer#LivenessAnalyzer(PartialEvaluator, boolean,
   * InitializationFinder, boolean)}
   */
  @Test
  @DisplayName(
      "Test new LivenessAnalyzer(PartialEvaluator, boolean, InitializationFinder, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.LivenessAnalyzer.<init>(proguard.evaluation.PartialEvaluator, boolean, proguard.evaluation.InitializationFinder, boolean)"
  })
  void testNewLivenessAnalyzer2() {
    // Arrange
    PartialEvaluator partialEvaluator = new PartialEvaluator();

    // Act and Assert
    assertFalse(
        (new LivenessAnalyzer(partialEvaluator, true, new InitializationFinder(), true))
            .isTraced(1));
  }

  /**
   * Test {@link LivenessAnalyzer#isTraced(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LivenessAnalyzer#isTraced(int)}
   */
  @Test
  @DisplayName("Test isTraced(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.LivenessAnalyzer.isTraced(int)"})
  void testIsTraced_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LivenessAnalyzer()).isTraced(1));
  }

  /**
   * Test {@link LivenessAnalyzer#isAliveBefore(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LivenessAnalyzer#isAliveBefore(int, int)}
   */
  @Test
  @DisplayName("Test isAliveBefore(int, int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.LivenessAnalyzer.isAliveBefore(int, int)"})
  void testIsAliveBefore_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LivenessAnalyzer()).isAliveBefore(1, 1));
  }

  /**
   * Test {@link LivenessAnalyzer#isAliveAfter(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LivenessAnalyzer#isAliveAfter(int, int)}
   */
  @Test
  @DisplayName("Test isAliveAfter(int, int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.LivenessAnalyzer.isAliveAfter(int, int)"})
  void testIsAliveAfter_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LivenessAnalyzer()).isAliveAfter(1, 1));
  }

  /**
   * Test {@link LivenessAnalyzer#isCategory2(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LivenessAnalyzer#isCategory2(int, int)}
   */
  @Test
  @DisplayName("Test isCategory2(int, int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.LivenessAnalyzer.isCategory2(int, int)"})
  void testIsCategory2_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LivenessAnalyzer()).isCategory2(1, 1));
  }
}
