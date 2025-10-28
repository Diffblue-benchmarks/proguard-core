package proguard.analysis.cpa.jvm.util;

import static org.junit.Assert.assertTrue;
import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.CallGraph;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.ClassPool;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.kotlin.KotlinConstants;

public class CfaUtilDiffblueTest {
  /**
   * Method under test:
   * {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool)}
   */
  @Test
  public void testCreateIntraproceduralCfaFromClassPool() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaFromClassPoolResult = CfaUtil
        .createIntraproceduralCfaFromClassPool(new ClassPool());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateIntraproceduralCfaFromClassPoolResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool)}
   */
  @Test
  public void testCreateIntraproceduralCfaFromClassPool2() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaFromClassPoolResult = CfaUtil.createIntraproceduralCfaFromClassPool(
        new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")));

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateIntraproceduralCfaFromClassPoolResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool, Supplier)}
   */
  @Test
  public void testCreateIntraproceduralCfaFromClassPool3() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaFromClassPoolResult = CfaUtil
        .createIntraproceduralCfaFromClassPool(new ClassPool(), null);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateIntraproceduralCfaFromClassPoolResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool, Supplier)}
   */
  @Test
  public void testCreateIntraproceduralCfaFromClassPool4() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaFromClassPoolResult = CfaUtil.createIntraproceduralCfaFromClassPool(
        new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")), null);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateIntraproceduralCfaFromClassPoolResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Method under test: {@link CfaUtil#createIntraproceduralCfa(ClassPool)}
   */
  @Test
  public void testCreateIntraproceduralCfa() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaResult = CfaUtil.createIntraproceduralCfa(new ClassPool());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateIntraproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test: {@link CfaUtil#createIntraproceduralCfa(ClassPool)}
   */
  @Test
  public void testCreateIntraproceduralCfa2() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaResult = CfaUtil
        .createIntraproceduralCfa(new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")));

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateIntraproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createIntraproceduralCfa(ClassPool, Supplier)}
   */
  @Test
  public void testCreateIntraproceduralCfa3() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaResult = CfaUtil.createIntraproceduralCfa(new ClassPool(), null);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateIntraproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createIntraproceduralCfa(ClassPool, Supplier)}
   */
  @Test
  public void testCreateIntraproceduralCfa4() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaResult = CfaUtil
        .createIntraproceduralCfa(new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")), null);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateIntraproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}
   */
  @Test
  public void testCreateInterproceduralCfaFromClassPoolAndCallGraph() {
    // Arrange
    ClassPool programClassPool = new ClassPool();

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult = CfaUtil
        .createInterproceduralCfaFromClassPoolAndCallGraph(programClassPool, CallGraph.concurrentCallGraph());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}
   */
  @Test
  public void testCreateInterproceduralCfaFromClassPoolAndCallGraph2() {
    // Arrange
    ClassPool programClassPool = new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult = CfaUtil
        .createInterproceduralCfaFromClassPoolAndCallGraph(programClassPool, CallGraph.concurrentCallGraph());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}
   */
  @Test
  public void testCreateInterproceduralCfaFromClassPoolAndCallGraph3() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    callGraph.addCall(new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true));

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult = CfaUtil
        .createInterproceduralCfaFromClassPoolAndCallGraph(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}
   */
  @Test
  public void testCreateInterproceduralCfaFromClassPoolAndCallGraph4() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    callGraph.addCall(
        new SymbolicCall(caller, MethodSignature.UNKNOWN, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult = CfaUtil
        .createInterproceduralCfaFromClassPoolAndCallGraph(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}
   */
  @Test
  public void testCreateInterproceduralCfaFromClassPoolAndCallGraph5() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    MethodSignature target = new MethodSignature("Class Name");
    callGraph.addCall(new SymbolicCall(caller, target, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult = CfaUtil
        .createInterproceduralCfaFromClassPoolAndCallGraph(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.isEmpty());
  }

  /**
   * Method under test: {@link CfaUtil#createInterproceduralCfa(ClassPool)}
   */
  @Test
  public void testCreateInterproceduralCfa() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaResult = CfaUtil.createInterproceduralCfa(new ClassPool());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)}
   */
  @Test
  public void testCreateInterproceduralCfa2() {
    // Arrange
    ClassPool programClassPool = new ClassPool();

    // Act
    JvmCfa actualCreateInterproceduralCfaResult = CfaUtil.createInterproceduralCfa(programClassPool,
        CallGraph.concurrentCallGraph());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)}
   */
  @Test
  public void testCreateInterproceduralCfa3() {
    // Arrange
    ClassPool programClassPool = new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Act
    JvmCfa actualCreateInterproceduralCfaResult = CfaUtil.createInterproceduralCfa(programClassPool,
        CallGraph.concurrentCallGraph());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)}
   */
  @Test
  public void testCreateInterproceduralCfa4() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    callGraph.addCall(new SymbolicCall(caller, ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1,
        new BranchInstruction((byte) 'A', 1), true, true));

    // Act
    JvmCfa actualCreateInterproceduralCfaResult = CfaUtil.createInterproceduralCfa(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)}
   */
  @Test
  public void testCreateInterproceduralCfa5() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    callGraph.addCall(
        new SymbolicCall(caller, MethodSignature.UNKNOWN, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Act
    JvmCfa actualCreateInterproceduralCfaResult = CfaUtil.createInterproceduralCfa(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)}
   */
  @Test
  public void testCreateInterproceduralCfa6() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    MethodSignature target = new MethodSignature("Class Name");
    callGraph.addCall(new SymbolicCall(caller, target, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Act
    JvmCfa actualCreateInterproceduralCfaResult = CfaUtil.createInterproceduralCfa(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfa(ClassPool, ClassPool)}
   */
  @Test
  public void testCreateInterproceduralCfa7() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaResult = CfaUtil.createInterproceduralCfa(new ClassPool(),
        KotlinConstants.dummyClassPool);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfa(ClassPool, ClassPool)}
   */
  @Test
  public void testCreateInterproceduralCfa8() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaResult = CfaUtil.createInterproceduralCfa(
        new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")), KotlinConstants.dummyClassPool);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool)}
   */
  @Test
  public void testCreateInterproceduralCfaFromClassPool() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolResult = CfaUtil
        .createInterproceduralCfaFromClassPool(new ClassPool());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaFromClassPoolResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool)}
   */
  @Test
  public void testCreateInterproceduralCfaFromClassPool2() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    programClassPool.addClass("Name", new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolResult = CfaUtil
        .createInterproceduralCfaFromClassPool(programClassPool);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaFromClassPoolResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool, ClassPool)}
   */
  @Test
  public void testCreateInterproceduralCfaFromClassPool3() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolResult = CfaUtil
        .createInterproceduralCfaFromClassPool(new ClassPool(), KotlinConstants.dummyClassPool);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaFromClassPoolResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool, ClassPool)}
   */
  @Test
  public void testCreateInterproceduralCfaFromClassPool4() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolResult = CfaUtil.createInterproceduralCfaFromClassPool(
        new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")), KotlinConstants.dummyClassPool);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualCreateInterproceduralCfaFromClassPoolResult
        .getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolResult.isEmpty());
  }
}
