package proguard.analysis.cpa.interfaces;

import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import org.junit.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;

public class ProgramLocationDependentForwardTransferRelationDiffblueTest {
  /**
   * Method under test:
   * {@link ProgramLocationDependentForwardTransferRelation#getEdges(ProgramLocationDependent)}
   */
  @Test
  public void testGetEdges() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap = new JvmForgetfulHeapAbstractState<>(null);

    // Act and Assert
    assertTrue(jvmTaintTransferRelation
        .getEdges(new JvmTaintAbstractState(JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>()))
        .isEmpty());
  }
}
