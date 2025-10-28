package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FloatValueDiffblueTest {
  /**
   * Method under test: {@link FloatValue#value()}
   */
  @Test
  public void testValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new UnknownFloatValue()).value(), 0.0f);
  }

  /**
   * Method under test: {@link FloatValue#generalize(ParticularFloatValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.generalize(new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#generalize(ParticularFloatValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualGeneralizeResult = compositeFloatValue.generalize(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#generalize(SpecificFloatValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.generalize((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#generalize(Value)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.FLOAT_VALUE.generalize(other));
  }

  /**
   * Method under test: {@link FloatValue#generalize(Value)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.generalize((Value) BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link FloatValue#add(ParticularFloatValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.add(new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#add(ParticularFloatValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    ParticularFloatValue other = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult = ParticularValueFactory.FLOAT_VALUE_0.add(other);

    // Assert
    assertTrue(actualAddResult instanceof ParticularFloatValue);
    assertEquals(other, actualAddResult);
  }

  /**
   * Method under test: {@link FloatValue#add(ParticularFloatValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualAddResult = compositeFloatValue.add(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualAddResult instanceof CompositeFloatValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#add(SpecificFloatValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.add((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#add(SpecificFloatValue)}
   */
  @Test
  public void testAdd5() {
    // Arrange and Act
    FloatValue actualAddResult = ParticularValueFactory.FLOAT_VALUE_0
        .add((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualAddResult instanceof CompositeFloatValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#subtract(ParticularFloatValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.subtract(new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#subtract(ParticularFloatValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange and Act
    FloatValue actualSubtractResult = ParticularValueFactory.FLOAT_VALUE_0.subtract(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularFloatValue);
    assertEquals(-10.0f, actualSubtractResult.value(), 0.0f);
    assertFalse(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#subtract(ParticularFloatValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualSubtractResult = compositeFloatValue.subtract(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#subtract(SpecificFloatValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.subtract((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#subtract(SpecificFloatValue)}
   */
  @Test
  public void testSubtract5() {
    // Arrange and Act
    FloatValue actualSubtractResult = ParticularValueFactory.FLOAT_VALUE_0
        .subtract((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#subtractFrom(ParticularFloatValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.subtractFrom(new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#subtractFrom(ParticularFloatValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange
    ParticularFloatValue other = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractFromResult = ParticularValueFactory.FLOAT_VALUE_0.subtractFrom(other);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularFloatValue);
    assertEquals(other, actualSubtractFromResult);
  }

  /**
   * Method under test: {@link FloatValue#subtractFrom(ParticularFloatValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualSubtractFromResult = compositeFloatValue.subtractFrom(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#subtractFrom(SpecificFloatValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.subtractFrom((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#subtractFrom(SpecificFloatValue)}
   */
  @Test
  public void testSubtractFrom5() {
    // Arrange and Act
    FloatValue actualSubtractFromResult = ParticularValueFactory.FLOAT_VALUE_0
        .subtractFrom((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#multiply(ParticularFloatValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.multiply(new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#multiply(ParticularFloatValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange
    FloatValue floatValue = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualMultiplyResult = floatValue.multiply(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularFloatValue);
    assertEquals(floatValue, actualMultiplyResult);
  }

  /**
   * Method under test: {@link FloatValue#multiply(ParticularFloatValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualMultiplyResult = compositeFloatValue.multiply(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeFloatValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#multiply(SpecificFloatValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.multiply((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#multiply(SpecificFloatValue)}
   */
  @Test
  public void testMultiply5() {
    // Arrange and Act
    FloatValue actualMultiplyResult = ParticularValueFactory.FLOAT_VALUE_0
        .multiply((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeFloatValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#divide(ParticularFloatValue)}
   */
  @Test
  public void testDivide() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.divide(new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#divide(ParticularFloatValue)}
   */
  @Test
  public void testDivide2() {
    // Arrange
    FloatValue floatValue = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualDivideResult = floatValue.divide(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularFloatValue);
    assertEquals(floatValue, actualDivideResult);
  }

  /**
   * Method under test: {@link FloatValue#divide(ParticularFloatValue)}
   */
  @Test
  public void testDivide3() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualDivideResult = compositeFloatValue.divide(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#divide(SpecificFloatValue)}
   */
  @Test
  public void testDivide4() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.divide((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#divide(SpecificFloatValue)}
   */
  @Test
  public void testDivide5() {
    // Arrange and Act
    FloatValue actualDivideResult = ParticularValueFactory.FLOAT_VALUE_0
        .divide((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#divideOf(ParticularFloatValue)}
   */
  @Test
  public void testDivideOf() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.divideOf(new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#divideOf(ParticularFloatValue)}
   */
  @Test
  public void testDivideOf2() {
    // Arrange and Act
    FloatValue actualDivideOfResult = ParticularValueFactory.FLOAT_VALUE_0.divideOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
    assertEquals(Float.POSITIVE_INFINITY, actualDivideOfResult.value(), 0.0f);
  }

  /**
   * Method under test: {@link FloatValue#divideOf(ParticularFloatValue)}
   */
  @Test
  public void testDivideOf3() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualDivideOfResult = compositeFloatValue.divideOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#divideOf(SpecificFloatValue)}
   */
  @Test
  public void testDivideOf4() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.divideOf((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#divideOf(SpecificFloatValue)}
   */
  @Test
  public void testDivideOf5() {
    // Arrange and Act
    FloatValue actualDivideOfResult = ParticularValueFactory.FLOAT_VALUE_0
        .divideOf((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#remainder(ParticularFloatValue)}
   */
  @Test
  public void testRemainder() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.remainder(new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#remainder(ParticularFloatValue)}
   */
  @Test
  public void testRemainder2() {
    // Arrange
    FloatValue floatValue = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualRemainderResult = floatValue.remainder(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularFloatValue);
    assertEquals(floatValue, actualRemainderResult);
  }

  /**
   * Method under test: {@link FloatValue#remainder(ParticularFloatValue)}
   */
  @Test
  public void testRemainder3() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualRemainderResult = compositeFloatValue.remainder(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#remainder(SpecificFloatValue)}
   */
  @Test
  public void testRemainder4() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.remainder((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#remainder(SpecificFloatValue)}
   */
  @Test
  public void testRemainder5() {
    // Arrange and Act
    FloatValue actualRemainderResult = ParticularValueFactory.FLOAT_VALUE_0
        .remainder((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#remainderOf(ParticularFloatValue)}
   */
  @Test
  public void testRemainderOf() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.remainderOf(new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#remainderOf(ParticularFloatValue)}
   */
  @Test
  public void testRemainderOf2() {
    // Arrange and Act
    FloatValue actualRemainderOfResult = ParticularValueFactory.FLOAT_VALUE_0
        .remainderOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
    assertEquals(Float.NaN, actualRemainderOfResult.value(), 0.0f);
  }

  /**
   * Method under test: {@link FloatValue#remainderOf(ParticularFloatValue)}
   */
  @Test
  public void testRemainderOf3() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualRemainderOfResult = compositeFloatValue.remainderOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#remainderOf(SpecificFloatValue)}
   */
  @Test
  public void testRemainderOf4() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.remainderOf((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Method under test: {@link FloatValue#remainderOf(SpecificFloatValue)}
   */
  @Test
  public void testRemainderOf5() {
    // Arrange and Act
    FloatValue actualRemainderOfResult = ParticularValueFactory.FLOAT_VALUE_0
        .remainderOf((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#compare(ParticularFloatValue)}
   */
  @Test
  public void testCompare() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    IntegerValue actualCompareResult = unknownFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#compare(ParticularFloatValue)}
   */
  @Test
  public void testCompare2() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act
    IntegerValue actualCompareResult = compositeFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#compare(SpecificFloatValue)}
   */
  @Test
  public void testCompare3() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    IntegerValue actualCompareResult = unknownFloatValue.compare((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#compareReverse(FloatValue)}
   */
  @Test
  public void testCompareReverse() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = (new UnknownFloatValue()).compareReverse(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#compareReverse(FloatValue)}
   */
  @Test
  public void testCompareReverse2() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = ParticularValueFactory.FLOAT_VALUE_0
        .compareReverse(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#compareReverse(FloatValue)}
   */
  @Test
  public void testCompareReverse3() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = (new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE)).compareReverse(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#compareReverse(ParticularFloatValue)}
   */
  @Test
  public void testCompareReverse4() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    IntegerValue actualCompareReverseResult = unknownFloatValue.compareReverse(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#compareReverse(ParticularFloatValue)}
   */
  @Test
  public void testCompareReverse5() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = ParticularValueFactory.FLOAT_VALUE_0
        .compareReverse(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareReverseResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareReverseResult.value());
    assertFalse(actualCompareReverseResult.isCategory2());
    assertTrue(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#compareReverse(ParticularFloatValue)}
   */
  @Test
  public void testCompareReverse6() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act
    IntegerValue actualCompareReverseResult = compositeFloatValue.compareReverse(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#compareReverse(SpecificFloatValue)}
   */
  @Test
  public void testCompareReverse7() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    IntegerValue actualCompareReverseResult = unknownFloatValue
        .compareReverse((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#compareReverse(SpecificFloatValue)}
   */
  @Test
  public void testCompareReverse8() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = ParticularValueFactory.FLOAT_VALUE_0
        .compareReverse((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link FloatValue#floatValue()}
   */
  @Test
  public void testFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.floatValue());
  }

  /**
   * Method under test: {@link FloatValue#computationalType()}
   */
  @Test
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(3, (new UnknownFloatValue()).computationalType());
  }

  /**
   * Method under test: {@link FloatValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("F", (new UnknownFloatValue()).internalType());
  }
}
