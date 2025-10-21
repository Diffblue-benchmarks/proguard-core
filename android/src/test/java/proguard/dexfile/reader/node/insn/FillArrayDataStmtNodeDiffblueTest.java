package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class FillArrayDataStmtNodeDiffblueTest {
  /**
   * Test {@link FillArrayDataStmtNode#FillArrayDataStmtNode(Op, int, Object)}.
   *
   * <p>Method under test: {@link FillArrayDataStmtNode#FillArrayDataStmtNode(Op, int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FillArrayDataStmtNode.<init>(Op, int, Object)"})
  public void testNewFillArrayDataStmtNode() {
    // Arrange and Act
    FillArrayDataStmtNode actualFillArrayDataStmtNode =
        new FillArrayDataStmtNode(Op.NOP, 1, Constant.Null);

    // Assert
    assertEquals(0, actualFillArrayDataStmtNode.__index);
    assertEquals(1, actualFillArrayDataStmtNode.ra);
    assertEquals(Op.NOP, actualFillArrayDataStmtNode.op);
  }

  /**
   * Test {@link FillArrayDataStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FillArrayDataStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FillArrayDataStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    FillArrayDataStmtNode fillArrayDataStmtNode =
        new FillArrayDataStmtNode(Op.NOP, 1, Constant.Null);
    DexCodeNode cv = new DexCodeNode();

    // Act
    fillArrayDataStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FillArrayDataStmtNode);
    assertEquals(0, ((FillArrayDataStmtNode) getResult).__index);
    assertEquals(1, ((FillArrayDataStmtNode) getResult).ra);
    assertEquals(Op.NOP, ((FillArrayDataStmtNode) getResult).op);
    assertSame(fillArrayDataStmtNode.array, ((FillArrayDataStmtNode) getResult).array);
  }
}
