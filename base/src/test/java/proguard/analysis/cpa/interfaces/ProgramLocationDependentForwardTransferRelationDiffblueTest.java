package proguard.analysis.cpa.interfaces;

import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "java.util.List ProgramLocationDependentForwardTransferRelation.getEdges(ProgramLocationDependent)"
  })
  public void testGetEdges_thenReturnEmpty() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);

    // Act and Assert
    assertTrue(
        jvmTaintTransferRelation
            .getEdges(
                new JvmTaintAbstractState(
                    JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>()))
            .isEmpty());
  }
}
