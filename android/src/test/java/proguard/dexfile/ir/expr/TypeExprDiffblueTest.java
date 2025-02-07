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

class TypeExprDiffblueTest {
  /**
   * Test {@link TypeExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link TypeExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.TypeExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    TypeExpr nCheckCastResult = Exprs.nCheckCast(new ArrayExpr(), "Type");

    // Act
    nCheckCastResult.releaseMemory();

    // Assert
    assertNull(nCheckCastResult.type);
    assertNull(nCheckCastResult.getOp());
  }

  /**
   * Test {@link TypeExpr#TypeExpr(VT, Value, String)}.
   *
   * <p>Method under test: {@link TypeExpr#TypeExpr(VT, Value, String)}
   */
  @Test
  @DisplayName("Test new TypeExpr(VT, Value, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.expr.TypeExpr.<init>(proguard.dexfile.ir.expr.Value$VT, proguard.dexfile.ir.expr.Value, java.lang.String)"
  })
  void testNewTypeExpr() {
    // Arrange
    ArrayExpr value = new ArrayExpr();

    // Act
    TypeExpr actualTypeExpr =
        new TypeExpr(VT.ADD, value, "The characteristics of someone or something");

    // Assert
    Value op = actualTypeExpr.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("The characteristics of someone or something", actualTypeExpr.type);
    assertNull(actualTypeExpr.getOps());
    assertNull(actualTypeExpr.tag);
    assertNull(actualTypeExpr.valueType);
    assertNull(actualTypeExpr.getOp1());
    assertNull(actualTypeExpr.getOp2());
    assertEquals(ET.E1, actualTypeExpr.et);
    assertEquals(VT.ADD, actualTypeExpr.vt);
    assertSame(value, op);
  }

  /**
   * Test {@link TypeExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.TypeExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnConstant() {
    // Arrange
    TypeExpr nCheckCastResult =
        Exprs.nCheckCast(Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()}), "Type");

    // Act
    Value actualCloneResult = nCheckCastResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    Value[] ops = op.getOps();
    assertTrue(ops[0] instanceof Constant);
    assertTrue(op instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof TypeExpr);
    assertEquals("Element Type", ((FilledArrayExpr) op).type);
    assertEquals(1, ops.length);
    assertEquals(ET.En, ((FilledArrayExpr) op).et);
    assertEquals(VT.FILLED_ARRAY, ((FilledArrayExpr) op).vt);
  }

  /**
   * Test {@link TypeExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op return CastExpr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.TypeExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenOpReturnCastExpr() {
    // Arrange
    TypeExpr nCheckCastResult =
        Exprs.nCheckCast(
            Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org"),
            "Type");

    // Act
    Value actualCloneResult = nCheckCastResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof CastExpr);
    assertTrue(op.getOp() instanceof Constant);
    assertTrue(actualCloneResult instanceof TypeExpr);
    assertEquals("alice.liddell@example.org", ((CastExpr) op).to);
    assertEquals("jane.doe@example.org", ((CastExpr) op).from);
    assertEquals(ET.E1, ((CastExpr) op).et);
    assertEquals(VT.CAST, ((CastExpr) op).vt);
  }

  /**
   * Test {@link TypeExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.TypeExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenOpReturnConstant() {
    // Arrange
    Constant obj = Exprs.nNull();
    TypeExpr nCheckCastResult = Exprs.nCheckCast(obj, "Type");

    // Act
    Value actualCloneResult = nCheckCastResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof TypeExpr);
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(VT.CONSTANT, ((Constant) op).vt);
    assertSame(obj.value, ((Constant) op).value);
  }

  /**
   * Test {@link TypeExpr#clone()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr} {@link ArrayExpr#clone()} return {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return Op is {@link ArrayExpr#ArrayExpr()}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#clone()}
   */
  @Test
  @DisplayName(
      "Test clone(); given ArrayExpr clone() return ArrayExpr(); then return Op is ArrayExpr()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.TypeExpr.clone()"})
  void testClone_givenArrayExprCloneReturnArrayExpr_thenReturnOpIsArrayExpr() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    op1.setOp1(Exprs.nNull());
    ArrayExpr arrayExpr = mock(ArrayExpr.class);
    ArrayExpr arrayExpr2 = new ArrayExpr();
    when(arrayExpr.clone()).thenReturn(arrayExpr2);
    ArrayExpr obj = mock(ArrayExpr.class);
    when(obj.trim()).thenReturn(arrayExpr);
    doNothing().when(obj).setOp1(Mockito.<Value>any());
    obj.setOp1(op1);

    // Act
    Value actualCloneResult = Exprs.nCheckCast(obj, "Type").clone();

    // Assert
    verify(arrayExpr).clone();
    verify(obj).trim();
    verify(obj).setOp1(isA(Value.class));
    assertTrue(actualCloneResult instanceof TypeExpr);
    assertSame(arrayExpr2, actualCloneResult.getOp());
  }

  /**
   * Test {@link TypeExpr#clone()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr} {@link Value#trim()} return nNull.
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); given ArrayExpr trim() return nNull; then Op return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.TypeExpr.clone()"})
  void testClone_givenArrayExprTrimReturnNNull_thenOpReturnConstant() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    Constant op12 = Exprs.nNull();
    op1.setOp1(op12);
    ArrayExpr obj = mock(ArrayExpr.class);
    when(obj.trim()).thenReturn(Exprs.nNull());
    doNothing().when(obj).setOp1(Mockito.<Value>any());
    obj.setOp1(op1);

    // Act
    Value actualCloneResult = Exprs.nCheckCast(obj, "Type").clone();

    // Assert
    verify(obj).trim();
    verify(obj).setOp1(isA(Value.class));
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof TypeExpr);
    assertNull(op.getOp1());
    assertNull(op.getOp2());
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(VT.CONSTANT, ((Constant) op).vt);
    assertSame(op12.value, ((Constant) op).value);
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code ((double)null[null][null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given ArrayExpr() Op1 is ArrayExpr(); then return '((double)null[null][null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.TypeExpr.toString0()"})
  void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnDoubleNullNullNull() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();
    obj.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("((double)null[null][null])", Exprs.nCheckCast(obj, "D").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@link ArrayExpr#ArrayExpr()} and {@code D}.
   *   <li>Then return {@code ((double)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given nCheckCast ArrayExpr() and 'D'; then return '((double)null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.TypeExpr.toString0()"})
  void testToString0_givenNCheckCastArrayExprAndD_thenReturnDoubleNullNull() {
    // Arrange, Act and Assert
    assertEquals("((double)null[null])", Exprs.nCheckCast(new ArrayExpr(), "D").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@link ArrayExpr#ArrayExpr()} and empty string.
   *   <li>Then return {@code (()null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given nCheckCast ArrayExpr() and empty string; then return '(()null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.TypeExpr.toString0()"})
  void testToString0_givenNCheckCastArrayExprAndEmptyString_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("(()null[null])", Exprs.nCheckCast(new ArrayExpr(), "").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@link ArrayExpr#ArrayExpr()} and {@code F}.
   *   <li>Then return {@code ((float)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given nCheckCast ArrayExpr() and 'F'; then return '((float)null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.TypeExpr.toString0()"})
  void testToString0_givenNCheckCastArrayExprAndF_thenReturnFloatNullNull() {
    // Arrange, Act and Assert
    assertEquals("((float)null[null])", Exprs.nCheckCast(new ArrayExpr(), "F").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@link ArrayExpr#ArrayExpr()} and {@code I}.
   *   <li>Then return {@code ((int)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given nCheckCast ArrayExpr() and 'I'; then return '((int)null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.TypeExpr.toString0()"})
  void testToString0_givenNCheckCastArrayExprAndI_thenReturnIntNullNull() {
    // Arrange, Act and Assert
    assertEquals("((int)null[null])", Exprs.nCheckCast(new ArrayExpr(), "I").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@link ArrayExpr#ArrayExpr()} and {@code J}.
   *   <li>Then return {@code ((long)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given nCheckCast ArrayExpr() and 'J'; then return '((long)null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.TypeExpr.toString0()"})
  void testToString0_givenNCheckCastArrayExprAndJ_thenReturnLongNullNull() {
    // Arrange, Act and Assert
    assertEquals("((long)null[null])", Exprs.nCheckCast(new ArrayExpr(), "J").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@code null} and {@code D}.
   *   <li>Then return {@code ((double)null)}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given nCheckCast 'null' and 'D'; then return '((double)null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.TypeExpr.toString0()"})
  void testToString0_givenNCheckCastNullAndD_thenReturnDoubleNull() {
    // Arrange, Act and Assert
    assertEquals("((double)null)", Exprs.nCheckCast(null, "D").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNewArray {@code D} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code new double[null[null]]}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given nNewArray 'D' and ArrayExpr(); then return 'new double[null[null]]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.TypeExpr.toString0()"})
  void testToString0_givenNNewArrayDAndArrayExpr_thenReturnNewDoubleNullNull() {
    // Arrange, Act and Assert
    assertEquals("new double[null[null]]", Exprs.nNewArray("D", new ArrayExpr()).toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNewArray {@code D} and {@code null}.
   *   <li>Then return {@code new double[null]}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given nNewArray 'D' and 'null'; then return 'new double[null]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.TypeExpr.toString0()"})
  void testToString0_givenNNewArrayDAndNull_thenReturnNewDoubleNull() {
    // Arrange, Act and Assert
    assertEquals("new double[null]", Exprs.nNewArray("D", null).toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((double)null[null][null[null]])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return '((double)null[null][null[null]])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.TypeExpr.toString0()"})
  void testToString0_thenReturnDoubleNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "((double)null[null][null[null]])",
        Exprs.nCheckCast(Exprs.nArray(base, new ArrayExpr(), "(("), "D").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code (null[null] instanceof [])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return '(null[null] instanceof [])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.TypeExpr.toString0()"})
  void testToString0_thenReturnNullNullInstanceof() {
    // Arrange, Act and Assert
    assertEquals("(null[null] instanceof [])", Exprs.nInstanceOf(new ArrayExpr(), "[").toString0());
  }
}
