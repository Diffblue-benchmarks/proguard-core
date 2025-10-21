package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.VT;

public class StaticFieldExprDiffblueTest {
  /**
   * Test {@link StaticFieldExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link StaticFieldExpr#releaseMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticFieldExpr.releaseMemory()"})
  public void testReleaseMemory() {
    // Arrange
    StaticFieldExpr nStaticFieldResult =
        Exprs.nStaticField("Owner Type", "Field Name", "Field Type");

    // Act
    nStaticFieldResult.releaseMemory();

    // Assert
    assertEquals(".null", nStaticFieldResult.toString0());
    assertNull(nStaticFieldResult.name);
    assertNull(nStaticFieldResult.owner);
    assertNull(nStaticFieldResult.type);
  }

  /**
   * Test {@link StaticFieldExpr#StaticFieldExpr(String, String, String)}.
   *
   * <p>Method under test: {@link StaticFieldExpr#StaticFieldExpr(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticFieldExpr.<init>(String, String, String)"})
  public void testNewStaticFieldExpr() {
    // Arrange and Act
    StaticFieldExpr actualStaticFieldExpr =
        new StaticFieldExpr("Owner Type", "Field Name", "Field Type");

    // Assert
    assertEquals("Field Name", actualStaticFieldExpr.name);
    assertEquals("Field Type", actualStaticFieldExpr.type);
    assertEquals("Owner Type", actualStaticFieldExpr.owner);
    assertNull(actualStaticFieldExpr.getOps());
    assertNull(actualStaticFieldExpr.tag);
    assertNull(actualStaticFieldExpr.valueType);
    assertNull(actualStaticFieldExpr.getOp());
    assertNull(actualStaticFieldExpr.getOp1());
    assertNull(actualStaticFieldExpr.getOp2());
    assertEquals(ET.E0, actualStaticFieldExpr.et);
    assertEquals(VT.STATIC_FIELD, actualStaticFieldExpr.vt);
  }

  /**
   * Test {@link StaticFieldExpr#clone()}.
   *
   * <p>Method under test: {@link StaticFieldExpr#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value StaticFieldExpr.clone()"})
  public void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nStaticField("Owner Type", "Field Name", "Field Type").clone();

    // Assert
    assertTrue(actualCloneResult instanceof StaticFieldExpr);
    assertEquals("Field Name", ((StaticFieldExpr) actualCloneResult).name);
    assertEquals("Field Type", ((StaticFieldExpr) actualCloneResult).type);
    assertEquals("Owner Type", ((StaticFieldExpr) actualCloneResult).owner);
    assertNull(actualCloneResult.getOps());
    assertNull(((StaticFieldExpr) actualCloneResult).tag);
    assertNull(((StaticFieldExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(ET.E0, ((StaticFieldExpr) actualCloneResult).et);
    assertEquals(VT.STATIC_FIELD, ((StaticFieldExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link StaticFieldExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link StaticFieldExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value StaticFieldExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper() {
    // Arrange
    StaticFieldExpr nStaticFieldResult =
        Exprs.nStaticField("Owner Type", "Field Name", "Field Type");

    // Act
    Value actualCloneResult = nStaticFieldResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof StaticFieldExpr);
    assertEquals("Field Name", ((StaticFieldExpr) actualCloneResult).name);
    assertEquals("Field Type", ((StaticFieldExpr) actualCloneResult).type);
    assertEquals("Owner Type", ((StaticFieldExpr) actualCloneResult).owner);
    assertNull(actualCloneResult.getOps());
    assertNull(((StaticFieldExpr) actualCloneResult).tag);
    assertNull(((StaticFieldExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(ET.E0, ((StaticFieldExpr) actualCloneResult).et);
    assertEquals(VT.STATIC_FIELD, ((StaticFieldExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link StaticFieldExpr#toString0()}.
   *
   * <p>Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticFieldExpr.toString0()"})
  public void testToString0() {
    // Arrange
    StaticFieldExpr nStaticFieldResult =
        Exprs.nStaticField("Owner Type", "Field Name", "Field Type");
    nStaticFieldResult.owner = "";

    // Act and Assert
    assertEquals(".Field Name", nStaticFieldResult.toString0());
  }

  /**
   * Test {@link StaticFieldExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link Exprs#nStaticField(String, String, String)} with {@code Owner Type} and
   *       {@code Field Name} and {@code Field Type} {@link StaticFieldExpr#owner} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticFieldExpr.toString0()"})
  public void testToString0_givenNStaticFieldWithOwnerTypeAndFieldNameAndFieldTypeOwnerIsNull() {
    // Arrange
    StaticFieldExpr nStaticFieldResult =
        Exprs.nStaticField("Owner Type", "Field Name", "Field Type");
    nStaticFieldResult.owner = null;

    // Act and Assert
    assertEquals(".Field Name", nStaticFieldResult.toString0());
  }

  /**
   * Test {@link StaticFieldExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code double.Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticFieldExpr.toString0()"})
  public void testToString0_thenReturnDoubleFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "double.Field Name", Exprs.nStaticField("D", "Field Name", "Field Type").toString0());
  }

  /**
   * Test {@link StaticFieldExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code float.Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticFieldExpr.toString0()"})
  public void testToString0_thenReturnFloatFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "float.Field Name", Exprs.nStaticField("F", "Field Name", "Field Type").toString0());
  }

  /**
   * Test {@link StaticFieldExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code int.Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticFieldExpr.toString0()"})
  public void testToString0_thenReturnIntFieldName() {
    // Arrange, Act and Assert
    assertEquals("int.Field Name", Exprs.nStaticField("I", "Field Name", "Field Type").toString0());
  }

  /**
   * Test {@link StaticFieldExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code long.Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticFieldExpr.toString0()"})
  public void testToString0_thenReturnLongFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "long.Field Name", Exprs.nStaticField("J", "Field Name", "Field Type").toString0());
  }
}
