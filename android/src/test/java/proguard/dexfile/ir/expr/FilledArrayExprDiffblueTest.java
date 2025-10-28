package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Proto;

public class FilledArrayExprDiffblueTest {
  /**
   * Method under test: {@link FilledArrayExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    FilledArrayExpr nFilledArrayResult = Exprs.nFilledArray("Element Type", new Value[]{new ArrayExpr()});

    // Act
    nFilledArrayResult.releaseMemory();

    // Assert
    assertNull(nFilledArrayResult.getOps());
    assertNull(nFilledArrayResult.type);
  }

  /**
   * Method under test: {@link FilledArrayExpr#clone()}
   */
  @Test
  public void testClone() {
    // Arrange and Act
    Value actualCloneResult = Exprs.nFilledArray("Element Type", new Value[]{}).clone();

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
    assertEquals(Value.VT.FILLED_ARRAY, ((FilledArrayExpr) actualCloneResult).vt);
  }

  /**
   * Method under test: {@link FilledArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    FilledArrayExpr nFilledArrayResult = Exprs.nFilledArray("Element Type", new Value[]{nNullResult});

    // Act
    Value actualCloneResult = nFilledArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof FilledArrayExpr);
    assertEquals("Element Type", ((FilledArrayExpr) actualCloneResult).type);
    assertNull(value.getOps());
    assertNull(((Constant) value).tag);
    assertNull(((FilledArrayExpr) actualCloneResult).tag);
    assertNull(((Constant) value).valueType);
    assertNull(((FilledArrayExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.En, ((FilledArrayExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.FILLED_ARRAY, ((FilledArrayExpr) actualCloneResult).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Method under test: {@link FilledArrayExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone3() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokeCustomExpr nInvokeCustomResult = Exprs.nInvokeCustom(new Value[]{nNullResult}, "Name", proto,
        new MethodHandle(1, new Field("Owner", "Name", "Type")), new Object[]{Constant.Null});
    FilledArrayExpr nFilledArrayResult = Exprs.nFilledArray("Element Type", new Value[]{nInvokeCustomResult});

    // Act
    Value actualCloneResult = nFilledArrayResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(actualCloneResult instanceof FilledArrayExpr);
    assertTrue(value instanceof InvokeCustomExpr);
    assertEquals("Element Type", ((FilledArrayExpr) actualCloneResult).type);
    assertEquals("InvokeCustomExpr(....)", value.toString0());
    assertEquals("Name", ((InvokeCustomExpr) value).name);
    assertNull(((InvokeCustomExpr) value).getArgs());
    assertNull(value2.getOps());
    assertNull(((Constant) value2).tag);
    assertNull(((FilledArrayExpr) actualCloneResult).tag);
    assertNull(((InvokeCustomExpr) value).tag);
    assertNull(((InvokeCustomExpr) value).getName());
    assertNull(((InvokeCustomExpr) value).getOwner());
    assertNull(((InvokeCustomExpr) value).getRet());
    assertNull(((Constant) value2).valueType);
    assertNull(((FilledArrayExpr) actualCloneResult).valueType);
    assertNull(((InvokeCustomExpr) value).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(value2.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(value2.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertNull(value2.getOp2());
    assertNull(((InvokeCustomExpr) value).method);
    assertEquals(1, ops.length);
    assertEquals(1, ops2.length);
    assertEquals(ET.E0, ((Constant) value2).et);
    assertEquals(ET.En, ((FilledArrayExpr) actualCloneResult).et);
    assertEquals(ET.En, ((InvokeCustomExpr) value).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.FILLED_ARRAY, ((FilledArrayExpr) actualCloneResult).vt);
    assertEquals(Value.VT.INVOKE_CUSTOM, ((InvokeCustomExpr) value).vt);
    assertSame(proto, ((InvokeCustomExpr) value).getProto());
    assertSame(nNullResult.value, ((Constant) value2).value);
    assertSame(nInvokeCustomResult.bsmArgs, ((InvokeCustomExpr) value).bsmArgs);
    assertSame(nInvokeCustomResult.handle, ((InvokeCustomExpr) value).handle);
  }

  /**
   * Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange
    FilledArrayExpr nFilledArrayResult = Exprs.nFilledArray("Element Type", new Value[]{new ArrayExpr()});
    nFilledArrayResult.type = null;

    // Act and Assert
    assertEquals("new []{null[null]}", nFilledArrayResult.toString0());
  }

  /**
   * Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    FilledArrayExpr nFilledArrayResult = Exprs.nFilledArray("Element Type", new Value[]{new ArrayExpr()});
    nFilledArrayResult.type = "";

    // Act and Assert
    assertEquals("new []{null[null]}", nFilledArrayResult.toString0());
  }

  /**
   * Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange, Act and Assert
    assertEquals("new double[]{null[null]}", Exprs.nFilledArray("D", new Value[]{new ArrayExpr()}).toString0());
  }

  /**
   * Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  public void testToString04() {
    // Arrange, Act and Assert
    assertEquals("new float[]{null[null]}", Exprs.nFilledArray("F", new Value[]{new ArrayExpr()}).toString0());
  }

  /**
   * Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  public void testToString05() {
    // Arrange, Act and Assert
    assertEquals("new int[]{null[null]}", Exprs.nFilledArray("I", new Value[]{new ArrayExpr()}).toString0());
  }

  /**
   * Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  public void testToString06() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("new double[]{null[null][null]}", Exprs.nFilledArray("D", new Value[]{arrayExpr}).toString0());
  }

  /**
   * Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  public void testToString07() {
    // Arrange
    ArrayExpr base = new ArrayExpr();

    // Act and Assert
    assertEquals("new double[]{null[null][null[null]]}",
        Exprs.nFilledArray("D", new Value[]{Exprs.nArray(base, new ArrayExpr(), "new ")}).toString0());
  }

  /**
   * Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  public void testToString08() {
    // Arrange, Act and Assert
    assertEquals("new double[]{null}", Exprs.nFilledArray("D", new Value[]{null}).toString0());
  }

  /**
   * Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  public void testToString09() {
    // Arrange, Act and Assert
    assertEquals("new double[]{}", Exprs.nFilledArray("D", new Value[]{}).toString0());
  }

  /**
   * Method under test: {@link FilledArrayExpr#toString0()}
   */
  @Test
  public void testToString010() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    arrayExpr.setOp1(new ArrayExpr());

    // Act and Assert
    assertEquals("new [][]{null[null][null]}", Exprs.nFilledArray("[", new Value[]{arrayExpr}).toString0());
  }

  /**
   * Method under test: {@link FilledArrayExpr#FilledArrayExpr(Value[], String)}
   */
  @Test
  public void testNewFilledArrayExpr() {
    // Arrange
    Value[] datas = new Value[]{new ArrayExpr()};

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
    assertEquals(Value.VT.FILLED_ARRAY, actualFilledArrayExpr.vt);
    assertSame(datas, actualFilledArrayExpr.getOps());
  }
}
