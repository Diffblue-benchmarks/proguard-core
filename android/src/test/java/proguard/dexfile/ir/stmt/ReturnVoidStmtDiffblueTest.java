package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class ReturnVoidStmtDiffblueTest {
  /**
   * Method under test: {@link ReturnVoidStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    ReturnVoidStmt nReturnVoidResult = Stmts.nReturnVoid();

    // Act
    Stmt actualCloneResult = nReturnVoidResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof ReturnVoidStmt);
    assertNull(actualCloneResult.getOps());
    assertNull(((ReturnVoidStmt) actualCloneResult).frame);
    assertNull(((ReturnVoidStmt) actualCloneResult).exceptionHandlers);
    assertNull(((ReturnVoidStmt) actualCloneResult)._cfg_froms);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((ReturnVoidStmt) actualCloneResult)._ts_default_next);
    assertNull(((ReturnVoidStmt) actualCloneResult).list);
    assertEquals(0, ((ReturnVoidStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((ReturnVoidStmt) actualCloneResult).et);
    assertEquals(Stmt.ST.RETURN_VOID, ((ReturnVoidStmt) actualCloneResult).st);
    assertFalse(((ReturnVoidStmt) actualCloneResult).visited);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ReturnVoidStmt}
   */
  @Test
  public void testNewReturnVoidStmt() {
    // Arrange and Act
    ReturnVoidStmt actualReturnVoidStmt = new ReturnVoidStmt();

    // Assert
    assertNull(actualReturnVoidStmt.getOps());
    assertNull(actualReturnVoidStmt.frame);
    assertNull(actualReturnVoidStmt.exceptionHandlers);
    assertNull(actualReturnVoidStmt._cfg_froms);
    assertNull(actualReturnVoidStmt.getOp());
    assertNull(actualReturnVoidStmt.getOp1());
    assertNull(actualReturnVoidStmt.getOp2());
    assertNull(actualReturnVoidStmt.getNext());
    assertNull(actualReturnVoidStmt.getPre());
    assertNull(actualReturnVoidStmt._ts_default_next);
    assertNull(actualReturnVoidStmt.list);
    assertEquals(0, actualReturnVoidStmt.id);
    assertEquals(ET.E0, actualReturnVoidStmt.et);
    assertEquals(Stmt.ST.RETURN_VOID, actualReturnVoidStmt.st);
    assertFalse(actualReturnVoidStmt.visited);
  }

  /**
   * Method under test: {@link ReturnVoidStmt#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("return", (new ReturnVoidStmt()).toString());
  }
}
