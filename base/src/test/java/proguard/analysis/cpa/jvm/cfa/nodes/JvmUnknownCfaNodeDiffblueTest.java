package proguard.analysis.cpa.jvm.cfa.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JvmUnknownCfaNodeDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean JvmUnknownCfaNode.isReturnExitNode()",
    "boolean JvmUnknownCfaNode.isUnknownNode()",
    "String JvmUnknownCfaNode.toString()"
  })
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
