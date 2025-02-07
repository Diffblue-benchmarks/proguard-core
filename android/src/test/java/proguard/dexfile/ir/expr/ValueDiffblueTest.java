package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.E1Expr;
import proguard.dexfile.ir.expr.Value.E2Expr;
import proguard.dexfile.ir.expr.Value.EnExpr;
import proguard.dexfile.ir.expr.Value.VT;

class ValueDiffblueTest {
  /**
   * Test E1Expr {@link E1Expr#getOp()}.
   *
   * <p>Method under test: {@link E1Expr#getOp()}
   */
  @Test
  @DisplayName("Test E1Expr getOp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.Value$E1Expr.getOp()"
  })
  void testE1ExprGetOp() {
    // Arrange
    CastExpr nCastResult =
        Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act and Assert
    assertSame(nCastResult.op, nCastResult.getOp());
  }

  /**
   * Test E1Expr {@link E1Expr#releaseMemory()}.
   *
   * <p>Method under test: {@link E1Expr#releaseMemory()}
   */
  @Test
  @DisplayName("Test E1Expr releaseMemory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.Value$E1Expr.releaseMemory()"})
  void testE1ExprReleaseMemory() {
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
   * Test E2Expr {@link E2Expr#getOp1()}.
   *
   * <p>Method under test: {@link E2Expr#getOp1()}
   */
  @Test
  @DisplayName("Test E2Expr getOp1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.Value$E2Expr.getOp1()"
  })
  void testE2ExprGetOp1() {
    // Arrange, Act and Assert
    assertNull((new ArrayExpr()).getOp1());
  }

  /**
   * Test E2Expr {@link E2Expr#getOp2()}.
   *
   * <p>Method under test: {@link E2Expr#getOp2()}
   */
  @Test
  @DisplayName("Test E2Expr getOp2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.Value$E2Expr.getOp2()"
  })
  void testE2ExprGetOp2() {
    // Arrange, Act and Assert
    assertNull((new ArrayExpr()).getOp2());
  }

  /**
   * Test EnExpr {@link EnExpr#cloneOps(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link EnExpr#cloneOps(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test EnExpr cloneOps(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return CastExpr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value[] proguard.dexfile.ir.expr.Value$EnExpr.cloneOps(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testEnExprCloneOpsWithLabelAndLocalMapper_thenFirstElementReturnCastExpr() {
    // Arrange
    PhiExpr nPhiResult =
        Exprs.nPhi(Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org"));

    // Act
    Value[] actualCloneOpsResult = nPhiResult.cloneOps(new LabelAndLocalMapper());

    // Assert
    Value value = actualCloneOpsResult[0];
    assertTrue(value instanceof CastExpr);
    assertTrue(value.getOp() instanceof Constant);
    assertEquals("alice.liddell@example.org", ((CastExpr) value).to);
    assertEquals("jane.doe@example.org", ((CastExpr) value).from);
    assertEquals(1, actualCloneOpsResult.length);
    assertEquals(ET.E1, ((CastExpr) value).et);
    assertEquals(VT.CAST, ((CastExpr) value).vt);
  }

  /**
   * Test EnExpr {@link EnExpr#cloneOps(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link FilledArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link EnExpr#cloneOps(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test EnExpr cloneOps(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return FilledArrayExpr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value[] proguard.dexfile.ir.expr.Value$EnExpr.cloneOps(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testEnExprCloneOpsWithLabelAndLocalMapper_thenFirstElementReturnFilledArrayExpr() {
    // Arrange
    PhiExpr nPhiResult =
        Exprs.nPhi(Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()}));

    // Act
    Value[] actualCloneOpsResult = nPhiResult.cloneOps(new LabelAndLocalMapper());

    // Assert
    Value value = actualCloneOpsResult[0];
    Value[] ops = value.getOps();
    assertTrue(ops[0] instanceof Constant);
    assertTrue(value instanceof FilledArrayExpr);
    assertEquals("Element Type", ((FilledArrayExpr) value).type);
    assertEquals(1, ops.length);
    assertEquals(1, actualCloneOpsResult.length);
    assertEquals(ET.En, ((FilledArrayExpr) value).et);
    assertEquals(VT.FILLED_ARRAY, ((FilledArrayExpr) value).vt);
  }

  /**
   * Test EnExpr {@link EnExpr#cloneOps(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return first element {@link Value#et} is {@code E0}.
   * </ul>
   *
   * <p>Method under test: {@link EnExpr#cloneOps(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test EnExpr cloneOps(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return first element et is 'E0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value[] proguard.dexfile.ir.expr.Value$EnExpr.cloneOps(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testEnExprCloneOpsWithLabelAndLocalMapper_thenReturnFirstElementEtIsE0() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    PhiExpr nPhiResult = Exprs.nPhi(nNullResult);

    // Act
    Value[] actualCloneOpsResult = nPhiResult.cloneOps(new LabelAndLocalMapper());

    // Assert
    Value value = actualCloneOpsResult[0];
    assertTrue(value instanceof Constant);
    assertEquals(1, actualCloneOpsResult.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test EnExpr {@link EnExpr#cloneOps()}.
   *
   * <ul>
   *   <li>Given nPhi.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link EnExpr#cloneOps()}
   */
  @Test
  @DisplayName("Test EnExpr cloneOps(); given nPhi; then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value[] proguard.dexfile.ir.expr.Value$EnExpr.cloneOps()"
  })
  void testEnExprCloneOps_givenNPhi_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, Exprs.nPhi().cloneOps().length);
  }

  /**
   * Test EnExpr {@link EnExpr#getOps()}.
   *
   * <p>Method under test: {@link EnExpr#getOps()}
   */
  @Test
  @DisplayName("Test EnExpr getOps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value[] proguard.dexfile.ir.expr.Value$EnExpr.getOps()"
  })
  void testEnExprGetOps() {
    // Arrange
    PhiExpr nPhiResult = Exprs.nPhi(new ArrayExpr());

    // Act and Assert
    assertSame(nPhiResult.ops, nPhiResult.getOps());
  }

  /**
   * Test EnExpr {@link EnExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link EnExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test EnExpr releaseMemory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.Value$EnExpr.releaseMemory()"})
  void testEnExprReleaseMemory() {
    // Arrange
    PhiExpr nPhiResult = Exprs.nPhi(new ArrayExpr());

    // Act
    nPhiResult.releaseMemory();

    // Assert
    assertNull(nPhiResult.getOps());
  }

  /**
   * Test EnExpr {@link EnExpr#setOps(Value[])}.
   *
   * <p>Method under test: {@link EnExpr#setOps(Value[])}
   */
  @Test
  @DisplayName("Test EnExpr setOps(Value[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.expr.Value$EnExpr.setOps(proguard.dexfile.ir.expr.Value[])"
  })
  void testEnExprSetOps() {
    // Arrange
    PhiExpr nPhiResult = Exprs.nPhi(new ArrayExpr());
    Value[] ops = new Value[] {new ArrayExpr()};

    // Act
    nPhiResult.setOps(ops);

    // Assert
    assertSame(ops, nPhiResult.getOps());
  }

  /**
   * Test {@link Value#getOp()}.
   *
   * <p>Method under test: {@link Value#getOp()}
   */
  @Test
  @DisplayName("Test getOp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.Value.getOp()"})
  void testGetOp() {
    // Arrange, Act and Assert
    assertNull((new ArrayExpr()).getOp());
  }

  /**
   * Test {@link Value#getOp1()}.
   *
   * <p>Method under test: {@link Value#getOp1()}
   */
  @Test
  @DisplayName("Test getOp1()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.Value.getOp1()"})
  void testGetOp1() {
    // Arrange, Act and Assert
    assertNull((new Local()).getOp1());
  }

  /**
   * Test {@link Value#getOp2()}.
   *
   * <p>Method under test: {@link Value#getOp2()}
   */
  @Test
  @DisplayName("Test getOp2()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.Value.getOp2()"})
  void testGetOp2() {
    // Arrange, Act and Assert
    assertNull((new Local()).getOp2());
  }

  /**
   * Test {@link Value#getOps()}.
   *
   * <p>Method under test: {@link Value#getOps()}
   */
  @Test
  @DisplayName("Test getOps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value[] proguard.dexfile.ir.expr.Value.getOps()"})
  void testGetOps() {
    // Arrange, Act and Assert
    assertNull((new ArrayExpr()).getOps());
  }

  /**
   * Test {@link Value#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null][null]}.
   * </ul>
   *
   * <p>Method under test: {@link Value#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given ArrayExpr() Op1 is ArrayExpr(); then return 'null[null][null]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.Value.toString()"})
  void testToString_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("null[null][null]", arrayExpr.toString());
  }

  /**
   * Test {@link Value#toString()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null]}.
   * </ul>
   *
   * <p>Method under test: {@link Value#toString()}
   */
  @Test
  @DisplayName("Test toString(); given ArrayExpr(); then return 'null[null]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.Value.toString()"})
  void testToString_givenArrayExpr_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("null[null]", (new ArrayExpr()).toString());
  }

  /**
   * Test {@link Value#toString()}.
   *
   * <ul>
   *   <li>Then return {@code null[null][null[null]]}.
   * </ul>
   *
   * <p>Method under test: {@link Value#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'null[null][null[null]]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.Value.toString()"})
  void testToString_thenReturnNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals("null[null][null[null]]", Exprs.nArray(base, new ArrayExpr(), "[").toString());
  }

  /**
   * Test {@link Value#trim()}.
   *
   * <p>Method under test: {@link Value#trim()}
   */
  @Test
  @DisplayName("Test trim()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.Value.trim()"})
  void testTrim() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();

    // Act and Assert
    assertSame(arrayExpr, arrayExpr.trim());
  }

  /**
   * Test VT {@link VT#canThrow()}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VT#canThrow()}
   */
  @Test
  @DisplayName("Test VT canThrow(); given 'ADD'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.expr.Value$VT.canThrow()"})
  void testVTCanThrow_givenAdd_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(VT.ADD.canThrow());
  }

  /**
   * Test VT {@link VT#canThrow()}.
   *
   * <ul>
   *   <li>Given {@code ARRAY}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VT#canThrow()}
   */
  @Test
  @DisplayName("Test VT canThrow(); given 'ARRAY'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.expr.Value$VT.canThrow()"})
  void testVTCanThrow_givenArray_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(VT.ARRAY.canThrow());
  }

  /**
   * Test VT {@link VT#mayThrow()}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VT#mayThrow()}
   */
  @Test
  @DisplayName("Test VT mayThrow(); given 'ADD'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.expr.Value$VT.mayThrow()"})
  void testVTMayThrow_givenAdd_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(VT.ADD.mayThrow());
  }

  /**
   * Test VT {@link VT#mayThrow()}.
   *
   * <ul>
   *   <li>Given {@code ARRAY}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VT#mayThrow()}
   */
  @Test
  @DisplayName("Test VT mayThrow(); given 'ARRAY'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.dexfile.ir.expr.Value$VT.mayThrow()"})
  void testVTMayThrow_givenArray_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(VT.ARRAY.mayThrow());
  }

  /**
   * Test VT {@link VT#toString()}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>Then return {@code +}.
   * </ul>
   *
   * <p>Method under test: {@link VT#toString()}
   */
  @Test
  @DisplayName("Test VT toString(); given 'ADD'; then return '+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.Value$VT.toString()"})
  void testVTToString_givenAdd_thenReturnPlusSign() {
    // Arrange, Act and Assert
    assertEquals("+", VT.ADD.toString());
  }

  /**
   * Test VT {@link VT#toString()}.
   *
   * <ul>
   *   <li>Given {@code ARRAY}.
   *   <li>Then return {@code ARRAY}.
   * </ul>
   *
   * <p>Method under test: {@link VT#toString()}
   */
  @Test
  @DisplayName("Test VT toString(); given 'ARRAY'; then return 'ARRAY'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.Value$VT.toString()"})
  void testVTToString_givenArray_thenReturnArray() {
    // Arrange, Act and Assert
    assertEquals("ARRAY", VT.ARRAY.toString());
  }
}
