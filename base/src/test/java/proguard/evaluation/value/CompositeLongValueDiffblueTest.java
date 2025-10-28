package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class CompositeLongValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompositeLongValue#equals(Object)}
   *   <li>{@link CompositeLongValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    CompositeLongValue compositeLongValue2 = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(compositeLongValue, compositeLongValue2);
    int expectedHashCodeResult = compositeLongValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeLongValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompositeLongValue#equals(Object)}
   *   <li>{@link CompositeLongValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(compositeLongValue, compositeLongValue);
    int expectedHashCodeResult = compositeLongValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeLongValue.hashCode());
  }

  /**
   * Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(ParticularValueFactory.LONG_VALUE_0, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(compositeLongValue,
        new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(
        new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(compositeLongValue,
        new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 1,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(compositeLongValue,
        new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(compositeLongValue,
        new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CompositeLongValue compositeLongValue = new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A',
        new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(compositeLongValue,
        new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        null);
  }

  /**
   * Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to CompositeLongValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompositeLongValue#CompositeLongValue(LongValue, byte, Value)}
   *   <li>{@link CompositeLongValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(lAb)",
        (new CompositeLongValue(BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .toString());
  }
}
