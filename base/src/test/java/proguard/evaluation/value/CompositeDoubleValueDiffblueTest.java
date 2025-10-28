package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class CompositeDoubleValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompositeDoubleValue#equals(Object)}
   *   <li>{@link CompositeDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);
    CompositeDoubleValue compositeDoubleValue2 = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(compositeDoubleValue, compositeDoubleValue2);
    int expectedHashCodeResult = compositeDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeDoubleValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompositeDoubleValue#equals(Object)}
   *   <li>{@link CompositeDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(compositeDoubleValue, compositeDoubleValue);
    int expectedHashCodeResult = compositeDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeDoubleValue.hashCode());
  }

  /**
   * Method under test: {@link CompositeDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(ParticularValueFactory.DOUBLE_VALUE_0,
        (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertNotEquals(compositeDoubleValue,
        new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link CompositeDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(
        new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE),
        (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertNotEquals(compositeDoubleValue,
        new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link CompositeDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 1,
        BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertNotEquals(compositeDoubleValue,
        new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link CompositeDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        ParticularValueFactory.DOUBLE_VALUE_0);

    // Act and Assert
    assertNotEquals(compositeDoubleValue,
        new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link CompositeDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue = new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A',
        new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));

    // Act and Assert
    assertNotEquals(compositeDoubleValue,
        new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link CompositeDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE), null);
  }

  /**
   * Method under test: {@link CompositeDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE),
        "Different type to CompositeDoubleValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CompositeDoubleValue#CompositeDoubleValue(DoubleValue, byte, DoubleValue)}
   *   <li>{@link CompositeDoubleValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(dAd)",
        (new CompositeDoubleValue(BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE))
            .toString());
  }
}
