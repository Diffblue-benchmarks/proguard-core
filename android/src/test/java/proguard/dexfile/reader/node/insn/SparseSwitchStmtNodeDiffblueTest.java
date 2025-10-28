package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class SparseSwitchStmtNodeDiffblueTest {
  /**
   * Method under test: {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    SparseSwitchStmtNode sparseSwitchStmtNode = new SparseSwitchStmtNode(Op.NOP, 1, new int[]{1, -1, 1, -1},
        new DexLabel[]{dexLabel});

    // Act
    sparseSwitchStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = sparseSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Method under test: {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    SparseSwitchStmtNode sparseSwitchStmtNode = new SparseSwitchStmtNode(Op.NOP, 1, new int[]{1, -1, 1, -1},
        new DexLabel[]{dexLabel});

    // Act
    sparseSwitchStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = sparseSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Method under test: {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    SparseSwitchStmtNode sparseSwitchStmtNode = new SparseSwitchStmtNode(Op.NOP, 1, new int[]{1, -1, 1, -1},
        new DexLabel[]{dexLabel});
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
    assertEquals(1, ((SparseSwitchStmtNode) getResult).a);
    assertEquals(Op.NOP, ((SparseSwitchStmtNode) getResult).op);
    assertSame(dexLabel, dexLabelArray[0]);
    assertSame(sparseSwitchStmtNode.labels, ((SparseSwitchStmtNode) getResult).labels);
    assertSame(sparseSwitchStmtNode.cases, ((SparseSwitchStmtNode) getResult).cases);
  }

  /**
   * Method under test: {@link SparseSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    SparseSwitchStmtNode sparseSwitchStmtNode = new SparseSwitchStmtNode(Op.NOP, 1, new int[]{1, -1, 1, -1},
        new DexLabel[]{dexLabel});

    // Act
    sparseSwitchStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert
    DexLabel[] dexLabelArray = sparseSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Method under test:
   * {@link SparseSwitchStmtNode#SparseSwitchStmtNode(Op, int, int[], DexLabel[])}
   */
  @Test
  public void testNewSparseSwitchStmtNode() {
    // Arrange
    DexLabel dexLabel = new DexLabel();

    // Act
    SparseSwitchStmtNode actualSparseSwitchStmtNode = new SparseSwitchStmtNode(Op.NOP, 1, new int[]{1, -1, 1, -1},
        new DexLabel[]{dexLabel});

    // Assert
    assertEquals(0, actualSparseSwitchStmtNode.__index);
    DexLabel[] dexLabelArray = actualSparseSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertEquals(1, actualSparseSwitchStmtNode.a);
    assertEquals(Op.NOP, actualSparseSwitchStmtNode.op);
    assertSame(dexLabel, dexLabelArray[0]);
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualSparseSwitchStmtNode.cases);
  }
}
