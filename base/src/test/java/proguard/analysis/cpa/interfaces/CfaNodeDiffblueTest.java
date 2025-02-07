package proguard.analysis.cpa.interfaces;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;

class CfaNodeDiffblueTest {
  /**
   * Test {@link CfaNode#isReturnExitNode()}.
   *
   * <p>Method under test: {@link CfaNode#isReturnExitNode()}
   */
  @Test
  @DisplayName("Test isReturnExitNode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.cpa.interfaces.CfaNode.isReturnExitNode()"})
  void testIsReturnExitNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isReturnExitNode());
  }

  /**
   * Test {@link CfaNode#isExceptionExitNode()}.
   *
   * <p>Method under test: {@link CfaNode#isExceptionExitNode()}
   */
  @Test
  @DisplayName("Test isExceptionExitNode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.cpa.interfaces.CfaNode.isExceptionExitNode()"})
  void testIsExceptionExitNode() {
    // Arrange, Act and Assert
    assertFalse(JvmUnknownCfaNode.INSTANCE.isExceptionExitNode());
  }

  /**
   * Test {@link CfaNode#isUnknownNode()}.
   *
   * <p>Method under test: {@link CfaNode#isUnknownNode()}
   */
  @Test
  @DisplayName("Test isUnknownNode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.analysis.cpa.interfaces.CfaNode.isUnknownNode()"})
  void testIsUnknownNode() {
    // Arrange, Act and Assert
    assertTrue(JvmUnknownCfaNode.INSTANCE.isUnknownNode());
  }
}
