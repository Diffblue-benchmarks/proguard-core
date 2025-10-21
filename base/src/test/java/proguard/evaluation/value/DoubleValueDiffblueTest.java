package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DoubleValueDiffblueTest {
  /**
   * Test {@link DoubleValue#value()}.
   *
   * <p>Method under test: {@link DoubleValue#value()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double DoubleValue.value()"})
  public void testValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, (new UnknownDoubleValue()).value(), 0.0);
  }

  /**
   * Test {@link DoubleValue#generalize(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#generalize(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.generalize(ParticularDoubleValue)"})
  public void testGeneralizeWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.generalize(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#generalize(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#generalize(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.generalize(ParticularDoubleValue)"})
  public void testGeneralizeWithParticularDoubleValue_thenReturnUnknownDoubleValue2() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualGeneralizeResult =
        compositeDoubleValue.generalize(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link DoubleValue#generalize(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <p>Method under test: {@link DoubleValue#generalize(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.generalize(SpecificDoubleValue)"})
  public void testGeneralizeWithSpecificDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue,
        unknownDoubleValue.generalize((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#UNKNOWN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#generalize(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value DoubleValue.generalize(Value)"})
  public void testGeneralizeWithValue_givenDouble_value_thenReturnUnknown_value() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.DOUBLE_VALUE.generalize(other));
  }

  /**
   * Test {@link DoubleValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#generalize(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value DoubleValue.generalize(Value)"})
  public void testGeneralizeWithValue_whenDouble_value_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue, unknownDoubleValue.generalize((Value) BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link DoubleValue#add(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#add(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.add(ParticularDoubleValue)"})
  public void testAddWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualAddResult = compositeDoubleValue.add(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#add(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#add(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.add(ParticularDoubleValue)"})
  public void testAddWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue other = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualAddResult = ParticularValueFactory.DOUBLE_VALUE_0.add(other);

    // Assert
    assertTrue(actualAddResult instanceof ParticularDoubleValue);
    assertEquals(other, actualAddResult);
  }

  /**
   * Test {@link DoubleValue#add(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#add(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.add(ParticularDoubleValue)"})
  public void testAddWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.add(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#add(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#add(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.add(SpecificDoubleValue)"})
  public void testAddWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualAddResult =
        ParticularValueFactory.DOUBLE_VALUE_0.add(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#add(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#add(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.add(SpecificDoubleValue)"})
  public void testAddWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue,
        unknownDoubleValue.add((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#subtract(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtract(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.subtract(ParticularDoubleValue)"})
  public void testSubtractWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualSubtractResult =
        compositeDoubleValue.subtract(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#subtract(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtract(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.subtract(ParticularDoubleValue)"})
  public void testSubtractWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualSubtractResult =
        ParticularValueFactory.DOUBLE_VALUE_0.subtract(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularDoubleValue);
    assertEquals(-10.0d, actualSubtractResult.value(), 0.0);
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#subtract(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtract(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.subtract(ParticularDoubleValue)"})
  public void testSubtractWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.subtract(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#subtract(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtract(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.subtract(SpecificDoubleValue)"})
  public void testSubtractWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualSubtractResult =
        ParticularValueFactory.DOUBLE_VALUE_0.subtract(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#subtract(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtract(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.subtract(SpecificDoubleValue)"})
  public void testSubtractWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue,
        unknownDoubleValue.subtract((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#subtractFrom(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtractFrom(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.subtractFrom(ParticularDoubleValue)"})
  public void testSubtractFromWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualSubtractFromResult =
        compositeDoubleValue.subtractFrom(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#subtractFrom(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtractFrom(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.subtractFrom(ParticularDoubleValue)"})
  public void testSubtractFromWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue other = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractFromResult =
        ParticularValueFactory.DOUBLE_VALUE_0.subtractFrom(other);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularDoubleValue);
    assertEquals(other, actualSubtractFromResult);
  }

  /**
   * Test {@link DoubleValue#subtractFrom(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtractFrom(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.subtractFrom(ParticularDoubleValue)"})
  public void testSubtractFromWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue, unknownDoubleValue.subtractFrom(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#subtractFrom(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtractFrom(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.subtractFrom(SpecificDoubleValue)"})
  public void testSubtractFromWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualSubtractFromResult =
        ParticularValueFactory.DOUBLE_VALUE_0.subtractFrom(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#subtractFrom(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtractFrom(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.subtractFrom(SpecificDoubleValue)"})
  public void testSubtractFromWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue,
        unknownDoubleValue.subtractFrom((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#multiply(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#multiply(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.multiply(ParticularDoubleValue)"})
  public void testMultiplyWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualMultiplyResult =
        compositeDoubleValue.multiply(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#multiply(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#multiply(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.multiply(ParticularDoubleValue)"})
  public void testMultiplyWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    DoubleValue doubleValue = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualMultiplyResult = doubleValue.multiply(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularDoubleValue);
    assertEquals(doubleValue, actualMultiplyResult);
  }

  /**
   * Test {@link DoubleValue#multiply(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#multiply(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.multiply(ParticularDoubleValue)"})
  public void testMultiplyWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.multiply(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#multiply(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#multiply(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.multiply(SpecificDoubleValue)"})
  public void testMultiplyWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualMultiplyResult =
        ParticularValueFactory.DOUBLE_VALUE_0.multiply(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#multiply(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#multiply(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.multiply(SpecificDoubleValue)"})
  public void testMultiplyWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue,
        unknownDoubleValue.multiply((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#divide(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divide(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.divide(ParticularDoubleValue)"})
  public void testDivideWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualDivideResult = compositeDoubleValue.divide(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#divide(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divide(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.divide(ParticularDoubleValue)"})
  public void testDivideWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    DoubleValue doubleValue = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualDivideResult = doubleValue.divide(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularDoubleValue);
    assertEquals(doubleValue, actualDivideResult);
  }

  /**
   * Test {@link DoubleValue#divide(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divide(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.divide(ParticularDoubleValue)"})
  public void testDivideWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.divide(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#divide(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divide(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.divide(SpecificDoubleValue)"})
  public void testDivideWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualDivideResult =
        ParticularValueFactory.DOUBLE_VALUE_0.divide(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#divide(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divide(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.divide(SpecificDoubleValue)"})
  public void testDivideWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue,
        unknownDoubleValue.divide((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#divideOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divideOf(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.divideOf(ParticularDoubleValue)"})
  public void testDivideOfWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualDivideOfResult =
        compositeDoubleValue.divideOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#divideOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divideOf(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.divideOf(ParticularDoubleValue)"})
  public void testDivideOfWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualDivideOfResult =
        ParticularValueFactory.DOUBLE_VALUE_0.divideOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularDoubleValue);
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
    assertEquals(Double.POSITIVE_INFINITY, actualDivideOfResult.value(), 0.0);
  }

  /**
   * Test {@link DoubleValue#divideOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divideOf(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.divideOf(ParticularDoubleValue)"})
  public void testDivideOfWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.divideOf(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#divideOf(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divideOf(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.divideOf(SpecificDoubleValue)"})
  public void testDivideOfWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualDivideOfResult =
        ParticularValueFactory.DOUBLE_VALUE_0.divideOf(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#divideOf(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divideOf(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.divideOf(SpecificDoubleValue)"})
  public void testDivideOfWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue,
        unknownDoubleValue.divideOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#remainder(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainder(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.remainder(ParticularDoubleValue)"})
  public void testRemainderWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualRemainderResult =
        compositeDoubleValue.remainder(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#remainder(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainder(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.remainder(ParticularDoubleValue)"})
  public void testRemainderWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    DoubleValue doubleValue = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualRemainderResult = doubleValue.remainder(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularDoubleValue);
    assertEquals(doubleValue, actualRemainderResult);
  }

  /**
   * Test {@link DoubleValue#remainder(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainder(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.remainder(ParticularDoubleValue)"})
  public void testRemainderWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.remainder(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#remainder(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainder(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.remainder(SpecificDoubleValue)"})
  public void testRemainderWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualRemainderResult =
        ParticularValueFactory.DOUBLE_VALUE_0.remainder(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#remainder(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainder(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.remainder(SpecificDoubleValue)"})
  public void testRemainderWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue,
        unknownDoubleValue.remainder((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#remainderOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainderOf(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.remainderOf(ParticularDoubleValue)"})
  public void testRemainderOfWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualRemainderOfResult =
        compositeDoubleValue.remainderOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#remainderOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainderOf(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.remainderOf(ParticularDoubleValue)"})
  public void testRemainderOfWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualRemainderOfResult =
        ParticularValueFactory.DOUBLE_VALUE_0.remainderOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularDoubleValue);
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
    assertEquals(Double.NaN, actualRemainderOfResult.value(), 0.0);
  }

  /**
   * Test {@link DoubleValue#remainderOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainderOf(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.remainderOf(ParticularDoubleValue)"})
  public void testRemainderOfWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue, unknownDoubleValue.remainderOf(new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#remainderOf(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainderOf(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.remainderOf(SpecificDoubleValue)"})
  public void testRemainderOfWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualRemainderOfResult =
        ParticularValueFactory.DOUBLE_VALUE_0.remainderOf(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#remainderOf(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainderOf(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.remainderOf(SpecificDoubleValue)"})
  public void testRemainderOfWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(
        unknownDoubleValue,
        unknownDoubleValue.remainderOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link DoubleValue#compare(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <p>Method under test: {@link DoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue DoubleValue.compare(ParticularDoubleValue)"})
  public void testCompareWithParticularDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    IntegerValue actualCompareResult =
        compositeDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compare(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue DoubleValue.compare(ParticularDoubleValue)"})
  public void testCompareWithParticularDoubleValue_givenUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareResult = unknownDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compare(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <p>Method under test: {@link DoubleValue#compare(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue DoubleValue.compare(SpecificDoubleValue)"})
  public void testCompareWithSpecificDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareResult =
        unknownDoubleValue.compare((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(DoubleValue)"})
  public void testCompareReverseWithDoubleValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        (new CompositeDoubleValue(
                BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE))
            .compareReverse(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(DoubleValue)"})
  public void testCompareReverseWithDoubleValue_givenDouble_value_0() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.DOUBLE_VALUE_0.compareReverse(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(DoubleValue)"})
  public void testCompareReverseWithDoubleValue_givenUnknownDoubleValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        (new UnknownDoubleValue()).compareReverse(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(ParticularDoubleValue)"})
  public void testCompareReverseWithParticularDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    IntegerValue actualCompareReverseResult =
        compositeDoubleValue.compareReverse(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(ParticularDoubleValue)"})
  public void testCompareReverseWithParticularDoubleValue_givenUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareReverseResult =
        unknownDoubleValue.compareReverse(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(ParticularDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(ParticularDoubleValue)"})
  public void testCompareReverseWithParticularDoubleValue_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.DOUBLE_VALUE_0.compareReverse(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareReverseResult.value());
    assertTrue(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(SpecificDoubleValue)"})
  public void testCompareReverseWithSpecificDoubleValue_givenDouble_value_0() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.DOUBLE_VALUE_0.compareReverse(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(SpecificDoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(SpecificDoubleValue)"})
  public void testCompareReverseWithSpecificDoubleValue_givenUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareReverseResult =
        unknownDoubleValue.compareReverse((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#doubleValue()}.
   *
   * <p>Method under test: {@link DoubleValue#doubleValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue DoubleValue.doubleValue()"})
  public void testDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.doubleValue());
  }

  /**
   * Test {@link DoubleValue#computationalType()}.
   *
   * <p>Method under test: {@link DoubleValue#computationalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DoubleValue.computationalType()"})
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(4, (new UnknownDoubleValue()).computationalType());
  }

  /**
   * Test {@link DoubleValue#internalType()}.
   *
   * <p>Method under test: {@link DoubleValue#internalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String DoubleValue.internalType()"})
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("D", (new UnknownDoubleValue()).internalType());
  }
}
