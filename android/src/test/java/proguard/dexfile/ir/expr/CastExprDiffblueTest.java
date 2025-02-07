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

class CastExprDiffblueTest {
  /**
   * Test {@link CastExpr#CastExpr(Value, String, String)}.
   *
   * <p>Method under test: {@link CastExpr#CastExpr(Value, String, String)}
   */
  @Test
  @DisplayName("Test new CastExpr(Value, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.expr.CastExpr.<init>(proguard.dexfile.ir.expr.Value, java.lang.String, java.lang.String)"
  })
  void testNewCastExpr() {
    // Arrange
    ArrayExpr value = new ArrayExpr();

    // Act
    CastExpr actualCastExpr =
        new CastExpr(value, "jane.doe@example.org", "alice.liddell@example.org");

    // Assert
    Value op = actualCastExpr.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("alice.liddell@example.org", actualCastExpr.to);
    assertEquals("jane.doe@example.org", actualCastExpr.from);
    assertNull(actualCastExpr.getOps());
    assertNull(actualCastExpr.tag);
    assertNull(actualCastExpr.valueType);
    assertNull(actualCastExpr.getOp1());
    assertNull(actualCastExpr.getOp2());
    assertEquals(ET.E1, actualCastExpr.et);
    assertEquals(VT.CAST, actualCastExpr.vt);
    assertSame(value, op);
  }

  /**
   * Test {@link CastExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link CastExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.CastExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    CastExpr nCastResult =
        Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act
    nCastResult.releaseMemory();

    // Assert
    assertEquals("(()null)", nCastResult.toString0());
    assertNull(nCastResult.from);
    assertNull(nCastResult.to);
    assertNull(nCastResult.getOp());
  }

  /**
   * Test {@link CastExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return CastExpr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.CastExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenReturnCastExpr() {
    // Arrange
    CastExpr nCastResult =
        Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act
    Value actualCloneResult = nCastResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof CastExpr);
    assertTrue(actualCloneResult.getOp() instanceof Constant);
    assertEquals("alice.liddell@example.org", ((CastExpr) actualCloneResult).to);
    assertEquals("jane.doe@example.org", ((CastExpr) actualCloneResult).from);
    assertNull(actualCloneResult.getOps());
    assertNull(((CastExpr) actualCloneResult).tag);
    assertNull(((CastExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(ET.E1, ((CastExpr) actualCloneResult).et);
    assertEquals(VT.CAST, ((CastExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link CastExpr#clone()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr} {@link ArrayExpr#clone()} return {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return Op is {@link ArrayExpr#ArrayExpr()}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#clone()}
   */
  @Test
  @DisplayName(
      "Test clone(); given ArrayExpr clone() return ArrayExpr(); then return Op is ArrayExpr()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.CastExpr.clone()"})
  void testClone_givenArrayExprCloneReturnArrayExpr_thenReturnOpIsArrayExpr() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    op1.setOp1(Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org"));
    ArrayExpr arrayExpr = mock(ArrayExpr.class);
    ArrayExpr arrayExpr2 = new ArrayExpr();
    when(arrayExpr.clone()).thenReturn(arrayExpr2);
    ArrayExpr obj = mock(ArrayExpr.class);
    when(obj.trim()).thenReturn(arrayExpr);
    doNothing().when(obj).setOp1(Mockito.<Value>any());
    obj.setOp1(op1);

    // Act
    Value actualCloneResult =
        Exprs.nCast(obj, "jane.doe@example.org", "alice.liddell@example.org").clone();

    // Assert
    verify(arrayExpr).clone();
    verify(obj).trim();
    verify(obj).setOp1(isA(Value.class));
    assertTrue(actualCloneResult instanceof CastExpr);
    assertSame(arrayExpr2, actualCloneResult.getOp());
  }

  /**
   * Test {@link CastExpr#clone()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr} {@link Value#trim()} return nNull.
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); given ArrayExpr trim() return nNull; then Op return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.CastExpr.clone()"})
  void testClone_givenArrayExprTrimReturnNNull_thenOpReturnConstant() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    op1.setOp1(Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org"));
    ArrayExpr obj = mock(ArrayExpr.class);
    Constant nNullResult = Exprs.nNull();
    when(obj.trim()).thenReturn(nNullResult);
    doNothing().when(obj).setOp1(Mockito.<Value>any());
    obj.setOp1(op1);

    // Act
    Value actualCloneResult =
        Exprs.nCast(obj, "jane.doe@example.org", "alice.liddell@example.org").clone();

    // Assert
    verify(obj).trim();
    verify(obj).setOp1(isA(Value.class));
    assertTrue(actualCloneResult instanceof CastExpr);
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertNull(op.getOp1());
    assertNull(op.getOp2());
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(VT.CONSTANT, ((Constant) op).vt);
    assertSame(nNullResult.value, ((Constant) op).value);
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.CastExpr.toString0()"})
  void testToString0() {
    // Arrange
    CastExpr nCastResult =
        Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");
    nCastResult.to = null;

    // Act and Assert
    assertEquals("(()null[null])", nCastResult.toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code ((double)null[null][null])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given ArrayExpr() Op1 is ArrayExpr(); then return '((double)null[null][null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.CastExpr.toString0()"})
  void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnDoubleNullNullNull() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();
    obj.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals(
        "((double)null[null][null])", Exprs.nCast(obj, "jane.doe@example.org", "D").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((double)null)}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return '((double)null)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.CastExpr.toString0()"})
  void testToString0_thenReturnDoubleNull() {
    // Arrange, Act and Assert
    assertEquals("((double)null)", Exprs.nCast(null, "jane.doe@example.org", "D").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((double)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return '((double)null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.CastExpr.toString0()"})
  void testToString0_thenReturnDoubleNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "((double)null[null])",
        Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "D").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((double)null[null][null[null]])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return '((double)null[null][null[null]])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.CastExpr.toString0()"})
  void testToString0_thenReturnDoubleNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "((double)null[null][null[null]])",
        Exprs.nCast(Exprs.nArray(base, new ArrayExpr(), "(("), "jane.doe@example.org", "D")
            .toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((float)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return '((float)null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.CastExpr.toString0()"})
  void testToString0_thenReturnFloatNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "((float)null[null])",
        Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "F").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((int)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return '((int)null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.CastExpr.toString0()"})
  void testToString0_thenReturnIntNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "((int)null[null])", Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "I").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code (([])null[null][null])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return '(([])null[null][null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.CastExpr.toString0()"})
  void testToString0_thenReturnNullNullNull() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();
    obj.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals(
        "(([])null[null][null])", Exprs.nCast(obj, "jane.doe@example.org", "[").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.CastExpr.toString0()"})
  void testToString02() {
    // Arrange
    CastExpr nCastResult =
        Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");
    nCastResult.to = "";

    // Act and Assert
    assertEquals("(()null[null])", nCastResult.toString0());
  }
}
