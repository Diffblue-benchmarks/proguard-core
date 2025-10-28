package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ParticularIntegerValueDiffblueTest {
  /**
   * Method under test: {@link ParticularIntegerValue#negate()}
   */
  @Test
  public void testNegate() {
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
   * Method under test: {@link ParticularIntegerValue#convertToByte()}
   */
  @Test
  public void testConvertToByte() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.convertToByte());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#convertToByte()}
   */
  @Test
  public void testConvertToByte2() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult = (new ParticularIntegerValue(Integer.MIN_VALUE)).convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof ParticularIntegerValue);
    assertEquals(0, actualConvertToByteResult.value());
    assertFalse(actualConvertToByteResult.isCategory2());
    assertTrue(actualConvertToByteResult.isParticular());
    assertTrue(actualConvertToByteResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#convertToCharacter()}
   */
  @Test
  public void testConvertToCharacter() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.convertToCharacter());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#convertToCharacter()}
   */
  @Test
  public void testConvertToCharacter2() {
    // Arrange and Act
    IntegerValue actualConvertToCharacterResult = (new ParticularIntegerValue(Value.NEVER)).convertToCharacter();

    // Assert
    assertTrue(actualConvertToCharacterResult instanceof ParticularIntegerValue);
    assertEquals(65535, actualConvertToCharacterResult.value());
    assertFalse(actualConvertToCharacterResult.isCategory2());
    assertTrue(actualConvertToCharacterResult.isParticular());
    assertTrue(actualConvertToCharacterResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#convertToShort()}
   */
  @Test
  public void testConvertToShort() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.convertToShort());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#convertToShort()}
   */
  @Test
  public void testConvertToShort2() {
    // Arrange and Act
    IntegerValue actualConvertToShortResult = (new ParticularIntegerValue(Integer.MIN_VALUE)).convertToShort();

    // Assert
    assertTrue(actualConvertToShortResult instanceof ParticularIntegerValue);
    assertEquals(0, actualConvertToShortResult.value());
    assertFalse(actualConvertToShortResult.isCategory2());
    assertTrue(actualConvertToShortResult.isParticular());
    assertTrue(actualConvertToShortResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#convertToLong()}
   */
  @Test
  public void testConvertToLong() {
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
   * Method under test: {@link ParticularIntegerValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat() {
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
   * Method under test: {@link ParticularIntegerValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble() {
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
   * Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).generalize(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize2() {
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
   * Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).generalize(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult = (new ParticularIntegerValue(42))
        .generalize(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualGeneralizeResult = particularIntegerValue
        .generalize((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(other, particularIntegerValue.generalize((IntegerValue) other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualGeneralizeResult = particularIntegerValue.generalize((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.generalize(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualGeneralizeResult = particularIntegerValue.generalize(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult = (new ParticularIntegerValue(42)).generalize((ParticularIntegerValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  public void testGeneralize11() {
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
   * {@link ParticularIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  public void testGeneralize12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.generalize(other));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  public void testGeneralize13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act
    IntegerValue actualGeneralizeResult = particularIntegerValue.generalize(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd() {
    // Arrange and Act
    IntegerValue actualAddResult = (new ParticularIntegerValue(42)).add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(0)).add(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd3() {
    // Arrange and Act
    IntegerValue actualAddResult = (new ParticularIntegerValue(Value.NEVER))
        .add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd4() {
    // Arrange and Act
    IntegerValue actualAddResult = (new ParticularIntegerValue(Integer.MIN_VALUE))
        .add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd5() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).add(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAddResult = particularIntegerValue.add(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualAddResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAddResult = particularIntegerValue
        .add((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd8() {
    // Arrange and Act
    IntegerValue actualAddResult = (new ParticularIntegerValue(42)).add(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  public void testAdd9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAddResult = particularIntegerValue.add(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof ParticularIntegerValue);
    assertEquals(84, actualAddResult.value());
    assertFalse(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd10() {
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
   * Method under test: {@link ParticularIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.add(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualAddResult = particularIntegerValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualAddResult = particularIntegerValue.add(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  public void testAdd14() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MAX_VALUE);

    // Act
    IntegerValue actualAddResult = particularIntegerValue.add(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract() {
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
   * Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract2() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new ParticularIntegerValue(Integer.MIN_VALUE))
        .subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).subtract(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract4() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult = particularIntegerValue.subtract(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualSubtractResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult = particularIntegerValue
        .subtract((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract6() {
    // Arrange and Act
    IntegerValue actualSubtractResult = (new ParticularIntegerValue(42)).subtract(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  public void testSubtract7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult = particularIntegerValue.subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractResult.value());
    assertFalse(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  public void testSubtract8() {
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
   * Method under test: {@link ParticularIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  public void testSubtract9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractResult = particularIntegerValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  public void testSubtract10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult = particularIntegerValue.subtract(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom() {
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
   * Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom2() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new ParticularIntegerValue(-128))
        .subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom3() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(0)).subtractFrom(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom4() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new ParticularIntegerValue(Integer.MIN_VALUE))
        .subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom5() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).subtractFrom(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom6() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new ParticularIntegerValue(42))
        .subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularIntegerValue);
    assertEquals(-42, actualSubtractFromResult.value());
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult = particularIntegerValue
        .subtractFrom((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom8() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult = (new ParticularIntegerValue(42))
        .subtractFrom(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  public void testSubtractFrom9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult = particularIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractFromResult.value());
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom10() {
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
   * {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(-41);

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
   * {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.subtractFrom(other));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractFromResult = particularIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  public void testSubtractFrom14() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult = particularIntegerValue
        .subtractFrom(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply() {
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
   * Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply2() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(1)).multiply(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply3() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = (new ParticularIntegerValue(-5376))
        .multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply4() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply5() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = (new ParticularIntegerValue(Integer.MIN_VALUE))
        .multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply6() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).multiply(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply7() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualMultiplyResult = (new ParticularIntegerValue(42)).multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularIntegerValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualMultiplyResult = particularIntegerValue
        .multiply((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply9() {
    // Arrange and Act
    IntegerValue actualMultiplyResult = (new ParticularIntegerValue(Integer.MIN_VALUE))
        .multiply(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  public void testMultiply10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualMultiplyResult = particularIntegerValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularIntegerValue);
    assertEquals(1764, actualMultiplyResult.value());
    assertFalse(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  public void testMultiply11() {
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
   * Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  public void testMultiply12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.multiply(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  public void testMultiply13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.multiply(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  public void testMultiply14() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualMultiplyResult = particularIntegerValue.multiply(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  public void testMultiply15() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualMultiplyResult = particularIntegerValue.multiply(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  public void testMultiply16() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualMultiplyResult = particularIntegerValue.multiply(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult = (new ParticularIntegerValue(42))
        .divide(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide2() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).divide(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide3() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue.divide(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualDivideResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide4() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue
        .divide((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide5() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue.divide((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide6() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue.divide((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  public void testDivide7() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue.divide(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularIntegerValue);
    assertEquals(1, actualDivideResult.value());
    assertFalse(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  public void testDivide8() throws ArithmeticException {
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
   * Method under test: {@link ParticularIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  public void testDivide9() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue.divide(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  public void testDivide10() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue.divide(new RangeIntegerValue(0, 3));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  public void testDivide11() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue
        .divide(new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isSpecific());
    assertTrue(actualDivideResult.isParticular());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf() throws ArithmeticException {
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
   * Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf2() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(1)).divideOf(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf3() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult = (new ParticularIntegerValue(-3))
        .divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf4() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult = (new ParticularIntegerValue(0))
        .divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf5() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).divideOf(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf6() throws ArithmeticException {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualDivideOfResult = (new ParticularIntegerValue(42)).divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf7() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideOfResult = particularIntegerValue
        .divideOf((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  public void testDivideOf8() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideOfResult = particularIntegerValue.divideOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularIntegerValue);
    assertEquals(1, actualDivideOfResult.value());
    assertFalse(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  public void testDivideOf9() throws ArithmeticException {
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
   * Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  public void testDivideOf10() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.divideOf(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  public void testDivideOf11() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act
    IntegerValue actualDivideOfResult = particularIntegerValue.divideOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  public void testDivideOf12() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualDivideOfResult = particularIntegerValue.divideOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  public void testDivideOf13() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualDivideOfResult = particularIntegerValue.divideOf(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  public void testDivideOf14() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualDivideOfResult = particularIntegerValue.divideOf(new RangeIntegerValue(1, Integer.MIN_VALUE));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult = (new ParticularIntegerValue(42))
        .remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder2() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult = (new ParticularIntegerValue(-128))
        .remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder3() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).remainder(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder4() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult = (new ParticularIntegerValue(42))
        .remainder(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularIntegerValue);
    assertEquals(0, actualRemainderResult.value());
    assertFalse(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder5() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult = particularIntegerValue
        .remainder((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder6() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult = particularIntegerValue.remainder((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder7() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualRemainderResult = particularIntegerValue.remainder((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder8() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.remainder((IntegerValue) new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  public void testRemainder9() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult = particularIntegerValue.remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularIntegerValue);
    assertEquals(0, actualRemainderResult.value());
    assertFalse(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  public void testRemainder10() throws ArithmeticException {
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
   * {@link ParticularIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  public void testRemainder11() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

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
   * {@link ParticularIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  public void testRemainder12() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.remainder(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  public void testRemainder13() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualRemainderResult = particularIntegerValue.remainder(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  public void testRemainder14() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult = particularIntegerValue.remainder(new RangeIntegerValue(0, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult = (new ParticularIntegerValue(42))
        .remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf2() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult = (new ParticularIntegerValue(-128))
        .remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf3() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult = (new ParticularIntegerValue(42))
        .remainderOf(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf4() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).remainderOf(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf5() throws ArithmeticException {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualRemainderOfResult = (new ParticularIntegerValue(42)).remainderOf(other);

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualRemainderOfResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf6() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderOfResult = particularIntegerValue
        .remainderOf((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf7() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.remainderOf((IntegerValue) other));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  public void testRemainderOf8() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderOfResult = particularIntegerValue.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularIntegerValue);
    assertEquals(0, actualRemainderOfResult.value());
    assertFalse(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  public void testRemainderOf9() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.remainderOf(other));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  public void testRemainderOf10() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualRemainderOfResult = particularIntegerValue.remainderOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isSpecific());
    assertTrue(actualRemainderOfResult.isParticular());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  public void testRemainderOf11() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act
    IntegerValue actualRemainderOfResult = particularIntegerValue.remainderOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  public void testRemainderOf12() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderOfResult = particularIntegerValue
        .remainderOf(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult = (new ParticularIntegerValue(42))
        .shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft3() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult = (new ParticularIntegerValue(42))
        .shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft4() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftLeft(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult = particularIntegerValue.shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualShiftLeftResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult = particularIntegerValue
        .shiftLeft((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult = particularIntegerValue.shiftLeft((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualShiftLeftResult = particularIntegerValue.shiftLeft((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualShiftLeftResult = particularIntegerValue.shiftLeft((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeft10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult = particularIntegerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularIntegerValue);
    assertEquals(43008, actualShiftLeftResult.value());
    assertFalse(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeft11() {
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
   * {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeft12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.shiftLeft(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeft13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

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
   * {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeft14() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualShiftLeftResult = particularIntegerValue.shiftLeft(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeft15() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult = particularIntegerValue.shiftLeft(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeft16() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult = particularIntegerValue.shiftLeft(new RangeIntegerValue(1, 42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult = (new ParticularIntegerValue(42))
        .shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf2() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult = (new ParticularIntegerValue(10))
        .shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf3() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(-131072)).shiftLeftOf(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf4() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult = (new ParticularIntegerValue(Value.NEVER))
        .shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf5() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftLeftOf(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf6() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualShiftLeftOfResult = (new ParticularIntegerValue(42)).shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult = particularIntegerValue
        .shiftLeftOf((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  public void testShiftLeftOf8() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftLeftOf(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  public void testShiftLeftOf9() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftLeftOfResult = (new ParticularIntegerValue(42)).shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularLongValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  public void testShiftLeftOf10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftLeftOfResult = particularIntegerValue
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
   * {@link ParticularIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftLeftOf11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult = particularIntegerValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularIntegerValue);
    assertEquals(43008, actualShiftLeftOfResult.value());
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  public void testShiftLeftOf12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftLeftOfResult = particularIntegerValue.shiftLeftOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularLongValue);
    assertEquals(184717953466368L, actualShiftLeftOfResult.value());
    assertTrue(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeftOf13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult = particularIntegerValue.shiftLeftOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeftOf14() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(10);

    // Act
    IntegerValue actualShiftLeftOfResult = particularIntegerValue.shiftLeftOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeftOf15() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1024);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.shiftLeftOf(other));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftLeftOf16() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult = particularIntegerValue.shiftLeftOf(new RangeIntegerValue(0, 3));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight() {
    // Arrange and Act
    IntegerValue actualShiftRightResult = (new ParticularIntegerValue(42))
        .shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight3() {
    // Arrange and Act
    IntegerValue actualShiftRightResult = (new ParticularIntegerValue(42))
        .shiftRight(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight4() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftRight(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult = particularIntegerValue.shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualShiftRightResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult = particularIntegerValue
        .shiftRight((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult = particularIntegerValue.shiftRight((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualShiftRightResult = particularIntegerValue.shiftRight((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isParticular());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRight9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult = particularIntegerValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof ParticularIntegerValue);
    assertEquals(0, actualShiftRightResult.value());
    assertFalse(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  public void testShiftRight10() {
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
   * {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  public void testShiftRight11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.shiftRight(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  public void testShiftRight12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualShiftRightResult = particularIntegerValue.shiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isParticular());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  public void testShiftRight13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult = particularIntegerValue
        .shiftRight(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  public void testShiftRight14() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult = particularIntegerValue.shiftRight(new RangeIntegerValue(1, 42));

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf() {
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
   * Method under test: {@link ParticularIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf2() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(0)).shiftRightOf(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftRightOf(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf4() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualShiftRightOfResult = (new ParticularIntegerValue(42)).shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightOfResult = particularIntegerValue
        .shiftRightOf((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  public void testShiftRightOf6() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftRightOf(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  public void testShiftRightOf7() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftRightOfResult = (new ParticularIntegerValue(42)).shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  public void testShiftRightOf8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftRightOfResult = particularIntegerValue
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
   * {@link ParticularIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testShiftRightOf9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightOfResult = particularIntegerValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(0, actualShiftRightOfResult.value());
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testShiftRightOf10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftRightOfResult = particularIntegerValue.shiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(0L, actualShiftRightOfResult.value());
    assertTrue(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftRightOf11() {
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
   * {@link ParticularIntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testShiftRightOf12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.shiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult = (new ParticularIntegerValue(42))
        .unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue,
        particularIntegerValue.unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight3() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult = (new ParticularIntegerValue(42))
        .unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight4() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).unsignedShiftRight(other));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult = particularIntegerValue
        .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualUnsignedShiftRightResult);
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult = particularIntegerValue
        .unsignedShiftRight((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult = particularIntegerValue
        .unsignedShiftRight((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult = particularIntegerValue
        .unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof ParticularIntegerValue);
    assertEquals(0, actualUnsignedShiftRightResult.value());
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight9() {
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
   * {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.unsignedShiftRight(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult = particularIntegerValue
        .unsignedShiftRight(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult = particularIntegerValue
        .unsignedShiftRight(new RangeIntegerValue(1, 42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf() {
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
   * {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf2() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(-128)).unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf3() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult = (new ParticularIntegerValue(42))
        .unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf4() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf5() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = (new ParticularIntegerValue(42)).unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = particularIntegerValue
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
   * {@link ParticularIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf7() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf8() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualUnsignedShiftRightOfResult = (new ParticularIntegerValue(42)).unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualUnsignedShiftRightOfResult = particularIntegerValue
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
   * {@link ParticularIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = particularIntegerValue
        .unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(0, actualUnsignedShiftRightOfResult.value());
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualUnsignedShiftRightOfResult = particularIntegerValue
        .unsignedShiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(0L, actualUnsignedShiftRightOfResult.value());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf12() {
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
   * {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf13() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.unsignedShiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf14() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = particularIntegerValue
        .unsignedShiftRightOf(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf15() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = particularIntegerValue
        .unsignedShiftRightOf(new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isParticular());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd() {
    // Arrange and Act
    IntegerValue actualAndResult = (new ParticularIntegerValue(42)).and(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd2() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(Value.NEVER)).and(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd3() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.and(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd4() {
    // Arrange and Act
    IntegerValue actualAndResult = (new ParticularIntegerValue(Integer.MIN_VALUE))
        .and(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd5() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).and(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd6() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualAndResult = (new ParticularIntegerValue(42)).and(other);

    // Assert
    assertTrue(actualAndResult instanceof ParticularIntegerValue);
    assertEquals(other, actualAndResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAndResult = particularIntegerValue
        .and((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  public void testAnd8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAndResult = particularIntegerValue.and(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualAndResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#and(RangeIntegerValue)}
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
   * Method under test: {@link ParticularIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  public void testAnd10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.and(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  public void testAnd11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.and(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  public void testAnd12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualAndResult = particularIntegerValue.and(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr() {
    // Arrange and Act
    IntegerValue actualOrResult = (new ParticularIntegerValue(42)).or(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.or(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr3() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(0)).or(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr4() {
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
   * Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr5() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).or(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult = particularIntegerValue.or(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualOrResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualOrResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult = particularIntegerValue
        .or((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  public void testOr8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult = particularIntegerValue.or(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualOrResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualOrResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  public void testOr9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult = particularIntegerValue.or(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  public void testOr10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.or(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  public void testOr11() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.or(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  public void testOr12() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualOrResult = particularIntegerValue.or(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualOrResult instanceof RangeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor() {
    // Arrange and Act
    IntegerValue actualXorResult = (new ParticularIntegerValue(42)).xor(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor2() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(0)).xor(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor3() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).xor(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor4() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult = particularIntegerValue.xor(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualXorResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualXorResult);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult = particularIntegerValue
        .xor((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  public void testXor6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult = particularIntegerValue.xor(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualXorResult instanceof ParticularIntegerValue);
    assertEquals(0, actualXorResult.value());
    assertFalse(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  public void testXor7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult = particularIntegerValue.xor(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularIntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  public void testXor8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.xor(other));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  public void testEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new ParticularIntegerValue(42)).equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, (new ParticularIntegerValue(-128)).equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(Value.NEVER,
        (new ParticularIntegerValue(Integer.MIN_VALUE)).equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, (new ParticularIntegerValue(42)).equal(BasicValueFactory.INTEGER_VALUE));
    assertEquals(Value.NEVER, (new ParticularIntegerValue(42)).equal(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  public void testEqual2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(0,
        particularIntegerValue.equal((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(1, particularIntegerValue.equal((IntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.equal((IntegerValue) new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  public void testEqual5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(1, particularIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  public void testEqual6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(0, particularIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  public void testEqual10() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(1, particularIntegerValue.equal(new RangeIntegerValue(1, 1)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  public void testLessThan() {
    // Arrange, Act and Assert
    assertEquals(0, (new ParticularIntegerValue(42)).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(Value.NEVER,
        (new ParticularIntegerValue(Float.MAX_EXPONENT)).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(1,
        (new ParticularIntegerValue(Integer.MIN_VALUE)).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, (new ParticularIntegerValue(42)).lessThan(BasicValueFactory.INTEGER_VALUE));
    assertEquals(Value.NEVER, (new ParticularIntegerValue(42)).lessThan(ParticularValueFactory.INTEGER_VALUE_0));
    assertEquals(1, (new ParticularIntegerValue(Integer.MIN_VALUE)).lessThan(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  public void testLessThan2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(0,
        particularIntegerValue.lessThan((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  public void testLessThan3() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  public void testLessThan4() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act and Assert
    assertEquals(1, particularIntegerValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  public void testLessThan5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  public void testLessThan6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(0, particularIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  public void testLessThan7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertEquals(1, particularIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  public void testLessThanOrEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new ParticularIntegerValue(42)).lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(1, (new ParticularIntegerValue(-128)).lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    assertEquals(0, (new ParticularIntegerValue(42)).lessThanOrEqual(BasicValueFactory.INTEGER_VALUE));
    assertEquals(Value.NEVER, (new ParticularIntegerValue(42)).lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  public void testLessThanOrEqual2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(0,
        particularIntegerValue
            .lessThanOrEqual((IntegerValue) new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  public void testLessThanOrEqual3() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(1, particularIntegerValue.lessThanOrEqual((IntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  public void testLessThanOrEqual4() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThanOrEqual((IntegerValue) new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual5() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(1, particularIntegerValue.lessThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual6() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThanOrEqual(new ParticularIntegerValue(1)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual7() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual8() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(3);

    // Act and Assert
    assertEquals(0, particularIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Method under test:
   * {@link ParticularIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  public void testLessThanOrEqual9() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(1, particularIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParticularIntegerValue#equals(Object)}
   *   <li>{@link ParticularIntegerValue#hashCode()}
   * </ul>
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
   * Methods under test:
   * <ul>
   *   <li>{@link ParticularIntegerValue#equals(Object)}
   *   <li>{@link ParticularIntegerValue#hashCode()}
   * </ul>
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
   * Method under test: {@link ParticularIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertNotEquals(particularIntegerValue, new ParticularIntegerValue(42));
  }

  /**
   * Method under test: {@link ParticularIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularIntegerValue(42), null);
  }

  /**
   * Method under test: {@link ParticularIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularIntegerValue(42), "Different type to ParticularIntegerValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParticularIntegerValue#ParticularIntegerValue(int)}
   *   <li>{@link ParticularIntegerValue#toString()}
   *   <li>{@link ParticularIntegerValue#isParticular()}
   *   <li>{@link ParticularIntegerValue#value()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ParticularIntegerValue actualParticularIntegerValue = new ParticularIntegerValue(42);
    String actualToStringResult = actualParticularIntegerValue.toString();
    boolean actualIsParticularResult = actualParticularIntegerValue.isParticular();

    // Assert
    assertEquals("42", actualToStringResult);
    assertEquals(42, actualParticularIntegerValue.value());
    assertTrue(actualIsParticularResult);
  }
}
