package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TopValueDiffblueTest {
  /**
   * Method under test: {@link TopValue#generalize(Value)}
   */
  @Test
  public void testGeneralize() {
    // Arrange and Act
    Value actualGeneralizeResult = (new TopValue()).generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link TopValue#generalize(Value)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    TopValue topValue = new TopValue();

    // Act and Assert
    assertSame(topValue, topValue.generalize(new TopValue()));
  }

  /**
   * Method under test: {@link TopValue#computationalType()}
   */
  @Test
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(7, (new TopValue()).computationalType());
  }

  /**
   * Method under test: {@link TopValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertNull((new TopValue()).internalType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TopValue#equals(Object)}
   *   <li>{@link TopValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TopValue topValue = new TopValue();
    TopValue topValue2 = new TopValue();

    // Act and Assert
    assertEquals(topValue, topValue2);
    int expectedHashCodeResult = topValue.hashCode();
    assertEquals(expectedHashCodeResult, topValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TopValue#equals(Object)}
   *   <li>{@link TopValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TopValue topValue = new TopValue();

    // Act and Assert
    assertEquals(topValue, topValue);
    int expectedHashCodeResult = topValue.hashCode();
    assertEquals(expectedHashCodeResult, topValue.hashCode());
  }

  /**
   * Method under test: {@link TopValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TopValue(), 1);
  }

  /**
   * Method under test: {@link TopValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TopValue(), null);
  }

  /**
   * Method under test: {@link TopValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TopValue(), "Different type to TopValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TopValue}
   *   <li>{@link TopValue#toString()}
   *   <li>{@link TopValue#isParticular()}
   *   <li>{@link TopValue#isSpecific()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TopValue actualTopValue = new TopValue();
    String actualToStringResult = actualTopValue.toString();
    boolean actualIsParticularResult = actualTopValue.isParticular();

    // Assert
    assertEquals("T", actualToStringResult);
    assertTrue(actualIsParticularResult);
    assertTrue(actualTopValue.isSpecific());
  }
}
