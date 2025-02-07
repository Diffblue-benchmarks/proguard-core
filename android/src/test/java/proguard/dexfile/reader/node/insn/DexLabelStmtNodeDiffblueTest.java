package proguard.dexfile.reader.node.insn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

class DexLabelStmtNodeDiffblueTest {
  /**
   * Test {@link DexLabelStmtNode#DexLabelStmtNode(DexLabel)}.
   *
   * <p>Method under test: {@link DexLabelStmtNode#DexLabelStmtNode(DexLabel)}
   */
  @Test
  @DisplayName("Test new DexLabelStmtNode(DexLabel)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.DexLabelStmtNode.<init>(proguard.dexfile.reader.DexLabel)"
  })
  void testNewDexLabelStmtNode() {
    // Arrange and Act
    DexLabelStmtNode actualDexLabelStmtNode = new DexLabelStmtNode(new DexLabel());

    // Assert
    assertNull(actualDexLabelStmtNode.op);
    assertEquals(0, actualDexLabelStmtNode.__index);
  }

  /**
   * Test {@link DexLabelStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexLabelStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.DexLabelStmtNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    DexLabelStmtNode dexLabelStmtNode = new DexLabelStmtNode(new DexLabel());
    DexCodeNode cv = new DexCodeNode();

    // Act
    dexLabelStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof DexLabelStmtNode);
    assertNull(((DexLabelStmtNode) getResult).op);
    assertEquals(0, ((DexLabelStmtNode) getResult).__index);
    assertSame(dexLabelStmtNode.label, ((DexLabelStmtNode) getResult).label);
  }
}
