package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.VT;

public class CastExprDiffblueTest {
  /**
   * Test {@link CastExpr#CastExpr(Value, String, String)}.
   *
   * <p>Method under test: {@link CastExpr#CastExpr(Value, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CastExpr.<init>(Value, String, String)"})
  public void testNewCastExpr() {
    // Arrange
    ArrayExpr value = new ArrayExpr();

    // Act
    CastExpr actualCastExpr =
        new CastExpr(value, "jane.doe@example.org", "alice.liddell@example.org");

    // Assert
    Value op = actualCastExpr.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("alice.liddell@example.org", actualCastExpr.to);
    assertEquals("jane.doe@example.org", actualCastExpr.from);
    assertNull(actualCastExpr.getOps());
    assertNull(actualCastExpr.tag);
    assertNull(actualCastExpr.valueType);
    assertNull(actualCastExpr.getOp1());
    assertNull(actualCastExpr.getOp2());
    assertEquals(ET.E1, actualCastExpr.et);
    assertEquals(VT.CAST, actualCastExpr.vt);
    assertSame(value, op);
  }

  /**
   * Test {@link CastExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link CastExpr#releaseMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CastExpr.releaseMemory()"})
  public void testReleaseMemory() {
    // Arrange
    CastExpr nCastResult =
        Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act
    nCastResult.releaseMemory();

    // Assert
    assertEquals("(()null)", nCastResult.toString0());
    assertNull(nCastResult.from);
    assertNull(nCastResult.to);
    assertNull(nCastResult.getOp());
  }

  /**
   * Test {@link CastExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value CastExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenReturnCastExpr() {
    // Arrange
    CastExpr nCastResult =
        Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act
    Value actualCloneResult = nCastResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof CastExpr);
    assertTrue(actualCloneResult.getOp() instanceof Constant);
    assertEquals("alice.liddell@example.org", ((CastExpr) actualCloneResult).to);
    assertEquals("jane.doe@example.org", ((CastExpr) actualCloneResult).from);
    assertNull(actualCloneResult.getOps());
    assertNull(((CastExpr) actualCloneResult).tag);
    assertNull(((CastExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(ET.E1, ((CastExpr) actualCloneResult).et);
    assertEquals(VT.CAST, ((CastExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CastExpr.toString0()"})
  public void testToString0() {
    // Arrange
    CastExpr nCastResult =
        Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");
    nCastResult.to = null;

    // Act and Assert
    assertEquals("(()null[null])", nCastResult.toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code ((double)null[null][null])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CastExpr.toString0()"})
  public void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnDoubleNullNullNull() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();
    obj.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals(
        "((double)null[null][null])", Exprs.nCast(obj, "jane.doe@example.org", "D").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((double)null)}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CastExpr.toString0()"})
  public void testToString0_thenReturnDoubleNull() {
    // Arrange, Act and Assert
    assertEquals("((double)null)", Exprs.nCast(null, "jane.doe@example.org", "D").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((double)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CastExpr.toString0()"})
  public void testToString0_thenReturnDoubleNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "((double)null[null])",
        Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "D").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((double)null[null][null[null]])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CastExpr.toString0()"})
  public void testToString0_thenReturnDoubleNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "((double)null[null][null[null]])",
        Exprs.nCast(Exprs.nArray(base, new ArrayExpr(), "(("), "jane.doe@example.org", "D")
            .toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((float)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CastExpr.toString0()"})
  public void testToString0_thenReturnFloatNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "((float)null[null])",
        Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "F").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((int)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CastExpr.toString0()"})
  public void testToString0_thenReturnIntNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "((int)null[null])", Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "I").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code (([])null[null][null])}.
   * </ul>
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CastExpr.toString0()"})
  public void testToString0_thenReturnNullNullNull() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();
    obj.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals(
        "(([])null[null][null])", Exprs.nCast(obj, "jane.doe@example.org", "[").toString0());
  }

  /**
   * Test {@link CastExpr#toString0()}.
   *
   * <p>Method under test: {@link CastExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CastExpr.toString0()"})
  public void testToString02() {
    // Arrange
    CastExpr nCastResult =
        Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");
    nCastResult.to = "";

    // Act and Assert
    assertEquals("(()null[null])", nCastResult.toString0());
  }
}
