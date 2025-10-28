package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ParticularLongValueDiffblueTest {
  /**
   * Method under test: {@link ParticularLongValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    LongValue actualNegateResult = (new ParticularLongValue(42L)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof ParticularLongValue);
    assertEquals(-42L, actualNegateResult.value());
    assertTrue(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = (new ParticularLongValue(42L)).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ParticularIntegerValue);
    assertEquals(42, actualConvertToIntegerResult.value());
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertTrue(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new ParticularLongValue(42L)).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ParticularFloatValue);
    assertEquals(42.0f, actualConvertToFloatResult.value(), 0.0f);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertTrue(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new ParticularLongValue(42L)).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ParticularDoubleValue);
    assertEquals(42.0d, actualConvertToDoubleResult.value(), 0.0);
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).generalize(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange and Act
    LongValue actualGeneralizeResult = (new ParticularLongValue(42L)).generalize(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link ParticularLongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualGeneralizeResult = particularLongValue
        .generalize((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link ParticularLongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act and Assert
    assertSame(other, particularLongValue.generalize((LongValue) other));
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#generalize(ParticularLongValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act and Assert
    assertSame(particularLongValue, particularLongValue.generalize(new ParticularLongValue(42L)));
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#generalize(ParticularLongValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualGeneralizeResult = particularLongValue.generalize(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#generalize(ParticularLongValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange and Act
    LongValue actualGeneralizeResult = (new ParticularLongValue(42L)).generalize((ParticularLongValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link ParticularLongValue#add(LongValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).add(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#add(LongValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAddResult = particularLongValue.add(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualAddResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#add(LongValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAddResult = particularLongValue.add((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#add(ParticularLongValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAddResult = particularLongValue.add(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAddResult instanceof ParticularLongValue);
    assertEquals(84L, actualAddResult.value());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).subtract(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractResult = particularLongValue.subtract(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualSubtractResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractResult = particularLongValue
        .subtract((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#subtract(ParticularLongValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractResult = particularLongValue.subtract(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).subtractFrom(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange and Act
    LongValue actualSubtractFromResult = (new ParticularLongValue(42L))
        .subtractFrom(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(-42L, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractFromResult = particularLongValue
        .subtractFrom((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#subtractFrom(ParticularLongValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractFromResult = particularLongValue.subtractFrom(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).multiply(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualMultiplyResult = (new ParticularLongValue(42L)).multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularLongValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualMultiplyResult = particularLongValue
        .multiply((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#multiply(ParticularLongValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualMultiplyResult = particularLongValue.multiply(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularLongValue);
    assertEquals(1764L, actualMultiplyResult.value());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#divide(LongValue)}
   */
  @Test
  public void testDivide() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).divide(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#divide(LongValue)}
   */
  @Test
  public void testDivide2() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideResult = particularLongValue.divide(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualDivideResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#divide(LongValue)}
   */
  @Test
  public void testDivide3() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideResult = particularLongValue
        .divide((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#divide(ParticularLongValue)}
   */
  @Test
  public void testDivide4() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideResult = particularLongValue.divide(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularLongValue);
    assertEquals(1L, actualDivideResult.value());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).divideOf(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf2() throws ArithmeticException {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualDivideOfResult = (new ParticularLongValue(42L)).divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularLongValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf3() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideOfResult = particularLongValue
        .divideOf((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#divideOf(ParticularLongValue)}
   */
  @Test
  public void testDivideOf4() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideOfResult = particularLongValue.divideOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularLongValue);
    assertEquals(1L, actualDivideOfResult.value());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).remainder(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder2() throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderResult = (new ParticularLongValue(42L)).remainder(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularLongValue);
    assertEquals(0L, actualRemainderResult.value());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder3() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderResult = particularLongValue
        .remainder((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#remainder(ParticularLongValue)}
   */
  @Test
  public void testRemainder4() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderResult = particularLongValue.remainder(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularLongValue);
    assertEquals(0L, actualRemainderResult.value());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).remainderOf(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf2() throws ArithmeticException {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualRemainderOfResult = (new ParticularLongValue(42L)).remainderOf(other);

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularLongValue);
    assertEquals(other, actualRemainderOfResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf3() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderOfResult = particularLongValue
        .remainderOf((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#remainderOf(ParticularLongValue)}
   */
  @Test
  public void testRemainderOf4() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderOfResult = particularLongValue.remainderOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularLongValue);
    assertEquals(0L, actualRemainderOfResult.value());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft() {
    // Arrange and Act
    LongValue actualShiftLeftResult = (new ParticularLongValue(42L))
        .shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Method under test: {@link ParticularLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft2() {
    // Arrange and Act
    LongValue actualShiftLeftResult = (new ParticularLongValue(42L)).shiftLeft(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Method under test: {@link ParticularLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftLeftResult = particularLongValue.shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualShiftLeftResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftLeftResult = particularLongValue.shiftLeft(
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft5() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftLeftResult = particularLongValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularLongValue);
    assertEquals(184717953466368L, actualShiftLeftResult.value());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight() {
    // Arrange and Act
    LongValue actualShiftRightResult = (new ParticularLongValue(42L))
        .shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Method under test: {@link ParticularLongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight2() {
    // Arrange and Act
    LongValue actualShiftRightResult = (new ParticularLongValue(42L)).shiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Method under test: {@link ParticularLongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftRightResult = particularLongValue.shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualShiftRightResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftRightResult = particularLongValue.shiftRight(
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRight5() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftRightResult = particularLongValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof ParticularLongValue);
    assertEquals(0L, actualShiftRightResult.value());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult = (new ParticularLongValue(42L))
        .unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight2() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult = (new ParticularLongValue(42L))
        .unsignedShiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualUnsignedShiftRightResult = particularLongValue
        .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualUnsignedShiftRightResult);
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualUnsignedShiftRightResult = particularLongValue.unsignedShiftRight(
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularLongValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight5() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualUnsignedShiftRightResult = particularLongValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof ParticularLongValue);
    assertEquals(0L, actualUnsignedShiftRightResult.value());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#and(LongValue)}
   */
  @Test
  public void testAnd() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).and(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#and(LongValue)}
   */
  @Test
  public void testAnd2() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualAndResult = (new ParticularLongValue(42L)).and(other);

    // Assert
    assertTrue(actualAndResult instanceof ParticularLongValue);
    assertEquals(other, actualAndResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#and(LongValue)}
   */
  @Test
  public void testAnd3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAndResult = particularLongValue.and((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#and(ParticularLongValue)}
   */
  @Test
  public void testAnd4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAndResult = particularLongValue.and(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAndResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualAndResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#or(LongValue)}
   */
  @Test
  public void testOr() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).or(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#or(LongValue)}
   */
  @Test
  public void testOr2() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualOrResult = particularLongValue.or(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualOrResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualOrResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#or(LongValue)}
   */
  @Test
  public void testOr3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualOrResult = particularLongValue.or((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#or(ParticularLongValue)}
   */
  @Test
  public void testOr4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualOrResult = particularLongValue.or(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualOrResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualOrResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#xor(LongValue)}
   */
  @Test
  public void testXor() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).xor(other));
  }

  /**
   * Method under test: {@link ParticularLongValue#xor(LongValue)}
   */
  @Test
  public void testXor2() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult = particularLongValue.xor(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualXorResult);
  }

  /**
   * Method under test: {@link ParticularLongValue#xor(LongValue)}
   */
  @Test
  public void testXor3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult = particularLongValue.xor((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#xor(ParticularLongValue)}
   */
  @Test
  public void testXor4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult = particularLongValue.xor(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(0L, actualXorResult.value());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#compare(LongValue)}
   */
  @Test
  public void testCompare() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ParticularLongValue(42L)).compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularLongValue#compare(LongValue)}
   */
  @Test
  public void testCompare2() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ParticularLongValue(42L)).compare(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParticularLongValue#equals(Object)}
   *   <li>{@link ParticularLongValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);
    ParticularLongValue particularLongValue2 = new ParticularLongValue(42L);

    // Act and Assert
    assertEquals(particularLongValue, particularLongValue2);
    int expectedHashCodeResult = particularLongValue.hashCode();
    assertEquals(expectedHashCodeResult, particularLongValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParticularLongValue#equals(Object)}
   *   <li>{@link ParticularLongValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act and Assert
    assertEquals(particularLongValue, particularLongValue);
    int expectedHashCodeResult = particularLongValue.hashCode();
    assertEquals(expectedHashCodeResult, particularLongValue.hashCode());
  }

  /**
   * Method under test: {@link ParticularLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act and Assert
    assertNotEquals(particularLongValue, new ParticularLongValue(42L));
  }

  /**
   * Method under test: {@link ParticularLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularLongValue(42L), null);
  }

  /**
   * Method under test: {@link ParticularLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularLongValue(42L), "Different type to ParticularLongValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParticularLongValue#ParticularLongValue(long)}
   *   <li>{@link ParticularLongValue#toString()}
   *   <li>{@link ParticularLongValue#isParticular()}
   *   <li>{@link ParticularLongValue#value()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ParticularLongValue actualParticularLongValue = new ParticularLongValue(42L);
    String actualToStringResult = actualParticularLongValue.toString();
    boolean actualIsParticularResult = actualParticularLongValue.isParticular();

    // Assert
    assertEquals("42L", actualToStringResult);
    assertEquals(42L, actualParticularLongValue.value());
    assertTrue(actualIsParticularResult);
  }
}
