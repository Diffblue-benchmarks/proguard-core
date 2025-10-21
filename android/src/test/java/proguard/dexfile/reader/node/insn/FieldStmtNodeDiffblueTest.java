package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class FieldStmtNodeDiffblueTest {
  /**
   * Test {@link FieldStmtNode#FieldStmtNode(Op, int, int, Field)}.
   *
   * <p>Method under test: {@link FieldStmtNode#FieldStmtNode(Op, int, int, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldStmtNode.<init>(Op, int, int, Field)"})
  public void testNewFieldStmtNode() {
    // Arrange, Act and Assert
    Field field = (new FieldStmtNode(Op.NOP, 1, 1, new Field("Owner", "Name", "Type"))).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
  }

  /**
   * Test {@link FieldStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FieldStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    FieldStmtNode fieldStmtNode =
        new FieldStmtNode(Op.NOP, 1, 1, new Field("Owner", "Name", "Type"));
    DexCodeNode cv = new DexCodeNode();

    // Act
    fieldStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FieldStmtNode);
    assertEquals(0, ((FieldStmtNode) getResult).__index);
    assertEquals(1, ((FieldStmtNode) getResult).a);
    assertEquals(1, ((FieldStmtNode) getResult).b);
    assertEquals(Op.NOP, ((FieldStmtNode) getResult).op);
    assertSame(fieldStmtNode.field, ((FieldStmtNode) getResult).field);
  }
}
