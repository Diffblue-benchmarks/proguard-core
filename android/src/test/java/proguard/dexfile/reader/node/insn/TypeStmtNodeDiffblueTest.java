package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class TypeStmtNodeDiffblueTest {
  /**
   * Method under test: {@link TypeStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    TypeStmtNode typeStmtNode = new TypeStmtNode(Op.NOP, 1, 1, "Type");
    DexCodeNode cv = new DexCodeNode();

    // Act
    typeStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof TypeStmtNode);
    assertEquals("Type", ((TypeStmtNode) getResult).type);
    assertEquals(0, ((TypeStmtNode) getResult).__index);
    assertEquals(1, ((TypeStmtNode) getResult).a);
    assertEquals(1, ((TypeStmtNode) getResult).b);
    assertEquals(Op.NOP, ((TypeStmtNode) getResult).op);
  }

  /**
   * Method under test: {@link TypeStmtNode#TypeStmtNode(Op, int, int, String)}
   */
  @Test
  public void testNewTypeStmtNode() {
    // Arrange and Act
    TypeStmtNode actualTypeStmtNode = new TypeStmtNode(Op.NOP, 1, 1, "Type");

    // Assert
    assertEquals("Type", actualTypeStmtNode.type);
    assertEquals(0, actualTypeStmtNode.__index);
    assertEquals(1, actualTypeStmtNode.a);
    assertEquals(1, actualTypeStmtNode.b);
    assertEquals(Op.NOP, actualTypeStmtNode.op);
  }
}
