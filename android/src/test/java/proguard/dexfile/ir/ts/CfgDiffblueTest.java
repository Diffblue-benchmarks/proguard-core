package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
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
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.GotoStmt;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.LookupSwitchStmt;
import proguard.dexfile.ir.stmt.ReturnVoidStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;
import proguard.dexfile.ir.stmt.TableSwitchStmt;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Proto;

public class CfgDiffblueTest {
  /**
   * Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  public void testCountLocalReads() {
    // Arrange, Act and Assert
    assertEquals(0, Cfg.countLocalReads(new IrMethod()).length);
  }

  /**
   * Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  public void testCountLocalReads2() {
    // Arrange
    ArrayList<Local> localList = new ArrayList<>();
    localList.add(new Local());
    IrMethod method = new IrMethod();
    method.locals = localList;

    // Act and Assert
    assertArrayEquals(new int[]{0}, Cfg.countLocalReads(method));
  }

  /**
   * Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  public void testCountLocalReads3() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertEquals(0, Cfg.countLocalReads(method).length);
  }

  /**
   * Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  public void testCountLocalReads4() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nNop());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertEquals(0, Cfg.countLocalReads(method).length);
  }

  /**
   * Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  public void testCountLocalReads5() {
    // Arrange
    TableSwitchStmt stmt = new TableSwitchStmt();
    stmt.setOp(Exprs.nNull());

    StmtList stmtList = new StmtList();
    stmtList.add(stmt);
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertEquals(0, Cfg.countLocalReads(method).length);
  }

  /**
   * Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  public void testCountLocalReads6() {
    // Arrange
    TableSwitchStmt stmt = new TableSwitchStmt();
    stmt.setOp(new CastExpr(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org"));

    StmtList stmtList = new StmtList();
    stmtList.add(stmt);
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertEquals(0, Cfg.countLocalReads(method).length);
  }

  /**
   * Method under test: {@link Cfg#countLocalReads(IrMethod)}
   */
  @Test
  public void testCountLocalReads7() {
    // Arrange
    TableSwitchStmt stmt = new TableSwitchStmt();
    stmt.setOp(new FilledArrayExpr(new Value[]{Exprs.nNull()}, "Type"));

    StmtList stmtList = new StmtList();
    stmtList.add(stmt);
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act and Assert
    assertEquals(0, Cfg.countLocalReads(method).length);
  }

  /**
   * Method under test: {@link Cfg#reIndexLocalAndLabel(IrMethod)}
   */
  @Test
  public void testReIndexLocalAndLabel() {
    // Arrange
    IrMethod irMethod = new IrMethod();

    // Act
    Cfg.reIndexLocalAndLabel(irMethod);

    // Assert
    assertNull(irMethod.stmts.getFirst());
  }

  /**
   * Method under test: {@link Cfg#reIndexLocalAndLabel(IrMethod)}
   */
  @Test
  public void testReIndexLocalAndLabel2() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt stmt = Stmts.nLabel();
    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    Cfg.reIndexLocalAndLabel(irMethod);

    // Assert
    assertSame(stmt, irMethod.stmts.getFirst());
  }

  /**
   * Method under test: {@link Cfg#reIndexLocalAndLabel(IrMethod)}
   */
  @Test
  public void testReIndexLocalAndLabel3() {
    // Arrange
    StmtList stmtList = new StmtList();
    ArrayExpr left = new ArrayExpr();
    AssignStmt stmt = new AssignStmt(Stmt.ST.LOCAL_START, left, new ArrayExpr());

    stmtList.add(stmt);
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    Cfg.reIndexLocalAndLabel(irMethod);

    // Assert
    Stmt first = irMethod.stmts.getFirst();
    assertTrue(first instanceof AssignStmt);
    assertSame(stmt, first);
  }

  /**
   * Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  public void testNotThrow() {
    // Arrange, Act and Assert
    assertTrue(Cfg.notThrow(Stmts.nLabel()));
  }

  /**
   * Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  public void testNotThrow2() {
    // Arrange
    ArrayExpr key = new ArrayExpr();

    // Act and Assert
    assertFalse(Cfg
        .notThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  public void testNotThrow3() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    BinopExpr key = new BinopExpr(Value.VT.ADD, op1, new ArrayExpr(), "Type");

    // Act and Assert
    assertFalse(Cfg
        .notThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  public void testNotThrow4() {
    // Arrange
    CastExpr key = new CastExpr(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act and Assert
    assertFalse(Cfg
        .notThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  public void testNotThrow5() {
    // Arrange
    Constant key = Exprs.nNull();

    // Act and Assert
    assertTrue(Cfg
        .notThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  public void testNotThrow6() {
    // Arrange
    Local key = new Local();

    // Act and Assert
    assertTrue(Cfg
        .notThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  public void testNotThrow7() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokeCustomExpr key = new InvokeCustomExpr(Value.VT.ADD, new Value[]{new ArrayExpr()}, "Method Name", proto,
        new MethodHandle(8, new Field("Owner", "Name", "Type")), new Object[]{Constant.Null});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Cfg
        .notThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#notThrow(Stmt)}
   */
  @Test
  public void testNotThrow8() {
    // Arrange
    Constant op1 = Exprs.nNull();
    BinopExpr key = new BinopExpr(Value.VT.ADD, op1, new ArrayExpr(), "Type");

    // Act and Assert
    assertFalse(Cfg
        .notThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  public void testIsThrow() {
    // Arrange, Act and Assert
    assertFalse(Cfg.isThrow(Stmts.nLabel()));
  }

  /**
   * Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  public void testIsThrow2() {
    // Arrange
    ArrayExpr key = new ArrayExpr();

    // Act and Assert
    assertTrue(Cfg
        .isThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  public void testIsThrow3() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    BinopExpr key = new BinopExpr(Value.VT.ADD, op1, new ArrayExpr(), "Type");

    // Act and Assert
    assertTrue(Cfg
        .isThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  public void testIsThrow4() {
    // Arrange
    CastExpr key = new CastExpr(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act and Assert
    assertTrue(Cfg
        .isThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  public void testIsThrow5() {
    // Arrange
    Constant key = Exprs.nNull();

    // Act and Assert
    assertFalse(Cfg
        .isThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  public void testIsThrow6() {
    // Arrange
    Local key = new Local();

    // Act and Assert
    assertFalse(Cfg
        .isThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  public void testIsThrow7() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokeCustomExpr key = new InvokeCustomExpr(Value.VT.ADD, new Value[]{new ArrayExpr()}, "Method Name", proto,
        new MethodHandle(8, new Field("Owner", "Name", "Type")), new Object[]{Constant.Null});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Cfg
        .isThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#isThrow(Stmt)}
   */
  @Test
  public void testIsThrow8() {
    // Arrange
    Constant op1 = Exprs.nNull();
    BinopExpr key = new BinopExpr(Value.VT.ADD, op1, new ArrayExpr(), "Type");

    // Act and Assert
    assertTrue(Cfg
        .isThrow(new LookupSwitchStmt(key, new int[]{42, 8, 42, 8}, new LabelStmt[]{Stmts.nLabel()}, Stmts.nLabel())));
  }

  /**
   * Method under test: {@link Cfg#createCfgWithoutEx(IrMethod)}
   */
  @Test
  public void testCreateCfgWithoutEx() {
    // Arrange
    IrMethod jm = new IrMethod();

    // Act
    Cfg.createCfgWithoutEx(jm);

    // Assert
    StmtList stmtList = jm.stmts;
    assertNull(stmtList.getFirst());
    assertNull(stmtList.getLast());
  }

  /**
   * Method under test: {@link Cfg#createCfgWithoutEx(IrMethod)}
   */
  @Test
  public void testCreateCfgWithoutEx2() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt stmt = Stmts.nLabel();
    stmtList.add(stmt);
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCfgWithoutEx(jm);

    // Assert
    StmtList stmtList2 = jm.stmts;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
  }

  /**
   * Method under test: {@link Cfg#createCfgWithoutEx(IrMethod)}
   */
  @Test
  public void testCreateCfgWithoutEx3() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt stmt = Stmts.nLabel();
    stmtList.add(stmt);
    LabelStmt stmt2 = Stmts.nLabel();
    stmtList.add(stmt2);
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCfgWithoutEx(jm);

    // Assert
    StmtList stmtList2 = jm.stmts;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt2, stmtList2.getLast());
  }

  /**
   * Method under test: {@link Cfg#createCfgWithoutEx(IrMethod)}
   */
  @Test
  public void testCreateCfgWithoutEx4() {
    // Arrange
    StmtList stmtList = new StmtList();
    GotoStmt stmt = new GotoStmt(null);
    stmtList.add(stmt);
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCfgWithoutEx(jm);

    // Assert
    StmtList stmtList2 = jm.stmts;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
  }

  /**
   * Method under test: {@link Cfg#createCfgWithoutEx(IrMethod)}
   */
  @Test
  public void testCreateCfgWithoutEx5() {
    // Arrange
    StmtList stmtList = new StmtList();
    LookupSwitchStmt stmt = new LookupSwitchStmt(new ArrayExpr(), new int[]{42, 1, 42, 1}, new LabelStmt[]{null}, null);

    stmtList.add(stmt);
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCfgWithoutEx(jm);

    // Assert
    StmtList stmtList2 = jm.stmts;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
  }

  /**
   * Method under test: {@link Cfg#createCFG(IrMethod)}
   */
  @Test
  public void testCreateCFG() {
    // Arrange
    IrMethod jm = new IrMethod();

    // Act
    Cfg.createCFG(jm);

    // Assert
    StmtList stmtList = jm.stmts;
    assertNull(stmtList.getFirst());
    assertNull(stmtList.getLast());
  }

  /**
   * Method under test: {@link Cfg#createCFG(IrMethod)}
   */
  @Test
  public void testCreateCFG2() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt stmt = Stmts.nLabel();
    stmtList.add(stmt);
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCFG(jm);

    // Assert
    StmtList stmtList2 = jm.stmts;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
  }

  /**
   * Method under test: {@link Cfg#createCFG(IrMethod)}
   */
  @Test
  public void testCreateCFG3() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt stmt = Stmts.nLabel();
    stmtList.add(stmt);
    LabelStmt stmt2 = Stmts.nLabel();
    stmtList.add(stmt2);
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCFG(jm);

    // Assert
    StmtList stmtList2 = jm.stmts;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt2, stmtList2.getLast());
  }

  /**
   * Method under test: {@link Cfg#createCFG(IrMethod)}
   */
  @Test
  public void testCreateCFG4() {
    // Arrange
    StmtList stmtList = new StmtList();
    GotoStmt stmt = new GotoStmt(null);
    stmtList.add(stmt);
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCFG(jm);

    // Assert
    StmtList stmtList2 = jm.stmts;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
  }

  /**
   * Method under test: {@link Cfg#createCFG(IrMethod)}
   */
  @Test
  public void testCreateCFG5() {
    // Arrange
    StmtList stmtList = new StmtList();
    LookupSwitchStmt stmt = new LookupSwitchStmt(new ArrayExpr(), new int[]{42, 1, 42, 1}, new LabelStmt[]{null}, null);

    stmtList.add(stmt);
    IrMethod jm = new IrMethod();
    jm.stmts = stmtList;

    // Act
    Cfg.createCFG(jm);

    // Assert
    StmtList stmtList2 = jm.stmts;
    assertSame(stmt, stmtList2.getFirst());
    assertSame(stmt, stmtList2.getLast());
  }

  /**
   * Method under test: {@link Cfg#dfsVisit(IrMethod, Cfg.DfsVisitor)}
   */
  @Test
  public void testDfsVisit() {
    // Arrange
    StmtList stmtList = new StmtList();
    ReturnVoidStmt stmt = Stmts.nReturnVoid();
    stmtList.add(stmt);
    IrMethod method = new IrMethod();
    method.stmts = stmtList;

    // Act
    Cfg.dfsVisit(method, null);

    // Assert
    Stmt first = method.stmts.getFirst();
    assertTrue(first instanceof ReturnVoidStmt);
    assertTrue(((ReturnVoidStmt) first).visited);
    assertSame(stmt, first);
  }

  /**
   * Method under test: {@link Cfg#travelMod(Value, Cfg.OnUseCallBack)}
   */
  @Test
  public void testTravelMod() {
    // Arrange
    Constant value = Exprs.nNull();

    // Act
    Value actualTravelModResult = Cfg.travelMod(value, new AggTransformer.ReplaceX());

    // Assert
    assertTrue(actualTravelModResult instanceof Constant);
    assertNull(actualTravelModResult.getOps());
    assertNull(((Constant) actualTravelModResult).tag);
    assertNull(((Constant) actualTravelModResult).valueType);
    assertNull(actualTravelModResult.getOp());
    assertNull(actualTravelModResult.getOp1());
    assertNull(actualTravelModResult.getOp2());
    assertEquals(ET.E0, ((Constant) actualTravelModResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) actualTravelModResult).vt);
  }

  /**
   * Method under test: {@link Cfg#travelMod(Value, Cfg.OnUseCallBack)}
   */
  @Test
  public void testTravelMod2() {
    // Arrange
    Local value = new Local();

    // Act
    Value actualTravelModResult = Cfg.travelMod(value, new AggTransformer.ReplaceX());

    // Assert
    assertTrue(actualTravelModResult instanceof Local);
    assertEquals("a0", ((Local) actualTravelModResult).toString0());
    assertNull(actualTravelModResult.getOps());
    assertNull(((Local) actualTravelModResult).tag);
    assertNull(((Local) actualTravelModResult).debugName);
    assertNull(((Local) actualTravelModResult).signature);
    assertNull(((Local) actualTravelModResult).valueType);
    assertNull(actualTravelModResult.getOp());
    assertNull(actualTravelModResult.getOp1());
    assertNull(actualTravelModResult.getOp2());
    assertEquals(0, ((Local) actualTravelModResult)._ls_index);
    assertEquals(ET.E0, ((Local) actualTravelModResult).et);
    assertEquals(Value.VT.LOCAL, ((Local) actualTravelModResult).vt);
  }

  /**
   * Method under test: {@link Cfg#travelMod(Value, Cfg.OnUseCallBack)}
   */
  @Test
  public void testTravelMod3() {
    // Arrange
    Constant value = Exprs.nNull();
    CastExpr value2 = new CastExpr(value, "jane.doe@example.org", "alice.liddell@example.org");

    // Act
    Value actualTravelModResult = Cfg.travelMod(value2, new AggTransformer.ReplaceX());

    // Assert
    assertTrue(actualTravelModResult instanceof CastExpr);
    assertEquals("alice.liddell@example.org", ((CastExpr) actualTravelModResult).to);
    assertEquals("jane.doe@example.org", ((CastExpr) actualTravelModResult).from);
    assertNull(actualTravelModResult.getOps());
    assertNull(((CastExpr) actualTravelModResult).tag);
    assertNull(((CastExpr) actualTravelModResult).valueType);
    assertNull(actualTravelModResult.getOp1());
    assertNull(actualTravelModResult.getOp2());
    assertEquals(ET.E1, ((CastExpr) actualTravelModResult).et);
    assertEquals(Value.VT.CAST, ((CastExpr) actualTravelModResult).vt);
    assertSame(value, actualTravelModResult.getOp());
  }

  /**
   * Method under test: {@link Cfg#travelMod(Value, Cfg.OnUseCallBack)}
   */
  @Test
  public void testTravelMod4() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    FilledArrayExpr value = new FilledArrayExpr(new Value[]{nNullResult}, "Type");

    // Act
    Value actualTravelModResult = Cfg.travelMod(value, new AggTransformer.ReplaceX());

    // Assert
    assertTrue(actualTravelModResult instanceof FilledArrayExpr);
    assertEquals("Type", ((FilledArrayExpr) actualTravelModResult).type);
    assertNull(((FilledArrayExpr) actualTravelModResult).tag);
    assertNull(((FilledArrayExpr) actualTravelModResult).valueType);
    assertNull(actualTravelModResult.getOp());
    assertNull(actualTravelModResult.getOp1());
    assertNull(actualTravelModResult.getOp2());
    Value[] ops = actualTravelModResult.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, ((FilledArrayExpr) actualTravelModResult).et);
    assertEquals(Value.VT.FILLED_ARRAY, ((FilledArrayExpr) actualTravelModResult).vt);
    assertSame(nNullResult, ops[0]);
  }

  /**
   * Method under test: {@link Cfg#travelMod(Value, Cfg.OnUseCallBack)}
   */
  @Test
  public void testTravelMod5() {
    // Arrange
    Constant base = Exprs.nNull();
    Constant index = Exprs.nNull();
    ArrayExpr value = new ArrayExpr(base, index, "Element Type");

    // Act
    Value actualTravelModResult = Cfg.travelMod(value, new AggTransformer.ReplaceX());

    // Assert
    assertTrue(actualTravelModResult instanceof ArrayExpr);
    assertEquals("Element Type", ((ArrayExpr) actualTravelModResult).elementType);
    assertEquals("null[null]", ((ArrayExpr) actualTravelModResult).toString0());
    assertNull(actualTravelModResult.getOps());
    assertNull(((ArrayExpr) actualTravelModResult).tag);
    assertNull(((ArrayExpr) actualTravelModResult).valueType);
    assertNull(actualTravelModResult.getOp());
    assertEquals(ET.E2, ((ArrayExpr) actualTravelModResult).et);
    assertEquals(Value.VT.ARRAY, ((ArrayExpr) actualTravelModResult).vt);
    assertSame(base, actualTravelModResult.getOp1());
    assertSame(index, actualTravelModResult.getOp2());
  }

  /**
   * Method under test: {@link Cfg#reIndexLocal(IrMethod)}
   */
  @Test
  public void testReIndexLocal() {
    // Arrange, Act and Assert
    assertEquals(0, Cfg.reIndexLocal(new IrMethod()));
  }

  /**
   * Method under test: {@link Cfg#collectTos(Stmt, Set)}
   */
  @Test
  public void testCollectTos() {
    // Arrange
    LabelStmt stmt = Stmts.nLabel();
    HashSet<Stmt> tos = new HashSet<>();

    // Act
    Cfg.collectTos(stmt, tos);

    // Assert
    assertEquals(1, tos.size());
  }

  /**
   * Method under test: {@link Cfg#collectTos(Stmt, Set)}
   */
  @Test
  public void testCollectTos2() {
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
   * Method under test: {@link Cfg#collectTos(Stmt, Set)}
   */
  @Test
  public void testCollectTos3() {
    // Arrange
    GotoStmt stmt = new GotoStmt(Stmts.nLabel());
    HashSet<Stmt> tos = new HashSet<>();

    // Act
    Cfg.collectTos(stmt, tos);

    // Assert
    assertEquals(1, tos.size());
  }

  /**
   * Method under test: {@link Cfg#collectTos(Stmt, Set)}
   */
  @Test
  public void testCollectTos4() {
    // Arrange
    ArrayExpr key = new ArrayExpr();
    LookupSwitchStmt stmt = new LookupSwitchStmt(key, new int[]{42, 2, 42, 2}, new LabelStmt[]{Stmts.nLabel()},
        Stmts.nLabel());

    HashSet<Stmt> tos = new HashSet<>();

    // Act
    Cfg.collectTos(stmt, tos);

    // Assert
    assertEquals(2, tos.size());
  }
}
