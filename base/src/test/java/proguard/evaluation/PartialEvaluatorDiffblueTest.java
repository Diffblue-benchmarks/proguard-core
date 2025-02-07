package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.classfile.util.BranchTargetFinder;
import proguard.evaluation.PartialEvaluator.Builder;
import proguard.evaluation.exception.EmptyCodeAttributeException;
import proguard.evaluation.util.DebugPrinter;
import proguard.evaluation.util.jsonprinter.JsonPrinter;
import proguard.evaluation.value.ValueFactory;
import proguard.exception.ProguardCoreException;

class PartialEvaluatorDiffblueTest {
  /**
   * Test Builder {@link Builder#disablePrettyPrinting()}.
   *
   * <p>Method under test: {@link Builder#disablePrettyPrinting()}
   */
  @Test
  @DisplayName("Test Builder disablePrettyPrinting()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.PartialEvaluator$Builder proguard.evaluation.PartialEvaluator$Builder.disablePrettyPrinting()"
  })
  void testBuilderDisablePrettyPrinting() {
    // Arrange
    Builder createResult = Builder.create();

    // Act and Assert
    assertSame(createResult, createResult.disablePrettyPrinting());
  }

  /**
   * Test {@link PartialEvaluator#PartialEvaluator()}.
   *
   * <p>Method under test: {@link PartialEvaluator#PartialEvaluator()}
   */
  @Test
  @DisplayName("Test new PartialEvaluator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.PartialEvaluator.<init>()"})
  void testNewPartialEvaluator() {
    // Arrange and Act
    PartialEvaluator actualPartialEvaluator = new PartialEvaluator();

    // Assert
    assertNull(actualPartialEvaluator.getStackAfter(1));
    assertNull(actualPartialEvaluator.getStackBefore(1));
    assertNull(actualPartialEvaluator.branchOrigins(1));
    assertNull(actualPartialEvaluator.branchTargets(1));
  }

  /**
   * Test {@link PartialEvaluator#PartialEvaluator(ValueFactory)}.
   *
   * <p>Method under test: {@link PartialEvaluator#PartialEvaluator(ValueFactory)}
   */
  @Test
  @DisplayName("Test new PartialEvaluator(ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.PartialEvaluator.<init>(proguard.evaluation.value.ValueFactory)"
  })
  void testNewPartialEvaluator2() {
    // Arrange and Act
    PartialEvaluator actualPartialEvaluator =
        new PartialEvaluator(new ParticularReferenceValueFactory());

    // Assert
    assertNull(actualPartialEvaluator.getStackAfter(1));
    assertNull(actualPartialEvaluator.getStackBefore(1));
    assertNull(actualPartialEvaluator.branchOrigins(1));
    assertNull(actualPartialEvaluator.branchTargets(1));
  }

  /**
   * Test {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit,
   * boolean)}
   */
  @Test
  @DisplayName("Test new PartialEvaluator(ValueFactory, InvocationUnit, boolean); when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.PartialEvaluator.<init>(proguard.evaluation.value.ValueFactory, proguard.evaluation.InvocationUnit, boolean)"
  })
  void testNewPartialEvaluator_whenFalse() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    PartialEvaluator actualPartialEvaluator =
        new PartialEvaluator(
            valueFactory, new BasicInvocationUnit(new ParticularReferenceValueFactory()), false);

    // Assert
    assertNull(actualPartialEvaluator.getStackAfter(1));
    assertNull(actualPartialEvaluator.getStackBefore(1));
    assertNull(actualPartialEvaluator.branchOrigins(1));
    assertNull(actualPartialEvaluator.branchTargets(1));
  }

  /**
   * Test {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit, boolean,
   * InstructionVisitor)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit,
   * boolean, InstructionVisitor)}
   */
  @Test
  @DisplayName(
      "Test new PartialEvaluator(ValueFactory, InvocationUnit, boolean, InstructionVisitor); when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.PartialEvaluator.<init>(proguard.evaluation.value.ValueFactory, proguard.evaluation.InvocationUnit, boolean, proguard.classfile.instruction.visitor.InstructionVisitor)"
  })
  void testNewPartialEvaluator_whenFalse2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicInvocationUnit invocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());

    // Act
    PartialEvaluator actualPartialEvaluator =
        new PartialEvaluator(valueFactory, invocationUnit, false, new MaxStackSizeComputer());

    // Assert
    assertNull(actualPartialEvaluator.getStackAfter(1));
    assertNull(actualPartialEvaluator.getStackBefore(1));
    assertNull(actualPartialEvaluator.branchOrigins(1));
    assertNull(actualPartialEvaluator.branchTargets(1));
  }

  /**
   * Test {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit,
   * boolean)}
   */
  @Test
  @DisplayName("Test new PartialEvaluator(ValueFactory, InvocationUnit, boolean); when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.PartialEvaluator.<init>(proguard.evaluation.value.ValueFactory, proguard.evaluation.InvocationUnit, boolean)"
  })
  void testNewPartialEvaluator_whenTrue() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    PartialEvaluator actualPartialEvaluator =
        new PartialEvaluator(
            valueFactory, new BasicInvocationUnit(new ParticularReferenceValueFactory()), true);

    // Assert
    assertNull(actualPartialEvaluator.getStackAfter(1));
    assertNull(actualPartialEvaluator.getStackBefore(1));
    assertNull(actualPartialEvaluator.branchOrigins(1));
    assertNull(actualPartialEvaluator.branchTargets(1));
  }

  /**
   * Test {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit, boolean,
   * InstructionVisitor)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit,
   * boolean, InstructionVisitor)}
   */
  @Test
  @DisplayName(
      "Test new PartialEvaluator(ValueFactory, InvocationUnit, boolean, InstructionVisitor); when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.PartialEvaluator.<init>(proguard.evaluation.value.ValueFactory, proguard.evaluation.InvocationUnit, boolean, proguard.classfile.instruction.visitor.InstructionVisitor)"
  })
  void testNewPartialEvaluator_whenTrue2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicInvocationUnit invocationUnit =
        new BasicInvocationUnit(new ParticularReferenceValueFactory());

    // Act
    PartialEvaluator actualPartialEvaluator =
        new PartialEvaluator(valueFactory, invocationUnit, true, new MaxStackSizeComputer());

    // Assert
    assertNull(actualPartialEvaluator.getStackAfter(1));
    assertNull(actualPartialEvaluator.getStackBefore(1));
    assertNull(actualPartialEvaluator.branchOrigins(1));
    assertNull(actualPartialEvaluator.branchTargets(1));
  }

  /**
   * Test {@link PartialEvaluator#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyCodeAttributeException}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then throw EmptyCodeAttributeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.PartialEvaluator.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenThrowEmptyCodeAttributeException() {
    // Arrange
    PartialEvaluator partialEvaluator = new PartialEvaluator();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        EmptyCodeAttributeException.class,
        () -> partialEvaluator.visitCodeAttribute(clazz, method, new CodeAttribute(1)));
  }

  /**
   * Test {@link PartialEvaluator#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then throw ProguardCoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.PartialEvaluator.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenThrowProguardCoreException() {
    // Arrange
    PartialEvaluator partialEvaluator = new PartialEvaluator();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method =
        new LibraryMethod(
            8,
            "Name",
            "Unexpected error while performing partial evaluation:%n  Class       = [%s]%n  Method      = [%s%s]%n"
                + "  Exception   = [%s] (%s)");

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            partialEvaluator.visitCodeAttribute(
                clazz,
                method,
                new CodeAttribute(
                    1, 3, 3, 3, new byte[] {'A', -19, 'A', -19, 'A', -19, 'A', -19})));
  }

  /**
   * Test {@link PartialEvaluator#visitCodeAttribute0(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyCodeAttributeException}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#visitCodeAttribute0(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute0(Clazz, Method, CodeAttribute); then throw EmptyCodeAttributeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.PartialEvaluator.visitCodeAttribute0(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute0_thenThrowEmptyCodeAttributeException() {
    // Arrange
    PartialEvaluator partialEvaluator = new PartialEvaluator();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        EmptyCodeAttributeException.class,
        () -> partialEvaluator.visitCodeAttribute0(clazz, method, new CodeAttribute(1)));
  }

  /**
   * Test {@link PartialEvaluator#isTraced(int)} with {@code instructionOffset}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isTraced(int)}
   */
  @Test
  @DisplayName("Test isTraced(int) with 'instructionOffset'; when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isTraced(int)"})
  void testIsTracedWithInstructionOffset_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isTraced(1));
  }

  /**
   * Test {@link PartialEvaluator#isTraced(int, int)} with {@code startOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isTraced(int, int)}
   */
  @Test
  @DisplayName(
      "Test isTraced(int, int) with 'startOffset', 'endOffset'; when three; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isTraced(int, int)"})
  void testIsTracedWithStartOffsetEndOffset_whenThree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isTraced(1, 3));
  }

  /**
   * Test {@link PartialEvaluator#isInstruction(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isInstruction(int)}
   */
  @Test
  @DisplayName("Test isInstruction(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isInstruction(int)"})
  void testIsInstruction_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isInstruction(1));
  }

  /**
   * Test {@link PartialEvaluator#isTarget(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isTarget(int)}
   */
  @Test
  @DisplayName("Test isTarget(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isTarget(int)"})
  void testIsTarget_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isTarget(1));
  }

  /**
   * Test {@link PartialEvaluator#isTarget(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isTarget(int)}
   */
  @Test
  @DisplayName("Test isTarget(int); when zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isTarget(int)"})
  void testIsTarget_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PartialEvaluator()).isTarget(0));
  }

  /**
   * Test {@link PartialEvaluator#isBranchOrigin(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isBranchOrigin(int)}
   */
  @Test
  @DisplayName("Test isBranchOrigin(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isBranchOrigin(int)"})
  void testIsBranchOrigin_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isBranchOrigin(1));
  }

  /**
   * Test {@link PartialEvaluator#isBranchTarget(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isBranchTarget(int)}
   */
  @Test
  @DisplayName("Test isBranchTarget(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isBranchTarget(int)"})
  void testIsBranchTarget_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isBranchTarget(1));
  }

  /**
   * Test {@link PartialEvaluator#isBranchOrExceptionTarget(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isBranchOrExceptionTarget(int)}
   */
  @Test
  @DisplayName("Test isBranchOrExceptionTarget(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isBranchOrExceptionTarget(int)"})
  void testIsBranchOrExceptionTarget_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isBranchOrExceptionTarget(1));
  }

  /**
   * Test {@link PartialEvaluator#isExceptionHandler(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isExceptionHandler(int)}
   */
  @Test
  @DisplayName("Test isExceptionHandler(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isExceptionHandler(int)"})
  void testIsExceptionHandler_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isExceptionHandler(1));
  }

  /**
   * Test {@link PartialEvaluator#isSubroutineStart(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isSubroutineStart(int)}
   */
  @Test
  @DisplayName("Test isSubroutineStart(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isSubroutineStart(int)"})
  void testIsSubroutineStart_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isSubroutineStart(1));
  }

  /**
   * Test {@link PartialEvaluator#isSubroutineStart(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isSubroutineStart(int)}
   */
  @Test
  @DisplayName("Test isSubroutineStart(int); when zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isSubroutineStart(int)"})
  void testIsSubroutineStart_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PartialEvaluator()).isSubroutineStart(0));
  }

  /**
   * Test {@link PartialEvaluator#isSubroutineInvocation(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isSubroutineInvocation(int)}
   */
  @Test
  @DisplayName("Test isSubroutineInvocation(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isSubroutineInvocation(int)"})
  void testIsSubroutineInvocation_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isSubroutineInvocation(1));
  }

  /**
   * Test {@link PartialEvaluator#isSubroutine(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isSubroutine(int)}
   */
  @Test
  @DisplayName("Test isSubroutine(int); when one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isSubroutine(int)"})
  void testIsSubroutine_whenOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PartialEvaluator()).isSubroutine(1));
  }

  /**
   * Test {@link PartialEvaluator#isSubroutineReturning(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isSubroutineReturning(int)}
   */
  @Test
  @DisplayName("Test isSubroutineReturning(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isSubroutineReturning(int)"})
  void testIsSubroutineReturning_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isSubroutineReturning(1));
  }

  /**
   * Test {@link PartialEvaluator#subroutineEnd(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#subroutineEnd(int)}
   */
  @Test
  @DisplayName("Test subroutineEnd(int); when one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.PartialEvaluator.subroutineEnd(int)"})
  void testSubroutineEnd_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PartialEvaluator()).subroutineEnd(1));
  }

  /**
   * Test {@link PartialEvaluator#isCreation(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isCreation(int)}
   */
  @Test
  @DisplayName("Test isCreation(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isCreation(int)"})
  void testIsCreation_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isCreation(2));
  }

  /**
   * Test {@link PartialEvaluator#isInitializer(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#isInitializer(int)}
   */
  @Test
  @DisplayName("Test isInitializer(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.PartialEvaluator.isInitializer(int)"})
  void testIsInitializer_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isInitializer(2));
  }

  /**
   * Test {@link PartialEvaluator#getVariablesBefore(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#getVariablesBefore(int)}
   */
  @Test
  @DisplayName("Test getVariablesBefore(int); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.TracedVariables proguard.evaluation.PartialEvaluator.getVariablesBefore(int)"
  })
  void testGetVariablesBefore_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).getVariablesBefore(1));
  }

  /**
   * Test {@link PartialEvaluator#getVariablesAfter(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#getVariablesAfter(int)}
   */
  @Test
  @DisplayName("Test getVariablesAfter(int); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.TracedVariables proguard.evaluation.PartialEvaluator.getVariablesAfter(int)"
  })
  void testGetVariablesAfter_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).getVariablesAfter(1));
  }

  /**
   * Test {@link PartialEvaluator#getStackBefore(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#getStackBefore(int)}
   */
  @Test
  @DisplayName("Test getStackBefore(int); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.TracedStack proguard.evaluation.PartialEvaluator.getStackBefore(int)"
  })
  void testGetStackBefore_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).getStackBefore(1));
  }

  /**
   * Test {@link PartialEvaluator#getStackAfter(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#getStackAfter(int)}
   */
  @Test
  @DisplayName("Test getStackAfter(int); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.TracedStack proguard.evaluation.PartialEvaluator.getStackAfter(int)"
  })
  void testGetStackAfter_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).getStackAfter(1));
  }

  /**
   * Test {@link PartialEvaluator#branchOrigins(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#branchOrigins(int)}
   */
  @Test
  @DisplayName("Test branchOrigins(int); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.InstructionOffsetValue proguard.evaluation.PartialEvaluator.branchOrigins(int)"
  })
  void testBranchOrigins_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).branchOrigins(1));
  }

  /**
   * Test {@link PartialEvaluator#branchTargets(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#branchTargets(int)}
   */
  @Test
  @DisplayName("Test branchTargets(int); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.InstructionOffsetValue proguard.evaluation.PartialEvaluator.branchTargets(int)"
  })
  void testBranchTargets_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).branchTargets(1));
  }

  /**
   * Test {@link PartialEvaluator#visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link ProguardCoreException}.
   * </ul>
   *
   * <p>Method under test: {@link PartialEvaluator#visitExceptionInfo(Clazz, Method, CodeAttribute,
   * ExceptionInfo)}
   */
  @Test
  @DisplayName(
      "Test visitExceptionInfo(Clazz, Method, CodeAttribute, ExceptionInfo); then throw ProguardCoreException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.PartialEvaluator.visitExceptionInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.ExceptionInfo)"
  })
  void testVisitExceptionInfo_thenThrowProguardCoreException() {
    // Arrange
    DebugPrinter stateTracker = mock(DebugPrinter.class);

    ProguardCoreException.Builder builder =
        new ProguardCoreException.Builder("An error occurred", 1);
    ProguardCoreException buildResult =
        builder.cause(new Throwable()).errorParameters("Error Parameters").build();
    doThrow(buildResult)
        .when(stateTracker)
        .registerUnusedExceptionHandler(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            anyInt(),
            anyInt(),
            Mockito.<ExceptionInfo>any());
    Builder createResult = Builder.create();
    Builder setBranchTargetFinderResult =
        createResult.setBranchTargetFinder(new BranchTargetFinder());
    Builder setBranchUnitResult = setBranchTargetFinderResult.setBranchUnit(new BasicBranchUnit());
    Builder setEvaluateAllCodeResult =
        setBranchUnitResult.setCallingInstructionBlockStack(new Stack<>()).setEvaluateAllCode(true);
    Builder setExtraInstructionVisitorResult =
        setEvaluateAllCodeResult.setExtraInstructionVisitor(new MaxStackSizeComputer());
    Builder stopAnalysisAfterNEvaluationsResult =
        setExtraInstructionVisitorResult
            .setInvocationUnit(new BasicInvocationUnit(new ParticularReferenceValueFactory()))
            .setPrettyPrinting(1)
            .setStateTracker(stateTracker)
            .stopAnalysisAfterNEvaluations(42);
    PartialEvaluator buildResult2 =
        stopAnalysisAfterNEvaluationsResult
            .setValueFactory(new ParticularReferenceValueFactory())
            .build();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        ProguardCoreException.class,
        () ->
            buildResult2.visitExceptionInfo(
                clazz, method, codeAttribute, new ExceptionInfo(1, 3, 1, 1)));
    verify(stateTracker)
        .registerUnusedExceptionHandler(
            isA(Clazz.class), isA(Method.class), eq(1), eq(3), isA(ExceptionInfo.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PartialEvaluator#stopAnalysisAfterNEvaluations(int)}
   *   <li>{@link PartialEvaluator#visitAnyAttribute(Clazz, Attribute)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.PartialEvaluator proguard.evaluation.PartialEvaluator.stopAnalysisAfterNEvaluations(int)",
    "void proguard.evaluation.PartialEvaluator.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder createResult = Builder.create();
    Builder setBranchTargetFinderResult =
        createResult.setBranchTargetFinder(new BranchTargetFinder());
    Builder setBranchUnitResult = setBranchTargetFinderResult.setBranchUnit(new BasicBranchUnit());
    Builder setEvaluateAllCodeResult =
        setBranchUnitResult.setCallingInstructionBlockStack(new Stack<>()).setEvaluateAllCode(true);
    Builder setExtraInstructionVisitorResult =
        setEvaluateAllCodeResult.setExtraInstructionVisitor(new MaxStackSizeComputer());
    Builder setPrettyPrintingResult =
        setExtraInstructionVisitorResult
            .setInvocationUnit(new BasicInvocationUnit(new ParticularReferenceValueFactory()))
            .setPrettyPrinting(1);
    Builder stopAnalysisAfterNEvaluationsResult =
        setPrettyPrintingResult
            .setStateTracker(new JsonPrinter())
            .stopAnalysisAfterNEvaluations(42);
    PartialEvaluator buildResult =
        stopAnalysisAfterNEvaluationsResult
            .setValueFactory(new ParticularReferenceValueFactory())
            .build();

    // Act
    PartialEvaluator actualStopAnalysisAfterNEvaluationsResult =
        buildResult.stopAnalysisAfterNEvaluations(42);
    LibraryClass clazz = new LibraryClass();
    buildResult.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    assertSame(buildResult, actualStopAnalysisAfterNEvaluationsResult);
  }
}
