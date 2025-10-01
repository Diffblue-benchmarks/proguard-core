package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.MapAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.interfaces.AbstractState;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmHeapAbstractState;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.Call;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Signature;
import proguard.classfile.instruction.BranchInstruction;

class JvmTaintExpandOperatorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link JvmCfa} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmTaintExpandOperator#JvmTaintExpandOperator(JvmCfa, Map)}
   *   <li>{@link JvmTaintExpandOperator#getSignaturesToSources()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when JvmCfa (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmTaintExpandOperator.<init>(JvmCfa, Map)",
    "void JvmTaintExpandOperator.<init>(JvmCfa, Map, boolean)",
    "Map JvmTaintExpandOperator.getSignaturesToSources()"
  })
  void testGettersAndSetters_whenJvmCfa() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    HashMap<Signature, Set<JvmTaintSource>> signaturesToSources = new HashMap<>();

    // Act
    JvmTaintExpandOperator actualJvmTaintExpandOperator =
        new JvmTaintExpandOperator(cfa, signaturesToSources);
    Map<Signature, Set<JvmTaintSource>> actualSignaturesToSources =
        actualJvmTaintExpandOperator.getSignaturesToSources();

    // Assert
    assertTrue(actualSignaturesToSources.isEmpty());
    assertSame(signaturesToSources, actualSignaturesToSources);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmTaintExpandOperator#JvmTaintExpandOperator(JvmCfa, Map, boolean)}
   *   <li>{@link JvmTaintExpandOperator#getSignaturesToSources()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmTaintExpandOperator.<init>(JvmCfa, Map)",
    "void JvmTaintExpandOperator.<init>(JvmCfa, Map, boolean)",
    "Map JvmTaintExpandOperator.getSignaturesToSources()"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    HashMap<Signature, Set<JvmTaintSource>> signaturesToSources = new HashMap<>();

    // Act
    JvmTaintExpandOperator actualJvmTaintExpandOperator =
        new JvmTaintExpandOperator(cfa, signaturesToSources, true);
    Map<Signature, Set<JvmTaintSource>> actualSignaturesToSources =
        actualJvmTaintExpandOperator.getSignaturesToSources();

    // Assert
    assertTrue(actualSignaturesToSources.isEmpty());
    assertSame(signaturesToSources, actualSignaturesToSources);
  }

  /**
   * Test {@link JvmTaintExpandOperator#expand(AbstractState, AbstractState, JvmCfaNode, Call)} with
   * {@code AbstractState}, {@code AbstractState}, {@code JvmCfaNode}, {@code Call}.
   *
   * <ul>
   *   <li>Then return Precision is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintExpandOperator#expand(AbstractState, AbstractState,
   * JvmCfaNode, Call)}
   */
  @Test
  @DisplayName(
      "Test expand(AbstractState, AbstractState, JvmCfaNode, Call) with 'AbstractState', 'AbstractState', 'JvmCfaNode', 'Call'; then return Precision is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmTaintAbstractState JvmTaintExpandOperator.expand(AbstractState, AbstractState, JvmCfaNode, Call)"
  })
  void testExpandWithAbstractStateAbstractStateJvmCfaNodeCall_thenReturnPrecisionIsNull() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    JvmTaintExpandOperator jvmTaintExpandOperator =
        new JvmTaintExpandOperator(cfa, new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);

    JvmTaintAbstractState expandedInitialState =
        new JvmTaintAbstractState(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());
    JvmCfaNode programLocation =
        new JvmCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, -2, new LibraryClass());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame2 = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap2 =
        new JvmForgetfulHeapAbstractState<>(null);
    HashMapAbstractState<String, SetAbstractState<JvmTaintSource>> staticFields =
        new HashMapAbstractState<>();

    JvmTaintAbstractState reducedExitState =
        new JvmTaintAbstractState(programLocation, frame2, heap2, staticFields);
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    CodeLocation caller = new CodeLocation(clazz, member, 2);
    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    JvmTaintAbstractState actualExpandResult =
        jvmTaintExpandOperator.expand(
            expandedInitialState, reducedExitState, JvmUnknownCfaNode.INSTANCE, call);

    // Assert
    assertNull(actualExpandResult.getPrecision());
    assertNull(actualExpandResult.getProgramLocation());
    MapAbstractState<String, SetAbstractState<JvmTaintSource>> staticFields2 =
        actualExpandResult.getStaticFields();
    assertTrue(staticFields2.isEmpty());
    assertEquals(frame, actualExpandResult.getFrame());
    assertSame(staticFields, staticFields2);
    assertSame(heap2, actualExpandResult.getHeap());
  }

  /**
   * Test {@link JvmTaintExpandOperator#createJvmAbstractState(JvmCfaNode, JvmFrameAbstractState,
   * JvmHeapAbstractState, MapAbstractState)}.
   *
   * <p>Method under test: {@link JvmTaintExpandOperator#createJvmAbstractState(JvmCfaNode,
   * JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)}
   */
  @Test
  @DisplayName(
      "Test createJvmAbstractState(JvmCfaNode, JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmTaintAbstractState JvmTaintExpandOperator.createJvmAbstractState(JvmCfaNode, JvmFrameAbstractState, JvmHeapAbstractState, MapAbstractState)"
  })
  void testCreateJvmAbstractState() {
    // Arrange
    JvmCfa cfa = new JvmCfa();
    JvmTaintExpandOperator jvmTaintExpandOperator =
        new JvmTaintExpandOperator(cfa, new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
    HashMapAbstractState<String, SetAbstractState<JvmTaintSource>> staticFields =
        new HashMapAbstractState<>();

    // Act
    JvmTaintAbstractState actualCreateJvmAbstractStateResult =
        jvmTaintExpandOperator.createJvmAbstractState(
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
}
