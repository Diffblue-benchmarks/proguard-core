package proguard.analysis.cpa.jvm.cfa.edges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmCfaNode;
import proguard.analysis.cpa.jvm.cfa.nodes.JvmUnknownCfaNode;
import proguard.classfile.attribute.CodeAttribute;

public class JvmAssumeCaseCfaEdgeDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmAssumeCaseCfaEdge.<init>(CodeAttribute, int, int)",
    "int JvmAssumeCaseCfaEdge.getAssumedCase()"
  })
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmAssumeCaseCfaEdge.<init>(JvmCfaNode, JvmCfaNode, CodeAttribute, int, int)"
  })
  public void testNewJvmAssumeCaseCfaEdge_thenSourceReturnJvmUnknownCfaNode() {
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
