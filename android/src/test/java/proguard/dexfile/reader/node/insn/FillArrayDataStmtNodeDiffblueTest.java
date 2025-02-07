package proguard.dexfile.reader.node.insn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

class FillArrayDataStmtNodeDiffblueTest {
  /**
   * Test {@link FillArrayDataStmtNode#FillArrayDataStmtNode(Op, int, Object)}.
   *
   * <p>Method under test: {@link FillArrayDataStmtNode#FillArrayDataStmtNode(Op, int, Object)}
   */
  @Test
  @DisplayName("Test new FillArrayDataStmtNode(Op, int, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.FillArrayDataStmtNode.<init>(proguard.dexfile.reader.Op, int, java.lang.Object)"
  })
  void testNewFillArrayDataStmtNode() {
    // Arrange and Act
    FillArrayDataStmtNode actualFillArrayDataStmtNode =
        new FillArrayDataStmtNode(Op.NOP, 1, Constant.Null);

    // Assert
    assertEquals(0, actualFillArrayDataStmtNode.__index);
    assertEquals(1, actualFillArrayDataStmtNode.ra);
    assertEquals(Op.NOP, actualFillArrayDataStmtNode.op);
  }

  /**
   * Test {@link FillArrayDataStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FillArrayDataStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.FillArrayDataStmtNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    FillArrayDataStmtNode fillArrayDataStmtNode =
        new FillArrayDataStmtNode(Op.NOP, 1, Constant.Null);
    DexCodeNode cv = new DexCodeNode();

    // Act
    fillArrayDataStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FillArrayDataStmtNode);
    assertEquals(0, ((FillArrayDataStmtNode) getResult).__index);
    assertEquals(1, ((FillArrayDataStmtNode) getResult).ra);
    assertEquals(Op.NOP, ((FillArrayDataStmtNode) getResult).op);
    assertSame(fillArrayDataStmtNode.array, ((FillArrayDataStmtNode) getResult).array);
  }
}
