package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class DexLabelStmtNodeDiffblueTest {
  /**
   * Test {@link DexLabelStmtNode#DexLabelStmtNode(DexLabel)}.
   *
   * <p>Method under test: {@link DexLabelStmtNode#DexLabelStmtNode(DexLabel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexLabelStmtNode.<init>(DexLabel)"})
  public void testNewDexLabelStmtNode() {
    // Arrange and Act
    DexLabelStmtNode actualDexLabelStmtNode = new DexLabelStmtNode(new DexLabel());

    // Assert
    assertNull(actualDexLabelStmtNode.op);
    assertEquals(0, actualDexLabelStmtNode.__index);
  }

  /**
   * Test {@link DexLabelStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexLabelStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexLabelStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
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
}
