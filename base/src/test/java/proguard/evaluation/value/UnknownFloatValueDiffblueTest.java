package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnknownFloatValueDiffblueTest {
  /**
   * Test {@link UnknownFloatValue#negate()}.
   *
   * <p>Method under test: {@link UnknownFloatValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.UnknownFloatValue.negate()"
  })
  void testNegate() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.negate());
  }

  /**
   * Test {@link UnknownFloatValue#convertToInteger()}.
   *
   * <p>Method under test: {@link UnknownFloatValue#convertToInteger()}
   */
  @Test
  @DisplayName("Test convertToInteger()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.UnknownFloatValue.convertToInteger()"
  })
  void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = (new UnknownFloatValue()).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof UnknownIntegerValue);
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertFalse(actualConvertToIntegerResult.isParticular());
    assertFalse(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Test {@link UnknownFloatValue#convertToLong()}.
   *
   * <p>Method under test: {@link UnknownFloatValue#convertToLong()}
   */
  @Test
  @DisplayName("Test convertToLong()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownFloatValue.convertToLong()"
  })
  void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new UnknownFloatValue()).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof UnknownLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertFalse(actualConvertToLongResult.isSpecific());
    assertTrue(actualConvertToLongResult.isCategory2());
  }

  /**
   * Test {@link UnknownFloatValue#convertToDouble()}.
   *
   * <p>Method under test: {@link UnknownFloatValue#convertToDouble()}
   */
  @Test
  @DisplayName("Test convertToDouble()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.UnknownFloatValue.convertToDouble()"
  })
  void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new UnknownFloatValue()).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof UnknownDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertFalse(actualConvertToDoubleResult.isSpecific());
    assertTrue(actualConvertToDoubleResult.isCategory2());
  }

  /**
   * Test {@link UnknownFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link UnknownFloatValue#generalize(FloatValue)}
   */
  @Test
  @DisplayName("Test generalize(FloatValue) with 'FloatValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.UnknownFloatValue.generalize(proguard.evaluation.value.FloatValue)"
  })
  void testGeneralizeWithFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.generalize(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link UnknownFloatValue#add(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link UnknownFloatValue#add(FloatValue)}
   */
  @Test
  @DisplayName("Test add(FloatValue) with 'FloatValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.UnknownFloatValue.add(proguard.evaluation.value.FloatValue)"
  })
  void testAddWithFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.add(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link UnknownFloatValue#subtract(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link UnknownFloatValue#subtract(FloatValue)}
   */
  @Test
  @DisplayName("Test subtract(FloatValue) with 'FloatValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.UnknownFloatValue.subtract(proguard.evaluation.value.FloatValue)"
  })
  void testSubtractWithFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.subtract(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link UnknownFloatValue#subtractFrom(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link UnknownFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(FloatValue) with 'FloatValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.UnknownFloatValue.subtractFrom(proguard.evaluation.value.FloatValue)"
  })
  void testSubtractFromWithFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.subtractFrom(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link UnknownFloatValue#multiply(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link UnknownFloatValue#multiply(FloatValue)}
   */
  @Test
  @DisplayName("Test multiply(FloatValue) with 'FloatValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.UnknownFloatValue.multiply(proguard.evaluation.value.FloatValue)"
  })
  void testMultiplyWithFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.multiply(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link UnknownFloatValue#divide(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link UnknownFloatValue#divide(FloatValue)}
   */
  @Test
  @DisplayName("Test divide(FloatValue) with 'FloatValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.UnknownFloatValue.divide(proguard.evaluation.value.FloatValue)"
  })
  void testDivideWithFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.divide(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link UnknownFloatValue#divideOf(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link UnknownFloatValue#divideOf(FloatValue)}
   */
  @Test
  @DisplayName("Test divideOf(FloatValue) with 'FloatValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.UnknownFloatValue.divideOf(proguard.evaluation.value.FloatValue)"
  })
  void testDivideOfWithFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.divideOf(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link UnknownFloatValue#remainder(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link UnknownFloatValue#remainder(FloatValue)}
   */
  @Test
  @DisplayName("Test remainder(FloatValue) with 'FloatValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.UnknownFloatValue.remainder(proguard.evaluation.value.FloatValue)"
  })
  void testRemainderWithFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.remainder(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link UnknownFloatValue#remainderOf(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link UnknownFloatValue#remainderOf(FloatValue)}
   */
  @Test
  @DisplayName("Test remainderOf(FloatValue) with 'FloatValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.UnknownFloatValue.remainderOf(proguard.evaluation.value.FloatValue)"
  })
  void testRemainderOfWithFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.remainderOf(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link UnknownFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link UnknownFloatValue#compare(FloatValue)}
   */
  @Test
  @DisplayName("Test compare(FloatValue) with 'FloatValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.UnknownFloatValue.compare(proguard.evaluation.value.FloatValue)"
  })
  void testCompareWithFloatValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new UnknownFloatValue()).compare(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link UnknownFloatValue#equals(Object)}, and {@link UnknownFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownFloatValue#equals(Object)}
   *   <li>{@link UnknownFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownFloatValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();
    UnknownFloatValue unknownFloatValue2 = new UnknownFloatValue();

    // Act and Assert
    assertEquals(unknownFloatValue, unknownFloatValue2);
    int expectedHashCodeResult = unknownFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownFloatValue2.hashCode());
  }

  /**
   * Test {@link UnknownFloatValue#equals(Object)}, and {@link UnknownFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownFloatValue#equals(Object)}
   *   <li>{@link UnknownFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownFloatValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertEquals(unknownFloatValue, unknownFloatValue);
    int expectedHashCodeResult = unknownFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownFloatValue.hashCode());
  }

  /**
   * Test {@link UnknownFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownFloatValue(), 1);
  }

  /**
   * Test {@link UnknownFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownFloatValue(), null);
  }

  /**
   * Test {@link UnknownFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownFloatValue(), "Different type to UnknownFloatValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownFloatValue}
   *   <li>{@link UnknownFloatValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.UnknownFloatValue.<init>()",
    "java.lang.String proguard.evaluation.value.UnknownFloatValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("f", (new UnknownFloatValue()).toString());
  }
}
