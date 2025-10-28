package proguard.dexfile.ir;

import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.CastExpr;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.FilledArrayExpr;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.IfStmt;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmts;

public class StmtTravelerDiffblueTest {
  /**
   * Method under test: {@link StmtTraveler#travel(Value)}
   */
  @Test
  public void testTravel() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant op = Exprs.nNull();

    // Act and Assert
    assertSame(op, stmtTraveler.travel(op));
  }

  /**
   * Method under test: {@link StmtTraveler#travel(Value)}
   */
  @Test
  public void testTravel2() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    CastExpr op = Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act and Assert
    assertSame(op, stmtTraveler.travel(op));
  }

  /**
   * Method under test: {@link StmtTraveler#travel(Value)}
   */
  @Test
  public void testTravel3() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    FilledArrayExpr op = Exprs.nFilledArray("Element Type", new Value[]{Exprs.nNull()});

    // Act and Assert
    assertSame(op, stmtTraveler.travel(op));
  }

  /**
   * Method under test: {@link StmtTraveler#travel(Value)}
   */
  @Test
  public void testTravel4() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant base = Exprs.nNull();
    ArrayExpr op = Exprs.nArray(base, Exprs.nNull(), "Element Type");

    // Act and Assert
    assertSame(op, stmtTraveler.travel(op));
  }

  /**
   * Method under test: {@link StmtTraveler#travel(Stmt)}
   */
  @Test
  public void testTravel5() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    LabelStmt stmt = Stmts.nLabel();

    // Act and Assert
    assertSame(stmt, stmtTraveler.travel(stmt));
  }

  /**
   * Method under test: {@link StmtTraveler#travel(Stmt)}
   */
  @Test
  public void testTravel6() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant a = Exprs.nNull();
    IfStmt stmt = Stmts.nIf(a, Stmts.nLabel());

    // Act and Assert
    assertSame(stmt, stmtTraveler.travel(stmt));
  }

  /**
   * Method under test: {@link StmtTraveler#travel(Stmt)}
   */
  @Test
  public void testTravel7() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant left = Exprs.nNull();
    AssignStmt stmt = Stmts.nAssign(left, Exprs.nNull());

    // Act and Assert
    assertSame(stmt, stmtTraveler.travel(stmt));
  }
}
