package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LongValueDiffblueTest {
  /**
   * Method under test: {@link LongValue#value()}
   */
  @Test
  public void testValue() {
    // Arrange, Act and Assert
    assertEquals(0L, (new UnknownLongValue()).value());
  }

  /**
   * Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.generalize(other));
  }

  /**
   * Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.generalize(other));
  }

  /**
   * Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange and Act
    LongValue actualGeneralizeResult = ParticularValueFactory.LONG_VALUE_0
        .generalize((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link LongValue#generalize(ParticularLongValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.generalize(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#generalize(ParticularLongValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualGeneralizeResult = compositeLongValue.generalize(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Method under test: {@link LongValue#generalize(SpecificLongValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.generalize((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#generalize(Value)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.generalize(other));
  }

  /**
   * Method under test: {@link LongValue#generalize(Value)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.generalize((Value) BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link LongValue#computationalType()}
   */
  @Test
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(2, (new UnknownLongValue()).computationalType());
  }

  /**
   * Method under test: {@link LongValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("J", (new UnknownLongValue()).internalType());
  }

  /**
   * Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.add(other));
  }

  /**
   * Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.add(other));
  }

  /**
   * Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .add(other));
  }

  /**
   * Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualAddResult = ParticularValueFactory.LONG_VALUE_0.add(other);

    // Assert
    assertTrue(actualAddResult instanceof ParticularLongValue);
    assertEquals(other, actualAddResult);
  }

  /**
   * Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  public void testAdd5() {
    // Arrange and Act
    LongValue actualAddResult = ParticularValueFactory.LONG_VALUE_0
        .add((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#add(ParticularLongValue)}
   */
  @Test
  public void testAdd6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.add(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#add(ParticularLongValue)}
   */
  @Test
  public void testAdd7() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualAddResult = ParticularValueFactory.LONG_VALUE_0.add(other);

    // Assert
    assertTrue(actualAddResult instanceof ParticularLongValue);
    assertEquals(other, actualAddResult);
  }

  /**
   * Method under test: {@link LongValue#add(ParticularLongValue)}
   */
  @Test
  public void testAdd8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualAddResult = compositeLongValue.add(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#add(SpecificLongValue)}
   */
  @Test
  public void testAdd9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.add((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.subtract(other));
  }

  /**
   * Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.subtract(other));
  }

  /**
   * Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtract(other));
  }

  /**
   * Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualSubtractResult = ParticularValueFactory.LONG_VALUE_0.subtract(other);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(other, actualSubtractResult);
  }

  /**
   * Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract5() {
    // Arrange and Act
    LongValue actualSubtractResult = ParticularValueFactory.LONG_VALUE_0
        .subtract((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#subtract(ParticularLongValue)}
   */
  @Test
  public void testSubtract6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.subtract(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#subtract(ParticularLongValue)}
   */
  @Test
  public void testSubtract7() {
    // Arrange and Act
    LongValue actualSubtractResult = ParticularValueFactory.LONG_VALUE_0.subtract(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(-42L, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#subtract(ParticularLongValue)}
   */
  @Test
  public void testSubtract8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualSubtractResult = compositeLongValue.subtract(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#subtract(SpecificLongValue)}
   */
  @Test
  public void testSubtract9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.subtract((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.subtractFrom(other));
  }

  /**
   * Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.subtractFrom(other));
  }

  /**
   * Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtractFrom(other));
  }

  /**
   * Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualSubtractFromResult = ParticularValueFactory.LONG_VALUE_0.subtractFrom(other);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(other, actualSubtractFromResult);
  }

  /**
   * Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom5() {
    // Arrange and Act
    LongValue actualSubtractFromResult = ParticularValueFactory.LONG_VALUE_0
        .subtractFrom((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#subtractFrom(ParticularLongValue)}
   */
  @Test
  public void testSubtractFrom6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.subtractFrom(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#subtractFrom(ParticularLongValue)}
   */
  @Test
  public void testSubtractFrom7() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractFromResult = ParticularValueFactory.LONG_VALUE_0.subtractFrom(other);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(other, actualSubtractFromResult);
  }

  /**
   * Method under test: {@link LongValue#subtractFrom(ParticularLongValue)}
   */
  @Test
  public void testSubtractFrom8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualSubtractFromResult = compositeLongValue.subtractFrom(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  public void testSubtractFrom9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.subtractFrom((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.multiply(other));
  }

  /**
   * Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply2() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.multiply(other));
  }

  /**
   * Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .multiply(other));
  }

  /**
   * Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply4() throws ArithmeticException {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualMultiplyResult = ParticularValueFactory.LONG_VALUE_0.multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularLongValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply5() throws ArithmeticException {
    // Arrange and Act
    LongValue actualMultiplyResult = ParticularValueFactory.LONG_VALUE_0
        .multiply((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#multiply(ParticularLongValue)}
   */
  @Test
  public void testMultiply6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.multiply(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#multiply(ParticularLongValue)}
   */
  @Test
  public void testMultiply7() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualMultiplyResult = longValue.multiply(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularLongValue);
    assertEquals(longValue, actualMultiplyResult);
  }

  /**
   * Method under test: {@link LongValue#multiply(ParticularLongValue)}
   */
  @Test
  public void testMultiply8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualMultiplyResult = compositeLongValue.multiply(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#multiply(SpecificLongValue)}
   */
  @Test
  public void testMultiply9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.multiply((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  public void testDivide() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.divide(other));
  }

  /**
   * Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  public void testDivide2() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.divide(other));
  }

  /**
   * Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  public void testDivide3() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divide(other));
  }

  /**
   * Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  public void testDivide4() throws ArithmeticException {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualDivideResult = longValue.divide(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularLongValue);
    assertEquals(longValue, actualDivideResult);
  }

  /**
   * Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  public void testDivide5() throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideResult = ParticularValueFactory.LONG_VALUE_0
        .divide((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#divide(ParticularLongValue)}
   */
  @Test
  public void testDivide6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.divide(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#divide(ParticularLongValue)}
   */
  @Test
  public void testDivide7() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualDivideResult = longValue.divide(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularLongValue);
    assertEquals(longValue, actualDivideResult);
  }

  /**
   * Method under test: {@link LongValue#divide(ParticularLongValue)}
   */
  @Test
  public void testDivide8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualDivideResult = compositeLongValue.divide(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#divide(SpecificLongValue)}
   */
  @Test
  public void testDivide9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.divide((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.divideOf(other));
  }

  /**
   * Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf2() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.divideOf(other));
  }

  /**
   * Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf3() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divideOf(other));
  }

  /**
   * Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf4() throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideOfResult = ParticularValueFactory.LONG_VALUE_0
        .divideOf((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf5() throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideOfResult = (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divideOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#divideOf(ParticularLongValue)}
   */
  @Test
  public void testDivideOf6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.divideOf(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#divideOf(ParticularLongValue)}
   */
  @Test
  public void testDivideOf7() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideOfResult = ParticularValueFactory.LONG_VALUE_1.divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularLongValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Method under test: {@link LongValue#divideOf(ParticularLongValue)}
   */
  @Test
  public void testDivideOf8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualDivideOfResult = compositeLongValue.divideOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#divideOf(SpecificLongValue)}
   */
  @Test
  public void testDivideOf9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.divideOf((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.remainder(other));
  }

  /**
   * Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder2() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.remainder(other));
  }

  /**
   * Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder3() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainder(other));
  }

  /**
   * Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder4() throws ArithmeticException {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualRemainderResult = longValue.remainder(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularLongValue);
    assertEquals(longValue, actualRemainderResult);
  }

  /**
   * Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder5() throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderResult = ParticularValueFactory.LONG_VALUE_0
        .remainder((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#remainder(ParticularLongValue)}
   */
  @Test
  public void testRemainder6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.remainder(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#remainder(ParticularLongValue)}
   */
  @Test
  public void testRemainder7() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualRemainderResult = longValue.remainder(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularLongValue);
    assertEquals(longValue, actualRemainderResult);
  }

  /**
   * Method under test: {@link LongValue#remainder(ParticularLongValue)}
   */
  @Test
  public void testRemainder8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualRemainderResult = compositeLongValue.remainder(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#remainder(SpecificLongValue)}
   */
  @Test
  public void testRemainder9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.remainder((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.remainderOf(other));
  }

  /**
   * Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf2() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.remainderOf(other));
  }

  /**
   * Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf3() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainderOf(other));
  }

  /**
   * Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf4() throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderOfResult = ParticularValueFactory.LONG_VALUE_0
        .remainderOf((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf5() throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderOfResult = (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainderOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#remainderOf(ParticularLongValue)}
   */
  @Test
  public void testRemainderOf6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.remainderOf(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#remainderOf(ParticularLongValue)}
   */
  @Test
  public void testRemainderOf7() {
    // Arrange and Act
    LongValue actualRemainderOfResult = ParticularValueFactory.LONG_VALUE_1.remainderOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularLongValue);
    assertEquals(0L, actualRemainderOfResult.value());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#remainderOf(ParticularLongValue)}
   */
  @Test
  public void testRemainderOf8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualRemainderOfResult = compositeLongValue.remainderOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#remainderOf(SpecificLongValue)}
   */
  @Test
  public void testRemainderOf9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.remainderOf((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft() {
    // Arrange
    LongValue longValue = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(longValue, longValue.shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft2() {
    // Arrange and Act
    LongValue actualShiftLeftResult = (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftLeft(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft3() {
    // Arrange and Act
    LongValue actualShiftLeftResult = (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft4() {
    // Arrange and Act
    LongValue actualShiftLeftResult = ParticularValueFactory.LONG_VALUE_0.shiftLeft(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft5() {
    // Arrange and Act
    LongValue actualShiftLeftResult = ParticularValueFactory.LONG_VALUE_0.shiftLeft(
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.shiftLeft(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link LongValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft7() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftLeftResult = longValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularLongValue);
    assertEquals(longValue, actualShiftLeftResult);
  }

  /**
   * Method under test: {@link LongValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftLeftResult = compositeLongValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#shiftLeft(SpecificLongValue)}
   */
  @Test
  public void testShiftLeft9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.shiftLeft(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight() {
    // Arrange
    LongValue longValue = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(longValue, longValue.shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight2() {
    // Arrange and Act
    LongValue actualShiftRightResult = (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight3() {
    // Arrange and Act
    LongValue actualShiftRightResult = (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight4() {
    // Arrange and Act
    LongValue actualShiftRightResult = ParticularValueFactory.LONG_VALUE_0.shiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight5() {
    // Arrange and Act
    LongValue actualShiftRightResult = ParticularValueFactory.LONG_VALUE_0.shiftRight(
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRight6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.shiftRight(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link LongValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRight7() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftRightResult = longValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof ParticularLongValue);
    assertEquals(longValue, actualShiftRightResult);
  }

  /**
   * Method under test: {@link LongValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRight8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftRightResult = compositeLongValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#shiftRight(SpecificLongValue)}
   */
  @Test
  public void testShiftRight9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.shiftRight(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight() {
    // Arrange
    LongValue longValue = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(longValue, longValue.unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight2() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult = (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).unsignedShiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight3() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult = (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight4() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult = ParticularValueFactory.LONG_VALUE_0
        .unsignedShiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight5() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult = ParticularValueFactory.LONG_VALUE_0.unsignedShiftRight(
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link LongValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.unsignedShiftRight(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link LongValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight7() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualUnsignedShiftRightResult = longValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof ParticularLongValue);
    assertEquals(longValue, actualUnsignedShiftRightResult);
  }

  /**
   * Method under test:
   * {@link LongValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualUnsignedShiftRightResult = compositeLongValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#unsignedShiftRight(SpecificLongValue)}
   */
  @Test
  public void testUnsignedShiftRight9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.unsignedShiftRight(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  public void testAnd() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.and(other));
  }

  /**
   * Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  public void testAnd2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.and(other));
  }

  /**
   * Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  public void testAnd3() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .and(other));
  }

  /**
   * Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  public void testAnd4() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualAndResult = ParticularValueFactory.LONG_VALUE_0.and(other);

    // Assert
    assertTrue(actualAndResult instanceof ParticularLongValue);
    assertEquals(other, actualAndResult);
  }

  /**
   * Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  public void testAnd5() {
    // Arrange and Act
    LongValue actualAndResult = ParticularValueFactory.LONG_VALUE_0
        .and((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#and(ParticularLongValue)}
   */
  @Test
  public void testAnd6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.and(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#and(ParticularLongValue)}
   */
  @Test
  public void testAnd7() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualAndResult = longValue.and(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAndResult instanceof ParticularLongValue);
    assertEquals(longValue, actualAndResult);
  }

  /**
   * Method under test: {@link LongValue#and(ParticularLongValue)}
   */
  @Test
  public void testAnd8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualAndResult = compositeLongValue.and(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#and(SpecificLongValue)}
   */
  @Test
  public void testAnd9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.and((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  public void testOr() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.or(other));
  }

  /**
   * Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  public void testOr2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.or(other));
  }

  /**
   * Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  public void testOr3() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .or(other));
  }

  /**
   * Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  public void testOr4() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualOrResult = ParticularValueFactory.LONG_VALUE_0.or(other);

    // Assert
    assertTrue(actualOrResult instanceof ParticularLongValue);
    assertEquals(other, actualOrResult);
  }

  /**
   * Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  public void testOr5() {
    // Arrange and Act
    LongValue actualOrResult = ParticularValueFactory.LONG_VALUE_0
        .or((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#or(ParticularLongValue)}
   */
  @Test
  public void testOr6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.or(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#or(ParticularLongValue)}
   */
  @Test
  public void testOr7() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualOrResult = ParticularValueFactory.LONG_VALUE_0.or(other);

    // Assert
    assertTrue(actualOrResult instanceof ParticularLongValue);
    assertEquals(other, actualOrResult);
  }

  /**
   * Method under test: {@link LongValue#or(ParticularLongValue)}
   */
  @Test
  public void testOr8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualOrResult = compositeLongValue.or(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#or(SpecificLongValue)}
   */
  @Test
  public void testOr9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.or((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  public void testXor() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.xor(other));
  }

  /**
   * Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  public void testXor2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.xor(other));
  }

  /**
   * Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  public void testXor3() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other,
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .xor(other));
  }

  /**
   * Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  public void testXor4() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualXorResult = ParticularValueFactory.LONG_VALUE_0.xor(other);

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(other, actualXorResult);
  }

  /**
   * Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  public void testXor5() {
    // Arrange and Act
    LongValue actualXorResult = ParticularValueFactory.LONG_VALUE_0
        .xor((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#xor(ParticularLongValue)}
   */
  @Test
  public void testXor6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.xor(new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#xor(ParticularLongValue)}
   */
  @Test
  public void testXor7() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult = ParticularValueFactory.LONG_VALUE_0.xor(other);

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(other, actualXorResult);
  }

  /**
   * Method under test: {@link LongValue#xor(ParticularLongValue)}
   */
  @Test
  public void testXor8() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualXorResult = compositeLongValue.xor(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#xor(SpecificLongValue)}
   */
  @Test
  public void testXor9() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.xor((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  public void testCompare() {
    // Arrange and Act
    IntegerValue actualCompareResult = BasicValueFactory.LONG_VALUE.compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  public void testCompare2() {
    // Arrange and Act
    IntegerValue actualCompareResult = ParticularValueFactory.LONG_VALUE_0.compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  public void testCompare3() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  public void testCompare4() {
    // Arrange and Act
    IntegerValue actualCompareResult = ParticularValueFactory.LONG_VALUE_0.compare(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  public void testCompare5() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).compare(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compare(ParticularLongValue)}
   */
  @Test
  public void testCompare6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareResult = unknownLongValue.compare(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compare(ParticularLongValue)}
   */
  @Test
  public void testCompare7() {
    // Arrange and Act
    IntegerValue actualCompareResult = ParticularValueFactory.LONG_VALUE_0.compare(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compare(SpecificLongValue)}
   */
  @Test
  public void testCompare8() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareResult = unknownLongValue.compare((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compareReverse(LongValue)}
   */
  @Test
  public void testCompareReverse() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = (new UnknownLongValue()).compareReverse(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compareReverse(LongValue)}
   */
  @Test
  public void testCompareReverse2() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = ParticularValueFactory.LONG_VALUE_0
        .compareReverse(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof ComparisonValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compareReverse(LongValue)}
   */
  @Test
  public void testCompareReverse3() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).compareReverse(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof ComparisonValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compareReverse(ParticularLongValue)}
   */
  @Test
  public void testCompareReverse4() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareReverseResult = unknownLongValue.compareReverse(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareReverseResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compareReverse(ParticularLongValue)}
   */
  @Test
  public void testCompareReverse5() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult = ParticularValueFactory.LONG_VALUE_0
        .compareReverse(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareReverseResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#compareReverse(SpecificLongValue)}
   */
  @Test
  public void testCompareReverse6() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareReverseResult = unknownLongValue
        .compareReverse((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareReverseResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Method under test: {@link LongValue#longValue()}
   */
  @Test
  public void testLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.longValue());
  }
}
