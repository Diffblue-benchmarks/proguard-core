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

public class JvmAssumeCfaEdgeDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmAssumeCfaEdge.<init>(CodeAttribute, int, boolean)",
    "boolean JvmAssumeCfaEdge.isSatisfied()"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void JvmAssumeCfaEdge.<init>(JvmCfaNode, JvmCfaNode, CodeAttribute, int, boolean)"
  })
  public void testNewJvmAssumeCfaEdge_thenSourceReturnJvmUnknownCfaNode() {
    // Arrange
    JvmUnknownCfaNode target = JvmUnknownCfaNode.INSTANCE;
    CodeAttribute methodCode = new CodeAttribute(1);

    // Act
    JvmAssumeCfaEdge actualJvmAssumeCfaEdge =
        new JvmAssumeCfaEdge(JvmUnknownCfaNode.INSTANCE, target, methodCode, 2, true);

    // Assert
    JvmCfaNode source = actualJvmAssumeCfaEdge.getSource();
    assertTrue(source instanceof JvmUnknownCfaNode);
    assertTrue(actualJvmAssumeCfaEdge.isSatisfied());
    assertSame(methodCode, actualJvmAssumeCfaEdge.getMethodCode());
    JvmUnknownCfaNode jvmUnknownCfaNode = target.INSTANCE;
    assertSame(jvmUnknownCfaNode, source);
    assertSame(jvmUnknownCfaNode, actualJvmAssumeCfaEdge.getTarget());
  }
}
