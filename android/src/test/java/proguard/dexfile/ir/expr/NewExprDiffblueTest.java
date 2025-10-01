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

class NewExprDiffblueTest {
  /**
   * Test {@link NewExpr#NewExpr(String)}.
   *
   * <p>Method under test: {@link NewExpr#NewExpr(String)}
   */
  @Test
  @DisplayName("Test new NewExpr(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NewExpr.<init>(String)"})
  void testNewNewExpr() {
    // Arrange and Act
    NewExpr actualNewExpr = new NewExpr("Type");

    // Assert
    assertEquals("Type", actualNewExpr.type);
    assertNull(actualNewExpr.tag);
    assertNull(actualNewExpr.valueType);
    assertNull(actualNewExpr.getOp());
    assertNull(actualNewExpr.getOp1());
    assertNull(actualNewExpr.getOp2());
    assertNull(actualNewExpr.getOps());
    assertEquals(ET.E0, actualNewExpr.et);
    assertEquals(VT.NEW, actualNewExpr.vt);
  }

  /**
   * Test {@link NewExpr#clone()}.
   *
   * <p>Method under test: {@link NewExpr#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value NewExpr.clone()"})
  void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nNew("Type").clone();

    // Assert
    assertTrue(actualCloneResult instanceof NewExpr);
    assertEquals("Type", ((NewExpr) actualCloneResult).type);
    assertNull(((NewExpr) actualCloneResult).tag);
    assertNull(((NewExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getOps());
    assertEquals(ET.E0, ((NewExpr) actualCloneResult).et);
    assertEquals(VT.NEW, ((NewExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link NewExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link NewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value NewExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper() {
    // Arrange
    NewExpr nNewResult = Exprs.nNew("Type");

    // Act
    Value actualCloneResult = nNewResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof NewExpr);
    assertEquals("Type", ((NewExpr) actualCloneResult).type);
    assertNull(((NewExpr) actualCloneResult).tag);
    assertNull(((NewExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getOps());
    assertEquals(ET.E0, ((NewExpr) actualCloneResult).et);
    assertEquals(VT.NEW, ((NewExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link NewExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link NewExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NewExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    NewExpr nNewResult = Exprs.nNew("Type");

    // Act
    nNewResult.releaseMemory();

    // Assert
    assertEquals("NEW ", nNewResult.toString0());
    assertNull(nNewResult.type);
  }

  /**
   * Test {@link NewExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNew {@code D}.
   *   <li>Then return {@code NEW double}.
   * </ul>
   *
   * <p>Method under test: {@link NewExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given nNew 'D'; then return 'NEW double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewExpr.toString0()"})
  void testToString0_givenNNewD_thenReturnNewDouble() {
    // Arrange, Act and Assert
    assertEquals("NEW double", Exprs.nNew("D").toString0());
  }

  /**
   * Test {@link NewExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNew empty string.
   *   <li>Then return {@code NEW}.
   * </ul>
   *
   * <p>Method under test: {@link NewExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given nNew empty string; then return 'NEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewExpr.toString0()"})
  void testToString0_givenNNewEmptyString_thenReturnNew() {
    // Arrange, Act and Assert
    assertEquals("NEW ", Exprs.nNew("").toString0());
  }

  /**
   * Test {@link NewExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNew {@code F}.
   *   <li>Then return {@code NEW float}.
   * </ul>
   *
   * <p>Method under test: {@link NewExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given nNew 'F'; then return 'NEW float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewExpr.toString0()"})
  void testToString0_givenNNewF_thenReturnNewFloat() {
    // Arrange, Act and Assert
    assertEquals("NEW float", Exprs.nNew("F").toString0());
  }

  /**
   * Test {@link NewExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNew {@code I}.
   *   <li>Then return {@code NEW int}.
   * </ul>
   *
   * <p>Method under test: {@link NewExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given nNew 'I'; then return 'NEW int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewExpr.toString0()"})
  void testToString0_givenNNewI_thenReturnNewInt() {
    // Arrange, Act and Assert
    assertEquals("NEW int", Exprs.nNew("I").toString0());
  }

  /**
   * Test {@link NewExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNew {@code J}.
   *   <li>Then return {@code NEW long}.
   * </ul>
   *
   * <p>Method under test: {@link NewExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); given nNew 'J'; then return 'NEW long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewExpr.toString0()"})
  void testToString0_givenNNewJ_thenReturnNewLong() {
    // Arrange, Act and Assert
    assertEquals("NEW long", Exprs.nNew("J").toString0());
  }
}
