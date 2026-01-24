package proguard.analysis.cpa.jvm.cfa.nodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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

class JvmCfaNodeDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmCfaNode.<init>(List, List, MethodSignature, int, Clazz)",
    "Clazz JvmCfaNode.getClazz()",
    "List JvmCfaNode.getEnteringEdges()",
    "List JvmCfaNode.getLeavingEdges()",
    "int JvmCfaNode.getOffset()",
    "String JvmCfaNode.toString()"
  })
  void testGettersAndSetters() {
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
  @DisplayName("Test new JvmCfaNode(MethodSignature, int, Clazz)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmCfaNode.<init>(MethodSignature, int, Clazz)"})
  void testNewJvmCfaNode() {
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
  @DisplayName("Test isEntryNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmCfaNode.isEntryNode()"})
  void testIsEntryNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isEntryNode());
  }

  /**
   * Test {@link JvmCfaNode#isExitNode()}.
   *
   * <p>Method under test: {@link JvmCfaNode#isExitNode()}
   */
  @Test
  @DisplayName("Test isExitNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JvmCfaNode.isExitNode()"})
  void testIsExitNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isExitNode());
  }

  /**
   * Test {@link JvmCfaNode#getSignature()}.
   *
   * <p>Method under test: {@link JvmCfaNode#getSignature()}
   */
  @Test
  @DisplayName("Test getSignature()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MethodSignature JvmCfaNode.getSignature()"})
  void testGetSignature() {
    // Arrange, Act and Assert
    assertNull(JvmUnknownCfaNode.INSTANCE.getSignature());
  }
}
