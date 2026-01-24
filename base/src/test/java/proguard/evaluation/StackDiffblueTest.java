package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.TopValue;
import proguard.evaluation.value.Value;

class StackDiffblueTest {
  /**
   * Test {@link Stack#Stack(Stack)}.
   *
   * <p>Method under test: {@link Stack#Stack(Stack)}
   */
  @Test
  @DisplayName("Test new Stack(Stack)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.<init>(Stack)"})
  void testNewStack() {
    // Arrange
    Stack stack = new Stack(3);

    // Act
    Stack actualStack = new Stack(stack);

    // Assert
    assertEquals(stack, actualStack);
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
  @DisplayName("Test new Stack(int); when three; then return first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.<init>(int)"})
  void testNewStack_whenThree_thenReturnFirstElementIsNull() {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Stack.getActualMaxSize()", "void Stack.pop1()", "int Stack.size()"})
  void testGettersAndSetters() {
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
  @DisplayName(
      "Test reset(int); given Stack(int) with maxSize is one; then second element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.reset(int)"})
  void testReset_givenStackWithMaxSizeIsOne_thenSecondElementIsNull() {
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
  @DisplayName("Test reset(int); given Stack(int) with maxSize is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.reset(int)"})
  void testReset_givenStackWithMaxSizeIsThree() {
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
  @DisplayName("Test reset(int); given TracedStack(int) with maxSize is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.reset(int)"})
  void testReset_givenTracedStackWithMaxSizeIsThree() {
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
  @DisplayName(
      "Test copy(Stack); given Stack(int) with maxSize is one; then second element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.copy(Stack)"})
  void testCopy_givenStackWithMaxSizeIsOne_thenSecondElementIsNull() {
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
  @DisplayName("Test generalize(Stack); when Stack(int) with maxSize is three; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stack.generalize(Stack)"})
  void testGeneralize_whenStackWithMaxSizeIsThree_thenReturnFalse() {
    // Arrange
    Stack stack = new Stack(3);

    // Act
    boolean actualGeneralizeResult = stack.generalize(new Stack(3));

    // Assert
    assertFalse(actualGeneralizeResult);
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
  @DisplayName("Test getBottom(int); given Stack(int) with maxSize is three; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Stack.getBottom(int)"})
  void testGetBottom_givenStackWithMaxSizeIsThree_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Stack(3).getBottom(1));
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
  @DisplayName(
      "Test setBottom(int, Value); given Stack(int) with maxSize is three; then array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.setBottom(int, Value)"})
  void testSetBottom_givenStackWithMaxSizeIsThree_thenArrayLengthIsThree() {
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
  @DisplayName("Test getTop(int); when NONE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Stack.getTop(int)"})
  void testGetTop_whenNone_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Stack(3).getTop(InitializationFinder.NONE));
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
  @DisplayName("Test setTop(int, Value); when NONE; then array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.setTop(int, Value)"})
  void testSetTop_whenNone_thenArrayLengthIsThree() {
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
   *   <li>Then {@link Stack#Stack(int)} with maxSize is three ActualMaxSize is two.
   * </ul>
   *
   * <p>Method under test: {@link Stack#push(Value)}
   */
  @Test
  @DisplayName("Test push(Value); then Stack(int) with maxSize is three ActualMaxSize is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.push(Value)"})
  void testPush_thenStackWithMaxSizeIsThreeActualMaxSizeIsTwo() {
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
   *   <li>Then {@link TracedStack#TracedStack(int)} with maxSize is three ActualMaxSize is two.
   * </ul>
   *
   * <p>Method under test: {@link Stack#push(Value)}
   */
  @Test
  @DisplayName("Test push(Value); then TracedStack(int) with maxSize is three ActualMaxSize is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.push(Value)"})
  void testPush_thenTracedStackWithMaxSizeIsThreeActualMaxSizeIsTwo() {
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
   * Test {@link Stack#replaceReferences(Value, Value)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Stack#replaceReferences(Value, Value)}
   */
  @Test
  @DisplayName("Test replaceReferences(Value, Value); when DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.replaceReferences(Value, Value)"})
  void testReplaceReferences_whenDouble_value() {
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
  @DisplayName(
      "Test replaceReferences(Value, Value); when 'null'; then first element is DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stack.replaceReferences(Value, Value)"})
  void testReplaceReferences_whenNull_thenFirstElementIsDouble_value() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Stack stack = new Stack(3);
    Stack stack2 = new Stack(3);

    // Act and Assert
    assertEquals(stack, stack2);
    assertEquals(stack.hashCode(), stack2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);
    TracedStack tracedStack2 = new TracedStack(3);

    // Act and Assert
    assertEquals(tracedStack, tracedStack2);
    assertEquals(tracedStack.hashCode(), tracedStack2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Stack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stack.equals(Object)", "int Stack.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @DisplayName("Test toString(); given Stack(int) with maxSize is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Stack.toString()"})
  void testToString_givenStackWithMaxSizeIsThree() {
    // Arrange, Act and Assert
    assertEquals("", new Stack(3).toString());
  }
}
