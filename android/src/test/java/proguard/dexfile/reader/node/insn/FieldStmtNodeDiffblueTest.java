package proguard.dexfile.reader.node.insn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

class FieldStmtNodeDiffblueTest {
  /**
   * Test {@link FieldStmtNode#FieldStmtNode(Op, int, int, Field)}.
   *
   * <p>Method under test: {@link FieldStmtNode#FieldStmtNode(Op, int, int, Field)}
   */
  @Test
  @DisplayName("Test new FieldStmtNode(Op, int, int, Field)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldStmtNode.<init>(Op, int, int, Field)"})
  void testNewFieldStmtNode() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");

    // Act and Assert
    Field field2 = new FieldStmtNode(Op.NOP, 1, 1, field).field;
    assertEquals("Name", field2.getName());
    assertEquals("Owner", field2.getOwner());
    assertEquals("Type", field2.getType());
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
  @DisplayName(
      "Test accept(DexCodeVisitor); when DexCodeNode(); then DexCodeNode() stmts size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldStmtNode.accept(DexCodeVisitor)"})
  void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");
    FieldStmtNode fieldStmtNode = new FieldStmtNode(Op.NOP, 1, 1, field);
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
