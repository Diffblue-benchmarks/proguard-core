package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class ValueDiffblueTest {
  /**
   * Method under test: {@link Value.E1Expr#getOp()}
   */
  @Test
  public void testE1ExprGetOp() {
    // Arrange
    CastExpr nCastResult = Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act and Assert
    assertSame(nCastResult.op, nCastResult.getOp());
  }

  /**
   * Method under test: {@link Value.E1Expr#releaseMemory()}
   */
  @Test
  public void testE1ExprReleaseMemory() {
    // Arrange
    CastExpr nCastResult = Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act
    nCastResult.releaseMemory();

    // Assert
    assertEquals("(()null)", nCastResult.toString0());
    assertNull(nCastResult.from);
    assertNull(nCastResult.to);
    assertNull(nCastResult.getOp());
  }

  /**
   * Method under test: {@link Value.E2Expr#getOp1()}
   */
  @Test
  public void testE2ExprGetOp1() {
    // Arrange, Act and Assert
    assertNull((new ArrayExpr()).getOp1());
  }

  /**
   * Method under test: {@link Value.E2Expr#getOp2()}
   */
  @Test
  public void testE2ExprGetOp2() {
    // Arrange, Act and Assert
    assertNull((new ArrayExpr()).getOp2());
  }

  /**
   * Method under test: {@link Value.EnExpr#cloneOps()}
   */
  @Test
  public void testEnExprCloneOps() {
    // Arrange, Act and Assert
    assertEquals(0, Exprs.nPhi().cloneOps().length);
  }

  /**
   * Method under test: {@link Value.EnExpr#cloneOps(LabelAndLocalMapper)}
   */
  @Test
  public void testEnExprCloneOps2() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    PhiExpr nPhiResult = Exprs.nPhi(nNullResult);

    // Act
    Value[] actualCloneOpsResult = nPhiResult.cloneOps(new LabelAndLocalMapper());

    // Assert
    Value value = actualCloneOpsResult[0];
    assertTrue(value instanceof Constant);
    assertNull(value.getOps());
    assertNull(((Constant) value).tag);
    assertNull(((Constant) value).valueType);
    assertNull(value.getOp());
    assertNull(value.getOp1());
    assertNull(value.getOp2());
    assertEquals(1, actualCloneOpsResult.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Method under test: {@link Value.EnExpr#cloneOps(LabelAndLocalMapper)}
   */
  @Test
  public void testEnExprCloneOps3() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    PhiExpr nPhiResult = Exprs.nPhi(Exprs.nFilledArray("Element Type", new Value[]{nNullResult}));

    // Act
    Value[] actualCloneOpsResult = nPhiResult.cloneOps(new LabelAndLocalMapper());

    // Assert
    Value value = actualCloneOpsResult[0];
    Value[] ops = value.getOps();
    Value value2 = ops[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof FilledArrayExpr);
    assertEquals("Element Type", ((FilledArrayExpr) value).type);
    assertNull(value2.getOps());
    assertNull(((Constant) value2).tag);
    assertNull(((FilledArrayExpr) value).tag);
    assertNull(((Constant) value2).valueType);
    assertNull(((FilledArrayExpr) value).valueType);
    assertNull(value2.getOp());
    assertNull(value.getOp());
    assertNull(value2.getOp1());
    assertNull(value.getOp1());
    assertNull(value2.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops.length);
    assertEquals(1, actualCloneOpsResult.length);
    assertEquals(ET.E0, ((Constant) value2).et);
    assertEquals(ET.En, ((FilledArrayExpr) value).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.FILLED_ARRAY, ((FilledArrayExpr) value).vt);
    assertSame(nNullResult.value, ((Constant) value2).value);
  }

  /**
   * Method under test: {@link Value.EnExpr#cloneOps(LabelAndLocalMapper)}
   */
  @Test
  public void testEnExprCloneOps4() {
    // Arrange
    Constant obj = Exprs.nNull();
    PhiExpr nPhiResult = Exprs.nPhi(Exprs.nCast(obj, "jane.doe@example.org", "alice.liddell@example.org"));

    // Act
    Value[] actualCloneOpsResult = nPhiResult.cloneOps(new LabelAndLocalMapper());

    // Assert
    Value value = actualCloneOpsResult[0];
    assertTrue(value instanceof CastExpr);
    Value op = value.getOp();
    assertTrue(op instanceof Constant);
    assertEquals("alice.liddell@example.org", ((CastExpr) value).to);
    assertEquals("jane.doe@example.org", ((CastExpr) value).from);
    assertNull(op.getOps());
    assertNull(value.getOps());
    assertNull(((CastExpr) value).tag);
    assertNull(((Constant) op).tag);
    assertNull(((CastExpr) value).valueType);
    assertNull(((Constant) op).valueType);
    assertNull(op.getOp());
    assertNull(op.getOp1());
    assertNull(value.getOp1());
    assertNull(op.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, actualCloneOpsResult.length);
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(ET.E1, ((CastExpr) value).et);
    assertEquals(Value.VT.CAST, ((CastExpr) value).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op).vt);
    assertSame(obj.value, ((Constant) op).value);
  }

  /**
   * Method under test: {@link Value.EnExpr#getOps()}
   */
  @Test
  public void testEnExprGetOps() {
    // Arrange
    PhiExpr nPhiResult = Exprs.nPhi(new ArrayExpr());

    // Act and Assert
    assertSame(nPhiResult.ops, nPhiResult.getOps());
  }

  /**
   * Method under test: {@link Value.EnExpr#releaseMemory()}
   */
  @Test
  public void testEnExprReleaseMemory() {
    // Arrange
    PhiExpr nPhiResult = Exprs.nPhi(new ArrayExpr());

    // Act
    nPhiResult.releaseMemory();

    // Assert
    assertNull(nPhiResult.getOps());
  }

  /**
   * Method under test: {@link Value.EnExpr#setOps(Value[])}
   */
  @Test
  public void testEnExprSetOps() {
    // Arrange
    PhiExpr nPhiResult = Exprs.nPhi(new ArrayExpr());
    Value[] ops = new Value[]{new ArrayExpr()};

    // Act
    nPhiResult.setOps(ops);

    // Assert
    assertSame(ops, nPhiResult.getOps());
  }

  /**
   * Method under test: {@link Value#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("null[null]", (new ArrayExpr()).toString());
  }

  /**
   * Method under test: {@link Value#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null][null]", arrayExpr.toString());
  }

  /**
   * Method under test: {@link Value#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals("null[null][null[null]]", Exprs.nArray(base, new ArrayExpr(), "[").toString());
  }

  /**
   * Method under test: {@link Value#trim()}
   */
  @Test
  public void testTrim() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();

    // Act and Assert
    assertSame(arrayExpr, arrayExpr.trim());
  }

  /**
   * Method under test: {@link Value#getOp()}
   */
  @Test
  public void testGetOp() {
    // Arrange, Act and Assert
    assertNull((new ArrayExpr()).getOp());
  }

  /**
   * Method under test: {@link Value#getOp1()}
   */
  @Test
  public void testGetOp1() {
    // Arrange, Act and Assert
    assertNull((new Local()).getOp1());
  }

  /**
   * Method under test: {@link Value#getOp2()}
   */
  @Test
  public void testGetOp2() {
    // Arrange, Act and Assert
    assertNull((new Local()).getOp2());
  }

  /**
   * Method under test: {@link Value#getOps()}
   */
  @Test
  public void testGetOps() {
    // Arrange, Act and Assert
    assertNull((new ArrayExpr()).getOps());
  }

  /**
   * Method under test: {@link Value.VT#canThrow()}
   */
  @Test
  public void testVTCanThrow() {
    // Arrange, Act and Assert
    assertFalse(Value.VT.ADD.canThrow());
    assertTrue(Value.VT.ARRAY.canThrow());
  }

  /**
   * Method under test: {@link Value.VT#mayThrow()}
   */
  @Test
  public void testVTMayThrow() {
    // Arrange, Act and Assert
    assertTrue(Value.VT.ADD.mayThrow());
    assertFalse(Value.VT.ARRAY.mayThrow());
  }

  /**
   * Method under test: {@link Value.VT#toString()}
   */
  @Test
  public void testVTToString() {
    // Arrange, Act and Assert
    assertEquals("+", Value.VT.ADD.toString());
    assertEquals("ARRAY", Value.VT.ARRAY.toString());
  }
}
