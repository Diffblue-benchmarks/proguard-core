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

public class Stmt0RNodeDiffblueTest {
  /**
   * Test {@link Stmt0RNode#Stmt0RNode(Op)}.
   *
   * <p>Method under test: {@link Stmt0RNode#Stmt0RNode(Op)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stmt0RNode.<init>(Op)"})
  public void testNewStmt0RNode() {
    // Arrange and Act
    Stmt0RNode actualStmt0RNode = new Stmt0RNode(Op.NOP);

    // Assert
    assertEquals(0, actualStmt0RNode.__index);
    assertEquals(Op.NOP, actualStmt0RNode.op);
  }

  /**
   * Test {@link Stmt0RNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Stmt0RNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Stmt0RNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    Stmt0RNode stmt0RNode = new Stmt0RNode(Op.NOP);
    DexCodeNode cv = new DexCodeNode();

    // Act
    stmt0RNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt0RNode);
    assertEquals(0, ((Stmt0RNode) getResult).__index);
    assertEquals(Op.NOP, ((Stmt0RNode) getResult).op);
  }
}
