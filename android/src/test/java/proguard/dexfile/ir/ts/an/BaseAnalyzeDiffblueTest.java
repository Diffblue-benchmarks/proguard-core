package proguard.dexfile.ir.ts.an;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.stmt.GotoStmt;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.LookupSwitchStmt;
import proguard.dexfile.ir.stmt.ReturnVoidStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;

class BaseAnalyzeDiffblueTest {
  /**
   * Test {@link BaseAnalyze#analyze0()}.
   *
   * <p>Method under test: {@link BaseAnalyze#analyze0()}
   */
  @Test
  @DisplayName("Test analyze0()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAnalyze.analyze0()"})
  void testAnalyze0() {
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
  @DisplayName("Test exec(AnalyzeValue[], Stmt) with 'SimpleLiveValue[]', 'Stmt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AnalyzeValue[] BaseAnalyze.exec(AnalyzeValue[], Stmt)"})
  void testExecWithSimpleLiveValueStmt() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue[] frame = new SimpleLiveValue[] {new SimpleLiveValue()};

    // Act
    SimpleLiveValue[] actualExecResult = simpleLiveAnalyze.exec(frame, Stmts.nLabel());

    // Assert
    assertSame(frame, actualExecResult);
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
  @DisplayName("Test getFrame(Stmt); when nLabel; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AnalyzeValue[] BaseAnalyze.getFrame(Stmt)"})
  void testGetFrame_whenNLabel_thenReturnNull() {
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
  @DisplayName("Test initCFG()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAnalyze.initCFG()"})
  void testInitCFG() {
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
  @DisplayName("Test initCFG()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAnalyze.initCFG()"})
  void testInitCFG2() {
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
  @DisplayName("Test initCFG()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAnalyze.initCFG()"})
  void testInitCFG3() {
    // Arrange
    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nReturnVoid());
    IrMethod method = new IrMethod();
    method.stmts = stmtList;
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Act
    simpleLiveAnalyze.initCFG();

    // Assert
    Stmt first = simpleLiveAnalyze.method.stmts.getFirst();
    assertTrue(first instanceof ReturnVoidStmt);
    assertTrue(((ReturnVoidStmt) first)._cfg_froms.isEmpty());
  }

  /**
   * Test {@link BaseAnalyze#initCFG()}.
   *
   * <p>Method under test: {@link BaseAnalyze#initCFG()}
   */
  @Test
  @DisplayName("Test initCFG()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAnalyze.initCFG()"})
  void testInitCFG4() {
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
  @DisplayName("Test initCFG()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAnalyze.initCFG()"})
  void testInitCFG5() {
    // Arrange
    StmtList stmtList = new StmtList();
    LabelStmt[] targets = new LabelStmt[] {null};
    LookupSwitchStmt stmt =
        new LookupSwitchStmt(new ArrayExpr(), new int[] {42, 1, 42, 1}, targets, null);
    stmtList.add(stmt);
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
  @DisplayName("Test newFrame()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AnalyzeValue[] BaseAnalyze.newFrame()"})
  void testNewFrame() {
    // Arrange, Act and Assert
    assertEquals(0, new SimpleLiveAnalyze(new IrMethod(), true).newFrame().length);
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
  @DisplayName("Test toString(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BaseAnalyze.toString()"})
  void testToString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new SimpleLiveAnalyze(new IrMethod(), true).toString());
  }

  /**
   * Test {@link BaseAnalyze#initFirstFrame(Stmt)}.
   *
   * <p>Method under test: {@link BaseAnalyze#initFirstFrame(Stmt)}
   */
  @Test
  @DisplayName("Test initFirstFrame(Stmt)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AnalyzeValue[] BaseAnalyze.initFirstFrame(Stmt)"})
  void testInitFirstFrame() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);

    // Act and Assert
    assertEquals(0, simpleLiveAnalyze.initFirstFrame(Stmts.nLabel()).length);
  }
}
