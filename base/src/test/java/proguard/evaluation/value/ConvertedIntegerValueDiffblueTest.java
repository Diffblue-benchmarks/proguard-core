package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ConvertedIntegerValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedIntegerValue#equals(Object)}
   *   <li>{@link ConvertedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedIntegerValue convertedIntegerValue = new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedIntegerValue convertedIntegerValue2 = new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedIntegerValue, convertedIntegerValue2);
    int expectedHashCodeResult = convertedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedIntegerValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedIntegerValue#equals(Object)}
   *   <li>{@link ConvertedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedIntegerValue convertedIntegerValue = new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedIntegerValue, convertedIntegerValue);
    int expectedHashCodeResult = convertedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedIntegerValue.hashCode());
  }

  /**
   * Method under test: {@link ConvertedIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedIntegerValue convertedIntegerValue = new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(convertedIntegerValue, new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link ConvertedIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link ConvertedIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedIntegerValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConvertedIntegerValue#ConvertedIntegerValue(Value)}
   *   <li>{@link ConvertedIntegerValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(int)(b)", (new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }
}
