package proguard.dexfile.ir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmts;

public class LocalVarDiffblueTest {
  /**
   * Method under test: {@link LocalVar#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();
    LocalVar localVar = new LocalVar("Name", "Type", "Signature", start, end, new Local());
    LabelAndLocalMapper map = new LabelAndLocalMapper();

    // Act
    LocalVar actualCloneResult = localVar.clone(map);

    // Assert
    assertEquals("Name", actualCloneResult.name);
    assertEquals("Signature", actualCloneResult.signature);
    assertEquals("Type", actualCloneResult.type);
    Local local = actualCloneResult.reg;
    assertEquals("a0", local.toString0());
    assertNull(local.getOps());
    LabelStmt labelStmt = actualCloneResult.end;
    assertNull(labelStmt.getOps());
    LabelStmt labelStmt2 = actualCloneResult.start;
    assertNull(labelStmt2.getOps());
    assertNull(local.tag);
    assertNull(labelStmt.tag);
    assertNull(labelStmt2.tag);
    assertNull(labelStmt.frame);
    assertNull(labelStmt2.frame);
    assertNull(local.debugName);
    assertNull(local.signature);
    assertNull(local.valueType);
    assertNull(labelStmt.displayName);
    assertNull(labelStmt2.displayName);
    assertNull(labelStmt.phis);
    assertNull(labelStmt2.phis);
    assertNull(labelStmt.exceptionHandlers);
    assertNull(labelStmt2.exceptionHandlers);
    assertNull(labelStmt._cfg_froms);
    assertNull(labelStmt2._cfg_froms);
    assertNull(local.getOp());
    assertNull(local.getOp1());
    assertNull(local.getOp2());
    assertNull(labelStmt.getOp());
    assertNull(labelStmt2.getOp());
    assertNull(labelStmt.getOp1());
    assertNull(labelStmt2.getOp1());
    assertNull(labelStmt.getOp2());
    assertNull(labelStmt2.getOp2());
    assertNull(labelStmt.getNext());
    assertNull(labelStmt2.getNext());
    assertNull(labelStmt.getPre());
    assertNull(labelStmt2.getPre());
    assertNull(labelStmt._ts_default_next);
    assertNull(labelStmt2._ts_default_next);
    assertEquals(-1, labelStmt.lineNumber);
    assertEquals(-1, labelStmt2.lineNumber);
    assertEquals(0, local._ls_index);
    assertEquals(0, labelStmt.id);
    assertEquals(0, labelStmt2.id);
    assertEquals(2, map.labels.size());
    assertEquals(ET.E0, local.et);
    assertEquals(ET.E0, labelStmt.et);
    assertEquals(ET.E0, labelStmt2.et);
    assertEquals(Value.VT.LOCAL, local.vt);
    assertEquals(Stmt.ST.LABEL, labelStmt.st);
    assertEquals(Stmt.ST.LABEL, labelStmt2.st);
    assertFalse(labelStmt.visited);
    assertFalse(labelStmt2.visited);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LocalVar#LocalVar(String, String, String, LabelStmt, LabelStmt, Local)}
   *   <li>{@link LocalVar#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();

    // Act
    LocalVar actualLocalVar = new LocalVar("Name", "Type", "Signature", start, end, new Local());
    actualLocalVar.toString();

    // Assert
    Local local = actualLocalVar.reg;
    assertEquals("a0", local.toString0());
    assertNull(local.getOps());
    LabelStmt labelStmt = actualLocalVar.end;
    assertNull(labelStmt.getOps());
    LabelStmt labelStmt2 = actualLocalVar.start;
    assertNull(labelStmt2.getOps());
    assertNull(local.getOp());
    assertNull(local.getOp1());
    assertNull(local.getOp2());
    assertNull(labelStmt.getOp());
    assertNull(labelStmt2.getOp());
    assertNull(labelStmt.getOp1());
    assertNull(labelStmt2.getOp1());
    assertNull(labelStmt.getOp2());
    assertNull(labelStmt2.getOp2());
    assertNull(labelStmt.getNext());
    assertNull(labelStmt2.getNext());
    assertNull(labelStmt.getPre());
    assertNull(labelStmt2.getPre());
  }
}
