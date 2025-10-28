package proguard.dexfile.reader.visitors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.DexLabel;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Op;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.node.DexCodeNode;

public class DexCodeVisitorDiffblueTest {
  /**
   * Method under test: {@link DexCodeVisitor#visitRegister(int)}
   */
  @Test
  public void testVisitRegister() {
    // Arrange
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(new DexCodeNode());

    // Act
    dexCodeVisitor.visitRegister(1);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertEquals(1, ((DexCodeNode) dexCodeVisitor2).totalRegister);
  }

  /**
   * Method under test: {@link DexCodeVisitor#visitStmt2R1N(Op, int, int, int)}
   */
  @Test
  public void testVisitStmt2R1N() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitStmt2R1N(Op.NOP, 1, 1, 1);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test: {@link DexCodeVisitor#visitStmt3R(Op, int, int, int)}
   */
  @Test
  public void testVisitStmt3R() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitStmt3R(Op.NOP, 1, 1, 1);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test: {@link DexCodeVisitor#visitTypeStmt(Op, int, int, String)}
   */
  @Test
  public void testVisitTypeStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitTypeStmt(Op.NOP, 1, 1, "Type");

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test: {@link DexCodeVisitor#DexCodeVisitor()}
   */
  @Test
  public void testNewDexCodeVisitor() {
    // Arrange, Act and Assert
    assertNull((new DexCodeVisitor()).visitor);
    assertNull((new DexCodeVisitor(new DexCodeVisitor())).visitor.visitor);
  }

  /**
   * Method under test: {@link DexCodeVisitor#visitConstStmt(Op, int, Object)}
   */
  @Test
  public void testVisitConstStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitConstStmt(Op.NOP, 1, Constant.Null);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test:
   * {@link DexCodeVisitor#visitFillArrayDataStmt(Op, int, Object)}
   */
  @Test
  public void testVisitFillArrayDataStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitFillArrayDataStmt(Op.NOP, 1, Constant.Null);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test: {@link DexCodeVisitor#visitFieldStmt(Op, int, int, Field)}
   */
  @Test
  public void testVisitFieldStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitFieldStmt(Op.NOP, 1, 1, new Field("Owner", "Name", "Type"));

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test:
   * {@link DexCodeVisitor#visitFilledNewArrayStmt(Op, int[], String)}
   */
  @Test
  public void testVisitFilledNewArrayStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitFilledNewArrayStmt(Op.NOP, new int[]{1, -1, 1, -1}, "Type");

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test:
   * {@link DexCodeVisitor#visitJumpStmt(Op, int, int, DexLabel)}
   */
  @Test
  public void testVisitJumpStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitJumpStmt(Op.NOP, 1, 1, new DexLabel());

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test: {@link DexCodeVisitor#visitLabel(DexLabel)}
   */
  @Test
  public void testVisitLabel() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitLabel(new DexLabel());

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test:
   * {@link DexCodeVisitor#visitSparseSwitchStmt(Op, int, int[], DexLabel[])}
   */
  @Test
  public void testVisitSparseSwitchStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitSparseSwitchStmt(Op.NOP, 1, new int[]{1, -1, 1, -1}, new DexLabel[]{new DexLabel()});

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test:
   * {@link DexCodeVisitor#visitMethodStmt(Op, int[], String, Proto, MethodHandle, Object[])}
   */
  @Test
  public void testVisitMethodStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    dexCodeVisitor.visitMethodStmt(Op.NOP, new int[]{1, -1, 1, -1}, "Name", proto,
        new MethodHandle(1, new Field("Owner", "Name", "Type")), Constant.Null);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test: {@link DexCodeVisitor#visitMethodStmt(Op, int[], Method)}
   */
  @Test
  public void testVisitMethodStmt2() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitMethodStmt(Op.NOP, new int[]{1, -1, 1, -1},
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test:
   * {@link DexCodeVisitor#visitMethodStmt(Op, int[], Method, Proto)}
   */
  @Test
  public void testVisitMethodStmt3() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);
    Method bsm = new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Act
    dexCodeVisitor.visitMethodStmt(Op.NOP, new int[]{1, -1, 1, -1}, bsm,
        new Proto(new String[]{"Parameter Types"}, "Return Type"));

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test: {@link DexCodeVisitor#visitStmt2R(Op, int, int)}
   */
  @Test
  public void testVisitStmt2R() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitStmt2R(Op.NOP, 1, 1);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test: {@link DexCodeVisitor#visitStmt0R(Op)}
   */
  @Test
  public void testVisitStmt0R() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitStmt0R(Op.NOP);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test: {@link DexCodeVisitor#visitStmt1R(Op, int)}
   */
  @Test
  public void testVisitStmt1R() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitStmt1R(Op.NOP, 1);

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test:
   * {@link DexCodeVisitor#visitPackedSwitchStmt(Op, int, int, DexLabel[])}
   */
  @Test
  public void testVisitPackedSwitchStmt() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);

    // Act
    dexCodeVisitor.visitPackedSwitchStmt(Op.NOP, 1, 1, new DexLabel[]{new DexLabel()});

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.stmts, ((DexCodeNode) dexCodeVisitor2).stmts);
  }

  /**
   * Method under test:
   * {@link DexCodeVisitor#visitTryCatch(DexLabel, DexLabel, DexLabel[], String[])}
   */
  @Test
  public void testVisitTryCatch() {
    // Arrange
    DexCodeNode visitor = new DexCodeNode();
    DexCodeVisitor dexCodeVisitor = new DexCodeVisitor(visitor);
    DexLabel start = new DexLabel();
    DexLabel end = new DexLabel();

    // Act
    dexCodeVisitor.visitTryCatch(start, end, new DexLabel[]{new DexLabel()}, new String[]{"Type"});

    // Assert
    DexCodeVisitor dexCodeVisitor2 = dexCodeVisitor.visitor;
    assertTrue(dexCodeVisitor2 instanceof DexCodeNode);
    assertSame(visitor.tryStmts, ((DexCodeNode) dexCodeVisitor2).tryStmts);
  }

  /**
   * Method under test: {@link DexCodeVisitor#visitDebug()}
   */
  @Test
  public void testVisitDebug() {
    // Arrange, Act and Assert
    assertNull((new DexCodeVisitor()).visitDebug());
    assertNull((new DexCodeVisitor(new DexCodeVisitor())).visitDebug());
  }
}
