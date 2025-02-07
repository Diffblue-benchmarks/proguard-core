package proguard.analysis.cpa.jvm.transfer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.defaults.SetAbstractState;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintSource;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintTransferRelation;
import proguard.analysis.cpa.jvm.state.JvmAbstractState;
import proguard.analysis.datastructure.callgraph.Call;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.exception.ProguardCoreException;
import proguard.exception.ProguardCoreException.Builder;

class JvmTransferRelationDiffblueTest {
  /**
   * Test {@link JvmTransferRelation#calculateArithmeticInstruction(Instruction, List)}.
   *
   * <ul>
   *   <li>Then calls {@link SetAbstractState#isLessOrEqual(SetAbstractState)}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTransferRelation#calculateArithmeticInstruction(Instruction,
   * List)}
   */
  @Test
  @DisplayName(
      "Test calculateArithmeticInstruction(Instruction, List); then calls isLessOrEqual(SetAbstractState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.calculateArithmeticInstruction(proguard.classfile.instruction.Instruction, java.util.List)"
  })
  void testCalculateArithmeticInstruction_thenCallsIsLessOrEqual() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    SetAbstractState<JvmTaintSource> jvmTaintSourceSet = mock(SetAbstractState.class);
    when(jvmTaintSourceSet.addAll(Mockito.<Collection<JvmTaintSource>>any())).thenReturn(true);
    when(jvmTaintSourceSet.isLessOrEqual(Mockito.<SetAbstractState<JvmTaintSource>>any()))
        .thenReturn(true);
    SetAbstractState<JvmTaintSource> jvmTaintSourceSet2 = mock(SetAbstractState.class);
    when(jvmTaintSourceSet2.copy()).thenReturn(jvmTaintSourceSet);

    ArrayList<SetAbstractState<JvmTaintSource>> operands = new ArrayList<>();
    operands.add(jvmTaintSourceSet2);

    // Act
    SetAbstractState<JvmTaintSource> actualCalculateArithmeticInstructionResult =
        jvmTaintTransferRelation.calculateArithmeticInstruction(instruction, operands);

    // Assert
    verify(jvmTaintSourceSet).addAll(isA(Collection.class));
    verify(jvmTaintSourceSet2).copy();
    verify(jvmTaintSourceSet).isLessOrEqual(isA(SetAbstractState.class));
    assertTrue(actualCalculateArithmeticInstructionResult.isEmpty());
    SetAbstractState setAbstractState = actualCalculateArithmeticInstructionResult.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualCalculateArithmeticInstructionResult);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTransferRelation#calculateArithmeticInstruction(Instruction, List)}.
   *
   * <ul>
   *   <li>Then calls {@link SetAbstractState#isLessOrEqual(SetAbstractState)}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTransferRelation#calculateArithmeticInstruction(Instruction,
   * List)}
   */
  @Test
  @DisplayName(
      "Test calculateArithmeticInstruction(Instruction, List); then calls isLessOrEqual(SetAbstractState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.calculateArithmeticInstruction(proguard.classfile.instruction.Instruction, java.util.List)"
  })
  void testCalculateArithmeticInstruction_thenCallsIsLessOrEqual2() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

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
    SetAbstractState<JvmTaintSource> actualCalculateArithmeticInstructionResult =
        jvmTaintTransferRelation.calculateArithmeticInstruction(instruction, operands);

    // Assert
    verify(jvmTaintSourceSet3).addAll(isA(Collection.class));
    verify(jvmTaintSourceSet).addAll(isA(Collection.class));
    verify(jvmTaintSourceSet4).copy();
    verify(jvmTaintSourceSet2).copy();
    verify(jvmTaintSourceSet3).isLessOrEqual(isA(SetAbstractState.class));
    verify(jvmTaintSourceSet).isLessOrEqual(isA(SetAbstractState.class));
    assertTrue(actualCalculateArithmeticInstructionResult.isEmpty());
    SetAbstractState setAbstractState = actualCalculateArithmeticInstructionResult.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualCalculateArithmeticInstructionResult);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTransferRelation#calculateArithmeticInstruction(Instruction, List)}.
   *
   * <ul>
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTransferRelation#calculateArithmeticInstruction(Instruction,
   * List)}
   */
  @Test
  @DisplayName(
      "Test calculateArithmeticInstruction(Instruction, List); then throw ProguardCoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.calculateArithmeticInstruction(proguard.classfile.instruction.Instruction, java.util.List)"
  })
  void testCalculateArithmeticInstruction_thenThrowProguardCoreException() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    SetAbstractState<JvmTaintSource> jvmTaintSourceSet = mock(SetAbstractState.class);

    Builder builder = new Builder("An error occurred", 1);
    ProguardCoreException buildResult =
        builder.cause(new Throwable()).errorParameters("Error Parameters").build();
    when(jvmTaintSourceSet.addAll(Mockito.<Collection<JvmTaintSource>>any()))
        .thenThrow(buildResult);
    SetAbstractState<JvmTaintSource> jvmTaintSourceSet2 = mock(SetAbstractState.class);
    when(jvmTaintSourceSet2.copy()).thenReturn(jvmTaintSourceSet);

    ArrayList<SetAbstractState<JvmTaintSource>> operands = new ArrayList<>();
    operands.add(jvmTaintSourceSet2);

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () -> jvmTaintTransferRelation.calculateArithmeticInstruction(instruction, operands));
    verify(jvmTaintSourceSet).addAll(isA(Collection.class));
    verify(jvmTaintSourceSet2).copy();
  }

  /**
   * Test {@link JvmTransferRelation#calculateArithmeticInstruction(Instruction, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmTransferRelation#calculateArithmeticInstruction(Instruction,
   * List)}
   */
  @Test
  @DisplayName(
      "Test calculateArithmeticInstruction(Instruction, List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.calculateArithmeticInstruction(proguard.classfile.instruction.Instruction, java.util.List)"
  })
  void testCalculateArithmeticInstruction_whenArrayList_thenReturnEmpty() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    // Act
    SetAbstractState<JvmTaintSource> actualCalculateArithmeticInstructionResult =
        jvmTaintTransferRelation.calculateArithmeticInstruction(instruction, new ArrayList<>());

    // Assert
    assertTrue(actualCalculateArithmeticInstructionResult.isEmpty());
    SetAbstractState setAbstractState = actualCalculateArithmeticInstructionResult.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualCalculateArithmeticInstructionResult);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTransferRelation#computeIncrement(LatticeAbstractState, int)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#computeIncrement(LatticeAbstractState, int)}
   */
  @Test
  @DisplayName("Test computeIncrement(LatticeAbstractState, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.computeIncrement(proguard.analysis.cpa.defaults.LatticeAbstractState, int)"
  })
  void testComputeIncrement() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    SetAbstractState<JvmTaintSource> jvmTaintSourceSet = mock(SetAbstractState.class);
    when(jvmTaintSourceSet.join(Mockito.<SetAbstractState<JvmTaintSource>>any()))
        .thenReturn(mock(SetAbstractState.class));

    // Act
    SetAbstractState<JvmTaintSource> actualComputeIncrementResult =
        jvmTaintTransferRelation.computeIncrement(jvmTaintSourceSet, 42);

    // Assert
    verify(jvmTaintSourceSet).join(isA(SetAbstractState.class));
    SetAbstractState<JvmTaintSource> abstractDefault =
        jvmTaintTransferRelation.getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    SetAbstractState setAbstractState = actualComputeIncrementResult.bottom;
    assertSame(setAbstractState, abstractDefault);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTransferRelation#computeIncrement(LatticeAbstractState, int)}.
   *
   * <ul>
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTransferRelation#computeIncrement(LatticeAbstractState, int)}
   */
  @Test
  @DisplayName("Test computeIncrement(LatticeAbstractState, int); then throw ProguardCoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.computeIncrement(proguard.analysis.cpa.defaults.LatticeAbstractState, int)"
  })
  void testComputeIncrement_thenThrowProguardCoreException() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    SetAbstractState<JvmTaintSource> jvmTaintSourceSet = mock(SetAbstractState.class);

    Builder builder = new Builder("An error occurred", 1);
    ProguardCoreException buildResult =
        builder.cause(new Throwable()).errorParameters("Error Parameters").build();
    when(jvmTaintSourceSet.join(Mockito.<SetAbstractState<JvmTaintSource>>any()))
        .thenThrow(buildResult);

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () -> jvmTaintTransferRelation.computeIncrement(jvmTaintSourceSet, 42));
    verify(jvmTaintSourceSet).join(isA(SetAbstractState.class));
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractByteConstant(byte)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractByteConstant(byte)}
   */
  @Test
  @DisplayName("Test getAbstractByteConstant(byte)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.getAbstractByteConstant(byte)"
  })
  void testGetAbstractByteConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractByteConstant =
        jvmTaintTransferRelation.getAbstractByteConstant((byte) 'A');

    // Assert
    assertTrue(actualAbstractByteConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractByteConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractByteConstant);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractDoubleConstant(double)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractDoubleConstant(double)}
   */
  @Test
  @DisplayName("Test getAbstractDoubleConstant(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.getAbstractDoubleConstant(double)"
  })
  void testGetAbstractDoubleConstant() {
    // Arrange and Act
    List<SetAbstractState<JvmTaintSource>> actualAbstractDoubleConstant =
        (new JvmTaintTransferRelation(new HashMap<>())).getAbstractDoubleConstant(10.0d);

    // Assert
    assertEquals(2, actualAbstractDoubleConstant.size());
    SetAbstractState<JvmTaintSource> getResult = actualAbstractDoubleConstant.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(getResult, actualAbstractDoubleConstant.get(1));
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractFloatConstant(float)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractFloatConstant(float)}
   */
  @Test
  @DisplayName("Test getAbstractFloatConstant(float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.getAbstractFloatConstant(float)"
  })
  void testGetAbstractFloatConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractFloatConstant =
        jvmTaintTransferRelation.getAbstractFloatConstant(10.0f);

    // Assert
    assertTrue(actualAbstractFloatConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractFloatConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractFloatConstant);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractIntegerConstant(int)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractIntegerConstant(int)}
   */
  @Test
  @DisplayName("Test getAbstractIntegerConstant(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.getAbstractIntegerConstant(int)"
  })
  void testGetAbstractIntegerConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractIntegerConstant =
        jvmTaintTransferRelation.getAbstractIntegerConstant(1);

    // Assert
    assertTrue(actualAbstractIntegerConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractIntegerConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractIntegerConstant);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractLongConstant(long)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractLongConstant(long)}
   */
  @Test
  @DisplayName("Test getAbstractLongConstant(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.getAbstractLongConstant(long)"
  })
  void testGetAbstractLongConstant() {
    // Arrange and Act
    List<SetAbstractState<JvmTaintSource>> actualAbstractLongConstant =
        (new JvmTaintTransferRelation(new HashMap<>())).getAbstractLongConstant(1L);

    // Assert
    assertEquals(2, actualAbstractLongConstant.size());
    SetAbstractState<JvmTaintSource> getResult = actualAbstractLongConstant.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(getResult, actualAbstractLongConstant.get(1));
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractNull()}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractNull()}
   */
  @Test
  @DisplayName("Test getAbstractNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.getAbstractNull()"
  })
  void testGetAbstractNull() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractNull =
        jvmTaintTransferRelation.getAbstractNull();

    // Assert
    assertTrue(actualAbstractNull.isEmpty());
    SetAbstractState setAbstractState = actualAbstractNull.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, actualAbstractNull);
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractShortConstant(short)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractShortConstant(short)}
   */
  @Test
  @DisplayName("Test getAbstractShortConstant(short)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.getAbstractShortConstant(short)"
  })
  void testGetAbstractShortConstant() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractShortConstant =
        jvmTaintTransferRelation.getAbstractShortConstant((short) 1);

    // Assert
    assertTrue(actualAbstractShortConstant.isEmpty());
    SetAbstractState setAbstractState = actualAbstractShortConstant.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractShortConstant);
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractReferenceValue(String)} with {@code className}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractReferenceValue(String)}
   */
  @Test
  @DisplayName("Test getAbstractReferenceValue(String) with 'className'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.getAbstractReferenceValue(java.lang.String)"
  })
  void testGetAbstractReferenceValueWithClassName() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractReferenceValue =
        jvmTaintTransferRelation.getAbstractReferenceValue("Class Name");

    // Assert
    assertTrue(actualAbstractReferenceValue.isEmpty());
    SetAbstractState setAbstractState = actualAbstractReferenceValue.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractReferenceValue);
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractReferenceValue(String, Clazz, boolean, boolean)}
   * with {@code className}, {@code referencedClazz}, {@code mayBeExtension}, {@code mayBeNull}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractReferenceValue(String, Clazz,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAbstractReferenceValue(String, Clazz, boolean, boolean) with 'className', 'referencedClazz', 'mayBeExtension', 'mayBeNull'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.getAbstractReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean)"
  })
  void testGetAbstractReferenceValueWithClassNameReferencedClazzMayBeExtensionMayBeNull() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractReferenceValue =
        jvmTaintTransferRelation.getAbstractReferenceValue(
            "Class Name", new LibraryClass(), true, true);

    // Assert
    assertTrue(actualAbstractReferenceValue.isEmpty());
    SetAbstractState setAbstractState = actualAbstractReferenceValue.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractReferenceValue);
  }

  /**
   * Test {@link JvmTransferRelation#getAbstractReferenceValue(String, Clazz, boolean, boolean,
   * Clazz, Method, int, Object)} with {@code className}, {@code referencedClazz}, {@code
   * mayBeExtension}, {@code mayBeNull}, {@code creationClass}, {@code creationMethod}, {@code
   * creationOffset}, {@code value}.
   *
   * <p>Method under test: {@link JvmTransferRelation#getAbstractReferenceValue(String, Clazz,
   * boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  @DisplayName(
      "Test getAbstractReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object) with 'className', 'referencedClazz', 'mayBeExtension', 'mayBeNull', 'creationClass', 'creationMethod', 'creationOffset', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.getAbstractReferenceValue(java.lang.String, proguard.classfile.Clazz, boolean, boolean, proguard.classfile.Clazz, proguard.classfile.Method, int, java.lang.Object)"
  })
  void
      testGetAbstractReferenceValueWithClassNameReferencedClazzMayBeExtensionMayBeNullCreationClassCreationMethodCreationOffsetValue() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    LibraryClass referencedClazz = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    SetAbstractState<JvmTaintSource> actualAbstractReferenceValue =
        jvmTaintTransferRelation.getAbstractReferenceValue(
            "Class Name",
            referencedClazz,
            true,
            true,
            creationClass,
            new LibraryMethod(1, "Name", "Descriptor"),
            1,
            "Value");

    // Assert
    assertTrue(actualAbstractReferenceValue.isEmpty());
    SetAbstractState setAbstractState = actualAbstractReferenceValue.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualAbstractReferenceValue);
  }

  /**
   * Test {@link JvmTransferRelation#processCall(JvmAbstractState, Call)}.
   *
   * <ul>
   *   <li>Given {@link ClassConstants#CLASS_GET_CANONICAL_NAME_SIGNATURE}.
   *   <li>Then calls {@link JvmAbstractState#push(LatticeAbstractState)}.
   * </ul>
   *
   * <p>Method under test: {@link JvmTransferRelation#processCall(JvmAbstractState, Call)}
   */
  @Test
  @DisplayName(
      "Test processCall(JvmAbstractState, Call); given CLASS_GET_CANONICAL_NAME_SIGNATURE; then calls push(LatticeAbstractState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.processCall(proguard.analysis.cpa.jvm.state.JvmAbstractState, proguard.analysis.datastructure.callgraph.Call)"
  })
  void testProcessCall_givenClass_get_canonical_name_signature_thenCallsPush() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    JvmTaintAbstractState state = mock(JvmTaintAbstractState.class);
    when(state.push(Mockito.<SetAbstractState<JvmTaintSource>>any())).thenReturn(null);
    Call call = mock(Call.class);
    when(call.isStatic()).thenReturn(true);
    when(call.getTarget()).thenReturn(ClassConstants.CLASS_GET_CANONICAL_NAME_SIGNATURE);

    // Act
    jvmTaintTransferRelation.processCall(state, call);

    // Assert
    verify(state).push(isA(SetAbstractState.class));
    verify(call, atLeast(1)).getTarget();
    verify(call).isStatic();
  }

  /**
   * Test {@link JvmTransferRelation#isInstanceOf(LatticeAbstractState, String)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#isInstanceOf(LatticeAbstractState, String)}
   */
  @Test
  @DisplayName("Test isInstanceOf(LatticeAbstractState, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.isInstanceOf(proguard.analysis.cpa.defaults.LatticeAbstractState, java.lang.String)"
  })
  void testIsInstanceOf() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());

    // Act
    SetAbstractState<JvmTaintSource> actualIsInstanceOfResult =
        jvmTaintTransferRelation.isInstanceOf(mock(SetAbstractState.class), "Type");

    // Assert
    assertTrue(actualIsInstanceOfResult.isEmpty());
    SetAbstractState setAbstractState = actualIsInstanceOfResult.bottom;
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractDefault());
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(setAbstractState, actualIsInstanceOfResult);
  }

  /**
   * Test {@link JvmTransferRelation#handleCheckCast(LatticeAbstractState, String)}.
   *
   * <p>Method under test: {@link JvmTransferRelation#handleCheckCast(LatticeAbstractState, String)}
   */
  @Test
  @DisplayName("Test handleCheckCast(LatticeAbstractState, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.LatticeAbstractState proguard.analysis.cpa.jvm.transfer.JvmTransferRelation.handleCheckCast(proguard.analysis.cpa.defaults.LatticeAbstractState, java.lang.String)"
  })
  void testHandleCheckCast() {
    // Arrange
    JvmTaintTransferRelation jvmTaintTransferRelation =
        new JvmTaintTransferRelation(new HashMap<>());
    SetAbstractState<JvmTaintSource> jvmTaintSourceSet = mock(SetAbstractState.class);

    // Act
    SetAbstractState<JvmTaintSource> actualHandleCheckCastResult =
        jvmTaintTransferRelation.handleCheckCast(jvmTaintSourceSet, "Type Name");

    // Assert
    SetAbstractState<JvmTaintSource> abstractDefault =
        jvmTaintTransferRelation.getAbstractDefault();
    assertTrue(abstractDefault.isEmpty());
    SetAbstractState setAbstractState = actualHandleCheckCastResult.bottom;
    assertSame(setAbstractState, abstractDefault);
    assertSame(setAbstractState, jvmTaintTransferRelation.getAbstractNull());
    assertSame(jvmTaintSourceSet, actualHandleCheckCastResult);
  }
}
