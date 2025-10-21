package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class MethodCustomStmtNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MethodCustomStmtNode#MethodCustomStmtNode(Op, int[], String, Proto, MethodHandle,
   *       Object[])}
   *   <li>{@link MethodCustomStmtNode#getProto()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void MethodCustomStmtNode.<init>(Op, int[], String, Proto, MethodHandle, Object[])",
    "Proto MethodCustomStmtNode.getProto()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    // Act
    MethodCustomStmtNode actualMethodCustomStmtNode =
        new MethodCustomStmtNode(
            Op.NOP,
            new int[] {1, -1, 1, -1},
            "Name",
            proto,
            new MethodHandle(1, field),
            new Object[] {Constant.Null});
    Proto actualProto = actualMethodCustomStmtNode.getProto();

    // Assert
    MethodHandle methodHandle = actualMethodCustomStmtNode.bsm;
    assertNull(methodHandle.getMethod());
    assertEquals(1, methodHandle.getType());
    assertSame(field, methodHandle.getField());
    assertSame(proto, actualProto);
  }

  /**
   * Test {@link MethodCustomStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodCustomStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    MethodCustomStmtNode methodCustomStmtNode =
        new MethodCustomStmtNode(
            Op.NOP,
            new int[] {1, -1, 1, -1},
            "Name",
            proto,
            new MethodHandle(1, field),
            new Object[] {Constant.Null});
    DexCodeNode cv = new DexCodeNode();

    // Act
    methodCustomStmtNode.accept(cv);

    // Assert
    List<DexStmtNode> dexStmtNodeList = cv.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodCustomStmtNode);
    assertEquals("Name", ((MethodCustomStmtNode) getResult).name);
    assertEquals(0, ((MethodCustomStmtNode) getResult).__index);
    assertEquals(1, methodCustomStmtNode.bsmArgs.length);
    Object[] objectArray = ((MethodCustomStmtNode) getResult).bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(Op.NOP, ((MethodCustomStmtNode) getResult).op);
    assertSame(field, methodCustomStmtNode.bsm.getField());
    assertSame(proto, methodCustomStmtNode.getProto());
    assertSame(proto, ((MethodCustomStmtNode) getResult).getProto());
    assertSame(methodCustomStmtNode.bsm, ((MethodCustomStmtNode) getResult).bsm);
    assertSame(methodCustomStmtNode.bsmArgs, objectArray);
    assertArrayEquals(new int[] {1, -1, 1, -1}, ((MethodCustomStmtNode) getResult).args);
  }

  /**
   * Test {@link MethodCustomStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodCustomStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitor() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    MethodCustomStmtNode methodCustomStmtNode =
        new MethodCustomStmtNode(
            Op.NOP,
            new int[] {1, -1, 1, -1},
            "Name",
            proto,
            new MethodHandle(1, field),
            new Object[] {Constant.Null});

    // Act
    methodCustomStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    assertSame(field, methodCustomStmtNode.bsm.getField());
    assertSame(proto, methodCustomStmtNode.getProto());
  }

  /**
   * Test {@link MethodCustomStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeNode#DexCodeNode()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodCustomStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeNode() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    MethodCustomStmtNode methodCustomStmtNode =
        new MethodCustomStmtNode(
            Op.NOP,
            new int[] {1, -1, 1, -1},
            "Name",
            proto,
            new MethodHandle(1, field),
            new Object[] {Constant.Null});

    // Act
    methodCustomStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert that nothing has changed
    assertSame(field, methodCustomStmtNode.bsm.getField());
    assertSame(proto, methodCustomStmtNode.getProto());
  }

  /**
   * Test {@link MethodCustomStmtNode#accept(DexCodeVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor(DexCodeVisitor)} with visitor is {@link
   *       DexCodeVisitor#DexCodeVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MethodCustomStmtNode.accept(DexCodeVisitor)"})
  public void testAccept_whenDexCodeVisitorWithVisitorIsDexCodeVisitor() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    MethodCustomStmtNode methodCustomStmtNode =
        new MethodCustomStmtNode(
            Op.NOP,
            new int[] {1, -1, 1, -1},
            "Name",
            proto,
            new MethodHandle(1, field),
            new Object[] {Constant.Null});

    // Act
    methodCustomStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    assertSame(field, methodCustomStmtNode.bsm.getField());
    assertSame(proto, methodCustomStmtNode.getProto());
  }
}
