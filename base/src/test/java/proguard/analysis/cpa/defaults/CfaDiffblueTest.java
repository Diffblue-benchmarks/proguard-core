package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
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

public class CfaDiffblueTest {
  /**
   * Method under test: {@link Cfa#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new JvmCfa()).isEmpty());
  }

  /**
   * Method under test: {@link Cfa#isEmpty()}
   */
  @Test
  public void testIsEmpty2() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    // Act and Assert
    assertFalse(jvmCfa.isEmpty());
  }

  /**
   * Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  public void testGetFunctionEntryNodes() {
    // Arrange and Act
    Collection<JvmCfaNode> actualFunctionEntryNodes = (new JvmCfa()).getFunctionEntryNodes();

    // Assert
    assertTrue(actualFunctionEntryNodes instanceof Set);
    assertTrue(actualFunctionEntryNodes.isEmpty());
  }

  /**
   * Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  public void testGetFunctionEntryNodes2() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());

    // Act
    Collection<JvmCfaNode> actualFunctionEntryNodes = jvmCfa.getFunctionEntryNodes();

    // Assert
    assertTrue(actualFunctionEntryNodes instanceof Set);
    assertTrue(actualFunctionEntryNodes.isEmpty());
  }

  /**
   * Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  public void testGetFunctionEntryNodes3() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 0, new LibraryClass());

    // Act
    Collection<JvmCfaNode> actualFunctionEntryNodes = jvmCfa.getFunctionEntryNodes();

    // Assert
    assertTrue(actualFunctionEntryNodes instanceof Set);
    assertEquals(1, actualFunctionEntryNodes.size());
  }

  /**
   * Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  public void testGetFunctionEntryNodes4() {
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
   * Method under test: {@link Cfa#getFunctionEntryNodes()}
   */
  @Test
  public void testGetFunctionEntryNodes5() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    jvmCfa.addNodeIfAbsent(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, new LibraryClass());
    jvmCfa.addNodeIfAbsent(null, 2, new LibraryClass());

    // Act
    Collection<JvmCfaNode> actualFunctionEntryNodes = jvmCfa.getFunctionEntryNodes();

    // Assert
    assertTrue(actualFunctionEntryNodes instanceof Set);
    assertTrue(actualFunctionEntryNodes.isEmpty());
  }

  /**
   * Method under test: {@link Cfa#getFunctionEntryNode(Signature)}
   */
  @Test
  public void testGetFunctionEntryNode() {
    // Arrange, Act and Assert
    assertNull((new JvmCfa()).getFunctionEntryNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE));
    assertNull((new JvmCfa()).getFunctionEntryNode(null));
  }

  /**
   * Method under test: {@link Cfa#getFunctionNodes(Signature)}
   */
  @Test
  public void testGetFunctionNodes() {
    // Arrange and Act
    Collection<JvmCfaNode> actualFunctionNodes = (new JvmCfa())
        .getFunctionNodes(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE);

    // Assert
    assertTrue(actualFunctionNodes instanceof Set);
    assertTrue(actualFunctionNodes.isEmpty());
  }

  /**
   * Method under test: {@link Cfa#getFunctionNodes(Signature)}
   */
  @Test
  public void testGetFunctionNodes2() {
    // Arrange and Act
    Collection<JvmCfaNode> actualFunctionNodes = (new JvmCfa()).getFunctionNodes(null);

    // Assert
    assertTrue(actualFunctionNodes instanceof Set);
    assertTrue(actualFunctionNodes.isEmpty());
  }

  /**
   * Method under test: {@link Cfa#getFunctionNode(Clazz, Method, int)}
   */
  @Test
  public void testGetFunctionNode() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNull(jvmCfa.getFunctionNode(clazz, new LibraryMethod(), 2));
  }

  /**
   * Method under test: {@link Cfa#getFunctionNode(Clazz, Method, int)}
   */
  @Test
  public void testGetFunctionNode2() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();

    // Act and Assert
    assertNull(jvmCfa.getFunctionNode(new LibraryClass(1, "This Class Name", "Super Class Name"), null, 2));
  }

  /**
   * Method under test: {@link Cfa#getFunctionNode(Signature, int)}
   */
  @Test
  public void testGetFunctionNode3() {
    // Arrange, Act and Assert
    assertNull((new JvmCfa()).getFunctionNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2));
  }

  /**
   * Method under test: {@link Cfa#getFunctionNode(Signature, int)}
   */
  @Test
  public void testGetFunctionNode4() {
    // Arrange, Act and Assert
    assertNull((new JvmCfa()).getFunctionNode(null, 2));
  }

  /**
   * Method under test: {@link Cfa#addFunctionEntryNode(Signature, CfaNode)}
   */
  @Test
  public void testAddFunctionEntryNode() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;

    // Act
    jvmCfa.addFunctionEntryNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, jvmUnknownCfaNode);

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
   * Method under test: {@link Cfa#addFunctionEntryNode(Signature, CfaNode)}
   */
  @Test
  public void testAddFunctionEntryNode2() {
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
   * Method under test: {@link Cfa#addFunctionNode(Signature, CfaNode, int)}
   */
  @Test
  public void testAddFunctionNode() {
    // Arrange
    JvmCfa jvmCfa = new JvmCfa();
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;

    // Act
    jvmCfa.addFunctionNode(ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, jvmUnknownCfaNode, 2);

    // Assert
    Stream<JvmCfaNode> allNodes = jvmCfa.getAllNodes();
    List<JvmCfaNode> collectResult = allNodes.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals(1, jvmCfa.functionNodes.size());
    assertFalse(jvmCfa.isEmpty());
    assertSame(jvmUnknownCfaNode.INSTANCE, collectResult.get(0));
  }

  /**
   * Method under test: {@link Cfa#addFunctionNode(Signature, CfaNode, int)}
   */
  @Test
  public void testAddFunctionNode2() {
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
