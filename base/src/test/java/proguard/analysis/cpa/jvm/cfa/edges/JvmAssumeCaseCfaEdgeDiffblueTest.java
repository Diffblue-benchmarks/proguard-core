package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.attribute.CodeAttribute;

class JvmAssumeCaseCfaEdgeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmAssumeCaseCfaEdge#JvmAssumeCaseCfaEdge(CodeAttribute, int, int)}
   *   <li>{@link JvmAssumeCaseCfaEdge#getAssumedCase()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeCaseCfaEdge.<init>(proguard.classfile.attribute.CodeAttribute, int, int)",
    "int proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeCaseCfaEdge.getAssumedCase()"
  })
  void testGettersAndSetters() {
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
   * Test {@link JvmAssumeCaseCfaEdge#JvmAssumeCaseCfaEdge(JvmCfaNode, JvmCfaNode, CodeAttribute,
   * int, int)}.
   *
   * <ul>
   *   <li>Then Source return {@link JvmUnknownCfaNode}.
   * </ul>
   *
   * <p>Method under test: {@link JvmAssumeCaseCfaEdge#JvmAssumeCaseCfaEdge(JvmCfaNode, JvmCfaNode,
   * CodeAttribute, int, int)}
   */
  @Test
  @DisplayName(
      "Test new JvmAssumeCaseCfaEdge(JvmCfaNode, JvmCfaNode, CodeAttribute, int, int); then Source return JvmUnknownCfaNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.cpa.jvm.cfa.edges.JvmAssumeCaseCfaEdge.<init>(proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode, proguard.classfile.attribute.CodeAttribute, int, int)"
  })
  void testNewJvmAssumeCaseCfaEdge_thenSourceReturnJvmUnknownCfaNode() {
    // Arrange
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeCaseCfaEdge actualJvmAssumeCaseCfaEdge =
        new JvmAssumeCaseCfaEdge(JvmUnknownCfaNode.INSTANCE, target, methodCode, 2, 1);

    // Assert
    JvmCfaNode source = actualJvmAssumeCaseCfaEdge.getSource();
    assertTrue(source instanceof JvmUnknownCfaNode);
    assertEquals(1, actualJvmAssumeCaseCfaEdge.getAssumedCase());
    assertSame(methodCode, actualJvmAssumeCaseCfaEdge.getMethodCode());
    JvmUnknownCfaNode jvmUnknownCfaNode = target.INSTANCE;
    assertSame(jvmUnknownCfaNode, source);
    assertSame(jvmUnknownCfaNode, actualJvmAssumeCaseCfaEdge.getTarget());
  }
}
