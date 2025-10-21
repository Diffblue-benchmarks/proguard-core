package proguard.analysis.cpa.interfaces;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;

public class CfaNodeDiffblueTest {
  /**
   * Test {@link CfaNode#isReturnExitNode()}.
   *
   * <p>Method under test: {@link CfaNode#isReturnExitNode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CfaNode.isReturnExitNode()"})
  public void testIsReturnExitNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isReturnExitNode());
  }

  /**
   * Test {@link CfaNode#isExceptionExitNode()}.
   *
   * <p>Method under test: {@link CfaNode#isExceptionExitNode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CfaNode.isExceptionExitNode()"})
  public void testIsExceptionExitNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isExceptionExitNode());
  }

  /**
   * Test {@link CfaNode#isUnknownNode()}.
   *
   * <p>Method under test: {@link CfaNode#isUnknownNode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CfaNode.isUnknownNode()"})
  public void testIsUnknownNode() {
    // Arrange, Act and Assert
    assertTrue(JvmUnknownCfaNode.INSTANCE.isUnknownNode());
  }
}
