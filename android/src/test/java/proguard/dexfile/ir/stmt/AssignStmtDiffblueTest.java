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
import proguard.dexfile.ir.expr.Value;

public class AssignStmtDiffblueTest {
  /**
   * Method under test: {@link AssignStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant left = Exprs.nNull();
    Constant right = Exprs.nNull();
    AssignStmt nAssignResult = Stmts.nAssign(left, right);

    // Act
    Stmt actualCloneResult = nAssignResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op1 = actualCloneResult.getOp1();
    assertTrue(op1 instanceof Constant);
    Value op2 = actualCloneResult.getOp2();
    assertTrue(op2 instanceof Constant);
    assertTrue(actualCloneResult instanceof AssignStmt);
    assertNull(op1.getOps());
    assertNull(op2.getOps());
    assertNull(actualCloneResult.getOps());
    assertNull(((Constant) op1).tag);
    assertNull(((Constant) op2).tag);
    assertNull(((AssignStmt) actualCloneResult).frame);
    assertNull(((Constant) op1).valueType);
    assertNull(((Constant) op2).valueType);
    assertNull(((AssignStmt) actualCloneResult).exceptionHandlers);
    assertNull(((AssignStmt) actualCloneResult)._cfg_froms);
    assertNull(op1.getOp());
    assertNull(op2.getOp());
    assertNull(op1.getOp1());
    assertNull(op2.getOp1());
    assertNull(op1.getOp2());
    assertNull(op2.getOp2());
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((AssignStmt) actualCloneResult)._ts_default_next);
    assertNull(((AssignStmt) actualCloneResult).list);
    assertEquals(0, ((AssignStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((Constant) op1).et);
    assertEquals(ET.E0, ((Constant) op2).et);
    assertEquals(ET.E2, ((AssignStmt) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) op1).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op2).vt);
    assertEquals(Stmt.ST.ASSIGN, ((AssignStmt) actualCloneResult).st);
    assertFalse(((AssignStmt) actualCloneResult).visited);
    Object object = right.value;
    assertSame(object, ((Constant) op1).value);
    assertSame(object, ((Constant) op2).value);
  }

  /**
   * Method under test: {@link AssignStmt#toString()}
   */
  @Test
  public void testToString() {
    // Arrange
    ArrayExpr left = new ArrayExpr();

    // Act and Assert
    assertEquals("null[null] = null[null]", Stmts.nAssign(left, new ArrayExpr()).toString());
  }

  /**
   * Method under test: {@link AssignStmt#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    left.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null][null] = null[null]", Stmts.nAssign(left, new ArrayExpr()).toString());
  }

  /**
   * Method under test: {@link AssignStmt#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr left = new ArrayExpr(base, new ArrayExpr(), "[");

    // Act and Assert
    assertEquals("null[null][null[null]] = null[null]", Stmts.nAssign(left, new ArrayExpr()).toString());
  }

  /**
   * Method under test: {@link AssignStmt#toString()}
   */
  @Test
  public void testToString4() {
    // Arrange, Act and Assert
    assertEquals("null = null[null]", Stmts.nAssign(null, new ArrayExpr()).toString());
  }

  /**
   * Method under test: {@link AssignStmt#toString()}
   */
  @Test
  public void testToString5() {
    // Arrange, Act and Assert
    assertEquals("null[null] = null", Stmts.nAssign(new ArrayExpr(), null).toString());
  }

  /**
   * Method under test: {@link AssignStmt#toString()}
   */
  @Test
  public void testToString6() {
    // Arrange
    ArrayExpr left = new ArrayExpr();

    // Act and Assert
    assertEquals("null[null] <- null[null]", Stmts.nFillArrayData(left, new ArrayExpr()).toString());
  }

  /**
   * Method under test: {@link AssignStmt#toString()}
   */
  @Test
  public void testToString7() {
    // Arrange
    ArrayExpr local = new ArrayExpr();

    // Act and Assert
    assertEquals("null[null] := null[null]", Stmts.nIdentity(local, new ArrayExpr()).toString());
  }

  /**
   * Method under test: {@link AssignStmt#toString()}
   */
  @Test
  public void testToString8() {
    // Arrange, Act and Assert
    assertEquals("null <- null[null]", Stmts.nFillArrayData(null, new ArrayExpr()).toString());
  }

  /**
   * Method under test: {@link AssignStmt#toString()}
   */
  @Test
  public void testToString9() {
    // Arrange, Act and Assert
    assertEquals("null[null] <- null", Stmts.nFillArrayData(new ArrayExpr(), null).toString());
  }

  /**
   * Method under test: {@link AssignStmt#toString()}
   */
  @Test
  public void testToString10() {
    // Arrange, Act and Assert
    assertEquals("null := null[null]", Stmts.nIdentity(null, new ArrayExpr()).toString());
  }

  /**
   * Method under test: {@link AssignStmt#toString()}
   */
  @Test
  public void testToString11() {
    // Arrange, Act and Assert
    assertEquals("null[null] := null", Stmts.nIdentity(new ArrayExpr(), null).toString());
  }

  /**
   * Method under test: {@link AssignStmt#AssignStmt(Stmt.ST, Value, Value)}
   */
  @Test
  public void testNewAssignStmt() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    ArrayExpr right = new ArrayExpr();

    // Act
    AssignStmt actualAssignStmt = new AssignStmt(Stmt.ST.LOCAL_START, left, right);

    // Assert
    assertNull(actualAssignStmt.getOps());
    assertNull(actualAssignStmt.frame);
    assertNull(actualAssignStmt.exceptionHandlers);
    assertNull(actualAssignStmt._cfg_froms);
    assertNull(actualAssignStmt.getOp());
    assertNull(actualAssignStmt.getNext());
    assertNull(actualAssignStmt.getPre());
    assertNull(actualAssignStmt._ts_default_next);
    assertNull(actualAssignStmt.list);
    assertEquals(0, actualAssignStmt.id);
    assertEquals(ET.E2, actualAssignStmt.et);
    assertEquals(Stmt.ST.LOCAL_START, actualAssignStmt.st);
    assertFalse(actualAssignStmt.visited);
    assertSame(left, actualAssignStmt.getOp1());
    assertSame(right, actualAssignStmt.getOp2());
  }
}
