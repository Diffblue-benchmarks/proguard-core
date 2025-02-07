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

class FieldExprDiffblueTest {
  /**
   * Test {@link FieldExpr#FieldExpr(Value, String, String, String)}.
   *
   * <p>Method under test: {@link FieldExpr#FieldExpr(Value, String, String, String)}
   */
  @Test
  @DisplayName("Test new FieldExpr(Value, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.expr.FieldExpr.<init>(proguard.dexfile.ir.expr.Value, java.lang.String, java.lang.String, java.lang.String)"
  })
  void testNewFieldExpr() {
    // Arrange
    ArrayExpr object = new ArrayExpr();

    // Act
    FieldExpr actualFieldExpr = new FieldExpr(object, "Owner Type", "Field Name", "Field Type");

    // Assert
    Value op = actualFieldExpr.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("Field Name", actualFieldExpr.name);
    assertEquals("Field Type", actualFieldExpr.type);
    assertEquals("Owner Type", actualFieldExpr.owner);
    assertEquals("null[null].Field Name", actualFieldExpr.toString0());
    assertNull(actualFieldExpr.getOps());
    assertNull(actualFieldExpr.tag);
    assertNull(actualFieldExpr.valueType);
    assertNull(actualFieldExpr.getOp1());
    assertNull(actualFieldExpr.getOp2());
    assertEquals(ET.E1, actualFieldExpr.et);
    assertEquals(VT.FIELD, actualFieldExpr.vt);
    assertSame(object, op);
  }

  /**
   * Test {@link FieldExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link FieldExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.FieldExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    FieldExpr nFieldResult =
        Exprs.nField(new ArrayExpr(), "Owner Type", "Field Name", "Field Type");

    // Act
    nFieldResult.releaseMemory();

    // Assert
    assertEquals("null.null", nFieldResult.toString0());
    assertNull(nFieldResult.name);
    assertNull(nFieldResult.owner);
    assertNull(nFieldResult.type);
    assertNull(nFieldResult.getOp());
  }

  /**
   * Test {@link FieldExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link FieldExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then Op return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.FieldExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenOpReturnConstant() {
    // Arrange
    FieldExpr nFieldResult = Exprs.nField(Exprs.nNull(), "Owner Type", "Field Name", "Field Type");

    // Act
    Value actualCloneResult = nFieldResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult.getOp() instanceof Constant);
    assertTrue(actualCloneResult instanceof FieldExpr);
    assertEquals("Field Name", ((FieldExpr) actualCloneResult).name);
    assertEquals("Field Type", ((FieldExpr) actualCloneResult).type);
    assertEquals("Owner Type", ((FieldExpr) actualCloneResult).owner);
    assertEquals("null.Field Name", actualCloneResult.toString0());
    assertNull(actualCloneResult.getOps());
    assertNull(((FieldExpr) actualCloneResult).tag);
    assertNull(((FieldExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(ET.E1, ((FieldExpr) actualCloneResult).et);
    assertEquals(VT.FIELD, ((FieldExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link FieldExpr#clone()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr} {@link Value#trim()} return nNull.
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link FieldExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); given ArrayExpr trim() return nNull; then Op return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.FieldExpr.clone()"})
  void testClone_givenArrayExprTrimReturnNNull_thenOpReturnConstant() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    Constant op12 = Exprs.nNull();
    op1.setOp1(op12);
    ArrayExpr object = mock(ArrayExpr.class);
    when(object.trim()).thenReturn(Exprs.nNull());
    doNothing().when(object).setOp1(Mockito.<Value>any());
    object.setOp1(op1);

    // Act
    Value actualCloneResult =
        Exprs.nField(object, "Owner Type", "Field Name", "Field Type").clone();

    // Assert
    verify(object).trim();
    verify(object).setOp1(isA(Value.class));
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof FieldExpr);
    assertEquals("null.Field Name", actualCloneResult.toString0());
    assertNull(op.getOp1());
    assertNull(op.getOp2());
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(VT.CONSTANT, ((Constant) op).vt);
    assertSame(op12.value, ((Constant) op).value);
  }

  /**
   * Test {@link FieldExpr#clone()}.
   *
   * <ul>
   *   <li>Then return toString0 is {@code null[null].Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link FieldExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return toString0 is 'null[null].Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.FieldExpr.clone()"})
  void testClone_thenReturnToString0IsNullNullFieldName() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    op1.setOp1(Exprs.nNull());
    ArrayExpr arrayExpr = mock(ArrayExpr.class);
    ArrayExpr arrayExpr2 = new ArrayExpr();
    when(arrayExpr.clone()).thenReturn(arrayExpr2);
    ArrayExpr object = mock(ArrayExpr.class);
    when(object.trim()).thenReturn(arrayExpr);
    doNothing().when(object).setOp1(Mockito.<Value>any());
    object.setOp1(op1);

    // Act
    Value actualCloneResult =
        Exprs.nField(object, "Owner Type", "Field Name", "Field Type").clone();

    // Assert
    verify(arrayExpr).clone();
    verify(object).trim();
    verify(object).setOp1(isA(Value.class));
    assertTrue(actualCloneResult instanceof FieldExpr);
    assertEquals("null[null].Field Name", actualCloneResult.toString0());
    assertSame(arrayExpr2, actualCloneResult.getOp());
  }

  /**
   * Test {@link FieldExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code null[null][null].Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link FieldExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given ArrayExpr() Op1 is ArrayExpr(); then return 'null[null][null].Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FieldExpr.toString0()"})
  void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNullFieldName() {
    // Arrange
    ArrayExpr object = new ArrayExpr();
    object.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals(
        "null[null][null].Field Name",
        Exprs.nField(object, "Owner Type", "Field Name", "Field Type").toString0());
  }

  /**
   * Test {@link FieldExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null.Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link FieldExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null.Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FieldExpr.toString0()"})
  void testToString0_thenReturnNullFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "null.Field Name",
        Exprs.nField(null, "Owner Type", "Field Name", "Field Type").toString0());
  }

  /**
   * Test {@link FieldExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link FieldExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FieldExpr.toString0()"})
  void testToString0_thenReturnNullNullFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "null[null].Field Name",
        Exprs.nField(new ArrayExpr(), "Owner Type", "Field Name", "Field Type").toString0());
  }

  /**
   * Test {@link FieldExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].[.Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link FieldExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].[.Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FieldExpr.toString0()"})
  void testToString0_thenReturnNullNullFieldName2() {
    // Arrange, Act and Assert
    assertEquals(
        "null[null].[.Field Name",
        Exprs.nField(
                Exprs.nField(new ArrayExpr(), "[", "[", "["),
                "Owner Type",
                "Field Name",
                "Field Type")
            .toString0());
  }

  /**
   * Test {@link FieldExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null][null[null]].Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link FieldExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null][null[null]].Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FieldExpr.toString0()"})
  void testToString0_thenReturnNullNullNullNullFieldName() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "null[null][null[null]].Field Name",
        Exprs.nField(
                Exprs.nArray(base, new ArrayExpr(), "["), "Owner Type", "Field Name", "Field Type")
            .toString0());
  }
}
