package proguard.dexfile.reader.node.insn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

class Stmt0RNodeDiffblueTest {
  /**
   * Test {@link Stmt0RNode#Stmt0RNode(Op)}.
   *
   * <p>Method under test: {@link Stmt0RNode#Stmt0RNode(Op)}
   */
  @Test
  @DisplayName("Test new Stmt0RNode(Op)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.Stmt0RNode.<init>(proguard.dexfile.reader.Op)"
  })
  void testNewStmt0RNode() {
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
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.Stmt0RNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
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
