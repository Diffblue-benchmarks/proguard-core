package proguard.analysis.cpa.jvm.domain.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState;
import proguard.analysis.cpa.jvm.witness.JvmLocalVariableLocation;
import proguard.analysis.cpa.jvm.witness.JvmMemoryLocation;
import proguard.analysis.cpa.jvm.witness.JvmStackLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.MethodSignature;

public class JvmMemoryLocationAbstractStateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(BamLocationDependentJvmMemoryLocation)}
   *   <li>{@link JvmMemoryLocationAbstractState#getLocationDependentMemoryLocation()}
   *   <li>{@link JvmMemoryLocationAbstractState#getSourceLocations()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(BamLocationDependentJvmMemoryLocation)",
    "BamLocationDependentJvmMemoryLocation JvmMemoryLocationAbstractState.getLocationDependentMemoryLocation()",
    "Set JvmMemoryLocationAbstractState.getSourceLocations()"
  })
  public void testGettersAndSetters() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>
        actualLocationDependentMemoryLocation =
            actualJvmMemoryLocationAbstractState.getLocationDependentMemoryLocation();

    // Assert
    assertTrue(actualJvmMemoryLocationAbstractState.getSourceLocations().isEmpty());
    assertSame(locationDependentMemoryLocation, actualLocationDependentMemoryLocation);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation,
   * JvmCfaNode, ProgramLocationDependentReachedSet)}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode,
   * ProgramLocationDependentReachedSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet)"
  })
  public void testNewJvmMemoryLocationAbstractState() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(memoryLocation, programLocation, sourceReachedSet);

    // Assert
    JvmCfaNode programLocation2 = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation2 instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertTrue(actualJvmMemoryLocationAbstractState.getSourceLocations().isEmpty());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(programLocation.INSTANCE, programLocation2);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation,
   * JvmCfaNode, ProgramLocationDependentReachedSet, LinkedList)}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode,
   * ProgramLocationDependentReachedSet, LinkedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, LinkedList)"
  })
  public void testNewJvmMemoryLocationAbstractState2() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation, programLocation, sourceReachedSet, new LinkedList<>());

    // Assert
    JvmCfaNode programLocation2 = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation2 instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertTrue(actualJvmMemoryLocationAbstractState.getSourceLocations().isEmpty());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(programLocation.INSTANCE, programLocation2);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation,
   * JvmCfaNode, ProgramLocationDependentReachedSet, Set)}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode,
   * ProgramLocationDependentReachedSet, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set)"
  })
  public void testNewJvmMemoryLocationAbstractState3() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();

    HashSet<BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>> sourceLocations =
        new HashSet<>();
    sourceLocations.add(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(-1)));
    sourceLocations.add(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation, programLocation, sourceReachedSet, sourceLocations);

    // Assert
    JvmCfaNode programLocation2 = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation2 instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertSame(sourceLocations, actualJvmMemoryLocationAbstractState.getSourceLocations());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(programLocation.INSTANCE, programLocation2);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation,
   * JvmCfaNode, ProgramLocationDependentReachedSet, Set, LinkedList)}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode,
   * ProgramLocationDependentReachedSet, Set, LinkedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set, LinkedList)"
  })
  public void testNewJvmMemoryLocationAbstractState4() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();

    HashSet<BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>> sourceLocations =
        new HashSet<>();
    sourceLocations.add(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(-1)));
    sourceLocations.add(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation, programLocation, sourceReachedSet, sourceLocations, new LinkedList<>());

    // Assert
    JvmCfaNode programLocation2 = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation2 instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertSame(sourceLocations, actualJvmMemoryLocationAbstractState.getSourceLocations());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(programLocation.INSTANCE, programLocation2);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation,
   * JvmCfaNode, ProgramLocationDependentReachedSet, Set)}.
   *
   * <ul>
   *   <li>Then return SourceLocations is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode,
   * ProgramLocationDependentReachedSet, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set)"
  })
  public void testNewJvmMemoryLocationAbstractState_thenReturnSourceLocationsIsHashSet() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();

    HashSet<BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>> sourceLocations =
        new HashSet<>();
    sourceLocations.add(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation, programLocation, sourceReachedSet, sourceLocations);

    // Assert
    JvmCfaNode programLocation2 = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation2 instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertSame(sourceLocations, actualJvmMemoryLocationAbstractState.getSourceLocations());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(programLocation.INSTANCE, programLocation2);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation,
   * JvmCfaNode, ProgramLocationDependentReachedSet, Set, LinkedList)}.
   *
   * <ul>
   *   <li>Then return SourceLocations is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode,
   * ProgramLocationDependentReachedSet, Set, LinkedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set, LinkedList)"
  })
  public void testNewJvmMemoryLocationAbstractState_thenReturnSourceLocationsIsHashSet2() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();

    HashSet<BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>> sourceLocations =
        new HashSet<>();
    sourceLocations.add(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation, programLocation, sourceReachedSet, sourceLocations, new LinkedList<>());

    // Assert
    JvmCfaNode programLocation2 = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation2 instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertSame(sourceLocations, actualJvmMemoryLocationAbstractState.getSourceLocations());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(programLocation.INSTANCE, programLocation2);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation,
   * JvmCfaNode, ProgramLocationDependentReachedSet, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return SourceLocations Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode,
   * ProgramLocationDependentReachedSet, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set)"
  })
  public void testNewJvmMemoryLocationAbstractState_whenHashSet_thenReturnSourceLocationsEmpty() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation, programLocation, sourceReachedSet, new HashSet<>());

    // Assert
    JvmCfaNode programLocation2 = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation2 instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertTrue(actualJvmMemoryLocationAbstractState.getSourceLocations().isEmpty());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(programLocation.INSTANCE, programLocation2);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation,
   * JvmCfaNode, ProgramLocationDependentReachedSet, Set, LinkedList)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return SourceLocations Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode,
   * ProgramLocationDependentReachedSet, Set, LinkedList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set, LinkedList)"
  })
  public void testNewJvmMemoryLocationAbstractState_whenHashSet_thenReturnSourceLocationsEmpty2() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();
    HashSet<BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState>> sourceLocations =
        new HashSet<>();

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation, programLocation, sourceReachedSet, sourceLocations, new LinkedList<>());

    // Assert
    JvmCfaNode programLocation2 = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation2 instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertTrue(actualJvmMemoryLocationAbstractState.getSourceLocations().isEmpty());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(programLocation.INSTANCE, programLocation2);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#peekCallStack()}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#peekCallStack()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "JvmMemoryLocationAbstractState.StackEntry JvmMemoryLocationAbstractState.peekCallStack()"
  })
  public void testPeekCallStack() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNull(jvmMemoryLocationAbstractState.peekCallStack());
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmMemoryLocationAbstractState.callStackContains(MethodSignature)"})
  public void testCallStackContains() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.callStackContains(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#copyStack()}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#copyStack()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LinkedList JvmMemoryLocationAbstractState.copyStack()"})
  public void testCopyStack() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertTrue(jvmMemoryLocationAbstractState.copyStack().isEmpty());
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#join(JvmMemoryLocationAbstractState)} with {@code
   * JvmMemoryLocationAbstractState}.
   *
   * <ul>
   *   <li>Then return {@link JvmMemoryLocationAbstractState#top}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#join(JvmMemoryLocationAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "JvmMemoryLocationAbstractState JvmMemoryLocationAbstractState.join(JvmMemoryLocationAbstractState)"
  })
  public void testJoinWithJvmMemoryLocationAbstractState_thenReturnTop() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    JvmMemoryLocationAbstractState actualJoinResult =
        jvmMemoryLocationAbstractState.join(JvmMemoryLocationAbstractState.top);

    // Assert
    assertSame(actualJoinResult.top, actualJoinResult);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)} with
   * {@code JvmMemoryLocationAbstractState}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  public void testIsLessOrEqualWithJvmMemoryLocationAbstractState() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(0)));

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.isLessOrEqual(
            new JvmMemoryLocationAbstractState<>(
                new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)))));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)} with
   * {@code JvmMemoryLocationAbstractState}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  public void testIsLessOrEqualWithJvmMemoryLocationAbstractState2() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(
                memoryLocation,
                JvmUnknownCfaNode.INSTANCE,
                new ProgramLocationDependentReachedSet<>()));

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.isLessOrEqual(
            new JvmMemoryLocationAbstractState<>(
                new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)))));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)} with
   * {@code JvmMemoryLocationAbstractState}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  public void testIsLessOrEqualWithJvmMemoryLocationAbstractState3() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.isLessOrEqual(
            new JvmMemoryLocationAbstractState<>(
                new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)))));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)} with
   * {@code JvmMemoryLocationAbstractState}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  public void testIsLessOrEqualWithJvmMemoryLocationAbstractState4() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState.setProgramLocation(JvmUnknownCfaNode.INSTANCE);
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.isLessOrEqual(
            new JvmMemoryLocationAbstractState<>(
                new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)))));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)} with
   * {@code JvmMemoryLocationAbstractState}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  public void testIsLessOrEqualWithJvmMemoryLocationAbstractState5() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.isLessOrEqual(new JvmMemoryLocationAbstractState<>(null)));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)} with
   * {@code JvmMemoryLocationAbstractState}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  public void testIsLessOrEqualWithJvmMemoryLocationAbstractState6() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> abstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    abstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertTrue(jvmMemoryLocationAbstractState.isLessOrEqual(abstractState));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)} with
   * {@code JvmMemoryLocationAbstractState}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  public void testIsLessOrEqualWithJvmMemoryLocationAbstractState_thenReturnTrue() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertTrue(
        jvmMemoryLocationAbstractState.isLessOrEqual(
            new JvmMemoryLocationAbstractState<>(
                new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)))));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#getProgramLocation()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#getProgramLocation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfaNode JvmMemoryLocationAbstractState.getProgramLocation()"})
  public void testGetProgramLocation_thenReturnNull() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNull(jvmMemoryLocationAbstractState.getProgramLocation());
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#setProgramLocation(JvmCfaNode)} with {@code
   * JvmCfaNode}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#setProgramLocation(JvmCfaNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmMemoryLocationAbstractState.setProgramLocation(JvmCfaNode)"})
  public void testSetProgramLocationWithJvmCfaNode() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    JvmUnknownCfaNode programLocation = JvmUnknownCfaNode.INSTANCE;

    // Act
    jvmMemoryLocationAbstractState.setProgramLocation(programLocation);

    // Assert
    JvmUnknownCfaNode jvmUnknownCfaNode = programLocation.INSTANCE;
    assertSame(
        jvmUnknownCfaNode,
        jvmMemoryLocationAbstractState.getLocationDependentMemoryLocation().getProgramLocation());
    assertSame(jvmUnknownCfaNode, jvmMemoryLocationAbstractState.getProgramLocation());
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#getSourceReachedSet()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#getSourceReachedSet()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ProgramLocationDependentReachedSet JvmMemoryLocationAbstractState.getSourceReachedSet()"
  })
  public void testGetSourceReachedSet_thenReturnNull() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNull(jvmMemoryLocationAbstractState.getSourceReachedSet());
  }

  /**
   * Test {@link
   * JvmMemoryLocationAbstractState#setSourceReachedSet(ProgramLocationDependentReachedSet)}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#setSourceReachedSet(ProgramLocationDependentReachedSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.setSourceReachedSet(ProgramLocationDependentReachedSet)"
  })
  public void testSetSourceReachedSet() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();

    // Act
    jvmMemoryLocationAbstractState.setSourceReachedSet(sourceReachedSet);

    // Assert
    assertSame(
        sourceReachedSet,
        jvmMemoryLocationAbstractState.getLocationDependentMemoryLocation().getSourceReachedSet());
    assertSame(sourceReachedSet, jvmMemoryLocationAbstractState.getSourceReachedSet());
  }

  /**
   * Test {@link
   * JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.addSourceLocation(BamLocationDependentJvmMemoryLocation)"
  })
  public void testAddSourceLocation() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Assert
    assertEquals(1, jvmMemoryLocationAbstractState.getSourceLocations().size());
  }

  /**
   * Test {@link
   * JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.addSourceLocation(BamLocationDependentJvmMemoryLocation)"
  })
  public void testAddSourceLocation2() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Assert that nothing has changed
    assertEquals(1, jvmMemoryLocationAbstractState.getSourceLocations().size());
  }

  /**
   * Test {@link
   * JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}.
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.addSourceLocation(BamLocationDependentJvmMemoryLocation)"
  })
  public void testAddSourceLocation3() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmStackLocation(1)));

    // Act
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Assert
    assertEquals(2, jvmMemoryLocationAbstractState.getSourceLocations().size());
  }

  /**
   * Test {@link
   * JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#addSourceLocation(BamLocationDependentJvmMemoryLocation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.addSourceLocation(BamLocationDependentJvmMemoryLocation)"
  })
  public void testAddSourceLocation_whenNull() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    jvmMemoryLocationAbstractState.addSourceLocation(null);

    // Assert
    assertEquals(1, jvmMemoryLocationAbstractState.getSourceLocations().size());
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#copy()}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmMemoryLocationAbstractState JvmMemoryLocationAbstractState.copy()"})
  public void testCopy() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState.copy());
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#copy()}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmMemoryLocationAbstractState JvmMemoryLocationAbstractState.copy()"})
  public void testCopy2() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState.copy());
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#copy()}.
   *
   * <ul>
   *   <li>Given {@link JvmLocalVariableLocation#JvmLocalVariableLocation(int)} with index is minus
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmMemoryLocationAbstractState JvmMemoryLocationAbstractState.copy()"})
  public void testCopy_givenJvmLocalVariableLocationWithIndexIsMinusOne() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(-1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState.copy());
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#copy()}.
   *
   * <ul>
   *   <li>Given {@link JvmStackLocation#JvmStackLocation(int)} with index is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#copy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmMemoryLocationAbstractState JvmMemoryLocationAbstractState.copy()"})
  public void testCopy_givenJvmStackLocationWithIndexIsOne() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmStackLocation(1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState.copy());
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#equals(Object)}, and {@link
   * JvmMemoryLocationAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmMemoryLocationAbstractState#equals(Object)}
   *   <li>{@link JvmMemoryLocationAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState2 =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState2);
    int expectedHashCodeResult = jvmMemoryLocationAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, jvmMemoryLocationAbstractState2.hashCode());
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#equals(Object)}, and {@link
   * JvmMemoryLocationAbstractState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmMemoryLocationAbstractState#equals(Object)}
   *   <li>{@link JvmMemoryLocationAbstractState#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState);
    int expectedHashCodeResult = jvmMemoryLocationAbstractState.hashCode();
    assertEquals(expectedHashCodeResult, jvmMemoryLocationAbstractState.hashCode());
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(0)));

    // Act and Assert
    assertNotEquals(
        jvmMemoryLocationAbstractState,
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1))));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNotEquals(
        jvmMemoryLocationAbstractState,
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1))));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNotEquals(jvmMemoryLocationAbstractState, null);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNotEquals(
        jvmMemoryLocationAbstractState, "Different type to JvmMemoryLocationAbstractState");
  }
}
