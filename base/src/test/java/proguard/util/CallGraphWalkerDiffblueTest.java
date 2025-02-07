package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.CallGraph;
import proguard.analysis.datastructure.callgraph.Node;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;

class CallGraphWalkerDiffblueTest {
  /**
   * Test {@link CallGraphWalker#getSuccessors(CallGraph, MethodSignature, int, int)} with {@code
   * callGraph}, {@code start}, {@code maxDepth}, {@code maxWidth}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CallGraphWalker#getSuccessors(CallGraph, MethodSignature, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test getSuccessors(CallGraph, MethodSignature, int, int) with 'callGraph', 'start', 'maxDepth', 'maxWidth'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.util.CallGraphWalker.getSuccessors(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, int, int)"
  })
  void testGetSuccessorsWithCallGraphStartMaxDepthMaxWidth_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<MethodSignature> actualSuccessors =
        CallGraphWalker.getSuccessors(
            CallGraph.concurrentCallGraph(),
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            2,
            1);

    // Assert
    assertEquals(1, actualSuccessors.size());
  }

  /**
   * Test {@link CallGraphWalker#getSuccessors(CallGraph, MethodSignature, int, int)} with {@code
   * callGraph}, {@code start}, {@code maxDepth}, {@code maxWidth}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CallGraphWalker#getSuccessors(CallGraph, MethodSignature, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test getSuccessors(CallGraph, MethodSignature, int, int) with 'callGraph', 'start', 'maxDepth', 'maxWidth'; when zero; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.util.CallGraphWalker.getSuccessors(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, int, int)"
  })
  void testGetSuccessorsWithCallGraphStartMaxDepthMaxWidth_whenZero_thenReturnEmpty() {
    // Arrange and Act
    Set<MethodSignature> actualSuccessors =
        CallGraphWalker.getSuccessors(
            CallGraph.concurrentCallGraph(),
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            0,
            1);

    // Assert
    assertTrue(actualSuccessors.isEmpty());
  }

  /**
   * Test {@link CallGraphWalker#getSuccessors(CallGraph, MethodSignature)} with {@code callGraph},
   * {@code start}.
   *
   * <ul>
   *   <li>When concurrentCallGraph.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CallGraphWalker#getSuccessors(CallGraph, MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test getSuccessors(CallGraph, MethodSignature) with 'callGraph', 'start'; when concurrentCallGraph; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.util.CallGraphWalker.getSuccessors(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature)"
  })
  void testGetSuccessorsWithCallGraphStart_whenConcurrentCallGraph_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<MethodSignature> actualSuccessors =
        CallGraphWalker.getSuccessors(
            CallGraph.concurrentCallGraph(),
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertEquals(1, actualSuccessors.size());
  }

  /**
   * Test {@link CallGraphWalker#getPredecessors(CallGraph, MethodSignature, int, int)} with {@code
   * callGraph}, {@code start}, {@code maxDepth}, {@code maxWidth}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CallGraphWalker#getPredecessors(CallGraph, MethodSignature, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test getPredecessors(CallGraph, MethodSignature, int, int) with 'callGraph', 'start', 'maxDepth', 'maxWidth'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.util.CallGraphWalker.getPredecessors(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, int, int)"
  })
  void testGetPredecessorsWithCallGraphStartMaxDepthMaxWidth_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<MethodSignature> actualPredecessors =
        CallGraphWalker.getPredecessors(
            CallGraph.concurrentCallGraph(),
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            2,
            1);

    // Assert
    assertEquals(1, actualPredecessors.size());
  }

  /**
   * Test {@link CallGraphWalker#getPredecessors(CallGraph, MethodSignature, int, int)} with {@code
   * callGraph}, {@code start}, {@code maxDepth}, {@code maxWidth}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CallGraphWalker#getPredecessors(CallGraph, MethodSignature, int,
   * int)}
   */
  @Test
  @DisplayName(
      "Test getPredecessors(CallGraph, MethodSignature, int, int) with 'callGraph', 'start', 'maxDepth', 'maxWidth'; when zero; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.util.CallGraphWalker.getPredecessors(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, int, int)"
  })
  void testGetPredecessorsWithCallGraphStartMaxDepthMaxWidth_whenZero_thenReturnEmpty() {
    // Arrange and Act
    Set<MethodSignature> actualPredecessors =
        CallGraphWalker.getPredecessors(
            CallGraph.concurrentCallGraph(),
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            0,
            1);

    // Assert
    assertTrue(actualPredecessors.isEmpty());
  }

  /**
   * Test {@link CallGraphWalker#getPredecessors(CallGraph, MethodSignature)} with {@code
   * callGraph}, {@code start}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CallGraphWalker#getPredecessors(CallGraph, MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test getPredecessors(CallGraph, MethodSignature) with 'callGraph', 'start'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.util.CallGraphWalker.getPredecessors(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature)"
  })
  void testGetPredecessorsWithCallGraphStart_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<MethodSignature> actualPredecessors =
        CallGraphWalker.getPredecessors(
            CallGraph.concurrentCallGraph(),
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertEquals(1, actualPredecessors.size());
  }

  /**
   * Test {@link CallGraphWalker#getPredecessors(CallGraph, MethodSignature)} with {@code
   * callGraph}, {@code start}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link CallGraphWalker#getPredecessors(CallGraph, MethodSignature)}
   */
  @Test
  @DisplayName(
      "Test getPredecessors(CallGraph, MethodSignature) with 'callGraph', 'start'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.util.CallGraphWalker.getPredecessors(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature)"
  })
  void testGetPredecessorsWithCallGraphStart_thenReturnSizeIsTwo() {
    // Arrange
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    callGraph.addCall(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            CallGraphWalker.MAX_DEPTH_DEFAULT,
            new BranchInstruction((byte) 'A', CallGraphWalker.MAX_DEPTH_DEFAULT),
            true,
            true));

    // Act
    Set<MethodSignature> actualPredecessors =
        CallGraphWalker.getPredecessors(
            callGraph, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertEquals(2, actualPredecessors.size());
  }

  /**
   * Test {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature, Predicate)} with
   * {@code callGraph}, {@code start}, {@code handler}.
   *
   * <p>Method under test: {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature,
   * Predicate)}
   */
  @Test
  @DisplayName(
      "Test successorPathsAccept(CallGraph, MethodSignature, Predicate) with 'callGraph', 'start', 'handler'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.util.CallGraphWalker.successorPathsAccept(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, java.util.function.Predicate)"
  })
  void testSuccessorPathsAcceptWithCallGraphStartHandler() {
    // Arrange
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    Predicate<Node> handler = mock(Predicate.class);
    when(handler.test(Mockito.<Node>any())).thenReturn(true);

    // Act
    Node actualSuccessorPathsAcceptResult =
        CallGraphWalker.successorPathsAccept(
            callGraph, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, handler);

    // Assert
    verify(handler).test(isA(Node.class));
    assertEquals(0, actualSuccessorPathsAcceptResult.getPredecessorDepth());
    assertEquals(0, actualSuccessorPathsAcceptResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualSuccessorPathsAcceptResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertFalse(actualSuccessorPathsAcceptResult.isTruncated);
    assertTrue(actualSuccessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.outgoingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.predecessors.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.successors.isEmpty());
    assertEquals(allPredecessors, actualSuccessorPathsAcceptResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualSuccessorPathsAcceptResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature, Predicate, int,
   * int)} with {@code callGraph}, {@code start}, {@code handler}, {@code maxDepth}, {@code
   * maxWidth}.
   *
   * <p>Method under test: {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature,
   * Predicate, int, int)}
   */
  @Test
  @DisplayName(
      "Test successorPathsAccept(CallGraph, MethodSignature, Predicate, int, int) with 'callGraph', 'start', 'handler', 'maxDepth', 'maxWidth'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.util.CallGraphWalker.successorPathsAccept(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, java.util.function.Predicate, int, int)"
  })
  void testSuccessorPathsAcceptWithCallGraphStartHandlerMaxDepthMaxWidth() {
    // Arrange and Act
    Node actualSuccessorPathsAcceptResult =
        CallGraphWalker.successorPathsAccept(
            CallGraph.concurrentCallGraph(),
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            mock(Predicate.class),
            0,
            1);

    // Assert
    assertEquals(0, actualSuccessorPathsAcceptResult.getPredecessorDepth());
    assertEquals(0, actualSuccessorPathsAcceptResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualSuccessorPathsAcceptResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualSuccessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.outgoingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.predecessors.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.successors.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.isTruncated);
    assertEquals(allPredecessors, actualSuccessorPathsAcceptResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualSuccessorPathsAcceptResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature, Predicate, int,
   * int)} with {@code callGraph}, {@code start}, {@code handler}, {@code maxDepth}, {@code
   * maxWidth}.
   *
   * <p>Method under test: {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature,
   * Predicate, int, int)}
   */
  @Test
  @DisplayName(
      "Test successorPathsAccept(CallGraph, MethodSignature, Predicate, int, int) with 'callGraph', 'start', 'handler', 'maxDepth', 'maxWidth'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.util.CallGraphWalker.successorPathsAccept(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, java.util.function.Predicate, int, int)"
  })
  void testSuccessorPathsAcceptWithCallGraphStartHandlerMaxDepthMaxWidth2() {
    // Arrange
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    Predicate<Node> handler = mock(Predicate.class);
    when(handler.test(Mockito.<Node>any())).thenReturn(true);

    // Act
    Node actualSuccessorPathsAcceptResult =
        CallGraphWalker.successorPathsAccept(
            callGraph, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, handler, 2, 1);

    // Assert
    verify(handler).test(isA(Node.class));
    assertEquals(0, actualSuccessorPathsAcceptResult.getPredecessorDepth());
    assertEquals(0, actualSuccessorPathsAcceptResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualSuccessorPathsAcceptResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertFalse(actualSuccessorPathsAcceptResult.isTruncated);
    assertTrue(actualSuccessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.outgoingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.predecessors.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.successors.isEmpty());
    assertEquals(allPredecessors, actualSuccessorPathsAcceptResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualSuccessorPathsAcceptResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature, Predicate, int,
   * int)} with {@code callGraph}, {@code start}, {@code handler}, {@code maxDepth}, {@code
   * maxWidth}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature,
   * Predicate, int, int)}
   */
  @Test
  @DisplayName(
      "Test successorPathsAccept(CallGraph, MethodSignature, Predicate, int, int) with 'callGraph', 'start', 'handler', 'maxDepth', 'maxWidth'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.util.CallGraphWalker.successorPathsAccept(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, java.util.function.Predicate, int, int)"
  })
  void testSuccessorPathsAcceptWithCallGraphStartHandlerMaxDepthMaxWidth_givenFalse() {
    // Arrange
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    Predicate<Node> handler = mock(Predicate.class);
    when(handler.test(Mockito.<Node>any())).thenReturn(false);

    // Act
    Node actualSuccessorPathsAcceptResult =
        CallGraphWalker.successorPathsAccept(
            callGraph, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, handler, 2, 1);

    // Assert
    verify(handler).test(isA(Node.class));
    assertEquals(0, actualSuccessorPathsAcceptResult.getPredecessorDepth());
    assertEquals(0, actualSuccessorPathsAcceptResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualSuccessorPathsAcceptResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertFalse(actualSuccessorPathsAcceptResult.isTruncated);
    assertTrue(actualSuccessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.outgoingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.predecessors.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.successors.isEmpty());
    assertEquals(allPredecessors, actualSuccessorPathsAcceptResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualSuccessorPathsAcceptResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature, Predicate)} with
   * {@code callGraph}, {@code start}, {@code handler}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature,
   * Predicate)}
   */
  @Test
  @DisplayName(
      "Test successorPathsAccept(CallGraph, MethodSignature, Predicate) with 'callGraph', 'start', 'handler'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.util.CallGraphWalker.successorPathsAccept(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, java.util.function.Predicate)"
  })
  void testSuccessorPathsAcceptWithCallGraphStartHandler_givenFalse() {
    // Arrange
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    Predicate<Node> handler = mock(Predicate.class);
    when(handler.test(Mockito.<Node>any())).thenReturn(false);

    // Act
    Node actualSuccessorPathsAcceptResult =
        CallGraphWalker.successorPathsAccept(
            callGraph, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, handler);

    // Assert
    verify(handler).test(isA(Node.class));
    assertEquals(0, actualSuccessorPathsAcceptResult.getPredecessorDepth());
    assertEquals(0, actualSuccessorPathsAcceptResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualSuccessorPathsAcceptResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertFalse(actualSuccessorPathsAcceptResult.isTruncated);
    assertTrue(actualSuccessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.outgoingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.predecessors.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.successors.isEmpty());
    assertEquals(allPredecessors, actualSuccessorPathsAcceptResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualSuccessorPathsAcceptResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature, Predicate)} with
   * {@code callGraph}, {@code start}, {@code handler}.
   *
   * <p>Method under test: {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature,
   * Predicate)}
   */
  @Test
  @DisplayName(
      "Test predecessorPathsAccept(CallGraph, MethodSignature, Predicate) with 'callGraph', 'start', 'handler'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.util.CallGraphWalker.predecessorPathsAccept(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, java.util.function.Predicate)"
  })
  void testPredecessorPathsAcceptWithCallGraphStartHandler() {
    // Arrange
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    Predicate<Node> handler = mock(Predicate.class);
    when(handler.test(Mockito.<Node>any())).thenReturn(true);

    // Act
    Node actualPredecessorPathsAcceptResult =
        CallGraphWalker.predecessorPathsAccept(
            callGraph, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, handler);

    // Assert
    verify(handler).test(isA(Node.class));
    assertEquals(0, actualPredecessorPathsAcceptResult.getPredecessorDepth());
    Set<Node> allPredecessors = actualPredecessorPathsAcceptResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualPredecessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.predecessors.isEmpty());
    assertEquals(allPredecessors, actualPredecessorPathsAcceptResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualPredecessorPathsAcceptResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature, Predicate)} with
   * {@code callGraph}, {@code start}, {@code handler}.
   *
   * <p>Method under test: {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature,
   * Predicate)}
   */
  @Test
  @DisplayName(
      "Test predecessorPathsAccept(CallGraph, MethodSignature, Predicate) with 'callGraph', 'start', 'handler'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.util.CallGraphWalker.predecessorPathsAccept(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, java.util.function.Predicate)"
  })
  void testPredecessorPathsAcceptWithCallGraphStartHandler2() {
    // Arrange
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    callGraph.addCall(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            CallGraphWalker.MAX_DEPTH_DEFAULT,
            new BranchInstruction((byte) 'A', CallGraphWalker.MAX_DEPTH_DEFAULT),
            true,
            true));
    Predicate<Node> handler = mock(Predicate.class);
    when(handler.test(Mockito.<Node>any())).thenReturn(true);

    // Act
    Node actualPredecessorPathsAcceptResult =
        CallGraphWalker.predecessorPathsAccept(
            callGraph, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, handler);

    // Assert
    verify(handler, atLeast(1)).test(Mockito.<Node>any());
    assertEquals(1, actualPredecessorPathsAcceptResult.getFurthestPredecessors().size());
    assertEquals(1, actualPredecessorPathsAcceptResult.getFurthestSuccessors().size());
    assertEquals(1, actualPredecessorPathsAcceptResult.incomingCallLocations.size());
    assertEquals(1, actualPredecessorPathsAcceptResult.predecessors.size());
    assertEquals(2, actualPredecessorPathsAcceptResult.getAllPredecessors().size());
    assertEquals(2, actualPredecessorPathsAcceptResult.getPredecessorDepth());
  }

  /**
   * Test {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature, Predicate, int,
   * int)} with {@code callGraph}, {@code start}, {@code handler}, {@code maxDepth}, {@code
   * maxWidth}.
   *
   * <p>Method under test: {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature,
   * Predicate, int, int)}
   */
  @Test
  @DisplayName(
      "Test predecessorPathsAccept(CallGraph, MethodSignature, Predicate, int, int) with 'callGraph', 'start', 'handler', 'maxDepth', 'maxWidth'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.util.CallGraphWalker.predecessorPathsAccept(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, java.util.function.Predicate, int, int)"
  })
  void testPredecessorPathsAcceptWithCallGraphStartHandlerMaxDepthMaxWidth() {
    // Arrange and Act
    Node actualPredecessorPathsAcceptResult =
        CallGraphWalker.predecessorPathsAccept(
            CallGraph.concurrentCallGraph(),
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            mock(Predicate.class),
            0,
            1);

    // Assert
    assertEquals(0, actualPredecessorPathsAcceptResult.getPredecessorDepth());
    assertEquals(0, actualPredecessorPathsAcceptResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualPredecessorPathsAcceptResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualPredecessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.outgoingCallLocations.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.predecessors.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.successors.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.isTruncated);
    assertEquals(allPredecessors, actualPredecessorPathsAcceptResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualPredecessorPathsAcceptResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature, Predicate, int,
   * int)} with {@code callGraph}, {@code start}, {@code handler}, {@code maxDepth}, {@code
   * maxWidth}.
   *
   * <p>Method under test: {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature,
   * Predicate, int, int)}
   */
  @Test
  @DisplayName(
      "Test predecessorPathsAccept(CallGraph, MethodSignature, Predicate, int, int) with 'callGraph', 'start', 'handler', 'maxDepth', 'maxWidth'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.util.CallGraphWalker.predecessorPathsAccept(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, java.util.function.Predicate, int, int)"
  })
  void testPredecessorPathsAcceptWithCallGraphStartHandlerMaxDepthMaxWidth2() {
    // Arrange
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    Predicate<Node> handler = mock(Predicate.class);
    when(handler.test(Mockito.<Node>any())).thenReturn(true);

    // Act
    Node actualPredecessorPathsAcceptResult =
        CallGraphWalker.predecessorPathsAccept(
            callGraph, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, handler, 2, 1);

    // Assert
    verify(handler).test(isA(Node.class));
    assertEquals(0, actualPredecessorPathsAcceptResult.getPredecessorDepth());
    assertEquals(0, actualPredecessorPathsAcceptResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualPredecessorPathsAcceptResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertFalse(actualPredecessorPathsAcceptResult.isTruncated);
    assertTrue(actualPredecessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.outgoingCallLocations.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.predecessors.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.successors.isEmpty());
    assertEquals(allPredecessors, actualPredecessorPathsAcceptResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualPredecessorPathsAcceptResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature, Predicate, int,
   * int)} with {@code callGraph}, {@code start}, {@code handler}, {@code maxDepth}, {@code
   * maxWidth}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature,
   * Predicate, int, int)}
   */
  @Test
  @DisplayName(
      "Test predecessorPathsAccept(CallGraph, MethodSignature, Predicate, int, int) with 'callGraph', 'start', 'handler', 'maxDepth', 'maxWidth'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.util.CallGraphWalker.predecessorPathsAccept(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, java.util.function.Predicate, int, int)"
  })
  void testPredecessorPathsAcceptWithCallGraphStartHandlerMaxDepthMaxWidth_givenFalse() {
    // Arrange
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    Predicate<Node> handler = mock(Predicate.class);
    when(handler.test(Mockito.<Node>any())).thenReturn(false);

    // Act
    Node actualPredecessorPathsAcceptResult =
        CallGraphWalker.predecessorPathsAccept(
            callGraph, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, handler, 2, 1);

    // Assert
    verify(handler).test(isA(Node.class));
    assertEquals(0, actualPredecessorPathsAcceptResult.getPredecessorDepth());
    assertEquals(0, actualPredecessorPathsAcceptResult.getSuccessorDepth());
    Set<Node> allPredecessors = actualPredecessorPathsAcceptResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertFalse(actualPredecessorPathsAcceptResult.isTruncated);
    assertTrue(actualPredecessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.outgoingCallLocations.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.predecessors.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.successors.isEmpty());
    assertEquals(allPredecessors, actualPredecessorPathsAcceptResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualPredecessorPathsAcceptResult.getFurthestSuccessors());
  }

  /**
   * Test {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature, Predicate)} with
   * {@code callGraph}, {@code start}, {@code handler}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature,
   * Predicate)}
   */
  @Test
  @DisplayName(
      "Test predecessorPathsAccept(CallGraph, MethodSignature, Predicate) with 'callGraph', 'start', 'handler'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.datastructure.callgraph.Node proguard.util.CallGraphWalker.predecessorPathsAccept(proguard.analysis.datastructure.callgraph.CallGraph, proguard.classfile.MethodSignature, java.util.function.Predicate)"
  })
  void testPredecessorPathsAcceptWithCallGraphStartHandler_givenFalse() {
    // Arrange
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    Predicate<Node> handler = mock(Predicate.class);
    when(handler.test(Mockito.<Node>any())).thenReturn(false);

    // Act
    Node actualPredecessorPathsAcceptResult =
        CallGraphWalker.predecessorPathsAccept(
            callGraph, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, handler);

    // Assert
    verify(handler).test(isA(Node.class));
    assertEquals(0, actualPredecessorPathsAcceptResult.getPredecessorDepth());
    Set<Node> allPredecessors = actualPredecessorPathsAcceptResult.getAllPredecessors();
    assertEquals(1, allPredecessors.size());
    assertTrue(actualPredecessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.predecessors.isEmpty());
    assertEquals(allPredecessors, actualPredecessorPathsAcceptResult.getFurthestPredecessors());
    assertEquals(allPredecessors, actualPredecessorPathsAcceptResult.getFurthestSuccessors());
  }
}
