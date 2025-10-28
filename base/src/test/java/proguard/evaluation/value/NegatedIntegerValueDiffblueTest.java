package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NegatedIntegerValueDiffblueTest {
  /**
   * Method under test: {@link NegatedIntegerValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    IntegerValue actualNegateResult = (new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof RangeIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedIntegerValue#equals(Object)}
   *   <li>{@link NegatedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue = new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    NegatedIntegerValue negatedIntegerValue2 = new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(negatedIntegerValue, negatedIntegerValue2);
    int expectedHashCodeResult = negatedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedIntegerValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedIntegerValue#equals(Object)}
   *   <li>{@link NegatedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue = new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(negatedIntegerValue, negatedIntegerValue);
    int expectedHashCodeResult = negatedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedIntegerValue.hashCode());
  }

  /**
   * Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue = new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(negatedIntegerValue, new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue = new NegatedIntegerValue(
        new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(negatedIntegerValue, new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to NegatedIntegerValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedIntegerValue#NegatedIntegerValue(IntegerValue)}
   *   <li>{@link NegatedIntegerValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("-b", (new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }
}
