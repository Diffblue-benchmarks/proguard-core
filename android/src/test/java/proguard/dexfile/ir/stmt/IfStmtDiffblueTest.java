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

public class IfStmtDiffblueTest {
  /**
   * Method under test: {@link IfStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    Local a = new Local();
    IfStmt nIfResult = Stmts.nIf(a, Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nIfResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Local);
    assertTrue(actualCloneResult instanceof IfStmt);
    assertEquals("a0", ((Local) op).toString0());
    assertNull(op.getOps());
    assertNull(actualCloneResult.getOps());
    LabelStmt target = ((IfStmt) actualCloneResult).getTarget();
    assertNull(target.getOps());
    assertNull(((Local) op).tag);
    assertNull(target.tag);
    assertNull(target.frame);
    assertNull(((IfStmt) actualCloneResult).frame);
    assertNull(((Local) op).debugName);
    assertNull(((Local) op).signature);
    assertNull(((Local) op).valueType);
    assertNull(target.displayName);
    assertNull(target.phis);
    assertNull(target.exceptionHandlers);
    assertNull(((IfStmt) actualCloneResult).exceptionHandlers);
    assertNull(target._cfg_froms);
    assertNull(((IfStmt) actualCloneResult)._cfg_froms);
    assertNull(op.getOp());
    assertNull(op.getOp1());
    assertNull(op.getOp2());
    assertNull(target.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(target.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(target.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(target.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(target.getPre());
    assertNull(target._ts_default_next);
    assertNull(((IfStmt) actualCloneResult)._ts_default_next);
    assertNull(target.list);
    assertNull(((IfStmt) actualCloneResult).list);
    assertEquals(-1, target.lineNumber);
    assertEquals(0, ((Local) op)._ls_index);
    assertEquals(0, target.id);
    assertEquals(0, ((IfStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((Local) op).et);
    assertEquals(ET.E0, target.et);
    assertEquals(ET.E1, ((IfStmt) actualCloneResult).et);
    assertEquals(Value.VT.LOCAL, ((Local) op).vt);
    assertEquals(Stmt.ST.IF, ((IfStmt) actualCloneResult).st);
    assertEquals(Stmt.ST.LABEL, target.st);
    assertFalse(target.visited);
    assertFalse(((IfStmt) actualCloneResult).visited);
  }

  /**
   * Method under test: {@link IfStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant a = Exprs.nNull();
    IfStmt nIfResult = Stmts.nIf(a, Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nIfResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof IfStmt);
    assertNull(op.getOps());
    assertNull(actualCloneResult.getOps());
    LabelStmt target = ((IfStmt) actualCloneResult).getTarget();
    assertNull(target.getOps());
    assertNull(((Constant) op).tag);
    assertNull(target.tag);
    assertNull(target.frame);
    assertNull(((IfStmt) actualCloneResult).frame);
    assertNull(((Constant) op).valueType);
    assertNull(target.displayName);
    assertNull(target.phis);
    assertNull(target.exceptionHandlers);
    assertNull(((IfStmt) actualCloneResult).exceptionHandlers);
    assertNull(target._cfg_froms);
    assertNull(((IfStmt) actualCloneResult)._cfg_froms);
    assertNull(op.getOp());
    assertNull(op.getOp1());
    assertNull(op.getOp2());
    assertNull(target.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(target.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(target.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(target.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(target.getPre());
    assertNull(target._ts_default_next);
    assertNull(((IfStmt) actualCloneResult)._ts_default_next);
    assertNull(target.list);
    assertNull(((IfStmt) actualCloneResult).list);
    assertEquals(-1, target.lineNumber);
    assertEquals(0, target.id);
    assertEquals(0, ((IfStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(ET.E0, target.et);
    assertEquals(ET.E1, ((IfStmt) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) op).vt);
    assertEquals(Stmt.ST.IF, ((IfStmt) actualCloneResult).st);
    assertEquals(Stmt.ST.LABEL, target.st);
    assertFalse(target.visited);
    assertFalse(((IfStmt) actualCloneResult).visited);
    assertSame(a.value, ((Constant) op).value);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IfStmt#setTarget(LabelStmt)}
   *   <li>{@link IfStmt#toString()}
   *   <li>{@link IfStmt#getTarget()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayExpr condition = new ArrayExpr();
    IfStmt ifStmt = new IfStmt(Stmt.ST.LOCAL_START, condition, Stmts.nLabel());
    LabelStmt target = Stmts.nLabel();

    // Act
    ifStmt.setTarget(target);
    ifStmt.toString();

    // Assert that nothing has changed
    assertSame(target, ifStmt.getTarget());
  }

  /**
   * Method under test: {@link IfStmt#IfStmt(Stmt.ST, Value, LabelStmt)}
   */
  @Test
  public void testNewIfStmt() {
    // Arrange
    ArrayExpr condition = new ArrayExpr();
    LabelStmt target = Stmts.nLabel();

    // Act
    IfStmt actualIfStmt = new IfStmt(Stmt.ST.LOCAL_START, condition, target);

    // Assert
    assertNull(actualIfStmt.getOps());
    assertNull(actualIfStmt.frame);
    assertNull(actualIfStmt.exceptionHandlers);
    assertNull(actualIfStmt._cfg_froms);
    assertNull(actualIfStmt.getOp1());
    assertNull(actualIfStmt.getOp2());
    assertNull(actualIfStmt.getNext());
    assertNull(actualIfStmt.getPre());
    assertNull(actualIfStmt._ts_default_next);
    assertNull(actualIfStmt.list);
    assertEquals(0, actualIfStmt.id);
    assertEquals(ET.E1, actualIfStmt.et);
    assertEquals(Stmt.ST.LOCAL_START, actualIfStmt.st);
    assertFalse(actualIfStmt.visited);
    assertSame(condition, actualIfStmt.getOp());
    assertSame(target, actualIfStmt.getTarget());
  }
}
