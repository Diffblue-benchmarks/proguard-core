package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.MapAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmHeapAbstractState;
import proguard.analysis.cpa.jvm.state.heap.tree.JvmShallowHeapAbstractState;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;

class JvmTaintAbstractStateDiffblueTest {
  /**
   * Test {@link JvmTaintAbstractState#JvmTaintAbstractState(JvmCfaNode, JvmFrameAbstractState,
   * JvmHeapAbstractState, MapAbstractState)}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#JvmTaintAbstractState(JvmCfaNode,
   * JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test new JvmTaintAbstractState(JvmCfaNode, JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmTaintAbstractState.<init>(JvmCfaNode, JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)"
  })
  void testNewJvmTaintAbstractState() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
    HashMapAbstractState<String, SetAbstractState<JvmTaintSource>> staticFields =
        new HashMapAbstractState<>();

    // Act
    JvmTaintAbstractState actualJvmTaintAbstractState =
        new JvmTaintAbstractState(JvmUnknownCfaNode.INSTANCE, frame, heap, staticFields);

    // Assert
    JvmHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 =
        actualJvmTaintAbstractState.getHeap();
    assertTrue(heap2 instanceof JvmForgetfulHeapAbstractState);
    assertSame(staticFields, actualJvmTaintAbstractState.getStaticFields());
    assertSame(frame, actualJvmTaintAbstractState.getFrame());
    assertSame(heap, heap2);
    assertSame(JvmUnknownCfaNode.INSTANCE, actualJvmTaintAbstractState.getProgramLocation());
  }

  /**
   * Test {@link JvmTaintAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmAbstractState) with 'JvmAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmTaintAbstractState JvmTaintAbstractState.join(JvmAbstractState)"})
  void testJoinWithJvmAbstractState() {
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

    JvmAbstractState<SetAbstractState<JvmTaintSource>> abstractState =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>());

    // Act
    JvmTaintAbstractState actualJoinResult = jvmTaintAbstractState.join(abstractState);

    // Assert
    JvmCfaNode programLocation2 = actualJoinResult.getProgramLocation();
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
  @DisplayName("Test join(JvmAbstractState) with 'JvmAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmTaintAbstractState JvmTaintAbstractState.join(JvmAbstractState)"})
  void testJoinWithJvmAbstractState2() {
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

    JvmAbstractState<SetAbstractState<JvmTaintSource>> abstractState =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>());

    // Act
    JvmTaintAbstractState actualJoinResult = jvmTaintAbstractState.join(abstractState);

    // Assert
    assertSame(jvmTaintAbstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmTaintAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmAbstractState) with 'JvmAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmTaintAbstractState JvmTaintAbstractState.join(JvmAbstractState)"})
  void testJoinWithJvmAbstractState3() {
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

    // Act
    JvmTaintAbstractState actualJoinResult = jvmTaintAbstractState.join(abstractState);

    // Assert
    assertEquals(abstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmTaintAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmAbstractState) with 'JvmAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmTaintAbstractState JvmTaintAbstractState.join(JvmAbstractState)"})
  void testJoinWithJvmAbstractState4() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    HashMapAbstractState<Object, SetAbstractState<JvmTaintSource>> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, SetAbstractState<JvmTaintSource>> heap =
        new JvmShallowHeapAbstractState<>(referenceToObject, referenceClass, null);

    JvmTaintAbstractState jvmTaintAbstractState =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    HashMapAbstractState<Object, SetAbstractState<JvmTaintSource>> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, SetAbstractState<JvmTaintSource>> heap2 =
        new JvmShallowHeapAbstractState<>(referenceToObject2, referenceClass2, null);

    JvmAbstractState<SetAbstractState<JvmTaintSource>> abstractState =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>());

    // Act
    JvmTaintAbstractState actualJoinResult = jvmTaintAbstractState.join(abstractState);

    // Assert
    assertSame(jvmTaintAbstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmTaintAbstractState#join(JvmAbstractState)} with {@code JvmAbstractState}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#join(JvmAbstractState)}
   */
  @Test
  @DisplayName("Test join(JvmAbstractState) with 'JvmAbstractState'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmTaintAbstractState JvmTaintAbstractState.join(JvmAbstractState)"})
  void testJoinWithJvmAbstractState5() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    HashMapAbstractState<Object, SetAbstractState<JvmTaintSource>> referenceToObject =
        new HashMapAbstractState<>();
    Class<Object> referenceClass = Object.class;

    JvmShallowHeapAbstractState<Object, SetAbstractState<JvmTaintSource>> heap =
        new JvmShallowHeapAbstractState<>(referenceToObject, referenceClass, null);

    JvmTaintAbstractState jvmTaintAbstractState =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    jvmTaintAbstractState.setArrayElement("Array", null, null);
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    HashMapAbstractState<Object, SetAbstractState<JvmTaintSource>> referenceToObject2 =
        new HashMapAbstractState<>();
    Class<Object> referenceClass2 = Object.class;

    JvmShallowHeapAbstractState<Object, SetAbstractState<JvmTaintSource>> heap2 =
        new JvmShallowHeapAbstractState<>(referenceToObject2, referenceClass2, null);

    JvmAbstractState<SetAbstractState<JvmTaintSource>> abstractState =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame2, heap2, new HashMapAbstractState<>());

    // Act
    JvmTaintAbstractState actualJoinResult = jvmTaintAbstractState.join(abstractState);

    // Assert
    assertEquals(abstractState, actualJoinResult);
  }

  /**
   * Test {@link JvmTaintAbstractState#copy()}.
   *
   * <p>Method under test: {@link JvmTaintAbstractState#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmTaintAbstractState JvmTaintAbstractState.copy()"})
  void testCopy() {
    // Arrange
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);

    JvmTaintAbstractState jvmTaintAbstractState =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    // Act
    JvmTaintAbstractState actualCopyResult = jvmTaintAbstractState.copy();

    // Assert
    assertEquals(jvmTaintAbstractState, actualCopyResult);
  }
}
