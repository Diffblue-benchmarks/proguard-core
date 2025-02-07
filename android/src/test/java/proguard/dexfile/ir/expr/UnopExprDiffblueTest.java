package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.VT;

class UnopExprDiffblueTest {
  /**
   * Test {@link UnopExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link UnopExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.UnopExpr.releaseMemory()"})
  void testReleaseMemory() {
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
  @DisplayName("Test new UnopExpr(VT, Value, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.expr.UnopExpr.<init>(proguard.dexfile.ir.expr.Value$VT, proguard.dexfile.ir.expr.Value, java.lang.String)"
  })
  void testNewUnopExpr() {
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
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; given nLength nNull; then Op return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.UnopExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_givenNLengthNNull_thenOpReturnConstant() {
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
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.UnopExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnConstant() {
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
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op return CastExpr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.UnopExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenOpReturnCastExpr() {
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
   * Test {@link UnopExpr#clone()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr} {@link ArrayExpr#clone()} return {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return toString0 is {@code null[null].length}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#clone()}
   */
  @Test
  @DisplayName(
      "Test clone(); given ArrayExpr clone() return ArrayExpr(); then return toString0 is 'null[null].length'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.UnopExpr.clone()"})
  void testClone_givenArrayExprCloneReturnArrayExpr_thenReturnToString0IsNullNullLength() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    op1.setOp1(Exprs.nNull());
    ArrayExpr arrayExpr = mock(ArrayExpr.class);
    ArrayExpr arrayExpr2 = new ArrayExpr();
    when(arrayExpr.clone()).thenReturn(arrayExpr2);
    ArrayExpr array = mock(ArrayExpr.class);
    when(array.trim()).thenReturn(arrayExpr);
    doNothing().when(array).setOp1(Mockito.<Value>any());
    array.setOp1(op1);

    // Act
    Value actualCloneResult = Exprs.nLength(array).clone();

    // Assert
    verify(arrayExpr).clone();
    verify(array).trim();
    verify(array).setOp1(isA(Value.class));
    assertTrue(actualCloneResult instanceof UnopExpr);
    assertEquals("null[null].length", actualCloneResult.toString0());
    assertSame(arrayExpr2, actualCloneResult.getOp());
  }

  /**
   * Test {@link UnopExpr#clone()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr} {@link Value#trim()} return nNull.
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link UnopExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); given ArrayExpr trim() return nNull; then Op return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.UnopExpr.clone()"})
  void testClone_givenArrayExprTrimReturnNNull_thenOpReturnConstant() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    Constant op12 = Exprs.nNull();
    op1.setOp1(op12);
    ArrayExpr array = mock(ArrayExpr.class);
    when(array.trim()).thenReturn(Exprs.nNull());
    doNothing().when(array).setOp1(Mockito.<Value>any());
    array.setOp1(op1);

    // Act
    Value actualCloneResult = Exprs.nLength(array).clone();

    // Assert
    verify(array).trim();
    verify(array).setOp1(isA(Value.class));
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof UnopExpr);
    assertEquals("null.length", actualCloneResult.toString0());
    assertNull(op.getOp1());
    assertNull(op.getOp2());
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(VT.CONSTANT, ((Constant) op).vt);
    assertSame(op12.value, ((Constant) op).value);
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
  @DisplayName(
      "Test toString0(); given ArrayExpr() Op1 is ArrayExpr(); then return 'null[null][null].length'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.UnopExpr.toString0()"})
  void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNullLength() {
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
  @DisplayName("Test toString0(); given nLength ArrayExpr(); then return 'null[null].length'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.UnopExpr.toString0()"})
  void testToString0_givenNLengthArrayExpr_thenReturnNullNullLength() {
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
  @DisplayName("Test toString0(); given nLength 'null'; then return 'null.length'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.UnopExpr.toString0()"})
  void testToString0_givenNLengthNull_thenReturnNullLength() {
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
  @DisplayName("Test toString0(); given nNeg ArrayExpr() and '['; then return '(-null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.UnopExpr.toString0()"})
  void testToString0_givenNNegArrayExprAndLeftSquareBracket_thenReturnNullNull() {
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
  @DisplayName("Test toString0(); given nNeg 'null' and '['; then return '(-null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.UnopExpr.toString0()"})
  void testToString0_givenNNegNullAndLeftSquareBracket_thenReturnNull() {
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
  @DisplayName("Test toString0(); given nNot ArrayExpr() and '['; then return '(!null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.UnopExpr.toString0()"})
  void testToString0_givenNNotArrayExprAndLeftSquareBracket_thenReturnNullNull() {
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
  @DisplayName("Test toString0(); given nNot 'null' and '['; then return '(!null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.UnopExpr.toString0()"})
  void testToString0_givenNNotNullAndLeftSquareBracket_thenReturnNull() {
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
  @DisplayName("Test toString0(); then return 'null[null][null[null]].length'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.UnopExpr.toString0()"})
  void testToString0_thenReturnNullNullNullNullLength() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "null[null][null[null]].length",
        Exprs.nLength(Exprs.nArray(base, new ArrayExpr(), "[")).toString0());
  }
}
