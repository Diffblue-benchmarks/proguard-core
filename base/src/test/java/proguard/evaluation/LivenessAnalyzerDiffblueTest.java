package proguard.evaluation;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class LivenessAnalyzerDiffblueTest {
  /**
   * Method under test: {@link LivenessAnalyzer#isTraced(int)}
   */
  @Test
  public void testIsTraced() {
    // Arrange, Act and Assert
    assertFalse((new LivenessAnalyzer()).isTraced(1));
  }

  /**
   * Method under test: {@link LivenessAnalyzer#isAliveBefore(int, int)}
   */
  @Test
  public void testIsAliveBefore() {
    // Arrange, Act and Assert
    assertFalse((new LivenessAnalyzer()).isAliveBefore(1, 1));
  }

  /**
   * Method under test: {@link LivenessAnalyzer#isAliveAfter(int, int)}
   */
  @Test
  public void testIsAliveAfter() {
    // Arrange, Act and Assert
    assertFalse((new LivenessAnalyzer()).isAliveAfter(1, 1));
  }

  /**
   * Method under test: {@link LivenessAnalyzer#isCategory2(int, int)}
   */
  @Test
  public void testIsCategory2() {
    // Arrange, Act and Assert
    assertFalse((new LivenessAnalyzer()).isCategory2(1, 1));
  }

  /**
   * Method under test: {@link LivenessAnalyzer#LivenessAnalyzer()}
   */
  @Test
  public void testNewLivenessAnalyzer() {
    // Arrange, Act and Assert
    assertFalse((new LivenessAnalyzer()).isTraced(1));
  }

  /**
   * Method under test:
   * {@link LivenessAnalyzer#LivenessAnalyzer(PartialEvaluator, boolean, InitializationFinder, boolean)}
   */
  @Test
  public void testNewLivenessAnalyzer2() {
    // Arrange
    PartialEvaluator partialEvaluator = new PartialEvaluator();

    // Act and Assert
    assertFalse((new LivenessAnalyzer(partialEvaluator, true, new InitializationFinder(), true)).isTraced(1));
  }
}
