package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.CfaNode;
import proguard.analysis.cpa.jvm.cfa.JvmCfa;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Cfa.isEmpty()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Cfa.isEmpty()"})
  void testIsEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new JvmCfa().isEmpty());
  }

  /**
   * Test {@link Cfa#getFunctionEntryNodes()}.
   *
   * <p>Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  @DisplayName("Test getFunctionEntryNodes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Cfa.getFunctionEntryNodes()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Cfa.getFunctionEntryNodes()"})
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
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  @DisplayName("Test getFunctionEntryNodes(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Cfa.getFunctionEntryNodes()"})
  void testGetFunctionEntryNodes_thenReturnEmpty() {
    // Arrange and Act
    Collection<JvmCfaNode> actualFunctionEntryNodes = new JvmCfa().getFunctionEntryNodes();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Cfa.getFunctionEntryNodes()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Cfa.getFunctionEntryNodes()"})
  void testGetFunctionEntryNodes_thenReturnSizeIsOne2() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new LibraryClass());
    jvmCfa.addNodeIfAbsent(null, 2, new LibraryClass());

    // Act
    Collection<JvmCfaNode> actualFunctionEntryNodes = jvmCfa.getFunctionEntryNodes();

    // Assert
    assertTrue(actualFunctionEntryNodes instanceof Set);
    assertEquals(1, actualFunctionEntryNodes.size());
  }

  /**
   * Test {@link Cfa#getFunctionEntryNode(Signature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionEntryNode(Signature)}
   */
  @Test
  @DisplayName("Test getFunctionEntryNode(Signature); when CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CfaNode Cfa.getFunctionEntryNode(Signature)"})
  void testGetFunctionEntryNode_whenClassloader_find_loaded_class_signature() {
    // Arrange, Act and Assert
    assertNull(
        new JvmCfa().getFunctionEntryNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
  }

  /**
   * Test {@link Cfa#getFunctionEntryNode(Signature)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionEntryNode(Signature)}
   */
  @Test
  @DisplayName("Test getFunctionEntryNode(Signature); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CfaNode Cfa.getFunctionEntryNode(Signature)"})
  void testGetFunctionEntryNode_whenNull() {
    // Arrange, Act and Assert
    assertNull(new JvmCfa().getFunctionEntryNode(null));
  }

  /**
   * Test {@link Cfa#getFunctionNodes(Signature)}.
   *
   * <ul>
   *   <li>When {@link ClassConstants#CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionNodes(Signature)}
   */
  @Test
  @DisplayName("Test getFunctionNodes(Signature); when CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Cfa.getFunctionNodes(Signature)"})
  void testGetFunctionNodes_whenClassloader_find_loaded_class_signature() {
    // Arrange and Act
    Collection<JvmCfaNode> actualFunctionNodes =
        new JvmCfa().getFunctionNodes(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertTrue(actualFunctionNodes instanceof Set);
    assertTrue(actualFunctionNodes.isEmpty());
  }

  /**
   * Test {@link Cfa#getFunctionNodes(Signature)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionNodes(Signature)}
   */
  @Test
  @DisplayName("Test getFunctionNodes(Signature); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection Cfa.getFunctionNodes(Signature)"})
  void testGetFunctionNodes_whenNull() {
    // Arrange and Act
    Collection<JvmCfaNode> actualFunctionNodes = new JvmCfa().getFunctionNodes(null);

    // Assert
    assertTrue(actualFunctionNodes instanceof Set);
    assertTrue(actualFunctionNodes.isEmpty());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CfaNode Cfa.getFunctionNode(Clazz, Method, int)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CfaNode Cfa.getFunctionNode(Signature, int)"})
  void testGetFunctionNodeWithSignatureOffset() {
    // Arrange, Act and Assert
    assertNull(
        new JvmCfa().getFunctionNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2));
  }

  /**
   * Test {@link Cfa#getFunctionNode(Signature, int)} with {@code signature}, {@code offset}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Cfa#getFunctionNode(Signature, int)}
   */
  @Test
  @DisplayName("Test getFunctionNode(Signature, int) with 'signature', 'offset'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CfaNode Cfa.getFunctionNode(Signature, int)"})
  void testGetFunctionNodeWithSignatureOffset_whenNull() {
    // Arrange, Act and Assert
    assertNull(new JvmCfa().getFunctionNode(null, 2));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cfa.addFunctionEntryNode(Signature, CfaNode)"})
  void testAddFunctionEntryNode_whenClassloader_find_loaded_class_signature() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();

    // Act
    jvmCfa.addFunctionEntryNode(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, JvmUnknownCfaNode.INSTANCE);

    // Assert
    Collection<JvmCfaNode> functionEntryNodes = jvmCfa.getFunctionEntryNodes();
    assertEquals(1, functionEntryNodes.size());
    assertTrue(functionEntryNodes instanceof Set);
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    List<JvmCfaNode> collectResult = allNodes.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals(1, jvmCfa.functionNodes.size());
    assertFalse(jvmCfa.isEmpty());
    assertSame(JvmUnknownCfaNode.INSTANCE, collectResult.get(0));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cfa.addFunctionEntryNode(Signature, CfaNode)"})
  void testAddFunctionEntryNode_whenNull_thenJvmCfaFunctionNodesNullSizeIsOne() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();

    // Act
    jvmCfa.addFunctionEntryNode(null, JvmUnknownCfaNode.INSTANCE);

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
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;
    assertSame(jvmUnknownCfaNode, collectResult.get(0));
    assertSame(jvmUnknownCfaNode, getResult.get(0));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cfa.addFunctionNode(Signature, CfaNode, int)"})
  void testAddFunctionNode_whenClassloader_find_loaded_class_signature() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();

    // Act
    jvmCfa.addFunctionNode(
        ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, JvmUnknownCfaNode.INSTANCE, 2);

    // Assert
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    List<JvmCfaNode> collectResult = allNodes.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals(1, jvmCfa.functionNodes.size());
    assertFalse(jvmCfa.isEmpty());
    assertSame(JvmUnknownCfaNode.INSTANCE, collectResult.get(0));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cfa.addFunctionNode(Signature, CfaNode, int)"})
  void testAddFunctionNode_whenNull_thenJvmCfaFunctionNodesNullSizeIsOne() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();

    // Act
    jvmCfa.addFunctionNode(null, JvmUnknownCfaNode.INSTANCE, 2);

    // Assert
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    List<JvmCfaNode> collectResult = allNodes.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    Map<MethodSignature, Map<Integer, JvmCfaNode>> methodSignatureMapMap = jvmCfa.functionNodes;
    assertEquals(1, methodSignatureMapMap.size());
    Map<Integer, JvmCfaNode> getResult = methodSignatureMapMap.get(null);
    assertEquals(1, getResult.size());
    assertFalse(jvmCfa.isEmpty());
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;
    assertSame(jvmUnknownCfaNode, collectResult.get(0));
    assertSame(jvmUnknownCfaNode, getResult.get(2));
  }
}
