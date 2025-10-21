package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;

public class ZeroTransformerDiffblueTest {
  /**
   * Test {@link ZeroTransformer#transformReportChanged(IrMethod)}.
   *
   * <p>Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    stmtList.add(new AssignStmt(ST.ASSIGN, left, new ArrayExpr()));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Test {@link ZeroTransformer#transformReportChanged(IrMethod)}.
   *
   * <p>Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged2() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(ST.ASSIGN, left, new ArrayExpr()));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Test {@link ZeroTransformer#transformReportChanged(IrMethod)}.
   *
   * <p>Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged3() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(ST.ASSIGN, left, Exprs.nNull()));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Test {@link ZeroTransformer#transformReportChanged(IrMethod)}.
   *
   * <p>Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged4() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(ST.ASSIGN, left, Exprs.nByte((byte) 'A')));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Test {@link ZeroTransformer#transformReportChanged(IrMethod)}.
   *
   * <p>Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged5() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(ST.ASSIGN, left, Exprs.nByte((byte) 1)));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Test {@link ZeroTransformer#transformReportChanged(IrMethod)}.
   *
   * <p>Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged6() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(ST.ASSIGN, left, Exprs.nByte((byte) 0)));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(method));
  }

  /**
   * Test {@link ZeroTransformer#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nLabel.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged_givenStmtListAddNLabel_thenReturnFalse() {
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
   * Test {@link ZeroTransformer#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged_whenIrMethod_thenReturnFalse() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(new IrMethod()));
  }
}
