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

public class UnopStmtDiffblueTest {
  /**
   * Method under test: {@link UnopStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant op = Exprs.nNull();
    UnopStmt nLockResult = Stmts.nLock(op);

    // Act
    Stmt actualCloneResult = nLockResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op2 = actualCloneResult.getOp();
    assertTrue(op2 instanceof Constant);
    assertTrue(actualCloneResult instanceof UnopStmt);
    assertNull(op2.getOps());
    assertNull(actualCloneResult.getOps());
    assertNull(((Constant) op2).tag);
    assertNull(((UnopStmt) actualCloneResult).frame);
    assertNull(((Constant) op2).valueType);
    assertNull(((UnopStmt) actualCloneResult).exceptionHandlers);
    assertNull(((UnopStmt) actualCloneResult)._cfg_froms);
    assertNull(op2.getOp());
    assertNull(op2.getOp1());
    assertNull(op2.getOp2());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((UnopStmt) actualCloneResult)._ts_default_next);
    assertNull(((UnopStmt) actualCloneResult).list);
    assertEquals(0, ((UnopStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((Constant) op2).et);
    assertEquals(ET.E1, ((UnopStmt) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) op2).vt);
    assertEquals(Stmt.ST.LOCK, ((UnopStmt) actualCloneResult).st);
    assertFalse(((UnopStmt) actualCloneResult).visited);
    assertSame(op.value, ((Constant) op2).value);
  }

  /**
   * Method under test: {@link UnopStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant value = Exprs.nNull();
    UnopStmt nLockResult = Stmts.nLock(new CastExpr(value, "jane.doe@example.org", "alice.liddell@example.org"));

    // Act
    Stmt actualCloneResult = nLockResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof CastExpr);
    Value op2 = op.getOp();
    assertTrue(op2 instanceof Constant);
    assertTrue(actualCloneResult instanceof UnopStmt);
    assertEquals("alice.liddell@example.org", ((CastExpr) op).to);
    assertEquals("jane.doe@example.org", ((CastExpr) op).from);
    assertNull(op2.getOps());
    assertNull(op.getOps());
    assertNull(actualCloneResult.getOps());
    assertNull(((CastExpr) op).tag);
    assertNull(((Constant) op2).tag);
    assertNull(((UnopStmt) actualCloneResult).frame);
    assertNull(((CastExpr) op).valueType);
    assertNull(((Constant) op2).valueType);
    assertNull(((UnopStmt) actualCloneResult).exceptionHandlers);
    assertNull(((UnopStmt) actualCloneResult)._cfg_froms);
    assertNull(op2.getOp());
    assertNull(op2.getOp1());
    assertNull(op.getOp1());
    assertNull(op2.getOp2());
    assertNull(op.getOp2());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((UnopStmt) actualCloneResult)._ts_default_next);
    assertNull(((UnopStmt) actualCloneResult).list);
    assertEquals(0, ((UnopStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((Constant) op2).et);
    assertEquals(ET.E1, ((CastExpr) op).et);
    assertEquals(ET.E1, ((UnopStmt) actualCloneResult).et);
    assertEquals(Value.VT.CAST, ((CastExpr) op).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op2).vt);
    assertEquals(Stmt.ST.LOCK, ((UnopStmt) actualCloneResult).st);
    assertFalse(((UnopStmt) actualCloneResult).visited);
    assertSame(value.value, ((Constant) op2).value);
  }

  /**
   * Method under test: {@link UnopStmt#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("lock null[null]", Stmts.nLock(new ArrayExpr()).toString());
    assertEquals("lock null", Stmts.nLock(null).toString());
    assertEquals("return null[null]", Stmts.nReturn(new ArrayExpr()).toString());
    assertEquals("throw null[null]", Stmts.nThrow(new ArrayExpr()).toString());
    assertEquals("return null", Stmts.nReturn(null).toString());
    assertEquals("throw null", Stmts.nThrow(null).toString());
  }

  /**
   * Method under test: {@link UnopStmt#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    ArrayExpr op = new ArrayExpr();
    op.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("lock null[null][null]", Stmts.nLock(op).toString());
  }

  /**
   * Method under test: {@link UnopStmt#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals("lock null[null][null[null]]", Stmts.nLock(new ArrayExpr(base, new ArrayExpr(), "lock ")).toString());
  }

  /**
   * Method under test: {@link UnopStmt#UnopStmt(Stmt.ST, Value)}
   */
  @Test
  public void testNewUnopStmt() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    UnopStmt actualUnopStmt = new UnopStmt(Stmt.ST.LOCAL_START, op);

    // Assert
    assertNull(actualUnopStmt.getOps());
    assertNull(actualUnopStmt.frame);
    assertNull(actualUnopStmt.exceptionHandlers);
    assertNull(actualUnopStmt._cfg_froms);
    assertNull(actualUnopStmt.getOp1());
    assertNull(actualUnopStmt.getOp2());
    assertNull(actualUnopStmt.getNext());
    assertNull(actualUnopStmt.getPre());
    assertNull(actualUnopStmt._ts_default_next);
    assertNull(actualUnopStmt.list);
    assertEquals(0, actualUnopStmt.id);
    assertEquals(ET.E1, actualUnopStmt.et);
    assertEquals(Stmt.ST.LOCAL_START, actualUnopStmt.st);
    assertFalse(actualUnopStmt.visited);
    assertSame(op, actualUnopStmt.getOp());
  }
}
