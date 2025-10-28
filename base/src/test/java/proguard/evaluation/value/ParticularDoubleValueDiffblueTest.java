package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ParticularDoubleValueDiffblueTest {
  /**
   * Method under test: {@link ParticularDoubleValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    DoubleValue actualNegateResult = (new ParticularDoubleValue(10.0d)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof ParticularDoubleValue);
    assertEquals(-10.0d, actualNegateResult.value(), 0.0);
    assertTrue(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = (new ParticularDoubleValue(10.0d)).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ParticularIntegerValue);
    assertEquals(10, actualConvertToIntegerResult.value());
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertTrue(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#convertToLong()}
   */
  @Test
  public void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new ParticularDoubleValue(10.0d)).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ParticularLongValue);
    assertEquals(10L, actualConvertToLongResult.value());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new ParticularDoubleValue(10.0d)).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ParticularFloatValue);
    assertEquals(10.0f, actualConvertToFloatResult.value(), 0.0f);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertTrue(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#generalize(DoubleValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).generalize(other));
  }

  /**
   * Method under test: {@link ParticularDoubleValue#generalize(DoubleValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange and Act
    DoubleValue actualGeneralizeResult = (new ParticularDoubleValue(10.0d))
        .generalize(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#generalize(DoubleValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualGeneralizeResult = particularDoubleValue
        .generalize((DoubleValue) new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
            BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#generalize(DoubleValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);
    ParticularDoubleValue other = new ParticularDoubleValue(10.0d);

    // Act and Assert
    assertSame(other, particularDoubleValue.generalize((DoubleValue) other));
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#generalize(ParticularDoubleValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act and Assert
    assertSame(particularDoubleValue, particularDoubleValue.generalize(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#generalize(ParticularDoubleValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(0.5d);

    // Act
    DoubleValue actualGeneralizeResult = particularDoubleValue.generalize(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#add(DoubleValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).add(other));
  }

  /**
   * Method under test: {@link ParticularDoubleValue#add(DoubleValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualAddResult = particularDoubleValue.add(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof ParticularDoubleValue);
    assertEquals(particularDoubleValue, actualAddResult);
  }

  /**
   * Method under test: {@link ParticularDoubleValue#add(DoubleValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualAddResult = particularDoubleValue
        .add((DoubleValue) new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
            BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#add(ParticularDoubleValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualAddResult = particularDoubleValue.add(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualAddResult instanceof ParticularDoubleValue);
    assertEquals(20.0d, actualAddResult.value(), 0.0);
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#subtract(DoubleValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).subtract(other));
  }

  /**
   * Method under test: {@link ParticularDoubleValue#subtract(DoubleValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractResult = particularDoubleValue.subtract(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularDoubleValue);
    assertEquals(particularDoubleValue, actualSubtractResult);
  }

  /**
   * Method under test: {@link ParticularDoubleValue#subtract(DoubleValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractResult = particularDoubleValue
        .subtract((DoubleValue) new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
            BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#subtract(ParticularDoubleValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractResult = particularDoubleValue.subtract(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularDoubleValue);
    assertEquals(0.0d, actualSubtractResult.value(), 0.0);
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).subtractFrom(other));
  }

  /**
   * Method under test: {@link ParticularDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange and Act
    DoubleValue actualSubtractFromResult = (new ParticularDoubleValue(10.0d))
        .subtractFrom(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularDoubleValue);
    assertEquals(-10.0d, actualSubtractFromResult.value(), 0.0);
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractFromResult = particularDoubleValue
        .subtractFrom((DoubleValue) new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
            BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#subtractFrom(ParticularDoubleValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractFromResult = particularDoubleValue.subtractFrom(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularDoubleValue);
    assertEquals(0.0d, actualSubtractFromResult.value(), 0.0);
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#multiply(DoubleValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).multiply(other));
  }

  /**
   * Method under test: {@link ParticularDoubleValue#multiply(DoubleValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange
    DoubleValue other = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualMultiplyResult = (new ParticularDoubleValue(10.0d)).multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularDoubleValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Method under test: {@link ParticularDoubleValue#multiply(DoubleValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualMultiplyResult = particularDoubleValue
        .multiply((DoubleValue) new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
            BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#multiply(ParticularDoubleValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualMultiplyResult = particularDoubleValue.multiply(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularDoubleValue);
    assertEquals(100.0d, actualMultiplyResult.value(), 0.0);
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#divide(DoubleValue)}
   */
  @Test
  public void testDivide() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).divide(other));
  }

  /**
   * Method under test: {@link ParticularDoubleValue#divide(DoubleValue)}
   */
  @Test
  public void testDivide2() {
    // Arrange and Act
    DoubleValue actualDivideResult = (new ParticularDoubleValue(10.0d)).divide(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularDoubleValue);
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
    assertEquals(Double.POSITIVE_INFINITY, actualDivideResult.value(), 0.0);
  }

  /**
   * Method under test: {@link ParticularDoubleValue#divide(DoubleValue)}
   */
  @Test
  public void testDivide3() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideResult = particularDoubleValue
        .divide((DoubleValue) new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
            BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#divide(ParticularDoubleValue)}
   */
  @Test
  public void testDivide4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideResult = particularDoubleValue.divide(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularDoubleValue);
    assertEquals(1.0d, actualDivideResult.value(), 0.0);
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  public void testDivideOf() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).divideOf(other));
  }

  /**
   * Method under test: {@link ParticularDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  public void testDivideOf2() {
    // Arrange
    DoubleValue other = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualDivideOfResult = (new ParticularDoubleValue(10.0d)).divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularDoubleValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Method under test: {@link ParticularDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  public void testDivideOf3() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideOfResult = particularDoubleValue
        .divideOf((DoubleValue) new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
            BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#divideOf(ParticularDoubleValue)}
   */
  @Test
  public void testDivideOf4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideOfResult = particularDoubleValue.divideOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularDoubleValue);
    assertEquals(1.0d, actualDivideOfResult.value(), 0.0);
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#remainder(DoubleValue)}
   */
  @Test
  public void testRemainder() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).remainder(other));
  }

  /**
   * Method under test: {@link ParticularDoubleValue#remainder(DoubleValue)}
   */
  @Test
  public void testRemainder2() {
    // Arrange and Act
    DoubleValue actualRemainderResult = (new ParticularDoubleValue(10.0d))
        .remainder(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularDoubleValue);
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
    assertEquals(Double.NaN, actualRemainderResult.value(), 0.0);
  }

  /**
   * Method under test: {@link ParticularDoubleValue#remainder(DoubleValue)}
   */
  @Test
  public void testRemainder3() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderResult = particularDoubleValue
        .remainder((DoubleValue) new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
            BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#remainder(ParticularDoubleValue)}
   */
  @Test
  public void testRemainder4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderResult = particularDoubleValue.remainder(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularDoubleValue);
    assertEquals(0.0d, actualRemainderResult.value(), 0.0);
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  public void testRemainderOf() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).remainderOf(other));
  }

  /**
   * Method under test: {@link ParticularDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  public void testRemainderOf2() {
    // Arrange
    DoubleValue other = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualRemainderOfResult = (new ParticularDoubleValue(10.0d)).remainderOf(other);

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularDoubleValue);
    assertEquals(other, actualRemainderOfResult);
  }

  /**
   * Method under test: {@link ParticularDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  public void testRemainderOf3() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderOfResult = particularDoubleValue
        .remainderOf((DoubleValue) new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
            BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#remainderOf(ParticularDoubleValue)}
   */
  @Test
  public void testRemainderOf4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderOfResult = particularDoubleValue.remainderOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularDoubleValue);
    assertEquals(0.0d, actualRemainderOfResult.value(), 0.0);
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#compare(DoubleValue)}
   */
  @Test
  public void testCompare() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ParticularDoubleValue(10.0d)).compare(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#compare(DoubleValue)}
   */
  @Test
  public void testCompare2() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ParticularDoubleValue(10.0d))
        .compare(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#compare(DoubleValue)}
   */
  @Test
  public void testCompare3() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    IntegerValue actualCompareResult = particularDoubleValue
        .compare((DoubleValue) new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
            BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#compare(DoubleValue)}
   */
  @Test
  public void testCompare4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    IntegerValue actualCompareResult = particularDoubleValue.compare((DoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(0, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#compare(DoubleValue)}
   */
  @Test
  public void testCompare5() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ParticularDoubleValue(-0.5d))
        .compare(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
    assertEquals(Value.NEVER, actualCompareResult.value());
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  public void testCompare6() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    IntegerValue actualCompareResult = particularDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(0, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  public void testCompare7() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(0.5d);

    // Act
    IntegerValue actualCompareResult = particularDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
    assertEquals(Value.NEVER, actualCompareResult.value());
  }

  /**
   * Method under test:
   * {@link ParticularDoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  public void testCompare8() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(Double.NaN);

    // Act
    IntegerValue actualCompareResult = particularDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParticularDoubleValue#equals(Object)}
   *   <li>{@link ParticularDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);
    ParticularDoubleValue particularDoubleValue2 = new ParticularDoubleValue(10.0d);

    // Act and Assert
    assertEquals(particularDoubleValue, particularDoubleValue2);
    int expectedHashCodeResult = particularDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, particularDoubleValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParticularDoubleValue#equals(Object)}
   *   <li>{@link ParticularDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act and Assert
    assertEquals(particularDoubleValue, particularDoubleValue);
    int expectedHashCodeResult = particularDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, particularDoubleValue.hashCode());
  }

  /**
   * Method under test: {@link ParticularDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(0.5d);

    // Act and Assert
    assertNotEquals(particularDoubleValue, new ParticularDoubleValue(10.0d));
  }

  /**
   * Method under test: {@link ParticularDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularDoubleValue(10.0d), null);
  }

  /**
   * Method under test: {@link ParticularDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularDoubleValue(10.0d), "Different type to ParticularDoubleValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParticularDoubleValue#ParticularDoubleValue(double)}
   *   <li>{@link ParticularDoubleValue#toString()}
   *   <li>{@link ParticularDoubleValue#isParticular()}
   *   <li>{@link ParticularDoubleValue#value()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ParticularDoubleValue actualParticularDoubleValue = new ParticularDoubleValue(10.0d);
    String actualToStringResult = actualParticularDoubleValue.toString();
    boolean actualIsParticularResult = actualParticularDoubleValue.isParticular();

    // Assert
    assertEquals("10.0d", actualToStringResult);
    assertEquals(10.0d, actualParticularDoubleValue.value(), 0.0);
    assertTrue(actualIsParticularResult);
  }
}
