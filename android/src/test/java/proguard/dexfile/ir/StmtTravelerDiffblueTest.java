package proguard.dexfile.ir;

import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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

class StmtTravelerDiffblueTest {
  /**
   * Test {@link StmtTraveler#travel(Value)} with {@code op}.
   *
   * <p>Method under test: {@link StmtTraveler#travel(Value)}
   */
  @Test
  @DisplayName("Test travel(Value) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value StmtTraveler.travel(Value)"})
  void testTravelWithOp() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    CastExpr op = Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act
    Value actualTravelResult = stmtTraveler.travel(op);

    // Assert
    assertSame(op, actualTravelResult);
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
  @DisplayName(
      "Test travel(Value) with 'op'; then return nArray(Value, Value, String) with base is nNull and index is nNull and 'Element Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value StmtTraveler.travel(Value)"})
  void testTravelWithOp_thenReturnNArrayWithBaseIsNNullAndIndexIsNNullAndElementType() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant base = Exprs.nNull();
    ArrayExpr op = Exprs.nArray(base, Exprs.nNull(), "Element Type");

    // Act
    Value actualTravelResult = stmtTraveler.travel(op);

    // Assert
    assertSame(op, actualTravelResult);
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
  @DisplayName(
      "Test travel(Value) with 'op'; then return nFilledArray 'Element Type' and array of Value with nNull")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value StmtTraveler.travel(Value)"})
  void testTravelWithOp_thenReturnNFilledArrayElementTypeAndArrayOfValueWithNNull() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    FilledArrayExpr op = Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()});

    // Act
    Value actualTravelResult = stmtTraveler.travel(op);

    // Assert
    assertSame(op, actualTravelResult);
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
  @DisplayName("Test travel(Value) with 'op'; when nNull; then return nNull")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value StmtTraveler.travel(Value)"})
  void testTravelWithOp_whenNNull_thenReturnNNull() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant op = Exprs.nNull();

    // Act
    Value actualTravelResult = stmtTraveler.travel(op);

    // Assert
    assertSame(op, actualTravelResult);
  }

  /**
   * Test {@link StmtTraveler#travel(Stmt)} with {@code stmt}.
   *
   * <p>Method under test: {@link StmtTraveler#travel(Stmt)}
   */
  @Test
  @DisplayName("Test travel(Stmt) with 'stmt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt StmtTraveler.travel(Stmt)"})
  void testTravelWithStmt() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    CastExpr left = Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org");
    AssignStmt stmt = Stmts.nAssign(left, Exprs.nNull());

    // Act
    Stmt actualTravelResult = stmtTraveler.travel(stmt);

    // Assert
    assertSame(stmt, actualTravelResult);
  }

  /**
   * Test {@link StmtTraveler#travel(Stmt)} with {@code stmt}.
   *
   * <p>Method under test: {@link StmtTraveler#travel(Stmt)}
   */
  @Test
  @DisplayName("Test travel(Stmt) with 'stmt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt StmtTraveler.travel(Stmt)"})
  void testTravelWithStmt2() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    FilledArrayExpr left = Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()});
    AssignStmt stmt = Stmts.nAssign(left, Exprs.nNull());

    // Act
    Stmt actualTravelResult = stmtTraveler.travel(stmt);

    // Assert
    assertSame(stmt, actualTravelResult);
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
  @DisplayName(
      "Test travel(Stmt) with 'stmt'; when nAssign nNull and nNull; then return nAssign nNull and nNull")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt StmtTraveler.travel(Stmt)"})
  void testTravelWithStmt_whenNAssignNNullAndNNull_thenReturnNAssignNNullAndNNull() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant left = Exprs.nNull();
    AssignStmt stmt = Stmts.nAssign(left, Exprs.nNull());

    // Act
    Stmt actualTravelResult = stmtTraveler.travel(stmt);

    // Assert
    assertSame(stmt, actualTravelResult);
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
  @DisplayName(
      "Test travel(Stmt) with 'stmt'; when nIf nNull and nLabel; then return nIf nNull and nLabel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt StmtTraveler.travel(Stmt)"})
  void testTravelWithStmt_whenNIfNNullAndNLabel_thenReturnNIfNNullAndNLabel() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    Constant a = Exprs.nNull();
    IfStmt stmt = Stmts.nIf(a, Stmts.nLabel());

    // Act
    Stmt actualTravelResult = stmtTraveler.travel(stmt);

    // Assert
    assertSame(stmt, actualTravelResult);
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
  @DisplayName("Test travel(Stmt) with 'stmt'; when nLabel; then return nLabel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt StmtTraveler.travel(Stmt)"})
  void testTravelWithStmt_whenNLabel_thenReturnNLabel() {
    // Arrange
    StmtTraveler stmtTraveler = new StmtTraveler();
    LabelStmt stmt = Stmts.nLabel();

    // Act
    Stmt actualTravelResult = stmtTraveler.travel(stmt);

    // Assert
    assertSame(stmt, actualTravelResult);
  }
}
