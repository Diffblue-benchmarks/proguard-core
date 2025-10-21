package proguard.evaluation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.evaluation.value.InstructionOffsetValue;

public class TracedBranchUnitDiffblueTest {
  /**
   * Test {@link TracedBranchUnit#reset()}.
   *
   * <p>Method under test: {@link TracedBranchUnit#reset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedBranchUnit.reset()"})
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
   * Test {@link TracedBranchUnit#branch(Clazz, CodeAttribute, int, int)}.
   *
   * <p>Method under test: {@link TracedBranchUnit#branch(Clazz, CodeAttribute, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedBranchUnit.branch(Clazz, CodeAttribute, int, int)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TracedBranchUnit.branchConditionally(Clazz, CodeAttribute, int, int, int)"
  })
  public void testBranchConditionally_givenCodeAttributeWithU2attributeNameIndexIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TracedBranchUnit.branchConditionally(Clazz, CodeAttribute, int, int, int)"
  })
  public void testBranchConditionally_thenNotTracedBranchUnitTraceBranchTargetsCategory2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TracedBranchUnit.branchConditionally(Clazz, CodeAttribute, int, int, int)"
  })
  public void testBranchConditionally_whenNone_thenTracedBranchUnitWasCalled() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TracedBranchUnit.<init>()"})
  public void testNewTracedBranchUnit() {
    // Arrange, Act and Assert
    assertNull((new TracedBranchUnit()).getTraceBranchTargets());
  }
}
