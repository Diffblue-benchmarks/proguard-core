package proguard.classfile.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
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
   * Method under test: {@link BranchTargetFinder#isInstruction(int)}
   */
  @Test
  public void testIsInstruction() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isInstruction(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isInstruction(int)}
   */
  @Test
  public void testIsInstruction2() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitConstantInstruction(clazz, method, codeAttribute, 2,
        new ConstantInstruction((byte) 'A', 1));

    // Act and Assert
    assertTrue(branchTargetFinder.isInstruction(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isCreation(int)}
   */
  @Test
  public void testIsCreation() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isCreation(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isInitializer(int)}
   */
  @Test
  public void testIsInitializer() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isInitializer(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isTarget(int)}
   */
  @Test
  public void testIsTarget() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isTarget(2));
    assertTrue((new BranchTargetFinder()).isTarget(0));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isTarget(int)}
   */
  @Test
  public void testIsTarget2() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(2, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitExceptionInfo(clazz, method, codeAttribute, new ExceptionInfo(1, 3, 2, 2));

    // Act and Assert
    assertTrue(branchTargetFinder.isTarget(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isBranchOrigin(int)}
   */
  @Test
  public void testIsBranchOrigin() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isBranchOrigin(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isBranchOrigin(int)}
   */
  @Test
  public void testIsBranchOrigin2() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(8, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitBranchInstruction(clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 8));

    // Act and Assert
    assertTrue(branchTargetFinder.isBranchOrigin(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isBranchTarget(int)}
   */
  @Test
  public void testIsBranchTarget() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isBranchTarget(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isBranchTarget(int)}
   */
  @Test
  public void testIsBranchTarget2() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(Short.SIZE, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitBranchInstruction(clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 0));

    // Act and Assert
    assertTrue(branchTargetFinder.isBranchTarget(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isAfterBranch(int)}
   */
  @Test
  public void testIsAfterBranch() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isAfterBranch(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isExceptionStart(int)}
   */
  @Test
  public void testIsExceptionStart() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isExceptionStart(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isExceptionStart(int)}
   */
  @Test
  public void testIsExceptionStart2() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(Double.SIZE, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitExceptionInfo(clazz, method, codeAttribute,
        new ExceptionInfo(1, 3, Double.SIZE, Double.SIZE));

    // Act and Assert
    assertTrue(branchTargetFinder.isExceptionStart(1));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isExceptionEnd(int)}
   */
  @Test
  public void testIsExceptionEnd() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isExceptionEnd(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isExceptionHandler(int)}
   */
  @Test
  public void testIsExceptionHandler() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isExceptionHandler(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isSubroutineInvocation(int)}
   */
  @Test
  public void testIsSubroutineInvocation() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isSubroutineInvocation(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isSubroutineInvocation(int)}
   */
  @Test
  public void testIsSubroutineInvocation2() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(512, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    branchTargetFinder.visitBranchInstruction(clazz, method, codeAttribute, 2, new BranchInstruction((byte) -88, 512));

    // Act and Assert
    assertTrue(branchTargetFinder.isSubroutineInvocation(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isSubroutineStart(int)}
   */
  @Test
  public void testIsSubroutineStart() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isSubroutineStart(2));
    assertTrue((new BranchTargetFinder()).isSubroutineStart(0));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isSubroutine(int)}
   */
  @Test
  public void testIsSubroutine() {
    // Arrange, Act and Assert
    assertTrue((new BranchTargetFinder()).isSubroutine(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#isSubroutineReturning(int)}
   */
  @Test
  public void testIsSubroutineReturning() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).isSubroutineReturning(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#subroutineStart(int)}
   */
  @Test
  public void testSubroutineStart() {
    // Arrange, Act and Assert
    assertEquals(0, (new BranchTargetFinder()).subroutineStart(2));
  }

  /**
   * Method under test: {@link BranchTargetFinder#subroutineEnd(int)}
   */
  @Test
  public void testSubroutineEnd() {
    // Arrange, Act and Assert
    assertEquals(0, (new BranchTargetFinder()).subroutineEnd(2));
  }

  /**
   * Method under test:
   * {@link BranchTargetFinder#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitVariableInstruction(clazz, method, codeAttribute, 2, new VariableInstruction((byte) 'A'));

    // Assert
    assertFalse(branchTargetFinder.containsSubroutines());
  }

  /**
   * Method under test:
   * {@link BranchTargetFinder#visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction)}
   */
  @Test
  public void testVisitVariableInstruction2() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitVariableInstruction(clazz, method, codeAttribute, 2, new VariableInstruction((byte) -87));

    // Assert
    assertTrue(branchTargetFinder.containsSubroutines());
  }

  /**
   * Method under test:
   * {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitBranchInstruction(clazz, method, codeAttribute, 2, new BranchInstruction((byte) 'A', 1));

    // Assert
    assertFalse(branchTargetFinder.containsSubroutines());
  }

  /**
   * Method under test:
   * {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction2() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitBranchInstruction(clazz, method, codeAttribute, 2, new BranchInstruction((byte) -88, 1));

    // Assert
    assertTrue(branchTargetFinder.containsSubroutines());
  }

  /**
   * Method under test:
   * {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction3() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitBranchInstruction(clazz, method, codeAttribute, 2, new BranchInstruction((byte) -55, 1));

    // Assert
    assertTrue(branchTargetFinder.containsSubroutines());
  }

  /**
   * Method under test:
   * {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction4() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitBranchInstruction(clazz, method, codeAttribute, 2, new BranchInstruction((byte) -89, 1));

    // Assert
    assertFalse(branchTargetFinder.containsSubroutines());
  }

  /**
   * Method under test:
   * {@link BranchTargetFinder#visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)}
   */
  @Test
  public void testVisitBranchInstruction5() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    branchTargetFinder.visitBranchInstruction(clazz, method, codeAttribute, 2, new BranchInstruction((byte) -56, 1));

    // Assert
    assertFalse(branchTargetFinder.containsSubroutines());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BranchTargetFinder#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link BranchTargetFinder#visitAnyConstant(Clazz, Constant)}
   *   <li>{@link BranchTargetFinder#containsSubroutines()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();

    // Act
    branchTargetFinder.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());
    LibraryClass clazz2 = new LibraryClass();
    branchTargetFinder.visitAnyConstant(clazz2, new ClassConstant());

    // Assert that nothing has changed
    assertFalse(branchTargetFinder.containsSubroutines());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BranchTargetFinder}
   */
  @Test
  public void testNewBranchTargetFinder() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).containsSubroutines());
  }
}
