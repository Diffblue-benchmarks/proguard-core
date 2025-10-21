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

public class TracedVariablesDiffblueTest {
  /**
   * Test {@link TracedVariables#TracedVariables(TracedVariables)}.
   *
   * <p>Method under test: {@link TracedVariables#TracedVariables(TracedVariables)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedVariables.<init>(TracedVariables)"})
  public void testNewTracedVariables() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act and Assert
    assertEquals(tracedVariables, new TracedVariables(tracedVariables));
  }

  /**
   * Test {@link TracedVariables#TracedVariables(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#TracedVariables(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedVariables.<init>(int)"})
  public void testNewTracedVariables_whenThree_thenReturnFirstElementIsNull() {
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
   * Test {@link TracedVariables#getProducerValue(int)}.
   *
   * <ul>
   *   <li>Given {@link TracedVariables#TracedVariables(int)} with size is three.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#getProducerValue(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TracedVariables.getProducerValue(int)"})
  public void testGetProducerValue_givenTracedVariablesWithSizeIsThree_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TracedVariables(3)).getProducerValue(1));
  }

  /**
   * Test {@link TracedVariables#reset(int)}.
   *
   * <ul>
   *   <li>Given {@link TracedVariables#TracedVariables(int)} with size is one.
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#reset(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedVariables.reset(int)"})
  public void testReset_givenTracedVariablesWithSizeIsOne_thenSecondElementIsNull() {
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
   * Test {@link TracedVariables#reset(int)}.
   *
   * <ul>
   *   <li>Then {@link TracedVariables#TracedVariables(int)} with size is three size is three.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#reset(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedVariables.reset(int)"})
  public void testReset_thenTracedVariablesWithSizeIsThreeSizeIsThree() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act
    tracedVariables.reset(3);

    // Assert that nothing has changed
    assertEquals(3, tracedVariables.size());
    assertEquals(3, tracedVariables.getValues().length);
  }

  /**
   * Test {@link TracedVariables#generalize(TracedVariables, boolean)} with {@code TracedVariables},
   * {@code boolean}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#generalize(TracedVariables, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedVariables.generalize(TracedVariables, boolean)"})
  public void testGeneralizeWithTracedVariablesBoolean_thenReturnFalse() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act and Assert
    assertFalse(tracedVariables.generalize(new TracedVariables(3), true));
  }

  /**
   * Test {@link TracedVariables#generalize(TracedVariables, boolean)} with {@code TracedVariables},
   * {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#generalize(TracedVariables, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedVariables.generalize(TracedVariables, boolean)"})
  public void testGeneralizeWithTracedVariablesBoolean_whenFalse_thenReturnFalse() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act and Assert
    assertFalse(tracedVariables.generalize(new TracedVariables(3), false));
  }

  /**
   * Test {@link TracedVariables#store(int, Value)}.
   *
   * <ul>
   *   <li>Then third element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#store(int, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedVariables.store(int, Value)"})
  public void testStore_thenThirdElementIsNull() {
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
   * Test {@link TracedVariables#store(int, Value)}.
   *
   * <ul>
   *   <li>Then third element {@link TopValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#store(int, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedVariables.store(int, Value)"})
  public void testStore_thenThirdElementTopValue() {
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
   * Test {@link TracedVariables#equals(Object)}, and {@link TracedVariables#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracedVariables#equals(Object)}
   *   <li>{@link TracedVariables#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedVariables.equals(Object)", "int TracedVariables.hashCode()"})
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
   * Test {@link TracedVariables#equals(Object)}, and {@link TracedVariables#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracedVariables#equals(Object)}
   *   <li>{@link TracedVariables#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedVariables.equals(Object)", "int TracedVariables.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act and Assert
    assertEquals(tracedVariables, tracedVariables);
    int expectedHashCodeResult = tracedVariables.hashCode();
    assertEquals(expectedHashCodeResult, tracedVariables.hashCode());
  }

  /**
   * Test {@link TracedVariables#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedVariables.equals(Object)", "int TracedVariables.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(1);

    // Act and Assert
    assertNotEquals(tracedVariables, new TracedVariables(3));
  }

  /**
   * Test {@link TracedVariables#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedVariables.equals(Object)", "int TracedVariables.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedVariables(3), null);
  }

  /**
   * Test {@link TracedVariables#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedVariables.equals(Object)", "int TracedVariables.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedVariables(3), "Different type to TracedVariables");
  }

  /**
   * Test {@link TracedVariables#toString()}.
   *
   * <p>Method under test: {@link TracedVariables#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TracedVariables.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("[empty:empty][empty:empty][empty:empty]", (new TracedVariables(3)).toString());
  }
}
