package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.ListAbstractState;
import proguard.analysis.cpa.defaults.MapAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.interfaces.AbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmHeapAbstractState;

class JvmTaintReduceOperatorDiffblueTest {
  /**
   * Test {@link JvmTaintReduceOperator#createJvmAbstractState(JvmCfaNode, JvmFrameAbstractState,
   * JvmHeapAbstractState, MapAbstractState)}.
   *
   * <p>Method under test: {@link JvmTaintReduceOperator#createJvmAbstractState(JvmCfaNode,
   * JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test createJvmAbstractState(JvmCfaNode, JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmTaintAbstractState JvmTaintReduceOperator.createJvmAbstractState(JvmCfaNode, JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)"
  })
  void testCreateJvmAbstractState() {
    // Arrange
    JvmTaintReduceOperator jvmTaintReduceOperator = new JvmTaintReduceOperator(true);
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
    HashMapAbstractState<String, SetAbstractState<JvmTaintSource>> staticFields =
        new HashMapAbstractState<>();

    // Act
    JvmTaintAbstractState actualCreateJvmAbstractStateResult =
        jvmTaintReduceOperator.createJvmAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, staticFields);

    // Assert
    JvmCfaNode programLocation = actualCreateJvmAbstractStateResult.getProgramLocation();
    assertTrue(programLocation instanceof JvmUnknownCfaNode);
    JvmHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 =
        actualCreateJvmAbstractStateResult.getHeap();
    assertTrue(heap2 instanceof JvmForgetfulHeapAbstractState);
    assertNull(actualCreateJvmAbstractStateResult.getPrecision());
    assertSame(staticFields, actualCreateJvmAbstractStateResult.getStaticFields());
    assertSame(frame, actualCreateJvmAbstractStateResult.getFrame());
    assertSame(heap, heap2);
    assertSame(JvmUnknownCfaNode.INSTANCE, programLocation);
  }

  /**
   * Test {@link JvmTaintReduceOperator#onMethodEntry(AbstractState, boolean)}.
   *
   * <ul>
   *   <li>Then copy return {@link JvmTaintAbstractState}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintReduceOperator#onMethodEntry(AbstractState, boolean)}
   */
  @Test
  @DisplayName("Test onMethodEntry(AbstractState, boolean); then copy return JvmTaintAbstractState")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AbstractState JvmTaintReduceOperator.onMethodEntry(AbstractState, boolean)"})
  void testOnMethodEntry_thenCopyReturnJvmTaintAbstractState() {
    // Arrange
    JvmTaintReduceOperator jvmTaintReduceOperator = new JvmTaintReduceOperator(true);
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
    HashMapAbstractState<String, SetAbstractState<JvmTaintSource>> staticFields =
        new HashMapAbstractState<>();

    JvmTaintAbstractState reducedState =
        new JvmTaintAbstractState(JvmUnknownCfaNode.INSTANCE, frame, heap, staticFields);

    // Act
    AbstractState actualOnMethodEntryResult =
        jvmTaintReduceOperator.onMethodEntry(reducedState, true);
    AbstractState actualCopyResult = actualOnMethodEntryResult.copy();

    // Assert
    assertTrue(actualCopyResult instanceof JvmTaintAbstractState);
    assertTrue(actualOnMethodEntryResult instanceof JvmTaintAbstractState);
    assertNull(reducedState.getPrecision());
    assertEquals(reducedState, actualCopyResult);
    assertEquals(reducedState, actualOnMethodEntryResult);
    assertSame(staticFields, reducedState.getStaticFields());
    assertSame(frame, reducedState.getFrame());
    assertSame(heap, reducedState.getHeap());
  }

  /**
   * Test {@link JvmTaintReduceOperator#onMethodEntry(AbstractState, boolean)}.
   *
   * <ul>
   *   <li>When {@link ListAbstractState#ListAbstractState()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintReduceOperator#onMethodEntry(AbstractState, boolean)}
   */
  @Test
  @DisplayName(
      "Test onMethodEntry(AbstractState, boolean); when ListAbstractState(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AbstractState JvmTaintReduceOperator.onMethodEntry(AbstractState, boolean)"})
  void testOnMethodEntry_whenListAbstractState_thenReturnList() {
    // Arrange
    JvmTaintReduceOperator jvmTaintReduceOperator = new JvmTaintReduceOperator(true);
    ListAbstractState<ValueAbstractState> reducedState = new ListAbstractState<>();

    // Act
    AbstractState actualOnMethodEntryResult =
        jvmTaintReduceOperator.onMethodEntry(reducedState, true);
    AbstractState actualCopyResult = actualOnMethodEntryResult.copy();

    // Assert
    assertTrue(actualOnMethodEntryResult instanceof List);
    assertTrue(reducedState.isEmpty());
    assertTrue(((List<Object>) actualOnMethodEntryResult).isEmpty());
    assertEquals(actualOnMethodEntryResult, actualCopyResult);
  }

  /**
   * Test {@link JvmTaintReduceOperator#onMethodEntry(AbstractState, boolean)}.
   *
   * <ul>
   *   <li>When {@link SetAbstractState#SetAbstractState(Object[])} with {@code Items}.
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintReduceOperator#onMethodEntry(AbstractState, boolean)}
   */
  @Test
  @DisplayName(
      "Test onMethodEntry(AbstractState, boolean); when SetAbstractState(Object[]) with 'Items'; then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AbstractState JvmTaintReduceOperator.onMethodEntry(AbstractState, boolean)"})
  void testOnMethodEntry_whenSetAbstractStateWithItems_thenReturnSet() {
    // Arrange
    JvmTaintReduceOperator jvmTaintReduceOperator = new JvmTaintReduceOperator(true);
    SetAbstractState<Object> reducedState = new SetAbstractState<>("Items");

    // Act
    AbstractState actualOnMethodEntryResult =
        jvmTaintReduceOperator.onMethodEntry(reducedState, true);
    AbstractState actualCopyResult = actualOnMethodEntryResult.copy();

    // Assert
    assertTrue(actualOnMethodEntryResult instanceof Set);
    assertEquals(1, reducedState.size());
    assertEquals(1, ((Set<String>) actualOnMethodEntryResult).size());
    assertEquals(actualOnMethodEntryResult, actualCopyResult);
  }

  /**
   * Test {@link JvmTaintReduceOperator#onMethodEntry(AbstractState, boolean)}.
   *
   * <ul>
   *   <li>When {@link JvmMemoryLocationAbstractState#top}.
   *   <li>Then {@link JvmMemoryLocationAbstractState#top} SourceLocations is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintReduceOperator#onMethodEntry(AbstractState, boolean)}
   */
  @Test
  @DisplayName(
      "Test onMethodEntry(AbstractState, boolean); when top; then top SourceLocations is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AbstractState JvmTaintReduceOperator.onMethodEntry(AbstractState, boolean)"})
  void testOnMethodEntry_whenTop_thenTopSourceLocationsIsNull() {
    // Arrange
    JvmMemoryLocationAbstractState reducedState = JvmMemoryLocationAbstractState.top;

    // Act
    AbstractState actualOnMethodEntryResult =
        new JvmTaintReduceOperator(true).onMethodEntry(reducedState, true);

    // Assert
    assertNull(reducedState.getSourceLocations());
    assertNull(reducedState.getPrecision());
    assertNull(reducedState.getLocationDependentMemoryLocation());
    assertSame(
        ((JvmMemoryLocationAbstractState) actualOnMethodEntryResult).top,
        actualOnMethodEntryResult);
  }
}
