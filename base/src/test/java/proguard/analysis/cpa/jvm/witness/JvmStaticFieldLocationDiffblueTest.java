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

public class JvmStaticFieldLocationDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmStaticFieldLocation.<init>(String)",
    "String JvmStaticFieldLocation.toString()"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "LatticeAbstractState JvmStaticFieldLocation.extractValueOrDefault(JvmAbstractState, LatticeAbstractState)"
  })
  public void testExtractValueOrDefault_thenReturnUnknown() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmStaticFieldLocation.equals(Object)",
    "int JvmStaticFieldLocation.hashCode()"
  })
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmStaticFieldLocation.equals(Object)",
    "int JvmStaticFieldLocation.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmStaticFieldLocation.equals(Object)",
    "int JvmStaticFieldLocation.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmStaticFieldLocation.equals(Object)",
    "int JvmStaticFieldLocation.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmStaticFieldLocation.equals(Object)",
    "int JvmStaticFieldLocation.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JvmStaticFieldLocation("Fqn"), "Different type to JvmStaticFieldLocation");
  }
}
