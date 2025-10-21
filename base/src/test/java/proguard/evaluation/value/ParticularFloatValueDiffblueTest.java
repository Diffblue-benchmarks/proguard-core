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

public class ParticularFloatValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularFloatValue#ParticularFloatValue(float)}
   *   <li>{@link ParticularFloatValue#toString()}
   *   <li>{@link ParticularFloatValue#isParticular()}
   *   <li>{@link ParticularFloatValue#value()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ParticularFloatValue.<init>(float)",
    "boolean ParticularFloatValue.isParticular()",
    "String ParticularFloatValue.toString()",
    "float ParticularFloatValue.value()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ParticularFloatValue actualParticularFloatValue = new ParticularFloatValue(10.0f);
    String actualToStringResult = actualParticularFloatValue.toString();
    boolean actualIsParticularResult = actualParticularFloatValue.isParticular();

    // Assert
    assertEquals("10.0f", actualToStringResult);
    assertEquals(10.0f, actualParticularFloatValue.value(), 0.0f);
    assertTrue(actualIsParticularResult);
  }

  /**
   * Test {@link ParticularFloatValue#negate()}.
   *
   * <p>Method under test: {@link ParticularFloatValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.negate()"})
  public void testNegate() {
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
   * Test {@link ParticularFloatValue#convertToInteger()}.
   *
   * <p>Method under test: {@link ParticularFloatValue#convertToInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.convertToInteger()"})
  public void testConvertToInteger() {
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
   * Test {@link ParticularFloatValue#convertToLong()}.
   *
   * <p>Method under test: {@link ParticularFloatValue#convertToLong()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue ParticularFloatValue.convertToLong()"})
  public void testConvertToLong() {
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
   * Test {@link ParticularFloatValue#convertToDouble()}.
   *
   * <p>Method under test: {@link ParticularFloatValue#convertToDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue ParticularFloatValue.convertToDouble()"})
  public void testConvertToDouble() {
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
   * Test {@link ParticularFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(FloatValue)"})
  public void testGeneralizeWithFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualGeneralizeResult =
        particularFloatValue.generalize(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(FloatValue)"})
  public void testGeneralizeWithFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);
    ParticularFloatValue other = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualGeneralizeResult = particularFloatValue.generalize((FloatValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof ParticularFloatValue);
    assertEquals(particularFloatValue, actualGeneralizeResult);
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link UnknownFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(FloatValue)"})
  public void testGeneralizeWithFloatValue_whenFloat_value_0_thenReturnUnknownFloatValue() {
    // Arrange and Act
    FloatValue actualGeneralizeResult =
        (new ParticularFloatValue(10.0f)).generalize(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(FloatValue)"})
  public void testGeneralizeWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).generalize(other));
  }

  /**
   * Test {@link ParticularFloatValue#generalize(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(ParticularFloatValue)"})
  public void testGeneralizeWithParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act and Assert
    assertSame(
        particularFloatValue, particularFloatValue.generalize(new ParticularFloatValue(10.0f)));
  }

  /**
   * Test {@link ParticularFloatValue#generalize(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(ParticularFloatValue)"})
  public void testGeneralizeWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act
    FloatValue actualGeneralizeResult =
        particularFloatValue.generalize(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#add(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#add(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.add(FloatValue)"})
  public void testAddWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult =
        particularFloatValue.add(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeFloatValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#add(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#add(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.add(FloatValue)"})
  public void testAddWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult = particularFloatValue.add(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof ParticularFloatValue);
    assertEquals(particularFloatValue, actualAddResult);
  }

  /**
   * Test {@link ParticularFloatValue#add(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#add(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.add(FloatValue)"})
  public void testAddWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).add(other));
  }

  /**
   * Test {@link ParticularFloatValue#add(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#add(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.add(ParticularFloatValue)"})
  public void testAddWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult = particularFloatValue.add(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualAddResult instanceof ParticularFloatValue);
    assertEquals(20.0f, actualAddResult.value(), 0.0f);
    assertFalse(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#subtract(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtract(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtract(FloatValue)"})
  public void testSubtractWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractResult =
        particularFloatValue.subtract(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#subtract(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtract(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtract(FloatValue)"})
  public void testSubtractWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractResult =
        particularFloatValue.subtract(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularFloatValue);
    assertEquals(particularFloatValue, actualSubtractResult);
  }

  /**
   * Test {@link ParticularFloatValue#subtract(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtract(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtract(FloatValue)"})
  public void testSubtractWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).subtract(other));
  }

  /**
   * Test {@link ParticularFloatValue#subtract(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtract(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtract(ParticularFloatValue)"})
  public void testSubtractWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractResult =
        particularFloatValue.subtract(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualSubtractResult.value(), 0.0f);
    assertFalse(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#subtractFrom(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtractFrom(FloatValue)"})
  public void testSubtractFromWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractFromResult =
        particularFloatValue.subtractFrom(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#subtractFrom(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtractFrom(FloatValue)"})
  public void testSubtractFromWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualSubtractFromResult =
        (new ParticularFloatValue(10.0f)).subtractFrom(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularFloatValue);
    assertEquals(-10.0f, actualSubtractFromResult.value(), 0.0f);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#subtractFrom(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtractFrom(FloatValue)"})
  public void testSubtractFromWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).subtractFrom(other));
  }

  /**
   * Test {@link ParticularFloatValue#subtractFrom(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtractFrom(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtractFrom(ParticularFloatValue)"})
  public void testSubtractFromWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractFromResult =
        particularFloatValue.subtractFrom(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualSubtractFromResult.value(), 0.0f);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#multiply(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#multiply(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.multiply(FloatValue)"})
  public void testMultiplyWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualMultiplyResult =
        particularFloatValue.multiply(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeFloatValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#multiply(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#multiply(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.multiply(FloatValue)"})
  public void testMultiplyWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange
    FloatValue other = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualMultiplyResult = (new ParticularFloatValue(10.0f)).multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularFloatValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Test {@link ParticularFloatValue#multiply(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#multiply(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.multiply(FloatValue)"})
  public void testMultiplyWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).multiply(other));
  }

  /**
   * Test {@link ParticularFloatValue#multiply(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#multiply(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.multiply(ParticularFloatValue)"})
  public void testMultiplyWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualMultiplyResult =
        particularFloatValue.multiply(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularFloatValue);
    assertEquals(100.0f, actualMultiplyResult.value(), 0.0f);
    assertFalse(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#divide(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divide(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divide(FloatValue)"})
  public void testDivideWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideResult =
        particularFloatValue.divide(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#divide(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divide(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divide(FloatValue)"})
  public void testDivideWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualDivideResult =
        (new ParticularFloatValue(10.0f)).divide(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
    assertEquals(Float.POSITIVE_INFINITY, actualDivideResult.value(), 0.0f);
  }

  /**
   * Test {@link ParticularFloatValue#divide(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divide(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divide(FloatValue)"})
  public void testDivideWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).divide(other));
  }

  /**
   * Test {@link ParticularFloatValue#divide(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divide(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divide(ParticularFloatValue)"})
  public void testDivideWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideResult = particularFloatValue.divide(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularFloatValue);
    assertEquals(1.0f, actualDivideResult.value(), 0.0f);
    assertFalse(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#divideOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divideOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divideOf(FloatValue)"})
  public void testDivideOfWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideOfResult =
        particularFloatValue.divideOf(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#divideOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divideOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divideOf(FloatValue)"})
  public void testDivideOfWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange
    FloatValue other = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualDivideOfResult = (new ParticularFloatValue(10.0f)).divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularFloatValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Test {@link ParticularFloatValue#divideOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divideOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divideOf(FloatValue)"})
  public void testDivideOfWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).divideOf(other));
  }

  /**
   * Test {@link ParticularFloatValue#divideOf(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divideOf(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divideOf(ParticularFloatValue)"})
  public void testDivideOfWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideOfResult =
        particularFloatValue.divideOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularFloatValue);
    assertEquals(1.0f, actualDivideOfResult.value(), 0.0f);
    assertFalse(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#remainder(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainder(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainder(FloatValue)"})
  public void testRemainderWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderResult =
        particularFloatValue.remainder(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#remainder(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainder(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainder(FloatValue)"})
  public void testRemainderWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualRemainderResult =
        (new ParticularFloatValue(10.0f)).remainder(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
    assertEquals(Float.NaN, actualRemainderResult.value(), 0.0f);
  }

  /**
   * Test {@link ParticularFloatValue#remainder(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainder(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainder(FloatValue)"})
  public void testRemainderWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).remainder(other));
  }

  /**
   * Test {@link ParticularFloatValue#remainder(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainder(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainder(ParticularFloatValue)"})
  public void testRemainderWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderResult =
        particularFloatValue.remainder(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualRemainderResult.value(), 0.0f);
    assertFalse(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#remainderOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainderOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainderOf(FloatValue)"})
  public void testRemainderOfWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderOfResult =
        particularFloatValue.remainderOf(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#remainderOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainderOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainderOf(FloatValue)"})
  public void testRemainderOfWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange
    FloatValue other = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualRemainderOfResult = (new ParticularFloatValue(10.0f)).remainderOf(other);

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularFloatValue);
    assertEquals(other, actualRemainderOfResult);
  }

  /**
   * Test {@link ParticularFloatValue#remainderOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainderOf(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainderOf(FloatValue)"})
  public void testRemainderOfWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularFloatValue(10.0f)).remainderOf(other));
  }

  /**
   * Test {@link ParticularFloatValue#remainderOf(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainderOf(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainderOf(ParticularFloatValue)"})
  public void testRemainderOfWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderOfResult =
        particularFloatValue.remainderOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualRemainderOfResult.value(), 0.0f);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(FloatValue)"})
  public void testCompareWithFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    IntegerValue actualCompareResult =
        particularFloatValue.compare(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return value is {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(FloatValue)"})
  public void testCompareWithFloatValue_thenReturnValueIsNever() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new ParticularFloatValue(-0.5f)).compare(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
    assertEquals(Value.NEVER, actualCompareResult.value());
  }

  /**
   * Test {@link ParticularFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return value is zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(FloatValue)"})
  public void testCompareWithFloatValue_thenReturnValueIsZero() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    IntegerValue actualCompareResult =
        particularFloatValue.compare((FloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(0, actualCompareResult.value());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return value is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(FloatValue)"})
  public void testCompareWithFloatValue_whenFloat_value_0_thenReturnValueIsOne() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new ParticularFloatValue(10.0f)).compare(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareResult.value());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(FloatValue)"})
  public void testCompareWithFloatValue_whenFloat_value_thenReturnUnknownIntegerValue() {
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
   * Test {@link ParticularFloatValue#compare(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return value is {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(ParticularFloatValue)"})
  public void testCompareWithParticularFloatValue_thenReturnValueIsNever() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act
    IntegerValue actualCompareResult =
        particularFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
    assertEquals(Value.NEVER, actualCompareResult.value());
  }

  /**
   * Test {@link ParticularFloatValue#compare(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return value is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(ParticularFloatValue)"})
  public void testCompareWithParticularFloatValue_thenReturnValueIsOne() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(Float.NaN);

    // Act
    IntegerValue actualCompareResult =
        particularFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#compare(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return value is zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(ParticularFloatValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(ParticularFloatValue)"})
  public void testCompareWithParticularFloatValue_thenReturnValueIsZero() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    IntegerValue actualCompareResult =
        particularFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(0, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#equals(Object)}, and {@link ParticularFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularFloatValue#equals(Object)}
   *   <li>{@link ParticularFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ParticularFloatValue.equals(Object)",
    "int ParticularFloatValue.hashCode()"
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
   * Test {@link ParticularFloatValue#equals(Object)}, and {@link ParticularFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularFloatValue#equals(Object)}
   *   <li>{@link ParticularFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ParticularFloatValue.equals(Object)",
    "int ParticularFloatValue.hashCode()"
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
   * Test {@link ParticularFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ParticularFloatValue.equals(Object)",
    "int ParticularFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act and Assert
    assertNotEquals(particularFloatValue, new ParticularFloatValue(10.0f));
  }

  /**
   * Test {@link ParticularFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ParticularFloatValue.equals(Object)",
    "int ParticularFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularFloatValue(10.0f), null);
  }

  /**
   * Test {@link ParticularFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ParticularFloatValue.equals(Object)",
    "int ParticularFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularFloatValue(10.0f), "Different type to ParticularFloatValue");
  }
}
