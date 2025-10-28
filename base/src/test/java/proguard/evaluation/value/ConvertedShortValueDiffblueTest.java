package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ConvertedShortValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedShortValue#equals(Object)}
   *   <li>{@link ConvertedShortValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedShortValue convertedShortValue = new ConvertedShortValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedShortValue convertedShortValue2 = new ConvertedShortValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedShortValue, convertedShortValue2);
    int expectedHashCodeResult = convertedShortValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedShortValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedShortValue#equals(Object)}
   *   <li>{@link ConvertedShortValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedShortValue convertedShortValue = new ConvertedShortValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedShortValue, convertedShortValue);
    int expectedHashCodeResult = convertedShortValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedShortValue.hashCode());
  }

  /**
   * Method under test: {@link ConvertedShortValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedShortValue convertedShortValue = new ConvertedShortValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(convertedShortValue, new ConvertedShortValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedShortValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConvertedShortValue convertedShortValue = new ConvertedShortValue(
        new ConvertedShortValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(convertedShortValue, new ConvertedShortValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedShortValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedShortValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link ConvertedShortValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedShortValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedShortValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedShortValue#ConvertedShortValue(IntegerValue)}
   *   <li>{@link ConvertedShortValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(short)(b)", (new ConvertedShortValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }
}
