package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.stmt.Stmt.ST;

class StmtsDiffblueTest {
  /**
   * Test {@link Stmts#nAssign(Value, Value)}.
   *
   * <p>Method under test: {@link Stmts#nAssign(Value, Value)}
   */
  @Test
  @DisplayName("Test nAssign(Value, Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.AssignStmt proguard.dexfile.ir.stmt.Stmts.nAssign(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.expr.Value)"
  })
  void testNAssign() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    ArrayExpr right = new ArrayExpr();

    // Act
    AssignStmt actualNAssignResult = Stmts.nAssign(left, right);

    // Assert
    Value op1 = actualNAssignResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNAssignResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualNAssignResult.getOps());
    assertNull(actualNAssignResult.frame);
    assertNull(actualNAssignResult.exceptionHandlers);
    assertNull(actualNAssignResult._cfg_froms);
    assertNull(actualNAssignResult.getOp());
    assertNull(actualNAssignResult.getNext());
    assertNull(actualNAssignResult.getPre());
    assertNull(actualNAssignResult._ts_default_next);
    assertNull(actualNAssignResult.list);
    assertEquals(0, actualNAssignResult.id);
    assertEquals(ET.E2, actualNAssignResult.et);
    assertEquals(ST.ASSIGN, actualNAssignResult.st);
    assertFalse(actualNAssignResult.visited);
    assertSame(left, op1);
    assertSame(right, op2);
  }

  /**
   * Test {@link Stmts#nFillArrayData(Value, Value)}.
   *
   * <p>Method under test: {@link Stmts#nFillArrayData(Value, Value)}
   */
  @Test
  @DisplayName("Test nFillArrayData(Value, Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.AssignStmt proguard.dexfile.ir.stmt.Stmts.nFillArrayData(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.expr.Value)"
  })
  void testNFillArrayData() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    ArrayExpr arrayData = new ArrayExpr();

    // Act
    AssignStmt actualNFillArrayDataResult = Stmts.nFillArrayData(left, arrayData);

    // Assert
    Value op1 = actualNFillArrayDataResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNFillArrayDataResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualNFillArrayDataResult.getOps());
    assertNull(actualNFillArrayDataResult.frame);
    assertNull(actualNFillArrayDataResult.exceptionHandlers);
    assertNull(actualNFillArrayDataResult._cfg_froms);
    assertNull(actualNFillArrayDataResult.getOp());
    assertNull(actualNFillArrayDataResult.getNext());
    assertNull(actualNFillArrayDataResult.getPre());
    assertNull(actualNFillArrayDataResult._ts_default_next);
    assertNull(actualNFillArrayDataResult.list);
    assertEquals(0, actualNFillArrayDataResult.id);
    assertEquals(ET.E2, actualNFillArrayDataResult.et);
    assertEquals(ST.FILL_ARRAY_DATA, actualNFillArrayDataResult.st);
    assertFalse(actualNFillArrayDataResult.visited);
    assertSame(left, op1);
    assertSame(arrayData, op2);
  }

  /**
   * Test {@link Stmts#nGoto(LabelStmt)}.
   *
   * <p>Method under test: {@link Stmts#nGoto(LabelStmt)}
   */
  @Test
  @DisplayName("Test nGoto(LabelStmt)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.GotoStmt proguard.dexfile.ir.stmt.Stmts.nGoto(proguard.dexfile.ir.stmt.LabelStmt)"
  })
  void testNGoto() {
    // Arrange
    LabelStmt target = Stmts.nLabel();

    // Act
    GotoStmt actualNGotoResult = Stmts.nGoto(target);

    // Assert
    assertNull(actualNGotoResult.getOps());
    assertNull(actualNGotoResult.frame);
    assertNull(actualNGotoResult.exceptionHandlers);
    assertNull(actualNGotoResult._cfg_froms);
    assertNull(actualNGotoResult.getOp());
    assertNull(actualNGotoResult.getOp1());
    assertNull(actualNGotoResult.getOp2());
    assertNull(actualNGotoResult.getNext());
    assertNull(actualNGotoResult.getPre());
    assertNull(actualNGotoResult._ts_default_next);
    assertNull(actualNGotoResult.list);
    assertEquals(0, actualNGotoResult.id);
    assertEquals(ET.E0, actualNGotoResult.et);
    assertEquals(ST.GOTO, actualNGotoResult.st);
    assertFalse(actualNGotoResult.visited);
    assertSame(target, actualNGotoResult.getTarget());
  }

  /**
   * Test {@link Stmts#nIdentity(Value, Value)}.
   *
   * <p>Method under test: {@link Stmts#nIdentity(Value, Value)}
   */
  @Test
  @DisplayName("Test nIdentity(Value, Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.AssignStmt proguard.dexfile.ir.stmt.Stmts.nIdentity(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.expr.Value)"
  })
  void testNIdentity() {
    // Arrange
    ArrayExpr local = new ArrayExpr();
    ArrayExpr identityRef = new ArrayExpr();

    // Act
    AssignStmt actualNIdentityResult = Stmts.nIdentity(local, identityRef);

    // Assert
    Value op1 = actualNIdentityResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNIdentityResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualNIdentityResult.getOps());
    assertNull(actualNIdentityResult.frame);
    assertNull(actualNIdentityResult.exceptionHandlers);
    assertNull(actualNIdentityResult._cfg_froms);
    assertNull(actualNIdentityResult.getOp());
    assertNull(actualNIdentityResult.getNext());
    assertNull(actualNIdentityResult.getPre());
    assertNull(actualNIdentityResult._ts_default_next);
    assertNull(actualNIdentityResult.list);
    assertEquals(0, actualNIdentityResult.id);
    assertEquals(ET.E2, actualNIdentityResult.et);
    assertEquals(ST.IDENTITY, actualNIdentityResult.st);
    assertFalse(actualNIdentityResult.visited);
    assertSame(local, op1);
    assertSame(identityRef, op2);
  }

  /**
   * Test {@link Stmts#nIf(Value, LabelStmt)}.
   *
   * <p>Method under test: {@link Stmts#nIf(Value, LabelStmt)}
   */
  @Test
  @DisplayName("Test nIf(Value, LabelStmt)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.IfStmt proguard.dexfile.ir.stmt.Stmts.nIf(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.stmt.LabelStmt)"
  })
  void testNIf() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    LabelStmt target = Stmts.nLabel();

    // Act
    IfStmt actualNIfResult = Stmts.nIf(a, target);

    // Assert
    Value op = actualNIfResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertNull(actualNIfResult.getOps());
    assertNull(actualNIfResult.frame);
    assertNull(actualNIfResult.exceptionHandlers);
    assertNull(actualNIfResult._cfg_froms);
    assertNull(actualNIfResult.getOp1());
    assertNull(actualNIfResult.getOp2());
    assertNull(actualNIfResult.getNext());
    assertNull(actualNIfResult.getPre());
    assertNull(actualNIfResult._ts_default_next);
    assertNull(actualNIfResult.list);
    assertEquals(0, actualNIfResult.id);
    assertEquals(ET.E1, actualNIfResult.et);
    assertEquals(ST.IF, actualNIfResult.st);
    assertFalse(actualNIfResult.visited);
    assertSame(a, op);
    assertSame(target, actualNIfResult.getTarget());
  }

  /**
   * Test {@link Stmts#nLabel()}.
   *
   * <p>Method under test: {@link Stmts#nLabel()}
   */
  @Test
  @DisplayName("Test nLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.stmt.LabelStmt proguard.dexfile.ir.stmt.Stmts.nLabel()"})
  void testNLabel() {
    // Arrange and Act
    LabelStmt actualNLabelResult = Stmts.nLabel();

    // Assert
    assertNull(actualNLabelResult.getOps());
    assertNull(actualNLabelResult.tag);
    assertNull(actualNLabelResult.frame);
    assertNull(actualNLabelResult.displayName);
    assertNull(actualNLabelResult.phis);
    assertNull(actualNLabelResult.exceptionHandlers);
    assertNull(actualNLabelResult._cfg_froms);
    assertNull(actualNLabelResult.getOp());
    assertNull(actualNLabelResult.getOp1());
    assertNull(actualNLabelResult.getOp2());
    assertNull(actualNLabelResult.getNext());
    assertNull(actualNLabelResult.getPre());
    assertNull(actualNLabelResult._ts_default_next);
    assertNull(actualNLabelResult.list);
    assertEquals(-1, actualNLabelResult.lineNumber);
    assertEquals(0, actualNLabelResult.id);
    assertEquals(ET.E0, actualNLabelResult.et);
    assertEquals(ST.LABEL, actualNLabelResult.st);
    assertFalse(actualNLabelResult.visited);
  }

  /**
   * Test {@link Stmts#nLock(Value)}.
   *
   * <p>Method under test: {@link Stmts#nLock(Value)}
   */
  @Test
  @DisplayName("Test nLock(Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.UnopStmt proguard.dexfile.ir.stmt.Stmts.nLock(proguard.dexfile.ir.expr.Value)"
  })
  void testNLock() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    UnopStmt actualNLockResult = Stmts.nLock(op);

    // Assert
    Value op2 = actualNLockResult.getOp();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualNLockResult.getOps());
    assertNull(actualNLockResult.frame);
    assertNull(actualNLockResult.exceptionHandlers);
    assertNull(actualNLockResult._cfg_froms);
    assertNull(actualNLockResult.getOp1());
    assertNull(actualNLockResult.getOp2());
    assertNull(actualNLockResult.getNext());
    assertNull(actualNLockResult.getPre());
    assertNull(actualNLockResult._ts_default_next);
    assertNull(actualNLockResult.list);
    assertEquals(0, actualNLockResult.id);
    assertEquals(ET.E1, actualNLockResult.et);
    assertEquals(ST.LOCK, actualNLockResult.st);
    assertFalse(actualNLockResult.visited);
    assertSame(op, op2);
  }

  /**
   * Test {@link Stmts#nLookupSwitch(Value, int[], LabelStmt[], LabelStmt)}.
   *
   * <p>Method under test: {@link Stmts#nLookupSwitch(Value, int[], LabelStmt[], LabelStmt)}
   */
  @Test
  @DisplayName("Test nLookupSwitch(Value, int[], LabelStmt[], LabelStmt)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.LookupSwitchStmt proguard.dexfile.ir.stmt.Stmts.nLookupSwitch(proguard.dexfile.ir.expr.Value, int[], proguard.dexfile.ir.stmt.LabelStmt[], proguard.dexfile.ir.stmt.LabelStmt)"
  })
  void testNLookupSwitch() {
    // Arrange
    ArrayExpr key = new ArrayExpr();

    // Act
    LookupSwitchStmt actualNLookupSwitchResult =
        Stmts.nLookupSwitch(
            key, new int[] {42, 1, 42, 1}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel());

    // Assert
    Value op = actualNLookupSwitchResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertNull(actualNLookupSwitchResult.getOps());
    assertNull(actualNLookupSwitchResult.frame);
    assertNull(actualNLookupSwitchResult.exceptionHandlers);
    assertNull(actualNLookupSwitchResult._cfg_froms);
    assertNull(actualNLookupSwitchResult.getOp1());
    assertNull(actualNLookupSwitchResult.getOp2());
    assertNull(actualNLookupSwitchResult.getNext());
    assertNull(actualNLookupSwitchResult.getPre());
    assertNull(actualNLookupSwitchResult._ts_default_next);
    assertNull(actualNLookupSwitchResult.list);
    assertEquals(0, actualNLookupSwitchResult.id);
    assertEquals(1, actualNLookupSwitchResult.targets.length);
    assertEquals(ET.E1, actualNLookupSwitchResult.et);
    assertEquals(ST.LOOKUP_SWITCH, actualNLookupSwitchResult.st);
    assertFalse(actualNLookupSwitchResult.visited);
    assertSame(key, op);
    assertArrayEquals(new int[] {42, 1, 42, 1}, actualNLookupSwitchResult.lookupValues);
  }

  /**
   * Test {@link Stmts#nNop()}.
   *
   * <p>Method under test: {@link Stmts#nNop()}
   */
  @Test
  @DisplayName("Test nNop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.stmt.NopStmt proguard.dexfile.ir.stmt.Stmts.nNop()"})
  void testNNop() {
    // Arrange and Act
    NopStmt actualNNopResult = Stmts.nNop();

    // Assert
    assertNull(actualNNopResult.getOps());
    assertNull(actualNNopResult.frame);
    assertNull(actualNNopResult.exceptionHandlers);
    assertNull(actualNNopResult._cfg_froms);
    assertNull(actualNNopResult.getOp());
    assertNull(actualNNopResult.getOp1());
    assertNull(actualNNopResult.getOp2());
    assertNull(actualNNopResult.getNext());
    assertNull(actualNNopResult.getPre());
    assertNull(actualNNopResult._ts_default_next);
    assertNull(actualNNopResult.list);
    assertEquals(0, actualNNopResult.id);
    assertEquals(ET.E0, actualNNopResult.et);
    assertEquals(ST.NOP, actualNNopResult.st);
    assertFalse(actualNNopResult.visited);
  }

  /**
   * Test {@link Stmts#nReturn(Value)}.
   *
   * <p>Method under test: {@link Stmts#nReturn(Value)}
   */
  @Test
  @DisplayName("Test nReturn(Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.UnopStmt proguard.dexfile.ir.stmt.Stmts.nReturn(proguard.dexfile.ir.expr.Value)"
  })
  void testNReturn() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    UnopStmt actualNReturnResult = Stmts.nReturn(op);

    // Assert
    Value op2 = actualNReturnResult.getOp();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualNReturnResult.getOps());
    assertNull(actualNReturnResult.frame);
    assertNull(actualNReturnResult.exceptionHandlers);
    assertNull(actualNReturnResult._cfg_froms);
    assertNull(actualNReturnResult.getOp1());
    assertNull(actualNReturnResult.getOp2());
    assertNull(actualNReturnResult.getNext());
    assertNull(actualNReturnResult.getPre());
    assertNull(actualNReturnResult._ts_default_next);
    assertNull(actualNReturnResult.list);
    assertEquals(0, actualNReturnResult.id);
    assertEquals(ET.E1, actualNReturnResult.et);
    assertEquals(ST.RETURN, actualNReturnResult.st);
    assertFalse(actualNReturnResult.visited);
    assertSame(op, op2);
  }

  /**
   * Test {@link Stmts#nReturnVoid()}.
   *
   * <p>Method under test: {@link Stmts#nReturnVoid()}
   */
  @Test
  @DisplayName("Test nReturnVoid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.ReturnVoidStmt proguard.dexfile.ir.stmt.Stmts.nReturnVoid()"
  })
  void testNReturnVoid() {
    // Arrange and Act
    ReturnVoidStmt actualNReturnVoidResult = Stmts.nReturnVoid();

    // Assert
    assertNull(actualNReturnVoidResult.getOps());
    assertNull(actualNReturnVoidResult.frame);
    assertNull(actualNReturnVoidResult.exceptionHandlers);
    assertNull(actualNReturnVoidResult._cfg_froms);
    assertNull(actualNReturnVoidResult.getOp());
    assertNull(actualNReturnVoidResult.getOp1());
    assertNull(actualNReturnVoidResult.getOp2());
    assertNull(actualNReturnVoidResult.getNext());
    assertNull(actualNReturnVoidResult.getPre());
    assertNull(actualNReturnVoidResult._ts_default_next);
    assertNull(actualNReturnVoidResult.list);
    assertEquals(0, actualNReturnVoidResult.id);
    assertEquals(ET.E0, actualNReturnVoidResult.et);
    assertEquals(ST.RETURN_VOID, actualNReturnVoidResult.st);
    assertFalse(actualNReturnVoidResult.visited);
  }

  /**
   * Test {@link Stmts#nTableSwitch(Value, int, LabelStmt[], LabelStmt)}.
   *
   * <p>Method under test: {@link Stmts#nTableSwitch(Value, int, LabelStmt[], LabelStmt)}
   */
  @Test
  @DisplayName("Test nTableSwitch(Value, int, LabelStmt[], LabelStmt)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.TableSwitchStmt proguard.dexfile.ir.stmt.Stmts.nTableSwitch(proguard.dexfile.ir.expr.Value, int, proguard.dexfile.ir.stmt.LabelStmt[], proguard.dexfile.ir.stmt.LabelStmt)"
  })
  void testNTableSwitch() {
    // Arrange
    ArrayExpr key = new ArrayExpr();

    // Act
    TableSwitchStmt actualNTableSwitchResult =
        Stmts.nTableSwitch(key, 1, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel());

    // Assert
    Value op = actualNTableSwitchResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertNull(actualNTableSwitchResult.getOps());
    assertNull(actualNTableSwitchResult.frame);
    assertNull(actualNTableSwitchResult.exceptionHandlers);
    assertNull(actualNTableSwitchResult._cfg_froms);
    assertNull(actualNTableSwitchResult.getOp1());
    assertNull(actualNTableSwitchResult.getOp2());
    assertNull(actualNTableSwitchResult.getNext());
    assertNull(actualNTableSwitchResult.getPre());
    assertNull(actualNTableSwitchResult._ts_default_next);
    assertNull(actualNTableSwitchResult.list);
    assertEquals(0, actualNTableSwitchResult.id);
    assertEquals(1, actualNTableSwitchResult.targets.length);
    assertEquals(1, actualNTableSwitchResult.lowIndex);
    assertEquals(ET.E1, actualNTableSwitchResult.et);
    assertEquals(ST.TABLE_SWITCH, actualNTableSwitchResult.st);
    assertFalse(actualNTableSwitchResult.visited);
    assertSame(key, op);
  }

  /**
   * Test {@link Stmts#nThrow(Value)}.
   *
   * <p>Method under test: {@link Stmts#nThrow(Value)}
   */
  @Test
  @DisplayName("Test nThrow(Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.UnopStmt proguard.dexfile.ir.stmt.Stmts.nThrow(proguard.dexfile.ir.expr.Value)"
  })
  void testNThrow() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    UnopStmt actualNThrowResult = Stmts.nThrow(op);

    // Assert
    Value op2 = actualNThrowResult.getOp();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualNThrowResult.getOps());
    assertNull(actualNThrowResult.frame);
    assertNull(actualNThrowResult.exceptionHandlers);
    assertNull(actualNThrowResult._cfg_froms);
    assertNull(actualNThrowResult.getOp1());
    assertNull(actualNThrowResult.getOp2());
    assertNull(actualNThrowResult.getNext());
    assertNull(actualNThrowResult.getPre());
    assertNull(actualNThrowResult._ts_default_next);
    assertNull(actualNThrowResult.list);
    assertEquals(0, actualNThrowResult.id);
    assertEquals(ET.E1, actualNThrowResult.et);
    assertEquals(ST.THROW, actualNThrowResult.st);
    assertFalse(actualNThrowResult.visited);
    assertSame(op, op2);
  }

  /**
   * Test {@link Stmts#nUnLock(Value)}.
   *
   * <p>Method under test: {@link Stmts#nUnLock(Value)}
   */
  @Test
  @DisplayName("Test nUnLock(Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.UnopStmt proguard.dexfile.ir.stmt.Stmts.nUnLock(proguard.dexfile.ir.expr.Value)"
  })
  void testNUnLock() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    UnopStmt actualNUnLockResult = Stmts.nUnLock(op);

    // Assert
    Value op2 = actualNUnLockResult.getOp();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualNUnLockResult.getOps());
    assertNull(actualNUnLockResult.frame);
    assertNull(actualNUnLockResult.exceptionHandlers);
    assertNull(actualNUnLockResult._cfg_froms);
    assertNull(actualNUnLockResult.getOp1());
    assertNull(actualNUnLockResult.getOp2());
    assertNull(actualNUnLockResult.getNext());
    assertNull(actualNUnLockResult.getPre());
    assertNull(actualNUnLockResult._ts_default_next);
    assertNull(actualNUnLockResult.list);
    assertEquals(0, actualNUnLockResult.id);
    assertEquals(ET.E1, actualNUnLockResult.et);
    assertEquals(ST.UNLOCK, actualNUnLockResult.st);
    assertFalse(actualNUnLockResult.visited);
    assertSame(op, op2);
  }

  /**
   * Test {@link Stmts#nVoidInvoke(Value)}.
   *
   * <p>Method under test: {@link Stmts#nVoidInvoke(Value)}
   */
  @Test
  @DisplayName("Test nVoidInvoke(Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.VoidInvokeStmt proguard.dexfile.ir.stmt.Stmts.nVoidInvoke(proguard.dexfile.ir.expr.Value)"
  })
  void testNVoidInvoke() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    VoidInvokeStmt actualNVoidInvokeResult = Stmts.nVoidInvoke(op);

    // Assert
    Value op2 = actualNVoidInvokeResult.getOp();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualNVoidInvokeResult.getOps());
    assertNull(actualNVoidInvokeResult.frame);
    assertNull(actualNVoidInvokeResult.exceptionHandlers);
    assertNull(actualNVoidInvokeResult._cfg_froms);
    assertNull(actualNVoidInvokeResult.getOp1());
    assertNull(actualNVoidInvokeResult.getOp2());
    assertNull(actualNVoidInvokeResult.getNext());
    assertNull(actualNVoidInvokeResult.getPre());
    assertNull(actualNVoidInvokeResult._ts_default_next);
    assertNull(actualNVoidInvokeResult.list);
    assertEquals(0, actualNVoidInvokeResult.id);
    assertEquals(ET.E1, actualNVoidInvokeResult.et);
    assertEquals(ST.VOID_INVOKE, actualNVoidInvokeResult.st);
    assertFalse(actualNVoidInvokeResult.visited);
    assertSame(op, op2);
  }
}
