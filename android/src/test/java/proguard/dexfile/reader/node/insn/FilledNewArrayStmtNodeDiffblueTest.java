package proguard.dexfile.reader.node.insn;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

class FilledNewArrayStmtNodeDiffblueTest {
  /**
   * Test {@link FilledNewArrayStmtNode#FilledNewArrayStmtNode(Op, int[], String)}.
   *
   * <p>Method under test: {@link FilledNewArrayStmtNode#FilledNewArrayStmtNode(Op, int[], String)}
   */
  @Test
  @DisplayName("Test new FilledNewArrayStmtNode(Op, int[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilledNewArrayStmtNode.<init>(Op, int[], String)"})
  void testNewFilledNewArrayStmtNode() {
    // Arrange and Act
    FilledNewArrayStmtNode actualFilledNewArrayStmtNode =
        new FilledNewArrayStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, "Type");

    // Assert
    assertEquals("Type", actualFilledNewArrayStmtNode.type);
    assertEquals(0, actualFilledNewArrayStmtNode.__index);
    assertEquals(Op.NOP, actualFilledNewArrayStmtNode.op);
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualFilledNewArrayStmtNode.args);
  }

  /**
   * Test {@link FilledNewArrayStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FilledNewArrayStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilledNewArrayStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    FilledNewArrayStmtNode filledNewArrayStmtNode =
        new FilledNewArrayStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, "Type");
    DexCodeNode cv = new DexCodeNode();

    // Act
    filledNewArrayStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FilledNewArrayStmtNode);
    assertEquals("Type", ((FilledNewArrayStmtNode) getResult).type);
    assertEquals(0, ((FilledNewArrayStmtNode) getResult).__index);
    assertEquals(Op.NOP, ((FilledNewArrayStmtNode) getResult).op);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((FilledNewArrayStmtNode) getResult).args);
  }
}
