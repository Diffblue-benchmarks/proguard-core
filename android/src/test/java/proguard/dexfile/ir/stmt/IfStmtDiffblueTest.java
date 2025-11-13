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
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.ir.stmt.Stmt.ST;

class IfStmtDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IfStmt#setTarget(LabelStmt)}
   *   <li>{@link IfStmt#toString()}
   *   <li>{@link IfStmt#getTarget()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LabelStmt IfStmt.getTarget()",
    "void IfStmt.setTarget(LabelStmt)",
    "java.lang.String IfStmt.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayExpr condition = new ArrayExpr();
    IfStmt ifStmt = new IfStmt(ST.LOCAL_START, condition, Stmts.nLabel());
    LabelStmt target = Stmts.nLabel();

    // Act
    ifStmt.setTarget(target);
    ifStmt.toString();

    // Assert
    assertSame(target, ifStmt.getTarget());
  }

  /**
   * Test {@link IfStmt#IfStmt(ST, Value, LabelStmt)}.
   *
   * <p>Method under test: {@link IfStmt#IfStmt(ST, Value, LabelStmt)}
   */
  @Test
  @DisplayName("Test new IfStmt(ST, Value, LabelStmt)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IfStmt.<init>(ST, Value, LabelStmt)"})
  void testNewIfStmt() {
    // Arrange
    ArrayExpr condition = new ArrayExpr();
    LabelStmt target = Stmts.nLabel();

    // Act
    IfStmt actualIfStmt = new IfStmt(ST.LOCAL_START, condition, target);

    // Assert
    Value op = actualIfStmt.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertNull(actualIfStmt.frame);
    assertNull(actualIfStmt.exceptionHandlers);
    assertNull(actualIfStmt._cfg_froms);
    assertNull(actualIfStmt.getOp1());
    assertNull(actualIfStmt.getOp2());
    assertNull(actualIfStmt.getOps());
    assertNull(actualIfStmt.getNext());
    assertNull(actualIfStmt.getPre());
    assertNull(actualIfStmt._ts_default_next);
    assertNull(actualIfStmt.list);
    assertEquals(0, actualIfStmt.id);
    assertEquals(ET.E1, actualIfStmt.et);
    assertEquals(ST.LOCAL_START, actualIfStmt.st);
    assertFalse(actualIfStmt.visited);
    assertSame(condition, op);
    assertSame(target, actualIfStmt.getTarget());
  }

  /**
   * Test {@link IfStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Given nIf {@link Local#Local()} and nLabel.
   *   <li>Then Op return {@link Local}.
   * </ul>
   *
   * <p>Method under test: {@link IfStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; given nIf Local() and nLabel; then Op return Local")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt IfStmt.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_givenNIfLocalAndNLabel_thenOpReturnLocal() {
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
    assertNull(((Local) op).debugName);
    assertNull(((Local) op).signature);
    assertEquals(0, ((Local) op)._ls_index);
    assertEquals(VT.LOCAL, ((Local) op).vt);
  }

  /**
   * Test {@link IfStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Given nIf nNull and nLabel.
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link IfStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; given nIf nNull and nLabel; then Op return Constant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt IfStmt.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_givenNIfNNullAndNLabel_thenOpReturnConstant() {
    // Arrange
    Constant a = Exprs.nNull();
    IfStmt nIfResult = Stmts.nIf(a, Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nIfResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof IfStmt);
    assertEquals(VT.CONSTANT, ((Constant) op).vt);
    assertSame(a.value, ((Constant) op).value);
  }
}
