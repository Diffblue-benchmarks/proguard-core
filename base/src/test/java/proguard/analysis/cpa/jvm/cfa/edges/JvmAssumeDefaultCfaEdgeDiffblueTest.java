package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.attribute.CodeAttribute;

class JvmAssumeDefaultCfaEdgeDiffblueTest {
  /**
   * Test {@link JvmAssumeDefaultCfaEdge#JvmAssumeDefaultCfaEdge(CodeAttribute, int)}.
   *
   * <p>Method under test: {@link JvmAssumeDefaultCfaEdge#JvmAssumeDefaultCfaEdge(CodeAttribute,
   * int)}
   */
  @Test
  @DisplayName("Test new JvmAssumeDefaultCfaEdge(CodeAttribute, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JvmAssumeDefaultCfaEdge.<init>(CodeAttribute, int)"})
  void testNewJvmAssumeDefaultCfaEdge() {
    // Arrange
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeDefaultCfaEdge actualJvmAssumeDefaultCfaEdge =
        new JvmAssumeDefaultCfaEdge(methodCode, 2);

    // Assert
    assertNull(actualJvmAssumeDefaultCfaEdge.getSource());
    assertNull(actualJvmAssumeDefaultCfaEdge.getTarget());
    assertSame(methodCode, actualJvmAssumeDefaultCfaEdge.getMethodCode());
  }

  /**
   * Test {@link JvmAssumeDefaultCfaEdge#JvmAssumeDefaultCfaEdge(JvmCfaNode, JvmCfaNode,
   * CodeAttribute, int)}.
   *
   * <ul>
   *   <li>Then Source return {@link JvmUnknownCfaNode}.
   * </ul>
   *
   * <p>Method under test: {@link JvmAssumeDefaultCfaEdge#JvmAssumeDefaultCfaEdge(JvmCfaNode,
   * JvmCfaNode, CodeAttribute, int)}
   */
  @Test
  @DisplayName(
      "Test new JvmAssumeDefaultCfaEdge(JvmCfaNode, JvmCfaNode, CodeAttribute, int); then Source return JvmUnknownCfaNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmAssumeDefaultCfaEdge.<init>(JvmCfaNode, JvmCfaNode, CodeAttribute, int)"
  })
  void testNewJvmAssumeDefaultCfaEdge_thenSourceReturnJvmUnknownCfaNode() {
    // Arrange
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeDefaultCfaEdge actualJvmAssumeDefaultCfaEdge =
        new JvmAssumeDefaultCfaEdge(
            JvmUnknownCfaNode.INSTANCE, JvmUnknownCfaNode.INSTANCE, methodCode, 2);

    // Assert
    JvmCfaNode source = actualJvmAssumeDefaultCfaEdge.getSource();
    assertTrue(source instanceof JvmUnknownCfaNode);
    assertSame(methodCode, actualJvmAssumeDefaultCfaEdge.getMethodCode());
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;
    assertSame(jvmUnknownCfaNode, source);
    assertSame(jvmUnknownCfaNode, actualJvmAssumeDefaultCfaEdge.getTarget());
  }
}
