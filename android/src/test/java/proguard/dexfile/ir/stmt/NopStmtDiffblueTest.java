package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class NopStmtDiffblueTest {
  /**
   * Method under test: {@link NopStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    NopStmt nNopResult = Stmts.nNop();

    // Act
    Stmt actualCloneResult = nNopResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof NopStmt);
    assertNull(actualCloneResult.getOps());
    assertNull(((NopStmt) actualCloneResult).frame);
    assertNull(((NopStmt) actualCloneResult).exceptionHandlers);
    assertNull(((NopStmt) actualCloneResult)._cfg_froms);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((NopStmt) actualCloneResult)._ts_default_next);
    assertNull(((NopStmt) actualCloneResult).list);
    assertEquals(0, ((NopStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((NopStmt) actualCloneResult).et);
    assertEquals(Stmt.ST.NOP, ((NopStmt) actualCloneResult).st);
    assertFalse(((NopStmt) actualCloneResult).visited);
  }

  /**
   * Method under test: default or parameterless constructor of {@link NopStmt}
   */
  @Test
  public void testNewNopStmt() {
    // Arrange and Act
    NopStmt actualNopStmt = new NopStmt();

    // Assert
    assertNull(actualNopStmt.getOps());
    assertNull(actualNopStmt.frame);
    assertNull(actualNopStmt.exceptionHandlers);
    assertNull(actualNopStmt._cfg_froms);
    assertNull(actualNopStmt.getOp());
    assertNull(actualNopStmt.getOp1());
    assertNull(actualNopStmt.getOp2());
    assertNull(actualNopStmt.getNext());
    assertNull(actualNopStmt.getPre());
    assertNull(actualNopStmt._ts_default_next);
    assertNull(actualNopStmt.list);
    assertEquals(0, actualNopStmt.id);
    assertEquals(ET.E0, actualNopStmt.et);
    assertEquals(Stmt.ST.NOP, actualNopStmt.st);
    assertFalse(actualNopStmt.visited);
  }

  /**
   * Method under test: {@link NopStmt#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("NOP", (new NopStmt()).toString());
  }
}
