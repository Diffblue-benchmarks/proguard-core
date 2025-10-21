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

public class MethodPolymorphicStmtNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodPolymorphicStmtNode#MethodPolymorphicStmtNode(Op, int[], Method, Proto)}
   *   <li>{@link MethodPolymorphicStmtNode#getProto()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodPolymorphicStmtNode.<init>(Op, int[], Method, Proto)",
    "Proto MethodPolymorphicStmtNode.getProto()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Method method = new Method("Owner", "Name", proto);

    Proto proto2 = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    MethodPolymorphicStmtNode actualMethodPolymorphicStmtNode =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method, proto2);
    Proto actualProto = actualMethodPolymorphicStmtNode.getProto();

    // Assert
    Method method2 = actualMethodPolymorphicStmtNode.method;
    assertEquals("(Parameter Types)Return Type", method2.getDesc());
    assertEquals("Name", method2.getName());
    assertEquals("Owner", method2.getOwner());
    assertEquals("Return Type", method2.getReturnType());
    assertSame(proto, method2.getProto());
    assertSame(proto2, actualProto);
    assertArrayEquals(new String[] {"Parameter Types"}, method2.getParameterTypes());
  }

  /**
   * Test {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodPolymorphicStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Method method = new Method("Owner", "Name", proto);

    Proto proto2 = new Proto(new String[] {"Parameter Types"}, "Return Type");

    MethodPolymorphicStmtNode methodPolymorphicStmtNode =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method, proto2);
    DexCodeNode cv = new DexCodeNode();

    // Act
    methodPolymorphicStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodPolymorphicStmtNode);
    assertEquals(0, ((MethodPolymorphicStmtNode) getResult).__index);
    assertEquals(Op.NOP, ((MethodPolymorphicStmtNode) getResult).op);
    assertSame(proto, methodPolymorphicStmtNode.method.getProto());
    assertSame(proto2, methodPolymorphicStmtNode.getProto());
    assertSame(proto2, ((MethodPolymorphicStmtNode) getResult).getProto());
    assertSame(methodPolymorphicStmtNode.method, ((MethodPolymorphicStmtNode) getResult).method);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((MethodPolymorphicStmtNode) getResult).args);
  }

  /**
   * Test {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodPolymorphicStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode_thenArrayLengthIsOne() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Method method = new Method("Owner", "Name", proto);

    Proto proto2 = new Proto(new String[] {"Parameter Types"}, "Return Type");

    MethodPolymorphicStmtNode methodPolymorphicStmtNode =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method, proto2);

    // Act
    methodPolymorphicStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert that nothing has changed
    Method method2 = methodPolymorphicStmtNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
    assertSame(proto2, methodPolymorphicStmtNode.getProto());
  }

  /**
   * Test {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodPolymorphicStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Method method = new Method("Owner", "Name", proto);

    Proto proto2 = new Proto(new String[] {"Parameter Types"}, "Return Type");

    MethodPolymorphicStmtNode methodPolymorphicStmtNode =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method, proto2);

    // Act
    methodPolymorphicStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    Method method2 = methodPolymorphicStmtNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
    assertSame(proto2, methodPolymorphicStmtNode.getProto());
  }

  /**
   * Test {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodPolymorphicStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodPolymorphicStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitor_thenArrayLengthIsOne() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Method method = new Method("Owner", "Name", proto);

    Proto proto2 = new Proto(new String[] {"Parameter Types"}, "Return Type");

    MethodPolymorphicStmtNode methodPolymorphicStmtNode =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {1, -1, 1, -1}, method, proto2);

    // Act
    methodPolymorphicStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    Method method2 = methodPolymorphicStmtNode.method;
    assertEquals(1, method2.getParameterTypes().length);
    assertSame(proto, method2.getProto());
    assertSame(proto2, methodPolymorphicStmtNode.getProto());
  }
}
