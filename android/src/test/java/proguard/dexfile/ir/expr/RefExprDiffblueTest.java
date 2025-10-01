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

class RefExprDiffblueTest {
  /**
   * Test {@link RefExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link RefExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RefExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    RefExpr nExceptionRefResult = Exprs.nExceptionRef("Type");

    // Act
    nExceptionRefResult.releaseMemory();

    // Assert
    assertNull(nExceptionRefResult.type);
  }

  /**
   * Test {@link RefExpr#RefExpr(VT, String, int)}.
   *
   * <p>Method under test: {@link RefExpr#RefExpr(VT, String, int)}
   */
  @Test
  @DisplayName("Test new RefExpr(VT, String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RefExpr.<init>(VT, String, int)"})
  void testNewRefExpr() {
    // Arrange and Act
    RefExpr actualRefExpr = new RefExpr(VT.ADD, "Ref Type", 1);

    // Assert
    assertEquals("Ref Type", actualRefExpr.type);
    assertNull(actualRefExpr.tag);
    assertNull(actualRefExpr.valueType);
    assertNull(actualRefExpr.getOp());
    assertNull(actualRefExpr.getOp1());
    assertNull(actualRefExpr.getOp2());
    assertNull(actualRefExpr.getOps());
    assertEquals(1, actualRefExpr.parameterIndex);
    assertEquals(ET.E0, actualRefExpr.et);
    assertEquals(VT.ADD, actualRefExpr.vt);
  }

  /**
   * Test {@link RefExpr#clone()}.
   *
   * <p>Method under test: {@link RefExpr#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value RefExpr.clone()"})
  void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nExceptionRef("Type").clone();

    // Assert
    assertTrue(actualCloneResult instanceof RefExpr);
    assertEquals("@Exception", actualCloneResult.toString0());
    assertEquals("Type", ((RefExpr) actualCloneResult).type);
    assertNull(((RefExpr) actualCloneResult).tag);
    assertNull(((RefExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getOps());
    assertEquals(-1, ((RefExpr) actualCloneResult).parameterIndex);
    assertEquals(ET.E0, ((RefExpr) actualCloneResult).et);
    assertEquals(VT.EXCEPTION_REF, ((RefExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link RefExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link RefExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value RefExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper() {
    // Arrange
    RefExpr nExceptionRefResult = Exprs.nExceptionRef("Type");

    // Act
    Value actualCloneResult = nExceptionRefResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof RefExpr);
    assertEquals("@Exception", actualCloneResult.toString0());
    assertEquals("Type", ((RefExpr) actualCloneResult).type);
    assertNull(((RefExpr) actualCloneResult).tag);
    assertNull(((RefExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getOps());
    assertEquals(-1, ((RefExpr) actualCloneResult).parameterIndex);
    assertEquals(ET.E0, ((RefExpr) actualCloneResult).et);
    assertEquals(VT.EXCEPTION_REF, ((RefExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link RefExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nExceptionRef {@code Type}.
   *   <li>Then return {@code @Exception}.
   * </ul>
   *
   * <p>Method under test: {@link RefExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given nExceptionRef 'Type'; then return '@Exception'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RefExpr.toString0()"})
  void testToString0_givenNExceptionRefType_thenReturnException() {
    // Arrange, Act and Assert
    assertEquals("@Exception", Exprs.nExceptionRef("Type").toString0());
  }

  /**
   * Test {@link RefExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link RefExpr#RefExpr(VT, String, int)} with vt is {@code THIS_REF} and {@code Ref
   *       Type} and index is one.
   *   <li>Then return {@code @this}.
   * </ul>
   *
   * <p>Method under test: {@link RefExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given RefExpr(VT, String, int) with vt is 'THIS_REF' and 'Ref Type' and index is one; then return '@this'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RefExpr.toString0()"})
  void testToString0_givenRefExprWithVtIsThisRefAndRefTypeAndIndexIsOne_thenReturnThis() {
    // Arrange, Act and Assert
    assertEquals("@this", new RefExpr(VT.THIS_REF, "Ref Type", 1).toString0());
  }

  /**
   * Test {@link RefExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code @parameter_1}.
   * </ul>
   *
   * <p>Method under test: {@link RefExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return '@parameter_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RefExpr.toString0()"})
  void testToString0_thenReturnParameter1() {
    // Arrange, Act and Assert
    assertEquals("@parameter_1", new RefExpr(VT.PARAMETER_REF, "Ref Type", 1).toString0());
  }
}
