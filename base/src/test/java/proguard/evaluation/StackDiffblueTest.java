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

public class StackDiffblueTest {
  /**
   * Method under test: {@link Stack#reset(int)}
   */
  @Test
  public void testReset() {
    // Arrange
    Stack stack = new Stack(1);

    // Act
    stack.reset(3);

    // Assert
    Value[] valueArray = stack.values;
    assertNull(valueArray[1]);
    assertNull(valueArray[2]);
    assertEquals(3, valueArray.length);
  }

  /**
   * Method under test: {@link Stack#copy(Stack)}
   */
  @Test
  public void testCopy() {
    // Arrange
    Stack stack = new Stack(1);

    // Act
    stack.copy(new Stack(3));

    // Assert
    Value[] valueArray = stack.values;
    assertNull(valueArray[1]);
    assertNull(valueArray[2]);
    assertEquals(3, valueArray.length);
  }

  /**
   * Method under test: {@link Stack#generalize(Stack)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    Stack stack = new Stack(3);

    // Act and Assert
    assertFalse(stack.generalize(new Stack(3)));
  }

  /**
   * Method under test: {@link Stack#getBottom(int)}
   */
  @Test
  public void testGetBottom() {
    // Arrange, Act and Assert
    assertNull((new Stack(3)).getBottom(1));
  }

  /**
   * Method under test: {@link Stack#setBottom(int, Value)}
   */
  @Test
  public void testSetBottom() {
    // Arrange
    Stack stack = new Stack(3);
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act
    stack.setBottom(1, value);

    // Assert
    Value[] valueArray = stack.values;
    assertEquals(3, valueArray.length);
    assertSame(value, valueArray[1]);
  }

  /**
   * Method under test: {@link Stack#getTop(int)}
   */
  @Test
  public void testGetTop() {
    // Arrange, Act and Assert
    assertNull((new Stack(3)).getTop(InitializationFinder.NONE));
  }

  /**
   * Method under test: {@link Stack#setTop(int, Value)}
   */
  @Test
  public void testSetTop() {
    // Arrange
    Stack stack = new Stack(3);
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act
    stack.setTop(InitializationFinder.NONE, value);

    // Assert
    Value[] valueArray = stack.values;
    assertEquals(3, valueArray.length);
    assertSame(value, valueArray[0]);
  }

  /**
   * Method under test: {@link Stack#push(Value)}
   */
  @Test
  public void testPush() {
    // Arrange
    Stack stack = new Stack(3);
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act
    stack.push(value);

    // Assert
    Value[] valueArray = stack.values;
    Value value2 = valueArray[0];
    assertTrue(value2 instanceof TopValue);
    assertEquals(2, stack.getActualMaxSize());
    assertEquals(2, stack.size());
    assertEquals(3, valueArray.length);
    assertFalse(value2.isCategory2());
    assertTrue(value2.isParticular());
    assertTrue(value2.isSpecific());
    assertSame(value, valueArray[1]);
  }

  /**
   * Method under test: {@link Stack#push(Value)}
   */
  @Test
  public void testPush2() {
    // Arrange
    Stack stack = new Stack(3);
    FloatValue value = BasicValueFactory.FLOAT_VALUE;

    // Act
    stack.push(value);

    // Assert
    Value[] valueArray = stack.values;
    assertNull(valueArray[1]);
    assertEquals(1, stack.getActualMaxSize());
    assertEquals(1, stack.size());
    assertEquals(3, valueArray.length);
    assertSame(value, valueArray[0]);
  }

  /**
   * Method under test: {@link Stack#replaceReferences(Value, Value)}
   */
  @Test
  public void testReplaceReferences() {
    // Arrange
    Stack stack = new Stack(3);

    // Act
    stack.replaceReferences(BasicValueFactory.DOUBLE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Assert that nothing has changed
    assertEquals(3, stack.values.length);
  }

  /**
   * Method under test: {@link Stack#replaceReferences(Value, Value)}
   */
  @Test
  public void testReplaceReferences2() {
    // Arrange
    Stack stack = new Stack(3);
    DoubleValue replacement = BasicValueFactory.DOUBLE_VALUE;

    // Act
    stack.replaceReferences(null, replacement);

    // Assert
    Value[] valueArray = stack.values;
    assertEquals(3, valueArray.length);
    assertSame(replacement, valueArray[0]);
    assertSame(replacement, valueArray[1]);
    assertSame(replacement, valueArray[2]);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Stack#equals(Object)}
   *   <li>{@link Stack#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Stack stack = new Stack(3);
    Stack stack2 = new Stack(3);

    // Act and Assert
    assertEquals(stack, stack2);
    int expectedHashCodeResult = stack.hashCode();
    assertEquals(expectedHashCodeResult, stack2.hashCode());
  }

  /**
   * Method under test: {@link Stack#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
   *   <li>{@link Stack#equals(Object)}
   *   <li>{@link Stack#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Stack stack = new Stack(3);

    // Act and Assert
    assertEquals(stack, stack);
    int expectedHashCodeResult = stack.hashCode();
    assertEquals(expectedHashCodeResult, stack.hashCode());
  }

  /**
   * Method under test: {@link Stack#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("", (new Stack(3)).toString());
    assertEquals("", (new TracedStack(3)).toString());
  }

  /**
   * Method under test: {@link Stack#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);

    // Act and Assert
    assertNotEquals(tracedStack, new Stack(3));
  }

  /**
   * Method under test: {@link Stack#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Stack(3), null);
  }

  /**
   * Method under test: {@link Stack#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Stack(3), "Different type to Stack");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Stack#getActualMaxSize()}
   *   <li>{@link Stack#size()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Stack stack = new Stack(3);

    // Act
    int actualActualMaxSize = stack.getActualMaxSize();

    // Assert
    assertEquals(0, actualActualMaxSize);
    assertEquals(0, stack.size());
  }

  /**
   * Method under test: {@link Stack#Stack(int)}
   */
  @Test
  public void testNewStack() {
    // Arrange and Act
    Stack actualStack = new Stack(3);

    // Assert
    Value[] valueArray = actualStack.values;
    assertNull(valueArray[0]);
    assertNull(valueArray[1]);
    assertNull(valueArray[2]);
    assertEquals(0, actualStack.getActualMaxSize());
    assertEquals(0, actualStack.size());
    assertEquals(3, valueArray.length);
  }

  /**
   * Method under test: {@link Stack#Stack(Stack)}
   */
  @Test
  public void testNewStack2() {
    // Arrange
    Stack stack = new Stack(3);

    // Act and Assert
    assertEquals(stack, new Stack(stack));
  }
}
