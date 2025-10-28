package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ConvertedCharacterValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedCharacterValue#equals(Object)}
   *   <li>{@link ConvertedCharacterValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedCharacterValue convertedCharacterValue = new ConvertedCharacterValue(
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedCharacterValue convertedCharacterValue2 = new ConvertedCharacterValue(
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedCharacterValue, convertedCharacterValue2);
    int expectedHashCodeResult = convertedCharacterValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedCharacterValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedCharacterValue#equals(Object)}
   *   <li>{@link ConvertedCharacterValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedCharacterValue convertedCharacterValue = new ConvertedCharacterValue(
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedCharacterValue, convertedCharacterValue);
    int expectedHashCodeResult = convertedCharacterValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedCharacterValue.hashCode());
  }

  /**
   * Method under test: {@link ConvertedCharacterValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedCharacterValue convertedCharacterValue = new ConvertedCharacterValue(
        BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(convertedCharacterValue, new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedCharacterValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConvertedCharacterValue convertedCharacterValue = new ConvertedCharacterValue(
        new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(convertedCharacterValue, new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedCharacterValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link ConvertedCharacterValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedCharacterValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedCharacterValue#ConvertedCharacterValue(IntegerValue)}
   *   <li>{@link ConvertedCharacterValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(char)(b)", (new ConvertedCharacterValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }
}
