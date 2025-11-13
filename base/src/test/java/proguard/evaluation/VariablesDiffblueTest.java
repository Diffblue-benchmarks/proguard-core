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
import proguard.evaluation.exception.VariableEmptySlotException;
import proguard.evaluation.exception.VariableIndexOutOfBoundException;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.FloatValue;
import proguard.evaluation.value.TopValue;
import proguard.evaluation.value.Value;

class VariablesDiffblueTest {
  /**
   * Test {@link Variables#Variables(Variables)}.
   *
   * <p>Method under test: {@link Variables#Variables(Variables)}
   */
  @Test
  @DisplayName("Test new Variables(Variables)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.<init>(Variables)"})
  void testNewVariables() {
    // Arrange
    Variables variables = new Variables(3);

    // Act
    Variables actualVariables = new Variables(variables);

    // Assert
    assertEquals(variables, actualVariables);
  }

  /**
   * Test {@link Variables#Variables(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#Variables(int)}
   */
  @Test
  @DisplayName("Test new Variables(int); when three; then return first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.<init>(int)"})
  void testNewVariables_whenThree_thenReturnFirstElementIsNull() {
    // Arrange and Act
    Variables actualVariables = new Variables(3);

    // Assert
    Value[] values = actualVariables.getValues();
    assertNull(values[0]);
    assertNull(values[1]);
    assertNull(values[2]);
    assertEquals(3, actualVariables.size());
    assertEquals(3, values.length);
  }

  /**
   * Test {@link Variables#reset(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is one.
   *   <li>Then second element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#reset(int)}
   */
  @Test
  @DisplayName(
      "Test reset(int); given Variables(int) with size is one; then second element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.reset(int)"})
  void testReset_givenVariablesWithSizeIsOne_thenSecondElementIsNull() {
    // Arrange
    Variables variables = new Variables(1);

    // Act
    variables.reset(3);

    // Assert
    Value[] values = variables.getValues();
    assertNull(values[1]);
    assertNull(values[2]);
    assertEquals(3, variables.size());
    assertEquals(3, values.length);
  }

  /**
   * Test {@link Variables#reset(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>Then {@link Variables#Variables(int)} with size is three size is three.
   * </ul>
   *
   * <p>Method under test: {@link Variables#reset(int)}
   */
  @Test
  @DisplayName(
      "Test reset(int); given Variables(int) with size is three; then Variables(int) with size is three size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.reset(int)"})
  void testReset_givenVariablesWithSizeIsThree_thenVariablesWithSizeIsThreeSizeIsThree() {
    // Arrange
    Variables variables = new Variables(3);

    // Act
    variables.reset(3);

    // Assert that nothing has changed
    assertEquals(3, variables.size());
    assertEquals(3, variables.getValues().length);
  }

  /**
   * Test {@link Variables#reset(int)}.
   *
   * <ul>
   *   <li>Then {@link TracedVariables#TracedVariables(int)} with size is three size is three.
   * </ul>
   *
   * <p>Method under test: {@link Variables#reset(int)}
   */
  @Test
  @DisplayName("Test reset(int); then TracedVariables(int) with size is three size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.reset(int)"})
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
   * Test {@link Variables#initialize(Variables)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#initialize(Variables)}
   */
  @Test
  @DisplayName(
      "Test initialize(Variables); given Variables(int) with size is one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.initialize(Variables)"})
  void testInitialize_givenVariablesWithSizeIsOne_thenThrowIllegalArgumentException() {
    // Arrange
    Variables variables = new Variables(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> variables.initialize(new Variables(3)));
  }

  /**
   * Test {@link Variables#initialize(Variables)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link Variables#initialize(Variables)}
   */
  @Test
  @DisplayName(
      "Test initialize(Variables); given Variables(int) with size is three; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.initialize(Variables)"})
  void testInitialize_givenVariablesWithSizeIsThree_thenDoesNotThrow() {
    // Arrange
    Variables variables = new Variables(3);

    // Act and Assert
    assertDoesNotThrow(() -> variables.initialize(new Variables(3)));
  }

  /**
   * Test {@link Variables#generalize(Variables, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#generalize(Variables, boolean)}
   */
  @Test
  @DisplayName(
      "Test generalize(Variables, boolean); given Variables(int) with size is one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Variables.generalize(Variables, boolean)"})
  void testGeneralize_givenVariablesWithSizeIsOne_thenThrowIllegalArgumentException() {
    // Arrange
    Variables variables = new Variables(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> variables.generalize(new Variables(3), true));
  }

  /**
   * Test {@link Variables#generalize(Variables, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#generalize(Variables, boolean)}
   */
  @Test
  @DisplayName(
      "Test generalize(Variables, boolean); given Variables(int) with size is three; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Variables.generalize(Variables, boolean)"})
  void testGeneralize_givenVariablesWithSizeIsThree_thenReturnFalse() {
    // Arrange
    Variables variables = new Variables(3);

    // Act and Assert
    assertFalse(variables.generalize(new Variables(3), true));
  }

  /**
   * Test {@link Variables#generalize(Variables, boolean)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#generalize(Variables, boolean)}
   */
  @Test
  @DisplayName(
      "Test generalize(Variables, boolean); given Variables(int) with size is three; when 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Variables.generalize(Variables, boolean)"})
  void testGeneralize_givenVariablesWithSizeIsThree_whenFalse_thenReturnFalse() {
    // Arrange
    Variables variables = new Variables(3);

    // Act and Assert
    assertFalse(variables.generalize(new Variables(3), false));
  }

  /**
   * Test {@link Variables#getValue(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is one.
   * </ul>
   *
   * <p>Method under test: {@link Variables#getValue(int)}
   */
  @Test
  @DisplayName("Test getValue(int); given Variables(int) with size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Variables.getValue(int)"})
  void testGetValue_givenVariablesWithSizeIsOne() {
    // Arrange, Act and Assert
    assertThrows(VariableIndexOutOfBoundException.class, () -> new Variables(1).getValue(1));
  }

  /**
   * Test {@link Variables#getValue(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#getValue(int)}
   */
  @Test
  @DisplayName(
      "Test getValue(int); given Variables(int) with size is three; when one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Variables.getValue(int)"})
  void testGetValue_givenVariablesWithSizeIsThree_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Variables(3).getValue(1));
  }

  /**
   * Test {@link Variables#getValue(int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#getValue(int)}
   */
  @Test
  @DisplayName("Test getValue(int); when NONE; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Variables.getValue(int)"})
  void testGetValue_whenNone_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new Variables(3).getValue(InitializationFinder.NONE));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Variables#getValues()}
   *   <li>{@link Variables#size()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value[] Variables.getValues()", "int Variables.size()"})
  void testGettersAndSetters() {
    // Arrange
    Variables variables = new Variables(3);

    // Act
    Value[] actualValues = variables.getValues();

    // Assert
    assertEquals(3, variables.size());
    assertSame(variables.values, actualValues);
  }

  /**
   * Test {@link Variables#store(int, Value)}.
   *
   * <ul>
   *   <li>Given {@link TracedVariables#TracedVariables(int)} with size is three ProducerValue is
   *       {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#store(int, Value)}
   */
  @Test
  @DisplayName(
      "Test store(int, Value); given TracedVariables(int) with size is three ProducerValue is FLOAT_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.store(int, Value)"})
  void testStore_givenTracedVariablesWithSizeIsThreeProducerValueIsFloat_value() {
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
   * Test {@link Variables#store(int, Value)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is one.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#store(int, Value)}
   */
  @Test
  @DisplayName(
      "Test store(int, Value); given Variables(int) with size is one; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.store(int, Value)"})
  void testStore_givenVariablesWithSizeIsOne_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new Variables(1).store(1, BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link Variables#store(int, Value)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then third element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#store(int, Value)}
   */
  @Test
  @DisplayName(
      "Test store(int, Value); given Variables(int) with size is three; when FLOAT_VALUE; then third element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.store(int, Value)"})
  void testStore_givenVariablesWithSizeIsThree_whenFloat_value_thenThirdElementIsNull() {
    // Arrange
    Variables variables = new Variables(3);
    FloatValue value = BasicValueFactory.FLOAT_VALUE;

    // Act
    variables.store(1, value);

    // Assert
    Value[] values = variables.getValues();
    assertNull(values[2]);
    assertEquals(3, values.length);
    assertSame(value, values[1]);
  }

  /**
   * Test {@link Variables#store(int, Value)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>When one.
   *   <li>Then third element {@link TopValue}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#store(int, Value)}
   */
  @Test
  @DisplayName(
      "Test store(int, Value); given Variables(int) with size is three; when one; then third element TopValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.store(int, Value)"})
  void testStore_givenVariablesWithSizeIsThree_whenOne_thenThirdElementTopValue() {
    // Arrange
    Variables variables = new Variables(3);
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act
    variables.store(1, value);

    // Assert
    Value[] values = variables.getValues();
    Value value2 = values[2];
    assertTrue(value2 instanceof TopValue);
    assertEquals(3, values.length);
    assertFalse(value2.isCategory2());
    assertTrue(value2.isParticular());
    assertTrue(value2.isSpecific());
    assertSame(value, values[1]);
  }

  /**
   * Test {@link Variables#store(int, Value)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#store(int, Value)}
   */
  @Test
  @DisplayName("Test store(int, Value); when NONE; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.store(int, Value)"})
  void testStore_whenNone_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new Variables(3).store(InitializationFinder.NONE, BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link Variables#load(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is one.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#load(int)}
   */
  @Test
  @DisplayName(
      "Test load(int); given Variables(int) with size is one; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Variables.load(int)"})
  void testLoad_givenVariablesWithSizeIsOne_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(VariableIndexOutOfBoundException.class, () -> new Variables(1).load(1));
  }

  /**
   * Test {@link Variables#load(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#load(int)}
   */
  @Test
  @DisplayName(
      "Test load(int); given Variables(int) with size is three; when one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Variables.load(int)"})
  void testLoad_givenVariablesWithSizeIsThree_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Variables(3).load(1));
  }

  /**
   * Test {@link Variables#load(int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#load(int)}
   */
  @Test
  @DisplayName("Test load(int); when NONE; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value Variables.load(int)"})
  void testLoad_whenNone_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new Variables(3).load(InitializationFinder.NONE));
  }

  /**
   * Test {@link Variables#iload(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is one.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#iload(int)}
   */
  @Test
  @DisplayName(
      "Test iload(int); given Variables(int) with size is one; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.IntegerValue Variables.iload(int)"})
  void testIload_givenVariablesWithSizeIsOne_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(VariableIndexOutOfBoundException.class, () -> new Variables(1).iload(1));
  }

  /**
   * Test {@link Variables#iload(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>Then throw {@link VariableEmptySlotException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#iload(int)}
   */
  @Test
  @DisplayName(
      "Test iload(int); given Variables(int) with size is three; then throw VariableEmptySlotException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.IntegerValue Variables.iload(int)"})
  void testIload_givenVariablesWithSizeIsThree_thenThrowVariableEmptySlotException() {
    // Arrange, Act and Assert
    assertThrows(VariableEmptySlotException.class, () -> new Variables(3).iload(1));
  }

  /**
   * Test {@link Variables#iload(int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#iload(int)}
   */
  @Test
  @DisplayName("Test iload(int); when NONE; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.IntegerValue Variables.iload(int)"})
  void testIload_whenNone_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new Variables(3).iload(InitializationFinder.NONE));
  }

  /**
   * Test {@link Variables#lload(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is one.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#lload(int)}
   */
  @Test
  @DisplayName(
      "Test lload(int); given Variables(int) with size is one; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.LongValue Variables.lload(int)"})
  void testLload_givenVariablesWithSizeIsOne_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(VariableIndexOutOfBoundException.class, () -> new Variables(1).lload(1));
  }

  /**
   * Test {@link Variables#lload(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>Then throw {@link VariableEmptySlotException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#lload(int)}
   */
  @Test
  @DisplayName(
      "Test lload(int); given Variables(int) with size is three; then throw VariableEmptySlotException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.LongValue Variables.lload(int)"})
  void testLload_givenVariablesWithSizeIsThree_thenThrowVariableEmptySlotException() {
    // Arrange, Act and Assert
    assertThrows(VariableEmptySlotException.class, () -> new Variables(3).lload(1));
  }

  /**
   * Test {@link Variables#lload(int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#lload(int)}
   */
  @Test
  @DisplayName("Test lload(int); when NONE; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.LongValue Variables.lload(int)"})
  void testLload_whenNone_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new Variables(3).lload(InitializationFinder.NONE));
  }

  /**
   * Test {@link Variables#fload(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is one.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#fload(int)}
   */
  @Test
  @DisplayName(
      "Test fload(int); given Variables(int) with size is one; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue Variables.fload(int)"})
  void testFload_givenVariablesWithSizeIsOne_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(VariableIndexOutOfBoundException.class, () -> new Variables(1).fload(1));
  }

  /**
   * Test {@link Variables#fload(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>Then throw {@link VariableEmptySlotException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#fload(int)}
   */
  @Test
  @DisplayName(
      "Test fload(int); given Variables(int) with size is three; then throw VariableEmptySlotException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue Variables.fload(int)"})
  void testFload_givenVariablesWithSizeIsThree_thenThrowVariableEmptySlotException() {
    // Arrange, Act and Assert
    assertThrows(VariableEmptySlotException.class, () -> new Variables(3).fload(1));
  }

  /**
   * Test {@link Variables#fload(int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#fload(int)}
   */
  @Test
  @DisplayName("Test fload(int); when NONE; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue Variables.fload(int)"})
  void testFload_whenNone_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new Variables(3).fload(InitializationFinder.NONE));
  }

  /**
   * Test {@link Variables#dload(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is one.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#dload(int)}
   */
  @Test
  @DisplayName(
      "Test dload(int); given Variables(int) with size is one; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue Variables.dload(int)"})
  void testDload_givenVariablesWithSizeIsOne_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(VariableIndexOutOfBoundException.class, () -> new Variables(1).dload(1));
  }

  /**
   * Test {@link Variables#dload(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>Then throw {@link VariableEmptySlotException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#dload(int)}
   */
  @Test
  @DisplayName(
      "Test dload(int); given Variables(int) with size is three; then throw VariableEmptySlotException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue Variables.dload(int)"})
  void testDload_givenVariablesWithSizeIsThree_thenThrowVariableEmptySlotException() {
    // Arrange, Act and Assert
    assertThrows(VariableEmptySlotException.class, () -> new Variables(3).dload(1));
  }

  /**
   * Test {@link Variables#dload(int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#dload(int)}
   */
  @Test
  @DisplayName("Test dload(int); when NONE; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue Variables.dload(int)"})
  void testDload_whenNone_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new Variables(3).dload(InitializationFinder.NONE));
  }

  /**
   * Test {@link Variables#aload(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is one.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#aload(int)}
   */
  @Test
  @DisplayName(
      "Test aload(int); given Variables(int) with size is one; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.ReferenceValue Variables.aload(int)"})
  void testAload_givenVariablesWithSizeIsOne_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(VariableIndexOutOfBoundException.class, () -> new Variables(1).aload(1));
  }

  /**
   * Test {@link Variables#aload(int)}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>Then throw {@link VariableEmptySlotException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#aload(int)}
   */
  @Test
  @DisplayName(
      "Test aload(int); given Variables(int) with size is three; then throw VariableEmptySlotException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.ReferenceValue Variables.aload(int)"})
  void testAload_givenVariablesWithSizeIsThree_thenThrowVariableEmptySlotException() {
    // Arrange, Act and Assert
    assertThrows(VariableEmptySlotException.class, () -> new Variables(3).aload(1));
  }

  /**
   * Test {@link Variables#aload(int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#aload(int)}
   */
  @Test
  @DisplayName("Test aload(int); when NONE; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.ReferenceValue Variables.aload(int)"})
  void testAload_whenNone_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new Variables(3).aload(InitializationFinder.NONE));
  }

  /**
   * Test {@link Variables#oload(int)}.
   *
   * <ul>
   *   <li>When {@code 1001}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#oload(int)}
   */
  @Test
  @DisplayName("Test oload(int); when '1001'; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.InstructionOffsetValue Variables.oload(int)"})
  void testOload_when1001_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(VariableIndexOutOfBoundException.class, () -> new Variables(3).oload(1001));
  }

  /**
   * Test {@link Variables#oload(int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then throw {@link VariableIndexOutOfBoundException}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#oload(int)}
   */
  @Test
  @DisplayName("Test oload(int); when NONE; then throw VariableIndexOutOfBoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.InstructionOffsetValue Variables.oload(int)"})
  void testOload_whenNone_thenThrowVariableIndexOutOfBoundException() {
    // Arrange, Act and Assert
    assertThrows(
        VariableIndexOutOfBoundException.class,
        () -> new Variables(3).oload(InitializationFinder.NONE));
  }

  /**
   * Test {@link Variables#replaceReferences(Value, Value)}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#replaceReferences(Value, Value)}
   */
  @Test
  @DisplayName("Test replaceReferences(Value, Value); when DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.replaceReferences(Value, Value)"})
  void testReplaceReferences_whenDouble_value() {
    // Arrange
    Variables variables = new Variables(3);

    // Act
    variables.replaceReferences(BasicValueFactory.DOUBLE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Assert that nothing has changed
    assertEquals(3, variables.getValues().length);
  }

  /**
   * Test {@link Variables#replaceReferences(Value, Value)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then first element is {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#replaceReferences(Value, Value)}
   */
  @Test
  @DisplayName(
      "Test replaceReferences(Value, Value); when 'null'; then first element is DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Variables.replaceReferences(Value, Value)"})
  void testReplaceReferences_whenNull_thenFirstElementIsDouble_value() {
    // Arrange
    Variables variables = new Variables(3);
    DoubleValue replacement = BasicValueFactory.DOUBLE_VALUE;

    // Act
    variables.replaceReferences(null, replacement);

    // Assert
    Value[] values = variables.getValues();
    assertEquals(3, values.length);
    assertSame(replacement, values[0]);
    assertSame(replacement, values[1]);
    assertSame(replacement, values[2]);
  }

  /**
   * Test {@link Variables#equals(Object)}, and {@link Variables#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Variables#equals(Object)}
   *   <li>{@link Variables#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Variables.equals(Object)", "int Variables.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Variables variables = new Variables(3);
    Variables variables2 = new Variables(3);

    // Act and Assert
    assertEquals(variables, variables2);
    assertEquals(variables.hashCode(), variables2.hashCode());
  }

  /**
   * Test {@link Variables#equals(Object)}, and {@link Variables#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link Variables#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Variables.equals(Object)", "int Variables.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TracedVariables tracedVariables = new TracedVariables(3);
    TracedVariables tracedVariables2 = new TracedVariables(3);

    // Act and Assert
    assertEquals(tracedVariables, tracedVariables2);
    assertEquals(tracedVariables.hashCode(), tracedVariables2.hashCode());
  }

  /**
   * Test {@link Variables#equals(Object)}, and {@link Variables#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Variables#equals(Object)}
   *   <li>{@link Variables#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Variables.equals(Object)", "int Variables.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Variables variables = new Variables(3);

    // Act and Assert
    assertEquals(variables, variables);
    int expectedHashCodeResult = variables.hashCode();
    assertEquals(expectedHashCodeResult, variables.hashCode());
  }

  /**
   * Test {@link Variables#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Variables#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Variables.equals(Object)", "int Variables.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Variables variables = new Variables(1);

    // Act and Assert
    assertNotEquals(variables, new Variables(3));
  }

  /**
   * Test {@link Variables#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Variables#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Variables.equals(Object)", "int Variables.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Variables(3), null);
  }

  /**
   * Test {@link Variables#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Variables#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Variables.equals(Object)", "int Variables.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Variables(3), "Different type to Variables");
  }

  /**
   * Test {@link Variables#toString()}.
   *
   * <ul>
   *   <li>Given {@link Variables#Variables(int)} with size is three.
   *   <li>Then return {@code [empty][empty][empty]}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given Variables(int) with size is three; then return '[empty][empty][empty]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Variables.toString()"})
  void testToString_givenVariablesWithSizeIsThree_thenReturnEmptyEmptyEmpty() {
    // Arrange, Act and Assert
    assertEquals("[empty][empty][empty]", new Variables(3).toString());
  }

  /**
   * Test {@link Variables#toString()}.
   *
   * <ul>
   *   <li>Then return {@code [empty:empty][empty:empty][empty:empty]}.
   * </ul>
   *
   * <p>Method under test: {@link Variables#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '[empty:empty][empty:empty][empty:empty]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Variables.toString()"})
  void testToString_thenReturnEmptyEmptyEmptyEmptyEmptyEmpty() {
    // Arrange, Act and Assert
    assertEquals("[empty:empty][empty:empty][empty:empty]", new TracedVariables(3).toString());
  }
}
