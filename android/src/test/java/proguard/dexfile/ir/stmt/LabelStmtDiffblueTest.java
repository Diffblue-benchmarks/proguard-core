package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.stmt.Stmt.ST;

class LabelStmtDiffblueTest {
  /**
   * Test new {@link LabelStmt} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link LabelStmt}
   */
  @Test
  @DisplayName("Test new LabelStmt (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.stmt.LabelStmt.<init>()"})
  void testNewLabelStmt() {
    // Arrange and Act
    LabelStmt actualLabelStmt = new LabelStmt();

    // Assert
    assertNull(actualLabelStmt.getOps());
    assertNull(actualLabelStmt.tag);
    assertNull(actualLabelStmt.frame);
    assertNull(actualLabelStmt.displayName);
    assertNull(actualLabelStmt.phis);
    assertNull(actualLabelStmt.exceptionHandlers);
    assertNull(actualLabelStmt._cfg_froms);
    assertNull(actualLabelStmt.getOp());
    assertNull(actualLabelStmt.getOp1());
    assertNull(actualLabelStmt.getOp2());
    assertNull(actualLabelStmt.getNext());
    assertNull(actualLabelStmt.getPre());
    assertNull(actualLabelStmt._ts_default_next);
    assertNull(actualLabelStmt.list);
    assertEquals(-1, actualLabelStmt.lineNumber);
    assertEquals(0, actualLabelStmt.id);
    assertEquals(ET.E0, actualLabelStmt.et);
    assertEquals(ST.LABEL, actualLabelStmt.st);
    assertFalse(actualLabelStmt.visited);
  }

  /**
   * Test {@link LabelStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>When {@link LabelAndLocalMapper} (default constructor).
   *   <li>Then return Ops is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; when LabelAndLocalMapper (default constructor); then return Ops is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.LabelStmt proguard.dexfile.ir.stmt.LabelStmt.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_whenLabelAndLocalMapper_thenReturnOpsIsNull() {
    // Arrange
    LabelStmt nLabelResult = Stmts.nLabel();

    // Act
    LabelStmt actualCloneResult = nLabelResult.clone(new LabelAndLocalMapper());

    // Assert
    assertNull(actualCloneResult.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(actualCloneResult.frame);
    assertNull(actualCloneResult.displayName);
    assertNull(actualCloneResult.phis);
    assertNull(actualCloneResult.exceptionHandlers);
    assertNull(actualCloneResult._cfg_froms);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(actualCloneResult._ts_default_next);
    assertNull(actualCloneResult.list);
    assertEquals(-1, actualCloneResult.lineNumber);
    assertEquals(0, actualCloneResult.id);
    assertEquals(ET.E0, actualCloneResult.et);
    assertEquals(ST.LABEL, actualCloneResult.st);
    assertFalse(actualCloneResult.visited);
  }

  /**
   * Test {@link LabelStmt#getDisplayName()}.
   *
   * <ul>
   *   <li>Given nLabel {@link LabelStmt#displayName} is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#getDisplayName()}
   */
  @Test
  @DisplayName("Test getDisplayName(); given nLabel displayName is 'foo'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.LabelStmt.getDisplayName()"})
  void testGetDisplayName_givenNLabelDisplayNameIsFoo_thenReturnFoo() {
    // Arrange
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo", nLabelResult.getDisplayName());
  }

  /**
   * Test {@link LabelStmt#toString()}.
   *
   * <ul>
   *   <li>Given nLabel {@link LabelStmt#displayName} is {@code foo}.
   *   <li>Then return {@code foo: // line 0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelStmt#toString()}
   */
  @Test
  @DisplayName("Test toString(); given nLabel displayName is 'foo'; then return 'foo: // line 0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.LabelStmt.toString()"})
  void testToString_givenNLabelDisplayNameIsFoo_thenReturnFooLine0() {
    // Arrange
    LabelStmt nLabelResult = Stmts.nLabel();
    nLabelResult.phis = null;
    nLabelResult.lineNumber = 0;
    nLabelResult.displayName = "foo";

    // Act and Assert
    assertEquals("foo: // line 0", nLabelResult.toString());
  }
}
