package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.InvokeExpr;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.NewExpr;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.ir.stmt.Stmts;
import proguard.dexfile.ir.ts.NewTransformer.TObject;
import proguard.dexfile.ir.ts.NewTransformer.Vx;

class NewTransformerDiffblueTest {
  /**
   * Test {@link NewTransformer#makeSureUsedBeforeConstructor(IrMethod, Map, int)}.
   *
   * <ul>
   *   <li>Given {@link TObject#TObject(Local, NewExpr)} with local is {@link Local#Local()} and
   *       init is nNew {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link NewTransformer#makeSureUsedBeforeConstructor(IrMethod, Map, int)}
   */
  @Test
  @DisplayName(
      "Test makeSureUsedBeforeConstructor(IrMethod, Map, int); given TObject(Local, NewExpr) with local is Local() and init is nNew 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NewTransformer.makeSureUsedBeforeConstructor(IrMethod, Map, int)"})
  void testMakeSureUsedBeforeConstructor_givenTObjectWithLocalIsLocalAndInitIsNNewType() {
    // Arrange
    NewTransformer newTransformer = new NewTransformer();
    IrMethod method = new IrMethod();

    HashMap<Local, TObject> init = new HashMap<>();
    Local local = new Local();
    Local local2 = new Local();
    TObject tObject = new TObject(local2, Exprs.nNew("Type"));

    init.put(local, tObject);

    // Act
    newTransformer.makeSureUsedBeforeConstructor(method, init, 3);

    // Assert
    assertTrue(init.isEmpty());
  }

  /**
   * Test {@link NewTransformer#makeSureUsedBeforeConstructor(IrMethod, Map, int)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link NewTransformer#makeSureUsedBeforeConstructor(IrMethod, Map, int)}
   */
  @Test
  @DisplayName(
      "Test makeSureUsedBeforeConstructor(IrMethod, Map, int); when HashMap(); then HashMap() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NewTransformer.makeSureUsedBeforeConstructor(IrMethod, Map, int)"})
  void testMakeSureUsedBeforeConstructor_whenHashMap_thenHashMapEmpty() {
    // Arrange
    NewTransformer newTransformer = new NewTransformer();
    IrMethod method = new IrMethod();
    HashMap<Local, TObject> init = new HashMap<>();

    // Act
    newTransformer.makeSureUsedBeforeConstructor(method, init, 3);

    // Assert that nothing has changed
    assertTrue(init.isEmpty());
  }

  /**
   * Test {@link NewTransformer#findInvokeExpr(Stmt)}.
   *
   * <p>Method under test: {@link NewTransformer#findInvokeExpr(Stmt)}
   */
  @Test
  @DisplayName("Test findInvokeExpr(Stmt)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr NewTransformer.findInvokeExpr(Stmt)"})
  void testFindInvokeExpr() {
    // Arrange
    NewTransformer newTransformer = new NewTransformer();
    ArrayExpr left = new ArrayExpr();
    AssignStmt p = new AssignStmt(ST.ASSIGN, left, new ArrayExpr());

    // Act
    InvokeExpr actualFindInvokeExprResult = newTransformer.findInvokeExpr(p);

    // Assert
    assertNull(actualFindInvokeExprResult);
  }

  /**
   * Test {@link NewTransformer#findInvokeExpr(Stmt)}.
   *
   * <ul>
   *   <li>When nLabel.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NewTransformer#findInvokeExpr(Stmt)}
   */
  @Test
  @DisplayName("Test findInvokeExpr(Stmt); when nLabel; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr NewTransformer.findInvokeExpr(Stmt)"})
  void testFindInvokeExpr_whenNLabel_thenReturnNull() {
    // Arrange
    NewTransformer newTransformer = new NewTransformer();

    // Act and Assert
    assertNull(newTransformer.findInvokeExpr(Stmts.nLabel()));
  }

  /**
   * Test TObject {@link TObject#TObject(Local, NewExpr)}.
   *
   * <p>Method under test: {@link TObject#TObject(Local, NewExpr)}
   */
  @Test
  @DisplayName("Test TObject new TObject(Local, NewExpr)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TObject.<init>(Local, NewExpr)"})
  void testTObjectNewTObject() {
    // Arrange
    Local local = new Local();

    // Act
    TObject actualTObject = new TObject(local, Exprs.nNew("Type"));

    // Assert
    Local local2 = actualTObject.local;
    assertEquals("a0", local2.toString0());
    assertNull(local2.getOp());
    assertNull(local2.getOp1());
    assertNull(local2.getOp2());
    assertNull(local2.getOps());
  }

  /**
   * Test Vx {@link Vx#Vx(TObject, boolean)}.
   *
   * <p>Method under test: {@link Vx#Vx(TObject, boolean)}
   */
  @Test
  @DisplayName("Test Vx new Vx(TObject, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Vx.<init>(TObject, boolean)"})
  void testVxNewVx() {
    // Arrange
    Local local = new Local();
    TObject obj = new TObject(local, Exprs.nNew("Type"));

    // Act
    Vx actualVx = new Vx(obj, true);

    // Assert
    TObject tObject = actualVx.obj;
    assertNull(tObject.invokeStmt);
    assertFalse(tObject.useBeforeInit);
    assertTrue(actualVx.init);
    assertSame(obj.local, tObject.local);
  }
}
