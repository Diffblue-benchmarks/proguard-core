package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.attribute.CodeAttribute;

public class JvmAssumeCfaEdgeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JvmAssumeCfaEdge#JvmAssumeCfaEdge(CodeAttribute, int, boolean)}
   *   <li>{@link JvmAssumeCfaEdge#isSatisfied()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeCfaEdge actualJvmAssumeCfaEdge = new JvmAssumeCfaEdge(methodCode, 2, true);
    boolean actualIsSatisfiedResult = actualJvmAssumeCfaEdge.isSatisfied();

    // Assert
    assertNull(actualJvmAssumeCfaEdge.getSource());
    assertNull(actualJvmAssumeCfaEdge.getTarget());
    assertTrue(actualIsSatisfiedResult);
    assertSame(methodCode, actualJvmAssumeCfaEdge.getMethodCode());
  }

  /**
   * Method under test:
   * {@link JvmAssumeCfaEdge#JvmAssumeCfaEdge(JvmCfaNode, JvmCfaNode, CodeAttribute, int, boolean)}
   */
  @Test
  public void testNewJvmAssumeCfaEdge() {
    // Arrange
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeCfaEdge actualJvmAssumeCfaEdge = new JvmAssumeCfaEdge(JvmUnknownCfaNode.INSTANCE, target, methodCode, 2,
        true);

    // Assert
    assertTrue(actualJvmAssumeCfaEdge.isSatisfied());
    assertSame(methodCode, actualJvmAssumeCfaEdge.getMethodCode());
    JvmUnknownCfaNode jvmUnknownCfaNode = target.INSTANCE;
    assertSame(jvmUnknownCfaNode, actualJvmAssumeCfaEdge.getSource());
    assertSame(jvmUnknownCfaNode, actualJvmAssumeCfaEdge.getTarget());
  }
}
