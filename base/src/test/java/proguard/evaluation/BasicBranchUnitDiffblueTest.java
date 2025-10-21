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

public class BasicBranchUnitDiffblueTest {
  /**
   * Test {@link BasicBranchUnit#reset()}.
   *
   * <p>Method under test: {@link BasicBranchUnit#reset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicBranchUnit.reset()"})
  public void testReset() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicBranchUnit.branch(Clazz, CodeAttribute, int, int)"})
  public void testBranch_thenNotBasicBranchUnitTraceBranchTargetsCategory2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicBranchUnit.branch(Clazz, CodeAttribute, int, int)"})
  public void testBranch_thenNotTracedBranchUnitTraceBranchTargetsCategory2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BasicBranchUnit.branchConditionally(Clazz, CodeAttribute, int, int, int)"
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
   * Test {@link BasicBranchUnit#returnFromMethod()}.
   *
   * <p>Method under test: {@link BasicBranchUnit#returnFromMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicBranchUnit.returnFromMethod()"})
  public void testReturnFromMethod() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BasicBranchUnit.throwException()"})
  public void testThrowException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BasicBranchUnit.<init>()",
    "InstructionOffsetValue BasicBranchUnit.getTraceBranchTargets()",
    "boolean BasicBranchUnit.wasCalled()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BasicBranchUnit actualBasicBranchUnit = new BasicBranchUnit();
    InstructionOffsetValue actualTraceBranchTargets = actualBasicBranchUnit.getTraceBranchTargets();

    // Assert
    assertNull(actualTraceBranchTargets);
    assertFalse(actualBasicBranchUnit.wasCalled());
  }
}
