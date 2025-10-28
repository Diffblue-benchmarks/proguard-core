package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class Stmt1RNodeDiffblueTest {
  /**
   * Method under test: {@link Stmt1RNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    Stmt1RNode stmt1RNode = new Stmt1RNode(Op.NOP, 1);
    DexCodeNode cv = new DexCodeNode();

    // Act
    stmt1RNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt1RNode);
    assertEquals(0, ((Stmt1RNode) getResult).__index);
    assertEquals(1, ((Stmt1RNode) getResult).a);
    assertEquals(Op.NOP, ((Stmt1RNode) getResult).op);
  }

  /**
   * Method under test: {@link Stmt1RNode#Stmt1RNode(Op, int)}
   */
  @Test
  public void testNewStmt1RNode() {
    // Arrange and Act
    Stmt1RNode actualStmt1RNode = new Stmt1RNode(Op.NOP, 1);

    // Assert
    assertEquals(0, actualStmt1RNode.__index);
    assertEquals(1, actualStmt1RNode.a);
    assertEquals(Op.NOP, actualStmt1RNode.op);
  }
}
