package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class DexLabelStmtNodeDiffblueTest {
  /**
   * Method under test: {@link DexLabelStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
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

  /**
   * Method under test: {@link DexLabelStmtNode#DexLabelStmtNode(DexLabel)}
   */
  @Test
  public void testNewDexLabelStmtNode() {
    // Arrange and Act
    DexLabelStmtNode actualDexLabelStmtNode = new DexLabelStmtNode(new DexLabel());

    // Assert
    assertNull(actualDexLabelStmtNode.op);
    assertEquals(0, actualDexLabelStmtNode.__index);
  }
}
