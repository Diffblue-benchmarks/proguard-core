package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;

public class JvmCfaEdgeDiffblueTest {
  /**
   * Method under test: {@link JvmCfaEdge#getSource()}
   */
  @Test
  public void testGetSource() {
    // Arrange, Act and Assert
    assertNull((new JvmAssumeExceptionCfaEdge(true, 1)).getSource());
  }

  /**
   * Method under test: {@link JvmCfaEdge#getTarget()}
   */
  @Test
  public void testGetTarget() {
    // Arrange, Act and Assert
    assertNull((new JvmAssumeExceptionCfaEdge(true, 1)).getTarget());
  }

  /**
   * Method under test: {@link JvmCfaEdge#setSource(JvmCfaNode)}
   */
  @Test
  public void testSetSource() {
    // Arrange
    JvmAssumeExceptionCfaEdge jvmAssumeExceptionCfaEdge = new JvmAssumeExceptionCfaEdge(true, 1);
    JvmUnknownCfaNode source = JvmUnknownCfaNode.INSTANCE;

    // Act
    jvmAssumeExceptionCfaEdge.setSource(source);

    // Assert
    JvmUnknownCfaNode expectedSource = source.INSTANCE;
    assertSame(expectedSource, jvmAssumeExceptionCfaEdge.getSource());
  }
}
