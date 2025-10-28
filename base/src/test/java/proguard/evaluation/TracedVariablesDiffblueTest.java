package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.FloatValue;
import proguard.evaluation.value.TopValue;
import proguard.evaluation.value.Value;

public class TracedVariablesDiffblueTest {
  /**
   * Method under test: {@link TracedVariables#getProducerValue(int)}
   */
  @Test
  public void testGetProducerValue() {
    // Arrange, Act and Assert
    assertNull((new TracedVariables(3)).getProducerValue(1));
  }

  /**
   * Method under test: {@link TracedVariables#reset(int)}
   */
  @Test
  public void testReset() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(1);

    // Act
    tracedVariables.reset(3);

    // Assert
    Value[] values = tracedVariables.getValues();
    assertNull(values[1]);
    assertNull(values[2]);
    assertEquals(3, tracedVariables.size());
    assertEquals(3, values.length);
  }

  /**
   * Method under test:
   * {@link TracedVariables#generalize(TracedVariables, boolean)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act and Assert
    assertFalse(tracedVariables.generalize(new TracedVariables(3), true));
  }

  /**
   * Method under test:
   * {@link TracedVariables#generalize(TracedVariables, boolean)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act and Assert
    assertFalse(tracedVariables.generalize(new TracedVariables(3), false));
  }

  /**
   * Method under test: {@link TracedVariables#store(int, Value)}
   */
  @Test
  public void testStore() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);
    tracedVariables.setProducerValue(BasicValueFactory.FLOAT_VALUE);
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act
    tracedVariables.store(1, value);

    // Assert
    Value[] values = tracedVariables.getValues();
    Value value2 = values[2];
    assertTrue(value2 instanceof TopValue);
    assertEquals(3, values.length);
    assertFalse(value2.isCategory2());
    assertTrue(value2.isParticular());
    assertTrue(value2.isSpecific());
    assertSame(value, values[1]);
  }

  /**
   * Method under test: {@link TracedVariables#store(int, Value)}
   */
  @Test
  public void testStore2() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);
    tracedVariables.setProducerValue(BasicValueFactory.DOUBLE_VALUE);
    FloatValue value = BasicValueFactory.FLOAT_VALUE;

    // Act
    tracedVariables.store(1, value);

    // Assert
    Value[] values = tracedVariables.getValues();
    assertNull(values[2]);
    assertEquals(3, values.length);
    assertSame(value, values[1]);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TracedVariables#equals(Object)}
   *   <li>{@link TracedVariables#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);
    TracedVariables tracedVariables2 = new TracedVariables(3);

    // Act and Assert
    assertEquals(tracedVariables, tracedVariables2);
    int expectedHashCodeResult = tracedVariables.hashCode();
    assertEquals(expectedHashCodeResult, tracedVariables2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TracedVariables#equals(Object)}
   *   <li>{@link TracedVariables#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act and Assert
    assertEquals(tracedVariables, tracedVariables);
    int expectedHashCodeResult = tracedVariables.hashCode();
    assertEquals(expectedHashCodeResult, tracedVariables.hashCode());
  }

  /**
   * Method under test: {@link TracedVariables#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("[empty:empty][empty:empty][empty:empty]", (new TracedVariables(3)).toString());
  }

  /**
   * Method under test: {@link TracedVariables#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(1);

    // Act and Assert
    assertNotEquals(tracedVariables, new TracedVariables(3));
  }

  /**
   * Method under test: {@link TracedVariables#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedVariables(3), null);
  }

  /**
   * Method under test: {@link TracedVariables#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedVariables(3), "Different type to TracedVariables");
  }

  /**
   * Method under test: {@link TracedVariables#TracedVariables(int)}
   */
  @Test
  public void testNewTracedVariables() {
    // Arrange and Act
    TracedVariables actualTracedVariables = new TracedVariables(3);

    // Assert
    Value[] values = actualTracedVariables.getValues();
    assertNull(values[0]);
    assertNull(values[1]);
    assertNull(values[2]);
    assertEquals(3, actualTracedVariables.size());
    assertEquals(3, values.length);
  }

  /**
   * Method under test: {@link TracedVariables#TracedVariables(TracedVariables)}
   */
  @Test
  public void testNewTracedVariables2() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act and Assert
    assertEquals(tracedVariables, new TracedVariables(tracedVariables));
  }
}
