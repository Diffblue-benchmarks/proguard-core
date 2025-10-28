package proguard.dexfile.ir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.stmt.StmtList;

public class IrMethodDiffblueTest {
  /**
   * Method under test: {@link IrMethod#clone()}
   */
  @Test
  public void testClone() {
    // Arrange and Act
    IrMethod actualCloneResult = (new IrMethod()).clone();

    // Assert
    assertNull(actualCloneResult.args);
    assertNull(actualCloneResult.name);
    assertNull(actualCloneResult.owner);
    assertNull(actualCloneResult.ret);
    assertNull(actualCloneResult.phiLabels);
    StmtList stmtList = actualCloneResult.stmts;
    assertNull(stmtList.getFirst());
    assertNull(stmtList.getLast());
    assertEquals(0, stmtList.getSize());
    assertFalse(stmtList.iterator().hasNext());
    assertFalse(actualCloneResult.isStatic);
    assertTrue(actualCloneResult.locals.isEmpty());
    assertTrue(actualCloneResult.traps.isEmpty());
    assertTrue(actualCloneResult.vars.isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of {@link IrMethod}
   */
  @Test
  public void testNewIrMethod() {
    // Arrange and Act
    IrMethod actualIrMethod = new IrMethod();

    // Assert
    assertNull(actualIrMethod.args);
    assertNull(actualIrMethod.name);
    assertNull(actualIrMethod.owner);
    assertNull(actualIrMethod.ret);
    assertNull(actualIrMethod.phiLabels);
    StmtList stmtList = actualIrMethod.stmts;
    assertNull(stmtList.getFirst());
    assertNull(stmtList.getLast());
    assertEquals(0, stmtList.getSize());
    assertFalse(stmtList.iterator().hasNext());
    assertFalse(actualIrMethod.isStatic);
    assertTrue(actualIrMethod.locals.isEmpty());
    assertTrue(actualIrMethod.traps.isEmpty());
    assertTrue(actualIrMethod.vars.isEmpty());
  }
}
