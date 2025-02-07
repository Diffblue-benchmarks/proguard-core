package proguard.analysis.cpa.jvm.util;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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

class CfaUtilDiffblueTest {
  /**
   * Test {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool)} with {@code
   * programClassPool}.
   *
   * <p>Method under test: {@link CfaUtil#createIntraproceduralCfaFromClassPool(ClassPool)}
   */
  @Test
  @DisplayName("Test createIntraproceduralCfaFromClassPool(ClassPool) with 'programClassPool'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createIntraproceduralCfaFromClassPool(proguard.classfile.ClassPool)"
  })
  void testCreateIntraproceduralCfaFromClassPoolWithProgramClassPool() {
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
  @DisplayName(
      "Test createIntraproceduralCfaFromClassPool(ClassPool, Supplier) with 'programClassPool', 'shouldAnalyzeNextCodeAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createIntraproceduralCfaFromClassPool(proguard.classfile.ClassPool, java.util.function.Supplier)"
  })
  void
      testCreateIntraproceduralCfaFromClassPoolWithProgramClassPoolShouldAnalyzeNextCodeAttribute() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaFromClassPoolResult =
        CfaUtil.createIntraproceduralCfaFromClassPool(new ClassPool(), mock(Supplier.class));

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
  @DisplayName(
      "Test createIntraproceduralCfaFromClassPool(ClassPool, Supplier) with 'programClassPool', 'shouldAnalyzeNextCodeAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createIntraproceduralCfaFromClassPool(proguard.classfile.ClassPool, java.util.function.Supplier)"
  })
  void
      testCreateIntraproceduralCfaFromClassPoolWithProgramClassPoolShouldAnalyzeNextCodeAttribute2() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaFromClassPoolResult =
        CfaUtil.createIntraproceduralCfaFromClassPool(
            new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")),
            mock(Supplier.class));

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
  @DisplayName(
      "Test createIntraproceduralCfaFromClassPool(ClassPool) with 'programClassPool'; when ClassPool()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createIntraproceduralCfaFromClassPool(proguard.classfile.ClassPool)"
  })
  void testCreateIntraproceduralCfaFromClassPoolWithProgramClassPool_whenClassPool() {
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
  @DisplayName("Test createIntraproceduralCfa(ClassPool) with 'programClassPool'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createIntraproceduralCfa(proguard.classfile.ClassPool)"
  })
  void testCreateIntraproceduralCfaWithProgramClassPool() {
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
  @DisplayName(
      "Test createIntraproceduralCfa(ClassPool, Supplier) with 'programClassPool', 'shouldAnalyzeNextCodeAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createIntraproceduralCfa(proguard.classfile.ClassPool, java.util.function.Supplier)"
  })
  void testCreateIntraproceduralCfaWithProgramClassPoolShouldAnalyzeNextCodeAttribute() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaResult =
        CfaUtil.createIntraproceduralCfa(new ClassPool(), mock(Supplier.class));

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
  @DisplayName(
      "Test createIntraproceduralCfa(ClassPool, Supplier) with 'programClassPool', 'shouldAnalyzeNextCodeAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createIntraproceduralCfa(proguard.classfile.ClassPool, java.util.function.Supplier)"
  })
  void testCreateIntraproceduralCfaWithProgramClassPoolShouldAnalyzeNextCodeAttribute2() {
    // Arrange and Act
    JvmCfa actualCreateIntraproceduralCfaResult =
        CfaUtil.createIntraproceduralCfa(
            new ClassPool(new LibraryClass(1, "This Class Name", "Super Class Name")),
            mock(Supplier.class));

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
  @DisplayName("Test createIntraproceduralCfa(ClassPool) with 'programClassPool'; when ClassPool()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createIntraproceduralCfa(proguard.classfile.ClassPool)"
  })
  void testCreateIntraproceduralCfaWithProgramClassPool_whenClassPool() {
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
  @DisplayName("Test createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(proguard.classfile.ClassPool, proguard.analysis.datastructure.callgraph.CallGraph)"
  })
  void testCreateInterproceduralCfaFromClassPoolAndCallGraph() {
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
  @DisplayName("Test createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(proguard.classfile.ClassPool, proguard.analysis.datastructure.callgraph.CallGraph)"
  })
  void testCreateInterproceduralCfaFromClassPoolAndCallGraph2() {
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
  @DisplayName("Test createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(proguard.classfile.ClassPool, proguard.analysis.datastructure.callgraph.CallGraph)"
  })
  void testCreateInterproceduralCfaFromClassPoolAndCallGraph3() {
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
  @DisplayName("Test createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(proguard.classfile.ClassPool, proguard.analysis.datastructure.callgraph.CallGraph)"
  })
  void testCreateInterproceduralCfaFromClassPoolAndCallGraph4() {
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
  @DisplayName(
      "Test createInterproceduralCfaFromClassPoolAndCallGraph(ClassPool, CallGraph); when concurrentCallGraph")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfaFromClassPoolAndCallGraph(proguard.classfile.ClassPool, proguard.analysis.datastructure.callgraph.CallGraph)"
  })
  void testCreateInterproceduralCfaFromClassPoolAndCallGraph_whenConcurrentCallGraph() {
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
  @DisplayName(
      "Test createInterproceduralCfa(ClassPool, CallGraph) with 'programClassPool', 'callGraph'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfa(proguard.classfile.ClassPool, proguard.analysis.datastructure.callgraph.CallGraph)"
  })
  void testCreateInterproceduralCfaWithProgramClassPoolCallGraph() {
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
  @DisplayName(
      "Test createInterproceduralCfa(ClassPool, CallGraph) with 'programClassPool', 'callGraph'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfa(proguard.classfile.ClassPool, proguard.analysis.datastructure.callgraph.CallGraph)"
  })
  void testCreateInterproceduralCfaWithProgramClassPoolCallGraph2() {
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
  @DisplayName(
      "Test createInterproceduralCfa(ClassPool, CallGraph) with 'programClassPool', 'callGraph'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfa(proguard.classfile.ClassPool, proguard.analysis.datastructure.callgraph.CallGraph)"
  })
  void testCreateInterproceduralCfaWithProgramClassPoolCallGraph3() {
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
  @DisplayName(
      "Test createInterproceduralCfa(ClassPool, CallGraph) with 'programClassPool', 'callGraph'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfa(proguard.classfile.ClassPool, proguard.analysis.datastructure.callgraph.CallGraph)"
  })
  void testCreateInterproceduralCfaWithProgramClassPoolCallGraph4() {
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
  @DisplayName(
      "Test createInterproceduralCfa(ClassPool, CallGraph) with 'programClassPool', 'callGraph'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfa(proguard.classfile.ClassPool, proguard.analysis.datastructure.callgraph.CallGraph)"
  })
  void testCreateInterproceduralCfaWithProgramClassPoolCallGraph5() {
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
  @DisplayName(
      "Test createInterproceduralCfa(ClassPool, ClassPool) with 'programClassPool', 'libraryClassPool'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfa(proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testCreateInterproceduralCfaWithProgramClassPoolLibraryClassPool() {
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
  @DisplayName(
      "Test createInterproceduralCfa(ClassPool, ClassPool) with 'programClassPool', 'libraryClassPool'; when ClassPool()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfa(proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testCreateInterproceduralCfaWithProgramClassPoolLibraryClassPool_whenClassPool() {
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
  @DisplayName(
      "Test createInterproceduralCfa(ClassPool) with 'programClassPool'; then FunctionEntryNodes return Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfa(proguard.classfile.ClassPool)"
  })
  void testCreateInterproceduralCfaWithProgramClassPool_thenFunctionEntryNodesReturnSet() {
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
  @DisplayName("Test createInterproceduralCfaFromClassPool(ClassPool) with 'programClassPool'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfaFromClassPool(proguard.classfile.ClassPool)"
  })
  void testCreateInterproceduralCfaFromClassPoolWithProgramClassPool() {
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
  @DisplayName(
      "Test createInterproceduralCfaFromClassPool(ClassPool, ClassPool) with 'programClassPool', 'libraryClassPool'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfaFromClassPool(proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testCreateInterproceduralCfaFromClassPoolWithProgramClassPoolLibraryClassPool() {
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
  @DisplayName(
      "Test createInterproceduralCfaFromClassPool(ClassPool, ClassPool) with 'programClassPool', 'libraryClassPool'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfaFromClassPool(proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testCreateInterproceduralCfaFromClassPoolWithProgramClassPoolLibraryClassPool2() {
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
  @DisplayName(
      "Test createInterproceduralCfaFromClassPool(ClassPool) with 'programClassPool'; when ClassPool()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.JvmCfa proguard.analysis.cpa.jvm.util.CfaUtil.createInterproceduralCfaFromClassPool(proguard.classfile.ClassPool)"
  })
  void testCreateInterproceduralCfaFromClassPoolWithProgramClassPool_whenClassPool() {
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
