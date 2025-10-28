package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class UnopExprDiffblueTest {
  /**
   * Method under test: {@link UnopExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    UnopExpr nLengthResult = Exprs.nLength(new ArrayExpr());

    // Act
    nLengthResult.releaseMemory();

    // Assert
    assertEquals("null.length", nLengthResult.toString0());
    assertNull(nLengthResult.getOp());
  }

  /**
   * Method under test: {@link UnopExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant array = Exprs.nNull();
    UnopExpr nLengthResult = Exprs.nLength(array);

    // Act
    Value actualCloneResult = nLengthResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof UnopExpr);
    assertEquals("null.length", actualCloneResult.toString0());
    assertNull(actualCloneResult.getOps());
    assertNull(op.getOps());
    assertNull(((Constant) op).tag);
    assertNull(((UnopExpr) actualCloneResult).tag);
    assertNull(((UnopExpr) actualCloneResult).type);
    assertNull(((Constant) op).valueType);
    assertNull(((UnopExpr) actualCloneResult).valueType);
    assertNull(op.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(op.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(op.getOp2());
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(ET.E1, ((UnopExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) op).vt);
    assertEquals(Value.VT.LENGTH, ((UnopExpr) actualCloneResult).vt);
    assertSame(array.value, ((Constant) op).value);
  }

  /**
   * Method under test: {@link UnopExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant obj = Exprs.nNull();
    UnopExpr nLengthResult = Exprs.nLength(Exprs.nCast(obj, "jane.doe@example.org", "alice.liddell@example.org"));

    // Act
    Value actualCloneResult = nLengthResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof CastExpr);
    Value op2 = op.getOp();
    assertTrue(op2 instanceof Constant);
    assertTrue(actualCloneResult instanceof UnopExpr);
    assertEquals("alice.liddell@example.org", ((CastExpr) op).to);
    assertEquals("jane.doe@example.org", ((CastExpr) op).from);
    assertNull(actualCloneResult.getOps());
    assertNull(op.getOps());
    assertNull(op2.getOps());
    assertNull(((CastExpr) op).tag);
    assertNull(((Constant) op2).tag);
    assertNull(((UnopExpr) actualCloneResult).tag);
    assertNull(((UnopExpr) actualCloneResult).type);
    assertNull(((CastExpr) op).valueType);
    assertNull(((Constant) op2).valueType);
    assertNull(((UnopExpr) actualCloneResult).valueType);
    assertNull(op2.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(op.getOp1());
    assertNull(op2.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(op.getOp2());
    assertNull(op2.getOp2());
    assertEquals(ET.E0, ((Constant) op2).et);
    assertEquals(ET.E1, ((CastExpr) op).et);
    assertEquals(ET.E1, ((UnopExpr) actualCloneResult).et);
    assertEquals(Value.VT.CAST, ((CastExpr) op).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op2).vt);
    assertEquals(Value.VT.LENGTH, ((UnopExpr) actualCloneResult).vt);
    assertSame(obj.value, ((Constant) op2).value);
  }

  /**
   * Method under test: {@link UnopExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone3() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    UnopExpr nLengthResult = Exprs.nLength(Exprs.nFilledArray("Element Type", new Value[]{nNullResult}));

    // Act
    Value actualCloneResult = nLengthResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    Value[] ops = op.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(op instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof UnopExpr);
    assertEquals("Element Type", ((FilledArrayExpr) op).type);
    assertNull(actualCloneResult.getOps());
    assertNull(value.getOps());
    assertNull(((Constant) value).tag);
    assertNull(((FilledArrayExpr) op).tag);
    assertNull(((UnopExpr) actualCloneResult).tag);
    assertNull(((UnopExpr) actualCloneResult).type);
    assertNull(((Constant) value).valueType);
    assertNull(((FilledArrayExpr) op).valueType);
    assertNull(((UnopExpr) actualCloneResult).valueType);
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
    assertEquals(ET.E1, ((UnopExpr) actualCloneResult).et);
    assertEquals(ET.En, ((FilledArrayExpr) op).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.FILLED_ARRAY, ((FilledArrayExpr) op).vt);
    assertEquals(Value.VT.LENGTH, ((UnopExpr) actualCloneResult).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Method under test: {@link UnopExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange, Act and Assert
    assertEquals("null[null].length", Exprs.nLength(new ArrayExpr()).toString0());
    assertEquals("null.length", Exprs.nLength(null).toString0());
    assertEquals("(-null[null])", Exprs.nNeg(new ArrayExpr(), "[").toString0());
    assertEquals("(!null[null])", Exprs.nNot(new ArrayExpr(), "[").toString0());
    assertEquals("(-null)", Exprs.nNeg(null, "[").toString0());
    assertEquals("(!null)", Exprs.nNot(null, "[").toString0());
  }

  /**
   * Method under test: {@link UnopExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    ArrayExpr array = new ArrayExpr();
    array.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null][null].length", Exprs.nLength(array).toString0());
  }

  /**
   * Method under test: {@link UnopExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals("null[null][null[null]].length", Exprs.nLength(Exprs.nArray(base, new ArrayExpr(), "[")).toString0());
  }

  /**
   * Method under test: {@link UnopExpr#UnopExpr(Value.VT, Value, String)}
   */
  @Test
  public void testNewUnopExpr() {
    // Arrange
    ArrayExpr value = new ArrayExpr();

    // Act
    UnopExpr actualUnopExpr = new UnopExpr(Value.VT.ADD, value, "Type");

    // Assert
    assertEquals("Type", actualUnopExpr.type);
    assertNull(actualUnopExpr.getOps());
    assertNull(actualUnopExpr.tag);
    assertNull(actualUnopExpr.valueType);
    assertNull(actualUnopExpr.getOp1());
    assertNull(actualUnopExpr.getOp2());
    assertEquals(ET.E1, actualUnopExpr.et);
    assertEquals(Value.VT.ADD, actualUnopExpr.vt);
    assertSame(value, actualUnopExpr.getOp());
  }
}
