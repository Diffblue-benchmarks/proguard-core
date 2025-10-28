package proguard.dexfile.ir.ts.an;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.stmt.GotoStmt;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.LookupSwitchStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;

public class BaseAnalyzeDiffblueTest {
  /**
   * Method under test: {@link BaseAnalyze#analyze0()}
   */
  @Test
  public void testAnalyze0() {
    // Arrange
    IrMethod method = new IrMethod();
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.analyze0();

    // Assert
    StmtList stmtList = simpleLiveAnalyze.method.stmts;
    assertNull(stmtList.getFirst());
    assertSame(method.stmts, stmtList);
  }

  /**
   * Method under test: {@link BaseAnalyze#analyze0()}
   */
  @Test
  public void testAnalyze02() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nReturnVoid());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.analyze0();

    // Assert
    assertSame(stmtList, simpleLiveAnalyze.method.stmts);
  }

  /**
   * Method under test: {@link BaseAnalyze#exec(AnalyzeValue[], Stmt)}
   */
  @Test
  public void testExec() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue[] frame = new SimpleLiveValue[]{new SimpleLiveValue()};

    // Act and Assert
    assertSame(frame, simpleLiveAnalyze.exec(frame, Stmts.nLabel()));
  }

  /**
   * Method under test: {@link BaseAnalyze#getFrame(Stmt)}
   */
  @Test
  public void testGetFrame() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);

    // Act and Assert
    assertNull(simpleLiveAnalyze.getFrame(Stmts.nLabel()));
  }

  /**
   * Method under test: {@link BaseAnalyze#initCFG()}
   */
  @Test
  public void testInitCFG() {
    // Arrange
    IrMethod method = new IrMethod();
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.initCFG();

    // Assert
    assertSame(method.stmts, simpleLiveAnalyze.method.stmts);
  }

  /**
   * Method under test: {@link BaseAnalyze#initCFG()}
   */
  @Test
  public void testInitCFG2() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.initCFG();

    // Assert
    assertSame(stmtList, simpleLiveAnalyze.method.stmts);
  }

  /**
   * Method under test: {@link BaseAnalyze#initCFG()}
   */
  @Test
  public void testInitCFG3() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    stmtList.add(Stmts.nLabel());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.initCFG();

    // Assert
    assertSame(stmtList, simpleLiveAnalyze.method.stmts);
  }

  /**
   * Method under test: {@link BaseAnalyze#initCFG()}
   */
  @Test
  public void testInitCFG4() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(new GotoStmt(null));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.initCFG();

    // Assert
    assertSame(stmtList, simpleLiveAnalyze.method.stmts);
  }

  /**
   * Method under test: {@link BaseAnalyze#initCFG()}
   */
  @Test
  public void testInitCFG5() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(new LookupSwitchStmt(new ArrayExpr(), new int[]{42, 1, 42, 1}, new LabelStmt[]{null}, null));
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.initCFG();

    // Assert
    assertSame(stmtList, simpleLiveAnalyze.method.stmts);
  }

  /**
   * Method under test: {@link BaseAnalyze#newFrame()}
   */
  @Test
  public void testNewFrame() {
    // Arrange, Act and Assert
    assertEquals(0, (new SimpleLiveAnalyze(new IrMethod(), true)).newFrame().length);
  }

  /**
   * Method under test: {@link BaseAnalyze#initFirstFrame(Stmt)}
   */
  @Test
  public void testInitFirstFrame() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);

    // Act and Assert
    assertEquals(0, simpleLiveAnalyze.initFirstFrame(Stmts.nLabel()).length);
  }
}
