package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.attribute.CodeAttribute;

public class JvmAssumeDefaultCfaEdgeDiffblueTest {
  /**
   * Method under test:
   * {@link JvmAssumeDefaultCfaEdge#JvmAssumeDefaultCfaEdge(CodeAttribute, int)}
   */
  @Test
  public void testNewJvmAssumeDefaultCfaEdge() {
    // Arrange
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeDefaultCfaEdge actualJvmAssumeDefaultCfaEdge = new JvmAssumeDefaultCfaEdge(methodCode, 2);

    // Assert
    assertNull(actualJvmAssumeDefaultCfaEdge.getSource());
    assertNull(actualJvmAssumeDefaultCfaEdge.getTarget());
    assertSame(methodCode, actualJvmAssumeDefaultCfaEdge.getMethodCode());
  }

  /**
   * Method under test:
   * {@link JvmAssumeDefaultCfaEdge#JvmAssumeDefaultCfaEdge(JvmCfaNode, JvmCfaNode, CodeAttribute, int)}
   */
  @Test
  public void testNewJvmAssumeDefaultCfaEdge2() {
    // Arrange
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeDefaultCfaEdge actualJvmAssumeDefaultCfaEdge = new JvmAssumeDefaultCfaEdge(JvmUnknownCfaNode.INSTANCE,
        target, methodCode, 2);

    // Assert
    assertSame(methodCode, actualJvmAssumeDefaultCfaEdge.getMethodCode());
    JvmUnknownCfaNode jvmUnknownCfaNode = target.INSTANCE;
    assertSame(jvmUnknownCfaNode, actualJvmAssumeDefaultCfaEdge.getSource());
    assertSame(jvmUnknownCfaNode, actualJvmAssumeDefaultCfaEdge.getTarget());
  }
}
