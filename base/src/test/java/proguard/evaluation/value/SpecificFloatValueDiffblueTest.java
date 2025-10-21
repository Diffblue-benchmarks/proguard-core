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

public class SpecificFloatValueDiffblueTest {
  /**
   * Test {@link SpecificFloatValue#negate()}.
   *
   * <ul>
   *   <li>Then return {@link NegatedFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.negate()"})
  public void testNegate_thenReturnNegatedFloatValue() {
    // Arrange and Act
    FloatValue actualNegateResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof NegatedFloatValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#negate()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.negate()"})
  public void testNegate_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualNegateResult = (new ParticularFloatValue(10.0f)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof ParticularFloatValue);
    assertEquals(-10.0f, actualNegateResult.value(), 0.0f);
    assertFalse(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#convertToInteger()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#convertToInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificFloatValue.convertToInteger()"})
  public void testConvertToInteger_thenReturnConvertedIntegerValue() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ConvertedIntegerValue);
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertFalse(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#convertToInteger()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#convertToInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificFloatValue.convertToInteger()"})
  public void testConvertToInteger_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult =
        (new ParticularFloatValue(10.0f)).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ParticularIntegerValue);
    assertEquals(10, actualConvertToIntegerResult.value());
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertTrue(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#convertToLong()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#convertToLong()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificFloatValue.convertToLong()"})
  public void testConvertToLong_thenReturnConvertedLongValue() {
    // Arrange and Act
    LongValue actualConvertToLongResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ConvertedLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#convertToLong()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#convertToLong()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue SpecificFloatValue.convertToLong()"})
  public void testConvertToLong_thenReturnParticularLongValue() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new ParticularFloatValue(10.0f)).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ParticularLongValue);
    assertEquals(10L, actualConvertToLongResult.value());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#convertToDouble()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#convertToDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue SpecificFloatValue.convertToDouble()"})
  public void testConvertToDouble_thenReturnConvertedDoubleValue() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ConvertedDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#convertToDouble()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#convertToDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue SpecificFloatValue.convertToDouble()"})
  public void testConvertToDouble_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new ParticularFloatValue(10.0f)).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ParticularDoubleValue);
    assertEquals(10.0d, actualConvertToDoubleResult.value(), 0.0);
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.generalize(FloatValue)"})
  public void testGeneralizeWithFloatValue() {
    // Arrange
    ConvertedFloatValue convertedFloatValue =
        new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    FloatValue actualGeneralizeResult =
        convertedFloatValue.generalize(
            (FloatValue)
                new ConvertedFloatValue(
                    new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ConvertedFloatValue#ConvertedFloatValue(Value)} with value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.generalize(FloatValue)"})
  public void testGeneralizeWithFloatValue_givenConvertedFloatValueWithValueIsNull() {
    // Arrange
    ConvertedFloatValue convertedFloatValue = new ConvertedFloatValue(null);

    // Act
    FloatValue actualGeneralizeResult =
        convertedFloatValue.generalize(
            (FloatValue)
                new ConvertedFloatValue(
                    new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularFloatValue#ParticularFloatValue(float)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.generalize(FloatValue)"})
  public void testGeneralizeWithFloatValue_givenParticularFloatValueWithValueIsTen() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).generalize(other));
  }

  /**
   * Test {@link SpecificFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.generalize(FloatValue)"})
  public void testGeneralizeWithFloatValue_thenReturnConvertedFloatValue() {
    // Arrange
    ConvertedFloatValue convertedFloatValue =
        new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedFloatValue other = new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    FloatValue actualGeneralizeResult = convertedFloatValue.generalize((FloatValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof ConvertedFloatValue);
    assertEquals(convertedFloatValue, actualGeneralizeResult);
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link SpecificFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link UnknownFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.generalize(FloatValue)"})
  public void testGeneralizeWithFloatValue_whenFloat_value_0_thenReturnUnknownFloatValue() {
    // Arrange and Act
    FloatValue actualGeneralizeResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#generalize(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.generalize(FloatValue)"})
  public void testGeneralizeWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).generalize(other));
  }

  /**
   * Test {@link SpecificFloatValue#generalize(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#generalize(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.generalize(SpecificFloatValue)"})
  public void testGeneralizeWithSpecificFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act and Assert
    assertSame(
        particularFloatValue,
        particularFloatValue.generalize((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Test {@link SpecificFloatValue#generalize(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#generalize(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.generalize(SpecificFloatValue)"})
  public void testGeneralizeWithSpecificFloatValue2() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualGeneralizeResult =
        particularFloatValue.generalize(
            new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#generalize(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularFloatValue#ParticularFloatValue(float)} with value is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#generalize(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.generalize(SpecificFloatValue)"})
  public void testGeneralizeWithSpecificFloatValue_givenParticularFloatValueWithValueIs05() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act
    FloatValue actualGeneralizeResult =
        particularFloatValue.generalize((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#generalize(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link UnknownFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#generalize(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.generalize(SpecificFloatValue)"})
  public void testGeneralizeWithSpecificFloatValue_whenNull_thenReturnUnknownFloatValue() {
    // Arrange and Act
    FloatValue actualGeneralizeResult =
        (new ParticularFloatValue(10.0f)).generalize((SpecificFloatValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#add(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularFloatValue#ParticularFloatValue(float)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#add(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.add(FloatValue)"})
  public void testAddWithFloatValue_givenParticularFloatValueWithValueIsTen() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).add(other));
  }

  /**
   * Test {@link SpecificFloatValue#add(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#add(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.add(FloatValue)"})
  public void testAddWithFloatValue_whenFloat_value_0_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualAddResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .add(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof CompositeFloatValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#add(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#add(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.add(FloatValue)"})
  public void testAddWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).add(other));
  }

  /**
   * Test {@link SpecificFloatValue#add(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#add(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.add(SpecificFloatValue)"})
  public void testAddWithSpecificFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult =
        particularFloatValue.add((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualAddResult instanceof CompositeFloatValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#subtract(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularFloatValue#ParticularFloatValue(float)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#subtract(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.subtract(FloatValue)"})
  public void testSubtractWithFloatValue_givenParticularFloatValueWithValueIsTen() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).subtract(other));
  }

  /**
   * Test {@link SpecificFloatValue#subtract(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#subtract(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.subtract(FloatValue)"})
  public void testSubtractWithFloatValue_whenFloat_value_0_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualSubtractResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtract(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#subtract(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#subtract(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.subtract(FloatValue)"})
  public void testSubtractWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtract(other));
  }

  /**
   * Test {@link SpecificFloatValue#subtract(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#subtract(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.subtract(SpecificFloatValue)"})
  public void testSubtractWithSpecificFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractResult =
        particularFloatValue.subtract((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#subtractFrom(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularFloatValue#ParticularFloatValue(float)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.subtractFrom(FloatValue)"})
  public void testSubtractFromWithFloatValue_givenParticularFloatValueWithValueIsTen() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).subtractFrom(other));
  }

  /**
   * Test {@link SpecificFloatValue#subtractFrom(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.subtractFrom(FloatValue)"})
  public void testSubtractFromWithFloatValue_whenFloat_value_0_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualSubtractFromResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtractFrom(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#subtractFrom(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.subtractFrom(FloatValue)"})
  public void testSubtractFromWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtractFrom(other));
  }

  /**
   * Test {@link SpecificFloatValue#subtractFrom(SpecificFloatValue)} with {@code
   * SpecificFloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#subtractFrom(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.subtractFrom(SpecificFloatValue)"})
  public void testSubtractFromWithSpecificFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractFromResult =
        particularFloatValue.subtractFrom((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#multiply(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularFloatValue#ParticularFloatValue(float)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#multiply(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.multiply(FloatValue)"})
  public void testMultiplyWithFloatValue_givenParticularFloatValueWithValueIsTen() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).multiply(other));
  }

  /**
   * Test {@link SpecificFloatValue#multiply(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#multiply(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.multiply(FloatValue)"})
  public void testMultiplyWithFloatValue_whenFloat_value_0_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualMultiplyResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .multiply(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeFloatValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#multiply(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#multiply(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.multiply(FloatValue)"})
  public void testMultiplyWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).multiply(other));
  }

  /**
   * Test {@link SpecificFloatValue#multiply(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#multiply(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.multiply(SpecificFloatValue)"})
  public void testMultiplyWithSpecificFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualMultiplyResult =
        particularFloatValue.multiply((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeFloatValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#divide(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularFloatValue#ParticularFloatValue(float)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#divide(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.divide(FloatValue)"})
  public void testDivideWithFloatValue_givenParticularFloatValueWithValueIsTen() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).divide(other));
  }

  /**
   * Test {@link SpecificFloatValue#divide(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#divide(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.divide(FloatValue)"})
  public void testDivideWithFloatValue_whenFloat_value_0_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualDivideResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divide(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof CompositeFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#divide(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#divide(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.divide(FloatValue)"})
  public void testDivideWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divide(other));
  }

  /**
   * Test {@link SpecificFloatValue#divide(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#divide(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.divide(SpecificFloatValue)"})
  public void testDivideWithSpecificFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideResult =
        particularFloatValue.divide((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#divideOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularFloatValue#ParticularFloatValue(float)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#divideOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.divideOf(FloatValue)"})
  public void testDivideOfWithFloatValue_givenParticularFloatValueWithValueIsTen() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).divideOf(other));
  }

  /**
   * Test {@link SpecificFloatValue#divideOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#divideOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.divideOf(FloatValue)"})
  public void testDivideOfWithFloatValue_whenFloat_value_0_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualDivideOfResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divideOf(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#divideOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#divideOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.divideOf(FloatValue)"})
  public void testDivideOfWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divideOf(other));
  }

  /**
   * Test {@link SpecificFloatValue#divideOf(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#divideOf(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.divideOf(SpecificFloatValue)"})
  public void testDivideOfWithSpecificFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideOfResult =
        particularFloatValue.divideOf((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#remainder(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularFloatValue#ParticularFloatValue(float)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#remainder(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.remainder(FloatValue)"})
  public void testRemainderWithFloatValue_givenParticularFloatValueWithValueIsTen() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).remainder(other));
  }

  /**
   * Test {@link SpecificFloatValue#remainder(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#remainder(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.remainder(FloatValue)"})
  public void testRemainderWithFloatValue_whenFloat_value_0_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualRemainderResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainder(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#remainder(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#remainder(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.remainder(FloatValue)"})
  public void testRemainderWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainder(other));
  }

  /**
   * Test {@link SpecificFloatValue#remainder(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#remainder(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.remainder(SpecificFloatValue)"})
  public void testRemainderWithSpecificFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderResult =
        particularFloatValue.remainder((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#remainderOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularFloatValue#ParticularFloatValue(float)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#remainderOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.remainderOf(FloatValue)"})
  public void testRemainderOfWithFloatValue_givenParticularFloatValueWithValueIsTen() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).remainderOf(other));
  }

  /**
   * Test {@link SpecificFloatValue#remainderOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#remainderOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.remainderOf(FloatValue)"})
  public void testRemainderOfWithFloatValue_whenFloat_value_0_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualRemainderOfResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainderOf(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#remainderOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#remainderOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.remainderOf(FloatValue)"})
  public void testRemainderOfWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainderOf(other));
  }

  /**
   * Test {@link SpecificFloatValue#remainderOf(SpecificFloatValue)} with {@code
   * SpecificFloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#remainderOf(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue SpecificFloatValue.remainderOf(SpecificFloatValue)"})
  public void testRemainderOfWithSpecificFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderOfResult =
        particularFloatValue.remainderOf((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularFloatValue#ParticularFloatValue(float)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#compare(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificFloatValue.compare(FloatValue)"})
  public void testCompareWithFloatValue_givenParticularFloatValueWithValueIsTen() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new ParticularFloatValue(10.0f)).compare(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#compare(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificFloatValue.compare(FloatValue)"})
  public void testCompareWithFloatValue_whenFloat_value_0_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .compare(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#compare(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificFloatValue.compare(FloatValue)"})
  public void testCompareWithFloatValue_whenFloat_value_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .compare(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#compare(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <p>Method under test: {@link SpecificFloatValue#compare(SpecificFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue SpecificFloatValue.compare(SpecificFloatValue)"})
  public void testCompareWithSpecificFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    IntegerValue actualCompareResult =
        particularFloatValue.compare((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#isSpecific()}.
   *
   * <p>Method under test: {@link SpecificFloatValue#isSpecific()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SpecificFloatValue.isSpecific()"})
  public void testIsSpecific() {
    // Arrange, Act and Assert
    assertTrue((new ParticularFloatValue(10.0f)).isSpecific());
  }

  /**
   * Test {@link SpecificFloatValue#equals(Object)}, and {@link SpecificFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SpecificFloatValue.equals(Object)",
    "int SpecificFloatValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);
    ParticularFloatValue particularFloatValue2 = new ParticularFloatValue(10.0f);

    // Act and Assert
    assertEquals(particularFloatValue, particularFloatValue2);
    int expectedHashCodeResult = particularFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, particularFloatValue2.hashCode());
  }

  /**
   * Test {@link SpecificFloatValue#equals(Object)}, and {@link SpecificFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SpecificFloatValue.equals(Object)",
    "int SpecificFloatValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act and Assert
    assertEquals(particularFloatValue, particularFloatValue);
    int expectedHashCodeResult = particularFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, particularFloatValue.hashCode());
  }

  /**
   * Test {@link SpecificFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SpecificFloatValue.equals(Object)",
    "int SpecificFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act and Assert
    assertNotEquals(particularFloatValue, new ParticularFloatValue(10.0f));
  }

  /**
   * Test {@link SpecificFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SpecificFloatValue.equals(Object)",
    "int SpecificFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularFloatValue(10.0f), null);
  }

  /**
   * Test {@link SpecificFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean SpecificFloatValue.equals(Object)",
    "int SpecificFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularFloatValue(10.0f), "Different type to SpecificFloatValue");
  }
}
