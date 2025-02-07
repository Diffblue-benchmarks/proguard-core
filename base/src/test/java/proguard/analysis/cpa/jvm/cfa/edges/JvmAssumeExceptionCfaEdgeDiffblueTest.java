package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;

class JvmAssumeExceptionCfaEdgeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmAssumeExceptionCfaEdge#JvmAssumeExceptionCfaEdge(boolean, int)}
   *   <li>{@link JvmAssumeExceptionCfaEdge#getCatchType()}
   *   <li>{@link JvmAssumeExceptionCfaEdge#isCaught()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeExceptionCfaEdge.<init>(boolean, int)",
    "int proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeExceptionCfaEdge.getCatchType()",
    "boolean proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeExceptionCfaEdge.isCaught()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    JvmAssumeExceptionCfaEdge actualJvmAssumeExceptionCfaEdge =
        new JvmAssumeExceptionCfaEdge(true, 1);
    int actualCatchType = actualJvmAssumeExceptionCfaEdge.getCatchType();
    boolean actualIsCaughtResult = actualJvmAssumeExceptionCfaEdge.isCaught();

    // Assert
    assertNull(actualJvmAssumeExceptionCfaEdge.getSource());
    assertNull(actualJvmAssumeExceptionCfaEdge.getTarget());
    assertEquals(1, actualCatchType);
    assertTrue(actualIsCaughtResult);
  }

  /**
   * Test {@link JvmAssumeExceptionCfaEdge#JvmAssumeExceptionCfaEdge(JvmCfaNode, JvmCfaNode,
   * boolean, int)}.
   *
   * <ul>
   *   <li>When {@link JvmUnknownCfaNode#INSTANCE}.
   *   <li>Then return CatchType is one.
   * </ul>
   *
   * <p>Method under test: {@link JvmAssumeExceptionCfaEdge#JvmAssumeExceptionCfaEdge(JvmCfaNode,
   * JvmCfaNode, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test new JvmAssumeExceptionCfaEdge(JvmCfaNode, JvmCfaNode, boolean, int); when INSTANCE; then return CatchType is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeExceptionCfaEdge.<init>(proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, boolean, int)"
  })
  void testNewJvmAssumeExceptionCfaEdge_whenInstance_thenReturnCatchTypeIsOne() {
    // Arrange
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;

    // Act
    JvmAssumeExceptionCfaEdge actualJvmAssumeExceptionCfaEdge =
        new JvmAssumeExceptionCfaEdge(JvmUnknownCfaNode.INSTANCE, target, true, 1);

    // Assert
    assertEquals(1, actualJvmAssumeExceptionCfaEdge.getCatchType());
    assertTrue(actualJvmAssumeExceptionCfaEdge.isCaught());
    JvmUnknownCfaNode jvmUnknownCfaNode = target.INSTANCE;
    assertSame(jvmUnknownCfaNode, actualJvmAssumeExceptionCfaEdge.getSource());
    assertSame(jvmUnknownCfaNode, actualJvmAssumeExceptionCfaEdge.getTarget());
  }
}
