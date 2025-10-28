package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Value;

public class StmtDiffblueTest {
  /**
   * Method under test: {@link Stmt.E1Stmt#getOp()}
   */
  @Test
  public void testE1StmtGetOp() {
    // Arrange, Act and Assert
    assertNull((new TableSwitchStmt()).getOp());
  }

  /**
   * Method under test: {@link Stmt.E1Stmt#setOp(Value)}
   */
  @Test
  public void testE1StmtSetOp() {
    // Arrange
    TableSwitchStmt tableSwitchStmt = new TableSwitchStmt();
    ArrayExpr op = new ArrayExpr();

    // Act
    tableSwitchStmt.setOp(op);

    // Assert
    assertSame(op, tableSwitchStmt.getOp());
  }

  /**
   * Method under test: {@link Stmt.E2Stmt#getOp1()}
   */
  @Test
  public void testE2StmtGetOp1() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    AssignStmt nAssignResult = Stmts.nAssign(left, new ArrayExpr());

    // Act and Assert
    assertSame(nAssignResult.op1, nAssignResult.getOp1());
  }

  /**
   * Method under test: {@link Stmt.E2Stmt#getOp2()}
   */
  @Test
  public void testE2StmtGetOp2() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    AssignStmt nAssignResult = Stmts.nAssign(left, new ArrayExpr());

    // Act and Assert
    assertSame(nAssignResult.op2, nAssignResult.getOp2());
  }

  /**
   * Method under test: {@link Stmt#getNext()}
   */
  @Test
  public void testGetNext() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getNext());
  }

  /**
   * Method under test: {@link Stmt#getOp()}
   */
  @Test
  public void testGetOp() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOp());
  }

  /**
   * Method under test: {@link Stmt#getOp1()}
   */
  @Test
  public void testGetOp1() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOp1());
  }

  /**
   * Method under test: {@link Stmt#getOp2()}
   */
  @Test
  public void testGetOp2() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOp2());
  }

  /**
   * Method under test: {@link Stmt#getOps()}
   */
  @Test
  public void testGetOps() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getOps());
  }

  /**
   * Method under test: {@link Stmt#getPre()}
   */
  @Test
  public void testGetPre() {
    // Arrange, Act and Assert
    assertNull(Stmts.nLabel().getPre());
  }

  /**
   * Method under test: {@link Stmt.ST#canBranch()}
   */
  @Test
  public void testSTCanBranch() {
    // Arrange, Act and Assert
    assertFalse(Stmt.ST.LOCAL_START.canBranch());
    assertTrue(Stmt.ST.GOTO.canBranch());
  }

  /**
   * Method under test: {@link Stmt.ST#canContinue()}
   */
  @Test
  public void testSTCanContinue() {
    // Arrange, Act and Assert
    assertTrue(Stmt.ST.LOCAL_START.canContinue());
    assertFalse(Stmt.ST.RETURN.canContinue());
  }

  /**
   * Method under test: {@link Stmt.ST#canSwitch()}
   */
  @Test
  public void testSTCanSwitch() {
    // Arrange, Act and Assert
    assertFalse(Stmt.ST.LOCAL_START.canSwitch());
    assertTrue(Stmt.ST.LOOKUP_SWITCH.canSwitch());
  }

  /**
   * Method under test: {@link Stmt.ST#canThrow()}
   */
  @Test
  public void testSTCanThrow() {
    // Arrange, Act and Assert
    assertFalse(Stmt.ST.LOCAL_START.canThrow());
    assertTrue(Stmt.ST.LOCK.canThrow());
  }

  /**
   * Method under test: {@link Stmt.ST#mayThrow()}
   */
  @Test
  public void testSTMayThrow() {
    // Arrange, Act and Assert
    assertFalse(Stmt.ST.LOCAL_START.mayThrow());
    assertTrue(Stmt.ST.ASSIGN.mayThrow());
  }
}
