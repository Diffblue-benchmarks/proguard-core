package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.FloatValue;
import proguard.evaluation.value.TopValue;
import proguard.evaluation.value.Value;

public class StackDiffblueTest {
  /**
   * Test {@link Stack#Stack(Stack)}.
   *
   * <p>Method under test: {@link Stack#Stack(Stack)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.<init>(Stack)"})
  public void testNewStack() {
    // Arrange
    Stack stack = new Stack(3);

    // Act and Assert
    assertEquals(stack, new Stack(stack));
  }

  /**
   * Test {@link Stack#Stack(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#Stack(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.<init>(int)"})
  public void testNewStack_whenThree_thenReturnFirstElementIsNull() {
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Stack#getActualMaxSize()}
   *   <li>{@link Stack#size()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Stack.getActualMaxSize()", "void Stack.pop1()", "int Stack.size()"})
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
   * Test {@link Stack#reset(int)}.
   *
   * <ul>
   *   <li>Given {@link Stack#Stack(int)} with maxSize is one.
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#reset(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.reset(int)"})
  public void testReset_givenStackWithMaxSizeIsOne_thenSecondElementIsNull() {
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
   * Test {@link Stack#reset(int)}.
   *
   * <ul>
   *   <li>Given {@link Stack#Stack(int)} with maxSize is three.
   * </ul>
   *
   * <p>Method under test: {@link Stack#reset(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.reset(int)"})
  public void testReset_givenStackWithMaxSizeIsThree() {
    // Arrange
    Stack stack = new Stack(3);

    // Act
    stack.reset(3);

    // Assert that nothing has changed
    assertEquals(3, stack.values.length);
  }

  /**
   * Test {@link Stack#reset(int)}.
   *
   * <ul>
   *   <li>Given {@link TracedStack#TracedStack(int)} with maxSize is three.
   * </ul>
   *
   * <p>Method under test: {@link Stack#reset(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.reset(int)"})
  public void testReset_givenTracedStackWithMaxSizeIsThree() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);

    // Act
    tracedStack.reset(3);

    // Assert that nothing has changed
    assertEquals(3, tracedStack.values.length);
  }

  /**
   * Test {@link Stack#copy(Stack)}.
   *
   * <ul>
   *   <li>Given {@link Stack#Stack(int)} with maxSize is one.
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#copy(Stack)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.copy(Stack)"})
  public void testCopy_givenStackWithMaxSizeIsOne_thenSecondElementIsNull() {
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
   * Test {@link Stack#generalize(Stack)}.
   *
   * <ul>
   *   <li>When {@link Stack#Stack(int)} with maxSize is three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#generalize(Stack)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Stack.generalize(Stack)"})
  public void testGeneralize_whenStackWithMaxSizeIsThree_thenReturnFalse() {
    // Arrange
    Stack stack = new Stack(3);

    // Act and Assert
    assertFalse(stack.generalize(new Stack(3)));
  }

  /**
   * Test {@link Stack#getBottom(int)}.
   *
   * <ul>
   *   <li>Given {@link Stack#Stack(int)} with maxSize is three.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#getBottom(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Stack.getBottom(int)"})
  public void testGetBottom_givenStackWithMaxSizeIsThree_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Stack(3)).getBottom(1));
  }

  /**
   * Test {@link Stack#setBottom(int, Value)}.
   *
   * <ul>
   *   <li>Given {@link Stack#Stack(int)} with maxSize is three.
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link Stack#setBottom(int, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.setBottom(int, Value)"})
  public void testSetBottom_givenStackWithMaxSizeIsThree_thenArrayLengthIsThree() {
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
   * Test {@link Stack#getTop(int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#getTop(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Stack.getTop(int)"})
  public void testGetTop_whenNone_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Stack(3)).getTop(InitializationFinder.NONE));
  }

  /**
   * Test {@link Stack#setTop(int, Value)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link Stack#setTop(int, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.setTop(int, Value)"})
  public void testSetTop_whenNone_thenArrayLengthIsThree() {
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
   * Test {@link Stack#push(Value)}.
   *
   * <ul>
   *   <li>Given {@link Stack#Stack(int)} with maxSize is three.
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then first element {@link TopValue}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#push(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.push(Value)"})
  public void testPush_givenStackWithMaxSizeIsThree_whenDouble_value_thenFirstElementTopValue() {
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
   * Test {@link Stack#push(Value)}.
   *
   * <ul>
   *   <li>Given {@link Stack#Stack(int)} with maxSize is three.
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#push(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.push(Value)"})
  public void testPush_givenStackWithMaxSizeIsThree_whenFloat_value_thenSecondElementIsNull() {
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
   * Test {@link Stack#replaceReferences(Value, Value)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#replaceReferences(Value, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.replaceReferences(Value, Value)"})
  public void testReplaceReferences_whenDouble_value() {
    // Arrange
    Stack stack = new Stack(3);

    // Act
    stack.replaceReferences(BasicValueFactory.DOUBLE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Assert that nothing has changed
    assertEquals(3, stack.values.length);
  }

  /**
   * Test {@link Stack#replaceReferences(Value, Value)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then first element is {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#replaceReferences(Value, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stack.replaceReferences(Value, Value)"})
  public void testReplaceReferences_whenNull_thenFirstElementIsDouble_value() {
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
   * Test {@link Stack#equals(Object)}, and {@link Stack#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Stack#equals(Object)}
   *   <li>{@link Stack#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
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
   * Test {@link Stack#equals(Object)}, and {@link Stack#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link Stack#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
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
   * Test {@link Stack#equals(Object)}, and {@link Stack#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Stack#equals(Object)}
   *   <li>{@link Stack#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Stack stack = new Stack(3);

    // Act and Assert
    assertEquals(stack, stack);
    int expectedHashCodeResult = stack.hashCode();
    assertEquals(expectedHashCodeResult, stack.hashCode());
  }

  /**
   * Test {@link Stack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Stack#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);

    // Act and Assert
    assertNotEquals(tracedStack, new Stack(3));
  }

  /**
   * Test {@link Stack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Stack#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Stack(3), null);
  }

  /**
   * Test {@link Stack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Stack#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Stack(3), "Different type to Stack");
  }

  /**
   * Test {@link Stack#toString()}.
   *
   * <ul>
   *   <li>Given {@link Stack#Stack(int)} with maxSize is three.
   * </ul>
   *
   * <p>Method under test: {@link Stack#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Stack.toString()"})
  public void testToString_givenStackWithMaxSizeIsThree() {
    // Arrange, Act and Assert
    assertEquals("", (new Stack(3)).toString());
  }

  /**
   * Test {@link Stack#toString()}.
   *
   * <ul>
   *   <li>Given {@link TracedStack#TracedStack(int)} with maxSize is three.
   * </ul>
   *
   * <p>Method under test: {@link Stack#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Stack.toString()"})
  public void testToString_givenTracedStackWithMaxSizeIsThree() {
    // Arrange, Act and Assert
    assertEquals("", (new TracedStack(3)).toString());
  }
}
