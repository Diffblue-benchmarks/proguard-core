package proguard.dexfile.ir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmts;

public class LabelAndLocalMapperDiffblueTest {
  /**
   * Method under test: {@link LabelAndLocalMapper#map(Local)}
   */
  @Test
  public void testMap() {
    // Arrange
    LabelAndLocalMapper labelAndLocalMapper = new LabelAndLocalMapper();

    // Act
    Local actualMapResult = labelAndLocalMapper.map(new Local());

    // Assert
    assertEquals("a0", actualMapResult.toString0());
    assertNull(actualMapResult.getOps());
    assertNull(actualMapResult.tag);
    assertNull(actualMapResult.debugName);
    assertNull(actualMapResult.signature);
    assertNull(actualMapResult.valueType);
    assertNull(actualMapResult.getOp());
    assertNull(actualMapResult.getOp1());
    assertNull(actualMapResult.getOp2());
    assertEquals(0, actualMapResult._ls_index);
    assertEquals(1, labelAndLocalMapper.locals.size());
    assertEquals(ET.E0, actualMapResult.et);
    assertEquals(Value.VT.LOCAL, actualMapResult.vt);
  }

  /**
   * Method under test: {@link LabelAndLocalMapper#map(LabelStmt)}
   */
  @Test
  public void testMap2() {
    // Arrange
    LabelAndLocalMapper labelAndLocalMapper = new LabelAndLocalMapper();

    // Act
    LabelStmt actualMapResult = labelAndLocalMapper.map(Stmts.nLabel());

    // Assert
    assertNull(actualMapResult.getOps());
    assertNull(actualMapResult.tag);
    assertNull(actualMapResult.frame);
    assertNull(actualMapResult.displayName);
    assertNull(actualMapResult.phis);
    assertNull(actualMapResult.exceptionHandlers);
    assertNull(actualMapResult._cfg_froms);
    assertNull(actualMapResult.getOp());
    assertNull(actualMapResult.getOp1());
    assertNull(actualMapResult.getOp2());
    assertNull(actualMapResult.getNext());
    assertNull(actualMapResult.getPre());
    assertNull(actualMapResult._ts_default_next);
    assertEquals(-1, actualMapResult.lineNumber);
    assertEquals(0, actualMapResult.id);
    assertEquals(1, labelAndLocalMapper.labels.size());
    assertEquals(ET.E0, actualMapResult.et);
    assertEquals(Stmt.ST.LABEL, actualMapResult.st);
    assertFalse(actualMapResult.visited);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link LabelAndLocalMapper}
   */
  @Test
  public void testNewLabelAndLocalMapper() {
    // Arrange and Act
    LabelAndLocalMapper actualLabelAndLocalMapper = new LabelAndLocalMapper();

    // Assert
    assertTrue(actualLabelAndLocalMapper.labels.isEmpty());
    assertTrue(actualLabelAndLocalMapper.locals.isEmpty());
  }
}
