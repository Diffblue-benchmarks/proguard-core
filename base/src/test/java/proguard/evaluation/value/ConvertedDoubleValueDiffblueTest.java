package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ConvertedDoubleValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedDoubleValue#equals(Object)}
   *   <li>{@link ConvertedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue = new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedDoubleValue convertedDoubleValue2 = new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedDoubleValue, convertedDoubleValue2);
    int expectedHashCodeResult = convertedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedDoubleValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedDoubleValue#equals(Object)}
   *   <li>{@link ConvertedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue = new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedDoubleValue, convertedDoubleValue);
    int expectedHashCodeResult = convertedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedDoubleValue.hashCode());
  }

  /**
   * Method under test: {@link ConvertedDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue = new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(convertedDoubleValue, new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue = new ConvertedDoubleValue(
        new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(convertedDoubleValue, new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link ConvertedDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedDoubleValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedDoubleValue#ConvertedDoubleValue(Value)}
   *   <li>{@link ConvertedDoubleValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(double)(b)", (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }
}
