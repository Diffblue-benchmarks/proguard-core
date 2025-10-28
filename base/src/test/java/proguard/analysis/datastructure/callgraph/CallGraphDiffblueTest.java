package proguard.analysis.datastructure.callgraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.ClassConstants;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodDescriptor;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.kotlin.KotlinConstants;

public class CallGraphDiffblueTest {
  /**
   * Method under test: {@link CallGraph#concurrentCallGraph()}
   */
  @Test
  public void testConcurrentCallGraph() {
    // Arrange and Act
    CallGraph actualConcurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Assert
    assertTrue(actualConcurrentCallGraphResult.incoming.isEmpty());
    assertTrue(actualConcurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  public void testAddCall() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    concurrentCallGraphResult.addCall(new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        1, new BranchInstruction((byte) 'A', 1), true, true));

    // Assert
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  public void testAddCall2() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    // Act
    concurrentCallGraphResult.addCall(new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        1, new BranchInstruction((byte) 'A', 1), true, true));

    // Assert
    assertEquals(1, concurrentCallGraphResult.incoming.size());
    assertEquals(1, concurrentCallGraphResult.outgoing.size());
  }

  /**
   * Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  public void testAddCall3() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    concurrentCallGraphResult.addCall(new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        0, new BranchInstruction((byte) 'A', 1), true, true));

    // Assert
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  public void testAddCall4() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    concurrentCallGraphResult.addCall(new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        -1, new BranchInstruction((byte) 'A', 1), true, true));

    // Assert
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  public void testAddCall5() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2);

    // Act
    concurrentCallGraphResult.addCall(new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        1, new BranchInstruction((byte) -1, 1), true, true));

    // Assert
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  public void testAddCall6() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz,
        new LibraryField(1, "Location of call {} is not a method", "Location of call {} is not a method"), 2);

    LibraryClass targetClass = new LibraryClass();
    LibraryMethod target = new LibraryMethod(1, "Location of call {} is not a method",
        "Location of call {} is not a method");

    // Act
    concurrentCallGraphResult
        .addCall(new ConcreteCall(caller, targetClass, target, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Assert
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  public void testAddCall7() {
    // Arrange
    CallGraph callGraph = new CallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    // Act
    callGraph.addCall(new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true));

    // Assert
    assertEquals(1, callGraph.incoming.size());
    assertEquals(1, callGraph.outgoing.size());
  }

  /**
   * Method under test: {@link CallGraph#addCall(Call)}
   */
  @Test
  public void testAddCall8() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    // Act
    concurrentCallGraphResult
        .addCall(new SymbolicCall(caller, null, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Assert
    assertTrue(concurrentCallGraphResult.incoming.isEmpty());
    assertTrue(concurrentCallGraphResult.outgoing.isEmpty());
  }

  /**
   * Method under test:
   * {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)}
   */
  @Test
  public void testReconstructCallGraph() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Act
    Node actualReconstructCallGraphResult = concurrentCallGraphResult.reconstructCallGraph(
        KotlinConstants.dummyClassPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new HashSet<>());

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
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
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    assertEquals(1, actualReconstructCallGraphResult.getAllPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestSuccessors().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Method under test:
   * {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)}
   */
  @Test
  public void testReconstructCallGraph2() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Act
    Node actualReconstructCallGraphResult = concurrentCallGraphResult.reconstructCallGraph(
        KotlinConstants.dummyClassPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, 1, new HashSet<>());

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
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
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    assertEquals(1, actualReconstructCallGraphResult.getAllPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestSuccessors().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Method under test:
   * {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, int, int, Set)}
   */
  @Test
  public void testReconstructCallGraph3() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    HashSet<MethodSignature> stopMethods = new HashSet<>();
    stopMethods.add(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    Node actualReconstructCallGraphResult = concurrentCallGraphResult.reconstructCallGraph(
        KotlinConstants.dummyClassPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, stopMethods);

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
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
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    assertEquals(1, actualReconstructCallGraphResult.getAllPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestSuccessors().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Method under test:
   * {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set)}
   */
  @Test
  public void testReconstructCallGraph4() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    // Act
    Node actualReconstructCallGraphResult = concurrentCallGraphResult.reconstructCallGraph(
        KotlinConstants.dummyClassPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, new HashSet<>());

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
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
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    assertEquals(1, actualReconstructCallGraphResult.getAllPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestSuccessors().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Method under test:
   * {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set)}
   */
  @Test
  public void testReconstructCallGraph5() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    HashSet<MethodSignature> stopMethods = new HashSet<>();
    stopMethods.add(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    Node actualReconstructCallGraphResult = concurrentCallGraphResult.reconstructCallGraph(
        KotlinConstants.dummyClassPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, stopMethods);

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
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
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    assertEquals(1, actualReconstructCallGraphResult.getAllPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestSuccessors().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Method under test:
   * {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set, Set)}
   */
  @Test
  public void testReconstructCallGraph6() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    HashSet<MethodSignature> stopMethods = new HashSet<>();

    // Act
    Node actualReconstructCallGraphResult = concurrentCallGraphResult.reconstructCallGraph(
        KotlinConstants.dummyClassPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, stopMethods,
        new HashSet<>());

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
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
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    assertEquals(1, actualReconstructCallGraphResult.getAllPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestSuccessors().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Method under test:
   * {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set, Set)}
   */
  @Test
  public void testReconstructCallGraph7() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();

    HashSet<MethodSignature> stopMethods = new HashSet<>();
    stopMethods.add(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    Node actualReconstructCallGraphResult = concurrentCallGraphResult.reconstructCallGraph(
        KotlinConstants.dummyClassPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, stopMethods,
        new HashSet<>());

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
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
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    assertEquals(1, actualReconstructCallGraphResult.getAllPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestSuccessors().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Method under test:
   * {@link CallGraph#reconstructCallGraph(ClassPool, MethodSignature, Set, Set)}
   */
  @Test
  public void testReconstructCallGraph8() {
    // Arrange
    CallGraph concurrentCallGraphResult = CallGraph.concurrentCallGraph();
    HashSet<MethodSignature> stopMethods = new HashSet<>();

    HashSet<MethodSignature> reachedMethods = new HashSet<>();
    reachedMethods.add(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Act
    Node actualReconstructCallGraphResult = concurrentCallGraphResult.reconstructCallGraph(
        KotlinConstants.dummyClassPool, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, stopMethods,
        reachedMethods);

    // Assert
    MethodSignature methodSignature = actualReconstructCallGraphResult.signature;
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
    assertEquals(0, actualReconstructCallGraphResult.getPredecessorDepth());
    assertEquals(0, actualReconstructCallGraphResult.getSuccessorDepth());
    assertEquals(1, actualReconstructCallGraphResult.getAllPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestPredecessors().size());
    assertEquals(1, actualReconstructCallGraphResult.getFurthestSuccessors().size());
    assertFalse(descriptor.isIncomplete());
    assertFalse(methodSignature.isIncomplete());
    assertTrue(actualReconstructCallGraphResult.incomingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.outgoingCallLocations.isEmpty());
    assertTrue(actualReconstructCallGraphResult.predecessors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.successors.isEmpty());
    assertTrue(actualReconstructCallGraphResult.isTruncated);
  }

  /**
   * Method under test: {@link CallGraph#CallGraph()}
   */
  @Test
  public void testNewCallGraph() {
    // Arrange and Act
    CallGraph actualCallGraph = new CallGraph();

    // Assert
    assertTrue(actualCallGraph.incoming.isEmpty());
    assertTrue(actualCallGraph.outgoing.isEmpty());
  }

  /**
   * Method under test: {@link CallGraph#CallGraph(Map, Map, boolean)}
   */
  @Test
  public void testNewCallGraph2() {
    // Arrange
    HashMap<MethodSignature, Set<Call>> incoming = new HashMap<>();

    // Act
    CallGraph actualCallGraph = new CallGraph(incoming, new HashMap<>(), true);

    // Assert
    assertTrue(actualCallGraph.incoming.isEmpty());
    assertTrue(actualCallGraph.outgoing.isEmpty());
  }
}
