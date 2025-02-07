package proguard.analysis.cpa.jvm.witness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

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

class JvmStaticFieldLocationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmStaticFieldLocation#JvmStaticFieldLocation(String)}
   *   <li>{@link JvmStaticFieldLocation#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.<init>(java.lang.String)",
    "java.lang.String proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("JvmStaticFieldLocation(Fqn)", (new JvmStaticFieldLocation("Fqn")).toString());
  }

  /**
   * Test {@link JvmStaticFieldLocation#extractValueOrDefault(JvmAbstractState,
   * LatticeAbstractState)}.
   *
   * <ul>
   *   <li>Then return {@link ValueAbstractState#UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link JvmStaticFieldLocation#extractValueOrDefault(JvmAbstractState,
   * LatticeAbstractState)}
   */
  @Test
  @DisplayName(
      "Test extractValueOrDefault(JvmAbstractState, LatticeAbstractState); then return UNKNOWN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.extractValueOrDefault(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.cpa.defaults.LatticeAbstractState)"
  })
  void testExtractValueOrDefault_thenReturnUnknown() {
    // Arrange
    JvmStaticFieldLocation jvmStaticFieldLocation = new JvmStaticFieldLocation("Fqn");
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act
    ValueAbstractState actualExtractValueOrDefaultResult =
        jvmStaticFieldLocation.extractValueOrDefault(
            new JvmAbstractState<>(
                JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>()),
            ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualExtractValueOrDefaultResult.UNKNOWN, actualExtractValueOrDefaultResult);
  }

  /**
   * Test {@link JvmStaticFieldLocation#equals(Object)}, and {@link
   * JvmStaticFieldLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmStaticFieldLocation#equals(Object)}
   *   <li>{@link JvmStaticFieldLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmStaticFieldLocation jvmStaticFieldLocation = new JvmStaticFieldLocation("Fqn");
    JvmStaticFieldLocation jvmStaticFieldLocation2 = new JvmStaticFieldLocation("Fqn");

    // Act and Assert
    assertEquals(jvmStaticFieldLocation, jvmStaticFieldLocation2);
    int expectedHashCodeResult = jvmStaticFieldLocation.hashCode();
    assertEquals(expectedHashCodeResult, jvmStaticFieldLocation2.hashCode());
  }

  /**
   * Test {@link JvmStaticFieldLocation#equals(Object)}, and {@link
   * JvmStaticFieldLocation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmStaticFieldLocation#equals(Object)}
   *   <li>{@link JvmStaticFieldLocation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmStaticFieldLocation jvmStaticFieldLocation = new JvmStaticFieldLocation("Fqn");

    // Act and Assert
    assertEquals(jvmStaticFieldLocation, jvmStaticFieldLocation);
    int expectedHashCodeResult = jvmStaticFieldLocation.hashCode();
    assertEquals(expectedHashCodeResult, jvmStaticFieldLocation.hashCode());
  }

  /**
   * Test {@link JvmStaticFieldLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmStaticFieldLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmStaticFieldLocation jvmStaticFieldLocation =
        new JvmStaticFieldLocation("proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation");

    // Act and Assert
    assertNotEquals(jvmStaticFieldLocation, new JvmStaticFieldLocation("Fqn"));
  }

  /**
   * Test {@link JvmStaticFieldLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmStaticFieldLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmStaticFieldLocation("Fqn"), null);
  }

  /**
   * Test {@link JvmStaticFieldLocation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmStaticFieldLocation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmStaticFieldLocation("Fqn"), "Different type to JvmStaticFieldLocation");
  }
}
