package proguard.dexfile.ir.ts.an;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.stmt.GotoStmt;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.LookupSwitchStmt;
import proguard.dexfile.ir.stmt.ReturnVoidStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;

public class BaseAnalyzeDiffblueTest {
  /**
   * Test {@link BaseAnalyze#analyze0()}.
   *
   * <p>Method under test: {@link BaseAnalyze#analyze0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseAnalyze.analyze0()"})
  public void testAnalyze0() {
    // Arrange
    StmtList stmtList = new StmtList();
    ReturnVoidStmt stmt = Stmts.nReturnVoid();
    stmtList.add(stmt);
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.analyze0();

    // Assert
    Stmt first = simpleLiveAnalyze.method.stmts.getFirst();
    Object object = ((ReturnVoidStmt) first).frame;
    assertTrue(object instanceof SimpleLiveValue[]);
    assertTrue(first instanceof ReturnVoidStmt);
    assertEquals(0, ((SimpleLiveValue[]) object).length);
    assertTrue(((ReturnVoidStmt) first).visited);
    assertSame(stmt.frame, object);
  }

  /**
   * Test {@link BaseAnalyze#exec(AnalyzeValue[], Stmt)} with {@code SimpleLiveValue[]}, {@code
   * Stmt}.
   *
   * <p>Method under test: {@link BaseAnalyze#exec(AnalyzeValue[], Stmt)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AnalyzeValue[] BaseAnalyze.exec(AnalyzeValue[], Stmt)"})
  public void testExecWithSimpleLiveValueStmt() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue[] frame = new SimpleLiveValue[] {new SimpleLiveValue()};

    // Act and Assert
    assertSame(frame, simpleLiveAnalyze.exec(frame, Stmts.nLabel()));
  }

  /**
   * Test {@link BaseAnalyze#getFrame(Stmt)}.
   *
   * <ul>
   *   <li>When nLabel.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAnalyze#getFrame(Stmt)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AnalyzeValue[] BaseAnalyze.getFrame(Stmt)"})
  public void testGetFrame_whenNLabel_thenReturnNull() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);

    // Act and Assert
    assertNull(simpleLiveAnalyze.getFrame(Stmts.nLabel()));
  }

  /**
   * Test {@link BaseAnalyze#initCFG()}.
   *
   * <p>Method under test: {@link BaseAnalyze#initCFG()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseAnalyze.initCFG()"})
  public void testInitCFG() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.initCFG();

    // Assert
    Stmt first = simpleLiveAnalyze.method.stmts.getFirst();
    assertTrue(first instanceof LabelStmt);
    assertTrue(((LabelStmt) first)._cfg_froms.isEmpty());
  }

  /**
   * Test {@link BaseAnalyze#initCFG()}.
   *
   * <p>Method under test: {@link BaseAnalyze#initCFG()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseAnalyze.initCFG()"})
  public void testInitCFG2() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    LabelStmt stmt = Stmts.nLabel();
    stmtList.add(stmt);
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.initCFG();

    // Assert
    StmtList stmtList2 = simpleLiveAnalyze.method.stmts;
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
   * Test {@link BaseAnalyze#initCFG()}.
   *
   * <p>Method under test: {@link BaseAnalyze#initCFG()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseAnalyze.initCFG()"})
  public void testInitCFG3() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(new GotoStmt(null));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.initCFG();

    // Assert
    Stmt first = simpleLiveAnalyze.method.stmts.getFirst();
    assertTrue(first instanceof GotoStmt);
    assertTrue(((GotoStmt) first)._cfg_froms.isEmpty());
  }

  /**
   * Test {@link BaseAnalyze#initCFG()}.
   *
   * <p>Method under test: {@link BaseAnalyze#initCFG()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseAnalyze.initCFG()"})
  public void testInitCFG4() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(
        new LookupSwitchStmt(
            new ArrayExpr(), new int[] {42, 1, 42, 1}, new LabelStmt[] {null}, null));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.initCFG();

    // Assert
    Stmt first = simpleLiveAnalyze.method.stmts.getFirst();
    assertTrue(first instanceof LookupSwitchStmt);
    assertTrue(((LookupSwitchStmt) first)._cfg_froms.isEmpty());
  }

  /**
   * Test {@link BaseAnalyze#newFrame()}.
   *
   * <p>Method under test: {@link BaseAnalyze#newFrame()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AnalyzeValue[] BaseAnalyze.newFrame()"})
  public void testNewFrame() {
    // Arrange, Act and Assert
    assertEquals(0, (new SimpleLiveAnalyze(new IrMethod(), true)).newFrame().length);
  }

  /**
   * Test {@link BaseAnalyze#toString()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseAnalyze#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String BaseAnalyze.toString()"})
  public void testToString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new SimpleLiveAnalyze(new IrMethod(), true)).toString());
  }

  /**
   * Test {@link BaseAnalyze#initFirstFrame(Stmt)}.
   *
   * <p>Method under test: {@link BaseAnalyze#initFirstFrame(Stmt)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AnalyzeValue[] BaseAnalyze.initFirstFrame(Stmt)"})
  public void testInitFirstFrame() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);

    // Act and Assert
    assertEquals(0, simpleLiveAnalyze.initFirstFrame(Stmts.nLabel()).length);
  }
}
