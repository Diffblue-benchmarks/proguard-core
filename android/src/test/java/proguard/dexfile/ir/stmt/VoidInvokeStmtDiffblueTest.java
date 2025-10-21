package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.CastExpr;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.ir.stmt.Stmt.ST;

public class VoidInvokeStmtDiffblueTest {
  /**
   * Test {@link VoidInvokeStmt#VoidInvokeStmt(Value)}.
   *
   * <p>Method under test: {@link VoidInvokeStmt#VoidInvokeStmt(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void VoidInvokeStmt.<init>(Value)"})
  public void testNewVoidInvokeStmt() {
    // Arrange
    ArrayExpr op = new ArrayExpr();

    // Act
    VoidInvokeStmt actualVoidInvokeStmt = new VoidInvokeStmt(op);

    // Assert
    Value op2 = actualVoidInvokeStmt.getOp();
    assertTrue(op2 instanceof ArrayExpr);
    assertNull(actualVoidInvokeStmt.getOps());
    assertNull(actualVoidInvokeStmt.frame);
    assertNull(actualVoidInvokeStmt.exceptionHandlers);
    assertNull(actualVoidInvokeStmt._cfg_froms);
    assertNull(actualVoidInvokeStmt.getOp1());
    assertNull(actualVoidInvokeStmt.getOp2());
    assertNull(actualVoidInvokeStmt.getNext());
    assertNull(actualVoidInvokeStmt.getPre());
    assertNull(actualVoidInvokeStmt._ts_default_next);
    assertNull(actualVoidInvokeStmt.list);
    assertEquals(0, actualVoidInvokeStmt.id);
    assertEquals(ET.E1, actualVoidInvokeStmt.et);
    assertEquals(ST.VOID_INVOKE, actualVoidInvokeStmt.st);
    assertFalse(actualVoidInvokeStmt.visited);
    assertSame(op, op2);
  }

  /**
   * Test {@link VoidInvokeStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Given nVoidInvoke nNull.
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link VoidInvokeStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt VoidInvokeStmt.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_givenNVoidInvokeNNull_thenOpReturnConstant() {
    // Arrange
    Constant op = Exprs.nNull();
    VoidInvokeStmt nVoidInvokeResult = Stmts.nVoidInvoke(op);

    // Act
    Stmt actualCloneResult = nVoidInvokeResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op2 = actualCloneResult.getOp();
    assertTrue(op2 instanceof Constant);
    assertTrue(actualCloneResult instanceof VoidInvokeStmt);
    assertNull(op2.getOp());
    assertEquals(ET.E0, ((Constant) op2).et);
    assertEquals(VT.CONSTANT, ((Constant) op2).vt);
    assertSame(op.value, ((Constant) op2).value);
  }

  /**
   * Test {@link VoidInvokeStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link VoidInvokeStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt VoidInvokeStmt.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenOpReturnCastExpr() {
    // Arrange
    VoidInvokeStmt nVoidInvokeResult =
        Stmts.nVoidInvoke(
            new CastExpr(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org"));

    // Act
    Stmt actualCloneResult = nVoidInvokeResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof CastExpr);
    assertTrue(op.getOp() instanceof Constant);
    assertTrue(actualCloneResult instanceof VoidInvokeStmt);
    assertEquals("alice.liddell@example.org", ((CastExpr) op).to);
    assertEquals("jane.doe@example.org", ((CastExpr) op).from);
    assertEquals(ET.E1, ((CastExpr) op).et);
    assertEquals(VT.CAST, ((CastExpr) op).vt);
  }

  /**
   * Test {@link VoidInvokeStmt#toString()}.
   *
   * <p>Method under test: {@link VoidInvokeStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String VoidInvokeStmt.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("void null[null]", (new VoidInvokeStmt(new ArrayExpr())).toString());
  }
}
