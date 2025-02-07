package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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

class JvmTaintAbstractStateDiffblueTest {
  /**
   * Test {@link JvmTaintAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmAbstractState) with 'JvmAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState.join(proguard.analysis.cpa.jvm.state.JvmAbstractState)"
  })
  void testJoinWithJvmAbstractState() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(mock(SetAbstractState.class));
    JvmTaintAbstractState jvmTaintAbstractState =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 =
        new JvmForgetfulHeapAbstractState<>(mock(SetAbstractState.class));

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
  @DisplayName("Test join(JvmAbstractState) with 'JvmAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState.join(proguard.analysis.cpa.jvm.state.JvmAbstractState)"
  })
  void testJoinWithJvmAbstractState2() {
    // Arrange
    JvmCfaNode programLocation =
        new JvmCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(mock(SetAbstractState.class));
    JvmTaintAbstractState jvmTaintAbstractState =
        new JvmTaintAbstractState(programLocation, frame, heap, new HashMapAbstractState<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 =
        new JvmForgetfulHeapAbstractState<>(mock(SetAbstractState.class));

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
   * <ul>
   *   <li>Then return StaticFields Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  @DisplayName(
      "Test join(JvmAbstractState) with 'JvmAbstractState'; then return StaticFields Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState.join(proguard.analysis.cpa.jvm.state.JvmAbstractState)"
  })
  void testJoinWithJvmAbstractState_thenReturnStaticFieldsEmpty() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    frame.setVariable(1, mock(SetAbstractState.class), mock(SetAbstractState.class));
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(mock(SetAbstractState.class));
    JvmTaintAbstractState jvmTaintAbstractState =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 =
        new JvmForgetfulHeapAbstractState<>(mock(SetAbstractState.class));

    // Act
    JvmTaintAbstractState actualJoinResult =
        jvmTaintAbstractState.join(
            new JvmAbstractState<>(
                JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>()));

    // Assert
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame3 = actualJoinResult.getFrame();
    assertEquals(2, frame3.getLocalVariables().size());
    assertTrue(actualJoinResult.getStaticFields().isEmpty());
    assertTrue(frame3.getOperandStack().isEmpty());
  }

  /**
   * Test {@link JvmTaintAbstractState#copy()}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState.copy()"
  })
  void testCopy() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(mock(SetAbstractState.class));
    JvmTaintAbstractState jvmTaintAbstractState =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    // Act and Assert
    assertEquals(jvmTaintAbstractState, jvmTaintAbstractState.copy());
  }
}
