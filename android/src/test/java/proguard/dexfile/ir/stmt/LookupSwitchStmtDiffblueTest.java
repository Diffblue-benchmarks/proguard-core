package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

class LookupSwitchStmtDiffblueTest {
  /**
   * Test {@link LookupSwitchStmt#LookupSwitchStmt(Value, int[], LabelStmt[], LabelStmt)}.
   *
   * <p>Method under test: {@link LookupSwitchStmt#LookupSwitchStmt(Value, int[], LabelStmt[],
   * LabelStmt)}
   */
  @Test
  @DisplayName("Test new LookupSwitchStmt(Value, int[], LabelStmt[], LabelStmt)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.stmt.LookupSwitchStmt.<init>(proguard.dexfile.ir.expr.Value, int[], proguard.dexfile.ir.stmt.LabelStmt[], proguard.dexfile.ir.stmt.LabelStmt)"
  })
  void testNewLookupSwitchStmt() {
    // Arrange
    ArrayExpr key = new ArrayExpr();

    // Act
    LookupSwitchStmt actualLookupSwitchStmt =
        new LookupSwitchStmt(
            key, new int[] {42, 1, 42, 1}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel());

    // Assert
    Value op = actualLookupSwitchStmt.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertNull(actualLookupSwitchStmt.getOps());
    assertNull(actualLookupSwitchStmt.frame);
    assertNull(actualLookupSwitchStmt.exceptionHandlers);
    assertNull(actualLookupSwitchStmt._cfg_froms);
    assertNull(actualLookupSwitchStmt.getOp1());
    assertNull(actualLookupSwitchStmt.getOp2());
    assertNull(actualLookupSwitchStmt.getNext());
    assertNull(actualLookupSwitchStmt.getPre());
    assertNull(actualLookupSwitchStmt._ts_default_next);
    assertNull(actualLookupSwitchStmt.list);
    assertEquals(0, actualLookupSwitchStmt.id);
    assertEquals(1, actualLookupSwitchStmt.targets.length);
    assertEquals(ET.E1, actualLookupSwitchStmt.et);
    assertEquals(ST.LOOKUP_SWITCH, actualLookupSwitchStmt.st);
    assertFalse(actualLookupSwitchStmt.visited);
    assertSame(key, op);
    assertArrayEquals(new int[] {42, 1, 42, 1}, actualLookupSwitchStmt.lookupValues);
  }

  /**
   * Test {@link LookupSwitchStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link LookupSwitchStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.Stmt proguard.dexfile.ir.stmt.LookupSwitchStmt.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenOpReturnConstant() {
    // Arrange
    Constant key = Exprs.nNull();
    LookupSwitchStmt nLookupSwitchResult =
        Stmts.nLookupSwitch(
            key, new int[] {42, 1, 42, 1}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nLookupSwitchResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof LookupSwitchStmt);
    assertEquals(VT.CONSTANT, ((Constant) op).vt);
    assertSame(key.value, ((Constant) op).value);
    assertArrayEquals(
        new int[] {42, 1, 42, 1}, ((LookupSwitchStmt) actualCloneResult).lookupValues);
  }

  /**
   * Test {@link LookupSwitchStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link Local}.
   * </ul>
   *
   * <p>Method under test: {@link LookupSwitchStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op return Local")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.Stmt proguard.dexfile.ir.stmt.LookupSwitchStmt.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenOpReturnLocal() {
    // Arrange
    Local key = new Local();
    LookupSwitchStmt nLookupSwitchResult =
        Stmts.nLookupSwitch(
            key, new int[] {42, 1, 42, 1}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nLookupSwitchResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Local);
    assertTrue(actualCloneResult instanceof LookupSwitchStmt);
    assertEquals("a0", ((Local) op).toString0());
    assertNull(((Local) op).debugName);
    assertNull(((Local) op).signature);
    assertEquals(0, ((Local) op)._ls_index);
    assertEquals(VT.LOCAL, ((Local) op).vt);
    assertArrayEquals(
        new int[] {42, 1, 42, 1}, ((LookupSwitchStmt) actualCloneResult).lookupValues);
  }

  /**
   * Test {@link LookupSwitchStmt#toString()}.
   *
   * <ul>
   *   <li>Then calls {@link Value#trim()}.
   * </ul>
   *
   * <p>Method under test: {@link LookupSwitchStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); then calls trim()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.LookupSwitchStmt.toString()"})
  void testToString_thenCallsTrim() {
    // Arrange
    ArrayExpr key = mock(ArrayExpr.class);
    when(key.trim()).thenReturn(new ArrayExpr());

    // Act
    Stmts.nLookupSwitch(key, new int[] {}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())
        .toString();

    // Assert
    verify(key).trim();
  }
}
