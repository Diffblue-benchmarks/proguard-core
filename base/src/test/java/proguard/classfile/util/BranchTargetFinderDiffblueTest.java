package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.ExceptionInfo;
import proguard.classfile.attribute.visitor.ExceptionInfoVisitor;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.VariableInstruction;
import proguard.classfile.instruction.visitor.InstructionVisitor;

class BranchTargetFinderDiffblueTest {
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
  @DisplayName("Test isInstruction(int); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isInstruction(int)"})
  void testIsInstruction_thenReturnTrue() {
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
  @DisplayName("Test isInstruction(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isInstruction(int)"})
  void testIsInstruction_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test isCreation(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isCreation(int)"})
  void testIsCreation_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test isInitializer(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isInitializer(int)"})
  void testIsInitializer_whenTwo_thenReturnFalse() {
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
  @DisplayName(
      "Test isTarget(int); given LibraryMethod(int, String, String) with u2accessFlags is two and 'Name' and 'Descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isTarget(int)"})
  void testIsTarget_givenLibraryMethodWithU2accessFlagsIsTwoAndNameAndDescriptor() {
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
  @DisplayName("Test isTarget(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isTarget(int)"})
  void testIsTarget_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test isTarget(int); when zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isTarget(int)"})
  void testIsTarget_whenZero_thenReturnTrue() {
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
  @DisplayName("Test isBranchOrigin(int); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isBranchOrigin(int)"})
  void testIsBranchOrigin_thenReturnTrue() {
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
  @DisplayName("Test isBranchOrigin(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isBranchOrigin(int)"})
  void testIsBranchOrigin_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test isBranchTarget(int); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isBranchTarget(int)"})
  void testIsBranchTarget_thenReturnTrue() {
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
  @DisplayName("Test isBranchTarget(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isBranchTarget(int)"})
  void testIsBranchTarget_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test isAfterBranch(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isAfterBranch(int)"})
  void testIsAfterBranch_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test isExceptionStart(int); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isExceptionStart(int)"})
  void testIsExceptionStart_thenReturnTrue() {
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
  @DisplayName("Test isExceptionStart(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isExceptionStart(int)"})
  void testIsExceptionStart_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test isExceptionEnd(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isExceptionEnd(int)"})
  void testIsExceptionEnd_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test isExceptionHandler(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isExceptionHandler(int)"})
  void testIsExceptionHandler_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test isSubroutineInvocation(int); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.BranchTargetFinder.isSubroutineInvocation(int)"
  })
  void testIsSubroutineInvocation_thenReturnTrue() {
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
  @DisplayName("Test isSubroutineInvocation(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.BranchTargetFinder.isSubroutineInvocation(int)"
  })
  void testIsSubroutineInvocation_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test isSubroutineStart(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isSubroutineStart(int)"})
  void testIsSubroutineStart_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test isSubroutineStart(int); when zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isSubroutineStart(int)"})
  void testIsSubroutineStart_whenZero_thenReturnTrue() {
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
  @DisplayName("Test isSubroutine(int); when two; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.util.BranchTargetFinder.isSubroutine(int)"})
  void testIsSubroutine_whenTwo_thenReturnTrue() {
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
  @DisplayName("Test isSubroutineReturning(int); when two; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.BranchTargetFinder.isSubroutineReturning(int)"
  })
  void testIsSubroutineReturning_whenTwo_thenReturnFalse() {
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
  @DisplayName("Test subroutineStart(int); when two; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.BranchTargetFinder.subroutineStart(int)"})
  void testSubroutineStart_whenTwo_thenReturnZero() {
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
  @DisplayName("Test subroutineEnd(int); when two; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.util.BranchTargetFinder.subroutineEnd(int)"})
  void testSubroutineEnd_whenTwo_thenReturnZero() {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.util.BranchTargetFinder.containsSubroutines()",
    "void proguard.classfile.util.BranchTargetFinder.visitAnyAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.Attribute)",
    "void proguard.classfile.util.BranchTargetFinder.visitAnyConstant(proguard.classfile.Clazz, proguard.classfile.constant.Constant)"
  })
  void testGettersAndSetters() {
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
   * Test {@link BranchTargetFinder#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#exceptionsAccept(Clazz, Method, ExceptionInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#visitCodeAttribute(Clazz, Method,
   * CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls exceptionsAccept(Clazz, Method, ExceptionInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.BranchTargetFinder.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsExceptionsAccept() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .exceptionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<ExceptionInfoVisitor>any());
    doNothing()
        .when(codeAttribute)
        .instructionsAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<InstructionVisitor>any());

    // Act
    branchTargetFinder.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute)
        .exceptionsAccept(isA(Clazz.class), isA(Method.class), isA(ExceptionInfoVisitor.class));
    verify(codeAttribute)
        .instructionsAccept(isA(Clazz.class), isA(Method.class), isA(InstructionVisitor.class));
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
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction); then BranchTargetFinder (default constructor) containsSubroutines")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.BranchTargetFinder.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction_thenBranchTargetFinderContainsSubroutines() {
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
  @DisplayName(
      "Test visitVariableInstruction(Clazz, Method, CodeAttribute, int, VariableInstruction); then not BranchTargetFinder (default constructor) containsSubroutines")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.BranchTargetFinder.visitVariableInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.VariableInstruction)"
  })
  void testVisitVariableInstruction_thenNotBranchTargetFinderContainsSubroutines() {
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
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.BranchTargetFinder.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction() {
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
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.BranchTargetFinder.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction2() {
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
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.BranchTargetFinder.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction3() {
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
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.BranchTargetFinder.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction4() {
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
  @DisplayName("Test visitBranchInstruction(Clazz, Method, CodeAttribute, int, BranchInstruction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.BranchTargetFinder.visitBranchInstruction(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, int, proguard.classfile.instruction.BranchInstruction)"
  })
  void testVisitBranchInstruction5() {
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
   * Test {@link BranchTargetFinder#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link LibraryClass#getName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link BranchTargetFinder#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); given 'Name'; then calls getName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.BranchTargetFinder.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_givenName_thenCallsGetName() {
    // Arrange
    BranchTargetFinder branchTargetFinder = new BranchTargetFinder();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getName(anyInt())).thenReturn("Name");

    // Act
    branchTargetFinder.visitMethodrefConstant(clazz, new MethodrefConstant());

    // Assert
    verify(clazz).getName(eq(0));
  }

  /**
   * Test new {@link BranchTargetFinder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BranchTargetFinder}
   */
  @Test
  @DisplayName("Test new BranchTargetFinder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.util.BranchTargetFinder.<init>()"})
  void testNewBranchTargetFinder() {
    // Arrange, Act and Assert
    assertFalse((new BranchTargetFinder()).containsSubroutines());
  }
}
