package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class JumpStmtNodeDiffblueTest {
  /**
   * Test {@link JumpStmtNode#JumpStmtNode(Op, int, int, DexLabel)}.
   *
   * <p>Method under test: {@link JumpStmtNode#JumpStmtNode(Op, int, int, DexLabel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JumpStmtNode.<init>(Op, int, int, DexLabel)"})
  public void testNewJumpStmtNode() {
    // Arrange and Act
    JumpStmtNode actualJumpStmtNode = new JumpStmtNode(Op.NOP, 1, 1, new DexLabel());

    // Assert
    assertEquals(0, actualJumpStmtNode.__index);
    assertEquals(1, actualJumpStmtNode.a);
    assertEquals(1, actualJumpStmtNode.b);
    assertEquals(Op.NOP, actualJumpStmtNode.op);
  }

  /**
   * Test {@link JumpStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JumpStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JumpStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    JumpStmtNode jumpStmtNode = new JumpStmtNode(Op.NOP, 1, 1, new DexLabel());
    DexCodeNode cv = new DexCodeNode();

    // Act
    jumpStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof JumpStmtNode);
    assertEquals(0, ((JumpStmtNode) getResult).__index);
    assertEquals(1, ((JumpStmtNode) getResult).a);
    assertEquals(1, ((JumpStmtNode) getResult).b);
    assertEquals(Op.NOP, ((JumpStmtNode) getResult).op);
    assertSame(jumpStmtNode.label, ((JumpStmtNode) getResult).label);
  }
}
