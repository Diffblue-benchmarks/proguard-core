package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NegatedIntegerValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedIntegerValue#NegatedIntegerValue(IntegerValue)}
   *   <li>{@link NegatedIntegerValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NegatedIntegerValue.<init>(IntegerValue)",
    "java.lang.String NegatedIntegerValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "-b", (new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }

  /**
   * Test {@link NegatedIntegerValue#negate()}.
   *
   * <p>Method under test: {@link NegatedIntegerValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue NegatedIntegerValue.negate()"})
  public void testNegate() {
    // Arrange and Act
    IntegerValue actualNegateResult =
        (new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof RangeIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}, and {@link NegatedIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedIntegerValue#equals(Object)}
   *   <li>{@link NegatedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedIntegerValue.equals(Object)",
    "int NegatedIntegerValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue =
        new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    NegatedIntegerValue negatedIntegerValue2 =
        new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(negatedIntegerValue, negatedIntegerValue2);
    int expectedHashCodeResult = negatedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedIntegerValue2.hashCode());
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}, and {@link NegatedIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedIntegerValue#equals(Object)}
   *   <li>{@link NegatedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedIntegerValue.equals(Object)",
    "int NegatedIntegerValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue =
        new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(negatedIntegerValue, negatedIntegerValue);
    int expectedHashCodeResult = negatedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedIntegerValue.hashCode());
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedIntegerValue.equals(Object)",
    "int NegatedIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue =
        new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        negatedIntegerValue, new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedIntegerValue.equals(Object)",
    "int NegatedIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue =
        new NegatedIntegerValue(new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(
        negatedIntegerValue, new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedIntegerValue.equals(Object)",
    "int NegatedIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NegatedIntegerValue.equals(Object)",
    "int NegatedIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to NegatedIntegerValue");
  }
}
