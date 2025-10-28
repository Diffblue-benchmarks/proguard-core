package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class PackedSwitchStmtNodeDiffblueTest {
  /**
   * Method under test: {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    PackedSwitchStmtNode packedSwitchStmtNode = new PackedSwitchStmtNode(Op.NOP, 1, 1, new DexLabel[]{dexLabel});

    // Act
    packedSwitchStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = packedSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Method under test: {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    PackedSwitchStmtNode packedSwitchStmtNode = new PackedSwitchStmtNode(Op.NOP, 1, 1, new DexLabel[]{dexLabel});

    // Act
    packedSwitchStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    DexLabel[] dexLabelArray = packedSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Method under test: {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    PackedSwitchStmtNode packedSwitchStmtNode = new PackedSwitchStmtNode(Op.NOP, 1, 1, new DexLabel[]{dexLabel});
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
    assertEquals(1, ((PackedSwitchStmtNode) getResult).a);
    assertEquals(1, ((PackedSwitchStmtNode) getResult).first_case);
    assertEquals(Op.NOP, ((PackedSwitchStmtNode) getResult).op);
    assertSame(dexLabel, dexLabelArray[0]);
    assertSame(packedSwitchStmtNode.labels, ((PackedSwitchStmtNode) getResult).labels);
  }

  /**
   * Method under test: {@link PackedSwitchStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    DexLabel dexLabel = new DexLabel();
    PackedSwitchStmtNode packedSwitchStmtNode = new PackedSwitchStmtNode(Op.NOP, 1, 1, new DexLabel[]{dexLabel});

    // Act
    packedSwitchStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert
    DexLabel[] dexLabelArray = packedSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
  }

  /**
   * Method under test:
   * {@link PackedSwitchStmtNode#PackedSwitchStmtNode(Op, int, int, DexLabel[])}
   */
  @Test
  public void testNewPackedSwitchStmtNode() {
    // Arrange
    DexLabel dexLabel = new DexLabel();

    // Act
    PackedSwitchStmtNode actualPackedSwitchStmtNode = new PackedSwitchStmtNode(Op.NOP, 1, 1, new DexLabel[]{dexLabel});

    // Assert
    assertEquals(0, actualPackedSwitchStmtNode.__index);
    DexLabel[] dexLabelArray = actualPackedSwitchStmtNode.labels;
    assertEquals(1, dexLabelArray.length);
    assertEquals(1, actualPackedSwitchStmtNode.a);
    assertEquals(1, actualPackedSwitchStmtNode.first_case);
    assertEquals(Op.NOP, actualPackedSwitchStmtNode.op);
    assertSame(dexLabel, dexLabelArray[0]);
  }
}
