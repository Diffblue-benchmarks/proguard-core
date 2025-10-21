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

public class PhiExprDiffblueTest {
  /**
   * Test {@link PhiExpr#PhiExpr(Value[])}.
   *
   * <p>Method under test: {@link PhiExpr#PhiExpr(Value[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PhiExpr.<init>(Value[])"})
  public void testNewPhiExpr() {
    // Arrange
    Value[] ops = new Value[] {new ArrayExpr()};

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
    assertEquals(VT.PHI, actualPhiExpr.vt);
    assertSame(ops, actualPhiExpr.getOps());
  }

  /**
   * Test {@link PhiExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Given nNull.
   *   <li>Then return toString0 is {@code φ(null)}.
   * </ul>
   *
   * <p>Method under test: {@link PhiExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value PhiExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_givenNNull_thenReturnToString0IsNull() {
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
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link PhiExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link PhiExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value PhiExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenFirstElementReturnCastExpr() {
    // Arrange
    PhiExpr nPhiResult =
        Exprs.nPhi(Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org"));

    // Act
    Value actualCloneResult = nPhiResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof CastExpr);
    assertTrue(value.getOp() instanceof Constant);
    assertTrue(actualCloneResult instanceof PhiExpr);
    assertEquals("alice.liddell@example.org", ((CastExpr) value).to);
    assertEquals("jane.doe@example.org", ((CastExpr) value).from);
    assertEquals(1, ops.length);
    assertEquals(ET.E1, ((CastExpr) value).et);
    assertEquals(VT.CAST, ((CastExpr) value).vt);
  }

  /**
   * Test {@link PhiExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link FilledArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link PhiExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value PhiExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenFirstElementReturnFilledArrayExpr() {
    // Arrange
    PhiExpr nPhiResult =
        Exprs.nPhi(Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()}));

    // Act
    Value actualCloneResult = nPhiResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    assertTrue(ops2[0] instanceof Constant);
    assertTrue(value instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof PhiExpr);
    assertEquals("Element Type", ((FilledArrayExpr) value).type);
    assertEquals(1, ops.length);
    assertEquals(1, ops2.length);
    assertEquals(ET.En, ((FilledArrayExpr) value).et);
    assertEquals(VT.FILLED_ARRAY, ((FilledArrayExpr) value).vt);
  }

  /**
   * Test {@link PhiExpr#clone()}.
   *
   * <ul>
   *   <li>Given nPhi.
   *   <li>Then return {@link PhiExpr}.
   * </ul>
   *
   * <p>Method under test: {@link PhiExpr#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value PhiExpr.clone()"})
  public void testClone_givenNPhi_thenReturnPhiExpr() {
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
    assertEquals(VT.PHI, ((PhiExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link PhiExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code φ(null[null][null])}.
   * </ul>
   *
   * <p>Method under test: {@link PhiExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String PhiExpr.toString0()"})
  public void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("φ(null[null][null])", Exprs.nPhi(arrayExpr).toString0());
  }

  /**
   * Test {@link PhiExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code φ(null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link PhiExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String PhiExpr.toString0()"})
  public void testToString0_givenArrayExpr_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("φ(null[null])", Exprs.nPhi(new ArrayExpr()).toString0());
  }

  /**
   * Test {@link PhiExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nPhi {@link ArrayExpr#ArrayExpr()} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code φ(null[null], null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link PhiExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String PhiExpr.toString0()"})
  public void testToString0_givenNPhiArrayExprAndArrayExpr_thenReturnNullNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();

    // Act and Assert
    assertEquals("φ(null[null], null[null])", Exprs.nPhi(arrayExpr, new ArrayExpr()).toString0());
  }

  /**
   * Test {@link PhiExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code φ(null[null][null[null]])}.
   * </ul>
   *
   * <p>Method under test: {@link PhiExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String PhiExpr.toString0()"})
  public void testToString0_thenReturnNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "φ(null[null][null[null]])",
        Exprs.nPhi(Exprs.nArray(base, new ArrayExpr(), "φ(")).toString0());
  }
}
