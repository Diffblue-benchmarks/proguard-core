package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UnknownDoubleValueDiffblueTest {
  /**
   * Method under test: {@link UnknownDoubleValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.negate());
  }

  /**
   * Method under test: {@link UnknownDoubleValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = (new UnknownDoubleValue()).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof UnknownIntegerValue);
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertFalse(actualConvertToIntegerResult.isParticular());
    assertFalse(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Method under test: {@link UnknownDoubleValue#convertToLong()}
   */
  @Test
  public void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new UnknownDoubleValue()).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof UnknownLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertFalse(actualConvertToLongResult.isSpecific());
    assertTrue(actualConvertToLongResult.isCategory2());
  }

  /**
   * Method under test: {@link UnknownDoubleValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new UnknownDoubleValue()).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof UnknownFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertFalse(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Method under test: {@link UnknownDoubleValue#generalize(DoubleValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.generalize(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link UnknownDoubleValue#add(DoubleValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.add(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link UnknownDoubleValue#subtract(DoubleValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.subtract(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link UnknownDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.subtractFrom(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link UnknownDoubleValue#multiply(DoubleValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.multiply(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link UnknownDoubleValue#divide(DoubleValue)}
   */
  @Test
  public void testDivide() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.divide(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link UnknownDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  public void testDivideOf() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.divideOf(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link UnknownDoubleValue#remainder(DoubleValue)}
   */
  @Test
  public void testRemainder() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.remainder(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link UnknownDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  public void testRemainderOf() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.remainderOf(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link UnknownDoubleValue#compare(DoubleValue)}
   */
  @Test
  public void testCompare() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new UnknownDoubleValue()).compare(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UnknownDoubleValue#equals(Object)}
   *   <li>{@link UnknownDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();
    UnknownDoubleValue unknownDoubleValue2 = new UnknownDoubleValue();

    // Act and Assert
    assertEquals(unknownDoubleValue, unknownDoubleValue2);
    int expectedHashCodeResult = unknownDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownDoubleValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UnknownDoubleValue#equals(Object)}
   *   <li>{@link UnknownDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertEquals(unknownDoubleValue, unknownDoubleValue);
    int expectedHashCodeResult = unknownDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownDoubleValue.hashCode());
  }

  /**
   * Method under test: {@link UnknownDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownDoubleValue(), 1);
  }

  /**
   * Method under test: {@link UnknownDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownDoubleValue(), null);
  }

  /**
   * Method under test: {@link UnknownDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownDoubleValue(), "Different type to UnknownDoubleValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownDoubleValue}
   *   <li>{@link UnknownDoubleValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("d", (new UnknownDoubleValue()).toString());
  }
}
