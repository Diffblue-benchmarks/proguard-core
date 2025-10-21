package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.stmt.Stmt.ST;

public class GotoStmtDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "LabelStmt GotoStmt.getTarget()",
    "void GotoStmt.setTarget(LabelStmt)",
    "java.lang.String GotoStmt.toString()"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GotoStmt.<init>(LabelStmt)"})
  public void testNewGotoStmt() {
    // Arrange
    LabelStmt target = Stmts.nLabel();

    // Act
    GotoStmt actualGotoStmt = new GotoStmt(target);

    // Assert
    assertNull(actualGotoStmt.getOps());
    assertNull(actualGotoStmt.frame);
    assertNull(actualGotoStmt.exceptionHandlers);
    assertNull(actualGotoStmt._cfg_froms);
    assertNull(actualGotoStmt.getOp());
    assertNull(actualGotoStmt.getOp1());
    assertNull(actualGotoStmt.getOp2());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt GotoStmt.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_whenLabelAndLocalMapper_thenReturnGotoStmt() {
    // Arrange
    GotoStmt nGotoResult = Stmts.nGoto(Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nGotoResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof GotoStmt);
    assertNull(actualCloneResult.getOps());
    assertNull(((GotoStmt) actualCloneResult).frame);
    assertNull(((GotoStmt) actualCloneResult).exceptionHandlers);
    assertNull(((GotoStmt) actualCloneResult)._cfg_froms);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
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
