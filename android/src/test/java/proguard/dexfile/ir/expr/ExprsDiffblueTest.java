package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.reader.DexType;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Proto;

class ExprsDiffblueTest {
  /**
   * Test {@link Exprs#copy(Value[])}.
   *
   * <ul>
   *   <li>When array of {@link Value} with {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link Exprs#copy(Value[])}
   */
  @Test
  @DisplayName(
      "Test copy(Value[]); when array of Value with ArrayExpr(); then return array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value[] Exprs.copy(Value[])"})
  void testCopy_whenArrayOfValueWithArrayExpr_thenReturnArrayLengthIsOne() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();

    // Act
    Value[] actualCopyResult = Exprs.copy(new Value[] {arrayExpr});

    // Assert
    assertEquals(1, actualCopyResult.length);
    assertSame(arrayExpr, actualCopyResult[0]);
  }

  /**
   * Test {@link Exprs#copy(Value[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link Exprs#copy(Value[])}
   */
  @Test
  @DisplayName("Test copy(Value[]); when 'null'; then return array length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value[] Exprs.copy(Value[])"})
  void testCopy_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange and Act
    Value[] actualCopyResult = Exprs.copy(null);

    // Assert
    assertEquals(0, actualCopyResult.length);
  }

  /**
   * Test {@link Exprs#nByte(byte)}.
   *
   * <p>Method under test: {@link Exprs#nByte(byte)}
   */
  @Test
  @DisplayName("Test nByte(byte)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nByte(byte)"})
  void testNByte() {
    // Arrange and Act
    Constant actualNByteResult = Exprs.nByte((byte) 'A');

    // Assert
    assertNull(actualNByteResult.tag);
    assertNull(actualNByteResult.valueType);
    assertNull(actualNByteResult.getOp());
    assertNull(actualNByteResult.getOp1());
    assertNull(actualNByteResult.getOp2());
    assertNull(actualNByteResult.getOps());
    assertEquals(ET.E0, actualNByteResult.et);
    assertEquals(VT.CONSTANT, actualNByteResult.vt);
    assertEquals('A', ((Byte) actualNByteResult.value).byteValue());
  }

  /**
   * Test {@link Exprs#nChar(char)}.
   *
   * <p>Method under test: {@link Exprs#nChar(char)}
   */
  @Test
  @DisplayName("Test nChar(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nChar(char)"})
  void testNChar() {
    // Arrange and Act
    Constant actualNCharResult = Exprs.nChar('A');

    // Assert
    assertEquals('A', ((Character) actualNCharResult.value).charValue());
    assertNull(actualNCharResult.tag);
    assertNull(actualNCharResult.valueType);
    assertNull(actualNCharResult.getOp());
    assertNull(actualNCharResult.getOp1());
    assertNull(actualNCharResult.getOp2());
    assertNull(actualNCharResult.getOps());
    assertEquals(ET.E0, actualNCharResult.et);
    assertEquals(VT.CONSTANT, actualNCharResult.vt);
  }

  /**
   * Test {@link Exprs#nType(String)} with {@code desc}.
   *
   * <p>Method under test: {@link Exprs#nType(String)}
   */
  @Test
  @DisplayName("Test nType(String) with 'desc'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nType(String)"})
  void testNTypeWithDesc() {
    // Arrange and Act
    Constant actualNTypeResult = Exprs.nType("The characteristics of someone or something");

    // Assert
    Object object = actualNTypeResult.value;
    assertTrue(object instanceof DexType);
    assertEquals("The characteristics of someone or something", object.toString());
    assertNull(actualNTypeResult.tag);
    assertNull(actualNTypeResult.valueType);
    assertNull(actualNTypeResult.getOp());
    assertNull(actualNTypeResult.getOp1());
    assertNull(actualNTypeResult.getOp2());
    assertNull(actualNTypeResult.getOps());
    assertEquals(ET.E0, actualNTypeResult.et);
    assertEquals(VT.CONSTANT, actualNTypeResult.vt);
  }

  /**
   * Test {@link Exprs#nType(DexType)} with {@code t}.
   *
   * <p>Method under test: {@link Exprs#nType(DexType)}
   */
  @Test
  @DisplayName("Test nType(DexType) with 't'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nType(DexType)"})
  void testNTypeWithT() {
    // Arrange and Act
    Constant actualNTypeResult =
        Exprs.nType(new DexType("The characteristics of someone or something"));

    // Assert
    Object object = actualNTypeResult.value;
    assertTrue(object instanceof DexType);
    assertEquals("The characteristics of someone or something", object.toString());
    assertNull(actualNTypeResult.tag);
    assertNull(actualNTypeResult.valueType);
    assertNull(actualNTypeResult.getOp());
    assertNull(actualNTypeResult.getOp1());
    assertNull(actualNTypeResult.getOp2());
    assertNull(actualNTypeResult.getOps());
    assertEquals(ET.E0, actualNTypeResult.et);
    assertEquals(VT.CONSTANT, actualNTypeResult.vt);
  }

  /**
   * Test {@link Exprs#nDouble(double)}.
   *
   * <p>Method under test: {@link Exprs#nDouble(double)}
   */
  @Test
  @DisplayName("Test nDouble(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nDouble(double)"})
  void testNDouble() {
    // Arrange and Act
    Constant actualNDoubleResult = Exprs.nDouble(10.0d);

    // Assert
    assertNull(actualNDoubleResult.tag);
    assertNull(actualNDoubleResult.valueType);
    assertNull(actualNDoubleResult.getOp());
    assertNull(actualNDoubleResult.getOp1());
    assertNull(actualNDoubleResult.getOp2());
    assertNull(actualNDoubleResult.getOps());
    assertEquals(10.0d, ((Double) actualNDoubleResult.value).doubleValue());
    assertEquals(ET.E0, actualNDoubleResult.et);
    assertEquals(VT.CONSTANT, actualNDoubleResult.vt);
  }

  /**
   * Test {@link Exprs#nFloat(float)}.
   *
   * <p>Method under test: {@link Exprs#nFloat(float)}
   */
  @Test
  @DisplayName("Test nFloat(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nFloat(float)"})
  void testNFloat() {
    // Arrange and Act
    Constant actualNFloatResult = Exprs.nFloat(10.0f);

    // Assert
    assertNull(actualNFloatResult.tag);
    assertNull(actualNFloatResult.valueType);
    assertNull(actualNFloatResult.getOp());
    assertNull(actualNFloatResult.getOp1());
    assertNull(actualNFloatResult.getOp2());
    assertNull(actualNFloatResult.getOps());
    assertEquals(10.0f, ((Float) actualNFloatResult.value).floatValue());
    assertEquals(ET.E0, actualNFloatResult.et);
    assertEquals(VT.CONSTANT, actualNFloatResult.vt);
  }

  /**
   * Test {@link Exprs#nInt(int)}.
   *
   * <p>Method under test: {@link Exprs#nInt(int)}
   */
  @Test
  @DisplayName("Test nInt(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nInt(int)"})
  void testNInt() {
    // Arrange and Act
    Constant actualNIntResult = Exprs.nInt(1);

    // Assert
    assertNull(actualNIntResult.tag);
    assertNull(actualNIntResult.valueType);
    assertNull(actualNIntResult.getOp());
    assertNull(actualNIntResult.getOp1());
    assertNull(actualNIntResult.getOp2());
    assertNull(actualNIntResult.getOps());
    assertEquals(1, ((Integer) actualNIntResult.value).intValue());
    assertEquals(ET.E0, actualNIntResult.et);
    assertEquals(VT.CONSTANT, actualNIntResult.vt);
  }

  /**
   * Test {@link Exprs#nLong(long)}.
   *
   * <p>Method under test: {@link Exprs#nLong(long)}
   */
  @Test
  @DisplayName("Test nLong(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nLong(long)"})
  void testNLong() {
    // Arrange and Act
    Constant actualNLongResult = Exprs.nLong(1L);

    // Assert
    assertNull(actualNLongResult.tag);
    assertNull(actualNLongResult.valueType);
    assertNull(actualNLongResult.getOp());
    assertNull(actualNLongResult.getOp1());
    assertNull(actualNLongResult.getOp2());
    assertNull(actualNLongResult.getOps());
    assertEquals(1L, ((Long) actualNLongResult.value).longValue());
    assertEquals(ET.E0, actualNLongResult.et);
    assertEquals(VT.CONSTANT, actualNLongResult.vt);
  }

  /**
   * Test {@link Exprs#nNull()}.
   *
   * <p>Method under test: {@link Exprs#nNull()}
   */
  @Test
  @DisplayName("Test nNull()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nNull()"})
  void testNNull() {
    // Arrange and Act
    Constant actualNNullResult = Exprs.nNull();

    // Assert
    assertNull(actualNNullResult.tag);
    assertNull(actualNNullResult.valueType);
    assertNull(actualNNullResult.getOp());
    assertNull(actualNNullResult.getOp1());
    assertNull(actualNNullResult.getOp2());
    assertNull(actualNNullResult.getOps());
    assertEquals(ET.E0, actualNNullResult.et);
    assertEquals(VT.CONSTANT, actualNNullResult.vt);
  }

  /**
   * Test {@link Exprs#nShort(short)}.
   *
   * <p>Method under test: {@link Exprs#nShort(short)}
   */
  @Test
  @DisplayName("Test nShort(short)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nShort(short)"})
  void testNShort() {
    // Arrange and Act
    Constant actualNShortResult = Exprs.nShort((short) 1);

    // Assert
    assertNull(actualNShortResult.tag);
    assertNull(actualNShortResult.valueType);
    assertNull(actualNShortResult.getOp());
    assertNull(actualNShortResult.getOp1());
    assertNull(actualNShortResult.getOp2());
    assertNull(actualNShortResult.getOps());
    assertEquals((short) 1, ((Short) actualNShortResult.value).shortValue());
    assertEquals(ET.E0, actualNShortResult.et);
    assertEquals(VT.CONSTANT, actualNShortResult.vt);
  }

  /**
   * Test {@link Exprs#nString(String)}.
   *
   * <p>Method under test: {@link Exprs#nString(String)}
   */
  @Test
  @DisplayName("Test nString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nString(String)"})
  void testNString() {
    // Arrange and Act
    Constant actualNStringResult = Exprs.nString("foo");

    // Assert
    assertEquals("foo", actualNStringResult.value);
    assertNull(actualNStringResult.tag);
    assertNull(actualNStringResult.valueType);
    assertNull(actualNStringResult.getOp());
    assertNull(actualNStringResult.getOp1());
    assertNull(actualNStringResult.getOp2());
    assertNull(actualNStringResult.getOps());
    assertEquals(ET.E0, actualNStringResult.et);
    assertEquals(VT.CONSTANT, actualNStringResult.vt);
  }

  /**
   * Test {@link Exprs#nAdd(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nAdd(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nAdd(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nAdd(Value, Value, String)"})
  void testNAdd() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNAddResult = Exprs.nAdd(a, b, "Type");

    // Assert
    Value op1 = actualNAddResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNAddResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] + null[null])", actualNAddResult.toString0());
    assertEquals("Type", actualNAddResult.type);
    assertNull(actualNAddResult.tag);
    assertNull(actualNAddResult.valueType);
    assertNull(actualNAddResult.getOp());
    assertNull(actualNAddResult.getOps());
    assertEquals(ET.E2, actualNAddResult.et);
    assertEquals(VT.ADD, actualNAddResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#niAdd(Value, Value)}.
   *
   * <p>Method under test: {@link Exprs#niAdd(Value, Value)}
   */
  @Test
  @DisplayName("Test niAdd(Value, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.niAdd(Value, Value)"})
  void testNiAdd() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNiAddResult = Exprs.niAdd(a, b);

    // Assert
    Value op1 = actualNiAddResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNiAddResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] + null[null])", actualNiAddResult.toString0());
    assertEquals("I", actualNiAddResult.type);
    assertNull(actualNiAddResult.tag);
    assertNull(actualNiAddResult.valueType);
    assertNull(actualNiAddResult.getOp());
    assertNull(actualNiAddResult.getOps());
    assertEquals(ET.E2, actualNiAddResult.et);
    assertEquals(VT.ADD, actualNiAddResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nAnd(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nAnd(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nAnd(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nAnd(Value, Value, String)"})
  void testNAnd() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNAndResult = Exprs.nAnd(a, b, "Type");

    // Assert
    Value op1 = actualNAndResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNAndResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] & null[null])", actualNAndResult.toString0());
    assertEquals("Type", actualNAndResult.type);
    assertNull(actualNAndResult.tag);
    assertNull(actualNAndResult.valueType);
    assertNull(actualNAndResult.getOp());
    assertNull(actualNAndResult.getOps());
    assertEquals(ET.E2, actualNAndResult.et);
    assertEquals(VT.AND, actualNAndResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nArray(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nArray(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nArray(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayExpr Exprs.nArray(Value, Value, String)"})
  void testNArray() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr index = new ArrayExpr();

    // Act
    ArrayExpr actualNArrayResult = Exprs.nArray(base, index, "Element Type");

    // Assert
    Value op1 = actualNArrayResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNArrayResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("Element Type", actualNArrayResult.elementType);
    assertEquals("null[null][null[null]]", actualNArrayResult.toString0());
    assertNull(actualNArrayResult.tag);
    assertNull(actualNArrayResult.valueType);
    assertNull(actualNArrayResult.getOp());
    assertNull(actualNArrayResult.getOps());
    assertEquals(ET.E2, actualNArrayResult.et);
    assertEquals(VT.ARRAY, actualNArrayResult.vt);
    assertSame(base, op1);
    assertSame(index, op2);
  }

  /**
   * Test {@link Exprs#nArrayValue(Object)}.
   *
   * <p>Method under test: {@link Exprs#nArrayValue(Object)}
   */
  @Test
  @DisplayName("Test nArrayValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nArrayValue(Object)"})
  void testNArrayValue() {
    // Arrange and Act
    Constant actualNArrayValueResult = Exprs.nArrayValue(Constant.Null);

    // Assert
    assertNull(actualNArrayValueResult.tag);
    assertNull(actualNArrayValueResult.valueType);
    assertNull(actualNArrayValueResult.getOp());
    assertNull(actualNArrayValueResult.getOp1());
    assertNull(actualNArrayValueResult.getOp2());
    assertNull(actualNArrayValueResult.getOps());
    assertEquals(ET.E0, actualNArrayValueResult.et);
    assertEquals(VT.CONSTANT, actualNArrayValueResult.vt);
  }

  /**
   * Test {@link Exprs#nCast(Value, String, String)}.
   *
   * <p>Method under test: {@link Exprs#nCast(Value, String, String)}
   */
  @Test
  @DisplayName("Test nCast(Value, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CastExpr Exprs.nCast(Value, String, String)"})
  void testNCast() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();

    // Act
    CastExpr actualNCastResult =
        Exprs.nCast(obj, "jane.doe@example.org", "alice.liddell@example.org");

    // Assert
    Value op = actualNCastResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("alice.liddell@example.org", actualNCastResult.to);
    assertEquals("jane.doe@example.org", actualNCastResult.from);
    assertNull(actualNCastResult.tag);
    assertNull(actualNCastResult.valueType);
    assertNull(actualNCastResult.getOp1());
    assertNull(actualNCastResult.getOp2());
    assertNull(actualNCastResult.getOps());
    assertEquals(ET.E1, actualNCastResult.et);
    assertEquals(VT.CAST, actualNCastResult.vt);
    assertSame(obj, op);
  }

  /**
   * Test {@link Exprs#nCheckCast(Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nCheckCast(Value, String)}
   */
  @Test
  @DisplayName("Test nCheckCast(Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeExpr Exprs.nCheckCast(Value, String)"})
  void testNCheckCast() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();

    // Act
    TypeExpr actualNCheckCastResult = Exprs.nCheckCast(obj, "Type");

    // Assert
    Value op = actualNCheckCastResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("Type", actualNCheckCastResult.type);
    assertNull(actualNCheckCastResult.tag);
    assertNull(actualNCheckCastResult.valueType);
    assertNull(actualNCheckCastResult.getOp1());
    assertNull(actualNCheckCastResult.getOp2());
    assertNull(actualNCheckCastResult.getOps());
    assertEquals(ET.E1, actualNCheckCastResult.et);
    assertEquals(VT.CHECK_CAST, actualNCheckCastResult.vt);
    assertSame(obj, op);
  }

  /**
   * Test {@link Exprs#nDCmpg(Value, Value)}.
   *
   * <p>Method under test: {@link Exprs#nDCmpg(Value, Value)}
   */
  @Test
  @DisplayName("Test nDCmpg(Value, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nDCmpg(Value, Value)"})
  void testNDCmpg() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDCmpgResult = Exprs.nDCmpg(a, b);

    // Assert
    Value op1 = actualNDCmpgResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNDCmpgResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] DCMPG null[null])", actualNDCmpgResult.toString0());
    assertEquals("D", actualNDCmpgResult.type);
    assertNull(actualNDCmpgResult.tag);
    assertNull(actualNDCmpgResult.valueType);
    assertNull(actualNDCmpgResult.getOp());
    assertNull(actualNDCmpgResult.getOps());
    assertEquals(ET.E2, actualNDCmpgResult.et);
    assertEquals(VT.DCMPG, actualNDCmpgResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nDCmpl(Value, Value)}.
   *
   * <p>Method under test: {@link Exprs#nDCmpl(Value, Value)}
   */
  @Test
  @DisplayName("Test nDCmpl(Value, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nDCmpl(Value, Value)"})
  void testNDCmpl() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDCmplResult = Exprs.nDCmpl(a, b);

    // Assert
    Value op1 = actualNDCmplResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNDCmplResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] DCMPL null[null])", actualNDCmplResult.toString0());
    assertEquals("D", actualNDCmplResult.type);
    assertNull(actualNDCmplResult.tag);
    assertNull(actualNDCmplResult.valueType);
    assertNull(actualNDCmplResult.getOp());
    assertNull(actualNDCmplResult.getOps());
    assertEquals(ET.E2, actualNDCmplResult.et);
    assertEquals(VT.DCMPL, actualNDCmplResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nDiv(Value, Value, String)}.
   *
   * <ul>
   *   <li>When {@code D}.
   *   <li>Then return {@link BinopExpr#type} is {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link Exprs#nDiv(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nDiv(Value, Value, String); when 'D'; then return type is 'D'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nDiv(Value, Value, String)"})
  void testNDiv_whenD_thenReturnTypeIsD() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDivResult = Exprs.nDiv(a, b, "D");

    // Assert
    Value op1 = actualNDivResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNDivResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] / null[null])", actualNDivResult.toString0());
    assertEquals("D", actualNDivResult.type);
    assertNull(actualNDivResult.tag);
    assertNull(actualNDivResult.valueType);
    assertNull(actualNDivResult.getOp());
    assertNull(actualNDivResult.getOps());
    assertEquals(ET.E2, actualNDivResult.et);
    assertEquals(VT.DDIV, actualNDivResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nDiv(Value, Value, String)}.
   *
   * <ul>
   *   <li>When {@code F}.
   *   <li>Then return {@link BinopExpr#type} is {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link Exprs#nDiv(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nDiv(Value, Value, String); when 'F'; then return type is 'F'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nDiv(Value, Value, String)"})
  void testNDiv_whenF_thenReturnTypeIsF() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDivResult = Exprs.nDiv(a, b, "F");

    // Assert
    Value op1 = actualNDivResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNDivResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] / null[null])", actualNDivResult.toString0());
    assertEquals("F", actualNDivResult.type);
    assertNull(actualNDivResult.tag);
    assertNull(actualNDivResult.valueType);
    assertNull(actualNDivResult.getOp());
    assertNull(actualNDivResult.getOps());
    assertEquals(ET.E2, actualNDivResult.et);
    assertEquals(VT.FDIV, actualNDivResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nDiv(Value, Value, String)}.
   *
   * <ul>
   *   <li>When {@code I}.
   *   <li>Then return {@link BinopExpr#type} is {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link Exprs#nDiv(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nDiv(Value, Value, String); when 'I'; then return type is 'I'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nDiv(Value, Value, String)"})
  void testNDiv_whenI_thenReturnTypeIsI() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDivResult = Exprs.nDiv(a, b, "I");

    // Assert
    Value op1 = actualNDivResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNDivResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] / null[null])", actualNDivResult.toString0());
    assertEquals("I", actualNDivResult.type);
    assertNull(actualNDivResult.tag);
    assertNull(actualNDivResult.valueType);
    assertNull(actualNDivResult.getOp());
    assertNull(actualNDivResult.getOps());
    assertEquals(ET.E2, actualNDivResult.et);
    assertEquals(VT.IDIV, actualNDivResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nDiv(Value, Value, String)}.
   *
   * <ul>
   *   <li>When {@code J}.
   *   <li>Then return {@link BinopExpr#type} is {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link Exprs#nDiv(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nDiv(Value, Value, String); when 'J'; then return type is 'J'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nDiv(Value, Value, String)"})
  void testNDiv_whenJ_thenReturnTypeIsJ() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDivResult = Exprs.nDiv(a, b, "J");

    // Assert
    Value op1 = actualNDivResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNDivResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] / null[null])", actualNDivResult.toString0());
    assertEquals("J", actualNDivResult.type);
    assertNull(actualNDivResult.tag);
    assertNull(actualNDivResult.valueType);
    assertNull(actualNDivResult.getOp());
    assertNull(actualNDivResult.getOps());
    assertEquals(ET.E2, actualNDivResult.et);
    assertEquals(VT.LDIV, actualNDivResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nDiv(Value, Value, String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Exprs#nDiv(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nDiv(Value, Value, String); when 'Type'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nDiv(Value, Value, String)"})
  void testNDiv_whenType_thenThrowRuntimeException() {
    // Arrange
    ArrayExpr a = new ArrayExpr();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Exprs.nDiv(a, new ArrayExpr(), "Type"));
  }

  /**
   * Test {@link Exprs#nEq(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nEq(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nEq(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nEq(Value, Value, String)"})
  void testNEq() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNEqResult = Exprs.nEq(a, b, "Type");

    // Assert
    Value op1 = actualNEqResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNEqResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] == null[null])", actualNEqResult.toString0());
    assertEquals("Type", actualNEqResult.type);
    assertNull(actualNEqResult.tag);
    assertNull(actualNEqResult.valueType);
    assertNull(actualNEqResult.getOp());
    assertNull(actualNEqResult.getOps());
    assertEquals(ET.E2, actualNEqResult.et);
    assertEquals(VT.EQ, actualNEqResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#niEq(Value, Value)}.
   *
   * <p>Method under test: {@link Exprs#niEq(Value, Value)}
   */
  @Test
  @DisplayName("Test niEq(Value, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.niEq(Value, Value)"})
  void testNiEq() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNiEqResult = Exprs.niEq(a, b);

    // Assert
    Value op1 = actualNiEqResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNiEqResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] == null[null])", actualNiEqResult.toString0());
    assertEquals("I", actualNiEqResult.type);
    assertNull(actualNiEqResult.tag);
    assertNull(actualNiEqResult.valueType);
    assertNull(actualNiEqResult.getOp());
    assertNull(actualNiEqResult.getOps());
    assertEquals(ET.E2, actualNiEqResult.et);
    assertEquals(VT.EQ, actualNiEqResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nExceptionRef(String)}.
   *
   * <p>Method under test: {@link Exprs#nExceptionRef(String)}
   */
  @Test
  @DisplayName("Test nExceptionRef(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RefExpr Exprs.nExceptionRef(String)"})
  void testNExceptionRef() {
    // Arrange and Act
    RefExpr actualNExceptionRefResult = Exprs.nExceptionRef("Type");

    // Assert
    assertEquals("@Exception", actualNExceptionRefResult.toString0());
    assertEquals("Type", actualNExceptionRefResult.type);
    assertNull(actualNExceptionRefResult.tag);
    assertNull(actualNExceptionRefResult.valueType);
    assertNull(actualNExceptionRefResult.getOp());
    assertNull(actualNExceptionRefResult.getOp1());
    assertNull(actualNExceptionRefResult.getOp2());
    assertNull(actualNExceptionRefResult.getOps());
    assertEquals(-1, actualNExceptionRefResult.parameterIndex);
    assertEquals(ET.E0, actualNExceptionRefResult.et);
    assertEquals(VT.EXCEPTION_REF, actualNExceptionRefResult.vt);
  }

  /**
   * Test {@link Exprs#nFCmpg(Value, Value)}.
   *
   * <p>Method under test: {@link Exprs#nFCmpg(Value, Value)}
   */
  @Test
  @DisplayName("Test nFCmpg(Value, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nFCmpg(Value, Value)"})
  void testNFCmpg() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNFCmpgResult = Exprs.nFCmpg(a, b);

    // Assert
    Value op1 = actualNFCmpgResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNFCmpgResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] FCMPG null[null])", actualNFCmpgResult.toString0());
    assertEquals("F", actualNFCmpgResult.type);
    assertNull(actualNFCmpgResult.tag);
    assertNull(actualNFCmpgResult.valueType);
    assertNull(actualNFCmpgResult.getOp());
    assertNull(actualNFCmpgResult.getOps());
    assertEquals(ET.E2, actualNFCmpgResult.et);
    assertEquals(VT.FCMPG, actualNFCmpgResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nFCmpl(Value, Value)}.
   *
   * <p>Method under test: {@link Exprs#nFCmpl(Value, Value)}
   */
  @Test
  @DisplayName("Test nFCmpl(Value, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nFCmpl(Value, Value)"})
  void testNFCmpl() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNFCmplResult = Exprs.nFCmpl(a, b);

    // Assert
    Value op1 = actualNFCmplResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNFCmplResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] FCMPL null[null])", actualNFCmplResult.toString0());
    assertEquals("F", actualNFCmplResult.type);
    assertNull(actualNFCmplResult.tag);
    assertNull(actualNFCmplResult.valueType);
    assertNull(actualNFCmplResult.getOp());
    assertNull(actualNFCmplResult.getOps());
    assertEquals(ET.E2, actualNFCmplResult.et);
    assertEquals(VT.FCMPL, actualNFCmplResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nField(Value, String, String, String)}.
   *
   * <p>Method under test: {@link Exprs#nField(Value, String, String, String)}
   */
  @Test
  @DisplayName("Test nField(Value, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldExpr Exprs.nField(Value, String, String, String)"})
  void testNField() {
    // Arrange
    ArrayExpr object = new ArrayExpr();

    // Act
    FieldExpr actualNFieldResult = Exprs.nField(object, "Owner Type", "Field Name", "Field Type");

    // Assert
    Value op = actualNFieldResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("Field Name", actualNFieldResult.name);
    assertEquals("Field Type", actualNFieldResult.type);
    assertEquals("Owner Type", actualNFieldResult.owner);
    assertEquals("null[null].Field Name", actualNFieldResult.toString0());
    assertNull(actualNFieldResult.tag);
    assertNull(actualNFieldResult.valueType);
    assertNull(actualNFieldResult.getOp1());
    assertNull(actualNFieldResult.getOp2());
    assertNull(actualNFieldResult.getOps());
    assertEquals(ET.E1, actualNFieldResult.et);
    assertEquals(VT.FIELD, actualNFieldResult.vt);
    assertSame(object, op);
  }

  /**
   * Test {@link Exprs#nGe(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nGe(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nGe(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nGe(Value, Value, String)"})
  void testNGe() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNGeResult = Exprs.nGe(a, b, "Type");

    // Assert
    Value op1 = actualNGeResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNGeResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] >= null[null])", actualNGeResult.toString0());
    assertEquals("Type", actualNGeResult.type);
    assertNull(actualNGeResult.tag);
    assertNull(actualNGeResult.valueType);
    assertNull(actualNGeResult.getOp());
    assertNull(actualNGeResult.getOps());
    assertEquals(ET.E2, actualNGeResult.et);
    assertEquals(VT.GE, actualNGeResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nGt(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nGt(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nGt(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nGt(Value, Value, String)"})
  void testNGt() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNGtResult = Exprs.nGt(a, b, "Type");

    // Assert
    Value op1 = actualNGtResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNGtResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] > null[null])", actualNGtResult.toString0());
    assertEquals("Type", actualNGtResult.type);
    assertNull(actualNGtResult.tag);
    assertNull(actualNGtResult.valueType);
    assertNull(actualNGtResult.getOp());
    assertNull(actualNGtResult.getOps());
    assertEquals(ET.E2, actualNGtResult.et);
    assertEquals(VT.GT, actualNGtResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#njGt(Value, Value)}.
   *
   * <p>Method under test: {@link Exprs#njGt(Value, Value)}
   */
  @Test
  @DisplayName("Test njGt(Value, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.njGt(Value, Value)"})
  void testNjGt() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNjGtResult = Exprs.njGt(a, b);

    // Assert
    Value op1 = actualNjGtResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNjGtResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] > null[null])", actualNjGtResult.toString0());
    assertEquals("J", actualNjGtResult.type);
    assertNull(actualNjGtResult.tag);
    assertNull(actualNjGtResult.valueType);
    assertNull(actualNjGtResult.getOp());
    assertNull(actualNjGtResult.getOps());
    assertEquals(ET.E2, actualNjGtResult.et);
    assertEquals(VT.GT, actualNjGtResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#niGt(Value, Value)}.
   *
   * <p>Method under test: {@link Exprs#niGt(Value, Value)}
   */
  @Test
  @DisplayName("Test niGt(Value, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.niGt(Value, Value)"})
  void testNiGt() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNiGtResult = Exprs.niGt(a, b);

    // Assert
    Value op1 = actualNiGtResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNiGtResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] > null[null])", actualNiGtResult.toString0());
    assertEquals("I", actualNiGtResult.type);
    assertNull(actualNiGtResult.tag);
    assertNull(actualNiGtResult.valueType);
    assertNull(actualNiGtResult.getOp());
    assertNull(actualNiGtResult.getOps());
    assertEquals(ET.E2, actualNiGtResult.et);
    assertEquals(VT.GT, actualNiGtResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nInstanceOf(Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nInstanceOf(Value, String)}
   */
  @Test
  @DisplayName("Test nInstanceOf(Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeExpr Exprs.nInstanceOf(Value, String)"})
  void testNInstanceOf() {
    // Arrange
    ArrayExpr value = new ArrayExpr();

    // Act
    TypeExpr actualNInstanceOfResult = Exprs.nInstanceOf(value, "Type");

    // Assert
    Value op = actualNInstanceOfResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("Type", actualNInstanceOfResult.type);
    assertNull(actualNInstanceOfResult.tag);
    assertNull(actualNInstanceOfResult.valueType);
    assertNull(actualNInstanceOfResult.getOp1());
    assertNull(actualNInstanceOfResult.getOp2());
    assertNull(actualNInstanceOfResult.getOps());
    assertEquals(ET.E1, actualNInstanceOfResult.et);
    assertEquals(VT.INSTANCE_OF, actualNInstanceOfResult.vt);
    assertSame(value, op);
  }

  /**
   * Test {@link Exprs#nInvokeInterface(Value[], String, String, String[], String)}.
   *
   * <p>Method under test: {@link Exprs#nInvokeInterface(Value[], String, String, String[], String)}
   */
  @Test
  @DisplayName("Test nInvokeInterface(Value[], String, String, String[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InvokeExpr Exprs.nInvokeInterface(Value[], String, String, String[], String)"
  })
  void testNInvokeInterface() {
    // Arrange
    Value[] regs = new Value[] {new ArrayExpr()};
    String[] argmentTypes = new String[] {"Argment Types"};

    // Act
    InvokeExpr actualNInvokeInterfaceResult =
        Exprs.nInvokeInterface(regs, "Owner", "Name", argmentTypes, "Return Type");

    // Assert
    assertEquals("Name", actualNInvokeInterfaceResult.getName());
    assertEquals("Owner", actualNInvokeInterfaceResult.getOwner());
    assertEquals("Return Type", actualNInvokeInterfaceResult.getRet());
    assertEquals("null[null].Name()", actualNInvokeInterfaceResult.toString0());
    assertNull(actualNInvokeInterfaceResult.tag);
    assertNull(actualNInvokeInterfaceResult.valueType);
    assertNull(actualNInvokeInterfaceResult.getOp());
    assertNull(actualNInvokeInterfaceResult.getOp1());
    assertNull(actualNInvokeInterfaceResult.getOp2());
    Value[] ops = actualNInvokeInterfaceResult.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, actualNInvokeInterfaceResult.et);
    assertEquals(VT.INVOKE_INTERFACE, actualNInvokeInterfaceResult.vt);
    assertSame(argmentTypes, actualNInvokeInterfaceResult.getArgs());
    assertSame(regs, ops);
  }

  /**
   * Test {@link Exprs#nInvokeNew(Value[], String[], String)} with {@code regs}, {@code
   * argmentTypes}, {@code owner}.
   *
   * <p>Method under test: {@link Exprs#nInvokeNew(Value[], String[], String)}
   */
  @Test
  @DisplayName("Test nInvokeNew(Value[], String[], String) with 'regs', 'argmentTypes', 'owner'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr Exprs.nInvokeNew(Value[], String[], String)"})
  void testNInvokeNewWithRegsArgmentTypesOwner() {
    // Arrange
    Value[] regs = new Value[] {new ArrayExpr()};
    String[] argmentTypes = new String[] {"Argment Types"};

    // Act
    InvokeExpr actualNInvokeNewResult = Exprs.nInvokeNew(regs, argmentTypes, "Owner");

    // Assert
    assertTrue(actualNInvokeNewResult instanceof InvokeNewExpr);
    assertEquals("<init>", actualNInvokeNewResult.getName());
    assertEquals("Owner", actualNInvokeNewResult.getOwner());
    assertEquals("Owner", actualNInvokeNewResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualNInvokeNewResult).getClassName());
    assertNull(((InvokeNewExpr) actualNInvokeNewResult).tag);
    assertNull(((InvokeNewExpr) actualNInvokeNewResult).valueType);
    assertNull(actualNInvokeNewResult.getOp());
    assertNull(actualNInvokeNewResult.getOp1());
    assertNull(actualNInvokeNewResult.getOp2());
    Value[] ops = actualNInvokeNewResult.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, ((InvokeNewExpr) actualNInvokeNewResult).et);
    assertEquals(VT.INVOKE_NEW, ((InvokeNewExpr) actualNInvokeNewResult).vt);
    assertSame(argmentTypes, actualNInvokeNewResult.getArgs());
    assertSame(regs, ops);
  }

  /**
   * Test {@link Exprs#nInvokeNew(Value[], String[], String, String)} with {@code regs}, {@code
   * argmentTypes}, {@code owner}, {@code className}.
   *
   * <p>Method under test: {@link Exprs#nInvokeNew(Value[], String[], String, String)}
   */
  @Test
  @DisplayName(
      "Test nInvokeNew(Value[], String[], String, String) with 'regs', 'argmentTypes', 'owner', 'className'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr Exprs.nInvokeNew(Value[], String[], String, String)"})
  void testNInvokeNewWithRegsArgmentTypesOwnerClassName() {
    // Arrange
    Value[] regs = new Value[] {new ArrayExpr()};
    String[] argmentTypes = new String[] {"Argment Types"};

    // Act
    InvokeExpr actualNInvokeNewResult = Exprs.nInvokeNew(regs, argmentTypes, "Owner", "Class Name");

    // Assert
    assertTrue(actualNInvokeNewResult instanceof InvokeNewExpr);
    assertEquals("<init>", actualNInvokeNewResult.getName());
    assertEquals("Class Name", ((InvokeNewExpr) actualNInvokeNewResult).getClassName());
    assertEquals("Owner", actualNInvokeNewResult.getOwner());
    assertEquals("Owner", actualNInvokeNewResult.getRet());
    assertNull(((InvokeNewExpr) actualNInvokeNewResult).tag);
    assertNull(((InvokeNewExpr) actualNInvokeNewResult).valueType);
    assertNull(actualNInvokeNewResult.getOp());
    assertNull(actualNInvokeNewResult.getOp1());
    assertNull(actualNInvokeNewResult.getOp2());
    Value[] ops = actualNInvokeNewResult.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, ((InvokeNewExpr) actualNInvokeNewResult).et);
    assertEquals(VT.INVOKE_NEW, ((InvokeNewExpr) actualNInvokeNewResult).vt);
    assertSame(argmentTypes, actualNInvokeNewResult.getArgs());
    assertSame(regs, ops);
  }

  /**
   * Test {@link Exprs#nInvokeSpecial(Value[], String, String, String[], String)}.
   *
   * <p>Method under test: {@link Exprs#nInvokeSpecial(Value[], String, String, String[], String)}
   */
  @Test
  @DisplayName("Test nInvokeSpecial(Value[], String, String, String[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr Exprs.nInvokeSpecial(Value[], String, String, String[], String)"})
  void testNInvokeSpecial() {
    // Arrange
    Value[] regs = new Value[] {new ArrayExpr()};
    String[] argmentTypes = new String[] {"Argment Types"};

    // Act
    InvokeExpr actualNInvokeSpecialResult =
        Exprs.nInvokeSpecial(regs, "Owner", "Name", argmentTypes, "Return Type");

    // Assert
    assertEquals("Name", actualNInvokeSpecialResult.getName());
    assertEquals("Owner", actualNInvokeSpecialResult.getOwner());
    assertEquals("Return Type", actualNInvokeSpecialResult.getRet());
    assertEquals("null[null].Name()", actualNInvokeSpecialResult.toString0());
    assertNull(actualNInvokeSpecialResult.tag);
    assertNull(actualNInvokeSpecialResult.valueType);
    assertNull(actualNInvokeSpecialResult.getOp());
    assertNull(actualNInvokeSpecialResult.getOp1());
    assertNull(actualNInvokeSpecialResult.getOp2());
    Value[] ops = actualNInvokeSpecialResult.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, actualNInvokeSpecialResult.et);
    assertEquals(VT.INVOKE_SPECIAL, actualNInvokeSpecialResult.vt);
    assertSame(argmentTypes, actualNInvokeSpecialResult.getArgs());
    assertSame(regs, ops);
  }

  /**
   * Test {@link Exprs#nInvokeStatic(Value[], String, String, String[], String)}.
   *
   * <p>Method under test: {@link Exprs#nInvokeStatic(Value[], String, String, String[], String)}
   */
  @Test
  @DisplayName("Test nInvokeStatic(Value[], String, String, String[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr Exprs.nInvokeStatic(Value[], String, String, String[], String)"})
  void testNInvokeStatic() {
    // Arrange
    Value[] regs = new Value[] {new ArrayExpr()};
    String[] argmentTypes = new String[] {"Argment Types"};

    // Act
    InvokeExpr actualNInvokeStaticResult =
        Exprs.nInvokeStatic(regs, "Owner", "Name", argmentTypes, "Return Type");

    // Assert
    assertEquals("Name", actualNInvokeStaticResult.getName());
    assertEquals("Owner", actualNInvokeStaticResult.getOwner());
    assertEquals("Return Type", actualNInvokeStaticResult.getRet());
    assertNull(actualNInvokeStaticResult.tag);
    assertNull(actualNInvokeStaticResult.valueType);
    assertNull(actualNInvokeStaticResult.getOp());
    assertNull(actualNInvokeStaticResult.getOp1());
    assertNull(actualNInvokeStaticResult.getOp2());
    Value[] ops = actualNInvokeStaticResult.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, actualNInvokeStaticResult.et);
    assertEquals(VT.INVOKE_STATIC, actualNInvokeStaticResult.vt);
    assertSame(argmentTypes, actualNInvokeStaticResult.getArgs());
    assertSame(regs, ops);
  }

  /**
   * Test {@link Exprs#nInvokeVirtual(Value[], String, String, String[], String)}.
   *
   * <p>Method under test: {@link Exprs#nInvokeVirtual(Value[], String, String, String[], String)}
   */
  @Test
  @DisplayName("Test nInvokeVirtual(Value[], String, String, String[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr Exprs.nInvokeVirtual(Value[], String, String, String[], String)"})
  void testNInvokeVirtual() {
    // Arrange
    Value[] regs = new Value[] {new ArrayExpr()};
    String[] argmentTypes = new String[] {"Argment Types"};

    // Act
    InvokeExpr actualNInvokeVirtualResult =
        Exprs.nInvokeVirtual(regs, "Owner", "Name", argmentTypes, "Return Type");

    // Assert
    assertEquals("Name", actualNInvokeVirtualResult.getName());
    assertEquals("Owner", actualNInvokeVirtualResult.getOwner());
    assertEquals("Return Type", actualNInvokeVirtualResult.getRet());
    assertEquals("null[null].Name()", actualNInvokeVirtualResult.toString0());
    assertNull(actualNInvokeVirtualResult.tag);
    assertNull(actualNInvokeVirtualResult.valueType);
    assertNull(actualNInvokeVirtualResult.getOp());
    assertNull(actualNInvokeVirtualResult.getOp1());
    assertNull(actualNInvokeVirtualResult.getOp2());
    Value[] ops = actualNInvokeVirtualResult.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, actualNInvokeVirtualResult.et);
    assertEquals(VT.INVOKE_VIRTUAL, actualNInvokeVirtualResult.vt);
    assertSame(argmentTypes, actualNInvokeVirtualResult.getArgs());
    assertSame(regs, ops);
  }

  /**
   * Test {@link Exprs#nInvokeCustom(Value[], String, Proto, MethodHandle, Object[])}.
   *
   * <ul>
   *   <li>When {@link Field#Field(String, String, String)} with {@code Owner} and {@code Name} and
   *       {@code Type}.
   *   <li>Then return {@link InvokeCustomExpr#handle} Method is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Exprs#nInvokeCustom(Value[], String, Proto, MethodHandle,
   * Object[])}
   */
  @Test
  @DisplayName(
      "Test nInvokeCustom(Value[], String, Proto, MethodHandle, Object[]); when Field(String, String, String) with 'Owner' and 'Name' and 'Type'; then return handle Method is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InvokeCustomExpr Exprs.nInvokeCustom(Value[], String, Proto, MethodHandle, Object[])"
  })
  void testNInvokeCustom_whenFieldWithOwnerAndNameAndType_thenReturnHandleMethodIsNull() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    // Act
    InvokeCustomExpr actualNInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {new ArrayExpr()}, "Name", proto, handle, new Object[] {Constant.Null});

    // Assert
    MethodHandle methodHandle = actualNInvokeCustomResult.handle;
    assertNull(methodHandle.getMethod());
    assertEquals(1, methodHandle.getType());
    assertSame(field, methodHandle.getField());
  }

  /**
   * Test {@link Exprs#nInvokeCustom(Value[], String, Proto, MethodHandle, Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return toString0 is {@code InvokeCustomExpr(....)}.
   * </ul>
   *
   * <p>Method under test: {@link Exprs#nInvokeCustom(Value[], String, Proto, MethodHandle,
   * Object[])}
   */
  @Test
  @DisplayName(
      "Test nInvokeCustom(Value[], String, Proto, MethodHandle, Object[]); when 'null'; then return toString0 is 'InvokeCustomExpr(....)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InvokeCustomExpr Exprs.nInvokeCustom(Value[], String, Proto, MethodHandle, Object[])"
  })
  void testNInvokeCustom_whenNull_thenReturnToString0IsInvokeCustomExpr() {
    // Arrange
    Value[] regs = new Value[] {new ArrayExpr()};
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");

    // Act
    InvokeCustomExpr actualNInvokeCustomResult =
        Exprs.nInvokeCustom(regs, "Name", proto, null, new Object[] {Constant.Null});

    // Assert
    assertEquals("InvokeCustomExpr(....)", actualNInvokeCustomResult.toString0());
    assertEquals("Name", actualNInvokeCustomResult.name);
    assertNull(actualNInvokeCustomResult.tag);
    assertNull(actualNInvokeCustomResult.getName());
    assertNull(actualNInvokeCustomResult.getOwner());
    assertNull(actualNInvokeCustomResult.getRet());
    assertNull(actualNInvokeCustomResult.valueType);
    assertNull(actualNInvokeCustomResult.getArgs());
    assertNull(actualNInvokeCustomResult.getOp());
    assertNull(actualNInvokeCustomResult.getOp1());
    assertNull(actualNInvokeCustomResult.getOp2());
    assertNull(actualNInvokeCustomResult.method);
    assertNull(actualNInvokeCustomResult.handle);
    Value[] ops = actualNInvokeCustomResult.getOps();
    assertEquals(1, ops.length);
    assertEquals(1, actualNInvokeCustomResult.bsmArgs.length);
    assertEquals(ET.En, actualNInvokeCustomResult.et);
    assertEquals(VT.INVOKE_CUSTOM, actualNInvokeCustomResult.vt);
    assertSame(proto, actualNInvokeCustomResult.getProto());
    assertSame(regs, ops);
  }

  /**
   * Test {@link Exprs#nInvokePolymorphic(Value[], Proto, Method)}.
   *
   * <p>Method under test: {@link Exprs#nInvokePolymorphic(Value[], Proto, Method)}
   */
  @Test
  @DisplayName("Test nInvokePolymorphic(Value[], Proto, Method)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokePolymorphicExpr Exprs.nInvokePolymorphic(Value[], Proto, Method)"})
  void testNInvokePolymorphic() {
    // Arrange
    Value[] regs = new Value[] {new ArrayExpr()};
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    // Act
    InvokePolymorphicExpr actualNInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(regs, proto, method);

    // Assert
    assertEquals("Name", actualNInvokePolymorphicResult.getName());
    assertEquals("Owner", actualNInvokePolymorphicResult.getOwner());
    assertEquals("Return Type", actualNInvokePolymorphicResult.getRet());
    assertEquals("null[null].Name()", actualNInvokePolymorphicResult.toString0());
    assertNull(actualNInvokePolymorphicResult.tag);
    assertNull(actualNInvokePolymorphicResult.valueType);
    assertNull(actualNInvokePolymorphicResult.getOp());
    assertNull(actualNInvokePolymorphicResult.getOp1());
    assertNull(actualNInvokePolymorphicResult.getOp2());
    assertEquals(1, actualNInvokePolymorphicResult.getArgs().length);
    Value[] ops = actualNInvokePolymorphicResult.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, actualNInvokePolymorphicResult.et);
    assertEquals(VT.INVOKE_POLYMORPHIC, actualNInvokePolymorphicResult.vt);
    assertSame(proto, actualNInvokePolymorphicResult.getProto());
    assertSame(regs, ops);
  }

  /**
   * Test {@link Exprs#nLCmp(Value, Value)}.
   *
   * <p>Method under test: {@link Exprs#nLCmp(Value, Value)}
   */
  @Test
  @DisplayName("Test nLCmp(Value, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nLCmp(Value, Value)"})
  void testNLCmp() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNLCmpResult = Exprs.nLCmp(a, b);

    // Assert
    Value op1 = actualNLCmpResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNLCmpResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] LCMP null[null])", actualNLCmpResult.toString0());
    assertEquals("J", actualNLCmpResult.type);
    assertNull(actualNLCmpResult.tag);
    assertNull(actualNLCmpResult.valueType);
    assertNull(actualNLCmpResult.getOp());
    assertNull(actualNLCmpResult.getOps());
    assertEquals(ET.E2, actualNLCmpResult.et);
    assertEquals(VT.LCMP, actualNLCmpResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nLe(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nLe(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nLe(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nLe(Value, Value, String)"})
  void testNLe() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNLeResult = Exprs.nLe(a, b, "Type");

    // Assert
    Value op1 = actualNLeResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNLeResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] <= null[null])", actualNLeResult.toString0());
    assertEquals("Type", actualNLeResult.type);
    assertNull(actualNLeResult.tag);
    assertNull(actualNLeResult.valueType);
    assertNull(actualNLeResult.getOp());
    assertNull(actualNLeResult.getOps());
    assertEquals(ET.E2, actualNLeResult.et);
    assertEquals(VT.LE, actualNLeResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nLength(Value)}.
   *
   * <p>Method under test: {@link Exprs#nLength(Value)}
   */
  @Test
  @DisplayName("Test nLength(Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnopExpr Exprs.nLength(Value)"})
  void testNLength() {
    // Arrange
    ArrayExpr array = new ArrayExpr();

    // Act
    UnopExpr actualNLengthResult = Exprs.nLength(array);

    // Assert
    Value op = actualNLengthResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("null[null].length", actualNLengthResult.toString0());
    assertNull(actualNLengthResult.tag);
    assertNull(actualNLengthResult.type);
    assertNull(actualNLengthResult.valueType);
    assertNull(actualNLengthResult.getOp1());
    assertNull(actualNLengthResult.getOp2());
    assertNull(actualNLengthResult.getOps());
    assertEquals(ET.E1, actualNLengthResult.et);
    assertEquals(VT.LENGTH, actualNLengthResult.vt);
    assertSame(array, op);
  }

  /**
   * Test {@link Exprs#nLocal(String)} with {@code debugName}.
   *
   * <p>Method under test: {@link Exprs#nLocal(String)}
   */
  @Test
  @DisplayName("Test nLocal(String) with 'debugName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Local Exprs.nLocal(String)"})
  void testNLocalWithDebugName() {
    // Arrange and Act
    Local actualNLocalResult = Exprs.nLocal("Debug Name");

    // Assert
    assertEquals("Debug Name", actualNLocalResult.debugName);
    assertEquals("Debug Name_0", actualNLocalResult.toString0());
    assertNull(actualNLocalResult.tag);
    assertNull(actualNLocalResult.signature);
    assertNull(actualNLocalResult.valueType);
    assertNull(actualNLocalResult.getOp());
    assertNull(actualNLocalResult.getOp1());
    assertNull(actualNLocalResult.getOp2());
    assertNull(actualNLocalResult.getOps());
    assertEquals(0, actualNLocalResult._ls_index);
    assertEquals(ET.E0, actualNLocalResult.et);
    assertEquals(VT.LOCAL, actualNLocalResult.vt);
  }

  /**
   * Test {@link Exprs#nLocal(int)} with {@code index}.
   *
   * <p>Method under test: {@link Exprs#nLocal(int)}
   */
  @Test
  @DisplayName("Test nLocal(int) with 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Local Exprs.nLocal(int)"})
  void testNLocalWithIndex() {
    // Arrange and Act
    Local actualNLocalResult = Exprs.nLocal(1);

    // Assert
    assertEquals("a1", actualNLocalResult.toString0());
    assertNull(actualNLocalResult.tag);
    assertNull(actualNLocalResult.debugName);
    assertNull(actualNLocalResult.signature);
    assertNull(actualNLocalResult.valueType);
    assertNull(actualNLocalResult.getOp());
    assertNull(actualNLocalResult.getOp1());
    assertNull(actualNLocalResult.getOp2());
    assertNull(actualNLocalResult.getOps());
    assertEquals(1, actualNLocalResult._ls_index);
    assertEquals(ET.E0, actualNLocalResult.et);
    assertEquals(VT.LOCAL, actualNLocalResult.vt);
  }

  /**
   * Test {@link Exprs#nLocal(int, String)} with {@code index}, {@code debugName}.
   *
   * <p>Method under test: {@link Exprs#nLocal(int, String)}
   */
  @Test
  @DisplayName("Test nLocal(int, String) with 'index', 'debugName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Local Exprs.nLocal(int, String)"})
  void testNLocalWithIndexDebugName() {
    // Arrange and Act
    Local actualNLocalResult = Exprs.nLocal(1, "Debug Name");

    // Assert
    assertEquals("Debug Name", actualNLocalResult.debugName);
    assertEquals("Debug Name_1", actualNLocalResult.toString0());
    assertNull(actualNLocalResult.tag);
    assertNull(actualNLocalResult.signature);
    assertNull(actualNLocalResult.valueType);
    assertNull(actualNLocalResult.getOp());
    assertNull(actualNLocalResult.getOp1());
    assertNull(actualNLocalResult.getOp2());
    assertNull(actualNLocalResult.getOps());
    assertEquals(1, actualNLocalResult._ls_index);
    assertEquals(ET.E0, actualNLocalResult.et);
    assertEquals(VT.LOCAL, actualNLocalResult.vt);
  }

  /**
   * Test {@link Exprs#nLt(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nLt(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nLt(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nLt(Value, Value, String)"})
  void testNLt() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNLtResult = Exprs.nLt(a, b, "Type");

    // Assert
    Value op1 = actualNLtResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNLtResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] < null[null])", actualNLtResult.toString0());
    assertEquals("Type", actualNLtResult.type);
    assertNull(actualNLtResult.tag);
    assertNull(actualNLtResult.valueType);
    assertNull(actualNLtResult.getOp());
    assertNull(actualNLtResult.getOps());
    assertEquals(ET.E2, actualNLtResult.et);
    assertEquals(VT.LT, actualNLtResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nMul(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nMul(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nMul(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nMul(Value, Value, String)"})
  void testNMul() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNMulResult = Exprs.nMul(a, b, "Type");

    // Assert
    Value op1 = actualNMulResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNMulResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] * null[null])", actualNMulResult.toString0());
    assertEquals("Type", actualNMulResult.type);
    assertNull(actualNMulResult.tag);
    assertNull(actualNMulResult.valueType);
    assertNull(actualNMulResult.getOp());
    assertNull(actualNMulResult.getOps());
    assertEquals(ET.E2, actualNMulResult.et);
    assertEquals(VT.MUL, actualNMulResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nNe(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nNe(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nNe(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nNe(Value, Value, String)"})
  void testNNe() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNNeResult = Exprs.nNe(a, b, "Type");

    // Assert
    Value op1 = actualNNeResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNNeResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] != null[null])", actualNNeResult.toString0());
    assertEquals("Type", actualNNeResult.type);
    assertNull(actualNNeResult.tag);
    assertNull(actualNNeResult.valueType);
    assertNull(actualNNeResult.getOp());
    assertNull(actualNNeResult.getOps());
    assertEquals(ET.E2, actualNNeResult.et);
    assertEquals(VT.NE, actualNNeResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nNeg(Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nNeg(Value, String)}
   */
  @Test
  @DisplayName("Test nNeg(Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnopExpr Exprs.nNeg(Value, String)"})
  void testNNeg() {
    // Arrange
    ArrayExpr array = new ArrayExpr();

    // Act
    UnopExpr actualNNegResult = Exprs.nNeg(array, "Type");

    // Assert
    Value op = actualNNegResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("(-null[null])", actualNNegResult.toString0());
    assertEquals("Type", actualNNegResult.type);
    assertNull(actualNNegResult.tag);
    assertNull(actualNNegResult.valueType);
    assertNull(actualNNegResult.getOp1());
    assertNull(actualNNegResult.getOp2());
    assertNull(actualNNegResult.getOps());
    assertEquals(ET.E1, actualNNegResult.et);
    assertEquals(VT.NEG, actualNNegResult.vt);
    assertSame(array, op);
  }

  /**
   * Test {@link Exprs#nNew(String)}.
   *
   * <p>Method under test: {@link Exprs#nNew(String)}
   */
  @Test
  @DisplayName("Test nNew(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NewExpr Exprs.nNew(String)"})
  void testNNew() {
    // Arrange and Act
    NewExpr actualNNewResult = Exprs.nNew("Type");

    // Assert
    assertEquals("Type", actualNNewResult.type);
    assertNull(actualNNewResult.tag);
    assertNull(actualNNewResult.valueType);
    assertNull(actualNNewResult.getOp());
    assertNull(actualNNewResult.getOp1());
    assertNull(actualNNewResult.getOp2());
    assertNull(actualNNewResult.getOps());
    assertEquals(ET.E0, actualNNewResult.et);
    assertEquals(VT.NEW, actualNNewResult.vt);
  }

  /**
   * Test {@link Exprs#nNewArray(String, Value)}.
   *
   * <p>Method under test: {@link Exprs#nNewArray(String, Value)}
   */
  @Test
  @DisplayName("Test nNewArray(String, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeExpr Exprs.nNewArray(String, Value)"})
  void testNNewArray() {
    // Arrange
    ArrayExpr size = new ArrayExpr();

    // Act
    TypeExpr actualNNewArrayResult = Exprs.nNewArray("Element Type", size);

    // Assert
    Value op = actualNNewArrayResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("Element Type", actualNNewArrayResult.type);
    assertNull(actualNNewArrayResult.tag);
    assertNull(actualNNewArrayResult.valueType);
    assertNull(actualNNewArrayResult.getOp1());
    assertNull(actualNNewArrayResult.getOp2());
    assertNull(actualNNewArrayResult.getOps());
    assertEquals(ET.E1, actualNNewArrayResult.et);
    assertEquals(VT.NEW_ARRAY, actualNNewArrayResult.vt);
    assertSame(size, op);
  }

  /**
   * Test {@link Exprs#nNewIntArray(Value)}.
   *
   * <p>Method under test: {@link Exprs#nNewIntArray(Value)}
   */
  @Test
  @DisplayName("Test nNewIntArray(Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeExpr Exprs.nNewIntArray(Value)"})
  void testNNewIntArray() {
    // Arrange
    ArrayExpr size = new ArrayExpr();

    // Act
    TypeExpr actualNNewIntArrayResult = Exprs.nNewIntArray(size);

    // Assert
    Value op = actualNNewIntArrayResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("I", actualNNewIntArrayResult.type);
    assertNull(actualNNewIntArrayResult.tag);
    assertNull(actualNNewIntArrayResult.valueType);
    assertNull(actualNNewIntArrayResult.getOp1());
    assertNull(actualNNewIntArrayResult.getOp2());
    assertNull(actualNNewIntArrayResult.getOps());
    assertEquals(ET.E1, actualNNewIntArrayResult.et);
    assertEquals(VT.NEW_ARRAY, actualNNewIntArrayResult.vt);
    assertSame(size, op);
  }

  /**
   * Test {@link Exprs#nNewLongArray(Value)}.
   *
   * <p>Method under test: {@link Exprs#nNewLongArray(Value)}
   */
  @Test
  @DisplayName("Test nNewLongArray(Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeExpr Exprs.nNewLongArray(Value)"})
  void testNNewLongArray() {
    // Arrange
    ArrayExpr size = new ArrayExpr();

    // Act
    TypeExpr actualNNewLongArrayResult = Exprs.nNewLongArray(size);

    // Assert
    Value op = actualNNewLongArrayResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("J", actualNNewLongArrayResult.type);
    assertNull(actualNNewLongArrayResult.tag);
    assertNull(actualNNewLongArrayResult.valueType);
    assertNull(actualNNewLongArrayResult.getOp1());
    assertNull(actualNNewLongArrayResult.getOp2());
    assertNull(actualNNewLongArrayResult.getOps());
    assertEquals(ET.E1, actualNNewLongArrayResult.et);
    assertEquals(VT.NEW_ARRAY, actualNNewLongArrayResult.vt);
    assertSame(size, op);
  }

  /**
   * Test {@link Exprs#nFilledArray(String, Value[])}.
   *
   * <p>Method under test: {@link Exprs#nFilledArray(String, Value[])}
   */
  @Test
  @DisplayName("Test nFilledArray(String, Value[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FilledArrayExpr Exprs.nFilledArray(String, Value[])"})
  void testNFilledArray() {
    // Arrange
    Value[] datas = new Value[] {new ArrayExpr()};

    // Act
    FilledArrayExpr actualNFilledArrayResult = Exprs.nFilledArray("Element Type", datas);

    // Assert
    assertEquals("Element Type", actualNFilledArrayResult.type);
    assertNull(actualNFilledArrayResult.tag);
    assertNull(actualNFilledArrayResult.valueType);
    assertNull(actualNFilledArrayResult.getOp());
    assertNull(actualNFilledArrayResult.getOp1());
    assertNull(actualNFilledArrayResult.getOp2());
    assertEquals(ET.En, actualNFilledArrayResult.et);
    assertEquals(VT.FILLED_ARRAY, actualNFilledArrayResult.vt);
    assertSame(datas, actualNFilledArrayResult.getOps());
  }

  /**
   * Test {@link Exprs#nNewMutiArray(String, int, Value[])}.
   *
   * <p>Method under test: {@link Exprs#nNewMutiArray(String, int, Value[])}
   */
  @Test
  @DisplayName("Test nNewMutiArray(String, int, Value[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NewMutiArrayExpr Exprs.nNewMutiArray(String, int, Value[])"})
  void testNNewMutiArray() {
    // Arrange
    Value[] sizes = new Value[] {new ArrayExpr()};

    // Act
    NewMutiArrayExpr actualNNewMutiArrayResult = Exprs.nNewMutiArray("Base", 1, sizes);

    // Assert
    assertEquals("Base", actualNNewMutiArrayResult.baseType);
    assertEquals("new byte[null[null]]", actualNNewMutiArrayResult.toString0());
    assertNull(actualNNewMutiArrayResult.tag);
    assertNull(actualNNewMutiArrayResult.valueType);
    assertNull(actualNNewMutiArrayResult.getOp());
    assertNull(actualNNewMutiArrayResult.getOp1());
    assertNull(actualNNewMutiArrayResult.getOp2());
    assertEquals(1, actualNNewMutiArrayResult.dimension);
    assertEquals(ET.En, actualNNewMutiArrayResult.et);
    assertEquals(VT.NEW_MULTI_ARRAY, actualNNewMutiArrayResult.vt);
    assertSame(sizes, actualNNewMutiArrayResult.getOps());
  }

  /**
   * Test {@link Exprs#nNot(Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nNot(Value, String)}
   */
  @Test
  @DisplayName("Test nNot(Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnopExpr Exprs.nNot(Value, String)"})
  void testNNot() {
    // Arrange
    ArrayExpr array = new ArrayExpr();

    // Act
    UnopExpr actualNNotResult = Exprs.nNot(array, "Type");

    // Assert
    Value op = actualNNotResult.getOp();
    assertTrue(op instanceof ArrayExpr);
    assertEquals("(!null[null])", actualNNotResult.toString0());
    assertEquals("Type", actualNNotResult.type);
    assertNull(actualNNotResult.tag);
    assertNull(actualNNotResult.valueType);
    assertNull(actualNNotResult.getOp1());
    assertNull(actualNNotResult.getOp2());
    assertNull(actualNNotResult.getOps());
    assertEquals(ET.E1, actualNNotResult.et);
    assertEquals(VT.NOT, actualNNotResult.vt);
    assertSame(array, op);
  }

  /**
   * Test {@link Exprs#nOr(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nOr(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nOr(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nOr(Value, Value, String)"})
  void testNOr() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNOrResult = Exprs.nOr(a, b, "Type");

    // Assert
    Value op1 = actualNOrResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNOrResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] | null[null])", actualNOrResult.toString0());
    assertEquals("Type", actualNOrResult.type);
    assertNull(actualNOrResult.tag);
    assertNull(actualNOrResult.valueType);
    assertNull(actualNOrResult.getOp());
    assertNull(actualNOrResult.getOps());
    assertEquals(ET.E2, actualNOrResult.et);
    assertEquals(VT.OR, actualNOrResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nParameterRef(String, int)}.
   *
   * <p>Method under test: {@link Exprs#nParameterRef(String, int)}
   */
  @Test
  @DisplayName("Test nParameterRef(String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RefExpr Exprs.nParameterRef(String, int)"})
  void testNParameterRef() {
    // Arrange and Act
    RefExpr actualNParameterRefResult = Exprs.nParameterRef("Type", 1);

    // Assert
    assertEquals("@parameter_1", actualNParameterRefResult.toString0());
    assertEquals("Type", actualNParameterRefResult.type);
    assertNull(actualNParameterRefResult.tag);
    assertNull(actualNParameterRefResult.valueType);
    assertNull(actualNParameterRefResult.getOp());
    assertNull(actualNParameterRefResult.getOp1());
    assertNull(actualNParameterRefResult.getOp2());
    assertNull(actualNParameterRefResult.getOps());
    assertEquals(1, actualNParameterRefResult.parameterIndex);
    assertEquals(ET.E0, actualNParameterRefResult.et);
    assertEquals(VT.PARAMETER_REF, actualNParameterRefResult.vt);
  }

  /**
   * Test {@link Exprs#nRem(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nRem(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nRem(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nRem(Value, Value, String)"})
  void testNRem() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNRemResult = Exprs.nRem(a, b, "Type");

    // Assert
    Value op1 = actualNRemResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNRemResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] % null[null])", actualNRemResult.toString0());
    assertEquals("Type", actualNRemResult.type);
    assertNull(actualNRemResult.tag);
    assertNull(actualNRemResult.valueType);
    assertNull(actualNRemResult.getOp());
    assertNull(actualNRemResult.getOps());
    assertEquals(ET.E2, actualNRemResult.et);
    assertEquals(VT.REM, actualNRemResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nShl(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nShl(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nShl(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nShl(Value, Value, String)"})
  void testNShl() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNShlResult = Exprs.nShl(a, b, "Type");

    // Assert
    Value op1 = actualNShlResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNShlResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] << null[null])", actualNShlResult.toString0());
    assertEquals("Type", actualNShlResult.type);
    assertNull(actualNShlResult.tag);
    assertNull(actualNShlResult.valueType);
    assertNull(actualNShlResult.getOp());
    assertNull(actualNShlResult.getOps());
    assertEquals(ET.E2, actualNShlResult.et);
    assertEquals(VT.SHL, actualNShlResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nShr(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nShr(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nShr(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nShr(Value, Value, String)"})
  void testNShr() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNShrResult = Exprs.nShr(a, b, "Type");

    // Assert
    Value op1 = actualNShrResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNShrResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] >> null[null])", actualNShrResult.toString0());
    assertEquals("Type", actualNShrResult.type);
    assertNull(actualNShrResult.tag);
    assertNull(actualNShrResult.valueType);
    assertNull(actualNShrResult.getOp());
    assertNull(actualNShrResult.getOps());
    assertEquals(ET.E2, actualNShrResult.et);
    assertEquals(VT.SHR, actualNShrResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nStaticField(String, String, String)}.
   *
   * <p>Method under test: {@link Exprs#nStaticField(String, String, String)}
   */
  @Test
  @DisplayName("Test nStaticField(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StaticFieldExpr Exprs.nStaticField(String, String, String)"})
  void testNStaticField() {
    // Arrange and Act
    StaticFieldExpr actualNStaticFieldResult =
        Exprs.nStaticField("Owner Type", "Field Name", "Field Type");

    // Assert
    assertEquals("Field Name", actualNStaticFieldResult.name);
    assertEquals("Field Type", actualNStaticFieldResult.type);
    assertEquals("Owner Type", actualNStaticFieldResult.owner);
    assertNull(actualNStaticFieldResult.tag);
    assertNull(actualNStaticFieldResult.valueType);
    assertNull(actualNStaticFieldResult.getOp());
    assertNull(actualNStaticFieldResult.getOp1());
    assertNull(actualNStaticFieldResult.getOp2());
    assertNull(actualNStaticFieldResult.getOps());
    assertEquals(ET.E0, actualNStaticFieldResult.et);
    assertEquals(VT.STATIC_FIELD, actualNStaticFieldResult.vt);
  }

  /**
   * Test {@link Exprs#nSub(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nSub(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nSub(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nSub(Value, Value, String)"})
  void testNSub() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNSubResult = Exprs.nSub(a, b, "Type");

    // Assert
    Value op1 = actualNSubResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNSubResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] - null[null])", actualNSubResult.toString0());
    assertEquals("Type", actualNSubResult.type);
    assertNull(actualNSubResult.tag);
    assertNull(actualNSubResult.valueType);
    assertNull(actualNSubResult.getOp());
    assertNull(actualNSubResult.getOps());
    assertEquals(ET.E2, actualNSubResult.et);
    assertEquals(VT.SUB, actualNSubResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nThisRef(String)}.
   *
   * <p>Method under test: {@link Exprs#nThisRef(String)}
   */
  @Test
  @DisplayName("Test nThisRef(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RefExpr Exprs.nThisRef(String)"})
  void testNThisRef() {
    // Arrange and Act
    RefExpr actualNThisRefResult = Exprs.nThisRef("Type");

    // Assert
    assertEquals("@this", actualNThisRefResult.toString0());
    assertEquals("Type", actualNThisRefResult.type);
    assertNull(actualNThisRefResult.tag);
    assertNull(actualNThisRefResult.valueType);
    assertNull(actualNThisRefResult.getOp());
    assertNull(actualNThisRefResult.getOp1());
    assertNull(actualNThisRefResult.getOp2());
    assertNull(actualNThisRefResult.getOps());
    assertEquals(-1, actualNThisRefResult.parameterIndex);
    assertEquals(ET.E0, actualNThisRefResult.et);
    assertEquals(VT.THIS_REF, actualNThisRefResult.vt);
  }

  /**
   * Test {@link Exprs#nUshr(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nUshr(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nUshr(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nUshr(Value, Value, String)"})
  void testNUshr() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNUshrResult = Exprs.nUshr(a, b, "Type");

    // Assert
    Value op1 = actualNUshrResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNUshrResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] >>> null[null])", actualNUshrResult.toString0());
    assertEquals("Type", actualNUshrResult.type);
    assertNull(actualNUshrResult.tag);
    assertNull(actualNUshrResult.valueType);
    assertNull(actualNUshrResult.getOp());
    assertNull(actualNUshrResult.getOps());
    assertEquals(ET.E2, actualNUshrResult.et);
    assertEquals(VT.USHR, actualNUshrResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nXor(Value, Value, String)}.
   *
   * <p>Method under test: {@link Exprs#nXor(Value, Value, String)}
   */
  @Test
  @DisplayName("Test nXor(Value, Value, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BinopExpr Exprs.nXor(Value, Value, String)"})
  void testNXor() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNXorResult = Exprs.nXor(a, b, "Type");

    // Assert
    Value op1 = actualNXorResult.getOp1();
    assertTrue(op1 instanceof ArrayExpr);
    Value op2 = actualNXorResult.getOp2();
    assertTrue(op2 instanceof ArrayExpr);
    assertEquals("(null[null] ^ null[null])", actualNXorResult.toString0());
    assertEquals("Type", actualNXorResult.type);
    assertNull(actualNXorResult.tag);
    assertNull(actualNXorResult.valueType);
    assertNull(actualNXorResult.getOp());
    assertNull(actualNXorResult.getOps());
    assertEquals(ET.E2, actualNXorResult.et);
    assertEquals(VT.XOR, actualNXorResult.vt);
    assertSame(a, op1);
    assertSame(b, op2);
  }

  /**
   * Test {@link Exprs#nPhi(Value[])}.
   *
   * <p>Method under test: {@link Exprs#nPhi(Value[])}
   */
  @Test
  @DisplayName("Test nPhi(Value[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhiExpr Exprs.nPhi(Value[])"})
  void testNPhi() {
    // Arrange
    Value[] ops = new Value[] {new ArrayExpr()};

    // Act
    PhiExpr actualNPhiResult = Exprs.nPhi(ops);

    // Assert
    assertEquals("φ(null[null])", actualNPhiResult.toString0());
    assertNull(actualNPhiResult.tag);
    assertNull(actualNPhiResult.valueType);
    assertNull(actualNPhiResult.getOp());
    assertNull(actualNPhiResult.getOp1());
    assertNull(actualNPhiResult.getOp2());
    assertEquals(ET.En, actualNPhiResult.et);
    assertEquals(VT.PHI, actualNPhiResult.vt);
    assertSame(ops, actualNPhiResult.getOps());
  }

  /**
   * Test {@link Exprs#nConstant(Object)}.
   *
   * <p>Method under test: {@link Exprs#nConstant(Object)}
   */
  @Test
  @DisplayName("Test nConstant(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Constant Exprs.nConstant(Object)"})
  void testNConstant() {
    // Arrange and Act
    Constant actualNConstantResult = Exprs.nConstant(Constant.Null);

    // Assert
    assertNull(actualNConstantResult.tag);
    assertNull(actualNConstantResult.valueType);
    assertNull(actualNConstantResult.getOp());
    assertNull(actualNConstantResult.getOp1());
    assertNull(actualNConstantResult.getOp2());
    assertNull(actualNConstantResult.getOps());
    assertEquals(ET.E0, actualNConstantResult.et);
    assertEquals(VT.CONSTANT, actualNConstantResult.vt);
  }
}
