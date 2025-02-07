package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

class UnopStmtDiffblueTest {
  /**
   * Test {@link UnopStmt#UnopStmt(ST, Value)}.
   *
   * <p>Method under test: {@link UnopStmt#UnopStmt(ST, Value)}
   */
  @Test
  @DisplayName("Test new UnopStmt(ST, Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.stmt.UnopStmt.<init>(proguard.dexfile.ir.stmt.Stmt$ST, proguard.dexfile.ir.expr.Value)"
  })
  void testNewUnopStmt() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    UnopStmt actualUnopStmt = new UnopStmt(ST.LOCAL_START, op);

    // Assert
    Value op2 = actualUnopStmt.getOp();
    assertTrue(op2 instanceof ArrayExpr);
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
    assertEquals(ST.LOCAL_START, actualUnopStmt.st);
    assertFalse(actualUnopStmt.visited);
    assertSame(op, op2);
  }

  /**
   * Test {@link UnopStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Given nLock nNull.
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; given nLock nNull; then Op return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.Stmt proguard.dexfile.ir.stmt.UnopStmt.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_givenNLockNNull_thenOpReturnConstant() {
    // Arrange
    Constant op = Exprs.nNull();
    UnopStmt nLockResult = Stmts.nLock(op);

    // Act
    Stmt actualCloneResult = nLockResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op2 = actualCloneResult.getOp();
    assertTrue(op2 instanceof Constant);
    assertTrue(actualCloneResult instanceof UnopStmt);
    assertNull(op2.getOp());
    assertEquals(ET.E0, ((Constant) op2).et);
    assertEquals(VT.CONSTANT, ((Constant) op2).vt);
    assertSame(op.value, ((Constant) op2).value);
  }

  /**
   * Test {@link UnopStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op return CastExpr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.Stmt proguard.dexfile.ir.stmt.UnopStmt.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenOpReturnCastExpr() {
    // Arrange
    UnopStmt nLockResult =
        Stmts.nLock(
            new CastExpr(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org"));

    // Act
    Stmt actualCloneResult = nLockResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof CastExpr);
    assertTrue(op.getOp() instanceof Constant);
    assertTrue(actualCloneResult instanceof UnopStmt);
    assertEquals("alice.liddell@example.org", ((CastExpr) op).to);
    assertEquals("jane.doe@example.org", ((CastExpr) op).from);
    assertEquals(ET.E1, ((CastExpr) op).et);
    assertEquals(VT.CAST, ((CastExpr) op).vt);
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code lock null[null][null]}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given ArrayExpr() Op1 is ArrayExpr(); then return 'lock null[null][null]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.UnopStmt.toString()"})
  void testToString_givenArrayExprOp1IsArrayExpr_thenReturnLockNullNullNull() {
    // Arrange
    ArrayExpr op = new ArrayExpr();
    op.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("lock null[null][null]", Stmts.nLock(op).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Given nLock {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code lock null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); given nLock ArrayExpr(); then return 'lock null[null]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.UnopStmt.toString()"})
  void testToString_givenNLockArrayExpr_thenReturnLockNullNull() {
    // Arrange, Act and Assert
    assertEquals("lock null[null]", Stmts.nLock(new ArrayExpr()).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Given nLock {@code null}.
   *   <li>Then return {@code lock null}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); given nLock 'null'; then return 'lock null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.UnopStmt.toString()"})
  void testToString_givenNLockNull_thenReturnLockNull() {
    // Arrange, Act and Assert
    assertEquals("lock null", Stmts.nLock(null).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Given nReturn {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code return null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); given nReturn ArrayExpr(); then return 'return null[null]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.UnopStmt.toString()"})
  void testToString_givenNReturnArrayExpr_thenReturnReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("return null[null]", Stmts.nReturn(new ArrayExpr()).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Given nReturn {@code null}.
   *   <li>Then return {@code return null}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); given nReturn 'null'; then return 'return null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.UnopStmt.toString()"})
  void testToString_givenNReturnNull_thenReturnReturnNull() {
    // Arrange, Act and Assert
    assertEquals("return null", Stmts.nReturn(null).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Given nThrow {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code throw null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); given nThrow ArrayExpr(); then return 'throw null[null]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.UnopStmt.toString()"})
  void testToString_givenNThrowArrayExpr_thenReturnThrowNullNull() {
    // Arrange, Act and Assert
    assertEquals("throw null[null]", Stmts.nThrow(new ArrayExpr()).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Given nThrow {@code null}.
   *   <li>Then return {@code throw null}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); given nThrow 'null'; then return 'throw null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.UnopStmt.toString()"})
  void testToString_givenNThrowNull_thenReturnThrowNull() {
    // Arrange, Act and Assert
    assertEquals("throw null", Stmts.nThrow(null).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code lock null[null][null[null]]}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'lock null[null][null[null]]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.UnopStmt.toString()"})
  void testToString_thenReturnLockNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "lock null[null][null[null]]",
        Stmts.nLock(new ArrayExpr(base, new ArrayExpr(), "lock ")).toString());
  }
}
