package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DoubleValueDiffblueTest {
  /**
   * Method under test: {@link DoubleValue#value()}
   */
  @Test
  public void testValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, (new UnknownDoubleValue()).value(), 0.0);
  }

  /**
   * Method under test: {@link DoubleValue#generalize(ParticularDoubleValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.generalize(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#generalize(ParticularDoubleValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualGeneralizeResult = compositeDoubleValue.generalize(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link DoubleValue#generalize(SpecificDoubleValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue,
        unknownDoubleValue.generalize((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#generalize(Value)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.DOUBLE_VALUE.generalize(other));
  }

  /**
   * Method under test: {@link DoubleValue#generalize(Value)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.generalize((Value) BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link DoubleValue#add(ParticularDoubleValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.add(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#add(ParticularDoubleValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    ParticularDoubleValue other = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualAddResult = ParticularValueFactory.DOUBLE_VALUE_0.add(other);

    // Assert
    assertTrue(actualAddResult instanceof ParticularDoubleValue);
    assertEquals(other, actualAddResult);
  }

  /**
   * Method under test: {@link DoubleValue#add(ParticularDoubleValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualAddResult = compositeDoubleValue.add(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#add(SpecificDoubleValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.add((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#add(SpecificDoubleValue)}
   */
  @Test
  public void testAdd5() {
    // Arrange and Act
    DoubleValue actualAddResult = ParticularValueFactory.DOUBLE_VALUE_0
        .add((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#subtract(ParticularDoubleValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.subtract(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#subtract(ParticularDoubleValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange and Act
    DoubleValue actualSubtractResult = ParticularValueFactory.DOUBLE_VALUE_0.subtract(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularDoubleValue);
    assertEquals(-10.0d, actualSubtractResult.value(), 0.0);
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#subtract(ParticularDoubleValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualSubtractResult = compositeDoubleValue.subtract(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#subtract(SpecificDoubleValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.subtract((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#subtract(SpecificDoubleValue)}
   */
  @Test
  public void testSubtract5() {
    // Arrange and Act
    DoubleValue actualSubtractResult = ParticularValueFactory.DOUBLE_VALUE_0
        .subtract((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#subtractFrom(ParticularDoubleValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.subtractFrom(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#subtractFrom(ParticularDoubleValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange
    ParticularDoubleValue other = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractFromResult = ParticularValueFactory.DOUBLE_VALUE_0.subtractFrom(other);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularDoubleValue);
    assertEquals(other, actualSubtractFromResult);
  }

  /**
   * Method under test: {@link DoubleValue#subtractFrom(ParticularDoubleValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualSubtractFromResult = compositeDoubleValue.subtractFrom(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#subtractFrom(SpecificDoubleValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue,
        unknownDoubleValue.subtractFrom((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#subtractFrom(SpecificDoubleValue)}
   */
  @Test
  public void testSubtractFrom5() {
    // Arrange and Act
    DoubleValue actualSubtractFromResult = ParticularValueFactory.DOUBLE_VALUE_0
        .subtractFrom((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#multiply(ParticularDoubleValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.multiply(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#multiply(ParticularDoubleValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange
    DoubleValue doubleValue = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualMultiplyResult = doubleValue.multiply(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularDoubleValue);
    assertEquals(doubleValue, actualMultiplyResult);
  }

  /**
   * Method under test: {@link DoubleValue#multiply(ParticularDoubleValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualMultiplyResult = compositeDoubleValue.multiply(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#multiply(SpecificDoubleValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.multiply((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#multiply(SpecificDoubleValue)}
   */
  @Test
  public void testMultiply5() {
    // Arrange and Act
    DoubleValue actualMultiplyResult = ParticularValueFactory.DOUBLE_VALUE_0
        .multiply((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#divide(ParticularDoubleValue)}
   */
  @Test
  public void testDivide() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.divide(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#divide(ParticularDoubleValue)}
   */
  @Test
  public void testDivide2() {
    // Arrange
    DoubleValue doubleValue = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualDivideResult = doubleValue.divide(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularDoubleValue);
    assertEquals(doubleValue, actualDivideResult);
  }

  /**
   * Method under test: {@link DoubleValue#divide(ParticularDoubleValue)}
   */
  @Test
  public void testDivide3() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualDivideResult = compositeDoubleValue.divide(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#divide(SpecificDoubleValue)}
   */
  @Test
  public void testDivide4() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.divide((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#divide(SpecificDoubleValue)}
   */
  @Test
  public void testDivide5() {
    // Arrange and Act
    DoubleValue actualDivideResult = ParticularValueFactory.DOUBLE_VALUE_0
        .divide((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#divideOf(ParticularDoubleValue)}
   */
  @Test
  public void testDivideOf() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.divideOf(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#divideOf(ParticularDoubleValue)}
   */
  @Test
  public void testDivideOf2() {
    // Arrange and Act
    DoubleValue actualDivideOfResult = ParticularValueFactory.DOUBLE_VALUE_0.divideOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularDoubleValue);
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
    assertEquals(Double.POSITIVE_INFINITY, actualDivideOfResult.value(), 0.0);
  }

  /**
   * Method under test: {@link DoubleValue#divideOf(ParticularDoubleValue)}
   */
  @Test
  public void testDivideOf3() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualDivideOfResult = compositeDoubleValue.divideOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#divideOf(SpecificDoubleValue)}
   */
  @Test
  public void testDivideOf4() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.divideOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#divideOf(SpecificDoubleValue)}
   */
  @Test
  public void testDivideOf5() {
    // Arrange and Act
    DoubleValue actualDivideOfResult = ParticularValueFactory.DOUBLE_VALUE_0
        .divideOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#remainder(ParticularDoubleValue)}
   */
  @Test
  public void testRemainder() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.remainder(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#remainder(ParticularDoubleValue)}
   */
  @Test
  public void testRemainder2() {
    // Arrange
    DoubleValue doubleValue = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualRemainderResult = doubleValue.remainder(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularDoubleValue);
    assertEquals(doubleValue, actualRemainderResult);
  }

  /**
   * Method under test: {@link DoubleValue#remainder(ParticularDoubleValue)}
   */
  @Test
  public void testRemainder3() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualRemainderResult = compositeDoubleValue.remainder(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#remainder(SpecificDoubleValue)}
   */
  @Test
  public void testRemainder4() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue,
        unknownDoubleValue.remainder((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#remainder(SpecificDoubleValue)}
   */
  @Test
  public void testRemainder5() {
    // Arrange and Act
    DoubleValue actualRemainderResult = ParticularValueFactory.DOUBLE_VALUE_0
        .remainder((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#remainderOf(ParticularDoubleValue)}
   */
  @Test
  public void testRemainderOf() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.remainderOf(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#remainderOf(ParticularDoubleValue)}
   */
  @Test
  public void testRemainderOf2() {
    // Arrange and Act
    DoubleValue actualRemainderOfResult = ParticularValueFactory.DOUBLE_VALUE_0
        .remainderOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularDoubleValue);
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
    assertEquals(Double.NaN, actualRemainderOfResult.value(), 0.0);
  }

  /**
   * Method under test: {@link DoubleValue#remainderOf(ParticularDoubleValue)}
   */
  @Test
  public void testRemainderOf3() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualRemainderOfResult = compositeDoubleValue.remainderOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#remainderOf(SpecificDoubleValue)}
   */
  @Test
  public void testRemainderOf4() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue,
        unknownDoubleValue.remainderOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Method under test: {@link DoubleValue#remainderOf(SpecificDoubleValue)}
   */
  @Test
  public void testRemainderOf5() {
    // Arrange and Act
    DoubleValue actualRemainderOfResult = ParticularValueFactory.DOUBLE_VALUE_0
        .remainderOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  public void testCompare() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareResult = unknownDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  public void testCompare2() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    IntegerValue actualCompareResult = compositeDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#compare(SpecificDoubleValue)}
   */
  @Test
  public void testCompare3() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareResult = unknownDoubleValue
        .compare((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#compareReverse(DoubleValue)}
   */
  @Test
  public void testCompareReverse() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = (new UnknownDoubleValue()).compareReverse(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#compareReverse(DoubleValue)}
   */
  @Test
  public void testCompareReverse2() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = ParticularValueFactory.DOUBLE_VALUE_0
        .compareReverse(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#compareReverse(DoubleValue)}
   */
  @Test
  public void testCompareReverse3() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = (new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE)).compareReverse(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#compareReverse(ParticularDoubleValue)}
   */
  @Test
  public void testCompareReverse4() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareReverseResult = unknownDoubleValue.compareReverse(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#compareReverse(ParticularDoubleValue)}
   */
  @Test
  public void testCompareReverse5() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = ParticularValueFactory.DOUBLE_VALUE_0
        .compareReverse(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareReverseResult.value());
    assertFalse(actualCompareReverseResult.isCategory2());
    assertTrue(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#compareReverse(ParticularDoubleValue)}
   */
  @Test
  public void testCompareReverse6() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    IntegerValue actualCompareReverseResult = compositeDoubleValue.compareReverse(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#compareReverse(SpecificDoubleValue)}
   */
  @Test
  public void testCompareReverse7() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareReverseResult = unknownDoubleValue
        .compareReverse((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#compareReverse(SpecificDoubleValue)}
   */
  @Test
  public void testCompareReverse8() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = ParticularValueFactory.DOUBLE_VALUE_0
        .compareReverse((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link DoubleValue#doubleValue()}
   */
  @Test
  public void testDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.doubleValue());
  }

  /**
   * Method under test: {@link DoubleValue#computationalType()}
   */
  @Test
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(4, (new UnknownDoubleValue()).computationalType());
  }

  /**
   * Method under test: {@link DoubleValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("D", (new UnknownDoubleValue()).internalType());
  }
}
