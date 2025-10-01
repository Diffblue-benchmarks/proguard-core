package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticFieldExpr.releaseMemory()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticFieldExpr.<init>(String, String, String)"})
  void testNewStaticFieldExpr() {
    // Arrange and Act
    StaticFieldExpr actualStaticFieldExpr =
        new StaticFieldExpr("Owner Type", "Field Name", "Field Type");

    // Assert
    assertEquals("Field Name", actualStaticFieldExpr.name);
    assertEquals("Field Type", actualStaticFieldExpr.type);
    assertEquals("Owner Type", actualStaticFieldExpr.owner);
    assertNull(actualStaticFieldExpr.tag);
    assertNull(actualStaticFieldExpr.valueType);
    assertNull(actualStaticFieldExpr.getOp());
    assertNull(actualStaticFieldExpr.getOp1());
    assertNull(actualStaticFieldExpr.getOp2());
    assertNull(actualStaticFieldExpr.getOps());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value StaticFieldExpr.clone()"})
  void testClone() {
    // Arrange
    StaticFieldExpr nStaticFieldResult =
        Exprs.nStaticField("Owner Type", "Field Name", "Field Type");

    // Act
    Value actualCloneResult = nStaticFieldResult.clone();

    // Assert
    assertTrue(actualCloneResult instanceof StaticFieldExpr);
    assertEquals("Field Name", ((StaticFieldExpr) actualCloneResult).name);
    assertEquals("Field Type", ((StaticFieldExpr) actualCloneResult).type);
    assertEquals("Owner Type", ((StaticFieldExpr) actualCloneResult).owner);
    assertNull(((StaticFieldExpr) actualCloneResult).tag);
    assertNull(((StaticFieldExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getOps());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value StaticFieldExpr.clone(LabelAndLocalMapper)"})
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
    assertNull(((StaticFieldExpr) actualCloneResult).tag);
    assertNull(((StaticFieldExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getOps());
    assertEquals(ET.E0, ((StaticFieldExpr) actualCloneResult).et);
    assertEquals(VT.STATIC_FIELD, ((StaticFieldExpr) actualCloneResult).vt);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticFieldExpr.toString0()"})
  void testToString0_thenReturnDoubleFieldName() {
    // Arrange
    StaticFieldExpr nStaticFieldResult = Exprs.nStaticField("D", "Field Name", "Field Type");

    // Act and Assert
    assertEquals("double.Field Name", nStaticFieldResult.toString0());
  }

  /**
   * Test {@link StaticFieldExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code .Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link StaticFieldExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return '.Field Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticFieldExpr.toString0()"})
  void testToString0_thenReturnFieldName() {
    // Arrange
    StaticFieldExpr nStaticFieldResult = Exprs.nStaticField("", "Field Name", "Field Type");

    // Act and Assert
    assertEquals(".Field Name", nStaticFieldResult.toString0());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticFieldExpr.toString0()"})
  void testToString0_thenReturnFloatFieldName() {
    // Arrange
    StaticFieldExpr nStaticFieldResult = Exprs.nStaticField("F", "Field Name", "Field Type");

    // Act and Assert
    assertEquals("float.Field Name", nStaticFieldResult.toString0());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticFieldExpr.toString0()"})
  void testToString0_thenReturnIntFieldName() {
    // Arrange
    StaticFieldExpr nStaticFieldResult = Exprs.nStaticField("I", "Field Name", "Field Type");

    // Act and Assert
    assertEquals("int.Field Name", nStaticFieldResult.toString0());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticFieldExpr.toString0()"})
  void testToString0_thenReturnLongFieldName() {
    // Arrange
    StaticFieldExpr nStaticFieldResult = Exprs.nStaticField("J", "Field Name", "Field Type");

    // Act and Assert
    assertEquals("long.Field Name", nStaticFieldResult.toString0());
  }
}
