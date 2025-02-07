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

class Stmt3RNodeDiffblueTest {
  /**
   * Test {@link Stmt3RNode#Stmt3RNode(Op, int, int, int)}.
   *
   * <p>Method under test: {@link Stmt3RNode#Stmt3RNode(Op, int, int, int)}
   */
  @Test
  @DisplayName("Test new Stmt3RNode(Op, int, int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.Stmt3RNode.<init>(proguard.dexfile.reader.Op, int, int, int)"
  })
  void testNewStmt3RNode() {
    // Arrange and Act
    Stmt3RNode actualStmt3RNode = new Stmt3RNode(Op.NOP, 1, 1, 1);

    // Assert
    assertEquals(0, actualStmt3RNode.__index);
    assertEquals(1, actualStmt3RNode.a);
    assertEquals(1, actualStmt3RNode.b);
    assertEquals(1, actualStmt3RNode.c);
    assertEquals(Op.NOP, actualStmt3RNode.op);
  }

  /**
   * Test {@link Stmt3RNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Stmt3RNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.Stmt3RNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
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
}
