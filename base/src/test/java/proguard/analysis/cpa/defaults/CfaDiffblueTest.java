package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.CfaNode;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.MethodSignature;
import proguard.classfile.Signature;

class CfaDiffblueTest {
  /**
   * Test {@link Cfa#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.cpa.defaults.Cfa.isEmpty()"})
  void testIsEmpty_thenReturnFalse() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    // Act and Assert
    assertFalse(jvmCfa.isEmpty());
  }

  /**
   * Test {@link Cfa#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.cpa.defaults.Cfa.isEmpty()"})
  void testIsEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new JvmCfa()).isEmpty());
  }

  /**
   * Test {@link Cfa#getFunctionEntryNodes()}.
   *
   * <p>Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  @DisplayName("Test getFunctionEntryNodes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection proguard.analysis.cpa.defaults.Cfa.getFunctionEntryNodes()"
  })
  void testGetFunctionEntryNodes() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    // Act
    Collection<JvmCfaNode> actualFunctionEntryNodes = jvmCfa.getFunctionEntryNodes();

    // Assert
    assertTrue(actualFunctionEntryNodes instanceof Set);
    assertTrue(actualFunctionEntryNodes.isEmpty());
  }

  /**
   * Test {@link Cfa#getFunctionEntryNodes()}.
   *
   * <p>Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  @DisplayName("Test getFunctionEntryNodes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection proguard.analysis.cpa.defaults.Cfa.getFunctionEntryNodes()"
  })
  void testGetFunctionEntryNodes2() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(null, 2, new LibraryClass());

    // Act
    Collection<JvmCfaNode> actualFunctionEntryNodes = jvmCfa.getFunctionEntryNodes();

    // Assert
    assertTrue(actualFunctionEntryNodes instanceof Set);
    assertTrue(actualFunctionEntryNodes.isEmpty());
  }

  /**
   * Test {@link Cfa#getFunctionEntryNodes()}.
   *
   * <p>Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  @DisplayName("Test getFunctionEntryNodes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection proguard.analysis.cpa.defaults.Cfa.getFunctionEntryNodes()"
  })
  void testGetFunctionEntryNodes3() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());
    jvmCfa.addNodeIfAbsent(null, 2, new LibraryClass());

    // Act
    Collection<JvmCfaNode> actualFunctionEntryNodes = jvmCfa.getFunctionEntryNodes();

    // Assert
    assertTrue(actualFunctionEntryNodes instanceof Set);
    assertTrue(actualFunctionEntryNodes.isEmpty());
  }

  /**
   * Test {@link Cfa#getFunctionEntryNodes()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  @DisplayName("Test getFunctionEntryNodes(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection proguard.analysis.cpa.defaults.Cfa.getFunctionEntryNodes()"
  })
  void testGetFunctionEntryNodes_thenReturnEmpty() {
    // Arrange and Act
    Collection<JvmCfaNode> actualFunctionEntryNodes = (new JvmCfa()).getFunctionEntryNodes();

    // Assert
    assertTrue(actualFunctionEntryNodes instanceof Set);
    assertTrue(actualFunctionEntryNodes.isEmpty());
  }

  /**
   * Test {@link Cfa#getFunctionEntryNodes()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  @DisplayName("Test getFunctionEntryNodes(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection proguard.analysis.cpa.defaults.Cfa.getFunctionEntryNodes()"
  })
  void testGetFunctionEntryNodes_thenReturnSizeIsOne() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new LibraryClass());

    // Act
    Collection<JvmCfaNode> actualFunctionEntryNodes = jvmCfa.getFunctionEntryNodes();

    // Assert
    assertTrue(actualFunctionEntryNodes instanceof Set);
    assertEquals(1, actualFunctionEntryNodes.size());
  }

  /**
   * Test {@link Cfa#getFunctionEntryNode(Signature)}.
   *
   * <p>Method under test: {@link Cfa#getFunctionEntryNode(Signature)}
   */
  @Test
  @DisplayName("Test getFunctionEntryNode(Signature)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.interfaces.CfaNode proguard.analysis.cpa.defaults.Cfa.getFunctionEntryNode(proguard.classfile.Signature)"
  })
  void testGetFunctionEntryNode() {
    // Arrange, Act and Assert
    assertNull(
        (new JvmCfa())
            .getFunctionEntryNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Cfa#getFunctionEntryNode(Signature)}.
   *
   * <p>Method under test: {@link Cfa#getFunctionEntryNode(Signature)}
   */
  @Test
  @DisplayName("Test getFunctionEntryNode(Signature)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.interfaces.CfaNode proguard.analysis.cpa.defaults.Cfa.getFunctionEntryNode(proguard.classfile.Signature)"
  })
  void testGetFunctionEntryNode2() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    // Act and Assert
    assertNull(jvmCfa.getFunctionEntryNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Cfa#getFunctionNodes(Signature)}.
   *
   * <ul>
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionNodes(Signature)}
   */
  @Test
  @DisplayName("Test getFunctionNodes(Signature); then return Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection proguard.analysis.cpa.defaults.Cfa.getFunctionNodes(proguard.classfile.Signature)"
  })
  void testGetFunctionNodes_thenReturnSet() {
    // Arrange and Act
    Collection<JvmCfaNode> actualFunctionNodes =
        (new JvmCfa()).getFunctionNodes(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertTrue(actualFunctionNodes instanceof Set);
    assertTrue(actualFunctionNodes.isEmpty());
  }

  /**
   * Test {@link Cfa#getFunctionNodes(Signature)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionNodes(Signature)}
   */
  @Test
  @DisplayName("Test getFunctionNodes(Signature); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Collection proguard.analysis.cpa.defaults.Cfa.getFunctionNodes(proguard.classfile.Signature)"
  })
  void testGetFunctionNodes_thenReturnSizeIsOne() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    // Act and Assert
    assertEquals(
        1, jvmCfa.getFunctionNodes(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE).size());
  }

  /**
   * Test {@link Cfa#getFunctionNode(Clazz, Method, int)} with {@code clazz}, {@code method}, {@code
   * offset}.
   *
   * <p>Method under test: {@link Cfa#getFunctionNode(Clazz, Method, int)}
   */
  @Test
  @DisplayName("Test getFunctionNode(Clazz, Method, int) with 'clazz', 'method', 'offset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.interfaces.CfaNode proguard.analysis.cpa.defaults.Cfa.getFunctionNode(proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testGetFunctionNodeWithClazzMethodOffset() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 1, new LibraryClass());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNull(jvmCfa.getFunctionNode(clazz, new LibraryMethod(), 2));
  }

  /**
   * Test {@link Cfa#getFunctionNode(Clazz, Method, int)} with {@code clazz}, {@code method}, {@code
   * offset}.
   *
   * <p>Method under test: {@link Cfa#getFunctionNode(Clazz, Method, int)}
   */
  @Test
  @DisplayName("Test getFunctionNode(Clazz, Method, int) with 'clazz', 'method', 'offset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.interfaces.CfaNode proguard.analysis.cpa.defaults.Cfa.getFunctionNode(proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testGetFunctionNodeWithClazzMethodOffset2() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();

    // Act and Assert
    assertNull(
        jvmCfa.getFunctionNode(
            new LibraryClass(1, "This Class Name", "Super Class Name"), null, 2));
  }

  /**
   * Test {@link Cfa#getFunctionNode(Clazz, Method, int)} with {@code clazz}, {@code method}, {@code
   * offset}.
   *
   * <p>Method under test: {@link Cfa#getFunctionNode(Clazz, Method, int)}
   */
  @Test
  @DisplayName("Test getFunctionNode(Clazz, Method, int) with 'clazz', 'method', 'offset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.interfaces.CfaNode proguard.analysis.cpa.defaults.Cfa.getFunctionNode(proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testGetFunctionNodeWithClazzMethodOffset3() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(MethodSignature.UNKNOWN, 1, new LibraryClass());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNull(jvmCfa.getFunctionNode(clazz, new LibraryMethod(), 2));
  }

  /**
   * Test {@link Cfa#getFunctionNode(Clazz, Method, int)} with {@code clazz}, {@code method}, {@code
   * offset}.
   *
   * <ul>
   *   <li>When {@link LibraryMethod#LibraryMethod()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionNode(Clazz, Method, int)}
   */
  @Test
  @DisplayName(
      "Test getFunctionNode(Clazz, Method, int) with 'clazz', 'method', 'offset'; when LibraryMethod(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.interfaces.CfaNode proguard.analysis.cpa.defaults.Cfa.getFunctionNode(proguard.classfile.Clazz, proguard.classfile.Method, int)"
  })
  void testGetFunctionNodeWithClazzMethodOffset_whenLibraryMethod_thenReturnNull() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNull(jvmCfa.getFunctionNode(clazz, new LibraryMethod(), 2));
  }

  /**
   * Test {@link Cfa#getFunctionNode(Signature, int)} with {@code signature}, {@code offset}.
   *
   * <p>Method under test: {@link Cfa#getFunctionNode(Signature, int)}
   */
  @Test
  @DisplayName("Test getFunctionNode(Signature, int) with 'signature', 'offset'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.interfaces.CfaNode proguard.analysis.cpa.defaults.Cfa.getFunctionNode(proguard.classfile.Signature, int)"
  })
  void testGetFunctionNodeWithSignatureOffset() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    LibraryClass clazz = new LibraryClass();
    jvmCfa.addNodeIfAbsent(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, clazz);
    MethodSignature methodSignature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;

    // Act
    JvmCfaNode actualFunctionNode = jvmCfa.getFunctionNode(methodSignature, 2);

    // Assert
    Collection<JvmCfaEdge> enteringIntraproceduralEdges =
        actualFunctionNode.getEnteringIntraproceduralEdges();
    assertTrue(enteringIntraproceduralEdges instanceof List);
    Collection<JvmCallCfaEdge> knownMethodCallEdges = actualFunctionNode.getKnownMethodCallEdges();
    assertTrue(knownMethodCallEdges instanceof List);
    Collection<JvmCallCfaEdge> leavingInterproceduralEdges =
        actualFunctionNode.getLeavingInterproceduralEdges();
    assertTrue(leavingInterproceduralEdges instanceof List);
    Collection<JvmCfaEdge> leavingIntraproceduralEdges =
        actualFunctionNode.getLeavingIntraproceduralEdges();
    assertTrue(leavingIntraproceduralEdges instanceof List);
    Clazz clazz2 = actualFunctionNode.getClazz();
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals(2, actualFunctionNode.getOffset());
    Optional<JvmCfaEdge> enteringInvokeEdge = actualFunctionNode.getEnteringInvokeEdge();
    assertFalse(enteringInvokeEdge.isPresent());
    assertFalse(actualFunctionNode.isExceptionExitNode());
    assertFalse(actualFunctionNode.isReturnExitNode());
    assertFalse(actualFunctionNode.isUnknownNode());
    assertFalse(actualFunctionNode.isEntryNode());
    assertFalse(actualFunctionNode.isExitNode());
    assertTrue(enteringIntraproceduralEdges.isEmpty());
    assertTrue(knownMethodCallEdges.isEmpty());
    assertTrue(leavingInterproceduralEdges.isEmpty());
    assertTrue(leavingIntraproceduralEdges.isEmpty());
    assertTrue(actualFunctionNode.getEnteringEdges().isEmpty());
    assertTrue(actualFunctionNode.getLeavingEdges().isEmpty());
    assertSame(clazz, clazz2);
    assertSame(enteringInvokeEdge, actualFunctionNode.getLeavingInvokeEdge());
    assertSame(methodSignature, actualFunctionNode.getSignature());
  }

  /**
   * Test {@link Cfa#getFunctionNode(Signature, int)} with {@code signature}, {@code offset}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionNode(Signature, int)}
   */
  @Test
  @DisplayName(
      "Test getFunctionNode(Signature, int) with 'signature', 'offset'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.interfaces.CfaNode proguard.analysis.cpa.defaults.Cfa.getFunctionNode(proguard.classfile.Signature, int)"
  })
  void testGetFunctionNodeWithSignatureOffset_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new JvmCfa()).getFunctionNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2));
  }

  /**
   * Test {@link Cfa#addFunctionEntryNode(Signature, CfaNode)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#addFunctionEntryNode(Signature, CfaNode)}
   */
  @Test
  @DisplayName(
      "Test addFunctionEntryNode(Signature, CfaNode); when CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.defaults.Cfa.addFunctionEntryNode(proguard.classfile.Signature, proguard.analysis.cpa.interfaces.CfaNode)"
  })
  void testAddFunctionEntryNode_whenClassloader_find_loaded_class_signature() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;

    // Act
    jvmCfa.addFunctionEntryNode(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, jvmUnknownCfaNode);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = jvmCfa.getFunctionEntryNodes();
    assertEquals(1, functionEntryNodes.size());
    assertTrue(functionEntryNodes instanceof Set);
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    List<JvmCfaNode> collectResult = allNodes.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals(1, jvmCfa.functionNodes.size());
    assertFalse(jvmCfa.isEmpty());
    assertSame(jvmUnknownCfaNode.INSTANCE, collectResult.get(0));
  }

  /**
   * Test {@link Cfa#addFunctionEntryNode(Signature, CfaNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link JvmCfa} (default constructor) {@link Cfa#functionNodes} {@code null} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#addFunctionEntryNode(Signature, CfaNode)}
   */
  @Test
  @DisplayName(
      "Test addFunctionEntryNode(Signature, CfaNode); when 'null'; then JvmCfa (default constructor) functionNodes 'null' size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.defaults.Cfa.addFunctionEntryNode(proguard.classfile.Signature, proguard.analysis.cpa.interfaces.CfaNode)"
  })
  void testAddFunctionEntryNode_whenNull_thenJvmCfaFunctionNodesNullSizeIsOne() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;

    // Act
    jvmCfa.addFunctionEntryNode(null, jvmUnknownCfaNode);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = jvmCfa.getFunctionEntryNodes();
    assertEquals(1, functionEntryNodes.size());
    assertTrue(functionEntryNodes instanceof Set);
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    List<JvmCfaNode> collectResult = allNodes.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    Map<MethodSignature, Map<Integer, JvmCfaNode>> methodSignatureMapMap = jvmCfa.functionNodes;
    assertEquals(1, methodSignatureMapMap.size());
    Map<Integer, JvmCfaNode> getResult = methodSignatureMapMap.get(null);
    assertEquals(1, getResult.size());
    assertFalse(jvmCfa.isEmpty());
    JvmUnknownCfaNode jvmUnknownCfaNode2 = jvmUnknownCfaNode.INSTANCE;
    assertSame(jvmUnknownCfaNode2, collectResult.get(0));
    assertSame(jvmUnknownCfaNode2, getResult.get(0));
  }

  /**
   * Test {@link Cfa#addFunctionNode(Signature, CfaNode, int)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#addFunctionNode(Signature, CfaNode, int)}
   */
  @Test
  @DisplayName(
      "Test addFunctionNode(Signature, CfaNode, int); when CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.defaults.Cfa.addFunctionNode(proguard.classfile.Signature, proguard.analysis.cpa.interfaces.CfaNode, int)"
  })
  void testAddFunctionNode_whenClassloader_find_loaded_class_signature() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;

    // Act
    jvmCfa.addFunctionNode(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, jvmUnknownCfaNode, 2);

    // Assert
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    List<JvmCfaNode> collectResult = allNodes.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals(1, jvmCfa.functionNodes.size());
    assertFalse(jvmCfa.isEmpty());
    assertSame(jvmUnknownCfaNode.INSTANCE, collectResult.get(0));
  }

  /**
   * Test {@link Cfa#addFunctionNode(Signature, CfaNode, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link JvmCfa} (default constructor) {@link Cfa#functionNodes} {@code null} size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#addFunctionNode(Signature, CfaNode, int)}
   */
  @Test
  @DisplayName(
      "Test addFunctionNode(Signature, CfaNode, int); when 'null'; then JvmCfa (default constructor) functionNodes 'null' size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.defaults.Cfa.addFunctionNode(proguard.classfile.Signature, proguard.analysis.cpa.interfaces.CfaNode, int)"
  })
  void testAddFunctionNode_whenNull_thenJvmCfaFunctionNodesNullSizeIsOne() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;

    // Act
    jvmCfa.addFunctionNode(null, jvmUnknownCfaNode, 2);

    // Assert
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    List<JvmCfaNode> collectResult = allNodes.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    Map<MethodSignature, Map<Integer, JvmCfaNode>> methodSignatureMapMap = jvmCfa.functionNodes;
    assertEquals(1, methodSignatureMapMap.size());
    Map<Integer, JvmCfaNode> getResult = methodSignatureMapMap.get(null);
    assertEquals(1, getResult.size());
    assertFalse(jvmCfa.isEmpty());
    JvmUnknownCfaNode jvmUnknownCfaNode2 = jvmUnknownCfaNode.INSTANCE;
    assertSame(jvmUnknownCfaNode2, collectResult.get(0));
    assertSame(jvmUnknownCfaNode2, getResult.get(2));
  }
}
