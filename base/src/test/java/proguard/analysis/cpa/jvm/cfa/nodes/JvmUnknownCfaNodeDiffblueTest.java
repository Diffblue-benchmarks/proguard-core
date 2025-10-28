package proguard.analysis.cpa.jvm.cfa.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class JvmUnknownCfaNodeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmUnknownCfaNode#toString()}
   *   <li>{@link JvmUnknownCfaNode#isReturnExitNode()}
   *   <li>{@link JvmUnknownCfaNode#isUnknownNode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;

    // Act
    String actualToStringResult = jvmUnknownCfaNode.toString();
    boolean actualIsReturnExitNodeResult = jvmUnknownCfaNode.isReturnExitNode();

    // Assert
    assertEquals("JvmUnknownCfaNode{}", actualToStringResult);
    assertFalse(actualIsReturnExitNodeResult);
    assertTrue(jvmUnknownCfaNode.isUnknownNode());
  }
}
