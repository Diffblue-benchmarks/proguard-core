package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.CastExpr;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.ir.stmt.Stmt.ST;

class AssignStmtDiffblueTest {
  /**
   * Test {@link AssignStmt#AssignStmt(ST, Value, Value)}.
   *
   * <p>Method under test: {@link AssignStmt#AssignStmt(ST, Value, Value)}
   */
  @Test
  @DisplayName("Test new AssignStmt(ST, Value, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssignStmt.<init>(ST, Value, Value)"})
  void testNewAssignStmt() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    ArrayExpr right = new ArrayExpr();

    // Act
    AssignStmt actualAssignStmt = new AssignStmt(ST.LOCAL_START, left, right);

    // Assert
    Value op1 = actualAssignStmt.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualAssignStmt.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualAssignStmt.frame);
    assertNull(actualAssignStmt.exceptionHandlers);
    assertNull(actualAssignStmt._cfg_froms);
    assertNull(actualAssignStmt.getOp());
    assertNull(actualAssignStmt.getOps());
    assertNull(actualAssignStmt.getNext());
    assertNull(actualAssignStmt.getPre());
    assertNull(actualAssignStmt._ts_default_next);
    assertNull(actualAssignStmt.list);
    assertEquals(0, actualAssignStmt.id);
    assertEquals(ET.E2, actualAssignStmt.et);
    assertEquals(ST.LOCAL_START, actualAssignStmt.st);
    assertFalse(actualAssignStmt.visited);
    assertSame(left, op1);
    assertSame(right, op2);
  }

  /**
   * Test {@link AssignStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Given nAssign nNull and nNull.
   *   <li>Then Op1 return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; given nAssign nNull and nNull; then Op1 return Constant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt AssignStmt.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_givenNAssignNNullAndNNull_thenOp1ReturnConstant() {
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
    assertNull(op1.getOp());
    assertEquals(ET.E0, ((Constant) op1).et);
    assertEquals(VT.CONSTANT, ((Constant) op1).vt);
    Object object = ((Constant) op1).value;
    assertSame(right.value, object);
    assertSame(object, ((Constant) op2).value);
  }

  /**
   * Test {@link AssignStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op1 return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op1 return CastExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt AssignStmt.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenOp1ReturnCastExpr() {
    // Arrange
    CastExpr left =
        new CastExpr(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org");
    AssignStmt nAssignResult = Stmts.nAssign(left, Exprs.nNull());

    // Act
    Stmt actualCloneResult = nAssignResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op1 = actualCloneResult.getOp1();
    assertTrue(op1 instanceof CastExpr);
    assertTrue(op1.getOp() instanceof Constant);
    assertTrue(actualCloneResult instanceof AssignStmt);
    assertEquals("alice.liddell@example.org", ((CastExpr) op1).to);
    assertEquals("jane.doe@example.org", ((CastExpr) op1).from);
    assertEquals(ET.E1, ((CastExpr) op1).et);
    assertEquals(VT.CAST, ((CastExpr) op1).vt);
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null][null] = null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given ArrayExpr() Op1 is ArrayExpr(); then return 'null[null][null] = null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  void testToString_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNullNullNull() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    left.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null][null] = null[null]", Stmts.nAssign(left, new ArrayExpr()).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nAssign {@link ArrayExpr#ArrayExpr()} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null] = null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given nAssign ArrayExpr() and ArrayExpr(); then return 'null[null] = null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  void testToString_givenNAssignArrayExprAndArrayExpr_thenReturnNullNullNullNull() {
    // Arrange
    ArrayExpr left = new ArrayExpr();

    // Act and Assert
    assertEquals("null[null] = null[null]", Stmts.nAssign(left, new ArrayExpr()).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nAssign {@link ArrayExpr#ArrayExpr()} and {@code null}.
   *   <li>Then return {@code null[null] = null}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given nAssign ArrayExpr() and 'null'; then return 'null[null] = null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  void testToString_givenNAssignArrayExprAndNull_thenReturnNullNullNull() {
    // Arrange
    AssignStmt nAssignResult = Stmts.nAssign(new ArrayExpr(), null);

    // Act and Assert
    assertEquals("null[null] = null", nAssignResult.toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Given nAssign {@code null} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null = null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given nAssign 'null' and ArrayExpr(); then return 'null = null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  void testToString_givenNAssignNullAndArrayExpr_thenReturnNullNullNull() {
    // Arrange, Act and Assert
    assertEquals("null = null[null]", Stmts.nAssign(null, new ArrayExpr()).toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null := null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'null := null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  void testToString_thenReturnNullNullNull() {
    // Arrange
    AssignStmt assignStmt = new AssignStmt(ST.LOCAL_START, null, new ArrayExpr());

    // Act and Assert
    assertEquals("null := null[null]", assignStmt.toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null[null] := null}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'null[null] := null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  void testToString_thenReturnNullNullNull2() {
    // Arrange
    AssignStmt assignStmt = new AssignStmt(ST.LOCAL_START, new ArrayExpr(), null);

    // Act and Assert
    assertEquals("null[null] := null", assignStmt.toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null <- null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'null <- null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  void testToString_thenReturnNullNullNull3() {
    // Arrange
    AssignStmt assignStmt = new AssignStmt(ST.FILL_ARRAY_DATA, null, new ArrayExpr());

    // Act and Assert
    assertEquals("null <- null[null]", assignStmt.toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null[null] <- null}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'null[null] <- null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  void testToString_thenReturnNullNullNull4() {
    // Arrange
    AssignStmt assignStmt = new AssignStmt(ST.FILL_ARRAY_DATA, new ArrayExpr(), null);

    // Act and Assert
    assertEquals("null[null] <- null", assignStmt.toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null[null] := null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'null[null] := null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  void testToString_thenReturnNullNullNullNull() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    AssignStmt assignStmt = new AssignStmt(ST.LOCAL_START, left, new ArrayExpr());

    // Act and Assert
    assertEquals("null[null] := null[null]", assignStmt.toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null[null] <- null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'null[null] <- null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  void testToString_thenReturnNullNullNullNull2() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    AssignStmt assignStmt = new AssignStmt(ST.FILL_ARRAY_DATA, left, new ArrayExpr());

    // Act and Assert
    assertEquals("null[null] <- null[null]", assignStmt.toString());
  }

  /**
   * Test {@link AssignStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null[null][null[null]] = null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link AssignStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'null[null][null[null]] = null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssignStmt.toString()"})
  void testToString_thenReturnNullNullNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr left = new ArrayExpr(base, new ArrayExpr(), "[");

    // Act and Assert
    assertEquals(
        "null[null][null[null]] = null[null]", Stmts.nAssign(left, new ArrayExpr()).toString());
  }
}
