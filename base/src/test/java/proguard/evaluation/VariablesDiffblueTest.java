package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.evaluation.exception.VariableEmptySlotException;
import proguard.evaluation.exception.VariableIndexOutOfBoundException;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.FloatValue;
import proguard.evaluation.value.TopValue;
import proguard.evaluation.value.Value;

public class VariablesDiffblueTest {
  /**
   * Method under test: {@link Variables#reset(int)}
   */
  @Test
  public void testReset() {
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
   * Method under test: {@link Variables#initialize(Variables)}
   */
  @Test
  public void testInitialize() {
    // Arrange
    Variables variables = new Variables(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> variables.initialize(new Variables(3)));
  }

  /**
   * Method under test: {@link Variables#generalize(Variables, boolean)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    Variables variables = new Variables(3);

    // Act and Assert
    assertFalse(variables.generalize(new Variables(3), true));
  }

  /**
   * Method under test: {@link Variables#generalize(Variables, boolean)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    Variables variables = new Variables(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> variables.generalize(new Variables(3), true));
  }

  /**
   * Method under test: {@link Variables#generalize(Variables, boolean)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    Variables variables = new Variables(3);

    // Act and Assert
    assertFalse(variables.generalize(new Variables(3), false));
  }

  /**
   * Method under test: {@link Variables#getValue(int)}
   */
  @Test
  public void testGetValue() {
    // Arrange, Act and Assert
    assertNull((new Variables(3)).getValue(1));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(3)).getValue(InitializationFinder.NONE));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(1)).getValue(1));
  }

  /**
   * Method under test: {@link Variables#store(int, Value)}
   */
  @Test
  public void testStore() {
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
   * Method under test: {@link Variables#store(int, Value)}
   */
  @Test
  public void testStore2() {
    // Arrange, Act and Assert
    assertThrows(VariableIndexOutOfBoundException.class,
        () -> (new Variables(3)).store(InitializationFinder.NONE, BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link Variables#store(int, Value)}
   */
  @Test
  public void testStore3() {
    // Arrange, Act and Assert
    assertThrows(VariableIndexOutOfBoundException.class,
        () -> (new Variables(1)).store(1, BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Method under test: {@link Variables#store(int, Value)}
   */
  @Test
  public void testStore4() {
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
   * Method under test: {@link Variables#load(int)}
   */
  @Test
  public void testLoad() {
    // Arrange, Act and Assert
    assertNull((new Variables(3)).load(1));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(3)).load(InitializationFinder.NONE));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(1)).load(1));
  }

  /**
   * Method under test: {@link Variables#iload(int)}
   */
  @Test
  public void testIload() {
    // Arrange, Act and Assert
    assertThrows(VariableEmptySlotException.class, () -> (new Variables(3)).iload(1));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(3)).iload(InitializationFinder.NONE));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(1)).iload(1));
  }

  /**
   * Method under test: {@link Variables#lload(int)}
   */
  @Test
  public void testLload() {
    // Arrange, Act and Assert
    assertThrows(VariableEmptySlotException.class, () -> (new Variables(3)).lload(1));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(3)).lload(InitializationFinder.NONE));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(1)).lload(1));
  }

  /**
   * Method under test: {@link Variables#fload(int)}
   */
  @Test
  public void testFload() {
    // Arrange, Act and Assert
    assertThrows(VariableEmptySlotException.class, () -> (new Variables(3)).fload(1));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(3)).fload(InitializationFinder.NONE));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(1)).fload(1));
  }

  /**
   * Method under test: {@link Variables#dload(int)}
   */
  @Test
  public void testDload() {
    // Arrange, Act and Assert
    assertThrows(VariableEmptySlotException.class, () -> (new Variables(3)).dload(1));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(3)).dload(InitializationFinder.NONE));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(1)).dload(1));
  }

  /**
   * Method under test: {@link Variables#aload(int)}
   */
  @Test
  public void testAload() {
    // Arrange, Act and Assert
    assertThrows(VariableEmptySlotException.class, () -> (new Variables(3)).aload(1));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(3)).aload(InitializationFinder.NONE));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(1)).aload(1));
  }

  /**
   * Method under test: {@link Variables#oload(int)}
   */
  @Test
  public void testOload() {
    // Arrange, Act and Assert
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(3)).oload(InitializationFinder.NONE));
    assertThrows(VariableIndexOutOfBoundException.class, () -> (new Variables(3)).oload(1001));
  }

  /**
   * Method under test: {@link Variables#replaceReferences(Value, Value)}
   */
  @Test
  public void testReplaceReferences() {
    // Arrange
    Variables variables = new Variables(3);

    // Act
    variables.replaceReferences(BasicValueFactory.DOUBLE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Assert that nothing has changed
    assertEquals(3, variables.getValues().length);
  }

  /**
   * Method under test: {@link Variables#replaceReferences(Value, Value)}
   */
  @Test
  public void testReplaceReferences2() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link Variables#equals(Object)}
   *   <li>{@link Variables#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Variables variables = new Variables(3);
    Variables variables2 = new Variables(3);

    // Act and Assert
    assertEquals(variables, variables2);
    int expectedHashCodeResult = variables.hashCode();
    assertEquals(expectedHashCodeResult, variables2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Variables#equals(Object)}
   *   <li>{@link Variables#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Variables variables = new Variables(3);

    // Act and Assert
    assertEquals(variables, variables);
    int expectedHashCodeResult = variables.hashCode();
    assertEquals(expectedHashCodeResult, variables.hashCode());
  }

  /**
   * Method under test: {@link Variables#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("[empty][empty][empty]", (new Variables(3)).toString());
    assertEquals("[empty:empty][empty:empty][empty:empty]", (new TracedVariables(3)).toString());
  }

  /**
   * Method under test: {@link Variables#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Variables variables = new Variables(1);

    // Act and Assert
    assertNotEquals(variables, new Variables(3));
  }

  /**
   * Method under test: {@link Variables#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Variables(3), null);
  }

  /**
   * Method under test: {@link Variables#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Variables(3), "Different type to Variables");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Variables#getValues()}
   *   <li>{@link Variables#size()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Variables variables = new Variables(3);

    // Act
    Value[] actualValues = variables.getValues();

    // Assert
    assertEquals(3, variables.size());
    assertSame(variables.values, actualValues);
  }

  /**
   * Method under test: {@link Variables#Variables(int)}
   */
  @Test
  public void testNewVariables() {
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
   * Method under test: {@link Variables#Variables(Variables)}
   */
  @Test
  public void testNewVariables2() {
    // Arrange
    Variables variables = new Variables(3);

    // Act and Assert
    assertEquals(variables, new Variables(variables));
  }
}
