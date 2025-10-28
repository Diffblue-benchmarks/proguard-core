package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class LabelStmtDiffblueTest {
  /**
   * Method under test: {@link LabelStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
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
    assertEquals(Stmt.ST.LABEL, actualCloneResult.st);
    assertFalse(actualCloneResult.visited);
  }

  /**
   * Method under test: default or parameterless constructor of {@link LabelStmt}
   */
  @Test
  public void testNewLabelStmt() {
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
    assertEquals(Stmt.ST.LABEL, actualLabelStmt.st);
    assertFalse(actualLabelStmt.visited);
  }
}
