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

public class JvmStackLocationDiffblueTest {
  /**
   * Method under test:
   * {@link JvmStackLocation#extractValueOrDefault(JvmAbstractState, LatticeAbstractState)}
   */
  @Test
  public void testExtractValueOrDefault() {
    // Arrange
    JvmStackLocation jvmStackLocation = new JvmStackLocation(1);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);

    // Act
    ValueAbstractState actualExtractValueOrDefaultResult = jvmStackLocation.extractValueOrDefault(
        new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>()),
        ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualExtractValueOrDefaultResult.UNKNOWN, actualExtractValueOrDefaultResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmStackLocation#equals(Object)}
   *   <li>{@link JvmStackLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmStackLocation jvmStackLocation = new JvmStackLocation(1);
    JvmStackLocation jvmStackLocation2 = new JvmStackLocation(1);

    // Act and Assert
    assertEquals(jvmStackLocation, jvmStackLocation2);
    int expectedHashCodeResult = jvmStackLocation.hashCode();
    assertEquals(expectedHashCodeResult, jvmStackLocation2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmStackLocation#equals(Object)}
   *   <li>{@link JvmStackLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmStackLocation jvmStackLocation = new JvmStackLocation(1);

    // Act and Assert
    assertEquals(jvmStackLocation, jvmStackLocation);
    int expectedHashCodeResult = jvmStackLocation.hashCode();
    assertEquals(expectedHashCodeResult, jvmStackLocation.hashCode());
  }

  /**
   * Method under test: {@link JvmStackLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmStackLocation jvmStackLocation = new JvmStackLocation(0);

    // Act and Assert
    assertNotEquals(jvmStackLocation, new JvmStackLocation(1));
  }

  /**
   * Method under test: {@link JvmStackLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmStackLocation(1), null);
  }

  /**
   * Method under test: {@link JvmStackLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmStackLocation(1), "Different type to JvmStackLocation");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmStackLocation#JvmStackLocation(int)}
   *   <li>{@link JvmStackLocation#toString()}
   *   <li>{@link JvmStackLocation#getIndex()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    JvmStackLocation actualJvmStackLocation = new JvmStackLocation(1);
    String actualToStringResult = actualJvmStackLocation.toString();

    // Assert
    assertEquals("JvmStackLocation(1)", actualToStringResult);
    assertEquals(1, actualJvmStackLocation.getIndex());
  }
}
