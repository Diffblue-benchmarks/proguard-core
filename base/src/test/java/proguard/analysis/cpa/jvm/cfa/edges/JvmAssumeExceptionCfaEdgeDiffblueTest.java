package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmAssumeExceptionCfaEdge.<init>(boolean, int)",
    "int JvmAssumeExceptionCfaEdge.getCatchType()",
    "boolean JvmAssumeExceptionCfaEdge.isCaught()"
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmAssumeExceptionCfaEdge.<init>(JvmCfaNode, JvmCfaNode, boolean, int)"})
  void testNewJvmAssumeExceptionCfaEdge_whenInstance_thenReturnCatchTypeIsOne() {
    // Arrange and Act
    JvmAssumeExceptionCfaEdge actualJvmAssumeExceptionCfaEdge =
        new JvmAssumeExceptionCfaEdge(
            JvmUnknownCfaNode.INSTANCE, JvmUnknownCfaNode.INSTANCE, true, 1);

    // Assert
    assertEquals(1, actualJvmAssumeExceptionCfaEdge.getCatchType());
    assertTrue(actualJvmAssumeExceptionCfaEdge.isCaught());
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;
    assertSame(jvmUnknownCfaNode, actualJvmAssumeExceptionCfaEdge.getSource());
    assertSame(jvmUnknownCfaNode, actualJvmAssumeExceptionCfaEdge.getTarget());
  }
}
