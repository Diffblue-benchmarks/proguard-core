package proguard.analysis.cpa.jvm.domain.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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

class JvmMemoryLocationAbstractStateDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.<init>(proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation)",
    "proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.getLocationDependentMemoryLocation()",
    "java.util.Set proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.getSourceLocations()"
  })
  void testGettersAndSetters() {
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
  @DisplayName(
      "Test new JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet)"
  })
  void testNewJvmMemoryLocationAbstractState() {
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
  @DisplayName(
      "Test new JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, LinkedList)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet, java.util.LinkedList)"
  })
  void testNewJvmMemoryLocationAbstractState2() {
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
  @DisplayName(
      "Test new JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet, java.util.Set)"
  })
  void testNewJvmMemoryLocationAbstractState3() {
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
  @DisplayName(
      "Test new JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set, LinkedList)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet, java.util.Set, java.util.LinkedList)"
  })
  void testNewJvmMemoryLocationAbstractState4() {
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
  @DisplayName(
      "Test new JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set); then return SourceLocations is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet, java.util.Set)"
  })
  void testNewJvmMemoryLocationAbstractState_thenReturnSourceLocationsIsHashSet() {
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
  @DisplayName(
      "Test new JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set, LinkedList); then return SourceLocations is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet, java.util.Set, java.util.LinkedList)"
  })
  void testNewJvmMemoryLocationAbstractState_thenReturnSourceLocationsIsHashSet2() {
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
  @DisplayName(
      "Test new JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set); when HashSet(); then return SourceLocations Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet, java.util.Set)"
  })
  void testNewJvmMemoryLocationAbstractState_whenHashSet_thenReturnSourceLocationsEmpty() {
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
  @DisplayName(
      "Test new JvmMemoryLocationAbstractState(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set, LinkedList); when HashSet(); then return SourceLocations Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.<init>(proguard.analysis.cpa.jvm.witness.JvmMemoryLocation, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet, java.util.Set, java.util.LinkedList)"
  })
  void testNewJvmMemoryLocationAbstractState_whenHashSet_thenReturnSourceLocationsEmpty2() {
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
  @DisplayName("Test peekCallStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState$StackEntry proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.peekCallStack()"
  })
  void testPeekCallStack() {
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
  @DisplayName("Test callStackContains(MethodSignature)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.callStackContains(proguard.classfile.MethodSignature)"
  })
  void testCallStackContains() {
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
  @DisplayName("Test copyStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.LinkedList proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.copyStack()"
  })
  void testCopyStack() {
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
  @DisplayName(
      "Test join(JvmMemoryLocationAbstractState) with 'JvmMemoryLocationAbstractState'; then return top")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.join(proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState)"
  })
  void testJoinWithJvmMemoryLocationAbstractState_thenReturnTop() {
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
  @DisplayName(
      "Test isLessOrEqual(JvmMemoryLocationAbstractState) with 'JvmMemoryLocationAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState() {
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
  @DisplayName(
      "Test isLessOrEqual(JvmMemoryLocationAbstractState) with 'JvmMemoryLocationAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState2() {
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
  @DisplayName(
      "Test isLessOrEqual(JvmMemoryLocationAbstractState) with 'JvmMemoryLocationAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState3() {
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
  @DisplayName(
      "Test isLessOrEqual(JvmMemoryLocationAbstractState) with 'JvmMemoryLocationAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState4() {
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
  @DisplayName(
      "Test isLessOrEqual(JvmMemoryLocationAbstractState) with 'JvmMemoryLocationAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState5() {
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
  @DisplayName(
      "Test isLessOrEqual(JvmMemoryLocationAbstractState) with 'JvmMemoryLocationAbstractState'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState6() {
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
  @DisplayName(
      "Test isLessOrEqual(JvmMemoryLocationAbstractState) with 'JvmMemoryLocationAbstractState'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.isLessOrEqual(proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState_thenReturnTrue() {
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
  @DisplayName("Test getProgramLocation(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.getProgramLocation()"
  })
  void testGetProgramLocation_thenReturnNull() {
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
  @DisplayName("Test setProgramLocation(JvmCfaNode) with 'JvmCfaNode'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.setProgramLocation(proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode)"
  })
  void testSetProgramLocationWithJvmCfaNode() {
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
  @DisplayName("Test getSourceReachedSet(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.getSourceReachedSet()"
  })
  void testGetSourceReachedSet_thenReturnNull() {
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
  @DisplayName("Test setSourceReachedSet(ProgramLocationDependentReachedSet)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.setSourceReachedSet(proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet)"
  })
  void testSetSourceReachedSet() {
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
  @DisplayName("Test addSourceLocation(BamLocationDependentJvmMemoryLocation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.addSourceLocation(proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation)"
  })
  void testAddSourceLocation() {
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
  @DisplayName("Test addSourceLocation(BamLocationDependentJvmMemoryLocation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.addSourceLocation(proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation)"
  })
  void testAddSourceLocation2() {
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
  @DisplayName("Test addSourceLocation(BamLocationDependentJvmMemoryLocation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.addSourceLocation(proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation)"
  })
  void testAddSourceLocation3() {
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
  @DisplayName("Test addSourceLocation(BamLocationDependentJvmMemoryLocation); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.addSourceLocation(proguard.analysis.cpa.jvm.domain.memory.BamLocationDependentJvmMemoryLocation)"
  })
  void testAddSourceLocation_whenNull() {
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
  @DisplayName("Test copy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.copy()"
  })
  void testCopy() {
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
  @DisplayName("Test copy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.copy()"
  })
  void testCopy2() {
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
  @DisplayName("Test copy(); given JvmLocalVariableLocation(int) with index is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.copy()"
  })
  void testCopy_givenJvmLocalVariableLocationWithIndexIsMinusOne() {
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
  @DisplayName("Test copy(); given JvmStackLocation(int) with index is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.copy()"
  })
  void testCopy_givenJvmStackLocationWithIndexIsOne() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.equals(java.lang.Object)",
    "int proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act and Assert
    assertNotEquals(
        jvmMemoryLocationAbstractState, "Different type to JvmMemoryLocationAbstractState");
  }
}
