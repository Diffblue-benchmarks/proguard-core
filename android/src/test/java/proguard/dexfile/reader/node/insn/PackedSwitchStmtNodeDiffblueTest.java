package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class PackedSwitchStmtNodeDiffblueTest {
  /**
   * Test {@link PackedSwitchStmtNode#PackedSwitchStmtNode(Op, int, int, DexLabel[])}.
   *
   * <p>Method under test: {@link PackedSwitchStmtNode#PackedSwitchStmtNode(Op, int, int,
   * DexLabel[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PackedSwitchStmtNode.<init>(Op, int, int, DexLabel[])"})
  public void testNewPackedSwitchStmtNode() {
    // Arrange
    DexLabel dexLabel = new DexLabel();

    // Act
    PackedSwitchStmtNode actualPackedSwitchStmtNode =
        new PackedSwitchStmtNode(Op.NOP, 1, 1, new DexLabel[] {dexLabel});

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PackedSwitchStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    PackedSwitchStmtNode packedSwitchStmtNode =
        new PackedSwitchStmtNode(Op.NOP, 1, 1, new DexLabel[] {dexLabel});
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PackedSwitchStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode_thenArrayLengthIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    PackedSwitchStmtNode packedSwitchStmtNode =
        new PackedSwitchStmtNode(Op.NOP, 1, 1, new DexLabel[] {dexLabel});

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PackedSwitchStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    PackedSwitchStmtNode packedSwitchStmtNode =
        new PackedSwitchStmtNode(Op.NOP, 1, 1, new DexLabel[] {dexLabel});

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PackedSwitchStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    PackedSwitchStmtNode packedSwitchStmtNode =
        new PackedSwitchStmtNode(Op.NOP, 1, 1, new DexLabel[] {dexLabel});

    // Act
    packedSwitchStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = packedSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }
}
