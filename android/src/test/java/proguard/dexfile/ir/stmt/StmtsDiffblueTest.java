package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Value;

public class StmtsDiffblueTest {
  /**
   * Method under test: {@link Stmts#nAssign(Value, Value)}
   */
  @Test
  public void testNAssign() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    ArrayExpr right = new ArrayExpr();

    // Act
    AssignStmt actualNAssignResult = Stmts.nAssign(left, right);

    // Assert
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
    assertEquals(Stmt.ST.ASSIGN, actualNAssignResult.st);
    assertFalse(actualNAssignResult.visited);
    assertSame(left, actualNAssignResult.getOp1());
    assertSame(right, actualNAssignResult.getOp2());
  }

  /**
   * Method under test: {@link Stmts#nFillArrayData(Value, Value)}
   */
  @Test
  public void testNFillArrayData() {
    // Arrange
    ArrayExpr left = new ArrayExpr();
    ArrayExpr arrayData = new ArrayExpr();

    // Act
    AssignStmt actualNFillArrayDataResult = Stmts.nFillArrayData(left, arrayData);

    // Assert
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
    assertEquals(Stmt.ST.FILL_ARRAY_DATA, actualNFillArrayDataResult.st);
    assertFalse(actualNFillArrayDataResult.visited);
    assertSame(left, actualNFillArrayDataResult.getOp1());
    assertSame(arrayData, actualNFillArrayDataResult.getOp2());
  }

  /**
   * Method under test: {@link Stmts#nGoto(LabelStmt)}
   */
  @Test
  public void testNGoto() {
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
    assertEquals(Stmt.ST.GOTO, actualNGotoResult.st);
    assertFalse(actualNGotoResult.visited);
    assertSame(target, actualNGotoResult.getTarget());
  }

  /**
   * Method under test: {@link Stmts#nIdentity(Value, Value)}
   */
  @Test
  public void testNIdentity() {
    // Arrange
    ArrayExpr local = new ArrayExpr();
    ArrayExpr identityRef = new ArrayExpr();

    // Act
    AssignStmt actualNIdentityResult = Stmts.nIdentity(local, identityRef);

    // Assert
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
    assertEquals(Stmt.ST.IDENTITY, actualNIdentityResult.st);
    assertFalse(actualNIdentityResult.visited);
    assertSame(local, actualNIdentityResult.getOp1());
    assertSame(identityRef, actualNIdentityResult.getOp2());
  }

  /**
   * Method under test: {@link Stmts#nIf(Value, LabelStmt)}
   */
  @Test
  public void testNIf() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    LabelStmt target = Stmts.nLabel();

    // Act
    IfStmt actualNIfResult = Stmts.nIf(a, target);

    // Assert
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
    assertEquals(Stmt.ST.IF, actualNIfResult.st);
    assertFalse(actualNIfResult.visited);
    assertSame(a, actualNIfResult.getOp());
    assertSame(target, actualNIfResult.getTarget());
  }

  /**
   * Method under test: {@link Stmts#nLabel()}
   */
  @Test
  public void testNLabel() {
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
    assertEquals(Stmt.ST.LABEL, actualNLabelResult.st);
    assertFalse(actualNLabelResult.visited);
  }

  /**
   * Method under test: {@link Stmts#nLock(Value)}
   */
  @Test
  public void testNLock() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    UnopStmt actualNLockResult = Stmts.nLock(op);

    // Assert
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
    assertEquals(Stmt.ST.LOCK, actualNLockResult.st);
    assertFalse(actualNLockResult.visited);
    assertSame(op, actualNLockResult.getOp());
  }

  /**
   * Method under test:
   * {@link Stmts#nLookupSwitch(Value, int[], LabelStmt[], LabelStmt)}
   */
  @Test
  public void testNLookupSwitch() {
    // Arrange
    ArrayExpr key = new ArrayExpr();
    LabelStmt nLabelResult = Stmts.nLabel();

    // Act
    LookupSwitchStmt actualNLookupSwitchResult = Stmts.nLookupSwitch(key, new int[]{42, 1, 42, 1},
        new LabelStmt[]{nLabelResult}, Stmts.nLabel());

    // Assert
    assertNull(actualNLookupSwitchResult.getOps());
    LabelStmt labelStmt = actualNLookupSwitchResult.defaultTarget;
    assertNull(labelStmt.getOps());
    assertNull(labelStmt.tag);
    assertNull(actualNLookupSwitchResult.frame);
    assertNull(labelStmt.frame);
    assertNull(labelStmt.displayName);
    assertNull(labelStmt.phis);
    assertNull(actualNLookupSwitchResult.exceptionHandlers);
    assertNull(labelStmt.exceptionHandlers);
    assertNull(actualNLookupSwitchResult._cfg_froms);
    assertNull(labelStmt._cfg_froms);
    assertNull(labelStmt.getOp());
    assertNull(actualNLookupSwitchResult.getOp1());
    assertNull(labelStmt.getOp1());
    assertNull(actualNLookupSwitchResult.getOp2());
    assertNull(labelStmt.getOp2());
    assertNull(actualNLookupSwitchResult.getNext());
    assertNull(labelStmt.getNext());
    assertNull(actualNLookupSwitchResult.getPre());
    assertNull(labelStmt.getPre());
    assertNull(actualNLookupSwitchResult._ts_default_next);
    assertNull(labelStmt._ts_default_next);
    assertNull(actualNLookupSwitchResult.list);
    assertNull(labelStmt.list);
    assertEquals(-1, labelStmt.lineNumber);
    assertEquals(0, actualNLookupSwitchResult.id);
    assertEquals(0, labelStmt.id);
    LabelStmt[] labelStmtArray = actualNLookupSwitchResult.targets;
    assertEquals(1, labelStmtArray.length);
    assertEquals(ET.E0, labelStmt.et);
    assertEquals(ET.E1, actualNLookupSwitchResult.et);
    assertEquals(Stmt.ST.LABEL, labelStmt.st);
    assertEquals(Stmt.ST.LOOKUP_SWITCH, actualNLookupSwitchResult.st);
    assertFalse(actualNLookupSwitchResult.visited);
    assertFalse(labelStmt.visited);
    assertSame(key, actualNLookupSwitchResult.getOp());
    assertSame(nLabelResult, labelStmtArray[0]);
    assertArrayEquals(new int[]{42, 1, 42, 1}, actualNLookupSwitchResult.lookupValues);
  }

  /**
   * Method under test: {@link Stmts#nNop()}
   */
  @Test
  public void testNNop() {
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
    assertEquals(Stmt.ST.NOP, actualNNopResult.st);
    assertFalse(actualNNopResult.visited);
  }

  /**
   * Method under test: {@link Stmts#nReturn(Value)}
   */
  @Test
  public void testNReturn() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    UnopStmt actualNReturnResult = Stmts.nReturn(op);

    // Assert
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
    assertEquals(Stmt.ST.RETURN, actualNReturnResult.st);
    assertFalse(actualNReturnResult.visited);
    assertSame(op, actualNReturnResult.getOp());
  }

  /**
   * Method under test: {@link Stmts#nReturnVoid()}
   */
  @Test
  public void testNReturnVoid() {
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
    assertEquals(Stmt.ST.RETURN_VOID, actualNReturnVoidResult.st);
    assertFalse(actualNReturnVoidResult.visited);
  }

  /**
   * Method under test:
   * {@link Stmts#nTableSwitch(Value, int, LabelStmt[], LabelStmt)}
   */
  @Test
  public void testNTableSwitch() {
    // Arrange
    ArrayExpr key = new ArrayExpr();
    LabelStmt nLabelResult = Stmts.nLabel();

    // Act
    TableSwitchStmt actualNTableSwitchResult = Stmts.nTableSwitch(key, 1, new LabelStmt[]{nLabelResult},
        Stmts.nLabel());

    // Assert
    assertNull(actualNTableSwitchResult.getOps());
    LabelStmt labelStmt = actualNTableSwitchResult.defaultTarget;
    assertNull(labelStmt.getOps());
    assertNull(labelStmt.tag);
    assertNull(actualNTableSwitchResult.frame);
    assertNull(labelStmt.frame);
    assertNull(labelStmt.displayName);
    assertNull(labelStmt.phis);
    assertNull(actualNTableSwitchResult.exceptionHandlers);
    assertNull(labelStmt.exceptionHandlers);
    assertNull(actualNTableSwitchResult._cfg_froms);
    assertNull(labelStmt._cfg_froms);
    assertNull(labelStmt.getOp());
    assertNull(actualNTableSwitchResult.getOp1());
    assertNull(labelStmt.getOp1());
    assertNull(actualNTableSwitchResult.getOp2());
    assertNull(labelStmt.getOp2());
    assertNull(actualNTableSwitchResult.getNext());
    assertNull(labelStmt.getNext());
    assertNull(actualNTableSwitchResult.getPre());
    assertNull(labelStmt.getPre());
    assertNull(actualNTableSwitchResult._ts_default_next);
    assertNull(labelStmt._ts_default_next);
    assertNull(actualNTableSwitchResult.list);
    assertNull(labelStmt.list);
    assertEquals(-1, labelStmt.lineNumber);
    assertEquals(0, actualNTableSwitchResult.id);
    assertEquals(0, labelStmt.id);
    LabelStmt[] labelStmtArray = actualNTableSwitchResult.targets;
    assertEquals(1, labelStmtArray.length);
    assertEquals(1, actualNTableSwitchResult.lowIndex);
    assertEquals(ET.E0, labelStmt.et);
    assertEquals(ET.E1, actualNTableSwitchResult.et);
    assertEquals(Stmt.ST.LABEL, labelStmt.st);
    assertEquals(Stmt.ST.TABLE_SWITCH, actualNTableSwitchResult.st);
    assertFalse(actualNTableSwitchResult.visited);
    assertFalse(labelStmt.visited);
    assertSame(key, actualNTableSwitchResult.getOp());
    assertSame(nLabelResult, labelStmtArray[0]);
  }

  /**
   * Method under test: {@link Stmts#nThrow(Value)}
   */
  @Test
  public void testNThrow() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    UnopStmt actualNThrowResult = Stmts.nThrow(op);

    // Assert
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
    assertEquals(Stmt.ST.THROW, actualNThrowResult.st);
    assertFalse(actualNThrowResult.visited);
    assertSame(op, actualNThrowResult.getOp());
  }

  /**
   * Method under test: {@link Stmts#nUnLock(Value)}
   */
  @Test
  public void testNUnLock() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    UnopStmt actualNUnLockResult = Stmts.nUnLock(op);

    // Assert
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
    assertEquals(Stmt.ST.UNLOCK, actualNUnLockResult.st);
    assertFalse(actualNUnLockResult.visited);
    assertSame(op, actualNUnLockResult.getOp());
  }

  /**
   * Method under test: {@link Stmts#nVoidInvoke(Value)}
   */
  @Test
  public void testNVoidInvoke() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    VoidInvokeStmt actualNVoidInvokeResult = Stmts.nVoidInvoke(op);

    // Assert
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
    assertEquals(Stmt.ST.VOID_INVOKE, actualNVoidInvokeResult.st);
    assertFalse(actualNVoidInvokeResult.visited);
    assertSame(op, actualNVoidInvokeResult.getOp());
  }
}
