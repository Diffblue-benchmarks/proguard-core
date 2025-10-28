package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class CompositeFloatValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompositeFloatValue#equals(Object)}
   *   <li>{@link CompositeFloatValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);
    CompositeFloatValue compositeFloatValue2 = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertEquals(compositeFloatValue, compositeFloatValue2);
    int expectedHashCodeResult = compositeFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeFloatValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompositeFloatValue#equals(Object)}
   *   <li>{@link CompositeFloatValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertEquals(compositeFloatValue, compositeFloatValue);
    int expectedHashCodeResult = compositeFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeFloatValue.hashCode());
  }

  /**
   * Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(ParticularValueFactory.FLOAT_VALUE_0, (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertNotEquals(compositeFloatValue,
        new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(
        new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE), (byte) 'A',
        BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertNotEquals(compositeFloatValue,
        new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 1,
        BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertNotEquals(compositeFloatValue,
        new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        ParticularValueFactory.FLOAT_VALUE_0);

    // Act and Assert
    assertNotEquals(compositeFloatValue,
        new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CompositeFloatValue compositeFloatValue = new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A',
        new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Act and Assert
    assertNotEquals(compositeFloatValue,
        new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE),
        null);
  }

  /**
   * Method under test: {@link CompositeFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE),
        "Different type to CompositeFloatValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CompositeFloatValue#CompositeFloatValue(FloatValue, byte, FloatValue)}
   *   <li>{@link CompositeFloatValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("(fAf)",
        (new CompositeFloatValue(BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE)).toString());
  }
}
