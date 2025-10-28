package proguard.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.Test;
import proguard.analysis.datastructure.callgraph.CallGraph;
import proguard.analysis.datastructure.callgraph.Node;
import proguard.classfile.ClassConstants;
import proguard.classfile.MethodDescriptor;
import proguard.classfile.MethodSignature;

public class CallGraphWalkerDiffblueTest {
  /**
   * Method under test:
   * {@link CallGraphWalker#getSuccessors(CallGraph, MethodSignature)}
   */
  @Test
  public void testGetSuccessors() {
    // Arrange and Act
    Set<MethodSignature> actualSuccessors = CallGraphWalker.getSuccessors(CallGraph.concurrentCallGraph(),
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertEquals(1, actualSuccessors.size());
  }

  /**
   * Method under test:
   * {@link CallGraphWalker#getSuccessors(CallGraph, MethodSignature, int, int)}
   */
  @Test
  public void testGetSuccessors2() {
    // Arrange and Act
    Set<MethodSignature> actualSuccessors = CallGraphWalker.getSuccessors(CallGraph.concurrentCallGraph(),
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1);

    // Assert
    assertEquals(1, actualSuccessors.size());
  }

  /**
   * Method under test:
   * {@link CallGraphWalker#getSuccessors(CallGraph, MethodSignature, int, int)}
   */
  @Test
  public void testGetSuccessors3() {
    // Arrange and Act
    Set<MethodSignature> actualSuccessors = CallGraphWalker.getSuccessors(CallGraph.concurrentCallGraph(),
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, 1);

    // Assert
    assertTrue(actualSuccessors.isEmpty());
  }

  /**
   * Method under test:
   * {@link CallGraphWalker#getPredecessors(CallGraph, MethodSignature)}
   */
  @Test
  public void testGetPredecessors() {
    // Arrange and Act
    Set<MethodSignature> actualPredecessors = CallGraphWalker.getPredecessors(CallGraph.concurrentCallGraph(),
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertEquals(1, actualPredecessors.size());
  }

  /**
   * Method under test:
   * {@link CallGraphWalker#getPredecessors(CallGraph, MethodSignature, int, int)}
   */
  @Test
  public void testGetPredecessors2() {
    // Arrange and Act
    Set<MethodSignature> actualPredecessors = CallGraphWalker.getPredecessors(CallGraph.concurrentCallGraph(),
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1);

    // Assert
    assertEquals(1, actualPredecessors.size());
  }

  /**
   * Method under test:
   * {@link CallGraphWalker#getPredecessors(CallGraph, MethodSignature, int, int)}
   */
  @Test
  public void testGetPredecessors3() {
    // Arrange and Act
    Set<MethodSignature> actualPredecessors = CallGraphWalker.getPredecessors(CallGraph.concurrentCallGraph(),
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, 1);

    // Assert
    assertTrue(actualPredecessors.isEmpty());
  }

  /**
   * Method under test:
   * {@link CallGraphWalker#successorPathsAccept(CallGraph, MethodSignature, Predicate, int, int)}
   */
  @Test
  public void testSuccessorPathsAccept() {
    // Arrange and Act
    Node actualSuccessorPathsAcceptResult = CallGraphWalker.successorPathsAccept(CallGraph.concurrentCallGraph(),
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, 0, 1);

    // Assert
    MethodSignature methodSignature = actualSuccessorPathsAcceptResult.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    MethodDescriptor descriptor = methodSignature.getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals("Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
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
    assertEquals(0, actualSuccessorPathsAcceptResult.getPredecessorDepth());
    assertEquals(0, actualSuccessorPathsAcceptResult.getSuccessorDepth());
    assertEquals(1, actualSuccessorPathsAcceptResult.getAllPredecessors().size());
    assertEquals(1, actualSuccessorPathsAcceptResult.getFurthestPredecessors().size());
    assertEquals(1, actualSuccessorPathsAcceptResult.getFurthestSuccessors().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualSuccessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.outgoingCallLocations.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.predecessors.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.successors.isEmpty());
    assertTrue(actualSuccessorPathsAcceptResult.isTruncated);
  }

  /**
   * Method under test:
   * {@link CallGraphWalker#predecessorPathsAccept(CallGraph, MethodSignature, Predicate, int, int)}
   */
  @Test
  public void testPredecessorPathsAccept() {
    // Arrange and Act
    Node actualPredecessorPathsAcceptResult = CallGraphWalker.predecessorPathsAccept(CallGraph.concurrentCallGraph(),
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, null, 0, 1);

    // Assert
    MethodSignature methodSignature = actualPredecessorPathsAcceptResult.signature;
    assertEquals("Class ClassLoader.findLoadedClass(String)", methodSignature.getPrettyFqn());
    MethodDescriptor descriptor = methodSignature.getDescriptor();
    assertEquals("Class", descriptor.getPrettyReturnType());
    assertEquals("Ljava/lang/Class;", descriptor.getReturnType());
    assertEquals("Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;",
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
    assertEquals(0, actualPredecessorPathsAcceptResult.getPredecessorDepth());
    assertEquals(0, actualPredecessorPathsAcceptResult.getSuccessorDepth());
    assertEquals(1, actualPredecessorPathsAcceptResult.getAllPredecessors().size());
    assertEquals(1, actualPredecessorPathsAcceptResult.getFurthestPredecessors().size());
    assertEquals(1, actualPredecessorPathsAcceptResult.getFurthestSuccessors().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualPredecessorPathsAcceptResult.incomingCallLocations.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.outgoingCallLocations.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.predecessors.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.successors.isEmpty());
    assertTrue(actualPredecessorPathsAcceptResult.isTruncated);
  }
}
