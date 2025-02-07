package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.FilledArrayExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    FilledArrayExpr nFilledArrayResult =
        Exprs.nFilledArray("Element Type", new Value[] {new ArrayExpr()});

    // Act
    nFilledArrayResult.releaseMemory();

    // Assert
    assertNull(nFilledArrayResult.getOps());
    assertNull(nFilledArrayResult.type);
  }

  /**
   * Test {@link FilledArrayExpr#FilledArrayExpr(Value[], String)}.
   *
   * <p>Method under test: {@link FilledArrayExpr#FilledArrayExpr(Value[], String)}
   */
  @Test
  @DisplayName("Test new FilledArrayExpr(Value[], String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.expr.FilledArrayExpr.<init>(proguard.dexfile.ir.expr.Value[], java.lang.String)"
  })
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
   *   <li>Then first element return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return Constant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.FilledArrayExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
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
    assertNull(value.getOps());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.FilledArrayExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnInvokeCustomExpr() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {Exprs.nNull()},
            "Name",
            proto,
            new MethodHandle(1, new Field("Owner", "Name", "Type")),
            new Object[] {Constant.Null});
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
    assertNull(((InvokeCustomExpr) value).getArgs());
    assertNull(((InvokeCustomExpr) value).getName());
    assertNull(((InvokeCustomExpr) value).getOwner());
    assertNull(((InvokeCustomExpr) value).getRet());
    assertNull(((InvokeCustomExpr) value).method);
    assertEquals(1, ops.length);
    assertEquals(1, value.getOps().length);
    Object[] objectArray = ((InvokeCustomExpr) value).bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(ET.En, ((InvokeCustomExpr) value).et);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.Value proguard.dexfile.ir.expr.FilledArrayExpr.clone()"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FilledArrayExpr.toString0()"})
  void testToString0() {
    // Arrange
    FilledArrayExpr nFilledArrayResult =
        Exprs.nFilledArray("Element Type", new Value[] {new ArrayExpr()});
    nFilledArrayResult.type = "";

    // Act and Assert
    assertEquals("new []{null[null]}", nFilledArrayResult.toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nFilledArray {@code D} and array of {@link Value} with {@code null}.
   *   <li>Then return {@code new double[]{null}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given nFilledArray 'D' and array of Value with 'null'; then return 'new double[]{null}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FilledArrayExpr.toString0()"})
  void testToString0_givenNFilledArrayDAndArrayOfValueWithNull_thenReturnNewDoubleNull() {
    // Arrange, Act and Assert
    assertEquals("new double[]{null}", Exprs.nFilledArray("D", new Value[] {null}).toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nFilledArray {@code D} and empty array of {@link Value}.
   *   <li>Then return {@code new double[]{}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given nFilledArray 'D' and empty array of Value; then return 'new double[]{}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FilledArrayExpr.toString0()"})
  void testToString0_givenNFilledArrayDAndEmptyArrayOfValue_thenReturnNewDouble() {
    // Arrange, Act and Assert
    assertEquals("new double[]{}", Exprs.nFilledArray("D", new Value[] {}).toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Given nFilledArray {@code Element Type} and array of {@link Value} with {@link
   *       ArrayExpr#ArrayExpr()} {@link FilledArrayExpr#type} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName(
      "Test toString0(); given nFilledArray 'Element Type' and array of Value with ArrayExpr() type is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FilledArrayExpr.toString0()"})
  void testToString0_givenNFilledArrayElementTypeAndArrayOfValueWithArrayExprTypeIsNull() {
    // Arrange
    FilledArrayExpr nFilledArrayResult =
        Exprs.nFilledArray("Element Type", new Value[] {new ArrayExpr()});
    nFilledArrayResult.type = null;

    // Act and Assert
    assertEquals("new []{null[null]}", nFilledArrayResult.toString0());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FilledArrayExpr.toString0()"})
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
   *   <li>Then return {@code new double[]{null[null][null]}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new double[]{null[null][null]}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewDoubleNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals(
        "new double[]{null[null][null]}",
        Exprs.nFilledArray("D", new Value[] {arrayExpr}).toString0());
  }

  /**
   * Test {@link FilledArrayExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new double[]{null[null][null[null]]}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new double[]{null[null][null[null]]}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewDoubleNullNullNullNull() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "new double[]{null[null][null[null]]}",
        Exprs.nFilledArray("D", new Value[] {Exprs.nArray(base, new ArrayExpr(), "new ")})
            .toString0());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FilledArrayExpr.toString0()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FilledArrayExpr.toString0()"})
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
   *   <li>Then return {@code new [][]{null[null][null]}}.
   * </ul>
   *
   * <p>Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new [][]{null[null][null]}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.FilledArrayExpr.toString0()"})
  void testToString0_thenReturnNewNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals(
        "new [][]{null[null][null]}", Exprs.nFilledArray("[", new Value[] {arrayExpr}).toString0());
  }
}
