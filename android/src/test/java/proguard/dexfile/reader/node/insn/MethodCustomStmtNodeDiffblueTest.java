package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class MethodCustomStmtNodeDiffblueTest {
  /**
   * Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    MethodCustomStmtNode methodCustomStmtNode = new MethodCustomStmtNode(Op.NOP, new int[]{1, -1, 1, -1}, "Name", proto,
        new MethodHandle(1, field), new Object[]{Constant.Null});

    // Act
    methodCustomStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    assertEquals(1, methodCustomStmtNode.bsmArgs.length);
    assertSame(field, methodCustomStmtNode.bsm.getField());
    assertSame(proto, methodCustomStmtNode.getProto());
  }

  /**
   * Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    MethodCustomStmtNode methodCustomStmtNode = new MethodCustomStmtNode(Op.NOP, new int[]{1, -1, 1, -1}, "Name", proto,
        new MethodHandle(1, field), new Object[]{Constant.Null});

    // Act
    methodCustomStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    assertEquals(1, methodCustomStmtNode.bsmArgs.length);
    assertSame(field, methodCustomStmtNode.bsm.getField());
    assertSame(proto, methodCustomStmtNode.getProto());
  }

  /**
   * Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    MethodCustomStmtNode methodCustomStmtNode = new MethodCustomStmtNode(Op.NOP, new int[]{1, -1, 1, -1}, "Name", proto,
        new MethodHandle(1, field), new Object[]{Constant.Null});
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
    assertSame(methodCustomStmtNode.args, ((MethodCustomStmtNode) getResult).args);
    assertSame(methodCustomStmtNode.bsm, ((MethodCustomStmtNode) getResult).bsm);
    assertSame(methodCustomStmtNode.bsmArgs, objectArray);
  }

  /**
   * Method under test: {@link MethodCustomStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    MethodCustomStmtNode methodCustomStmtNode = new MethodCustomStmtNode(Op.NOP, new int[]{1, -1, 1, -1}, "Name", proto,
        new MethodHandle(1, field), new Object[]{Constant.Null});

    // Act
    methodCustomStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert
    assertEquals(1, methodCustomStmtNode.bsmArgs.length);
    assertSame(field, methodCustomStmtNode.bsm.getField());
    assertSame(proto, methodCustomStmtNode.getProto());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MethodCustomStmtNode#MethodCustomStmtNode(Op, int[], String, Proto, MethodHandle, Object[])}
   *   <li>{@link MethodCustomStmtNode#getProto()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    // Act
    MethodCustomStmtNode actualMethodCustomStmtNode = new MethodCustomStmtNode(Op.NOP, new int[]{1, -1, 1, -1}, "Name",
        proto, new MethodHandle(1, field), new Object[]{Constant.Null});
    Proto actualProto = actualMethodCustomStmtNode.getProto();

    // Assert
    MethodHandle methodHandle = actualMethodCustomStmtNode.bsm;
    assertNull(methodHandle.getMethod());
    assertEquals(1, methodHandle.getType());
    assertSame(field, methodHandle.getField());
    assertSame(proto, actualProto);
  }
}
