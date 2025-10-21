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

public class TracedStackDiffblueTest {
  /**
   * Test {@link TracedStack#TracedStack(TracedStack)}.
   *
   * <p>Method under test: {@link TracedStack#TracedStack(TracedStack)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedStack.<init>(TracedStack)"})
  public void testNewTracedStack() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedStack.<init>(int)"})
  public void testNewTracedStack_whenThree_thenReturnFirstElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TracedStack.getBottomProducerValue(int)"})
  public void testGetBottomProducerValue_givenTracedStackWithMaxSizeIsThree_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TracedStack.getBottomActualProducerValue(int)"})
  public void testGetBottomActualProducerValue_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TracedStack.getTopProducerValue(int)"})
  public void testGetTopProducerValue_whenNone_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TracedStack.getTopActualProducerValue(int)"})
  public void testGetTopActualProducerValue_whenNone_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedStack.reset(int)"})
  public void testReset_givenTracedStackWithMaxSizeIsOne_thenSecondElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedStack.reset(int)"})
  public void testReset_givenTracedStackWithMaxSizeIsThree() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedStack.copy(TracedStack)"})
  public void testCopyWithTracedStack_givenTracedStackWithMaxSizeIsOne_thenSecondElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedStack.generalize(TracedStack)"})
  public void testGeneralizeWithTracedStack_whenTracedStackWithMaxSizeIsThree_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedStack.push(Value)"})
  public void testPush_thenFirstElementTopValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedStack.push(Value)"})
  public void testPush_thenSecondElementIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedStack.equals(Object)", "int TracedStack.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedStack.equals(Object)", "int TracedStack.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedStack.equals(Object)", "int TracedStack.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedStack.equals(Object)", "int TracedStack.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedStack.equals(Object)", "int TracedStack.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedStack(3), "Different type to TracedStack");
  }

  /**
   * Test {@link TracedStack#toString()}.
   *
   * <p>Method under test: {@link TracedStack#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TracedStack.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("", (new TracedStack(3)).toString());
  }
}
