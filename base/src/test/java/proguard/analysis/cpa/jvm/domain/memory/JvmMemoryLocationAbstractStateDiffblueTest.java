package proguard.analysis.cpa.jvm.domain.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.ProgramLocationDependentReachedSet;
import proguard.analysis.cpa.interfaces.AbstractState;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState.StackEntry;
import proguard.analysis.cpa.jvm.domain.taint.JvmTaintAbstractState;
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.analysis.cpa.jvm.witness.JvmLocalVariableLocation;
import proguard.analysis.cpa.jvm.witness.JvmMemoryLocation;
import proguard.analysis.cpa.jvm.witness.JvmStackLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.MethodDescriptor;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(BamLocationDependentJvmMemoryLocation)",
    "BamLocationDependentJvmMemoryLocation JvmMemoryLocationAbstractState.getLocationDependentMemoryLocation()",
    "Set JvmMemoryLocationAbstractState.getSourceLocations()"
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet)"
  })
  void testNewJvmMemoryLocationAbstractState() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation, JvmUnknownCfaNode.INSTANCE, sourceReachedSet);

    // Assert
    JvmCfaNode programLocation = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertTrue(actualJvmMemoryLocationAbstractState.getSourceLocations().isEmpty());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(JvmUnknownCfaNode.INSTANCE, programLocation);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set)"
  })
  void testNewJvmMemoryLocationAbstractState2() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
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
            memoryLocation, JvmUnknownCfaNode.INSTANCE, sourceReachedSet, sourceLocations);

    // Assert
    JvmCfaNode programLocation = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertSame(sourceLocations, actualJvmMemoryLocationAbstractState.getSourceLocations());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(JvmUnknownCfaNode.INSTANCE, programLocation);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set)"
  })
  void testNewJvmMemoryLocationAbstractState_thenReturnSourceLocationsIsHashSet() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
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
            memoryLocation, JvmUnknownCfaNode.INSTANCE, sourceReachedSet, sourceLocations);

    // Assert
    JvmCfaNode programLocation = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertSame(sourceLocations, actualJvmMemoryLocationAbstractState.getSourceLocations());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(JvmUnknownCfaNode.INSTANCE, programLocation);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.<init>(JvmMemoryLocation, JvmCfaNode, ProgramLocationDependentReachedSet, Set)"
  })
  void testNewJvmMemoryLocationAbstractState_whenHashSet_thenReturnSourceLocationsEmpty() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    ProgramLocationDependentReachedSet<
            JvmCfaNode, JvmCfaEdge, JvmTaintAbstractState, MethodSignature>
        sourceReachedSet = new ProgramLocationDependentReachedSet<>();

    // Act
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> actualJvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation, JvmUnknownCfaNode.INSTANCE, sourceReachedSet, new HashSet<>());

    // Assert
    JvmCfaNode programLocation = actualJvmMemoryLocationAbstractState.getProgramLocation();
    assertTrue(programLocation instanceof JvmUnknownCfaNode);
    assertNull(actualJvmMemoryLocationAbstractState.getPrecision());
    assertTrue(actualJvmMemoryLocationAbstractState.getSourceLocations().isEmpty());
    assertSame(sourceReachedSet, actualJvmMemoryLocationAbstractState.getSourceReachedSet());
    assertSame(JvmUnknownCfaNode.INSTANCE, programLocation);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#peekCallStack()}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#peekCallStack()}
   */
  @Test
  @DisplayName("Test peekCallStack()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StackEntry JvmMemoryLocationAbstractState.peekCallStack()"})
  void testPeekCallStack() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmMemoryLocationAbstractState.callStackContains(MethodSignature)"})
  void testCallStackContains() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.callStackContains(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}
   */
  @Test
  @DisplayName("Test callStackContains(MethodSignature)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmMemoryLocationAbstractState.callStackContains(MethodSignature)"})
  void testCallStackContains2() {
    // Arrange
    LinkedList<StackEntry> callStack = new LinkedList<>();
    StackEntry stackEntry =
        new StackEntry(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top);
    callStack.add(stackEntry);
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation,
            JvmUnknownCfaNode.INSTANCE,
            new ProgramLocationDependentReachedSet<>(),
            callStack);

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.callStackContains(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}
   */
  @Test
  @DisplayName("Test callStackContains(MethodSignature)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmMemoryLocationAbstractState.callStackContains(MethodSignature)"})
  void testCallStackContains3() {
    // Arrange
    LinkedList<StackEntry> callStack = new LinkedList<>();
    StackEntry stackEntry =
        new StackEntry(
            ClassConstants.CLASS_FOR_NAME_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top);
    callStack.add(stackEntry);
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation,
            JvmUnknownCfaNode.INSTANCE,
            new ProgramLocationDependentReachedSet<>(),
            callStack);

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.callStackContains(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}
   */
  @Test
  @DisplayName("Test callStackContains(MethodSignature)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmMemoryLocationAbstractState.callStackContains(MethodSignature)"})
  void testCallStackContains4() {
    // Arrange
    LinkedList<StackEntry> callStack = new LinkedList<>();
    StackEntry stackEntry =
        new StackEntry(
            null, new ProgramLocationDependentReachedSet(), JvmMemoryLocationAbstractState.top);
    callStack.add(stackEntry);
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation,
            JvmUnknownCfaNode.INSTANCE,
            new ProgramLocationDependentReachedSet<>(),
            callStack);

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.callStackContains(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}
   */
  @Test
  @DisplayName("Test callStackContains(MethodSignature)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmMemoryLocationAbstractState.callStackContains(MethodSignature)"})
  void testCallStackContains5() {
    // Arrange
    LinkedList<StackEntry> callStack = new LinkedList<>();
    StackEntry stackEntry =
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top);
    callStack.add(stackEntry);
    StackEntry stackEntry2 =
        new StackEntry(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top);
    callStack.add(stackEntry2);
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation,
            JvmUnknownCfaNode.INSTANCE,
            new ProgramLocationDependentReachedSet<>(),
            callStack);

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.callStackContains(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}
   */
  @Test
  @DisplayName("Test callStackContains(MethodSignature); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmMemoryLocationAbstractState.callStackContains(MethodSignature)"})
  void testCallStackContains_thenReturnTrue() {
    // Arrange
    LinkedList<StackEntry> callStack = new LinkedList<>();
    StackEntry stackEntry =
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top);
    callStack.add(stackEntry);
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation,
            JvmUnknownCfaNode.INSTANCE,
            new ProgramLocationDependentReachedSet<>(),
            callStack);

    // Act and Assert
    assertTrue(
        jvmMemoryLocationAbstractState.callStackContains(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_LOAD_CLASS_SIGNATURE2}.
   * </ul>
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#callStackContains(MethodSignature)}
   */
  @Test
  @DisplayName("Test callStackContains(MethodSignature); when CLASSLOADER_LOAD_CLASS_SIGNATURE2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmMemoryLocationAbstractState.callStackContains(MethodSignature)"})
  void testCallStackContains_whenClassloader_load_class_signature2() {
    // Arrange
    LinkedList<StackEntry> callStack = new LinkedList<>();
    StackEntry stackEntry =
        new StackEntry(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top);
    callStack.add(stackEntry);
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(
            memoryLocation,
            JvmUnknownCfaNode.INSTANCE,
            new ProgramLocationDependentReachedSet<>(),
            callStack);

    // Act and Assert
    assertFalse(
        jvmMemoryLocationAbstractState.callStackContains(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE2));
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#copyStack()}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#copyStack()}
   */
  @Test
  @DisplayName("Test copyStack()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LinkedList JvmMemoryLocationAbstractState.copyStack()"})
  void testCopyStack() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JvmMemoryLocationAbstractState JvmMemoryLocationAbstractState.join(JvmMemoryLocationAbstractState)"
  })
  void testJoinWithJvmMemoryLocationAbstractState_thenReturnTop() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

    // Act and Assert
    assertSame(
        JvmMemoryLocationAbstractState.top,
        jvmMemoryLocationAbstractState.join(JvmMemoryLocationAbstractState.top));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(0));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation2 =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act
    boolean actualIsLessOrEqualResult =
        jvmMemoryLocationAbstractState.isLessOrEqual(
            new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation2));

    // Assert
    assertFalse(actualIsLessOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState2() {
    // Arrange
    JvmLocalVariableLocation memoryLocation = new JvmLocalVariableLocation(1);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(
            memoryLocation, JvmUnknownCfaNode.INSTANCE, new ProgramLocationDependentReachedSet<>());
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation2 =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act
    boolean actualIsLessOrEqualResult =
        jvmMemoryLocationAbstractState.isLessOrEqual(
            new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation2));

    // Assert
    assertFalse(actualIsLessOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState3() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation2 =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act
    boolean actualIsLessOrEqualResult =
        jvmMemoryLocationAbstractState.isLessOrEqual(
            new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation2));

    // Assert
    assertFalse(actualIsLessOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState4() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    jvmMemoryLocationAbstractState.setProgramLocation(JvmUnknownCfaNode.INSTANCE);
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation2 =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act
    boolean actualIsLessOrEqualResult =
        jvmMemoryLocationAbstractState.isLessOrEqual(
            new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation2));

    // Assert
    assertFalse(actualIsLessOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState5() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

    // Act
    boolean actualIsLessOrEqualResult =
        jvmMemoryLocationAbstractState.isLessOrEqual(new JvmMemoryLocationAbstractState<>(null));

    // Assert
    assertFalse(actualIsLessOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState6() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation2 =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> abstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation2);
    abstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    boolean actualIsLessOrEqualResult = jvmMemoryLocationAbstractState.isLessOrEqual(abstractState);

    // Assert
    assertTrue(actualIsLessOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState_thenReturnTrue() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation2 =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act
    boolean actualIsLessOrEqualResult =
        jvmMemoryLocationAbstractState.isLessOrEqual(
            new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation2));

    // Assert
    assertTrue(actualIsLessOrEqualResult);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)} with
   * {@code JvmMemoryLocationAbstractState}.
   *
   * <ul>
   *   <li>When {@link JvmMemoryLocationAbstractState#top}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JvmMemoryLocationAbstractState#isLessOrEqual(JvmMemoryLocationAbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(JvmMemoryLocationAbstractState) with 'JvmMemoryLocationAbstractState'; when top; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState)"
  })
  void testIsLessOrEqualWithJvmMemoryLocationAbstractState_whenTop_thenReturnTrue() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

    // Act and Assert
    assertTrue(jvmMemoryLocationAbstractState.isLessOrEqual(JvmMemoryLocationAbstractState.top));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmCfaNode JvmMemoryLocationAbstractState.getProgramLocation()"})
  void testGetProgramLocation_thenReturnNull() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmMemoryLocationAbstractState.setProgramLocation(JvmCfaNode)"})
  void testSetProgramLocationWithJvmCfaNode() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

    // Act
    jvmMemoryLocationAbstractState.setProgramLocation(JvmUnknownCfaNode.INSTANCE);

    // Assert
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProgramLocationDependentReachedSet JvmMemoryLocationAbstractState.getSourceReachedSet()"
  })
  void testGetSourceReachedSet_thenReturnNull() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.setSourceReachedSet(ProgramLocationDependentReachedSet)"
  })
  void testSetSourceReachedSet() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.addSourceLocation(BamLocationDependentJvmMemoryLocation)"
  })
  void testAddSourceLocation() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.addSourceLocation(BamLocationDependentJvmMemoryLocation)"
  })
  void testAddSourceLocation2() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.addSourceLocation(BamLocationDependentJvmMemoryLocation)"
  })
  void testAddSourceLocation3() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmMemoryLocationAbstractState.addSourceLocation(BamLocationDependentJvmMemoryLocation)"
  })
  void testAddSourceLocation_whenNull() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmMemoryLocationAbstractState JvmMemoryLocationAbstractState.copy()"})
  void testCopy() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

    // Act
    JvmMemoryLocationAbstractState actualCopyResult = jvmMemoryLocationAbstractState.copy();

    // Assert
    assertEquals(jvmMemoryLocationAbstractState, actualCopyResult);
  }

  /**
   * Test {@link JvmMemoryLocationAbstractState#copy()}.
   *
   * <p>Method under test: {@link JvmMemoryLocationAbstractState#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmMemoryLocationAbstractState JvmMemoryLocationAbstractState.copy()"})
  void testCopy2() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    JvmMemoryLocationAbstractState actualCopyResult = jvmMemoryLocationAbstractState.copy();

    // Assert
    assertEquals(jvmMemoryLocationAbstractState, actualCopyResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmMemoryLocationAbstractState JvmMemoryLocationAbstractState.copy()"})
  void testCopy_givenJvmLocalVariableLocationWithIndexIsMinusOne() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(-1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    JvmMemoryLocationAbstractState actualCopyResult = jvmMemoryLocationAbstractState.copy();

    // Assert
    assertEquals(jvmMemoryLocationAbstractState, actualCopyResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmMemoryLocationAbstractState JvmMemoryLocationAbstractState.copy()"})
  void testCopy_givenJvmStackLocationWithIndexIsOne() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmStackLocation(1)));
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));

    // Act
    JvmMemoryLocationAbstractState actualCopyResult = jvmMemoryLocationAbstractState.copy();

    // Assert
    assertEquals(jvmMemoryLocationAbstractState, actualCopyResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation2 =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState2 =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation2);

    // Act and Assert
    assertEquals(jvmMemoryLocationAbstractState, jvmMemoryLocationAbstractState2);
    assertEquals(
        jvmMemoryLocationAbstractState.hashCode(), jvmMemoryLocationAbstractState2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(0));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation2 =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertNotEquals(
        jvmMemoryLocationAbstractState,
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation2));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);
    jvmMemoryLocationAbstractState.addSourceLocation(
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1)));
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation2 =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));

    // Act and Assert
    assertNotEquals(
        jvmMemoryLocationAbstractState,
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation2));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmMemoryLocationAbstractState.equals(Object)",
    "int JvmMemoryLocationAbstractState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BamLocationDependentJvmMemoryLocation<JvmTaintAbstractState> locationDependentMemoryLocation =
        new BamLocationDependentJvmMemoryLocation<>(new JvmLocalVariableLocation(1));
    JvmMemoryLocationAbstractState<JvmTaintAbstractState> jvmMemoryLocationAbstractState =
        new JvmMemoryLocationAbstractState<>(locationDependentMemoryLocation);

    // Act and Assert
    assertNotEquals(
        jvmMemoryLocationAbstractState, "Different type to JvmMemoryLocationAbstractState");
  }

  /**
   * Test StackEntry {@link StackEntry#equals(Object)}, and {@link StackEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StackEntry#equals(Object)}
   *   <li>{@link StackEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test StackEntry equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackEntry.equals(Object)", "int StackEntry.hashCode()"})
  void testStackEntryEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StackEntry stackEntry =
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
            JvmMemoryLocationAbstractState.top);
    StackEntry stackEntry2 =
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
            JvmMemoryLocationAbstractState.top);

    // Act and Assert
    assertEquals(stackEntry, stackEntry2);
    assertEquals(stackEntry.hashCode(), stackEntry2.hashCode());
  }

  /**
   * Test StackEntry {@link StackEntry#equals(Object)}, and {@link StackEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StackEntry#equals(Object)}
   *   <li>{@link StackEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test StackEntry equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackEntry.equals(Object)", "int StackEntry.hashCode()"})
  void testStackEntryEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StackEntry stackEntry =
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top);

    // Act and Assert
    assertEquals(stackEntry, stackEntry);
    int expectedHashCodeResult = stackEntry.hashCode();
    assertEquals(expectedHashCodeResult, stackEntry.hashCode());
  }

  /**
   * Test StackEntry {@link StackEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test StackEntry equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackEntry.equals(Object)", "int StackEntry.hashCode()"})
  void testStackEntryEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StackEntry stackEntry =
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top);

    // Act and Assert
    assertNotEquals(
        stackEntry,
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top));
  }

  /**
   * Test StackEntry {@link StackEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test StackEntry equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackEntry.equals(Object)", "int StackEntry.hashCode()"})
  void testStackEntryEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StackEntry stackEntry =
        new StackEntry(
            ClassConstants.CLASSLOADER_LOAD_CLASS_SIGNATURE,
            null,
            JvmMemoryLocationAbstractState.top);

    // Act and Assert
    assertNotEquals(
        stackEntry,
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
            JvmMemoryLocationAbstractState.top));
  }

  /**
   * Test StackEntry {@link StackEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test StackEntry equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackEntry.equals(Object)", "int StackEntry.hashCode()"})
  void testStackEntryEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StackEntry stackEntry =
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
            ValueAbstractState.UNKNOWN);

    // Act and Assert
    assertNotEquals(
        stackEntry,
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
            JvmMemoryLocationAbstractState.top));
  }

  /**
   * Test StackEntry {@link StackEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test StackEntry equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackEntry.equals(Object)", "int StackEntry.hashCode()"})
  void testStackEntryEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top),
        null);
  }

  /**
   * Test StackEntry {@link StackEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StackEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test StackEntry equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StackEntry.equals(Object)", "int StackEntry.hashCode()"})
  void testStackEntryEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top),
        "Different type to StackEntry");
  }

  /**
   * Test StackEntry {@link StackEntry#StackEntry(MethodSignature,
   * ProgramLocationDependentReachedSet, AbstractState)}.
   *
   * <p>Method under test: {@link StackEntry#StackEntry(MethodSignature,
   * ProgramLocationDependentReachedSet, AbstractState)}
   */
  @Test
  @DisplayName(
      "Test StackEntry new StackEntry(MethodSignature, ProgramLocationDependentReachedSet, AbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StackEntry.<init>(MethodSignature, ProgramLocationDependentReachedSet, AbstractState)"
  })
  void testStackEntryNewStackEntry() {
    // Arrange and Act
    StackEntry actualStackEntry =
        new StackEntry(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            new ProgramLocationDependentReachedSet(),
            JvmMemoryLocationAbstractState.top);

    // Assert
    MethodSignature methodSignature = actualStackEntry.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    MethodDescriptor descriptor = methodSignature.getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals(
        "Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
        methodSignature.getFqn());
    List<String> argumentTypes = descriptor.getArgumentTypes();
    assertEquals(1, argumentTypes.size());
    assertEquals("Ljava/lang/String;", argumentTypes.get(0));
    assertEquals("String", descriptor.getPrettyArgumentTypes());
    assertEquals("findLoadedClass", methodSignature.getMethodName());
    assertEquals("java.lang", methodSignature.getExternalPackageName());
    assertEquals("java.lang", methodSignature.getPackageName());
    assertEquals("java/lang/ClassLoader", methodSignature.getClassName());
    assertNull(methodSignature.getReferencedClass());
    assertNull(methodSignature.getReferencedMethod());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
  }
}
