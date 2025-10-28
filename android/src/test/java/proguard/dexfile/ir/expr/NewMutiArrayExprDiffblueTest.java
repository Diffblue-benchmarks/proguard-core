package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;

public class NewMutiArrayExprDiffblueTest {
  /**
   * Method under test: {@link NewMutiArrayExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    NewMutiArrayExpr nNewMutiArrayResult = Exprs.nNewMutiArray("Base", 1, new Value[]{new ArrayExpr()});

    // Act
    nNewMutiArrayResult.releaseMemory();

    // Assert
    assertNull(nNewMutiArrayResult.getOps());
    assertNull(nNewMutiArrayResult.baseType);
  }

  /**
   * Method under test: {@link NewMutiArrayExpr#clone()}
   */
  @Test
  public void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nNewMutiArray("Base", 1, new Value[]{}).clone();

    // Assert
    assertTrue(actualCloneResult instanceof NewMutiArrayExpr);
    assertEquals("Base", ((NewMutiArrayExpr) actualCloneResult).baseType);
    assertEquals("new byte[]", actualCloneResult.toString0());
    assertNull(((NewMutiArrayExpr) actualCloneResult).tag);
    assertNull(((NewMutiArrayExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(0, actualCloneResult.getOps().length);
    assertEquals(1, ((NewMutiArrayExpr) actualCloneResult).dimension);
    assertEquals(ET.En, ((NewMutiArrayExpr) actualCloneResult).et);
    assertEquals(Value.VT.NEW_MULTI_ARRAY, ((NewMutiArrayExpr) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link NewMutiArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    NewMutiArrayExpr nNewMutiArrayResult = Exprs.nNewMutiArray("Base", 1, new Value[]{nNullResult});

    // Act
    Value actualCloneResult = nNewMutiArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof NewMutiArrayExpr);
    assertEquals("Base", ((NewMutiArrayExpr) actualCloneResult).baseType);
    assertEquals("new byte[null]", actualCloneResult.toString0());
    assertNull(value.getOps());
    assertNull(((Constant) value).tag);
    assertNull(((NewMutiArrayExpr) actualCloneResult).tag);
    assertNull(((Constant) value).valueType);
    assertNull(((NewMutiArrayExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops.length);
    assertEquals(1, ((NewMutiArrayExpr) actualCloneResult).dimension);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.En, ((NewMutiArrayExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.NEW_MULTI_ARRAY, ((NewMutiArrayExpr) actualCloneResult).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Method under test: {@link NewMutiArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone3() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    NewMutiArrayExpr nNewMutiArrayResult = Exprs.nNewMutiArray("Base", 1,
        new Value[]{Exprs.nFilledArray("Element Type", new Value[]{nNullResult})});

    // Act
    Value actualCloneResult = nNewMutiArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof NewMutiArrayExpr);
    assertEquals("Base", ((NewMutiArrayExpr) actualCloneResult).baseType);
    assertEquals("Element Type", ((FilledArrayExpr) value).type);
    assertNull(value2.getOps());
    assertNull(((Constant) value2).tag);
    assertNull(((FilledArrayExpr) value).tag);
    assertNull(((NewMutiArrayExpr) actualCloneResult).tag);
    assertNull(((Constant) value2).valueType);
    assertNull(((FilledArrayExpr) value).valueType);
    assertNull(((NewMutiArrayExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(value2.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(value2.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertNull(value2.getOp2());
    assertEquals(1, ops.length);
    assertEquals(1, ops2.length);
    assertEquals(1, ((NewMutiArrayExpr) actualCloneResult).dimension);
    assertEquals(ET.E0, ((Constant) value2).et);
    assertEquals(ET.En, ((FilledArrayExpr) value).et);
    assertEquals(ET.En, ((NewMutiArrayExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.FILLED_ARRAY, ((FilledArrayExpr) value).vt);
    assertEquals(Value.VT.NEW_MULTI_ARRAY, ((NewMutiArrayExpr) actualCloneResult).vt);
    assertSame(nNullResult.value, ((Constant) value2).value);
  }

  /**
   * Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange, Act and Assert
    assertEquals("new byte[null[null]]", Exprs.nNewMutiArray("Base", 1, new Value[]{new ArrayExpr()}).toString0());
    assertEquals("new [][null[null]]", Exprs.nNewMutiArray("[", 1, new Value[]{new ArrayExpr()}).toString0());
    assertEquals("new double[null[null]]", Exprs.nNewMutiArray("D", 1, new Value[]{new ArrayExpr()}).toString0());
    assertEquals("new float[null[null]]", Exprs.nNewMutiArray("F", 1, new Value[]{new ArrayExpr()}).toString0());
    assertEquals(
        "new byte[null[null]][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"
            + "[][][][][][][][][][][][][][][][][][][][][][][][][]",
        Exprs.nNewMutiArray("Base", 66, new Value[]{new ArrayExpr()}).toString0());
    assertEquals("new byte[null]", Exprs.nNewMutiArray("Base", 1, new Value[]{null}).toString0());
    assertEquals("new int[null[null]]", Exprs.nNewMutiArray("I", 1, new Value[]{new ArrayExpr()}).toString0());
  }

  /**
   * Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    NewMutiArrayExpr nNewMutiArrayResult = Exprs.nNewMutiArray("Base", 1, new Value[]{new ArrayExpr()});
    nNewMutiArrayResult.baseType = null;

    // Act and Assert
    assertEquals("new [null[null]]", nNewMutiArrayResult.toString0());
  }

  /**
   * Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange
    NewMutiArrayExpr nNewMutiArrayResult = Exprs.nNewMutiArray("Base", 1, new Value[]{new ArrayExpr()});
    nNewMutiArrayResult.baseType = "";

    // Act and Assert
    assertEquals("new [null[null]]", nNewMutiArrayResult.toString0());
  }

  /**
   * Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  public void testToString04() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("new byte[null[null][null]]", Exprs.nNewMutiArray("Base", 1, new Value[]{arrayExpr}).toString0());
  }

  /**
   * Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  public void testToString05() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals("new byte[null[null][null[null]]]",
        Exprs.nNewMutiArray("Base", 1, new Value[]{Exprs.nArray(base, new ArrayExpr(), "new ")}).toString0());
  }

  /**
   * Method under test:
   * {@link NewMutiArrayExpr#NewMutiArrayExpr(String, int, Value[])}
   */
  @Test
  public void testNewNewMutiArrayExpr() {
    // Arrange
    Value[] sizes = new Value[]{new ArrayExpr()};

    // Act
    NewMutiArrayExpr actualNewMutiArrayExpr = new NewMutiArrayExpr("Base", 1, sizes);

    // Assert
    assertEquals("Base", actualNewMutiArrayExpr.baseType);
    assertEquals("new byte[null[null]]", actualNewMutiArrayExpr.toString0());
    assertNull(actualNewMutiArrayExpr.tag);
    assertNull(actualNewMutiArrayExpr.valueType);
    assertNull(actualNewMutiArrayExpr.getOp());
    assertNull(actualNewMutiArrayExpr.getOp1());
    assertNull(actualNewMutiArrayExpr.getOp2());
    assertEquals(1, actualNewMutiArrayExpr.dimension);
    assertEquals(ET.En, actualNewMutiArrayExpr.et);
    assertEquals(Value.VT.NEW_MULTI_ARRAY, actualNewMutiArrayExpr.vt);
    assertSame(sizes, actualNewMutiArrayExpr.getOps());
  }
}
