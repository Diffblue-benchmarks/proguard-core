package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;

public class TableSwitchStmtDiffblueTest {
  /**
   * Method under test: {@link TableSwitchStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    Local key = new Local();
    TableSwitchStmt nTableSwitchResult = Stmts.nTableSwitch(key, 1, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nTableSwitchResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Local);
    assertTrue(actualCloneResult instanceof TableSwitchStmt);
    assertEquals("a0", ((Local) op).toString0());
    assertNull(op.getOps());
    assertNull(actualCloneResult.getOps());
    LabelStmt[] labelStmtArray = ((TableSwitchStmt) actualCloneResult).targets;
    LabelStmt labelStmt = labelStmtArray[0];
    assertNull(labelStmt.getOps());
    LabelStmt labelStmt2 = ((TableSwitchStmt) actualCloneResult).defaultTarget;
    assertNull(labelStmt2.getOps());
    assertNull(((Local) op).tag);
    assertNull(labelStmt.tag);
    assertNull(labelStmt2.tag);
    assertNull(labelStmt.frame);
    assertNull(labelStmt2.frame);
    assertNull(((TableSwitchStmt) actualCloneResult).frame);
    assertNull(((Local) op).debugName);
    assertNull(((Local) op).signature);
    assertNull(((Local) op).valueType);
    assertNull(labelStmt.displayName);
    assertNull(labelStmt2.displayName);
    assertNull(labelStmt.phis);
    assertNull(labelStmt2.phis);
    assertNull(labelStmt.exceptionHandlers);
    assertNull(labelStmt2.exceptionHandlers);
    assertNull(((TableSwitchStmt) actualCloneResult).exceptionHandlers);
    assertNull(labelStmt._cfg_froms);
    assertNull(labelStmt2._cfg_froms);
    assertNull(((TableSwitchStmt) actualCloneResult)._cfg_froms);
    assertNull(op.getOp());
    assertNull(op.getOp1());
    assertNull(op.getOp2());
    assertNull(labelStmt.getOp());
    assertNull(labelStmt2.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(labelStmt.getOp1());
    assertNull(labelStmt2.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(labelStmt.getOp2());
    assertNull(labelStmt2.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(labelStmt.getNext());
    assertNull(labelStmt2.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(labelStmt.getPre());
    assertNull(labelStmt2.getPre());
    assertNull(labelStmt._ts_default_next);
    assertNull(labelStmt2._ts_default_next);
    assertNull(((TableSwitchStmt) actualCloneResult)._ts_default_next);
    assertNull(labelStmt.list);
    assertNull(labelStmt2.list);
    assertNull(((TableSwitchStmt) actualCloneResult).list);
    assertEquals(-1, labelStmt.lineNumber);
    assertEquals(-1, labelStmt2.lineNumber);
    assertEquals(0, ((Local) op)._ls_index);
    assertEquals(0, labelStmt.id);
    assertEquals(0, labelStmt2.id);
    assertEquals(0, ((TableSwitchStmt) actualCloneResult).id);
    assertEquals(1, labelStmtArray.length);
    assertEquals(1, ((TableSwitchStmt) actualCloneResult).lowIndex);
    assertEquals(ET.E0, ((Local) op).et);
    assertEquals(ET.E0, labelStmt.et);
    assertEquals(ET.E0, labelStmt2.et);
    assertEquals(ET.E1, ((TableSwitchStmt) actualCloneResult).et);
    assertEquals(Value.VT.LOCAL, ((Local) op).vt);
    assertEquals(Stmt.ST.LABEL, labelStmt.st);
    assertEquals(Stmt.ST.LABEL, labelStmt2.st);
    assertEquals(Stmt.ST.TABLE_SWITCH, ((TableSwitchStmt) actualCloneResult).st);
    assertFalse(labelStmt.visited);
    assertFalse(labelStmt2.visited);
    assertFalse(((TableSwitchStmt) actualCloneResult).visited);
  }

  /**
   * Method under test: {@link TableSwitchStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant key = Exprs.nNull();
    TableSwitchStmt nTableSwitchResult = Stmts.nTableSwitch(key, 1, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nTableSwitchResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof TableSwitchStmt);
    assertNull(op.getOps());
    assertNull(actualCloneResult.getOps());
    LabelStmt[] labelStmtArray = ((TableSwitchStmt) actualCloneResult).targets;
    LabelStmt labelStmt = labelStmtArray[0];
    assertNull(labelStmt.getOps());
    LabelStmt labelStmt2 = ((TableSwitchStmt) actualCloneResult).defaultTarget;
    assertNull(labelStmt2.getOps());
    assertNull(((Constant) op).tag);
    assertNull(labelStmt.tag);
    assertNull(labelStmt2.tag);
    assertNull(labelStmt.frame);
    assertNull(labelStmt2.frame);
    assertNull(((TableSwitchStmt) actualCloneResult).frame);
    assertNull(((Constant) op).valueType);
    assertNull(labelStmt.displayName);
    assertNull(labelStmt2.displayName);
    assertNull(labelStmt.phis);
    assertNull(labelStmt2.phis);
    assertNull(labelStmt.exceptionHandlers);
    assertNull(labelStmt2.exceptionHandlers);
    assertNull(((TableSwitchStmt) actualCloneResult).exceptionHandlers);
    assertNull(labelStmt._cfg_froms);
    assertNull(labelStmt2._cfg_froms);
    assertNull(((TableSwitchStmt) actualCloneResult)._cfg_froms);
    assertNull(op.getOp());
    assertNull(op.getOp1());
    assertNull(op.getOp2());
    assertNull(labelStmt.getOp());
    assertNull(labelStmt2.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(labelStmt.getOp1());
    assertNull(labelStmt2.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(labelStmt.getOp2());
    assertNull(labelStmt2.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(labelStmt.getNext());
    assertNull(labelStmt2.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(labelStmt.getPre());
    assertNull(labelStmt2.getPre());
    assertNull(labelStmt._ts_default_next);
    assertNull(labelStmt2._ts_default_next);
    assertNull(((TableSwitchStmt) actualCloneResult)._ts_default_next);
    assertNull(labelStmt.list);
    assertNull(labelStmt2.list);
    assertNull(((TableSwitchStmt) actualCloneResult).list);
    assertEquals(-1, labelStmt.lineNumber);
    assertEquals(-1, labelStmt2.lineNumber);
    assertEquals(0, labelStmt.id);
    assertEquals(0, labelStmt2.id);
    assertEquals(0, ((TableSwitchStmt) actualCloneResult).id);
    assertEquals(1, labelStmtArray.length);
    assertEquals(1, ((TableSwitchStmt) actualCloneResult).lowIndex);
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(ET.E0, labelStmt.et);
    assertEquals(ET.E0, labelStmt2.et);
    assertEquals(ET.E1, ((TableSwitchStmt) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) op).vt);
    assertEquals(Stmt.ST.LABEL, labelStmt.st);
    assertEquals(Stmt.ST.LABEL, labelStmt2.st);
    assertEquals(Stmt.ST.TABLE_SWITCH, ((TableSwitchStmt) actualCloneResult).st);
    assertFalse(labelStmt.visited);
    assertFalse(labelStmt2.visited);
    assertFalse(((TableSwitchStmt) actualCloneResult).visited);
    assertSame(key.value, ((Constant) op).value);
  }

  /**
   * Method under test: {@link TableSwitchStmt#TableSwitchStmt()}
   */
  @Test
  public void testNewTableSwitchStmt() {
    // Arrange and Act
    TableSwitchStmt actualTableSwitchStmt = new TableSwitchStmt();

    // Assert
    assertNull(actualTableSwitchStmt.getOps());
    assertNull(actualTableSwitchStmt.targets);
    assertNull(actualTableSwitchStmt.frame);
    assertNull(actualTableSwitchStmt.exceptionHandlers);
    assertNull(actualTableSwitchStmt._cfg_froms);
    assertNull(actualTableSwitchStmt.getOp1());
    assertNull(actualTableSwitchStmt.getOp2());
    assertNull(actualTableSwitchStmt.getOp());
    assertNull(actualTableSwitchStmt.defaultTarget);
    assertNull(actualTableSwitchStmt.getNext());
    assertNull(actualTableSwitchStmt.getPre());
    assertNull(actualTableSwitchStmt._ts_default_next);
    assertNull(actualTableSwitchStmt.list);
    assertEquals(0, actualTableSwitchStmt.id);
    assertEquals(0, actualTableSwitchStmt.lowIndex);
    assertEquals(ET.E1, actualTableSwitchStmt.et);
    assertEquals(Stmt.ST.TABLE_SWITCH, actualTableSwitchStmt.st);
    assertFalse(actualTableSwitchStmt.visited);
  }

  /**
   * Method under test:
   * {@link TableSwitchStmt#TableSwitchStmt(Value, int, LabelStmt[], LabelStmt)}
   */
  @Test
  public void testNewTableSwitchStmt2() {
    // Arrange
    ArrayExpr key = new ArrayExpr();
    LabelStmt nLabelResult = Stmts.nLabel();

    // Act
    TableSwitchStmt actualTableSwitchStmt = new TableSwitchStmt(key, 1, new LabelStmt[]{nLabelResult}, Stmts.nLabel());

    // Assert
    assertNull(actualTableSwitchStmt.getOps());
    LabelStmt labelStmt = actualTableSwitchStmt.defaultTarget;
    assertNull(labelStmt.getOps());
    assertNull(labelStmt.tag);
    assertNull(actualTableSwitchStmt.frame);
    assertNull(labelStmt.frame);
    assertNull(labelStmt.displayName);
    assertNull(labelStmt.phis);
    assertNull(actualTableSwitchStmt.exceptionHandlers);
    assertNull(labelStmt.exceptionHandlers);
    assertNull(actualTableSwitchStmt._cfg_froms);
    assertNull(labelStmt._cfg_froms);
    assertNull(labelStmt.getOp());
    assertNull(actualTableSwitchStmt.getOp1());
    assertNull(labelStmt.getOp1());
    assertNull(actualTableSwitchStmt.getOp2());
    assertNull(labelStmt.getOp2());
    assertNull(actualTableSwitchStmt.getNext());
    assertNull(labelStmt.getNext());
    assertNull(actualTableSwitchStmt.getPre());
    assertNull(labelStmt.getPre());
    assertNull(actualTableSwitchStmt._ts_default_next);
    assertNull(labelStmt._ts_default_next);
    assertNull(actualTableSwitchStmt.list);
    assertNull(labelStmt.list);
    assertEquals(-1, labelStmt.lineNumber);
    assertEquals(0, actualTableSwitchStmt.id);
    assertEquals(0, labelStmt.id);
    LabelStmt[] labelStmtArray = actualTableSwitchStmt.targets;
    assertEquals(1, labelStmtArray.length);
    assertEquals(1, actualTableSwitchStmt.lowIndex);
    assertEquals(ET.E0, labelStmt.et);
    assertEquals(ET.E1, actualTableSwitchStmt.et);
    assertEquals(Stmt.ST.LABEL, labelStmt.st);
    assertEquals(Stmt.ST.TABLE_SWITCH, actualTableSwitchStmt.st);
    assertFalse(actualTableSwitchStmt.visited);
    assertFalse(labelStmt.visited);
    assertSame(key, actualTableSwitchStmt.getOp());
    assertSame(nLabelResult, labelStmtArray[0]);
  }
}
