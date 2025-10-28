package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class ArrayExprDiffblueTest {
  /**
   * Method under test: {@link ArrayExpr#clone()}
   */
  @Test
  public void testClone() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp2(Exprs.nNull());
    Constant op1 = Exprs.nNull();
    arrayExpr.setOp1(op1);

    // Act
    Value actualCloneResult = arrayExpr.clone();

    // Assert
    assertTrue(actualCloneResult instanceof ArrayExpr);
    Value op12 = actualCloneResult.getOp1();
    assertTrue(op12 instanceof Constant);
    Value op2 = actualCloneResult.getOp2();
    assertTrue(op2 instanceof Constant);
    assertEquals("null[null]", actualCloneResult.toString0());
    assertNull(actualCloneResult.getOps());
    assertNull(op12.getOps());
    assertNull(op2.getOps());
    assertNull(((ArrayExpr) actualCloneResult).tag);
    assertNull(((Constant) op12).tag);
    assertNull(((Constant) op2).tag);
    assertNull(((ArrayExpr) actualCloneResult).elementType);
    assertNull(((ArrayExpr) actualCloneResult).valueType);
    assertNull(((Constant) op12).valueType);
    assertNull(((Constant) op2).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(op12.getOp());
    assertNull(op2.getOp());
    assertNull(op12.getOp1());
    assertNull(op2.getOp1());
    assertNull(op12.getOp2());
    assertNull(op2.getOp2());
    assertEquals(ET.E0, ((Constant) op12).et);
    assertEquals(ET.E0, ((Constant) op2).et);
    assertEquals(ET.E2, ((ArrayExpr) actualCloneResult).et);
    assertEquals(Value.VT.ARRAY, ((ArrayExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op12).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op2).vt);
    Object object = op1.value;
    assertSame(object, ((Constant) op12).value);
    assertSame(object, ((Constant) op2).value);
  }

  /**
   * Method under test: {@link ArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant base = Exprs.nNull();
    Constant index = Exprs.nNull();
    ArrayExpr nArrayResult = Exprs.nArray(base, index, "Element Type");

    // Act
    Value actualCloneResult = nArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof ArrayExpr);
    Value op1 = actualCloneResult.getOp1();
    assertTrue(op1 instanceof Constant);
    Value op2 = actualCloneResult.getOp2();
    assertTrue(op2 instanceof Constant);
    assertEquals("Element Type", ((ArrayExpr) actualCloneResult).elementType);
    assertEquals("null[null]", actualCloneResult.toString0());
    assertNull(actualCloneResult.getOps());
    assertNull(op1.getOps());
    assertNull(op2.getOps());
    assertNull(((ArrayExpr) actualCloneResult).tag);
    assertNull(((Constant) op1).tag);
    assertNull(((Constant) op2).tag);
    assertNull(((ArrayExpr) actualCloneResult).valueType);
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
    assertEquals(ET.E2, ((ArrayExpr) actualCloneResult).et);
    assertEquals(Value.VT.ARRAY, ((ArrayExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op1).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op2).vt);
    Object object = index.value;
    assertSame(object, ((Constant) op1).value);
    assertSame(object, ((Constant) op2).value);
  }

  /**
   * Method under test: {@link ArrayExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange, Act and Assert
    assertEquals("null[null]", (new ArrayExpr()).toString0());
  }

  /**
   * Method under test: {@link ArrayExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null][null]", arrayExpr.toString0());
  }

  /**
   * Method under test: {@link ArrayExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp2(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null[null]]", arrayExpr.toString0());
  }

  /**
   * Method under test: {@link ArrayExpr#toString0()}
   */
  @Test
  public void testToString04() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    ArrayExpr a = new ArrayExpr();
    arrayExpr.setOp1(Exprs.nDCmpg(a, new ArrayExpr()));

    // Act and Assert
    assertEquals("(null[null] DCMPG null[null])[null]", arrayExpr.toString0());
  }

  /**
   * Method under test: {@link ArrayExpr#toString0()}
   */
  @Test
  public void testToString05() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(Exprs.nNull());

    // Act and Assert
    assertEquals("null[null]", arrayExpr.toString0());
  }

  /**
   * Method under test: {@link ArrayExpr#ArrayExpr()}
   */
  @Test
  public void testNewArrayExpr() {
    // Arrange and Act
    ArrayExpr actualArrayExpr = new ArrayExpr();

    // Assert
    assertEquals("null[null]", actualArrayExpr.toString0());
    assertNull(actualArrayExpr.getOps());
    assertNull(actualArrayExpr.tag);
    assertNull(actualArrayExpr.elementType);
    assertNull(actualArrayExpr.valueType);
    assertNull(actualArrayExpr.getOp());
    assertNull(actualArrayExpr.getOp1());
    assertNull(actualArrayExpr.getOp2());
    assertEquals(ET.E2, actualArrayExpr.et);
    assertEquals(Value.VT.ARRAY, actualArrayExpr.vt);
  }

  /**
   * Method under test: {@link ArrayExpr#ArrayExpr(Value, Value, String)}
   */
  @Test
  public void testNewArrayExpr2() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr index = new ArrayExpr();

    // Act
    ArrayExpr actualArrayExpr = new ArrayExpr(base, index, "Element Type");

    // Assert
    assertEquals("Element Type", actualArrayExpr.elementType);
    assertEquals("null[null][null[null]]", actualArrayExpr.toString0());
    assertNull(actualArrayExpr.getOps());
    assertNull(actualArrayExpr.tag);
    assertNull(actualArrayExpr.valueType);
    assertNull(actualArrayExpr.getOp());
    assertEquals(ET.E2, actualArrayExpr.et);
    assertEquals(Value.VT.ARRAY, actualArrayExpr.vt);
    assertSame(base, actualArrayExpr.getOp1());
    assertSame(index, actualArrayExpr.getOp2());
  }
}
