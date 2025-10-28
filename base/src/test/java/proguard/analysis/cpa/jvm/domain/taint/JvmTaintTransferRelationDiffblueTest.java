package proguard.analysis.cpa.jvm.domain.taint;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.interfaces.Precision;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.VariableInstruction;

public class JvmTaintTransferRelationDiffblueTest {
  /**
   * Method under test: {@link JvmTaintTransferRelation#getAbstractDefault()}
   */
  @Test
  public void testGetAbstractDefault() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractDefault = jvmTaintTransferRelation.getAbstractDefault();

    // Assert
    assertTrue(actualAbstractDefault.isEmpty());
    SetAbstractState setAbstractState = actualAbstractDefault.bottom;
    assertSame(setAbstractState, actualAbstractDefault);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Method under test:
   * {@link JvmTaintTransferRelation#getAbstractSuccessorForInstruction(JvmAbstractState, Instruction, Clazz, Precision)}
   */
  @Test
  public void testGetAbstractSuccessorForInstruction() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap = new JvmForgetfulHeapAbstractState<>(null);
    JvmAbstractState<SetAbstractState<JvmTaintSource>> abstractState = new JvmAbstractState<>(
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    BranchInstruction instruction = new BranchInstruction((byte) 2, 1);

    // Act and Assert
    assertSame(abstractState, jvmTaintTransferRelation.getAbstractSuccessorForInstruction(abstractState, instruction,
        new LibraryClass(), null));
  }

  /**
   * Method under test:
   * {@link JvmTaintTransferRelation#getAbstractSuccessorForInstruction(JvmAbstractState, Instruction, Clazz, Precision)}
   */
  @Test
  public void testGetAbstractSuccessorForInstruction2() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap = new JvmForgetfulHeapAbstractState<>(null);
    JvmAbstractState<SetAbstractState<JvmTaintSource>> abstractState = new JvmAbstractState<>(
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    LookUpSwitchInstruction instruction = new LookUpSwitchInstruction();

    // Act and Assert
    assertSame(abstractState, jvmTaintTransferRelation.getAbstractSuccessorForInstruction(abstractState, instruction,
        new LibraryClass(), null));
  }

  /**
   * Method under test:
   * {@link JvmTaintTransferRelation#getAbstractSuccessorForInstruction(JvmAbstractState, Instruction, Clazz, Precision)}
   */
  @Test
  public void testGetAbstractSuccessorForInstruction3() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap = new JvmForgetfulHeapAbstractState<>(null);
    JvmAbstractState<SetAbstractState<JvmTaintSource>> abstractState = new JvmAbstractState<>(
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    SimpleInstruction instruction = new SimpleInstruction();

    // Act and Assert
    assertSame(abstractState, jvmTaintTransferRelation.getAbstractSuccessorForInstruction(abstractState, instruction,
        new LibraryClass(), null));
  }

  /**
   * Method under test:
   * {@link JvmTaintTransferRelation#getAbstractSuccessorForInstruction(JvmAbstractState, Instruction, Clazz, Precision)}
   */
  @Test
  public void testGetAbstractSuccessorForInstruction4() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap = new JvmForgetfulHeapAbstractState<>(null);
    JvmAbstractState<SetAbstractState<JvmTaintSource>> abstractState = new JvmAbstractState<>(
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    VariableInstruction instruction = new VariableInstruction();

    // Act and Assert
    assertSame(abstractState, jvmTaintTransferRelation.getAbstractSuccessorForInstruction(abstractState, instruction,
        new LibraryClass(), null));
  }

  /**
   * Method under test:
   * {@link JvmTaintTransferRelation#getAbstractSuccessorForInstruction(JvmAbstractState, Instruction, Clazz, Precision)}
   */
  @Test
  public void testGetAbstractSuccessorForInstruction5() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());
    JvmFrameAbstractState<SetAbstractState<JvmTaintSource>> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<SetAbstractState<JvmTaintSource>> heap = new JvmForgetfulHeapAbstractState<>(null);
    JvmAbstractState<SetAbstractState<JvmTaintSource>> abstractState = new JvmAbstractState<>(
        JvmUnknownCfaNode.INSTANCE, frame, heap, new HashMapAbstractState<>());

    ConstantInstruction instruction = new ConstantInstruction((byte) -78, 1);

    // Act and Assert
    assertSame(abstractState, jvmTaintTransferRelation.getAbstractSuccessorForInstruction(abstractState, instruction,
        new LibraryClass(), null));
  }

  /**
   * Method under test:
   * {@link JvmTaintTransferRelation#JvmTaintTransferRelation(Map, Map, Map)}
   */
  @Test
  public void testNewJvmTaintTransferRelation() {
    // Arrange
    HashMap<Signature, Set<JvmTaintSource>> taintSources = new HashMap<>();
    HashMap<MethodSignature, JvmTaintTransformer> taintTransformers = new HashMap<>();

    // Act
    JvmTaintTransferRelation actualJvmTaintTransferRelation = new JvmTaintTransferRelation(taintSources,
        taintTransformers, new HashMap<>());

    // Assert
    SetAbstractState<JvmTaintSource> abstractDefault = actualJvmTaintTransferRelation.getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, actualJvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Method under test:
   * {@link JvmTaintTransferRelation#JvmTaintTransferRelation(Map)}
   */
  @Test
  public void testNewJvmTaintTransferRelation2() {
    // Arrange and Act
    JvmTaintTransferRelation actualJvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());

    // Assert
    SetAbstractState<JvmTaintSource> abstractDefault = actualJvmTaintTransferRelation.getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, actualJvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Method under test:
   * {@link JvmTaintTransferRelation#JvmTaintTransferRelation(Map, Map)}
   */
  @Test
  public void testNewJvmTaintTransferRelation3() {
    // Arrange
    HashMap<Signature, Set<JvmTaintSource>> taintSources = new HashMap<>();

    // Act
    JvmTaintTransferRelation actualJvmTaintTransferRelation = new JvmTaintTransferRelation(taintSources,
        new HashMap<>());

    // Assert
    SetAbstractState<JvmTaintSource> abstractDefault = actualJvmTaintTransferRelation.getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    assertSame(abstractDefault, actualJvmTaintTransferRelation.getAbstractNull());
  }
}
