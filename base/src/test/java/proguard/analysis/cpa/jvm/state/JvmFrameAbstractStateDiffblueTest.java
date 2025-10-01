package proguard.analysis.cpa.jvm.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.defaults.ListAbstractState;
import proguard.analysis.cpa.defaults.StackAbstractState;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.Value;

class JvmFrameAbstractStateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmFrameAbstractState#JvmFrameAbstractState(ListAbstractState,
   *       StackAbstractState)}
   *   <li>{@link JvmFrameAbstractState#getLocalVariables()}
   *   <li>{@link JvmFrameAbstractState#getOperandStack()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmFrameAbstractState.<init>(ListAbstractState, StackAbstractState)",
    "ListAbstractState JvmFrameAbstractState.getLocalVariables()",
    "StackAbstractState JvmFrameAbstractState.getOperandStack()"
  })
  void testGettersAndSetters() {
    // Arrange
    ListAbstractState<ValueAbstractState> localVariables = new ListAbstractState<>();
    StackAbstractState<ValueAbstractState> operandStack = new StackAbstractState<>();

    // Act
    JvmFrameAbstractState<ValueAbstractState> actualJvmFrameAbstractState =
        new JvmFrameAbstractState<>(localVariables, operandStack);
    ListAbstractState<ValueAbstractState> actualLocalVariables =
        actualJvmFrameAbstractState.getLocalVariables();

    // Assert
    assertSame(localVariables, actualLocalVariables);
    assertSame(operandStack, actualJvmFrameAbstractState.getOperandStack());
  }

  /**
   * Test {@link JvmFrameAbstractState#JvmFrameAbstractState()}.
   *
   * <p>Method under test: {@link JvmFrameAbstractState#JvmFrameAbstractState()}
   */
  @Test
  @DisplayName("Test new JvmFrameAbstractState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmFrameAbstractState.<init>()"})
  void testNewJvmFrameAbstractState() {
    // Arrange and Act
    JvmFrameAbstractState<ValueAbstractState> actualJvmFrameAbstractState =
        new JvmFrameAbstractState<>();

    // Assert
    assertNull(actualJvmFrameAbstractState.getPrecision());
    ListAbstractState<ValueAbstractState> localVariables =
        actualJvmFrameAbstractState.getLocalVariables();
    assertTrue(localVariables.isEmpty());
    assertEquals(localVariables, actualJvmFrameAbstractState.getOperandStack());
  }

  /**
   * Test {@link JvmFrameAbstractState#join(JvmFrameAbstractState)} with {@code
   * JvmFrameAbstractState}.
   *
   * <p>Method under test: {@link JvmFrameAbstractState#join(JvmFrameAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmFrameAbstractState) with 'JvmFrameAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmFrameAbstractState JvmFrameAbstractState.join(JvmFrameAbstractState)"})
  void testJoinWithJvmFrameAbstractState() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();
    jvmFrameAbstractState.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);

    // Act
    JvmFrameAbstractState<ValueAbstractState> actualJoinResult =
        jvmFrameAbstractState.join(new JvmFrameAbstractState<>());

    // Assert
    assertSame(jvmFrameAbstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmFrameAbstractState#join(JvmFrameAbstractState)} with {@code
   * JvmFrameAbstractState}.
   *
   * <p>Method under test: {@link JvmFrameAbstractState#join(JvmFrameAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmFrameAbstractState) with 'JvmFrameAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmFrameAbstractState JvmFrameAbstractState.join(JvmFrameAbstractState)"})
  void testJoinWithJvmFrameAbstractState2() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    JvmFrameAbstractState<ValueAbstractState> abstractState = new JvmFrameAbstractState<>();
    abstractState.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);

    // Act
    JvmFrameAbstractState<ValueAbstractState> actualJoinResult =
        jvmFrameAbstractState.join(abstractState);

    // Assert
    assertEquals(abstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmFrameAbstractState#join(JvmFrameAbstractState)} with {@code
   * JvmFrameAbstractState}.
   *
   * <p>Method under test: {@link JvmFrameAbstractState#join(JvmFrameAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmFrameAbstractState) with 'JvmFrameAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmFrameAbstractState JvmFrameAbstractState.join(JvmFrameAbstractState)"})
  void testJoinWithJvmFrameAbstractState3() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();
    jvmFrameAbstractState.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);

    JvmFrameAbstractState<ValueAbstractState> abstractState = new JvmFrameAbstractState<>();
    abstractState.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);

    // Act
    JvmFrameAbstractState<ValueAbstractState> actualJoinResult =
        jvmFrameAbstractState.join(abstractState);

    // Assert
    assertSame(jvmFrameAbstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmFrameAbstractState#join(JvmFrameAbstractState)} with {@code
   * JvmFrameAbstractState}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#ValueAbstractState(Value)} with value is {@link
   *       BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#join(JvmFrameAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(JvmFrameAbstractState) with 'JvmFrameAbstractState'; given ValueAbstractState(Value) with value is DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmFrameAbstractState JvmFrameAbstractState.join(JvmFrameAbstractState)"})
  void testJoinWithJvmFrameAbstractState_givenValueAbstractStateWithValueIsDouble_value() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();
    jvmFrameAbstractState.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);

    JvmFrameAbstractState<ValueAbstractState> abstractState = new JvmFrameAbstractState<>();
    abstractState.setVariable(
        1, new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE), ValueAbstractState.UNKNOWN);

    // Act
    JvmFrameAbstractState<ValueAbstractState> actualJoinResult =
        jvmFrameAbstractState.join(abstractState);

    // Assert
    assertSame(jvmFrameAbstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmFrameAbstractState#join(JvmFrameAbstractState)} with {@code
   * JvmFrameAbstractState}.
   *
   * <ul>
   *   <li>Then return {@link JvmFrameAbstractState#JvmFrameAbstractState()}.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#join(JvmFrameAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(JvmFrameAbstractState) with 'JvmFrameAbstractState'; then return JvmFrameAbstractState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmFrameAbstractState JvmFrameAbstractState.join(JvmFrameAbstractState)"})
  void testJoinWithJvmFrameAbstractState_thenReturnJvmFrameAbstractState() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    // Act
    JvmFrameAbstractState<ValueAbstractState> actualJoinResult =
        jvmFrameAbstractState.join(new JvmFrameAbstractState<>());

    // Assert
    assertSame(jvmFrameAbstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmFrameAbstractState#copy()}.
   *
   * <p>Method under test: {@link JvmFrameAbstractState#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmFrameAbstractState JvmFrameAbstractState.copy()"})
  void testCopy() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    // Act
    JvmFrameAbstractState<ValueAbstractState> actualCopyResult = jvmFrameAbstractState.copy();

    // Assert
    assertEquals(jvmFrameAbstractState, actualCopyResult);
  }

  /**
   * Test {@link JvmFrameAbstractState#equals(Object)}, and {@link
   * JvmFrameAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmFrameAbstractState#equals(Object)}
   *   <li>{@link JvmFrameAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmFrameAbstractState.equals(Object)",
    "int JvmFrameAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState2 =
        new JvmFrameAbstractState<>();

    // Act and Assert
    assertEquals(jvmFrameAbstractState, jvmFrameAbstractState2);
    assertEquals(jvmFrameAbstractState.hashCode(), jvmFrameAbstractState2.hashCode());
  }

  /**
   * Test {@link JvmFrameAbstractState#equals(Object)}, and {@link
   * JvmFrameAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmFrameAbstractState#equals(Object)}
   *   <li>{@link JvmFrameAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmFrameAbstractState.equals(Object)",
    "int JvmFrameAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    // Act and Assert
    assertEquals(jvmFrameAbstractState, jvmFrameAbstractState);
    int expectedHashCodeResult = jvmFrameAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, jvmFrameAbstractState.hashCode());
  }

  /**
   * Test {@link JvmFrameAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmFrameAbstractState.equals(Object)",
    "int JvmFrameAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    // Act and Assert
    assertNotEquals(jvmFrameAbstractState, 1);
  }

  /**
   * Test {@link JvmFrameAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmFrameAbstractState.equals(Object)",
    "int JvmFrameAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();
    jvmFrameAbstractState.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(jvmFrameAbstractState, new JvmFrameAbstractState<>());
  }

  /**
   * Test {@link JvmFrameAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmFrameAbstractState.equals(Object)",
    "int JvmFrameAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StackAbstractState<ValueAbstractState> operandStack = new StackAbstractState<>();
    operandStack.add(ValueAbstractState.UNKNOWN);
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState =
        new JvmFrameAbstractState<>(new ListAbstractState<>(), operandStack);

    // Act and Assert
    assertNotEquals(jvmFrameAbstractState, new JvmFrameAbstractState<>());
  }

  /**
   * Test {@link JvmFrameAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmFrameAbstractState.equals(Object)",
    "int JvmFrameAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    // Act and Assert
    assertNotEquals(jvmFrameAbstractState, null);
  }

  /**
   * Test {@link JvmFrameAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmFrameAbstractState.equals(Object)",
    "int JvmFrameAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    // Act and Assert
    assertNotEquals(jvmFrameAbstractState, "Different type to JvmFrameAbstractState");
  }

  /**
   * Test {@link JvmFrameAbstractState#peekOrDefault(int, LatticeAbstractState)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#peekOrDefault(int, LatticeAbstractState)}
   */
  @Test
  @DisplayName("Test peekOrDefault(int, LatticeAbstractState); when one; then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmFrameAbstractState.peekOrDefault(int, LatticeAbstractState)"
  })
  void testPeekOrDefault_whenOne_thenReturnUnknown() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmFrameAbstractState.peekOrDefault(1, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmFrameAbstractState#pop()}.
   *
   * <p>Method under test: {@link JvmFrameAbstractState#pop()}
   */
  @Test
  @DisplayName("Test pop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LatticeAbstractState JvmFrameAbstractState.pop()"})
  void testPop() {
    // Arrange
    StackAbstractState<ValueAbstractState> operandStack = new StackAbstractState<>();
    operandStack.add(ValueAbstractState.UNKNOWN);
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState =
        new JvmFrameAbstractState<>(new ListAbstractState<>(), operandStack);

    // Act
    ValueAbstractState actualPopResult = jvmFrameAbstractState.pop();

    // Assert
    assertSame(operandStack, jvmFrameAbstractState.getOperandStack());
    assertSame(ValueAbstractState.UNKNOWN, actualPopResult);
  }

  /**
   * Test {@link JvmFrameAbstractState#popOrDefault(LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@link JvmFrameAbstractState#JvmFrameAbstractState()}.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#popOrDefault(LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test popOrDefault(LatticeAbstractState); given JvmFrameAbstractState(); then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmFrameAbstractState.popOrDefault(LatticeAbstractState)"
  })
  void testPopOrDefault_givenJvmFrameAbstractState_thenReturnUnknown() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN, jvmFrameAbstractState.popOrDefault(ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmFrameAbstractState#popOrDefault(LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Then Value ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#popOrDefault(LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test popOrDefault(LatticeAbstractState); then Value ReferencedClass return LibraryClass")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmFrameAbstractState.popOrDefault(LatticeAbstractState)"
  })
  void testPopOrDefault_thenValueReferencedClassReturnLibraryClass() {
    // Arrange
    StackAbstractState<ValueAbstractState> operandStack = new StackAbstractState<>();
    operandStack.add(ValueAbstractState.UNKNOWN);
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState =
        new JvmFrameAbstractState<>(new ListAbstractState<>(), operandStack);

    // Act and Assert
    Value value = jvmFrameAbstractState.popOrDefault(ValueAbstractState.UNKNOWN).getValue();
    assertTrue(((TypedReferenceValue) value).getReferencedClass() instanceof LibraryClass);
    assertTrue(value instanceof TypedReferenceValue);
    assertSame(operandStack, jvmFrameAbstractState.getOperandStack());
  }

  /**
   * Test {@link JvmFrameAbstractState#push(LatticeAbstractState)}.
   *
   * <p>Method under test: {@link JvmFrameAbstractState#push(LatticeAbstractState)}
   */
  @Test
  @DisplayName("Test push(LatticeAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LatticeAbstractState JvmFrameAbstractState.push(LatticeAbstractState)"})
  void testPush() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    // Act
    ValueAbstractState actualPushResult = jvmFrameAbstractState.push(ValueAbstractState.UNKNOWN);

    // Assert
    StackAbstractState<ValueAbstractState> operandStack = jvmFrameAbstractState.getOperandStack();
    assertEquals(1, operandStack.size());
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    assertSame(valueAbstractState, operandStack.get(0));
    assertSame(valueAbstractState, actualPushResult);
  }

  /**
   * Test {@link JvmFrameAbstractState#pushAll(List)}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#pushAll(List)}
   */
  @Test
  @DisplayName(
      "Test pushAll(List); given UNKNOWN; when ArrayList() add UNKNOWN; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JvmFrameAbstractState.pushAll(List)"})
  void testPushAll_givenUnknown_whenArrayListAddUnknown_thenReturnArrayList() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    ArrayList<ValueAbstractState> states = new ArrayList<>();
    states.add(ValueAbstractState.UNKNOWN);

    // Act
    List<ValueAbstractState> actualPushAllResult = jvmFrameAbstractState.pushAll(states);

    // Assert
    assertEquals(states, jvmFrameAbstractState.getOperandStack());
    assertSame(states, actualPushAllResult);
  }

  /**
   * Test {@link JvmFrameAbstractState#pushAll(List)}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#pushAll(List)}
   */
  @Test
  @DisplayName(
      "Test pushAll(List); given UNKNOWN; when ArrayList() add UNKNOWN; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JvmFrameAbstractState.pushAll(List)"})
  void testPushAll_givenUnknown_whenArrayListAddUnknown_thenReturnArrayList2() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    ArrayList<ValueAbstractState> states = new ArrayList<>();
    states.add(ValueAbstractState.UNKNOWN);
    states.add(ValueAbstractState.UNKNOWN);

    // Act
    List<ValueAbstractState> actualPushAllResult = jvmFrameAbstractState.pushAll(states);

    // Assert
    assertEquals(states, jvmFrameAbstractState.getOperandStack());
    assertSame(states, actualPushAllResult);
  }

  /**
   * Test {@link JvmFrameAbstractState#pushAll(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#pushAll(List)}
   */
  @Test
  @DisplayName("Test pushAll(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List JvmFrameAbstractState.pushAll(List)"})
  void testPushAll_whenArrayList_thenReturnEmpty() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();
    ArrayList<ValueAbstractState> states = new ArrayList<>();

    // Act and Assert
    assertTrue(jvmFrameAbstractState.pushAll(states).isEmpty());
    assertEquals(states, jvmFrameAbstractState.getOperandStack());
  }

  /**
   * Test {@link JvmFrameAbstractState#getVariableOrDefault(int, LatticeAbstractState)}.
   *
   * <p>Method under test: {@link JvmFrameAbstractState#getVariableOrDefault(int,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName("Test getVariableOrDefault(int, LatticeAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmFrameAbstractState.getVariableOrDefault(int, LatticeAbstractState)"
  })
  void testGetVariableOrDefault() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();
    jvmFrameAbstractState.setVariable(1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmFrameAbstractState.getVariableOrDefault(1, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmFrameAbstractState#getVariableOrDefault(int, LatticeAbstractState)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#getVariableOrDefault(int,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test getVariableOrDefault(int, LatticeAbstractState); when one; then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmFrameAbstractState.getVariableOrDefault(int, LatticeAbstractState)"
  })
  void testGetVariableOrDefault_whenOne_thenReturnUnknown() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmFrameAbstractState.getVariableOrDefault(1, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmFrameAbstractState#setVariable(int, LatticeAbstractState,
   * LatticeAbstractState)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link JvmFrameAbstractState#JvmFrameAbstractState()} LocalVariables size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmFrameAbstractState#setVariable(int, LatticeAbstractState,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test setVariable(int, LatticeAbstractState, LatticeAbstractState); when one; then JvmFrameAbstractState() LocalVariables size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmFrameAbstractState.setVariable(int, LatticeAbstractState, LatticeAbstractState)"
  })
  void testSetVariable_whenOne_thenJvmFrameAbstractStateLocalVariablesSizeIsTwo() {
    // Arrange
    JvmFrameAbstractState<ValueAbstractState> jvmFrameAbstractState = new JvmFrameAbstractState<>();

    // Act
    ValueAbstractState actualSetVariableResult =
        jvmFrameAbstractState.setVariable(
            1, ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);

    // Assert
    ListAbstractState<ValueAbstractState> localVariables =
        jvmFrameAbstractState.getLocalVariables();
    assertEquals(2, localVariables.size());
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    assertSame(valueAbstractState, localVariables.get(0));
    assertSame(valueAbstractState, localVariables.get(1));
    assertSame(valueAbstractState, actualSetVariableResult);
  }
}
