package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.defaults.StackAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.Call;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;
import proguard.classfile.instruction.BranchInstruction;

class JvmTaintTransferRelationDiffblueTest {
  /**
   * Test {@link JvmTaintTransferRelation#JvmTaintTransferRelation(Map, Map, Map)}.
   *
   * <p>Method under test: {@link JvmTaintTransferRelation#JvmTaintTransferRelation(Map, Map, Map)}
   */
  @Test
  @DisplayName("Test new JvmTaintTransferRelation(Map, Map, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation.<init>(java.util.Map, java.util.Map, java.util.Map)"
  })
  void testNewJvmTaintTransferRelation() {
    // Arrange
    HashMap<Signature, Set<JvmTaintSource>> taintSources = new HashMap<>();
    HashMap<MethodSignature, JvmTaintTransformer> taintTransformers = new HashMap<>();

    // Act
    JvmTaintTransferRelation actualJvmTaintTransferRelation =
        new JvmTaintTransferRelation(taintSources, taintTransformers, new HashMap<>());

    // Assert
    SetAbstractState<JvmTaintSource> abstractDefault =
        actualJvmTaintTransferRelation.getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, actualJvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTaintTransferRelation#JvmTaintTransferRelation(Map)}.
   *
   * <p>Method under test: {@link JvmTaintTransferRelation#JvmTaintTransferRelation(Map)}
   */
  @Test
  @DisplayName("Test new JvmTaintTransferRelation(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation.<init>(java.util.Map)"
  })
  void testNewJvmTaintTransferRelation2() {
    // Arrange and Act
    JvmTaintTransferRelation actualJvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Assert
    SetAbstractState<JvmTaintSource> abstractDefault =
        actualJvmTaintTransferRelation.getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, actualJvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTaintTransferRelation#JvmTaintTransferRelation(Map, Map)}.
   *
   * <p>Method under test: {@link JvmTaintTransferRelation#JvmTaintTransferRelation(Map, Map)}
   */
  @Test
  @DisplayName("Test new JvmTaintTransferRelation(Map, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation.<init>(java.util.Map, java.util.Map)"
  })
  void testNewJvmTaintTransferRelation3() {
    // Arrange
    HashMap<Signature, Set<JvmTaintSource>> taintSources = new HashMap<>();

    // Act
    JvmTaintTransferRelation actualJvmTaintTransferRelation =
        new JvmTaintTransferRelation(taintSources, new HashMap<>());

    // Assert
    SetAbstractState<JvmTaintSource> abstractDefault =
        actualJvmTaintTransferRelation.getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, actualJvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTaintTransferRelation#invokeMethod(JvmAbstractState, Call, List)}.
   *
   * <p>Method under test: {@link JvmTaintTransferRelation#invokeMethod(JvmAbstractState, Call,
   * List)}
   */
  @Test
  @DisplayName("Test invokeMethod(JvmAbstractState, Call, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation.invokeMethod(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call, java.util.List)"
  })
  void testInvokeMethod() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(mock(SetAbstractState.class));
    JvmAbstractState<SetAbstractState<JvmTaintSource>> state =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    // Act
    jvmTaintTransferRelation.invokeMethod(state, call, new ArrayList<>());

    // Assert
    StackAbstractState<SetAbstractState<JvmTaintSource>> operandStack =
        state.getFrame().getOperandStack();
    assertEquals(1, operandStack.size());
    SetAbstractState<JvmTaintSource> peekResult = state.peek();
    assertTrue(peekResult.isEmpty());
    assertSame(peekResult, operandStack.get(0));
    assertSame(peekResult, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(peekResult, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTaintTransferRelation#invokeMethod(JvmAbstractState, Call, List)}.
   *
   * <ul>
   *   <li>Given {@link SetAbstractState} {@link AbstractCollection#addAll(Collection)} return
   *       {@code true}.
   *   <li>Then calls {@link AbstractCollection#addAll(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintTransferRelation#invokeMethod(JvmAbstractState, Call,
   * List)}
   */
  @Test
  @DisplayName(
      "Test invokeMethod(JvmAbstractState, Call, List); given SetAbstractState addAll(Collection) return 'true'; then calls addAll(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation.invokeMethod(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call, java.util.List)"
  })
  void testInvokeMethod_givenSetAbstractStateAddAllReturnTrue_thenCallsAddAll() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(mock(SetAbstractState.class));
    JvmAbstractState<SetAbstractState<JvmTaintSource>> state =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    SetAbstractState<JvmTaintSource> jvmTaintSourceSet = mock(SetAbstractState.class);
    when(jvmTaintSourceSet.addAll(Mockito.<Collection<JvmTaintSource>>any())).thenReturn(true);
    when(jvmTaintSourceSet.isLessOrEqual(Mockito.<SetAbstractState<JvmTaintSource>>any()))
        .thenReturn(true);
    SetAbstractState<JvmTaintSource> jvmTaintSourceSet2 = mock(SetAbstractState.class);
    when(jvmTaintSourceSet2.copy()).thenReturn(jvmTaintSourceSet);

    ArrayList<SetAbstractState<JvmTaintSource>> operands = new ArrayList<>();
    operands.add(jvmTaintSourceSet2);

    // Act
    jvmTaintTransferRelation.invokeMethod(state, call, operands);

    // Assert
    verify(jvmTaintSourceSet).addAll(isA(Collection.class));
    verify(jvmTaintSourceSet2).copy();
    verify(jvmTaintSourceSet).isLessOrEqual(isA(SetAbstractState.class));
    StackAbstractState<SetAbstractState<JvmTaintSource>> operandStack =
        state.getFrame().getOperandStack();
    assertEquals(1, operandStack.size());
    SetAbstractState<JvmTaintSource> peekResult = state.peek();
    assertTrue(peekResult.isEmpty());
    assertSame(peekResult, operandStack.get(0));
    assertSame(peekResult, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(peekResult, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTaintTransferRelation#invokeMethod(JvmAbstractState, Call, List)}.
   *
   * <ul>
   *   <li>Given {@link SetAbstractState} {@link AbstractCollection#addAll(Collection)} return
   *       {@code true}.
   *   <li>Then calls {@link AbstractCollection#addAll(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintTransferRelation#invokeMethod(JvmAbstractState, Call,
   * List)}
   */
  @Test
  @DisplayName(
      "Test invokeMethod(JvmAbstractState, Call, List); given SetAbstractState addAll(Collection) return 'true'; then calls addAll(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation.invokeMethod(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call, java.util.List)"
  })
  void testInvokeMethod_givenSetAbstractStateAddAllReturnTrue_thenCallsAddAll2() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(mock(SetAbstractState.class));
    JvmAbstractState<SetAbstractState<JvmTaintSource>> state =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall call =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    SetAbstractState<JvmTaintSource> jvmTaintSourceSet = mock(SetAbstractState.class);
    when(jvmTaintSourceSet.addAll(Mockito.<Collection<JvmTaintSource>>any())).thenReturn(true);
    when(jvmTaintSourceSet.isLessOrEqual(Mockito.<SetAbstractState<JvmTaintSource>>any()))
        .thenReturn(true);
    SetAbstractState<JvmTaintSource> jvmTaintSourceSet2 = mock(SetAbstractState.class);
    when(jvmTaintSourceSet2.copy()).thenReturn(jvmTaintSourceSet);
    SetAbstractState<JvmTaintSource> jvmTaintSourceSet3 = mock(SetAbstractState.class);
    when(jvmTaintSourceSet3.addAll(Mockito.<Collection<JvmTaintSource>>any())).thenReturn(true);
    when(jvmTaintSourceSet3.isLessOrEqual(Mockito.<SetAbstractState<JvmTaintSource>>any()))
        .thenReturn(true);
    SetAbstractState<JvmTaintSource> jvmTaintSourceSet4 = mock(SetAbstractState.class);
    when(jvmTaintSourceSet4.copy()).thenReturn(jvmTaintSourceSet3);

    ArrayList<SetAbstractState<JvmTaintSource>> operands = new ArrayList<>();
    operands.add(jvmTaintSourceSet4);
    operands.add(jvmTaintSourceSet2);

    // Act
    jvmTaintTransferRelation.invokeMethod(state, call, operands);

    // Assert
    verify(jvmTaintSourceSet3).addAll(isA(Collection.class));
    verify(jvmTaintSourceSet).addAll(isA(Collection.class));
    verify(jvmTaintSourceSet4).copy();
    verify(jvmTaintSourceSet2).copy();
    verify(jvmTaintSourceSet3).isLessOrEqual(isA(SetAbstractState.class));
    verify(jvmTaintSourceSet).isLessOrEqual(isA(SetAbstractState.class));
    StackAbstractState<SetAbstractState<JvmTaintSource>> operandStack =
        state.getFrame().getOperandStack();
    assertEquals(1, operandStack.size());
    SetAbstractState<JvmTaintSource> peekResult = state.peek();
    assertTrue(peekResult.isEmpty());
    assertSame(peekResult, operandStack.get(0));
    assertSame(peekResult, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(peekResult, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTaintTransferRelation#getAbstractDefault()}.
   *
   * <p>Method under test: {@link JvmTaintTransferRelation#getAbstractDefault()}
   */
  @Test
  @DisplayName("Test getAbstractDefault()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.SetAbstractState proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation.getAbstractDefault()"
  })
  void testGetAbstractDefault() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractDefault =
        jvmTaintTransferRelation.getAbstractDefault();

    // Assert
    assertTrue(actualAbstractDefault.isEmpty());
    SetAbstractState setAbstractState = actualAbstractDefault.bottom;
    assertSame(setAbstractState, actualAbstractDefault);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }
}
