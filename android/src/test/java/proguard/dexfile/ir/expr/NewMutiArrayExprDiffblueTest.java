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

public class NewMutiArrayExprDiffblueTest {
  /**
   * Test {@link NewMutiArrayExpr#NewMutiArrayExpr(String, int, Value[])}.
   *
   * <p>Method under test: {@link NewMutiArrayExpr#NewMutiArrayExpr(String, int, Value[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NewMutiArrayExpr.<init>(String, int, Value[])"})
  public void testNewNewMutiArrayExpr() {
    // Arrange
    Value[] sizes = new Value[] {new ArrayExpr()};

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
    assertEquals(VT.NEW_MULTI_ARRAY, actualNewMutiArrayExpr.vt);
    assertSame(sizes, actualNewMutiArrayExpr.getOps());
  }

  /**
   * Test {@link NewMutiArrayExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link NewMutiArrayExpr#releaseMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NewMutiArrayExpr.releaseMemory()"})
  public void testReleaseMemory() {
    // Arrange
    NewMutiArrayExpr nNewMutiArrayResult =
        Exprs.nNewMutiArray("Base", 1, new Value[] {new ArrayExpr()});

    // Act
    nNewMutiArrayResult.releaseMemory();

    // Assert
    assertNull(nNewMutiArrayResult.getOps());
    assertNull(nNewMutiArrayResult.baseType);
  }

  /**
   * Test {@link NewMutiArrayExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link FilledArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value NewMutiArrayExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenFirstElementReturnFilledArrayExpr() {
    // Arrange
    NewMutiArrayExpr nNewMutiArrayResult =
        Exprs.nNewMutiArray(
            "Base",
            1,
            new Value[] {Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()})});

    // Act
    Value actualCloneResult = nNewMutiArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    assertTrue(ops2[0] instanceof Constant);
    assertTrue(value instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof NewMutiArrayExpr);
    assertEquals("Element Type", ((FilledArrayExpr) value).type);
    assertEquals(1, ops.length);
    assertEquals(1, ops2.length);
    assertEquals(ET.En, ((FilledArrayExpr) value).et);
    assertEquals(VT.FILLED_ARRAY, ((FilledArrayExpr) value).vt);
  }

  /**
   * Test {@link NewMutiArrayExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return toString0 is {@code new byte[null]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value NewMutiArrayExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenReturnToString0IsNewByteNull() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    NewMutiArrayExpr nNewMutiArrayResult =
        Exprs.nNewMutiArray("Base", 1, new Value[] {nNullResult});

    // Act
    Value actualCloneResult = nNewMutiArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof NewMutiArrayExpr);
    assertEquals("new byte[null]", actualCloneResult.toString0());
    assertNull(value.getOps());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link NewMutiArrayExpr#clone()}.
   *
   * <ul>
   *   <li>Then return {@link NewMutiArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value NewMutiArrayExpr.clone()"})
  public void testClone_thenReturnNewMutiArrayExpr() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nNewMutiArray("Base", 1, new Value[] {}).clone();

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
    assertEquals(VT.NEW_MULTI_ARRAY, ((NewMutiArrayExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  public void testToString0() {
    // Arrange
    NewMutiArrayExpr nNewMutiArrayResult =
        Exprs.nNewMutiArray("Base", 1, new Value[] {new ArrayExpr()});
    nNewMutiArrayResult.baseType = null;

    // Act and Assert
    assertEquals("new [null[null]]", nNewMutiArrayResult.toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code new byte[null[null][null]]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  public void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnNewByteNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals(
        "new byte[null[null][null]]",
        Exprs.nNewMutiArray("Base", 1, new Value[] {arrayExpr}).toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  public void testToString0_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "new byte[null[null]][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"
            + "[][][][][][][][][][][][][][][][][][][][][][][][][]",
        Exprs.nNewMutiArray("Base", 66, new Value[] {new ArrayExpr()}).toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new byte[null]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  public void testToString0_thenReturnNewByteNull() {
    // Arrange, Act and Assert
    assertEquals("new byte[null]", Exprs.nNewMutiArray("Base", 1, new Value[] {null}).toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new byte[null[null]]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  public void testToString0_thenReturnNewByteNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new byte[null[null]]",
        Exprs.nNewMutiArray("Base", 1, new Value[] {new ArrayExpr()}).toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new byte[null[null][null[null]]]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  public void testToString0_thenReturnNewByteNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "new byte[null[null][null[null]]]",
        Exprs.nNewMutiArray("Base", 1, new Value[] {Exprs.nArray(base, new ArrayExpr(), "new ")})
            .toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new double[null[null]]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  public void testToString0_thenReturnNewDoubleNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new double[null[null]]",
        Exprs.nNewMutiArray("D", 1, new Value[] {new ArrayExpr()}).toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new float[null[null]]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  public void testToString0_thenReturnNewFloatNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new float[null[null]]",
        Exprs.nNewMutiArray("F", 1, new Value[] {new ArrayExpr()}).toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new int[null[null]]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  public void testToString0_thenReturnNewIntNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new int[null[null]]",
        Exprs.nNewMutiArray("I", 1, new Value[] {new ArrayExpr()}).toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new [][null[null]]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  public void testToString0_thenReturnNewNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new [][null[null]]",
        Exprs.nNewMutiArray("[", 1, new Value[] {new ArrayExpr()}).toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  public void testToString02() {
    // Arrange
    NewMutiArrayExpr nNewMutiArrayResult =
        Exprs.nNewMutiArray("Base", 1, new Value[] {new ArrayExpr()});
    nNewMutiArrayResult.baseType = "";

    // Act and Assert
    assertEquals("new [null[null]]", nNewMutiArrayResult.toString0());
  }
}
