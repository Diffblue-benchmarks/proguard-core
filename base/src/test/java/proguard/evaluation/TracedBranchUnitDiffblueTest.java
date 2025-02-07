package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.evaluation.value.InstructionOffsetValue;

class TracedBranchUnitDiffblueTest {
  /**
   * Test {@link TracedBranchUnit#reset()}.
   *
   * <p>Method under test: {@link TracedBranchUnit#reset()}
   */
  @Test
  @DisplayName("Test reset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.TracedBranchUnit.reset()"})
  void testReset() {
    // Arrange
    TracedBranchUnit tracedBranchUnit = new TracedBranchUnit();

    // Act
    tracedBranchUnit.reset();

    // Assert
    InstructionOffsetValue traceBranchTargets = tracedBranchUnit.getTraceBranchTargets();
    assertFalse(traceBranchTargets.isCategory2());
    assertTrue(traceBranchTargets.isParticular());
    assertTrue(traceBranchTargets.isSpecific());
  }

  /**
   * Test {@link TracedBranchUnit#branch(Clazz, CodeAttribute, int, int)}.
   *
   * <p>Method under test: {@link TracedBranchUnit#branch(Clazz, CodeAttribute, int, int)}
   */
  @Test
  @DisplayName("Test branch(Clazz, CodeAttribute, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.TracedBranchUnit.branch(proguard.classfile.Clazz, proguard.classfile.attribute.CodeAttribute, int, int)"
  })
  void testBranch() {
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
   * Test {@link TracedBranchUnit#branchConditionally(Clazz, CodeAttribute, int, int, int)}.
   *
   * <ul>
   *   <li>Given {@link CodeAttribute#CodeAttribute(int)} with u2attributeNameIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link TracedBranchUnit#branchConditionally(Clazz, CodeAttribute, int,
   * int, int)}
   */
  @Test
  @DisplayName(
      "Test branchConditionally(Clazz, CodeAttribute, int, int, int); given CodeAttribute(int) with u2attributeNameIndex is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.TracedBranchUnit.branchConditionally(proguard.classfile.Clazz, proguard.classfile.attribute.CodeAttribute, int, int, int)"
  })
  void testBranchConditionally_givenCodeAttributeWithU2attributeNameIndexIsOne() {
    // Arrange
    TracedBranchUnit tracedBranchUnit = new TracedBranchUnit();
    LibraryClass clazz = new LibraryClass();
    tracedBranchUnit.branch(clazz, new CodeAttribute(1), 2, 1);
    LibraryClass clazz2 = new LibraryClass();

    // Act
    tracedBranchUnit.branchConditionally(clazz2, new CodeAttribute(1), 2, 1, 0);

    // Assert that nothing has changed
    InstructionOffsetValue traceBranchTargets = tracedBranchUnit.getTraceBranchTargets();
    assertFalse(traceBranchTargets.isCategory2());
    assertTrue(tracedBranchUnit.wasCalled());
    assertTrue(traceBranchTargets.isParticular());
    assertTrue(traceBranchTargets.isSpecific());
    assertTrue(tracedBranchUnit.wasCalled);
  }

  /**
   * Test {@link TracedBranchUnit#branchConditionally(Clazz, CodeAttribute, int, int, int)}.
   *
   * <ul>
   *   <li>Then not {@link TracedBranchUnit} (default constructor) TraceBranchTargets Category2.
   * </ul>
   *
   * <p>Method under test: {@link TracedBranchUnit#branchConditionally(Clazz, CodeAttribute, int,
   * int, int)}
   */
  @Test
  @DisplayName(
      "Test branchConditionally(Clazz, CodeAttribute, int, int, int); then not TracedBranchUnit (default constructor) TraceBranchTargets Category2")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.TracedBranchUnit.branchConditionally(proguard.classfile.Clazz, proguard.classfile.attribute.CodeAttribute, int, int, int)"
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
   * Test {@link TracedBranchUnit#branchConditionally(Clazz, CodeAttribute, int, int, int)}.
   *
   * <ul>
   *   <li>When {@link InitializationFinder#NONE}.
   *   <li>Then {@link TracedBranchUnit} (default constructor) wasCalled.
   * </ul>
   *
   * <p>Method under test: {@link TracedBranchUnit#branchConditionally(Clazz, CodeAttribute, int,
   * int, int)}
   */
  @Test
  @DisplayName(
      "Test branchConditionally(Clazz, CodeAttribute, int, int, int); when NONE; then TracedBranchUnit (default constructor) wasCalled")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.TracedBranchUnit.branchConditionally(proguard.classfile.Clazz, proguard.classfile.attribute.CodeAttribute, int, int, int)"
  })
  void testBranchConditionally_whenNone_thenTracedBranchUnitWasCalled() {
    // Arrange
    TracedBranchUnit tracedBranchUnit = new TracedBranchUnit();
    LibraryClass clazz = new LibraryClass();

    // Act
    tracedBranchUnit.branchConditionally(
        clazz, new CodeAttribute(1), 2, 1, InitializationFinder.NONE);

    // Assert
    assertTrue(tracedBranchUnit.wasCalled());
    assertTrue(tracedBranchUnit.wasCalled);
  }

  /**
   * Test new {@link TracedBranchUnit} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TracedBranchUnit}
   */
  @Test
  @DisplayName("Test new TracedBranchUnit (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.evaluation.TracedBranchUnit.<init>()"})
  void testNewTracedBranchUnit() {
    // Arrange, Act and Assert
    assertNull((new TracedBranchUnit()).getTraceBranchTargets());
  }
}
