package proguard.analysis.cpa.interfaces;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;

public class CfaNodeDiffblueTest {
  /**
   * Method under test: {@link CfaNode#isReturnExitNode()}
   */
  @Test
  public void testIsReturnExitNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isReturnExitNode());
  }

  /**
   * Method under test: {@link CfaNode#isExceptionExitNode()}
   */
  @Test
  public void testIsExceptionExitNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isExceptionExitNode());
  }

  /**
   * Method under test: {@link CfaNode#isUnknownNode()}
   */
  @Test
  public void testIsUnknownNode() {
    // Arrange, Act and Assert
    assertTrue(JvmUnknownCfaNode.INSTANCE.isUnknownNode());
  }
}
