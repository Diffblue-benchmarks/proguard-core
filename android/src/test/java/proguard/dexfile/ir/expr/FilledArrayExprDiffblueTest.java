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
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Proto;

class FilledArrayExprDiffblueTest {
  /**
   * Test {@link FilledArrayExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link FilledArrayExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilledArrayExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    FilledArrayExpr nFilledArrayResult =
        Exprs.nFilledArray("Element Type", new Value[] {new ArrayExpr()});

    // Act
    nFilledArrayResult.releaseMemory();

    // Assert
    assertNull(nFilledArrayResult.type);
    assertNull(nFilledArrayResult.getOps());
  }

  /**
   * Test {@link FilledArrayExpr#FilledArrayExpr(Value[], String)}.
   *
   * <p>Method under test: {@link FilledArrayExpr#FilledArrayExpr(Value[], String)}
   */
  @Test
  @DisplayName("Test new FilledArrayExpr(Value[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FilledArrayExpr.<init>(Value[], String)"})
  void testNewFilledArrayExpr() {
    // Arrange
    Value[] datas = new Value[] {new ArrayExpr()};

    // Act
    FilledArrayExpr actualFilledArrayExpr = new FilledArrayExpr(datas, "Type");

    // Assert
    assertEquals("Type", actualFilledArrayExpr.type);
    assertNull(actualFilledArrayExpr.tag);
    assertNull(actualFilledArrayExpr.valueType);
    assertNull(actualFilledArrayExpr.getOp());
    assertNull(actualFilledArrayExpr.getOp1());
    assertNull(actualFilledArrayExpr.getOp2());
    assertEquals(ET.En, actualFilledArrayExpr.et);
    assertEquals(VT.FILLED_ARRAY, actualFilledArrayExpr.vt);
    assertSame(datas, actualFilledArrayExpr.getOps());
  }

  /**
   * Test {@link FilledArrayExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link CastExpr}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return CastExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value FilledArrayExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnCastExpr() {
    // Arrange
    CastExpr nCastResult =
        Exprs.nCast(Exprs.nNull(), "jane.doe@example.org", "alice.liddell@example.org");
    FilledArrayExpr nFilledArrayResult =
        Exprs.nFilledArray("Element Type", new Value[] {nCastResult});

    // Act
    Value actualCloneResult = nFilledArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof CastExpr);
    assertTrue(value.getOp() instanceof Constant);
    assertTrue(actualCloneResult instanceof FilledArrayExpr);
    assertEquals("alice.liddell@example.org", ((CastExpr) value).to);
    assertEquals("jane.doe@example.org", ((CastExpr) value).from);
    assertEquals(1, ops.length);
    assertEquals(ET.E1, ((CastExpr) value).et);
    assertEquals(VT.CAST, ((CastExpr) value).vt);
  }

  /**
   * Test {@link FilledArrayExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return Constant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value FilledArrayExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnConstant() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    FilledArrayExpr nFilledArrayResult =
        Exprs.nFilledArray("Element Type", new Value[] {nNullResult});

    // Act
    Value actualCloneResult = nFilledArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof FilledArrayExpr);
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link FilledArrayExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link FilledArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return FilledArrayExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value FilledArrayExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnFilledArrayExpr() {
    // Arrange
    FilledArrayExpr nFilledArrayResult =
        Exprs.nFilledArray(
            "Element Type",
            new Value[] {Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()})});

    // Act
    Value actualCloneResult = nFilledArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof FilledArrayExpr);
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof FilledArrayExpr);
    assertEquals("Element Type", ((FilledArrayExpr) value).type);
    assertEquals(1, ops.length);
    assertEquals(VT.FILLED_ARRAY, ((FilledArrayExpr) value).vt);
  }

  /**
   * Test {@link FilledArrayExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link InvokeCustomExpr}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return InvokeCustomExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value FilledArrayExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnInvokeCustomExpr() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {Exprs.nNull()}, "Name", proto, handle, new Object[] {Constant.Null});
    FilledArrayExpr nFilledArrayResult =
        Exprs.nFilledArray("Element Type", new Value[] {nInvokeCustomResult});

    // Act
    Value actualCloneResult = nFilledArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof FilledArrayExpr);
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeCustomExpr);
    assertEquals("InvokeCustomExpr(....)", value.toString0());
    assertEquals("Name", ((InvokeCustomExpr) value).name);
    assertNull(((InvokeCustomExpr) value).getName());
    assertNull(((InvokeCustomExpr) value).getOwner());
    assertNull(((InvokeCustomExpr) value).getRet());
    assertNull(((InvokeCustomExpr) value).getArgs());
    assertNull(((InvokeCustomExpr) value).method);
    assertEquals(1, ops.length);
    assertEquals(1, value.getOps().length);
    Object[] objectArray = ((InvokeCustomExpr) value).bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(VT.INVOKE_CUSTOM, ((InvokeCustomExpr) value).vt);
    assertSame(proto, ((InvokeCustomExpr) value).getProto());
    assertSame(nInvokeCustomResult.bsmArgs, objectArray);
    assertSame(nInvokeCustomResult.handle, ((InvokeCustomExpr) value).handle);
  }

  /**
   * Test {@link FilledArrayExpr#clone()}.
   *
   * <ul>
   *   <li>Then return {@link FilledArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return FilledArrayExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value FilledArrayExpr.clone()"})
  void testClone_thenReturnFilledArrayExpr() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nFilledArray("Element Type", new Value[] {}).clone();

    // Assert
    assertTrue(actualCloneResult instanceof FilledArrayExpr);
    assertEquals("Element Type", ((FilledArrayExpr) actualCloneResult).type);
    assertNull(((FilledArrayExpr) actualCloneResult).tag);
    assertNull(((FilledArrayExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertEquals(0, actualCloneResult.getOps().length);
    assertEquals(ET.En, ((FilledArrayExpr) actualCloneResult).et);
    assertEquals(VT.FILLED_ARRAY, ((FilledArrayExpr) actualCloneResult).vt);
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0() {
    // Arrange
    Value[] datas = new Value[] {new ArrayExpr()};
    FilledArrayExpr filledArrayExpr = new FilledArrayExpr(datas, "");

    // Act and Assert
    assertEquals("new []{null[null]}", filledArrayExpr.toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Given {@link ArrayExpr#ArrayExpr()} Op1 is {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code new []{null[null][null]}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given ArrayExpr() Op1 is ArrayExpr(); then return 'new []{null[null][null]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_givenArrayExprOp1IsArrayExpr_thenReturnNewNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());
    Value[] datas = new Value[] {arrayExpr};
    FilledArrayExpr filledArrayExpr = new FilledArrayExpr(datas, null);

    // Act and Assert
    assertEquals("new []{null[null][null]}", filledArrayExpr.toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new []{}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new []{}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNew() {
    // Arrange
    FilledArrayExpr filledArrayExpr = new FilledArrayExpr(new Value[] {}, null);

    // Act and Assert
    assertEquals("new []{}", filledArrayExpr.toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new double[]{null[null]}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new double[]{null[null]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewDoubleNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new double[]{null[null]}",
        Exprs.nFilledArray("D", new Value[] {new ArrayExpr()}).toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new float[]{null[null]}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new float[]{null[null]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewFloatNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new float[]{null[null]}",
        Exprs.nFilledArray("F", new Value[] {new ArrayExpr()}).toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new int[]{null[null]}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new int[]{null[null]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewIntNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new int[]{null[null]}",
        Exprs.nFilledArray("I", new Value[] {new ArrayExpr()}).toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new long[]{null[null]}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new long[]{null[null]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewLongNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new long[]{null[null]}",
        Exprs.nFilledArray("J", new Value[] {new ArrayExpr()}).toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new []{new []{null[null]}}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new []{new []{null[null]}}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewNewNullNull() {
    // Arrange
    Value[] datas = new Value[] {Exprs.nFilledArray("", new Value[] {new ArrayExpr()})};
    FilledArrayExpr filledArrayExpr = new FilledArrayExpr(datas, null);

    // Act and Assert
    assertEquals("new []{new []{null[null]}}", filledArrayExpr.toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new []{null}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new []{null}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewNull() {
    // Arrange
    Value[] datas = new Value[] {null};
    FilledArrayExpr filledArrayExpr = new FilledArrayExpr(datas, null);

    // Act and Assert
    assertEquals("new []{null}", filledArrayExpr.toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new []{null[null]}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new []{null[null]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewNullNull() {
    // Arrange
    Value[] datas = new Value[] {new ArrayExpr()};
    FilledArrayExpr filledArrayExpr = new FilledArrayExpr(datas, null);

    // Act and Assert
    assertEquals("new []{null[null]}", filledArrayExpr.toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new [][]{null[null]}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new [][]{null[null]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewNullNull2() {
    // Arrange
    Value[] datas = new Value[] {new ArrayExpr()};
    FilledArrayExpr filledArrayExpr = new FilledArrayExpr(datas, "[");

    // Act and Assert
    assertEquals("new [][]{null[null]}", filledArrayExpr.toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new []{(()null[null])}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new []{(()null[null])}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewNullNull3() {
    // Arrange
    CastExpr nCastResult = Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "");
    Value[] datas = new Value[] {nCastResult};
    FilledArrayExpr filledArrayExpr = new FilledArrayExpr(datas, null);

    // Act and Assert
    assertEquals("new []{(()null[null])}", filledArrayExpr.toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new []{null[null][null[null]]}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new []{null[null][null[null]]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr nArrayResult = Exprs.nArray(base, new ArrayExpr(), "new ");
    Value[] datas = new Value[] {nArrayResult};
    FilledArrayExpr filledArrayExpr = new FilledArrayExpr(datas, null);

    // Act and Assert
    assertEquals("new []{null[null][null[null]]}", filledArrayExpr.toString0());
  }
}
