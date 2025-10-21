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

public class TypeExprDiffblueTest {
  /**
   * Test {@link TypeExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link TypeExpr#releaseMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TypeExpr.releaseMemory()"})
  public void testReleaseMemory() {
    // Arrange
    TypeExpr nCheckCastResult = Exprs.nCheckCast(new ArrayExpr(), "Type");

    // Act
    nCheckCastResult.releaseMemory();

    // Assert
    assertNull(nCheckCastResult.type);
    assertNull(nCheckCastResult.getOp());
  }

  /**
   * Test {@link TypeExpr#TypeExpr(VT, Value, String)}.
   *
   * <p>Method under test: {@link TypeExpr#TypeExpr(VT, Value, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TypeExpr.<init>(VT, Value, String)"})
  public void testNewTypeExpr() {
    // Arrange
    ArrayExpr value = new ArrayExpr();

    // Act
    TypeExpr actualTypeExpr =
        new TypeExpr(VT.ADD, value, "The characteristics of someone or something");

    // Assert
    Value op = actualTypeExpr.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("The characteristics of someone or something", actualTypeExpr.type);
    assertNull(actualTypeExpr.getOps());
    assertNull(actualTypeExpr.tag);
    assertNull(actualTypeExpr.valueType);
    assertNull(actualTypeExpr.getOp1());
    assertNull(actualTypeExpr.getOp2());
    assertEquals(ET.E1, actualTypeExpr.et);
    assertEquals(VT.ADD, actualTypeExpr.vt);
    assertSame(value, op);
  }

  /**
   * Test {@link TypeExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TypeExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenFirstElementReturnConstant() {
    // Arrange
    TypeExpr nCheckCastResult =
        Exprs.nCheckCast(Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()}), "Type");

    // Act
    Value actualCloneResult = nCheckCastResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    Value[] ops = op.getOps();
    assertTrue(ops[0] instanceof Constant);
    assertTrue(op instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof TypeExpr);
    assertEquals("Element Type", ((FilledArrayExpr) op).type);
    assertEquals(1, ops.length);
    assertEquals(ET.En, ((FilledArrayExpr) op).et);
    assertEquals(VT.FILLED_ARRAY, ((FilledArrayExpr) op).vt);
  }

  /**
   * Test {@link TypeExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TypeExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenOpReturnCastExpr() {
    // Arrange
    TypeExpr nCheckCastResult =
        Exprs.nCheckCast(
            Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org"),
            "Type");

    // Act
    Value actualCloneResult = nCheckCastResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof CastExpr);
    assertTrue(op.getOp() instanceof Constant);
    assertTrue(actualCloneResult instanceof TypeExpr);
    assertEquals("alice.liddell@example.org", ((CastExpr) op).to);
    assertEquals("jane.doe@example.org", ((CastExpr) op).from);
    assertEquals(ET.E1, ((CastExpr) op).et);
    assertEquals(VT.CAST, ((CastExpr) op).vt);
  }

  /**
   * Test {@link TypeExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then Op return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TypeExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenOpReturnConstant() {
    // Arrange
    Constant obj = Exprs.nNull();
    TypeExpr nCheckCastResult = Exprs.nCheckCast(obj, "Type");

    // Act
    Value actualCloneResult = nCheckCastResult.clone(new LabelAndLocalMapper());

    // Assert
    Value op = actualCloneResult.getOp();
    assertTrue(op instanceof Constant);
    assertTrue(actualCloneResult instanceof TypeExpr);
    assertEquals(ET.E0, ((Constant) op).et);
    assertEquals(VT.CONSTANT, ((Constant) op).vt);
    assertSame(obj.value, ((Constant) op).value);
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code ((double)null[null][null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeExpr.toString0()"})
  public void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnDoubleNullNullNull() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();
    obj.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("((double)null[null][null])", Exprs.nCheckCast(obj, "D").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@link ArrayExpr#ArrayExpr()} and {@code D}.
   *   <li>Then return {@code ((double)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeExpr.toString0()"})
  public void testToString0_givenNCheckCastArrayExprAndD_thenReturnDoubleNullNull() {
    // Arrange, Act and Assert
    assertEquals("((double)null[null])", Exprs.nCheckCast(new ArrayExpr(), "D").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@link ArrayExpr#ArrayExpr()} and empty string.
   *   <li>Then return {@code (()null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeExpr.toString0()"})
  public void testToString0_givenNCheckCastArrayExprAndEmptyString_thenReturnNullNull() {
    // Arrange, Act and Assert
    assertEquals("(()null[null])", Exprs.nCheckCast(new ArrayExpr(), "").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@link ArrayExpr#ArrayExpr()} and {@code F}.
   *   <li>Then return {@code ((float)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeExpr.toString0()"})
  public void testToString0_givenNCheckCastArrayExprAndF_thenReturnFloatNullNull() {
    // Arrange, Act and Assert
    assertEquals("((float)null[null])", Exprs.nCheckCast(new ArrayExpr(), "F").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@link ArrayExpr#ArrayExpr()} and {@code I}.
   *   <li>Then return {@code ((int)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeExpr.toString0()"})
  public void testToString0_givenNCheckCastArrayExprAndI_thenReturnIntNullNull() {
    // Arrange, Act and Assert
    assertEquals("((int)null[null])", Exprs.nCheckCast(new ArrayExpr(), "I").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@link ArrayExpr#ArrayExpr()} and {@code J}.
   *   <li>Then return {@code ((long)null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeExpr.toString0()"})
  public void testToString0_givenNCheckCastArrayExprAndJ_thenReturnLongNullNull() {
    // Arrange, Act and Assert
    assertEquals("((long)null[null])", Exprs.nCheckCast(new ArrayExpr(), "J").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nCheckCast {@code null} and {@code D}.
   *   <li>Then return {@code ((double)null)}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeExpr.toString0()"})
  public void testToString0_givenNCheckCastNullAndD_thenReturnDoubleNull() {
    // Arrange, Act and Assert
    assertEquals("((double)null)", Exprs.nCheckCast(null, "D").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNewArray {@code D} and {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code new double[null[null]]}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeExpr.toString0()"})
  public void testToString0_givenNNewArrayDAndArrayExpr_thenReturnNewDoubleNullNull() {
    // Arrange, Act and Assert
    assertEquals("new double[null[null]]", Exprs.nNewArray("D", new ArrayExpr()).toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nNewArray {@code D} and {@code null}.
   *   <li>Then return {@code new double[null]}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeExpr.toString0()"})
  public void testToString0_givenNNewArrayDAndNull_thenReturnNewDoubleNull() {
    // Arrange, Act and Assert
    assertEquals("new double[null]", Exprs.nNewArray("D", null).toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((double)null[null][null[null]])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeExpr.toString0()"})
  public void testToString0_thenReturnDoubleNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "((double)null[null][null[null]])",
        Exprs.nCheckCast(Exprs.nArray(base, new ArrayExpr(), "(("), "D").toString0());
  }

  /**
   * Test {@link TypeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code (null[null] instanceof [])}.
   * </ul>
   *
   * <p>Method under test: {@link TypeExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TypeExpr.toString0()"})
  public void testToString0_thenReturnNullNullInstanceof() {
    // Arrange, Act and Assert
    assertEquals("(null[null] instanceof [])", Exprs.nInstanceOf(new ArrayExpr(), "[").toString0());
  }
}
