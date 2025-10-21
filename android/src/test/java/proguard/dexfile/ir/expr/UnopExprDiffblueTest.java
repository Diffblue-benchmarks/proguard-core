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

public class UnopExprDiffblueTest {
  /**
   * Test {@link UnopExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link UnopExpr#releaseMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnopExpr.releaseMemory()"})
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
   * Test {@link UnopExpr#UnopExpr(VT, Value, String)}.
   *
   * <p>Method under test: {@link UnopExpr#UnopExpr(VT, Value, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnopExpr.<init>(VT, Value, String)"})
  public void testNewUnopExpr() {
    // Arrange
    ArrayExpr value = new ArrayExpr();

    // Act
    UnopExpr actualUnopExpr = new UnopExpr(VT.ADD, value, "Type");

    // Assert
    Value op = actualUnopExpr.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("Type", actualUnopExpr.type);
    assertNull(actualUnopExpr.getOps());
    assertNull(actualUnopExpr.tag);
    assertNull(actualUnopExpr.valueType);
    assertNull(actualUnopExpr.getOp1());
    assertNull(actualUnopExpr.getOp2());
    assertEquals(ET.E1, actualUnopExpr.et);
    assertEquals(VT.ADD, actualUnopExpr.vt);
    assertSame(value, op);
  }

  /**
   * Test {@link UnopExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Given nLength nNull.
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value UnopExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_givenNLengthNNull_thenOpReturnConstant() {
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
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(VT.CONSTANT, ((Constant) op).vt);
    assertSame(array.value, ((Constant) op).value);
  }

  /**
   * Test {@link UnopExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value UnopExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenFirstElementReturnConstant() {
    // Arrange
    UnopExpr nLengthResult =
        Exprs.nLength(Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()}));

    // Act
    Value actualCloneResult = nLengthResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    Value[] ops = op.getOps();
    assertTrue(ops[0] instanceof Constant);
    assertTrue(op instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof UnopExpr);
    assertEquals("Element Type", ((FilledArrayExpr) op).type);
    assertEquals(1, ops.length);
    assertEquals(ET.En, ((FilledArrayExpr) op).et);
    assertEquals(VT.FILLED_ARRAY, ((FilledArrayExpr) op).vt);
  }

  /**
   * Test {@link UnopExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value UnopExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenOpReturnCastExpr() {
    // Arrange
    UnopExpr nLengthResult =
        Exprs.nLength(
            Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org"));

    // Act
    Value actualCloneResult = nLengthResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof CastExpr);
    assertTrue(op.getOp() instanceof Constant);
    assertTrue(actualCloneResult instanceof UnopExpr);
    assertEquals("alice.liddell@example.org", ((CastExpr) op).to);
    assertEquals("jane.doe@example.org", ((CastExpr) op).from);
    assertEquals(ET.E1, ((CastExpr) op).et);
    assertEquals(VT.CAST, ((CastExpr) op).vt);
  }

  /**
   * Test {@link UnopExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null][null].length}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UnopExpr.toString0()"})
  public void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNullLength() {
    // Arrange
    ArrayExpr array = new ArrayExpr();
    array.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null][null].length", Exprs.nLength(array).toString0());
  }

  /**
   * Test {@link UnopExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nLength {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null].length}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UnopExpr.toString0()"})
  public void testToString0_givenNLengthArrayExpr_thenReturnNullNullLength() {
    // Arrange, Act and Assert
    assertEquals("null[null].length", Exprs.nLength(new ArrayExpr()).toString0());
  }

  /**
   * Test {@link UnopExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nLength {@code null}.
   *   <li>Then return {@code null.length}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UnopExpr.toString0()"})
  public void testToString0_givenNLengthNull_thenReturnNullLength() {
    // Arrange, Act and Assert
    assertEquals("null.length", Exprs.nLength(null).toString0());
  }

  /**
   * Test {@link UnopExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNeg {@link ArrayExpr#ArrayExpr()} and {@code [}.
   *   <li>Then return {@code (-null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UnopExpr.toString0()"})
  public void testToString0_givenNNegArrayExprAndLeftSquareBracket_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("(-null[null])", Exprs.nNeg(new ArrayExpr(), "[").toString0());
  }

  /**
   * Test {@link UnopExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNeg {@code null} and {@code [}.
   *   <li>Then return {@code (-null)}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UnopExpr.toString0()"})
  public void testToString0_givenNNegNullAndLeftSquareBracket_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("(-null)", Exprs.nNeg(null, "[").toString0());
  }

  /**
   * Test {@link UnopExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNot {@link ArrayExpr#ArrayExpr()} and {@code [}.
   *   <li>Then return {@code (!null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UnopExpr.toString0()"})
  public void testToString0_givenNNotArrayExprAndLeftSquareBracket_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("(!null[null])", Exprs.nNot(new ArrayExpr(), "[").toString0());
  }

  /**
   * Test {@link UnopExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNot {@code null} and {@code [}.
   *   <li>Then return {@code (!null)}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UnopExpr.toString0()"})
  public void testToString0_givenNNotNullAndLeftSquareBracket_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("(!null)", Exprs.nNot(null, "[").toString0());
  }

  /**
   * Test {@link UnopExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null][null[null]].length}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UnopExpr.toString0()"})
  public void testToString0_thenReturnNullNullNullNullLength() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "null[null][null[null]].length",
        Exprs.nLength(Exprs.nArray(base, new ArrayExpr(), "[")).toString0());
  }
}
