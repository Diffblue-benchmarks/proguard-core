package proguard.analysis.cpa.jvm.witness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;

class JvmLocalVariableLocationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmLocalVariableLocation#JvmLocalVariableLocation(int)}
   *   <li>{@link JvmLocalVariableLocation#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmLocalVariableLocation.<init>(int)",
    "java.lang.String JvmLocalVariableLocation.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("JvmLocalVariableLocation(1)", new JvmLocalVariableLocation(1).toString());
  }

  /**
   * Test {@link JvmLocalVariableLocation#extractValueOrDefault(JvmAbstractState,
   * LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmLocalVariableLocation#extractValueOrDefault(JvmAbstractState,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test extractValueOrDefault(JvmAbstractState, LatticeAbstractState); then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmLocalVariableLocation.extractValueOrDefault(JvmAbstractState, LatticeAbstractState)"
  })
  void testExtractValueOrDefault_thenReturnUnknown() {
    // Arrange
    JvmLocalVariableLocation jvmLocalVariableLocation = new JvmLocalVariableLocation(1);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    JvmAbstractState<ValueAbstractState> jvmState =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmLocalVariableLocation.extractValueOrDefault(jvmState, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmLocalVariableLocation#equals(Object)}, and {@link
   * JvmLocalVariableLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmLocalVariableLocation#equals(Object)}
   *   <li>{@link JvmLocalVariableLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmLocalVariableLocation.equals(Object)",
    "int JvmLocalVariableLocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmLocalVariableLocation jvmLocalVariableLocation = new JvmLocalVariableLocation(1);
    JvmLocalVariableLocation jvmLocalVariableLocation2 = new JvmLocalVariableLocation(1);

    // Act and Assert
    assertEquals(jvmLocalVariableLocation, jvmLocalVariableLocation2);
    assertEquals(jvmLocalVariableLocation.hashCode(), jvmLocalVariableLocation2.hashCode());
  }

  /**
   * Test {@link JvmLocalVariableLocation#equals(Object)}, and {@link
   * JvmLocalVariableLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmLocalVariableLocation#equals(Object)}
   *   <li>{@link JvmLocalVariableLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmLocalVariableLocation.equals(Object)",
    "int JvmLocalVariableLocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmLocalVariableLocation jvmLocalVariableLocation = new JvmLocalVariableLocation(1);

    // Act and Assert
    assertEquals(jvmLocalVariableLocation, jvmLocalVariableLocation);
    int expectedHashCodeResult = jvmLocalVariableLocation.hashCode();
    assertEquals(expectedHashCodeResult, jvmLocalVariableLocation.hashCode());
  }

  /**
   * Test {@link JvmLocalVariableLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmLocalVariableLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmLocalVariableLocation.equals(Object)",
    "int JvmLocalVariableLocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmLocalVariableLocation jvmLocalVariableLocation = new JvmLocalVariableLocation(0);

    // Act and Assert
    assertNotEquals(jvmLocalVariableLocation, new JvmLocalVariableLocation(1));
  }

  /**
   * Test {@link JvmLocalVariableLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmLocalVariableLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmLocalVariableLocation.equals(Object)",
    "int JvmLocalVariableLocation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmLocalVariableLocation(1), null);
  }

  /**
   * Test {@link JvmLocalVariableLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmLocalVariableLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmLocalVariableLocation.equals(Object)",
    "int JvmLocalVariableLocation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmLocalVariableLocation(1), "Different type to JvmLocalVariableLocation");
  }
}
