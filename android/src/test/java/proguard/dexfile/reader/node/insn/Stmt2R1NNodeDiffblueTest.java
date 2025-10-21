package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class Stmt2R1NNodeDiffblueTest {
  /**
   * Test {@link Stmt2R1NNode#Stmt2R1NNode(Op, int, int, int)}.
   *
   * <p>Method under test: {@link Stmt2R1NNode#Stmt2R1NNode(Op, int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stmt2R1NNode.<init>(Op, int, int, int)"})
  public void testNewStmt2R1NNode() {
    // Arrange and Act
    Stmt2R1NNode actualStmt2R1NNode = new Stmt2R1NNode(Op.NOP, 1, 1, 1);

    // Assert
    assertEquals(0, actualStmt2R1NNode.__index);
    assertEquals(1, actualStmt2R1NNode.content);
    assertEquals(1, actualStmt2R1NNode.distReg);
    assertEquals(1, actualStmt2R1NNode.srcReg);
    assertEquals(Op.NOP, actualStmt2R1NNode.op);
  }

  /**
   * Test {@link Stmt2R1NNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Stmt2R1NNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stmt2R1NNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    Stmt2R1NNode stmt2R1NNode = new Stmt2R1NNode(Op.NOP, 1, 1, 1);
    DexCodeNode cv = new DexCodeNode();

    // Act
    stmt2R1NNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt2R1NNode);
    assertEquals(0, ((Stmt2R1NNode) getResult).__index);
    assertEquals(1, ((Stmt2R1NNode) getResult).content);
    assertEquals(1, ((Stmt2R1NNode) getResult).distReg);
    assertEquals(1, ((Stmt2R1NNode) getResult).srcReg);
    assertEquals(Op.NOP, ((Stmt2R1NNode) getResult).op);
  }
}
