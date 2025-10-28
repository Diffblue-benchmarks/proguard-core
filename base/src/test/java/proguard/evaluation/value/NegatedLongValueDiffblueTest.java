package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NegatedLongValueDiffblueTest {
  /**
   * Method under test: {@link NegatedLongValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    LongValue actualNegateResult = (new NegatedLongValue(BasicValueFactory.LONG_VALUE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof UnknownLongValue);
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
    assertTrue(actualNegateResult.isCategory2());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedLongValue#equals(Object)}
   *   <li>{@link NegatedLongValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NegatedLongValue negatedLongValue = new NegatedLongValue(BasicValueFactory.LONG_VALUE);
    NegatedLongValue negatedLongValue2 = new NegatedLongValue(BasicValueFactory.LONG_VALUE);

    // Act and Assert
    assertEquals(negatedLongValue, negatedLongValue2);
    int expectedHashCodeResult = negatedLongValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedLongValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedLongValue#equals(Object)}
   *   <li>{@link NegatedLongValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NegatedLongValue negatedLongValue = new NegatedLongValue(BasicValueFactory.LONG_VALUE);

    // Act and Assert
    assertEquals(negatedLongValue, negatedLongValue);
    int expectedHashCodeResult = negatedLongValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedLongValue.hashCode());
  }

  /**
   * Method under test: {@link NegatedLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NegatedLongValue negatedLongValue = new NegatedLongValue(ParticularValueFactory.LONG_VALUE_0);

    // Act and Assert
    assertNotEquals(negatedLongValue, new NegatedLongValue(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link NegatedLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NegatedLongValue negatedLongValue = new NegatedLongValue(new NegatedLongValue(BasicValueFactory.LONG_VALUE));

    // Act and Assert
    assertNotEquals(negatedLongValue, new NegatedLongValue(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link NegatedLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedLongValue(BasicValueFactory.LONG_VALUE), null);
  }

  /**
   * Method under test: {@link NegatedLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedLongValue(BasicValueFactory.LONG_VALUE), "Different type to NegatedLongValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedLongValue#NegatedLongValue(LongValue)}
   *   <li>{@link NegatedLongValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("-l", (new NegatedLongValue(BasicValueFactory.LONG_VALUE)).toString());
  }
}
