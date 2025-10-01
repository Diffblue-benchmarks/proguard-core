package proguard.analysis.cpa.jvm.state;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.MapAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.operators.JvmDefaultReduceOperator;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmHeapAbstractState;

class JvmAbstractStateFactoryDiffblueTest {
  /**
   * Test {@link JvmAbstractStateFactory#createJvmAbstractState(JvmCfaNode, JvmFrameAbstractState,
   * JvmHeapAbstractState, MapAbstractState)}.
   *
   * <p>Method under test: {@link JvmAbstractStateFactory#createJvmAbstractState(JvmCfaNode,
   * JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test createJvmAbstractState(JvmCfaNode, JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmAbstractState JvmAbstractStateFactory.createJvmAbstractState(JvmCfaNode, JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)"
  })
  void testCreateJvmAbstractState() {
    // Arrange
    JvmDefaultReduceOperator<ValueAbstractState> jvmDefaultReduceOperator =
        new JvmDefaultReduceOperator<>(true);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap =
        new JvmForgetfulHeapAbstractState<>(ValueAbstractState.UNKNOWN);
    HashMapAbstractState<String, ValueAbstractState> staticFields = new HashMapAbstractState<>();

    // Act
    JvmAbstractState<ValueAbstractState> actualCreateJvmAbstractStateResult =
        jvmDefaultReduceOperator.createJvmAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, staticFields);

    // Assert
    JvmCfaNode programLocation = actualCreateJvmAbstractStateResult.getProgramLocation();
    assertTrue(programLocation instanceof JvmUnknownCfaNode);
    JvmHeapAbstractState<ValueAbstractState> heap2 = actualCreateJvmAbstractStateResult.getHeap();
    assertTrue(heap2 instanceof JvmForgetfulHeapAbstractState);
    assertNull(actualCreateJvmAbstractStateResult.getPrecision());
    assertSame(staticFields, actualCreateJvmAbstractStateResult.getStaticFields());
    assertSame(frame, actualCreateJvmAbstractStateResult.getFrame());
    assertSame(heap, heap2);
    assertSame(JvmUnknownCfaNode.INSTANCE, programLocation);
  }
}
