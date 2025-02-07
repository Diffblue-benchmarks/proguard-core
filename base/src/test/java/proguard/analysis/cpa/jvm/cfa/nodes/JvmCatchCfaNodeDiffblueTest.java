package proguard.analysis.cpa.jvm.cfa.nodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCallCfaEdge;
import proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge;
import proguard.classfile.ClassConstants;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;

class JvmCatchCfaNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmCatchCfaNode#JvmCatchCfaNode(List, List, MethodSignature, int, int, Clazz)}
   *   <li>{@link JvmCatchCfaNode#getCatchType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode.<init>(java.util.List, java.util.List, proguard.classfile.MethodSignature, int, int, proguard.classfile.Clazz)",
    "int proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode.getCatchType()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<JvmCfaEdge> leavingEdges = new ArrayList<>();
    ArrayList<JvmCfaEdge> enteringEdges = new ArrayList<>();
    MethodSignature signature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;
    LibraryClass clazz = new LibraryClass();

    // Act
    JvmCatchCfaNode actualJvmCatchCfaNode =
        new JvmCatchCfaNode(leavingEdges, enteringEdges, signature, 2, 1, clazz);

    // Assert
    assertEquals(1, actualJvmCatchCfaNode.getCatchType());
    assertEquals(2, actualJvmCatchCfaNode.getOffset());
    List<JvmCfaEdge> enteringEdges2 = actualJvmCatchCfaNode.getEnteringEdges();
    assertTrue(enteringEdges2.isEmpty());
    List<JvmCfaEdge> leavingEdges2 = actualJvmCatchCfaNode.getLeavingEdges();
    assertTrue(leavingEdges2.isEmpty());
    assertSame(enteringEdges, enteringEdges2);
    assertSame(leavingEdges, leavingEdges2);
    assertSame(clazz, actualJvmCatchCfaNode.getClazz());
    assertSame(signature, actualJvmCatchCfaNode.getSignature());
  }

  /**
   * Test {@link JvmCatchCfaNode#JvmCatchCfaNode(MethodSignature, int, int, Clazz)}.
   *
   * <p>Method under test: {@link JvmCatchCfaNode#JvmCatchCfaNode(MethodSignature, int, int, Clazz)}
   */
  @Test
  @DisplayName("Test new JvmCatchCfaNode(MethodSignature, int, int, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode.<init>(proguard.classfile.MethodSignature, int, int, proguard.classfile.Clazz)"
  })
  void testNewJvmCatchCfaNode() {
    // Arrange
    MethodSignature signature = ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE;
    LibraryClass clazz = new LibraryClass();

    // Act
    JvmCatchCfaNode actualJvmCatchCfaNode = new JvmCatchCfaNode(signature, 2, 1, clazz);

    // Assert
    Collection<JvmCfaEdge> enteringIntraproceduralEdges =
        actualJvmCatchCfaNode.getEnteringIntraproceduralEdges();
    assertTrue(enteringIntraproceduralEdges instanceof List);
    Collection<JvmCallCfaEdge> knownMethodCallEdges =
        actualJvmCatchCfaNode.getKnownMethodCallEdges();
    assertTrue(knownMethodCallEdges instanceof List);
    Collection<JvmCallCfaEdge> leavingInterproceduralEdges =
        actualJvmCatchCfaNode.getLeavingInterproceduralEdges();
    assertTrue(leavingInterproceduralEdges instanceof List);
    Collection<JvmCfaEdge> leavingIntraproceduralEdges =
        actualJvmCatchCfaNode.getLeavingIntraproceduralEdges();
    assertTrue(leavingIntraproceduralEdges instanceof List);
    Clazz clazz2 = actualJvmCatchCfaNode.getClazz();
    assertTrue(clazz2 instanceof LibraryClass);
    assertEquals(1, actualJvmCatchCfaNode.getCatchType());
    assertEquals(2, actualJvmCatchCfaNode.getOffset());
    Optional<JvmCfaEdge> enteringInvokeEdge = actualJvmCatchCfaNode.getEnteringInvokeEdge();
    assertFalse(enteringInvokeEdge.isPresent());
    assertFalse(actualJvmCatchCfaNode.isExceptionExitNode());
    assertFalse(actualJvmCatchCfaNode.isReturnExitNode());
    assertFalse(actualJvmCatchCfaNode.isUnknownNode());
    assertFalse(actualJvmCatchCfaNode.isFinallyNode());
    assertFalse(actualJvmCatchCfaNode.isEntryNode());
    assertFalse(actualJvmCatchCfaNode.isExitNode());
    assertTrue(enteringIntraproceduralEdges.isEmpty());
    assertTrue(knownMethodCallEdges.isEmpty());
    assertTrue(leavingInterproceduralEdges.isEmpty());
    assertTrue(leavingIntraproceduralEdges.isEmpty());
    assertTrue(actualJvmCatchCfaNode.getEnteringEdges().isEmpty());
    assertTrue(actualJvmCatchCfaNode.getLeavingEdges().isEmpty());
    assertSame(clazz, clazz2);
    assertSame(enteringInvokeEdge, actualJvmCatchCfaNode.getLeavingInvokeEdge());
    assertSame(signature, actualJvmCatchCfaNode.getSignature());
  }

  /**
   * Test {@link JvmCatchCfaNode#isFinallyNode()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JvmCatchCfaNode#isFinallyNode()}
   */
  @Test
  @DisplayName("Test isFinallyNode(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode.isFinallyNode()"})
  void testIsFinallyNode_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new JvmCatchCfaNode(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 1, new LibraryClass()))
            .isFinallyNode());
  }

  /**
   * Test {@link JvmCatchCfaNode#isFinallyNode()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JvmCatchCfaNode#isFinallyNode()}
   */
  @Test
  @DisplayName("Test isFinallyNode(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.cpa.jvm.cfa.nodes.JvmCatchCfaNode.isFinallyNode()"})
  void testIsFinallyNode_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new JvmCatchCfaNode(
                ClassConstants.CLASSLOADER_FIND_LOADED_CLASS_SIGNATURE, 2, 0, new LibraryClass()))
            .isFinallyNode());
  }
}
