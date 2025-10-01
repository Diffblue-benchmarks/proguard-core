package proguard.analysis.cpa.jvm.cfa.nodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JvmUnknownCfaNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmUnknownCfaNode#toString()}
   *   <li>{@link JvmUnknownCfaNode#isReturnExitNode()}
   *   <li>{@link JvmUnknownCfaNode#isUnknownNode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JvmUnknownCfaNode.isReturnExitNode()",
    "boolean JvmUnknownCfaNode.isUnknownNode()",
    "String JvmUnknownCfaNode.toString()"
  })
  void testGettersAndSetters() {
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
