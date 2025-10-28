package proguard.analysis.cpa.jvm.cfa.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;

public class JvmCfaNodeDiffblueTest {
  /**
   * Method under test: {@link JvmCfaNode#isEntryNode()}
   */
  @Test
  public void testIsEntryNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isEntryNode());
  }

  /**
   * Method under test: {@link JvmCfaNode#isExitNode()}
   */
  @Test
  public void testIsExitNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isExitNode());
  }

  /**
   * Method under test: {@link JvmCfaNode#getSignature()}
   */
  @Test
  public void testGetSignature() {
    // Arrange, Act and Assert
    assertNull(JvmUnknownCfaNode.INSTANCE.getSignature());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmCfaNode#equals(Object)}
   *   <li>{@link JvmCfaNode#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;
    JvmUnknownCfaNode jvmUnknownCfaNode2 = JvmUnknownCfaNode.INSTANCE;

    // Act and Assert
    assertEquals(jvmUnknownCfaNode, jvmUnknownCfaNode2);
    int expectedHashCodeResult = jvmUnknownCfaNode.hashCode();
    assertEquals(expectedHashCodeResult, jvmUnknownCfaNode2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmCfaNode#equals(Object)}
   *   <li>{@link JvmCfaNode#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;

    // Act and Assert
    assertEquals(jvmUnknownCfaNode, jvmUnknownCfaNode);
    int expectedHashCodeResult = jvmUnknownCfaNode.hashCode();
    assertEquals(expectedHashCodeResult, jvmUnknownCfaNode.hashCode());
  }

  /**
   * Method under test: {@link JvmCfaNode#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JvmUnknownCfaNode.INSTANCE, "42");
  }

  /**
   * Method under test: {@link JvmCfaNode#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JvmUnknownCfaNode.INSTANCE, null);
  }

  /**
   * Method under test: {@link JvmCfaNode#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JvmUnknownCfaNode.INSTANCE, "Different type to JvmCfaNode");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmCfaNode#JvmCfaNode(List, List, MethodSignature, int, Clazz)}
   *   <li>{@link JvmCfaNode#toString()}
   *   <li>{@link JvmCfaNode#getClazz()}
   *   <li>{@link JvmCfaNode#getEnteringEdges()}
   *   <li>{@link JvmCfaNode#getLeavingEdges()}
   *   <li>{@link JvmCfaNode#getOffset()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<JvmCfaEdge> leavingEdges = new ArrayList<>();
    ArrayList<JvmCfaEdge> enteringEdges = new ArrayList<>();
    MethodSignature signature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;
    LibraryClass clazz = new LibraryClass();

    // Act
    JvmCfaNode actualJvmCfaNode = new JvmCfaNode(leavingEdges, enteringEdges, signature, 2, clazz);
    String actualToStringResult = actualJvmCfaNode.toString();
    Clazz actualClazz = actualJvmCfaNode.getClazz();
    List<JvmCfaEdge> actualEnteringEdges = actualJvmCfaNode.getEnteringEdges();
    List<JvmCfaEdge> actualLeavingEdges = actualJvmCfaNode.getLeavingEdges();

    // Assert
    assertEquals("JvmCfaNode{Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;:2}",
        actualToStringResult);
    assertEquals(2, actualJvmCfaNode.getOffset());
    assertTrue(actualEnteringEdges.isEmpty());
    assertTrue(actualLeavingEdges.isEmpty());
    assertSame(enteringEdges, actualEnteringEdges);
    assertSame(leavingEdges, actualLeavingEdges);
    assertSame(clazz, actualClazz);
    assertSame(signature, actualJvmCfaNode.getSignature());
  }

  /**
   * Method under test: {@link JvmCfaNode#JvmCfaNode(MethodSignature, int, Clazz)}
   */
  @Test
  public void testNewJvmCfaNode() {
    // Arrange
    MethodSignature signature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;
    LibraryClass clazz = new LibraryClass();

    // Act
    JvmCfaNode actualJvmCfaNode = new JvmCfaNode(signature, 2, clazz);

    // Assert
    Collection<JvmCfaEdge> enteringIntraproceduralEdges = actualJvmCfaNode.getEnteringIntraproceduralEdges();
    assertTrue(enteringIntraproceduralEdges instanceof List);
    Collection<JvmCallCfaEdge> knownMethodCallEdges = actualJvmCfaNode.getKnownMethodCallEdges();
    assertTrue(knownMethodCallEdges instanceof List);
    Collection<JvmCallCfaEdge> leavingInterproceduralEdges = actualJvmCfaNode.getLeavingInterproceduralEdges();
    assertTrue(leavingInterproceduralEdges instanceof List);
    Collection<JvmCfaEdge> leavingIntraproceduralEdges = actualJvmCfaNode.getLeavingIntraproceduralEdges();
    assertTrue(leavingIntraproceduralEdges instanceof List);
    assertEquals(2, actualJvmCfaNode.getOffset());
    Optional<JvmCfaEdge> enteringInvokeEdge = actualJvmCfaNode.getEnteringInvokeEdge();
    assertFalse(enteringInvokeEdge.isPresent());
    assertFalse(actualJvmCfaNode.isExceptionExitNode());
    assertFalse(actualJvmCfaNode.isReturnExitNode());
    assertFalse(actualJvmCfaNode.isUnknownNode());
    assertFalse(actualJvmCfaNode.isEntryNode());
    assertFalse(actualJvmCfaNode.isExitNode());
    assertTrue(enteringIntraproceduralEdges.isEmpty());
    assertTrue(knownMethodCallEdges.isEmpty());
    assertTrue(leavingInterproceduralEdges.isEmpty());
    assertTrue(leavingIntraproceduralEdges.isEmpty());
    assertTrue(actualJvmCfaNode.getEnteringEdges().isEmpty());
    assertTrue(actualJvmCfaNode.getLeavingEdges().isEmpty());
    assertSame(clazz, actualJvmCfaNode.getClazz());
    assertSame(enteringInvokeEdge, actualJvmCfaNode.getLeavingInvokeEdge());
    assertSame(signature, actualJvmCfaNode.getSignature());
  }
}
