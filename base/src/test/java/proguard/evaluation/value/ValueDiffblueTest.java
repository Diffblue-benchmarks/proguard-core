package proguard.evaluation.value;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ValueDiffblueTest {
  /**
   * Test {@link Value#category1Value()}.
   *
   * <p>Method under test: {@link Value#category1Value()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.Category1Value Value.category1Value()"})
  public void testCategory1Value() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new UnknownDoubleValue()).category1Value());
  }

  /**
   * Test {@link Value#category2Value()}.
   *
   * <p>Method under test: {@link Value#category2Value()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.Category2Value Value.category2Value()"})
  public void testCategory2Value() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).category2Value());
  }

  /**
   * Test {@link Value#integerValue()}.
   *
   * <p>Method under test: {@link Value#integerValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.IntegerValue Value.integerValue()"})
  public void testIntegerValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).integerValue());
  }

  /**
   * Test {@link Value#longValue()}.
   *
   * <p>Method under test: {@link Value#longValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.LongValue Value.longValue()"})
  public void testLongValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).longValue());
  }

  /**
   * Test {@link Value#floatValue()}.
   *
   * <p>Method under test: {@link Value#floatValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.FloatValue Value.floatValue()"})
  public void testFloatValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).floatValue());
  }

  /**
   * Test {@link Value#doubleValue()}.
   *
   * <p>Method under test: {@link Value#doubleValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.DoubleValue Value.doubleValue()"})
  public void testDoubleValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).doubleValue());
  }

  /**
   * Test {@link Value#referenceValue()}.
   *
   * <p>Method under test: {@link Value#referenceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.ReferenceValue Value.referenceValue()"})
  public void testReferenceValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).referenceValue());
  }

  /**
   * Test {@link Value#instructionOffsetValue()}.
   *
   * <p>Method under test: {@link Value#instructionOffsetValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.InstructionOffsetValue Value.instructionOffsetValue()"
  })
  public void testInstructionOffsetValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).instructionOffsetValue());
  }

  /**
   * Test {@link Value#isSpecific()}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Value#isSpecific()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isSpecific()"})
  public void testIsSpecific_givenInteger_value_0_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ParticularValueFactory.INTEGER_VALUE_0.isSpecific());
  }

  /**
   * Test {@link Value#isSpecific()}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Value#isSpecific()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isSpecific()"})
  public void testIsSpecific_givenUnknownDoubleValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new UnknownDoubleValue()).isSpecific());
  }

  /**
   * Test {@link Value#isParticular()}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Value#isParticular()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isParticular()"})
  public void testIsParticular_givenInteger_value_0_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ParticularValueFactory.INTEGER_VALUE_0.isParticular());
  }

  /**
   * Test {@link Value#isParticular()}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Value#isParticular()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Value.isParticular()"})
  public void testIsParticular_givenUnknownDoubleValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new UnknownDoubleValue()).isParticular());
  }

  /**
   * Test {@link Value#copyIfMutable()}.
   *
   * <p>Method under test: {@link Value#copyIfMutable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Value.copyIfMutable()"})
  public void testCopyIfMutable() {
    // Arrange
    TopValue topValue = new TopValue();

    // Act and Assert
    assertSame(topValue, topValue.copyIfMutable());
  }
}
