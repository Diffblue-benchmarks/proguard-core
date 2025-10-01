package proguard.analysis.cpa.interfaces;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;

class ProgramLocationDependentForwardTransferRelationDiffblueTest {
  /**
   * Test {@link
   * ProgramLocationDependentForwardTransferRelation#getEdges(ProgramLocationDependent)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProgramLocationDependentForwardTransferRelation#getEdges(ProgramLocationDependent)}
   */
  @Test
  @DisplayName("Test getEdges(ProgramLocationDependent); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ProgramLocationDependentForwardTransferRelation.getEdges(ProgramLocationDependent)"
  })
  void testGetEdges_thenReturnEmpty() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);

    JvmTaintAbstractState state =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    // Act and Assert
    assertTrue(jvmTaintTransferRelation.getEdges(state).isEmpty());
  }
}
