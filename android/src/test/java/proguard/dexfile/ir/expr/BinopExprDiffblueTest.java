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

public class BinopExprDiffblueTest {
  /**
   * Test {@link BinopExpr#BinopExpr(VT, Value, Value, String)}.
   *
   * <p>Method under test: {@link BinopExpr#BinopExpr(VT, Value, Value, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BinopExpr.<init>(VT, Value, Value, String)"})
  public void testNewBinopExpr() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    ArrayExpr op2 = new ArrayExpr();

    // Act
    BinopExpr actualBinopExpr = new BinopExpr(VT.ADD, op1, op2, "Type");

    // Assert
    Value op12 = actualBinopExpr.getOp1();
    assertTrue(op12 instanceof ArrayExpr);
    Value op22 = actualBinopExpr.getOp2();
    assertTrue(op22 instanceof ArrayExpr);
    assertEquals("(null[null] + null[null])", actualBinopExpr.toString0());
    assertEquals("Type", actualBinopExpr.type);
    assertNull(actualBinopExpr.getOps());
    assertNull(actualBinopExpr.tag);
    assertNull(actualBinopExpr.valueType);
    assertNull(actualBinopExpr.getOp());
    assertEquals(ET.E2, actualBinopExpr.et);
    assertEquals(VT.ADD, actualBinopExpr.vt);
    assertSame(op1, op12);
    assertSame(op2, op22);
  }

  /**
   * Test {@link BinopExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link BinopExpr#releaseMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BinopExpr.releaseMemory()"})
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
   * Test {@link BinopExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Given nDCmpg nNull and nNull.
   *   <li>Then return {@link BinopExpr}.
   * </ul>
   *
   * <p>Method under test: {@link BinopExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value BinopExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_givenNDCmpgNNullAndNNull_thenReturnBinopExpr() {
    // Arrange
    Constant a = Exprs.nNull();
    BinopExpr nDCmpgResult = Exprs.nDCmpg(a, Exprs.nNull());

    // Act
    Value actualCloneResult = nDCmpgResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof BinopExpr);
    assertTrue(actualCloneResult.getOp1() instanceof Constant);
    assertTrue(actualCloneResult.getOp2() instanceof Constant);
    assertEquals("(null DCMPG null)", actualCloneResult.toString0());
    assertEquals("D", ((BinopExpr) actualCloneResult).type);
    assertNull(actualCloneResult.getOps());
    assertNull(((BinopExpr) actualCloneResult).tag);
    assertNull(((BinopExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertEquals(ET.E2, ((BinopExpr) actualCloneResult).et);
    assertEquals(VT.DCMPG, ((BinopExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link BinopExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code (null[null][null] DCMPG null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BinopExpr.toString0()"})
  public void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNullDcmpgNullNull() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    a.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals(
        "(null[null][null] DCMPG null[null])", Exprs.nDCmpg(a, new ArrayExpr()).toString0());
  }

  /**
   * Test {@link BinopExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nDCmpg {@link ArrayExpr#ArrayExpr()} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code (null[null] DCMPG null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BinopExpr.toString0()"})
  public void testToString0_givenNDCmpgArrayExprAndArrayExpr_thenReturnNullNullDcmpgNullNull() {
    // Arrange
    ArrayExpr a = new ArrayExpr();

    // Act and Assert
    assertEquals("(null[null] DCMPG null[null])", Exprs.nDCmpg(a, new ArrayExpr()).toString0());
  }

  /**
   * Test {@link BinopExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nDCmpg {@link ArrayExpr#ArrayExpr()} and {@code null}.
   *   <li>Then return {@code (null[null] DCMPG null)}.
   * </ul>
   *
   * <p>Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BinopExpr.toString0()"})
  public void testToString0_givenNDCmpgArrayExprAndNull_thenReturnNullNullDcmpgNull() {
    // Arrange, Act and Assert
    assertEquals("(null[null] DCMPG null)", Exprs.nDCmpg(new ArrayExpr(), null).toString0());
  }

  /**
   * Test {@link BinopExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nDCmpg {@code null} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code (null DCMPG null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BinopExpr.toString0()"})
  public void testToString0_givenNDCmpgNullAndArrayExpr_thenReturnNullDcmpgNullNull() {
    // Arrange, Act and Assert
    assertEquals("(null DCMPG null[null])", Exprs.nDCmpg(null, new ArrayExpr()).toString0());
  }

  /**
   * Test {@link BinopExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((null[null] DCMPG null[null]) DCMPG null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BinopExpr.toString0()"})
  public void testToString0_thenReturnNullNullDcmpgNullNullDcmpgNullNull() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    BinopExpr a2 = Exprs.nDCmpg(a, new ArrayExpr());

    // Act and Assert
    assertEquals(
        "((null[null] DCMPG null[null]) DCMPG null[null])",
        Exprs.nDCmpg(a2, new ArrayExpr()).toString0());
  }

  /**
   * Test {@link BinopExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code (null[null][null[null]] DCMPG null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link BinopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BinopExpr.toString0()"})
  public void testToString0_thenReturnNullNullNullNullDcmpgNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr a = Exprs.nArray(base, new ArrayExpr(), "(");

    // Act and Assert
    assertEquals(
        "(null[null][null[null]] DCMPG null[null])", Exprs.nDCmpg(a, new ArrayExpr()).toString0());
  }
}
