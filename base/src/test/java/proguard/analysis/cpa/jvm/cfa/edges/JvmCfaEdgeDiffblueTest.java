package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;

public class JvmCfaEdgeDiffblueTest {
  /**
   * Test {@link JvmCfaEdge#getSource()}.
   *
   * <p>Method under test: {@link JvmCfaEdge#getSource()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfaNode JvmCfaEdge.getSource()"})
  public void testGetSource() {
    // Arrange, Act and Assert
    assertNull((new JvmAssumeExceptionCfaEdge(true, 1)).getSource());
  }

  /**
   * Test {@link JvmCfaEdge#getTarget()}.
   *
   * <p>Method under test: {@link JvmCfaEdge#getTarget()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JvmCfaNode JvmCfaEdge.getTarget()"})
  public void testGetTarget() {
    // Arrange, Act and Assert
    assertNull((new JvmAssumeExceptionCfaEdge(true, 1)).getTarget());
  }

  /**
   * Test {@link JvmCfaEdge#setSource(JvmCfaNode)}.
   *
   * <p>Method under test: {@link JvmCfaEdge#setSource(JvmCfaNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmCfaEdge.setSource(JvmCfaNode)"})
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

  /**
   * Test {@link JvmCfaEdge#targetSignature()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JvmCfaEdge#targetSignature()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.classfile.MethodSignature JvmCfaEdge.targetSignature()"})
  public void testTargetSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new JvmAssumeExceptionCfaEdge(
                JvmUnknownCfaNode.INSTANCE, JvmUnknownCfaNode.INSTANCE, true, 1))
            .targetSignature());
  }
}
