package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RangeIntegerValueDiffblueTest {
  /**
   * Test {@link RangeIntegerValue#RangeIntegerValue(int, int)}.
   *
   * <p>Method under test: {@link RangeIntegerValue#RangeIntegerValue(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RangeIntegerValue.<init>(int, int)"})
  public void testNewRangeIntegerValue() {
    // Arrange and Act
    RangeIntegerValue actualRangeIntegerValue = new RangeIntegerValue(1, 3);

    // Assert
    assertFalse(actualRangeIntegerValue.isCategory2());
    assertFalse(actualRangeIntegerValue.isParticular());
    assertFalse(actualRangeIntegerValue.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#value()}.
   *
   * <p>Method under test: {@link RangeIntegerValue#value()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.value()"})
  public void testValue() {
    // Arrange, Act and Assert
    assertEquals(1, (new RangeIntegerValue(1, 3)).value());
  }

  /**
   * Test {@link RangeIntegerValue#negate()}.
   *
   * <ul>
   *   <li>Then return not Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.negate()"})
  public void testNegate_thenReturnNotParticular() {
    // Arrange and Act
    IntegerValue actualNegateResult = (new RangeIntegerValue(1, 3)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof RangeIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#negate()}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.negate()"})
  public void testNegate_thenReturnParticular() {
    // Arrange and Act
    IntegerValue actualNegateResult = (new RangeIntegerValue(Integer.MIN_VALUE, 3)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof RangeIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isSpecific());
    assertTrue(actualNegateResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#convertToByte()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@link
   *       Integer#MIN_VALUE} and max is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToByte()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToByte()"})
  public void testConvertToByte_givenRangeIntegerValueWithMinIsMin_valueAndMaxIsThree() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3)).convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToByteResult.isCategory2());
    assertFalse(actualConvertToByteResult.isParticular());
    assertFalse(actualConvertToByteResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToByte()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@code 32767}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToByte()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToByte()"})
  public void testConvertToByte_givenRangeIntegerValueWithMinIsOneAndMaxIs32767() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult = (new RangeIntegerValue(1, 32767)).convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToByteResult.isCategory2());
    assertFalse(actualConvertToByteResult.isParticular());
    assertFalse(actualConvertToByteResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToByte()}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToByte()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToByte()"})
  public void testConvertToByte_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.convertToByte());
  }

  /**
   * Test {@link RangeIntegerValue#convertToCharacter()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@link
   *       Integer#MIN_VALUE} and max is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToCharacter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToCharacter()"})
  public void testConvertToCharacter_givenRangeIntegerValueWithMinIsMin_valueAndMaxIsThree() {
    // Arrange and Act
    IntegerValue actualConvertToCharacterResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3)).convertToCharacter();

    // Assert
    assertTrue(actualConvertToCharacterResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToCharacterResult.isCategory2());
    assertFalse(actualConvertToCharacterResult.isParticular());
    assertFalse(actualConvertToCharacterResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToCharacter()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToCharacter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToCharacter()"})
  public void testConvertToCharacter_givenRangeIntegerValueWithMinIsOneAndMaxIsMax_value() {
    // Arrange and Act
    IntegerValue actualConvertToCharacterResult =
        (new RangeIntegerValue(1, Integer.MAX_VALUE)).convertToCharacter();

    // Assert
    assertTrue(actualConvertToCharacterResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToCharacterResult.isCategory2());
    assertFalse(actualConvertToCharacterResult.isParticular());
    assertFalse(actualConvertToCharacterResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToCharacter()}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToCharacter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToCharacter()"})
  public void testConvertToCharacter_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.convertToCharacter());
  }

  /**
   * Test {@link RangeIntegerValue#convertToShort()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@link
   *       Integer#MIN_VALUE} and max is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToShort()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToShort()"})
  public void testConvertToShort_givenRangeIntegerValueWithMinIsMin_valueAndMaxIsThree() {
    // Arrange and Act
    IntegerValue actualConvertToShortResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3)).convertToShort();

    // Assert
    assertTrue(actualConvertToShortResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToShortResult.isCategory2());
    assertFalse(actualConvertToShortResult.isParticular());
    assertFalse(actualConvertToShortResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToShort()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@code 65535}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToShort()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToShort()"})
  public void testConvertToShort_givenRangeIntegerValueWithMinIsOneAndMaxIs65535() {
    // Arrange and Act
    IntegerValue actualConvertToShortResult = (new RangeIntegerValue(1, 65535)).convertToShort();

    // Assert
    assertTrue(actualConvertToShortResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToShortResult.isCategory2());
    assertFalse(actualConvertToShortResult.isParticular());
    assertFalse(actualConvertToShortResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToShort()}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToShort()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToShort()"})
  public void testConvertToShort_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.convertToShort());
  }

  /**
   * Test {@link RangeIntegerValue#convertToLong()}.
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToLong()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.convertToLong()"})
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
   * Test {@link RangeIntegerValue#convertToFloat()}.
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue RangeIntegerValue.convertToFloat()"})
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
   * Test {@link RangeIntegerValue#convertToDouble()}.
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue RangeIntegerValue.convertToDouble()"})
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
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  public void testGeneralizeWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  public void testGeneralizeWithIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(
        rangeIntegerValue, rangeIntegerValue.generalize(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  public void testGeneralizeWithIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue =
        new RangeIntegerValue(Integer.MIN_VALUE, Float.MAX_EXPONENT);

    // Act and Assert
    assertSame(
        rangeIntegerValue, rangeIntegerValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  public void testGeneralizeWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).generalize(other));
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  public void testGeneralizeWithIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult =
        rangeIntegerValue.generalize(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  public void testGeneralizeWithIntegerValue_whenInteger_value_0_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        (new RangeIntegerValue(1, 3)).generalize(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_4}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  public void testGeneralizeWithIntegerValue_whenInteger_value_4_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        (new RangeIntegerValue(1, 3)).generalize(ParticularValueFactory.INTEGER_VALUE_4);

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  public void testGeneralizeWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).generalize(other));
  }

  /**
   * Test {@link RangeIntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(ParticularIntegerValue)"})
  public void testGeneralizeWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.generalize(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link RangeIntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(ParticularIntegerValue)"})
  public void testGeneralizeWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult =
        rangeIntegerValue.generalize(new ParticularIntegerValue(0));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(ParticularIntegerValue)"})
  public void testGeneralizeWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult =
        rangeIntegerValue.generalize(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(RangeIntegerValue)"})
  public void testGeneralizeWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.generalize(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link RangeIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(RangeIntegerValue)"})
  public void testGeneralizeWithRangeIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, rangeIntegerValue.generalize(other));
  }

  /**
   * Test {@link RangeIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(RangeIntegerValue)"})
  public void testGeneralizeWithRangeIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 1);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, rangeIntegerValue.generalize(other));
  }

  /**
   * Test {@link RangeIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(RangeIntegerValue)"})
  public void testGeneralizeWithRangeIntegerValue4() {
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
   * Test {@link RangeIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(RangeIntegerValue)"})
  public void testGeneralizeWithRangeIntegerValue_whenRangeIntegerValueWithMinIsOneAndMaxIsOne() {
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
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@link
   *       Integer#MIN_VALUE} and max is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  public void testAddWithIntegerValue_givenRangeIntegerValueWithMinIsMin_valueAndMaxIsThree() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@link
   *       Integer#MIN_VALUE} and max is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  public void testAddWithIntegerValue_givenRangeIntegerValueWithMinIsMin_valueAndMaxIsThree2() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3)).add(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  public void testAddWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAddResult =
        rangeIntegerValue.add(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  public void testAddWithIntegerValue_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.add(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  public void testAddWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new RangeIntegerValue(1, 3)).add(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  public void testAddWithIntegerValue_whenInteger_value_byte_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new RangeIntegerValue(1, 3)).add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeValueFactory#INTEGER_VALUE_INT}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  public void testAddWithIntegerValue_whenInteger_value_int_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new RangeIntegerValue(1, 3)).add(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  public void testAddWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new RangeIntegerValue(1, 3)).add(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  public void testAddWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).add(other));
  }

  /**
   * Test {@link RangeIntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(ParticularIntegerValue)"})
  public void testAddWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.add(new ParticularIntegerValue(0)));
  }

  /**
   * Test {@link RangeIntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(ParticularIntegerValue)"})
  public void testAddWithParticularIntegerValue_thenReturnRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(ParticularIntegerValue)"})
  public void testAddWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
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
   * Test {@link RangeIntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(ParticularIntegerValue)"})
  public void testAddWithParticularIntegerValue_whenParticularIntegerValueWithValueIsFortyTwo() {
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
   * Test {@link RangeIntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(ParticularIntegerValue)"})
  public void testAddWithParticularIntegerValue_whenParticularIntegerValueWithValueIsMax_value() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualAddResult =
        rangeIntegerValue.add(new ParticularIntegerValue(Integer.MAX_VALUE));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(RangeIntegerValue)"})
  public void testAddWithRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(RangeIntegerValue)"})
  public void testAddWithRangeIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsMax_value() {
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
   * Test {@link RangeIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(RangeIntegerValue)"})
  public void testAddWithRangeIntegerValue_thenReturnRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  public void testSubtractWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  public void testSubtractWithIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(
        rangeIntegerValue, rangeIntegerValue.subtract(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  public void testSubtractWithIntegerValue3() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .subtract(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  public void testSubtractWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult =
        rangeIntegerValue.subtract(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  public void testSubtractWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new RangeIntegerValue(1, 3)).subtract(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  public void testSubtractWithIntegerValue_whenInteger_value_byte_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new RangeIntegerValue(1, 3)).subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeValueFactory#INTEGER_VALUE_INT}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  public void testSubtractWithIntegerValue_whenInteger_value_int_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new RangeIntegerValue(1, 3)).subtract(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  public void testSubtractWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new RangeIntegerValue(1, 3)).subtract(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  public void testSubtractWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).subtract(other));
  }

  /**
   * Test {@link RangeIntegerValue#subtract(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(ParticularIntegerValue)"})
  public void testSubtractWithParticularIntegerValue() {
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
   * Test {@link RangeIntegerValue#subtract(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(ParticularIntegerValue)"})
  public void testSubtractWithParticularIntegerValue2() {
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
   * Test {@link RangeIntegerValue#subtract(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(ParticularIntegerValue)"})
  public void testSubtractWithParticularIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.subtract(new ParticularIntegerValue(0)));
  }

  /**
   * Test {@link RangeIntegerValue#subtract(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(ParticularIntegerValue)"})
  public void testSubtractWithParticularIntegerValue4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult =
        rangeIntegerValue.subtract(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(ParticularIntegerValue)"})
  public void testSubtractWithParticularIntegerValue_thenReturnRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(RangeIntegerValue)"})
  public void testSubtractWithRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(RangeIntegerValue)"})
  public void testSubtractWithRangeIntegerValue2() {
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
   * Test {@link RangeIntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(RangeIntegerValue)"})
  public void testSubtractWithRangeIntegerValue_thenReturnRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  public void testSubtractFromWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  public void testSubtractFromWithIntegerValue2() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  public void testSubtractFromWithIntegerValue3() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new RangeIntegerValue(1, Integer.MIN_VALUE))
            .subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  public void testSubtractFromWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  public void testSubtractFromWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new RangeIntegerValue(1, 3)).subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  public void testSubtractFromWithIntegerValue_whenInteger_value_0_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new RangeIntegerValue(1, 3)).subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeValueFactory#INTEGER_VALUE_INT}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  public void testSubtractFromWithIntegerValue_whenInteger_value_int() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new RangeIntegerValue(1, 3)).subtractFrom(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  public void testSubtractFromWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).subtractFrom(other));
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(ParticularIntegerValue)"})
  public void testSubtractFromWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(ParticularIntegerValue)"})
  public void testSubtractFromWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(ParticularIntegerValue)"})
  public void testSubtractFromWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(RangeIntegerValue)"})
  public void testSubtractFromWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(RangeIntegerValue)"})
  public void testSubtractFromWithRangeIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(RangeIntegerValue)"})
  public void testSubtractFromWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  public void testMultiplyWithIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(
        rangeIntegerValue, rangeIntegerValue.multiply(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  public void testMultiplyWithIntegerValue2() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .multiply(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  public void testMultiplyWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsMin_value() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        (new RangeIntegerValue(1, Integer.MIN_VALUE))
            .multiply(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  public void testMultiplyWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult =
        rangeIntegerValue.multiply(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  public void testMultiplyWithIntegerValue_whenInteger_value_0_thenReturnInteger_value_0() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).multiply(other));
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_2}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  public void testMultiplyWithIntegerValue_whenInteger_value_2_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        (new RangeIntegerValue(1, 3)).multiply(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  public void testMultiplyWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        (new RangeIntegerValue(1, 3)).multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  public void testMultiplyWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        (new RangeIntegerValue(1, 3)).multiply(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  public void testMultiplyWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).multiply(other));
  }

  /**
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  public void testMultiplyWithParticularIntegerValue() {
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
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  public void testMultiplyWithParticularIntegerValue2() {
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
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  public void testMultiplyWithParticularIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.multiply(new ParticularIntegerValue(1)));
  }

  /**
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  public void testMultiplyWithParticularIntegerValue4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.multiply(other));
  }

  /**
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  public void testMultiplyWithParticularIntegerValue5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult =
        rangeIntegerValue.multiply(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  public void testMultiplyWithParticularIntegerValue_thenReturnRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(RangeIntegerValue)"})
  public void testMultiplyWithRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@link
   *       Integer#MIN_VALUE} and max is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  public void testDivideWithIntegerValue_givenRangeIntegerValueWithMinIsMin_valueAndMaxIsThree()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .divide(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  public void testDivideWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsMin_value()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        (new RangeIntegerValue(1, Integer.MIN_VALUE))
            .divide(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  public void testDivideWithIntegerValue_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult =
        rangeIntegerValue.divide(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  public void testDivideWithIntegerValue_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.divide(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  public void testDivideWithIntegerValue_whenInteger_value_0_thenReturnUnknownIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        (new RangeIntegerValue(1, 3)).divide(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_2}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  public void testDivideWithIntegerValue_whenInteger_value_2_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        (new RangeIntegerValue(1, 3)).divide(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  public void testDivideWithIntegerValue_whenInteger_value_byte_thenReturnUnknownIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        (new RangeIntegerValue(1, 3)).divide(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  public void testDivideWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        (new RangeIntegerValue(1, 3)).divide(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  public void testDivideWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).divide(other));
  }

  /**
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  public void testDivideWithParticularIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.divide(new ParticularIntegerValue(1)));
  }

  /**
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  public void testDivideWithParticularIntegerValue2() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualDivideResult =
        rangeIntegerValue.divide(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  public void testDivideWithParticularIntegerValue3() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualDivideResult =
        rangeIntegerValue.divide(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  public void testDivideWithParticularIntegerValue_thenReturnParticular()
      throws ArithmeticException {
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
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  public void testDivideWithParticularIntegerValue_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult =
        rangeIntegerValue.divide(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  public void testDivideWithParticularIntegerValue_whenParticularIntegerValueWithValueIsZero()
      throws ArithmeticException {
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
   * Test {@link RangeIntegerValue#divide(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(RangeIntegerValue)"})
  public void testDivideWithRangeIntegerValue() throws ArithmeticException {
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
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  public void testDivideOfWithIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE))
            .divideOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isSpecific());
    assertTrue(actualDivideOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is zero and max is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  public void testDivideOfWithIntegerValue_givenRangeIntegerValueWithMinIsZeroAndMaxIsThree()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        (new RangeIntegerValue(0, 3)).divideOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  public void testDivideOfWithIntegerValue_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideOfResult =
        rangeIntegerValue.divideOf(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  public void testDivideOfWithIntegerValue_whenInteger_value_0_thenReturnParticular()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        (new RangeIntegerValue(1, 3)).divideOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isSpecific());
    assertTrue(actualDivideOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  public void testDivideOfWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        (new RangeIntegerValue(1, 3)).divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  public void testDivideOfWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        (new RangeIntegerValue(1, 3)).divideOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  public void testDivideOfWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).divideOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(ParticularIntegerValue)"})
  public void testDivideOfWithParticularIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideOfResult =
        rangeIntegerValue.divideOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(ParticularIntegerValue)"})
  public void testDivideOfWithParticularIntegerValue_thenReturnParticular()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue =
        new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE);

    // Act
    IntegerValue actualDivideOfResult = rangeIntegerValue.divideOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isSpecific());
    assertTrue(actualDivideOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(ParticularIntegerValue)"})
  public void testDivideOfWithParticularIntegerValue_thenReturnRangeIntegerValue()
      throws ArithmeticException {
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
   * Test {@link RangeIntegerValue#divideOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(ParticularIntegerValue)"})
  public void testDivideOfWithParticularIntegerValue_thenReturnUnknownIntegerValue()
      throws ArithmeticException {
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
   * Test {@link RangeIntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(RangeIntegerValue)"})
  public void testDivideOfWithRangeIntegerValue() throws ArithmeticException {
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
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  public void testRemainderWithIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(
        rangeIntegerValue, rangeIntegerValue.remainder(ParticularValueFactory.INTEGER_VALUE_4));
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  public void testRemainderWithIntegerValue2() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .remainder(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  public void testRemainderWithIntegerValue_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderResult =
        rangeIntegerValue.remainder(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  public void testRemainderWithIntegerValue_whenInteger_value_0_thenReturnUnknownIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        (new RangeIntegerValue(1, 3)).remainder(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  public void testRemainderWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        (new RangeIntegerValue(1, 3)).remainder(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isSpecific());
    assertTrue(actualRemainderResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  public void testRemainderWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        (new RangeIntegerValue(1, 3)).remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  public void testRemainderWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).remainder(other));
  }

  /**
   * Test {@link RangeIntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(ParticularIntegerValue)"})
  public void testRemainderWithParticularIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.remainder(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link RangeIntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(ParticularIntegerValue)"})
  public void testRemainderWithParticularIntegerValue2() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualRemainderResult =
        rangeIntegerValue.remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(ParticularIntegerValue)"})
  public void testRemainderWithParticularIntegerValue3() throws ArithmeticException {
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
   * Test {@link RangeIntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(ParticularIntegerValue)"})
  public void testRemainderWithParticularIntegerValue_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    IntegerValue actualRemainderResult =
        rangeIntegerValue.remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(RangeIntegerValue)"})
  public void testRemainderWithRangeIntegerValue() throws ArithmeticException {
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
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is zero and max is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  public void testRemainderOfWithIntegerValue_givenRangeIntegerValueWithMinIsZeroAndMaxIsThree()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        (new RangeIntegerValue(0, 3)).remainderOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  public void testRemainderOfWithIntegerValue_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  public void testRemainderOfWithIntegerValue_whenInteger_value_0_thenReturnInteger_value_0()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).remainderOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  public void testRemainderOfWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        (new RangeIntegerValue(1, 3)).remainderOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_3}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  public void testRemainderOfWithIntegerValue_whenInteger_value_3_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        (new RangeIntegerValue(1, 3)).remainderOf(ParticularValueFactory.INTEGER_VALUE_3);

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  public void testRemainderOfWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        (new RangeIntegerValue(1, 3)).remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  public void testRemainderOfWithIntegerValue_whenInteger_value_m1() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        (new RangeIntegerValue(1, 3)).remainderOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  public void testRemainderOfWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).remainderOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(ParticularIntegerValue)"})
  public void testRemainderOfWithParticularIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(ParticularIntegerValue)"})
  public void testRemainderOfWithParticularIntegerValue2() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(new ParticularIntegerValue(1));

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(ParticularIntegerValue)"})
  public void testRemainderOfWithParticularIntegerValue3() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.remainderOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(ParticularIntegerValue)"})
  public void testRemainderOfWithParticularIntegerValue4() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(ParticularIntegerValue)"})
  public void testRemainderOfWithParticularIntegerValue_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(RangeIntegerValue)"})
  public void testRemainderOfWithRangeIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(
        rangeIntegerValue, rangeIntegerValue.shiftLeft(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue2() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        (new RangeIntegerValue(1, Integer.MIN_VALUE))
            .shiftLeft(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult =
        rangeIntegerValue.shiftLeft(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        (new RangeIntegerValue(1, 3)).shiftLeft(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        (new RangeIntegerValue(1, 3)).shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue_whenInteger_value_m1_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        (new RangeIntegerValue(1, 3)).shiftLeft(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftLeft(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(ParticularIntegerValue)"})
  public void testShiftLeftWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 3);

    // Act
    IntegerValue actualShiftLeftResult =
        rangeIntegerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(ParticularIntegerValue)"})
  public void testShiftLeftWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.shiftLeft(new ParticularIntegerValue(1024)));
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(ParticularIntegerValue)"})
  public void testShiftLeftWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult =
        rangeIntegerValue.shiftLeft(new ParticularIntegerValue(10));

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(ParticularIntegerValue)"})
  public void testShiftLeftWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult =
        rangeIntegerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(RangeIntegerValue)"})
  public void testShiftLeftWithRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  public void testShiftLeftOfWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  public void testShiftLeftOfWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsNever() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        (new RangeIntegerValue(1, Value.NEVER)).shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  public void testShiftLeftOfWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsSize() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        (new RangeIntegerValue(1, Integer.SIZE))
            .shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  public void testShiftLeftOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  public void testShiftLeftOfWithIntegerValue_whenInteger_value_0_thenReturnInteger_value_0() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftLeftOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  public void testShiftLeftOfWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        (new RangeIntegerValue(1, 3)).shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  public void testShiftLeftOfWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        (new RangeIntegerValue(1, 3)).shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  public void testShiftLeftOfWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        (new RangeIntegerValue(1, 3)).shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  public void testShiftLeftOfWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftLeftOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftLeftOf(LongValue)"})
  public void testShiftLeftOfWithLongValue_whenLong_value_0_thenReturnLong_value_0() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftLeftOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_1}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftLeftOf(LongValue)"})
  public void testShiftLeftOfWithLongValue_whenLong_value_1_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftOfResult =
        (new RangeIntegerValue(1, 3)).shiftLeftOf(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
    assertTrue(actualShiftLeftOfResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftLeftOf(LongValue)"})
  public void testShiftLeftOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftLeftOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  public void testShiftLeftOfWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  public void testShiftLeftOfWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  public void testShiftLeftOfWithParticularIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.shiftLeftOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  public void testShiftLeftOfWithParticularIntegerValue4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  public void testShiftLeftOfWithParticularIntegerValue5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  public void testShiftLeftOfWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftLeftOf(ParticularLongValue)"})
  public void testShiftLeftOfWithParticularLongValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularLongValue other = new ParticularLongValue(0L);

    // Act and Assert
    assertSame(other, rangeIntegerValue.shiftLeftOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftLeftOf(ParticularLongValue)"})
  public void testShiftLeftOfWithParticularLongValue_thenReturnUnknownLongValue() {
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
   * Test {@link RangeIntegerValue#shiftLeftOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(RangeIntegerValue)"})
  public void testShiftLeftOfWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(
        rangeIntegerValue, rangeIntegerValue.shiftRight(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightResult =
        rangeIntegerValue.shiftRight(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        (new RangeIntegerValue(1, 3)).shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        (new RangeIntegerValue(1, 3)).shiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftRight(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(ParticularIntegerValue)"})
  public void testShiftRightWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.shiftRight(new ParticularIntegerValue(0)));
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(ParticularIntegerValue)"})
  public void testShiftRightWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightResult =
        rangeIntegerValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(RangeIntegerValue)"})
  public void testShiftRightWithRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  public void testShiftRightOfWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .shiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  public void testShiftRightOfWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsSize() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        (new RangeIntegerValue(1, Integer.SIZE))
            .shiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  public void testShiftRightOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  public void testShiftRightOfWithIntegerValue_whenInteger_value_0_thenReturnInteger_value_0() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  public void testShiftRightOfWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        (new RangeIntegerValue(1, 3)).shiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  public void testShiftRightOfWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        (new RangeIntegerValue(1, 3)).shiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  public void testShiftRightOfWithIntegerValue_whenInteger_value_m1() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        (new RangeIntegerValue(1, 3)).shiftRightOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  public void testShiftRightOfWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftRightOf(LongValue)"})
  public void testShiftRightOfWithLongValue_whenLong_value_0_thenReturnLong_value_0() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_1}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftRightOf(LongValue)"})
  public void testShiftRightOfWithLongValue_whenLong_value_1_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftRightOfResult =
        (new RangeIntegerValue(1, 3)).shiftRightOf(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftRightOf(LongValue)"})
  public void testShiftRightOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).shiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(ParticularIntegerValue)"})
  public void testShiftRightOfWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(ParticularIntegerValue)"})
  public void testShiftRightOfWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(ParticularIntegerValue)"})
  public void testShiftRightOfWithParticularIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.shiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(ParticularIntegerValue)"})
  public void testShiftRightOfWithParticularIntegerValue_thenReturnParticular() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(ParticularIntegerValue)"})
  public void testShiftRightOfWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftRightOf(ParticularLongValue)"})
  public void testShiftRightOfWithParticularLongValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularLongValue other = new ParticularLongValue(0L);

    // Act and Assert
    assertSame(other, rangeIntegerValue.shiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftRightOf(ParticularLongValue)"})
  public void testShiftRightOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    LongValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(RangeIntegerValue)"})
  public void testShiftRightOfWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(
        rangeIntegerValue,
        rangeIntegerValue.unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue2() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue_thenReturnParticular() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE))
            .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        (new RangeIntegerValue(1, 3)).unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        (new RangeIntegerValue(1, 3)).unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).unsignedShiftRight(other));
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  public void testUnsignedShiftRightWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(
        rangeIntegerValue, rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(0)));
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  public void testUnsignedShiftRightWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue =
        new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return not Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  public void testUnsignedShiftRightWithParticularIntegerValue_thenReturnNotParticular() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  public void testUnsignedShiftRightWithParticularIntegerValue_thenReturnParticular() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(RangeIntegerValue)"})
  public void testUnsignedShiftRightWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  public void testUnsignedShiftRightOfWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        (new RangeIntegerValue(Integer.MIN_VALUE, 3))
            .unsignedShiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  public void testUnsignedShiftRightOfWithIntegerValue2() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        (new RangeIntegerValue(1, Integer.SIZE))
            .unsignedShiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  public void testUnsignedShiftRightOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  public void testUnsignedShiftRightOfWithIntegerValue_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).unsignedShiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  public void testUnsignedShiftRightOfWithIntegerValue_thenReturnInteger_value_0() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).unsignedShiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  public void testUnsignedShiftRightOfWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        (new RangeIntegerValue(1, 3)).unsignedShiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  public void testUnsignedShiftRightOfWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        (new RangeIntegerValue(1, 3))
            .unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.unsignedShiftRightOf(LongValue)"})
  public void testUnsignedShiftRightOfWithLongValue_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightOfResult =
        (new RangeIntegerValue(1, 3)).unsignedShiftRightOf(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.unsignedShiftRightOf(LongValue)"})
  public void testUnsignedShiftRightOfWithLongValue_whenLong_value_0_thenReturnLong_value_0() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).unsignedShiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.unsignedShiftRightOf(LongValue)"})
  public void testUnsignedShiftRightOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).unsignedShiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  public void testUnsignedShiftRightOfWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  public void testUnsignedShiftRightOfWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  public void testUnsignedShiftRightOfWithParticularIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.unsignedShiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  public void testUnsignedShiftRightOfWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.unsignedShiftRightOf(ParticularLongValue)"})
  public void testUnsignedShiftRightOfWithParticularLongValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularLongValue other = new ParticularLongValue(0L);

    // Act and Assert
    assertSame(other, rangeIntegerValue.unsignedShiftRightOf(other));
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue RangeIntegerValue.unsignedShiftRightOf(ParticularLongValue)"})
  public void testUnsignedShiftRightOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(RangeIntegerValue)"})
  public void testUnsignedShiftRightOfWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  public void testAndWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult =
        rangeIntegerValue.and(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  public void testAndWithIntegerValue_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.and(ParticularValueFactory.INTEGER_VALUE_M1));
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  public void testAndWithIntegerValue_whenInteger_value_0_thenReturnInteger_value_0() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).and(other));
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  public void testAndWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        (new RangeIntegerValue(1, 3)).and(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  public void testAndWithIntegerValue_whenInteger_value_byte_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        (new RangeIntegerValue(1, 3)).and(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  public void testAndWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).and(other));
  }

  /**
   * Test {@link RangeIntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(ParticularIntegerValue)"})
  public void testAndWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.and(new ParticularIntegerValue(Value.NEVER)));
  }

  /**
   * Test {@link RangeIntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(ParticularIntegerValue)"})
  public void testAndWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(other, rangeIntegerValue.and(other));
  }

  /**
   * Test {@link RangeIntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(ParticularIntegerValue)"})
  public void testAndWithParticularIntegerValue_thenReturnRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(ParticularIntegerValue)"})
  public void testAndWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult =
        rangeIntegerValue.and(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#and(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(RangeIntegerValue)"})
  public void testAndWithRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  public void testOrWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult =
        rangeIntegerValue.or(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  public void testOrWithIntegerValue_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.or(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  public void testOrWithIntegerValue_whenInteger_value_1_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        (new RangeIntegerValue(1, 3)).or(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  public void testOrWithIntegerValue_whenInteger_value_byte_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        (new RangeIntegerValue(1, 3)).or(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  public void testOrWithIntegerValue_whenInteger_value_m1_thenReturnInteger_value_m1() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_M1;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).or(other));
  }

  /**
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  public void testOrWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).or(other));
  }

  /**
   * Test {@link RangeIntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(ParticularIntegerValue)"})
  public void testOrWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(Value.NEVER);

    // Act and Assert
    assertSame(other, rangeIntegerValue.or(other));
  }

  /**
   * Test {@link RangeIntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(ParticularIntegerValue)"})
  public void testOrWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.or(new ParticularIntegerValue(0)));
  }

  /**
   * Test {@link RangeIntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(ParticularIntegerValue)"})
  public void testOrWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult =
        rangeIntegerValue.or(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualOrResult instanceof RangeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(ParticularIntegerValue)"})
  public void testOrWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
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
   * Test {@link RangeIntegerValue#or(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(RangeIntegerValue)"})
  public void testOrWithRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(IntegerValue)"})
  public void testXorWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualXorResult =
        rangeIntegerValue.xor(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(IntegerValue)"})
  public void testXorWithIntegerValue_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.xor(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(IntegerValue)"})
  public void testXorWithIntegerValue_whenInteger_value_1_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualXorResult =
        (new RangeIntegerValue(1, 3)).xor(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(IntegerValue)"})
  public void testXorWithIntegerValue_whenInteger_value_byte_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualXorResult =
        (new RangeIntegerValue(1, 3)).xor(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(IntegerValue)"})
  public void testXorWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new RangeIntegerValue(1, 3)).xor(other));
  }

  /**
   * Test {@link RangeIntegerValue#xor(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(ParticularIntegerValue)"})
  public void testXorWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(rangeIntegerValue, rangeIntegerValue.xor(new ParticularIntegerValue(0)));
  }

  /**
   * Test {@link RangeIntegerValue#xor(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(ParticularIntegerValue)"})
  public void testXorWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
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
   * Test {@link RangeIntegerValue#xor(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(RangeIntegerValue)"})
  public void testXorWithRangeIntegerValue() {
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
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  public void testEqualWithIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(
        0,
        rangeIntegerValue.equal(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  public void testEqualWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsMin_value() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new RangeIntegerValue(1, Integer.MIN_VALUE))
            .equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  public void testEqualWithIntegerValue_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new RangeIntegerValue(1, 1)).equal(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  public void testEqualWithIntegerValue_whenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER, (new RangeIntegerValue(1, 3)).equal(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  public void testEqualWithIntegerValue_whenInteger_value_1_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new RangeIntegerValue(1, 3)).equal(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_4}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  public void testEqualWithIntegerValue_whenInteger_value_4_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER, (new RangeIntegerValue(1, 3)).equal(ParticularValueFactory.INTEGER_VALUE_4));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  public void testEqualWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new RangeIntegerValue(1, 3)).equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  public void testEqualWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new RangeIntegerValue(1, 3)).equal(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link RangeIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(ParticularIntegerValue)"})
  public void testEqualWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(42, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link RangeIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(ParticularIntegerValue)"})
  public void testEqualWithParticularIntegerValue_thenReturnNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link RangeIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(ParticularIntegerValue)"})
  public void testEqualWithParticularIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(42, 42);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link RangeIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(ParticularIntegerValue)"})
  public void testEqualWithParticularIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link RangeIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(ParticularIntegerValue)"})
  public void testEqualWithParticularIntegerValue_whenParticularIntegerValueWithValueIsNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.equal(new ParticularIntegerValue(Value.NEVER)));
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  public void testEqualWithRangeIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 1);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  public void testEqualWithRangeIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 0);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  public void testEqualWithRangeIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.equal(new RangeIntegerValue(3, 3)));
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  public void testEqualWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  public void testEqualWithRangeIntegerValue_thenReturnZero2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  public void testEqualWithRangeIntegerValue_whenRangeIntegerValueWithMinIsOneAndMaxIsZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.equal(new RangeIntegerValue(1, 0)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  public void testLessThanWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new RangeIntegerValue(Float.MAX_EXPONENT, 3))
            .lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  public void testLessThanWithIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(
        0,
        rangeIntegerValue.lessThan(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  public void testLessThanWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsMin_value() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new RangeIntegerValue(1, Integer.MIN_VALUE))
            .lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  public void testLessThanWithIntegerValue_whenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new RangeIntegerValue(1, 3)).lessThan(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_2}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  public void testLessThanWithIntegerValue_whenInteger_value_2_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new RangeIntegerValue(1, 3)).lessThan(ParticularValueFactory.INTEGER_VALUE_2));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_4}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  public void testLessThanWithIntegerValue_whenInteger_value_4_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new RangeIntegerValue(1, 3)).lessThan(ParticularValueFactory.INTEGER_VALUE_4));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  public void testLessThanWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new RangeIntegerValue(1, 3)).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  public void testLessThanWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new RangeIntegerValue(1, 3)).lessThan(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(ParticularIntegerValue)"})
  public void testLessThanWithParticularIntegerValue_thenReturnNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.lessThan(new ParticularIntegerValue(1)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(ParticularIntegerValue)"})
  public void testLessThanWithParticularIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(ParticularIntegerValue)"})
  public void testLessThanWithParticularIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(RangeIntegerValue)"})
  public void testLessThanWithRangeIntegerValue_thenReturnNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(RangeIntegerValue)"})
  public void testLessThanWithRangeIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 0);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(RangeIntegerValue)"})
  public void testLessThanWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  public void testLessThanOrEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new RangeIntegerValue(1, -128))
            .lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  public void testLessThanOrEqualWithIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(
        0,
        rangeIntegerValue.lessThanOrEqual(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  public void testLessThanOrEqualWithIntegerValue_whenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new RangeIntegerValue(1, 3)).lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  public void testLessThanOrEqualWithIntegerValue_whenInteger_value_1_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new RangeIntegerValue(1, 3)).lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_3}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  public void testLessThanOrEqualWithIntegerValue_whenInteger_value_3_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1, (new RangeIntegerValue(1, 3)).lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_3));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  public void testLessThanOrEqualWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new RangeIntegerValue(1, 3)).lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  public void testLessThanOrEqualWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new RangeIntegerValue(1, 3)).lessThanOrEqual(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(ParticularIntegerValue)"})
  public void testLessThanOrEqualWithParticularIntegerValue_thenReturnNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.lessThanOrEqual(new ParticularIntegerValue(0)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(ParticularIntegerValue)"})
  public void testLessThanOrEqualWithParticularIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.lessThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(ParticularIntegerValue)"})
  public void testLessThanOrEqualWithParticularIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.lessThanOrEqual(new ParticularIntegerValue(1)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(RangeIntegerValue)"})
  public void testLessThanOrEqualWithRangeIntegerValue_thenReturnNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(Value.NEVER, rangeIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 0)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(RangeIntegerValue)"})
  public void testLessThanOrEqualWithRangeIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 1);

    // Act and Assert
    assertEquals(1, rangeIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(RangeIntegerValue)"})
  public void testLessThanOrEqualWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(0, rangeIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link RangeIntegerValue#isParticular()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#isParticular()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RangeIntegerValue.isParticular()"})
  public void testIsParticular_givenRangeIntegerValueWithMinIsOneAndMaxIsThree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new RangeIntegerValue(1, 3)).isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#isParticular()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#isParticular()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RangeIntegerValue.isParticular()"})
  public void testIsParticular_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new RangeIntegerValue(3, 3)).isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#equals(Object)}, and {@link RangeIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RangeIntegerValue#equals(Object)}
   *   <li>{@link RangeIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RangeIntegerValue.equals(Object)",
    "int RangeIntegerValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(rangeIntegerValue, rangeIntegerValue);
    int expectedHashCodeResult = rangeIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, rangeIntegerValue.hashCode());
  }

  /**
   * Test {@link RangeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RangeIntegerValue.equals(Object)",
    "int RangeIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertNotEquals(rangeIntegerValue, new RangeIntegerValue(1, 3));
  }

  /**
   * Test {@link RangeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RangeIntegerValue.equals(Object)",
    "int RangeIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RangeIntegerValue(1, 3), null);
  }

  /**
   * Test {@link RangeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean RangeIntegerValue.equals(Object)",
    "int RangeIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RangeIntegerValue(1, 3), "Different type to RangeIntegerValue");
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@code -32768}
   *       and max is {@code 32767}.
   *   <li>Then return {@code s}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  public void testToString_givenRangeIntegerValueWithMinIs32768AndMaxIs32767_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals("s", (new RangeIntegerValue(-32768, 32767)).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@code -32768}
   *       and max is three.
   *   <li>Then return {@code -32768..3}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  public void testToString_givenRangeIntegerValueWithMinIs32768AndMaxIsThree_thenReturn327683() {
    // Arrange, Act and Assert
    assertEquals("-32768..3", (new RangeIntegerValue(-32768, 3)).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       three.
   *   <li>Then return {@code 1..3}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  public void testToString_givenRangeIntegerValueWithMinIsOneAndMaxIsThree_thenReturn13() {
    // Arrange, Act and Assert
    assertEquals("1..3", (new RangeIntegerValue(1, 3)).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is three and max is
   *       three.
   *   <li>Then return {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  public void testToString_givenRangeIntegerValueWithMinIsThreeAndMaxIsThree_thenReturn3() {
    // Arrange, Act and Assert
    assertEquals("3", (new RangeIntegerValue(3, 3)).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is zero and max is
   *       one.
   *   <li>Then return {@code z}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  public void testToString_givenRangeIntegerValueWithMinIsZeroAndMaxIsOne_thenReturnZ() {
    // Arrange, Act and Assert
    assertEquals("z", (new RangeIntegerValue(0, 1)).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is zero and max is
   *       three.
   *   <li>Then return {@code 0..3}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  public void testToString_givenRangeIntegerValueWithMinIsZeroAndMaxIsThree_thenReturn03() {
    // Arrange, Act and Assert
    assertEquals("0..3", (new RangeIntegerValue(0, 3)).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code -128..3}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  public void testToString_thenReturn1283() {
    // Arrange, Act and Assert
    assertEquals("-128..3", (new RangeIntegerValue(-128, 3)).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code -2147483648..3}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  public void testToString_thenReturn21474836483() {
    // Arrange, Act and Assert
    assertEquals("-2147483648..3", (new RangeIntegerValue(Integer.MIN_VALUE, 3)).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code b}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  public void testToString_thenReturnB() {
    // Arrange, Act and Assert
    assertEquals("b", (new RangeIntegerValue(-128, Float.MAX_EXPONENT)).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code i}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  public void testToString_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals("i", (new RangeIntegerValue(Integer.MIN_VALUE, Integer.MAX_VALUE)).toString());
  }
}
