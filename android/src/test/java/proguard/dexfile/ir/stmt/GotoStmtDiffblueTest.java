package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import proguard.dexfile.ir.stmt.Stmt.ST;

class GotoStmtDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GotoStmt#setTarget(LabelStmt)}
   *   <li>{@link GotoStmt#toString()}
   *   <li>{@link GotoStmt#getTarget()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LabelStmt GotoStmt.getTarget()",
    "void GotoStmt.setTarget(LabelStmt)",
    "java.lang.String GotoStmt.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    GotoStmt gotoStmt = new GotoStmt(Stmts.nLabel());
    LabelStmt target = Stmts.nLabel();

    // Act
    gotoStmt.setTarget(target);
    gotoStmt.toString();

    // Assert
    assertSame(target, gotoStmt.getTarget());
  }

  /**
   * Test {@link GotoStmt#GotoStmt(LabelStmt)}.
   *
   * <p>Method under test: {@link GotoStmt#GotoStmt(LabelStmt)}
   */
  @Test
  @DisplayName("Test new GotoStmt(LabelStmt)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GotoStmt.<init>(LabelStmt)"})
  void testNewGotoStmt() {
    // Arrange
    LabelStmt target = Stmts.nLabel();

    // Act
    GotoStmt actualGotoStmt = new GotoStmt(target);

    // Assert
    assertNull(actualGotoStmt.frame);
    assertNull(actualGotoStmt.exceptionHandlers);
    assertNull(actualGotoStmt._cfg_froms);
    assertNull(actualGotoStmt.getOp());
    assertNull(actualGotoStmt.getOp1());
    assertNull(actualGotoStmt.getOp2());
    assertNull(actualGotoStmt.getOps());
    assertNull(actualGotoStmt.getNext());
    assertNull(actualGotoStmt.getPre());
    assertNull(actualGotoStmt._ts_default_next);
    assertNull(actualGotoStmt.list);
    assertEquals(0, actualGotoStmt.id);
    assertEquals(ET.E0, actualGotoStmt.et);
    assertEquals(ST.GOTO, actualGotoStmt.st);
    assertFalse(actualGotoStmt.visited);
    assertSame(target, actualGotoStmt.getTarget());
  }

  /**
   * Test {@link GotoStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>When {@link LabelAndLocalMapper} (default constructor).
   *   <li>Then return {@link GotoStmt}.
   * </ul>
   *
   * <p>Method under test: {@link GotoStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; when LabelAndLocalMapper (default constructor); then return GotoStmt")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt GotoStmt.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_whenLabelAndLocalMapper_thenReturnGotoStmt() {
    // Arrange
    GotoStmt nGotoResult = Stmts.nGoto(Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nGotoResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof GotoStmt);
    assertNull(((GotoStmt) actualCloneResult).frame);
    assertNull(((GotoStmt) actualCloneResult).exceptionHandlers);
    assertNull(((GotoStmt) actualCloneResult)._cfg_froms);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getOps());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((GotoStmt) actualCloneResult)._ts_default_next);
    assertNull(((GotoStmt) actualCloneResult).list);
    assertEquals(0, ((GotoStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((GotoStmt) actualCloneResult).et);
    assertEquals(ST.GOTO, ((GotoStmt) actualCloneResult).st);
    assertFalse(((GotoStmt) actualCloneResult).visited);
  }
}
