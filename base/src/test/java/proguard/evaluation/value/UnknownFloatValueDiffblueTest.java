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

public class UnknownFloatValueDiffblueTest {
  /**
   * Test {@link UnknownFloatValue#negate()}.
   *
   * <p>Method under test: {@link UnknownFloatValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownFloatValue.negate()"})
  public void testNegate() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownFloatValue.convertToInteger()"})
  public void testConvertToInteger() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownFloatValue.convertToLong()"})
  public void testConvertToLong() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownFloatValue.convertToDouble()"})
  public void testConvertToDouble() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownFloatValue.generalize(FloatValue)"})
  public void testGeneralizeWithFloatValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownFloatValue.add(FloatValue)"})
  public void testAddWithFloatValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownFloatValue.subtract(FloatValue)"})
  public void testSubtractWithFloatValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownFloatValue.subtractFrom(FloatValue)"})
  public void testSubtractFromWithFloatValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownFloatValue.multiply(FloatValue)"})
  public void testMultiplyWithFloatValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownFloatValue.divide(FloatValue)"})
  public void testDivideWithFloatValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownFloatValue.divideOf(FloatValue)"})
  public void testDivideOfWithFloatValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownFloatValue.remainder(FloatValue)"})
  public void testRemainderWithFloatValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownFloatValue.remainderOf(FloatValue)"})
  public void testRemainderOfWithFloatValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownFloatValue.compare(FloatValue)"})
  public void testCompareWithFloatValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownFloatValue.equals(Object)",
    "int UnknownFloatValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownFloatValue.equals(Object)",
    "int UnknownFloatValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownFloatValue.equals(Object)",
    "int UnknownFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownFloatValue.equals(Object)",
    "int UnknownFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownFloatValue.equals(Object)",
    "int UnknownFloatValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnknownFloatValue.<init>()",
    "java.lang.String UnknownFloatValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("f", (new UnknownFloatValue()).toString());
  }
}
