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

public class TracedStackDiffblueTest {
  /**
   * Method under test: {@link TracedStack#getBottomProducerValue(int)}
   */
  @Test
  public void testGetBottomProducerValue() {
    // Arrange, Act and Assert
    assertNull((new TracedStack(3)).getBottomProducerValue(1));
  }

  /**
   * Method under test: {@link TracedStack#getBottomActualProducerValue(int)}
   */
  @Test
  public void testGetBottomActualProducerValue() {
    // Arrange, Act and Assert
    assertNull((new TracedStack(3)).getBottomActualProducerValue(1));
  }

  /**
   * Method under test: {@link TracedStack#getTopProducerValue(int)}
   */
  @Test
  public void testGetTopProducerValue() {
    // Arrange, Act and Assert
    assertNull((new TracedStack(3)).getTopProducerValue(InitializationFinder.NONE));
  }

  /**
   * Method under test: {@link TracedStack#getTopActualProducerValue(int)}
   */
  @Test
  public void testGetTopActualProducerValue() {
    // Arrange, Act and Assert
    assertNull((new TracedStack(3)).getTopActualProducerValue(InitializationFinder.NONE));
  }

  /**
   * Method under test: {@link TracedStack#reset(int)}
   */
  @Test
  public void testReset() {
    // Arrange
    TracedStack tracedStack = new TracedStack(1);

    // Act
    tracedStack.reset(3);

    // Assert
    Value[] valueArray = tracedStack.values;
    assertNull(valueArray[1]);
    assertNull(valueArray[2]);
    assertEquals(3, valueArray.length);
  }

  /**
   * Method under test: {@link TracedStack#copy(TracedStack)}
   */
  @Test
  public void testCopy() {
    // Arrange
    TracedStack tracedStack = new TracedStack(1);

    // Act
    tracedStack.copy(new TracedStack(3));

    // Assert
    Value[] valueArray = tracedStack.values;
    assertNull(valueArray[1]);
    assertNull(valueArray[2]);
    assertEquals(3, valueArray.length);
  }

  /**
   * Method under test: {@link TracedStack#generalize(TracedStack)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);

    // Act and Assert
    assertFalse(tracedStack.generalize(new TracedStack(3)));
  }

  /**
   * Method under test: {@link TracedStack#push(Value)}
   */
  @Test
  public void testPush() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);
    tracedStack.setProducerValue(BasicValueFactory.FLOAT_VALUE);
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act
    tracedStack.push(value);

    // Assert
    Value[] valueArray = tracedStack.values;
    Value value2 = valueArray[0];
    assertTrue(value2 instanceof TopValue);
    assertEquals(2, tracedStack.getActualMaxSize());
    assertEquals(2, tracedStack.size());
    assertEquals(3, valueArray.length);
    assertFalse(value2.isCategory2());
    assertTrue(value2.isParticular());
    assertTrue(value2.isSpecific());
    assertSame(value, valueArray[1]);
  }

  /**
   * Method under test: {@link TracedStack#push(Value)}
   */
  @Test
  public void testPush2() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);
    tracedStack.setProducerValue(BasicValueFactory.DOUBLE_VALUE);
    FloatValue value = BasicValueFactory.FLOAT_VALUE;

    // Act
    tracedStack.push(value);

    // Assert
    Value[] valueArray = tracedStack.values;
    assertNull(valueArray[1]);
    assertEquals(1, tracedStack.getActualMaxSize());
    assertEquals(1, tracedStack.size());
    assertEquals(3, valueArray.length);
    assertSame(value, valueArray[0]);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TracedStack#equals(Object)}
   *   <li>{@link TracedStack#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);
    TracedStack tracedStack2 = new TracedStack(3);

    // Act and Assert
    assertEquals(tracedStack, tracedStack2);
    int expectedHashCodeResult = tracedStack.hashCode();
    assertEquals(expectedHashCodeResult, tracedStack2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TracedStack#equals(Object)}
   *   <li>{@link TracedStack#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);

    // Act and Assert
    assertEquals(tracedStack, tracedStack);
    int expectedHashCodeResult = tracedStack.hashCode();
    assertEquals(expectedHashCodeResult, tracedStack.hashCode());
  }

  /**
   * Method under test: {@link TracedStack#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("", (new TracedStack(3)).toString());
  }

  /**
   * Method under test: {@link TracedStack#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedStack(3), 1);
  }

  /**
   * Method under test: {@link TracedStack#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedStack(3), null);
  }

  /**
   * Method under test: {@link TracedStack#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedStack(3), "Different type to TracedStack");
  }

  /**
   * Method under test: {@link TracedStack#TracedStack(int)}
   */
  @Test
  public void testNewTracedStack() {
    // Arrange and Act
    TracedStack actualTracedStack = new TracedStack(3);

    // Assert
    Value[] valueArray = actualTracedStack.values;
    assertNull(valueArray[0]);
    assertNull(valueArray[1]);
    assertNull(valueArray[2]);
    assertEquals(0, actualTracedStack.getActualMaxSize());
    assertEquals(0, actualTracedStack.size());
    assertEquals(3, valueArray.length);
  }

  /**
   * Method under test: {@link TracedStack#TracedStack(TracedStack)}
   */
  @Test
  public void testNewTracedStack2() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);

    // Act and Assert
    assertEquals(tracedStack, new TracedStack(tracedStack));
  }
}
