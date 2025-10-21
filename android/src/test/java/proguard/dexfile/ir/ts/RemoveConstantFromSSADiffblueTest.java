package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.ir.stmt.StmtList;

public class RemoveConstantFromSSADiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RemoveConstantFromSSA.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged_thenIrMethodStmtsFirstIsNull() {
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
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} Last is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveConstantFromSSA#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RemoveConstantFromSSA.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged_whenIrMethod_thenIrMethodStmtsLastIsNull() {
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
