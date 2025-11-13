package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.ir.stmt.StmtList;

class RemoveConstantFromSSADiffblueTest {
  /**
   * Test {@link RemoveConstantFromSSA#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveConstantFromSSA#transformReportChanged(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transformReportChanged(IrMethod); then IrMethod (default constructor) stmts First is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RemoveConstantFromSSA.transformReportChanged(IrMethod)"})
  void testTransformReportChanged_thenIrMethodStmtsFirstIsNull() {
    // Arrange
    RemoveConstantFromSSA removeConstantFromSSA = new RemoveConstantFromSSA();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(ST.ASSIGN, left, Exprs.nNull()));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act
    removeConstantFromSSA.transformReportChanged(method);

    // Assert
    StmtList stmtList2 = method.stmts;
    assertNull(stmtList2.getFirst());
    assertNull(stmtList2.getLast());
    assertEquals(0, stmtList2.getSize());
    assertFalse(stmtList2.iterator().hasNext());
  }

  /**
   * Test {@link RemoveConstantFromSSA#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveConstantFromSSA#transformReportChanged(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transformReportChanged(IrMethod); then IrMethod (default constructor) stmts First is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RemoveConstantFromSSA.transformReportChanged(IrMethod)"})
  void testTransformReportChanged_thenIrMethodStmtsFirstIsNull2() {
    // Arrange
    RemoveConstantFromSSA removeConstantFromSSA = new RemoveConstantFromSSA();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(ST.ASSIGN, left, Exprs.nNull()));
    Local left2 = new Local();
    stmtList.add(new AssignStmt(ST.ASSIGN, left2, Exprs.nNull()));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act
    removeConstantFromSSA.transformReportChanged(method);

    // Assert
    StmtList stmtList2 = method.stmts;
    assertNull(stmtList2.getFirst());
    assertNull(stmtList2.getLast());
    assertEquals(0, stmtList2.getSize());
    assertFalse(stmtList2.iterator().hasNext());
  }

  /**
   * Test {@link RemoveConstantFromSSA#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} Last is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveConstantFromSSA#transformReportChanged(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transformReportChanged(IrMethod); when IrMethod (default constructor); then IrMethod (default constructor) stmts Last is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RemoveConstantFromSSA.transformReportChanged(IrMethod)"})
  void testTransformReportChanged_whenIrMethod_thenIrMethodStmtsLastIsNull() {
    // Arrange
    RemoveConstantFromSSA removeConstantFromSSA = new RemoveConstantFromSSA();
    IrMethod method = new IrMethod();

    // Act
    boolean actualTransformReportChangedResult =
        removeConstantFromSSA.transformReportChanged(method);

    // Assert
    StmtList stmtList = method.stmts;
    assertNull(stmtList.getLast());
    assertEquals(0, stmtList.getSize());
    assertFalse(stmtList.iterator().hasNext());
    assertFalse(actualTransformReportChangedResult);
  }
}
