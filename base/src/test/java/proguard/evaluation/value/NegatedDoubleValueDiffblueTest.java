package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NegatedDoubleValueDiffblueTest {
  /**
   * Method under test: {@link NegatedDoubleValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    DoubleValue actualNegateResult = (new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof UnknownDoubleValue);
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
    assertTrue(actualNegateResult.isCategory2());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedDoubleValue#equals(Object)}
   *   <li>{@link NegatedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue = new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE);
    NegatedDoubleValue negatedDoubleValue2 = new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(negatedDoubleValue, negatedDoubleValue2);
    int expectedHashCodeResult = negatedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedDoubleValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedDoubleValue#equals(Object)}
   *   <li>{@link NegatedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue = new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(negatedDoubleValue, negatedDoubleValue);
    int expectedHashCodeResult = negatedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedDoubleValue.hashCode());
  }

  /**
   * Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue = new NegatedDoubleValue(ParticularValueFactory.DOUBLE_VALUE_0);

    // Act and Assert
    assertNotEquals(negatedDoubleValue, new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue = new NegatedDoubleValue(
        new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE));

    // Act and Assert
    assertNotEquals(negatedDoubleValue, new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE), null);
  }

  /**
   * Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE), "Different type to NegatedDoubleValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedDoubleValue#NegatedDoubleValue(DoubleValue)}
   *   <li>{@link NegatedDoubleValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("-d", (new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE)).toString());
  }
}
