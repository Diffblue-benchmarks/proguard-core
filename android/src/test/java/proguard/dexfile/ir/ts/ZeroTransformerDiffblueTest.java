package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertFalse;
import org.junit.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;

public class ZeroTransformerDiffblueTest {
  /**
   * Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(new IrMethod()));
  }

  /**
   * Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged2() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged3() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    stmtList.add(new AssignStmt(Stmt.ST.ASSIGN, left, new ArrayExpr()));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged4() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(Stmt.ST.ASSIGN, left, new ArrayExpr()));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged5() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(Stmt.ST.ASSIGN, left, Exprs.nNull()));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged6() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(Stmt.ST.ASSIGN, left, Exprs.nByte((byte) 'A')));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged7() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(Stmt.ST.ASSIGN, left, Exprs.nByte((byte) 1)));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged8() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(Stmt.ST.ASSIGN, left, Exprs.nByte((byte) 0)));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }
}
