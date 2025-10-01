package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.evaluation.value.BasicValueFactory;

class StackAbstractStateDiffblueTest {
  /**
   * Test {@link StackAbstractState#join(StackAbstractState)} with {@code StackAbstractState}.
   *
   * <ul>
   *   <li>Given {@link StackAbstractState} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#join(StackAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(StackAbstractState) with 'StackAbstractState'; given StackAbstractState (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StackAbstractState StackAbstractState.join(StackAbstractState)"})
  void testJoinWithStackAbstractState_givenStackAbstractState() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();

    StackAbstractState<ValueAbstractState> abstractState = new StackAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act
    StackAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(abstractState);

    // Assert
    assertSame(abstractState, actualJoinResult);
  }

  /**
   * Test {@link StackAbstractState#join(StackAbstractState)} with {@code StackAbstractState}.
   *
   * <ul>
   *   <li>Given {@link StackAbstractState} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#join(StackAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(StackAbstractState) with 'StackAbstractState'; given StackAbstractState (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StackAbstractState StackAbstractState.join(StackAbstractState)"})
  void testJoinWithStackAbstractState_givenStackAbstractState2() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();

    StackAbstractState<ValueAbstractState> abstractState = new StackAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act
    StackAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(abstractState);

    // Assert
    assertSame(abstractState, actualJoinResult);
  }

  /**
   * Test {@link StackAbstractState#join(StackAbstractState)} with {@code StackAbstractState}.
   *
   * <ul>
   *   <li>Given {@link StackAbstractState} (default constructor) add {@link
   *       ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#join(StackAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(StackAbstractState) with 'StackAbstractState'; given StackAbstractState (default constructor) add UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StackAbstractState StackAbstractState.join(StackAbstractState)"})
  void testJoinWithStackAbstractState_givenStackAbstractStateAddUnknown() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    StackAbstractState<ValueAbstractState> abstractState = new StackAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act
    StackAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(abstractState);

    // Assert
    assertSame(abstractState, actualJoinResult);
  }

  /**
   * Test {@link StackAbstractState#join(StackAbstractState)} with {@code StackAbstractState}.
   *
   * <ul>
   *   <li>Given {@link StackAbstractState} (default constructor).
   *   <li>When {@link StackAbstractState} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#join(StackAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(StackAbstractState) with 'StackAbstractState'; given StackAbstractState (default constructor); when StackAbstractState (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StackAbstractState StackAbstractState.join(StackAbstractState)"})
  void testJoinWithStackAbstractState_givenStackAbstractState_whenStackAbstractState() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();
    StackAbstractState<ValueAbstractState> abstractState = new StackAbstractState<>();

    // Act
    StackAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(abstractState);

    // Assert
    assertSame(abstractState, actualJoinResult);
  }

  /**
   * Test {@link StackAbstractState#join(StackAbstractState)} with {@code StackAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#ValueAbstractState(Value)} with value is {@link
   *       BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#join(StackAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(StackAbstractState) with 'StackAbstractState'; given ValueAbstractState(Value) with value is DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StackAbstractState StackAbstractState.join(StackAbstractState)"})
  void testJoinWithStackAbstractState_givenValueAbstractStateWithValueIsDouble_value() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    StackAbstractState<ValueAbstractState> abstractState = new StackAbstractState<>();
    abstractState.add(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));

    // Act
    StackAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(abstractState);

    // Assert
    assertEquals(valueAbstractStateList, actualJoinResult);
  }

  /**
   * Test {@link StackAbstractState#join(StackAbstractState)} with {@code StackAbstractState}.
   *
   * <ul>
   *   <li>When {@link StackAbstractState} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#join(StackAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(StackAbstractState) with 'StackAbstractState'; when StackAbstractState (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StackAbstractState StackAbstractState.join(StackAbstractState)"})
  void testJoinWithStackAbstractState_whenStackAbstractState() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    // Act
    StackAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(new StackAbstractState<>());

    // Assert
    assertSame(valueAbstractStateList, actualJoinResult);
  }

  /**
   * Test {@link StackAbstractState#isLessOrEqual(StackAbstractState)} with {@code
   * StackAbstractState}.
   *
   * <p>Method under test: {@link StackAbstractState#isLessOrEqual(StackAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(StackAbstractState) with 'StackAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackAbstractState.isLessOrEqual(StackAbstractState)"})
  void testIsLessOrEqualWithStackAbstractState() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    StackAbstractState<ValueAbstractState> abstractState = new StackAbstractState<>();
    abstractState.add(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));

    // Act and Assert
    assertFalse(valueAbstractStateList.isLessOrEqual(abstractState));
  }

  /**
   * Test {@link StackAbstractState#isLessOrEqual(StackAbstractState)} with {@code
   * StackAbstractState}.
   *
   * <ul>
   *   <li>Given {@link StackAbstractState} (default constructor) add {@link
   *       ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#isLessOrEqual(StackAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(StackAbstractState) with 'StackAbstractState'; given StackAbstractState (default constructor) add UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackAbstractState.isLessOrEqual(StackAbstractState)"})
  void testIsLessOrEqualWithStackAbstractState_givenStackAbstractStateAddUnknown() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    StackAbstractState<ValueAbstractState> abstractState = new StackAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertTrue(valueAbstractStateList.isLessOrEqual(abstractState));
  }

  /**
   * Test {@link StackAbstractState#isLessOrEqual(StackAbstractState)} with {@code
   * StackAbstractState}.
   *
   * <ul>
   *   <li>Given {@link StackAbstractState} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#isLessOrEqual(StackAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(StackAbstractState) with 'StackAbstractState'; given StackAbstractState (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackAbstractState.isLessOrEqual(StackAbstractState)"})
  void testIsLessOrEqualWithStackAbstractState_givenStackAbstractState_thenReturnTrue() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();

    StackAbstractState<ValueAbstractState> abstractState = new StackAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertTrue(valueAbstractStateList.isLessOrEqual(abstractState));
  }

  /**
   * Test {@link StackAbstractState#isLessOrEqual(StackAbstractState)} with {@code
   * StackAbstractState}.
   *
   * <ul>
   *   <li>Given {@link StackAbstractState} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#isLessOrEqual(StackAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(StackAbstractState) with 'StackAbstractState'; given StackAbstractState (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackAbstractState.isLessOrEqual(StackAbstractState)"})
  void testIsLessOrEqualWithStackAbstractState_givenStackAbstractState_thenReturnTrue2() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();

    StackAbstractState<ValueAbstractState> abstractState = new StackAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertTrue(valueAbstractStateList.isLessOrEqual(abstractState));
  }

  /**
   * Test {@link StackAbstractState#isLessOrEqual(StackAbstractState)} with {@code
   * StackAbstractState}.
   *
   * <ul>
   *   <li>When {@link StackAbstractState} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#isLessOrEqual(StackAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(StackAbstractState) with 'StackAbstractState'; when StackAbstractState (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackAbstractState.isLessOrEqual(StackAbstractState)"})
  void testIsLessOrEqualWithStackAbstractState_whenStackAbstractState() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();

    // Act and Assert
    assertTrue(valueAbstractStateList.isLessOrEqual(new StackAbstractState<>()));
  }

  /**
   * Test {@link StackAbstractState#isLessOrEqual(StackAbstractState)} with {@code
   * StackAbstractState}.
   *
   * <ul>
   *   <li>When {@link StackAbstractState} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#isLessOrEqual(StackAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(StackAbstractState) with 'StackAbstractState'; when StackAbstractState (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackAbstractState.isLessOrEqual(StackAbstractState)"})
  void testIsLessOrEqualWithStackAbstractState_whenStackAbstractState_thenReturnFalse() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertFalse(valueAbstractStateList.isLessOrEqual(new StackAbstractState<>()));
  }

  /**
   * Test {@link StackAbstractState#copy()}.
   *
   * <p>Method under test: {@link StackAbstractState#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StackAbstractState StackAbstractState.copy()"})
  void testCopy() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();

    // Act
    StackAbstractState<ValueAbstractState> actualCopyResult = valueAbstractStateList.copy();

    // Assert
    assertEquals(valueAbstractStateList, actualCopyResult);
  }

  /**
   * Test {@link StackAbstractState#popOrDefault(LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@link StackAbstractState} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#popOrDefault(LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test popOrDefault(LatticeAbstractState); given StackAbstractState (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LatticeAbstractState StackAbstractState.popOrDefault(LatticeAbstractState)"})
  void testPopOrDefault_givenStackAbstractState() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();

    // Act
    ValueAbstractState actualPopOrDefaultResult =
        valueAbstractStateList.popOrDefault(ValueAbstractState.UNKNOWN);

    // Assert
    assertTrue(valueAbstractStateList.isEmpty());
    assertSame(ValueAbstractState.UNKNOWN, actualPopOrDefaultResult);
  }

  /**
   * Test {@link StackAbstractState#popOrDefault(LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@link StackAbstractState} (default constructor) add {@link
   *       ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#popOrDefault(LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test popOrDefault(LatticeAbstractState); given StackAbstractState (default constructor) add UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LatticeAbstractState StackAbstractState.popOrDefault(LatticeAbstractState)"})
  void testPopOrDefault_givenStackAbstractStateAddUnknown() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    // Act
    ValueAbstractState actualPopOrDefaultResult =
        valueAbstractStateList.popOrDefault(ValueAbstractState.UNKNOWN);

    // Assert
    assertTrue(valueAbstractStateList.isEmpty());
    assertSame(ValueAbstractState.UNKNOWN, actualPopOrDefaultResult);
  }

  /**
   * Test {@link StackAbstractState#peek(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link StackAbstractState} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#peek(int)}
   */
  @Test
  @DisplayName(
      "Test peek(int) with 'int'; then StackAbstractState (default constructor) size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LatticeAbstractState StackAbstractState.peek(int)"})
  void testPeekWithInt_thenStackAbstractStateSizeIsTwo() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    // Act
    ValueAbstractState actualPeekResult = valueAbstractStateList.peek(1);

    // Assert
    assertEquals(2, valueAbstractStateList.size());
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    assertSame(valueAbstractState, valueAbstractStateList.get(0));
    assertSame(valueAbstractState, valueAbstractStateList.get(1));
    assertSame(valueAbstractState, actualPeekResult);
  }

  /**
   * Test {@link StackAbstractState#peekOrDefault(int, LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@link StackAbstractState} (default constructor) add {@link
   *       ValueAbstractState#UNKNOWN}.
   *   <li>When one.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#peekOrDefault(int, LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test peekOrDefault(int, LatticeAbstractState); given StackAbstractState (default constructor) add UNKNOWN; when one; then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState StackAbstractState.peekOrDefault(int, LatticeAbstractState)"
  })
  void testPeekOrDefault_givenStackAbstractStateAddUnknown_whenOne_thenReturnUnknown() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        valueAbstractStateList.peekOrDefault(1, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link StackAbstractState#peekOrDefault(int, LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@link StackAbstractState} (default constructor).
   *   <li>When one.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link StackAbstractState#peekOrDefault(int, LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test peekOrDefault(int, LatticeAbstractState); given StackAbstractState (default constructor); when one; then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState StackAbstractState.peekOrDefault(int, LatticeAbstractState)"
  })
  void testPeekOrDefault_givenStackAbstractState_whenOne_thenReturnUnknown() {
    // Arrange
    StackAbstractState<ValueAbstractState> valueAbstractStateList = new StackAbstractState<>();

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        valueAbstractStateList.peekOrDefault(1, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test new {@link StackAbstractState} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StackAbstractState}
   */
  @Test
  @DisplayName("Test new StackAbstractState (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StackAbstractState.<init>()"})
  void testNewStackAbstractState() {
    // Arrange and Act
    StackAbstractState<ValueAbstractState> actualValueAbstractStateList =
        new StackAbstractState<>();

    // Assert
    assertTrue(actualValueAbstractStateList.isEmpty());
  }
}
