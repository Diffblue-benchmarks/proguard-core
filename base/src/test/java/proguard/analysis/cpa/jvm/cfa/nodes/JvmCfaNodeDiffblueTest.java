package proguard.analysis.cpa.jvm.cfa.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;

public class JvmCfaNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmCfaNode.<init>(List, List, MethodSignature, int, Clazz)",
    "Clazz JvmCfaNode.getClazz()",
    "List JvmCfaNode.getEnteringEdges()",
    "List JvmCfaNode.getLeavingEdges()",
    "int JvmCfaNode.getOffset()",
    "String JvmCfaNode.toString()"
  })
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
    assertEquals(
        "JvmCfaNode{Ljava/lang/ClassLoader;findLoadedClass(Ljava/lang/String;)Ljava/lang/Class;:2}",
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
   * Test {@link JvmCfaNode#JvmCfaNode(MethodSignature, int, Clazz)}.
   *
   * <p>Method under test: {@link JvmCfaNode#JvmCfaNode(MethodSignature, int, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmCfaNode.<init>(MethodSignature, int, Clazz)"})
  public void testNewJvmCfaNode() {
    // Arrange
    MethodSignature signature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;
    LibraryClass clazz = new LibraryClass();

    // Act
    JvmCfaNode actualJvmCfaNode = new JvmCfaNode(signature, 2, clazz);

    // Assert
    Collection<JvmCfaEdge> enteringIntraproceduralEdges =
        actualJvmCfaNode.getEnteringIntraproceduralEdges();
    assertTrue(enteringIntraproceduralEdges instanceof List);
    Collection<JvmCallCfaEdge> knownMethodCallEdges = actualJvmCfaNode.getKnownMethodCallEdges();
    assertTrue(knownMethodCallEdges instanceof List);
    Collection<JvmCallCfaEdge> leavingInterproceduralEdges =
        actualJvmCfaNode.getLeavingInterproceduralEdges();
    assertTrue(leavingInterproceduralEdges instanceof List);
    Collection<JvmCfaEdge> leavingIntraproceduralEdges =
        actualJvmCfaNode.getLeavingIntraproceduralEdges();
    assertTrue(leavingIntraproceduralEdges instanceof List);
    Clazz clazz2 = actualJvmCfaNode.getClazz();
    assertTrue(clazz2 instanceof LibraryClass);
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
    assertSame(clazz, clazz2);
    assertSame(enteringInvokeEdge, actualJvmCfaNode.getLeavingInvokeEdge());
    assertSame(signature, actualJvmCfaNode.getSignature());
  }

  /**
   * Test {@link JvmCfaNode#isEntryNode()}.
   *
   * <p>Method under test: {@link JvmCfaNode#isEntryNode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmCfaNode.isEntryNode()"})
  public void testIsEntryNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isEntryNode());
  }

  /**
   * Test {@link JvmCfaNode#isExitNode()}.
   *
   * <p>Method under test: {@link JvmCfaNode#isExitNode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JvmCfaNode.isExitNode()"})
  public void testIsExitNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isExitNode());
  }

  /**
   * Test {@link JvmCfaNode#getSignature()}.
   *
   * <p>Method under test: {@link JvmCfaNode#getSignature()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodSignature JvmCfaNode.getSignature()"})
  public void testGetSignature() {
    // Arrange, Act and Assert
    assertNull(JvmUnknownCfaNode.INSTANCE.getSignature());
  }

  /**
   * Test {@link Object#equals(Object)}, and {@link JvmCfaNode#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmCfaNode#equals(Object)}
   *   <li>{@link JvmCfaNode#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JvmCfaNode.hashCode()"})
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
   * Test {@link Object#equals(Object)}, and {@link JvmCfaNode#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmCfaNode#equals(Object)}
   *   <li>{@link JvmCfaNode#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JvmCfaNode.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;

    // Act and Assert
    assertEquals(jvmUnknownCfaNode, jvmUnknownCfaNode);
    int expectedHashCodeResult = jvmUnknownCfaNode.hashCode();
    assertEquals(expectedHashCodeResult, jvmUnknownCfaNode.hashCode());
  }

  /**
   * Test {@link Object#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmCfaNode#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JvmCfaNode.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JvmUnknownCfaNode.INSTANCE, "42");
  }

  /**
   * Test {@link Object#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmCfaNode#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JvmCfaNode.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JvmUnknownCfaNode.INSTANCE, null);
  }

  /**
   * Test {@link Object#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JvmCfaNode#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JvmCfaNode.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(JvmUnknownCfaNode.INSTANCE, "Different type to JvmCfaNode");
  }
}
