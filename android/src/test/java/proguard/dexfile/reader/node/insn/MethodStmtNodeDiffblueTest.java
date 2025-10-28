package proguard.dexfile.reader.node.insn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.node.DexCodeNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;

public class MethodStmtNodeDiffblueTest {
  /**
   * Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    MethodStmtNode methodStmtNode = new MethodStmtNode(Op.NOP, new int[]{1, -1, 1, -1},
        new Method("Owner", "Name", proto));

    // Act
    methodStmtNode.accept(new DexCodeVisitor());

    // Assert that nothing has changed
    assertSame(proto, methodStmtNode.method.getProto());
    assertSame(proto, methodStmtNode.getProto());
  }

  /**
   * Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    MethodStmtNode methodStmtNode = new MethodStmtNode(Op.NOP, new int[]{1, -1, 1, -1},
        new Method("Owner", "Name", proto));

    // Act
    methodStmtNode.accept(new DexCodeVisitor(new DexCodeVisitor()));

    // Assert that nothing has changed
    assertSame(proto, methodStmtNode.method.getProto());
    assertSame(proto, methodStmtNode.getProto());
  }

  /**
   * Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    MethodStmtNode methodStmtNode = new MethodStmtNode(Op.NOP, new int[]{1, -1, 1, -1},
        new Method("Owner", "Name", proto));
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
    assertSame(methodStmtNode.args, ((MethodStmtNode) getResult).args);
    assertSame(methodStmtNode.method, ((MethodStmtNode) getResult).method);
  }

  /**
   * Method under test: {@link MethodStmtNode#accept(DexCodeVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    MethodStmtNode methodStmtNode = new MethodStmtNode(Op.NOP, new int[]{1, -1, 1, -1},
        new Method("Owner", "Name", proto));

    // Act
    methodStmtNode.accept(new DexCodeVisitor(new DexCodeNode()));

    // Assert
    assertSame(proto, methodStmtNode.method.getProto());
    assertSame(proto, methodStmtNode.getProto());
  }

  /**
   * Method under test: {@link MethodStmtNode#getProto()}
   */
  @Test
  public void testGetProto() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertSame(proto,
        (new MethodStmtNode(Op.NOP, new int[]{1, -1, 1, -1}, new Method("Owner", "Name", proto))).getProto());
  }

  /**
   * Method under test: {@link MethodStmtNode#MethodStmtNode(Op, int[], Method)}
   */
  @Test
  public void testNewMethodStmtNode() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    Method method = (new MethodStmtNode(Op.NOP, new int[]{1, -1, 1, -1}, new Method("Owner", "Name", proto))).method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", method.getName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", method.getReturnType());
    assertSame(proto, method.getProto());
  }
}
