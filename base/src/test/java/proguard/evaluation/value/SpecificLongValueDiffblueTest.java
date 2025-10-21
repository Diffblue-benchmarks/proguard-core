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

public class SpecificLongValueDiffblueTest {
  /**
   * Test {@link SpecificLongValue#negate()}.
   *
   * <ul>
   *   <li>Then return {@link NegatedLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.negate()"})
  public void testNegate_thenReturnNegatedLongValue() {
    // Arrange and Act
    LongValue actualNegateResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof NegatedLongValue);
    assertFalse(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#negate()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.negate()"})
  public void testNegate_thenReturnParticularLongValue() {
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
   * Test {@link SpecificLongValue#convertToInteger()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#convertToInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificLongValue.convertToInteger()"})
  public void testConvertToInteger_thenReturnConvertedIntegerValue() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ConvertedIntegerValue);
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertFalse(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#convertToInteger()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#convertToInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificLongValue.convertToInteger()"})
  public void testConvertToInteger_thenReturnParticularIntegerValue() {
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
   * Test {@link SpecificLongValue#convertToFloat()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#convertToFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificLongValue.convertToFloat()"})
  public void testConvertToFloat_thenReturnConvertedFloatValue() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ConvertedFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#convertToFloat()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#convertToFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificLongValue.convertToFloat()"})
  public void testConvertToFloat_thenReturnParticularFloatValue() {
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
   * Test {@link SpecificLongValue#convertToDouble()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#convertToDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue SpecificLongValue.convertToDouble()"})
  public void testConvertToDouble_thenReturnConvertedDoubleValue() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ConvertedDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#convertToDouble()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#convertToDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue SpecificLongValue.convertToDouble()"})
  public void testConvertToDouble_thenReturnParticularDoubleValue() {
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
   * Test {@link SpecificLongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#generalize(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.generalize(LongValue)"})
  public void testGeneralizeWithLongValue_givenParticularLongValueWithValueIsFortyTwo() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).generalize(other));
  }

  /**
   * Test {@link SpecificLongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#generalize(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.generalize(LongValue)"})
  public void testGeneralizeWithLongValue_thenReturnConvertedLongValue() {
    // Arrange
    ConvertedLongValue convertedLongValue =
        new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedLongValue other = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualGeneralizeResult = convertedLongValue.generalize((LongValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof ConvertedLongValue);
    assertEquals(convertedLongValue, actualGeneralizeResult);
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link SpecificLongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#generalize(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.generalize(LongValue)"})
  public void testGeneralizeWithLongValue_whenLong_value_0_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualGeneralizeResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link SpecificLongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#generalize(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.generalize(LongValue)"})
  public void testGeneralizeWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).generalize(other));
  }

  /**
   * Test {@link SpecificLongValue#generalize(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#generalize(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.generalize(SpecificLongValue)"})
  public void testGeneralizeWithSpecificLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act and Assert
    assertSame(
        particularLongValue,
        particularLongValue.generalize((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link SpecificLongValue#generalize(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#generalize(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.generalize(SpecificLongValue)"})
  public void testGeneralizeWithSpecificLongValue2() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualGeneralizeResult =
        particularLongValue.generalize(
            new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link SpecificLongValue#generalize(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#generalize(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.generalize(SpecificLongValue)"})
  public void testGeneralizeWithSpecificLongValue_givenParticularLongValueWithValueIsOne() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualGeneralizeResult =
        particularLongValue.generalize((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link SpecificLongValue#generalize(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#generalize(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.generalize(SpecificLongValue)"})
  public void testGeneralizeWithSpecificLongValue_whenNull_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualGeneralizeResult =
        (new ParticularLongValue(42L)).generalize((SpecificLongValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link SpecificLongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#add(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.add(LongValue)"})
  public void testAddWithLongValue_givenParticularLongValueWithValueIsFortyTwo() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).add(other));
  }

  /**
   * Test {@link SpecificLongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#add(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.add(LongValue)"})
  public void testAddWithLongValue_whenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualAddResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .add(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#add(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.add(LongValue)"})
  public void testAddWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).add(other));
  }

  /**
   * Test {@link SpecificLongValue#add(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#add(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.add(SpecificLongValue)"})
  public void testAddWithSpecificLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAddResult =
        particularLongValue.add((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtract(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtract(LongValue)"})
  public void testSubtractWithLongValue_givenParticularLongValueWithValueIsFortyTwo() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).subtract(other));
  }

  /**
   * Test {@link SpecificLongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtract(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtract(LongValue)"})
  public void testSubtractWithLongValue_thenReturnParticularLongValue() {
    // Arrange
    ConvertedLongValue convertedLongValue =
        new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualSubtractResult =
        convertedLongValue.subtract(
            (LongValue) new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtract(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtract(LongValue)"})
  public void testSubtractWithLongValue_whenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualSubtractResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtract(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtract(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtract(LongValue)"})
  public void testSubtractWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtract(other));
  }

  /**
   * Test {@link SpecificLongValue#subtract(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#subtract(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtract(SpecificLongValue)"})
  public void testSubtractWithSpecificLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractResult =
        particularLongValue.subtract(
            new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtract(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtract(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtract(SpecificLongValue)"})
  public void testSubtractWithSpecificLongValue_givenParticularLongValueWithValueIsOne() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualSubtractResult =
        particularLongValue.subtract((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtract(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtract(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtract(SpecificLongValue)"})
  public void testSubtractWithSpecificLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractResult =
        particularLongValue.subtract((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtract(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtract(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtract(SpecificLongValue)"})
  public void testSubtractWithSpecificLongValue_whenNull_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualSubtractResult =
        (new ParticularLongValue(42L)).subtract((SpecificLongValue) null);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtractFrom(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtractFrom(LongValue)"})
  public void testSubtractFromWithLongValue_givenParticularLongValueWithValueIsFortyTwo() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).subtractFrom(other));
  }

  /**
   * Test {@link SpecificLongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtractFrom(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtractFrom(LongValue)"})
  public void testSubtractFromWithLongValue_thenReturnParticularLongValue() {
    // Arrange
    ConvertedLongValue convertedLongValue =
        new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualSubtractFromResult =
        convertedLongValue.subtractFrom(
            (LongValue) new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtractFrom(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtractFrom(LongValue)"})
  public void testSubtractFromWithLongValue_whenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualSubtractFromResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtractFrom(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtractFrom(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtractFrom(LongValue)"})
  public void testSubtractFromWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtractFrom(other));
  }

  /**
   * Test {@link SpecificLongValue#subtractFrom(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtractFrom(SpecificLongValue)"})
  public void testSubtractFromWithSpecificLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractFromResult =
        particularLongValue.subtractFrom(
            new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtractFrom(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtractFrom(SpecificLongValue)"})
  public void testSubtractFromWithSpecificLongValue_givenParticularLongValueWithValueIsOne() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualSubtractFromResult =
        particularLongValue.subtractFrom((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtractFrom(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtractFrom(SpecificLongValue)"})
  public void testSubtractFromWithSpecificLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractFromResult =
        particularLongValue.subtractFrom((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#subtractFrom(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.subtractFrom(SpecificLongValue)"})
  public void testSubtractFromWithSpecificLongValue_whenNull_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualSubtractFromResult =
        (new ParticularLongValue(42L)).subtractFrom((SpecificLongValue) null);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#multiply(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.multiply(LongValue)"})
  public void testMultiplyWithLongValue_givenParticularLongValueWithValueIsFortyTwo() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).multiply(other));
  }

  /**
   * Test {@link SpecificLongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#multiply(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.multiply(LongValue)"})
  public void testMultiplyWithLongValue_whenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualMultiplyResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .multiply(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#multiply(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.multiply(LongValue)"})
  public void testMultiplyWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).multiply(other));
  }

  /**
   * Test {@link SpecificLongValue#multiply(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#multiply(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.multiply(SpecificLongValue)"})
  public void testMultiplyWithSpecificLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualMultiplyResult =
        particularLongValue.multiply((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#divide(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.divide(LongValue)"})
  public void testDivideWithLongValue_givenParticularLongValueWithValueIsFortyTwo()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).divide(other));
  }

  /**
   * Test {@link SpecificLongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#divide(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.divide(LongValue)"})
  public void testDivideWithLongValue_whenLong_value_0_thenReturnCompositeLongValue()
      throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divide(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#divide(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.divide(LongValue)"})
  public void testDivideWithLongValue_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divide(other));
  }

  /**
   * Test {@link SpecificLongValue#divide(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#divide(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.divide(SpecificLongValue)"})
  public void testDivideWithSpecificLongValue() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideResult =
        particularLongValue.divide((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#divideOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.divideOf(LongValue)"})
  public void testDivideOfWithLongValue_givenParticularLongValueWithValueIsFortyTwo()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).divideOf(other));
  }

  /**
   * Test {@link SpecificLongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#divideOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.divideOf(LongValue)"})
  public void testDivideOfWithLongValue_whenLong_value_0_thenReturnCompositeLongValue()
      throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideOfResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divideOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#divideOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.divideOf(LongValue)"})
  public void testDivideOfWithLongValue_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divideOf(other));
  }

  /**
   * Test {@link SpecificLongValue#divideOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#divideOf(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.divideOf(SpecificLongValue)"})
  public void testDivideOfWithSpecificLongValue() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideOfResult =
        particularLongValue.divideOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#remainder(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.remainder(LongValue)"})
  public void testRemainderWithLongValue_givenParticularLongValueWithValueIsFortyTwo()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).remainder(other));
  }

  /**
   * Test {@link SpecificLongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#remainder(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.remainder(LongValue)"})
  public void testRemainderWithLongValue_whenLong_value_0_thenReturnCompositeLongValue()
      throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainder(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#remainder(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.remainder(LongValue)"})
  public void testRemainderWithLongValue_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainder(other));
  }

  /**
   * Test {@link SpecificLongValue#remainder(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#remainder(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.remainder(SpecificLongValue)"})
  public void testRemainderWithSpecificLongValue() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderResult =
        particularLongValue.remainder((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#remainderOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.remainderOf(LongValue)"})
  public void testRemainderOfWithLongValue_givenParticularLongValueWithValueIsFortyTwo()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).remainderOf(other));
  }

  /**
   * Test {@link SpecificLongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#remainderOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.remainderOf(LongValue)"})
  public void testRemainderOfWithLongValue_whenLong_value_0_thenReturnCompositeLongValue()
      throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderOfResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainderOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#remainderOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.remainderOf(LongValue)"})
  public void testRemainderOfWithLongValue_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainderOf(other));
  }

  /**
   * Test {@link SpecificLongValue#remainderOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#remainderOf(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.remainderOf(SpecificLongValue)"})
  public void testRemainderOfWithSpecificLongValue() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderOfResult =
        particularLongValue.remainderOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue_whenInteger_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue_whenInteger_value_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftLeft(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Test {@link SpecificLongValue#shiftLeft(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#shiftLeft(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.shiftLeft(SpecificLongValue)"})
  public void testShiftLeftWithSpecificLongValue() {
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
   * Test {@link SpecificLongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue_whenInteger_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue_whenInteger_value_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Test {@link SpecificLongValue#shiftRight(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#shiftRight(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.shiftRight(SpecificLongValue)"})
  public void testShiftRightWithSpecificLongValue() {
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
   * Test {@link SpecificLongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Test {@link SpecificLongValue#unsignedShiftRight(SpecificLongValue)} with {@code
   * SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#unsignedShiftRight(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.unsignedShiftRight(SpecificLongValue)"})
  public void testUnsignedShiftRightWithSpecificLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualUnsignedShiftRightResult =
        particularLongValue.unsignedShiftRight(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#and(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.and(LongValue)"})
  public void testAndWithLongValue_givenParticularLongValueWithValueIsFortyTwo() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).and(other));
  }

  /**
   * Test {@link SpecificLongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#and(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.and(LongValue)"})
  public void testAndWithLongValue_thenReturnConvertedLongValue() {
    // Arrange
    ConvertedLongValue convertedLongValue =
        new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedLongValue other = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualAndResult = convertedLongValue.and((LongValue) other);

    // Assert
    assertTrue(actualAndResult instanceof ConvertedLongValue);
    assertEquals(convertedLongValue, actualAndResult);
    assertSame(other, actualAndResult);
  }

  /**
   * Test {@link SpecificLongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#and(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.and(LongValue)"})
  public void testAndWithLongValue_whenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualAndResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .and(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#and(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.and(LongValue)"})
  public void testAndWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).and(other));
  }

  /**
   * Test {@link SpecificLongValue#and(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#and(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.and(SpecificLongValue)"})
  public void testAndWithSpecificLongValue_givenParticularLongValueWithValueIsOne() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualAndResult =
        particularLongValue.and((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#and(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue#ParticularLongValue(long)} with value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#and(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.and(SpecificLongValue)"})
  public void testAndWithSpecificLongValue_thenReturnParticularLongValueWithValueIsFortyTwo() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act and Assert
    assertSame(
        particularLongValue,
        particularLongValue.and((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link SpecificLongValue#and(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>When {@link ConvertedLongValue#ConvertedLongValue(Value)} with value is {@link
   *       BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#and(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.and(SpecificLongValue)"})
  public void testAndWithSpecificLongValue_whenConvertedLongValueWithValueIsInteger_value_byte() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAndResult =
        particularLongValue.and(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#and(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#and(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.and(SpecificLongValue)"})
  public void testAndWithSpecificLongValue_whenNull_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualAndResult = (new ParticularLongValue(42L)).and((SpecificLongValue) null);

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#or(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.or(LongValue)"})
  public void testOrWithLongValue_givenParticularLongValueWithValueIsFortyTwo() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).or(other));
  }

  /**
   * Test {@link SpecificLongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#or(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.or(LongValue)"})
  public void testOrWithLongValue_thenReturnConvertedLongValue() {
    // Arrange
    ConvertedLongValue convertedLongValue =
        new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedLongValue other = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualOrResult = convertedLongValue.or((LongValue) other);

    // Assert
    assertTrue(actualOrResult instanceof ConvertedLongValue);
    assertEquals(convertedLongValue, actualOrResult);
    assertSame(other, actualOrResult);
  }

  /**
   * Test {@link SpecificLongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#or(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.or(LongValue)"})
  public void testOrWithLongValue_whenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualOrResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .or(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#or(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.or(LongValue)"})
  public void testOrWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).or(other));
  }

  /**
   * Test {@link SpecificLongValue#or(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#or(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.or(SpecificLongValue)"})
  public void testOrWithSpecificLongValue_givenParticularLongValueWithValueIsOne() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualOrResult =
        particularLongValue.or((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#or(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue#ParticularLongValue(long)} with value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#or(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.or(SpecificLongValue)"})
  public void testOrWithSpecificLongValue_thenReturnParticularLongValueWithValueIsFortyTwo() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act and Assert
    assertSame(
        particularLongValue,
        particularLongValue.or((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link SpecificLongValue#or(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>When {@link ConvertedLongValue#ConvertedLongValue(Value)} with value is {@link
   *       BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#or(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.or(SpecificLongValue)"})
  public void testOrWithSpecificLongValue_whenConvertedLongValueWithValueIsInteger_value_byte() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualOrResult =
        particularLongValue.or(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#or(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#or(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.or(SpecificLongValue)"})
  public void testOrWithSpecificLongValue_whenNull_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualOrResult = (new ParticularLongValue(42L)).or((SpecificLongValue) null);

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#xor(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.xor(LongValue)"})
  public void testXorWithLongValue_givenParticularLongValueWithValueIsFortyTwo() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularLongValue(42L)).xor(other));
  }

  /**
   * Test {@link SpecificLongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#xor(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.xor(LongValue)"})
  public void testXorWithLongValue_thenReturnParticularLongValue() {
    // Arrange
    ConvertedLongValue convertedLongValue =
        new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualXorResult =
        convertedLongValue.xor(
            (LongValue) new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(0L, actualXorResult.value());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#xor(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.xor(LongValue)"})
  public void testXorWithLongValue_whenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualXorResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .xor(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#xor(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.xor(LongValue)"})
  public void testXorWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).xor(other));
  }

  /**
   * Test {@link SpecificLongValue#xor(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#xor(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.xor(SpecificLongValue)"})
  public void testXorWithSpecificLongValue_givenParticularLongValueWithValueIsOne() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualXorResult =
        particularLongValue.xor((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#xor(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#xor(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.xor(SpecificLongValue)"})
  public void testXorWithSpecificLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult =
        particularLongValue.xor((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(0L, actualXorResult.value());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#xor(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>When {@link ConvertedLongValue#ConvertedLongValue(Value)} with value is {@link
   *       BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#xor(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.xor(SpecificLongValue)"})
  public void testXorWithSpecificLongValue_whenConvertedLongValueWithValueIsInteger_value_byte() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult =
        particularLongValue.xor(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#xor(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#xor(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificLongValue.xor(SpecificLongValue)"})
  public void testXorWithSpecificLongValue_whenNull_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualXorResult = (new ParticularLongValue(42L)).xor((SpecificLongValue) null);

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#compare(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificLongValue.compare(LongValue)"})
  public void testCompareWithLongValue_givenParticularLongValueWithValueIsFortyTwo() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new ParticularLongValue(42L)).compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link NegatedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#compare(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificLongValue.compare(LongValue)"})
  public void testCompareWithLongValue_whenLong_value_0_thenReturnNegatedIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .compare(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link NegatedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#compare(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificLongValue.compare(LongValue)"})
  public void testCompareWithLongValue_whenLong_value_thenReturnNegatedIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#compare(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificLongValue#compare(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificLongValue.compare(SpecificLongValue)"})
  public void testCompareWithSpecificLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    IntegerValue actualCompareResult =
        particularLongValue.compare((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#isSpecific()}.
   *
   * <p>Method under test: {@link SpecificLongValue#isSpecific()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SpecificLongValue.isSpecific()"})
  public void testIsSpecific() {
    // Arrange, Act and Assert
    assertTrue((new ParticularLongValue(42L)).isSpecific());
  }

  /**
   * Test {@link SpecificLongValue#equals(Object)}, and {@link SpecificLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SpecificLongValue.equals(Object)",
    "int SpecificLongValue.hashCode()"
  })
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
   * Test {@link SpecificLongValue#equals(Object)}, and {@link SpecificLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SpecificLongValue.equals(Object)",
    "int SpecificLongValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act and Assert
    assertEquals(particularLongValue, particularLongValue);
    int expectedHashCodeResult = particularLongValue.hashCode();
    assertEquals(expectedHashCodeResult, particularLongValue.hashCode());
  }

  /**
   * Test {@link SpecificLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SpecificLongValue.equals(Object)",
    "int SpecificLongValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act and Assert
    assertNotEquals(particularLongValue, new ParticularLongValue(42L));
  }

  /**
   * Test {@link SpecificLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SpecificLongValue.equals(Object)",
    "int SpecificLongValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularLongValue(42L), null);
  }

  /**
   * Test {@link SpecificLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SpecificLongValue.equals(Object)",
    "int SpecificLongValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularLongValue(42L), "Different type to SpecificLongValue");
  }
}
