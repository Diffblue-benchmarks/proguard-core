package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.AbstractState;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.ArrayReferenceValue;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.ComparisonValue;
import proguard.evaluation.value.CompositeDoubleValue;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;

class ValueAbstractStateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValueAbstractState#ValueAbstractState(Value)}
   *   <li>{@link ValueAbstractState#setValue(Value)}
   *   <li>{@link ValueAbstractState#toString()}
   *   <li>{@link ValueAbstractState#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValueAbstractState.<init>(Value)",
    "Value ValueAbstractState.getValue()",
    "void ValueAbstractState.setValue(Value)",
    "String ValueAbstractState.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ValueAbstractState actualValueAbstractState =
        new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);
    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;
    actualValueAbstractState.setValue(value);
    String actualToStringResult = actualValueAbstractState.toString();

    // Assert
    assertEquals("ValueAbstractState(d)", actualToStringResult);
    assertSame(value, actualValueAbstractState.getValue());
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test join(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  void testJoinWithValueAbstractState() {
    // Arrange
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    TypedReferenceValue value = new TypedReferenceValue("Type", new LibraryClass(), true, false);
    valueAbstractState.setValue(value);

    ValueAbstractState abstractState = ValueAbstractState.UNKNOWN;
    TypedReferenceValue value2 = new TypedReferenceValue("Type", new LibraryClass(), true, false);
    abstractState.setValue(value2);

    // Act and Assert
    assertSame(ValueAbstractState.UNKNOWN, valueAbstractState.join(abstractState));
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test join(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  void testJoinWithValueAbstractState2() {
    // Arrange
    ArrayReferenceValue value =
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE);

    // Act and Assert
    assertEquals(
        ValueAbstractState.UNKNOWN, new ValueAbstractState(value).join(ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test join(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  void testJoinWithValueAbstractState3() {
    // Arrange
    ArrayReferenceValue value =
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE);

    // Act
    ValueAbstractState actualJoinResult =
        ValueAbstractState.UNKNOWN.join(new ValueAbstractState(value));

    // Assert
    assertEquals(ValueAbstractState.UNKNOWN, actualJoinResult);
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test join(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  void testJoinWithValueAbstractState4() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);
    TypedReferenceValue value = new TypedReferenceValue("Type", new LibraryClass(), true, false);
    valueAbstractState.setValue(value);

    ValueAbstractState abstractState = ValueAbstractState.UNKNOWN;
    TypedReferenceValue value2 = new TypedReferenceValue("Type", new LibraryClass(), true, false);
    abstractState.setValue(value2);

    // Act
    ValueAbstractState actualJoinResult = valueAbstractState.join(abstractState);

    // Assert
    assertSame(valueAbstractState, actualJoinResult);
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test join(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  void testJoinWithValueAbstractState5() {
    // Arrange
    ValueAbstractState valueAbstractState =
        new ValueAbstractState(
            new CompositeDoubleValue(
                BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));
    ValueAbstractState abstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);

    // Act
    ValueAbstractState actualJoinResult = valueAbstractState.join(abstractState);

    // Assert
    assertEquals(abstractState, actualJoinResult);
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#ValueAbstractState(Value)} with value is {@link
   *       BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(ValueAbstractState) with 'ValueAbstractState'; given ValueAbstractState(Value) with value is DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  void testJoinWithValueAbstractState_givenValueAbstractStateWithValueIsDouble_value() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);

    // Act
    ValueAbstractState actualJoinResult =
        valueAbstractState.join(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertSame(valueAbstractState, actualJoinResult);
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>Then Value return {@link TypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(ValueAbstractState) with 'ValueAbstractState'; then Value return TypedReferenceValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  void testJoinWithValueAbstractState_thenValueReturnTypedReferenceValue() {
    // Arrange, Act and Assert
    Value value =
        new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)
            .join(ValueAbstractState.UNKNOWN)
            .getValue();
    assertTrue(value instanceof TypedReferenceValue);
    assertEquals("Type", ((TypedReferenceValue) value).getType());
    assertEquals(-1, ((TypedReferenceValue) value).isNull());
    assertEquals(1, ((TypedReferenceValue) value).isNotNull());
    assertFalse(value.isParticular());
    assertTrue(((TypedReferenceValue) value).mayBeExtension());
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>When {@link ValueAbstractState#ValueAbstractState(Value)} with value is {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(ValueAbstractState) with 'ValueAbstractState'; when ValueAbstractState(Value) with value is REFERENCE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValueAbstractState ValueAbstractState.join(ValueAbstractState)"})
  void testJoinWithValueAbstractState_whenValueAbstractStateWithValueIsReference_value() {
    // Arrange
    ValueAbstractState abstractState = new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE);

    // Act
    ValueAbstractState actualJoinResult = ValueAbstractState.UNKNOWN.join(abstractState);

    // Assert
    assertEquals(abstractState, actualJoinResult);
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  void testIsLessOrEqualWithValueAbstractState() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);

    // Act
    boolean actualIsLessOrEqualResult =
        valueAbstractState.isLessOrEqual(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualIsLessOrEqualResult);
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  void testIsLessOrEqualWithValueAbstractState2() {
    // Arrange
    ValueAbstractState valueAbstractState =
        new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE);

    // Act
    boolean actualIsLessOrEqualResult =
        valueAbstractState.isLessOrEqual(new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE));

    // Assert
    assertTrue(actualIsLessOrEqualResult);
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  void testIsLessOrEqualWithValueAbstractState3() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.INTEGER_VALUE);

    // Act
    boolean actualIsLessOrEqualResult =
        valueAbstractState.isLessOrEqual(
            new ValueAbstractState(
                new ComparisonValue(
                    BasicValueFactory.DOUBLE_VALUE, BasicValueFactory.DOUBLE_VALUE)));

    // Assert
    assertFalse(actualIsLessOrEqualResult);
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  void testIsLessOrEqualWithValueAbstractState4() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.UNKNOWN_VALUE);

    // Act
    boolean actualIsLessOrEqualResult =
        valueAbstractState.isLessOrEqual(new ValueAbstractState(BasicValueFactory.UNKNOWN_VALUE));

    // Assert
    assertTrue(actualIsLessOrEqualResult);
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>When {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'; given UNKNOWN; when UNKNOWN; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValueAbstractState.isLessOrEqual(ValueAbstractState)"})
  void testIsLessOrEqualWithValueAbstractState_givenUnknown_whenUnknown_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ValueAbstractState.UNKNOWN.isLessOrEqual(ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link ValueAbstractState#copy()}.
   *
   * <p>Method under test: {@link ValueAbstractState#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AbstractState ValueAbstractState.copy()"})
  void testCopy() {
    // Arrange and Act
    AbstractState actualCopyResult = ValueAbstractState.UNKNOWN.copy();
    AbstractState actualCopyResult2 = actualCopyResult.copy();

    // Assert
    assertTrue(actualCopyResult2 instanceof ValueAbstractState);
    assertTrue(actualCopyResult instanceof ValueAbstractState);
    ValueAbstractState valueAbstractState = ((ValueAbstractState) actualCopyResult2).UNKNOWN;
    assertEquals(valueAbstractState, actualCopyResult2);
    assertEquals(valueAbstractState, actualCopyResult);
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}, and {@link ValueAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValueAbstractState#equals(Object)}
   *   <li>{@link ValueAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    ValueAbstractState valueAbstractState2 = ValueAbstractState.UNKNOWN;

    // Act and Assert
    assertEquals(valueAbstractState, valueAbstractState2);
    assertEquals(valueAbstractState.hashCode(), valueAbstractState2.hashCode());
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}, and {@link ValueAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValueAbstractState#equals(Object)}
   *   <li>{@link ValueAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;

    // Act and Assert
    assertEquals(valueAbstractState, valueAbstractState);
    int expectedHashCodeResult = valueAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, valueAbstractState.hashCode());
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE), ValueAbstractState.UNKNOWN);
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValueAbstractState.UNKNOWN, null);
  }

  /**
   * Test {@link ValueAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValueAbstractState.equals(Object)",
    "int ValueAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValueAbstractState.UNKNOWN, "Different type to ValueAbstractState");
  }
}
