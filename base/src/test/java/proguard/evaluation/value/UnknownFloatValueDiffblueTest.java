package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UnknownFloatValueDiffblueTest {
  /**
   * Method under test: {@link UnknownFloatValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.negate());
  }

  /**
   * Method under test: {@link UnknownFloatValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = (new UnknownFloatValue()).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof UnknownIntegerValue);
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertFalse(actualConvertToIntegerResult.isParticular());
    assertFalse(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Method under test: {@link UnknownFloatValue#convertToLong()}
   */
  @Test
  public void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new UnknownFloatValue()).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof UnknownLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertFalse(actualConvertToLongResult.isSpecific());
    assertTrue(actualConvertToLongResult.isCategory2());
  }

  /**
   * Method under test: {@link UnknownFloatValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new UnknownFloatValue()).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof UnknownDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertFalse(actualConvertToDoubleResult.isSpecific());
    assertTrue(actualConvertToDoubleResult.isCategory2());
  }

  /**
   * Method under test: {@link UnknownFloatValue#generalize(FloatValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.generalize(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link UnknownFloatValue#add(FloatValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.add(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link UnknownFloatValue#subtract(FloatValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.subtract(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link UnknownFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.subtractFrom(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link UnknownFloatValue#multiply(FloatValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.multiply(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link UnknownFloatValue#divide(FloatValue)}
   */
  @Test
  public void testDivide() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.divide(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link UnknownFloatValue#divideOf(FloatValue)}
   */
  @Test
  public void testDivideOf() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.divideOf(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link UnknownFloatValue#remainder(FloatValue)}
   */
  @Test
  public void testRemainder() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.remainder(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link UnknownFloatValue#remainderOf(FloatValue)}
   */
  @Test
  public void testRemainderOf() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.remainderOf(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link UnknownFloatValue#compare(FloatValue)}
   */
  @Test
  public void testCompare() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new UnknownFloatValue()).compare(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UnknownFloatValue#equals(Object)}
   *   <li>{@link UnknownFloatValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();
    UnknownFloatValue unknownFloatValue2 = new UnknownFloatValue();

    // Act and Assert
    assertEquals(unknownFloatValue, unknownFloatValue2);
    int expectedHashCodeResult = unknownFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownFloatValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UnknownFloatValue#equals(Object)}
   *   <li>{@link UnknownFloatValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertEquals(unknownFloatValue, unknownFloatValue);
    int expectedHashCodeResult = unknownFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownFloatValue.hashCode());
  }

  /**
   * Method under test: {@link UnknownFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownFloatValue(), 1);
  }

  /**
   * Method under test: {@link UnknownFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownFloatValue(), null);
  }

  /**
   * Method under test: {@link UnknownFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownFloatValue(), "Different type to UnknownFloatValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownFloatValue}
   *   <li>{@link UnknownFloatValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("f", (new UnknownFloatValue()).toString());
  }
}
