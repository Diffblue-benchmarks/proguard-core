package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ConvertedLongValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedLongValue#equals(Object)}
   *   <li>{@link ConvertedLongValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedLongValue convertedLongValue = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedLongValue convertedLongValue2 = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedLongValue, convertedLongValue2);
    int expectedHashCodeResult = convertedLongValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedLongValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedLongValue#equals(Object)}
   *   <li>{@link ConvertedLongValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedLongValue convertedLongValue = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedLongValue, convertedLongValue);
    int expectedHashCodeResult = convertedLongValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedLongValue.hashCode());
  }

  /**
   * Method under test: {@link ConvertedLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedLongValue convertedLongValue = new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(convertedLongValue, new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link ConvertedLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedLongValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedLongValue#ConvertedLongValue(Value)}
   *   <li>{@link ConvertedLongValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(long)(b)", (new ConvertedLongValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }
}
