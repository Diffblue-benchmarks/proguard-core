package proguard.evaluation.util;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.constant.visitor.ConstantVisitor;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.visitor.MemberVisitor;
import proguard.evaluation.BasicBranchUnit;
import proguard.evaluation.PartialEvaluator;
import proguard.evaluation.TracedStack;
import proguard.evaluation.TracedVariables;
import proguard.evaluation.Variables;
import proguard.evaluation.value.InstructionOffsetValue;

class DebugPrinterDiffblueTest {
  /**
   * Test {@link DebugPrinter#startCodeAttribute(Clazz, Method, CodeAttribute, Variables)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link LibraryClass#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#startCodeAttribute(Clazz, Method, CodeAttribute,
   * Variables)}
   */
  @Test
  @DisplayName(
      "Test startCodeAttribute(Clazz, Method, CodeAttribute, Variables); given 'Name'; then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.startCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.Variables)"
  })
  void testStartCodeAttribute_givenName_thenCallsGetName() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName()).thenReturn("Name");
    when(clazz.getString(anyInt())).thenReturn("String");
    ProgramMethod method = new ProgramMethod();
    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    debugPrinter.startCodeAttribute(clazz, method, codeAttribute, new Variables(3));

    // Assert
    verify(clazz).getName();
    verify(clazz, atLeast(1)).getString(eq(0));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName("Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = new PartialEvaluator();

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName("Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException2() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName("Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException3() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {':', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName("Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException4() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt()))
        .thenReturn(new InstructionOffsetValue(new int[] {42, 1, 42, 1}));
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#isTraced(int)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName(
      "Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable); given 'false'; when PartialEvaluator isTraced(int) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException_givenFalse_whenPartialEvaluatorIsTracedReturnFalse() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.isTraced(anyInt())).thenReturn(false);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName(
      "Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable); given InstructionOffsetValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException_givenInstructionOffsetValue() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(mock(InstructionOffsetValue.class));
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName(
      "Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable); given InstructionOffsetValue(int) with value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException_givenInstructionOffsetValueWithValueIsFortyTwo() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(new InstructionOffsetValue(42));
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#branchOrigins(int)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName(
      "Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable); given 'null'; when PartialEvaluator branchOrigins(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException_givenNull_whenPartialEvaluatorBranchOriginsReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(null);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#branchTargets(int)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName(
      "Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable); given 'null'; when PartialEvaluator branchTargets(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException_givenNull_whenPartialEvaluatorBranchTargetsReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(null);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#getStackAfter(int)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName(
      "Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable); given 'null'; when PartialEvaluator getStackAfter(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException_givenNull_whenPartialEvaluatorGetStackAfterReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(null);
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#getStackBefore(int)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName(
      "Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable); given 'null'; when PartialEvaluator getStackBefore(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException_givenNull_whenPartialEvaluatorGetStackBeforeReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(null);
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#getVariablesAfter(int)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName(
      "Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable); given 'null'; when PartialEvaluator getVariablesAfter(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException_givenNull_whenPartialEvaluatorGetVariablesAfterReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(null);
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#getVariablesBefore(int)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName(
      "Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable); given 'null'; when PartialEvaluator getVariablesBefore(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException_givenNull_whenPartialEvaluatorGetVariablesBeforeReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(null);
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute, PartialEvaluator,
   * Throwable)}.
   *
   * <ul>
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#branchTargets(int)} return {@link
   *       InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#registerException(Clazz, Method, CodeAttribute,
   * PartialEvaluator, Throwable)}
   */
  @Test
  @DisplayName(
      "Test registerException(Clazz, Method, CodeAttribute, PartialEvaluator, Throwable); when PartialEvaluator branchTargets(int) return EMPTY_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.registerException(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator, java.lang.Throwable)"
  })
  void testRegisterException_whenPartialEvaluatorBranchTargetsReturnEmpty_value() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = mock(LibraryMethod.class);
    doNothing().when(method).accept(Mockito.<Clazz>any(), Mockito.<MemberVisitor>any());
    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.registerException(clazz, method, codeAttribute, evaluator, new Throwable());

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(method).accept(isA(Clazz.class), isA(MemberVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName("Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName("Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults2() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName("Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults3() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {':', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName("Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults4() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt()))
        .thenReturn(new InstructionOffsetValue(new int[] {42, 1, 42, 1}));
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#isTraced(int)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName(
      "Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator); given 'false'; when PartialEvaluator isTraced(int) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults_givenFalse_whenPartialEvaluatorIsTracedReturnFalse() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.isTraced(anyInt())).thenReturn(false);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName(
      "Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator); given InstructionOffsetValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults_givenInstructionOffsetValue() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(mock(InstructionOffsetValue.class));
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName(
      "Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator); given InstructionOffsetValue(int) with value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults_givenInstructionOffsetValueWithValueIsFortyTwo() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(new InstructionOffsetValue(42));
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#branchOrigins(int)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName(
      "Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator); given 'null'; when PartialEvaluator branchOrigins(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults_givenNull_whenPartialEvaluatorBranchOriginsReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(null);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#branchTargets(int)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName(
      "Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator); given 'null'; when PartialEvaluator branchTargets(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults_givenNull_whenPartialEvaluatorBranchTargetsReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(null);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#getStackAfter(int)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName(
      "Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator); given 'null'; when PartialEvaluator getStackAfter(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults_givenNull_whenPartialEvaluatorGetStackAfterReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(null);
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#getStackBefore(int)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName(
      "Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator); given 'null'; when PartialEvaluator getStackBefore(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults_givenNull_whenPartialEvaluatorGetStackBeforeReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(null);
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#getVariablesAfter(int)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName(
      "Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator); given 'null'; when PartialEvaluator getVariablesAfter(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults_givenNull_whenPartialEvaluatorGetVariablesAfterReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(null);
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PartialEvaluator} {@link PartialEvaluator#getVariablesBefore(int)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName(
      "Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator); given 'null'; when PartialEvaluator getVariablesBefore(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults_givenNull_whenPartialEvaluatorGetVariablesBeforeReturnNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(null);
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(evaluator, atLeast(1)).branchOrigins(anyInt());
    verify(evaluator, atLeast(1)).branchTargets(anyInt());
    verify(evaluator, atLeast(1)).getStackAfter(anyInt());
    verify(evaluator, atLeast(1)).getStackBefore(anyInt());
    verify(evaluator, atLeast(1)).getVariablesAfter(anyInt());
    verify(evaluator, atLeast(1)).getVariablesBefore(anyInt());
    verify(evaluator, atLeast(1)).isBranchOrExceptionTarget(anyInt());
    verify(evaluator, atLeast(1)).isTraced(anyInt());
  }

  /**
   * Test {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator)}.
   *
   * <ul>
   *   <li>Then calls {@link Clazz#constantPoolEntryAccept(int, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#evaluationResults(Clazz, Method, CodeAttribute,
   * PartialEvaluator)}
   */
  @Test
  @DisplayName(
      "Test evaluationResults(Clazz, Method, CodeAttribute, PartialEvaluator); then calls constantPoolEntryAccept(int, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.evaluationResults(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.evaluation.PartialEvaluator)"
  })
  void testEvaluationResults_thenCallsConstantPoolEntryAccept() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    Clazz clazz = mock(Clazz.class);
    doNothing().when(clazz).constantPoolEntryAccept(anyInt(), Mockito.<ConstantVisitor>any());
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute =
        new CodeAttribute(1, 3, 3, 3, new byte[] {20, 1, 'A', 1, 'A', 1, 'A', 1});

    PartialEvaluator evaluator = mock(PartialEvaluator.class);
    when(evaluator.getStackAfter(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesAfter(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.branchTargets(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.getStackBefore(anyInt())).thenReturn(new TracedStack(3));
    when(evaluator.getVariablesBefore(anyInt())).thenReturn(new TracedVariables(3));
    when(evaluator.isTraced(anyInt())).thenReturn(true);
    when(evaluator.branchOrigins(anyInt())).thenReturn(InstructionOffsetValue.EMPTY_VALUE);
    when(evaluator.isBranchOrExceptionTarget(anyInt())).thenReturn(true);

    // Act
    debugPrinter.evaluationResults(clazz, method, codeAttribute, evaluator);

    // Assert
    verify(clazz).constantPoolEntryAccept(eq(321), isA(ConstantVisitor.class));
    verify(evaluator).branchOrigins(eq(0));
    verify(evaluator).branchTargets(eq(0));
    verify(evaluator).getStackAfter(eq(0));
    verify(evaluator).getStackBefore(eq(0));
    verify(evaluator).getVariablesAfter(eq(0));
    verify(evaluator).getVariablesBefore(eq(0));
    verify(evaluator).isBranchOrExceptionTarget(eq(0));
    verify(evaluator, atLeast(1)).isTraced(eq(0));
  }

  /**
   * Test {@link DebugPrinter#startInstructionEvaluation(Clazz, Method, int, Instruction,
   * TracedVariables, TracedStack, int)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link Instruction#toString(Clazz, int)}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#startInstructionEvaluation(Clazz, Method, int,
   * Instruction, TracedVariables, TracedStack, int)}
   */
  @Test
  @DisplayName(
      "Test startInstructionEvaluation(Clazz, Method, int, Instruction, TracedVariables, TracedStack, int); given 'String'; then calls toString(Clazz, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.startInstructionEvaluation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.instruction.Instruction, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack, int)"
  })
  void testStartInstructionEvaluation_givenString_thenCallsToString() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = mock(BranchInstruction.class);
    when(instruction.toString(Mockito.<Clazz>any(), anyInt())).thenReturn("String");
    TracedVariables variablesBefore = new TracedVariables(3);

    // Act
    debugPrinter.startInstructionEvaluation(
        clazz, method, 1, instruction, variablesBefore, new TracedStack(3), 3);

    // Assert
    verify(instruction).toString(isA(Clazz.class), eq(1));
  }

  /**
   * Test {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int, Instruction,
   * TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}.
   *
   * <p>Method under test: {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int,
   * Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}
   */
  @Test
  @DisplayName(
      "Test afterInstructionEvaluation(Clazz, Method, int, Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.afterInstructionEvaluation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.instruction.Instruction, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack, proguard.evaluation.BasicBranchUnit, proguard.evaluation.value.InstructionOffsetValue)"
  })
  void testAfterInstructionEvaluation() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    TracedVariables variablesAfter = new TracedVariables(3);
    TracedStack stackAfter = new TracedStack(3);
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    when(branchUnit.wasCalled()).thenReturn(true);
    when(branchUnit.getTraceBranchTargets())
        .thenReturn(new InstructionOffsetValue(new int[] {42, 1, 42, 1}));

    // Act
    debugPrinter.afterInstructionEvaluation(
        clazz,
        method,
        1,
        instruction,
        variablesAfter,
        stackAfter,
        branchUnit,
        InstructionOffsetValue.EMPTY_VALUE);

    // Assert
    verify(branchUnit).getTraceBranchTargets();
    verify(branchUnit).wasCalled();
  }

  /**
   * Test {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int, Instruction,
   * TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int,
   * Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}
   */
  @Test
  @DisplayName(
      "Test afterInstructionEvaluation(Clazz, Method, int, Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue); given EMPTY_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.afterInstructionEvaluation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.instruction.Instruction, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack, proguard.evaluation.BasicBranchUnit, proguard.evaluation.value.InstructionOffsetValue)"
  })
  void testAfterInstructionEvaluation_givenEmpty_value() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    TracedVariables variablesAfter = new TracedVariables(3);
    TracedStack stackAfter = new TracedStack(3);
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    when(branchUnit.wasCalled()).thenReturn(true);
    when(branchUnit.getTraceBranchTargets()).thenReturn(InstructionOffsetValue.EMPTY_VALUE);

    // Act
    debugPrinter.afterInstructionEvaluation(
        clazz,
        method,
        1,
        instruction,
        variablesAfter,
        stackAfter,
        branchUnit,
        InstructionOffsetValue.EMPTY_VALUE);

    // Assert
    verify(branchUnit).getTraceBranchTargets();
    verify(branchUnit).wasCalled();
  }

  /**
   * Test {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int, Instruction,
   * TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int,
   * Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}
   */
  @Test
  @DisplayName(
      "Test afterInstructionEvaluation(Clazz, Method, int, Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue); given EMPTY_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.afterInstructionEvaluation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.instruction.Instruction, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack, proguard.evaluation.BasicBranchUnit, proguard.evaluation.value.InstructionOffsetValue)"
  })
  void testAfterInstructionEvaluation_givenEmpty_value2() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    TracedVariables variablesAfter = new TracedVariables(3);
    TracedStack stackAfter = new TracedStack(3);
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    when(branchUnit.wasCalled()).thenReturn(true);
    when(branchUnit.getTraceBranchTargets()).thenReturn(InstructionOffsetValue.EMPTY_VALUE);

    // Act
    debugPrinter.afterInstructionEvaluation(
        clazz, method, 1, instruction, variablesAfter, stackAfter, branchUnit, null);

    // Assert
    verify(branchUnit).getTraceBranchTargets();
    verify(branchUnit).wasCalled();
  }

  /**
   * Test {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int, Instruction,
   * TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>When {@link InstructionOffsetValue}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int,
   * Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}
   */
  @Test
  @DisplayName(
      "Test afterInstructionEvaluation(Clazz, Method, int, Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue); given EMPTY_VALUE; when InstructionOffsetValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.afterInstructionEvaluation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.instruction.Instruction, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack, proguard.evaluation.BasicBranchUnit, proguard.evaluation.value.InstructionOffsetValue)"
  })
  void testAfterInstructionEvaluation_givenEmpty_value_whenInstructionOffsetValue() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    TracedVariables variablesAfter = new TracedVariables(3);
    TracedStack stackAfter = new TracedStack(3);
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    when(branchUnit.wasCalled()).thenReturn(true);
    when(branchUnit.getTraceBranchTargets()).thenReturn(InstructionOffsetValue.EMPTY_VALUE);

    // Act
    debugPrinter.afterInstructionEvaluation(
        clazz,
        method,
        1,
        instruction,
        variablesAfter,
        stackAfter,
        branchUnit,
        mock(InstructionOffsetValue.class));

    // Assert
    verify(branchUnit).getTraceBranchTargets();
    verify(branchUnit).wasCalled();
  }

  /**
   * Test {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int, Instruction,
   * TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int,
   * Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}
   */
  @Test
  @DisplayName(
      "Test afterInstructionEvaluation(Clazz, Method, int, Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue); given InstructionOffsetValue(int) with value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.afterInstructionEvaluation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.instruction.Instruction, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack, proguard.evaluation.BasicBranchUnit, proguard.evaluation.value.InstructionOffsetValue)"
  })
  void testAfterInstructionEvaluation_givenInstructionOffsetValueWithValueIsFortyTwo() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    TracedVariables variablesAfter = new TracedVariables(3);
    TracedStack stackAfter = new TracedStack(3);
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    when(branchUnit.wasCalled()).thenReturn(true);
    when(branchUnit.getTraceBranchTargets()).thenReturn(new InstructionOffsetValue(42));

    // Act
    debugPrinter.afterInstructionEvaluation(
        clazz,
        method,
        1,
        instruction,
        variablesAfter,
        stackAfter,
        branchUnit,
        InstructionOffsetValue.EMPTY_VALUE);

    // Assert
    verify(branchUnit).getTraceBranchTargets();
    verify(branchUnit).wasCalled();
  }

  /**
   * Test {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int, Instruction,
   * TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#afterInstructionEvaluation(Clazz, Method, int,
   * Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue)}
   */
  @Test
  @DisplayName(
      "Test afterInstructionEvaluation(Clazz, Method, int, Instruction, TracedVariables, TracedStack, BasicBranchUnit, InstructionOffsetValue); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.afterInstructionEvaluation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.instruction.Instruction, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack, proguard.evaluation.BasicBranchUnit, proguard.evaluation.value.InstructionOffsetValue)"
  })
  void testAfterInstructionEvaluation_givenNull() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    TracedVariables variablesAfter = new TracedVariables(3);
    TracedStack stackAfter = new TracedStack(3);
    BasicBranchUnit branchUnit = mock(BasicBranchUnit.class);
    when(branchUnit.wasCalled()).thenReturn(true);
    when(branchUnit.getTraceBranchTargets()).thenReturn(null);

    // Act
    debugPrinter.afterInstructionEvaluation(
        clazz,
        method,
        1,
        instruction,
        variablesAfter,
        stackAfter,
        branchUnit,
        InstructionOffsetValue.EMPTY_VALUE);

    // Assert
    verify(branchUnit).getTraceBranchTargets();
    verify(branchUnit).wasCalled();
  }

  /**
   * Test {@link DebugPrinter#definitiveBranch(Clazz, Method, int, Instruction, TracedVariables,
   * TracedStack, InstructionOffsetValue)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link InstructionOffsetValue#instructionOffset(int)}.
   * </ul>
   *
   * <p>Method under test: {@link DebugPrinter#definitiveBranch(Clazz, Method, int, Instruction,
   * TracedVariables, TracedStack, InstructionOffsetValue)}
   */
  @Test
  @DisplayName(
      "Test definitiveBranch(Clazz, Method, int, Instruction, TracedVariables, TracedStack, InstructionOffsetValue); given one; then calls instructionOffset(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.DebugPrinter.definitiveBranch(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.instruction.Instruction, proguard.evaluation.TracedVariables, proguard.evaluation.TracedStack, proguard.evaluation.value.InstructionOffsetValue)"
  })
  void testDefinitiveBranch_givenOne_thenCallsInstructionOffset() {
    // Arrange
    DebugPrinter debugPrinter = new DebugPrinter(true, true);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    TracedVariables variablesAfter = new TracedVariables(3);
    TracedStack stackAfter = new TracedStack(3);
    InstructionOffsetValue branchTargets = mock(InstructionOffsetValue.class);
    when(branchTargets.instructionOffset(anyInt())).thenReturn(1);

    // Act
    debugPrinter.definitiveBranch(
        clazz, method, 1, instruction, variablesAfter, stackAfter, branchTargets);

    // Assert
    verify(branchTargets).instructionOffset(eq(0));
  }
}
