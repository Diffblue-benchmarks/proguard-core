package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IntegerValueDiffblueTest {
  /**
   * Test {@link IntegerValue#value()}.
   *
   * <p>Method under test: {@link IntegerValue#value()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.value()"})
  public void testValue() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownIntegerValue()).value());
  }

  /**
   * Test {@link IntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(ParticularIntegerValue)"})
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
   * Test {@link IntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(ParticularIntegerValue)"})
  public void testGeneralizeWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.generalize(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(ParticularIntegerValue)"})
  public void testGeneralizeWithParticularIntegerValue_thenReturnUnknownIntegerValue2() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualGeneralizeResult =
        comparisonValue.generalize(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(RangeIntegerValue)"})
  public void testGeneralizeWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.generalize(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#generalize(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(SpecificIntegerValue)"})
  public void testGeneralizeWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.generalize((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#generalize(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(UnknownIntegerValue)"})
  public void testGeneralizeWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.generalize(other));
  }

  /**
   * Test {@link IntegerValue#generalize(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(UnknownIntegerValue)"})
  public void testGeneralizeWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.generalize(other));
  }

  /**
   * Test {@link IntegerValue#generalize(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(UnknownIntegerValue)"})
  public void testGeneralizeWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.generalize(other));
  }

  /**
   * Test {@link IntegerValue#generalize(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(UnknownIntegerValue)"})
  public void testGeneralizeWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.generalize(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link BasicValueFactory#UNKNOWN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value IntegerValue.generalize(Value)"})
  public void testGeneralizeWithValue_givenInteger_value_byte_thenReturnUnknown_value() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.generalize(other));
  }

  /**
   * Test {@link IntegerValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value IntegerValue.generalize(Value)"})
  public void testGeneralizeWithValue_whenInteger_value_byte_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.generalize((Value) BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(ParticularIntegerValue)"})
  public void testAddWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAddResult = comparisonValue.add(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(ParticularIntegerValue)"})
  public void testAddWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(ParticularIntegerValue)"})
  public void testAddWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.add(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(RangeIntegerValue)"})
  public void testAddWithRangeIntegerValue_givenInteger_value_byte_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(RangeIntegerValue)"})
  public void testAddWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.add(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#add(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(SpecificIntegerValue)"})
  public void testAddWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        ParticularValueFactory.INTEGER_VALUE_0.add(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#add(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(SpecificIntegerValue)"})
  public void testAddWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#add(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(SpecificIntegerValue)"})
  public void testAddWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.add((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#add(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(UnknownIntegerValue)"})
  public void testAddWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.add(other));
  }

  /**
   * Test {@link IntegerValue#add(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(UnknownIntegerValue)"})
  public void testAddWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.add(other));
  }

  /**
   * Test {@link IntegerValue#add(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(UnknownIntegerValue)"})
  public void testAddWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(other));
  }

  /**
   * Test {@link IntegerValue#add(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.add(UnknownIntegerValue)"})
  public void testAddWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.add(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#subtract(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(ParticularIntegerValue)"})
  public void testSubtractWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractResult = comparisonValue.subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtract(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(ParticularIntegerValue)"})
  public void testSubtractWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtract(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(ParticularIntegerValue)"})
  public void testSubtractWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtract(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(RangeIntegerValue)"})
  public void testSubtractWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(RangeIntegerValue)"})
  public void testSubtractWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtract(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#subtract(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(SpecificIntegerValue)"})
  public void testSubtractWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        ParticularValueFactory.INTEGER_VALUE_0.subtract(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtract(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(SpecificIntegerValue)"})
  public void testSubtractWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtract(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtract(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(SpecificIntegerValue)"})
  public void testSubtractWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.subtract((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#subtract(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(UnknownIntegerValue)"})
  public void testSubtractWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.subtract(other));
  }

  /**
   * Test {@link IntegerValue#subtract(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(UnknownIntegerValue)"})
  public void testSubtractWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.subtract(other));
  }

  /**
   * Test {@link IntegerValue#subtract(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(UnknownIntegerValue)"})
  public void testSubtractWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtract(other));
  }

  /**
   * Test {@link IntegerValue#subtract(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(UnknownIntegerValue)"})
  public void testSubtractWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtract(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(ParticularIntegerValue)"})
  public void testSubtractFromWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractFromResult =
        comparisonValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(ParticularIntegerValue)"})
  public void testSubtractFromWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(ParticularIntegerValue)"})
  public void testSubtractFromWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.subtractFrom(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(RangeIntegerValue)"})
  public void testSubtractFromWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtractFrom(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(RangeIntegerValue)"})
  public void testSubtractFromWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtractFrom(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(SpecificIntegerValue)"})
  public void testSubtractFromWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        ParticularValueFactory.INTEGER_VALUE_0.subtractFrom(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtractFrom(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(SpecificIntegerValue)"})
  public void testSubtractFromWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtractFrom(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtractFrom(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(SpecificIntegerValue)"})
  public void testSubtractFromWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.subtractFrom((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(UnknownIntegerValue)"})
  public void testSubtractFromWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.subtractFrom(other));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(UnknownIntegerValue)"})
  public void testSubtractFromWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.subtractFrom(other));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(UnknownIntegerValue)"})
  public void testSubtractFromWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtractFrom(other));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(UnknownIntegerValue)"})
  public void testSubtractFromWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtractFrom(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#multiply(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(ParticularIntegerValue)"})
  public void testMultiplyWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualMultiplyResult = comparisonValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#multiply(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(ParticularIntegerValue)"})
  public void testMultiplyWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#multiply(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(ParticularIntegerValue)"})
  public void testMultiplyWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.multiply(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(RangeIntegerValue)"})
  public void testMultiplyWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.multiply(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#multiply(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(SpecificIntegerValue)"})
  public void testMultiplyWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        ParticularValueFactory.INTEGER_VALUE_0.multiply(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#multiply(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(SpecificIntegerValue)"})
  public void testMultiplyWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.multiply(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#multiply(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(SpecificIntegerValue)"})
  public void testMultiplyWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.multiply((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#multiply(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(UnknownIntegerValue)"})
  public void testMultiplyWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.multiply(other));
  }

  /**
   * Test {@link IntegerValue#multiply(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(UnknownIntegerValue)"})
  public void testMultiplyWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.multiply(other));
  }

  /**
   * Test {@link IntegerValue#multiply(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(UnknownIntegerValue)"})
  public void testMultiplyWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.multiply(other));
  }

  /**
   * Test {@link IntegerValue#multiply(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(UnknownIntegerValue)"})
  public void testMultiplyWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.multiply(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#divide(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(ParticularIntegerValue)"})
  public void testDivideWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualDivideResult = comparisonValue.divide(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divide(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(ParticularIntegerValue)"})
  public void testDivideWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualDivideResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.divide(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divide(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(ParticularIntegerValue)"})
  public void testDivideWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divide(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#divide(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(RangeIntegerValue)"})
  public void testDivideWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divide(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#divide(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(SpecificIntegerValue)"})
  public void testDivideWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualDivideResult =
        ParticularValueFactory.INTEGER_VALUE_0.divide(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divide(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(SpecificIntegerValue)"})
  public void testDivideWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualDivideResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.divide(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divide(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(SpecificIntegerValue)"})
  public void testDivideWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.divide((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#divide(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(UnknownIntegerValue)"})
  public void testDivideWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.divide(other));
  }

  /**
   * Test {@link IntegerValue#divide(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(UnknownIntegerValue)"})
  public void testDivideWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.divide(other));
  }

  /**
   * Test {@link IntegerValue#divide(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(UnknownIntegerValue)"})
  public void testDivideWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.divide(other));
  }

  /**
   * Test {@link IntegerValue#divide(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(UnknownIntegerValue)"})
  public void testDivideWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divide(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#divideOf(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(ParticularIntegerValue)"})
  public void testDivideOfWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualDivideOfResult = comparisonValue.divideOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divideOf(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(ParticularIntegerValue)"})
  public void testDivideOfWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideOfResult = ParticularValueFactory.INTEGER_VALUE_1.divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Test {@link IntegerValue#divideOf(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(ParticularIntegerValue)"})
  public void testDivideOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divideOf(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(RangeIntegerValue)"})
  public void testDivideOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divideOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#divideOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divideOf(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(SpecificIntegerValue)"})
  public void testDivideOfWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.divideOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#divideOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(UnknownIntegerValue)"})
  public void testDivideOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.divideOf(other));
  }

  /**
   * Test {@link IntegerValue#divideOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(UnknownIntegerValue)"})
  public void testDivideOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.divideOf(other));
  }

  /**
   * Test {@link IntegerValue#divideOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(UnknownIntegerValue)"})
  public void testDivideOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.divideOf(other));
  }

  /**
   * Test {@link IntegerValue#divideOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(UnknownIntegerValue)"})
  public void testDivideOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divideOf(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(ParticularIntegerValue)"})
  public void testRemainderWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualRemainderResult = comparisonValue.remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(ParticularIntegerValue)"})
  public void testRemainderWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        BasicRangeValueFactory.INTEGER_VALUE_CHAR.remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(ParticularIntegerValue)"})
  public void testRemainderWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainder(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#remainder(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(RangeIntegerValue)"})
  public void testRemainderWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainder(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#remainder(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainder(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(SpecificIntegerValue)"})
  public void testRemainderWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.remainder((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#remainder(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(UnknownIntegerValue)"})
  public void testRemainderWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.remainder(other));
  }

  /**
   * Test {@link IntegerValue#remainder(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(UnknownIntegerValue)"})
  public void testRemainderWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.remainder(other));
  }

  /**
   * Test {@link IntegerValue#remainder(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(UnknownIntegerValue)"})
  public void testRemainderWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.remainder(other));
  }

  /**
   * Test {@link IntegerValue#remainder(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(UnknownIntegerValue)"})
  public void testRemainderWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainder(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(ParticularIntegerValue)"})
  public void testRemainderOfWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualRemainderOfResult =
        comparisonValue.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(ParticularIntegerValue)"})
  public void testRemainderOfWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        ParticularValueFactory.INTEGER_VALUE_1.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularIntegerValue);
    assertEquals(0, actualRemainderOfResult.value());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(ParticularIntegerValue)"})
  public void testRemainderOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.remainderOf(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#remainderOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(RangeIntegerValue)"})
  public void testRemainderOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainderOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#remainderOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(SpecificIntegerValue)"})
  public void testRemainderOfWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.remainderOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#remainderOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(UnknownIntegerValue)"})
  public void testRemainderOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.remainderOf(other));
  }

  /**
   * Test {@link IntegerValue#remainderOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(UnknownIntegerValue)"})
  public void testRemainderOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.remainderOf(other));
  }

  /**
   * Test {@link IntegerValue#remainderOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(UnknownIntegerValue)"})
  public void testRemainderOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.remainderOf(other));
  }

  /**
   * Test {@link IntegerValue#remainderOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(UnknownIntegerValue)"})
  public void testRemainderOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainderOf(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(ParticularIntegerValue)"})
  public void testShiftLeftWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftLeftResult = comparisonValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(ParticularIntegerValue)"})
  public void testShiftLeftWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    IntegerValue integerValue = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualShiftLeftResult = integerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularIntegerValue);
    assertEquals(integerValue, actualShiftLeftResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(ParticularIntegerValue)"})
  public void testShiftLeftWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeft(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(RangeIntegerValue)"})
  public void testShiftLeftWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeft(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(SpecificIntegerValue)"})
  public void testShiftLeftWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftLeft((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(UnknownIntegerValue)"})
  public void testShiftLeftWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftLeft(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(UnknownIntegerValue)"})
  public void testShiftLeftWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftLeft(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(UnknownIntegerValue)"})
  public void testShiftLeftWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftLeft(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(UnknownIntegerValue)"})
  public void testShiftLeftWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeft(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(ParticularIntegerValue)"})
  public void testShiftRightWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftRightResult =
        comparisonValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(ParticularIntegerValue)"})
  public void testShiftRightWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(ParticularIntegerValue)"})
  public void testShiftRightWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRight(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftRight(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(RangeIntegerValue)"})
  public void testShiftRightWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRight(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#shiftRight(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(SpecificIntegerValue)"})
  public void testShiftRightWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        ParticularValueFactory.INTEGER_VALUE_0.shiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRight(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(SpecificIntegerValue)"})
  public void testShiftRightWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRight(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(SpecificIntegerValue)"})
  public void testShiftRightWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftRight((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftRight(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(UnknownIntegerValue)"})
  public void testShiftRightWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftRight(other));
  }

  /**
   * Test {@link IntegerValue#shiftRight(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(UnknownIntegerValue)"})
  public void testShiftRightWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftRight(other));
  }

  /**
   * Test {@link IntegerValue#shiftRight(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(UnknownIntegerValue)"})
  public void testShiftRightWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRight(other));
  }

  /**
   * Test {@link IntegerValue#shiftRight(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(UnknownIntegerValue)"})
  public void testShiftRightWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRight(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  public void testUnsignedShiftRightWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        comparisonValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  public void testUnsignedShiftRightWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRight(
            new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  public void testUnsignedShiftRightWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(RangeIntegerValue)"})
  public void testUnsignedShiftRightWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.unsignedShiftRight(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(SpecificIntegerValue)"})
  public void testUnsignedShiftRightWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(SpecificIntegerValue)"})
  public void testUnsignedShiftRightWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(SpecificIntegerValue)"})
  public void testUnsignedShiftRightWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(UnknownIntegerValue)"})
  public void testUnsignedShiftRightWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.unsignedShiftRight(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(UnknownIntegerValue)"})
  public void testUnsignedShiftRightWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRight(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(UnknownIntegerValue)"})
  public void testUnsignedShiftRightWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRight(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(UnknownIntegerValue)"})
  public void testUnsignedShiftRightWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.unsignedShiftRight(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  public void testShiftLeftOfWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftLeftOfResult =
        comparisonValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  public void testShiftLeftOfWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  public void testShiftLeftOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.shiftLeftOf(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.shiftLeftOf(ParticularLongValue)"})
  public void testShiftLeftOfWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftLeftOfResult = comparisonValue.shiftLeftOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.shiftLeftOf(ParticularLongValue)"})
  public void testShiftLeftOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftLeftOfResult = ParticularValueFactory.INTEGER_VALUE_0.shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularLongValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.shiftLeftOf(ParticularLongValue)"})
  public void testShiftLeftOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftLeftOfResult =
        unknownIntegerValue.shiftLeftOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
    assertTrue(actualShiftLeftOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(RangeIntegerValue)"})
  public void testShiftLeftOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeftOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(SpecificIntegerValue)"})
  public void testShiftLeftOfWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftLeftOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.shiftLeftOf(SpecificLongValue)"})
  public void testShiftLeftOfWithSpecificLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftLeftOfResult =
        unknownIntegerValue.shiftLeftOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
    assertTrue(actualShiftLeftOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(UnknownIntegerValue)"})
  public void testShiftLeftOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftLeftOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(UnknownIntegerValue)"})
  public void testShiftLeftOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftLeftOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(UnknownIntegerValue)"})
  public void testShiftLeftOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftLeftOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(UnknownIntegerValue)"})
  public void testShiftLeftOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeftOf(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(UnknownLongValue)} with {@code UnknownLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(UnknownLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.shiftLeftOf(UnknownLongValue)"})
  public void testShiftLeftOfWithUnknownLongValue() {
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
   * Test {@link IntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(ParticularIntegerValue)"})
  public void testShiftRightOfWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftRightOfResult =
        comparisonValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(ParticularIntegerValue)"})
  public void testShiftRightOfWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(ParticularIntegerValue)"})
  public void testShiftRightOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.shiftRightOf(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.shiftRightOf(ParticularLongValue)"})
  public void testShiftRightOfWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftRightOfResult = comparisonValue.shiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.shiftRightOf(ParticularLongValue)"})
  public void testShiftRightOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftRightOfResult = ParticularValueFactory.INTEGER_VALUE_0.shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.shiftRightOf(ParticularLongValue)"})
  public void testShiftRightOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftRightOfResult =
        unknownIntegerValue.shiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(RangeIntegerValue)"})
  public void testShiftRightOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRightOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(SpecificIntegerValue)"})
  public void testShiftRightOfWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftRightOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.shiftRightOf(SpecificLongValue)"})
  public void testShiftRightOfWithSpecificLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftRightOfResult =
        unknownIntegerValue.shiftRightOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(UnknownIntegerValue)"})
  public void testShiftRightOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(UnknownIntegerValue)"})
  public void testShiftRightOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(UnknownIntegerValue)"})
  public void testShiftRightOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(UnknownIntegerValue)"})
  public void testShiftRightOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRightOf(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(UnknownLongValue)} with {@code UnknownLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(UnknownLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.shiftRightOf(UnknownLongValue)"})
  public void testShiftRightOfWithUnknownLongValue() {
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
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  public void testUnsignedShiftRightOfWithParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  public void testUnsignedShiftRightOfWithParticularIntegerValue2() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        comparisonValue.unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  public void testUnsignedShiftRightOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRightOf(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.unsignedShiftRightOf(ParticularLongValue)"})
  public void testUnsignedShiftRightOfWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        comparisonValue.unsignedShiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.unsignedShiftRightOf(ParticularLongValue)"})
  public void testUnsignedShiftRightOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.unsignedShiftRightOf(ParticularLongValue)"})
  public void testUnsignedShiftRightOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        unknownIntegerValue.unsignedShiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(RangeIntegerValue)"})
  public void testUnsignedShiftRightOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.unsignedShiftRightOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(SpecificIntegerValue)"})
  public void testUnsignedShiftRightOfWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRightOf(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(SpecificLongValue)} with {@code
   * SpecificLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.unsignedShiftRightOf(SpecificLongValue)"})
  public void testUnsignedShiftRightOfWithSpecificLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        unknownIntegerValue.unsignedShiftRightOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(UnknownIntegerValue)"})
  public void testUnsignedShiftRightOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.unsignedShiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(UnknownIntegerValue)"})
  public void testUnsignedShiftRightOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(UnknownIntegerValue)"})
  public void testUnsignedShiftRightOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(UnknownIntegerValue)"})
  public void testUnsignedShiftRightOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.unsignedShiftRightOf(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(UnknownLongValue)} with {@code UnknownLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(UnknownLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue IntegerValue.unsignedShiftRightOf(UnknownLongValue)"})
  public void testUnsignedShiftRightOfWithUnknownLongValue() {
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
   * Test {@link IntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.and(ParticularIntegerValue)"})
  public void testAndWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAndResult = comparisonValue.and(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.and(ParticularIntegerValue)"})
  public void testAndWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.and(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.and(ParticularIntegerValue)"})
  public void testAndWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.and(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#and(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#and(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.and(RangeIntegerValue)"})
  public void testAndWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.and(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.and(SpecificIntegerValue)"})
  public void testAndWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        ParticularValueFactory.INTEGER_VALUE_0.and(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.and(SpecificIntegerValue)"})
  public void testAndWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.and(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.and(SpecificIntegerValue)"})
  public void testAndWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.and((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#and(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.and(UnknownIntegerValue)"})
  public void testAndWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.and(other));
  }

  /**
   * Test {@link IntegerValue#and(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.and(UnknownIntegerValue)"})
  public void testAndWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.and(other));
  }

  /**
   * Test {@link IntegerValue#and(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.and(UnknownIntegerValue)"})
  public void testAndWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.and(other));
  }

  /**
   * Test {@link IntegerValue#and(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.and(UnknownIntegerValue)"})
  public void testAndWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.and(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.or(ParticularIntegerValue)"})
  public void testOrWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualOrResult = comparisonValue.or(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.or(ParticularIntegerValue)"})
  public void testOrWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult = ParticularValueFactory.INTEGER_VALUE_0.or(other);

    // Assert
    assertTrue(actualOrResult instanceof ParticularIntegerValue);
    assertEquals(other, actualOrResult);
  }

  /**
   * Test {@link IntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.or(ParticularIntegerValue)"})
  public void testOrWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.or(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#or(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#or(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.or(RangeIntegerValue)"})
  public void testOrWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.or(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#or(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.or(SpecificIntegerValue)"})
  public void testOrWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.or((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#or(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.or(UnknownIntegerValue)"})
  public void testOrWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.or(other));
  }

  /**
   * Test {@link IntegerValue#or(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.or(UnknownIntegerValue)"})
  public void testOrWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.or(other));
  }

  /**
   * Test {@link IntegerValue#or(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.or(UnknownIntegerValue)"})
  public void testOrWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.or(other));
  }

  /**
   * Test {@link IntegerValue#or(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.or(UnknownIntegerValue)"})
  public void testOrWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.or(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#xor(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(ParticularIntegerValue)"})
  public void testXorWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualXorResult = comparisonValue.xor(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#xor(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(ParticularIntegerValue)"})
  public void testXorWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult = ParticularValueFactory.INTEGER_VALUE_0.xor(other);

    // Assert
    assertTrue(actualXorResult instanceof ParticularIntegerValue);
    assertEquals(other, actualXorResult);
  }

  /**
   * Test {@link IntegerValue#xor(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(ParticularIntegerValue)"})
  public void testXorWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.xor(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#xor(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(RangeIntegerValue)"})
  public void testXorWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.xor(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#xor(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(SpecificIntegerValue)"})
  public void testXorWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.xor((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#xor(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(UnknownIntegerValue)"})
  public void testXorWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.xor(other));
  }

  /**
   * Test {@link IntegerValue#xor(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(UnknownIntegerValue)"})
  public void testXorWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.xor(other));
  }

  /**
   * Test {@link IntegerValue#xor(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(UnknownIntegerValue)"})
  public void testXorWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.xor(other));
  }

  /**
   * Test {@link IntegerValue#xor(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(UnknownIntegerValue)"})
  public void testXorWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.xor(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#equal(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.equal(ParticularIntegerValue)"})
  public void testEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#equal(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.equal(ParticularIntegerValue)"})
  public void testEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.equal(RangeIntegerValue)"})
  public void testEqualWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#equal(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.equal(SpecificIntegerValue)"})
  public void testEqualWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0, unknownIntegerValue.equal((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#equal(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.equal(UnknownIntegerValue)"})
  public void testEqualWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.equal(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#equal(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.equal(UnknownIntegerValue)"})
  public void testEqualWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.equal(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#equal(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.equal(UnknownIntegerValue)"})
  public void testEqualWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.equal(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#equal(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.equal(UnknownIntegerValue)"})
  public void testEqualWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.equal(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThan(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThan(ParticularIntegerValue)"})
  public void testLessThanWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThan(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThan(ParticularIntegerValue)"})
  public void testLessThanWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThan(RangeIntegerValue)"})
  public void testLessThanWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#lessThan(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThan(SpecificIntegerValue)"})
  public void testLessThanWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThan(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThan(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThan(SpecificIntegerValue)"})
  public void testLessThanWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0, unknownIntegerValue.lessThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThan(UnknownIntegerValue)"})
  public void testLessThanWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThan(UnknownIntegerValue)"})
  public void testLessThanWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThan(UnknownIntegerValue)"})
  public void testLessThanWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThan(UnknownIntegerValue)"})
  public void testLessThanWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(ParticularIntegerValue)"})
  public void testLessThanOrEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(ParticularIntegerValue)"})
  public void testLessThanOrEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(RangeIntegerValue)"})
  public void testLessThanOrEqualWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(SpecificIntegerValue)"})
  public void testLessThanOrEqualWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(SpecificIntegerValue)"})
  public void testLessThanOrEqualWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0,
        unknownIntegerValue.lessThanOrEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(UnknownIntegerValue)"})
  public void testLessThanOrEqualWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(UnknownIntegerValue)"})
  public void testLessThanOrEqualWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0, ParticularValueFactory.INTEGER_VALUE_0.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(UnknownIntegerValue)"})
  public void testLessThanOrEqualWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(UnknownIntegerValue)"})
  public void testLessThanOrEqualWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#notEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#notEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.notEqual(IntegerValue)"})
  public void testNotEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new UnknownIntegerValue()).notEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#notEqual(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#notEqual(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.notEqual(ParticularIntegerValue)"})
  public void testNotEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.notEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#notEqual(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.notEqual(ParticularIntegerValue)"})
  public void testNotEqualWithParticularIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.notEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#notEqual(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.notEqual(ParticularIntegerValue)"})
  public void testNotEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.notEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#notEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.notEqual(RangeIntegerValue)"})
  public void testNotEqualWithRangeIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.notEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#notEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.notEqual(RangeIntegerValue)"})
  public void testNotEqualWithRangeIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.notEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#notEqual(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#notEqual(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.notEqual(SpecificIntegerValue)"})
  public void testNotEqualWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0, unknownIntegerValue.notEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#notEqual(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#notEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.notEqual(UnknownIntegerValue)"})
  public void testNotEqualWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.notEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#notEqual(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.notEqual(UnknownIntegerValue)"})
  public void testNotEqualWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.notEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#notEqual(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.notEqual(UnknownIntegerValue)"})
  public void testNotEqualWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.notEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#notEqual(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.notEqual(UnknownIntegerValue)"})
  public void testNotEqualWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.notEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(IntegerValue)"})
  public void testGreaterThanWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .greaterThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(IntegerValue)"})
  public void testGreaterThanWithIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThan(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(IntegerValue)"})
  public void testGreaterThanWithIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(IntegerValue)"})
  public void testGreaterThanWithIntegerValue_givenUnknownIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new UnknownIntegerValue()).greaterThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(ParticularIntegerValue)"})
  public void testGreaterThanWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(ParticularIntegerValue)"})
  public void testGreaterThanWithParticularIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(ParticularIntegerValue)"})
  public void testGreaterThanWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(RangeIntegerValue)"})
  public void testGreaterThanWithRangeIntegerValue_givenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(RangeIntegerValue)"})
  public void testGreaterThanWithRangeIntegerValue_givenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(RangeIntegerValue)"})
  public void testGreaterThanWithRangeIntegerValue_givenUnknownIntegerValue_thenReturnZero() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(SpecificIntegerValue)"})
  public void testGreaterThanWithSpecificIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThan(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(SpecificIntegerValue)"})
  public void testGreaterThanWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(SpecificIntegerValue)"})
  public void testGreaterThanWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0, unknownIntegerValue.greaterThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(UnknownIntegerValue)"})
  public void testGreaterThanWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(UnknownIntegerValue)"})
  public void testGreaterThanWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.greaterThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(UnknownIntegerValue)"})
  public void testGreaterThanWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThan(UnknownIntegerValue)"})
  public void testGreaterThanWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(IntegerValue)"})
  public void testGreaterThanOrEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .greaterThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(IntegerValue)"})
  public void testGreaterThanOrEqualWithIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(IntegerValue)"})
  public void testGreaterThanOrEqualWithIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(IntegerValue)"})
  public void testGreaterThanOrEqualWithIntegerValue_givenUnknownIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new UnknownIntegerValue()).greaterThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(ParticularIntegerValue)"})
  public void testGreaterThanOrEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(ParticularIntegerValue)"})
  public void testGreaterThanOrEqualWithParticularIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(
            new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(ParticularIntegerValue)"})
  public void testGreaterThanOrEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(RangeIntegerValue)"})
  public void testGreaterThanOrEqualWithRangeIntegerValue_givenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(RangeIntegerValue)"})
  public void testGreaterThanOrEqualWithRangeIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(RangeIntegerValue)"})
  public void testGreaterThanOrEqualWithRangeIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(SpecificIntegerValue)"})
  public void testGreaterThanOrEqualWithSpecificIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(SpecificIntegerValue)"})
  public void testGreaterThanOrEqualWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(SpecificIntegerValue)"})
  public void testGreaterThanOrEqualWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0,
        unknownIntegerValue.greaterThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(UnknownIntegerValue)"})
  public void testGreaterThanOrEqualWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(UnknownIntegerValue)"})
  public void testGreaterThanOrEqualWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0, ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(UnknownIntegerValue)"})
  public void testGreaterThanOrEqualWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(UnknownIntegerValue)"})
  public void testGreaterThanOrEqualWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#integerValue()}.
   *
   * <p>Method under test: {@link IntegerValue#integerValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue IntegerValue.integerValue()"})
  public void testIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.integerValue());
  }

  /**
   * Test {@link IntegerValue#computationalType()}.
   *
   * <p>Method under test: {@link IntegerValue#computationalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IntegerValue.computationalType()"})
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(1, (new UnknownIntegerValue()).computationalType());
  }

  /**
   * Test {@link IntegerValue#internalType()}.
   *
   * <p>Method under test: {@link IntegerValue#internalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String IntegerValue.internalType()"})
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("I", (new UnknownIntegerValue()).internalType());
  }
}
