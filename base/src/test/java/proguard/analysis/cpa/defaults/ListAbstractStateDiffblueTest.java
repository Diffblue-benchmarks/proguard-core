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

class ListAbstractStateDiffblueTest {
  /**
   * Test {@link ListAbstractState#ListAbstractState()}.
   *
   * <p>Method under test: {@link ListAbstractState#ListAbstractState()}
   */
  @Test
  @DisplayName("Test new ListAbstractState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListAbstractState.<init>()", "void ListAbstractState.<init>(int)"})
  void testNewListAbstractState() {
    // Arrange and Act
    ListAbstractState<ValueAbstractState> actualValueAbstractStateList = new ListAbstractState<>();

    // Assert
    assertTrue(actualValueAbstractStateList.isEmpty());
  }

  /**
   * Test {@link ListAbstractState#ListAbstractState(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#ListAbstractState(int)}
   */
  @Test
  @DisplayName("Test new ListAbstractState(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListAbstractState.<init>()", "void ListAbstractState.<init>(int)"})
  void testNewListAbstractState_whenOne() {
    // Arrange and Act
    ListAbstractState<ValueAbstractState> actualValueAbstractStateList = new ListAbstractState<>(1);

    // Assert
    assertTrue(actualValueAbstractStateList.isEmpty());
  }

  /**
   * Test {@link ListAbstractState#join(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ListAbstractState#ListAbstractState()}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#join(ListAbstractState)}
   */
  @Test
  @DisplayName("Test join(ListAbstractState) with 'ListAbstractState'; given ListAbstractState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListAbstractState ListAbstractState.join(ListAbstractState)"})
  void testJoinWithListAbstractState_givenListAbstractState() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();

    ListAbstractState<ValueAbstractState> abstractState = new ListAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act
    ListAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(abstractState);

    // Assert
    assertSame(abstractState, actualJoinResult);
  }

  /**
   * Test {@link ListAbstractState#join(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ListAbstractState#ListAbstractState()}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#join(ListAbstractState)}
   */
  @Test
  @DisplayName("Test join(ListAbstractState) with 'ListAbstractState'; given ListAbstractState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListAbstractState ListAbstractState.join(ListAbstractState)"})
  void testJoinWithListAbstractState_givenListAbstractState2() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();

    ListAbstractState<ValueAbstractState> abstractState = new ListAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act
    ListAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(abstractState);

    // Assert
    assertSame(abstractState, actualJoinResult);
  }

  /**
   * Test {@link ListAbstractState#join(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ListAbstractState#ListAbstractState()} add {@link
   *       ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#join(ListAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(ListAbstractState) with 'ListAbstractState'; given ListAbstractState() add UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListAbstractState ListAbstractState.join(ListAbstractState)"})
  void testJoinWithListAbstractState_givenListAbstractStateAddUnknown() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    ListAbstractState<ValueAbstractState> abstractState = new ListAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act
    ListAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(abstractState);

    // Assert
    assertSame(abstractState, actualJoinResult);
  }

  /**
   * Test {@link ListAbstractState#join(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ListAbstractState#ListAbstractState()}.
   *   <li>When {@link ListAbstractState#ListAbstractState()}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#join(ListAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(ListAbstractState) with 'ListAbstractState'; given ListAbstractState(); when ListAbstractState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListAbstractState ListAbstractState.join(ListAbstractState)"})
  void testJoinWithListAbstractState_givenListAbstractState_whenListAbstractState() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();
    ListAbstractState<ValueAbstractState> abstractState = new ListAbstractState<>();

    // Act
    ListAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(abstractState);

    // Assert
    assertSame(abstractState, actualJoinResult);
  }

  /**
   * Test {@link ListAbstractState#join(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#ValueAbstractState(Value)} with value is {@link
   *       BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#join(ListAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(ListAbstractState) with 'ListAbstractState'; given ValueAbstractState(Value) with value is DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListAbstractState ListAbstractState.join(ListAbstractState)"})
  void testJoinWithListAbstractState_givenValueAbstractStateWithValueIsDouble_value() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    ListAbstractState<ValueAbstractState> abstractState = new ListAbstractState<>();
    abstractState.add(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));

    // Act
    ListAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(abstractState);

    // Assert
    assertEquals(valueAbstractStateList, actualJoinResult);
  }

  /**
   * Test {@link ListAbstractState#join(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <ul>
   *   <li>When {@link ListAbstractState#ListAbstractState()}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#join(ListAbstractState)}
   */
  @Test
  @DisplayName("Test join(ListAbstractState) with 'ListAbstractState'; when ListAbstractState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListAbstractState ListAbstractState.join(ListAbstractState)"})
  void testJoinWithListAbstractState_whenListAbstractState() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    // Act
    ListAbstractState<ValueAbstractState> actualJoinResult =
        valueAbstractStateList.join(new ListAbstractState<>());

    // Assert
    assertSame(valueAbstractStateList, actualJoinResult);
  }

  /**
   * Test {@link ListAbstractState#isLessOrEqual(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <p>Method under test: {@link ListAbstractState#isLessOrEqual(ListAbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(ListAbstractState) with 'ListAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListAbstractState.isLessOrEqual(ListAbstractState)"})
  void testIsLessOrEqualWithListAbstractState() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    ListAbstractState<ValueAbstractState> abstractState = new ListAbstractState<>();
    abstractState.add(new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE));

    // Act and Assert
    assertFalse(valueAbstractStateList.isLessOrEqual(abstractState));
  }

  /**
   * Test {@link ListAbstractState#isLessOrEqual(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ListAbstractState#ListAbstractState()} add {@link
   *       ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#isLessOrEqual(ListAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(ListAbstractState) with 'ListAbstractState'; given ListAbstractState() add UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListAbstractState.isLessOrEqual(ListAbstractState)"})
  void testIsLessOrEqualWithListAbstractState_givenListAbstractStateAddUnknown() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    ListAbstractState<ValueAbstractState> abstractState = new ListAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertTrue(valueAbstractStateList.isLessOrEqual(abstractState));
  }

  /**
   * Test {@link ListAbstractState#isLessOrEqual(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ListAbstractState#ListAbstractState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#isLessOrEqual(ListAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(ListAbstractState) with 'ListAbstractState'; given ListAbstractState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListAbstractState.isLessOrEqual(ListAbstractState)"})
  void testIsLessOrEqualWithListAbstractState_givenListAbstractState_thenReturnTrue() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();

    ListAbstractState<ValueAbstractState> abstractState = new ListAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertTrue(valueAbstractStateList.isLessOrEqual(abstractState));
  }

  /**
   * Test {@link ListAbstractState#isLessOrEqual(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ListAbstractState#ListAbstractState()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#isLessOrEqual(ListAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(ListAbstractState) with 'ListAbstractState'; given ListAbstractState(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListAbstractState.isLessOrEqual(ListAbstractState)"})
  void testIsLessOrEqualWithListAbstractState_givenListAbstractState_thenReturnTrue2() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();

    ListAbstractState<ValueAbstractState> abstractState = new ListAbstractState<>();
    abstractState.add(ValueAbstractState.UNKNOWN);
    abstractState.add(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertTrue(valueAbstractStateList.isLessOrEqual(abstractState));
  }

  /**
   * Test {@link ListAbstractState#isLessOrEqual(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <ul>
   *   <li>When {@link ListAbstractState#ListAbstractState()}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#isLessOrEqual(ListAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(ListAbstractState) with 'ListAbstractState'; when ListAbstractState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListAbstractState.isLessOrEqual(ListAbstractState)"})
  void testIsLessOrEqualWithListAbstractState_whenListAbstractState() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();

    // Act and Assert
    assertTrue(valueAbstractStateList.isLessOrEqual(new ListAbstractState<>()));
  }

  /**
   * Test {@link ListAbstractState#isLessOrEqual(ListAbstractState)} with {@code ListAbstractState}.
   *
   * <ul>
   *   <li>When {@link ListAbstractState#ListAbstractState()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#isLessOrEqual(ListAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(ListAbstractState) with 'ListAbstractState'; when ListAbstractState(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListAbstractState.isLessOrEqual(ListAbstractState)"})
  void testIsLessOrEqualWithListAbstractState_whenListAbstractState_thenReturnFalse() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertFalse(valueAbstractStateList.isLessOrEqual(new ListAbstractState<>()));
  }

  /**
   * Test {@link ListAbstractState#copy()}.
   *
   * <p>Method under test: {@link ListAbstractState#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListAbstractState ListAbstractState.copy()"})
  void testCopy() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();

    // Act
    ListAbstractState<ValueAbstractState> actualCopyResult = valueAbstractStateList.copy();

    // Assert
    assertEquals(valueAbstractStateList, actualCopyResult);
  }

  /**
   * Test {@link ListAbstractState#getOrDefault(int, LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@link ListAbstractState#ListAbstractState()} add {@link
   *       ValueAbstractState#UNKNOWN}.
   *   <li>When one.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#getOrDefault(int, LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test getOrDefault(int, LatticeAbstractState); given ListAbstractState() add UNKNOWN; when one; then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState ListAbstractState.getOrDefault(int, LatticeAbstractState)"
  })
  void testGetOrDefault_givenListAbstractStateAddUnknown_whenOne_thenReturnUnknown() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);
    valueAbstractStateList.add(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        valueAbstractStateList.getOrDefault(1, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link ListAbstractState#getOrDefault(int, LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@link ListAbstractState#ListAbstractState()}.
   *   <li>When one.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link ListAbstractState#getOrDefault(int, LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test getOrDefault(int, LatticeAbstractState); given ListAbstractState(); when one; then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState ListAbstractState.getOrDefault(int, LatticeAbstractState)"
  })
  void testGetOrDefault_givenListAbstractState_whenOne_thenReturnUnknown() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        valueAbstractStateList.getOrDefault(1, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link ListAbstractState#set(int, LatticeAbstractState, LatticeAbstractState)} with {@code
   * int}, {@code ValueAbstractState}, {@code ValueAbstractState}.
   *
   * <p>Method under test: {@link ListAbstractState#set(int, LatticeAbstractState,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test set(int, LatticeAbstractState, LatticeAbstractState) with 'int', 'ValueAbstractState', 'ValueAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState ListAbstractState.set(int, LatticeAbstractState, LatticeAbstractState)"
  })
  void testSetWithIntValueAbstractStateValueAbstractState() {
    // Arrange
    ListAbstractState<ValueAbstractState> valueAbstractStateList = new ListAbstractState<>();

    // Act
    ValueAbstractState actualSetResult =
        valueAbstractStateList.set(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);

    // Assert
    assertEquals(2, valueAbstractStateList.size());
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    assertSame(valueAbstractState, valueAbstractStateList.get(0));
    assertSame(valueAbstractState, valueAbstractStateList.get(1));
    assertSame(valueAbstractState, actualSetResult);
  }
}
