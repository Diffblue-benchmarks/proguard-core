package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class ConstStmtNodeDiffblueTest {
  /**
   * Method under test: {@link ConstStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    ConstStmtNode constStmtNode = new ConstStmtNode(Op.NOP, 1, Constant.Null);
    DexCodeNode cv = new DexCodeNode();

    // Act
    constStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof ConstStmtNode);
    assertEquals(0, ((ConstStmtNode) getResult).__index);
    assertEquals(1, ((ConstStmtNode) getResult).a);
    assertEquals(Op.NOP, ((ConstStmtNode) getResult).op);
    assertSame(constStmtNode.value, ((ConstStmtNode) getResult).value);
  }

  /**
   * Method under test: {@link ConstStmtNode#ConstStmtNode(Op, int, Object)}
   */
  @Test
  public void testNewConstStmtNode() {
    // Arrange and Act
    ConstStmtNode actualConstStmtNode = new ConstStmtNode(Op.NOP, 1, Constant.Null);

    // Assert
    assertEquals(0, actualConstStmtNode.__index);
    assertEquals(1, actualConstStmtNode.a);
    assertEquals(Op.NOP, actualConstStmtNode.op);
  }
}
