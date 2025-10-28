package proguard.analysis.cpa.jvm.transfer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import proguard.analysis.cpa.defaults.HashMapAbstractState;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.interfaces.Precision;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation;
import proguard.analysis.cpa.jvm.domain.value.JvmValueTransferRelation;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.cpa.jvm.state.JvmFrameAbstractState;
import proguard.analysis.cpa.jvm.state.heap.JvmForgetfulHeapAbstractState;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.VariableInstruction;
import proguard.evaluation.ParticularReferenceValueFactory;

public class JvmTransferRelationDiffblueTest {
  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractSuccessorForInstruction(JvmAbstractState, Instruction, Clazz, Precision)}
   */
  @Test
  public void testGetAbstractSuccessorForInstruction() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new ParticularReferenceValueFactory(), null);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmAbstractState<ValueAbstractState> abstractState = new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame, heap,
        new HashMapAbstractState<>());

    BranchInstruction instruction = new BranchInstruction((byte) 2, 1);

    // Act and Assert
    assertSame(abstractState, jvmValueTransferRelation.getAbstractSuccessorForInstruction(abstractState, instruction,
        new LibraryClass(), null));
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractSuccessorForInstruction(JvmAbstractState, Instruction, Clazz, Precision)}
   */
  @Test
  public void testGetAbstractSuccessorForInstruction2() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new ParticularReferenceValueFactory(), null);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmAbstractState<ValueAbstractState> abstractState = new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame, heap,
        new HashMapAbstractState<>());

    LookUpSwitchInstruction instruction = new LookUpSwitchInstruction();

    // Act and Assert
    assertSame(abstractState, jvmValueTransferRelation.getAbstractSuccessorForInstruction(abstractState, instruction,
        new LibraryClass(), null));
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractSuccessorForInstruction(JvmAbstractState, Instruction, Clazz, Precision)}
   */
  @Test
  public void testGetAbstractSuccessorForInstruction3() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new ParticularReferenceValueFactory(), null);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmAbstractState<ValueAbstractState> abstractState = new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame, heap,
        new HashMapAbstractState<>());

    SimpleInstruction instruction = new SimpleInstruction();

    // Act and Assert
    assertSame(abstractState, jvmValueTransferRelation.getAbstractSuccessorForInstruction(abstractState, instruction,
        new LibraryClass(), null));
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractSuccessorForInstruction(JvmAbstractState, Instruction, Clazz, Precision)}
   */
  @Test
  public void testGetAbstractSuccessorForInstruction4() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new ParticularReferenceValueFactory(), null);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmAbstractState<ValueAbstractState> abstractState = new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame, heap,
        new HashMapAbstractState<>());

    VariableInstruction instruction = new VariableInstruction();

    // Act and Assert
    assertSame(abstractState, jvmValueTransferRelation.getAbstractSuccessorForInstruction(abstractState, instruction,
        new LibraryClass(), null));
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractSuccessorForInstruction(JvmAbstractState, Instruction, Clazz, Precision)}
   */
  @Test
  public void testGetAbstractSuccessorForInstruction5() {
    // Arrange
    JvmValueTransferRelation jvmValueTransferRelation = new JvmValueTransferRelation(
        new ParticularReferenceValueFactory(), null);
    JvmFrameAbstractState<ValueAbstractState> frame = new JvmFrameAbstractState<>();
    JvmForgetfulHeapAbstractState<ValueAbstractState> heap = new JvmForgetfulHeapAbstractState<>(
        ValueAbstractState.UNKNOWN);
    JvmAbstractState<ValueAbstractState> abstractState = new JvmAbstractState<>(JvmUnknownCfaNode.INSTANCE, frame, heap,
        new HashMapAbstractState<>());

    ConstantInstruction instruction = new ConstantInstruction((byte) -78, 1);

    // Act and Assert
    assertSame(abstractState, jvmValueTransferRelation.getAbstractSuccessorForInstruction(abstractState, instruction,
        new LibraryClass(), null));
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#calculateArithmeticInstruction(Instruction, List)}
   */
  @Test
  public void testCalculateArithmeticInstruction() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());
    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    // Act
    SetAbstractState<JvmTaintSource> actualCalculateArithmeticInstructionResult = jvmTaintTransferRelation
        .calculateArithmeticInstruction(instruction, new ArrayList<>());

    // Assert
    assertTrue(actualCalculateArithmeticInstructionResult.isEmpty());
    SetAbstractState setAbstractState = actualCalculateArithmeticInstructionResult.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualCalculateArithmeticInstructionResult);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Method under test: {@link JvmTransferRelation#getAbstractByteConstant(byte)}
   */
  @Test
  public void testGetAbstractByteConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractByteConstant = jvmTaintTransferRelation
        .getAbstractByteConstant((byte) 'A');

    // Assert
    assertTrue(actualAbstractByteConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractByteConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractByteConstant);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractDoubleConstant(double)}
   */
  @Test
  public void testGetAbstractDoubleConstant() {
    // Arrange and Act
    List<SetAbstractState<JvmTaintSource>> actualAbstractDoubleConstant = (new JvmTaintTransferRelation(
        new HashMap<>())).getAbstractDoubleConstant(10.0d);

    // Assert
    assertEquals(2, actualAbstractDoubleConstant.size());
    SetAbstractState<JvmTaintSource> getResult = actualAbstractDoubleConstant.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(getResult, actualAbstractDoubleConstant.get(1));
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractFloatConstant(float)}
   */
  @Test
  public void testGetAbstractFloatConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractFloatConstant = jvmTaintTransferRelation
        .getAbstractFloatConstant(10.0f);

    // Assert
    assertTrue(actualAbstractFloatConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractFloatConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractFloatConstant);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractIntegerConstant(int)}
   */
  @Test
  public void testGetAbstractIntegerConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractIntegerConstant = jvmTaintTransferRelation
        .getAbstractIntegerConstant(1);

    // Assert
    assertTrue(actualAbstractIntegerConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractIntegerConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractIntegerConstant);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Method under test: {@link JvmTransferRelation#getAbstractLongConstant(long)}
   */
  @Test
  public void testGetAbstractLongConstant() {
    // Arrange and Act
    List<SetAbstractState<JvmTaintSource>> actualAbstractLongConstant = (new JvmTaintTransferRelation(new HashMap<>()))
        .getAbstractLongConstant(1L);

    // Assert
    assertEquals(2, actualAbstractLongConstant.size());
    SetAbstractState<JvmTaintSource> getResult = actualAbstractLongConstant.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(getResult, actualAbstractLongConstant.get(1));
  }

  /**
   * Method under test: {@link JvmTransferRelation#getAbstractNull()}
   */
  @Test
  public void testGetAbstractNull() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractNull = jvmTaintTransferRelation.getAbstractNull();

    // Assert
    assertTrue(actualAbstractNull.isEmpty());
    SetAbstractState setAbstractState = actualAbstractNull.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractNull);
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractShortConstant(short)}
   */
  @Test
  public void testGetAbstractShortConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractShortConstant = jvmTaintTransferRelation
        .getAbstractShortConstant((short) 1);

    // Assert
    assertTrue(actualAbstractShortConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractShortConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractShortConstant);
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  public void testGetAbstractReferenceValue() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractReferenceValue = jvmTaintTransferRelation
        .getAbstractReferenceValue("Class Name");

    // Assert
    assertTrue(actualAbstractReferenceValue.isEmpty());
    SetAbstractState setAbstractState = actualAbstractReferenceValue.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractReferenceValue);
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testGetAbstractReferenceValue2() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());
    LibraryClass referencedClazz = new LibraryClass();

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractReferenceValue = jvmTaintTransferRelation
        .getAbstractReferenceValue("Class Name", referencedClazz, true, true);

    // Assert
    assertTrue(actualAbstractReferenceValue.isEmpty());
    assertTrue(referencedClazz.getExtraFeatureNames().isEmpty());
    SetAbstractState setAbstractState = actualAbstractReferenceValue.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractReferenceValue);
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#getAbstractReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testGetAbstractReferenceValue3() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());
    LibraryClass referencedClazz = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractReferenceValue = jvmTaintTransferRelation.getAbstractReferenceValue(
        "Class Name", referencedClazz, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1,
        "Value");

    // Assert
    assertTrue(actualAbstractReferenceValue.isEmpty());
    assertTrue(referencedClazz.getExtraFeatureNames().isEmpty());
    SetAbstractState setAbstractState = actualAbstractReferenceValue.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractReferenceValue);
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#isInstanceOf(LatticeAbstractState, String)}
   */
  @Test
  public void testIsInstanceOf() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation = new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualIsInstanceOfResult = jvmTaintTransferRelation.isInstanceOf(null, "Type");

    // Assert
    assertTrue(actualIsInstanceOfResult.isEmpty());
    SetAbstractState setAbstractState = actualIsInstanceOfResult.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualIsInstanceOfResult);
  }

  /**
   * Method under test:
   * {@link JvmTransferRelation#handleCheckCast(LatticeAbstractState, String)}
   */
  @Test
  public void testHandleCheckCast() {
    // Arrange, Act and Assert
    assertNull((new JvmTaintTransferRelation(new HashMap<>())).handleCheckCast(null, "Type Name"));
  }
}
