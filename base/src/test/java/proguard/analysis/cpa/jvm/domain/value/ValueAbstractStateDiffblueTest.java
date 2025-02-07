package proguard.analysis.cpa.jvm.domain.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.AbstractState;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.ArrayReferenceValue;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.CompositeFloatValue;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.<init>(proguard.evaluation.value.Value)",
    "proguard.evaluation.value.Value proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.getValue()",
    "void proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.setValue(proguard.evaluation.value.Value)",
    "java.lang.String proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.toString()"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.join(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testJoinWithValueAbstractState() {
    // Arrange and Act
    ValueAbstractState actualJoinResult =
        (new ValueAbstractState(
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE)))
            .join(ValueAbstractState.UNKNOWN);

    // Assert
    assertEquals(actualJoinResult.UNKNOWN, actualJoinResult);
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test join(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.join(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testJoinWithValueAbstractState2() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertSame(
        valueAbstractState,
        valueAbstractState.join(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)));
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test join(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.join(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testJoinWithValueAbstractState3() {
    // Arrange and Act
    ValueAbstractState actualJoinResult =
        ValueAbstractState.UNKNOWN.join(
            new ValueAbstractState(
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE)));

    // Assert
    assertEquals(actualJoinResult.UNKNOWN, actualJoinResult);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.join(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testJoinWithValueAbstractState_givenValueAbstractStateWithValueIsDouble_value() {
    // Arrange and Act
    ValueAbstractState actualJoinResult =
        (new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)).join(ValueAbstractState.UNKNOWN);

    // Assert
    Value value = actualJoinResult.getValue();
    assertTrue(((TypedReferenceValue) value).getReferencedClass() instanceof LibraryClass);
    assertTrue(value instanceof TypedReferenceValue);
    assertSame(actualJoinResult.UNKNOWN, actualJoinResult);
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#ValueAbstractState(Value)} with value is {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(ValueAbstractState) with 'ValueAbstractState'; given ValueAbstractState(Value) with value is REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.join(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testJoinWithValueAbstractState_givenValueAbstractStateWithValueIsReference_value() {
    // Arrange
    ValueAbstractState valueAbstractState =
        new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertEquals(valueAbstractState, valueAbstractState.join(ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>Then Value ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(ValueAbstractState) with 'ValueAbstractState'; then Value ReferencedClass return LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.join(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testJoinWithValueAbstractState_thenValueReferencedClassReturnLibraryClass() {
    // Arrange and Act
    ValueAbstractState actualJoinResult =
        ValueAbstractState.UNKNOWN.join(ValueAbstractState.UNKNOWN);

    // Assert
    Value value = actualJoinResult.getValue();
    assertTrue(((TypedReferenceValue) value).getReferencedClass() instanceof LibraryClass);
    assertTrue(value instanceof TypedReferenceValue);
    assertSame(actualJoinResult.UNKNOWN, actualJoinResult);
  }

  /**
   * Test {@link ValueAbstractState#join(ValueAbstractState)} with {@code ValueAbstractState}.
   *
   * <ul>
   *   <li>When {@link ValueAbstractState#ValueAbstractState(Value)} with value is {@link
   *       BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#join(ValueAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(ValueAbstractState) with 'ValueAbstractState'; when ValueAbstractState(Value) with value is DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.join(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testJoinWithValueAbstractState_whenValueAbstractStateWithValueIsDouble_value() {
    // Arrange and Act
    ValueAbstractState actualJoinResult =
        ValueAbstractState.UNKNOWN.join(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));

    // Assert
    Value value = actualJoinResult.getValue();
    assertTrue(((TypedReferenceValue) value).getReferencedClass() instanceof LibraryClass);
    assertTrue(value instanceof TypedReferenceValue);
    assertSame(actualJoinResult.UNKNOWN, actualJoinResult);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.value.ValueAbstractState proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.join(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testJoinWithValueAbstractState_whenValueAbstractStateWithValueIsReference_value() {
    // Arrange
    ValueAbstractState abstractState = new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertEquals(abstractState, ValueAbstractState.UNKNOWN.join(abstractState));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testIsLessOrEqualWithValueAbstractState() {
    // Arrange, Act and Assert
    assertFalse(
        ValueAbstractState.UNKNOWN.isLessOrEqual(
            new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testIsLessOrEqualWithValueAbstractState2() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertTrue(
        valueAbstractState.isLessOrEqual(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testIsLessOrEqualWithValueAbstractState3() {
    // Arrange, Act and Assert
    assertTrue(
        ValueAbstractState.UNKNOWN.isLessOrEqual(
            new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE)));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testIsLessOrEqualWithValueAbstractState4() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertFalse(
        valueAbstractState.isLessOrEqual(
            new ValueAbstractState(
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE))));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testIsLessOrEqualWithValueAbstractState5() {
    // Arrange
    ValueAbstractState valueAbstractState =
        new ValueAbstractState(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertFalse(
        valueAbstractState.isLessOrEqual(
            new ValueAbstractState(
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE))));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testIsLessOrEqualWithValueAbstractState6() {
    // Arrange, Act and Assert
    assertFalse(
        ValueAbstractState.UNKNOWN.isLessOrEqual(
            new ValueAbstractState(
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE))));
  }

  /**
   * Test {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)} with {@code
   * ValueAbstractState}.
   *
   * <p>Method under test: {@link ValueAbstractState#isLessOrEqual(ValueAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ValueAbstractState) with 'ValueAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
  void testIsLessOrEqualWithValueAbstractState7() {
    // Arrange
    ValueAbstractState valueAbstractState = new ValueAbstractState(BasicValueFactory.UNKNOWN_VALUE);

    // Act and Assert
    assertTrue(
        valueAbstractState.isLessOrEqual(new ValueAbstractState(BasicValueFactory.UNKNOWN_VALUE)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.value.ValueAbstractState)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.interfaces.AbstractState proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.copy()"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    ValueAbstractState valueAbstractState2 = ValueAbstractState.UNKNOWN;

    // Act and Assert
    assertEquals(valueAbstractState, valueAbstractState2);
    int expectedHashCodeResult = valueAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, valueAbstractState2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.hashCode()"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.hashCode()"
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
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ValueAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ValueAbstractState(BasicValueFactory.UNKNOWN_VALUE), ValueAbstractState.UNKNOWN);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.hashCode()"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.value.ValueAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ValueAbstractState.UNKNOWN, "Different type to ValueAbstractState");
  }
}
