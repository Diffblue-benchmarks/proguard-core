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

public class UnknownDoubleValueDiffblueTest {
  /**
   * Test {@link UnknownDoubleValue#negate()}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.negate()"})
  public void testNegate() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.negate());
  }

  /**
   * Test {@link UnknownDoubleValue#convertToInteger()}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#convertToInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownDoubleValue.convertToInteger()"})
  public void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = (new UnknownDoubleValue()).convertToInteger();

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownDoubleValue.convertToLong()"})
  public void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new UnknownDoubleValue()).convertToLong();

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownDoubleValue.convertToFloat()"})
  public void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new UnknownDoubleValue()).convertToFloat();

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.generalize(DoubleValue)"})
  public void testGeneralizeWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.generalize(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link UnknownDoubleValue#add(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#add(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.add(DoubleValue)"})
  public void testAddWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.add(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link UnknownDoubleValue#subtract(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#subtract(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.subtract(DoubleValue)"})
  public void testSubtractWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.subtract(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link UnknownDoubleValue#subtractFrom(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.subtractFrom(DoubleValue)"})
  public void testSubtractFromWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.subtractFrom(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link UnknownDoubleValue#multiply(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#multiply(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.multiply(DoubleValue)"})
  public void testMultiplyWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.multiply(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link UnknownDoubleValue#divide(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#divide(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.divide(DoubleValue)"})
  public void testDivideWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.divide(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link UnknownDoubleValue#divideOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.divideOf(DoubleValue)"})
  public void testDivideOfWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.divideOf(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link UnknownDoubleValue#remainder(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#remainder(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.remainder(DoubleValue)"})
  public void testRemainderWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.remainder(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link UnknownDoubleValue#remainderOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownDoubleValue.remainderOf(DoubleValue)"})
  public void testRemainderOfWithDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act and Assert
    assertSame(unknownDoubleValue, unknownDoubleValue.remainderOf(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link UnknownDoubleValue#compare(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link UnknownDoubleValue#compare(DoubleValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownDoubleValue.compare(DoubleValue)"})
  public void testCompareWithDoubleValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new UnknownDoubleValue()).compare(BasicValueFactory.DOUBLE_VALUE);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownDoubleValue.equals(Object)",
    "int UnknownDoubleValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();
    UnknownDoubleValue unknownDoubleValue2 = new UnknownDoubleValue();

    // Act and Assert
    assertEquals(unknownDoubleValue, unknownDoubleValue2);
    int expectedHashCodeResult = unknownDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownDoubleValue2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownDoubleValue.equals(Object)",
    "int UnknownDoubleValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownDoubleValue.equals(Object)",
    "int UnknownDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownDoubleValue.equals(Object)",
    "int UnknownDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownDoubleValue.equals(Object)",
    "int UnknownDoubleValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnknownDoubleValue.<init>()",
    "java.lang.String UnknownDoubleValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("d", (new UnknownDoubleValue()).toString());
  }
}
