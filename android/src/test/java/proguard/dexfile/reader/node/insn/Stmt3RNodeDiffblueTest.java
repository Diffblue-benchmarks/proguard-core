package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class Stmt3RNodeDiffblueTest {
  /**
   * Method under test: {@link Stmt3RNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    Stmt3RNode stmt3RNode = new Stmt3RNode(Op.NOP, 1, 1, 1);
    DexCodeNode cv = new DexCodeNode();

    // Act
    stmt3RNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt3RNode);
    assertEquals(0, ((Stmt3RNode) getResult).__index);
    assertEquals(1, ((Stmt3RNode) getResult).a);
    assertEquals(1, ((Stmt3RNode) getResult).b);
    assertEquals(1, ((Stmt3RNode) getResult).c);
    assertEquals(Op.NOP, ((Stmt3RNode) getResult).op);
  }

  /**
   * Method under test: {@link Stmt3RNode#Stmt3RNode(Op, int, int, int)}
   */
  @Test
  public void testNewStmt3RNode() {
    // Arrange and Act
    Stmt3RNode actualStmt3RNode = new Stmt3RNode(Op.NOP, 1, 1, 1);

    // Assert
    assertEquals(0, actualStmt3RNode.__index);
    assertEquals(1, actualStmt3RNode.a);
    assertEquals(1, actualStmt3RNode.b);
    assertEquals(1, actualStmt3RNode.c);
    assertEquals(Op.NOP, actualStmt3RNode.op);
  }
}
