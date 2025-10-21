package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import proguard.dexfile.ir.stmt.GotoStmt;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.LookupSwitchStmt;
import proguard.dexfile.ir.stmt.ReturnVoidStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;
import proguard.dexfile.ir.stmt.TableSwitchStmt;
import proguard.dexfile.ir.ts.AggTransformer.ReplaceX;
import proguard.dexfile.ir.ts.Cfg.DfsVisitor;
import proguard.dexfile.ir.ts.Cfg.OnUseCallBack;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Proto;

public class CfgDiffblueTest {
  /**
   * Test {@link Cfg#countLocalReads(IrMethod)}.
   *
   * <p>Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] Cfg.countLocalReads(IrMethod)"})
  public void testCountLocalReads() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] Cfg.countLocalReads(IrMethod)"})
  public void testCountLocalReads2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] Cfg.countLocalReads(IrMethod)"})
  public void testCountLocalReads_givenArrayListAddLocal_thenReturnArrayOfIntWithZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] Cfg.countLocalReads(IrMethod)"})
  public void testCountLocalReads_givenStmtListAddNLabel_thenReturnEmptyArrayOfInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] Cfg.countLocalReads(IrMethod)"})
  public void testCountLocalReads_givenStmtListAddNNop_thenReturnEmptyArrayOfInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] Cfg.countLocalReads(IrMethod)"})
  public void testCountLocalReads_givenTableSwitchStmtOpIsNNull_thenReturnEmptyArrayOfInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] Cfg.countLocalReads(IrMethod)"})
  public void testCountLocalReads_whenIrMethod_thenReturnEmptyArrayOfInt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.reIndexLocalAndLabel(IrMethod)"})
  public void testReIndexLocalAndLabel_givenStmtListAddNLabel_thenIrMethodStmtsFirstLabelStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.notThrow(Stmt)"})
  public void testNotThrow() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.notThrow(Stmt)"})
  public void testNotThrow2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.notThrow(Stmt)"})
  public void testNotThrow3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.notThrow(Stmt)"})
  public void testNotThrow4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.notThrow(Stmt)"})
  public void testNotThrow_thenThrowRuntimeException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.notThrow(Stmt)"})
  public void testNotThrow_whenBinopExprWithVtIsAddAndOp1IsArrayExprAndOp2IsArrayExprAndType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.notThrow(Stmt)"})
  public void testNotThrow_whenBinopExprWithVtIsAddAndOp1IsNNullAndOp2IsArrayExprAndType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.notThrow(Stmt)"})
  public void testNotThrow_whenNLabel_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Cfg.notThrow(Stmts.nLabel()));
  }

  /**
   * Test {@link Cfg#isThrow(Stmt)} with {@code s}.
   *
   * <p>Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.isThrow(Stmt)"})
  public void testIsThrowWithS() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.isThrow(Stmt)"})
  public void testIsThrowWithS2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.isThrow(Stmt)"})
  public void testIsThrowWithS3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.isThrow(Stmt)"})
  public void testIsThrowWithS4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.isThrow(Stmt)"})
  public void testIsThrowWithS5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.isThrow(Stmt)"})
  public void testIsThrowWithS_thenThrowRuntimeException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.isThrow(Stmt)"})
  public void testIsThrowWithS_whenBinopExprWithVtIsAddAndOp1IsNNullAndOp2IsArrayExprAndType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Cfg.isThrow(Stmt)"})
  public void testIsThrowWithS_whenNLabel_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.createCfgWithoutEx(IrMethod)"})
  public void testCreateCfgWithoutEx_givenStmtListAddNLabel_thenIrMethodStmtsFirstLabelStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.createCfgWithoutEx(IrMethod)"})
  public void testCreateCfgWithoutEx_givenStmtListAddNLabel_thenIrMethodStmtsLastLabelStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.createCfgWithoutEx(IrMethod)"})
  public void testCreateCfgWithoutEx_thenIrMethodStmtsFirstGotoStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.createCfgWithoutEx(IrMethod)"})
  public void testCreateCfgWithoutEx_thenIrMethodStmtsFirstLookupSwitchStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.createCFG(IrMethod)"})
  public void testCreateCFG_givenStmtListAddNLabel_thenIrMethodStmtsFirstLabelStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.createCFG(IrMethod)"})
  public void testCreateCFG_givenStmtListAddNLabel_thenIrMethodStmtsLastLabelStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.createCFG(IrMethod)"})
  public void testCreateCFG_thenIrMethodStmtsFirstGotoStmt() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.createCFG(IrMethod)"})
  public void testCreateCFG_thenIrMethodStmtsFirstLookupSwitchStmt() {
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
   *   <li>Given {@link StmtList} (default constructor) add nReturnVoid.
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First {@link
   *       ReturnVoidStmt}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#dfsVisit(IrMethod, DfsVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.dfsVisit(IrMethod, DfsVisitor)"})
  public void testDfsVisit_givenStmtListAddNReturnVoid_thenIrMethodStmtsFirstReturnVoidStmt() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nReturnVoid());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act
    Cfg.dfsVisit(method, null);

    // Assert
    Stmt first = method.stmts.getFirst();
    assertTrue(first instanceof ReturnVoidStmt);
    assertTrue(((ReturnVoidStmt) first).visited);
  }

  /**
   * Test {@link Cfg#travelMod(Value, OnUseCallBack)} with {@code value}, {@code callback}.
   *
   * <ul>
   *   <li>Then return {@link ArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travelMod(Value, OnUseCallBack)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Cfg.travelMod(Value, OnUseCallBack)"})
  public void testTravelModWithValueCallback_thenReturnArrayExpr() {
    // Arrange
    Constant base = Exprs.nNull();
    Constant index = Exprs.nNull();
    ArrayExpr value = new ArrayExpr(base, index, "Element Type");

    // Act
    Value actualTravelModResult = Cfg.travelMod(value, new ReplaceX());

    // Assert
    assertTrue(actualTravelModResult instanceof ArrayExpr);
    Value op1 = actualTravelModResult.getOp1();
    assertTrue(op1 instanceof Constant);
    Value op2 = actualTravelModResult.getOp2();
    assertTrue(op2 instanceof Constant);
    assertEquals("Element Type", ((ArrayExpr) actualTravelModResult).elementType);
    assertEquals("null[null]", ((ArrayExpr) actualTravelModResult).toString0());
    assertEquals(ET.E2, ((ArrayExpr) actualTravelModResult).et);
    assertEquals(VT.ARRAY, ((ArrayExpr) actualTravelModResult).vt);
    assertSame(base, op1);
    assertSame(index, op2);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Cfg.travelMod(Value, OnUseCallBack)"})
  public void testTravelModWithValueCallback_thenReturnCastExpr() {
    // Arrange
    Constant value = Exprs.nNull();
    CastExpr value2 = new CastExpr(value, "jane.doe@example.org", "alice.liddell@example.org");

    // Act
    Value actualTravelModResult = Cfg.travelMod(value2, new ReplaceX());

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Cfg.travelMod(Value, OnUseCallBack)"})
  public void testTravelModWithValueCallback_thenReturnFilledArrayExpr() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    FilledArrayExpr value = new FilledArrayExpr(new Value[] {nNullResult}, "Type");

    // Act
    Value actualTravelModResult = Cfg.travelMod(value, new ReplaceX());

    // Assert
    assertTrue(actualTravelModResult instanceof FilledArrayExpr);
    assertEquals("Type", ((FilledArrayExpr) actualTravelModResult).type);
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
   *   <li>When {@link Local#Local()}.
   *   <li>Then return {@link Local}.
   * </ul>
   *
   * <p>Method under test: {@link Cfg#travelMod(Value, OnUseCallBack)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Cfg.travelMod(Value, OnUseCallBack)"})
  public void testTravelModWithValueCallback_whenLocal_thenReturnLocal() {
    // Arrange
    Local value = new Local();

    // Act
    Value actualTravelModResult = Cfg.travelMod(value, new ReplaceX());

    // Assert
    assertTrue(actualTravelModResult instanceof Local);
    assertEquals("a0", ((Local) actualTravelModResult).toString0());
    assertNull(((Local) actualTravelModResult).debugName);
    assertNull(((Local) actualTravelModResult).signature);
    assertEquals(0, ((Local) actualTravelModResult)._ls_index);
    assertEquals(VT.LOCAL, ((Local) actualTravelModResult).vt);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value Cfg.travelMod(Value, OnUseCallBack)"})
  public void testTravelModWithValueCallback_whenNNull_thenReturnConstant() {
    // Arrange
    Constant value = Exprs.nNull();

    // Act
    Value actualTravelModResult = Cfg.travelMod(value, new ReplaceX());

    // Assert
    assertTrue(actualTravelModResult instanceof Constant);
    assertNull(actualTravelModResult.getOps());
    assertNull(actualTravelModResult.getOp());
    assertNull(actualTravelModResult.getOp1());
    assertNull(actualTravelModResult.getOp2());
    assertEquals(ET.E0, ((Constant) actualTravelModResult).et);
    assertEquals(VT.CONSTANT, ((Constant) actualTravelModResult).vt);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Cfg.reIndexLocal(IrMethod)"})
  public void testReIndexLocal_whenIrMethod_thenReturnZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.collectTos(Stmt, Set)"})
  public void testCollectTos_givenHashSet_whenNLabelExceptionHandlersIsHashSet() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.collectTos(Stmt, Set)"})
  public void testCollectTos_thenHashSetSizeIsTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.collectTos(Stmt, Set)"})
  public void testCollectTos_whenGotoStmtWithTargetIsNLabel_thenHashSetSizeIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Cfg.collectTos(Stmt, Set)"})
  public void testCollectTos_whenNLabel_thenHashSetSizeIsOne() {
    // Arrange
    LabelStmt stmt = Stmts.nLabel();
    HashSet<Stmt> tos = new HashSet<>();

    // Act
    Cfg.collectTos(stmt, tos);

    // Assert
    assertEquals(1, tos.size());
  }
}
