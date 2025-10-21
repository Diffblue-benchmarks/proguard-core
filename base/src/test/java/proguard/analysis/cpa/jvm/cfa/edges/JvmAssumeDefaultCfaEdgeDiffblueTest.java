package proguard.analysis.cpa.jvm.cfa.edges;

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

public class JvmAssumeDefaultCfaEdgeDiffblueTest {
  /**
   * Test {@link JvmAssumeDefaultCfaEdge#JvmAssumeDefaultCfaEdge(CodeAttribute, int)}.
   *
   * <p>Method under test: {@link JvmAssumeDefaultCfaEdge#JvmAssumeDefaultCfaEdge(CodeAttribute,
   * int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JvmAssumeDefaultCfaEdge.<init>(CodeAttribute, int)"})
  public void testNewJvmAssumeDefaultCfaEdge() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmAssumeDefaultCfaEdge.<init>(JvmCfaNode, JvmCfaNode, CodeAttribute, int)"
  })
  public void testNewJvmAssumeDefaultCfaEdge_thenSourceReturnJvmUnknownCfaNode() {
    // Arrange
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeDefaultCfaEdge actualJvmAssumeDefaultCfaEdge =
        new JvmAssumeDefaultCfaEdge(JvmUnknownCfaNode.INSTANCE, target, methodCode, 2);

    // Assert
    JvmCfaNode source = actualJvmAssumeDefaultCfaEdge.getSource();
    assertTrue(source instanceof JvmUnknownCfaNode);
    assertSame(methodCode, actualJvmAssumeDefaultCfaEdge.getMethodCode());
    JvmUnknownCfaNode jvmUnknownCfaNode = target.INSTANCE;
    assertSame(jvmUnknownCfaNode, source);
    assertSame(jvmUnknownCfaNode, actualJvmAssumeDefaultCfaEdge.getTarget());
  }
}
