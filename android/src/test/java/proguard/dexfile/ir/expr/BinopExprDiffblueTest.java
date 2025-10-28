package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class BinopExprDiffblueTest {
  /**
   * Method under test: {@link BinopExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    BinopExpr nDCmpgResult = Exprs.nDCmpg(a, new ArrayExpr());

    // Act
    nDCmpgResult.releaseMemory();

    // Assert
    assertEquals("(null DCMPG null)", nDCmpgResult.toString0());
    assertNull(nDCmpgResult.type);
    assertNull(nDCmpgResult.getOp1());
    assertNull(nDCmpgResult.getOp2());
  }

  /**
   * Method under test: {@link BinopExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant a = Exprs.nNull();
    Constant b = Exprs.nNull();
    BinopExpr nDCmpgResult = Exprs.nDCmpg(a, b);

    // Act
    Value actualCloneResult = nDCmpgResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof BinopExpr);
    Value op1 = actualCloneResult.getOp1();
    assertTrue(op1 instanceof Constant);
    Value op2 = actualCloneResult.getOp2();
    assertTrue(op2 instanceof Constant);
    assertEquals("(null DCMPG null)", actualCloneResult.toString0());
    assertEquals("D", ((BinopExpr) actualCloneResult).type);
    assertNull(actualCloneResult.getOps());
    assertNull(op1.getOps());
    assertNull(op2.getOps());
    assertNull(((BinopExpr) actualCloneResult).tag);
    assertNull(((Constant) op1).tag);
    assertNull(((Constant) op2).tag);
    assertNull(((BinopExpr) actualCloneResult).valueType);
    assertNull(((Constant) op1).valueType);
    assertNull(((Constant) op2).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(op1.getOp());
    assertNull(op2.getOp());
    assertNull(op1.getOp1());
    assertNull(op2.getOp1());
    assertNull(op1.getOp2());
    assertNull(op2.getOp2());
    assertEquals(ET.E0, ((Constant) op1).et);
    assertEquals(ET.E0, ((Constant) op2).et);
    assertEquals(ET.E2, ((BinopExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) op1).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op2).vt);
    assertEquals(Value.VT.DCMPG, ((BinopExpr) actualCloneResult).vt);
    Object object = b.value;
    assertSame(object, ((Constant) op1).value);
    assertSame(object, ((Constant) op2).value);
  }

  /**
   * Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange
    ArrayExpr a = new ArrayExpr();

    // Act and Assert
    assertEquals("(null[null] DCMPG null[null])", Exprs.nDCmpg(a, new ArrayExpr()).toString0());
  }

  /**
   * Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    a.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("(null[null][null] DCMPG null[null])", Exprs.nDCmpg(a, new ArrayExpr()).toString0());
  }

  /**
   * Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr a = Exprs.nArray(base, new ArrayExpr(), "(");

    // Act and Assert
    assertEquals("(null[null][null[null]] DCMPG null[null])", Exprs.nDCmpg(a, new ArrayExpr()).toString0());
  }

  /**
   * Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  public void testToString04() {
    // Arrange, Act and Assert
    assertEquals("(null DCMPG null[null])", Exprs.nDCmpg(null, new ArrayExpr()).toString0());
  }

  /**
   * Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  public void testToString05() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    BinopExpr a2 = Exprs.nDCmpg(a, new ArrayExpr());

    // Act and Assert
    assertEquals("((null[null] DCMPG null[null]) DCMPG null[null])", Exprs.nDCmpg(a2, new ArrayExpr()).toString0());
  }

  /**
   * Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  public void testToString06() {
    // Arrange, Act and Assert
    assertEquals("(null[null] DCMPG null)", Exprs.nDCmpg(new ArrayExpr(), null).toString0());
  }

  /**
   * Method under test:
   * {@link BinopExpr#BinopExpr(Value.VT, Value, Value, String)}
   */
  @Test
  public void testNewBinopExpr() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    ArrayExpr op2 = new ArrayExpr();

    // Act
    BinopExpr actualBinopExpr = new BinopExpr(Value.VT.ADD, op1, op2, "Type");

    // Assert
    assertEquals("(null[null] + null[null])", actualBinopExpr.toString0());
    assertEquals("Type", actualBinopExpr.type);
    assertNull(actualBinopExpr.getOps());
    assertNull(actualBinopExpr.tag);
    assertNull(actualBinopExpr.valueType);
    assertNull(actualBinopExpr.getOp());
    assertEquals(ET.E2, actualBinopExpr.et);
    assertEquals(Value.VT.ADD, actualBinopExpr.vt);
    assertSame(op1, actualBinopExpr.getOp1());
    assertSame(op2, actualBinopExpr.getOp2());
  }
}
