package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ParticularFloatValueDiffblueTest {
  /**
   * Method under test: {@link ParticularFloatValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    FloatValue actualNegateResult = (new ParticularFloatValue(10.0f)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof ParticularFloatValue);
    assertEquals(-10.0f, actualNegateResult.value(), 0.0f);
    assertFalse(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = (new ParticularFloatValue(10.0f)).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ParticularIntegerValue);
    assertEquals(10, actualConvertToIntegerResult.value());
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertTrue(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#convertToLong()}
   */
  @Test
  public void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new ParticularFloatValue(10.0f)).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ParticularLongValue);
    assertEquals(10L, actualConvertToLongResult.value());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new ParticularFloatValue(10.0f)).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ParticularDoubleValue);
    assertEquals(10.0d, actualConvertToDoubleResult.value(), 0.0);
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).generalize(other));
  }

  /**
   * Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange and Act
    FloatValue actualGeneralizeResult = (new ParticularFloatValue(10.0f))
        .generalize(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualGeneralizeResult = particularFloatValue.generalize(
        (FloatValue) new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);
    ParticularFloatValue other = new ParticularFloatValue(10.0f);

    // Act and Assert
    assertSame(other, particularFloatValue.generalize((FloatValue) other));
  }

  /**
   * Method under test:
   * {@link ParticularFloatValue#generalize(ParticularFloatValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act and Assert
    assertSame(particularFloatValue, particularFloatValue.generalize(new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test:
   * {@link ParticularFloatValue#generalize(ParticularFloatValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act
    FloatValue actualGeneralizeResult = particularFloatValue.generalize(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#add(FloatValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).add(other));
  }

  /**
   * Method under test: {@link ParticularFloatValue#add(FloatValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult = particularFloatValue.add(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof ParticularFloatValue);
    assertEquals(particularFloatValue, actualAddResult);
  }

  /**
   * Method under test: {@link ParticularFloatValue#add(FloatValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult = particularFloatValue.add(
        (FloatValue) new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeFloatValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#add(ParticularFloatValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult = particularFloatValue.add(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualAddResult instanceof ParticularFloatValue);
    assertEquals(20.0f, actualAddResult.value(), 0.0f);
    assertFalse(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#subtract(FloatValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).subtract(other));
  }

  /**
   * Method under test: {@link ParticularFloatValue#subtract(FloatValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractResult = particularFloatValue.subtract(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularFloatValue);
    assertEquals(particularFloatValue, actualSubtractResult);
  }

  /**
   * Method under test: {@link ParticularFloatValue#subtract(FloatValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractResult = particularFloatValue.subtract(
        (FloatValue) new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularFloatValue#subtract(ParticularFloatValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractResult = particularFloatValue.subtract(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualSubtractResult.value(), 0.0f);
    assertFalse(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).subtractFrom(other));
  }

  /**
   * Method under test: {@link ParticularFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange and Act
    FloatValue actualSubtractFromResult = (new ParticularFloatValue(10.0f))
        .subtractFrom(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularFloatValue);
    assertEquals(-10.0f, actualSubtractFromResult.value(), 0.0f);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractFromResult = particularFloatValue.subtractFrom(
        (FloatValue) new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularFloatValue#subtractFrom(ParticularFloatValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractFromResult = particularFloatValue.subtractFrom(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualSubtractFromResult.value(), 0.0f);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#multiply(FloatValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).multiply(other));
  }

  /**
   * Method under test: {@link ParticularFloatValue#multiply(FloatValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange
    FloatValue other = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualMultiplyResult = (new ParticularFloatValue(10.0f)).multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularFloatValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Method under test: {@link ParticularFloatValue#multiply(FloatValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualMultiplyResult = particularFloatValue.multiply(
        (FloatValue) new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeFloatValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularFloatValue#multiply(ParticularFloatValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualMultiplyResult = particularFloatValue.multiply(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularFloatValue);
    assertEquals(100.0f, actualMultiplyResult.value(), 0.0f);
    assertFalse(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#divide(FloatValue)}
   */
  @Test
  public void testDivide() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).divide(other));
  }

  /**
   * Method under test: {@link ParticularFloatValue#divide(FloatValue)}
   */
  @Test
  public void testDivide2() {
    // Arrange and Act
    FloatValue actualDivideResult = (new ParticularFloatValue(10.0f)).divide(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
    assertEquals(Float.POSITIVE_INFINITY, actualDivideResult.value(), 0.0f);
  }

  /**
   * Method under test: {@link ParticularFloatValue#divide(FloatValue)}
   */
  @Test
  public void testDivide3() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideResult = particularFloatValue.divide(
        (FloatValue) new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#divide(ParticularFloatValue)}
   */
  @Test
  public void testDivide4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideResult = particularFloatValue.divide(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularFloatValue);
    assertEquals(1.0f, actualDivideResult.value(), 0.0f);
    assertFalse(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#divideOf(FloatValue)}
   */
  @Test
  public void testDivideOf() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).divideOf(other));
  }

  /**
   * Method under test: {@link ParticularFloatValue#divideOf(FloatValue)}
   */
  @Test
  public void testDivideOf2() {
    // Arrange
    FloatValue other = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualDivideOfResult = (new ParticularFloatValue(10.0f)).divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularFloatValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Method under test: {@link ParticularFloatValue#divideOf(FloatValue)}
   */
  @Test
  public void testDivideOf3() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideOfResult = particularFloatValue.divideOf(
        (FloatValue) new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularFloatValue#divideOf(ParticularFloatValue)}
   */
  @Test
  public void testDivideOf4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideOfResult = particularFloatValue.divideOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularFloatValue);
    assertEquals(1.0f, actualDivideOfResult.value(), 0.0f);
    assertFalse(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#remainder(FloatValue)}
   */
  @Test
  public void testRemainder() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).remainder(other));
  }

  /**
   * Method under test: {@link ParticularFloatValue#remainder(FloatValue)}
   */
  @Test
  public void testRemainder2() {
    // Arrange and Act
    FloatValue actualRemainderResult = (new ParticularFloatValue(10.0f))
        .remainder(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
    assertEquals(Float.NaN, actualRemainderResult.value(), 0.0f);
  }

  /**
   * Method under test: {@link ParticularFloatValue#remainder(FloatValue)}
   */
  @Test
  public void testRemainder3() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderResult = particularFloatValue.remainder(
        (FloatValue) new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularFloatValue#remainder(ParticularFloatValue)}
   */
  @Test
  public void testRemainder4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderResult = particularFloatValue.remainder(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualRemainderResult.value(), 0.0f);
    assertFalse(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#remainderOf(FloatValue)}
   */
  @Test
  public void testRemainderOf() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).remainderOf(other));
  }

  /**
   * Method under test: {@link ParticularFloatValue#remainderOf(FloatValue)}
   */
  @Test
  public void testRemainderOf2() {
    // Arrange
    FloatValue other = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualRemainderOfResult = (new ParticularFloatValue(10.0f)).remainderOf(other);

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularFloatValue);
    assertEquals(other, actualRemainderOfResult);
  }

  /**
   * Method under test: {@link ParticularFloatValue#remainderOf(FloatValue)}
   */
  @Test
  public void testRemainderOf3() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderOfResult = particularFloatValue.remainderOf(
        (FloatValue) new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularFloatValue#remainderOf(ParticularFloatValue)}
   */
  @Test
  public void testRemainderOf4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderOfResult = particularFloatValue.remainderOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualRemainderOfResult.value(), 0.0f);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  public void testCompare() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ParticularFloatValue(10.0f)).compare(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  public void testCompare2() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ParticularFloatValue(10.0f)).compare(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  public void testCompare3() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    IntegerValue actualCompareResult = particularFloatValue.compare(
        (FloatValue) new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  public void testCompare4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    IntegerValue actualCompareResult = particularFloatValue.compare((FloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(0, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  public void testCompare5() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ParticularFloatValue(-0.5f)).compare(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
    assertEquals(Value.NEVER, actualCompareResult.value());
  }

  /**
   * Method under test: {@link ParticularFloatValue#compare(ParticularFloatValue)}
   */
  @Test
  public void testCompare6() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    IntegerValue actualCompareResult = particularFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(0, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularFloatValue#compare(ParticularFloatValue)}
   */
  @Test
  public void testCompare7() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act
    IntegerValue actualCompareResult = particularFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
    assertEquals(Value.NEVER, actualCompareResult.value());
  }

  /**
   * Method under test: {@link ParticularFloatValue#compare(ParticularFloatValue)}
   */
  @Test
  public void testCompare8() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(Float.NaN);

    // Act
    IntegerValue actualCompareResult = particularFloatValue.compare(new ParticularFloatValue(10.0f));

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
   *   <li>{@link ParticularFloatValue#equals(Object)}
   *   <li>{@link ParticularFloatValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);
    ParticularFloatValue particularFloatValue2 = new ParticularFloatValue(10.0f);

    // Act and Assert
    assertEquals(particularFloatValue, particularFloatValue2);
    int expectedHashCodeResult = particularFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, particularFloatValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParticularFloatValue#equals(Object)}
   *   <li>{@link ParticularFloatValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act and Assert
    assertEquals(particularFloatValue, particularFloatValue);
    int expectedHashCodeResult = particularFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, particularFloatValue.hashCode());
  }

  /**
   * Method under test: {@link ParticularFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act and Assert
    assertNotEquals(particularFloatValue, new ParticularFloatValue(10.0f));
  }

  /**
   * Method under test: {@link ParticularFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularFloatValue(10.0f), null);
  }

  /**
   * Method under test: {@link ParticularFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularFloatValue(10.0f), "Different type to ParticularFloatValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParticularFloatValue#ParticularFloatValue(float)}
   *   <li>{@link ParticularFloatValue#toString()}
   *   <li>{@link ParticularFloatValue#isParticular()}
   *   <li>{@link ParticularFloatValue#value()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ParticularFloatValue actualParticularFloatValue = new ParticularFloatValue(10.0f);
    String actualToStringResult = actualParticularFloatValue.toString();
    boolean actualIsParticularResult = actualParticularFloatValue.isParticular();

    // Assert
    assertEquals("10.0f", actualToStringResult);
    assertEquals(10.0f, actualParticularFloatValue.value(), 0.0f);
    assertTrue(actualIsParticularResult);
  }
}
