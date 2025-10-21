package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;

public class JvmTaintAbstractStateDiffblueTest {
  /**
   * Test {@link JvmTaintAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmTaintAbstractState JvmTaintAbstractState.join(JvmAbstractState)"})
  public void testJoinWithJvmAbstractState() {
    // Arrange
    JvmCfaNode programLocation =
        new JvmCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
    JvmTaintAbstractState jvmTaintAbstractState =
        new JvmTaintAbstractState(programLocation, frame, heap, new HashMapAbstractState<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 =
        new JvmForgetfulHeapAbstractState<>(null);

    // Act and Assert
    JvmCfaNode programLocation2 =
        jvmTaintAbstractState
            .join(
                new JvmAbstractState<>(
                    JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>()))
            .getProgramLocation();
    Collection<JvmCfaEdge> enteringIntraproceduralEdges =
        programLocation2.getEnteringIntraproceduralEdges();
    assertTrue(enteringIntraproceduralEdges instanceof List);
    Collection<JvmCallCfaEdge> knownMethodCallEdges = programLocation2.getKnownMethodCallEdges();
    assertTrue(knownMethodCallEdges instanceof List);
    Collection<JvmCallCfaEdge> leavingInterproceduralEdges =
        programLocation2.getLeavingInterproceduralEdges();
    assertTrue(leavingInterproceduralEdges instanceof List);
    Collection<JvmCfaEdge> leavingIntraproceduralEdges =
        programLocation2.getLeavingIntraproceduralEdges();
    assertTrue(leavingIntraproceduralEdges instanceof List);
    Optional<JvmCfaEdge> enteringInvokeEdge = programLocation2.getEnteringInvokeEdge();
    assertFalse(enteringInvokeEdge.isPresent());
    assertFalse(programLocation2.isUnknownNode());
    assertTrue(enteringIntraproceduralEdges.isEmpty());
    assertTrue(knownMethodCallEdges.isEmpty());
    assertTrue(leavingInterproceduralEdges.isEmpty());
    assertTrue(leavingIntraproceduralEdges.isEmpty());
    assertTrue(programLocation2.getEnteringEdges().isEmpty());
    assertTrue(programLocation2.getLeavingEdges().isEmpty());
    assertTrue(programLocation2.isReturnExitNode());
    assertTrue(programLocation2.isExitNode());
    assertSame(enteringInvokeEdge, programLocation2.getLeavingInvokeEdge());
  }

  /**
   * Test {@link JvmTaintAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmTaintAbstractState JvmTaintAbstractState.join(JvmAbstractState)"})
  public void testJoinWithJvmAbstractState2() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    frame.setVariable(1, null, null);
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
    JvmTaintAbstractState jvmTaintAbstractState =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 =
        new JvmForgetfulHeapAbstractState<>(null);

    // Act and Assert
    assertSame(
        jvmTaintAbstractState,
        jvmTaintAbstractState.join(
            new JvmAbstractState<>(
                JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>())));
  }

  /**
   * Test {@link JvmTaintAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmTaintAbstractState JvmTaintAbstractState.join(JvmAbstractState)"})
  public void testJoinWithJvmAbstractState3() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
    JvmTaintAbstractState jvmTaintAbstractState =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    frame2.setVariable(1, null, null);
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 =
        new JvmForgetfulHeapAbstractState<>(null);
    JvmAbstractState<SetAbstractState<JvmTaintSource>> abstractState =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>());

    // Act and Assert
    assertEquals(abstractState, jvmTaintAbstractState.join(abstractState));
  }

  /**
   * Test {@link JvmTaintAbstractState#copy()}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmTaintAbstractState JvmTaintAbstractState.copy()"})
  public void testCopy() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
    JvmTaintAbstractState jvmTaintAbstractState =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    // Act and Assert
    assertEquals(jvmTaintAbstractState, jvmTaintAbstractState.copy());
  }
}
