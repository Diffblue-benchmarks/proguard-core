package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.CallGraph;
import proguard.analysis.datastructure.callgraph.Node;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;

public class CallGraphWalkerDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallGraphWalker.getSuccessors(CallGraph, MethodSignature, int, int)"})
  public void testGetSuccessorsWithCallGraphStartMaxDepthMaxWidth_thenReturnSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallGraphWalker.getSuccessors(CallGraph, MethodSignature, int, int)"})
  public void testGetSuccessorsWithCallGraphStartMaxDepthMaxWidth_whenZero_thenReturnEmpty() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallGraphWalker.getSuccessors(CallGraph, MethodSignature)"})
  public void testGetSuccessorsWithCallGraphStart_whenConcurrentCallGraph_thenReturnSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallGraphWalker.getPredecessors(CallGraph, MethodSignature, int, int)"})
  public void testGetPredecessorsWithCallGraphStartMaxDepthMaxWidth_thenReturnSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallGraphWalker.getPredecessors(CallGraph, MethodSignature, int, int)"})
  public void testGetPredecessorsWithCallGraphStartMaxDepthMaxWidth_whenZero_thenReturnEmpty() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallGraphWalker.getPredecessors(CallGraph, MethodSignature)"})
  public void testGetPredecessorsWithCallGraphStart_thenReturnSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallGraphWalker.getPredecessors(CallGraph, MethodSignature)"})
  public void testGetPredecessorsWithCallGraphStart_thenReturnSizeIsTwo() {
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
   * Test {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature, Predicate, int,
   * int)} with {@code callGraph}, {@code start}, {@code handler}, {@code maxDepth}, {@code
   * maxWidth}.
   *
   * <p>Method under test: {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature,
   * Predicate, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Node CallGraphWalker.successorPathsAccept(CallGraph, MethodSignature, Predicate, int, int)"
  })
  public void testSuccessorPathsAcceptWithCallGraphStartHandlerMaxDepthMaxWidth() {
    // Arrange and Act
    Node actualSuccessorPathsAcceptResult =
        CallGraphWalker.successorPathsAccept(
            CallGraph.concurrentCallGraph(),
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
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
   * Test {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature, Predicate, int,
   * int)} with {@code callGraph}, {@code start}, {@code handler}, {@code maxDepth}, {@code
   * maxWidth}.
   *
   * <p>Method under test: {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature,
   * Predicate, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Node CallGraphWalker.predecessorPathsAccept(CallGraph, MethodSignature, Predicate, int, int)"
  })
  public void testPredecessorPathsAcceptWithCallGraphStartHandlerMaxDepthMaxWidth() {
    // Arrange and Act
    Node actualPredecessorPathsAcceptResult =
        CallGraphWalker.predecessorPathsAccept(
            CallGraph.concurrentCallGraph(),
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            null,
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
}
