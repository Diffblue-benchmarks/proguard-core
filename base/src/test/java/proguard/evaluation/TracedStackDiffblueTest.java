package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.FloatValue;
import proguard.evaluation.value.TopValue;
import proguard.evaluation.value.Value;

class TracedStackDiffblueTest {
  /**
   * Test {@link TracedStack#TracedStack(TracedStack)}.
   *
   * <p>Method under test: {@link TracedStack#TracedStack(TracedStack)}
   */
  @Test
  @DisplayName("Test new TracedStack(TracedStack)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.TracedStack.<init>(proguard.evaluation.TracedStack)"
  })
  void testNewTracedStack() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);

    // Act and Assert
    assertEquals(tracedStack, new TracedStack(tracedStack));
  }

  /**
   * Test {@link TracedStack#TracedStack(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#TracedStack(int)}
   */
  @Test
  @DisplayName("Test new TracedStack(int); when three; then return first element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.TracedStack.<init>(int)"})
  void testNewTracedStack_whenThree_thenReturnFirstElementIsNull() {
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
   * Test {@link TracedStack#getBottomProducerValue(int)}.
   *
   * <ul>
   *   <li>Given {@link TracedStack#TracedStack(int)} with maxSize is three.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#getBottomProducerValue(int)}
   */
  @Test
  @DisplayName(
      "Test getBottomProducerValue(int); given TracedStack(int) with maxSize is three; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.TracedStack.getBottomProducerValue(int)"
  })
  void testGetBottomProducerValue_givenTracedStackWithMaxSizeIsThree_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TracedStack(3)).getBottomProducerValue(1));
  }

  /**
   * Test {@link TracedStack#getBottomActualProducerValue(int)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#getBottomActualProducerValue(int)}
   */
  @Test
  @DisplayName("Test getBottomActualProducerValue(int); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.TracedStack.getBottomActualProducerValue(int)"
  })
  void testGetBottomActualProducerValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TracedStack(3)).getBottomActualProducerValue(1));
  }

  /**
   * Test {@link TracedStack#getTopProducerValue(int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#getTopProducerValue(int)}
   */
  @Test
  @DisplayName("Test getTopProducerValue(int); when NONE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.TracedStack.getTopProducerValue(int)"
  })
  void testGetTopProducerValue_whenNone_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TracedStack(3)).getTopProducerValue(InitializationFinder.NONE));
  }

  /**
   * Test {@link TracedStack#getTopActualProducerValue(int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#getTopActualProducerValue(int)}
   */
  @Test
  @DisplayName("Test getTopActualProducerValue(int); when NONE; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.TracedStack.getTopActualProducerValue(int)"
  })
  void testGetTopActualProducerValue_whenNone_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TracedStack(3)).getTopActualProducerValue(InitializationFinder.NONE));
  }

  /**
   * Test {@link TracedStack#reset(int)}.
   *
   * <ul>
   *   <li>Given {@link TracedStack#TracedStack(int)} with maxSize is one.
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#reset(int)}
   */
  @Test
  @DisplayName(
      "Test reset(int); given TracedStack(int) with maxSize is one; then second element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.TracedStack.reset(int)"})
  void testReset_givenTracedStackWithMaxSizeIsOne_thenSecondElementIsNull() {
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
   * Test {@link TracedStack#reset(int)}.
   *
   * <ul>
   *   <li>Given {@link TracedStack#TracedStack(int)} with maxSize is three.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#reset(int)}
   */
  @Test
  @DisplayName("Test reset(int); given TracedStack(int) with maxSize is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.TracedStack.reset(int)"})
  void testReset_givenTracedStackWithMaxSizeIsThree() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);

    // Act
    tracedStack.reset(3);

    // Assert that nothing has changed
    assertEquals(3, tracedStack.values.length);
  }

  /**
   * Test {@link TracedStack#copy(TracedStack)} with {@code TracedStack}.
   *
   * <ul>
   *   <li>Given {@link TracedStack#TracedStack(int)} with maxSize is one.
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#copy(TracedStack)}
   */
  @Test
  @DisplayName(
      "Test copy(TracedStack) with 'TracedStack'; given TracedStack(int) with maxSize is one; then second element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.TracedStack.copy(proguard.evaluation.TracedStack)"})
  void testCopyWithTracedStack_givenTracedStackWithMaxSizeIsOne_thenSecondElementIsNull() {
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
   * Test {@link TracedStack#generalize(TracedStack)} with {@code TracedStack}.
   *
   * <ul>
   *   <li>When {@link TracedStack#TracedStack(int)} with maxSize is three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#generalize(TracedStack)}
   */
  @Test
  @DisplayName(
      "Test generalize(TracedStack) with 'TracedStack'; when TracedStack(int) with maxSize is three; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.TracedStack.generalize(proguard.evaluation.TracedStack)"
  })
  void testGeneralizeWithTracedStack_whenTracedStackWithMaxSizeIsThree_thenReturnFalse() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);

    // Act and Assert
    assertFalse(tracedStack.generalize(new TracedStack(3)));
  }

  /**
   * Test {@link TracedStack#push(Value)}.
   *
   * <ul>
   *   <li>Then first element {@link TopValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#push(Value)}
   */
  @Test
  @DisplayName("Test push(Value); then first element TopValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.TracedStack.push(proguard.evaluation.value.Value)"})
  void testPush_thenFirstElementTopValue() {
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
   * Test {@link TracedStack#push(Value)}.
   *
   * <ul>
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#push(Value)}
   */
  @Test
  @DisplayName("Test push(Value); then second element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.TracedStack.push(proguard.evaluation.value.Value)"})
  void testPush_thenSecondElementIsNull() {
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
   * Test {@link TracedStack#equals(Object)}, and {@link TracedStack#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracedStack#equals(Object)}
   *   <li>{@link TracedStack#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.TracedStack.equals(java.lang.Object)",
    "int proguard.evaluation.TracedStack.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);
    TracedStack tracedStack2 = new TracedStack(3);

    // Act and Assert
    assertEquals(tracedStack, tracedStack2);
    int expectedHashCodeResult = tracedStack.hashCode();
    assertEquals(expectedHashCodeResult, tracedStack2.hashCode());
  }

  /**
   * Test {@link TracedStack#equals(Object)}, and {@link TracedStack#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracedStack#equals(Object)}
   *   <li>{@link TracedStack#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.TracedStack.equals(java.lang.Object)",
    "int proguard.evaluation.TracedStack.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TracedStack tracedStack = new TracedStack(3);

    // Act and Assert
    assertEquals(tracedStack, tracedStack);
    int expectedHashCodeResult = tracedStack.hashCode();
    assertEquals(expectedHashCodeResult, tracedStack.hashCode());
  }

  /**
   * Test {@link TracedStack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.TracedStack.equals(java.lang.Object)",
    "int proguard.evaluation.TracedStack.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedStack(3), 1);
  }

  /**
   * Test {@link TracedStack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.TracedStack.equals(java.lang.Object)",
    "int proguard.evaluation.TracedStack.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedStack(3), null);
  }

  /**
   * Test {@link TracedStack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracedStack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.TracedStack.equals(java.lang.Object)",
    "int proguard.evaluation.TracedStack.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedStack(3), "Different type to TracedStack");
  }

  /**
   * Test {@link TracedStack#toString()}.
   *
   * <p>Method under test: {@link TracedStack#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.evaluation.TracedStack.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("", (new TracedStack(3)).toString());
  }
}
