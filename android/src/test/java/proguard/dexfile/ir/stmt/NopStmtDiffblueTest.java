package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.stmt.Stmt.ST;

class NopStmtDiffblueTest {
  /**
   * Test new {@link NopStmt} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NopStmt}
   */
  @Test
  @DisplayName("Test new NopStmt (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NopStmt.<init>()"})
  void testNewNopStmt() {
    // Arrange and Act
    NopStmt actualNopStmt = new NopStmt();

    // Assert
    assertNull(actualNopStmt.frame);
    assertNull(actualNopStmt.exceptionHandlers);
    assertNull(actualNopStmt._cfg_froms);
    assertNull(actualNopStmt.getOp());
    assertNull(actualNopStmt.getOp1());
    assertNull(actualNopStmt.getOp2());
    assertNull(actualNopStmt.getOps());
    assertNull(actualNopStmt.getNext());
    assertNull(actualNopStmt.getPre());
    assertNull(actualNopStmt._ts_default_next);
    assertNull(actualNopStmt.list);
    assertEquals(0, actualNopStmt.id);
    assertEquals(ET.E0, actualNopStmt.et);
    assertEquals(ST.NOP, actualNopStmt.st);
    assertFalse(actualNopStmt.visited);
  }

  /**
   * Test {@link NopStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link NopStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stmt NopStmt.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper() {
    // Arrange
    NopStmt nNopResult = Stmts.nNop();

    // Act
    Stmt actualCloneResult = nNopResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof NopStmt);
    assertNull(((NopStmt) actualCloneResult).frame);
    assertNull(((NopStmt) actualCloneResult).exceptionHandlers);
    assertNull(((NopStmt) actualCloneResult)._cfg_froms);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getOps());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((NopStmt) actualCloneResult)._ts_default_next);
    assertNull(((NopStmt) actualCloneResult).list);
    assertEquals(0, ((NopStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((NopStmt) actualCloneResult).et);
    assertEquals(ST.NOP, ((NopStmt) actualCloneResult).st);
    assertFalse(((NopStmt) actualCloneResult).visited);
  }

  /**
   * Test {@link NopStmt#toString()}.
   *
   * <p>Method under test: {@link NopStmt#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NopStmt.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("NOP", new NopStmt().toString());
  }
}
