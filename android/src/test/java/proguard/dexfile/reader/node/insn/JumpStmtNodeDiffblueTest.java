package proguard.dexfile.reader.node.insn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

class JumpStmtNodeDiffblueTest {
  /**
   * Test {@link JumpStmtNode#JumpStmtNode(Op, int, int, DexLabel)}.
   *
   * <p>Method under test: {@link JumpStmtNode#JumpStmtNode(Op, int, int, DexLabel)}
   */
  @Test
  @DisplayName("Test new JumpStmtNode(Op, int, int, DexLabel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JumpStmtNode.<init>(Op, int, int, DexLabel)"})
  void testNewJumpStmtNode() {
    // Arrange and Act
    JumpStmtNode actualJumpStmtNode = new JumpStmtNode(Op.NOP, 1, 1, new DexLabel());

    // Assert
    assertEquals(0, actualJumpStmtNode.__index);
    assertEquals(1, actualJumpStmtNode.a);
    assertEquals(1, actualJumpStmtNode.b);
    assertEquals(Op.NOP, actualJumpStmtNode.op);
  }

  /**
   * Test {@link JumpStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link JumpStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JumpStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    JumpStmtNode jumpStmtNode = new JumpStmtNode(Op.NOP, 1, 1, new DexLabel());
    DexCodeNode cv = new DexCodeNode();

    // Act
    jumpStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof JumpStmtNode);
    assertEquals(0, ((JumpStmtNode) getResult).__index);
    assertEquals(1, ((JumpStmtNode) getResult).a);
    assertEquals(1, ((JumpStmtNode) getResult).b);
    assertEquals(Op.NOP, ((JumpStmtNode) getResult).op);
    assertSame(jumpStmtNode.label, ((JumpStmtNode) getResult).label);
  }
}
