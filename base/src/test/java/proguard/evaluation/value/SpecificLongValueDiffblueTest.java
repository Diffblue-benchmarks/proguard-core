package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SpecificLongValueDiffblueTest {
  /**
   * Method under test: {@link SpecificLongValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    LongValue actualNegateResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof NegatedLongValue);
    assertFalse(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#negate()}
   */
  @Test
  public void testNegate2() {
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
   * Method under test: {@link SpecificLongValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ConvertedIntegerValue);
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertFalse(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger2() {
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
   * Method under test: {@link SpecificLongValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ConvertedFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat2() {
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
   * Method under test: {@link SpecificLongValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ConvertedDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble2() {
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
   * Method under test: {@link SpecificLongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).generalize(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).generalize(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange and Act
    LongValue actualGeneralizeResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .generalize(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link SpecificLongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    ConvertedLongValue convertedLongValue = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedLongValue other = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, convertedLongValue.generalize((LongValue) other));
  }

  /**
   * Method under test: {@link SpecificLongValue#generalize(SpecificLongValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act and Assert
    assertSame(particularLongValue, particularLongValue.generalize((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link SpecificLongValue#generalize(SpecificLongValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualGeneralizeResult = particularLongValue.generalize((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link SpecificLongValue#generalize(SpecificLongValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange and Act
    LongValue actualGeneralizeResult = (new ParticularLongValue(42L)).generalize((SpecificLongValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link SpecificLongValue#generalize(SpecificLongValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualGeneralizeResult = particularLongValue
        .generalize(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link SpecificLongValue#add(LongValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).add(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#add(LongValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).add(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#add(LongValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange and Act
    LongValue actualAddResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .add(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#add(SpecificLongValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAddResult = particularLongValue.add((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtract(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).subtract(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange and Act
    LongValue actualSubtractResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .subtract(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    ConvertedLongValue convertedLongValue = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualSubtractResult = convertedLongValue
        .subtract((LongValue) new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtract(SpecificLongValue)}
   */
  @Test
  public void testSubtract5() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractResult = particularLongValue.subtract((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtract(SpecificLongValue)}
   */
  @Test
  public void testSubtract6() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualSubtractResult = particularLongValue.subtract((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtract(SpecificLongValue)}
   */
  @Test
  public void testSubtract7() {
    // Arrange and Act
    LongValue actualSubtractResult = (new ParticularLongValue(42L)).subtract((SpecificLongValue) null);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtract(SpecificLongValue)}
   */
  @Test
  public void testSubtract8() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractResult = particularLongValue
        .subtract(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtractFrom(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).subtractFrom(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange and Act
    LongValue actualSubtractFromResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .subtractFrom(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange
    ConvertedLongValue convertedLongValue = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualSubtractFromResult = convertedLongValue
        .subtractFrom((LongValue) new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  public void testSubtractFrom5() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractFromResult = particularLongValue
        .subtractFrom((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  public void testSubtractFrom6() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualSubtractFromResult = particularLongValue
        .subtractFrom((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  public void testSubtractFrom7() {
    // Arrange and Act
    LongValue actualSubtractFromResult = (new ParticularLongValue(42L)).subtractFrom((SpecificLongValue) null);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  public void testSubtractFrom8() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractFromResult = particularLongValue
        .subtractFrom(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).multiply(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).multiply(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange and Act
    LongValue actualMultiplyResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .multiply(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#multiply(SpecificLongValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualMultiplyResult = particularLongValue.multiply((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#divide(LongValue)}
   */
  @Test
  public void testDivide() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divide(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#divide(LongValue)}
   */
  @Test
  public void testDivide2() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).divide(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#divide(LongValue)}
   */
  @Test
  public void testDivide3() throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .divide(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#divide(SpecificLongValue)}
   */
  @Test
  public void testDivide4() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideResult = particularLongValue.divide((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divideOf(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf2() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).divideOf(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf3() throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideOfResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .divideOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#divideOf(SpecificLongValue)}
   */
  @Test
  public void testDivideOf4() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideOfResult = particularLongValue.divideOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainder(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder2() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).remainder(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder3() throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .remainder(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#remainder(SpecificLongValue)}
   */
  @Test
  public void testRemainder4() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderResult = particularLongValue.remainder((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainderOf(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf2() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).remainderOf(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf3() throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderOfResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .remainderOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#remainderOf(SpecificLongValue)}
   */
  @Test
  public void testRemainderOf4() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderOfResult = particularLongValue
        .remainderOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft() {
    // Arrange and Act
    LongValue actualShiftLeftResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftLeft(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Method under test: {@link SpecificLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft2() {
    // Arrange and Act
    LongValue actualShiftLeftResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#shiftLeft(SpecificLongValue)}
   */
  @Test
  public void testShiftLeft3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftLeftResult = particularLongValue.shiftLeft(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight() {
    // Arrange and Act
    LongValue actualShiftRightResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Method under test: {@link SpecificLongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight2() {
    // Arrange and Act
    LongValue actualShiftRightResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#shiftRight(SpecificLongValue)}
   */
  @Test
  public void testShiftRight3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftRightResult = particularLongValue.shiftRight(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .unsignedShiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Method under test: {@link SpecificLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight2() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificLongValue#unsignedShiftRight(SpecificLongValue)}
   */
  @Test
  public void testUnsignedShiftRight3() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualUnsignedShiftRightResult = particularLongValue.unsignedShiftRight(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#and(LongValue)}
   */
  @Test
  public void testAnd() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).and(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#and(LongValue)}
   */
  @Test
  public void testAnd2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).and(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#and(LongValue)}
   */
  @Test
  public void testAnd3() {
    // Arrange and Act
    LongValue actualAndResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .and(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#and(LongValue)}
   */
  @Test
  public void testAnd4() {
    // Arrange
    ConvertedLongValue convertedLongValue = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedLongValue other = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, convertedLongValue.and((LongValue) other));
  }

  /**
   * Method under test: {@link SpecificLongValue#and(SpecificLongValue)}
   */
  @Test
  public void testAnd5() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act and Assert
    assertSame(particularLongValue, particularLongValue.and((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link SpecificLongValue#and(SpecificLongValue)}
   */
  @Test
  public void testAnd6() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualAndResult = particularLongValue.and((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#and(SpecificLongValue)}
   */
  @Test
  public void testAnd7() {
    // Arrange and Act
    LongValue actualAndResult = (new ParticularLongValue(42L)).and((SpecificLongValue) null);

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#and(SpecificLongValue)}
   */
  @Test
  public void testAnd8() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAndResult = particularLongValue
        .and(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#or(LongValue)}
   */
  @Test
  public void testOr() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).or(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#or(LongValue)}
   */
  @Test
  public void testOr2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).or(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#or(LongValue)}
   */
  @Test
  public void testOr3() {
    // Arrange and Act
    LongValue actualOrResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .or(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#or(LongValue)}
   */
  @Test
  public void testOr4() {
    // Arrange
    ConvertedLongValue convertedLongValue = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedLongValue other = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, convertedLongValue.or((LongValue) other));
  }

  /**
   * Method under test: {@link SpecificLongValue#or(SpecificLongValue)}
   */
  @Test
  public void testOr5() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act and Assert
    assertSame(particularLongValue, particularLongValue.or((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link SpecificLongValue#or(SpecificLongValue)}
   */
  @Test
  public void testOr6() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualOrResult = particularLongValue.or((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#or(SpecificLongValue)}
   */
  @Test
  public void testOr7() {
    // Arrange and Act
    LongValue actualOrResult = (new ParticularLongValue(42L)).or((SpecificLongValue) null);

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#or(SpecificLongValue)}
   */
  @Test
  public void testOr8() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualOrResult = particularLongValue
        .or(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#xor(LongValue)}
   */
  @Test
  public void testXor() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).xor(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#xor(LongValue)}
   */
  @Test
  public void testXor2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).xor(other));
  }

  /**
   * Method under test: {@link SpecificLongValue#xor(LongValue)}
   */
  @Test
  public void testXor3() {
    // Arrange and Act
    LongValue actualXorResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .xor(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#xor(LongValue)}
   */
  @Test
  public void testXor4() {
    // Arrange
    ConvertedLongValue convertedLongValue = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualXorResult = convertedLongValue
        .xor((LongValue) new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(0L, actualXorResult.value());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#xor(SpecificLongValue)}
   */
  @Test
  public void testXor5() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult = particularLongValue.xor((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(0L, actualXorResult.value());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#xor(SpecificLongValue)}
   */
  @Test
  public void testXor6() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualXorResult = particularLongValue.xor((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#xor(SpecificLongValue)}
   */
  @Test
  public void testXor7() {
    // Arrange and Act
    LongValue actualXorResult = (new ParticularLongValue(42L)).xor((SpecificLongValue) null);

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#xor(SpecificLongValue)}
   */
  @Test
  public void testXor8() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult = particularLongValue
        .xor(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#compare(LongValue)}
   */
  @Test
  public void testCompare() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#compare(LongValue)}
   */
  @Test
  public void testCompare2() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ParticularLongValue(42L)).compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#compare(LongValue)}
   */
  @Test
  public void testCompare3() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .compare(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#compare(SpecificLongValue)}
   */
  @Test
  public void testCompare4() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    IntegerValue actualCompareResult = particularLongValue.compare((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#isSpecific()}
   */
  @Test
  public void testIsSpecific() {
    // Arrange, Act and Assert
    assertTrue((new ParticularLongValue(42L)).isSpecific());
  }

  /**
   * Method under test: {@link SpecificLongValue#equals(Object)}
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
   * Method under test: {@link SpecificLongValue#equals(Object)}
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
   * Method under test: {@link SpecificLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act and Assert
    assertNotEquals(particularLongValue, new ParticularLongValue(42L));
  }

  /**
   * Method under test: {@link SpecificLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularLongValue(42L), null);
  }

  /**
   * Method under test: {@link SpecificLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularLongValue(42L), "Different type to SpecificLongValue");
  }
}
