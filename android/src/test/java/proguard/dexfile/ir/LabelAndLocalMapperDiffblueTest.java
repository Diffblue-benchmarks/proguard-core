package proguard.dexfile.ir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.ir.stmt.Stmts;

class LabelAndLocalMapperDiffblueTest {
  /**
   * Test {@link LabelAndLocalMapper#map(LabelStmt)} with {@code label}.
   *
   * <p>Method under test: {@link LabelAndLocalMapper#map(LabelStmt)}
   */
  @Test
  @DisplayName("Test map(LabelStmt) with 'label'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.LabelStmt proguard.dexfile.ir.LabelAndLocalMapper.map(proguard.dexfile.ir.stmt.LabelStmt)"
  })
  void testMapWithLabel() {
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
    assertEquals(ST.LABEL, actualMapResult.st);
    assertFalse(actualMapResult.visited);
  }

  /**
   * Test {@link LabelAndLocalMapper#map(Local)} with {@code local}.
   *
   * <ul>
   *   <li>When {@link Local#Local()}.
   *   <li>Then return toString0 is {@code a0}.
   * </ul>
   *
   * <p>Method under test: {@link LabelAndLocalMapper#map(Local)}
   */
  @Test
  @DisplayName("Test map(Local) with 'local'; when Local(); then return toString0 is 'a0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Local proguard.dexfile.ir.LabelAndLocalMapper.map(proguard.dexfile.ir.expr.Local)"
  })
  void testMapWithLocal_whenLocal_thenReturnToString0IsA0() {
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
    assertEquals(VT.LOCAL, actualMapResult.vt);
  }

  /**
   * Test new {@link LabelAndLocalMapper} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link LabelAndLocalMapper}
   */
  @Test
  @DisplayName("Test new LabelAndLocalMapper (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.LabelAndLocalMapper.<init>()"})
  void testNewLabelAndLocalMapper() {
    // Arrange and Act
    LabelAndLocalMapper actualLabelAndLocalMapper = new LabelAndLocalMapper();

    // Assert
    assertTrue(actualLabelAndLocalMapper.labels.isEmpty());
    assertTrue(actualLabelAndLocalMapper.locals.isEmpty());
  }
}
