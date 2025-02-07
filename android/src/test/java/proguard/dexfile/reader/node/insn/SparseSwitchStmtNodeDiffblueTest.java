package proguard.dexfile.reader.node.insn;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

class SparseSwitchStmtNodeDiffblueTest {
  /**
   * Test {@link SparseSwitchStmtNode#SparseSwitchStmtNode(Op, int, int[], DexLabel[])}.
   *
   * <p>Method under test: {@link SparseSwitchStmtNode#SparseSwitchStmtNode(Op, int, int[],
   * DexLabel[])}
   */
  @Test
  @DisplayName("Test new SparseSwitchStmtNode(Op, int, int[], DexLabel[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.SparseSwitchStmtNode.<init>(proguard.dexfile.reader.Op, int, int[], proguard.dexfile.reader.DexLabel[])"
  })
  void testNewSparseSwitchStmtNode() {
    // Arrange
    DexLabel dexLabel = new DexLabel();

    // Act
    SparseSwitchStmtNode actualSparseSwitchStmtNode =
        new SparseSwitchStmtNode(Op.NOP, 1, new int[] {1, -1, 1, -1}, new DexLabel[] {dexLabel});

    // Assert
    assertEquals(0, actualSparseSwitchStmtNode.__index);
    DexLabel[] dexLabelArray = actualSparseSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertEquals(1, actualSparseSwitchStmtNode.a);
    assertEquals(Op.NOP, actualSparseSwitchStmtNode.op);
    assertSame(dexLabel, dexLabelArray[0]);
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualSparseSwitchStmtNode.cases);
  }

  /**
   * Test {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.SparseSwitchStmtNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    SparseSwitchStmtNode sparseSwitchStmtNode =
        new SparseSwitchStmtNode(Op.NOP, 1, new int[] {1, -1, 1, -1}, new DexLabel[] {dexLabel});
    DexCodeNode cv = new DexCodeNode();

    // Act
    sparseSwitchStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof SparseSwitchStmtNode);
    assertEquals(0, ((SparseSwitchStmtNode) getResult).__index);
    DexLabel[] dexLabelArray = sparseSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    DexLabel[] dexLabelArray2 = ((SparseSwitchStmtNode) getResult).labels;
    assertEquals(1, dexLabelArray2.length);
    assertEquals(1, ((SparseSwitchStmtNode) getResult).a);
    assertEquals(Op.NOP, ((SparseSwitchStmtNode) getResult).op);
    assertSame(dexLabel, dexLabelArray[0]);
    assertSame(dexLabel, dexLabelArray2[0]);
    assertSame(sparseSwitchStmtNode.labels, dexLabelArray2);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((SparseSwitchStmtNode) getResult).cases);
  }

  /**
   * Test {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode(); then array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.SparseSwitchStmtNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode_thenArrayLengthIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    SparseSwitchStmtNode sparseSwitchStmtNode =
        new SparseSwitchStmtNode(Op.NOP, 1, new int[] {1, -1, 1, -1}, new DexLabel[] {dexLabel});

    // Act
    sparseSwitchStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = sparseSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Test {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeVisitor(); then array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.SparseSwitchStmtNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    SparseSwitchStmtNode sparseSwitchStmtNode =
        new SparseSwitchStmtNode(Op.NOP, 1, new int[] {1, -1, 1, -1}, new DexLabel[] {dexLabel});

    // Act
    sparseSwitchStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = sparseSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Test {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexCodeVisitor); when DexCodeVisitor(); then array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.insn.SparseSwitchStmtNode.accept(proguard.dexfile.reader.visitors.DexCodeVisitor)"
  })
  void testAccept_whenDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    SparseSwitchStmtNode sparseSwitchStmtNode =
        new SparseSwitchStmtNode(Op.NOP, 1, new int[] {1, -1, 1, -1}, new DexLabel[] {dexLabel});

    // Act
    sparseSwitchStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = sparseSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }
}
