package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LongValueDiffblueTest {
  /**
   * Test {@link LongValue#value()}.
   *
   * <p>Method under test: {@link LongValue#value()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long LongValue.value()"})
  public void testValue() {
    // Arrange, Act and Assert
    assertEquals(0L, (new UnknownLongValue()).value());
  }

  /**
   * Test {@link LongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.generalize(LongValue)"})
  public void testGeneralizeWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other));
  }

  /**
   * Test {@link LongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.generalize(LongValue)"})
  public void testGeneralizeWithLongValue_givenLong_value_0_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.generalize(other));
  }

  /**
   * Test {@link LongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.generalize(LongValue)"})
  public void testGeneralizeWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.generalize(other));
  }

  /**
   * Test {@link LongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.generalize(LongValue)"})
  public void testGeneralizeWithLongValue_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualGeneralizeResult =
        ParticularValueFactory.LONG_VALUE_0.generalize(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link LongValue#generalize(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.generalize(ParticularLongValue)"})
  public void testGeneralizeWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.generalize(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#generalize(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.generalize(ParticularLongValue)"})
  public void testGeneralizeWithParticularLongValue_thenReturnUnknownLongValue2() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualGeneralizeResult = compositeLongValue.generalize(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link LongValue#generalize(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#generalize(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.generalize(SpecificLongValue)"})
  public void testGeneralizeWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue,
        unknownLongValue.generalize((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#UNKNOWN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value LongValue.generalize(Value)"})
  public void testGeneralizeWithValue_givenLong_value_thenReturnUnknown_value() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.generalize(other));
  }

  /**
   * Test {@link LongValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value LongValue.generalize(Value)"})
  public void testGeneralizeWithValue_whenLong_value_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.generalize((Value) BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link LongValue#computationalType()}.
   *
   * <p>Method under test: {@link LongValue#computationalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LongValue.computationalType()"})
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(2, (new UnknownLongValue()).computationalType());
  }

  /**
   * Test {@link LongValue#internalType()}.
   *
   * <p>Method under test: {@link LongValue#internalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String LongValue.internalType()"})
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("J", (new UnknownLongValue()).internalType());
  }

  /**
   * Test {@link LongValue#add(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.add(LongValue)"})
  public void testAddWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .add(other));
  }

  /**
   * Test {@link LongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.add(LongValue)"})
  public void testAddWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.add(other));
  }

  /**
   * Test {@link LongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.add(LongValue)"})
  public void testAddWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.add(other));
  }

  /**
   * Test {@link LongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.add(LongValue)"})
  public void testAddWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualAddResult =
        ParticularValueFactory.LONG_VALUE_0.add(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link LongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.add(LongValue)"})
  public void testAddWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualAddResult = ParticularValueFactory.LONG_VALUE_0.add(other);

    // Assert
    assertTrue(actualAddResult instanceof ParticularLongValue);
    assertEquals(other, actualAddResult);
  }

  /**
   * Test {@link LongValue#add(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.add(ParticularLongValue)"})
  public void testAddWithParticularLongValue_givenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualAddResult = ParticularValueFactory.LONG_VALUE_0.add(other);

    // Assert
    assertTrue(actualAddResult instanceof ParticularLongValue);
    assertEquals(other, actualAddResult);
  }

  /**
   * Test {@link LongValue#add(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.add(ParticularLongValue)"})
  public void testAddWithParticularLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.add(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#add(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.add(ParticularLongValue)"})
  public void testAddWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualAddResult = compositeLongValue.add(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link LongValue#add(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#add(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.add(SpecificLongValue)"})
  public void testAddWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue, unknownLongValue.add((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtract(LongValue)"})
  public void testSubtractWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtract(other));
  }

  /**
   * Test {@link LongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtract(LongValue)"})
  public void testSubtractWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.subtract(other));
  }

  /**
   * Test {@link LongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtract(LongValue)"})
  public void testSubtractWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.subtract(other));
  }

  /**
   * Test {@link LongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtract(LongValue)"})
  public void testSubtractWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualSubtractResult =
        ParticularValueFactory.LONG_VALUE_0.subtract(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link LongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtract(LongValue)"})
  public void testSubtractWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualSubtractResult = ParticularValueFactory.LONG_VALUE_0.subtract(other);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(other, actualSubtractResult);
  }

  /**
   * Test {@link LongValue#subtract(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtract(ParticularLongValue)"})
  public void testSubtractWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualSubtractResult = compositeLongValue.subtract(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link LongValue#subtract(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtract(ParticularLongValue)"})
  public void testSubtractWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange and Act
    LongValue actualSubtractResult =
        ParticularValueFactory.LONG_VALUE_0.subtract(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(-42L, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link LongValue#subtract(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtract(ParticularLongValue)"})
  public void testSubtractWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.subtract(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#subtract(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#subtract(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtract(SpecificLongValue)"})
  public void testSubtractWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue,
        unknownLongValue.subtract((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(LongValue)"})
  public void testSubtractFromWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtractFrom(other));
  }

  /**
   * Test {@link LongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(LongValue)"})
  public void testSubtractFromWithLongValue_givenLong_value_0_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.subtractFrom(other));
  }

  /**
   * Test {@link LongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(LongValue)"})
  public void testSubtractFromWithLongValue_givenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.subtractFrom(other));
  }

  /**
   * Test {@link LongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(LongValue)"})
  public void testSubtractFromWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualSubtractFromResult =
        ParticularValueFactory.LONG_VALUE_0.subtractFrom(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link LongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(LongValue)"})
  public void testSubtractFromWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualSubtractFromResult = ParticularValueFactory.LONG_VALUE_0.subtractFrom(other);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(other, actualSubtractFromResult);
  }

  /**
   * Test {@link LongValue#subtractFrom(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(ParticularLongValue)"})
  public void testSubtractFromWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualSubtractFromResult =
        compositeLongValue.subtractFrom(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link LongValue#subtractFrom(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(ParticularLongValue)"})
  public void testSubtractFromWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractFromResult = ParticularValueFactory.LONG_VALUE_0.subtractFrom(other);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(other, actualSubtractFromResult);
  }

  /**
   * Test {@link LongValue#subtractFrom(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(ParticularLongValue)"})
  public void testSubtractFromWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.subtractFrom(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#subtractFrom(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(SpecificLongValue)"})
  public void testSubtractFromWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue,
        unknownLongValue.subtractFrom((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.multiply(LongValue)"})
  public void testMultiplyWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .multiply(other));
  }

  /**
   * Test {@link LongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.multiply(LongValue)"})
  public void testMultiplyWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.multiply(other));
  }

  /**
   * Test {@link LongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.multiply(LongValue)"})
  public void testMultiplyWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.multiply(other));
  }

  /**
   * Test {@link LongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.multiply(LongValue)"})
  public void testMultiplyWithLongValue_thenReturnCompositeLongValue() throws ArithmeticException {
    // Arrange and Act
    LongValue actualMultiplyResult =
        ParticularValueFactory.LONG_VALUE_0.multiply(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link LongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.multiply(LongValue)"})
  public void testMultiplyWithLongValue_whenLong_value_0_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualMultiplyResult = ParticularValueFactory.LONG_VALUE_0.multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularLongValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Test {@link LongValue#multiply(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.multiply(ParticularLongValue)"})
  public void testMultiplyWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualMultiplyResult = compositeLongValue.multiply(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link LongValue#multiply(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.multiply(ParticularLongValue)"})
  public void testMultiplyWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualMultiplyResult = longValue.multiply(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularLongValue);
    assertEquals(longValue, actualMultiplyResult);
  }

  /**
   * Test {@link LongValue#multiply(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.multiply(ParticularLongValue)"})
  public void testMultiplyWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.multiply(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#multiply(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#multiply(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.multiply(SpecificLongValue)"})
  public void testMultiplyWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue,
        unknownLongValue.multiply((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divide(LongValue)"})
  public void testDivideWithLongValue() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divide(other));
  }

  /**
   * Test {@link LongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divide(LongValue)"})
  public void testDivideWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.divide(other));
  }

  /**
   * Test {@link LongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divide(LongValue)"})
  public void testDivideWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.divide(other));
  }

  /**
   * Test {@link LongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divide(LongValue)"})
  public void testDivideWithLongValue_thenReturnCompositeLongValue() throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideResult =
        ParticularValueFactory.LONG_VALUE_0.divide(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link LongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_1}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divide(LongValue)"})
  public void testDivideWithLongValue_whenLong_value_1_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualDivideResult = longValue.divide(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularLongValue);
    assertEquals(longValue, actualDivideResult);
  }

  /**
   * Test {@link LongValue#divide(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divide(ParticularLongValue)"})
  public void testDivideWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualDivideResult = compositeLongValue.divide(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link LongValue#divide(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divide(ParticularLongValue)"})
  public void testDivideWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualDivideResult = longValue.divide(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularLongValue);
    assertEquals(longValue, actualDivideResult);
  }

  /**
   * Test {@link LongValue#divide(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divide(ParticularLongValue)"})
  public void testDivideWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.divide(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#divide(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#divide(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divide(SpecificLongValue)"})
  public void testDivideWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue,
        unknownLongValue.divide((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divideOf(LongValue)"})
  public void testDivideOfWithLongValue() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divideOf(other));
  }

  /**
   * Test {@link LongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divideOf(LongValue)"})
  public void testDivideOfWithLongValue2() throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideOfResult =
        ParticularValueFactory.LONG_VALUE_0.divideOf(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divideOf(LongValue)"})
  public void testDivideOfWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.divideOf(other));
  }

  /**
   * Test {@link LongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divideOf(LongValue)"})
  public void testDivideOfWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.divideOf(other));
  }

  /**
   * Test {@link LongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divideOf(LongValue)"})
  public void testDivideOfWithLongValue_whenLong_value_0_thenReturnCompositeLongValue()
      throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideOfResult =
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divideOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#divideOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divideOf(ParticularLongValue)"})
  public void testDivideOfWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualDivideOfResult = compositeLongValue.divideOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#divideOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divideOf(ParticularLongValue)"})
  public void testDivideOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideOfResult = ParticularValueFactory.LONG_VALUE_1.divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularLongValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Test {@link LongValue#divideOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divideOf(ParticularLongValue)"})
  public void testDivideOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.divideOf(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#divideOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#divideOf(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.divideOf(SpecificLongValue)"})
  public void testDivideOfWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue,
        unknownLongValue.divideOf((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainder(LongValue)"})
  public void testRemainderWithLongValue() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainder(other));
  }

  /**
   * Test {@link LongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainder(LongValue)"})
  public void testRemainderWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.remainder(other));
  }

  /**
   * Test {@link LongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainder(LongValue)"})
  public void testRemainderWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.remainder(other));
  }

  /**
   * Test {@link LongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainder(LongValue)"})
  public void testRemainderWithLongValue_thenReturnCompositeLongValue() throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderResult =
        ParticularValueFactory.LONG_VALUE_0.remainder(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_1}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainder(LongValue)"})
  public void testRemainderWithLongValue_whenLong_value_1_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualRemainderResult = longValue.remainder(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularLongValue);
    assertEquals(longValue, actualRemainderResult);
  }

  /**
   * Test {@link LongValue#remainder(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainder(ParticularLongValue)"})
  public void testRemainderWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualRemainderResult = compositeLongValue.remainder(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainder(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainder(ParticularLongValue)"})
  public void testRemainderWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualRemainderResult = longValue.remainder(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularLongValue);
    assertEquals(longValue, actualRemainderResult);
  }

  /**
   * Test {@link LongValue#remainder(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainder(ParticularLongValue)"})
  public void testRemainderWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.remainder(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#remainder(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#remainder(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainder(SpecificLongValue)"})
  public void testRemainderWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue,
        unknownLongValue.remainder((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainderOf(LongValue)"})
  public void testRemainderOfWithLongValue() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainderOf(other));
  }

  /**
   * Test {@link LongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainderOf(LongValue)"})
  public void testRemainderOfWithLongValue2() throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderOfResult =
        ParticularValueFactory.LONG_VALUE_0.remainderOf(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainderOf(LongValue)"})
  public void testRemainderOfWithLongValue_givenLong_value_0_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.remainderOf(other));
  }

  /**
   * Test {@link LongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainderOf(LongValue)"})
  public void testRemainderOfWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.remainderOf(other));
  }

  /**
   * Test {@link LongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainderOf(LongValue)"})
  public void testRemainderOfWithLongValue_whenLong_value_0_thenReturnCompositeLongValue()
      throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderOfResult =
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainderOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainderOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainderOf(ParticularLongValue)"})
  public void testRemainderOfWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualRemainderOfResult =
        compositeLongValue.remainderOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainderOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainderOf(ParticularLongValue)"})
  public void testRemainderOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange and Act
    LongValue actualRemainderOfResult =
        ParticularValueFactory.LONG_VALUE_1.remainderOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularLongValue);
    assertEquals(0L, actualRemainderOfResult.value());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainderOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainderOf(ParticularLongValue)"})
  public void testRemainderOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.remainderOf(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#remainderOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#remainderOf(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.remainderOf(SpecificLongValue)"})
  public void testRemainderOfWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue,
        unknownLongValue.remainderOf((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        ParticularValueFactory.LONG_VALUE_0.shiftLeft(
            new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue_givenLong_value_0_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        ParticularValueFactory.LONG_VALUE_0.shiftLeft(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Test {@link LongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue_givenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue longValue = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(longValue, longValue.shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link LongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue_whenInteger_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue_whenInteger_value_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftLeft(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Test {@link LongValue#shiftLeft(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(ParticularIntegerValue)"})
  public void testShiftLeftWithParticularIntegerValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftLeftResult = compositeLongValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftLeft(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(ParticularIntegerValue)"})
  public void testShiftLeftWithParticularIntegerValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftLeftResult = longValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularLongValue);
    assertEquals(longValue, actualShiftLeftResult);
  }

  /**
   * Test {@link LongValue#shiftLeft(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(ParticularIntegerValue)"})
  public void testShiftLeftWithParticularIntegerValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.shiftLeft(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link LongValue#shiftLeft(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#shiftLeft(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(SpecificLongValue)"})
  public void testShiftLeftWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.shiftLeft(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        ParticularValueFactory.LONG_VALUE_0.shiftRight(
            new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue_givenLong_value_0_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        ParticularValueFactory.LONG_VALUE_0.shiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Test {@link LongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue_givenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue longValue = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(longValue, longValue.shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link LongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue_whenInteger_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue_whenInteger_value_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Test {@link LongValue#shiftRight(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftRight(ParticularIntegerValue)"})
  public void testShiftRightWithParticularIntegerValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftRightResult =
        compositeLongValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftRight(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftRight(ParticularIntegerValue)"})
  public void testShiftRightWithParticularIntegerValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftRightResult = longValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof ParticularLongValue);
    assertEquals(longValue, actualShiftRightResult);
  }

  /**
   * Test {@link LongValue#shiftRight(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftRight(ParticularIntegerValue)"})
  public void testShiftRightWithParticularIntegerValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.shiftRight(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link LongValue#shiftRight(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#shiftRight(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.shiftRight(SpecificLongValue)"})
  public void testShiftRightWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.shiftRight(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        ParticularValueFactory.LONG_VALUE_0.unsignedShiftRight(
            new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue_givenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue longValue = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(longValue, longValue.unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue_thenReturnUnknownLongValue2() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        ParticularValueFactory.LONG_VALUE_0.unsignedShiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(ParticularIntegerValue)"})
  public void testUnsignedShiftRightWithParticularIntegerValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualUnsignedShiftRightResult =
        compositeLongValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(ParticularIntegerValue)"})
  public void testUnsignedShiftRightWithParticularIntegerValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualUnsignedShiftRightResult =
        longValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof ParticularLongValue);
    assertEquals(longValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(ParticularIntegerValue)"})
  public void testUnsignedShiftRightWithParticularIntegerValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue, unknownLongValue.unsignedShiftRight(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(SpecificLongValue)"})
  public void testUnsignedShiftRightWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.unsignedShiftRight(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#and(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.and(LongValue)"})
  public void testAndWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .and(other));
  }

  /**
   * Test {@link LongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.and(LongValue)"})
  public void testAndWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.and(other));
  }

  /**
   * Test {@link LongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.and(LongValue)"})
  public void testAndWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.and(other));
  }

  /**
   * Test {@link LongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.and(LongValue)"})
  public void testAndWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualAndResult =
        ParticularValueFactory.LONG_VALUE_0.and(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link LongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.and(LongValue)"})
  public void testAndWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualAndResult = ParticularValueFactory.LONG_VALUE_0.and(other);

    // Assert
    assertTrue(actualAndResult instanceof ParticularLongValue);
    assertEquals(other, actualAndResult);
  }

  /**
   * Test {@link LongValue#and(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.and(ParticularLongValue)"})
  public void testAndWithParticularLongValue_givenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualAndResult = longValue.and(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAndResult instanceof ParticularLongValue);
    assertEquals(longValue, actualAndResult);
  }

  /**
   * Test {@link LongValue#and(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.and(ParticularLongValue)"})
  public void testAndWithParticularLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.and(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#and(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.and(ParticularLongValue)"})
  public void testAndWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualAndResult = compositeLongValue.and(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link LongValue#and(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#and(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.and(SpecificLongValue)"})
  public void testAndWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue, unknownLongValue.and((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#or(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.or(LongValue)"})
  public void testOrWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .or(other));
  }

  /**
   * Test {@link LongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.or(LongValue)"})
  public void testOrWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.or(other));
  }

  /**
   * Test {@link LongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.or(LongValue)"})
  public void testOrWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.or(other));
  }

  /**
   * Test {@link LongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.or(LongValue)"})
  public void testOrWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualOrResult =
        ParticularValueFactory.LONG_VALUE_0.or(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link LongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.or(LongValue)"})
  public void testOrWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualOrResult = ParticularValueFactory.LONG_VALUE_0.or(other);

    // Assert
    assertTrue(actualOrResult instanceof ParticularLongValue);
    assertEquals(other, actualOrResult);
  }

  /**
   * Test {@link LongValue#or(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.or(ParticularLongValue)"})
  public void testOrWithParticularLongValue_givenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualOrResult = ParticularValueFactory.LONG_VALUE_0.or(other);

    // Assert
    assertTrue(actualOrResult instanceof ParticularLongValue);
    assertEquals(other, actualOrResult);
  }

  /**
   * Test {@link LongValue#or(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.or(ParticularLongValue)"})
  public void testOrWithParticularLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.or(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#or(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.or(ParticularLongValue)"})
  public void testOrWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualOrResult = compositeLongValue.or(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link LongValue#or(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#or(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.or(SpecificLongValue)"})
  public void testOrWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue, unknownLongValue.or((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.xor(LongValue)"})
  public void testXorWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .xor(other));
  }

  /**
   * Test {@link LongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.xor(LongValue)"})
  public void testXorWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, ParticularValueFactory.LONG_VALUE_0.xor(other));
  }

  /**
   * Test {@link LongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.xor(LongValue)"})
  public void testXorWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.LONG_VALUE.xor(other));
  }

  /**
   * Test {@link LongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.xor(LongValue)"})
  public void testXorWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualXorResult =
        ParticularValueFactory.LONG_VALUE_0.xor(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link LongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.xor(LongValue)"})
  public void testXorWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualXorResult = ParticularValueFactory.LONG_VALUE_0.xor(other);

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(other, actualXorResult);
  }

  /**
   * Test {@link LongValue#xor(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.xor(ParticularLongValue)"})
  public void testXorWithParticularLongValue_givenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult = ParticularValueFactory.LONG_VALUE_0.xor(other);

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(other, actualXorResult);
  }

  /**
   * Test {@link LongValue#xor(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.xor(ParticularLongValue)"})
  public void testXorWithParticularLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.xor(new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#xor(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.xor(ParticularLongValue)"})
  public void testXorWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualXorResult = compositeLongValue.xor(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link LongValue#xor(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#xor(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.xor(SpecificLongValue)"})
  public void testXorWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue, unknownLongValue.xor((SpecificLongValue) new ParticularLongValue(42L)));
  }

  /**
   * Test {@link LongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compare(LongValue)"})
  public void testCompareWithLongValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compare(LongValue)"})
  public void testCompareWithLongValue2() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .compare(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compare(LongValue)"})
  public void testCompareWithLongValue_givenLong_value_0_whenLong_value() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        ParticularValueFactory.LONG_VALUE_0.compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compare(LongValue)"})
  public void testCompareWithLongValue_givenLong_value_0_whenLong_value_0() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        ParticularValueFactory.LONG_VALUE_0.compare(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compare(LongValue)"})
  public void testCompareWithLongValue_givenLong_value_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        BasicValueFactory.LONG_VALUE.compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compare(ParticularLongValue)"})
  public void testCompareWithParticularLongValue_givenLong_value_0() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        ParticularValueFactory.LONG_VALUE_0.compare(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compare(ParticularLongValue)"})
  public void testCompareWithParticularLongValue_givenUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareResult = unknownLongValue.compare(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#compare(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compare(SpecificLongValue)"})
  public void testCompareWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareResult =
        unknownLongValue.compare((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#compareReverse(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(LongValue)"})
  public void testCompareReverseWithLongValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        (new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .compareReverse(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof ComparisonValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ComparisonValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compareReverse(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(LongValue)"})
  public void testCompareReverseWithLongValue_givenLong_value_0_thenReturnComparisonValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.LONG_VALUE_0.compareReverse(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof ComparisonValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compareReverse(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(LongValue)"})
  public void testCompareReverseWithLongValue_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        (new UnknownLongValue()).compareReverse(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compareReverse(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(ParticularLongValue)"})
  public void testCompareReverseWithParticularLongValue_givenLong_value_0() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.LONG_VALUE_0.compareReverse(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareReverseResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compareReverse(ParticularLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(ParticularLongValue)"})
  public void testCompareReverseWithParticularLongValue_givenUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareReverseResult =
        unknownLongValue.compareReverse(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareReverseResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#compareReverse(SpecificLongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(SpecificLongValue)"})
  public void testCompareReverseWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareReverseResult =
        unknownLongValue.compareReverse((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareReverseResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#longValue()}.
   *
   * <p>Method under test: {@link LongValue#longValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue LongValue.longValue()"})
  public void testLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.longValue());
  }
}
