package proguard.dexfile.ir;

import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link StmtTraveler#travel(Value)} with {@code op}.
   *
   * <p>Method under test: {@link StmtTraveler#travel(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value StmtTraveler.travel(Value)"})
  public void testTravelWithOp() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    CastExpr op = Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act and Assert
    assertSame(op, stmtTraveler.travel(op));
  }

  /**
   * Test {@link StmtTraveler#travel(Value)} with {@code op}.
   *
   * <ul>
   *   <li>Then return {@link Exprs#nArray(Value, Value, String)} with base is nNull and index is
   *       nNull and {@code Element Type}.
   * </ul>
   *
   * <p>Method under test: {@link StmtTraveler#travel(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value StmtTraveler.travel(Value)"})
  public void testTravelWithOp_thenReturnNArrayWithBaseIsNNullAndIndexIsNNullAndElementType() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant base = Exprs.nNull();
    ArrayExpr op = Exprs.nArray(base, Exprs.nNull(), "Element Type");

    // Act and Assert
    assertSame(op, stmtTraveler.travel(op));
  }

  /**
   * Test {@link StmtTraveler#travel(Value)} with {@code op}.
   *
   * <ul>
   *   <li>Then return nFilledArray {@code Element Type} and array of {@link Value} with nNull.
   * </ul>
   *
   * <p>Method under test: {@link StmtTraveler#travel(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value StmtTraveler.travel(Value)"})
  public void testTravelWithOp_thenReturnNFilledArrayElementTypeAndArrayOfValueWithNNull() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    FilledArrayExpr op = Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()});

    // Act and Assert
    assertSame(op, stmtTraveler.travel(op));
  }

  /**
   * Test {@link StmtTraveler#travel(Value)} with {@code op}.
   *
   * <ul>
   *   <li>When nNull.
   *   <li>Then return nNull.
   * </ul>
   *
   * <p>Method under test: {@link StmtTraveler#travel(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value StmtTraveler.travel(Value)"})
  public void testTravelWithOp_whenNNull_thenReturnNNull() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant op = Exprs.nNull();

    // Act and Assert
    assertSame(op, stmtTraveler.travel(op));
  }

  /**
   * Test {@link StmtTraveler#travel(Stmt)} with {@code stmt}.
   *
   * <ul>
   *   <li>When nAssign nNull and nNull.
   *   <li>Then return nAssign nNull and nNull.
   * </ul>
   *
   * <p>Method under test: {@link StmtTraveler#travel(Stmt)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt StmtTraveler.travel(Stmt)"})
  public void testTravelWithStmt_whenNAssignNNullAndNNull_thenReturnNAssignNNullAndNNull() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant left = Exprs.nNull();
    AssignStmt stmt = Stmts.nAssign(left, Exprs.nNull());

    // Act and Assert
    assertSame(stmt, stmtTraveler.travel(stmt));
  }

  /**
   * Test {@link StmtTraveler#travel(Stmt)} with {@code stmt}.
   *
   * <ul>
   *   <li>When nIf nNull and nLabel.
   *   <li>Then return nIf nNull and nLabel.
   * </ul>
   *
   * <p>Method under test: {@link StmtTraveler#travel(Stmt)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt StmtTraveler.travel(Stmt)"})
  public void testTravelWithStmt_whenNIfNNullAndNLabel_thenReturnNIfNNullAndNLabel() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant a = Exprs.nNull();
    IfStmt stmt = Stmts.nIf(a, Stmts.nLabel());

    // Act and Assert
    assertSame(stmt, stmtTraveler.travel(stmt));
  }

  /**
   * Test {@link StmtTraveler#travel(Stmt)} with {@code stmt}.
   *
   * <ul>
   *   <li>When nLabel.
   *   <li>Then return nLabel.
   * </ul>
   *
   * <p>Method under test: {@link StmtTraveler#travel(Stmt)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt StmtTraveler.travel(Stmt)"})
  public void testTravelWithStmt_whenNLabel_thenReturnNLabel() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    LabelStmt stmt = Stmts.nLabel();

    // Act and Assert
    assertSame(stmt, stmtTraveler.travel(stmt));
  }
}
