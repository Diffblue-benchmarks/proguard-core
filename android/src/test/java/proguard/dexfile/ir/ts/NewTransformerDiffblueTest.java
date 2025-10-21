package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.NewExpr;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.ir.stmt.Stmts;
import proguard.dexfile.ir.ts.NewTransformer.TObject;
import proguard.dexfile.ir.ts.NewTransformer.Vx;

public class NewTransformerDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NewTransformer.makeSureUsedBeforeConstructor(IrMethod, Map, int)"})
  public void testMakeSureUsedBeforeConstructor_givenTObjectWithLocalIsLocalAndInitIsNNewType() {
    // Arrange
    NewTransformer newTransformer = new NewTransformer();
    IrMethod method = new IrMethod();

    HashMap<Local, TObject> init = new HashMap<>();
    Local local = new Local();
    Local local2 = new Local();
    init.put(local, new TObject(local2, Exprs.nNew("Type")));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NewTransformer.makeSureUsedBeforeConstructor(IrMethod, Map, int)"})
  public void testMakeSureUsedBeforeConstructor_whenHashMap_thenHashMapEmpty() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.dexfile.ir.expr.InvokeExpr NewTransformer.findInvokeExpr(Stmt)"})
  public void testFindInvokeExpr() {
    // Arrange
    NewTransformer newTransformer = new NewTransformer();
    ArrayExpr left = new ArrayExpr();

    // Act and Assert
    assertNull(newTransformer.findInvokeExpr(new AssignStmt(ST.ASSIGN, left, new ArrayExpr())));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.dexfile.ir.expr.InvokeExpr NewTransformer.findInvokeExpr(Stmt)"})
  public void testFindInvokeExpr_whenNLabel_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TObject.<init>(Local, NewExpr)"})
  public void testTObjectNewTObject() {
    // Arrange
    Local local = new Local();

    // Act and Assert
    Local local2 = (new TObject(local, Exprs.nNew("Type"))).local;
    assertEquals("a0", local2.toString0());
    assertNull(local2.getOps());
    assertNull(local2.getOp());
    assertNull(local2.getOp1());
    assertNull(local2.getOp2());
  }

  /**
   * Test Vx {@link Vx#Vx(TObject, boolean)}.
   *
   * <p>Method under test: {@link Vx#Vx(TObject, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Vx.<init>(TObject, boolean)"})
  public void testVxNewVx() {
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
