package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class TypeExprDiffblueTest {
  /**
   * Method under test: {@link TypeExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    TypeExpr nCheckCastResult = Exprs.nCheckCast(new ArrayExpr(), "Type");

    // Act
    nCheckCastResult.releaseMemory();

    // Assert
    assertNull(nCheckCastResult.type);
    assertNull(nCheckCastResult.getOp());
  }

  /**
   * Method under test: {@link TypeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant obj = Exprs.nNull();
    TypeExpr nCheckCastResult = Exprs.nCheckCast(obj, "Type");

    // Act
    Value actualCloneResult = nCheckCastResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof TypeExpr);
    assertEquals("Type", ((TypeExpr) actualCloneResult).type);
    assertNull(actualCloneResult.getOps());
    assertNull(op.getOps());
    assertNull(((Constant) op).tag);
    assertNull(((TypeExpr) actualCloneResult).tag);
    assertNull(((Constant) op).valueType);
    assertNull(((TypeExpr) actualCloneResult).valueType);
    assertNull(op.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(op.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(op.getOp2());
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(ET.E1, ((TypeExpr) actualCloneResult).et);
    assertEquals(Value.VT.CHECK_CAST, ((TypeExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op).vt);
    assertSame(obj.value, ((Constant) op).value);
  }

  /**
   * Method under test: {@link TypeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant obj = Exprs.nNull();
    TypeExpr nCheckCastResult = Exprs.nCheckCast(Exprs.nCast(obj, "jane.doe@example.org", "alice.liddell@example.org"),
        "Type");

    // Act
    Value actualCloneResult = nCheckCastResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof CastExpr);
    Value op2 = op.getOp();
    assertTrue(op2 instanceof Constant);
    assertTrue(actualCloneResult instanceof TypeExpr);
    assertEquals("Type", ((TypeExpr) actualCloneResult).type);
    assertEquals("alice.liddell@example.org", ((CastExpr) op).to);
    assertEquals("jane.doe@example.org", ((CastExpr) op).from);
    assertNull(actualCloneResult.getOps());
    assertNull(op.getOps());
    assertNull(op2.getOps());
    assertNull(((CastExpr) op).tag);
    assertNull(((Constant) op2).tag);
    assertNull(((TypeExpr) actualCloneResult).tag);
    assertNull(((CastExpr) op).valueType);
    assertNull(((Constant) op2).valueType);
    assertNull(((TypeExpr) actualCloneResult).valueType);
    assertNull(op2.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(op.getOp1());
    assertNull(op2.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(op.getOp2());
    assertNull(op2.getOp2());
    assertEquals(ET.E0, ((Constant) op2).et);
    assertEquals(ET.E1, ((CastExpr) op).et);
    assertEquals(ET.E1, ((TypeExpr) actualCloneResult).et);
    assertEquals(Value.VT.CAST, ((CastExpr) op).vt);
    assertEquals(Value.VT.CHECK_CAST, ((TypeExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op2).vt);
    assertSame(obj.value, ((Constant) op2).value);
  }

  /**
   * Method under test: {@link TypeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone3() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    TypeExpr nCheckCastResult = Exprs.nCheckCast(Exprs.nFilledArray("Element Type", new Value[]{nNullResult}), "Type");

    // Act
    Value actualCloneResult = nCheckCastResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    Value[] ops = op.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(op instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof TypeExpr);
    assertEquals("Element Type", ((FilledArrayExpr) op).type);
    assertEquals("Type", ((TypeExpr) actualCloneResult).type);
    assertNull(actualCloneResult.getOps());
    assertNull(value.getOps());
    assertNull(((Constant) value).tag);
    assertNull(((FilledArrayExpr) op).tag);
    assertNull(((TypeExpr) actualCloneResult).tag);
    assertNull(((Constant) value).valueType);
    assertNull(((FilledArrayExpr) op).valueType);
    assertNull(((TypeExpr) actualCloneResult).valueType);
    assertNull(op.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(op.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(op.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.E1, ((TypeExpr) actualCloneResult).et);
    assertEquals(ET.En, ((FilledArrayExpr) op).et);
    assertEquals(Value.VT.CHECK_CAST, ((TypeExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.FILLED_ARRAY, ((FilledArrayExpr) op).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange, Act and Assert
    assertEquals("((double)null[null])", Exprs.nCheckCast(new ArrayExpr(), "D").toString0());
    assertEquals("(()null[null])", Exprs.nCheckCast(new ArrayExpr(), "").toString0());
    assertEquals("((float)null[null])", Exprs.nCheckCast(new ArrayExpr(), "F").toString0());
    assertEquals("((int)null[null])", Exprs.nCheckCast(new ArrayExpr(), "I").toString0());
    assertEquals("((double)null)", Exprs.nCheckCast(null, "D").toString0());
    assertEquals("(null[null] instanceof [])", Exprs.nInstanceOf(new ArrayExpr(), "[").toString0());
    assertEquals("new double[null[null]]", Exprs.nNewArray("D", new ArrayExpr()).toString0());
    assertEquals("new double[null]", Exprs.nNewArray("D", null).toString0());
    assertEquals("((long)null[null])", Exprs.nCheckCast(new ArrayExpr(), "J").toString0());
  }

  /**
   * Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();
    obj.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("((double)null[null][null])", Exprs.nCheckCast(obj, "D").toString0());
  }

  /**
   * Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals("((double)null[null][null[null]])",
        Exprs.nCheckCast(Exprs.nArray(base, new ArrayExpr(), "(("), "D").toString0());
  }

  /**
   * Method under test: {@link TypeExpr#TypeExpr(Value.VT, Value, String)}
   */
  @Test
  public void testNewTypeExpr() {
    // Arrange
    ArrayExpr value = new ArrayExpr();

    // Act
    TypeExpr actualTypeExpr = new TypeExpr(Value.VT.ADD, value, "The characteristics of someone or something");

    // Assert
    assertEquals("The characteristics of someone or something", actualTypeExpr.type);
    assertNull(actualTypeExpr.getOps());
    assertNull(actualTypeExpr.tag);
    assertNull(actualTypeExpr.valueType);
    assertNull(actualTypeExpr.getOp1());
    assertNull(actualTypeExpr.getOp2());
    assertEquals(ET.E1, actualTypeExpr.et);
    assertEquals(Value.VT.ADD, actualTypeExpr.vt);
    assertSame(value, actualTypeExpr.getOp());
  }
}
