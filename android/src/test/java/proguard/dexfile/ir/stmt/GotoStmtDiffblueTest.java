package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class GotoStmtDiffblueTest {
  /**
   * Method under test: {@link GotoStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    GotoStmt nGotoResult = Stmts.nGoto(Stmts.nLabel());

    // Act
    Stmt actualCloneResult = nGotoResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof GotoStmt);
    assertNull(actualCloneResult.getOps());
    LabelStmt target = ((GotoStmt) actualCloneResult).getTarget();
    assertNull(target.getOps());
    assertNull(target.tag);
    assertNull(target.frame);
    assertNull(((GotoStmt) actualCloneResult).frame);
    assertNull(target.displayName);
    assertNull(target.phis);
    assertNull(target.exceptionHandlers);
    assertNull(((GotoStmt) actualCloneResult).exceptionHandlers);
    assertNull(target._cfg_froms);
    assertNull(((GotoStmt) actualCloneResult)._cfg_froms);
    assertNull(actualCloneResult.getOp());
    assertNull(target.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(target.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(target.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(target.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(target.getPre());
    assertNull(target._ts_default_next);
    assertNull(((GotoStmt) actualCloneResult)._ts_default_next);
    assertNull(target.list);
    assertNull(((GotoStmt) actualCloneResult).list);
    assertEquals(-1, target.lineNumber);
    assertEquals(0, target.id);
    assertEquals(0, ((GotoStmt) actualCloneResult).id);
    assertEquals(ET.E0, target.et);
    assertEquals(ET.E0, ((GotoStmt) actualCloneResult).et);
    assertEquals(Stmt.ST.GOTO, ((GotoStmt) actualCloneResult).st);
    assertEquals(Stmt.ST.LABEL, target.st);
    assertFalse(target.visited);
    assertFalse(((GotoStmt) actualCloneResult).visited);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GotoStmt#setTarget(LabelStmt)}
   *   <li>{@link GotoStmt#toString()}
   *   <li>{@link GotoStmt#getTarget()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    GotoStmt gotoStmt = new GotoStmt(Stmts.nLabel());
    LabelStmt target = Stmts.nLabel();

    // Act
    gotoStmt.setTarget(target);
    gotoStmt.toString();

    // Assert that nothing has changed
    assertSame(target, gotoStmt.getTarget());
  }

  /**
   * Method under test: {@link GotoStmt#GotoStmt(LabelStmt)}
   */
  @Test
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
    assertEquals(Stmt.ST.GOTO, actualGotoStmt.st);
    assertFalse(actualGotoStmt.visited);
    assertSame(target, actualGotoStmt.getTarget());
  }
}
