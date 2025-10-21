package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;

public class JvmAssumeExceptionCfaEdgeDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmAssumeExceptionCfaEdge.<init>(boolean, int)",
    "int JvmAssumeExceptionCfaEdge.getCatchType()",
    "boolean JvmAssumeExceptionCfaEdge.isCaught()"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmAssumeExceptionCfaEdge.<init>(JvmCfaNode, JvmCfaNode, boolean, int)"})
  public void testNewJvmAssumeExceptionCfaEdge_whenInstance_thenReturnCatchTypeIsOne() {
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
