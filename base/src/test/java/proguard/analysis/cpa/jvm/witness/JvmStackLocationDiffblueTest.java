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

class JvmStackLocationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmStackLocation#JvmStackLocation(int)}
   *   <li>{@link JvmStackLocation#toString()}
   *   <li>{@link JvmStackLocation#getIndex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmStackLocation.<init>(int)",
    "int JvmStackLocation.getIndex()",
    "String JvmStackLocation.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    JvmStackLocation actualJvmStackLocation = new JvmStackLocation(1);
    String actualToStringResult = actualJvmStackLocation.toString();

    // Assert
    assertEquals("JvmStackLocation(1)", actualToStringResult);
    assertEquals(1, actualJvmStackLocation.getIndex());
  }

  /**
   * Test {@link JvmStackLocation#extractValueOrDefault(JvmAbstractState, LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Given {@link JvmStackLocation#JvmStackLocation(int)} with index is one.
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmStackLocation#extractValueOrDefault(JvmAbstractState,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test extractValueOrDefault(JvmAbstractState, LatticeAbstractState); given JvmStackLocation(int) with index is one; then return UNKNOWN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LatticeAbstractState JvmStackLocation.extractValueOrDefault(JvmAbstractState, LatticeAbstractState)"
  })
  void testExtractValueOrDefault_givenJvmStackLocationWithIndexIsOne_thenReturnUnknown() {
    // Arrange
    JvmStackLocation jvmStackLocation = new JvmStackLocation(1);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    JvmAbstractState<ValueAbstractState> jvmState =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    // Act and Assert
    assertSame(
        ValueAbstractState.UNKNOWN,
        jvmStackLocation.extractValueOrDefault(jvmState, ValueAbstractState.UNKNOWN));
  }

  /**
   * Test {@link JvmStackLocation#equals(Object)}, and {@link JvmStackLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmStackLocation#equals(Object)}
   *   <li>{@link JvmStackLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmStackLocation.equals(Object)", "int JvmStackLocation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmStackLocation jvmStackLocation = new JvmStackLocation(1);
    JvmStackLocation jvmStackLocation2 = new JvmStackLocation(1);

    // Act and Assert
    assertEquals(jvmStackLocation, jvmStackLocation2);
    assertEquals(jvmStackLocation.hashCode(), jvmStackLocation2.hashCode());
  }

  /**
   * Test {@link JvmStackLocation#equals(Object)}, and {@link JvmStackLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmStackLocation#equals(Object)}
   *   <li>{@link JvmStackLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmStackLocation.equals(Object)", "int JvmStackLocation.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmStackLocation jvmStackLocation = new JvmStackLocation(1);

    // Act and Assert
    assertEquals(jvmStackLocation, jvmStackLocation);
    int expectedHashCodeResult = jvmStackLocation.hashCode();
    assertEquals(expectedHashCodeResult, jvmStackLocation.hashCode());
  }

  /**
   * Test {@link JvmStackLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmStackLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmStackLocation.equals(Object)", "int JvmStackLocation.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmStackLocation jvmStackLocation = new JvmStackLocation(0);

    // Act and Assert
    assertNotEquals(jvmStackLocation, new JvmStackLocation(1));
  }

  /**
   * Test {@link JvmStackLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmStackLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmStackLocation.equals(Object)", "int JvmStackLocation.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmStackLocation(1), null);
  }

  /**
   * Test {@link JvmStackLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmStackLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmStackLocation.equals(Object)", "int JvmStackLocation.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmStackLocation(1), "Different type to JvmStackLocation");
  }
}
