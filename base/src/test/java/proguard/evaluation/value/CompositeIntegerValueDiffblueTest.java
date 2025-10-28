package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class CompositeIntegerValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompositeIntegerValue#equals(Object)}
   *   <li>{@link CompositeIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue = new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    CompositeIntegerValue compositeIntegerValue2 = new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(compositeIntegerValue, compositeIntegerValue2);
    int expectedHashCodeResult = compositeIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeIntegerValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompositeIntegerValue#equals(Object)}
   *   <li>{@link CompositeIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue = new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(compositeIntegerValue, compositeIntegerValue);
    int expectedHashCodeResult = compositeIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeIntegerValue.hashCode());
  }

  /**
   * Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue = new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(compositeIntegerValue, new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue = new CompositeIntegerValue(
        new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(compositeIntegerValue, new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue = new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        (byte) 1, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(compositeIntegerValue, new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue = new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(compositeIntegerValue, new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue = new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        (byte) 'A', new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(compositeIntegerValue, new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE), "Different type to CompositeIntegerValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CompositeIntegerValue#CompositeIntegerValue(IntegerValue, byte, IntegerValue)}
   *   <li>{@link CompositeIntegerValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(bAb)", (new CompositeIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, (byte) 'A',
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }
}
