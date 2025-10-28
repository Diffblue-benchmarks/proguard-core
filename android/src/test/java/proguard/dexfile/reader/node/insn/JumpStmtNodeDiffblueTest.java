package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class JumpStmtNodeDiffblueTest {
  /**
   * Method under test: {@link JumpStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
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

  /**
   * Method under test: {@link JumpStmtNode#JumpStmtNode(Op, int, int, DexLabel)}
   */
  @Test
  public void testNewJumpStmtNode() {
    // Arrange and Act
    JumpStmtNode actualJumpStmtNode = new JumpStmtNode(Op.NOP, 1, 1, new DexLabel());

    // Assert
    assertEquals(0, actualJumpStmtNode.__index);
    assertEquals(1, actualJumpStmtNode.a);
    assertEquals(1, actualJumpStmtNode.b);
    assertEquals(Op.NOP, actualJumpStmtNode.op);
  }
}
