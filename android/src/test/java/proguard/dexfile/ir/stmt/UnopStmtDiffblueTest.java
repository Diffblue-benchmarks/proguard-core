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

class UnopStmtDiffblueTest {
  /**
   * Test {@link UnopStmt#UnopStmt(ST, Value)}.
   *
   * <p>Method under test: {@link UnopStmt#UnopStmt(ST, Value)}
   */
  @Test
  @DisplayName("Test new UnopStmt(ST, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnopStmt.<init>(ST, Value)"})
  void testNewUnopStmt() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    UnopStmt actualUnopStmt = new UnopStmt(ST.LOCAL_START, op);

    // Assert
    Value op2 = actualUnopStmt.getOp();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualUnopStmt.frame);
    assertNull(actualUnopStmt.exceptionHandlers);
    assertNull(actualUnopStmt._cfg_froms);
    assertNull(actualUnopStmt.getOp1());
    assertNull(actualUnopStmt.getOp2());
    assertNull(actualUnopStmt.getOps());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt UnopStmt.clone(LabelAndLocalMapper)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt UnopStmt.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenOpReturnCastExpr() {
    // Arrange
    CastExpr op = new CastExpr(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org");
    UnopStmt nLockResult = Stmts.nLock(op);

    // Act
    Stmt actualCloneResult = nLockResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op2 = actualCloneResult.getOp();
    assertTrue(op2 instanceof CastExpr);
    assertTrue(op2.getOp() instanceof Constant);
    assertTrue(actualCloneResult instanceof UnopStmt);
    assertEquals("alice.liddell@example.org", ((CastExpr) op2).to);
    assertEquals("jane.doe@example.org", ((CastExpr) op2).from);
    assertEquals(ET.E1, ((CastExpr) op2).et);
    assertEquals(VT.CAST, ((CastExpr) op2).vt);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_givenArrayExprOp1IsArrayExpr_thenReturnLockNullNullNull() {
    // Arrange
    ArrayExpr op = new ArrayExpr();
    op.setOp1(new ArrayExpr());
    UnopStmt nLockResult = Stmts.nLock(op);

    // Act and Assert
    assertEquals("lock null[null][null]", nLockResult.toString());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_givenNLockArrayExpr_thenReturnLockNullNull() {
    // Arrange
    UnopStmt nLockResult = Stmts.nLock(new ArrayExpr());

    // Act and Assert
    assertEquals("lock null[null]", nLockResult.toString());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_givenNLockNull_thenReturnLockNull() {
    // Arrange
    UnopStmt nLockResult = Stmts.nLock(null);

    // Act and Assert
    assertEquals("lock null", nLockResult.toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Given {@link UnopStmt#UnopStmt(ST, Value)} with type is {@code LOCAL_END} and op is
   *       {@code null}.
   *   <li>Then return {@code null ::END}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given UnopStmt(ST, Value) with type is 'LOCAL_END' and op is 'null'; then return 'null ::END'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_givenUnopStmtWithTypeIsLocalEndAndOpIsNull_thenReturnNullEnd() {
    // Arrange, Act and Assert
    assertEquals("null ::END", new UnopStmt(ST.LOCAL_END, null).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Given {@link UnopStmt#UnopStmt(ST, Value)} with type is {@code RETURN} and op is {@code
   *       null}.
   *   <li>Then return {@code return null}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given UnopStmt(ST, Value) with type is 'RETURN' and op is 'null'; then return 'return null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_givenUnopStmtWithTypeIsReturnAndOpIsNull_thenReturnReturnNull() {
    // Arrange, Act and Assert
    assertEquals("return null", new UnopStmt(ST.RETURN, null).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Given {@link UnopStmt#UnopStmt(ST, Value)} with type is {@code THROW} and op is {@code
   *       null}.
   *   <li>Then return {@code throw null}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given UnopStmt(ST, Value) with type is 'THROW' and op is 'null'; then return 'throw null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_givenUnopStmtWithTypeIsThrowAndOpIsNull_thenReturnThrowNull() {
    // Arrange, Act and Assert
    assertEquals("throw null", new UnopStmt(ST.THROW, null).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Given {@link UnopStmt#UnopStmt(ST, Value)} with type is {@code UNLOCK} and op is {@code
   *       null}.
   *   <li>Then return {@code unlock null}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given UnopStmt(ST, Value) with type is 'UNLOCK' and op is 'null'; then return 'unlock null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_givenUnopStmtWithTypeIsUnlockAndOpIsNull_thenReturnUnlockNull() {
    // Arrange, Act and Assert
    assertEquals("unlock null", new UnopStmt(ST.UNLOCK, null).toString());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_thenReturnLockNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr op = new ArrayExpr(base, new ArrayExpr(), "lock ");

    // Act and Assert
    assertEquals("lock null[null][null[null]]", Stmts.nLock(op).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null[null] ::END}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'null[null] ::END'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_thenReturnNullNullEnd() {
    // Arrange, Act and Assert
    assertEquals("null[null] ::END", new UnopStmt(ST.LOCAL_END, new ArrayExpr()).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code return null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'return null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_thenReturnReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("return null[null]", new UnopStmt(ST.RETURN, new ArrayExpr()).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code throw null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'throw null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_thenReturnThrowNullNull() {
    // Arrange, Act and Assert
    assertEquals("throw null[null]", new UnopStmt(ST.THROW, new ArrayExpr()).toString());
  }

  /**
   * Test {@link UnopStmt#toString()}.
   *
   * <ul>
   *   <li>Then return {@code unlock null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link UnopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'unlock null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UnopStmt.toString()"})
  void testToString_thenReturnUnlockNullNull() {
    // Arrange, Act and Assert
    assertEquals("unlock null[null]", new UnopStmt(ST.UNLOCK, new ArrayExpr()).toString());
  }
}
