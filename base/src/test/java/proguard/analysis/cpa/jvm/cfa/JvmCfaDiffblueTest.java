package proguard.analysis.cpa.jvm.cfa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeExceptionCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.datastructure.CodeLocation;
import proguard.analysis.datastructure.callgraph.SymbolicCall;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodSignature;
import proguard.classfile.instruction.BranchInstruction;

public class JvmCfaDiffblueTest {
  /**
   * Test {@link JvmCfa#getAllNodes()}.
   *
   * <p>Method under test: {@link JvmCfa#getAllNodes()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stream JvmCfa.getAllNodes()"})
  public void testGetAllNodes() {
    // Arrange and Act
    Stream<JvmCfaNode> actualAllNodes = (new JvmCfa()).getAllNodes();

    // Assert
    assertTrue(actualAllNodes.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link JvmCfa#getFunctionCatchNodes(MethodSignature)}.
   *
   * <p>Method under test: {@link JvmCfa#getFunctionCatchNodes(MethodSignature)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection JvmCfa.getFunctionCatchNodes(MethodSignature)"})
  public void testGetFunctionCatchNodes() {
    // Arrange and Act
    Collection<JvmCatchCfaNode> actualFunctionCatchNodes =
        (new JvmCfa())
            .getFunctionCatchNodes(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertTrue(actualFunctionCatchNodes instanceof Set);
    assertTrue(actualFunctionCatchNodes.isEmpty());
  }

  /**
   * Test {@link JvmCfa#getFunctionCatchNode(MethodSignature, int)}.
   *
   * <p>Method under test: {@link JvmCfa#getFunctionCatchNode(MethodSignature, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCatchCfaNode JvmCfa.getFunctionCatchNode(MethodSignature, int)"})
  public void testGetFunctionCatchNode() {
    // Arrange, Act and Assert
    assertNull(
        (new JvmCfa())
            .getFunctionCatchNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2));
  }

  /**
   * Test {@link JvmCfa#addFunctionCatchNode(MethodSignature, JvmCatchCfaNode, int)}.
   *
   * <p>Method under test: {@link JvmCfa#addFunctionCatchNode(MethodSignature, JvmCatchCfaNode,
   * int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmCfa.addFunctionCatchNode(MethodSignature, JvmCatchCfaNode, int)"})
  public void testAddFunctionCatchNode() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    JvmCatchCfaNode node =
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new LibraryClass());

    // Act
    jvmCfa.addFunctionCatchNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, node, 2);

    // Assert
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    List<JvmCfaNode> collectResult = allNodes.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertSame(node, collectResult.get(0));
  }

  /**
   * Test {@link JvmCfa#addFunctionCatchNode(MethodSignature, JvmCatchCfaNode, int)}.
   *
   * <p>Method under test: {@link JvmCfa#addFunctionCatchNode(MethodSignature, JvmCatchCfaNode,
   * int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmCfa.addFunctionCatchNode(MethodSignature, JvmCatchCfaNode, int)"})
  public void testAddFunctionCatchNode2() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addFunctionCatchNode(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new LibraryClass()),
        2);
    JvmCatchCfaNode node =
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new LibraryClass());

    // Act
    jvmCfa.addFunctionCatchNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, node, 2);

    // Assert that nothing has changed
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    List<JvmCfaNode> collectResult = allNodes.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertSame(node, collectResult.get(0));
  }

  /**
   * Test {@link JvmCfa#containsFunctionCatchNode(MethodSignature, int)}.
   *
   * <p>Method under test: {@link JvmCfa#containsFunctionCatchNode(MethodSignature, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmCfa.containsFunctionCatchNode(MethodSignature, int)"})
  public void testContainsFunctionCatchNode() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addFunctionCatchNode(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new LibraryClass()),
        1);

    // Act and Assert
    assertFalse(
        jvmCfa.containsFunctionCatchNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2));
  }

  /**
   * Test {@link JvmCfa#containsFunctionCatchNode(MethodSignature, int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JvmCfa#containsFunctionCatchNode(MethodSignature, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmCfa.containsFunctionCatchNode(MethodSignature, int)"})
  public void testContainsFunctionCatchNode_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new JvmCfa())
            .containsFunctionCatchNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2));
  }

  /**
   * Test {@link JvmCfa#containsFunctionCatchNode(MethodSignature, int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JvmCfa#containsFunctionCatchNode(MethodSignature, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmCfa.containsFunctionCatchNode(MethodSignature, int)"})
  public void testContainsFunctionCatchNode_thenReturnTrue() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addFunctionCatchNode(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new LibraryClass()),
        2);

    // Act and Assert
    assertTrue(
        jvmCfa.containsFunctionCatchNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2));
  }

  /**
   * Test {@link JvmCfa#getFunctionReturnExitNode(MethodSignature, Clazz)}.
   *
   * <p>Method under test: {@link JvmCfa#getFunctionReturnExitNode(MethodSignature, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfaNode JvmCfa.getFunctionReturnExitNode(MethodSignature, Clazz)"})
  public void testGetFunctionReturnExitNode() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    MethodSignature signature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;
    LibraryClass clazz = new LibraryClass();

    // Act
    JvmCfaNode actualFunctionReturnExitNode = jvmCfa.getFunctionReturnExitNode(signature, clazz);

    // Assert
    Collection<JvmCfaEdge> enteringIntraproceduralEdges =
        actualFunctionReturnExitNode.getEnteringIntraproceduralEdges();
    assertTrue(enteringIntraproceduralEdges instanceof List);
    Collection<JvmCallCfaEdge> knownMethodCallEdges =
        actualFunctionReturnExitNode.getKnownMethodCallEdges();
    assertTrue(knownMethodCallEdges instanceof List);
    Collection<JvmCallCfaEdge> leavingInterproceduralEdges =
        actualFunctionReturnExitNode.getLeavingInterproceduralEdges();
    assertTrue(leavingInterproceduralEdges instanceof List);
    Collection<JvmCfaEdge> leavingIntraproceduralEdges =
        actualFunctionReturnExitNode.getLeavingIntraproceduralEdges();
    assertTrue(leavingIntraproceduralEdges instanceof List);
    Clazz clazz2 = actualFunctionReturnExitNode.getClazz();
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals(-1, actualFunctionReturnExitNode.getOffset());
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    assertEquals(1, allNodes.limit(5).collect(Collectors.toList()).size());
    Optional<JvmCfaEdge> enteringInvokeEdge = actualFunctionReturnExitNode.getEnteringInvokeEdge();
    assertFalse(enteringInvokeEdge.isPresent());
    assertFalse(jvmCfa.isEmpty());
    assertFalse(actualFunctionReturnExitNode.isExceptionExitNode());
    assertFalse(actualFunctionReturnExitNode.isUnknownNode());
    assertFalse(actualFunctionReturnExitNode.isEntryNode());
    assertTrue(enteringIntraproceduralEdges.isEmpty());
    assertTrue(knownMethodCallEdges.isEmpty());
    assertTrue(leavingInterproceduralEdges.isEmpty());
    assertTrue(leavingIntraproceduralEdges.isEmpty());
    assertTrue(actualFunctionReturnExitNode.getEnteringEdges().isEmpty());
    assertTrue(actualFunctionReturnExitNode.getLeavingEdges().isEmpty());
    assertTrue(actualFunctionReturnExitNode.isReturnExitNode());
    assertTrue(actualFunctionReturnExitNode.isExitNode());
    assertSame(clazz, clazz2);
    assertSame(enteringInvokeEdge, actualFunctionReturnExitNode.getLeavingInvokeEdge());
    assertSame(signature, actualFunctionReturnExitNode.getSignature());
  }

  /**
   * Test {@link JvmCfa#getFunctionReturnExitNode(MethodSignature, Clazz)}.
   *
   * <p>Method under test: {@link JvmCfa#getFunctionReturnExitNode(MethodSignature, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfaNode JvmCfa.getFunctionReturnExitNode(MethodSignature, Clazz)"})
  public void testGetFunctionReturnExitNode2() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    LibraryClass clazz = new LibraryClass();
    jvmCfa.addNodeIfAbsent(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, -1, clazz);
    MethodSignature signature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;

    // Act
    JvmCfaNode actualFunctionReturnExitNode =
        jvmCfa.getFunctionReturnExitNode(signature, new LibraryClass());

    // Assert
    Collection<JvmCfaEdge> enteringIntraproceduralEdges =
        actualFunctionReturnExitNode.getEnteringIntraproceduralEdges();
    assertTrue(enteringIntraproceduralEdges instanceof List);
    Collection<JvmCallCfaEdge> knownMethodCallEdges =
        actualFunctionReturnExitNode.getKnownMethodCallEdges();
    assertTrue(knownMethodCallEdges instanceof List);
    Collection<JvmCallCfaEdge> leavingInterproceduralEdges =
        actualFunctionReturnExitNode.getLeavingInterproceduralEdges();
    assertTrue(leavingInterproceduralEdges instanceof List);
    Collection<JvmCfaEdge> leavingIntraproceduralEdges =
        actualFunctionReturnExitNode.getLeavingIntraproceduralEdges();
    assertTrue(leavingIntraproceduralEdges instanceof List);
    Clazz clazz2 = actualFunctionReturnExitNode.getClazz();
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals(-1, actualFunctionReturnExitNode.getOffset());
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    assertEquals(1, allNodes.limit(5).collect(Collectors.toList()).size());
    Optional<JvmCfaEdge> enteringInvokeEdge = actualFunctionReturnExitNode.getEnteringInvokeEdge();
    assertFalse(enteringInvokeEdge.isPresent());
    assertFalse(jvmCfa.isEmpty());
    assertFalse(actualFunctionReturnExitNode.isExceptionExitNode());
    assertFalse(actualFunctionReturnExitNode.isUnknownNode());
    assertFalse(actualFunctionReturnExitNode.isEntryNode());
    assertTrue(enteringIntraproceduralEdges.isEmpty());
    assertTrue(knownMethodCallEdges.isEmpty());
    assertTrue(leavingInterproceduralEdges.isEmpty());
    assertTrue(leavingIntraproceduralEdges.isEmpty());
    assertTrue(actualFunctionReturnExitNode.getEnteringEdges().isEmpty());
    assertTrue(actualFunctionReturnExitNode.getLeavingEdges().isEmpty());
    assertTrue(actualFunctionReturnExitNode.isReturnExitNode());
    assertTrue(actualFunctionReturnExitNode.isExitNode());
    assertSame(clazz, clazz2);
    assertSame(enteringInvokeEdge, actualFunctionReturnExitNode.getLeavingInvokeEdge());
    assertSame(signature, actualFunctionReturnExitNode.getSignature());
  }

  /**
   * Test {@link JvmCfa#getFunctionExceptionExitNode(MethodSignature, Clazz)}.
   *
   * <p>Method under test: {@link JvmCfa#getFunctionExceptionExitNode(MethodSignature, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfaNode JvmCfa.getFunctionExceptionExitNode(MethodSignature, Clazz)"})
  public void testGetFunctionExceptionExitNode() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    MethodSignature signature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;
    LibraryClass clazz = new LibraryClass();

    // Act
    JvmCfaNode actualFunctionExceptionExitNode =
        jvmCfa.getFunctionExceptionExitNode(signature, clazz);

    // Assert
    Collection<JvmCfaEdge> enteringIntraproceduralEdges =
        actualFunctionExceptionExitNode.getEnteringIntraproceduralEdges();
    assertTrue(enteringIntraproceduralEdges instanceof List);
    Collection<JvmCallCfaEdge> knownMethodCallEdges =
        actualFunctionExceptionExitNode.getKnownMethodCallEdges();
    assertTrue(knownMethodCallEdges instanceof List);
    Collection<JvmCallCfaEdge> leavingInterproceduralEdges =
        actualFunctionExceptionExitNode.getLeavingInterproceduralEdges();
    assertTrue(leavingInterproceduralEdges instanceof List);
    Collection<JvmCfaEdge> leavingIntraproceduralEdges =
        actualFunctionExceptionExitNode.getLeavingIntraproceduralEdges();
    assertTrue(leavingIntraproceduralEdges instanceof List);
    Clazz clazz2 = actualFunctionExceptionExitNode.getClazz();
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals(-2, actualFunctionExceptionExitNode.getOffset());
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    assertEquals(1, allNodes.limit(5).collect(Collectors.toList()).size());
    Optional<JvmCfaEdge> enteringInvokeEdge =
        actualFunctionExceptionExitNode.getEnteringInvokeEdge();
    assertFalse(enteringInvokeEdge.isPresent());
    assertFalse(jvmCfa.isEmpty());
    assertFalse(actualFunctionExceptionExitNode.isReturnExitNode());
    assertFalse(actualFunctionExceptionExitNode.isUnknownNode());
    assertFalse(actualFunctionExceptionExitNode.isEntryNode());
    assertTrue(enteringIntraproceduralEdges.isEmpty());
    assertTrue(knownMethodCallEdges.isEmpty());
    assertTrue(leavingInterproceduralEdges.isEmpty());
    assertTrue(leavingIntraproceduralEdges.isEmpty());
    assertTrue(actualFunctionExceptionExitNode.getEnteringEdges().isEmpty());
    assertTrue(actualFunctionExceptionExitNode.getLeavingEdges().isEmpty());
    assertTrue(actualFunctionExceptionExitNode.isExceptionExitNode());
    assertTrue(actualFunctionExceptionExitNode.isExitNode());
    assertSame(clazz, clazz2);
    assertSame(enteringInvokeEdge, actualFunctionExceptionExitNode.getLeavingInvokeEdge());
    assertSame(signature, actualFunctionExceptionExitNode.getSignature());
  }

  /**
   * Test {@link JvmCfa#getFunctionExceptionExitNode(MethodSignature, Clazz)}.
   *
   * <p>Method under test: {@link JvmCfa#getFunctionExceptionExitNode(MethodSignature, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfaNode JvmCfa.getFunctionExceptionExitNode(MethodSignature, Clazz)"})
  public void testGetFunctionExceptionExitNode2() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    LibraryClass clazz = new LibraryClass();
    jvmCfa.addNodeIfAbsent(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, -2, clazz);
    MethodSignature signature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;

    // Act
    JvmCfaNode actualFunctionExceptionExitNode =
        jvmCfa.getFunctionExceptionExitNode(signature, new LibraryClass());

    // Assert
    Collection<JvmCfaEdge> enteringIntraproceduralEdges =
        actualFunctionExceptionExitNode.getEnteringIntraproceduralEdges();
    assertTrue(enteringIntraproceduralEdges instanceof List);
    Collection<JvmCallCfaEdge> knownMethodCallEdges =
        actualFunctionExceptionExitNode.getKnownMethodCallEdges();
    assertTrue(knownMethodCallEdges instanceof List);
    Collection<JvmCallCfaEdge> leavingInterproceduralEdges =
        actualFunctionExceptionExitNode.getLeavingInterproceduralEdges();
    assertTrue(leavingInterproceduralEdges instanceof List);
    Collection<JvmCfaEdge> leavingIntraproceduralEdges =
        actualFunctionExceptionExitNode.getLeavingIntraproceduralEdges();
    assertTrue(leavingIntraproceduralEdges instanceof List);
    Clazz clazz2 = actualFunctionExceptionExitNode.getClazz();
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals(-2, actualFunctionExceptionExitNode.getOffset());
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    assertEquals(1, allNodes.limit(5).collect(Collectors.toList()).size());
    Optional<JvmCfaEdge> enteringInvokeEdge =
        actualFunctionExceptionExitNode.getEnteringInvokeEdge();
    assertFalse(enteringInvokeEdge.isPresent());
    assertFalse(jvmCfa.isEmpty());
    assertFalse(actualFunctionExceptionExitNode.isReturnExitNode());
    assertFalse(actualFunctionExceptionExitNode.isUnknownNode());
    assertFalse(actualFunctionExceptionExitNode.isEntryNode());
    assertTrue(enteringIntraproceduralEdges.isEmpty());
    assertTrue(knownMethodCallEdges.isEmpty());
    assertTrue(leavingInterproceduralEdges.isEmpty());
    assertTrue(leavingIntraproceduralEdges.isEmpty());
    assertTrue(actualFunctionExceptionExitNode.getEnteringEdges().isEmpty());
    assertTrue(actualFunctionExceptionExitNode.getLeavingEdges().isEmpty());
    assertTrue(actualFunctionExceptionExitNode.isExceptionExitNode());
    assertTrue(actualFunctionExceptionExitNode.isExitNode());
    assertSame(clazz, clazz2);
    assertSame(enteringInvokeEdge, actualFunctionExceptionExitNode.getLeavingInvokeEdge());
    assertSame(signature, actualFunctionExceptionExitNode.getSignature());
  }

  /**
   * Test {@link JvmCfa#addNodeIfAbsent(MethodSignature, int, Clazz)}.
   *
   * <p>Method under test: {@link JvmCfa#addNodeIfAbsent(MethodSignature, int, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfaNode JvmCfa.addNodeIfAbsent(MethodSignature, int, Clazz)"})
  public void testAddNodeIfAbsent() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    // Act
    JvmCfaNode actualAddNodeIfAbsentResult =
        jvmCfa.addNodeIfAbsent(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = jvmCfa.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(actualAddNodeIfAbsentResult.getClazz() instanceof LibraryClass);
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    assertEquals(1, allNodes.limit(5).collect(Collectors.toList()).size());
    assertEquals(2, actualAddNodeIfAbsentResult.getOffset());
    assertFalse(jvmCfa.isEmpty());
    assertFalse(actualAddNodeIfAbsentResult.isEntryNode());
    assertTrue(functionEntryNodes.isEmpty());
  }

  /**
   * Test {@link JvmCfa#addNodeIfAbsent(MethodSignature, int, Clazz)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then {@link JvmCfa} (default constructor) AllNodes limit five collect toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmCfa#addNodeIfAbsent(MethodSignature, int, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfaNode JvmCfa.addNodeIfAbsent(MethodSignature, int, Clazz)"})
  public void testAddNodeIfAbsent_whenTwo_thenJvmCfaAllNodesLimitFiveCollectToListSizeIsOne() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();

    // Act
    JvmCfaNode actualAddNodeIfAbsentResult =
        jvmCfa.addNodeIfAbsent(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = jvmCfa.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(actualAddNodeIfAbsentResult.getClazz() instanceof LibraryClass);
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    assertEquals(1, allNodes.limit(5).collect(Collectors.toList()).size());
    assertEquals(2, actualAddNodeIfAbsentResult.getOffset());
    assertFalse(jvmCfa.isEmpty());
    assertFalse(actualAddNodeIfAbsentResult.isEntryNode());
    assertTrue(functionEntryNodes.isEmpty());
  }

  /**
   * Test {@link JvmCfa#addNodeIfAbsent(MethodSignature, int, Clazz)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link JvmCfa} (default constructor) FunctionEntryNodes size is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmCfa#addNodeIfAbsent(MethodSignature, int, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfaNode JvmCfa.addNodeIfAbsent(MethodSignature, int, Clazz)"})
  public void testAddNodeIfAbsent_whenZero_thenJvmCfaFunctionEntryNodesSizeIsOne() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();

    // Act
    JvmCfaNode actualAddNodeIfAbsentResult =
        jvmCfa.addNodeIfAbsent(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new LibraryClass());

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = jvmCfa.getFunctionEntryNodes();
    assertEquals(1, functionEntryNodes.size());
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(actualAddNodeIfAbsentResult.getClazz() instanceof LibraryClass);
    assertEquals(0, actualAddNodeIfAbsentResult.getOffset());
    assertTrue(actualAddNodeIfAbsentResult.isEntryNode());
  }

  /**
   * Test {@link JvmCfa#clear()}.
   *
   * <p>Method under test: {@link JvmCfa#clear()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmCfa.clear()"})
  public void testClear() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addFunctionCatchNode(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 2, new LibraryClass()),
        1);
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    jvmCfa.addUnknownTargetInterproceduralEdge(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Act
    jvmCfa.clear();

    // Assert
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(jvmCfa.isEmpty());
  }

  /**
   * Test {@link JvmCfa#clear()}.
   *
   * <p>Method under test: {@link JvmCfa#clear()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmCfa.clear()"})
  public void testClear2() {
    // Arrange
    JvmCatchCfaNode node =
        new JvmCatchCfaNode(
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 2, new LibraryClass());
    node.addLeavingEdge(new JvmAssumeExceptionCfaEdge(true, 1));

    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addFunctionCatchNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, node, 1);
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    jvmCfa.addUnknownTargetInterproceduralEdge(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Act
    jvmCfa.clear();

    // Assert
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(jvmCfa.isEmpty());
  }

  /**
   * Test {@link JvmCfa#clear()}.
   *
   * <ul>
   *   <li>Given {@link JvmCfa} (default constructor).
   *   <li>Then {@link JvmCfa} (default constructor) AllNodes limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmCfa#clear()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmCfa.clear()"})
  public void testClear_givenJvmCfa_thenJvmCfaAllNodesLimitFiveCollectToListEmpty() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();

    // Act
    jvmCfa.clear();

    // Assert that nothing has changed
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(jvmCfa.isEmpty());
  }

  /**
   * Test {@link JvmCfa#clear()}.
   *
   * <ul>
   *   <li>Then {@link JvmCfa} (default constructor) AllNodes limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link JvmCfa#clear()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmCfa.clear()"})
  public void testClear_thenJvmCfaAllNodesLimitFiveCollectToListEmpty() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    LibraryClass clazz = new LibraryClass();
    CodeLocation caller = new CodeLocation(clazz, new LibraryMethod(), 2);

    jvmCfa.addUnknownTargetInterproceduralEdge(
        new SymbolicCall(
            caller,
            ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE,
            1,
            new BranchInstruction((byte) 'A', 1),
            true,
            true));

    // Act
    jvmCfa.clear();

    // Assert
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(jvmCfa.isEmpty());
  }

  /**
   * Test new {@link JvmCfa} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link JvmCfa}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmCfa.<init>()"})
  public void testNewJvmCfa() {
    // Arrange and Act
    JvmCfa actualJvmCfa = new JvmCfa();

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = actualJvmCfa.getFunctionEntryNodes();
    assertTrue(functionEntryNodes instanceof Set);
    assertTrue(functionEntryNodes.isEmpty());
    Stream<JvmCfaNode> allNodes = actualJvmCfa.getAllNodes();
    assertTrue(allNodes.limit(5).collect(Collectors.toList()).isEmpty());
    assertTrue(actualJvmCfa.isEmpty());
  }
}
