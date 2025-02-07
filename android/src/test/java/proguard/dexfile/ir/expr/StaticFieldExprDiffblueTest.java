package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.VT;

class StaticFieldExprDiffblueTest {
  /**
   * Test {@link StaticFieldExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link StaticFieldExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.StaticFieldExpr.releaseMemory()"})
  void testReleaseMemory() {
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
  @DisplayName("Test new StaticFieldExpr(String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.expr.StaticFieldExpr.<init>(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testNewStaticFieldExpr() {
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
  @DisplayName("Test clone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.StaticFieldExpr.clone()"
  })
  void testClone() {
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
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.StaticFieldExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper() {
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
  @DisplayName("Test toString0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.StaticFieldExpr.toString0()"})
  void testToString0() {
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
  @DisplayName(
      "Test toString0(); given nStaticField(String, String, String) with 'Owner Type' and 'Field Name' and 'Field Type' owner is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.StaticFieldExpr.toString0()"})
  void testToString0_givenNStaticFieldWithOwnerTypeAndFieldNameAndFieldTypeOwnerIsNull() {
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
  @DisplayName("Test toString0(); then return 'double.Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.StaticFieldExpr.toString0()"})
  void testToString0_thenReturnDoubleFieldName() {
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
  @DisplayName("Test toString0(); then return 'float.Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.StaticFieldExpr.toString0()"})
  void testToString0_thenReturnFloatFieldName() {
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
  @DisplayName("Test toString0(); then return 'int.Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.StaticFieldExpr.toString0()"})
  void testToString0_thenReturnIntFieldName() {
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
  @DisplayName("Test toString0(); then return 'long.Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.StaticFieldExpr.toString0()"})
  void testToString0_thenReturnLongFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "long.Field Name", Exprs.nStaticField("J", "Field Name", "Field Type").toString0());
  }
}
