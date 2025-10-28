package proguard.dexfile.ir;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmts;

public class TrapDiffblueTest {
  /**
   * Method under test: {@link Trap#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();
    Trap trap = new Trap(start, end, new LabelStmt[]{Stmts.nLabel()}, new String[]{"Types"});
    LabelAndLocalMapper mapper = new LabelAndLocalMapper();

    // Act
    Trap actualCloneResult = trap.clone(mapper);

    // Assert
    LabelStmt[] labelStmtArray = actualCloneResult.handlers;
    LabelStmt labelStmt = labelStmtArray[0];
    assertNull(labelStmt.getOps());
    LabelStmt labelStmt2 = actualCloneResult.end;
    assertNull(labelStmt2.getOps());
    LabelStmt labelStmt3 = actualCloneResult.start;
    assertNull(labelStmt3.getOps());
    assertNull(labelStmt.tag);
    assertNull(labelStmt2.tag);
    assertNull(labelStmt3.tag);
    assertNull(labelStmt.frame);
    assertNull(labelStmt2.frame);
    assertNull(labelStmt3.frame);
    assertNull(labelStmt.displayName);
    assertNull(labelStmt2.displayName);
    assertNull(labelStmt3.displayName);
    assertNull(labelStmt.phis);
    assertNull(labelStmt2.phis);
    assertNull(labelStmt3.phis);
    assertNull(labelStmt.exceptionHandlers);
    assertNull(labelStmt2.exceptionHandlers);
    assertNull(labelStmt3.exceptionHandlers);
    assertNull(labelStmt._cfg_froms);
    assertNull(labelStmt2._cfg_froms);
    assertNull(labelStmt3._cfg_froms);
    assertNull(labelStmt.getOp());
    assertNull(labelStmt2.getOp());
    assertNull(labelStmt3.getOp());
    assertNull(labelStmt.getOp1());
    assertNull(labelStmt2.getOp1());
    assertNull(labelStmt3.getOp1());
    assertNull(labelStmt.getOp2());
    assertNull(labelStmt2.getOp2());
    assertNull(labelStmt3.getOp2());
    assertNull(labelStmt.getNext());
    assertNull(labelStmt2.getNext());
    assertNull(labelStmt3.getNext());
    assertNull(labelStmt.getPre());
    assertNull(labelStmt2.getPre());
    assertNull(labelStmt3.getPre());
    assertNull(labelStmt._ts_default_next);
    assertNull(labelStmt2._ts_default_next);
    assertNull(labelStmt3._ts_default_next);
    assertEquals(-1, labelStmt.lineNumber);
    assertEquals(-1, labelStmt2.lineNumber);
    assertEquals(-1, labelStmt3.lineNumber);
    assertEquals(0, labelStmt.id);
    assertEquals(0, labelStmt2.id);
    assertEquals(0, labelStmt3.id);
    assertEquals(1, labelStmtArray.length);
    assertEquals(3, mapper.labels.size());
    assertEquals(ET.E0, labelStmt.et);
    assertEquals(ET.E0, labelStmt2.et);
    assertEquals(ET.E0, labelStmt3.et);
    assertEquals(Stmt.ST.LABEL, labelStmt.st);
    assertEquals(Stmt.ST.LABEL, labelStmt2.st);
    assertEquals(Stmt.ST.LABEL, labelStmt3.st);
    assertFalse(labelStmt.visited);
    assertFalse(labelStmt2.visited);
    assertFalse(labelStmt3.visited);
    assertArrayEquals(new String[]{"Types"}, actualCloneResult.types);
  }

  /**
   * Method under test: {@link Trap#Trap()}
   */
  @Test
  public void testNewTrap() {
    // Arrange and Act
    Trap actualTrap = new Trap();

    // Assert
    assertNull(actualTrap.types);
    assertNull(actualTrap.handlers);
    assertNull(actualTrap.end);
    assertNull(actualTrap.start);
  }

  /**
   * Method under test:
   * {@link Trap#Trap(LabelStmt, LabelStmt, LabelStmt[], String[])}
   */
  @Test
  public void testNewTrap2() {
    // Arrange
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();

    // Act
    Trap actualTrap = new Trap(start, end, new LabelStmt[]{Stmts.nLabel()}, new String[]{"Types"});

    // Assert
    LabelStmt labelStmt = actualTrap.end;
    assertNull(labelStmt.getOps());
    LabelStmt labelStmt2 = actualTrap.start;
    assertNull(labelStmt2.getOps());
    assertNull(labelStmt.getOp());
    assertNull(labelStmt2.getOp());
    assertNull(labelStmt.getOp1());
    assertNull(labelStmt2.getOp1());
    assertNull(labelStmt.getOp2());
    assertNull(labelStmt2.getOp2());
    assertNull(labelStmt.getNext());
    assertNull(labelStmt2.getNext());
    assertNull(labelStmt.getPre());
    assertNull(labelStmt2.getPre());
  }
}
