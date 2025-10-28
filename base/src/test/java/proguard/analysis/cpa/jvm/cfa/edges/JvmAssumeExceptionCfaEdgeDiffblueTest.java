package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;

public class JvmAssumeExceptionCfaEdgeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmAssumeExceptionCfaEdge#JvmAssumeExceptionCfaEdge(boolean, int)}
   *   <li>{@link JvmAssumeExceptionCfaEdge#getCatchType()}
   *   <li>{@link JvmAssumeExceptionCfaEdge#isCaught()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    JvmAssumeExceptionCfaEdge actualJvmAssumeExceptionCfaEdge = new JvmAssumeExceptionCfaEdge(true, 1);
    int actualCatchType = actualJvmAssumeExceptionCfaEdge.getCatchType();
    boolean actualIsCaughtResult = actualJvmAssumeExceptionCfaEdge.isCaught();

    // Assert
    assertNull(actualJvmAssumeExceptionCfaEdge.getSource());
    assertNull(actualJvmAssumeExceptionCfaEdge.getTarget());
    assertEquals(1, actualCatchType);
    assertTrue(actualIsCaughtResult);
  }

  /**
   * Method under test:
   * {@link JvmAssumeExceptionCfaEdge#JvmAssumeExceptionCfaEdge(JvmCfaNode, JvmCfaNode, boolean, int)}
   */
  @Test
  public void testNewJvmAssumeExceptionCfaEdge() {
    // Arrange
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;

    // Act
    JvmAssumeExceptionCfaEdge actualJvmAssumeExceptionCfaEdge = new JvmAssumeExceptionCfaEdge(
        JvmUnknownCfaNode.INSTANCE, target, true, 1);

    // Assert
    assertEquals(1, actualJvmAssumeExceptionCfaEdge.getCatchType());
    assertTrue(actualJvmAssumeExceptionCfaEdge.isCaught());
    JvmUnknownCfaNode jvmUnknownCfaNode = target.INSTANCE;
    assertSame(jvmUnknownCfaNode, actualJvmAssumeExceptionCfaEdge.getSource());
    assertSame(jvmUnknownCfaNode, actualJvmAssumeExceptionCfaEdge.getTarget());
  }
}
