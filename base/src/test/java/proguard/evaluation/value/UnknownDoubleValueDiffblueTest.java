package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnknownDoubleValueDiffblueTest {
  /**
   * Test {@link UnknownDoubleValue#negate()}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.negate()"})
  void testNegate() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualNegateResult = unknownDoubleValue.negate();

    // Assert
    assertSame(unknownDoubleValue, actualNegateResult);
  }

  /**
   * Test {@link UnknownDoubleValue#convertToInteger()}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#convertToInteger()}
   */
  @Test
  @DisplayName("Test convertToInteger()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownDoubleValue.convertToInteger()"})
  void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = new UnknownDoubleValue().convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof UnknownIntegerValue);
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertFalse(actualConvertToIntegerResult.isParticular());
    assertFalse(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Test {@link UnknownDoubleValue#convertToLong()}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#convertToLong()}
   */
  @Test
  @DisplayName("Test convertToLong()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownDoubleValue.convertToLong()"})
  void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = new UnknownDoubleValue().convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof UnknownLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertFalse(actualConvertToLongResult.isSpecific());
    assertTrue(actualConvertToLongResult.isCategory2());
  }

  /**
   * Test {@link UnknownDoubleValue#convertToFloat()}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#convertToFloat()}
   */
  @Test
  @DisplayName("Test convertToFloat()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue UnknownDoubleValue.convertToFloat()"})
  void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = new UnknownDoubleValue().convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof UnknownFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertFalse(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Test {@link UnknownDoubleValue#generalize(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#generalize(DoubleValue)}
   */
  @Test
  @DisplayName("Test generalize(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.generalize(DoubleValue)"})
  void testGeneralizeWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualGeneralizeResult =
        unknownDoubleValue.generalize(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertSame(unknownDoubleValue, actualGeneralizeResult);
  }

  /**
   * Test {@link UnknownDoubleValue#add(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#add(DoubleValue)}
   */
  @Test
  @DisplayName("Test add(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.add(DoubleValue)"})
  void testAddWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualAddResult = unknownDoubleValue.add(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertSame(unknownDoubleValue, actualAddResult);
  }

  /**
   * Test {@link UnknownDoubleValue#subtract(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#subtract(DoubleValue)}
   */
  @Test
  @DisplayName("Test subtract(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.subtract(DoubleValue)"})
  void testSubtractWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualSubtractResult = unknownDoubleValue.subtract(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertSame(unknownDoubleValue, actualSubtractResult);
  }

  /**
   * Test {@link UnknownDoubleValue#subtractFrom(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.subtractFrom(DoubleValue)"})
  void testSubtractFromWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualSubtractFromResult =
        unknownDoubleValue.subtractFrom(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertSame(unknownDoubleValue, actualSubtractFromResult);
  }

  /**
   * Test {@link UnknownDoubleValue#multiply(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#multiply(DoubleValue)}
   */
  @Test
  @DisplayName("Test multiply(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.multiply(DoubleValue)"})
  void testMultiplyWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualMultiplyResult = unknownDoubleValue.multiply(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertSame(unknownDoubleValue, actualMultiplyResult);
  }

  /**
   * Test {@link UnknownDoubleValue#divide(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#divide(DoubleValue)}
   */
  @Test
  @DisplayName("Test divide(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.divide(DoubleValue)"})
  void testDivideWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualDivideResult = unknownDoubleValue.divide(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertSame(unknownDoubleValue, actualDivideResult);
  }

  /**
   * Test {@link UnknownDoubleValue#divideOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  @DisplayName("Test divideOf(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.divideOf(DoubleValue)"})
  void testDivideOfWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualDivideOfResult = unknownDoubleValue.divideOf(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertSame(unknownDoubleValue, actualDivideOfResult);
  }

  /**
   * Test {@link UnknownDoubleValue#remainder(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#remainder(DoubleValue)}
   */
  @Test
  @DisplayName("Test remainder(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.remainder(DoubleValue)"})
  void testRemainderWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualRemainderResult =
        unknownDoubleValue.remainder(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertSame(unknownDoubleValue, actualRemainderResult);
  }

  /**
   * Test {@link UnknownDoubleValue#remainderOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  @DisplayName("Test remainderOf(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.remainderOf(DoubleValue)"})
  void testRemainderOfWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualRemainderOfResult =
        unknownDoubleValue.remainderOf(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertSame(unknownDoubleValue, actualRemainderOfResult);
  }

  /**
   * Test {@link UnknownDoubleValue#compare(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#compare(DoubleValue)}
   */
  @Test
  @DisplayName("Test compare(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownDoubleValue.compare(DoubleValue)"})
  void testCompareWithDoubleValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        new UnknownDoubleValue().compare(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link UnknownDoubleValue#equals(Object)}, and {@link UnknownDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownDoubleValue#equals(Object)}
   *   <li>{@link UnknownDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UnknownDoubleValue.equals(Object)",
    "int UnknownDoubleValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();
    UnknownDoubleValue unknownDoubleValue2 = new UnknownDoubleValue();

    // Act and Assert
    assertEquals(unknownDoubleValue, unknownDoubleValue2);
    assertEquals(unknownDoubleValue.hashCode(), unknownDoubleValue2.hashCode());
  }

  /**
   * Test {@link UnknownDoubleValue#equals(Object)}, and {@link UnknownDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownDoubleValue#equals(Object)}
   *   <li>{@link UnknownDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UnknownDoubleValue.equals(Object)",
    "int UnknownDoubleValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertEquals(unknownDoubleValue, unknownDoubleValue);
    int expectedHashCodeResult = unknownDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownDoubleValue.hashCode());
  }

  /**
   * Test {@link UnknownDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UnknownDoubleValue.equals(Object)",
    "int UnknownDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownDoubleValue(), 1);
  }

  /**
   * Test {@link UnknownDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UnknownDoubleValue.equals(Object)",
    "int UnknownDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownDoubleValue(), null);
  }

  /**
   * Test {@link UnknownDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UnknownDoubleValue.equals(Object)",
    "int UnknownDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownDoubleValue(), "Different type to UnknownDoubleValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownDoubleValue}
   *   <li>{@link UnknownDoubleValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnknownDoubleValue.<init>()",
    "java.lang.String UnknownDoubleValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("d", new UnknownDoubleValue().toString());
  }
}
