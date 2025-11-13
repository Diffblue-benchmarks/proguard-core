package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.VT;

class NewMutiArrayExprDiffblueTest {
  /**
   * Test {@link NewMutiArrayExpr#NewMutiArrayExpr(String, int, Value[])}.
   *
   * <p>Method under test: {@link NewMutiArrayExpr#NewMutiArrayExpr(String, int, Value[])}
   */
  @Test
  @DisplayName("Test new NewMutiArrayExpr(String, int, Value[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NewMutiArrayExpr.<init>(String, int, Value[])"})
  void testNewNewMutiArrayExpr() {
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
  @DisplayName("Test releaseMemory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NewMutiArrayExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    NewMutiArrayExpr nNewMutiArrayResult =
        Exprs.nNewMutiArray("Base", 1, new Value[] {new ArrayExpr()});

    // Act
    nNewMutiArrayResult.releaseMemory();

    // Assert
    assertNull(nNewMutiArrayResult.baseType);
    assertNull(nNewMutiArrayResult.getOps());
  }

  /**
   * Test {@link NewMutiArrayExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return CastExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value NewMutiArrayExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnCastExpr() {
    // Arrange
    CastExpr nCastResult =
        Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org");
    NewMutiArrayExpr nNewMutiArrayResult =
        Exprs.nNewMutiArray("Base", 1, new Value[] {nCastResult});

    // Act
    Value actualCloneResult = nNewMutiArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof CastExpr);
    assertTrue(value.getOp() instanceof Constant);
    assertTrue(actualCloneResult instanceof NewMutiArrayExpr);
    assertEquals("alice.liddell@example.org", ((CastExpr) value).to);
    assertEquals("jane.doe@example.org", ((CastExpr) value).from);
    assertEquals(1, ops.length);
    assertEquals(ET.E1, ((CastExpr) value).et);
    assertEquals(VT.CAST, ((CastExpr) value).vt);
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
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return FilledArrayExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value NewMutiArrayExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnFilledArrayExpr() {
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
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return toString0 is 'new byte[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value NewMutiArrayExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenReturnToString0IsNewByteNull() {
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
  @DisplayName("Test clone(); then return NewMutiArrayExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value NewMutiArrayExpr.clone()"})
  void testClone_thenReturnNewMutiArrayExpr() {
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
  @DisplayName("Test toString0()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0() {
    // Arrange
    Value[] sizes = new Value[] {new ArrayExpr()};

    // Act and Assert
    assertEquals("new [null[null]]", new NewMutiArrayExpr("", 1, sizes).toString0());
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
  @DisplayName(
      "Test toString0(); given ArrayExpr() Op1 is ArrayExpr(); then return 'new byte[null[null][null]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnNewByteNullNullNull() {
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
   *   <li>Then return {@code new byte[]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0_thenReturnNewByte() {
    // Arrange, Act and Assert
    assertEquals("new byte[]", Exprs.nNewMutiArray("Base", 1, new Value[] {}).toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new byte[((double)null[null])]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new byte[((double)null[null])]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0_thenReturnNewByteDoubleNullNull() {
    // Arrange
    CastExpr nCastResult = Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "D");

    // Act and Assert
    assertEquals(
        "new byte[((double)null[null])]",
        Exprs.nNewMutiArray("Base", 1, new Value[] {nCastResult}).toString0());
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
  @DisplayName("Test toString0(); then return 'new byte[null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0_thenReturnNewByteNull() {
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
  @DisplayName("Test toString0(); then return 'new byte[null[null]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0_thenReturnNewByteNullNull() {
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
  @DisplayName("Test toString0(); then return 'new byte[null[null][null[null]]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0_thenReturnNewByteNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr nArrayResult = Exprs.nArray(base, new ArrayExpr(), "new ");

    // Act and Assert
    assertEquals(
        "new byte[null[null][null[null]]]",
        Exprs.nNewMutiArray("Base", 1, new Value[] {nArrayResult}).toString0());
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
  @DisplayName("Test toString0(); then return 'new double[null[null]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0_thenReturnNewDoubleNullNull() {
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
  @DisplayName("Test toString0(); then return 'new float[null[null]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0_thenReturnNewFloatNullNull() {
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
  @DisplayName("Test toString0(); then return 'new int[null[null]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0_thenReturnNewIntNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new int[null[null]]",
        Exprs.nNewMutiArray("I", 1, new Value[] {new ArrayExpr()}).toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new long[null[null]]}.
   * </ul>
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new long[null[null]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0_thenReturnNewLongNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new long[null[null]]",
        Exprs.nNewMutiArray("J", 1, new Value[] {new ArrayExpr()}).toString0());
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
  @DisplayName("Test toString0(); then return 'new [][null[null]]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString0_thenReturnNewNullNull() {
    // Arrange
    Value[] sizes = new Value[] {new ArrayExpr()};

    // Act and Assert
    assertEquals("new [][null[null]]", new NewMutiArrayExpr("[", 1, sizes).toString0());
  }

  /**
   * Test {@link NewMutiArrayExpr#toString0()}.
   *
   * <p>Method under test: {@link NewMutiArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewMutiArrayExpr.toString0()"})
  void testToString02() {
    // Arrange
    Value[] sizes = new Value[] {new ArrayExpr()};

    // Act and Assert
    assertEquals("new [null[null]]", new NewMutiArrayExpr(null, 1, sizes).toString0());
  }
}
