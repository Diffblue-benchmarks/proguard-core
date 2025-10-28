package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class Stmt2RNodeDiffblueTest {
  /**
   * Method under test: {@link Stmt2RNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    Stmt2RNode stmt2RNode = new Stmt2RNode(Op.NOP, 1, 1);
    DexCodeNode cv = new DexCodeNode();

    // Act
    stmt2RNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt2RNode);
    assertEquals(0, ((Stmt2RNode) getResult).__index);
    assertEquals(1, ((Stmt2RNode) getResult).a);
    assertEquals(1, ((Stmt2RNode) getResult).b);
    assertEquals(Op.NOP, ((Stmt2RNode) getResult).op);
  }

  /**
   * Method under test: {@link Stmt2RNode#Stmt2RNode(Op, int, int)}
   */
  @Test
  public void testNewStmt2RNode() {
    // Arrange and Act
    Stmt2RNode actualStmt2RNode = new Stmt2RNode(Op.NOP, 1, 1);

    // Assert
    assertEquals(0, actualStmt2RNode.__index);
    assertEquals(1, actualStmt2RNode.a);
    assertEquals(1, actualStmt2RNode.b);
    assertEquals(Op.NOP, actualStmt2RNode.op);
  }
}
