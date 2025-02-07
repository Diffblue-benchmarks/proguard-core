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

class ConstStmtNodeDiffblueTest {
  /**
   * Test {@link ConstStmtNode#ConstStmtNode(Op, int, Object)}.
   *
   * <p>Method under test: {@link ConstStmtNode#ConstStmtNode(Op, int, Object)}
   */
  @Test
  @DisplayName("Test new ConstStmtNode(Op, int, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.ConstStmtNode.<init>(proguard.dexfile.reader.Op, int, java.lang.Object)"
  })
  void testNewConstStmtNode() {
    // Arrange and Act
    ConstStmtNode actualConstStmtNode = new ConstStmtNode(Op.NOP, 1, Constant.Null);

    // Assert
    assertEquals(0, actualConstStmtNode.__index);
    assertEquals(1, actualConstStmtNode.a);
    assertEquals(Op.NOP, actualConstStmtNode.op);
  }

  /**
   * Test {@link ConstStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.ConstStmtNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
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
}
