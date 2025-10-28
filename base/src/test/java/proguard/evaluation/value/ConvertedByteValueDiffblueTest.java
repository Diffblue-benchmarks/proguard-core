package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ConvertedByteValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedByteValue#equals(Object)}
   *   <li>{@link ConvertedByteValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedByteValue convertedByteValue2 = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedByteValue, convertedByteValue2);
    int expectedHashCodeResult = convertedByteValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedByteValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedByteValue#equals(Object)}
   *   <li>{@link ConvertedByteValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedByteValue, convertedByteValue);
    int expectedHashCodeResult = convertedByteValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedByteValue.hashCode());
  }

  /**
   * Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(convertedByteValue, new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(convertedByteValue, new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedByteValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedByteValue#ConvertedByteValue(IntegerValue)}
   *   <li>{@link ConvertedByteValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(byte)(b)", (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }
}
