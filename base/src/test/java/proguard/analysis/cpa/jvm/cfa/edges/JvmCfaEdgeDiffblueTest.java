package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;

class JvmCfaEdgeDiffblueTest {
  /**
   * Test {@link JvmCfaEdge#getSource()}.
   *
   * <p>Method under test: {@link JvmCfaEdge#getSource()}
   */
  @Test
  @DisplayName("Test getSource()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmCfaNode JvmCfaEdge.getSource()"})
  void testGetSource() {
    // Arrange, Act and Assert
    assertNull(new JvmAssumeExceptionCfaEdge(true, 1).getSource());
  }

  /**
   * Test {@link JvmCfaEdge#getTarget()}.
   *
   * <p>Method under test: {@link JvmCfaEdge#getTarget()}
   */
  @Test
  @DisplayName("Test getTarget()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JvmCfaNode JvmCfaEdge.getTarget()"})
  void testGetTarget() {
    // Arrange, Act and Assert
    assertNull(new JvmAssumeExceptionCfaEdge(true, 1).getTarget());
  }

  /**
   * Test {@link JvmCfaEdge#setSource(JvmCfaNode)}.
   *
   * <p>Method under test: {@link JvmCfaEdge#setSource(JvmCfaNode)}
   */
  @Test
  @DisplayName("Test setSource(JvmCfaNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmCfaEdge.setSource(JvmCfaNode)"})
  void testSetSource() {
    // Arrange
    JvmAssumeExceptionCfaEdge jvmAssumeExceptionCfaEdge = new JvmAssumeExceptionCfaEdge(true, 1);

    // Act
    jvmAssumeExceptionCfaEdge.setSource(JvmUnknownCfaNode.INSTANCE);

    // Assert
    assertSame(JvmUnknownCfaNode.INSTANCE, jvmAssumeExceptionCfaEdge.getSource());
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
  @DisplayName("Test targetSignature(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.classfile.MethodSignature JvmCfaEdge.targetSignature()"})
  void testTargetSignature_thenReturnNull() {
    // Arrange
    JvmAssumeExceptionCfaEdge jvmAssumeExceptionCfaEdge =
        new JvmAssumeExceptionCfaEdge(
            JvmUnknownCfaNode.INSTANCE, JvmUnknownCfaNode.INSTANCE, true, 1);

    // Act and Assert
    assertNull(jvmAssumeExceptionCfaEdge.targetSignature());
  }
}
