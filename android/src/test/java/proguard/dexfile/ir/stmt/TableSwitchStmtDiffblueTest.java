package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.ir.stmt.Stmt.ST;

public class TableSwitchStmtDiffblueTest {
  /**
   * Test {@link TableSwitchStmt#TableSwitchStmt()}.
   *
   * <p>Method under test: {@link TableSwitchStmt#TableSwitchStmt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableSwitchStmt.<init>()"})
  public void testNewTableSwitchStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TableSwitchStmt.<init>(Value, int, LabelStmt[], LabelStmt)"})
  public void testNewTableSwitchStmt2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt TableSwitchStmt.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenOpReturnConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt TableSwitchStmt.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenOpReturnLocal() {
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
}
