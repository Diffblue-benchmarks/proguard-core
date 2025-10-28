package proguard.evaluation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.evaluation.value.InstructionOffsetValue;

public class BasicBranchUnitDiffblueTest {
  /**
   * Method under test: {@link BasicBranchUnit#reset()}
   */
  @Test
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
   * Method under test:
   * {@link BasicBranchUnit#branch(Clazz, CodeAttribute, int, int)}
   */
  @Test
  public void testBranch() {
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
   * Method under test:
   * {@link BasicBranchUnit#branch(Clazz, CodeAttribute, int, int)}
   */
  @Test
  public void testBranch2() {
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
   * {@link BasicBranchUnit#branchConditionally(Clazz, CodeAttribute, int, int, int)}
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
   * Method under test: {@link BasicBranchUnit#returnFromMethod()}
   */
  @Test
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
   * Method under test: {@link BasicBranchUnit#throwException()}
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BasicBranchUnit}
   *   <li>{@link BasicBranchUnit#getTraceBranchTargets()}
   *   <li>{@link BasicBranchUnit#wasCalled()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BasicBranchUnit actualBasicBranchUnit = new BasicBranchUnit();
    InstructionOffsetValue actualTraceBranchTargets = actualBasicBranchUnit.getTraceBranchTargets();

    // Assert
    assertNull(actualTraceBranchTargets);
    assertFalse(actualBasicBranchUnit.wasCalled());
  }
}
