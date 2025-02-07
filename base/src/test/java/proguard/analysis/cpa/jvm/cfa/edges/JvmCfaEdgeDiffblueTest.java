package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge.getSource()"
  })
  void testGetSource() {
    // Arrange, Act and Assert
    assertNull((new JvmAssumeExceptionCfaEdge(true, 1)).getSource());
  }

  /**
   * Test {@link JvmCfaEdge#getTarget()}.
   *
   * <p>Method under test: {@link JvmCfaEdge#getTarget()}
   */
  @Test
  @DisplayName("Test getTarget()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge.getTarget()"
  })
  void testGetTarget() {
    // Arrange, Act and Assert
    assertNull((new JvmAssumeExceptionCfaEdge(true, 1)).getTarget());
  }

  /**
   * Test {@link JvmCfaEdge#setSource(JvmCfaNode)}.
   *
   * <p>Method under test: {@link JvmCfaEdge#setSource(JvmCfaNode)}
   */
  @Test
  @DisplayName("Test setSource(JvmCfaNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge.setSource(proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode)"
  })
  void testSetSource() {
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
   * Test {@link JvmCfaEdge#setTarget(JvmCfaNode)}.
   *
   * <p>Method under test: {@link JvmCfaEdge#setTarget(JvmCfaNode)}
   */
  @Test
  @DisplayName("Test setTarget(JvmCfaNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge.setTarget(proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode)"
  })
  void testSetTarget() {
    // Arrange
    JvmAssumeExceptionCfaEdge jvmAssumeExceptionCfaEdge = new JvmAssumeExceptionCfaEdge(true, 1);
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;

    // Act
    jvmAssumeExceptionCfaEdge.setTarget(target);

    // Assert
    JvmUnknownCfaNode expectedTarget = target.INSTANCE;
    assertSame(expectedTarget, jvmAssumeExceptionCfaEdge.getTarget());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.MethodSignature proguard.analysis.cpa.jvm.cfa.edges.JvmCfaEdge.targetSignature()"
  })
  void testTargetSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new JvmAssumeExceptionCfaEdge(
                JvmUnknownCfaNode.INSTANCE, JvmUnknownCfaNode.INSTANCE, true, 1))
            .targetSignature());
  }
}
