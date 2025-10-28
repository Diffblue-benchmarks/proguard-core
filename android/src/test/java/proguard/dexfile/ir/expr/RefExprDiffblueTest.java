package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class RefExprDiffblueTest {
  /**
   * Method under test: {@link RefExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    RefExpr nExceptionRefResult = Exprs.nExceptionRef("Type");

    // Act
    nExceptionRefResult.releaseMemory();

    // Assert
    assertNull(nExceptionRefResult.type);
  }

  /**
   * Method under test: {@link RefExpr#clone()}
   */
  @Test
  public void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nExceptionRef("Type").clone();

    // Assert
    assertTrue(actualCloneResult instanceof RefExpr);
    assertEquals("@Exception", actualCloneResult.toString0());
    assertEquals("Type", ((RefExpr) actualCloneResult).type);
    assertNull(actualCloneResult.getOps());
    assertNull(((RefExpr) actualCloneResult).tag);
    assertNull(((RefExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(-1, ((RefExpr) actualCloneResult).parameterIndex);
    assertEquals(ET.E0, ((RefExpr) actualCloneResult).et);
    assertEquals(Value.VT.EXCEPTION_REF, ((RefExpr) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link RefExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    RefExpr nExceptionRefResult = Exprs.nExceptionRef("Type");

    // Act
    Value actualCloneResult = nExceptionRefResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof RefExpr);
    assertEquals("@Exception", actualCloneResult.toString0());
    assertEquals("Type", ((RefExpr) actualCloneResult).type);
    assertNull(actualCloneResult.getOps());
    assertNull(((RefExpr) actualCloneResult).tag);
    assertNull(((RefExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(-1, ((RefExpr) actualCloneResult).parameterIndex);
    assertEquals(ET.E0, ((RefExpr) actualCloneResult).et);
    assertEquals(Value.VT.EXCEPTION_REF, ((RefExpr) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link RefExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange, Act and Assert
    assertEquals("@Exception", Exprs.nExceptionRef("Type").toString0());
    assertEquals("@this", Exprs.nThisRef("@Exception").toString0());
    assertEquals("@parameter_1", Exprs.nParameterRef("@Exception", 1).toString0());
  }

  /**
   * Method under test: {@link RefExpr#RefExpr(Value.VT, String, int)}
   */
  @Test
  public void testNewRefExpr() {
    // Arrange and Act
    RefExpr actualRefExpr = new RefExpr(Value.VT.ADD, "Ref Type", 1);

    // Assert
    assertEquals("Ref Type", actualRefExpr.type);
    assertNull(actualRefExpr.getOps());
    assertNull(actualRefExpr.tag);
    assertNull(actualRefExpr.valueType);
    assertNull(actualRefExpr.getOp());
    assertNull(actualRefExpr.getOp1());
    assertNull(actualRefExpr.getOp2());
    assertEquals(1, actualRefExpr.parameterIndex);
    assertEquals(ET.E0, actualRefExpr.et);
    assertEquals(Value.VT.ADD, actualRefExpr.vt);
  }
}
