package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.exception.VariableIndexOutOfBoundException;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.FloatValue;
import proguard.evaluation.value.TopValue;
import proguard.evaluation.value.Value;

class TracedVariablesDiffblueTest {
  /**
   * Test {@link TracedVariables#TracedVariables(TracedVariables)}.
   *
   * <p>Method under test: {@link TracedVariables#TracedVariables(TracedVariables)}
   */
  @Test
  @DisplayName("Test new TracedVariables(TracedVariables)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.<init>(TracedVariables)"})
  void testNewTracedVariables() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act
    TracedVariables actualTracedVariables = new TracedVariables(tracedVariables);

    // Assert
    assertEquals(tracedVariables, actualTracedVariables);
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
  @DisplayName("Test new TracedVariables(int); when three; then return first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.<init>(int)"})
  void testNewTracedVariables_whenThree_thenReturnFirstElementIsNull() {
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
   * Test {@link TracedVariables#setProducerValue(int, Value)} with {@code index}, {@code value}.
   *
   * <ul>
   *   <li>Given {@link TracedVariables#TracedVariables(int)} with size is one.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#setProducerValue(int, Value)}
   */
  @Test
  @DisplayName(
      "Test setProducerValue(int, Value) with 'index', 'value'; given TracedVariables(int) with size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.setProducerValue(int, Value)"})
  void testSetProducerValueWithIndexValue_givenTracedVariablesWithSizeIsOne() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new TracedVariables(1).setProducerValue(1, BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link TracedVariables#setProducerValue(int, Value)} with {@code index}, {@code value}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#setProducerValue(int, Value)}
   */
  @Test
  @DisplayName("Test setProducerValue(int, Value) with 'index', 'value'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.setProducerValue(int, Value)"})
  void testSetProducerValueWithIndexValue_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new TracedVariables(3).setProducerValue(1, BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link TracedVariables#setProducerValue(int, Value)} with {@code index}, {@code value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#setProducerValue(int, Value)}
   */
  @Test
  @DisplayName(
      "Test setProducerValue(int, Value) with 'index', 'value'; when FLOAT_VALUE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.setProducerValue(int, Value)"})
  void testSetProducerValueWithIndexValue_whenFloat_value_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new TracedVariables(3).setProducerValue(1, BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link TracedVariables#setProducerValue(int, Value)} with {@code index}, {@code value}.
   *
   * <ul>
   *   <li>When {@link TracedVariables#NONE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#setProducerValue(int, Value)}
   */
  @Test
  @DisplayName("Test setProducerValue(int, Value) with 'index', 'value'; when NONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.setProducerValue(int, Value)"})
  void testSetProducerValueWithIndexValue_whenNone() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () ->
            new TracedVariables(3)
                .setProducerValue(TracedVariables.NONE, BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link TracedVariables#getProducerValue(int)}.
   *
   * <ul>
   *   <li>Given {@link TracedVariables#TracedVariables(int)} with size is one.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#getProducerValue(int)}
   */
  @Test
  @DisplayName("Test getProducerValue(int); given TracedVariables(int) with size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracedVariables.getProducerValue(int)"})
  void testGetProducerValue_givenTracedVariablesWithSizeIsOne() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class, () -> new TracedVariables(1).getProducerValue(1));
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
  @DisplayName(
      "Test getProducerValue(int); given TracedVariables(int) with size is three; when one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracedVariables.getProducerValue(int)"})
  void testGetProducerValue_givenTracedVariablesWithSizeIsThree_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TracedVariables(3).getProducerValue(1));
  }

  /**
   * Test {@link TracedVariables#getProducerValue(int)}.
   *
   * <ul>
   *   <li>When {@link TracedVariables#NONE}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#getProducerValue(int)}
   */
  @Test
  @DisplayName("Test getProducerValue(int); when NONE; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracedVariables.getProducerValue(int)"})
  void testGetProducerValue_whenNone_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new TracedVariables(3).getProducerValue(TracedVariables.NONE));
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
  @DisplayName(
      "Test reset(int); given TracedVariables(int) with size is one; then second element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.reset(int)"})
  void testReset_givenTracedVariablesWithSizeIsOne_thenSecondElementIsNull() {
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
  @DisplayName("Test reset(int); then TracedVariables(int) with size is three size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.reset(int)"})
  void testReset_thenTracedVariablesWithSizeIsThreeSizeIsThree() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act
    tracedVariables.reset(3);

    // Assert that nothing has changed
    assertEquals(3, tracedVariables.size());
    assertEquals(3, tracedVariables.getValues().length);
  }

  /**
   * Test {@link TracedVariables#initialize(TracedVariables)} with {@code TracedVariables}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#initialize(TracedVariables)}
   */
  @Test
  @DisplayName("Test initialize(TracedVariables) with 'TracedVariables'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.initialize(TracedVariables)"})
  void testInitializeWithTracedVariables_thenDoesNotThrow() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act and Assert
    assertDoesNotThrow(() -> tracedVariables.initialize(new TracedVariables(3)));
  }

  /**
   * Test {@link TracedVariables#initialize(TracedVariables)} with {@code TracedVariables}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#initialize(TracedVariables)}
   */
  @Test
  @DisplayName(
      "Test initialize(TracedVariables) with 'TracedVariables'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.initialize(TracedVariables)"})
  void testInitializeWithTracedVariables_thenThrowIllegalArgumentException() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> tracedVariables.initialize(new TracedVariables(3)));
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
  @DisplayName(
      "Test generalize(TracedVariables, boolean) with 'TracedVariables', 'boolean'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracedVariables.generalize(TracedVariables, boolean)"})
  void testGeneralizeWithTracedVariablesBoolean_thenReturnFalse() {
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
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#generalize(TracedVariables, boolean)}
   */
  @Test
  @DisplayName(
      "Test generalize(TracedVariables, boolean) with 'TracedVariables', 'boolean'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracedVariables.generalize(TracedVariables, boolean)"})
  void testGeneralizeWithTracedVariablesBoolean_thenThrowIllegalArgumentException() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tracedVariables.generalize(new TracedVariables(3), true));
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
  @DisplayName(
      "Test generalize(TracedVariables, boolean) with 'TracedVariables', 'boolean'; when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracedVariables.generalize(TracedVariables, boolean)"})
  void testGeneralizeWithTracedVariablesBoolean_whenFalse_thenReturnFalse() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);

    // Act and Assert
    assertFalse(tracedVariables.generalize(new TracedVariables(3), false));
  }

  /**
   * Test {@link TracedVariables#store(int, Value)}.
   *
   * <ul>
   *   <li>Given {@link TracedVariables#TracedVariables(int)} with size is one ProducerValue is
   *       {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#store(int, Value)}
   */
  @Test
  @DisplayName(
      "Test store(int, Value); given TracedVariables(int) with size is one ProducerValue is DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.store(int, Value)"})
  void testStore_givenTracedVariablesWithSizeIsOneProducerValueIsDouble_value() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(1);
    tracedVariables.setProducerValue(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> tracedVariables.store(1, BasicValueFactory.DOUBLE_VALUE));
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
  @DisplayName("Test store(int, Value); then third element TopValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.store(int, Value)"})
  void testStore_thenThirdElementTopValue() {
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
   * Test {@link TracedVariables#store(int, Value)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then third element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#store(int, Value)}
   */
  @Test
  @DisplayName("Test store(int, Value); when FLOAT_VALUE; then third element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.store(int, Value)"})
  void testStore_whenFloat_value_thenThirdElementIsNull() {
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
   *   <li>When {@link TracedVariables#NONE}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link TracedVariables#store(int, Value)}
   */
  @Test
  @DisplayName("Test store(int, Value); when NONE; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TracedVariables.store(int, Value)"})
  void testStore_whenNone_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new TracedVariables(3).store(TracedVariables.NONE, BasicValueFactory.DOUBLE_VALUE));
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracedVariables.equals(Object)", "int TracedVariables.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);
    TracedVariables tracedVariables2 = new TracedVariables(3);

    // Act and Assert
    assertEquals(tracedVariables, tracedVariables2);
    assertEquals(tracedVariables.hashCode(), tracedVariables2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracedVariables.equals(Object)", "int TracedVariables.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracedVariables.equals(Object)", "int TracedVariables.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedVariables(3), 3);
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracedVariables.equals(Object)", "int TracedVariables.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracedVariables.equals(Object)", "int TracedVariables.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracedVariables.equals(Object)", "int TracedVariables.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TracedVariables(3), "Different type to TracedVariables");
  }

  /**
   * Test {@link TracedVariables#toString()}.
   *
   * <p>Method under test: {@link TracedVariables#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TracedVariables.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("[empty:empty][empty:empty][empty:empty]", new TracedVariables(3).toString());
  }
}
