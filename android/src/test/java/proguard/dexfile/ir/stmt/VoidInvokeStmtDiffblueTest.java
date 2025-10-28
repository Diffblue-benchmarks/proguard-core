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
import proguard.dexfile.ir.expr.CastExpr;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Value;

public class VoidInvokeStmtDiffblueTest {
  /**
   * Method under test: {@link VoidInvokeStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant op = Exprs.nNull();
    VoidInvokeStmt nVoidInvokeResult = Stmts.nVoidInvoke(op);

    // Act
    Stmt actualCloneResult = nVoidInvokeResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op2 = actualCloneResult.getOp();
    assertTrue(op2 instanceof Constant);
    assertTrue(actualCloneResult instanceof VoidInvokeStmt);
    assertNull(op2.getOps());
    assertNull(actualCloneResult.getOps());
    assertNull(((Constant) op2).tag);
    assertNull(((VoidInvokeStmt) actualCloneResult).frame);
    assertNull(((Constant) op2).valueType);
    assertNull(((VoidInvokeStmt) actualCloneResult).exceptionHandlers);
    assertNull(((VoidInvokeStmt) actualCloneResult)._cfg_froms);
    assertNull(op2.getOp());
    assertNull(op2.getOp1());
    assertNull(op2.getOp2());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((VoidInvokeStmt) actualCloneResult)._ts_default_next);
    assertNull(((VoidInvokeStmt) actualCloneResult).list);
    assertEquals(0, ((VoidInvokeStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((Constant) op2).et);
    assertEquals(ET.E1, ((VoidInvokeStmt) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) op2).vt);
    assertEquals(Stmt.ST.VOID_INVOKE, ((VoidInvokeStmt) actualCloneResult).st);
    assertFalse(((VoidInvokeStmt) actualCloneResult).visited);
    assertSame(op.value, ((Constant) op2).value);
  }

  /**
   * Method under test: {@link VoidInvokeStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant value = Exprs.nNull();
    VoidInvokeStmt nVoidInvokeResult = Stmts
        .nVoidInvoke(new CastExpr(value, "jane.doe@example.org", "alice.liddell@example.org"));

    // Act
    Stmt actualCloneResult = nVoidInvokeResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof CastExpr);
    Value op2 = op.getOp();
    assertTrue(op2 instanceof Constant);
    assertTrue(actualCloneResult instanceof VoidInvokeStmt);
    assertEquals("alice.liddell@example.org", ((CastExpr) op).to);
    assertEquals("jane.doe@example.org", ((CastExpr) op).from);
    assertNull(op2.getOps());
    assertNull(op.getOps());
    assertNull(actualCloneResult.getOps());
    assertNull(((CastExpr) op).tag);
    assertNull(((Constant) op2).tag);
    assertNull(((VoidInvokeStmt) actualCloneResult).frame);
    assertNull(((CastExpr) op).valueType);
    assertNull(((Constant) op2).valueType);
    assertNull(((VoidInvokeStmt) actualCloneResult).exceptionHandlers);
    assertNull(((VoidInvokeStmt) actualCloneResult)._cfg_froms);
    assertNull(op2.getOp());
    assertNull(op2.getOp1());
    assertNull(op.getOp1());
    assertNull(op2.getOp2());
    assertNull(op.getOp2());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((VoidInvokeStmt) actualCloneResult)._ts_default_next);
    assertNull(((VoidInvokeStmt) actualCloneResult).list);
    assertEquals(0, ((VoidInvokeStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((Constant) op2).et);
    assertEquals(ET.E1, ((CastExpr) op).et);
    assertEquals(ET.E1, ((VoidInvokeStmt) actualCloneResult).et);
    assertEquals(Value.VT.CAST, ((CastExpr) op).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op2).vt);
    assertEquals(Stmt.ST.VOID_INVOKE, ((VoidInvokeStmt) actualCloneResult).st);
    assertFalse(((VoidInvokeStmt) actualCloneResult).visited);
    assertSame(value.value, ((Constant) op2).value);
  }

  /**
   * Method under test: {@link VoidInvokeStmt#VoidInvokeStmt(Value)}
   */
  @Test
  public void testNewVoidInvokeStmt() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    VoidInvokeStmt actualVoidInvokeStmt = new VoidInvokeStmt(op);

    // Assert
    assertNull(actualVoidInvokeStmt.getOps());
    assertNull(actualVoidInvokeStmt.frame);
    assertNull(actualVoidInvokeStmt.exceptionHandlers);
    assertNull(actualVoidInvokeStmt._cfg_froms);
    assertNull(actualVoidInvokeStmt.getOp1());
    assertNull(actualVoidInvokeStmt.getOp2());
    assertNull(actualVoidInvokeStmt.getNext());
    assertNull(actualVoidInvokeStmt.getPre());
    assertNull(actualVoidInvokeStmt._ts_default_next);
    assertNull(actualVoidInvokeStmt.list);
    assertEquals(0, actualVoidInvokeStmt.id);
    assertEquals(ET.E1, actualVoidInvokeStmt.et);
    assertEquals(Stmt.ST.VOID_INVOKE, actualVoidInvokeStmt.st);
    assertFalse(actualVoidInvokeStmt.visited);
    assertSame(op, actualVoidInvokeStmt.getOp());
  }

  /**
   * Method under test: {@link VoidInvokeStmt#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("void null[null]", (new VoidInvokeStmt(new ArrayExpr())).toString());
  }
}
