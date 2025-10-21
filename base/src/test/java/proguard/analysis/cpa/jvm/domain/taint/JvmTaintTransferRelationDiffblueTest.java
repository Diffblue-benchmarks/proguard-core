package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.defaults.StackAbstractState;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.analysis.cpa.jvm.witness.JvmMemoryLocation;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.Call;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;
import proguard.classfile.instruction.BranchInstruction;

public class JvmTaintTransferRelationDiffblueTest {
  /**
   * Test {@link JvmTaintTransferRelation#JvmTaintTransferRelation(Map, Map, Map)}.
   *
   * <p>Method under test: {@link JvmTaintTransferRelation#JvmTaintTransferRelation(Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintTransferRelation.<init>(Map, Map, Map)"})
  public void testNewJvmTaintTransferRelation() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintTransferRelation.<init>(Map)"})
  public void testNewJvmTaintTransferRelation2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintTransferRelation.<init>(Map, Map)"})
  public void testNewJvmTaintTransferRelation3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintTransferRelation.invokeMethod(JvmAbstractState, Call, List)"})
  public void testInvokeMethod() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
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
   * <p>Method under test: {@link JvmTaintTransferRelation#invokeMethod(JvmAbstractState, Call,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintTransferRelation.invokeMethod(JvmAbstractState, Call, List)"})
  public void testInvokeMethod2() {
    // Arrange
    HashMap<Signature, Set<JvmTaintSource>> taintSources = new HashMap<>();
    HashMap<MethodSignature, JvmTaintTransformer> taintTransformers = new HashMap<>();
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(taintSources, taintTransformers, new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
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
   *   <li>Given {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is {@code A} and
   *       branchOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintTransferRelation#invokeMethod(JvmAbstractState, Call,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintTransferRelation.invokeMethod(JvmAbstractState, Call, List)"})
  public void testInvokeMethod_givenBranchInstructionWithOpcodeIsAAndBranchOffsetIsOne() {
    // Arrange
    HashMap<Call, Set<JvmMemoryLocation>> extraTaintPropagationLocations = new HashMap<>();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true);

    extraTaintPropagationLocations.put(symbolicCall, new HashSet<>());
    HashMap<Signature, Set<JvmTaintSource>> taintSources = new HashMap<>();
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(taintSources, new HashMap<>(), extraTaintPropagationLocations);
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
    JvmAbstractState<SetAbstractState<JvmTaintSource>> state =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall call =
        new SymbolicCall(
            caller2,
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
   *   <li>Given {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is one and
   *       branchOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmTaintTransferRelation#invokeMethod(JvmAbstractState, Call,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmTaintTransferRelation.invokeMethod(JvmAbstractState, Call, List)"})
  public void testInvokeMethod_givenBranchInstructionWithOpcodeIsOneAndBranchOffsetIsOne() {
    // Arrange
    HashMap<Call, Set<JvmMemoryLocation>> extraTaintPropagationLocations = new HashMap<>();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall symbolicCall =
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 1, 1),
            true,
            true);

    extraTaintPropagationLocations.put(symbolicCall, new HashSet<>());
    HashMap<Signature, Set<JvmTaintSource>> taintSources = new HashMap<>();
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(taintSources, new HashMap<>(), extraTaintPropagationLocations);
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap =
        new JvmForgetfulHeapAbstractState<>(null);
    JvmAbstractState<SetAbstractState<JvmTaintSource>> state =
        new JvmAbstractState<>(
            JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    LibraryClass clazz2 = new LibraryClass();
    CodeLocation caller2 = new CodeLocation(clazz2, new LibraryField(1, "Name", "Descriptor"), 2);

    SymbolicCall call =
        new SymbolicCall(
            caller2,
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
   * Test {@link JvmTaintTransferRelation#getAbstractDefault()}.
   *
   * <p>Method under test: {@link JvmTaintTransferRelation#getAbstractDefault()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SetAbstractState JvmTaintTransferRelation.getAbstractDefault()"})
  public void testGetAbstractDefault() {
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
