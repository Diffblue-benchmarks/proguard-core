package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SpecificIntegerValueDiffblueTest {
  /**
   * Method under test: {@link SpecificIntegerValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    IntegerValue actualNegateResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof NegatedIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#negate()}
   */
  @Test
  public void testNegate2() {
    // Arrange and Act
    IntegerValue actualNegateResult = (new ParticularIntegerValue(42)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof ParticularIntegerValue);
    assertEquals(-42, actualNegateResult.value());
    assertFalse(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#convertToByte()}
   */
  @Test
  public void testConvertToByte() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof ConvertedByteValue);
    assertFalse(actualConvertToByteResult.isCategory2());
    assertFalse(actualConvertToByteResult.isParticular());
    assertTrue(actualConvertToByteResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#convertToCharacter()}
   */
  @Test
  public void testConvertToCharacter() {
    // Arrange and Act
    IntegerValue actualConvertToCharacterResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToCharacter();

    // Assert
    assertTrue(actualConvertToCharacterResult instanceof ConvertedCharacterValue);
    assertFalse(actualConvertToCharacterResult.isCategory2());
    assertFalse(actualConvertToCharacterResult.isParticular());
    assertTrue(actualConvertToCharacterResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#convertToShort()}
   */
  @Test
  public void testConvertToShort() {
    // Arrange and Act
    IntegerValue actualConvertToShortResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToShort();

    // Assert
    assertTrue(actualConvertToShortResult instanceof ConvertedShortValue);
    assertFalse(actualConvertToShortResult.isCategory2());
    assertFalse(actualConvertToShortResult.isParticular());
    assertTrue(actualConvertToShortResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#convertToLong()}
   */
  @Test
  public void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ConvertedLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#convertToLong()}
   */
  @Test
  public void testConvertToLong2() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new ParticularIntegerValue(42)).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ParticularLongValue);
    assertEquals(42L, actualConvertToLongResult.value());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ConvertedFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat2() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new ParticularIntegerValue(42)).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ParticularFloatValue);
    assertEquals(42.0f, actualConvertToFloatResult.value(), 0.0f);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertTrue(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ConvertedDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble2() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new ParticularIntegerValue(42)).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ParticularDoubleValue);
    assertEquals(42.0d, actualConvertToDoubleResult.value(), 0.0);
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).generalize(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .generalize(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedByteValue other = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, convertedByteValue.generalize((IntegerValue) other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualGeneralizeResult = convertedByteValue
        .generalize((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualGeneralizeResult = convertedByteValue
        .generalize((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult = (new ParticularIntegerValue(Integer.MIN_VALUE))
        .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualGeneralizeResult = convertedByteValue.generalize(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualGeneralizeResult = particularIntegerValue.generalize(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(particularIntegerValue,
        particularIntegerValue.generalize((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  public void testGeneralize11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualGeneralizeResult = particularIntegerValue
        .generalize((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  public void testGeneralize12() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult = (new ParticularIntegerValue(42)).generalize((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  public void testGeneralize13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualGeneralizeResult = particularIntegerValue
        .generalize(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd() {
    // Arrange and Act
    IntegerValue actualAddResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange and Act
    IntegerValue actualAddResult = (new ParticularIntegerValue(42)).add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).add(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange and Act
    IntegerValue actualAddResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .add(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd5() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAddResult = convertedByteValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAddResult = particularIntegerValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  public void testAdd7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAddResult = particularIntegerValue.add((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new ParticularIntegerValue(42))
        .subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtract(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .subtract(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract5() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractResult = convertedByteValue
        .subtract((IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractResult.value());
    assertFalse(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract6() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractResult = convertedByteValue
        .subtract((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract7() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualSubtractResult = convertedByteValue
        .subtract((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  public void testSubtract8() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractResult = convertedByteValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  public void testSubtract9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult = particularIntegerValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  public void testSubtract10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult = particularIntegerValue
        .subtract((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractResult.value());
    assertFalse(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  public void testSubtract11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualSubtractResult = particularIntegerValue
        .subtract((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  public void testSubtract12() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new ParticularIntegerValue(42)).subtract((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  public void testSubtract13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult = particularIntegerValue
        .subtract(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new ParticularIntegerValue(42))
        .subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtractFrom(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom5() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractFromResult = convertedByteValue
        .subtractFrom((IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractFromResult.value());
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom6() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractFromResult = convertedByteValue
        .subtractFrom((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom7() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualSubtractFromResult = convertedByteValue
        .subtractFrom((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom8() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractFromResult = convertedByteValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult = particularIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  public void testSubtractFrom10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult = particularIntegerValue
        .subtractFrom((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractFromResult.value());
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  public void testSubtractFrom11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualSubtractFromResult = particularIntegerValue
        .subtractFrom((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  public void testSubtractFrom12() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new ParticularIntegerValue(42)).subtractFrom((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  public void testSubtractFrom13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult = particularIntegerValue
        .subtractFrom(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = (new ParticularIntegerValue(42))
        .multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).multiply(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .multiply(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  public void testMultiply5() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualMultiplyResult = convertedByteValue.multiply(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  public void testMultiply6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualMultiplyResult = particularIntegerValue.multiply(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  public void testMultiply7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualMultiplyResult = particularIntegerValue
        .multiply((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .divide(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide2() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divide(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide3() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .divide(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  public void testDivide4() throws ArithmeticException {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualDivideResult = convertedByteValue.divide(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  public void testDivide5() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue.divide(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  public void testDivide6() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue
        .divide((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf2() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult = (new ParticularIntegerValue(42))
        .divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf3() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divideOf(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf4() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .divideOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  public void testDivideOf5() throws ArithmeticException {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualDivideOfResult = convertedByteValue.divideOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  public void testDivideOf6() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideOfResult = particularIntegerValue.divideOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isSpecific());
    assertTrue(actualDivideOfResult.isParticular());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#divideOf(SpecificIntegerValue)}
   */
  @Test
  public void testDivideOf7() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideOfResult = particularIntegerValue
        .divideOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder2() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainder(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder3() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .remainder(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  public void testRemainder4() throws ArithmeticException {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualRemainderResult = convertedByteValue.remainder(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  public void testRemainder5() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult = particularIntegerValue.remainder(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#remainder(SpecificIntegerValue)}
   */
  @Test
  public void testRemainder6() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult = particularIntegerValue
        .remainder((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf2() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainderOf(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf3() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .remainderOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  public void testRemainderOf4() throws ArithmeticException {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualRemainderOfResult = convertedByteValue.remainderOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#remainderOf(SpecificIntegerValue)}
   */
  @Test
  public void testRemainderOf5() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderOfResult = particularIntegerValue
        .remainderOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftLeft(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft3() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeft4() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftLeftResult = convertedByteValue.shiftLeft(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeft5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult = particularIntegerValue.shiftLeft(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#shiftLeft(SpecificIntegerValue)}
   */
  @Test
  public void testShiftLeft6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult = particularIntegerValue
        .shiftLeft((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftLeftOf(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf3() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  public void testShiftLeftOf4() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftLeftOf(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  public void testShiftLeftOf5() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftLeftOf(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  public void testShiftLeftOf6() {
    // Arrange and Act
    LongValue actualShiftLeftOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftLeftOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  public void testShiftLeftOf7() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftLeftOfResult = convertedByteValue
        .shiftLeftOf((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeftOf8() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftLeftOfResult = convertedByteValue.shiftLeftOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#shiftLeftOf(SpecificIntegerValue)}
   */
  @Test
  public void testShiftLeftOf9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult = particularIntegerValue
        .shiftLeftOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#shiftLeftOf(SpecificLongValue)}
   */
  @Test
  public void testShiftLeftOf10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftLeftOfResult = particularIntegerValue
        .shiftLeftOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight() {
    // Arrange and Act
    IntegerValue actualShiftRightResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftRight(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight3() {
    // Arrange and Act
    IntegerValue actualShiftRightResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  public void testShiftRight4() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftRightResult = convertedByteValue.shiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  public void testShiftRight5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult = particularIntegerValue.shiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  public void testShiftRight6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult = particularIntegerValue
        .shiftRight((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf2() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult = (new ParticularIntegerValue(42))
        .shiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftRightOf(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf4() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftRightOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  public void testShiftRightOf5() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftRightOf(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  public void testShiftRightOf6() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftRightOf(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  public void testShiftRightOf7() {
    // Arrange and Act
    LongValue actualShiftRightOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .shiftRightOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  public void testShiftRightOf8() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftRightOfResult = convertedByteValue
        .shiftRightOf((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftRightOf9() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftRightOfResult = convertedByteValue.shiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftRightOf10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightOfResult = particularIntegerValue.shiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isParticular());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#shiftRightOf(SpecificIntegerValue)}
   */
  @Test
  public void testShiftRightOf11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightOfResult = particularIntegerValue
        .shiftRightOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#shiftRightOf(SpecificLongValue)}
   */
  @Test
  public void testShiftRightOf12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftRightOfResult = particularIntegerValue
        .shiftRightOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).unsignedShiftRight(other));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight3() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight4() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualUnsignedShiftRightResult = convertedByteValue.unsignedShiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult = particularIntegerValue
        .unsignedShiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult = particularIntegerValue
        .unsignedShiftRight((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf2() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult = (new ParticularIntegerValue(42))
        .unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf4() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .unsignedShiftRightOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf5() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf6() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf7() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightOfResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .unsignedShiftRightOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf8() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualUnsignedShiftRightOfResult = convertedByteValue
        .unsignedShiftRightOf((LongValue) new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf9() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = convertedByteValue
        .unsignedShiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = particularIntegerValue
        .unsignedShiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isParticular());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(SpecificIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = particularIntegerValue
        .unsignedShiftRightOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#unsignedShiftRightOf(SpecificLongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualUnsignedShiftRightOfResult = particularIntegerValue
        .unsignedShiftRightOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd() {
    // Arrange and Act
    IntegerValue actualAndResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .and(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd2() {
    // Arrange and Act
    IntegerValue actualAndResult = (new ParticularIntegerValue(42)).and(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).and(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd4() {
    // Arrange and Act
    IntegerValue actualAndResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .and(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd5() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedByteValue other = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, convertedByteValue.and((IntegerValue) other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd6() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAndResult = convertedByteValue
        .and((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd7() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualAndResult = convertedByteValue
        .and((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  public void testAnd8() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAndResult = convertedByteValue.and(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  public void testAnd9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAndResult = particularIntegerValue.and(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  public void testAnd10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(particularIntegerValue,
        particularIntegerValue.and((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  public void testAnd11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualAndResult = particularIntegerValue.and((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  public void testAnd12() {
    // Arrange and Act
    IntegerValue actualAndResult = (new ParticularIntegerValue(42)).and((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  public void testAnd13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAndResult = particularIntegerValue
        .and(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr() {
    // Arrange and Act
    IntegerValue actualOrResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .or(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).or(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr3() {
    // Arrange and Act
    IntegerValue actualOrResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .or(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr4() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedByteValue other = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, convertedByteValue.or((IntegerValue) other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr5() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualOrResult = convertedByteValue
        .or((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr6() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualOrResult = convertedByteValue
        .or((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr7() {
    // Arrange and Act
    IntegerValue actualOrResult = (new ParticularIntegerValue(Integer.MIN_VALUE))
        .or(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualOrResult instanceof RangeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  public void testOr8() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualOrResult = convertedByteValue.or(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  public void testOr9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(particularIntegerValue,
        particularIntegerValue.or((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  public void testOr10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualOrResult = particularIntegerValue.or((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  public void testOr11() {
    // Arrange and Act
    IntegerValue actualOrResult = (new ParticularIntegerValue(42)).or((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  public void testOr12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult = particularIntegerValue
        .or(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor() {
    // Arrange and Act
    IntegerValue actualXorResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .xor(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).xor(other));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor3() {
    // Arrange and Act
    IntegerValue actualXorResult = (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .xor(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor4() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualXorResult = convertedByteValue
        .xor((IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof ParticularIntegerValue);
    assertEquals(0, actualXorResult.value());
    assertFalse(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor5() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualXorResult = convertedByteValue
        .xor((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor6() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualXorResult = convertedByteValue
        .xor((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  public void testXor7() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualXorResult = convertedByteValue.xor(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  public void testXor8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult = particularIntegerValue.xor((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualXorResult instanceof ParticularIntegerValue);
    assertEquals(0, actualXorResult.value());
    assertFalse(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  public void testXor9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualXorResult = particularIntegerValue.xor((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  public void testXor10() {
    // Arrange and Act
    IntegerValue actualXorResult = (new ParticularIntegerValue(42)).xor((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  public void testXor11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult = particularIntegerValue
        .xor(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equal(IntegerValue)}
   */
  @Test
  public void testEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).equal(BasicValueFactory.INTEGER_VALUE));
    assertEquals(0, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .equal(ParticularValueFactory.INTEGER_VALUE_0));
    assertEquals(0, (new ParticularIntegerValue(42)).equal((SpecificIntegerValue) null));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equal(IntegerValue)}
   */
  @Test
  public void testEqual2() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(1,
        convertedByteValue.equal((IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equal(IntegerValue)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0,
        convertedByteValue.equal((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equal(IntegerValue)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act and Assert
    assertEquals(0,
        convertedByteValue.equal((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual5() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, convertedByteValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  public void testEqual6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(1, particularIntegerValue.equal((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  public void testEqual7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(0, particularIntegerValue.equal((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  public void testEqual8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(0, particularIntegerValue.equal(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  public void testLessThan() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, (new ParticularIntegerValue(42)).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).lessThan(BasicValueFactory.INTEGER_VALUE));
    assertEquals(0, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .lessThan(ParticularValueFactory.INTEGER_VALUE_0));
    assertEquals(0, (new ParticularIntegerValue(42)).lessThan((SpecificIntegerValue) null));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  public void testLessThan2() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(Value.NEVER,
        convertedByteValue.lessThan((IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  public void testLessThan3() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0,
        convertedByteValue.lessThan((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  public void testLessThan4() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act and Assert
    assertEquals(0,
        convertedByteValue.lessThan((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  public void testLessThan5() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, convertedByteValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  public void testLessThan6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  public void testLessThan7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  public void testLessThan8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(0, particularIntegerValue.lessThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  public void testLessThan9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(0, particularIntegerValue.lessThan(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  public void testLessThanOrEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, (new ParticularIntegerValue(42)).lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .lessThanOrEqual(BasicValueFactory.INTEGER_VALUE));
    assertEquals(0, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_0));
    assertEquals(0, (new ParticularIntegerValue(42)).lessThanOrEqual((SpecificIntegerValue) null));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  public void testLessThanOrEqual2() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(1, convertedByteValue
        .lessThanOrEqual((IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  public void testLessThanOrEqual3() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, convertedByteValue
        .lessThanOrEqual((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  public void testLessThanOrEqual4() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act and Assert
    assertEquals(0, convertedByteValue
        .lessThanOrEqual((IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual5() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, convertedByteValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(1, particularIntegerValue.lessThanOrEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(0, particularIntegerValue.lessThanOrEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(0,
        particularIntegerValue.lessThanOrEqual(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#isSpecific()}
   */
  @Test
  public void testIsSpecific() {
    // Arrange, Act and Assert
    assertTrue((new ParticularIntegerValue(42)).isSpecific());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);
    ParticularIntegerValue particularIntegerValue2 = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(particularIntegerValue, particularIntegerValue2);
    int expectedHashCodeResult = particularIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, particularIntegerValue2.hashCode());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(particularIntegerValue, particularIntegerValue);
    int expectedHashCodeResult = particularIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, particularIntegerValue.hashCode());
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertNotEquals(particularIntegerValue, new ParticularIntegerValue(42));
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularIntegerValue(42), null);
  }

  /**
   * Method under test: {@link SpecificIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularIntegerValue(42), "Different type to SpecificIntegerValue");
  }
}
