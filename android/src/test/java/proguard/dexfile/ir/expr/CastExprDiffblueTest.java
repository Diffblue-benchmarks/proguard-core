package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class CastExprDiffblueTest {
  /**
   * Method under test: {@link CastExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    CastExpr nCastResult = Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act
    nCastResult.releaseMemory();

    // Assert
    assertEquals("(()null)", nCastResult.toString0());
    assertNull(nCastResult.from);
    assertNull(nCastResult.to);
    assertNull(nCastResult.getOp());
  }

  /**
   * Method under test: {@link CastExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant obj = Exprs.nNull();
    CastExpr nCastResult = Exprs.nCast(obj, "jane.doe@example.org", "alice.liddell@example.org");

    // Act
    Value actualCloneResult = nCastResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof CastExpr);
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertEquals("alice.liddell@example.org", ((CastExpr) actualCloneResult).to);
    assertEquals("jane.doe@example.org", ((CastExpr) actualCloneResult).from);
    assertNull(actualCloneResult.getOps());
    assertNull(op.getOps());
    assertNull(((CastExpr) actualCloneResult).tag);
    assertNull(((Constant) op).tag);
    assertNull(((CastExpr) actualCloneResult).valueType);
    assertNull(((Constant) op).valueType);
    assertNull(op.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(op.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(op.getOp2());
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(ET.E1, ((CastExpr) actualCloneResult).et);
    assertEquals(Value.VT.CAST, ((CastExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) op).vt);
    assertSame(obj.value, ((Constant) op).value);
  }

  /**
   * Method under test: {@link CastExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange
    CastExpr nCastResult = Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");
    nCastResult.to = null;

    // Act and Assert
    assertEquals("(()null[null])", nCastResult.toString0());
  }

  /**
   * Method under test: {@link CastExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    CastExpr nCastResult = Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");
    nCastResult.to = "";

    // Act and Assert
    assertEquals("(()null[null])", nCastResult.toString0());
  }

  /**
   * Method under test: {@link CastExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange, Act and Assert
    assertEquals("((double)null[null])", Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "D").toString0());
  }

  /**
   * Method under test: {@link CastExpr#toString0()}
   */
  @Test
  public void testToString04() {
    // Arrange, Act and Assert
    assertEquals("((float)null[null])", Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "F").toString0());
  }

  /**
   * Method under test: {@link CastExpr#toString0()}
   */
  @Test
  public void testToString05() {
    // Arrange, Act and Assert
    assertEquals("((int)null[null])", Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "I").toString0());
  }

  /**
   * Method under test: {@link CastExpr#toString0()}
   */
  @Test
  public void testToString06() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();
    obj.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("((double)null[null][null])", Exprs.nCast(obj, "jane.doe@example.org", "D").toString0());
  }

  /**
   * Method under test: {@link CastExpr#toString0()}
   */
  @Test
  public void testToString07() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals("((double)null[null][null[null]])",
        Exprs.nCast(Exprs.nArray(base, new ArrayExpr(), "(("), "jane.doe@example.org", "D").toString0());
  }

  /**
   * Method under test: {@link CastExpr#toString0()}
   */
  @Test
  public void testToString08() {
    // Arrange, Act and Assert
    assertEquals("((double)null)", Exprs.nCast(null, "jane.doe@example.org", "D").toString0());
  }

  /**
   * Method under test: {@link CastExpr#toString0()}
   */
  @Test
  public void testToString09() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();
    obj.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("(([])null[null][null])", Exprs.nCast(obj, "jane.doe@example.org", "[").toString0());
  }

  /**
   * Method under test: {@link CastExpr#CastExpr(Value, String, String)}
   */
  @Test
  public void testNewCastExpr() {
    // Arrange
    ArrayExpr value = new ArrayExpr();

    // Act
    CastExpr actualCastExpr = new CastExpr(value, "jane.doe@example.org", "alice.liddell@example.org");

    // Assert
    assertEquals("alice.liddell@example.org", actualCastExpr.to);
    assertEquals("jane.doe@example.org", actualCastExpr.from);
    assertNull(actualCastExpr.getOps());
    assertNull(actualCastExpr.tag);
    assertNull(actualCastExpr.valueType);
    assertNull(actualCastExpr.getOp1());
    assertNull(actualCastExpr.getOp2());
    assertEquals(ET.E1, actualCastExpr.et);
    assertEquals(Value.VT.CAST, actualCastExpr.vt);
    assertSame(value, actualCastExpr.getOp());
  }
}
