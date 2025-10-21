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

public class FieldExprDiffblueTest {
  /**
   * Test {@link FieldExpr#FieldExpr(Value, String, String, String)}.
   *
   * <p>Method under test: {@link FieldExpr#FieldExpr(Value, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldExpr.<init>(Value, String, String, String)"})
  public void testNewFieldExpr() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldExpr.releaseMemory()"})
  public void testReleaseMemory() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value FieldExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenOpReturnConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldExpr.toString0()"})
  public void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnNullNullNullFieldName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldExpr.toString0()"})
  public void testToString0_thenReturnNullFieldName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldExpr.toString0()"})
  public void testToString0_thenReturnNullNullFieldName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldExpr.toString0()"})
  public void testToString0_thenReturnNullNullFieldName2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldExpr.toString0()"})
  public void testToString0_thenReturnNullNullNullNullFieldName() {
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
