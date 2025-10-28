package proguard.dexfile.reader.node;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.node.insn.ConstStmtNode;
import proguard.dexfile.reader.node.insn.DexLabelStmtNode;
import proguard.dexfile.reader.node.insn.DexStmtNode;
import proguard.dexfile.reader.node.insn.FieldStmtNode;
import proguard.dexfile.reader.node.insn.FillArrayDataStmtNode;
import proguard.dexfile.reader.node.insn.FilledNewArrayStmtNode;
import proguard.dexfile.reader.node.insn.JumpStmtNode;
import proguard.dexfile.reader.node.insn.MethodCustomStmtNode;
import proguard.dexfile.reader.node.insn.MethodPolymorphicStmtNode;
import proguard.dexfile.reader.node.insn.MethodStmtNode;
import proguard.dexfile.reader.node.insn.PackedSwitchStmtNode;
import proguard.dexfile.reader.node.insn.SparseSwitchStmtNode;
import proguard.dexfile.reader.node.insn.Stmt0RNode;
import proguard.dexfile.reader.node.insn.Stmt1RNode;
import proguard.dexfile.reader.node.insn.Stmt2R1NNode;
import proguard.dexfile.reader.node.insn.Stmt2RNode;
import proguard.dexfile.reader.node.insn.Stmt3RNode;
import proguard.dexfile.reader.node.insn.TypeStmtNode;
import proguard.dexfile.reader.visitors.DexCodeVisitor;
import proguard.dexfile.reader.visitors.DexDebugVisitor;
import proguard.dexfile.reader.visitors.DexMethodVisitor;

public class DexCodeNodeDiffblueTest {
  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();

    // Act
    dexCodeNode.accept(new DexMethodVisitor());

    // Assert that nothing has changed
    assertTrue(dexCodeNode.stmts.isEmpty());
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();

    // Act
    dexCodeNode.accept(new DexMethodVisitor(new DexMethodVisitor()));

    // Assert that nothing has changed
    assertTrue(dexCodeNode.stmts.isEmpty());
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    assertNull(dexCodeNode.tryStmts);
    DexCodeNode dexCodeNode2 = v.codeNode;
    assertNull(dexCodeNode2.tryStmts);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertTrue(dexCodeNode.stmts.isEmpty());
    assertTrue(dexCodeNode2.stmts.isEmpty());
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabelStmtNode stmt = new DexLabelStmtNode(new DexLabel());
    dexCodeNode.add(stmt);
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof DexLabelStmtNode);
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode2.tryStmts);
    assertNull(((DexLabelStmtNode) getResult).op);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertEquals(0, ((DexLabelStmtNode) getResult).__index);
    List<DexStmtNode> dexStmtNodeList2 = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    assertSame(stmt, dexStmtNodeList2.get(0));
    assertSame(stmt.label, ((DexLabelStmtNode) getResult).label);
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept5() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();
    dexCodeNode.visitTryCatch(start, end, new DexLabel[]{dexLabel}, new String[]{"Type"});
    DexLabelStmtNode stmt = new DexLabelStmtNode(new DexLabel());
    dexCodeNode.add(stmt);
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof DexLabelStmtNode);
    assertNull(((DexLabelStmtNode) getResult).op);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertEquals(0, ((DexLabelStmtNode) getResult).__index);
    List<DexStmtNode> dexStmtNodeList2 = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    List<TryCatchNode> tryCatchNodeList = dexCodeNode.tryStmts;
    assertEquals(1, tryCatchNodeList.size());
    List<TryCatchNode> tryCatchNodeList2 = dexCodeNode2.tryStmts;
    assertEquals(1, tryCatchNodeList2.size());
    TryCatchNode getResult2 = tryCatchNodeList2.get(0);
    DexLabel[] dexLabelArray = getResult2.handler;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
    TryCatchNode getResult3 = tryCatchNodeList.get(0);
    assertSame(end, getResult3.end);
    assertSame(end, getResult2.end);
    assertSame(start, getResult3.start);
    assertSame(start, getResult2.start);
    assertSame(stmt, dexStmtNodeList2.get(0));
    String[] stringArray = getResult2.type;
    assertSame(stringArray, getResult3.type);
    assertSame(stmt.label, ((DexLabelStmtNode) getResult).label);
    assertArrayEquals(new String[]{"Type"}, stringArray);
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept6() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    ConstStmtNode stmt = new ConstStmtNode(Op.NOP, -1, Constant.Null);

    dexCodeNode.add(stmt);
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof ConstStmtNode);
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode2.tryStmts);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertEquals(-1, ((ConstStmtNode) getResult).a);
    assertEquals(0, ((ConstStmtNode) getResult).__index);
    List<DexStmtNode> dexStmtNodeList2 = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    assertEquals(Op.NOP, ((ConstStmtNode) getResult).op);
    assertSame(stmt, dexStmtNodeList2.get(0));
    assertSame(stmt.value, ((ConstStmtNode) getResult).value);
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept7() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    FieldStmtNode stmt = new FieldStmtNode(Op.NOP, -1, -1, new Field("Owner", "Name", "Type"));

    dexCodeNode.add(stmt);
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FieldStmtNode);
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode2.tryStmts);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertEquals(-1, ((FieldStmtNode) getResult).a);
    assertEquals(-1, ((FieldStmtNode) getResult).b);
    assertEquals(0, ((FieldStmtNode) getResult).__index);
    List<DexStmtNode> dexStmtNodeList2 = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    assertEquals(Op.NOP, ((FieldStmtNode) getResult).op);
    assertSame(stmt, dexStmtNodeList2.get(0));
    assertSame(stmt.field, ((FieldStmtNode) getResult).field);
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept8() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    FillArrayDataStmtNode stmt = new FillArrayDataStmtNode(Op.NOP, -1, Constant.Null);

    dexCodeNode.add(stmt);
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FillArrayDataStmtNode);
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode2.tryStmts);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertEquals(-1, ((FillArrayDataStmtNode) getResult).ra);
    assertEquals(0, ((FillArrayDataStmtNode) getResult).__index);
    List<DexStmtNode> dexStmtNodeList2 = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    assertEquals(Op.NOP, ((FillArrayDataStmtNode) getResult).op);
    assertSame(stmt, dexStmtNodeList2.get(0));
    assertSame(stmt.array, ((FillArrayDataStmtNode) getResult).array);
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept9() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    Stmt0RNode stmt = new Stmt0RNode(Op.NOP);
    dexCodeNode.add(stmt);
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt0RNode);
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList2 = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    DexStmtNode getResult2 = dexStmtNodeList2.get(0);
    assertTrue(getResult2 instanceof Stmt0RNode);
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode2.tryStmts);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertEquals(0, ((Stmt0RNode) getResult2).__index);
    assertEquals(Op.NOP, ((Stmt0RNode) getResult2).op);
    assertSame(stmt, getResult);
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept10() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    FilledNewArrayStmtNode stmt = new FilledNewArrayStmtNode(Op.NOP, new int[]{-1, 1, -1, 1}, "Type");

    dexCodeNode.add(stmt);
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FilledNewArrayStmtNode);
    assertEquals("Type", ((FilledNewArrayStmtNode) getResult).type);
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode2.tryStmts);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertEquals(0, ((FilledNewArrayStmtNode) getResult).__index);
    List<DexStmtNode> dexStmtNodeList2 = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    assertEquals(Op.NOP, ((FilledNewArrayStmtNode) getResult).op);
    assertSame(stmt, dexStmtNodeList2.get(0));
    assertSame(stmt.args, ((FilledNewArrayStmtNode) getResult).args);
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept11() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    Stmt1RNode stmt = new Stmt1RNode(Op.NOP, -1);

    dexCodeNode.add(stmt);
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt1RNode);
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList2 = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    DexStmtNode getResult2 = dexStmtNodeList2.get(0);
    assertTrue(getResult2 instanceof Stmt1RNode);
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode2.tryStmts);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertEquals(-1, ((Stmt1RNode) getResult2).a);
    assertEquals(0, ((Stmt1RNode) getResult2).__index);
    assertEquals(Op.NOP, ((Stmt1RNode) getResult2).op);
    assertSame(stmt, getResult);
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept12() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    JumpStmtNode stmt = new JumpStmtNode(Op.NOP, -1, -1, new DexLabel());

    dexCodeNode.add(stmt);
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof JumpStmtNode);
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode2.tryStmts);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertEquals(-1, ((JumpStmtNode) getResult).a);
    assertEquals(-1, ((JumpStmtNode) getResult).b);
    assertEquals(0, ((JumpStmtNode) getResult).__index);
    List<DexStmtNode> dexStmtNodeList2 = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    assertEquals(Op.NOP, ((JumpStmtNode) getResult).op);
    assertSame(stmt, dexStmtNodeList2.get(0));
    assertSame(stmt.label, ((JumpStmtNode) getResult).label);
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept13() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    MethodCustomStmtNode stmt = new MethodCustomStmtNode(Op.NOP, new int[]{-1, 1, -1, 1}, "Name", proto,
        new MethodHandle(-1, new Field("Owner", "Name", "Type")), new Object[]{Constant.Null});

    dexCodeNode.add(stmt);
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodCustomStmtNode);
    assertEquals("Name", ((MethodCustomStmtNode) getResult).name);
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode2.tryStmts);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertEquals(0, ((MethodCustomStmtNode) getResult).__index);
    List<DexStmtNode> dexStmtNodeList2 = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    Object[] objectArray = ((MethodCustomStmtNode) getResult).bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(Op.NOP, ((MethodCustomStmtNode) getResult).op);
    assertSame(proto, ((MethodCustomStmtNode) getResult).getProto());
    assertSame(stmt, dexStmtNodeList2.get(0));
    assertSame(stmt.args, ((MethodCustomStmtNode) getResult).args);
    assertSame(stmt.bsm, ((MethodCustomStmtNode) getResult).bsm);
    assertSame(stmt.bsmArgs, objectArray);
  }

  /**
   * Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  public void testAccept14() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    Method method = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    MethodPolymorphicStmtNode stmt = new MethodPolymorphicStmtNode(Op.NOP, new int[]{-1, 1, -1, 1}, method, proto);

    dexCodeNode.add(stmt);
    DexMethodNode v = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodPolymorphicStmtNode);
    assertNull(dexCodeNode.tryStmts);
    assertNull(dexCodeNode2.tryStmts);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertEquals(0, ((MethodPolymorphicStmtNode) getResult).__index);
    List<DexStmtNode> dexStmtNodeList2 = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    assertEquals(Op.NOP, ((MethodPolymorphicStmtNode) getResult).op);
    assertSame(proto, ((MethodPolymorphicStmtNode) getResult).getProto());
    assertSame(stmt, dexStmtNodeList2.get(0));
    assertSame(stmt.args, ((MethodPolymorphicStmtNode) getResult).args);
    assertSame(stmt.method, ((MethodPolymorphicStmtNode) getResult).method);
  }

  /**
   * Method under test: {@link DexCodeNode#add(DexStmtNode)}
   */
  @Test
  public void testAdd() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabelStmtNode stmt = new DexLabelStmtNode(new DexLabel());

    // Act
    dexCodeNode.add(stmt);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    assertSame(stmt, dexStmtNodeList.get(0));
  }

  /**
   * Method under test: {@link DexCodeNode#visitConstStmt(Op, int, Object)}
   */
  @Test
  public void testVisitConstStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    Object object = Constant.Null;

    // Act
    dexCodeNode.visitConstStmt(Op.NOP, 1, object);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof ConstStmtNode);
    assertEquals(0, ((ConstStmtNode) getResult).__index);
    assertEquals(1, ((ConstStmtNode) getResult).a);
    assertEquals(Op.NOP, ((ConstStmtNode) getResult).op);
    assertSame(object, ((ConstStmtNode) getResult).value);
  }

  /**
   * Method under test:
   * {@link DexCodeNode#visitFillArrayDataStmt(Op, int, Object)}
   */
  @Test
  public void testVisitFillArrayDataStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    Object object = Constant.Null;

    // Act
    dexCodeNode.visitFillArrayDataStmt(Op.NOP, 1, object);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FillArrayDataStmtNode);
    assertEquals(0, ((FillArrayDataStmtNode) getResult).__index);
    assertEquals(1, ((FillArrayDataStmtNode) getResult).ra);
    assertEquals(Op.NOP, ((FillArrayDataStmtNode) getResult).op);
    assertSame(object, ((FillArrayDataStmtNode) getResult).array);
  }

  /**
   * Method under test: {@link DexCodeNode#visitFieldStmt(Op, int, int, Field)}
   */
  @Test
  public void testVisitFieldStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    Field field = new Field("Owner", "Name", "Type");

    // Act
    dexCodeNode.visitFieldStmt(Op.NOP, 1, 1, field);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FieldStmtNode);
    assertEquals(0, ((FieldStmtNode) getResult).__index);
    assertEquals(1, ((FieldStmtNode) getResult).a);
    assertEquals(1, ((FieldStmtNode) getResult).b);
    assertEquals(Op.NOP, ((FieldStmtNode) getResult).op);
    assertSame(field, ((FieldStmtNode) getResult).field);
  }

  /**
   * Method under test:
   * {@link DexCodeNode#visitFilledNewArrayStmt(Op, int[], String)}
   */
  @Test
  public void testVisitFilledNewArrayStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    int[] args = new int[]{1, -1, 1, -1};

    // Act
    dexCodeNode.visitFilledNewArrayStmt(Op.NOP, args, "Type");

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FilledNewArrayStmtNode);
    assertEquals("Type", ((FilledNewArrayStmtNode) getResult).type);
    assertEquals(0, ((FilledNewArrayStmtNode) getResult).__index);
    assertEquals(Op.NOP, ((FilledNewArrayStmtNode) getResult).op);
    assertSame(args, ((FilledNewArrayStmtNode) getResult).args);
  }

  /**
   * Method under test: {@link DexCodeNode#visitJumpStmt(Op, int, int, DexLabel)}
   */
  @Test
  public void testVisitJumpStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabel label = new DexLabel();

    // Act
    dexCodeNode.visitJumpStmt(Op.NOP, 1, 1, label);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof JumpStmtNode);
    assertEquals(0, ((JumpStmtNode) getResult).__index);
    assertEquals(1, ((JumpStmtNode) getResult).a);
    assertEquals(1, ((JumpStmtNode) getResult).b);
    assertEquals(Op.NOP, ((JumpStmtNode) getResult).op);
    assertSame(label, ((JumpStmtNode) getResult).label);
  }

  /**
   * Method under test: {@link DexCodeNode#visitLabel(DexLabel)}
   */
  @Test
  public void testVisitLabel() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabel label = new DexLabel();

    // Act
    dexCodeNode.visitLabel(label);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof DexLabelStmtNode);
    assertNull(((DexLabelStmtNode) getResult).op);
    assertEquals(0, ((DexLabelStmtNode) getResult).__index);
    assertSame(label, ((DexLabelStmtNode) getResult).label);
  }

  /**
   * Method under test:
   * {@link DexCodeNode#visitMethodStmt(Op, int[], String, Proto, MethodHandle, Object[])}
   */
  @Test
  public void testVisitMethodStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    int[] args = new int[]{1, -1, 1, -1};
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    MethodHandle bsm = new MethodHandle(1, new Field("Owner", "Name", "Type"));

    Object[] bsmArgs = new Object[]{Constant.Null};

    // Act
    dexCodeNode.visitMethodStmt(Op.NOP, args, "Name", proto, bsm, bsmArgs);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodCustomStmtNode);
    assertEquals("Name", ((MethodCustomStmtNode) getResult).name);
    assertEquals(0, ((MethodCustomStmtNode) getResult).__index);
    assertEquals(Op.NOP, ((MethodCustomStmtNode) getResult).op);
    assertSame(bsm, ((MethodCustomStmtNode) getResult).bsm);
    assertSame(proto, ((MethodCustomStmtNode) getResult).getProto());
    assertSame(args, ((MethodCustomStmtNode) getResult).args);
    assertSame(bsmArgs, ((MethodCustomStmtNode) getResult).bsmArgs);
  }

  /**
   * Method under test: {@link DexCodeNode#visitMethodStmt(Op, int[], Method)}
   */
  @Test
  public void testVisitMethodStmt2() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    int[] args = new int[]{1, -1, 1, -1};
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Method method = new Method("Owner", "Name", proto);

    // Act
    dexCodeNode.visitMethodStmt(Op.NOP, args, method);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodStmtNode);
    assertEquals(0, ((MethodStmtNode) getResult).__index);
    assertEquals(Op.NOP, ((MethodStmtNode) getResult).op);
    assertSame(method, ((MethodStmtNode) getResult).method);
    assertSame(proto, ((MethodStmtNode) getResult).getProto());
    assertSame(args, ((MethodStmtNode) getResult).args);
  }

  /**
   * Method under test:
   * {@link DexCodeNode#visitMethodStmt(Op, int[], Method, Proto)}
   */
  @Test
  public void testVisitMethodStmt3() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    int[] args = new int[]{1, -1, 1, -1};
    Method bsm = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    dexCodeNode.visitMethodStmt(Op.NOP, args, bsm, proto);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodPolymorphicStmtNode);
    assertEquals(0, ((MethodPolymorphicStmtNode) getResult).__index);
    assertEquals(Op.NOP, ((MethodPolymorphicStmtNode) getResult).op);
    assertSame(bsm, ((MethodPolymorphicStmtNode) getResult).method);
    assertSame(proto, ((MethodPolymorphicStmtNode) getResult).getProto());
    assertSame(args, ((MethodPolymorphicStmtNode) getResult).args);
  }

  /**
   * Method under test:
   * {@link DexCodeNode#visitPackedSwitchStmt(Op, int, int, DexLabel[])}
   */
  @Test
  public void testVisitPackedSwitchStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabel[] labels = new DexLabel[]{new DexLabel()};

    // Act
    dexCodeNode.visitPackedSwitchStmt(Op.NOP, 1, 1, labels);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof PackedSwitchStmtNode);
    assertEquals(0, ((PackedSwitchStmtNode) getResult).__index);
    assertEquals(1, ((PackedSwitchStmtNode) getResult).a);
    assertEquals(1, ((PackedSwitchStmtNode) getResult).first_case);
    assertEquals(Op.NOP, ((PackedSwitchStmtNode) getResult).op);
    assertSame(labels, ((PackedSwitchStmtNode) getResult).labels);
  }

  /**
   * Method under test:
   * {@link DexCodeNode#visitSparseSwitchStmt(Op, int, int[], DexLabel[])}
   */
  @Test
  public void testVisitSparseSwitchStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    int[] cases = new int[]{1, -1, 1, -1};
    DexLabel[] labels = new DexLabel[]{new DexLabel()};

    // Act
    dexCodeNode.visitSparseSwitchStmt(Op.NOP, 1, cases, labels);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof SparseSwitchStmtNode);
    assertEquals(0, ((SparseSwitchStmtNode) getResult).__index);
    assertEquals(1, ((SparseSwitchStmtNode) getResult).a);
    assertEquals(Op.NOP, ((SparseSwitchStmtNode) getResult).op);
    assertSame(cases, ((SparseSwitchStmtNode) getResult).cases);
    assertSame(labels, ((SparseSwitchStmtNode) getResult).labels);
  }

  /**
   * Method under test: {@link DexCodeNode#visitStmt0R(Op)}
   */
  @Test
  public void testVisitStmt0R() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();

    // Act
    dexCodeNode.visitStmt0R(Op.NOP);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt0RNode);
    assertEquals(0, ((Stmt0RNode) getResult).__index);
    assertEquals(Op.NOP, ((Stmt0RNode) getResult).op);
  }

  /**
   * Method under test: {@link DexCodeNode#visitStmt1R(Op, int)}
   */
  @Test
  public void testVisitStmt1R() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();

    // Act
    dexCodeNode.visitStmt1R(Op.NOP, 1);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt1RNode);
    assertEquals(0, ((Stmt1RNode) getResult).__index);
    assertEquals(1, ((Stmt1RNode) getResult).a);
    assertEquals(Op.NOP, ((Stmt1RNode) getResult).op);
  }

  /**
   * Method under test: {@link DexCodeNode#visitStmt2R(Op, int, int)}
   */
  @Test
  public void testVisitStmt2R() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();

    // Act
    dexCodeNode.visitStmt2R(Op.NOP, 1, 1);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt2RNode);
    assertEquals(0, ((Stmt2RNode) getResult).__index);
    assertEquals(1, ((Stmt2RNode) getResult).a);
    assertEquals(1, ((Stmt2RNode) getResult).b);
    assertEquals(Op.NOP, ((Stmt2RNode) getResult).op);
  }

  /**
   * Method under test: {@link DexCodeNode#visitStmt2R1N(Op, int, int, int)}
   */
  @Test
  public void testVisitStmt2R1N() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();

    // Act
    dexCodeNode.visitStmt2R1N(Op.NOP, 1, 1, 1);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt2R1NNode);
    assertEquals(0, ((Stmt2R1NNode) getResult).__index);
    assertEquals(1, ((Stmt2R1NNode) getResult).content);
    assertEquals(1, ((Stmt2R1NNode) getResult).distReg);
    assertEquals(1, ((Stmt2R1NNode) getResult).srcReg);
    assertEquals(Op.NOP, ((Stmt2R1NNode) getResult).op);
  }

  /**
   * Method under test: {@link DexCodeNode#visitStmt3R(Op, int, int, int)}
   */
  @Test
  public void testVisitStmt3R() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();

    // Act
    dexCodeNode.visitStmt3R(Op.NOP, 1, 1, 1);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt3RNode);
    assertEquals(0, ((Stmt3RNode) getResult).__index);
    assertEquals(1, ((Stmt3RNode) getResult).a);
    assertEquals(1, ((Stmt3RNode) getResult).b);
    assertEquals(1, ((Stmt3RNode) getResult).c);
    assertEquals(Op.NOP, ((Stmt3RNode) getResult).op);
  }

  /**
   * Method under test:
   * {@link DexCodeNode#visitTryCatch(DexLabel, DexLabel, DexLabel[], String[])}
   */
  @Test
  public void testVisitTryCatch() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel[] handler = new DexLabel[]{new DexLabel()};
    String[] type = new String[]{"Type"};

    // Act
    dexCodeNode.visitTryCatch(start, end, handler, type);

    // Assert
    List<TryCatchNode> tryCatchNodeList = dexCodeNode.tryStmts;
    assertEquals(1, tryCatchNodeList.size());
    TryCatchNode getResult = tryCatchNodeList.get(0);
    assertSame(end, getResult.end);
    assertSame(start, getResult.start);
    assertSame(type, getResult.type);
    assertSame(handler, getResult.handler);
  }

  /**
   * Method under test:
   * {@link DexCodeNode#visitTryCatch(DexLabel, DexLabel, DexLabel[], String[])}
   */
  @Test
  public void testVisitTryCatch2() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.tryStmts = new ArrayList<>();
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel[] handler = new DexLabel[]{new DexLabel()};
    String[] type = new String[]{"Type"};

    // Act
    dexCodeNode.visitTryCatch(start, end, handler, type);

    // Assert
    List<TryCatchNode> tryCatchNodeList = dexCodeNode.tryStmts;
    assertEquals(1, tryCatchNodeList.size());
    TryCatchNode getResult = tryCatchNodeList.get(0);
    assertSame(end, getResult.end);
    assertSame(start, getResult.start);
    assertSame(type, getResult.type);
    assertSame(handler, getResult.handler);
  }

  /**
   * Method under test: {@link DexCodeNode#visitTypeStmt(Op, int, int, String)}
   */
  @Test
  public void testVisitTypeStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();

    // Act
    dexCodeNode.visitTypeStmt(Op.NOP, 1, 1, "Type");

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
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
   * Method under test: {@link DexCodeNode#visitDebug()}
   */
  @Test
  public void testVisitDebug() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();

    // Act
    DexDebugVisitor actualVisitDebugResult = dexCodeNode.visitDebug();

    // Assert
    DexDebugNode dexDebugNode = dexCodeNode.debugNode;
    assertNull(dexDebugNode.fineName);
    assertNull(dexDebugNode.parameterNames);
    assertSame(dexCodeNode.debugNode, actualVisitDebugResult);
    assertSame(((DexDebugNode) actualVisitDebugResult).debugNodes, dexDebugNode.debugNodes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DexCodeNode#DexCodeNode()}
   *   <li>{@link DexCodeNode#visitRegister(int)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DexCodeNode actualDexCodeNode = new DexCodeNode();
    actualDexCodeNode.visitRegister(1);

    // Assert
    assertTrue(actualDexCodeNode.stmts.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DexCodeNode#DexCodeNode(DexCodeVisitor)}
   *   <li>{@link DexCodeNode#visitRegister(int)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    DexCodeNode actualDexCodeNode = new DexCodeNode(new DexCodeVisitor());
    actualDexCodeNode.visitRegister(1);

    // Assert
    assertTrue(actualDexCodeNode.stmts.isEmpty());
  }
}
