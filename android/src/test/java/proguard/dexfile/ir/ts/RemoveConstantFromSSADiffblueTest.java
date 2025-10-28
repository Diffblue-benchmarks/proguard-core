package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.StmtList;

public class RemoveConstantFromSSADiffblueTest {
  /**
   * Method under test:
   * {@link RemoveConstantFromSSA#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged() {
    // Arrange
    RemoveConstantFromSSA removeConstantFromSSA = new RemoveConstantFromSSA();
    IrMethod method = new IrMethod();

    // Act
    boolean actualTransformReportChangedResult = removeConstantFromSSA.transformReportChanged(method);

    // Assert
    StmtList stmtList = method.stmts;
    assertNull(stmtList.getFirst());
    assertNull(stmtList.getLast());
    assertEquals(0, stmtList.getSize());
    assertFalse(stmtList.iterator().hasNext());
    assertFalse(actualTransformReportChangedResult);
  }

  /**
   * Method under test:
   * {@link RemoveConstantFromSSA#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged2() {
    // Arrange
    RemoveConstantFromSSA removeConstantFromSSA = new RemoveConstantFromSSA();

    StmtList stmtList = new StmtList();
    Local left = new Local();
    stmtList.add(new AssignStmt(Stmt.ST.ASSIGN, left, Exprs.nNull()));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act
    boolean actualTransformReportChangedResult = removeConstantFromSSA.transformReportChanged(method);

    // Assert
    StmtList stmtList2 = method.stmts;
    assertNull(stmtList2.getFirst());
    assertNull(stmtList2.getLast());
    assertEquals(0, stmtList2.getSize());
    assertFalse(stmtList2.iterator().hasNext());
    assertTrue(actualTransformReportChangedResult);
  }
}
