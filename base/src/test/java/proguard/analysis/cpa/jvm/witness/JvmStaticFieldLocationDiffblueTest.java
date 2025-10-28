package proguard.analysis.cpa.jvm.witness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;

public class JvmStaticFieldLocationDiffblueTest {
  /**
   * Method under test:
   * {@link JvmStaticFieldLocation#extractValueOrDefault(JvmAbstractState, LatticeAbstractState)}
   */
  @Test
  public void testExtractValueOrDefault() {
    // Arrange
    JvmStaticFieldLocation jvmStaticFieldLocation = new JvmStaticFieldLocation("Fqn");
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);

    // Act
    ValueAbstractState actualExtractValueOrDefaultResult = jvmStaticFieldLocation.extractValueOrDefault(
        new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>()),
        ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualExtractValueOrDefaultResult.UNKNOWN, actualExtractValueOrDefaultResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmStaticFieldLocation#equals(Object)}
   *   <li>{@link JvmStaticFieldLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmStaticFieldLocation jvmStaticFieldLocation = new JvmStaticFieldLocation("Fqn");
    JvmStaticFieldLocation jvmStaticFieldLocation2 = new JvmStaticFieldLocation("Fqn");

    // Act and Assert
    assertEquals(jvmStaticFieldLocation, jvmStaticFieldLocation2);
    int expectedHashCodeResult = jvmStaticFieldLocation.hashCode();
    assertEquals(expectedHashCodeResult, jvmStaticFieldLocation2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmStaticFieldLocation#equals(Object)}
   *   <li>{@link JvmStaticFieldLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmStaticFieldLocation jvmStaticFieldLocation = new JvmStaticFieldLocation("Fqn");

    // Act and Assert
    assertEquals(jvmStaticFieldLocation, jvmStaticFieldLocation);
    int expectedHashCodeResult = jvmStaticFieldLocation.hashCode();
    assertEquals(expectedHashCodeResult, jvmStaticFieldLocation.hashCode());
  }

  /**
   * Method under test: {@link JvmStaticFieldLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmStaticFieldLocation jvmStaticFieldLocation = new JvmStaticFieldLocation(
        "proguard.analysis.cpa.jvm.witness.JvmStaticFieldLocation");

    // Act and Assert
    assertNotEquals(jvmStaticFieldLocation, new JvmStaticFieldLocation("Fqn"));
  }

  /**
   * Method under test: {@link JvmStaticFieldLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmStaticFieldLocation("Fqn"), null);
  }

  /**
   * Method under test: {@link JvmStaticFieldLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmStaticFieldLocation("Fqn"), "Different type to JvmStaticFieldLocation");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmStaticFieldLocation#JvmStaticFieldLocation(String)}
   *   <li>{@link JvmStaticFieldLocation#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("JvmStaticFieldLocation(Fqn)", (new JvmStaticFieldLocation("Fqn")).toString());
  }
}
