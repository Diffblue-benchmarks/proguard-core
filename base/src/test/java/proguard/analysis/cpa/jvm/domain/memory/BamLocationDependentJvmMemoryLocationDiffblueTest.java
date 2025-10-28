package proguard.analysis.cpa.jvm.domain.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.analysis.cpa.defaults.LatticeAbstractState;
import proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.witness.JvmLocalVariableLocation;
import proguard.analysis.cpa.jvm.witness.JvmMemoryLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;

public class BamLocationDependentJvmMemoryLocationDiffblueTest {
  /**
   * Method under test: {@link BamLocationDependentJvmMemoryLocation#copy()}
   */
  @Test
  public void testCopy() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals(bamLocationDependentJvmMemoryLocation, bamLocationDependentJvmMemoryLocation.copy());
  }

  /**
   * Method under test:
   * {@link BamLocationDependentJvmMemoryLocation#extractFirstValue(LatticeAbstractState)}
   */
  @Test
  public void testExtractFirstValue() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        memoryLocation, JvmUnknownCfaNode.INSTANCE, new ProgramLocationDependentReachedSet<>());

    // Act
    ValueAbstractState actualExtractFirstValueResult = bamLocationDependentJvmMemoryLocation
        .extractFirstValue(ValueAbstractState.UNKNOWN);

    // Assert
    assertSame(actualExtractFirstValueResult.UNKNOWN, actualExtractFirstValueResult);
  }

  /**
   * Method under test:
   * {@link BamLocationDependentJvmMemoryLocation#getProgramLocation()}
   */
  @Test
  public void testGetProgramLocation() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));

    // Act and Assert
    assertNull(bamLocationDependentJvmMemoryLocation.getProgramLocation());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation2 = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals(bamLocationDependentJvmMemoryLocation, bamLocationDependentJvmMemoryLocation2);
    int expectedHashCodeResult = bamLocationDependentJvmMemoryLocation.hashCode();
    assertEquals(expectedHashCodeResult, bamLocationDependentJvmMemoryLocation2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals(bamLocationDependentJvmMemoryLocation, bamLocationDependentJvmMemoryLocation);
    int expectedHashCodeResult = bamLocationDependentJvmMemoryLocation.hashCode();
    assertEquals(expectedHashCodeResult, bamLocationDependentJvmMemoryLocation.hashCode());
  }

  /**
   * Method under test: {@link BamLocationDependentJvmMemoryLocation#toString()}
   */
  @Test
  public void testToString() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));

    // Act and Assert
    assertEquals("JvmLocalVariableLocation(1)", bamLocationDependentJvmMemoryLocation.toString());
  }

  /**
   * Method under test: {@link BamLocationDependentJvmMemoryLocation#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));
    bamLocationDependentJvmMemoryLocation.setProgramLocation(
        new JvmCatchCfaNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new LibraryClass()));

    // Act and Assert
    assertEquals("JvmLocalVariableLocation(1)@Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang"
        + "/Class;:2", bamLocationDependentJvmMemoryLocation.toString());
  }

  /**
   * Method under test:
   * {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(0));

    // Act and Assert
    assertNotEquals(bamLocationDependentJvmMemoryLocation,
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
  }

  /**
   * Method under test:
   * {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        memoryLocation, JvmUnknownCfaNode.INSTANCE, new ProgramLocationDependentReachedSet<>());

    // Act and Assert
    assertNotEquals(bamLocationDependentJvmMemoryLocation,
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
  }

  /**
   * Method under test:
   * {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));
    bamLocationDependentJvmMemoryLocation.setProgramLocation(JvmUnknownCfaNode.INSTANCE);

    // Act and Assert
    assertNotEquals(bamLocationDependentJvmMemoryLocation,
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
  }

  /**
   * Method under test:
   * {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));

    // Act and Assert
    assertNotEquals(bamLocationDependentJvmMemoryLocation, null);
  }

  /**
   * Method under test:
   * {@link BamLocationDependentJvmMemoryLocation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> bamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));

    // Act and Assert
    assertNotEquals(bamLocationDependentJvmMemoryLocation, "Different type to BamLocationDependentJvmMemoryLocation");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BamLocationDependentJvmMemoryLocation#BamLocationDependentJvmMemoryLocation(JvmMemoryLocation)}
   *   <li>
   * {@link BamLocationDependentJvmMemoryLocation#setProgramLocation(JvmCfaNode)}
   *   <li>
   * {@link BamLocationDependentJvmMemoryLocation#setSourceReachedSet(ProgramLocationDependentReachedSet)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getMemoryLocation()}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getSourceReachedSet()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    // Act
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> actualBamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        memoryLocation);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    actualBamLocationDependentJvmMemoryLocation.setProgramLocation(programLocation);
    ProgramLocationDependentReachedSet<JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature> sourceReachedSet = new ProgramLocationDependentReachedSet<>();
    actualBamLocationDependentJvmMemoryLocation.setSourceReachedSet(sourceReachedSet);
    JvmMemoryLocation actualMemoryLocation = actualBamLocationDependentJvmMemoryLocation.getMemoryLocation();

    // Assert that nothing has changed
    assertTrue(actualMemoryLocation instanceof JvmLocalVariableLocation);
    assertEquals(1, ((JvmLocalVariableLocation) actualMemoryLocation).index);
    assertSame(sourceReachedSet, actualBamLocationDependentJvmMemoryLocation.getSourceReachedSet());
    assertSame(memoryLocation, actualMemoryLocation);
    JvmUnknownCfaNode expectedProgramLocation = programLocation.INSTANCE;
    assertSame(expectedProgramLocation, actualBamLocationDependentJvmMemoryLocation.getProgramLocation());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BamLocationDependentJvmMemoryLocation#BamLocationDependentJvmMemoryLocation(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet)}
   *   <li>
   * {@link BamLocationDependentJvmMemoryLocation#setProgramLocation(JvmCfaNode)}
   *   <li>
   * {@link BamLocationDependentJvmMemoryLocation#setSourceReachedSet(ProgramLocationDependentReachedSet)}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getMemoryLocation()}
   *   <li>{@link BamLocationDependentJvmMemoryLocation#getSourceReachedSet()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    // Act
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> actualBamLocationDependentJvmMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        memoryLocation, JvmUnknownCfaNode.INSTANCE, new ProgramLocationDependentReachedSet<>());
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    actualBamLocationDependentJvmMemoryLocation.setProgramLocation(programLocation);
    ProgramLocationDependentReachedSet<JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature> sourceReachedSet = new ProgramLocationDependentReachedSet<>();
    actualBamLocationDependentJvmMemoryLocation.setSourceReachedSet(sourceReachedSet);
    JvmMemoryLocation actualMemoryLocation = actualBamLocationDependentJvmMemoryLocation.getMemoryLocation();

    // Assert that nothing has changed
    assertTrue(actualMemoryLocation instanceof JvmLocalVariableLocation);
    assertEquals(1, ((JvmLocalVariableLocation) actualMemoryLocation).index);
    assertSame(sourceReachedSet, actualBamLocationDependentJvmMemoryLocation.getSourceReachedSet());
    assertSame(memoryLocation, actualMemoryLocation);
    JvmUnknownCfaNode expectedProgramLocation = programLocation.INSTANCE;
    assertSame(expectedProgramLocation, actualBamLocationDependentJvmMemoryLocation.getProgramLocation());
  }
}
