package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.attribute.CodeAttribute;

public class JvmAssumeCaseCfaEdgeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JvmAssumeCaseCfaEdge#JvmAssumeCaseCfaEdge(CodeAttribute, int, int)}
   *   <li>{@link JvmAssumeCaseCfaEdge#getAssumedCase()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeCaseCfaEdge actualJvmAssumeCaseCfaEdge = new JvmAssumeCaseCfaEdge(methodCode, 2, 1);
    int actualAssumedCase = actualJvmAssumeCaseCfaEdge.getAssumedCase();

    // Assert
    assertNull(actualJvmAssumeCaseCfaEdge.getSource());
    assertNull(actualJvmAssumeCaseCfaEdge.getTarget());
    assertEquals(1, actualAssumedCase);
    assertSame(methodCode, actualJvmAssumeCaseCfaEdge.getMethodCode());
  }

  /**
   * Method under test:
   * {@link JvmAssumeCaseCfaEdge#JvmAssumeCaseCfaEdge(JvmCfaNode, JvmCfaNode, CodeAttribute, int, int)}
   */
  @Test
  public void testNewJvmAssumeCaseCfaEdge() {
    // Arrange
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeCaseCfaEdge actualJvmAssumeCaseCfaEdge = new JvmAssumeCaseCfaEdge(JvmUnknownCfaNode.INSTANCE, target,
        methodCode, 2, 1);

    // Assert
    assertEquals(1, actualJvmAssumeCaseCfaEdge.getAssumedCase());
    assertSame(methodCode, actualJvmAssumeCaseCfaEdge.getMethodCode());
    JvmUnknownCfaNode jvmUnknownCfaNode = target.INSTANCE;
    assertSame(jvmUnknownCfaNode, actualJvmAssumeCaseCfaEdge.getSource());
    assertSame(jvmUnknownCfaNode, actualJvmAssumeCaseCfaEdge.getTarget());
  }
}
