package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

class TableSwitchStmtDiffblueTest {
  /**
   * Test {@link TableSwitchStmt#TableSwitchStmt()}.
   *
   * <p>Method under test: {@link TableSwitchStmt#TableSwitchStmt()}
   */
  @Test
  @DisplayName("Test new TableSwitchStmt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.stmt.TableSwitchStmt.<init>()"})
  void testNewTableSwitchStmt() {
    // Arrange and Act
    TableSwitchStmt actualTableSwitchStmt = new TableSwitchStmt();

    // Assert
    assertNull(actualTableSwitchStmt.getOps());
    assertNull(actualTableSwitchStmt.targets);
    assertNull(actualTableSwitchStmt.frame);
    assertNull(actualTableSwitchStmt.exceptionHandlers);
    assertNull(actualTableSwitchStmt._cfg_froms);
    assertNull(actualTableSwitchStmt.getOp1());
    assertNull(actualTableSwitchStmt.getOp2());
    assertNull(actualTableSwitchStmt.getOp());
    assertNull(actualTableSwitchStmt.defaultTarget);
    assertNull(actualTableSwitchStmt.getNext());
    assertNull(actualTableSwitchStmt.getPre());
    assertNull(actualTableSwitchStmt._ts_default_next);
    assertNull(actualTableSwitchStmt.list);
    assertEquals(0, actualTableSwitchStmt.id);
    assertEquals(0, actualTableSwitchStmt.lowIndex);
    assertEquals(ET.E1, actualTableSwitchStmt.et);
    assertEquals(ST.TABLE_SWITCH, actualTableSwitchStmt.st);
    assertFalse(actualTableSwitchStmt.visited);
  }

  /**
   * Test {@link TableSwitchStmt#TableSwitchStmt(Value, int, LabelStmt[], LabelStmt)}.
   *
   * <p>Method under test: {@link TableSwitchStmt#TableSwitchStmt(Value, int, LabelStmt[],
   * LabelStmt)}
   */
  @Test
  @DisplayName("Test new TableSwitchStmt(Value, int, LabelStmt[], LabelStmt)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.stmt.TableSwitchStmt.<init>(proguard.dexfile.ir.expr.Value, int, proguard.dexfile.ir.stmt.LabelStmt[], proguard.dexfile.ir.stmt.LabelStmt)"
  })
  void testNewTableSwitchStmt2() {
    // Arrange
    ArrayExpr key = new ArrayExpr();

    // Act
    TableSwitchStmt actualTableSwitchStmt =
        new TableSwitchStmt(key, 1, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel());

    // Assert
    Value op = actualTableSwitchStmt.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertNull(actualTableSwitchStmt.getOps());
    assertNull(actualTableSwitchStmt.frame);
    assertNull(actualTableSwitchStmt.exceptionHandlers);
    assertNull(actualTableSwitchStmt._cfg_froms);
    assertNull(actualTableSwitchStmt.getOp1());
    assertNull(actualTableSwitchStmt.getOp2());
    assertNull(actualTableSwitchStmt.getNext());
    assertNull(actualTableSwitchStmt.getPre());
    assertNull(actualTableSwitchStmt._ts_default_next);
    assertNull(actualTableSwitchStmt.list);
    assertEquals(0, actualTableSwitchStmt.id);
    assertEquals(1, actualTableSwitchStmt.targets.length);
    assertEquals(1, actualTableSwitchStmt.lowIndex);
    assertEquals(ET.E1, actualTableSwitchStmt.et);
    assertEquals(ST.TABLE_SWITCH, actualTableSwitchStmt.st);
    assertFalse(actualTableSwitchStmt.visited);
    assertSame(key, op);
  }

  /**
   * Test {@link TableSwitchStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.Stmt proguard.dexfile.ir.stmt.TableSwitchStmt.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenOpReturnConstant() {
    // Arrange
    Constant key = Exprs.nNull();
    TableSwitchStmt nTableSwitchResult =
        Stmts.nTableSwitch(key, 1, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nTableSwitchResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof TableSwitchStmt);
    assertEquals(VT.CONSTANT, ((Constant) op).vt);
    assertSame(key.value, ((Constant) op).value);
  }

  /**
   * Test {@link TableSwitchStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link Local}.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op return Local")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.Stmt proguard.dexfile.ir.stmt.TableSwitchStmt.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenOpReturnLocal() {
    // Arrange
    Local key = new Local();
    TableSwitchStmt nTableSwitchResult =
        Stmts.nTableSwitch(key, 1, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nTableSwitchResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Local);
    assertTrue(actualCloneResult instanceof TableSwitchStmt);
    assertEquals("a0", ((Local) op).toString0());
    assertNull(((Local) op).debugName);
    assertNull(((Local) op).signature);
    assertEquals(0, ((Local) op)._ls_index);
    assertEquals(VT.LOCAL, ((Local) op).vt);
  }

  /**
   * Test {@link TableSwitchStmt#toString()}.
   *
   * <ul>
   *   <li>Then calls {@link Value#trim()}.
   * </ul>
   *
   * <p>Method under test: {@link TableSwitchStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then calls trim()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.TableSwitchStmt.toString()"})
  void testToString_thenCallsTrim() {
    // Arrange
    ArrayExpr op1 = mock(ArrayExpr.class);
    when(op1.trim()).thenReturn(new ArrayExpr());

    ArrayExpr op = new ArrayExpr();
    op.setOp1(op1);
    ArrayExpr key = new ArrayExpr();
    TableSwitchStmt nTableSwitchResult =
        Stmts.nTableSwitch(key, 1, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel());
    nTableSwitchResult.setOp(op);

    // Act
    nTableSwitchResult.toString();

    // Assert
    verify(op1).trim();
  }
}
