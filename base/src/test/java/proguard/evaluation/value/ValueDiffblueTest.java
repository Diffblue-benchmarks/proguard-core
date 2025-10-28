package proguard.evaluation.value;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ValueDiffblueTest {
  /**
   * Method under test: {@link Value#category1Value()}
   */
  @Test
  public void testCategory1Value() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new UnknownDoubleValue()).category1Value());
  }

  /**
   * Method under test: {@link Value#category2Value()}
   */
  @Test
  public void testCategory2Value() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).category2Value());
  }

  /**
   * Method under test: {@link Value#integerValue()}
   */
  @Test
  public void testIntegerValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).integerValue());
  }

  /**
   * Method under test: {@link Value#longValue()}
   */
  @Test
  public void testLongValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).longValue());
  }

  /**
   * Method under test: {@link Value#floatValue()}
   */
  @Test
  public void testFloatValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).floatValue());
  }

  /**
   * Method under test: {@link Value#doubleValue()}
   */
  @Test
  public void testDoubleValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).doubleValue());
  }

  /**
   * Method under test: {@link Value#referenceValue()}
   */
  @Test
  public void testReferenceValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).referenceValue());
  }

  /**
   * Method under test: {@link Value#instructionOffsetValue()}
   */
  @Test
  public void testInstructionOffsetValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).instructionOffsetValue());
  }

  /**
   * Method under test: {@link Value#isSpecific()}
   */
  @Test
  public void testIsSpecific() {
    // Arrange, Act and Assert
    assertFalse((new UnknownDoubleValue()).isSpecific());
    assertTrue(ParticularValueFactory.INTEGER_VALUE_0.isSpecific());
  }

  /**
   * Method under test: {@link Value#isParticular()}
   */
  @Test
  public void testIsParticular() {
    // Arrange, Act and Assert
    assertFalse((new UnknownDoubleValue()).isParticular());
    assertTrue(ParticularValueFactory.INTEGER_VALUE_0.isParticular());
  }

  /**
   * Method under test: {@link Value#copyIfMutable()}
   */
  @Test
  public void testCopyIfMutable() {
    // Arrange
    TopValue topValue = new TopValue();

    // Act and Assert
    assertSame(topValue, topValue.copyIfMutable());
  }
}
