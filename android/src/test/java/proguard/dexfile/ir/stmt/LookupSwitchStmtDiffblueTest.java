package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertArrayEquals;
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

public class LookupSwitchStmtDiffblueTest {
  /**
   * Method under test: {@link LookupSwitchStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    Local key = new Local();
    LookupSwitchStmt nLookupSwitchResult = Stmts.nLookupSwitch(key, new int[]{42, 1, 42, 1},
        new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nLookupSwitchResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Local);
    assertTrue(actualCloneResult instanceof LookupSwitchStmt);
    assertEquals("a0", ((Local) op).toString0());
    assertNull(op.getOps());
    assertNull(actualCloneResult.getOps());
    LabelStmt[] labelStmtArray = ((LookupSwitchStmt) actualCloneResult).targets;
    LabelStmt labelStmt = labelStmtArray[0];
    assertNull(labelStmt.getOps());
    LabelStmt labelStmt2 = ((LookupSwitchStmt) actualCloneResult).defaultTarget;
    assertNull(labelStmt2.getOps());
    assertNull(((Local) op).tag);
    assertNull(labelStmt.tag);
    assertNull(labelStmt2.tag);
    assertNull(labelStmt.frame);
    assertNull(labelStmt2.frame);
    assertNull(((LookupSwitchStmt) actualCloneResult).frame);
    assertNull(((Local) op).debugName);
    assertNull(((Local) op).signature);
    assertNull(((Local) op).valueType);
    assertNull(labelStmt.displayName);
    assertNull(labelStmt2.displayName);
    assertNull(labelStmt.phis);
    assertNull(labelStmt2.phis);
    assertNull(labelStmt.exceptionHandlers);
    assertNull(labelStmt2.exceptionHandlers);
    assertNull(((LookupSwitchStmt) actualCloneResult).exceptionHandlers);
    assertNull(labelStmt._cfg_froms);
    assertNull(labelStmt2._cfg_froms);
    assertNull(((LookupSwitchStmt) actualCloneResult)._cfg_froms);
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
    assertNull(((LookupSwitchStmt) actualCloneResult)._ts_default_next);
    assertNull(labelStmt.list);
    assertNull(labelStmt2.list);
    assertNull(((LookupSwitchStmt) actualCloneResult).list);
    assertEquals(-1, labelStmt.lineNumber);
    assertEquals(-1, labelStmt2.lineNumber);
    assertEquals(0, ((Local) op)._ls_index);
    assertEquals(0, labelStmt.id);
    assertEquals(0, labelStmt2.id);
    assertEquals(0, ((LookupSwitchStmt) actualCloneResult).id);
    assertEquals(1, labelStmtArray.length);
    assertEquals(ET.E0, ((Local) op).et);
    assertEquals(ET.E0, labelStmt.et);
    assertEquals(ET.E0, labelStmt2.et);
    assertEquals(ET.E1, ((LookupSwitchStmt) actualCloneResult).et);
    assertEquals(Value.VT.LOCAL, ((Local) op).vt);
    assertEquals(Stmt.ST.LABEL, labelStmt.st);
    assertEquals(Stmt.ST.LABEL, labelStmt2.st);
    assertEquals(Stmt.ST.LOOKUP_SWITCH, ((LookupSwitchStmt) actualCloneResult).st);
    assertFalse(labelStmt.visited);
    assertFalse(labelStmt2.visited);
    assertFalse(((LookupSwitchStmt) actualCloneResult).visited);
    assertArrayEquals(new int[]{42, 1, 42, 1}, ((LookupSwitchStmt) actualCloneResult).lookupValues);
  }

  /**
   * Method under test: {@link LookupSwitchStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant key = Exprs.nNull();
    LookupSwitchStmt nLookupSwitchResult = Stmts.nLookupSwitch(key, new int[]{42, 1, 42, 1},
        new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nLookupSwitchResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof LookupSwitchStmt);
    assertNull(op.getOps());
    assertNull(actualCloneResult.getOps());
    LabelStmt[] labelStmtArray = ((LookupSwitchStmt) actualCloneResult).targets;
    LabelStmt labelStmt = labelStmtArray[0];
    assertNull(labelStmt.getOps());
    LabelStmt labelStmt2 = ((LookupSwitchStmt) actualCloneResult).defaultTarget;
    assertNull(labelStmt2.getOps());
    assertNull(((Constant) op).tag);
    assertNull(labelStmt.tag);
    assertNull(labelStmt2.tag);
    assertNull(labelStmt.frame);
    assertNull(labelStmt2.frame);
    assertNull(((LookupSwitchStmt) actualCloneResult).frame);
    assertNull(((Constant) op).valueType);
    assertNull(labelStmt.displayName);
    assertNull(labelStmt2.displayName);
    assertNull(labelStmt.phis);
    assertNull(labelStmt2.phis);
    assertNull(labelStmt.exceptionHandlers);
    assertNull(labelStmt2.exceptionHandlers);
    assertNull(((LookupSwitchStmt) actualCloneResult).exceptionHandlers);
    assertNull(labelStmt._cfg_froms);
    assertNull(labelStmt2._cfg_froms);
    assertNull(((LookupSwitchStmt) actualCloneResult)._cfg_froms);
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
    assertNull(((LookupSwitchStmt) actualCloneResult)._ts_default_next);
    assertNull(labelStmt.list);
    assertNull(labelStmt2.list);
    assertNull(((LookupSwitchStmt) actualCloneResult).list);
    assertEquals(-1, labelStmt.lineNumber);
    assertEquals(-1, labelStmt2.lineNumber);
    assertEquals(0, labelStmt.id);
    assertEquals(0, labelStmt2.id);
    assertEquals(0, ((LookupSwitchStmt) actualCloneResult).id);
    assertEquals(1, labelStmtArray.length);
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(ET.E0, labelStmt.et);
    assertEquals(ET.E0, labelStmt2.et);
    assertEquals(ET.E1, ((LookupSwitchStmt) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) op).vt);
    assertEquals(Stmt.ST.LABEL, labelStmt.st);
    assertEquals(Stmt.ST.LABEL, labelStmt2.st);
    assertEquals(Stmt.ST.LOOKUP_SWITCH, ((LookupSwitchStmt) actualCloneResult).st);
    assertFalse(labelStmt.visited);
    assertFalse(labelStmt2.visited);
    assertFalse(((LookupSwitchStmt) actualCloneResult).visited);
    assertSame(key.value, ((Constant) op).value);
    assertArrayEquals(new int[]{42, 1, 42, 1}, ((LookupSwitchStmt) actualCloneResult).lookupValues);
  }

  /**
   * Method under test:
   * {@link LookupSwitchStmt#LookupSwitchStmt(Value, int[], LabelStmt[], LabelStmt)}
   */
  @Test
  public void testNewLookupSwitchStmt() {
    // Arrange
    ArrayExpr key = new ArrayExpr();
    LabelStmt nLabelResult = Stmts.nLabel();

    // Act
    LookupSwitchStmt actualLookupSwitchStmt = new LookupSwitchStmt(key, new int[]{42, 1, 42, 1},
        new LabelStmt[]{nLabelResult}, Stmts.nLabel());

    // Assert
    assertNull(actualLookupSwitchStmt.getOps());
    LabelStmt labelStmt = actualLookupSwitchStmt.defaultTarget;
    assertNull(labelStmt.getOps());
    assertNull(labelStmt.tag);
    assertNull(actualLookupSwitchStmt.frame);
    assertNull(labelStmt.frame);
    assertNull(labelStmt.displayName);
    assertNull(labelStmt.phis);
    assertNull(actualLookupSwitchStmt.exceptionHandlers);
    assertNull(labelStmt.exceptionHandlers);
    assertNull(actualLookupSwitchStmt._cfg_froms);
    assertNull(labelStmt._cfg_froms);
    assertNull(labelStmt.getOp());
    assertNull(actualLookupSwitchStmt.getOp1());
    assertNull(labelStmt.getOp1());
    assertNull(actualLookupSwitchStmt.getOp2());
    assertNull(labelStmt.getOp2());
    assertNull(actualLookupSwitchStmt.getNext());
    assertNull(labelStmt.getNext());
    assertNull(actualLookupSwitchStmt.getPre());
    assertNull(labelStmt.getPre());
    assertNull(actualLookupSwitchStmt._ts_default_next);
    assertNull(labelStmt._ts_default_next);
    assertNull(actualLookupSwitchStmt.list);
    assertNull(labelStmt.list);
    assertEquals(-1, labelStmt.lineNumber);
    assertEquals(0, actualLookupSwitchStmt.id);
    assertEquals(0, labelStmt.id);
    LabelStmt[] labelStmtArray = actualLookupSwitchStmt.targets;
    assertEquals(1, labelStmtArray.length);
    assertEquals(ET.E0, labelStmt.et);
    assertEquals(ET.E1, actualLookupSwitchStmt.et);
    assertEquals(Stmt.ST.LABEL, labelStmt.st);
    assertEquals(Stmt.ST.LOOKUP_SWITCH, actualLookupSwitchStmt.st);
    assertFalse(actualLookupSwitchStmt.visited);
    assertFalse(labelStmt.visited);
    assertSame(key, actualLookupSwitchStmt.getOp());
    assertSame(nLabelResult, labelStmtArray[0]);
    assertArrayEquals(new int[]{42, 1, 42, 1}, actualLookupSwitchStmt.lookupValues);
  }
}
