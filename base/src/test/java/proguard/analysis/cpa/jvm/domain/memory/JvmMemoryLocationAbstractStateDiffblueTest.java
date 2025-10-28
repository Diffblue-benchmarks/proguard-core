package proguard.analysis.cpa.jvm.domain.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState;
import proguard.analysis.cpa.jvm.witness.JvmLocalVariableLocation;
import proguard.analysis.cpa.jvm.witness.JvmStackLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.MethodSignature;

public class JvmMemoryLocationAbstractStateDiffblueTest {
  /**
   * Method under test: {@link JvmMemoryLocationAbstractState#peekCallStack()}
   */
  @Test
  public void testPeekCallStack() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNull(jvmMemoryLocationAbstractState.peekCallStack());
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}
   */
  @Test
  public void testCallStackContains() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.callStackContains(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Method under test: {@link JvmMemoryLocationAbstractState#copyStack()}
   */
  @Test
  public void testCopyStack() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertTrue(jvmMemoryLocationAbstractState.copyStack().isEmpty());
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#join(JvmMemoryLocationAbstractState)}
   */
  @Test
  public void testJoin() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    JvmMemoryLocationAbstractState actualJoinResult = jvmMemoryLocationAbstractState
        .join(JvmMemoryLocationAbstractState.top);

    // Assert
    assertSame(actualJoinResult.top, actualJoinResult);
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  public void testIsLessOrEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertTrue(jvmMemoryLocationAbstractState.isLessOrEqual(new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)))));
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  public void testIsLessOrEqual2() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(0)));

    // Act and Assert
    assertFalse(jvmMemoryLocationAbstractState.isLessOrEqual(new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)))));
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  public void testIsLessOrEqual3() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(memoryLocation, JvmUnknownCfaNode.INSTANCE,
            new ProgramLocationDependentReachedSet<>()));

    // Act and Assert
    assertFalse(jvmMemoryLocationAbstractState.isLessOrEqual(new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)))));
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  public void testIsLessOrEqual4() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertFalse(jvmMemoryLocationAbstractState.isLessOrEqual(new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)))));
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  public void testIsLessOrEqual5() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState.setProgramLocation(JvmUnknownCfaNode.INSTANCE);
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertFalse(jvmMemoryLocationAbstractState.isLessOrEqual(new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)))));
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  public void testIsLessOrEqual6() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertFalse(jvmMemoryLocationAbstractState.isLessOrEqual(new JvmMemoryLocationAbstractState<>(null)));
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  public void testIsLessOrEqual7() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> abstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    abstractState.addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertTrue(jvmMemoryLocationAbstractState.isLessOrEqual(abstractState));
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#getProgramLocation()}
   */
  @Test
  public void testGetProgramLocation() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNull(jvmMemoryLocationAbstractState.getProgramLocation());
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#setProgramLocation(JvmCfaNode)}
   */
  @Test
  public void testSetProgramLocation() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        locationDependentMemoryLocation);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;

    // Act
    jvmMemoryLocationAbstractState.setProgramLocation(programLocation);

    // Assert
    assertSame(locationDependentMemoryLocation, jvmMemoryLocationAbstractState.getLocationDependentMemoryLocation());
    JvmUnknownCfaNode expectedProgramLocation = programLocation.INSTANCE;
    assertSame(expectedProgramLocation, jvmMemoryLocationAbstractState.getProgramLocation());
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#getSourceReachedSet()}
   */
  @Test
  public void testGetSourceReachedSet() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNull(jvmMemoryLocationAbstractState.getSourceReachedSet());
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#setSourceReachedSet(ProgramLocationDependentReachedSet)}
   */
  @Test
  public void testSetSourceReachedSet() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        locationDependentMemoryLocation);
    ProgramLocationDependentReachedSet<JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature> sourceReachedSet = new ProgramLocationDependentReachedSet<>();

    // Act
    jvmMemoryLocationAbstractState.setSourceReachedSet(sourceReachedSet);

    // Assert
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation2 = jvmMemoryLocationAbstractState
        .getLocationDependentMemoryLocation();
    assertSame(sourceReachedSet, locationDependentMemoryLocation2.getSourceReachedSet());
    assertSame(sourceReachedSet, jvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(locationDependentMemoryLocation, locationDependentMemoryLocation2);
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}
   */
  @Test
  public void testAddSourceLocation() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Assert
    assertEquals(1, jvmMemoryLocationAbstractState.getSourceLocations().size());
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}
   */
  @Test
  public void testAddSourceLocation2() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Assert
    assertEquals(1, jvmMemoryLocationAbstractState.getSourceLocations().size());
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}
   */
  @Test
  public void testAddSourceLocation3() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    jvmMemoryLocationAbstractState.addSourceLocation(null);

    // Assert
    assertEquals(1, jvmMemoryLocationAbstractState.getSourceLocations().size());
  }

  /**
   * Method under test:
   * {@link JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}
   */
  @Test
  public void testAddSourceLocation4() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmStackLocation(1)));

    // Act
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Assert
    assertEquals(2, jvmMemoryLocationAbstractState.getSourceLocations().size());
  }

  /**
   * Method under test: {@link JvmMemoryLocationAbstractState#copy()}
   */
  @Test
  public void testCopy() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState.copy());
  }

  /**
   * Method under test: {@link JvmMemoryLocationAbstractState#copy()}
   */
  @Test
  public void testCopy2() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState.copy());
  }

  /**
   * Method under test: {@link JvmMemoryLocationAbstractState#copy()}
   */
  @Test
  public void testCopy3() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(-1)));
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState.copy());
  }

  /**
   * Method under test: {@link JvmMemoryLocationAbstractState#copy()}
   */
  @Test
  public void testCopy4() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmStackLocation(1)));
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState.copy());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmMemoryLocationAbstractState#equals(Object)}
   *   <li>{@link JvmMemoryLocationAbstractState#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState2 = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState2);
    int expectedHashCodeResult = jvmMemoryLocationAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, jvmMemoryLocationAbstractState2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmMemoryLocationAbstractState#equals(Object)}
   *   <li>{@link JvmMemoryLocationAbstractState#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState);
    int expectedHashCodeResult = jvmMemoryLocationAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, jvmMemoryLocationAbstractState.hashCode());
  }

  /**
   * Method under test: {@link JvmMemoryLocationAbstractState#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(0)));

    // Act and Assert
    assertNotEquals(jvmMemoryLocationAbstractState, new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1))));
  }

  /**
   * Method under test: {@link JvmMemoryLocationAbstractState#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState
        .addSourceLocation(new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNotEquals(jvmMemoryLocationAbstractState, new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1))));
  }

  /**
   * Method under test: {@link JvmMemoryLocationAbstractState#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNotEquals(jvmMemoryLocationAbstractState, null);
  }

  /**
   * Method under test: {@link JvmMemoryLocationAbstractState#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNotEquals(jvmMemoryLocationAbstractState, "Different type to JvmMemoryLocationAbstractState");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(BamLocationDependentJvmMemoryLocation)}
   *   <li>
   * {@link JvmMemoryLocationAbstractState#getLocationDependentMemoryLocation()}
   *   <li>{@link JvmMemoryLocationAbstractState#getSourceLocations()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation = new BamLocationDependentJvmMemoryLocation<>(
        new JvmLocalVariableLocation(1));

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState = new JvmMemoryLocationAbstractState<>(
        locationDependentMemoryLocation);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> actualLocationDependentMemoryLocation = actualJvmMemoryLocationAbstractState
        .getLocationDependentMemoryLocation();

    // Assert
    assertTrue(actualJvmMemoryLocationAbstractState.getSourceLocations().isEmpty());
    assertSame(locationDependentMemoryLocation, actualLocationDependentMemoryLocation);
  }
}
