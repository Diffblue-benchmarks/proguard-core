package proguard.analysis.cpa.jvm.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InstructionClassifierDiffblueTest {
  /**
   * Test {@link InstructionClassifier#isReturn(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionClassifier#isReturn(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionClassifier.isReturn(byte)"})
  public void testIsReturn_whenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isReturn((byte) 'A'));
  }

  /**
   * Test {@link InstructionClassifier#isReturn(byte)}.
   *
   * <ul>
   *   <li>When minus seventy-nine.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionClassifier#isReturn(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionClassifier.isReturn(byte)"})
  public void testIsReturn_whenMinusSeventyNine_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(InstructionClassifier.isReturn((byte) -79));
  }

  /**
   * Test {@link InstructionClassifier#isTypedReturn(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionClassifier#isTypedReturn(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionClassifier.isTypedReturn(byte)"})
  public void testIsTypedReturn_whenA() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isTypedReturn((byte) 'A'));
  }

  /**
   * Test {@link InstructionClassifier#isTypedReturn(byte)}.
   *
   * <ul>
   *   <li>When minus seventy-nine.
   * </ul>
   *
   * <p>Method under test: {@link InstructionClassifier#isTypedReturn(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionClassifier.isTypedReturn(byte)"})
  public void testIsTypedReturn_whenMinusSeventyNine() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isTypedReturn((byte) -79));
  }

  /**
   * Test {@link InstructionClassifier#isInvoke(byte)}.
   *
   * <p>Method under test: {@link InstructionClassifier#isInvoke(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionClassifier.isInvoke(byte)"})
  public void testIsInvoke() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isInvoke((byte) 'A'));
  }

  /**
   * Test {@link InstructionClassifier#isLongShift(byte)}.
   *
   * <p>Method under test: {@link InstructionClassifier#isLongShift(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InstructionClassifier.isLongShift(byte)"})
  public void testIsLongShift() {
    // Arrange, Act and Assert
    assertFalse(InstructionClassifier.isLongShift((byte) 'A'));
  }
}
