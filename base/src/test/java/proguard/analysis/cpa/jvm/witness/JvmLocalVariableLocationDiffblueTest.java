package proguard.analysis.cpa.jvm.witness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;

public class JvmLocalVariableLocationDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmLocalVariableLocation.<init>(int)",
    "java.lang.String JvmLocalVariableLocation.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("JvmLocalVariableLocation(1)", (new JvmLocalVariableLocation(1)).toString());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "LatticeAbstractState JvmLocalVariableLocation.extractValueOrDefault(JvmAbstractState, LatticeAbstractState)"
  })
  public void testExtractValueOrDefault_thenReturnUnknown() {
    // Arrange
    JvmLocalVariableLocation jvmLocalVariableLocation = new JvmLocalVariableLocation(1);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);

    // Act
    ValueAbstractState actualExtractValueOrDefaultResult =
        jvmLocalVariableLocation.extractValueOrDefault(
            new JvmAbstractState<>(
                JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>()),
            ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualExtractValueOrDefaultResult.UNKNOWN, actualExtractValueOrDefaultResult);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmLocalVariableLocation.equals(Object)",
    "int JvmLocalVariableLocation.hashCode()"
  })
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmLocalVariableLocation.equals(Object)",
    "int JvmLocalVariableLocation.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmLocalVariableLocation.equals(Object)",
    "int JvmLocalVariableLocation.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmLocalVariableLocation.equals(Object)",
    "int JvmLocalVariableLocation.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmLocalVariableLocation.equals(Object)",
    "int JvmLocalVariableLocation.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmLocalVariableLocation(1), "Different type to JvmLocalVariableLocation");
  }
}
