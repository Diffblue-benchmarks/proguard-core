package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;

public class InvokeExprDiffblueTest {
  /**
   * Method under test: {@link InvokeExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"},
        "Owner");

    // Act
    nInvokeNewResult.releaseMemory();

    // Assert
    assertTrue(nInvokeNewResult instanceof InvokeNewExpr);
    assertNull(nInvokeNewResult.getArgs());
    assertNull(nInvokeNewResult.getOps());
    assertNull(nInvokeNewResult.getName());
    assertNull(nInvokeNewResult.getOwner());
    assertNull(nInvokeNewResult.getRet());
    assertNull(((InvokeNewExpr) nInvokeNewResult).method);
    assertNull(nInvokeNewResult.getProto());
  }

  /**
   * Method under test: {@link InvokeExpr#getProto()}
   */
  @Test
  public void testGetProto() {
    // Arrange and Act
    Proto actualProto = Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"}, "Owner")
        .getProto();

    // Assert
    assertEquals("(Argment Types)Owner", actualProto.getDesc());
    assertEquals("Owner", actualProto.getReturnType());
    assertArrayEquals(new String[]{"Argment Types"}, actualProto.getParameterTypes());
  }

  /**
   * Method under test: {@link InvokeExpr#getProto()}
   */
  @Test
  public void testGetProto2() {
    // Arrange
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"},
        "Owner");
    nInvokeNewResult.method = null;

    // Act and Assert
    assertNull(nInvokeNewResult.getProto());
  }

  /**
   * Method under test: {@link InvokeExpr#clone()}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant nNullResult = Exprs.nNull();

    // Act
    InvokeExpr actualCloneResult = Exprs.nInvokeNew(new Value[]{nNullResult}, new String[]{"Argment Types"}, "Owner")
        .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argment Types)Owner", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    assertEquals("<init>", actualCloneResult.getName());
    assertEquals("<init>", method.getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertNull(value.getOps());
    assertNull(((Constant) value).tag);
    assertNull(((InvokeNewExpr) actualCloneResult).tag);
    assertNull(((Constant) value).valueType);
    assertNull(((InvokeNewExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.En, ((InvokeNewExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) actualCloneResult).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto.getParameterTypes());
    assertSame(proto, method.getProto());
    assertSame(nNullResult.value, ((Constant) value).value);
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test: {@link InvokeExpr#clone()}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant nNullResult = Exprs.nNull();

    // Act
    InvokeExpr actualCloneResult = Exprs
        .nInvokeNew(new Value[]{Exprs.nFilledArray("Element Type", new Value[]{nNullResult})},
            new String[]{"Argment Types"}, "Owner")
        .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argment Types)Owner", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    assertEquals("<init>", actualCloneResult.getName());
    assertEquals("<init>", method.getName());
    assertEquals("Element Type", ((FilledArrayExpr) value).type);
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertNull(value2.getOps());
    assertNull(((Constant) value2).tag);
    assertNull(((FilledArrayExpr) value).tag);
    assertNull(((InvokeNewExpr) actualCloneResult).tag);
    assertNull(((Constant) value2).valueType);
    assertNull(((FilledArrayExpr) value).valueType);
    assertNull(((InvokeNewExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value2.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value2.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value2.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value2).et);
    assertEquals(ET.En, ((FilledArrayExpr) value).et);
    assertEquals(ET.En, ((InvokeNewExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.FILLED_ARRAY, ((FilledArrayExpr) value).vt);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) actualCloneResult).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto.getParameterTypes());
    assertSame(proto, method.getProto());
    assertSame(nNullResult.value, ((Constant) value2).value);
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test: {@link InvokeExpr#clone()}
   */
  @Test
  public void testClone3() {
    // Arrange
    Constant nNullResult = Exprs.nNull();

    // Act
    InvokeExpr actualCloneResult = Exprs
        .nInvokeInterface(new Value[]{nNullResult}, "Owner", "Name", new String[]{"Argment Types"}, "Return Type")
        .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    Method method = actualCloneResult.method;
    assertEquals("(Argment Types)Return Type", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argment Types)Return Type", proto.getDesc());
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualCloneResult.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto.getReturnType());
    assertEquals("null.Name()", actualCloneResult.toString0());
    assertNull(value.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value).tag);
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, actualCloneResult.vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto.getParameterTypes());
    assertSame(proto, method.getProto());
    assertSame(nNullResult.value, ((Constant) value).value);
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test: {@link InvokeExpr#clone()}
   */
  @Test
  public void testClone4() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeInterfaceResult = Exprs.nInvokeInterface(new Value[]{nNullResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");

    // Act
    InvokeExpr actualCloneResult = Exprs
        .nInvokeNew(new Value[]{nInvokeInterfaceResult}, new String[]{"Argment Types"}, "Owner")
        .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argment Types)Owner", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    Proto proto2 = ((InvokeExpr) value).getProto();
    assertEquals("(Argment Types)Return Type", proto2.getDesc());
    assertEquals("<init>", actualCloneResult.getName());
    assertEquals("<init>", method.getName());
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("Return Type", proto2.getReturnType());
    assertEquals("null.Name()", value.toString0());
    assertNull(value2.getOps());
    assertNull(((Constant) value2).tag);
    assertNull(((InvokeExpr) value).tag);
    assertNull(((InvokeNewExpr) actualCloneResult).tag);
    assertNull(((Constant) value2).valueType);
    assertNull(((InvokeExpr) value).valueType);
    assertNull(((InvokeNewExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value2.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value2.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value2.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value2).et);
    assertEquals(ET.En, ((InvokeExpr) value).et);
    assertEquals(ET.En, ((InvokeNewExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) actualCloneResult).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto.getParameterTypes());
    String[] args2 = ((InvokeExpr) value).getArgs();
    assertSame(args2, proto2.getParameterTypes());
    assertSame(proto, method.getProto());
    assertSame(nNullResult.value, ((Constant) value2).value);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
    assertArrayEquals(new String[]{"Argment Types"}, args);
    assertArrayEquals(new String[]{"Argment Types"}, args2);
  }

  /**
   * Method under test: {@link InvokeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone5() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{nNullResult}, new String[]{"Argment Types"}, "Owner");

    // Act
    InvokeExpr actualCloneResult = nInvokeNewResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argment Types)Owner", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    assertEquals("<init>", actualCloneResult.getName());
    assertEquals("<init>", method.getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertNull(value.getOps());
    assertNull(((Constant) value).tag);
    assertNull(((InvokeNewExpr) actualCloneResult).tag);
    assertNull(((Constant) value).valueType);
    assertNull(((InvokeNewExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.En, ((InvokeNewExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) actualCloneResult).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto.getParameterTypes());
    assertSame(proto, method.getProto());
    assertSame(nNullResult.value, ((Constant) value).value);
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test: {@link InvokeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone6() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(
        new Value[]{Exprs.nFilledArray("Element Type", new Value[]{nNullResult})}, new String[]{"Argment Types"},
        "Owner");

    // Act
    InvokeExpr actualCloneResult = nInvokeNewResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argment Types)Owner", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    assertEquals("<init>", actualCloneResult.getName());
    assertEquals("<init>", method.getName());
    assertEquals("Element Type", ((FilledArrayExpr) value).type);
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertNull(value2.getOps());
    assertNull(((Constant) value2).tag);
    assertNull(((FilledArrayExpr) value).tag);
    assertNull(((InvokeNewExpr) actualCloneResult).tag);
    assertNull(((Constant) value2).valueType);
    assertNull(((FilledArrayExpr) value).valueType);
    assertNull(((InvokeNewExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value2.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value2.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value2.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value2).et);
    assertEquals(ET.En, ((FilledArrayExpr) value).et);
    assertEquals(ET.En, ((InvokeNewExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.FILLED_ARRAY, ((FilledArrayExpr) value).vt);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) actualCloneResult).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto.getParameterTypes());
    assertSame(proto, method.getProto());
    assertSame(nNullResult.value, ((Constant) value2).value);
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test: {@link InvokeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone7() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeInterfaceResult = Exprs.nInvokeInterface(new Value[]{nNullResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");

    // Act
    InvokeExpr actualCloneResult = nInvokeInterfaceResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    Method method = actualCloneResult.method;
    assertEquals("(Argment Types)Return Type", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argment Types)Return Type", proto.getDesc());
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualCloneResult.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto.getReturnType());
    assertEquals("null.Name()", actualCloneResult.toString0());
    assertNull(value.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value).tag);
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, actualCloneResult.vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto.getParameterTypes());
    assertSame(proto, method.getProto());
    assertSame(nNullResult.value, ((Constant) value).value);
    assertArrayEquals(new String[]{"Argment Types"}, args);
  }

  /**
   * Method under test: {@link InvokeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone8() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeInterfaceResult = Exprs.nInvokeInterface(new Value[]{nNullResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{nInvokeInterfaceResult}, new String[]{"Argment Types"},
        "Owner");

    // Act
    InvokeExpr actualCloneResult = nInvokeNewResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argment Types)Owner", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    Proto proto2 = ((InvokeExpr) value).getProto();
    assertEquals("(Argment Types)Return Type", proto2.getDesc());
    assertEquals("<init>", actualCloneResult.getName());
    assertEquals("<init>", method.getName());
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("Return Type", proto2.getReturnType());
    assertEquals("null.Name()", value.toString0());
    assertNull(value2.getOps());
    assertNull(((Constant) value2).tag);
    assertNull(((InvokeExpr) value).tag);
    assertNull(((InvokeNewExpr) actualCloneResult).tag);
    assertNull(((Constant) value2).valueType);
    assertNull(((InvokeExpr) value).valueType);
    assertNull(((InvokeNewExpr) actualCloneResult).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value2.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value2.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value2.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value2).et);
    assertEquals(ET.En, ((InvokeExpr) value).et);
    assertEquals(ET.En, ((InvokeNewExpr) actualCloneResult).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) actualCloneResult).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto.getParameterTypes());
    String[] args2 = ((InvokeExpr) value).getArgs();
    assertSame(args2, proto2.getParameterTypes());
    assertSame(proto, method.getProto());
    assertSame(nNullResult.value, ((Constant) value2).value);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
    assertArrayEquals(new String[]{"Argment Types"}, args);
    assertArrayEquals(new String[]{"Argment Types"}, args2);
  }

  /**
   * Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange, Act and Assert
    assertEquals("new (null[null])",
        Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"}, null).toString0());
    assertEquals("new double(null[null])",
        Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"}, "D").toString0());
    assertEquals("new (null[null])",
        Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"}, "").toString0());
    assertEquals("new float(null[null])",
        Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"}, "F").toString0());
    assertEquals("null[null].new ()",
        (new InvokeNewExpr(Value.VT.ADD, new Value[]{new ArrayExpr()}, "new ", "new ", new String[]{"new "}, "new "))
            .toString0());
    assertEquals("new int(null[null])",
        Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"}, "I").toString0());
    assertEquals("new [][]{null[null]}.new ()",
        (new InvokeNewExpr(Value.VT.ADD, new Value[]{Exprs.nFilledArray("[", new Value[]{new ArrayExpr()})}, "new ",
            "new ", new String[]{"new "}, "new ")).toString0());
    assertEquals("new ((()null[null]))",
        Exprs
            .nInvokeNew(new Value[]{Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "")},
                new String[]{"Argment Types"}, null)
            .toString0());
    assertEquals("new [](null[null]).new ()",
        (new InvokeNewExpr(Value.VT.ADD,
            new Value[]{Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"new "}, "[")}, "new ", "new ",
            new String[]{"new "}, "new ")).toString0());
  }

  /**
   * Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    Proto proto = new Proto(new String[]{"new "}, "new ");

    // Act and Assert
    assertEquals("null[null].new ()",
        Exprs
            .nInvokePolymorphic(new Value[]{new ArrayExpr()}, proto,
                new Method("new ", "new ", new Proto(new String[]{"new "}, "new ")))
            .toString0());
  }

  /**
   * Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();

    // Act and Assert
    assertEquals("new (null[null],null[null])",
        Exprs.nInvokeNew(new Value[]{arrayExpr, new ArrayExpr()}, new String[]{"Argment Types"}, null).toString0());
  }

  /**
   * Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  public void testToString04() {
    // Arrange
    Proto proto = new Proto(new String[]{"new "}, "new ");

    // Act and Assert
    assertEquals("new [][]{null[null]}.new ()",
        Exprs
            .nInvokePolymorphic(new Value[]{Exprs.nFilledArray("[", new Value[]{new ArrayExpr()})}, proto,
                new Method("new ", "new ", new Proto(new String[]{"new "}, "new ")))
            .toString0());
  }

  /**
   * Method under test: {@link InvokeExpr#getOwner()}
   */
  @Test
  public void testGetOwner() {
    // Arrange, Act and Assert
    assertEquals("Owner",
        Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"}, "Owner").getOwner());
  }

  /**
   * Method under test: {@link InvokeExpr#getOwner()}
   */
  @Test
  public void testGetOwner2() {
    // Arrange
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"},
        "Owner");
    nInvokeNewResult.method = null;

    // Act and Assert
    assertNull(nInvokeNewResult.getOwner());
  }

  /**
   * Method under test: {@link InvokeExpr#getRet()}
   */
  @Test
  public void testGetRet() {
    // Arrange, Act and Assert
    assertEquals("Owner",
        Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"}, "Owner").getRet());
  }

  /**
   * Method under test: {@link InvokeExpr#getRet()}
   */
  @Test
  public void testGetRet2() {
    // Arrange
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"},
        "Owner");
    nInvokeNewResult.method = null;

    // Act and Assert
    assertNull(nInvokeNewResult.getRet());
  }

  /**
   * Method under test: {@link InvokeExpr#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("<init>",
        Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"}, "Owner").getName());
  }

  /**
   * Method under test: {@link InvokeExpr#getName()}
   */
  @Test
  public void testGetName2() {
    // Arrange
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"},
        "Owner");
    nInvokeNewResult.method = null;

    // Act and Assert
    assertNull(nInvokeNewResult.getName());
  }

  /**
   * Method under test: {@link InvokeExpr#getArgs()}
   */
  @Test
  public void testGetArgs() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"Argment Types"},
        Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"}, "Owner").getArgs());
  }

  /**
   * Method under test: {@link InvokeExpr#getArgs()}
   */
  @Test
  public void testGetArgs2() {
    // Arrange
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"Argment Types"},
        "Owner");
    nInvokeNewResult.method = null;

    // Act and Assert
    assertNull(nInvokeNewResult.getArgs());
  }

  /**
   * Method under test:
   * {@link InvokeExpr#InvokeExpr(Value.VT, Value[], String, String, String[], String)}
   */
  @Test
  public void testNewInvokeExpr() {
    // Arrange
    Value[] args = new Value[]{new ArrayExpr()};
    String[] argmentTypes = new String[]{"Argment Types"};

    // Act
    InvokeExpr actualInvokeExpr = new InvokeExpr(Value.VT.ADD, args, "Owner Type", "Method Name", argmentTypes,
        "Return Type");

    // Assert
    Method method = actualInvokeExpr.method;
    assertEquals("(Argment Types)Return Type", method.getDesc());
    Proto proto = actualInvokeExpr.getProto();
    assertEquals("(Argment Types)Return Type", proto.getDesc());
    assertEquals("Method Name", actualInvokeExpr.getName());
    assertEquals("Method Name", method.getName());
    assertEquals("Owner Type", actualInvokeExpr.getOwner());
    assertEquals("Owner Type", method.getOwner());
    assertEquals("Return Type", actualInvokeExpr.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto.getReturnType());
    assertEquals("null[null].Method Name()", actualInvokeExpr.toString0());
    assertNull(actualInvokeExpr.tag);
    assertNull(actualInvokeExpr.valueType);
    assertNull(actualInvokeExpr.getOp());
    assertNull(actualInvokeExpr.getOp1());
    assertNull(actualInvokeExpr.getOp2());
    assertEquals(ET.En, actualInvokeExpr.et);
    assertEquals(Value.VT.ADD, actualInvokeExpr.vt);
    assertSame(proto, method.getProto());
    String[] args2 = actualInvokeExpr.getArgs();
    assertSame(argmentTypes, args2);
    assertSame(argmentTypes, method.getParameterTypes());
    assertSame(argmentTypes, proto.getParameterTypes());
    assertSame(args, actualInvokeExpr.getOps());
    assertArrayEquals(new String[]{"Argment Types"}, args2);
  }

  /**
   * Method under test: {@link InvokeExpr#InvokeExpr(Value.VT, Value[], Method)}
   */
  @Test
  public void testNewInvokeExpr2() {
    // Arrange
    Value[] args = new Value[]{new ArrayExpr()};
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    InvokeExpr actualInvokeExpr = new InvokeExpr(Value.VT.ADD, args, new Method("Owner", "Name", proto));

    // Assert
    Method method = actualInvokeExpr.method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", actualInvokeExpr.getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualInvokeExpr.getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualInvokeExpr.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("null[null].Name()", actualInvokeExpr.toString0());
    assertNull(actualInvokeExpr.tag);
    assertNull(actualInvokeExpr.valueType);
    assertNull(actualInvokeExpr.getOp());
    assertNull(actualInvokeExpr.getOp1());
    assertNull(actualInvokeExpr.getOp2());
    assertEquals(ET.En, actualInvokeExpr.et);
    assertEquals(Value.VT.ADD, actualInvokeExpr.vt);
    assertSame(proto, actualInvokeExpr.getProto());
    assertSame(proto, method.getProto());
    String[] args2 = actualInvokeExpr.getArgs();
    assertSame(args2, method.getParameterTypes());
    assertSame(args, actualInvokeExpr.getOps());
    assertArrayEquals(new String[]{"Parameter Types"}, args2);
  }
}
