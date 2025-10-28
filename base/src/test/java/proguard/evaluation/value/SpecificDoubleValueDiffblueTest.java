package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SpecificDoubleValueDiffblueTest {
  /**
   * Method under test: {@link SpecificDoubleValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    DoubleValue actualNegateResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof NegatedDoubleValue);
    assertFalse(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#negate()}
   */
  @Test
  public void testNegate2() {
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
   * Method under test: {@link SpecificDoubleValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ConvertedIntegerValue);
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertFalse(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger2() {
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
   * Method under test: {@link SpecificDoubleValue#convertToLong()}
   */
  @Test
  public void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ConvertedLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#convertToLong()}
   */
  @Test
  public void testConvertToLong2() {
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
   * Method under test: {@link SpecificDoubleValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ConvertedFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat2() {
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
   * Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).generalize(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).generalize(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange and Act
    DoubleValue actualGeneralizeResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .generalize(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue = new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedDoubleValue other = new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, convertedDoubleValue.generalize((DoubleValue) other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue = new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    DoubleValue actualGeneralizeResult = convertedDoubleValue.generalize(
        (DoubleValue) new ConvertedDoubleValue(new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue = new ConvertedDoubleValue(null);

    // Act
    DoubleValue actualGeneralizeResult = convertedDoubleValue.generalize(
        (DoubleValue) new ConvertedDoubleValue(new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link SpecificDoubleValue#generalize(SpecificDoubleValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act and Assert
    assertSame(particularDoubleValue,
        particularDoubleValue.generalize((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test:
   * {@link SpecificDoubleValue#generalize(SpecificDoubleValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(0.5d);

    // Act
    DoubleValue actualGeneralizeResult = particularDoubleValue
        .generalize((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link SpecificDoubleValue#generalize(SpecificDoubleValue)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange and Act
    DoubleValue actualGeneralizeResult = (new ParticularDoubleValue(10.0d)).generalize((SpecificDoubleValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link SpecificDoubleValue#generalize(SpecificDoubleValue)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualGeneralizeResult = particularDoubleValue
        .generalize(new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#add(DoubleValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).add(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#add(DoubleValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).add(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#add(DoubleValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange and Act
    DoubleValue actualAddResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .add(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#add(SpecificDoubleValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualAddResult = particularDoubleValue.add((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#subtract(DoubleValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtract(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#subtract(DoubleValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).subtract(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#subtract(DoubleValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange and Act
    DoubleValue actualSubtractResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .subtract(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#subtract(SpecificDoubleValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractResult = particularDoubleValue
        .subtract((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtractFrom(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).subtractFrom(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange and Act
    DoubleValue actualSubtractFromResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .subtractFrom(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificDoubleValue#subtractFrom(SpecificDoubleValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractFromResult = particularDoubleValue
        .subtractFrom((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#multiply(DoubleValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).multiply(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#multiply(DoubleValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).multiply(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#multiply(DoubleValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange and Act
    DoubleValue actualMultiplyResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .multiply(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#multiply(SpecificDoubleValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualMultiplyResult = particularDoubleValue
        .multiply((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#divide(DoubleValue)}
   */
  @Test
  public void testDivide() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divide(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#divide(DoubleValue)}
   */
  @Test
  public void testDivide2() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).divide(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#divide(DoubleValue)}
   */
  @Test
  public void testDivide3() {
    // Arrange and Act
    DoubleValue actualDivideResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .divide(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#divide(SpecificDoubleValue)}
   */
  @Test
  public void testDivide4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideResult = particularDoubleValue
        .divide((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  public void testDivideOf() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divideOf(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  public void testDivideOf2() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).divideOf(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  public void testDivideOf3() {
    // Arrange and Act
    DoubleValue actualDivideOfResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .divideOf(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#divideOf(SpecificDoubleValue)}
   */
  @Test
  public void testDivideOf4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideOfResult = particularDoubleValue
        .divideOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#remainder(DoubleValue)}
   */
  @Test
  public void testRemainder() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainder(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#remainder(DoubleValue)}
   */
  @Test
  public void testRemainder2() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).remainder(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#remainder(DoubleValue)}
   */
  @Test
  public void testRemainder3() {
    // Arrange and Act
    DoubleValue actualRemainderResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .remainder(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#remainder(SpecificDoubleValue)}
   */
  @Test
  public void testRemainder4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderResult = particularDoubleValue
        .remainder((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  public void testRemainderOf() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainderOf(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  public void testRemainderOf2() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).remainderOf(other));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  public void testRemainderOf3() {
    // Arrange and Act
    DoubleValue actualRemainderOfResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .remainderOf(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificDoubleValue#remainderOf(SpecificDoubleValue)}
   */
  @Test
  public void testRemainderOf4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderOfResult = particularDoubleValue
        .remainderOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#compare(DoubleValue)}
   */
  @Test
  public void testCompare() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .compare(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#compare(DoubleValue)}
   */
  @Test
  public void testCompare2() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ParticularDoubleValue(10.0d)).compare(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#compare(DoubleValue)}
   */
  @Test
  public void testCompare3() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .compare(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#compare(SpecificDoubleValue)}
   */
  @Test
  public void testCompare4() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    IntegerValue actualCompareResult = particularDoubleValue
        .compare((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#isSpecific()}
   */
  @Test
  public void testIsSpecific() {
    // Arrange, Act and Assert
    assertTrue((new ParticularDoubleValue(10.0d)).isSpecific());
  }

  /**
   * Method under test: {@link SpecificDoubleValue#equals(Object)}
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
   * Method under test: {@link SpecificDoubleValue#equals(Object)}
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
   * Method under test: {@link SpecificDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(0.5d);

    // Act and Assert
    assertNotEquals(particularDoubleValue, new ParticularDoubleValue(10.0d));
  }

  /**
   * Method under test: {@link SpecificDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularDoubleValue(10.0d), null);
  }

  /**
   * Method under test: {@link SpecificDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularDoubleValue(10.0d), "Different type to SpecificDoubleValue");
  }
}
