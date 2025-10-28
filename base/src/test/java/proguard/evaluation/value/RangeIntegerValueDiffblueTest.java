package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RangeIntegerValueDiffblueTest {
  /**
   * Method under test: {@link RangeIntegerValue#value()}
   */
  @Test
  public void testValue() {
    // Arrange, Act and Assert
    assertEquals(1, (new RangeIntegerValue(1, 3)).value());
  }

  /**
   * Method under test: {@link RangeIntegerValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    IntegerValue actualNegateResult = (new RangeIntegerValue(1, 3)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof RangeIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#negate()}
   */
  @Test
  public void testNegate2() {
    // Arrange and Act
    IntegerValue actualNegateResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof RangeIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isSpecific());
    assertTrue(actualNegateResult.isParticular());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToByte()}
   */
  @Test
  public void testConvertToByte() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.convertToByte());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToByte()}
   */
  @Test
  public void testConvertToByte2() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3)).convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToByteResult.isCategory2());
    assertFalse(actualConvertToByteResult.isParticular());
    assertFalse(actualConvertToByteResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToByte()}
   */
  @Test
  public void testConvertToByte3() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult = (new RangeIntegerValue(1, 32767)).convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToByteResult.isCategory2());
    assertFalse(actualConvertToByteResult.isParticular());
    assertFalse(actualConvertToByteResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToCharacter()}
   */
  @Test
  public void testConvertToCharacter() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.convertToCharacter());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToCharacter()}
   */
  @Test
  public void testConvertToCharacter2() {
    // Arrange and Act
    IntegerValue actualConvertToCharacterResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3)).convertToCharacter();

    // Assert
    assertTrue(actualConvertToCharacterResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToCharacterResult.isCategory2());
    assertFalse(actualConvertToCharacterResult.isParticular());
    assertFalse(actualConvertToCharacterResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToCharacter()}
   */
  @Test
  public void testConvertToCharacter3() {
    // Arrange and Act
    IntegerValue actualConvertToCharacterResult = (new RangeIntegerValue(1, Integer.MAX_VALUE)).convertToCharacter();

    // Assert
    assertTrue(actualConvertToCharacterResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToCharacterResult.isCategory2());
    assertFalse(actualConvertToCharacterResult.isParticular());
    assertFalse(actualConvertToCharacterResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToShort()}
   */
  @Test
  public void testConvertToShort() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.convertToShort());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToShort()}
   */
  @Test
  public void testConvertToShort2() {
    // Arrange and Act
    IntegerValue actualConvertToShortResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3)).convertToShort();

    // Assert
    assertTrue(actualConvertToShortResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToShortResult.isCategory2());
    assertFalse(actualConvertToShortResult.isParticular());
    assertFalse(actualConvertToShortResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToShort()}
   */
  @Test
  public void testConvertToShort3() {
    // Arrange and Act
    IntegerValue actualConvertToShortResult = (new RangeIntegerValue(1, 65535)).convertToShort();

    // Assert
    assertTrue(actualConvertToShortResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToShortResult.isCategory2());
    assertFalse(actualConvertToShortResult.isParticular());
    assertFalse(actualConvertToShortResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToLong()}
   */
  @Test
  public void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new RangeIntegerValue(1, 3)).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof UnknownLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertFalse(actualConvertToLongResult.isSpecific());
    assertTrue(actualConvertToLongResult.isCategory2());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new RangeIntegerValue(1, 3)).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof UnknownFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertFalse(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new RangeIntegerValue(1, 3)).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof UnknownDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertFalse(actualConvertToDoubleResult.isSpecific());
    assertTrue(actualConvertToDoubleResult.isCategory2());
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).generalize(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).generalize(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult = (new RangeIntegerValue(1, 3))
        .generalize(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.generalize(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult = (new RangeIntegerValue(1, 3))
        .generalize(ParticularValueFactory.INTEGER_VALUE_4);

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult = rangeIntegerValue
        .generalize((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, Float.MAX_EXPONENT);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  public void testGeneralize9() {
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
   * Method under test:
   * {@link RangeIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.generalize(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  public void testGeneralize11() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult = rangeIntegerValue.generalize(new ParticularIntegerValue(0));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  public void testGeneralize12() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.generalize(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  public void testGeneralize13() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, rangeIntegerValue.generalize(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  public void testGeneralize14() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 1);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, rangeIntegerValue.generalize(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  public void testGeneralize15() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);

    // Act
    IntegerValue actualGeneralizeResult = rangeIntegerValue.generalize(new RangeIntegerValue(1, 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  public void testGeneralize16() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 1);

    // Act
    IntegerValue actualGeneralizeResult = rangeIntegerValue.generalize(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd() {
    // Arrange and Act
    IntegerValue actualAddResult = (new RangeIntegerValue(1, 3)).add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange and Act
    IntegerValue actualAddResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).add(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.add(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd5() {
    // Arrange and Act
    IntegerValue actualAddResult = (new RangeIntegerValue(1, 3)).add(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd6() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue
        .add((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd7() {
    // Arrange and Act
    IntegerValue actualAddResult = (new RangeIntegerValue(1, 3)).add(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd8() {
    // Arrange and Act
    IntegerValue actualAddResult = (new RangeIntegerValue(1, 3)).add(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd9() {
    // Arrange and Act
    IntegerValue actualAddResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .add(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  public void testAdd10() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  public void testAdd11() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.add(new ParticularIntegerValue(0)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  public void testAdd12() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  public void testAdd13() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  public void testAdd14() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new ParticularIntegerValue(Integer.MAX_VALUE));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd15() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd16() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MAX_VALUE, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd17() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MAX_VALUE);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new RangeIntegerValue(1, 3))
        .subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).subtract(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.subtract(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract5() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new RangeIntegerValue(1, 3)).subtract(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract6() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue
        .subtract((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract7() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new RangeIntegerValue(1, 3)).subtract(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract8() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new RangeIntegerValue(1, 3)).subtract(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract9() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .subtract(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  public void testSubtract10() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  public void testSubtract11() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  public void testSubtract12() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new ParticularIntegerValue(-41));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  public void testSubtract13() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.subtract(new ParticularIntegerValue(0)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  public void testSubtract14() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  public void testSubtract15() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  public void testSubtract16() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  public void testSubtract17() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new RangeIntegerValue(1, 3))
        .subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).subtractFrom(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new RangeIntegerValue(1, 3))
        .subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractFromResult = rangeIntegerValue
        .subtractFrom((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom6() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new RangeIntegerValue(1, 3))
        .subtractFrom(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom7() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom8() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new RangeIntegerValue(1, Integer.MIN_VALUE))
        .subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  public void testSubtractFrom9() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractFromResult = rangeIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  public void testSubtractFrom10() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualSubtractFromResult = rangeIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  public void testSubtractFrom11() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractFromResult = rangeIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom12() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractFromResult = rangeIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom13() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualSubtractFromResult = rangeIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom14() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractFromResult = rangeIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = (new RangeIntegerValue(1, 3))
        .multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).multiply(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).multiply(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.multiply(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply5() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = (new RangeIntegerValue(1, 3)).multiply(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply6() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue
        .multiply((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply7() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = (new RangeIntegerValue(1, 3)).multiply(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply8() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .multiply(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply9() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = (new RangeIntegerValue(1, Integer.MIN_VALUE))
        .multiply(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  public void testMultiply10() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  public void testMultiply11() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  public void testMultiply12() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  public void testMultiply13() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.multiply(new ParticularIntegerValue(1)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  public void testMultiply14() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.multiply(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  public void testMultiply15() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue.multiply(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  public void testMultiply16() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue.multiply(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult = (new RangeIntegerValue(1, 3)).divide(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide2() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).divide(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide3() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult = (new RangeIntegerValue(1, 3)).divide(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide4() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.divide(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide5() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult = (new RangeIntegerValue(1, 3)).divide(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide6() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult = rangeIntegerValue
        .divide((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide7() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult = (new RangeIntegerValue(1, 3)).divide(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide8() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .divide(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide9() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult = (new RangeIntegerValue(1, Integer.MIN_VALUE))
        .divide(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  public void testDivide10() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult = rangeIntegerValue.divide(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isSpecific());
    assertTrue(actualDivideResult.isParticular());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  public void testDivide11() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.divide(new ParticularIntegerValue(1)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  public void testDivide12() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult = rangeIntegerValue.divide(new ParticularIntegerValue(0));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  public void testDivide13() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult = rangeIntegerValue.divide(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  public void testDivide14() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualDivideResult = rangeIntegerValue.divide(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  public void testDivide15() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualDivideResult = rangeIntegerValue.divide(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  public void testDivide16() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult = rangeIntegerValue.divide(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult = (new RangeIntegerValue(1, 3))
        .divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf2() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).divideOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf3() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult = (new RangeIntegerValue(1, 3)).divideOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isSpecific());
    assertTrue(actualDivideOfResult.isParticular());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf4() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideOfResult = rangeIntegerValue
        .divideOf((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf5() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult = (new RangeIntegerValue(1, 3)).divideOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf6() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult = (new RangeIntegerValue(0, 3)).divideOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf7() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult = (new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE))
        .divideOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isSpecific());
    assertTrue(actualDivideOfResult.isParticular());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  public void testDivideOf8() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideOfResult = rangeIntegerValue.divideOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  public void testDivideOf9() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 3);

    // Act
    IntegerValue actualDivideOfResult = rangeIntegerValue.divideOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  public void testDivideOf10() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideOfResult = rangeIntegerValue.divideOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  public void testDivideOf11() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE);

    // Act
    IntegerValue actualDivideOfResult = rangeIntegerValue.divideOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isSpecific());
    assertTrue(actualDivideOfResult.isParticular());
  }

  /**
   * Method under test: {@link RangeIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  public void testDivideOf12() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideOfResult = rangeIntegerValue.divideOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult = (new RangeIntegerValue(1, 3))
        .remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder2() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).remainder(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder3() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult = (new RangeIntegerValue(1, 3))
        .remainder(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder4() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult = (new RangeIntegerValue(1, 3))
        .remainder(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isSpecific());
    assertTrue(actualRemainderResult.isParticular());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder5() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.remainder(ParticularValueFactory.INTEGER_VALUE_4));
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder6() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderResult = rangeIntegerValue
        .remainder((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder7() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .remainder(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  public void testRemainder8() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.remainder(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  public void testRemainder9() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualRemainderResult = rangeIntegerValue.remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  public void testRemainder10() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    IntegerValue actualRemainderResult = rangeIntegerValue.remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  public void testRemainder11() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderResult = rangeIntegerValue.remainder(new ParticularIntegerValue(0));

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  public void testRemainder12() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderResult = rangeIntegerValue.remainder(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult = (new RangeIntegerValue(1, 3))
        .remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf2() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).remainderOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf3() throws ArithmeticException {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).remainderOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf4() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult = (new RangeIntegerValue(1, 3))
        .remainderOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf5() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult = (new RangeIntegerValue(1, 3))
        .remainderOf(ParticularValueFactory.INTEGER_VALUE_3);

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf6() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult = rangeIntegerValue
        .remainderOf((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf7() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult = (new RangeIntegerValue(1, 3))
        .remainderOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf8() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult = (new RangeIntegerValue(0, 3))
        .remainderOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  public void testRemainderOf9() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult = rangeIntegerValue.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  public void testRemainderOf10() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 3);

    // Act
    IntegerValue actualRemainderOfResult = rangeIntegerValue.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  public void testRemainderOf11() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult = rangeIntegerValue.remainderOf(new ParticularIntegerValue(1));

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  public void testRemainderOf12() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.remainderOf(other));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  public void testRemainderOf13() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult = rangeIntegerValue.remainderOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  public void testRemainderOf14() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult = rangeIntegerValue.remainderOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult = (new RangeIntegerValue(1, 3))
        .shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftLeft(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.shiftLeft(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft4() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult = (new RangeIntegerValue(1, 3))
        .shiftLeft(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult = rangeIntegerValue
        .shiftLeft((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft6() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult = (new RangeIntegerValue(1, 3))
        .shiftLeft(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft7() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult = (new RangeIntegerValue(1, Integer.MIN_VALUE))
        .shiftLeft(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft8() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult = rangeIntegerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft9() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 3);

    // Act
    IntegerValue actualShiftLeftResult = rangeIntegerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft10() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult = rangeIntegerValue.shiftLeft(new ParticularIntegerValue(10));

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft11() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.shiftLeft(new ParticularIntegerValue(1024)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeft12() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult = rangeIntegerValue.shiftLeft(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult = (new RangeIntegerValue(1, 3))
        .shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftLeftOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf3() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftLeftOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf4() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult = (new RangeIntegerValue(1, 3))
        .shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult = rangeIntegerValue
        .shiftLeftOf((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf6() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult = (new RangeIntegerValue(1, 3))
        .shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf7() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf8() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult = (new RangeIntegerValue(1, Integer.SIZE))
        .shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf9() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult = (new RangeIntegerValue(1, Value.NEVER))
        .shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  public void testShiftLeftOf10() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftLeftOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  public void testShiftLeftOf11() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftLeftOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  public void testShiftLeftOf12() {
    // Arrange and Act
    LongValue actualShiftLeftOfResult = (new RangeIntegerValue(1, 3)).shiftLeftOf(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
    assertTrue(actualShiftLeftOfResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeftOf13() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult = rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeftOf14() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualShiftLeftOfResult = rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeftOf15() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    IntegerValue actualShiftLeftOfResult = rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeftOf16() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.shiftLeftOf(other));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeftOf17() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult = rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeftOf18() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult = rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  public void testShiftLeftOf19() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    LongValue actualShiftLeftOfResult = rangeIntegerValue.shiftLeftOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
    assertTrue(actualShiftLeftOfResult.isCategory2());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  public void testShiftLeftOf20() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularLongValue other = new ParticularLongValue(0L);

    // Act and Assert
    assertSame(other, rangeIntegerValue.shiftLeftOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeftOf21() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult = rangeIntegerValue.shiftLeftOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight() {
    // Arrange and Act
    IntegerValue actualShiftRightResult = (new RangeIntegerValue(1, 3))
        .shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftRight(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.shiftRight(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight4() {
    // Arrange and Act
    IntegerValue actualShiftRightResult = (new RangeIntegerValue(1, 3))
        .shiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightResult = rangeIntegerValue
        .shiftRight((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRight6() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightResult = rangeIntegerValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isParticular());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRight7() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.shiftRight(new ParticularIntegerValue(0)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  public void testShiftRight8() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightResult = rangeIntegerValue.shiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult = (new RangeIntegerValue(1, 3))
        .shiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftRightOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf3() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftRightOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf4() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult = (new RangeIntegerValue(1, 3))
        .shiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isParticular());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult = rangeIntegerValue
        .shiftRightOf((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf6() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult = (new RangeIntegerValue(1, 3))
        .shiftRightOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isParticular());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf7() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .shiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf8() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult = (new RangeIntegerValue(1, Integer.SIZE))
        .shiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  public void testShiftRightOf9() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftRightOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  public void testShiftRightOf10() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftRightOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  public void testShiftRightOf11() {
    // Arrange and Act
    LongValue actualShiftRightOfResult = (new RangeIntegerValue(1, 3))
        .shiftRightOf(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRightOf12() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult = rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRightOf13() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualShiftRightOfResult = rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRightOf14() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    IntegerValue actualShiftRightOfResult = rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRightOf15() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.shiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRightOf16() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult = rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isParticular());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testShiftRightOf17() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    LongValue actualShiftRightOfResult = rangeIntegerValue.shiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testShiftRightOf18() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularLongValue other = new ParticularLongValue(0L);

    // Act and Assert
    assertSame(other, rangeIntegerValue.shiftRightOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftRightOf19() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult = rangeIntegerValue.shiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult = (new RangeIntegerValue(1, 3))
        .unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).unsignedShiftRight(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight4() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult = (new RangeIntegerValue(1, 3))
        .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult = rangeIntegerValue
        .unsignedShiftRight((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight6() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight7() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult = (new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE))
        .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight8() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult = rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight9() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult = rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight10() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(0)));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight11() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE);

    // Act
    IntegerValue actualUnsignedShiftRightResult = rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight12() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult = rangeIntegerValue.unsignedShiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult = (new RangeIntegerValue(1, 3))
        .unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf3() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf4() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult = (new RangeIntegerValue(1, 3))
        .unsignedShiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isParticular());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = rangeIntegerValue
        .unsignedShiftRightOf((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf6() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3))
        .unsignedShiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf7() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult = (new RangeIntegerValue(1, Integer.SIZE))
        .unsignedShiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf8() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).unsignedShiftRightOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf9() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).unsignedShiftRightOf(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf10() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightOfResult = (new RangeIntegerValue(1, 3))
        .unsignedShiftRightOf(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf11() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = rangeIntegerValue
        .unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf12() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = rangeIntegerValue
        .unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf13() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = rangeIntegerValue
        .unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf14() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf15() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    LongValue actualUnsignedShiftRightOfResult = rangeIntegerValue.unsignedShiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf16() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularLongValue other = new ParticularLongValue(0L);

    // Act and Assert
    assertSame(other, rangeIntegerValue.unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf17() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = rangeIntegerValue.unsignedShiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd() {
    // Arrange and Act
    IntegerValue actualAndResult = (new RangeIntegerValue(1, 3)).and(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).and(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd3() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).and(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd4() {
    // Arrange and Act
    IntegerValue actualAndResult = (new RangeIntegerValue(1, 3)).and(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult = rangeIntegerValue
        .and((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd6() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.and(ParticularValueFactory.INTEGER_VALUE_M1));
  }

  /**
   * Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  public void testAnd7() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult = rangeIntegerValue.and(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  public void testAnd8() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.and(new ParticularIntegerValue(Value.NEVER)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  public void testAnd9() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.and(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  public void testAnd10() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult = rangeIntegerValue.and(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  public void testAnd11() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult = rangeIntegerValue.and(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr() {
    // Arrange and Act
    IntegerValue actualOrResult = (new RangeIntegerValue(1, 3)).or(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).or(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.or(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr4() {
    // Arrange and Act
    IntegerValue actualOrResult = (new RangeIntegerValue(1, 3)).or(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult = rangeIntegerValue
        .or((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr6() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_M1;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).or(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  public void testOr7() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult = rangeIntegerValue.or(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  public void testOr8() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(Value.NEVER);

    // Act and Assert
    assertSame(other, rangeIntegerValue.or(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  public void testOr9() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.or(new ParticularIntegerValue(0)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  public void testOr10() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult = rangeIntegerValue.or(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualOrResult instanceof RangeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  public void testOr11() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult = rangeIntegerValue.or(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor() {
    // Arrange and Act
    IntegerValue actualXorResult = (new RangeIntegerValue(1, 3)).xor(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor2() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).xor(other));
  }

  /**
   * Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.xor(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor4() {
    // Arrange and Act
    IntegerValue actualXorResult = (new RangeIntegerValue(1, 3)).xor(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualXorResult = rangeIntegerValue
        .xor((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  public void testXor6() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualXorResult = rangeIntegerValue.xor(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  public void testXor7() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.xor(new ParticularIntegerValue(0)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  public void testXor8() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualXorResult = rangeIntegerValue.xor(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  public void testEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new RangeIntegerValue(1, 3)).equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(Value.NEVER,
        (new RangeIntegerValue(1, Integer.MIN_VALUE)).equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, (new RangeIntegerValue(1, 3)).equal(BasicValueFactory.INTEGER_VALUE));
    assertEquals(Value.NEVER, (new RangeIntegerValue(1, 3)).equal(ParticularValueFactory.INTEGER_VALUE_0));
    assertEquals(0, (new RangeIntegerValue(1, 3)).equal(ParticularValueFactory.INTEGER_VALUE_1));
    assertEquals(Value.NEVER, (new RangeIntegerValue(1, 3)).equal(ParticularValueFactory.INTEGER_VALUE_4));
    assertEquals(1, (new RangeIntegerValue(1, 1)).equal(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  public void testEqual2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(0,
        rangeIntegerValue.equal((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(42, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  public void testEqual5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  public void testEqual6() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.equal(new ParticularIntegerValue(Value.NEVER)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  public void testEqual7() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(42, 42);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual8() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual9() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual10() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 1);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual11() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 0);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual12() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.equal(new RangeIntegerValue(1, 0)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual13() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.equal(new RangeIntegerValue(3, 3)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  public void testLessThan() {
    // Arrange, Act and Assert
    assertEquals(0, (new RangeIntegerValue(1, 3)).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(Value.NEVER,
        (new RangeIntegerValue(Float.MAX_EXPONENT, 3)).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(1, (new RangeIntegerValue(1, Integer.MIN_VALUE)).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, (new RangeIntegerValue(1, 3)).lessThan(BasicValueFactory.INTEGER_VALUE));
    assertEquals(Value.NEVER, (new RangeIntegerValue(1, 3)).lessThan(ParticularValueFactory.INTEGER_VALUE_0));
    assertEquals(0, (new RangeIntegerValue(1, 3)).lessThan(ParticularValueFactory.INTEGER_VALUE_2));
    assertEquals(1, (new RangeIntegerValue(1, 3)).lessThan(ParticularValueFactory.INTEGER_VALUE_4));
  }

  /**
   * Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  public void testLessThan2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(0,
        rangeIntegerValue.lessThan((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  public void testLessThan3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  public void testLessThan4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  public void testLessThan5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.lessThan(new ParticularIntegerValue(1)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  public void testLessThan6() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  public void testLessThan7() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  public void testLessThan8() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 0);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  public void testLessThanOrEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new RangeIntegerValue(1, 3)).lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(1, (new RangeIntegerValue(1, -128)).lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, (new RangeIntegerValue(1, 3)).lessThanOrEqual(BasicValueFactory.INTEGER_VALUE));
    assertEquals(Value.NEVER, (new RangeIntegerValue(1, 3)).lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_0));
    assertEquals(0, (new RangeIntegerValue(1, 3)).lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_1));
    assertEquals(1, (new RangeIntegerValue(1, 3)).lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_3));
  }

  /**
   * Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  public void testLessThanOrEqual2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(0,
        rangeIntegerValue.lessThanOrEqual((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.lessThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.lessThanOrEqual(new ParticularIntegerValue(1)));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.lessThanOrEqual(new ParticularIntegerValue(0)));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual6() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual7() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 1);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual8() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 0)));
  }

  /**
   * Method under test: {@link RangeIntegerValue#isParticular()}
   */
  @Test
  public void testIsParticular() {
    // Arrange, Act and Assert
    assertFalse((new RangeIntegerValue(1, 3)).isParticular());
    assertTrue((new RangeIntegerValue(3, 3)).isParticular());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RangeIntegerValue#equals(Object)}
   *   <li>{@link RangeIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(rangeIntegerValue, rangeIntegerValue);
    int expectedHashCodeResult = rangeIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, rangeIntegerValue.hashCode());
  }

  /**
   * Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("1..3", (new RangeIntegerValue(1, 3)).toString());
    assertEquals("3", (new RangeIntegerValue(3, 3)).toString());
    assertEquals("-128..3", (new RangeIntegerValue(-128, 3)).toString());
    assertEquals("-32768..3", (new RangeIntegerValue(-32768, 3)).toString());
    assertEquals("-2147483648..3", (new RangeIntegerValue(Integer.MIN_VALUE, 3)).toString());
    assertEquals("0..3", (new RangeIntegerValue(0, 3)).toString());
    assertEquals("b", (new RangeIntegerValue(-128, Float.MAX_EXPONENT)).toString());
    assertEquals("s", (new RangeIntegerValue(-32768, 32767)).toString());
    assertEquals("i", (new RangeIntegerValue(Integer.MIN_VALUE, Integer.MAX_VALUE)).toString());
    assertEquals("z", (new RangeIntegerValue(0, 1)).toString());
  }

  /**
   * Method under test: {@link RangeIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertNotEquals(rangeIntegerValue, new RangeIntegerValue(1, 3));
  }

  /**
   * Method under test: {@link RangeIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RangeIntegerValue(1, 3), null);
  }

  /**
   * Method under test: {@link RangeIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RangeIntegerValue(1, 3), "Different type to RangeIntegerValue");
  }

  /**
   * Method under test: {@link RangeIntegerValue#RangeIntegerValue(int, int)}
   */
  @Test
  public void testNewRangeIntegerValue() {
    // Arrange and Act
    RangeIntegerValue actualRangeIntegerValue = new RangeIntegerValue(1, 3);

    // Assert
    assertFalse(actualRangeIntegerValue.isCategory2());
    assertFalse(actualRangeIntegerValue.isParticular());
    assertFalse(actualRangeIntegerValue.isSpecific());
  }
}
