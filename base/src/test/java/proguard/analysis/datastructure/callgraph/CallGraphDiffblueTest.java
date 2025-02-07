package proguard.analysis.datastructure.callgraph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.kotlin.KotlinConstants;

class CallGraphDiffblueTest {
  /**
   * Test {@link CallGraph#CallGraph()}.
   *
   * <p>Method under test: {@link CallGraph#CallGraph()}
   */
  @Test
  @DisplayName("Test new CallGraph()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.CallGraph.<init>()",
    "void proguard.analysis.datastructure.callgraph.CallGraph.<init>(java.util.Map, java.util.Map, boolean)"
  })
  void testNewCallGraph() {
    // Arrange and Act
    CallGraph actualCallGraph = new CallGraph();

    // Assert
    assertTrue(actualCallGraph.incoming.isEmpty());
    assertTrue(actualCallGraph.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#CallGraph(Map, Map, boolean)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link CallGraph#CallGraph(Map, Map, boolean)}
   */
  @Test
  @DisplayName("Test new CallGraph(Map, Map, boolean); when HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.CallGraph.<init>()",
    "void proguard.analysis.datastructure.callgraph.CallGraph.<init>(java.util.Map, java.util.Map, boolean)"
  })
  void testNewCallGraph_whenHashMap() {
    // Arrange
    HashMap<MethodSignature, Set<Call>> incoming = new HashMap<>();

    // Act
    CallGraph actualCallGraph = new CallGraph(incoming, new HashMap<>(), true);

    // Assert
    assertTrue(actualCallGraph.incoming.isEmpty());
    assertTrue(actualCallGraph.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#concurrentCallGraph()}.
   *
   * <p>Method under test: {@link CallGraph#concurrentCallGraph()}
   */
  @Test
  @DisplayName("Test concurrentCallGraph()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.CallGraph proguard.analysis.datastructure.callgraph.CallGraph.concurrentCallGraph()"
  })
  void testConcurrentCallGraph() {
    // Arrange and Act
    CallGraph actualConcurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Assert
    assertTrue(actualConcurrentCallGraphResult.incoming.isEmpty());
    assertTrue(actualConcurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.CallGraph.addCall(proguard.analysis.datastructure.callgraph.Call)"
  })
  void testAddCall() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    concurrentCallGraphResult.addCall(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            0,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.CallGraph.addCall(proguard.analysis.datastructure.callgraph.Call)"
  })
  void testAddCall2() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    concurrentCallGraphResult.addCall(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            -1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.CallGraph.addCall(proguard.analysis.datastructure.callgraph.Call)"
  })
  void testAddCall3() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller =
        new CodeLocation(
            clazz,
            new LibraryField(
                1, "Location of call {} is not a method", "Location of call {} is not a method"),
            2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target =
        new LibraryMethod(
            1, "Location of call {} is not a method", "Location of call {} is not a method");

    // Act
    concurrentCallGraphResult.addCall(
        new ConcreteCall(
            caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.CallGraph.addCall(proguard.analysis.datastructure.callgraph.Call)"
  })
  void testAddCall4() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    // Act
    concurrentCallGraphResult.addCall(
        new SymbolicCall(caller, null, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <ul>
   *   <li>Given {@link CallGraph#CallGraph()}.
   *   <li>Then {@link CallGraph#CallGraph()} {@link CallGraph#incoming} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call); given CallGraph(); then CallGraph() incoming size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.CallGraph.addCall(proguard.analysis.datastructure.callgraph.Call)"
  })
  void testAddCall_givenCallGraph_thenCallGraphIncomingSizeIsOne() {
    // Arrange
    CallGraph callGraph = new CallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    // Act
    callGraph.addCall(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Assert
    assertEquals(1, callGraph.incoming.size());
    assertEquals(1, callGraph.outgoing.size());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <ul>
   *   <li>Then concurrentCallGraph {@link CallGraph#incoming} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName("Test addCall(Call); then concurrentCallGraph incoming size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.CallGraph.addCall(proguard.analysis.datastructure.callgraph.Call)"
  })
  void testAddCall_thenConcurrentCallGraphIncomingSizeIsOne() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    // Act
    concurrentCallGraphResult.addCall(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Assert
    assertEquals(1, concurrentCallGraphResult.incoming.size());
    assertEquals(1, concurrentCallGraphResult.outgoing.size());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <ul>
   *   <li>When {@link BranchInstruction#BranchInstruction(byte, int)} with opcode is minus one and
   *       branchOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName(
      "Test addCall(Call); when BranchInstruction(byte, int) with opcode is minus one and branchOffset is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.CallGraph.addCall(proguard.analysis.datastructure.callgraph.Call)"
  })
  void testAddCall_whenBranchInstructionWithOpcodeIsMinusOneAndBranchOffsetIsOne() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    concurrentCallGraphResult.addCall(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) -1, 1),
            true,
            true));

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#addCall(Call)}.
   *
   * <ul>
   *   <li>When {@link LibraryField#LibraryField(int, String, String)} with u2accessFlags is one and
   *       {@code Name} and {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  @DisplayName(
      "Test addCall(Call); when LibraryField(int, String, String) with u2accessFlags is one and 'Name' and 'Descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.datastructure.callgraph.CallGraph.addCall(proguard.analysis.datastructure.callgraph.Call)"
  })
  void testAddCall_whenLibraryFieldWithU2accessFlagsIsOneAndNameAndDescriptor() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    concurrentCallGraphResult.addCall(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Assert that nothing has changed
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)} with
   * {@code programClassPool}, {@code start}, {@code maxDepth}, {@code maxWidth}, {@code
   * stopMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int,
   * int, Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, int, int, Set) with 'programClassPool', 'start', 'maxDepth', 'maxWidth', 'stopMethods'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.analysis.datastructure.callgraph.CallGraph.reconstructCallGraph(proguard.classfile.ClassPool, proguard.classfile.MethodSignature, int, int, java.util.Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartMaxDepthMaxWidthStopMethods() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            2,
            1,
            new HashSet<>());

    // Assert
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualReconstructCallGraphResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)} with
   * {@code programClassPool}, {@code start}, {@code maxDepth}, {@code maxWidth}, {@code
   * stopMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int,
   * int, Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, int, int, Set) with 'programClassPool', 'start', 'maxDepth', 'maxWidth', 'stopMethods'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.analysis.datastructure.callgraph.CallGraph.reconstructCallGraph(proguard.classfile.ClassPool, proguard.classfile.MethodSignature, int, int, java.util.Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartMaxDepthMaxWidthStopMethods2() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            0,
            1,
            new HashSet<>());

    // Assert
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualReconstructCallGraphResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)} with
   * {@code programClassPool}, {@code start}, {@code maxDepth}, {@code maxWidth}, {@code
   * stopMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int,
   * int, Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, int, int, Set) with 'programClassPool', 'start', 'maxDepth', 'maxWidth', 'stopMethods'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.analysis.datastructure.callgraph.CallGraph.reconstructCallGraph(proguard.classfile.ClassPool, proguard.classfile.MethodSignature, int, int, java.util.Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartMaxDepthMaxWidthStopMethods3() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    HashSet<MethodSignature> stopMethods = new HashSet<>();
    stopMethods.add(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            2,
            1,
            stopMethods);

    // Assert
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualReconstructCallGraphResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set)} with {@code
   * programClassPool}, {@code start}, {@code stopMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, Set) with 'programClassPool', 'start', 'stopMethods'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.analysis.datastructure.callgraph.CallGraph.reconstructCallGraph(proguard.classfile.ClassPool, proguard.classfile.MethodSignature, java.util.Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartStopMethods() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            new HashSet<>());

    // Assert
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualReconstructCallGraphResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set)} with {@code
   * programClassPool}, {@code start}, {@code stopMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, Set) with 'programClassPool', 'start', 'stopMethods'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.analysis.datastructure.callgraph.CallGraph.reconstructCallGraph(proguard.classfile.ClassPool, proguard.classfile.MethodSignature, java.util.Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartStopMethods2() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    HashSet<MethodSignature> stopMethods = new HashSet<>();
    stopMethods.add(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            stopMethods);

    // Assert
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualReconstructCallGraphResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set, Set)} with {@code
   * programClassPool}, {@code start}, {@code stopMethods}, {@code reachedMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, Set, Set) with 'programClassPool', 'start', 'stopMethods', 'reachedMethods'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.analysis.datastructure.callgraph.CallGraph.reconstructCallGraph(proguard.classfile.ClassPool, proguard.classfile.MethodSignature, java.util.Set, java.util.Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartStopMethodsReachedMethods() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    HashSet<MethodSignature> stopMethods = new HashSet<>();

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            stopMethods,
            new HashSet<>());

    // Assert
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualReconstructCallGraphResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set, Set)} with {@code
   * programClassPool}, {@code start}, {@code stopMethods}, {@code reachedMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, Set, Set) with 'programClassPool', 'start', 'stopMethods', 'reachedMethods'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.analysis.datastructure.callgraph.CallGraph.reconstructCallGraph(proguard.classfile.ClassPool, proguard.classfile.MethodSignature, java.util.Set, java.util.Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartStopMethodsReachedMethods2() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    HashSet<MethodSignature> stopMethods = new HashSet<>();
    stopMethods.add(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            stopMethods,
            new HashSet<>());

    // Assert
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualReconstructCallGraphResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set, Set)} with {@code
   * programClassPool}, {@code start}, {@code stopMethods}, {@code reachedMethods}.
   *
   * <p>Method under test: {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test reconstructCallGraph(ClassPool, MethodSignature, Set, Set) with 'programClassPool', 'start', 'stopMethods', 'reachedMethods'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.analysis.datastructure.callgraph.CallGraph.reconstructCallGraph(proguard.classfile.ClassPool, proguard.classfile.MethodSignature, java.util.Set, java.util.Set)"
  })
  void testReconstructCallGraphWithProgramClassPoolStartStopMethodsReachedMethods3() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    HashSet<MethodSignature> stopMethods = new HashSet<>();

    HashSet<MethodSignature> reachedMethods = new HashSet<>();
    reachedMethods.add(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    Node actualReconstructCallGraphResult =
        concurrentCallGraphResult.reconstructCallGraph(
            KotlinConstants.dummyClassPool,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            stopMethods,
            reachedMethods);

    // Assert
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualReconstructCallGraphResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualReconstructCallGraphResult.getFurthestSuccessors());
  }
}
