package proguard.evaluation;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LivenessAnalyzerDiffblueTest {
  /**
   * Test {@link LivenessAnalyzer#LivenessAnalyzer()}.
   *
   * <p>Method under test: {@link LivenessAnalyzer#LivenessAnalyzer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LivenessAnalyzer.<init>()"})
  public void testNewLivenessAnalyzer() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LivenessAnalyzer.<init>(PartialEvaluator, boolean, InitializationFinder, boolean)"
  })
  public void testNewLivenessAnalyzer2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LivenessAnalyzer.isTraced(int)"})
  public void testIsTraced_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LivenessAnalyzer.isAliveBefore(int, int)"})
  public void testIsAliveBefore_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LivenessAnalyzer.isAliveAfter(int, int)"})
  public void testIsAliveAfter_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LivenessAnalyzer.isCategory2(int, int)"})
  public void testIsCategory2_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LivenessAnalyzer()).isCategory2(1, 1));
  }
}
