package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ComparisonValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonValue#equals(Object)}
   *   <li>{@link ComparisonValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ComparisonValue comparisonValue2 = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(comparisonValue, comparisonValue2);
    int expectedHashCodeResult = comparisonValue.hashCode();
    assertEquals(expectedHashCodeResult, comparisonValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonValue#equals(Object)}
   *   <li>{@link ComparisonValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(comparisonValue, comparisonValue);
    int expectedHashCodeResult = comparisonValue.hashCode();
    assertEquals(expectedHashCodeResult, comparisonValue.hashCode());
  }

  /**
   * Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(comparisonValue,
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(comparisonValue,
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(comparisonValue,
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ComparisonValue comparisonValue = new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(comparisonValue,
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        null);
  }

  /**
   * Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ComparisonValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonValue#ComparisonValue(Value, Value)}
   *   <li>{@link ComparisonValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(b~b)",
        (new ComparisonValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .toString());
  }
}
