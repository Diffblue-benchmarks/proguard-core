package proguard.evaluation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.evaluation.value.InstructionOffsetValue;

public class TracedBranchUnitDiffblueTest {
  /**
   * Method under test: {@link TracedBranchUnit#reset()}
   */
  @Test
  public void testReset() {
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
   * Method under test:
   * {@link TracedBranchUnit#branch(Clazz, CodeAttribute, int, int)}
   */
  @Test
  public void testBranch() {
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
   * Method under test:
   * {@link TracedBranchUnit#branchConditionally(Clazz, CodeAttribute, int, int, int)}
   */
  @Test
  public void testBranchConditionally() {
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
   * Method under test:
   * {@link TracedBranchUnit#branchConditionally(Clazz, CodeAttribute, int, int, int)}
   */
  @Test
  public void testBranchConditionally2() {
    // Arrange
    TracedBranchUnit tracedBranchUnit = new TracedBranchUnit();
    LibraryClass clazz = new LibraryClass();

    // Act
    tracedBranchUnit.branchConditionally(clazz, new CodeAttribute(1), 2, 1, InitializationFinder.NONE);

    // Assert
    assertNull(tracedBranchUnit.getTraceBranchTargets());
    assertTrue(tracedBranchUnit.wasCalled());
    assertTrue(tracedBranchUnit.wasCalled);
  }

  /**
   * Method under test:
   * {@link TracedBranchUnit#branchConditionally(Clazz, CodeAttribute, int, int, int)}
   */
  @Test
  public void testBranchConditionally3() {
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
   * Method under test: default or parameterless constructor of
   * {@link TracedBranchUnit}
   */
  @Test
  public void testNewTracedBranchUnit() {
    // Arrange, Act and Assert
    assertNull((new TracedBranchUnit()).getTraceBranchTargets());
  }
}
