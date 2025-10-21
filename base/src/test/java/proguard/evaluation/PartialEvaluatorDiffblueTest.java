package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Stack;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.classfile.util.BranchTargetFinder;
import proguard.evaluation.PartialEvaluator.Builder;
import proguard.evaluation.exception.EmptyCodeAttributeException;
import proguard.evaluation.util.jsonprinter.JsonPrinter;
import proguard.evaluation.value.ValueFactory;
import proguard.exception.ProguardCoreException;

public class PartialEvaluatorDiffblueTest {
  /**
   * Test Builder {@link Builder#disablePrettyPrinting()}.
   *
   * <p>Method under test: {@link Builder#disablePrettyPrinting()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Builder Builder.disablePrettyPrinting()"})
  public void testBuilderDisablePrettyPrinting() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PartialEvaluator.<init>()"})
  public void testNewPartialEvaluator() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PartialEvaluator.<init>(ValueFactory)"})
  public void testNewPartialEvaluator2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PartialEvaluator.<init>(ValueFactory, InvocationUnit, boolean)"})
  public void testNewPartialEvaluator_whenFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void PartialEvaluator.<init>(ValueFactory, InvocationUnit, boolean, InstructionVisitor)"
  })
  public void testNewPartialEvaluator_whenFalse2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PartialEvaluator.<init>(ValueFactory, InvocationUnit, boolean)"})
  public void testNewPartialEvaluator_whenTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void PartialEvaluator.<init>(ValueFactory, InvocationUnit, boolean, InstructionVisitor)"
  })
  public void testNewPartialEvaluator_whenTrue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PartialEvaluator.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute_thenThrowEmptyCodeAttributeException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PartialEvaluator.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute_thenThrowProguardCoreException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PartialEvaluator.visitCodeAttribute0(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute0_thenThrowEmptyCodeAttributeException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isTraced(int)"})
  public void testIsTracedWithInstructionOffset_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isTraced(int, int)"})
  public void testIsTracedWithStartOffsetEndOffset_whenThree_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isInstruction(int)"})
  public void testIsInstruction_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isTarget(int)"})
  public void testIsTarget_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isTarget(int)"})
  public void testIsTarget_whenZero_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isBranchOrigin(int)"})
  public void testIsBranchOrigin_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isBranchTarget(int)"})
  public void testIsBranchTarget_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isBranchOrExceptionTarget(int)"})
  public void testIsBranchOrExceptionTarget_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isExceptionHandler(int)"})
  public void testIsExceptionHandler_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isSubroutineStart(int)"})
  public void testIsSubroutineStart_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isSubroutineStart(int)"})
  public void testIsSubroutineStart_whenZero_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isSubroutineInvocation(int)"})
  public void testIsSubroutineInvocation_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isSubroutine(int)"})
  public void testIsSubroutine_whenOne_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isSubroutineReturning(int)"})
  public void testIsSubroutineReturning_whenOne_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PartialEvaluator.subroutineEnd(int)"})
  public void testSubroutineEnd_whenOne_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isCreation(int)"})
  public void testIsCreation_whenTwo_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PartialEvaluator.isInitializer(int)"})
  public void testIsInitializer_whenTwo_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.TracedVariables PartialEvaluator.getVariablesBefore(int)"
  })
  public void testGetVariablesBefore_whenOne_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.TracedVariables PartialEvaluator.getVariablesAfter(int)"})
  public void testGetVariablesAfter_whenOne_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.TracedStack PartialEvaluator.getStackBefore(int)"})
  public void testGetStackBefore_whenOne_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.TracedStack PartialEvaluator.getStackAfter(int)"})
  public void testGetStackAfter_whenOne_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.InstructionOffsetValue PartialEvaluator.branchOrigins(int)"
  })
  public void testBranchOrigins_whenOne_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.evaluation.value.InstructionOffsetValue PartialEvaluator.branchTargets(int)"
  })
  public void testBranchTargets_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).branchTargets(1));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PartialEvaluator PartialEvaluator.stopAnalysisAfterNEvaluations(int)",
    "void PartialEvaluator.visitAnyAttribute(Clazz, Attribute)"
  })
  public void testGettersAndSetters() {
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
