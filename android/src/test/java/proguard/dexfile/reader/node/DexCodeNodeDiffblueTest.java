package proguard.dexfile.reader.node;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexCodeNode#DexCodeNode()}
   *   <li>{@link DexCodeNode#visitRegister(int)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexCodeNode.<init>()",
    "void DexCodeNode.<init>(DexCodeVisitor)",
    "void DexCodeNode.visitRegister(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DexCodeNode actualDexCodeNode = new DexCodeNode();
    actualDexCodeNode.visitRegister(1);

    // Assert
    assertTrue(actualDexCodeNode.stmts.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link DexCodeVisitor#DexCodeVisitor()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexCodeNode#DexCodeNode(DexCodeVisitor)}
   *   <li>{@link DexCodeNode#visitRegister(int)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexCodeNode.<init>()",
    "void DexCodeNode.<init>(DexCodeVisitor)",
    "void DexCodeNode.visitRegister(int)"
  })
  public void testGettersAndSetters_whenDexCodeVisitor() {
    // Arrange and Act
    DexCodeNode actualDexCodeNode = new DexCodeNode(new DexCodeVisitor());
    actualDexCodeNode.visitRegister(1);

    // Assert
    assertTrue(actualDexCodeNode.stmts.isEmpty());
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    DexCodeNode dexCodeNode2 = v.codeNode;
    assertNull(dexCodeNode2.tryStmts);
    assertNull(dexCodeNode2.debugNode);
    assertEquals(-1, dexCodeNode2.totalRegister);
    assertTrue(dexCodeNode2.stmts.isEmpty());
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor2() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabelStmtNode stmt = new DexLabelStmtNode(new DexLabel());
    dexCodeNode.add(stmt);
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<DexStmtNode> dexStmtNodeList = v.codeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof DexLabelStmtNode);
    assertNull(((DexLabelStmtNode) getResult).op);
    assertSame(stmt.label, ((DexLabelStmtNode) getResult).label);
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor3() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new Stmt0RNode(Op.NOP));
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    DexCodeNode dexCodeNode2 = v.codeNode;
    List<DexStmtNode> dexStmtNodeList = dexCodeNode2.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt0RNode);
    assertNull(dexCodeNode2.tryStmts);
    assertEquals(0, ((Stmt0RNode) getResult).__index);
    assertEquals(Op.NOP, ((Stmt0RNode) getResult).op);
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor4() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new FilledNewArrayStmtNode(Op.NOP, new int[] {-1, 1, -1, 1}, "Type"));
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<DexStmtNode> dexStmtNodeList = v.codeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FilledNewArrayStmtNode);
    assertEquals("Type", ((FilledNewArrayStmtNode) getResult).type);
    assertArrayEquals(new int[] {-1, 1, -1, 1}, ((FilledNewArrayStmtNode) getResult).args);
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor5() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.add(new Stmt1RNode(Op.NOP, -1));
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<DexStmtNode> dexStmtNodeList = v.codeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof Stmt1RNode);
    assertEquals(-1, ((Stmt1RNode) getResult).a);
    assertEquals(0, ((Stmt1RNode) getResult).__index);
    assertEquals(Op.NOP, ((Stmt1RNode) getResult).op);
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor6() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    JumpStmtNode stmt = new JumpStmtNode(Op.NOP, -1, -1, new DexLabel());

    dexCodeNode.add(stmt);
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<DexStmtNode> dexStmtNodeList = v.codeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof JumpStmtNode);
    assertEquals(-1, ((JumpStmtNode) getResult).b);
    assertSame(stmt.label, ((JumpStmtNode) getResult).label);
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor7() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    Method method =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    MethodPolymorphicStmtNode stmt =
        new MethodPolymorphicStmtNode(Op.NOP, new int[] {-1, 1, -1, 1}, method, proto);

    dexCodeNode.add(stmt);
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodPolymorphicStmtNode);
    List<DexStmtNode> dexStmtNodeList2 = v.codeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    DexStmtNode getResult2 = dexStmtNodeList2.get(0);
    assertTrue(getResult2 instanceof MethodPolymorphicStmtNode);
    assertSame(proto, ((MethodPolymorphicStmtNode) getResult).getProto());
    assertSame(proto, ((MethodPolymorphicStmtNode) getResult2).getProto());
    Method method2 = stmt.method;
    assertSame(method2, ((MethodPolymorphicStmtNode) getResult).method);
    assertSame(method2, ((MethodPolymorphicStmtNode) getResult2).method);
    assertArrayEquals(new int[] {-1, 1, -1, 1}, ((MethodPolymorphicStmtNode) getResult2).args);
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <ul>
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} first {@link
   *       ConstStmtNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor_thenDexCodeNodeStmtsFirstConstStmtNode() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    ConstStmtNode stmt = new ConstStmtNode(Op.NOP, -1, Constant.Null);

    dexCodeNode.add(stmt);
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof ConstStmtNode);
    List<DexStmtNode> dexStmtNodeList2 = v.codeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    DexStmtNode getResult2 = dexStmtNodeList2.get(0);
    assertTrue(getResult2 instanceof ConstStmtNode);
    Object object = stmt.value;
    assertSame(object, ((ConstStmtNode) getResult).value);
    assertSame(object, ((ConstStmtNode) getResult2).value);
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <ul>
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} first {@link
   *       FieldStmtNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor_thenDexCodeNodeStmtsFirstFieldStmtNode() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    FieldStmtNode stmt = new FieldStmtNode(Op.NOP, -1, -1, new Field("Owner", "Name", "Type"));

    dexCodeNode.add(stmt);
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FieldStmtNode);
    List<DexStmtNode> dexStmtNodeList2 = v.codeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    DexStmtNode getResult2 = dexStmtNodeList2.get(0);
    assertTrue(getResult2 instanceof FieldStmtNode);
    Field field = stmt.field;
    assertSame(field, ((FieldStmtNode) getResult).field);
    assertSame(field, ((FieldStmtNode) getResult2).field);
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <ul>
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} first {@link
   *       FillArrayDataStmtNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor_thenDexCodeNodeStmtsFirstFillArrayDataStmtNode() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    FillArrayDataStmtNode stmt = new FillArrayDataStmtNode(Op.NOP, -1, Constant.Null);

    dexCodeNode.add(stmt);
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof FillArrayDataStmtNode);
    List<DexStmtNode> dexStmtNodeList2 = v.codeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    DexStmtNode getResult2 = dexStmtNodeList2.get(0);
    assertTrue(getResult2 instanceof FillArrayDataStmtNode);
    assertEquals(-1, ((FillArrayDataStmtNode) getResult2).ra);
    Object object = stmt.array;
    assertSame(object, ((FillArrayDataStmtNode) getResult).array);
    assertSame(object, ((FillArrayDataStmtNode) getResult2).array);
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <ul>
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} first {@link
   *       MethodCustomStmtNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor_thenDexCodeNodeStmtsFirstMethodCustomStmtNode() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    MethodCustomStmtNode stmt =
        new MethodCustomStmtNode(
            Op.NOP,
            new int[] {-1, 1, -1, 1},
            "Name",
            proto,
            new MethodHandle(-1, new Field("Owner", "Name", "Type")),
            new Object[] {Constant.Null});

    dexCodeNode.add(stmt);
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<DexStmtNode> dexStmtNodeList = dexCodeNode.stmts;
    assertEquals(1, dexStmtNodeList.size());
    DexStmtNode getResult = dexStmtNodeList.get(0);
    assertTrue(getResult instanceof MethodCustomStmtNode);
    List<DexStmtNode> dexStmtNodeList2 = v.codeNode.stmts;
    assertEquals(1, dexStmtNodeList2.size());
    DexStmtNode getResult2 = dexStmtNodeList2.get(0);
    assertTrue(getResult2 instanceof MethodCustomStmtNode);
    assertEquals("Name", ((MethodCustomStmtNode) getResult2).name);
    Object[] objectArray = ((MethodCustomStmtNode) getResult2).bsmArgs;
    assertEquals(1, objectArray.length);
    assertSame(proto, ((MethodCustomStmtNode) getResult).getProto());
    assertSame(proto, ((MethodCustomStmtNode) getResult2).getProto());
    MethodHandle methodHandle = stmt.bsm;
    assertSame(methodHandle, ((MethodCustomStmtNode) getResult).bsm);
    assertSame(methodHandle, ((MethodCustomStmtNode) getResult2).bsm);
    Object[] objectArray2 = stmt.bsmArgs;
    assertSame(objectArray2, ((MethodCustomStmtNode) getResult).bsmArgs);
    assertSame(objectArray2, objectArray);
    assertArrayEquals(new int[] {-1, 1, -1, 1}, ((MethodCustomStmtNode) getResult2).args);
  }

  /**
   * Test {@link DexCodeNode#accept(DexMethodVisitor)} with {@code DexMethodVisitor}.
   *
   * <ul>
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#tryStmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeNode#accept(DexMethodVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.accept(DexMethodVisitor)"})
  public void testAcceptWithDexMethodVisitor_thenDexCodeNodeTryStmtsSizeIsOne() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel dexLabel = new DexLabel();
    dexCodeNode.visitTryCatch(start, end, new DexLabel[] {dexLabel}, new String[] {"Type"});
    dexCodeNode.add(new DexLabelStmtNode(new DexLabel()));
    DexMethodNode v =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexCodeNode.accept(v);

    // Assert
    List<TryCatchNode> tryCatchNodeList = dexCodeNode.tryStmts;
    assertEquals(1, tryCatchNodeList.size());
    List<TryCatchNode> tryCatchNodeList2 = v.codeNode.tryStmts;
    assertEquals(1, tryCatchNodeList2.size());
    TryCatchNode getResult = tryCatchNodeList2.get(0);
    DexLabel[] dexLabelArray = getResult.handler;
    assertEquals(1, dexLabelArray.length);
    assertSame(dexLabel, dexLabelArray[0]);
    TryCatchNode getResult2 = tryCatchNodeList.get(0);
    assertSame(end, getResult2.end);
    assertSame(end, getResult.end);
    assertSame(start, getResult2.start);
    assertSame(start, getResult.start);
    String[] stringArray = getResult.type;
    assertSame(stringArray, getResult2.type);
    assertArrayEquals(new String[] {"Type"}, stringArray);
  }

  /**
   * Test {@link DexCodeNode#add(DexStmtNode)}.
   *
   * <p>Method under test: {@link DexCodeNode#add(DexStmtNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.add(DexStmtNode)"})
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
   * Test {@link DexCodeNode#visitConstStmt(Op, int, Object)}.
   *
   * <p>Method under test: {@link DexCodeNode#visitConstStmt(Op, int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitConstStmt(Op, int, Object)"})
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
   * Test {@link DexCodeNode#visitFillArrayDataStmt(Op, int, Object)}.
   *
   * <p>Method under test: {@link DexCodeNode#visitFillArrayDataStmt(Op, int, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitFillArrayDataStmt(Op, int, Object)"})
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
   * Test {@link DexCodeNode#visitFieldStmt(Op, int, int, Field)}.
   *
   * <p>Method under test: {@link DexCodeNode#visitFieldStmt(Op, int, int, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitFieldStmt(Op, int, int, Field)"})
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
   * Test {@link DexCodeNode#visitFilledNewArrayStmt(Op, int[], String)}.
   *
   * <p>Method under test: {@link DexCodeNode#visitFilledNewArrayStmt(Op, int[], String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitFilledNewArrayStmt(Op, int[], String)"})
  public void testVisitFilledNewArrayStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    int[] args = new int[] {1, -1, 1, -1};

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
   * Test {@link DexCodeNode#visitJumpStmt(Op, int, int, DexLabel)}.
   *
   * <p>Method under test: {@link DexCodeNode#visitJumpStmt(Op, int, int, DexLabel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitJumpStmt(Op, int, int, DexLabel)"})
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
   * Test {@link DexCodeNode#visitLabel(DexLabel)}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeNode#visitLabel(DexLabel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitLabel(DexLabel)"})
  public void testVisitLabel_givenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
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
   * Test {@link DexCodeNode#visitMethodStmt(Op, int[], Method, Proto)} with {@code op}, {@code
   * args}, {@code bsm}, {@code proto}.
   *
   * <p>Method under test: {@link DexCodeNode#visitMethodStmt(Op, int[], Method, Proto)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitMethodStmt(Op, int[], Method, Proto)"})
  public void testVisitMethodStmtWithOpArgsBsmProto() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    int[] args = new int[] {1, -1, 1, -1};
    Method bsm =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

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
   * Test {@link DexCodeNode#visitMethodStmt(Op, int[], Method)} with {@code op}, {@code args},
   * {@code method}.
   *
   * <p>Method under test: {@link DexCodeNode#visitMethodStmt(Op, int[], Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitMethodStmt(Op, int[], Method)"})
  public void testVisitMethodStmtWithOpArgsMethod() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    int[] args = new int[] {1, -1, 1, -1};
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

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
   * Test {@link DexCodeNode#visitMethodStmt(Op, int[], String, Proto, MethodHandle, Object[])} with
   * {@code op}, {@code args}, {@code name}, {@code proto}, {@code bsm}, {@code bsmArgs}.
   *
   * <p>Method under test: {@link DexCodeNode#visitMethodStmt(Op, int[], String, Proto,
   * MethodHandle, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexCodeNode.visitMethodStmt(Op, int[], String, Proto, MethodHandle, Object[])"
  })
  public void testVisitMethodStmtWithOpArgsNameProtoBsmBsmArgs() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    int[] args = new int[] {1, -1, 1, -1};
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    MethodHandle bsm = new MethodHandle(1, new Field("Owner", "Name", "Type"));

    Object[] bsmArgs = new Object[] {Constant.Null};

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
   * Test {@link DexCodeNode#visitPackedSwitchStmt(Op, int, int, DexLabel[])}.
   *
   * <p>Method under test: {@link DexCodeNode#visitPackedSwitchStmt(Op, int, int, DexLabel[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitPackedSwitchStmt(Op, int, int, DexLabel[])"})
  public void testVisitPackedSwitchStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabel[] labels = new DexLabel[] {new DexLabel()};

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
   * Test {@link DexCodeNode#visitSparseSwitchStmt(Op, int, int[], DexLabel[])}.
   *
   * <p>Method under test: {@link DexCodeNode#visitSparseSwitchStmt(Op, int, int[], DexLabel[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitSparseSwitchStmt(Op, int, int[], DexLabel[])"})
  public void testVisitSparseSwitchStmt() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    int[] cases = new int[] {1, -1, 1, -1};
    DexLabel[] labels = new DexLabel[] {new DexLabel()};

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
   * Test {@link DexCodeNode#visitStmt0R(Op)}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()}.
   *   <li>Then {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#stmts} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeNode#visitStmt0R(Op)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitStmt0R(Op)"})
  public void testVisitStmt0R_givenDexCodeNode_thenDexCodeNodeStmtsSizeIsOne() {
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
   * Test {@link DexCodeNode#visitStmt1R(Op, int)}.
   *
   * <p>Method under test: {@link DexCodeNode#visitStmt1R(Op, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitStmt1R(Op, int)"})
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
   * Test {@link DexCodeNode#visitStmt2R(Op, int, int)}.
   *
   * <p>Method under test: {@link DexCodeNode#visitStmt2R(Op, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitStmt2R(Op, int, int)"})
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
   * Test {@link DexCodeNode#visitStmt2R1N(Op, int, int, int)}.
   *
   * <p>Method under test: {@link DexCodeNode#visitStmt2R1N(Op, int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitStmt2R1N(Op, int, int, int)"})
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
   * Test {@link DexCodeNode#visitStmt3R(Op, int, int, int)}.
   *
   * <p>Method under test: {@link DexCodeNode#visitStmt3R(Op, int, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitStmt3R(Op, int, int, int)"})
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
   * Test {@link DexCodeNode#visitTryCatch(DexLabel, DexLabel, DexLabel[], String[])}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeNode#visitTryCatch(DexLabel, DexLabel, DexLabel[],
   * String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitTryCatch(DexLabel, DexLabel, DexLabel[], String[])"})
  public void testVisitTryCatch_givenDexCodeNode() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel[] handler = new DexLabel[] {new DexLabel()};
    String[] type = new String[] {"Type"};

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
   * Test {@link DexCodeNode#visitTryCatch(DexLabel, DexLabel, DexLabel[], String[])}.
   *
   * <ul>
   *   <li>Given {@link DexCodeNode#DexCodeNode()} {@link DexCodeNode#tryStmts} is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DexCodeNode#visitTryCatch(DexLabel, DexLabel, DexLabel[],
   * String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitTryCatch(DexLabel, DexLabel, DexLabel[], String[])"})
  public void testVisitTryCatch_givenDexCodeNodeTryStmtsIsArrayList() {
    // Arrange
    DexCodeNode dexCodeNode = new DexCodeNode();
    dexCodeNode.tryStmts = new ArrayList<>();
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();
    DexLabel[] handler = new DexLabel[] {new DexLabel()};
    String[] type = new String[] {"Type"};

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
   * Test {@link DexCodeNode#visitTypeStmt(Op, int, int, String)}.
   *
   * <p>Method under test: {@link DexCodeNode#visitTypeStmt(Op, int, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexCodeNode.visitTypeStmt(Op, int, int, String)"})
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
   * Test {@link DexCodeNode#visitDebug()}.
   *
   * <p>Method under test: {@link DexCodeNode#visitDebug()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexDebugVisitor DexCodeNode.visitDebug()"})
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
}
