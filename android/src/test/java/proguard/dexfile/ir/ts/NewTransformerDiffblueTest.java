package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.NewExpr;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmts;

public class NewTransformerDiffblueTest {
  /**
   * Method under test:
   * {@link NewTransformer#makeSureUsedBeforeConstructor(IrMethod, Map, int)}
   */
  @Test
  public void testMakeSureUsedBeforeConstructor() {
    // Arrange
    NewTransformer newTransformer = new NewTransformer();
    IrMethod method = new IrMethod();
    HashMap<Local, NewTransformer.TObject> init = new HashMap<>();

    // Act
    newTransformer.makeSureUsedBeforeConstructor(method, init, 3);

    // Assert
    assertTrue(init.isEmpty());
  }

  /**
   * Method under test:
   * {@link NewTransformer#makeSureUsedBeforeConstructor(IrMethod, Map, int)}
   */
  @Test
  public void testMakeSureUsedBeforeConstructor2() {
    // Arrange
    NewTransformer newTransformer = new NewTransformer();
    IrMethod method = new IrMethod();

    HashMap<Local, NewTransformer.TObject> init = new HashMap<>();
    Local local = new Local();
    Local local2 = new Local();
    init.put(local, new NewTransformer.TObject(local2, Exprs.nNew("Type")));

    // Act
    newTransformer.makeSureUsedBeforeConstructor(method, init, 3);

    // Assert
    assertTrue(init.isEmpty());
  }

  /**
   * Method under test: {@link NewTransformer#findInvokeExpr(Stmt)}
   */
  @Test
  public void testFindInvokeExpr() {
    // Arrange
    NewTransformer newTransformer = new NewTransformer();

    // Act and Assert
    assertNull(newTransformer.findInvokeExpr(Stmts.nLabel()));
  }

  /**
   * Method under test: {@link NewTransformer#findInvokeExpr(Stmt)}
   */
  @Test
  public void testFindInvokeExpr2() {
    // Arrange
    NewTransformer newTransformer = new NewTransformer();
    ArrayExpr left = new ArrayExpr();

    // Act and Assert
    assertNull(newTransformer.findInvokeExpr(new AssignStmt(Stmt.ST.ASSIGN, left, new ArrayExpr())));
  }

  /**
   * Method under test: {@link NewTransformer.TObject#TObject(Local, NewExpr)}
   */
  @Test
  public void testTObjectNewTObject() {
    // Arrange
    Local local = new Local();

    // Act and Assert
    Local local2 = (new NewTransformer.TObject(local, Exprs.nNew("Type"))).local;
    assertEquals("a0", local2.toString0());
    assertNull(local2.getOps());
    assertNull(local2.getOp());
    assertNull(local2.getOp1());
    assertNull(local2.getOp2());
  }

  /**
   * Method under test:
   * {@link NewTransformer.Vx#Vx(NewTransformer.TObject, boolean)}
   */
  @Test
  public void testVxNewVx() {
    // Arrange
    Local local = new Local();
    NewTransformer.TObject obj = new NewTransformer.TObject(local, Exprs.nNew("Type"));

    // Act
    NewTransformer.Vx actualVx = new NewTransformer.Vx(obj, true);

    // Assert
    NewTransformer.TObject tObject = actualVx.obj;
    assertNull(tObject.invokeStmt);
    assertFalse(tObject.useBeforeInit);
    assertTrue(actualVx.init);
    assertSame(obj.local, tObject.local);
  }
}
