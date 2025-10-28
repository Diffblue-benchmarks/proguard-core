package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SpecificFloatValueDiffblueTest {
  /**
   * Method under test: {@link SpecificFloatValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    FloatValue actualNegateResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof NegatedFloatValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#negate()}
   */
  @Test
  public void testNegate2() {
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
   * Method under test: {@link SpecificFloatValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ConvertedIntegerValue);
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertFalse(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger2() {
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
   * Method under test: {@link SpecificFloatValue#convertToLong()}
   */
  @Test
  public void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ConvertedLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#convertToLong()}
   */
  @Test
  public void testConvertToLong2() {
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
   * Method under test: {@link SpecificFloatValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ConvertedDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble2() {
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
   * Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).generalize(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).generalize(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange and Act
    FloatValue actualGeneralizeResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .generalize(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    ConvertedFloatValue convertedFloatValue = new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedFloatValue other = new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, convertedFloatValue.generalize((FloatValue) other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    ConvertedFloatValue convertedFloatValue = new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    FloatValue actualGeneralizeResult = convertedFloatValue.generalize(
        (FloatValue) new ConvertedFloatValue(new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    ConvertedFloatValue convertedFloatValue = new ConvertedFloatValue(null);

    // Act
    FloatValue actualGeneralizeResult = convertedFloatValue.generalize(
        (FloatValue) new ConvertedFloatValue(new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#generalize(SpecificFloatValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act and Assert
    assertSame(particularFloatValue,
        particularFloatValue.generalize((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link SpecificFloatValue#generalize(SpecificFloatValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act
    FloatValue actualGeneralizeResult = particularFloatValue
        .generalize((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#generalize(SpecificFloatValue)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange and Act
    FloatValue actualGeneralizeResult = (new ParticularFloatValue(10.0f)).generalize((SpecificFloatValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#generalize(SpecificFloatValue)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualGeneralizeResult = particularFloatValue
        .generalize(new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#add(FloatValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).add(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#add(FloatValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).add(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#add(FloatValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange and Act
    FloatValue actualAddResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .add(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof CompositeFloatValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#add(SpecificFloatValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult = particularFloatValue.add((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualAddResult instanceof CompositeFloatValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#subtract(FloatValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtract(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#subtract(FloatValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).subtract(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#subtract(FloatValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange and Act
    FloatValue actualSubtractResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .subtract(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#subtract(SpecificFloatValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractResult = particularFloatValue
        .subtract((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtractFrom(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).subtractFrom(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange and Act
    FloatValue actualSubtractFromResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .subtractFrom(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificFloatValue#subtractFrom(SpecificFloatValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractFromResult = particularFloatValue
        .subtractFrom((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#multiply(FloatValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).multiply(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#multiply(FloatValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).multiply(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#multiply(FloatValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange and Act
    FloatValue actualMultiplyResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .multiply(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeFloatValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#multiply(SpecificFloatValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualMultiplyResult = particularFloatValue
        .multiply((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeFloatValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#divide(FloatValue)}
   */
  @Test
  public void testDivide() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divide(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#divide(FloatValue)}
   */
  @Test
  public void testDivide2() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).divide(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#divide(FloatValue)}
   */
  @Test
  public void testDivide3() {
    // Arrange and Act
    FloatValue actualDivideResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .divide(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof CompositeFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#divide(SpecificFloatValue)}
   */
  @Test
  public void testDivide4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideResult = particularFloatValue.divide((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#divideOf(FloatValue)}
   */
  @Test
  public void testDivideOf() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divideOf(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#divideOf(FloatValue)}
   */
  @Test
  public void testDivideOf2() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).divideOf(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#divideOf(FloatValue)}
   */
  @Test
  public void testDivideOf3() {
    // Arrange and Act
    FloatValue actualDivideOfResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .divideOf(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#divideOf(SpecificFloatValue)}
   */
  @Test
  public void testDivideOf4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideOfResult = particularFloatValue
        .divideOf((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#remainder(FloatValue)}
   */
  @Test
  public void testRemainder() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainder(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#remainder(FloatValue)}
   */
  @Test
  public void testRemainder2() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).remainder(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#remainder(FloatValue)}
   */
  @Test
  public void testRemainder3() {
    // Arrange and Act
    FloatValue actualRemainderResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .remainder(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#remainder(SpecificFloatValue)}
   */
  @Test
  public void testRemainder4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderResult = particularFloatValue
        .remainder((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#remainderOf(FloatValue)}
   */
  @Test
  public void testRemainderOf() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainderOf(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#remainderOf(FloatValue)}
   */
  @Test
  public void testRemainderOf2() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).remainderOf(other));
  }

  /**
   * Method under test: {@link SpecificFloatValue#remainderOf(FloatValue)}
   */
  @Test
  public void testRemainderOf3() {
    // Arrange and Act
    FloatValue actualRemainderOfResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .remainderOf(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#remainderOf(SpecificFloatValue)}
   */
  @Test
  public void testRemainderOf4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderOfResult = particularFloatValue
        .remainderOf((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#compare(FloatValue)}
   */
  @Test
  public void testCompare() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .compare(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#compare(FloatValue)}
   */
  @Test
  public void testCompare2() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ParticularFloatValue(10.0f)).compare(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#compare(FloatValue)}
   */
  @Test
  public void testCompare3() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .compare(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#compare(SpecificFloatValue)}
   */
  @Test
  public void testCompare4() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    IntegerValue actualCompareResult = particularFloatValue
        .compare((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#isSpecific()}
   */
  @Test
  public void testIsSpecific() {
    // Arrange, Act and Assert
    assertTrue((new ParticularFloatValue(10.0f)).isSpecific());
  }

  /**
   * Method under test: {@link SpecificFloatValue#equals(Object)}
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
   * Method under test: {@link SpecificFloatValue#equals(Object)}
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
   * Method under test: {@link SpecificFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act and Assert
    assertNotEquals(particularFloatValue, new ParticularFloatValue(10.0f));
  }

  /**
   * Method under test: {@link SpecificFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularFloatValue(10.0f), null);
  }

  /**
   * Method under test: {@link SpecificFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularFloatValue(10.0f), "Different type to SpecificFloatValue");
  }
}
