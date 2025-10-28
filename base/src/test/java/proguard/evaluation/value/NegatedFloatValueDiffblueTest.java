package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NegatedFloatValueDiffblueTest {
  /**
   * Method under test: {@link NegatedFloatValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange and Act
    FloatValue actualNegateResult = (new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof UnknownFloatValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedFloatValue#equals(Object)}
   *   <li>{@link NegatedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NegatedFloatValue negatedFloatValue = new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE);
    NegatedFloatValue negatedFloatValue2 = new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertEquals(negatedFloatValue, negatedFloatValue2);
    int expectedHashCodeResult = negatedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedFloatValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedFloatValue#equals(Object)}
   *   <li>{@link NegatedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NegatedFloatValue negatedFloatValue = new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertEquals(negatedFloatValue, negatedFloatValue);
    int expectedHashCodeResult = negatedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedFloatValue.hashCode());
  }

  /**
   * Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NegatedFloatValue negatedFloatValue = new NegatedFloatValue(ParticularValueFactory.FLOAT_VALUE_0);

    // Act and Assert
    assertNotEquals(negatedFloatValue, new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NegatedFloatValue negatedFloatValue = new NegatedFloatValue(new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE));

    // Act and Assert
    assertNotEquals(negatedFloatValue, new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE), null);
  }

  /**
   * Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE), "Different type to NegatedFloatValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NegatedFloatValue#NegatedFloatValue(FloatValue)}
   *   <li>{@link NegatedFloatValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("-f", (new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE)).toString());
  }
}
