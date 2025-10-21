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

public class Stmt1RNodeDiffblueTest {
  /**
   * Test {@link Stmt1RNode#Stmt1RNode(Op, int)}.
   *
   * <p>Method under test: {@link Stmt1RNode#Stmt1RNode(Op, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stmt1RNode.<init>(Op, int)"})
  public void testNewStmt1RNode() {
    // Arrange and Act
    Stmt1RNode actualStmt1RNode = new Stmt1RNode(Op.NOP, 1);

    // Assert
    assertEquals(0, actualStmt1RNode.__index);
    assertEquals(1, actualStmt1RNode.a);
    assertEquals(Op.NOP, actualStmt1RNode.op);
  }

  /**
   * Test {@link Stmt1RNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Stmt1RNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stmt1RNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
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
}
