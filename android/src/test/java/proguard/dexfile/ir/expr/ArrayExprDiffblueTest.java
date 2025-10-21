package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.VT;

public class ArrayExprDiffblueTest {
  /**
   * Test {@link ArrayExpr#ArrayExpr()}.
   *
   * <p>Method under test: {@link ArrayExpr#ArrayExpr()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayExpr.<init>()"})
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
    assertEquals(VT.ARRAY, actualArrayExpr.vt);
  }

  /**
   * Test {@link ArrayExpr#ArrayExpr(Value, Value, String)}.
   *
   * <p>Method under test: {@link ArrayExpr#ArrayExpr(Value, Value, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayExpr.<init>(Value, Value, String)"})
  public void testNewArrayExpr2() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr index = new ArrayExpr();

    // Act
    ArrayExpr actualArrayExpr = new ArrayExpr(base, index, "Element Type");

    // Assert
    Value op1 = actualArrayExpr.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualArrayExpr.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("Element Type", actualArrayExpr.elementType);
    assertEquals("null[null][null[null]]", actualArrayExpr.toString0());
    assertNull(actualArrayExpr.getOps());
    assertNull(actualArrayExpr.tag);
    assertNull(actualArrayExpr.valueType);
    assertNull(actualArrayExpr.getOp());
    assertEquals(ET.E2, actualArrayExpr.et);
    assertEquals(VT.ARRAY, actualArrayExpr.vt);
    assertSame(base, op1);
    assertSame(index, op2);
  }

  /**
   * Test {@link ArrayExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return {@link ArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ArrayExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenReturnArrayExpr() {
    // Arrange
    Constant base = Exprs.nNull();
    ArrayExpr nArrayResult = Exprs.nArray(base, Exprs.nNull(), "Element Type");

    // Act
    Value actualCloneResult = nArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof ArrayExpr);
    assertTrue(actualCloneResult.getOp1() instanceof Constant);
    assertTrue(actualCloneResult.getOp2() instanceof Constant);
    assertEquals("Element Type", ((ArrayExpr) actualCloneResult).elementType);
    assertEquals("null[null]", actualCloneResult.toString0());
    assertNull(actualCloneResult.getOps());
    assertNull(((ArrayExpr) actualCloneResult).tag);
    assertNull(((ArrayExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertEquals(ET.E2, ((ArrayExpr) actualCloneResult).et);
    assertEquals(VT.ARRAY, ((ArrayExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link ArrayExpr#clone()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op2 is nNull.
   *   <li>Then return {@link ArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayExpr#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ArrayExpr.clone()"})
  public void testClone_givenArrayExprOp2IsNNull_thenReturnArrayExpr() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp2(Exprs.nNull());
    arrayExpr.setOp1(Exprs.nNull());

    // Act
    Value actualCloneResult = arrayExpr.clone();

    // Assert
    assertTrue(actualCloneResult instanceof ArrayExpr);
    assertTrue(actualCloneResult.getOp1() instanceof Constant);
    assertTrue(actualCloneResult.getOp2() instanceof Constant);
    assertEquals("null[null]", actualCloneResult.toString0());
    assertNull(actualCloneResult.getOps());
    assertNull(((ArrayExpr) actualCloneResult).tag);
    assertNull(((ArrayExpr) actualCloneResult).elementType);
    assertNull(((ArrayExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertEquals(ET.E2, ((ArrayExpr) actualCloneResult).et);
    assertEquals(VT.ARRAY, ((ArrayExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link ArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null][null]}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ArrayExpr.toString0()"})
  public void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null][null]", arrayExpr.toString0());
  }

  /**
   * Test {@link ArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is nNull.
   *   <li>Then return {@code null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ArrayExpr.toString0()"})
  public void testToString0_givenArrayExprOp1IsNNull_thenReturnNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(Exprs.nNull());

    // Act and Assert
    assertEquals("null[null]", arrayExpr.toString0());
  }

  /**
   * Test {@link ArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op2 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null[null]]}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ArrayExpr.toString0()"})
  public void testToString0_givenArrayExprOp2IsArrayExpr_thenReturnNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp2(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null[null]]", arrayExpr.toString0());
  }

  /**
   * Test {@link ArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ArrayExpr.toString0()"})
  public void testToString0_givenArrayExpr_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("null[null]", (new ArrayExpr()).toString0());
  }

  /**
   * Test {@link ArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code (null[null] DCMPG null[null])[null]}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ArrayExpr.toString0()"})
  public void testToString0_thenReturnNullNullDcmpgNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    ArrayExpr a = new ArrayExpr();
    arrayExpr.setOp1(Exprs.nDCmpg(a, new ArrayExpr()));

    // Act and Assert
    assertEquals("(null[null] DCMPG null[null])[null]", arrayExpr.toString0());
  }
}
