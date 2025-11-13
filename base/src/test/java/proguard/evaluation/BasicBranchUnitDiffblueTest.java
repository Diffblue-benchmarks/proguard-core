package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.evaluation.value.InstructionOffsetValue;

class BasicBranchUnitDiffblueTest {
  /**
   * Test {@link BasicBranchUnit#reset()}.
   *
   * <p>Method under test: {@link BasicBranchUnit#reset()}
   */
  @Test
  @DisplayName("Test reset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicBranchUnit.reset()"})
  void testReset() {
    // Arrange
    BasicBranchUnit basicBranchUnit = new BasicBranchUnit();

    // Act
    basicBranchUnit.reset();

    // Assert
    InstructionOffsetValue traceBranchTargets = basicBranchUnit.getTraceBranchTargets();
    assertFalse(traceBranchTargets.isCategory2());
    assertTrue(traceBranchTargets.isParticular());
    assertTrue(traceBranchTargets.isSpecific());
  }

  /**
   * Test {@link BasicBranchUnit#branch(Clazz, CodeAttribute, int, int)}.
   *
   * <ul>
   *   <li>Then not {@link BasicBranchUnit} (default constructor) TraceBranchTargets Category2.
   * </ul>
   *
   * <p>Method under test: {@link BasicBranchUnit#branch(Clazz, CodeAttribute, int, int)}
   */
  @Test
  @DisplayName(
      "Test branch(Clazz, CodeAttribute, int, int); then not BasicBranchUnit (default constructor) TraceBranchTargets Category2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicBranchUnit.branch(Clazz, CodeAttribute, int, int)"})
  void testBranch_thenNotBasicBranchUnitTraceBranchTargetsCategory2() {
    // Arrange
    BasicBranchUnit basicBranchUnit = new BasicBranchUnit();
    LibraryClass clazz = new LibraryClass();

    // Act
    basicBranchUnit.branch(clazz, new CodeAttribute(1), 2, 1);

    // Assert
    InstructionOffsetValue traceBranchTargets = basicBranchUnit.getTraceBranchTargets();
    assertFalse(traceBranchTargets.isCategory2());
    assertTrue(basicBranchUnit.wasCalled());
    assertTrue(traceBranchTargets.isParticular());
    assertTrue(traceBranchTargets.isSpecific());
    assertTrue(basicBranchUnit.wasCalled);
  }

  /**
   * Test {@link BasicBranchUnit#branch(Clazz, CodeAttribute, int, int)}.
   *
   * <ul>
   *   <li>Then not {@link TracedBranchUnit} (default constructor) TraceBranchTargets Category2.
   * </ul>
   *
   * <p>Method under test: {@link BasicBranchUnit#branch(Clazz, CodeAttribute, int, int)}
   */
  @Test
  @DisplayName(
      "Test branch(Clazz, CodeAttribute, int, int); then not TracedBranchUnit (default constructor) TraceBranchTargets Category2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicBranchUnit.branch(Clazz, CodeAttribute, int, int)"})
  void testBranch_thenNotTracedBranchUnitTraceBranchTargetsCategory2() {
    // Arrange
    TracedBranchUnit tracedBranchUnit = new TracedBranchUnit();
    LibraryClass clazz = new LibraryClass();

    // Act
    tracedBranchUnit.branch(clazz, new CodeAttribute(1), 2, 1);

    // Assert
    InstructionOffsetValue traceBranchTargets = tracedBranchUnit.getTraceBranchTargets();
    assertFalse(traceBranchTargets.isCategory2());
    assertTrue(tracedBranchUnit.wasCalled());
    assertTrue(traceBranchTargets.isParticular());
    assertTrue(traceBranchTargets.isSpecific());
    assertTrue(tracedBranchUnit.wasCalled);
  }

  /**
   * Test {@link BasicBranchUnit#branchConditionally(Clazz, CodeAttribute, int, int, int)}.
   *
   * <ul>
   *   <li>Then not {@link TracedBranchUnit} (default constructor) TraceBranchTargets Category2.
   * </ul>
   *
   * <p>Method under test: {@link BasicBranchUnit#branchConditionally(Clazz, CodeAttribute, int,
   * int, int)}
   */
  @Test
  @DisplayName(
      "Test branchConditionally(Clazz, CodeAttribute, int, int, int); then not TracedBranchUnit (default constructor) TraceBranchTargets Category2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicBranchUnit.branchConditionally(Clazz, CodeAttribute, int, int, int)"
  })
  void testBranchConditionally_thenNotTracedBranchUnitTraceBranchTargetsCategory2() {
    // Arrange
    TracedBranchUnit tracedBranchUnit = new TracedBranchUnit();
    LibraryClass clazz = new LibraryClass();

    // Act
    tracedBranchUnit.branchConditionally(clazz, new CodeAttribute(1), 2, 1, 1);

    // Assert
    InstructionOffsetValue traceBranchTargets = tracedBranchUnit.getTraceBranchTargets();
    assertFalse(traceBranchTargets.isCategory2());
    assertTrue(tracedBranchUnit.wasCalled());
    assertTrue(traceBranchTargets.isParticular());
    assertTrue(traceBranchTargets.isSpecific());
    assertTrue(tracedBranchUnit.wasCalled);
  }

  /**
   * Test {@link BasicBranchUnit#returnFromMethod()}.
   *
   * <p>Method under test: {@link BasicBranchUnit#returnFromMethod()}
   */
  @Test
  @DisplayName("Test returnFromMethod()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicBranchUnit.returnFromMethod()"})
  void testReturnFromMethod() {
    // Arrange
    BasicBranchUnit basicBranchUnit = new BasicBranchUnit();

    // Act
    basicBranchUnit.returnFromMethod();

    // Assert
    InstructionOffsetValue traceBranchTargets = basicBranchUnit.getTraceBranchTargets();
    assertFalse(traceBranchTargets.isCategory2());
    assertTrue(basicBranchUnit.wasCalled());
    assertTrue(traceBranchTargets.isParticular());
    assertTrue(traceBranchTargets.isSpecific());
    assertTrue(basicBranchUnit.wasCalled);
  }

  /**
   * Test {@link BasicBranchUnit#throwException()}.
   *
   * <p>Method under test: {@link BasicBranchUnit#throwException()}
   */
  @Test
  @DisplayName("Test throwException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicBranchUnit.throwException()"})
  void testThrowException() {
    // Arrange
    BasicBranchUnit basicBranchUnit = new BasicBranchUnit();

    // Act
    basicBranchUnit.throwException();

    // Assert
    InstructionOffsetValue traceBranchTargets = basicBranchUnit.getTraceBranchTargets();
    assertFalse(traceBranchTargets.isCategory2());
    assertTrue(basicBranchUnit.wasCalled());
    assertTrue(traceBranchTargets.isParticular());
    assertTrue(traceBranchTargets.isSpecific());
    assertTrue(basicBranchUnit.wasCalled);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BasicBranchUnit}
   *   <li>{@link BasicBranchUnit#getTraceBranchTargets()}
   *   <li>{@link BasicBranchUnit#wasCalled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicBranchUnit.<init>()",
    "InstructionOffsetValue BasicBranchUnit.getTraceBranchTargets()",
    "boolean BasicBranchUnit.wasCalled()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BasicBranchUnit actualBasicBranchUnit = new BasicBranchUnit();
    InstructionOffsetValue actualTraceBranchTargets = actualBasicBranchUnit.getTraceBranchTargets();

    // Assert
    assertNull(actualTraceBranchTargets);
    assertFalse(actualBasicBranchUnit.wasCalled());
  }
}
