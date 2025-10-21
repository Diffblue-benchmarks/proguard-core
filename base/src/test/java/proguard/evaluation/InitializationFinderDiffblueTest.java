package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import proguard.classfile.util.BranchTargetFinder;
import proguard.evaluation.PartialEvaluator.Builder;
import proguard.evaluation.util.jsonprinter.JsonPrinter;

public class InitializationFinderDiffblueTest {
  /**
   * Test {@link InitializationFinder#InitializationFinder()}.
   *
   * <p>Method under test: {@link InitializationFinder#InitializationFinder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InitializationFinder.<init>()"})
  public void testNewInitializationFinder() {
    // Arrange and Act
    InitializationFinder actualInitializationFinder = new InitializationFinder();

    // Assert
    assertEquals(0, actualInitializationFinder.superInitializationOffset());
    assertTrue(actualInitializationFinder.isInitializer());
  }

  /**
   * Test {@link InitializationFinder#InitializationFinder(PartialEvaluator, boolean)}.
   *
   * <p>Method under test: {@link InitializationFinder#InitializationFinder(PartialEvaluator,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InitializationFinder.<init>(PartialEvaluator, boolean)"})
  public void testNewInitializationFinder2() {
    // Arrange and Act
    InitializationFinder actualInitializationFinder =
        new InitializationFinder(new PartialEvaluator(), true);

    // Assert
    assertEquals(0, actualInitializationFinder.superInitializationOffset());
    assertTrue(actualInitializationFinder.isInitializer());
  }

  /**
   * Test {@link InitializationFinder#isInitializer()}.
   *
   * <p>Method under test: {@link InitializationFinder#isInitializer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InitializationFinder.isInitializer()"})
  public void testIsInitializer() {
    // Arrange, Act and Assert
    assertTrue((new InitializationFinder()).isInitializer());
  }

  /**
   * Test {@link InitializationFinder#isInitializer(int)} with {@code int}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InitializationFinder#isInitializer(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean InitializationFinder.isInitializer(int)"})
  public void testIsInitializerWithInt_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new InitializationFinder()).isInitializer(2));
  }

  /**
   * Test {@link InitializationFinder#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link InitializationFinder#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InitializationFinder.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute() {
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
    PartialEvaluator partialEvaluator =
        stopAnalysisAfterNEvaluationsResult
            .setValueFactory(new ParticularReferenceValueFactory())
            .build();
    InitializationFinder initializationFinder = new InitializationFinder(partialEvaluator, false);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    initializationFinder.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Assert
    assertFalse(initializationFinder.isInitializer());
    assertEquals(InitializationFinder.NONE, initializationFinder.superInitializationOffset());
  }

  /**
   * Test {@link InitializationFinder#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <p>Method under test: {@link InitializationFinder#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InitializationFinder.visitCodeAttribute(Clazz, Method, CodeAttribute)"})
  public void testVisitCodeAttribute2() {
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
    PartialEvaluator partialEvaluator =
        stopAnalysisAfterNEvaluationsResult
            .setValueFactory(new ParticularReferenceValueFactory())
            .build();
    InitializationFinder initializationFinder = new InitializationFinder(partialEvaluator, false);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "<init>", "Descriptor");

    // Act
    initializationFinder.visitCodeAttribute(clazz, method, new CodeAttribute(1));

    // Assert
    assertFalse(initializationFinder.isInitializer());
    assertEquals(InitializationFinder.NONE, initializationFinder.superInitializationOffset());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InitializationFinder#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link InitializationFinder#superInitializationOffset()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "int InitializationFinder.superInitializationOffset()",
    "void InitializationFinder.visitAnyAttribute(Clazz, Attribute)"
  })
  public void testGettersAndSetters() {
    // Arrange
    InitializationFinder initializationFinder = new InitializationFinder();
    LibraryClass clazz = new LibraryClass();

    // Act
    initializationFinder.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    assertEquals(0, initializationFinder.superInitializationOffset());
  }
}
