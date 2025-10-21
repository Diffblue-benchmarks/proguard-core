package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertArrayEquals;
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

public class SparseSwitchStmtNodeDiffblueTest {
  /**
   * Test {@link SparseSwitchStmtNode#SparseSwitchStmtNode(Op, int, int[], DexLabel[])}.
   *
   * <p>Method under test: {@link SparseSwitchStmtNode#SparseSwitchStmtNode(Op, int, int[],
   * DexLabel[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SparseSwitchStmtNode.<init>(Op, int, int[], DexLabel[])"})
  public void testNewSparseSwitchStmtNode() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SparseSwitchStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SparseSwitchStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode_thenArrayLengthIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SparseSwitchStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor_thenArrayLengthIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SparseSwitchStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitor_thenArrayLengthIsOne() {
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
