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
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class MethodStmtNodeDiffblueTest {
  /**
   * Test {@link MethodStmtNode#MethodStmtNode(Op, int[], Method)}.
   *
   * <p>Method under test: {@link MethodStmtNode#MethodStmtNode(Op, int[], Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodStmtNode.<init>(Op, int[], Method)"})
  public void testNewMethodStmtNode() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    Method method =
        (new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, new Method("Owner", "Name", proto)))
            .method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", method.getName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", method.getReturnType());
    assertSame(proto, method.getProto());
  }

  /**
   * Test {@link MethodStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    MethodStmtNode methodStmtNode =
        new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, new Method("Owner", "Name", proto));
    DexCodeNode cv = new DexCodeNode();

    // Act
    methodStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodStmtNode);
    assertEquals(0, ((MethodStmtNode) getResult).__index);
    assertEquals(Op.NOP, ((MethodStmtNode) getResult).op);
    assertSame(proto, methodStmtNode.method.getProto());
    assertSame(proto, methodStmtNode.getProto());
    assertSame(proto, ((MethodStmtNode) getResult).getProto());
    assertSame(methodStmtNode.method, ((MethodStmtNode) getResult).method);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((MethodStmtNode) getResult).args);
  }

  /**
   * Test {@link MethodStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitor() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    MethodStmtNode methodStmtNode =
        new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, new Method("Owner", "Name", proto));

    // Act
    methodStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    assertSame(proto, methodStmtNode.method.getProto());
    assertSame(proto, methodStmtNode.getProto());
  }

  /**
   * Test {@link MethodStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    MethodStmtNode methodStmtNode =
        new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, new Method("Owner", "Name", proto));

    // Act
    methodStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert that nothing has changed
    assertSame(proto, methodStmtNode.method.getProto());
    assertSame(proto, methodStmtNode.getProto());
  }

  /**
   * Test {@link MethodStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeVisitor#DexCodeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    MethodStmtNode methodStmtNode =
        new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, new Method("Owner", "Name", proto));

    // Act
    methodStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    assertSame(proto, methodStmtNode.method.getProto());
    assertSame(proto, methodStmtNode.getProto());
  }

  /**
   * Test {@link MethodStmtNode#getProto()}.
   *
   * <p>Method under test: {@link MethodStmtNode#getProto()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Proto MethodStmtNode.getProto()"})
  public void testGetProto() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertSame(
        proto,
        (new MethodStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, new Method("Owner", "Name", proto)))
            .getProto());
  }
}
