package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ConvertedFloatValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedFloatValue#equals(Object)}
   *   <li>{@link ConvertedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedFloatValue convertedFloatValue = new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedFloatValue convertedFloatValue2 = new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedFloatValue, convertedFloatValue2);
    int expectedHashCodeResult = convertedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedFloatValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedFloatValue#equals(Object)}
   *   <li>{@link ConvertedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedFloatValue convertedFloatValue = new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedFloatValue, convertedFloatValue);
    int expectedHashCodeResult = convertedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedFloatValue.hashCode());
  }

  /**
   * Method under test: {@link ConvertedFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedFloatValue convertedFloatValue = new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(convertedFloatValue, new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConvertedFloatValue convertedFloatValue = new ConvertedFloatValue(
        new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(convertedFloatValue, new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link ConvertedFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedFloatValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedFloatValue#ConvertedFloatValue(Value)}
   *   <li>{@link ConvertedFloatValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(float)(b)", (new ConvertedFloatValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }
}
