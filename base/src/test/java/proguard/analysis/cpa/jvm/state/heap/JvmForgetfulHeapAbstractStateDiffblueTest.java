package proguard.analysis.cpa.jvm.state.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;

class JvmForgetfulHeapAbstractStateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmForgetfulHeapAbstractState#JvmForgetfulHeapAbstractState(LatticeAbstractState)}
   *   <li>{@link JvmForgetfulHeapAbstractState#setArrayElement(Object, LatticeAbstractState,
   *       LatticeAbstractState)}
   *   <li>{@link JvmForgetfulHeapAbstractState#setField(Object, String, LatticeAbstractState)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmForgetfulHeapAbstractState.<init>(LatticeAbstractState)",
    "void JvmForgetfulHeapAbstractState.setArrayElement(Object, LatticeAbstractState, LatticeAbstractState)",
    "void JvmForgetfulHeapAbstractState.setField(Object, String, LatticeAbstractState)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    JvmForgetfulHeapAbstractState<ValueAbstractState> actualJvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    actualJvmForgetfulHeapAbstractState.setArrayElement(
        "Array", ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN);
    actualJvmForgetfulHeapAbstractState.setField("Object", "Fqn", ValueAbstractState.UNKNOWN);

    // Assert
    assertNull(actualJvmForgetfulHeapAbstractState.getPrecision());
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#getFieldOrDefault(Object, String,
   * LatticeAbstractState)}.
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#getFieldOrDefault(Object, String,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName("Test getFieldOrDefault(Object, String, LatticeAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmForgetfulHeapAbstractState.getFieldOrDefault(Object, String, LatticeAbstractState)"
  })
  void testGetFieldOrDefault() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmForgetfulHeapAbstractState.getFieldOrDefault(
            "Object", "Fqn", ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#getArrayElementOrDefault(Object,
   * LatticeAbstractState, LatticeAbstractState)}.
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#getArrayElementOrDefault(Object,
   * LatticeAbstractState, LatticeAbstractState)}
   */
  @Test
  @DisplayName("Test getArrayElementOrDefault(Object, LatticeAbstractState, LatticeAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmForgetfulHeapAbstractState.getArrayElementOrDefault(Object, LatticeAbstractState, LatticeAbstractState)"
  })
  void testGetArrayElementOrDefault() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmForgetfulHeapAbstractState.getArrayElementOrDefault(
            "Array", ValueAbstractState.UNKNOWN, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#newObject(String, JvmCfaNode)} with {@code
   * className}, {@code creationCite}.
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#newObject(String, JvmCfaNode)}
   */
  @Test
  @DisplayName("Test newObject(String, JvmCfaNode) with 'className', 'creationCite'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmForgetfulHeapAbstractState.newObject(String, JvmCfaNode)"
  })
  void testNewObjectWithClassNameCreationCite() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmForgetfulHeapAbstractState.newObject("Class Name", JvmUnknownCfaNode.INSTANCE));
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#newArray(String, List, JvmCfaNode)}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#newArray(String, List, JvmCfaNode)}
   */
  @Test
  @DisplayName(
      "Test newArray(String, List, JvmCfaNode); given UNKNOWN; when ArrayList() add UNKNOWN; then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmForgetfulHeapAbstractState.newArray(String, List, JvmCfaNode)"
  })
  void testNewArray_givenUnknown_whenArrayListAddUnknown_thenArrayListSizeIsOne() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    ArrayList<ValueAbstractState> dimensions = new ArrayList<>();
    dimensions.add(ValueAbstractState.UNKNOWN);

    // Act
    ValueAbstractState actualNewArrayResult =
        jvmForgetfulHeapAbstractState.newArray("Type", dimensions, JvmUnknownCfaNode.INSTANCE);

    // Assert
    assertEquals(1, dimensions.size());
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    assertSame(valueAbstractState, dimensions.get(0));
    assertSame(valueAbstractState, actualNewArrayResult);
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#newArray(String, List, JvmCfaNode)}.
   *
   * <ul>
   *   <li>Given {@link ValueAbstractState#UNKNOWN}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#newArray(String, List, JvmCfaNode)}
   */
  @Test
  @DisplayName(
      "Test newArray(String, List, JvmCfaNode); given UNKNOWN; when ArrayList() add UNKNOWN; then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmForgetfulHeapAbstractState.newArray(String, List, JvmCfaNode)"
  })
  void testNewArray_givenUnknown_whenArrayListAddUnknown_thenArrayListSizeIsTwo() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    ArrayList<ValueAbstractState> dimensions = new ArrayList<>();
    dimensions.add(ValueAbstractState.UNKNOWN);
    dimensions.add(ValueAbstractState.UNKNOWN);

    // Act
    ValueAbstractState actualNewArrayResult =
        jvmForgetfulHeapAbstractState.newArray("Type", dimensions, JvmUnknownCfaNode.INSTANCE);

    // Assert
    assertEquals(2, dimensions.size());
    ValueAbstractState valueAbstractState = ValueAbstractState.UNKNOWN;
    assertSame(valueAbstractState, dimensions.get(0));
    assertSame(valueAbstractState, dimensions.get(1));
    assertSame(valueAbstractState, actualNewArrayResult);
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#newArray(String, List, JvmCfaNode)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#newArray(String, List, JvmCfaNode)}
   */
  @Test
  @DisplayName("Test newArray(String, List, JvmCfaNode); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmForgetfulHeapAbstractState.newArray(String, List, JvmCfaNode)"
  })
  void testNewArray_whenArrayList() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmForgetfulHeapAbstractState.newArray(
            "Type", new ArrayList<>(), JvmUnknownCfaNode.INSTANCE));
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#join(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#join(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmHeapAbstractState) with 'JvmHeapAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmForgetfulHeapAbstractState JvmForgetfulHeapAbstractState.join(JvmHeapAbstractState)"
  })
  void testJoinWithJvmHeapAbstractState() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act
    JvmForgetfulHeapAbstractState<ValueAbstractState> actualJoinResult =
        jvmForgetfulHeapAbstractState.join(
            new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN));

    // Assert
    assertSame(jvmForgetfulHeapAbstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(JvmHeapAbstractState) with 'JvmHeapAbstractState'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmForgetfulHeapAbstractState.isLessOrEqual(JvmHeapAbstractState)"})
  void testIsLessOrEqualWithJvmHeapAbstractState_thenReturnTrue() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act
    boolean actualIsLessOrEqualResult =
        jvmForgetfulHeapAbstractState.isLessOrEqual(
            new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN));

    // Assert
    assertTrue(actualIsLessOrEqualResult);
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)} with {@code
   * JvmHeapAbstractState}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#isLessOrEqual(JvmHeapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(JvmHeapAbstractState) with 'JvmHeapAbstractState'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmForgetfulHeapAbstractState.isLessOrEqual(JvmHeapAbstractState)"})
  void testIsLessOrEqualWithJvmHeapAbstractState_whenNull_thenReturnFalse() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertFalse(jvmForgetfulHeapAbstractState.isLessOrEqual(null));
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#equals(Object)}, and {@link
   * JvmForgetfulHeapAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmForgetfulHeapAbstractState#equals(Object)}
   *   <li>{@link JvmForgetfulHeapAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmForgetfulHeapAbstractState.equals(Object)",
    "int JvmForgetfulHeapAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState2 =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertEquals(jvmForgetfulHeapAbstractState, jvmForgetfulHeapAbstractState2);
    assertEquals(
        jvmForgetfulHeapAbstractState.hashCode(), jvmForgetfulHeapAbstractState2.hashCode());
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#equals(Object)}, and {@link
   * JvmForgetfulHeapAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmForgetfulHeapAbstractState#equals(Object)}
   *   <li>{@link JvmForgetfulHeapAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmForgetfulHeapAbstractState.equals(Object)",
    "int JvmForgetfulHeapAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertEquals(jvmForgetfulHeapAbstractState, jvmForgetfulHeapAbstractState);
    int expectedHashCodeResult = jvmForgetfulHeapAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, jvmForgetfulHeapAbstractState.hashCode());
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmForgetfulHeapAbstractState.equals(Object)",
    "int JvmForgetfulHeapAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(jvmForgetfulHeapAbstractState, 3);
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmForgetfulHeapAbstractState.equals(Object)",
    "int JvmForgetfulHeapAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(jvmForgetfulHeapAbstractState, null);
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmForgetfulHeapAbstractState.equals(Object)",
    "int JvmForgetfulHeapAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(
        jvmForgetfulHeapAbstractState, "Different type to JvmForgetfulHeapAbstractState");
  }

  /**
   * Test {@link JvmForgetfulHeapAbstractState#copy()}.
   *
   * <p>Method under test: {@link JvmForgetfulHeapAbstractState#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmForgetfulHeapAbstractState JvmForgetfulHeapAbstractState.copy()"})
  void testCopy() {
    // Arrange
    JvmForgetfulHeapAbstractState<ValueAbstractState> jvmForgetfulHeapAbstractState =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act
    JvmForgetfulHeapAbstractState<ValueAbstractState> actualCopyResult =
        jvmForgetfulHeapAbstractState.copy();

    // Assert
    assertSame(jvmForgetfulHeapAbstractState, actualCopyResult);
  }
}
