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

class JvmAssumeCfaEdgeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JvmAssumeCfaEdge#JvmAssumeCfaEdge(CodeAttribute, int, boolean)}
   *   <li>{@link JvmAssumeCfaEdge#isSatisfied()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmAssumeCfaEdge.<init>(CodeAttribute, int, boolean)",
    "boolean JvmAssumeCfaEdge.isSatisfied()"
  })
  void testGettersAndSetters() {
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
   * Test {@link JvmAssumeCfaEdge#JvmAssumeCfaEdge(JvmCfaNode, JvmCfaNode, CodeAttribute, int,
   * boolean)}.
   *
   * <ul>
   *   <li>Then Source return {@link JvmUnknownCfaNode}.
   * </ul>
   *
   * <p>Method under test: {@link JvmAssumeCfaEdge#JvmAssumeCfaEdge(JvmCfaNode, JvmCfaNode,
   * CodeAttribute, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test new JvmAssumeCfaEdge(JvmCfaNode, JvmCfaNode, CodeAttribute, int, boolean); then Source return JvmUnknownCfaNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JvmAssumeCfaEdge.<init>(JvmCfaNode, JvmCfaNode, CodeAttribute, int, boolean)"
  })
  void testNewJvmAssumeCfaEdge_thenSourceReturnJvmUnknownCfaNode() {
    // Arrange
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeCfaEdge actualJvmAssumeCfaEdge =
        new JvmAssumeCfaEdge(
            JvmUnknownCfaNode.INSTANCE, JvmUnknownCfaNode.INSTANCE, methodCode, 2, true);

    // Assert
    JvmCfaNode source = actualJvmAssumeCfaEdge.getSource();
    assertTrue(source instanceof JvmUnknownCfaNode);
    assertTrue(actualJvmAssumeCfaEdge.isSatisfied());
    assertSame(methodCode, actualJvmAssumeCfaEdge.getMethodCode());
    JvmUnknownCfaNode jvmUnknownCfaNode = JvmUnknownCfaNode.INSTANCE;
    assertSame(jvmUnknownCfaNode, source);
    assertSame(jvmUnknownCfaNode, actualJvmAssumeCfaEdge.getTarget());
  }
}
