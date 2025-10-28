package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.visitor.MaxStackSizeComputer;
import proguard.classfile.instruction.visitor.InstructionVisitor;
import proguard.evaluation.exception.EmptyCodeAttributeException;
import proguard.evaluation.value.ValueFactory;
import proguard.exception.ProguardCoreException;

public class PartialEvaluatorDiffblueTest {
  /**
   * Method under test: {@link PartialEvaluator.Builder#disablePrettyPrinting()}
   */
  @Test
  public void testBuilderDisablePrettyPrinting() {
    // Arrange
    PartialEvaluator.Builder createResult = PartialEvaluator.Builder.create();

    // Act and Assert
    assertSame(createResult, createResult.disablePrettyPrinting());
  }

  /**
   * Method under test:
   * {@link PartialEvaluator#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute() {
    // Arrange
    PartialEvaluator partialEvaluator = new PartialEvaluator();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(EmptyCodeAttributeException.class,
        () -> partialEvaluator.visitCodeAttribute(clazz, method, new CodeAttribute(1)));
  }

  /**
   * Method under test:
   * {@link PartialEvaluator#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute2() {
    // Arrange
    PartialEvaluator partialEvaluator = new PartialEvaluator();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(8, "Name",
        "Unexpected error while performing partial evaluation:%n  Class       = [%s]%n  Method      = [%s%s]%n"
            + "  Exception   = [%s] (%s)");

    // Act and Assert
    assertThrows(ProguardCoreException.class, () -> partialEvaluator.visitCodeAttribute(clazz, method,
        new CodeAttribute(1, 3, 3, 3, new byte[]{'A', -19, 'A', -19, 'A', -19, 'A', -19})));
  }

  /**
   * Method under test:
   * {@link PartialEvaluator#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute3() {
    // Arrange
    PartialEvaluator partialEvaluator = new PartialEvaluator();
    LibraryClass clazz = new LibraryClass(1005, "Empty code attribute found during partial evaluation",
        "Empty code attribute found during partial evaluation");

    LibraryMethod method = new LibraryMethod(1, "Name",
        "Unexpected error while performing partial evaluation:%n  Class       = [%s]%n  Method      = [%s%s]%n"
            + "  Exception   = [%s] (%s)");

    // Act and Assert
    assertThrows(ProguardCoreException.class, () -> partialEvaluator.visitCodeAttribute(clazz, method,
        new CodeAttribute(1, 3, 3, 3, new byte[]{'A', -19, 'A', -19, 'A', -19, 'A', -19})));
  }

  /**
   * Method under test:
   * {@link PartialEvaluator#visitCodeAttribute0(Clazz, Method, CodeAttribute)}
   */
  @Test
  public void testVisitCodeAttribute0() {
    // Arrange
    PartialEvaluator partialEvaluator = new PartialEvaluator();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(EmptyCodeAttributeException.class,
        () -> partialEvaluator.visitCodeAttribute0(clazz, method, new CodeAttribute(1)));
  }

  /**
   * Method under test: {@link PartialEvaluator#isTraced(int)}
   */
  @Test
  public void testIsTraced() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isTraced(1));
    assertFalse((new PartialEvaluator()).isTraced(1, 3));
  }

  /**
   * Method under test: {@link PartialEvaluator#isInstruction(int)}
   */
  @Test
  public void testIsInstruction() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isInstruction(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#isTarget(int)}
   */
  @Test
  public void testIsTarget() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isTarget(1));
    assertTrue((new PartialEvaluator()).isTarget(0));
  }

  /**
   * Method under test: {@link PartialEvaluator#isBranchOrigin(int)}
   */
  @Test
  public void testIsBranchOrigin() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isBranchOrigin(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#isBranchTarget(int)}
   */
  @Test
  public void testIsBranchTarget() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isBranchTarget(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#isBranchOrExceptionTarget(int)}
   */
  @Test
  public void testIsBranchOrExceptionTarget() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isBranchOrExceptionTarget(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#isExceptionHandler(int)}
   */
  @Test
  public void testIsExceptionHandler() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isExceptionHandler(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#isSubroutineStart(int)}
   */
  @Test
  public void testIsSubroutineStart() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isSubroutineStart(1));
    assertTrue((new PartialEvaluator()).isSubroutineStart(0));
  }

  /**
   * Method under test: {@link PartialEvaluator#isSubroutineInvocation(int)}
   */
  @Test
  public void testIsSubroutineInvocation() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isSubroutineInvocation(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#isSubroutine(int)}
   */
  @Test
  public void testIsSubroutine() {
    // Arrange, Act and Assert
    assertTrue((new PartialEvaluator()).isSubroutine(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#isSubroutineReturning(int)}
   */
  @Test
  public void testIsSubroutineReturning() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isSubroutineReturning(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#subroutineEnd(int)}
   */
  @Test
  public void testSubroutineEnd() {
    // Arrange, Act and Assert
    assertEquals(0, (new PartialEvaluator()).subroutineEnd(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#isCreation(int)}
   */
  @Test
  public void testIsCreation() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isCreation(2));
  }

  /**
   * Method under test: {@link PartialEvaluator#isInitializer(int)}
   */
  @Test
  public void testIsInitializer() {
    // Arrange, Act and Assert
    assertFalse((new PartialEvaluator()).isInitializer(2));
  }

  /**
   * Method under test: {@link PartialEvaluator#getVariablesBefore(int)}
   */
  @Test
  public void testGetVariablesBefore() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).getVariablesBefore(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#getVariablesAfter(int)}
   */
  @Test
  public void testGetVariablesAfter() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).getVariablesAfter(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#getStackBefore(int)}
   */
  @Test
  public void testGetStackBefore() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).getStackBefore(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#getStackAfter(int)}
   */
  @Test
  public void testGetStackAfter() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).getStackAfter(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#branchOrigins(int)}
   */
  @Test
  public void testBranchOrigins() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).branchOrigins(1));
  }

  /**
   * Method under test: {@link PartialEvaluator#branchTargets(int)}
   */
  @Test
  public void testBranchTargets() {
    // Arrange, Act and Assert
    assertNull((new PartialEvaluator()).branchTargets(1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PartialEvaluator#stopAnalysisAfterNEvaluations(int)}
   *   <li>{@link PartialEvaluator#visitAnyAttribute(Clazz, Attribute)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PartialEvaluator partialEvaluator = new PartialEvaluator();

    // Act
    PartialEvaluator actualStopAnalysisAfterNEvaluationsResult = partialEvaluator.stopAnalysisAfterNEvaluations(42);
    LibraryClass clazz = new LibraryClass();
    partialEvaluator.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert that nothing has changed
    assertSame(partialEvaluator, actualStopAnalysisAfterNEvaluationsResult);
  }

  /**
   * Method under test: {@link PartialEvaluator#PartialEvaluator()}
   */
  @Test
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
   * Method under test: {@link PartialEvaluator#PartialEvaluator(ValueFactory)}
   */
  @Test
  public void testNewPartialEvaluator2() {
    // Arrange and Act
    PartialEvaluator actualPartialEvaluator = new PartialEvaluator(new ParticularReferenceValueFactory());

    // Assert
    assertNull(actualPartialEvaluator.getStackAfter(1));
    assertNull(actualPartialEvaluator.getStackBefore(1));
    assertNull(actualPartialEvaluator.branchOrigins(1));
    assertNull(actualPartialEvaluator.branchTargets(1));
  }

  /**
   * Method under test:
   * {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit, boolean)}
   */
  @Test
  public void testNewPartialEvaluator3() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    PartialEvaluator actualPartialEvaluator = new PartialEvaluator(valueFactory,
        new BasicInvocationUnit(new ParticularReferenceValueFactory()), true);

    // Assert
    assertNull(actualPartialEvaluator.getStackAfter(1));
    assertNull(actualPartialEvaluator.getStackBefore(1));
    assertNull(actualPartialEvaluator.branchOrigins(1));
    assertNull(actualPartialEvaluator.branchTargets(1));
  }

  /**
   * Method under test:
   * {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit, boolean)}
   */
  @Test
  public void testNewPartialEvaluator4() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act
    PartialEvaluator actualPartialEvaluator = new PartialEvaluator(valueFactory,
        new BasicInvocationUnit(new ParticularReferenceValueFactory()), false);

    // Assert
    assertNull(actualPartialEvaluator.getStackAfter(1));
    assertNull(actualPartialEvaluator.getStackBefore(1));
    assertNull(actualPartialEvaluator.branchOrigins(1));
    assertNull(actualPartialEvaluator.branchTargets(1));
  }

  /**
   * Method under test:
   * {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit, boolean, InstructionVisitor)}
   */
  @Test
  public void testNewPartialEvaluator5() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicInvocationUnit invocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());

    // Act
    PartialEvaluator actualPartialEvaluator = new PartialEvaluator(valueFactory, invocationUnit, true,
        new MaxStackSizeComputer());

    // Assert
    assertNull(actualPartialEvaluator.getStackAfter(1));
    assertNull(actualPartialEvaluator.getStackBefore(1));
    assertNull(actualPartialEvaluator.branchOrigins(1));
    assertNull(actualPartialEvaluator.branchTargets(1));
  }

  /**
   * Method under test:
   * {@link PartialEvaluator#PartialEvaluator(ValueFactory, InvocationUnit, boolean, InstructionVisitor)}
   */
  @Test
  public void testNewPartialEvaluator6() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();
    BasicInvocationUnit invocationUnit = new BasicInvocationUnit(new ParticularReferenceValueFactory());

    // Act
    PartialEvaluator actualPartialEvaluator = new PartialEvaluator(valueFactory, invocationUnit, false,
        new MaxStackSizeComputer());

    // Assert
    assertNull(actualPartialEvaluator.getStackAfter(1));
    assertNull(actualPartialEvaluator.getStackBefore(1));
    assertNull(actualPartialEvaluator.branchOrigins(1));
    assertNull(actualPartialEvaluator.branchTargets(1));
  }
}
