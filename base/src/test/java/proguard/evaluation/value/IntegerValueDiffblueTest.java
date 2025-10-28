package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class IntegerValueDiffblueTest {
  /**
   * Method under test: {@link IntegerValue#value()}
   */
  @Test
  public void testValue() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownIntegerValue()).value());
  }

  /**
   * Method under test: {@link IntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.generalize(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualGeneralizeResult = comparisonValue.generalize(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult = rangeIntegerValue.generalize(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.generalize(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.generalize((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.generalize(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.generalize(other));
  }

  /**
   * Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.generalize(other));
  }

  /**
   * Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.generalize(other));
  }

  /**
   * Method under test: {@link IntegerValue#generalize(Value)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.generalize((Value) BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link IntegerValue#generalize(Value)}
   */
  @Test
  public void testGeneralize11() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.generalize(other));
  }

  /**
   * Method under test: {@link IntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.add(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange and Act
    IntegerValue actualAddResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAddResult = comparisonValue.add(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.add(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd5() {
    // Arrange and Act
    IntegerValue actualAddResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  public void testAdd6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.add((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  public void testAdd7() {
    // Arrange and Act
    IntegerValue actualAddResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .add((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  public void testAdd8() {
    // Arrange and Act
    IntegerValue actualAddResult = ParticularValueFactory.INTEGER_VALUE_0
        .add((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  public void testAdd9() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.add(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  public void testAdd10() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(other));
  }

  /**
   * Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  public void testAdd11() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.add(other));
  }

  /**
   * Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  public void testAdd12() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.add(other));
  }

  /**
   * Method under test: {@link IntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtract(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange and Act
    IntegerValue actualSubtractResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractResult = comparisonValue.subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtract(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  public void testSubtract5() {
    // Arrange and Act
    IntegerValue actualSubtractResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  public void testSubtract6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.subtract((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  public void testSubtract7() {
    // Arrange and Act
    IntegerValue actualSubtractResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .subtract((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  public void testSubtract8() {
    // Arrange and Act
    IntegerValue actualSubtractResult = ParticularValueFactory.INTEGER_VALUE_0
        .subtract((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  public void testSubtract9() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtract(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  public void testSubtract10() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtract(other));
  }

  /**
   * Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  public void testSubtract11() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.subtract(other));
  }

  /**
   * Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  public void testSubtract12() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.subtract(other));
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtractFrom(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractFromResult = comparisonValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtractFrom(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom5() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  public void testSubtractFrom6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.subtractFrom((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  public void testSubtractFrom7() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .subtractFrom((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  public void testSubtractFrom8() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = ParticularValueFactory.INTEGER_VALUE_0
        .subtractFrom((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  public void testSubtractFrom9() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtractFrom(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  public void testSubtractFrom10() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtractFrom(other));
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  public void testSubtractFrom11() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.subtractFrom(other));
  }

  /**
   * Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  public void testSubtractFrom12() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.subtractFrom(other));
  }

  /**
   * Method under test: {@link IntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.multiply(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualMultiplyResult = comparisonValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.multiply(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  public void testMultiply5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.multiply((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  public void testMultiply6() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .multiply((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  public void testMultiply7() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = ParticularValueFactory.INTEGER_VALUE_0
        .multiply((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  public void testMultiply8() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.multiply(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  public void testMultiply9() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.multiply(other));
  }

  /**
   * Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  public void testMultiply10() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.multiply(other));
  }

  /**
   * Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  public void testMultiply11() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.multiply(other));
  }

  /**
   * Method under test: {@link IntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  public void testDivide() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divide(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  public void testDivide2() {
    // Arrange and Act
    IntegerValue actualDivideResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.divide(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  public void testDivide3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualDivideResult = comparisonValue.divide(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  public void testDivide4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divide(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  public void testDivide5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divide((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  public void testDivide6() {
    // Arrange and Act
    IntegerValue actualDivideResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .divide((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  public void testDivide7() {
    // Arrange and Act
    IntegerValue actualDivideResult = ParticularValueFactory.INTEGER_VALUE_0
        .divide((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  public void testDivide8() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divide(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  public void testDivide9() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.divide(other));
  }

  /**
   * Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  public void testDivide10() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.divide(other));
  }

  /**
   * Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  public void testDivide11() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.divide(other));
  }

  /**
   * Method under test: {@link IntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  public void testDivideOf() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divideOf(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  public void testDivideOf2() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideOfResult = ParticularValueFactory.INTEGER_VALUE_1.divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Method under test: {@link IntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  public void testDivideOf3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualDivideOfResult = comparisonValue.divideOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  public void testDivideOf4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divideOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#divideOf(SpecificIntegerValue)}
   */
  @Test
  public void testDivideOf5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.divideOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  public void testDivideOf6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divideOf(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  public void testDivideOf7() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.divideOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  public void testDivideOf8() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.divideOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  public void testDivideOf9() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.divideOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  public void testRemainder() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainder(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  public void testRemainder2() {
    // Arrange and Act
    IntegerValue actualRemainderResult = BasicRangeValueFactory.INTEGER_VALUE_CHAR
        .remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  public void testRemainder3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualRemainderResult = comparisonValue.remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  public void testRemainder4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainder(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#remainder(SpecificIntegerValue)}
   */
  @Test
  public void testRemainder5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.remainder((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  public void testRemainder6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainder(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  public void testRemainder7() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.remainder(other));
  }

  /**
   * Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  public void testRemainder8() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.remainder(other));
  }

  /**
   * Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  public void testRemainder9() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.remainder(other));
  }

  /**
   * Method under test: {@link IntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  public void testRemainderOf() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainderOf(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  public void testRemainderOf2() {
    // Arrange and Act
    IntegerValue actualRemainderOfResult = ParticularValueFactory.INTEGER_VALUE_1
        .remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularIntegerValue);
    assertEquals(0, actualRemainderOfResult.value());
    assertFalse(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  public void testRemainderOf3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualRemainderOfResult = comparisonValue.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  public void testRemainderOf4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainderOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#remainderOf(SpecificIntegerValue)}
   */
  @Test
  public void testRemainderOf5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.remainderOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  public void testRemainderOf6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainderOf(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  public void testRemainderOf7() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.remainderOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  public void testRemainderOf8() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.remainderOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  public void testRemainderOf9() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.remainderOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeft(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft2() {
    // Arrange
    IntegerValue integerValue = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualShiftLeftResult = integerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularIntegerValue);
    assertEquals(integerValue, actualShiftLeftResult);
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftLeftResult = comparisonValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeft4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeft(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeft(SpecificIntegerValue)}
   */
  @Test
  public void testShiftLeft5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.shiftLeft((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  public void testShiftLeft6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeft(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  public void testShiftLeft7() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftLeft(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  public void testShiftLeft8() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftLeft(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  public void testShiftLeft9() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftLeft(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRight() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRight(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRight2() {
    // Arrange and Act
    IntegerValue actualShiftRightResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRight3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftRightResult = comparisonValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  public void testShiftRight4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRight(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  public void testShiftRight5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.shiftRight((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  public void testShiftRight6() {
    // Arrange and Act
    IntegerValue actualShiftRightResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .shiftRight((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  public void testShiftRight7() {
    // Arrange and Act
    IntegerValue actualShiftRightResult = ParticularValueFactory.INTEGER_VALUE_0
        .shiftRight((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  public void testShiftRight8() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRight(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  public void testShiftRight9() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRight(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  public void testShiftRight10() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftRight(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  public void testShiftRight11() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftRight(other));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight2() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualUnsignedShiftRightResult = comparisonValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.unsignedShiftRight(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRight((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight6() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .unsignedShiftRight((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight7() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult = ParticularValueFactory.INTEGER_VALUE_0
        .unsignedShiftRight((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight8() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.unsignedShiftRight(new UnknownIntegerValue()));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight9() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRight(other));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight10() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRight(other));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight11() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.unsignedShiftRight(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeftOf() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeftOf(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeftOf2() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult = ParticularValueFactory.INTEGER_VALUE_0.shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeftOf3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftLeftOfResult = comparisonValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  public void testShiftLeftOf4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftLeftOfResult = unknownIntegerValue.shiftLeftOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
    assertTrue(actualShiftLeftOfResult.isCategory2());
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  public void testShiftLeftOf5() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftLeftOfResult = ParticularValueFactory.INTEGER_VALUE_0.shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularLongValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  public void testShiftLeftOf6() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftLeftOfResult = comparisonValue.shiftLeftOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeftOf7() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeftOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(SpecificIntegerValue)}
   */
  @Test
  public void testShiftLeftOf8() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.shiftLeftOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(SpecificLongValue)}
   */
  @Test
  public void testShiftLeftOf9() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftLeftOfResult = unknownIntegerValue
        .shiftLeftOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
    assertTrue(actualShiftLeftOfResult.isCategory2());
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  public void testShiftLeftOf10() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeftOf(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  public void testShiftLeftOf11() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftLeftOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  public void testShiftLeftOf12() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftLeftOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  public void testShiftLeftOf13() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftLeftOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftLeftOf(UnknownLongValue)}
   */
  @Test
  public void testShiftLeftOf14() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();
    UnknownLongValue other = new UnknownLongValue();

    // Act
    LongValue actualShiftLeftOfResult = unknownIntegerValue.shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRightOf() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRightOf(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRightOf2() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightOfResult = ParticularValueFactory.INTEGER_VALUE_0.shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRightOf3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftRightOfResult = comparisonValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testShiftRightOf4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftRightOfResult = unknownIntegerValue.shiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testShiftRightOf5() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftRightOfResult = ParticularValueFactory.INTEGER_VALUE_0.shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testShiftRightOf6() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftRightOfResult = comparisonValue.shiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftRightOf7() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRightOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(SpecificIntegerValue)}
   */
  @Test
  public void testShiftRightOf8() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.shiftRightOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(SpecificLongValue)}
   */
  @Test
  public void testShiftRightOf9() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftRightOfResult = unknownIntegerValue
        .shiftRightOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  public void testShiftRightOf10() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRightOf(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  public void testShiftRightOf11() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRightOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  public void testShiftRightOf12() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftRightOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  public void testShiftRightOf13() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftRightOf(other));
  }

  /**
   * Method under test: {@link IntegerValue#shiftRightOf(UnknownLongValue)}
   */
  @Test
  public void testShiftRightOf14() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();
    UnknownLongValue other = new UnknownLongValue();

    // Act
    LongValue actualShiftRightOfResult = unknownIntegerValue.shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.unsignedShiftRightOf(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf2() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = comparisonValue
        .unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualUnsignedShiftRightOfResult = unknownIntegerValue.unsignedShiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf5() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualUnsignedShiftRightOfResult = ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf6() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualUnsignedShiftRightOfResult = comparisonValue.unsignedShiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf7() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.unsignedShiftRightOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(SpecificIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf8() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRightOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(SpecificLongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf9() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualUnsignedShiftRightOfResult = unknownIntegerValue
        .unsignedShiftRightOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf10() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.unsignedShiftRightOf(new UnknownIntegerValue()));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf11() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf12() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf13() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link IntegerValue#unsignedShiftRightOf(UnknownLongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf14() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();
    UnknownLongValue other = new UnknownLongValue();

    // Act
    LongValue actualUnsignedShiftRightOfResult = unknownIntegerValue.unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Method under test: {@link IntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  public void testAnd() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.and(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  public void testAnd2() {
    // Arrange and Act
    IntegerValue actualAndResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.and(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  public void testAnd3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAndResult = comparisonValue.and(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#and(RangeIntegerValue)}
   */
  @Test
  public void testAnd4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.and(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  public void testAnd5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.and((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  public void testAnd6() {
    // Arrange and Act
    IntegerValue actualAndResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .and((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  public void testAnd7() {
    // Arrange and Act
    IntegerValue actualAndResult = ParticularValueFactory.INTEGER_VALUE_0
        .and((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  public void testAnd8() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.and(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  public void testAnd9() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.and(other));
  }

  /**
   * Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  public void testAnd10() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.and(other));
  }

  /**
   * Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  public void testAnd11() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.and(other));
  }

  /**
   * Method under test: {@link IntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  public void testOr() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.or(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  public void testOr2() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult = ParticularValueFactory.INTEGER_VALUE_0.or(other);

    // Assert
    assertTrue(actualOrResult instanceof ParticularIntegerValue);
    assertEquals(other, actualOrResult);
  }

  /**
   * Method under test: {@link IntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  public void testOr3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualOrResult = comparisonValue.or(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#or(RangeIntegerValue)}
   */
  @Test
  public void testOr4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.or(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  public void testOr5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.or((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  public void testOr6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.or(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  public void testOr7() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.or(other));
  }

  /**
   * Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  public void testOr8() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.or(other));
  }

  /**
   * Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  public void testOr9() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.or(other));
  }

  /**
   * Method under test: {@link IntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  public void testXor() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.xor(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  public void testXor2() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult = ParticularValueFactory.INTEGER_VALUE_0.xor(other);

    // Assert
    assertTrue(actualXorResult instanceof ParticularIntegerValue);
    assertEquals(other, actualXorResult);
  }

  /**
   * Method under test: {@link IntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  public void testXor3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualXorResult = comparisonValue.xor(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link IntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  public void testXor4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.xor(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  public void testXor5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.xor((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  public void testXor6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.xor(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  public void testXor7() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.xor(other));
  }

  /**
   * Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  public void testXor8() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.xor(other));
  }

  /**
   * Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  public void testXor9() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.xor(other));
  }

  /**
   * Method under test: {@link IntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  public void testEqual() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  public void testEqual2() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.equal((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  public void testEqual5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.equal(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  public void testEqual6() {
    // Arrange, Act and Assert
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.equal(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  public void testEqual7() {
    // Arrange, Act and Assert
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.equal(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  public void testEqual8() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.equal(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  public void testLessThan() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  public void testLessThan2() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  public void testLessThan3() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  public void testLessThan4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  public void testLessThan5() {
    // Arrange, Act and Assert
    assertEquals(0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  public void testLessThan6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  public void testLessThan7() {
    // Arrange, Act and Assert
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  public void testLessThan8() {
    // Arrange, Act and Assert
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  public void testLessThan9() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Method under test:
   * {@link IntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link IntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual2() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual3() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThanOrEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual5() {
    // Arrange, Act and Assert
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .lessThanOrEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual7() {
    // Arrange, Act and Assert
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual8() {
    // Arrange, Act and Assert
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual9() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#notEqual(IntegerValue)}
   */
  @Test
  public void testNotEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownIntegerValue()).notEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.notEqual(new ParticularIntegerValue(42)));
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.notEqual(new RangeIntegerValue(1, 3)));
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.notEqual(new UnknownIntegerValue()));
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.notEqual(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#notEqual(ParticularIntegerValue)}
   */
  @Test
  public void testNotEqual2() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.notEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#notEqual(ParticularIntegerValue)}
   */
  @Test
  public void testNotEqual3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.notEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#notEqual(RangeIntegerValue)}
   */
  @Test
  public void testNotEqual4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.notEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#notEqual(SpecificIntegerValue)}
   */
  @Test
  public void testNotEqual5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.notEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#notEqual(UnknownIntegerValue)}
   */
  @Test
  public void testNotEqual6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.notEqual(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#notEqual(UnknownIntegerValue)}
   */
  @Test
  public void testNotEqual7() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.notEqual(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#greaterThan(IntegerValue)}
   */
  @Test
  public void testGreaterThan() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownIntegerValue()).greaterThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.greaterThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0,
        (new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .greaterThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(new ParticularIntegerValue(42)));
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(new RangeIntegerValue(1, 3)));
    assertEquals(Value.NEVER, ParticularValueFactory.INTEGER_VALUE_0.greaterThan(new RangeIntegerValue(1, 3)));
    assertEquals(0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
    assertEquals(0,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(new UnknownIntegerValue()));
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.greaterThan(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#greaterThan(ParticularIntegerValue)}
   */
  @Test
  public void testGreaterThan2() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThan(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#greaterThan(ParticularIntegerValue)}
   */
  @Test
  public void testGreaterThan3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThan(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#greaterThan(RangeIntegerValue)}
   */
  @Test
  public void testGreaterThan4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link IntegerValue#greaterThan(SpecificIntegerValue)}
   */
  @Test
  public void testGreaterThan5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#greaterThan(UnknownIntegerValue)}
   */
  @Test
  public void testGreaterThan6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThan(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#greaterThan(UnknownIntegerValue)}
   */
  @Test
  public void testGreaterThan7() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThan(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#greaterThanOrEqual(IntegerValue)}
   */
  @Test
  public void testGreaterThanOrEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownIntegerValue()).greaterThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0,
        (new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .greaterThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(new ParticularIntegerValue(42)));
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(new RangeIntegerValue(1, 3)));
    assertEquals(Value.NEVER, ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(new RangeIntegerValue(1, 3)));
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE
        .greaterThanOrEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0
        .greaterThanOrEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(new UnknownIntegerValue()));
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Method under test:
   * {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  public void testGreaterThanOrEqual2() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  public void testGreaterThanOrEqual3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)}
   */
  @Test
  public void testGreaterThanOrEqual4() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  public void testGreaterThanOrEqual5() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThanOrEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  public void testGreaterThanOrEqual6() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Method under test:
   * {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  public void testGreaterThanOrEqual7() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Method under test: {@link IntegerValue#integerValue()}
   */
  @Test
  public void testIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.integerValue());
  }

  /**
   * Method under test: {@link IntegerValue#computationalType()}
   */
  @Test
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(1, (new UnknownIntegerValue()).computationalType());
  }

  /**
   * Method under test: {@link IntegerValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("I", (new UnknownIntegerValue()).internalType());
  }
}
