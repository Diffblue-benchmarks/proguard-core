package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;

class ZeroTransformerDiffblueTest {
  /**
   * Test {@link ZeroTransformer#transformReportChanged(IrMethod)}.
   *
   * <p>Method under test: {@link ZeroTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @DisplayName("Test transformReportChanged(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  void testTransformReportChanged() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    AssignStmt stmt = new AssignStmt(ST.ASSIGN, left, new ArrayExpr());
    stmtList.add(stmt);
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
  @DisplayName("Test transformReportChanged(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  void testTransformReportChanged2() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    AssignStmt stmt = new AssignStmt(ST.ASSIGN, left, new ArrayExpr());
    stmtList.add(stmt);
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
  @DisplayName("Test transformReportChanged(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  void testTransformReportChanged3() {
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
  @DisplayName("Test transformReportChanged(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  void testTransformReportChanged4() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    AssignStmt stmt = new AssignStmt(ST.ASSIGN, left, Exprs.nByte((byte) 'A'));
    stmtList.add(stmt);
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
  @DisplayName("Test transformReportChanged(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  void testTransformReportChanged5() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    AssignStmt stmt = new AssignStmt(ST.ASSIGN, left, Exprs.nByte((byte) 1));
    stmtList.add(stmt);
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
  @DisplayName("Test transformReportChanged(IrMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  void testTransformReportChanged6() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    AssignStmt stmt = new AssignStmt(ST.ASSIGN, left, Exprs.nByte((byte) 0));
    stmtList.add(stmt);
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
  @DisplayName(
      "Test transformReportChanged(IrMethod); given StmtList (default constructor) add nLabel; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  void testTransformReportChanged_givenStmtListAddNLabel_thenReturnFalse() {
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
  @DisplayName(
      "Test transformReportChanged(IrMethod); when IrMethod (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZeroTransformer.transformReportChanged(IrMethod)"})
  void testTransformReportChanged_whenIrMethod_thenReturnFalse() {
    // Arrange
    ZeroTransformer zeroTransformer = new ZeroTransformer();

    // Act and Assert
    assertFalse(zeroTransformer.transformReportChanged(new IrMethod()));
  }
}
