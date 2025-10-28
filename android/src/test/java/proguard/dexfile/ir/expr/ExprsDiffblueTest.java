package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.reader.DexType;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Proto;

public class ExprsDiffblueTest {
  /**
   * Method under test: {@link Exprs#copy(Value[])}
   */
  @Test
  public void testCopy() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();

    // Act
    Value[] actualCopyResult = Exprs.copy(new Value[]{arrayExpr});

    // Assert
    assertEquals(1, actualCopyResult.length);
    assertSame(arrayExpr, actualCopyResult[0]);
  }

  /**
   * Method under test: {@link Exprs#copy(Value[])}
   */
  @Test
  public void testCopy2() {
    // Arrange, Act and Assert
    assertEquals(0, Exprs.copy(null).length);
  }

  /**
   * Method under test: {@link Exprs#nByte(byte)}
   */
  @Test
  public void testNByte() {
    // Arrange and Act
    Constant actualNByteResult = Exprs.nByte((byte) 'A');

    // Assert
    assertNull(actualNByteResult.getOps());
    assertNull(actualNByteResult.tag);
    assertNull(actualNByteResult.valueType);
    assertNull(actualNByteResult.getOp());
    assertNull(actualNByteResult.getOp1());
    assertNull(actualNByteResult.getOp2());
    assertEquals(ET.E0, actualNByteResult.et);
    assertEquals(Value.VT.CONSTANT, actualNByteResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nChar(char)}
   */
  @Test
  public void testNChar() {
    // Arrange and Act
    Constant actualNCharResult = Exprs.nChar('A');

    // Assert
    assertNull(actualNCharResult.getOps());
    assertNull(actualNCharResult.tag);
    assertNull(actualNCharResult.valueType);
    assertNull(actualNCharResult.getOp());
    assertNull(actualNCharResult.getOp1());
    assertNull(actualNCharResult.getOp2());
    assertEquals(ET.E0, actualNCharResult.et);
    assertEquals(Value.VT.CONSTANT, actualNCharResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nType(String)}
   */
  @Test
  public void testNType() {
    // Arrange and Act
    Constant actualNTypeResult = Exprs.nType("The characteristics of someone or something");

    // Assert
    Object object = actualNTypeResult.value;
    assertTrue(object instanceof DexType);
    assertEquals("The characteristics of someone or something", object.toString());
    assertNull(actualNTypeResult.getOps());
    assertNull(actualNTypeResult.tag);
    assertNull(actualNTypeResult.valueType);
    assertNull(actualNTypeResult.getOp());
    assertNull(actualNTypeResult.getOp1());
    assertNull(actualNTypeResult.getOp2());
    assertEquals(ET.E0, actualNTypeResult.et);
    assertEquals(Value.VT.CONSTANT, actualNTypeResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nType(DexType)}
   */
  @Test
  public void testNType2() {
    // Arrange and Act
    Constant actualNTypeResult = Exprs.nType(new DexType("The characteristics of someone or something"));

    // Assert
    Object object = actualNTypeResult.value;
    assertTrue(object instanceof DexType);
    assertEquals("The characteristics of someone or something", object.toString());
    assertNull(actualNTypeResult.getOps());
    assertNull(actualNTypeResult.tag);
    assertNull(actualNTypeResult.valueType);
    assertNull(actualNTypeResult.getOp());
    assertNull(actualNTypeResult.getOp1());
    assertNull(actualNTypeResult.getOp2());
    assertEquals(ET.E0, actualNTypeResult.et);
    assertEquals(Value.VT.CONSTANT, actualNTypeResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nDouble(double)}
   */
  @Test
  public void testNDouble() {
    // Arrange and Act
    Constant actualNDoubleResult = Exprs.nDouble(10.0d);

    // Assert
    assertNull(actualNDoubleResult.getOps());
    assertNull(actualNDoubleResult.tag);
    assertNull(actualNDoubleResult.valueType);
    assertNull(actualNDoubleResult.getOp());
    assertNull(actualNDoubleResult.getOp1());
    assertNull(actualNDoubleResult.getOp2());
    assertEquals(10.0d, ((Double) actualNDoubleResult.value).doubleValue(), 0.0);
    assertEquals(ET.E0, actualNDoubleResult.et);
    assertEquals(Value.VT.CONSTANT, actualNDoubleResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nFloat(float)}
   */
  @Test
  public void testNFloat() {
    // Arrange and Act
    Constant actualNFloatResult = Exprs.nFloat(10.0f);

    // Assert
    assertNull(actualNFloatResult.getOps());
    assertNull(actualNFloatResult.tag);
    assertNull(actualNFloatResult.valueType);
    assertNull(actualNFloatResult.getOp());
    assertNull(actualNFloatResult.getOp1());
    assertNull(actualNFloatResult.getOp2());
    assertEquals(10.0f, ((Float) actualNFloatResult.value).floatValue(), 0.0f);
    assertEquals(ET.E0, actualNFloatResult.et);
    assertEquals(Value.VT.CONSTANT, actualNFloatResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nInt(int)}
   */
  @Test
  public void testNInt() {
    // Arrange and Act
    Constant actualNIntResult = Exprs.nInt(1);

    // Assert
    assertNull(actualNIntResult.getOps());
    assertNull(actualNIntResult.tag);
    assertNull(actualNIntResult.valueType);
    assertNull(actualNIntResult.getOp());
    assertNull(actualNIntResult.getOp1());
    assertNull(actualNIntResult.getOp2());
    assertEquals(ET.E0, actualNIntResult.et);
    assertEquals(Value.VT.CONSTANT, actualNIntResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nLong(long)}
   */
  @Test
  public void testNLong() {
    // Arrange and Act
    Constant actualNLongResult = Exprs.nLong(1L);

    // Assert
    assertNull(actualNLongResult.getOps());
    assertNull(actualNLongResult.tag);
    assertNull(actualNLongResult.valueType);
    assertNull(actualNLongResult.getOp());
    assertNull(actualNLongResult.getOp1());
    assertNull(actualNLongResult.getOp2());
    assertEquals(ET.E0, actualNLongResult.et);
    assertEquals(Value.VT.CONSTANT, actualNLongResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nNull()}
   */
  @Test
  public void testNNull() {
    // Arrange and Act
    Constant actualNNullResult = Exprs.nNull();

    // Assert
    assertNull(actualNNullResult.getOps());
    assertNull(actualNNullResult.tag);
    assertNull(actualNNullResult.valueType);
    assertNull(actualNNullResult.getOp());
    assertNull(actualNNullResult.getOp1());
    assertNull(actualNNullResult.getOp2());
    assertEquals(ET.E0, actualNNullResult.et);
    assertEquals(Value.VT.CONSTANT, actualNNullResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nShort(short)}
   */
  @Test
  public void testNShort() {
    // Arrange and Act
    Constant actualNShortResult = Exprs.nShort((short) 1);

    // Assert
    assertNull(actualNShortResult.getOps());
    assertNull(actualNShortResult.tag);
    assertNull(actualNShortResult.valueType);
    assertNull(actualNShortResult.getOp());
    assertNull(actualNShortResult.getOp1());
    assertNull(actualNShortResult.getOp2());
    assertEquals(ET.E0, actualNShortResult.et);
    assertEquals(Value.VT.CONSTANT, actualNShortResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nString(String)}
   */
  @Test
  public void testNString() {
    // Arrange and Act
    Constant actualNStringResult = Exprs.nString("foo");

    // Assert
    assertEquals("foo", actualNStringResult.value);
    assertNull(actualNStringResult.getOps());
    assertNull(actualNStringResult.tag);
    assertNull(actualNStringResult.valueType);
    assertNull(actualNStringResult.getOp());
    assertNull(actualNStringResult.getOp1());
    assertNull(actualNStringResult.getOp2());
    assertEquals(ET.E0, actualNStringResult.et);
    assertEquals(Value.VT.CONSTANT, actualNStringResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nAdd(Value, Value, String)}
   */
  @Test
  public void testNAdd() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNAddResult = Exprs.nAdd(a, b, "Type");

    // Assert
    assertEquals("(null[null] + null[null])", actualNAddResult.toString0());
    assertEquals("Type", actualNAddResult.type);
    assertNull(actualNAddResult.getOps());
    assertNull(actualNAddResult.tag);
    assertNull(actualNAddResult.valueType);
    assertNull(actualNAddResult.getOp());
    assertEquals(ET.E2, actualNAddResult.et);
    assertEquals(Value.VT.ADD, actualNAddResult.vt);
    assertSame(a, actualNAddResult.getOp1());
    assertSame(b, actualNAddResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#niAdd(Value, Value)}
   */
  @Test
  public void testNiAdd() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNiAddResult = Exprs.niAdd(a, b);

    // Assert
    assertEquals("(null[null] + null[null])", actualNiAddResult.toString0());
    assertEquals("I", actualNiAddResult.type);
    assertNull(actualNiAddResult.getOps());
    assertNull(actualNiAddResult.tag);
    assertNull(actualNiAddResult.valueType);
    assertNull(actualNiAddResult.getOp());
    assertEquals(ET.E2, actualNiAddResult.et);
    assertEquals(Value.VT.ADD, actualNiAddResult.vt);
    assertSame(a, actualNiAddResult.getOp1());
    assertSame(b, actualNiAddResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nAnd(Value, Value, String)}
   */
  @Test
  public void testNAnd() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNAndResult = Exprs.nAnd(a, b, "Type");

    // Assert
    assertEquals("(null[null] & null[null])", actualNAndResult.toString0());
    assertEquals("Type", actualNAndResult.type);
    assertNull(actualNAndResult.getOps());
    assertNull(actualNAndResult.tag);
    assertNull(actualNAndResult.valueType);
    assertNull(actualNAndResult.getOp());
    assertEquals(ET.E2, actualNAndResult.et);
    assertEquals(Value.VT.AND, actualNAndResult.vt);
    assertSame(a, actualNAndResult.getOp1());
    assertSame(b, actualNAndResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nArray(Value, Value, String)}
   */
  @Test
  public void testNArray() {
    // Arrange
    ArrayExpr base = new ArrayExpr();
    ArrayExpr index = new ArrayExpr();

    // Act
    ArrayExpr actualNArrayResult = Exprs.nArray(base, index, "Element Type");

    // Assert
    assertEquals("Element Type", actualNArrayResult.elementType);
    assertEquals("null[null][null[null]]", actualNArrayResult.toString0());
    assertNull(actualNArrayResult.getOps());
    assertNull(actualNArrayResult.tag);
    assertNull(actualNArrayResult.valueType);
    assertNull(actualNArrayResult.getOp());
    assertEquals(ET.E2, actualNArrayResult.et);
    assertEquals(Value.VT.ARRAY, actualNArrayResult.vt);
    assertSame(base, actualNArrayResult.getOp1());
    assertSame(index, actualNArrayResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nArrayValue(Object)}
   */
  @Test
  public void testNArrayValue() {
    // Arrange and Act
    Constant actualNArrayValueResult = Exprs.nArrayValue(Constant.Null);

    // Assert
    assertNull(actualNArrayValueResult.getOps());
    assertNull(actualNArrayValueResult.tag);
    assertNull(actualNArrayValueResult.valueType);
    assertNull(actualNArrayValueResult.getOp());
    assertNull(actualNArrayValueResult.getOp1());
    assertNull(actualNArrayValueResult.getOp2());
    assertEquals(ET.E0, actualNArrayValueResult.et);
    assertEquals(Value.VT.CONSTANT, actualNArrayValueResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nCast(Value, String, String)}
   */
  @Test
  public void testNCast() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();

    // Act
    CastExpr actualNCastResult = Exprs.nCast(obj, "jane.doe@example.org", "alice.liddell@example.org");

    // Assert
    assertEquals("alice.liddell@example.org", actualNCastResult.to);
    assertEquals("jane.doe@example.org", actualNCastResult.from);
    assertNull(actualNCastResult.getOps());
    assertNull(actualNCastResult.tag);
    assertNull(actualNCastResult.valueType);
    assertNull(actualNCastResult.getOp1());
    assertNull(actualNCastResult.getOp2());
    assertEquals(ET.E1, actualNCastResult.et);
    assertEquals(Value.VT.CAST, actualNCastResult.vt);
    assertSame(obj, actualNCastResult.getOp());
  }

  /**
   * Method under test: {@link Exprs#nCheckCast(Value, String)}
   */
  @Test
  public void testNCheckCast() {
    // Arrange
    ArrayExpr obj = new ArrayExpr();

    // Act
    TypeExpr actualNCheckCastResult = Exprs.nCheckCast(obj, "Type");

    // Assert
    assertEquals("Type", actualNCheckCastResult.type);
    assertNull(actualNCheckCastResult.getOps());
    assertNull(actualNCheckCastResult.tag);
    assertNull(actualNCheckCastResult.valueType);
    assertNull(actualNCheckCastResult.getOp1());
    assertNull(actualNCheckCastResult.getOp2());
    assertEquals(ET.E1, actualNCheckCastResult.et);
    assertEquals(Value.VT.CHECK_CAST, actualNCheckCastResult.vt);
    assertSame(obj, actualNCheckCastResult.getOp());
  }

  /**
   * Method under test: {@link Exprs#nDCmpg(Value, Value)}
   */
  @Test
  public void testNDCmpg() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDCmpgResult = Exprs.nDCmpg(a, b);

    // Assert
    assertEquals("(null[null] DCMPG null[null])", actualNDCmpgResult.toString0());
    assertEquals("D", actualNDCmpgResult.type);
    assertNull(actualNDCmpgResult.getOps());
    assertNull(actualNDCmpgResult.tag);
    assertNull(actualNDCmpgResult.valueType);
    assertNull(actualNDCmpgResult.getOp());
    assertEquals(ET.E2, actualNDCmpgResult.et);
    assertEquals(Value.VT.DCMPG, actualNDCmpgResult.vt);
    assertSame(a, actualNDCmpgResult.getOp1());
    assertSame(b, actualNDCmpgResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nDCmpl(Value, Value)}
   */
  @Test
  public void testNDCmpl() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDCmplResult = Exprs.nDCmpl(a, b);

    // Assert
    assertEquals("(null[null] DCMPL null[null])", actualNDCmplResult.toString0());
    assertEquals("D", actualNDCmplResult.type);
    assertNull(actualNDCmplResult.getOps());
    assertNull(actualNDCmplResult.tag);
    assertNull(actualNDCmplResult.valueType);
    assertNull(actualNDCmplResult.getOp());
    assertEquals(ET.E2, actualNDCmplResult.et);
    assertEquals(Value.VT.DCMPL, actualNDCmplResult.vt);
    assertSame(a, actualNDCmplResult.getOp1());
    assertSame(b, actualNDCmplResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nDiv(Value, Value, String)}
   */
  @Test
  public void testNDiv() {
    // Arrange
    ArrayExpr a = new ArrayExpr();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> Exprs.nDiv(a, new ArrayExpr(), "Type"));
  }

  /**
   * Method under test: {@link Exprs#nDiv(Value, Value, String)}
   */
  @Test
  public void testNDiv2() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDivResult = Exprs.nDiv(a, b, "I");

    // Assert
    assertEquals("(null[null] / null[null])", actualNDivResult.toString0());
    assertEquals("I", actualNDivResult.type);
    assertNull(actualNDivResult.getOps());
    assertNull(actualNDivResult.tag);
    assertNull(actualNDivResult.valueType);
    assertNull(actualNDivResult.getOp());
    assertEquals(ET.E2, actualNDivResult.et);
    assertEquals(Value.VT.IDIV, actualNDivResult.vt);
    assertSame(a, actualNDivResult.getOp1());
    assertSame(b, actualNDivResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nDiv(Value, Value, String)}
   */
  @Test
  public void testNDiv3() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDivResult = Exprs.nDiv(a, b, "J");

    // Assert
    assertEquals("(null[null] / null[null])", actualNDivResult.toString0());
    assertEquals("J", actualNDivResult.type);
    assertNull(actualNDivResult.getOps());
    assertNull(actualNDivResult.tag);
    assertNull(actualNDivResult.valueType);
    assertNull(actualNDivResult.getOp());
    assertEquals(ET.E2, actualNDivResult.et);
    assertEquals(Value.VT.LDIV, actualNDivResult.vt);
    assertSame(a, actualNDivResult.getOp1());
    assertSame(b, actualNDivResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nDiv(Value, Value, String)}
   */
  @Test
  public void testNDiv4() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDivResult = Exprs.nDiv(a, b, "F");

    // Assert
    assertEquals("(null[null] / null[null])", actualNDivResult.toString0());
    assertEquals("F", actualNDivResult.type);
    assertNull(actualNDivResult.getOps());
    assertNull(actualNDivResult.tag);
    assertNull(actualNDivResult.valueType);
    assertNull(actualNDivResult.getOp());
    assertEquals(ET.E2, actualNDivResult.et);
    assertEquals(Value.VT.FDIV, actualNDivResult.vt);
    assertSame(a, actualNDivResult.getOp1());
    assertSame(b, actualNDivResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nDiv(Value, Value, String)}
   */
  @Test
  public void testNDiv5() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNDivResult = Exprs.nDiv(a, b, "D");

    // Assert
    assertEquals("(null[null] / null[null])", actualNDivResult.toString0());
    assertEquals("D", actualNDivResult.type);
    assertNull(actualNDivResult.getOps());
    assertNull(actualNDivResult.tag);
    assertNull(actualNDivResult.valueType);
    assertNull(actualNDivResult.getOp());
    assertEquals(ET.E2, actualNDivResult.et);
    assertEquals(Value.VT.DDIV, actualNDivResult.vt);
    assertSame(a, actualNDivResult.getOp1());
    assertSame(b, actualNDivResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nEq(Value, Value, String)}
   */
  @Test
  public void testNEq() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNEqResult = Exprs.nEq(a, b, "Type");

    // Assert
    assertEquals("(null[null] == null[null])", actualNEqResult.toString0());
    assertEquals("Type", actualNEqResult.type);
    assertNull(actualNEqResult.getOps());
    assertNull(actualNEqResult.tag);
    assertNull(actualNEqResult.valueType);
    assertNull(actualNEqResult.getOp());
    assertEquals(ET.E2, actualNEqResult.et);
    assertEquals(Value.VT.EQ, actualNEqResult.vt);
    assertSame(a, actualNEqResult.getOp1());
    assertSame(b, actualNEqResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#niEq(Value, Value)}
   */
  @Test
  public void testNiEq() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNiEqResult = Exprs.niEq(a, b);

    // Assert
    assertEquals("(null[null] == null[null])", actualNiEqResult.toString0());
    assertEquals("I", actualNiEqResult.type);
    assertNull(actualNiEqResult.getOps());
    assertNull(actualNiEqResult.tag);
    assertNull(actualNiEqResult.valueType);
    assertNull(actualNiEqResult.getOp());
    assertEquals(ET.E2, actualNiEqResult.et);
    assertEquals(Value.VT.EQ, actualNiEqResult.vt);
    assertSame(a, actualNiEqResult.getOp1());
    assertSame(b, actualNiEqResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nExceptionRef(String)}
   */
  @Test
  public void testNExceptionRef() {
    // Arrange and Act
    RefExpr actualNExceptionRefResult = Exprs.nExceptionRef("Type");

    // Assert
    assertEquals("@Exception", actualNExceptionRefResult.toString0());
    assertEquals("Type", actualNExceptionRefResult.type);
    assertNull(actualNExceptionRefResult.getOps());
    assertNull(actualNExceptionRefResult.tag);
    assertNull(actualNExceptionRefResult.valueType);
    assertNull(actualNExceptionRefResult.getOp());
    assertNull(actualNExceptionRefResult.getOp1());
    assertNull(actualNExceptionRefResult.getOp2());
    assertEquals(-1, actualNExceptionRefResult.parameterIndex);
    assertEquals(ET.E0, actualNExceptionRefResult.et);
    assertEquals(Value.VT.EXCEPTION_REF, actualNExceptionRefResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nFCmpg(Value, Value)}
   */
  @Test
  public void testNFCmpg() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNFCmpgResult = Exprs.nFCmpg(a, b);

    // Assert
    assertEquals("(null[null] FCMPG null[null])", actualNFCmpgResult.toString0());
    assertEquals("F", actualNFCmpgResult.type);
    assertNull(actualNFCmpgResult.getOps());
    assertNull(actualNFCmpgResult.tag);
    assertNull(actualNFCmpgResult.valueType);
    assertNull(actualNFCmpgResult.getOp());
    assertEquals(ET.E2, actualNFCmpgResult.et);
    assertEquals(Value.VT.FCMPG, actualNFCmpgResult.vt);
    assertSame(a, actualNFCmpgResult.getOp1());
    assertSame(b, actualNFCmpgResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nFCmpl(Value, Value)}
   */
  @Test
  public void testNFCmpl() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNFCmplResult = Exprs.nFCmpl(a, b);

    // Assert
    assertEquals("(null[null] FCMPL null[null])", actualNFCmplResult.toString0());
    assertEquals("F", actualNFCmplResult.type);
    assertNull(actualNFCmplResult.getOps());
    assertNull(actualNFCmplResult.tag);
    assertNull(actualNFCmplResult.valueType);
    assertNull(actualNFCmplResult.getOp());
    assertEquals(ET.E2, actualNFCmplResult.et);
    assertEquals(Value.VT.FCMPL, actualNFCmplResult.vt);
    assertSame(a, actualNFCmplResult.getOp1());
    assertSame(b, actualNFCmplResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nField(Value, String, String, String)}
   */
  @Test
  public void testNField() {
    // Arrange
    ArrayExpr object = new ArrayExpr();

    // Act
    FieldExpr actualNFieldResult = Exprs.nField(object, "Owner Type", "Field Name", "Field Type");

    // Assert
    assertEquals("Field Name", actualNFieldResult.name);
    assertEquals("Field Type", actualNFieldResult.type);
    assertEquals("Owner Type", actualNFieldResult.owner);
    assertEquals("null[null].Field Name", actualNFieldResult.toString0());
    assertNull(actualNFieldResult.getOps());
    assertNull(actualNFieldResult.tag);
    assertNull(actualNFieldResult.valueType);
    assertNull(actualNFieldResult.getOp1());
    assertNull(actualNFieldResult.getOp2());
    assertEquals(ET.E1, actualNFieldResult.et);
    assertEquals(Value.VT.FIELD, actualNFieldResult.vt);
    assertSame(object, actualNFieldResult.getOp());
  }

  /**
   * Method under test: {@link Exprs#nGe(Value, Value, String)}
   */
  @Test
  public void testNGe() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNGeResult = Exprs.nGe(a, b, "Type");

    // Assert
    assertEquals("(null[null] >= null[null])", actualNGeResult.toString0());
    assertEquals("Type", actualNGeResult.type);
    assertNull(actualNGeResult.getOps());
    assertNull(actualNGeResult.tag);
    assertNull(actualNGeResult.valueType);
    assertNull(actualNGeResult.getOp());
    assertEquals(ET.E2, actualNGeResult.et);
    assertEquals(Value.VT.GE, actualNGeResult.vt);
    assertSame(a, actualNGeResult.getOp1());
    assertSame(b, actualNGeResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nGt(Value, Value, String)}
   */
  @Test
  public void testNGt() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNGtResult = Exprs.nGt(a, b, "Type");

    // Assert
    assertEquals("(null[null] > null[null])", actualNGtResult.toString0());
    assertEquals("Type", actualNGtResult.type);
    assertNull(actualNGtResult.getOps());
    assertNull(actualNGtResult.tag);
    assertNull(actualNGtResult.valueType);
    assertNull(actualNGtResult.getOp());
    assertEquals(ET.E2, actualNGtResult.et);
    assertEquals(Value.VT.GT, actualNGtResult.vt);
    assertSame(a, actualNGtResult.getOp1());
    assertSame(b, actualNGtResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#njGt(Value, Value)}
   */
  @Test
  public void testNjGt() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNjGtResult = Exprs.njGt(a, b);

    // Assert
    assertEquals("(null[null] > null[null])", actualNjGtResult.toString0());
    assertEquals("J", actualNjGtResult.type);
    assertNull(actualNjGtResult.getOps());
    assertNull(actualNjGtResult.tag);
    assertNull(actualNjGtResult.valueType);
    assertNull(actualNjGtResult.getOp());
    assertEquals(ET.E2, actualNjGtResult.et);
    assertEquals(Value.VT.GT, actualNjGtResult.vt);
    assertSame(a, actualNjGtResult.getOp1());
    assertSame(b, actualNjGtResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#niGt(Value, Value)}
   */
  @Test
  public void testNiGt() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNiGtResult = Exprs.niGt(a, b);

    // Assert
    assertEquals("(null[null] > null[null])", actualNiGtResult.toString0());
    assertEquals("I", actualNiGtResult.type);
    assertNull(actualNiGtResult.getOps());
    assertNull(actualNiGtResult.tag);
    assertNull(actualNiGtResult.valueType);
    assertNull(actualNiGtResult.getOp());
    assertEquals(ET.E2, actualNiGtResult.et);
    assertEquals(Value.VT.GT, actualNiGtResult.vt);
    assertSame(a, actualNiGtResult.getOp1());
    assertSame(b, actualNiGtResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nInstanceOf(Value, String)}
   */
  @Test
  public void testNInstanceOf() {
    // Arrange
    ArrayExpr value = new ArrayExpr();

    // Act
    TypeExpr actualNInstanceOfResult = Exprs.nInstanceOf(value, "Type");

    // Assert
    assertEquals("Type", actualNInstanceOfResult.type);
    assertNull(actualNInstanceOfResult.getOps());
    assertNull(actualNInstanceOfResult.tag);
    assertNull(actualNInstanceOfResult.valueType);
    assertNull(actualNInstanceOfResult.getOp1());
    assertNull(actualNInstanceOfResult.getOp2());
    assertEquals(ET.E1, actualNInstanceOfResult.et);
    assertEquals(Value.VT.INSTANCE_OF, actualNInstanceOfResult.vt);
    assertSame(value, actualNInstanceOfResult.getOp());
  }

  /**
   * Method under test:
   * {@link Exprs#nInvokeInterface(Value[], String, String, String[], String)}
   */
  @Test
  public void testNInvokeInterface() {
    // Arrange
    Value[] regs = new Value[]{new ArrayExpr()};
    String[] argmentTypes = new String[]{"Argment Types"};

    // Act
    InvokeExpr actualNInvokeInterfaceResult = Exprs.nInvokeInterface(regs, "Owner", "Name", argmentTypes,
        "Return Type");

    // Assert
    Method method = actualNInvokeInterfaceResult.method;
    assertEquals("(Argment Types)Return Type", method.getDesc());
    Proto proto = actualNInvokeInterfaceResult.getProto();
    assertEquals("(Argment Types)Return Type", proto.getDesc());
    assertEquals("Name", actualNInvokeInterfaceResult.getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualNInvokeInterfaceResult.getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualNInvokeInterfaceResult.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto.getReturnType());
    assertEquals("null[null].Name()", actualNInvokeInterfaceResult.toString0());
    assertNull(actualNInvokeInterfaceResult.tag);
    assertNull(actualNInvokeInterfaceResult.valueType);
    assertNull(actualNInvokeInterfaceResult.getOp());
    assertNull(actualNInvokeInterfaceResult.getOp1());
    assertNull(actualNInvokeInterfaceResult.getOp2());
    assertEquals(ET.En, actualNInvokeInterfaceResult.et);
    assertEquals(Value.VT.INVOKE_INTERFACE, actualNInvokeInterfaceResult.vt);
    assertSame(proto, method.getProto());
    String[] args = actualNInvokeInterfaceResult.getArgs();
    assertSame(argmentTypes, args);
    assertSame(argmentTypes, method.getParameterTypes());
    assertSame(argmentTypes, proto.getParameterTypes());
    assertSame(regs, actualNInvokeInterfaceResult.getOps());
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test: {@link Exprs#nInvokeNew(Value[], String[], String)}
   */
  @Test
  public void testNInvokeNew() {
    // Arrange
    Value[] regs = new Value[]{new ArrayExpr()};
    String[] argmentTypes = new String[]{"Argment Types"};

    // Act
    InvokeExpr actualNInvokeNewResult = Exprs.nInvokeNew(regs, argmentTypes, "Owner");

    // Assert
    assertTrue(actualNInvokeNewResult instanceof InvokeNewExpr);
    Method method = ((InvokeNewExpr) actualNInvokeNewResult).method;
    assertEquals("(Argment Types)Owner", method.getDesc());
    Proto proto = actualNInvokeNewResult.getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    assertEquals("<init>", actualNInvokeNewResult.getName());
    assertEquals("<init>", method.getName());
    assertEquals("Owner", actualNInvokeNewResult.getOwner());
    assertEquals("Owner", actualNInvokeNewResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualNInvokeNewResult).getClassName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertNull(((InvokeNewExpr) actualNInvokeNewResult).tag);
    assertNull(((InvokeNewExpr) actualNInvokeNewResult).valueType);
    assertNull(actualNInvokeNewResult.getOp());
    assertNull(actualNInvokeNewResult.getOp1());
    assertNull(actualNInvokeNewResult.getOp2());
    assertEquals(ET.En, ((InvokeNewExpr) actualNInvokeNewResult).et);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) actualNInvokeNewResult).vt);
    assertSame(proto, method.getProto());
    String[] args = actualNInvokeNewResult.getArgs();
    assertSame(argmentTypes, args);
    assertSame(argmentTypes, method.getParameterTypes());
    assertSame(argmentTypes, proto.getParameterTypes());
    assertSame(regs, actualNInvokeNewResult.getOps());
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test:
   * {@link Exprs#nInvokeNew(Value[], String[], String, String)}
   */
  @Test
  public void testNInvokeNew2() {
    // Arrange
    Value[] regs = new Value[]{new ArrayExpr()};
    String[] argmentTypes = new String[]{"Argment Types"};

    // Act
    InvokeExpr actualNInvokeNewResult = Exprs.nInvokeNew(regs, argmentTypes, "Owner", "Class Name");

    // Assert
    assertTrue(actualNInvokeNewResult instanceof InvokeNewExpr);
    Method method = ((InvokeNewExpr) actualNInvokeNewResult).method;
    assertEquals("(Argment Types)Owner", method.getDesc());
    Proto proto = actualNInvokeNewResult.getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    assertEquals("<init>", actualNInvokeNewResult.getName());
    assertEquals("<init>", method.getName());
    assertEquals("Class Name", ((InvokeNewExpr) actualNInvokeNewResult).getClassName());
    assertEquals("Owner", actualNInvokeNewResult.getOwner());
    assertEquals("Owner", actualNInvokeNewResult.getRet());
    assertEquals("Owner", method.getOwner());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertNull(((InvokeNewExpr) actualNInvokeNewResult).tag);
    assertNull(((InvokeNewExpr) actualNInvokeNewResult).valueType);
    assertNull(actualNInvokeNewResult.getOp());
    assertNull(actualNInvokeNewResult.getOp1());
    assertNull(actualNInvokeNewResult.getOp2());
    assertEquals(ET.En, ((InvokeNewExpr) actualNInvokeNewResult).et);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) actualNInvokeNewResult).vt);
    assertSame(proto, method.getProto());
    String[] args = actualNInvokeNewResult.getArgs();
    assertSame(argmentTypes, args);
    assertSame(argmentTypes, method.getParameterTypes());
    assertSame(argmentTypes, proto.getParameterTypes());
    assertSame(regs, actualNInvokeNewResult.getOps());
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test:
   * {@link Exprs#nInvokeSpecial(Value[], String, String, String[], String)}
   */
  @Test
  public void testNInvokeSpecial() {
    // Arrange
    Value[] regs = new Value[]{new ArrayExpr()};
    String[] argmentTypes = new String[]{"Argment Types"};

    // Act
    InvokeExpr actualNInvokeSpecialResult = Exprs.nInvokeSpecial(regs, "Owner", "Name", argmentTypes, "Return Type");

    // Assert
    Method method = actualNInvokeSpecialResult.method;
    assertEquals("(Argment Types)Return Type", method.getDesc());
    Proto proto = actualNInvokeSpecialResult.getProto();
    assertEquals("(Argment Types)Return Type", proto.getDesc());
    assertEquals("Name", actualNInvokeSpecialResult.getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualNInvokeSpecialResult.getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualNInvokeSpecialResult.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto.getReturnType());
    assertEquals("null[null].Name()", actualNInvokeSpecialResult.toString0());
    assertNull(actualNInvokeSpecialResult.tag);
    assertNull(actualNInvokeSpecialResult.valueType);
    assertNull(actualNInvokeSpecialResult.getOp());
    assertNull(actualNInvokeSpecialResult.getOp1());
    assertNull(actualNInvokeSpecialResult.getOp2());
    assertEquals(ET.En, actualNInvokeSpecialResult.et);
    assertEquals(Value.VT.INVOKE_SPECIAL, actualNInvokeSpecialResult.vt);
    assertSame(proto, method.getProto());
    String[] args = actualNInvokeSpecialResult.getArgs();
    assertSame(argmentTypes, args);
    assertSame(argmentTypes, method.getParameterTypes());
    assertSame(argmentTypes, proto.getParameterTypes());
    assertSame(regs, actualNInvokeSpecialResult.getOps());
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test:
   * {@link Exprs#nInvokeStatic(Value[], String, String, String[], String)}
   */
  @Test
  public void testNInvokeStatic() {
    // Arrange
    Value[] regs = new Value[]{new ArrayExpr()};
    String[] argmentTypes = new String[]{"Argment Types"};

    // Act
    InvokeExpr actualNInvokeStaticResult = Exprs.nInvokeStatic(regs, "Owner", "Name", argmentTypes, "Return Type");

    // Assert
    Method method = actualNInvokeStaticResult.method;
    assertEquals("(Argment Types)Return Type", method.getDesc());
    Proto proto = actualNInvokeStaticResult.getProto();
    assertEquals("(Argment Types)Return Type", proto.getDesc());
    assertEquals("Name", actualNInvokeStaticResult.getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualNInvokeStaticResult.getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualNInvokeStaticResult.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto.getReturnType());
    assertNull(actualNInvokeStaticResult.tag);
    assertNull(actualNInvokeStaticResult.valueType);
    assertNull(actualNInvokeStaticResult.getOp());
    assertNull(actualNInvokeStaticResult.getOp1());
    assertNull(actualNInvokeStaticResult.getOp2());
    assertEquals(ET.En, actualNInvokeStaticResult.et);
    assertEquals(Value.VT.INVOKE_STATIC, actualNInvokeStaticResult.vt);
    assertSame(proto, method.getProto());
    String[] args = actualNInvokeStaticResult.getArgs();
    assertSame(argmentTypes, args);
    assertSame(argmentTypes, method.getParameterTypes());
    assertSame(argmentTypes, proto.getParameterTypes());
    assertSame(regs, actualNInvokeStaticResult.getOps());
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test:
   * {@link Exprs#nInvokeVirtual(Value[], String, String, String[], String)}
   */
  @Test
  public void testNInvokeVirtual() {
    // Arrange
    Value[] regs = new Value[]{new ArrayExpr()};
    String[] argmentTypes = new String[]{"Argment Types"};

    // Act
    InvokeExpr actualNInvokeVirtualResult = Exprs.nInvokeVirtual(regs, "Owner", "Name", argmentTypes, "Return Type");

    // Assert
    Method method = actualNInvokeVirtualResult.method;
    assertEquals("(Argment Types)Return Type", method.getDesc());
    Proto proto = actualNInvokeVirtualResult.getProto();
    assertEquals("(Argment Types)Return Type", proto.getDesc());
    assertEquals("Name", actualNInvokeVirtualResult.getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualNInvokeVirtualResult.getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualNInvokeVirtualResult.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto.getReturnType());
    assertEquals("null[null].Name()", actualNInvokeVirtualResult.toString0());
    assertNull(actualNInvokeVirtualResult.tag);
    assertNull(actualNInvokeVirtualResult.valueType);
    assertNull(actualNInvokeVirtualResult.getOp());
    assertNull(actualNInvokeVirtualResult.getOp1());
    assertNull(actualNInvokeVirtualResult.getOp2());
    assertEquals(ET.En, actualNInvokeVirtualResult.et);
    assertEquals(Value.VT.INVOKE_VIRTUAL, actualNInvokeVirtualResult.vt);
    assertSame(proto, method.getProto());
    String[] args = actualNInvokeVirtualResult.getArgs();
    assertSame(argmentTypes, args);
    assertSame(argmentTypes, method.getParameterTypes());
    assertSame(argmentTypes, proto.getParameterTypes());
    assertSame(regs, actualNInvokeVirtualResult.getOps());
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test:
   * {@link Exprs#nInvokeCustom(Value[], String, Proto, MethodHandle, Object[])}
   */
  @Test
  public void testNInvokeCustom() {
    // Arrange
    Value[] regs = new Value[]{new ArrayExpr()};
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    // Act
    InvokeCustomExpr actualNInvokeCustomResult = Exprs.nInvokeCustom(regs, "Name", proto, new MethodHandle(1, field),
        new Object[]{Constant.Null});

    // Assert
    assertEquals("InvokeCustomExpr(....)", actualNInvokeCustomResult.toString0());
    assertEquals("Name", actualNInvokeCustomResult.name);
    assertNull(actualNInvokeCustomResult.getArgs());
    assertNull(actualNInvokeCustomResult.tag);
    assertNull(actualNInvokeCustomResult.getName());
    assertNull(actualNInvokeCustomResult.getOwner());
    assertNull(actualNInvokeCustomResult.getRet());
    assertNull(actualNInvokeCustomResult.valueType);
    assertNull(actualNInvokeCustomResult.getOp());
    assertNull(actualNInvokeCustomResult.getOp1());
    assertNull(actualNInvokeCustomResult.getOp2());
    MethodHandle methodHandle = actualNInvokeCustomResult.handle;
    assertNull(methodHandle.getMethod());
    assertNull(actualNInvokeCustomResult.method);
    assertEquals(1, methodHandle.getType());
    assertEquals(1, actualNInvokeCustomResult.bsmArgs.length);
    assertEquals(ET.En, actualNInvokeCustomResult.et);
    assertEquals(Value.VT.INVOKE_CUSTOM, actualNInvokeCustomResult.vt);
    assertSame(field, methodHandle.getField());
    assertSame(proto, actualNInvokeCustomResult.getProto());
    assertSame(regs, actualNInvokeCustomResult.getOps());
  }

  /**
   * Method under test:
   * {@link Exprs#nInvokeCustom(Value[], String, Proto, MethodHandle, Object[])}
   */
  @Test
  public void testNInvokeCustom2() {
    // Arrange
    Value[] regs = new Value[]{new ArrayExpr()};
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    InvokeCustomExpr actualNInvokeCustomResult = Exprs.nInvokeCustom(regs, "Name", proto, null,
        new Object[]{Constant.Null});

    // Assert
    assertEquals("InvokeCustomExpr(....)", actualNInvokeCustomResult.toString0());
    assertEquals("Name", actualNInvokeCustomResult.name);
    assertNull(actualNInvokeCustomResult.getArgs());
    assertNull(actualNInvokeCustomResult.tag);
    assertNull(actualNInvokeCustomResult.getName());
    assertNull(actualNInvokeCustomResult.getOwner());
    assertNull(actualNInvokeCustomResult.getRet());
    assertNull(actualNInvokeCustomResult.valueType);
    assertNull(actualNInvokeCustomResult.getOp());
    assertNull(actualNInvokeCustomResult.getOp1());
    assertNull(actualNInvokeCustomResult.getOp2());
    assertNull(actualNInvokeCustomResult.method);
    assertNull(actualNInvokeCustomResult.handle);
    assertEquals(1, actualNInvokeCustomResult.bsmArgs.length);
    assertEquals(ET.En, actualNInvokeCustomResult.et);
    assertEquals(Value.VT.INVOKE_CUSTOM, actualNInvokeCustomResult.vt);
    assertSame(proto, actualNInvokeCustomResult.getProto());
    assertSame(regs, actualNInvokeCustomResult.getOps());
  }

  /**
   * Method under test: {@link Exprs#nInvokePolymorphic(Value[], Proto, Method)}
   */
  @Test
  public void testNInvokePolymorphic() {
    // Arrange
    Value[] regs = new Value[]{new ArrayExpr()};
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Proto proto2 = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    InvokePolymorphicExpr actualNInvokePolymorphicResult = Exprs.nInvokePolymorphic(regs, proto,
        new Method("Owner", "Name", proto2));

    // Assert
    Method method = actualNInvokePolymorphicResult.method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", actualNInvokePolymorphicResult.getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualNInvokePolymorphicResult.getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualNInvokePolymorphicResult.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("null[null].Name()", actualNInvokePolymorphicResult.toString0());
    assertNull(actualNInvokePolymorphicResult.tag);
    assertNull(actualNInvokePolymorphicResult.valueType);
    assertNull(actualNInvokePolymorphicResult.getOp());
    assertNull(actualNInvokePolymorphicResult.getOp1());
    assertNull(actualNInvokePolymorphicResult.getOp2());
    assertEquals(ET.En, actualNInvokePolymorphicResult.et);
    assertEquals(Value.VT.INVOKE_POLYMORPHIC, actualNInvokePolymorphicResult.vt);
    assertSame(proto, actualNInvokePolymorphicResult.getProto());
    assertSame(proto2, method.getProto());
    String[] args = actualNInvokePolymorphicResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(regs, actualNInvokePolymorphicResult.getOps());
    assertArrayEquals(new String[]{"Parameter Types"}, args);
  }

  /**
   * Method under test: {@link Exprs#nLCmp(Value, Value)}
   */
  @Test
  public void testNLCmp() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNLCmpResult = Exprs.nLCmp(a, b);

    // Assert
    assertEquals("(null[null] LCMP null[null])", actualNLCmpResult.toString0());
    assertEquals("J", actualNLCmpResult.type);
    assertNull(actualNLCmpResult.getOps());
    assertNull(actualNLCmpResult.tag);
    assertNull(actualNLCmpResult.valueType);
    assertNull(actualNLCmpResult.getOp());
    assertEquals(ET.E2, actualNLCmpResult.et);
    assertEquals(Value.VT.LCMP, actualNLCmpResult.vt);
    assertSame(a, actualNLCmpResult.getOp1());
    assertSame(b, actualNLCmpResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nLe(Value, Value, String)}
   */
  @Test
  public void testNLe() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNLeResult = Exprs.nLe(a, b, "Type");

    // Assert
    assertEquals("(null[null] <= null[null])", actualNLeResult.toString0());
    assertEquals("Type", actualNLeResult.type);
    assertNull(actualNLeResult.getOps());
    assertNull(actualNLeResult.tag);
    assertNull(actualNLeResult.valueType);
    assertNull(actualNLeResult.getOp());
    assertEquals(ET.E2, actualNLeResult.et);
    assertEquals(Value.VT.LE, actualNLeResult.vt);
    assertSame(a, actualNLeResult.getOp1());
    assertSame(b, actualNLeResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nLength(Value)}
   */
  @Test
  public void testNLength() {
    // Arrange
    ArrayExpr array = new ArrayExpr();

    // Act
    UnopExpr actualNLengthResult = Exprs.nLength(array);

    // Assert
    assertEquals("null[null].length", actualNLengthResult.toString0());
    assertNull(actualNLengthResult.getOps());
    assertNull(actualNLengthResult.tag);
    assertNull(actualNLengthResult.type);
    assertNull(actualNLengthResult.valueType);
    assertNull(actualNLengthResult.getOp1());
    assertNull(actualNLengthResult.getOp2());
    assertEquals(ET.E1, actualNLengthResult.et);
    assertEquals(Value.VT.LENGTH, actualNLengthResult.vt);
    assertSame(array, actualNLengthResult.getOp());
  }

  /**
   * Method under test: {@link Exprs#nLocal(int)}
   */
  @Test
  public void testNLocal() {
    // Arrange and Act
    Local actualNLocalResult = Exprs.nLocal(1);

    // Assert
    assertEquals("a1", actualNLocalResult.toString0());
    assertNull(actualNLocalResult.getOps());
    assertNull(actualNLocalResult.tag);
    assertNull(actualNLocalResult.debugName);
    assertNull(actualNLocalResult.signature);
    assertNull(actualNLocalResult.valueType);
    assertNull(actualNLocalResult.getOp());
    assertNull(actualNLocalResult.getOp1());
    assertNull(actualNLocalResult.getOp2());
    assertEquals(1, actualNLocalResult._ls_index);
    assertEquals(ET.E0, actualNLocalResult.et);
    assertEquals(Value.VT.LOCAL, actualNLocalResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nLocal(int, String)}
   */
  @Test
  public void testNLocal2() {
    // Arrange and Act
    Local actualNLocalResult = Exprs.nLocal(1, "Debug Name");

    // Assert
    assertEquals("Debug Name", actualNLocalResult.debugName);
    assertEquals("Debug Name_1", actualNLocalResult.toString0());
    assertNull(actualNLocalResult.getOps());
    assertNull(actualNLocalResult.tag);
    assertNull(actualNLocalResult.signature);
    assertNull(actualNLocalResult.valueType);
    assertNull(actualNLocalResult.getOp());
    assertNull(actualNLocalResult.getOp1());
    assertNull(actualNLocalResult.getOp2());
    assertEquals(1, actualNLocalResult._ls_index);
    assertEquals(ET.E0, actualNLocalResult.et);
    assertEquals(Value.VT.LOCAL, actualNLocalResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nLocal(String)}
   */
  @Test
  public void testNLocal3() {
    // Arrange and Act
    Local actualNLocalResult = Exprs.nLocal("Debug Name");

    // Assert
    assertEquals("Debug Name", actualNLocalResult.debugName);
    assertEquals("Debug Name_0", actualNLocalResult.toString0());
    assertNull(actualNLocalResult.getOps());
    assertNull(actualNLocalResult.tag);
    assertNull(actualNLocalResult.signature);
    assertNull(actualNLocalResult.valueType);
    assertNull(actualNLocalResult.getOp());
    assertNull(actualNLocalResult.getOp1());
    assertNull(actualNLocalResult.getOp2());
    assertEquals(0, actualNLocalResult._ls_index);
    assertEquals(ET.E0, actualNLocalResult.et);
    assertEquals(Value.VT.LOCAL, actualNLocalResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nLt(Value, Value, String)}
   */
  @Test
  public void testNLt() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNLtResult = Exprs.nLt(a, b, "Type");

    // Assert
    assertEquals("(null[null] < null[null])", actualNLtResult.toString0());
    assertEquals("Type", actualNLtResult.type);
    assertNull(actualNLtResult.getOps());
    assertNull(actualNLtResult.tag);
    assertNull(actualNLtResult.valueType);
    assertNull(actualNLtResult.getOp());
    assertEquals(ET.E2, actualNLtResult.et);
    assertEquals(Value.VT.LT, actualNLtResult.vt);
    assertSame(a, actualNLtResult.getOp1());
    assertSame(b, actualNLtResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nMul(Value, Value, String)}
   */
  @Test
  public void testNMul() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNMulResult = Exprs.nMul(a, b, "Type");

    // Assert
    assertEquals("(null[null] * null[null])", actualNMulResult.toString0());
    assertEquals("Type", actualNMulResult.type);
    assertNull(actualNMulResult.getOps());
    assertNull(actualNMulResult.tag);
    assertNull(actualNMulResult.valueType);
    assertNull(actualNMulResult.getOp());
    assertEquals(ET.E2, actualNMulResult.et);
    assertEquals(Value.VT.MUL, actualNMulResult.vt);
    assertSame(a, actualNMulResult.getOp1());
    assertSame(b, actualNMulResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nNe(Value, Value, String)}
   */
  @Test
  public void testNNe() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNNeResult = Exprs.nNe(a, b, "Type");

    // Assert
    assertEquals("(null[null] != null[null])", actualNNeResult.toString0());
    assertEquals("Type", actualNNeResult.type);
    assertNull(actualNNeResult.getOps());
    assertNull(actualNNeResult.tag);
    assertNull(actualNNeResult.valueType);
    assertNull(actualNNeResult.getOp());
    assertEquals(ET.E2, actualNNeResult.et);
    assertEquals(Value.VT.NE, actualNNeResult.vt);
    assertSame(a, actualNNeResult.getOp1());
    assertSame(b, actualNNeResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nNeg(Value, String)}
   */
  @Test
  public void testNNeg() {
    // Arrange
    ArrayExpr array = new ArrayExpr();

    // Act
    UnopExpr actualNNegResult = Exprs.nNeg(array, "Type");

    // Assert
    assertEquals("(-null[null])", actualNNegResult.toString0());
    assertEquals("Type", actualNNegResult.type);
    assertNull(actualNNegResult.getOps());
    assertNull(actualNNegResult.tag);
    assertNull(actualNNegResult.valueType);
    assertNull(actualNNegResult.getOp1());
    assertNull(actualNNegResult.getOp2());
    assertEquals(ET.E1, actualNNegResult.et);
    assertEquals(Value.VT.NEG, actualNNegResult.vt);
    assertSame(array, actualNNegResult.getOp());
  }

  /**
   * Method under test: {@link Exprs#nNew(String)}
   */
  @Test
  public void testNNew() {
    // Arrange and Act
    NewExpr actualNNewResult = Exprs.nNew("Type");

    // Assert
    assertEquals("Type", actualNNewResult.type);
    assertNull(actualNNewResult.getOps());
    assertNull(actualNNewResult.tag);
    assertNull(actualNNewResult.valueType);
    assertNull(actualNNewResult.getOp());
    assertNull(actualNNewResult.getOp1());
    assertNull(actualNNewResult.getOp2());
    assertEquals(ET.E0, actualNNewResult.et);
    assertEquals(Value.VT.NEW, actualNNewResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nNewArray(String, Value)}
   */
  @Test
  public void testNNewArray() {
    // Arrange
    ArrayExpr size = new ArrayExpr();

    // Act
    TypeExpr actualNNewArrayResult = Exprs.nNewArray("Element Type", size);

    // Assert
    assertEquals("Element Type", actualNNewArrayResult.type);
    assertNull(actualNNewArrayResult.getOps());
    assertNull(actualNNewArrayResult.tag);
    assertNull(actualNNewArrayResult.valueType);
    assertNull(actualNNewArrayResult.getOp1());
    assertNull(actualNNewArrayResult.getOp2());
    assertEquals(ET.E1, actualNNewArrayResult.et);
    assertEquals(Value.VT.NEW_ARRAY, actualNNewArrayResult.vt);
    assertSame(size, actualNNewArrayResult.getOp());
  }

  /**
   * Method under test: {@link Exprs#nNewIntArray(Value)}
   */
  @Test
  public void testNNewIntArray() {
    // Arrange
    ArrayExpr size = new ArrayExpr();

    // Act
    TypeExpr actualNNewIntArrayResult = Exprs.nNewIntArray(size);

    // Assert
    assertEquals("I", actualNNewIntArrayResult.type);
    assertNull(actualNNewIntArrayResult.getOps());
    assertNull(actualNNewIntArrayResult.tag);
    assertNull(actualNNewIntArrayResult.valueType);
    assertNull(actualNNewIntArrayResult.getOp1());
    assertNull(actualNNewIntArrayResult.getOp2());
    assertEquals(ET.E1, actualNNewIntArrayResult.et);
    assertEquals(Value.VT.NEW_ARRAY, actualNNewIntArrayResult.vt);
    assertSame(size, actualNNewIntArrayResult.getOp());
  }

  /**
   * Method under test: {@link Exprs#nNewLongArray(Value)}
   */
  @Test
  public void testNNewLongArray() {
    // Arrange
    ArrayExpr size = new ArrayExpr();

    // Act
    TypeExpr actualNNewLongArrayResult = Exprs.nNewLongArray(size);

    // Assert
    assertEquals("J", actualNNewLongArrayResult.type);
    assertNull(actualNNewLongArrayResult.getOps());
    assertNull(actualNNewLongArrayResult.tag);
    assertNull(actualNNewLongArrayResult.valueType);
    assertNull(actualNNewLongArrayResult.getOp1());
    assertNull(actualNNewLongArrayResult.getOp2());
    assertEquals(ET.E1, actualNNewLongArrayResult.et);
    assertEquals(Value.VT.NEW_ARRAY, actualNNewLongArrayResult.vt);
    assertSame(size, actualNNewLongArrayResult.getOp());
  }

  /**
   * Method under test: {@link Exprs#nFilledArray(String, Value[])}
   */
  @Test
  public void testNFilledArray() {
    // Arrange
    Value[] datas = new Value[]{new ArrayExpr()};

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
    assertEquals(Value.VT.FILLED_ARRAY, actualNFilledArrayResult.vt);
    assertSame(datas, actualNFilledArrayResult.getOps());
  }

  /**
   * Method under test: {@link Exprs#nNewMutiArray(String, int, Value[])}
   */
  @Test
  public void testNNewMutiArray() {
    // Arrange
    Value[] sizes = new Value[]{new ArrayExpr()};

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
    assertEquals(Value.VT.NEW_MULTI_ARRAY, actualNNewMutiArrayResult.vt);
    assertSame(sizes, actualNNewMutiArrayResult.getOps());
  }

  /**
   * Method under test: {@link Exprs#nNot(Value, String)}
   */
  @Test
  public void testNNot() {
    // Arrange
    ArrayExpr array = new ArrayExpr();

    // Act
    UnopExpr actualNNotResult = Exprs.nNot(array, "Type");

    // Assert
    assertEquals("(!null[null])", actualNNotResult.toString0());
    assertEquals("Type", actualNNotResult.type);
    assertNull(actualNNotResult.getOps());
    assertNull(actualNNotResult.tag);
    assertNull(actualNNotResult.valueType);
    assertNull(actualNNotResult.getOp1());
    assertNull(actualNNotResult.getOp2());
    assertEquals(ET.E1, actualNNotResult.et);
    assertEquals(Value.VT.NOT, actualNNotResult.vt);
    assertSame(array, actualNNotResult.getOp());
  }

  /**
   * Method under test: {@link Exprs#nOr(Value, Value, String)}
   */
  @Test
  public void testNOr() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNOrResult = Exprs.nOr(a, b, "Type");

    // Assert
    assertEquals("(null[null] | null[null])", actualNOrResult.toString0());
    assertEquals("Type", actualNOrResult.type);
    assertNull(actualNOrResult.getOps());
    assertNull(actualNOrResult.tag);
    assertNull(actualNOrResult.valueType);
    assertNull(actualNOrResult.getOp());
    assertEquals(ET.E2, actualNOrResult.et);
    assertEquals(Value.VT.OR, actualNOrResult.vt);
    assertSame(a, actualNOrResult.getOp1());
    assertSame(b, actualNOrResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nParameterRef(String, int)}
   */
  @Test
  public void testNParameterRef() {
    // Arrange and Act
    RefExpr actualNParameterRefResult = Exprs.nParameterRef("Type", 1);

    // Assert
    assertEquals("@parameter_1", actualNParameterRefResult.toString0());
    assertEquals("Type", actualNParameterRefResult.type);
    assertNull(actualNParameterRefResult.getOps());
    assertNull(actualNParameterRefResult.tag);
    assertNull(actualNParameterRefResult.valueType);
    assertNull(actualNParameterRefResult.getOp());
    assertNull(actualNParameterRefResult.getOp1());
    assertNull(actualNParameterRefResult.getOp2());
    assertEquals(1, actualNParameterRefResult.parameterIndex);
    assertEquals(ET.E0, actualNParameterRefResult.et);
    assertEquals(Value.VT.PARAMETER_REF, actualNParameterRefResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nRem(Value, Value, String)}
   */
  @Test
  public void testNRem() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNRemResult = Exprs.nRem(a, b, "Type");

    // Assert
    assertEquals("(null[null] % null[null])", actualNRemResult.toString0());
    assertEquals("Type", actualNRemResult.type);
    assertNull(actualNRemResult.getOps());
    assertNull(actualNRemResult.tag);
    assertNull(actualNRemResult.valueType);
    assertNull(actualNRemResult.getOp());
    assertEquals(ET.E2, actualNRemResult.et);
    assertEquals(Value.VT.REM, actualNRemResult.vt);
    assertSame(a, actualNRemResult.getOp1());
    assertSame(b, actualNRemResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nShl(Value, Value, String)}
   */
  @Test
  public void testNShl() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNShlResult = Exprs.nShl(a, b, "Type");

    // Assert
    assertEquals("(null[null] << null[null])", actualNShlResult.toString0());
    assertEquals("Type", actualNShlResult.type);
    assertNull(actualNShlResult.getOps());
    assertNull(actualNShlResult.tag);
    assertNull(actualNShlResult.valueType);
    assertNull(actualNShlResult.getOp());
    assertEquals(ET.E2, actualNShlResult.et);
    assertEquals(Value.VT.SHL, actualNShlResult.vt);
    assertSame(a, actualNShlResult.getOp1());
    assertSame(b, actualNShlResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nShr(Value, Value, String)}
   */
  @Test
  public void testNShr() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNShrResult = Exprs.nShr(a, b, "Type");

    // Assert
    assertEquals("(null[null] >> null[null])", actualNShrResult.toString0());
    assertEquals("Type", actualNShrResult.type);
    assertNull(actualNShrResult.getOps());
    assertNull(actualNShrResult.tag);
    assertNull(actualNShrResult.valueType);
    assertNull(actualNShrResult.getOp());
    assertEquals(ET.E2, actualNShrResult.et);
    assertEquals(Value.VT.SHR, actualNShrResult.vt);
    assertSame(a, actualNShrResult.getOp1());
    assertSame(b, actualNShrResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nStaticField(String, String, String)}
   */
  @Test
  public void testNStaticField() {
    // Arrange and Act
    StaticFieldExpr actualNStaticFieldResult = Exprs.nStaticField("Owner Type", "Field Name", "Field Type");

    // Assert
    assertEquals("Field Name", actualNStaticFieldResult.name);
    assertEquals("Field Type", actualNStaticFieldResult.type);
    assertEquals("Owner Type", actualNStaticFieldResult.owner);
    assertNull(actualNStaticFieldResult.getOps());
    assertNull(actualNStaticFieldResult.tag);
    assertNull(actualNStaticFieldResult.valueType);
    assertNull(actualNStaticFieldResult.getOp());
    assertNull(actualNStaticFieldResult.getOp1());
    assertNull(actualNStaticFieldResult.getOp2());
    assertEquals(ET.E0, actualNStaticFieldResult.et);
    assertEquals(Value.VT.STATIC_FIELD, actualNStaticFieldResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nSub(Value, Value, String)}
   */
  @Test
  public void testNSub() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNSubResult = Exprs.nSub(a, b, "Type");

    // Assert
    assertEquals("(null[null] - null[null])", actualNSubResult.toString0());
    assertEquals("Type", actualNSubResult.type);
    assertNull(actualNSubResult.getOps());
    assertNull(actualNSubResult.tag);
    assertNull(actualNSubResult.valueType);
    assertNull(actualNSubResult.getOp());
    assertEquals(ET.E2, actualNSubResult.et);
    assertEquals(Value.VT.SUB, actualNSubResult.vt);
    assertSame(a, actualNSubResult.getOp1());
    assertSame(b, actualNSubResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nThisRef(String)}
   */
  @Test
  public void testNThisRef() {
    // Arrange and Act
    RefExpr actualNThisRefResult = Exprs.nThisRef("Type");

    // Assert
    assertEquals("@this", actualNThisRefResult.toString0());
    assertEquals("Type", actualNThisRefResult.type);
    assertNull(actualNThisRefResult.getOps());
    assertNull(actualNThisRefResult.tag);
    assertNull(actualNThisRefResult.valueType);
    assertNull(actualNThisRefResult.getOp());
    assertNull(actualNThisRefResult.getOp1());
    assertNull(actualNThisRefResult.getOp2());
    assertEquals(-1, actualNThisRefResult.parameterIndex);
    assertEquals(ET.E0, actualNThisRefResult.et);
    assertEquals(Value.VT.THIS_REF, actualNThisRefResult.vt);
  }

  /**
   * Method under test: {@link Exprs#nUshr(Value, Value, String)}
   */
  @Test
  public void testNUshr() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNUshrResult = Exprs.nUshr(a, b, "Type");

    // Assert
    assertEquals("(null[null] >>> null[null])", actualNUshrResult.toString0());
    assertEquals("Type", actualNUshrResult.type);
    assertNull(actualNUshrResult.getOps());
    assertNull(actualNUshrResult.tag);
    assertNull(actualNUshrResult.valueType);
    assertNull(actualNUshrResult.getOp());
    assertEquals(ET.E2, actualNUshrResult.et);
    assertEquals(Value.VT.USHR, actualNUshrResult.vt);
    assertSame(a, actualNUshrResult.getOp1());
    assertSame(b, actualNUshrResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nXor(Value, Value, String)}
   */
  @Test
  public void testNXor() {
    // Arrange
    ArrayExpr a = new ArrayExpr();
    ArrayExpr b = new ArrayExpr();

    // Act
    BinopExpr actualNXorResult = Exprs.nXor(a, b, "Type");

    // Assert
    assertEquals("(null[null] ^ null[null])", actualNXorResult.toString0());
    assertEquals("Type", actualNXorResult.type);
    assertNull(actualNXorResult.getOps());
    assertNull(actualNXorResult.tag);
    assertNull(actualNXorResult.valueType);
    assertNull(actualNXorResult.getOp());
    assertEquals(ET.E2, actualNXorResult.et);
    assertEquals(Value.VT.XOR, actualNXorResult.vt);
    assertSame(a, actualNXorResult.getOp1());
    assertSame(b, actualNXorResult.getOp2());
  }

  /**
   * Method under test: {@link Exprs#nPhi(Value[])}
   */
  @Test
  public void testNPhi() {
    // Arrange
    Value[] ops = new Value[]{new ArrayExpr()};

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
    assertEquals(Value.VT.PHI, actualNPhiResult.vt);
    assertSame(ops, actualNPhiResult.getOps());
  }

  /**
   * Method under test: {@link Exprs#nConstant(Object)}
   */
  @Test
  public void testNConstant() {
    // Arrange and Act
    Constant actualNConstantResult = Exprs.nConstant(Constant.Null);

    // Assert
    assertNull(actualNConstantResult.getOps());
    assertNull(actualNConstantResult.tag);
    assertNull(actualNConstantResult.valueType);
    assertNull(actualNConstantResult.getOp());
    assertNull(actualNConstantResult.getOp1());
    assertNull(actualNConstantResult.getOp2());
    assertEquals(ET.E0, actualNConstantResult.et);
    assertEquals(Value.VT.CONSTANT, actualNConstantResult.vt);
  }
}
