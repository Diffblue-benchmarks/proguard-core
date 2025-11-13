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

class PackedSwitchStmtNodeDiffblueTest {
  /**
   * Test {@link PackedSwitchStmtNode#PackedSwitchStmtNode(Op, int, int, DexLabel[])}.
   *
   * <p>Method under test: {@link PackedSwitchStmtNode#PackedSwitchStmtNode(Op, int, int,
   * DexLabel[])}
   */
  @Test
  @DisplayName("Test new PackedSwitchStmtNode(Op, int, int, DexLabel[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PackedSwitchStmtNode.<init>(Op, int, int, DexLabel[])"})
  void testNewPackedSwitchStmtNode() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    DexLabel[] labels = new DexLabel[] {dexLabel};

    // Act
    PackedSwitchStmtNode actualPackedSwitchStmtNode =
        new PackedSwitchStmtNode(Op.NOP, 1, 1, labels);

    // Assert
    assertEquals(0, actualPackedSwitchStmtNode.__index);
    DexLabel[] dexLabelArray = actualPackedSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertEquals(1, actualPackedSwitchStmtNode.a);
    assertEquals(1, actualPackedSwitchStmtNode.first_case);
    assertEquals(Op.NOP, actualPackedSwitchStmtNode.op);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Test {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PackedSwitchStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    DexLabel[] labels = new DexLabel[] {dexLabel};
    PackedSwitchStmtNode packedSwitchStmtNode = new PackedSwitchStmtNode(Op.NOP, 1, 1, labels);
    DexCodeNode cv = new DexCodeNode();

    // Act
    packedSwitchStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof PackedSwitchStmtNode);
    assertEquals(0, ((PackedSwitchStmtNode) getResult).__index);
    DexLabel[] dexLabelArray = packedSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    DexLabel[] dexLabelArray2 = ((PackedSwitchStmtNode) getResult).labels;
    assertEquals(1, dexLabelArray2.length);
    assertEquals(1, ((PackedSwitchStmtNode) getResult).a);
    assertEquals(1, ((PackedSwitchStmtNode) getResult).first_case);
    assertEquals(Op.NOP, ((PackedSwitchStmtNode) getResult).op);
    assertSame(dexLabel, dexLabelArray[0]);
    assertSame(dexLabel, dexLabelArray2[0]);
    assertSame(packedSwitchStmtNode.labels, dexLabelArray2);
  }

  /**
   * Test {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeNode(); then array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PackedSwitchStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode_thenArrayLengthIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    DexLabel[] labels = new DexLabel[] {dexLabel};
    PackedSwitchStmtNode packedSwitchStmtNode = new PackedSwitchStmtNode(Op.NOP, 1, 1, labels);

    // Act
    packedSwitchStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = packedSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Test {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeVisitor(DexCodeVisitor) with visitor is DexCodeVisitor(); then array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PackedSwitchStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    DexLabel[] labels = new DexLabel[] {dexLabel};
    PackedSwitchStmtNode packedSwitchStmtNode = new PackedSwitchStmtNode(Op.NOP, 1, 1, labels);

    // Act
    packedSwitchStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = packedSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Test {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexCodeVisitor); when DexCodeVisitor(); then array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PackedSwitchStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    DexLabel[] labels = new DexLabel[] {dexLabel};
    PackedSwitchStmtNode packedSwitchStmtNode = new PackedSwitchStmtNode(Op.NOP, 1, 1, labels);

    // Act
    packedSwitchStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = packedSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }
}
