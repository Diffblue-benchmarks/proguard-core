package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class UnknownValueDiffblueTest {
  /**
   * Method under test: {@link UnknownValue#generalize(Value)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    UnknownValue unknownValue = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(unknownValue, unknownValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownValue#computationalType()}
   */
  @Test
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(Value.NEVER, BasicValueFactory.UNKNOWN_VALUE.computationalType());
  }

  /**
   * Method under test: {@link UnknownValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertNull(BasicValueFactory.UNKNOWN_VALUE.internalType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UnknownValue#equals(Object)}
   *   <li>{@link UnknownValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownValue unknownValue = BasicValueFactory.UNKNOWN_VALUE;
    UnknownValue unknownValue2 = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertEquals(unknownValue, unknownValue2);
    int expectedHashCodeResult = unknownValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UnknownValue#equals(Object)}
   *   <li>{@link UnknownValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnknownValue unknownValue = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertEquals(unknownValue, unknownValue);
    int expectedHashCodeResult = unknownValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownValue.hashCode());
  }

  /**
   * Method under test: {@link UnknownValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.UNKNOWN_VALUE, 3);
  }

  /**
   * Method under test: {@link UnknownValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.UNKNOWN_VALUE, null);
  }

  /**
   * Method under test: {@link UnknownValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.UNKNOWN_VALUE, "Different type to UnknownValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownValue}
   *   <li>{@link UnknownValue#toString()}
   *   <li>{@link UnknownValue#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    UnknownValue actualUnknownValue = new UnknownValue();
    String actualToStringResult = actualUnknownValue.toString();

    // Assert
    assertEquals("UNKNOWN", actualToStringResult);
    assertFalse(actualUnknownValue.isCategory2());
  }
}
