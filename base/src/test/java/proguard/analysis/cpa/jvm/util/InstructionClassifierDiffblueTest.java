package proguard.analysis.cpa.jvm.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class InstructionClassifierDiffblueTest {
  /**
   * Method under test: {@link InstructionClassifier#isReturn(byte)}
   */
  @Test
  public void testIsReturn() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isReturn((byte) 'A'));
    assertTrue(InstructionClassifier.isReturn((byte) -79));
  }

  /**
   * Method under test: {@link InstructionClassifier#isTypedReturn(byte)}
   */
  @Test
  public void testIsTypedReturn() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isTypedReturn((byte) 'A'));
    assertFalse(InstructionClassifier.isTypedReturn((byte) -79));
  }

  /**
   * Method under test: {@link InstructionClassifier#isInvoke(byte)}
   */
  @Test
  public void testIsInvoke() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isInvoke((byte) 'A'));
  }

  /**
   * Method under test: {@link InstructionClassifier#isLongShift(byte)}
   */
  @Test
  public void testIsLongShift() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isLongShift((byte) 'A'));
  }
}
