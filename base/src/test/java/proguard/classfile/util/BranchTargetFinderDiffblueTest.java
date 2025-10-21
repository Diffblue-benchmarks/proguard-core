package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.VariableInstruction;

public class BranchTargetFinderDiffblueTest {
  /**
   * Test {@link BranchTargetFinder#isInstruction(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isInstruction(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isInstruction(int)"})
  public void testIsInstruction_thenReturnTrue() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitConstantInstruction(
        clazz, method, codeAttribute, 2, new ConstantInstruction((byte) 'A', 1));

    // Act and Assert
    assertTrue(branchTargetFinder.isInstruction(2));
  }

  /**
   * Test {@link BranchTargetFinder#isInstruction(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isInstruction(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isInstruction(int)"})
  public void testIsInstruction_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isInstruction(2));
  }

  /**
   * Test {@link BranchTargetFinder#isCreation(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isCreation(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isCreation(int)"})
  public void testIsCreation_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isCreation(2));
  }

  /**
   * Test {@link BranchTargetFinder#isInitializer(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isInitializer(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isInitializer(int)"})
  public void testIsInitializer_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isInitializer(2));
  }

  /**
   * Test {@link BranchTargetFinder#isTarget(int)}.
   *
   * <ul>
   *   <li>Given {@link LibraryMethod#LibraryMethod(int, String, String)} with u2accessFlags is two
   *       and {@code Name} and {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isTarget(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isTarget(int)"})
  public void testIsTarget_givenLibraryMethodWithU2accessFlagsIsTwoAndNameAndDescriptor() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(2, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitExceptionInfo(
        clazz, method, codeAttribute, new ExceptionInfo(1, 3, 2, 2));

    // Act and Assert
    assertTrue(branchTargetFinder.isTarget(2));
  }

  /**
   * Test {@link BranchTargetFinder#isTarget(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isTarget(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isTarget(int)"})
  public void testIsTarget_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isTarget(2));
  }

  /**
   * Test {@link BranchTargetFinder#isTarget(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isTarget(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isTarget(int)"})
  public void testIsTarget_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BranchTargetFinder()).isTarget(0));
  }

  /**
   * Test {@link BranchTargetFinder#isBranchOrigin(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isBranchOrigin(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isBranchOrigin(int)"})
  public void testIsBranchOrigin_thenReturnTrue() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(8, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 8));

    // Act and Assert
    assertTrue(branchTargetFinder.isBranchOrigin(2));
  }

  /**
   * Test {@link BranchTargetFinder#isBranchOrigin(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isBranchOrigin(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isBranchOrigin(int)"})
  public void testIsBranchOrigin_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isBranchOrigin(2));
  }

  /**
   * Test {@link BranchTargetFinder#isBranchTarget(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isBranchTarget(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isBranchTarget(int)"})
  public void testIsBranchTarget_thenReturnTrue() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(Short.SIZE, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 0));

    // Act and Assert
    assertTrue(branchTargetFinder.isBranchTarget(2));
  }

  /**
   * Test {@link BranchTargetFinder#isBranchTarget(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isBranchTarget(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isBranchTarget(int)"})
  public void testIsBranchTarget_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isBranchTarget(2));
  }

  /**
   * Test {@link BranchTargetFinder#isAfterBranch(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isAfterBranch(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isAfterBranch(int)"})
  public void testIsAfterBranch_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isAfterBranch(2));
  }

  /**
   * Test {@link BranchTargetFinder#isExceptionStart(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isExceptionStart(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isExceptionStart(int)"})
  public void testIsExceptionStart_thenReturnTrue() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(Double.SIZE, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitExceptionInfo(
        clazz, method, codeAttribute, new ExceptionInfo(1, 3, Double.SIZE, Double.SIZE));

    // Act and Assert
    assertTrue(branchTargetFinder.isExceptionStart(1));
  }

  /**
   * Test {@link BranchTargetFinder#isExceptionStart(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isExceptionStart(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isExceptionStart(int)"})
  public void testIsExceptionStart_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isExceptionStart(2));
  }

  /**
   * Test {@link BranchTargetFinder#isExceptionEnd(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isExceptionEnd(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isExceptionEnd(int)"})
  public void testIsExceptionEnd_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isExceptionEnd(2));
  }

  /**
   * Test {@link BranchTargetFinder#isExceptionHandler(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isExceptionHandler(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isExceptionHandler(int)"})
  public void testIsExceptionHandler_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isExceptionHandler(2));
  }

  /**
   * Test {@link BranchTargetFinder#isSubroutineInvocation(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isSubroutineInvocation(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isSubroutineInvocation(int)"})
  public void testIsSubroutineInvocation_thenReturnTrue() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(512, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) -88, 512));

    // Act and Assert
    assertTrue(branchTargetFinder.isSubroutineInvocation(2));
  }

  /**
   * Test {@link BranchTargetFinder#isSubroutineInvocation(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isSubroutineInvocation(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isSubroutineInvocation(int)"})
  public void testIsSubroutineInvocation_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isSubroutineInvocation(2));
  }

  /**
   * Test {@link BranchTargetFinder#isSubroutineStart(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isSubroutineStart(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isSubroutineStart(int)"})
  public void testIsSubroutineStart_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isSubroutineStart(2));
  }

  /**
   * Test {@link BranchTargetFinder#isSubroutineStart(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isSubroutineStart(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isSubroutineStart(int)"})
  public void testIsSubroutineStart_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BranchTargetFinder()).isSubroutineStart(0));
  }

  /**
   * Test {@link BranchTargetFinder#isSubroutine(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isSubroutine(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isSubroutine(int)"})
  public void testIsSubroutine_whenTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BranchTargetFinder()).isSubroutine(2));
  }

  /**
   * Test {@link BranchTargetFinder#isSubroutineReturning(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#isSubroutineReturning(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BranchTargetFinder.isSubroutineReturning(int)"})
  public void testIsSubroutineReturning_whenTwo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isSubroutineReturning(2));
  }

  /**
   * Test {@link BranchTargetFinder#subroutineStart(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#subroutineStart(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BranchTargetFinder.subroutineStart(int)"})
  public void testSubroutineStart_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new BranchTargetFinder()).subroutineStart(2));
  }

  /**
   * Test {@link BranchTargetFinder#subroutineEnd(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#subroutineEnd(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BranchTargetFinder.subroutineEnd(int)"})
  public void testSubroutineEnd_whenTwo_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new BranchTargetFinder()).subroutineEnd(2));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BranchTargetFinder#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link BranchTargetFinder#visitAnyConstant(Clazz, Constant)}
   *   <li>{@link BranchTargetFinder#containsSubroutines()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean BranchTargetFinder.containsSubroutines()",
    "void BranchTargetFinder.visitAnyAttribute(Clazz, Attribute)",
    "void BranchTargetFinder.visitAnyConstant(Clazz, Constant)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();

    // Act
    branchTargetFinder.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());
    LibraryClass clazz2 = new LibraryClass();
    branchTargetFinder.visitAnyConstant(clazz2, new ClassConstant());

    // Assert
    assertFalse(branchTargetFinder.containsSubroutines());
  }

  /**
   * Test {@link BranchTargetFinder#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <ul>
   *   <li>Then {@link BranchTargetFinder} (default constructor) containsSubroutines.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BranchTargetFinder.visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)"
  })
  public void testVisitVariableInstruction_thenBranchTargetFinderContainsSubroutines() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) -87));

    // Assert
    assertTrue(branchTargetFinder.containsSubroutines());
  }

  /**
   * Test {@link BranchTargetFinder#visitVariableInstruction(Clazz, Method, CodeAttribute, int,
   * VariableInstruction)}.
   *
   * <ul>
   *   <li>Then not {@link BranchTargetFinder} (default constructor) containsSubroutines.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#visitVariableInstruction(Clazz, Method,
   * CodeAttribute, int, VariableInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BranchTargetFinder.visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)"
  })
  public void testVisitVariableInstruction_thenNotBranchTargetFinderContainsSubroutines() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitVariableInstruction(
        clazz, method, codeAttribute, 2, new VariableInstruction((byte) 'A'));

    // Assert that nothing has changed
    assertFalse(branchTargetFinder.containsSubroutines());
  }

  /**
   * Test {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BranchTargetFinder.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert that nothing has changed
    assertFalse(branchTargetFinder.containsSubroutines());
  }

  /**
   * Test {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BranchTargetFinder.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction2() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) -88, 1));

    // Assert
    assertTrue(branchTargetFinder.containsSubroutines());
  }

  /**
   * Test {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BranchTargetFinder.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction3() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) -55, 1));

    // Assert
    assertTrue(branchTargetFinder.containsSubroutines());
  }

  /**
   * Test {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BranchTargetFinder.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction4() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) -89, 1));

    // Assert that nothing has changed
    assertFalse(branchTargetFinder.containsSubroutines());
  }

  /**
   * Test {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method, CodeAttribute, int,
   * BranchInstruction)}.
   *
   * <p>Method under test: {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method,
   * CodeAttribute, int, BranchInstruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BranchTargetFinder.visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)"
  })
  public void testVisitBranchInstruction5() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitBranchInstruction(
        clazz, method, codeAttribute, 2, new BranchInstruction((byte) -56, 1));

    // Assert that nothing has changed
    assertFalse(branchTargetFinder.containsSubroutines());
  }

  /**
   * Test new {@link BranchTargetFinder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BranchTargetFinder}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BranchTargetFinder.<init>()"})
  public void testNewBranchTargetFinder() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).containsSubroutines());
  }
}
