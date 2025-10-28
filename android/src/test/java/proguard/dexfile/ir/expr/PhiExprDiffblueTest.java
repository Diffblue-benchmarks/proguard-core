package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class PhiExprDiffblueTest {
  /**
   * Method under test: {@link PhiExpr#clone()}
   */
  @Test
  public void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nPhi().clone();

    // Assert
    assertTrue(actualCloneResult instanceof PhiExpr);
    assertEquals("φ()", actualCloneResult.toString0());
    assertNull(((PhiExpr) actualCloneResult).tag);
    assertNull(((PhiExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(0, actualCloneResult.getOps().length);
    assertEquals(ET.En, ((PhiExpr) actualCloneResult).et);
    assertEquals(Value.VT.PHI, ((PhiExpr) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link PhiExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    PhiExpr nPhiResult = Exprs.nPhi(nNullResult);

    // Act
    Value actualCloneResult = nPhiResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof PhiExpr);
    assertEquals("φ(null)", actualCloneResult.toString0());
    assertNull(value.getOps());
    assertNull(((Constant) value).tag);
    assertNull(((PhiExpr) actualCloneResult).tag);
    assertNull(((Constant) value).valueType);
    assertNull(((PhiExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.En, ((PhiExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.PHI, ((PhiExpr) actualCloneResult).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Method under test: {@link PhiExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone3() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    PhiExpr nPhiResult = Exprs.nPhi(Exprs.nFilledArray("Element Type", new Value[]{nNullResult}));

    // Act
    Value actualCloneResult = nPhiResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof PhiExpr);
    assertEquals("Element Type", ((FilledArrayExpr) value).type);
    assertNull(value2.getOps());
    assertNull(((Constant) value2).tag);
    assertNull(((FilledArrayExpr) value).tag);
    assertNull(((PhiExpr) actualCloneResult).tag);
    assertNull(((Constant) value2).valueType);
    assertNull(((FilledArrayExpr) value).valueType);
    assertNull(((PhiExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(value2.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(value2.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertNull(value2.getOp2());
    assertEquals(1, ops.length);
    assertEquals(1, ops2.length);
    assertEquals(ET.E0, ((Constant) value2).et);
    assertEquals(ET.En, ((FilledArrayExpr) value).et);
    assertEquals(ET.En, ((PhiExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.FILLED_ARRAY, ((FilledArrayExpr) value).vt);
    assertEquals(Value.VT.PHI, ((PhiExpr) actualCloneResult).vt);
    assertSame(nNullResult.value, ((Constant) value2).value);
  }

  /**
   * Method under test: {@link PhiExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone4() {
    // Arrange
    Constant obj = Exprs.nNull();
    PhiExpr nPhiResult = Exprs.nPhi(Exprs.nCast(obj, "jane.doe@example.org", "alice.liddell@example.org"));

    // Act
    Value actualCloneResult = nPhiResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof CastExpr);
    Value op = value.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof PhiExpr);
    assertEquals("alice.liddell@example.org", ((CastExpr) value).to);
    assertEquals("jane.doe@example.org", ((CastExpr) value).from);
    assertNull(op.getOps());
    assertNull(value.getOps());
    assertNull(((CastExpr) value).tag);
    assertNull(((Constant) op).tag);
    assertNull(((PhiExpr) actualCloneResult).tag);
    assertNull(((CastExpr) value).valueType);
    assertNull(((Constant) op).valueType);
    assertNull(((PhiExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(op.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(op.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(op.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(ET.E1, ((CastExpr) value).et);
    assertEquals(ET.En, ((PhiExpr) actualCloneResult).et);
    assertEquals(Value.VT.CAST, ((CastExpr) value).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op).vt);
    assertEquals(Value.VT.PHI, ((PhiExpr) actualCloneResult).vt);
    assertSame(obj.value, ((Constant) op).value);
  }

  /**
   * Method under test: {@link PhiExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange, Act and Assert
    assertEquals("φ(null[null])", Exprs.nPhi(new ArrayExpr()).toString0());
  }

  /**
   * Method under test: {@link PhiExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("φ(null[null][null])", Exprs.nPhi(arrayExpr).toString0());
  }

  /**
   * Method under test: {@link PhiExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals("φ(null[null][null[null]])", Exprs.nPhi(Exprs.nArray(base, new ArrayExpr(), "φ(")).toString0());
  }

  /**
   * Method under test: {@link PhiExpr#toString0()}
   */
  @Test
  public void testToString04() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();

    // Act and Assert
    assertEquals("φ(null[null], null[null])", Exprs.nPhi(arrayExpr, new ArrayExpr()).toString0());
  }

  /**
   * Method under test: {@link PhiExpr#PhiExpr(Value[])}
   */
  @Test
  public void testNewPhiExpr() {
    // Arrange
    Value[] ops = new Value[]{new ArrayExpr()};

    // Act
    PhiExpr actualPhiExpr = new PhiExpr(ops);

    // Assert
    assertEquals("φ(null[null])", actualPhiExpr.toString0());
    assertNull(actualPhiExpr.tag);
    assertNull(actualPhiExpr.valueType);
    assertNull(actualPhiExpr.getOp());
    assertNull(actualPhiExpr.getOp1());
    assertNull(actualPhiExpr.getOp2());
    assertEquals(ET.En, actualPhiExpr.et);
    assertEquals(Value.VT.PHI, actualPhiExpr.vt);
    assertSame(ops, actualPhiExpr.getOps());
  }
}
