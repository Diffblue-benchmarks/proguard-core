package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.BinopExpr;
import proguard.dexfile.ir.expr.CastExpr;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.FilledArrayExpr;
import proguard.dexfile.ir.expr.InvokeCustomExpr;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.GotoStmt;
import proguard.dexfile.ir.stmt.IfStmt;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.LookupSwitchStmt;
import proguard.dexfile.ir.stmt.ReturnVoidStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;
import proguard.dexfile.ir.stmt.TableSwitchStmt;
import proguard.dexfile.ir.ts.AggTransformer.ReplaceX;
import proguard.dexfile.ir.ts.Cfg.DfsVisitor;
import proguard.dexfile.ir.ts.Cfg.FrameVisitor;
import proguard.dexfile.ir.ts.Cfg.OnUseCallBack;
import proguard.dexfile.ir.ts.Cfg.TravelCallBack;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Proto;

class CfgDiffblueTest {
  /**
   * Test {@link Cfg#countLocalReads(IrMethod)}.
   *
   * <p>Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  @DisplayName("Test countLocalReads(IrMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.dexfile.ir.ts.Cfg.countLocalReads(proguard.dexfile.ir.IrMethod)"
  })
  void testCountLocalReads() {
    // Arrange
    TableSwitchStmt stmt = new TableSwitchStmt();
    stmt.setOp(new CastExpr(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org"));

    StmtList stmtList = new StmtList();
    stmtList.add(stmt);
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertArrayEquals(new int[] {}, Cfg.countLocalReads(method));
  }

  /**
   * Test {@link Cfg#countLocalReads(IrMethod)}.
   *
   * <p>Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  @DisplayName("Test countLocalReads(IrMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.dexfile.ir.ts.Cfg.countLocalReads(proguard.dexfile.ir.IrMethod)"
  })
  void testCountLocalReads2() {
    // Arrange
    TableSwitchStmt stmt = new TableSwitchStmt();
    stmt.setOp(new FilledArrayExpr(new Value[] {Exprs.nNull()}, "Type"));

    StmtList stmtList = new StmtList();
    stmtList.add(stmt);
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertArrayEquals(new int[] {}, Cfg.countLocalReads(method));
  }

  /**
   * Test {@link Cfg#countLocalReads(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Local#Local()}.
   *   <li>Then return array of {@code int} with zero.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test countLocalReads(IrMethod); given ArrayList() add Local(); then return array of int with zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.dexfile.ir.ts.Cfg.countLocalReads(proguard.dexfile.ir.IrMethod)"
  })
  void testCountLocalReads_givenArrayListAddLocal_thenReturnArrayOfIntWithZero() {
    // Arrange
    ArrayList<Local> localList = new ArrayList<>();
    localList.add(new Local());
    IrMethod method = new IrMethod();
    method.locals = localList;

    // Act and Assert
    assertArrayEquals(new int[] {0}, Cfg.countLocalReads(method));
  }

  /**
   * Test {@link Cfg#countLocalReads(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nLabel.
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test countLocalReads(IrMethod); given StmtList (default constructor) add nLabel; then return empty array of int")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.dexfile.ir.ts.Cfg.countLocalReads(proguard.dexfile.ir.IrMethod)"
  })
  void testCountLocalReads_givenStmtListAddNLabel_thenReturnEmptyArrayOfInt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertArrayEquals(new int[] {}, Cfg.countLocalReads(method));
  }

  /**
   * Test {@link Cfg#countLocalReads(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nNop.
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test countLocalReads(IrMethod); given StmtList (default constructor) add nNop; then return empty array of int")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.dexfile.ir.ts.Cfg.countLocalReads(proguard.dexfile.ir.IrMethod)"
  })
  void testCountLocalReads_givenStmtListAddNNop_thenReturnEmptyArrayOfInt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nNop());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertArrayEquals(new int[] {}, Cfg.countLocalReads(method));
  }

  /**
   * Test {@link Cfg#countLocalReads(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link TableSwitchStmt#TableSwitchStmt()} Op is nNull.
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test countLocalReads(IrMethod); given TableSwitchStmt() Op is nNull; then return empty array of int")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.dexfile.ir.ts.Cfg.countLocalReads(proguard.dexfile.ir.IrMethod)"
  })
  void testCountLocalReads_givenTableSwitchStmtOpIsNNull_thenReturnEmptyArrayOfInt() {
    // Arrange
    TableSwitchStmt stmt = new TableSwitchStmt();
    stmt.setOp(Exprs.nNull());

    StmtList stmtList = new StmtList();
    stmtList.add(stmt);
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertArrayEquals(new int[] {}, Cfg.countLocalReads(method));
  }

  /**
   * Test {@link Cfg#countLocalReads(IrMethod)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test countLocalReads(IrMethod); when IrMethod (default constructor); then return empty array of int")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int[] proguard.dexfile.ir.ts.Cfg.countLocalReads(proguard.dexfile.ir.IrMethod)"
  })
  void testCountLocalReads_whenIrMethod_thenReturnEmptyArrayOfInt() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[] {}, Cfg.countLocalReads(new IrMethod()));
  }

  /**
   * Test {@link Cfg#reIndexLocalAndLabel(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nLabel.
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First {@link
   *       LabelStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#reIndexLocalAndLabel(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test reIndexLocalAndLabel(IrMethod); given StmtList (default constructor) add nLabel; then IrMethod (default constructor) stmts First LabelStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.reIndexLocalAndLabel(proguard.dexfile.ir.IrMethod)"
  })
  void testReIndexLocalAndLabel_givenStmtListAddNLabel_thenIrMethodStmtsFirstLabelStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    Cfg.reIndexLocalAndLabel(irMethod);

    // Assert
    Stmt first = irMethod.stmts.getFirst();
    assertTrue(first instanceof LabelStmt);
    assertEquals("L0", ((LabelStmt) first).getDisplayName());
    assertEquals("L0", ((LabelStmt) first).displayName);
  }

  /**
   * Test {@link Cfg#notThrow(Stmt)}.
   *
   * <p>Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  @DisplayName("Test notThrow(Stmt)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.notThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testNotThrow() {
    // Arrange
    ArrayExpr key = new ArrayExpr();

    // Act and Assert
    assertFalse(
        Cfg.notThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#notThrow(Stmt)}.
   *
   * <p>Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  @DisplayName("Test notThrow(Stmt)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.notThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testNotThrow2() {
    // Arrange
    CastExpr key =
        new CastExpr(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act and Assert
    assertFalse(
        Cfg.notThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#notThrow(Stmt)}.
   *
   * <p>Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  @DisplayName("Test notThrow(Stmt)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.notThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testNotThrow3() {
    // Arrange
    Constant key = Exprs.nNull();

    // Act and Assert
    assertTrue(
        Cfg.notThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#notThrow(Stmt)}.
   *
   * <p>Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  @DisplayName("Test notThrow(Stmt)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.notThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testNotThrow4() {
    // Arrange
    Local key = new Local();

    // Act and Assert
    assertTrue(
        Cfg.notThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#notThrow(Stmt)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  @DisplayName("Test notThrow(Stmt); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.notThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testNotThrow_thenThrowRuntimeException() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokeCustomExpr key =
        new InvokeCustomExpr(
            VT.ADD,
            new Value[] {new ArrayExpr()},
            "Method Name",
            proto,
            new MethodHandle(8, new Field("Owner", "Name", "Type")),
            new Object[] {Constant.Null});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            Cfg.notThrow(
                new LookupSwitchStmt(
                    key,
                    new int[] {42, 8, 42, 8},
                    new LabelStmt[] {Stmts.nLabel()},
                    Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#notThrow(Stmt)}.
   *
   * <ul>
   *   <li>When {@link BinopExpr#BinopExpr(VT, Value, Value, String)} with vt is {@code ADD} and op1
   *       is {@link ArrayExpr#ArrayExpr()} and op2 is {@link ArrayExpr#ArrayExpr()} and {@code
   *       Type}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  @DisplayName(
      "Test notThrow(Stmt); when BinopExpr(VT, Value, Value, String) with vt is 'ADD' and op1 is ArrayExpr() and op2 is ArrayExpr() and 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.notThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testNotThrow_whenBinopExprWithVtIsAddAndOp1IsArrayExprAndOp2IsArrayExprAndType() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    BinopExpr key = new BinopExpr(VT.ADD, op1, new ArrayExpr(), "Type");

    // Act and Assert
    assertFalse(
        Cfg.notThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#notThrow(Stmt)}.
   *
   * <ul>
   *   <li>When {@link BinopExpr#BinopExpr(VT, Value, Value, String)} with vt is {@code ADD} and op1
   *       is nNull and op2 is {@link ArrayExpr#ArrayExpr()} and {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  @DisplayName(
      "Test notThrow(Stmt); when BinopExpr(VT, Value, Value, String) with vt is 'ADD' and op1 is nNull and op2 is ArrayExpr() and 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.notThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testNotThrow_whenBinopExprWithVtIsAddAndOp1IsNNullAndOp2IsArrayExprAndType() {
    // Arrange
    Constant op1 = Exprs.nNull();
    BinopExpr key = new BinopExpr(VT.ADD, op1, new ArrayExpr(), "Type");

    // Act and Assert
    assertFalse(
        Cfg.notThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#notThrow(Stmt)}.
   *
   * <ul>
   *   <li>When nLabel.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  @DisplayName("Test notThrow(Stmt); when nLabel; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.notThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testNotThrow_whenNLabel_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Cfg.notThrow(Stmts.nLabel()));
  }

  /**
   * Test {@link Cfg#isThrow(Stmt)} with {@code s}.
   *
   * <p>Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  @DisplayName("Test isThrow(Stmt) with 's'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.isThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testIsThrowWithS() {
    // Arrange
    ArrayExpr key = new ArrayExpr();

    // Act and Assert
    assertTrue(
        Cfg.isThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#isThrow(Stmt)} with {@code s}.
   *
   * <p>Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  @DisplayName("Test isThrow(Stmt) with 's'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.isThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testIsThrowWithS2() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    BinopExpr key = new BinopExpr(VT.ADD, op1, new ArrayExpr(), "Type");

    // Act and Assert
    assertTrue(
        Cfg.isThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#isThrow(Stmt)} with {@code s}.
   *
   * <p>Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  @DisplayName("Test isThrow(Stmt) with 's'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.isThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testIsThrowWithS3() {
    // Arrange
    CastExpr key =
        new CastExpr(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act and Assert
    assertTrue(
        Cfg.isThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#isThrow(Stmt)} with {@code s}.
   *
   * <p>Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  @DisplayName("Test isThrow(Stmt) with 's'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.isThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testIsThrowWithS4() {
    // Arrange
    Constant key = Exprs.nNull();

    // Act and Assert
    assertFalse(
        Cfg.isThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#isThrow(Stmt)} with {@code s}.
   *
   * <p>Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  @DisplayName("Test isThrow(Stmt) with 's'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.isThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testIsThrowWithS5() {
    // Arrange
    Local key = new Local();

    // Act and Assert
    assertFalse(
        Cfg.isThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#isThrow(Stmt)} with {@code s}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  @DisplayName("Test isThrow(Stmt) with 's'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.isThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testIsThrowWithS_thenThrowRuntimeException() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokeCustomExpr key =
        new InvokeCustomExpr(
            VT.ADD,
            new Value[] {new ArrayExpr()},
            "Method Name",
            proto,
            new MethodHandle(8, new Field("Owner", "Name", "Type")),
            new Object[] {Constant.Null});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            Cfg.isThrow(
                new LookupSwitchStmt(
                    key,
                    new int[] {42, 8, 42, 8},
                    new LabelStmt[] {Stmts.nLabel()},
                    Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#isThrow(Stmt)} with {@code s}.
   *
   * <ul>
   *   <li>When {@link BinopExpr#BinopExpr(VT, Value, Value, String)} with vt is {@code ADD} and op1
   *       is nNull and op2 is {@link ArrayExpr#ArrayExpr()} and {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  @DisplayName(
      "Test isThrow(Stmt) with 's'; when BinopExpr(VT, Value, Value, String) with vt is 'ADD' and op1 is nNull and op2 is ArrayExpr() and 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.isThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testIsThrowWithS_whenBinopExprWithVtIsAddAndOp1IsNNullAndOp2IsArrayExprAndType() {
    // Arrange
    Constant op1 = Exprs.nNull();
    BinopExpr key = new BinopExpr(VT.ADD, op1, new ArrayExpr(), "Type");

    // Act and Assert
    assertTrue(
        Cfg.isThrow(
            new LookupSwitchStmt(
                key, new int[] {42, 8, 42, 8}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Test {@link Cfg#isThrow(Stmt)} with {@code s}.
   *
   * <ul>
   *   <li>When nLabel.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  @DisplayName("Test isThrow(Stmt) with 's'; when nLabel; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.ts.Cfg.isThrow(proguard.dexfile.ir.stmt.Stmt)"})
  void testIsThrowWithS_whenNLabel_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Cfg.isThrow(Stmts.nLabel()));
  }

  /**
   * Test {@link Cfg#createCfgWithoutEx(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nLabel.
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First {@link
   *       LabelStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#createCfgWithoutEx(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test createCfgWithoutEx(IrMethod); given StmtList (default constructor) add nLabel; then IrMethod (default constructor) stmts First LabelStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.createCfgWithoutEx(proguard.dexfile.ir.IrMethod)"
  })
  void testCreateCfgWithoutEx_givenStmtListAddNLabel_thenIrMethodStmtsFirstLabelStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCfgWithoutEx(jm);

    // Assert
    Stmt first = jm.stmts.getFirst();
    assertTrue(first instanceof LabelStmt);
    assertTrue(((LabelStmt) first)._cfg_froms.isEmpty());
  }

  /**
   * Test {@link Cfg#createCfgWithoutEx(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nLabel.
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} Last {@link
   *       LabelStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#createCfgWithoutEx(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test createCfgWithoutEx(IrMethod); given StmtList (default constructor) add nLabel; then IrMethod (default constructor) stmts Last LabelStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.createCfgWithoutEx(proguard.dexfile.ir.IrMethod)"
  })
  void testCreateCfgWithoutEx_givenStmtListAddNLabel_thenIrMethodStmtsLastLabelStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    LabelStmt stmt = Stmts.nLabel();
    stmtList.add(stmt);
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCfgWithoutEx(jm);

    // Assert
    StmtList stmtList2 = jm.stmts;
    Stmt first = stmtList2.getFirst();
    assertTrue(first instanceof LabelStmt);
    Stmt last = stmtList2.getLast();
    assertTrue(last instanceof LabelStmt);
    Set<Stmt> stmtSet = ((LabelStmt) last)._cfg_froms;
    assertEquals(1, stmtSet.size());
    assertTrue(((LabelStmt) first)._cfg_froms.isEmpty());
    assertSame(stmt._cfg_froms, stmtSet);
  }

  /**
   * Test {@link Cfg#createCfgWithoutEx(IrMethod)}.
   *
   * <ul>
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First {@link
   *       GotoStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#createCfgWithoutEx(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test createCfgWithoutEx(IrMethod); then IrMethod (default constructor) stmts First GotoStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.createCfgWithoutEx(proguard.dexfile.ir.IrMethod)"
  })
  void testCreateCfgWithoutEx_thenIrMethodStmtsFirstGotoStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(new GotoStmt(null));
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCfgWithoutEx(jm);

    // Assert
    Stmt first = jm.stmts.getFirst();
    assertTrue(first instanceof GotoStmt);
    assertTrue(((GotoStmt) first)._cfg_froms.isEmpty());
  }

  /**
   * Test {@link Cfg#createCfgWithoutEx(IrMethod)}.
   *
   * <ul>
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First {@link
   *       LookupSwitchStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#createCfgWithoutEx(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test createCfgWithoutEx(IrMethod); then IrMethod (default constructor) stmts First LookupSwitchStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.createCfgWithoutEx(proguard.dexfile.ir.IrMethod)"
  })
  void testCreateCfgWithoutEx_thenIrMethodStmtsFirstLookupSwitchStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(
        new LookupSwitchStmt(
            new ArrayExpr(), new int[] {42, 1, 42, 1}, new LabelStmt[] {null}, null));
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCfgWithoutEx(jm);

    // Assert
    Stmt first = jm.stmts.getFirst();
    assertTrue(first instanceof LookupSwitchStmt);
    assertTrue(((LookupSwitchStmt) first)._cfg_froms.isEmpty());
  }

  /**
   * Test {@link Cfg#createCFG(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nLabel.
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First {@link
   *       LabelStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#createCFG(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test createCFG(IrMethod); given StmtList (default constructor) add nLabel; then IrMethod (default constructor) stmts First LabelStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.ts.Cfg.createCFG(proguard.dexfile.ir.IrMethod)"})
  void testCreateCFG_givenStmtListAddNLabel_thenIrMethodStmtsFirstLabelStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCFG(jm);

    // Assert
    Stmt first = jm.stmts.getFirst();
    assertTrue(first instanceof LabelStmt);
    assertTrue(((LabelStmt) first)._cfg_froms.isEmpty());
  }

  /**
   * Test {@link Cfg#createCFG(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nLabel.
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} Last {@link
   *       LabelStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#createCFG(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test createCFG(IrMethod); given StmtList (default constructor) add nLabel; then IrMethod (default constructor) stmts Last LabelStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.ts.Cfg.createCFG(proguard.dexfile.ir.IrMethod)"})
  void testCreateCFG_givenStmtListAddNLabel_thenIrMethodStmtsLastLabelStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    LabelStmt stmt = Stmts.nLabel();
    stmtList.add(stmt);
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCFG(jm);

    // Assert
    StmtList stmtList2 = jm.stmts;
    Stmt first = stmtList2.getFirst();
    assertTrue(first instanceof LabelStmt);
    Stmt last = stmtList2.getLast();
    assertTrue(last instanceof LabelStmt);
    Set<Stmt> stmtSet = ((LabelStmt) last)._cfg_froms;
    assertEquals(1, stmtSet.size());
    assertTrue(((LabelStmt) first)._cfg_froms.isEmpty());
    assertSame(stmt._cfg_froms, stmtSet);
  }

  /**
   * Test {@link Cfg#createCFG(IrMethod)}.
   *
   * <ul>
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First {@link
   *       GotoStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#createCFG(IrMethod)}
   */
  @Test
  @DisplayName("Test createCFG(IrMethod); then IrMethod (default constructor) stmts First GotoStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.ts.Cfg.createCFG(proguard.dexfile.ir.IrMethod)"})
  void testCreateCFG_thenIrMethodStmtsFirstGotoStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(new GotoStmt(null));
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCFG(jm);

    // Assert
    Stmt first = jm.stmts.getFirst();
    assertTrue(first instanceof GotoStmt);
    assertTrue(((GotoStmt) first)._cfg_froms.isEmpty());
  }

  /**
   * Test {@link Cfg#createCFG(IrMethod)}.
   *
   * <ul>
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First {@link
   *       LookupSwitchStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#createCFG(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test createCFG(IrMethod); then IrMethod (default constructor) stmts First LookupSwitchStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.ts.Cfg.createCFG(proguard.dexfile.ir.IrMethod)"})
  void testCreateCFG_thenIrMethodStmtsFirstLookupSwitchStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(
        new LookupSwitchStmt(
            new ArrayExpr(), new int[] {42, 1, 42, 1}, new LabelStmt[] {null}, null));
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCFG(jm);

    // Assert
    Stmt first = jm.stmts.getFirst();
    assertTrue(first instanceof LookupSwitchStmt);
    assertTrue(((LookupSwitchStmt) first)._cfg_froms.isEmpty());
  }

  /**
   * Test {@link Cfg#dfsVisit(IrMethod, DfsVisitor)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#dfsVisit(IrMethod, DfsVisitor)}
   */
  @Test
  @DisplayName(
      "Test dfsVisit(IrMethod, DfsVisitor); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.dfsVisit(proguard.dexfile.ir.IrMethod, proguard.dexfile.ir.ts.Cfg$DfsVisitor)"
  })
  void testDfsVisit_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    DfsVisitor visitor = mock(DfsVisitor.class);
    doThrow(new RuntimeException("foo")).when(visitor).onVisit(Mockito.<Stmt>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Cfg.dfsVisit(method, visitor));
    verify(visitor).onVisit(isA(Stmt.class));
  }

  /**
   * Test {@link Cfg#dfsVisit(IrMethod, DfsVisitor)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nReturnVoid.
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First {@link
   *       ReturnVoidStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#dfsVisit(IrMethod, DfsVisitor)}
   */
  @Test
  @DisplayName(
      "Test dfsVisit(IrMethod, DfsVisitor); given StmtList (default constructor) add nReturnVoid; then IrMethod (default constructor) stmts First ReturnVoidStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.dfsVisit(proguard.dexfile.ir.IrMethod, proguard.dexfile.ir.ts.Cfg$DfsVisitor)"
  })
  void testDfsVisit_givenStmtListAddNReturnVoid_thenIrMethodStmtsFirstReturnVoidStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nReturnVoid());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    DfsVisitor visitor = mock(DfsVisitor.class);
    doNothing().when(visitor).onVisit(Mockito.<Stmt>any());

    // Act
    Cfg.dfsVisit(method, visitor);

    // Assert
    verify(visitor).onVisit(isA(Stmt.class));
    Stmt first = method.stmts.getFirst();
    assertTrue(first instanceof ReturnVoidStmt);
    assertTrue(((ReturnVoidStmt) first).visited);
  }

  /**
   * Test {@link Cfg#dfs(StmtList, FrameVisitor)}.
   *
   * <p>Method under test: {@link Cfg#dfs(StmtList, FrameVisitor)}
   */
  @Test
  @DisplayName("Test dfs(StmtList, FrameVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.dfs(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$FrameVisitor)"
  })
  void testDfs() {
    // Arrange
    StmtList stmts = new StmtList();
    ArrayExpr key = new ArrayExpr();
    stmts.add(
        new LookupSwitchStmt(
            key, new int[] {42, 1, 42, 1}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel()));
    FrameVisitor<Object> sv = mock(FrameVisitor.class);
    when(sv.merge(
            Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Stmt>any(), Mockito.<Stmt>any()))
        .thenThrow(new RuntimeException("foo"));
    when(sv.exec(Mockito.<Object>any(), Mockito.<Stmt>any())).thenReturn(Constant.Null);
    when(sv.initFirstFrame(Mockito.<Stmt>any())).thenReturn(Constant.Null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Cfg.dfs(stmts, sv));
    verify(sv).exec(isA(Object.class), isA(Stmt.class));
    verify(sv).initFirstFrame(isA(Stmt.class));
    verify(sv).merge(isA(Object.class), isNull(), isA(Stmt.class), isA(Stmt.class));
  }

  /**
   * Test {@link Cfg#dfs(StmtList, FrameVisitor)}.
   *
   * <p>Method under test: {@link Cfg#dfs(StmtList, FrameVisitor)}
   */
  @Test
  @DisplayName("Test dfs(StmtList, FrameVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.dfs(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$FrameVisitor)"
  })
  void testDfs2() {
    // Arrange
    StmtList stmts = new StmtList();
    ArrayExpr key = new ArrayExpr();
    stmts.add(
        new LookupSwitchStmt(key, new int[] {42, 1, 42, 1}, new LabelStmt[] {}, Stmts.nLabel()));
    FrameVisitor<Object> sv = mock(FrameVisitor.class);
    when(sv.merge(
            Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Stmt>any(), Mockito.<Stmt>any()))
        .thenThrow(new RuntimeException("foo"));
    when(sv.exec(Mockito.<Object>any(), Mockito.<Stmt>any())).thenReturn(Constant.Null);
    when(sv.initFirstFrame(Mockito.<Stmt>any())).thenReturn(Constant.Null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Cfg.dfs(stmts, sv));
    verify(sv).exec(isA(Object.class), isA(Stmt.class));
    verify(sv).initFirstFrame(isA(Stmt.class));
    verify(sv).merge(isA(Object.class), isNull(), isA(Stmt.class), isA(Stmt.class));
  }

  /**
   * Test {@link Cfg#dfs(StmtList, FrameVisitor)}.
   *
   * <ul>
   *   <li>Given {@link GotoStmt#GotoStmt(LabelStmt)} with target is nLabel.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#dfs(StmtList, FrameVisitor)}
   */
  @Test
  @DisplayName("Test dfs(StmtList, FrameVisitor); given GotoStmt(LabelStmt) with target is nLabel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.dfs(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$FrameVisitor)"
  })
  void testDfs_givenGotoStmtWithTargetIsNLabel() {
    // Arrange
    StmtList stmts = new StmtList();
    stmts.add(new GotoStmt(Stmts.nLabel()));
    FrameVisitor<Object> sv = mock(FrameVisitor.class);
    when(sv.merge(
            Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Stmt>any(), Mockito.<Stmt>any()))
        .thenThrow(new RuntimeException("foo"));
    when(sv.exec(Mockito.<Object>any(), Mockito.<Stmt>any())).thenReturn(Constant.Null);
    when(sv.initFirstFrame(Mockito.<Stmt>any())).thenReturn(Constant.Null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Cfg.dfs(stmts, sv));
    verify(sv).exec(isA(Object.class), isA(Stmt.class));
    verify(sv).initFirstFrame(isA(Stmt.class));
    verify(sv).merge(isA(Object.class), isNull(), isA(Stmt.class), isA(Stmt.class));
  }

  /**
   * Test {@link Cfg#dfs(StmtList, FrameVisitor)}.
   *
   * <ul>
   *   <li>Given nReturnVoid.
   *   <li>Then {@link StmtList} (default constructor) First {@link ReturnVoidStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#dfs(StmtList, FrameVisitor)}
   */
  @Test
  @DisplayName(
      "Test dfs(StmtList, FrameVisitor); given nReturnVoid; then StmtList (default constructor) First ReturnVoidStmt")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.dfs(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$FrameVisitor)"
  })
  void testDfs_givenNReturnVoid_thenStmtListFirstReturnVoidStmt() {
    // Arrange
    StmtList stmts = new StmtList();
    ReturnVoidStmt stmt = Stmts.nReturnVoid();
    stmts.add(stmt);
    FrameVisitor<Object> sv = mock(FrameVisitor.class);
    when(sv.exec(Mockito.<Object>any(), Mockito.<Stmt>any())).thenReturn(Constant.Null);
    when(sv.initFirstFrame(Mockito.<Stmt>any())).thenReturn(Constant.Null);

    // Act
    Cfg.dfs(stmts, sv);

    // Assert
    verify(sv).exec(isA(Object.class), isA(Stmt.class));
    verify(sv).initFirstFrame(isA(Stmt.class));
    Stmt first = stmts.getFirst();
    assertTrue(first instanceof ReturnVoidStmt);
    assertTrue(((ReturnVoidStmt) first).visited);
    assertSame(stmt.frame, ((ReturnVoidStmt) first).frame);
  }

  /**
   * Test {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <p>Method under test: {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travelMod(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelModWithStmtsCallbackTravelPhi() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    Local condition = new Local();
    when(stmts.getFirst()).thenReturn(new IfStmt(ST.LOCAL_START, condition, Stmts.nLabel()));

    // Act
    Cfg.travelMod(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <p>Method under test: {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travelMod(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelModWithStmtsCallbackTravelPhi2() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    Local left = new Local();
    when(stmts.getFirst()).thenReturn(new AssignStmt(ST.LOCAL_START, left, new Local()));

    // Act
    Cfg.travelMod(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <p>Method under test: {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travelMod(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelModWithStmtsCallbackTravelPhi3() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    Local left = new Local();
    when(stmts.getFirst()).thenReturn(new AssignStmt(ST.ASSIGN, left, new Local()));

    // Act
    Cfg.travelMod(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <p>Method under test: {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travelMod(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelModWithStmtsCallbackTravelPhi4() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    Local left = new Local();
    when(stmts.getFirst()).thenReturn(new AssignStmt(ST.IDENTITY, left, new Local()));

    // Act
    Cfg.travelMod(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <p>Method under test: {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travelMod(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelModWithStmtsCallbackTravelPhi5() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    CastExpr key = new CastExpr(new Local(), "jane.doe@example.org", "alice.liddell@example.org");

    when(stmts.getFirst())
        .thenReturn(
            new LookupSwitchStmt(
                key, new int[] {42, 1, 42, 1}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel()));

    // Act
    Cfg.travelMod(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <ul>
   *   <li>Given {@link GotoStmt#GotoStmt(LabelStmt)} with target is nLabel.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travelMod(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'; given GotoStmt(LabelStmt) with target is nLabel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelModWithStmtsCallbackTravelPhi_givenGotoStmtWithTargetIsNLabel() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    when(stmts.getFirst()).thenReturn(new GotoStmt(Stmts.nLabel()));

    // Act
    Cfg.travelMod(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <ul>
   *   <li>Given nLabel.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travelMod(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'; given nLabel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelModWithStmtsCallbackTravelPhi_givenNLabel() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    when(stmts.getFirst()).thenReturn(Stmts.nLabel());

    // Act
    Cfg.travelMod(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <ul>
   *   <li>Given nLabel.
   *   <li>When {@code false}.
   *   <li>Then calls {@link StmtList#getFirst()}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travelMod(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travelMod(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'; given nLabel; when 'false'; then calls getFirst()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelModWithStmtsCallbackTravelPhi_givenNLabel_whenFalse_thenCallsGetFirst() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    when(stmts.getFirst()).thenReturn(Stmts.nLabel());

    // Act
    Cfg.travelMod(stmts, new ReplaceX(), false);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travelMod(Value, OnUseCallBack)} with {@code value}, {@code callback}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()}.
   *   <li>When {@link Local#Local()}.
   *   <li>Then return {@link ArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travelMod(Value, OnUseCallBack)}
   */
  @Test
  @DisplayName(
      "Test travelMod(Value, OnUseCallBack) with 'value', 'callback'; given ArrayExpr(); when Local(); then return ArrayExpr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.ts.Cfg$OnUseCallBack)"
  })
  void testTravelModWithValueCallback_givenArrayExpr_whenLocal_thenReturnArrayExpr() {
    // Arrange
    Local value = new Local();
    OnUseCallBack callback = mock(OnUseCallBack.class);
    when(callback.onUse(Mockito.<Local>any())).thenReturn(new ArrayExpr());

    // Act
    Value actualTravelModResult = Cfg.travelMod(value, callback);

    // Assert
    verify(callback).onUse(isA(Local.class));
    assertTrue(actualTravelModResult instanceof ArrayExpr);
    assertEquals("null[null]", ((ArrayExpr) actualTravelModResult).toString0());
    assertNull(((ArrayExpr) actualTravelModResult).elementType);
    assertNull(actualTravelModResult.getOp1());
    assertNull(actualTravelModResult.getOp2());
    assertEquals(VT.ARRAY, ((ArrayExpr) actualTravelModResult).vt);
  }

  /**
   * Test {@link Cfg#travelMod(Value, OnUseCallBack)} with {@code value}, {@code callback}.
   *
   * <ul>
   *   <li>Then return {@link BinopExpr}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travelMod(Value, OnUseCallBack)}
   */
  @Test
  @DisplayName(
      "Test travelMod(Value, OnUseCallBack) with 'value', 'callback'; then return BinopExpr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.ts.Cfg$OnUseCallBack)"
  })
  void testTravelModWithValueCallback_thenReturnBinopExpr() {
    // Arrange
    Constant op1 = Exprs.nNull();
    Constant op2 = Exprs.nNull();

    // Act
    Value actualTravelModResult =
        Cfg.travelMod(new BinopExpr(VT.ADD, op1, op2, "Type"), mock(OnUseCallBack.class));

    // Assert
    assertTrue(actualTravelModResult instanceof BinopExpr);
    Value op12 = actualTravelModResult.getOp1();
    assertTrue(op12 instanceof Constant);
    Value op22 = actualTravelModResult.getOp2();
    assertTrue(op22 instanceof Constant);
    assertEquals("(null + null)", ((BinopExpr) actualTravelModResult).toString0());
    assertEquals(VT.ADD, ((BinopExpr) actualTravelModResult).vt);
    assertSame(op1, op12);
    assertSame(op2, op22);
  }

  /**
   * Test {@link Cfg#travelMod(Value, OnUseCallBack)} with {@code value}, {@code callback}.
   *
   * <ul>
   *   <li>Then return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travelMod(Value, OnUseCallBack)}
   */
  @Test
  @DisplayName(
      "Test travelMod(Value, OnUseCallBack) with 'value', 'callback'; then return CastExpr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.ts.Cfg$OnUseCallBack)"
  })
  void testTravelModWithValueCallback_thenReturnCastExpr() {
    // Arrange
    Constant value = Exprs.nNull();

    // Act
    Value actualTravelModResult =
        Cfg.travelMod(
            new CastExpr(value, "jane.doe@example.org", "alice.liddell@example.org"),
            mock(OnUseCallBack.class));

    // Assert
    assertTrue(actualTravelModResult instanceof CastExpr);
    assertEquals("alice.liddell@example.org", ((CastExpr) actualTravelModResult).to);
    assertEquals("jane.doe@example.org", ((CastExpr) actualTravelModResult).from);
    assertEquals(ET.E1, ((CastExpr) actualTravelModResult).et);
    assertEquals(VT.CAST, ((CastExpr) actualTravelModResult).vt);
    assertSame(value, actualTravelModResult.getOp());
  }

  /**
   * Test {@link Cfg#travelMod(Value, OnUseCallBack)} with {@code value}, {@code callback}.
   *
   * <ul>
   *   <li>Then return {@link FilledArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travelMod(Value, OnUseCallBack)}
   */
  @Test
  @DisplayName(
      "Test travelMod(Value, OnUseCallBack) with 'value', 'callback'; then return FilledArrayExpr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.ts.Cfg$OnUseCallBack)"
  })
  void testTravelModWithValueCallback_thenReturnFilledArrayExpr() {
    // Arrange
    Constant nNullResult = Exprs.nNull();

    // Act
    Value actualTravelModResult =
        Cfg.travelMod(
            new FilledArrayExpr(new Value[] {nNullResult}, "Type"), mock(OnUseCallBack.class));

    // Assert
    assertTrue(actualTravelModResult instanceof FilledArrayExpr);
    Value[] ops = actualTravelModResult.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, ((FilledArrayExpr) actualTravelModResult).et);
    assertEquals(VT.FILLED_ARRAY, ((FilledArrayExpr) actualTravelModResult).vt);
    assertSame(nNullResult, ops[0]);
  }

  /**
   * Test {@link Cfg#travelMod(Value, OnUseCallBack)} with {@code value}, {@code callback}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travelMod(Value, OnUseCallBack)}
   */
  @Test
  @DisplayName(
      "Test travelMod(Value, OnUseCallBack) with 'value', 'callback'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.ts.Cfg$OnUseCallBack)"
  })
  void testTravelModWithValueCallback_thenThrowRuntimeException() {
    // Arrange
    Local value = new Local();
    OnUseCallBack callback = mock(OnUseCallBack.class);
    when(callback.onUse(Mockito.<Local>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Cfg.travelMod(value, callback));
    verify(callback).onUse(isA(Local.class));
  }

  /**
   * Test {@link Cfg#travelMod(Value, OnUseCallBack)} with {@code value}, {@code callback}.
   *
   * <ul>
   *   <li>When nNull.
   *   <li>Then return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travelMod(Value, OnUseCallBack)}
   */
  @Test
  @DisplayName(
      "Test travelMod(Value, OnUseCallBack) with 'value', 'callback'; when nNull; then return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.ts.Cfg.travelMod(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.ts.Cfg$OnUseCallBack)"
  })
  void testTravelModWithValueCallback_whenNNull_thenReturnConstant() {
    // Arrange and Act
    Value actualTravelModResult = Cfg.travelMod(Exprs.nNull(), mock(OnUseCallBack.class));

    // Assert
    assertTrue(actualTravelModResult instanceof Constant);
    assertNull(actualTravelModResult.getOp1());
    assertNull(actualTravelModResult.getOp2());
    assertEquals(ET.E0, ((Constant) actualTravelModResult).et);
    assertEquals(VT.CONSTANT, ((Constant) actualTravelModResult).vt);
  }

  /**
   * Test {@link Cfg#travel(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <p>Method under test: {@link Cfg#travel(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travel(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travel(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelWithStmtsCallbackTravelPhi() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    Local condition = new Local();
    when(stmts.getFirst()).thenReturn(new IfStmt(ST.LOCAL_START, condition, Stmts.nLabel()));

    // Act
    Cfg.travel(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travel(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <p>Method under test: {@link Cfg#travel(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travel(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travel(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelWithStmtsCallbackTravelPhi2() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    Local left = new Local();
    when(stmts.getFirst()).thenReturn(new AssignStmt(ST.LOCAL_START, left, new Local()));

    // Act
    Cfg.travel(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travel(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <p>Method under test: {@link Cfg#travel(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travel(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travel(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelWithStmtsCallbackTravelPhi3() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    Local left = new Local();
    when(stmts.getFirst()).thenReturn(new AssignStmt(ST.ASSIGN, left, new Local()));

    // Act
    Cfg.travel(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travel(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <p>Method under test: {@link Cfg#travel(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travel(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travel(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelWithStmtsCallbackTravelPhi4() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    Local left = new Local();
    when(stmts.getFirst()).thenReturn(new AssignStmt(ST.IDENTITY, left, new Local()));

    // Act
    Cfg.travel(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travel(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <p>Method under test: {@link Cfg#travel(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travel(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travel(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelWithStmtsCallbackTravelPhi5() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    CastExpr key = new CastExpr(new Local(), "jane.doe@example.org", "alice.liddell@example.org");

    when(stmts.getFirst())
        .thenReturn(
            new LookupSwitchStmt(
                key, new int[] {42, 1, 42, 1}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel()));

    // Act
    Cfg.travel(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travel(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <ul>
   *   <li>Given {@link GotoStmt#GotoStmt(LabelStmt)} with target is nLabel.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travel(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travel(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'; given GotoStmt(LabelStmt) with target is nLabel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travel(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelWithStmtsCallbackTravelPhi_givenGotoStmtWithTargetIsNLabel() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    when(stmts.getFirst()).thenReturn(new GotoStmt(Stmts.nLabel()));

    // Act
    Cfg.travel(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travel(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <ul>
   *   <li>Given nLabel.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travel(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travel(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'; given nLabel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travel(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelWithStmtsCallbackTravelPhi_givenNLabel() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    when(stmts.getFirst()).thenReturn(Stmts.nLabel());

    // Act
    Cfg.travel(stmts, new ReplaceX(), true);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travel(StmtList, TravelCallBack, boolean)} with {@code stmts}, {@code
   * callback}, {@code travelPhi}.
   *
   * <ul>
   *   <li>Given nLabel.
   *   <li>When {@code false}.
   *   <li>Then calls {@link StmtList#getFirst()}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travel(StmtList, TravelCallBack, boolean)}
   */
  @Test
  @DisplayName(
      "Test travel(StmtList, TravelCallBack, boolean) with 'stmts', 'callback', 'travelPhi'; given nLabel; when 'false'; then calls getFirst()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travel(proguard.dexfile.ir.stmt.StmtList, proguard.dexfile.ir.ts.Cfg$TravelCallBack, boolean)"
  })
  void testTravelWithStmtsCallbackTravelPhi_givenNLabel_whenFalse_thenCallsGetFirst() {
    // Arrange
    StmtList stmts = mock(StmtList.class);
    when(stmts.getFirst()).thenReturn(Stmts.nLabel());

    // Act
    Cfg.travel(stmts, new ReplaceX(), false);

    // Assert
    verify(stmts).getFirst();
  }

  /**
   * Test {@link Cfg#travel(Value, OnUseCallBack)} with {@code value}, {@code callback}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()}.
   *   <li>When {@link Local#Local()}.
   *   <li>Then calls {@link OnUseCallBack#onUse(Local)}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travel(Value, OnUseCallBack)}
   */
  @Test
  @DisplayName(
      "Test travel(Value, OnUseCallBack) with 'value', 'callback'; given ArrayExpr(); when Local(); then calls onUse(Local)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travel(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.ts.Cfg$OnUseCallBack)"
  })
  void testTravelWithValueCallback_givenArrayExpr_whenLocal_thenCallsOnUse() {
    // Arrange
    Local value = new Local();
    OnUseCallBack callback = mock(OnUseCallBack.class);
    when(callback.onUse(Mockito.<Local>any())).thenReturn(new ArrayExpr());

    // Act
    Cfg.travel(value, callback);

    // Assert
    verify(callback).onUse(isA(Local.class));
  }

  /**
   * Test {@link Cfg#travel(Value, OnUseCallBack)} with {@code value}, {@code callback}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travel(Value, OnUseCallBack)}
   */
  @Test
  @DisplayName(
      "Test travel(Value, OnUseCallBack) with 'value', 'callback'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.travel(proguard.dexfile.ir.expr.Value, proguard.dexfile.ir.ts.Cfg$OnUseCallBack)"
  })
  void testTravelWithValueCallback_thenThrowRuntimeException() {
    // Arrange
    Local value = new Local();
    OnUseCallBack callback = mock(OnUseCallBack.class);
    when(callback.onUse(Mockito.<Local>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Cfg.travel(value, callback));
    verify(callback).onUse(isA(Local.class));
  }

  /**
   * Test {@link Cfg#reIndexLocal(IrMethod)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#reIndexLocal(IrMethod)}
   */
  @Test
  @DisplayName("Test reIndexLocal(IrMethod); when IrMethod (default constructor); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.dexfile.ir.ts.Cfg.reIndexLocal(proguard.dexfile.ir.IrMethod)"})
  void testReIndexLocal_whenIrMethod_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, Cfg.reIndexLocal(new IrMethod()));
  }

  /**
   * Test {@link Cfg#collectTos(Stmt, Set)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When nLabel {@link Stmt#exceptionHandlers} is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#collectTos(Stmt, Set)}
   */
  @Test
  @DisplayName(
      "Test collectTos(Stmt, Set); given HashSet(); when nLabel exceptionHandlers is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.collectTos(proguard.dexfile.ir.stmt.Stmt, java.util.Set)"
  })
  void testCollectTos_givenHashSet_whenNLabelExceptionHandlersIsHashSet() {
    // Arrange
    LabelStmt stmt = Stmts.nLabel();
    stmt.exceptionHandlers = new HashSet<>();
    HashSet<Stmt> tos = new HashSet<>();

    // Act
    Cfg.collectTos(stmt, tos);

    // Assert
    assertEquals(1, tos.size());
  }

  /**
   * Test {@link Cfg#collectTos(Stmt, Set)}.
   *
   * <ul>
   *   <li>Then {@link HashSet#HashSet()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#collectTos(Stmt, Set)}
   */
  @Test
  @DisplayName("Test collectTos(Stmt, Set); then HashSet() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.collectTos(proguard.dexfile.ir.stmt.Stmt, java.util.Set)"
  })
  void testCollectTos_thenHashSetSizeIsTwo() {
    // Arrange
    ArrayExpr key = new ArrayExpr();
    LookupSwitchStmt stmt =
        new LookupSwitchStmt(
            key, new int[] {42, 2, 42, 2}, new LabelStmt[] {Stmts.nLabel()}, Stmts.nLabel());

    HashSet<Stmt> tos = new HashSet<>();

    // Act
    Cfg.collectTos(stmt, tos);

    // Assert
    assertEquals(2, tos.size());
  }

  /**
   * Test {@link Cfg#collectTos(Stmt, Set)}.
   *
   * <ul>
   *   <li>When {@link GotoStmt#GotoStmt(LabelStmt)} with target is nLabel.
   *   <li>Then {@link HashSet#HashSet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#collectTos(Stmt, Set)}
   */
  @Test
  @DisplayName(
      "Test collectTos(Stmt, Set); when GotoStmt(LabelStmt) with target is nLabel; then HashSet() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.collectTos(proguard.dexfile.ir.stmt.Stmt, java.util.Set)"
  })
  void testCollectTos_whenGotoStmtWithTargetIsNLabel_thenHashSetSizeIsOne() {
    // Arrange
    GotoStmt stmt = new GotoStmt(Stmts.nLabel());
    HashSet<Stmt> tos = new HashSet<>();

    // Act
    Cfg.collectTos(stmt, tos);

    // Assert
    assertEquals(1, tos.size());
  }

  /**
   * Test {@link Cfg#collectTos(Stmt, Set)}.
   *
   * <ul>
   *   <li>When nLabel.
   *   <li>Then {@link HashSet#HashSet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#collectTos(Stmt, Set)}
   */
  @Test
  @DisplayName("Test collectTos(Stmt, Set); when nLabel; then HashSet() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.Cfg.collectTos(proguard.dexfile.ir.stmt.Stmt, java.util.Set)"
  })
  void testCollectTos_whenNLabel_thenHashSetSizeIsOne() {
    // Arrange
    LabelStmt stmt = Stmts.nLabel();
    HashSet<Stmt> tos = new HashSet<>();

    // Act
    Cfg.collectTos(stmt, tos);

    // Assert
    assertEquals(1, tos.size());
  }
}
