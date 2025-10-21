package proguard.analysis.cpa.jvm.util;

import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool)} with {@code
   * programClassPool}.
   *
   * <p>Method under test: {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createIntraproceduralCfaFromClassPool(ClassPool)"})
  public void testCreateIntraproceduralCfaFromClassPoolWithProgramClassPool() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaFromClassPoolResult =
        CfaUtil.createIntraproceduralCfaFromClassPool(
            new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")));

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateIntraproceduralCfaFromClassPoolResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool, Supplier)} with {@code
   * programClassPool}, {@code shouldAnalyzeNextCodeAttribute}.
   *
   * <p>Method under test: {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool,
   * Supplier)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createIntraproceduralCfaFromClassPool(ClassPool, Supplier)"})
  public void
      testCreateIntraproceduralCfaFromClassPoolWithProgramClassPoolShouldAnalyzeNextCodeAttribute() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaFromClassPoolResult =
        CfaUtil.createIntraproceduralCfaFromClassPool(new ClassPool(), null);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateIntraproceduralCfaFromClassPoolResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool, Supplier)} with {@code
   * programClassPool}, {@code shouldAnalyzeNextCodeAttribute}.
   *
   * <p>Method under test: {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool,
   * Supplier)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createIntraproceduralCfaFromClassPool(ClassPool, Supplier)"})
  public void
      testCreateIntraproceduralCfaFromClassPoolWithProgramClassPoolShouldAnalyzeNextCodeAttribute2() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaFromClassPoolResult =
        CfaUtil.createIntraproceduralCfaFromClassPool(
            new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")), null);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateIntraproceduralCfaFromClassPoolResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool)} with {@code
   * programClassPool}.
   *
   * <ul>
   *   <li>When {@link ClassPool#ClassPool()}.
   * </ul>
   *
   * <p>Method under test: {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createIntraproceduralCfaFromClassPool(ClassPool)"})
  public void testCreateIntraproceduralCfaFromClassPoolWithProgramClassPool_whenClassPool() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaFromClassPoolResult =
        CfaUtil.createIntraproceduralCfaFromClassPool(new ClassPool());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateIntraproceduralCfaFromClassPoolResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createIntraproceduralCfa(ClassPool)} with {@code programClassPool}.
   *
   * <p>Method under test: {@link CfaUtil#createIntraproceduralCfa(ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createIntraproceduralCfa(ClassPool)"})
  public void testCreateIntraproceduralCfaWithProgramClassPool() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaResult =
        CfaUtil.createIntraproceduralCfa(
            new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")));

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateIntraproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createIntraproceduralCfa(ClassPool, Supplier)} with {@code
   * programClassPool}, {@code shouldAnalyzeNextCodeAttribute}.
   *
   * <p>Method under test: {@link CfaUtil#createIntraproceduralCfa(ClassPool, Supplier)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createIntraproceduralCfa(ClassPool, Supplier)"})
  public void testCreateIntraproceduralCfaWithProgramClassPoolShouldAnalyzeNextCodeAttribute() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaResult =
        CfaUtil.createIntraproceduralCfa(new ClassPool(), null);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateIntraproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createIntraproceduralCfa(ClassPool, Supplier)} with {@code
   * programClassPool}, {@code shouldAnalyzeNextCodeAttribute}.
   *
   * <p>Method under test: {@link CfaUtil#createIntraproceduralCfa(ClassPool, Supplier)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createIntraproceduralCfa(ClassPool, Supplier)"})
  public void testCreateIntraproceduralCfaWithProgramClassPoolShouldAnalyzeNextCodeAttribute2() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaResult =
        CfaUtil.createIntraproceduralCfa(
            new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")), null);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateIntraproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createIntraproceduralCfa(ClassPool)} with {@code programClassPool}.
   *
   * <ul>
   *   <li>When {@link ClassPool#ClassPool()}.
   * </ul>
   *
   * <p>Method under test: {@link CfaUtil#createIntraproceduralCfa(ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createIntraproceduralCfa(ClassPool)"})
  public void testCreateIntraproceduralCfaWithProgramClassPool_whenClassPool() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaResult = CfaUtil.createIntraproceduralCfa(new ClassPool());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateIntraproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateIntraproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateIntraproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}.
   *
   * <p>Method under test: {@link
   * CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "JvmCfa CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)"
  })
  public void testCreateInterproceduralCfaFromClassPoolAndCallGraph() {
    // Arrange
    ClassPool programClassPool =
        new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult =
        CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(
            programClassPool, CallGraph.concurrentCallGraph());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes =
        actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}.
   *
   * <p>Method under test: {@link
   * CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "JvmCfa CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)"
  })
  public void testCreateInterproceduralCfaFromClassPoolAndCallGraph2() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    callGraph.addCall(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult =
        CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes =
        actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}.
   *
   * <p>Method under test: {@link
   * CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "JvmCfa CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)"
  })
  public void testCreateInterproceduralCfaFromClassPoolAndCallGraph3() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    callGraph.addCall(
        new SymbolicCall(
            caller, MethodSignature.UNKNOWN, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult =
        CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes =
        actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}.
   *
   * <p>Method under test: {@link
   * CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "JvmCfa CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)"
  })
  public void testCreateInterproceduralCfaFromClassPoolAndCallGraph4() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    MethodSignature target = new MethodSignature("Class Name");
    callGraph.addCall(
        new SymbolicCall(caller, target, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult =
        CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes =
        actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}.
   *
   * <ul>
   *   <li>When concurrentCallGraph.
   * </ul>
   *
   * <p>Method under test: {@link
   * CfaUtil#createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "JvmCfa CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)"
  })
  public void testCreateInterproceduralCfaFromClassPoolAndCallGraph_whenConcurrentCallGraph() {
    // Arrange
    ClassPool programClassPool = new ClassPool();

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult =
        CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(
            programClassPool, CallGraph.concurrentCallGraph());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes =
        actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolAndCallGraphResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)} with {@code
   * programClassPool}, {@code callGraph}.
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfa(ClassPool, CallGraph)"})
  public void testCreateInterproceduralCfaWithProgramClassPoolCallGraph() {
    // Arrange
    ClassPool programClassPool = new ClassPool();

    // Act
    JvmCfa actualCreateInterproceduralCfaResult =
        CfaUtil.createInterproceduralCfa(programClassPool, CallGraph.concurrentCallGraph());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)} with {@code
   * programClassPool}, {@code callGraph}.
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfa(ClassPool, CallGraph)"})
  public void testCreateInterproceduralCfaWithProgramClassPoolCallGraph2() {
    // Arrange
    ClassPool programClassPool =
        new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Act
    JvmCfa actualCreateInterproceduralCfaResult =
        CfaUtil.createInterproceduralCfa(programClassPool, CallGraph.concurrentCallGraph());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)} with {@code
   * programClassPool}, {@code callGraph}.
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfa(ClassPool, CallGraph)"})
  public void testCreateInterproceduralCfaWithProgramClassPoolCallGraph3() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    callGraph.addCall(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Act
    JvmCfa actualCreateInterproceduralCfaResult =
        CfaUtil.createInterproceduralCfa(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)} with {@code
   * programClassPool}, {@code callGraph}.
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfa(ClassPool, CallGraph)"})
  public void testCreateInterproceduralCfaWithProgramClassPoolCallGraph4() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    callGraph.addCall(
        new SymbolicCall(
            caller, MethodSignature.UNKNOWN, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Act
    JvmCfa actualCreateInterproceduralCfaResult =
        CfaUtil.createInterproceduralCfa(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)} with {@code
   * programClassPool}, {@code callGraph}.
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfa(ClassPool, CallGraph)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfa(ClassPool, CallGraph)"})
  public void testCreateInterproceduralCfaWithProgramClassPoolCallGraph5() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    CallGraph callGraph = CallGraph.concurrentCallGraph();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    MethodSignature target = new MethodSignature("Class Name");
    callGraph.addCall(
        new SymbolicCall(caller, target, 1, new BranchInstruction((byte) 'A', 1), true, true));

    // Act
    JvmCfa actualCreateInterproceduralCfaResult =
        CfaUtil.createInterproceduralCfa(programClassPool, callGraph);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfa(ClassPool, ClassPool)} with {@code
   * programClassPool}, {@code libraryClassPool}.
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfa(ClassPool, ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfa(ClassPool, ClassPool)"})
  public void testCreateInterproceduralCfaWithProgramClassPoolLibraryClassPool() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaResult =
        CfaUtil.createInterproceduralCfa(
            new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")),
            KotlinConstants.dummyClassPool);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfa(ClassPool, ClassPool)} with {@code
   * programClassPool}, {@code libraryClassPool}.
   *
   * <ul>
   *   <li>When {@link ClassPool#ClassPool()}.
   * </ul>
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfa(ClassPool, ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfa(ClassPool, ClassPool)"})
  public void testCreateInterproceduralCfaWithProgramClassPoolLibraryClassPool_whenClassPool() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaResult =
        CfaUtil.createInterproceduralCfa(new ClassPool(), KotlinConstants.dummyClassPool);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfa(ClassPool)} with {@code programClassPool}.
   *
   * <ul>
   *   <li>Then FunctionEntryNodes return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfa(ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfa(ClassPool)"})
  public void testCreateInterproceduralCfaWithProgramClassPool_thenFunctionEntryNodesReturnSet() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaResult = CfaUtil.createInterproceduralCfa(new ClassPool());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool)} with {@code
   * programClassPool}.
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfaFromClassPool(ClassPool)"})
  public void testCreateInterproceduralCfaFromClassPoolWithProgramClassPool() {
    // Arrange
    ClassPool programClassPool = new ClassPool();
    programClassPool.addClass("Name", new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolResult =
        CfaUtil.createInterproceduralCfaFromClassPool(programClassPool);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaFromClassPoolResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool, ClassPool)} with {@code
   * programClassPool}, {@code libraryClassPool}.
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool,
   * ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfaFromClassPool(ClassPool, ClassPool)"})
  public void testCreateInterproceduralCfaFromClassPoolWithProgramClassPoolLibraryClassPool() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolResult =
        CfaUtil.createInterproceduralCfaFromClassPool(
            new ClassPool(), KotlinConstants.dummyClassPool);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaFromClassPoolResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool, ClassPool)} with {@code
   * programClassPool}, {@code libraryClassPool}.
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool,
   * ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfaFromClassPool(ClassPool, ClassPool)"})
  public void testCreateInterproceduralCfaFromClassPoolWithProgramClassPoolLibraryClassPool2() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolResult =
        CfaUtil.createInterproceduralCfaFromClassPool(
            new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")),
            KotlinConstants.dummyClassPool);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaFromClassPoolResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolResult.isEmpty());
  }

  /**
   * Test {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool)} with {@code
   * programClassPool}.
   *
   * <ul>
   *   <li>When {@link ClassPool#ClassPool()}.
   * </ul>
   *
   * <p>Method under test: {@link CfaUtil#createInterproceduralCfaFromClassPool(ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfa CfaUtil.createInterproceduralCfaFromClassPool(ClassPool)"})
  public void testCreateInterproceduralCfaFromClassPoolWithProgramClassPool_whenClassPool() {
    // Arrange and Act
    JvmCfa actualCreateInterproceduralCfaFromClassPoolResult =
        CfaUtil.createInterproceduralCfaFromClassPool(new ClassPool());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes =
        actualCreateInterproceduralCfaFromClassPoolResult.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualCreateInterproceduralCfaFromClassPoolResult.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualCreateInterproceduralCfaFromClassPoolResult.isEmpty());
  }
}
