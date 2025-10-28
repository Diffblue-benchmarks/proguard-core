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

public class JvmLocalVariableLocationDiffblueTest {
  /**
   * Method under test:
   * {@link JvmLocalVariableLocation#extractValueOrDefault(JvmAbstractState, LatticeAbstractState)}
   */
  @Test
  public void testExtractValueOrDefault() {
    // Arrange
    JvmLocalVariableLocation jvmLocalVariableLocation = new JvmLocalVariableLocation(1);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);

    // Act
    ValueAbstractState actualExtractValueOrDefaultResult = jvmLocalVariableLocation.extractValueOrDefault(
        new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>()),
        ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualExtractValueOrDefaultResult.UNKNOWN, actualExtractValueOrDefaultResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmLocalVariableLocation#equals(Object)}
   *   <li>{@link JvmLocalVariableLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmLocalVariableLocation jvmLocalVariableLocation = new JvmLocalVariableLocation(1);
    JvmLocalVariableLocation jvmLocalVariableLocation2 = new JvmLocalVariableLocation(1);

    // Act and Assert
    assertEquals(jvmLocalVariableLocation, jvmLocalVariableLocation2);
    int expectedHashCodeResult = jvmLocalVariableLocation.hashCode();
    assertEquals(expectedHashCodeResult, jvmLocalVariableLocation2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmLocalVariableLocation#equals(Object)}
   *   <li>{@link JvmLocalVariableLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmLocalVariableLocation jvmLocalVariableLocation = new JvmLocalVariableLocation(1);

    // Act and Assert
    assertEquals(jvmLocalVariableLocation, jvmLocalVariableLocation);
    int expectedHashCodeResult = jvmLocalVariableLocation.hashCode();
    assertEquals(expectedHashCodeResult, jvmLocalVariableLocation.hashCode());
  }

  /**
   * Method under test: {@link JvmLocalVariableLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmLocalVariableLocation jvmLocalVariableLocation = new JvmLocalVariableLocation(0);

    // Act and Assert
    assertNotEquals(jvmLocalVariableLocation, new JvmLocalVariableLocation(1));
  }

  /**
   * Method under test: {@link JvmLocalVariableLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmLocalVariableLocation(1), null);
  }

  /**
   * Method under test: {@link JvmLocalVariableLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmLocalVariableLocation(1), "Different type to JvmLocalVariableLocation");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmLocalVariableLocation#JvmLocalVariableLocation(int)}
   *   <li>{@link JvmLocalVariableLocation#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("JvmLocalVariableLocation(1)", (new JvmLocalVariableLocation(1)).toString());
  }
}
