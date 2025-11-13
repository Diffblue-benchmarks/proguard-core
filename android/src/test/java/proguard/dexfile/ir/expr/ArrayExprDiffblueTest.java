package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.VT;

class ArrayExprDiffblueTest {
  /**
   * Test {@link ArrayExpr#ArrayExpr()}.
   *
   * <p>Method under test: {@link ArrayExpr#ArrayExpr()}
   */
  @Test
  @DisplayName("Test new ArrayExpr()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayExpr.<init>()"})
  void testNewArrayExpr() {
    // Arrange and Act
    ArrayExpr actualArrayExpr = new ArrayExpr();

    // Assert
    assertEquals("null[null]", actualArrayExpr.toString0());
    assertNull(actualArrayExpr.tag);
    assertNull(actualArrayExpr.elementType);
    assertNull(actualArrayExpr.valueType);
    assertNull(actualArrayExpr.getOp());
    assertNull(actualArrayExpr.getOp1());
    assertNull(actualArrayExpr.getOp2());
    assertNull(actualArrayExpr.getOps());
    assertEquals(ET.E2, actualArrayExpr.et);
    assertEquals(VT.ARRAY, actualArrayExpr.vt);
  }

  /**
   * Test {@link ArrayExpr#ArrayExpr(Value, Value, String)}.
   *
   * <p>Method under test: {@link ArrayExpr#ArrayExpr(Value, Value, String)}
   */
  @Test
  @DisplayName("Test new ArrayExpr(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ArrayExpr.<init>(Value, Value, String)"})
  void testNewArrayExpr2() {
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
    assertNull(actualArrayExpr.tag);
    assertNull(actualArrayExpr.valueType);
    assertNull(actualArrayExpr.getOp());
    assertNull(actualArrayExpr.getOps());
    assertEquals(ET.E2, actualArrayExpr.et);
    assertEquals(VT.ARRAY, actualArrayExpr.vt);
    assertSame(base, op1);
    assertSame(index, op2);
  }

  /**
   * Test {@link ArrayExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op1 return {@link BinopExpr}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op1 return BinopExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value ArrayExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenOp1ReturnBinopExpr() {
    // Arrange
    Constant a = Exprs.nNull();
    BinopExpr base = Exprs.nDCmpg(a, Exprs.nNull());
    ArrayExpr nArrayResult = Exprs.nArray(base, Exprs.nNull(), "Element Type");

    // Act
    Value actualCloneResult = nArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof ArrayExpr);
    Value op1 = actualCloneResult.getOp1();
    assertTrue(op1 instanceof BinopExpr);
    assertTrue(op1.getOp1() instanceof Constant);
    assertTrue(op1.getOp2() instanceof Constant);
    assertEquals("(null DCMPG null)", op1.toString0());
    assertEquals("(null DCMPG null)[null]", actualCloneResult.toString0());
    assertEquals("D", ((BinopExpr) op1).type);
    assertEquals(ET.E2, ((BinopExpr) op1).et);
    assertEquals(VT.DCMPG, ((BinopExpr) op1).vt);
  }

  /**
   * Test {@link ArrayExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op1 return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op1 return Constant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value ArrayExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenOp1ReturnConstant() {
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
    assertEquals("null[null]", actualCloneResult.toString0());
    assertNull(op1.getOp1());
    assertNull(op1.getOp2());
    assertEquals(ET.E0, ((Constant) op1).et);
    assertEquals(VT.CONSTANT, ((Constant) op1).vt);
    Object object = ((Constant) op1).value;
    assertSame(index.value, object);
    assertSame(object, ((Constant) op2).value);
  }

  /**
   * Test {@link ArrayExpr#clone()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op2 is nNull.
   *   <li>Then Op1 return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link ArrayExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); given ArrayExpr() Op2 is nNull; then Op1 return Constant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value ArrayExpr.clone()"})
  void testClone_givenArrayExprOp2IsNNull_thenOp1ReturnConstant() {
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
    assertNull(((ArrayExpr) actualCloneResult).tag);
    assertNull(((ArrayExpr) actualCloneResult).elementType);
    assertNull(((ArrayExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOps());
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
  @DisplayName(
      "Test toString0(); given ArrayExpr() Op1 is ArrayExpr(); then return 'null[null][null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ArrayExpr.toString0()"})
  void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNull() {
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
  @DisplayName("Test toString0(); given ArrayExpr() Op1 is nNull; then return 'null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ArrayExpr.toString0()"})
  void testToString0_givenArrayExprOp1IsNNull_thenReturnNullNull() {
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
  @DisplayName(
      "Test toString0(); given ArrayExpr() Op2 is ArrayExpr(); then return 'null[null[null]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ArrayExpr.toString0()"})
  void testToString0_givenArrayExprOp2IsArrayExpr_thenReturnNullNullNull() {
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
  @DisplayName("Test toString0(); given ArrayExpr(); then return 'null[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ArrayExpr.toString0()"})
  void testToString0_givenArrayExpr_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("null[null]", new ArrayExpr().toString0());
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
  @DisplayName("Test toString0(); then return '(null[null] DCMPG null[null])[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ArrayExpr.toString0()"})
  void testToString0_thenReturnNullNullDcmpgNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    ArrayExpr a = new ArrayExpr();
    BinopExpr op1 = Exprs.nDCmpg(a, new ArrayExpr());
    arrayExpr.setOp1(op1);

    // Act and Assert
    assertEquals("(null[null] DCMPG null[null])[null]", arrayExpr.toString0());
  }
}
