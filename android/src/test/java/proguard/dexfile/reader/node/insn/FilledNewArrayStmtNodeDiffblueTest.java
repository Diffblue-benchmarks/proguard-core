package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class FilledNewArrayStmtNodeDiffblueTest {
  /**
   * Method under test: {@link FilledNewArrayStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    FilledNewArrayStmtNode filledNewArrayStmtNode = new FilledNewArrayStmtNode(Op.NOP, new int[]{1, -1, 1, -1}, "Type");
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
    assertSame(filledNewArrayStmtNode.args, ((FilledNewArrayStmtNode) getResult).args);
  }

  /**
   * Method under test:
   * {@link FilledNewArrayStmtNode#FilledNewArrayStmtNode(Op, int[], String)}
   */
  @Test
  public void testNewFilledNewArrayStmtNode() {
    // Arrange and Act
    FilledNewArrayStmtNode actualFilledNewArrayStmtNode = new FilledNewArrayStmtNode(Op.NOP, new int[]{1, -1, 1, -1},
        "Type");

    // Assert
    assertEquals("Type", actualFilledNewArrayStmtNode.type);
    assertEquals(0, actualFilledNewArrayStmtNode.__index);
    assertEquals(Op.NOP, actualFilledNewArrayStmtNode.op);
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualFilledNewArrayStmtNode.args);
  }
}
