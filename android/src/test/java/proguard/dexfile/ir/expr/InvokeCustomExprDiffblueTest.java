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

public class InvokeCustomExprDiffblueTest {
  /**
   * Method under test: {@link InvokeCustomExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokeCustomExpr nInvokeCustomResult = Exprs.nInvokeCustom(new Value[]{new ArrayExpr()}, "Name", proto,
        new MethodHandle(1, new Field("Owner", "Name", "Type")), new Object[]{Constant.Null});

    // Act
    nInvokeCustomResult.releaseMemory();

    // Assert
    assertNull(nInvokeCustomResult.bsmArgs);
    assertNull(nInvokeCustomResult.getOps());
    assertNull(nInvokeCustomResult.name);
    assertNull(nInvokeCustomResult.handle);
    assertNull(nInvokeCustomResult.getProto());
  }

  /**
   * Method under test: {@link InvokeCustomExpr#getProto()}
   */
  @Test
  public void testGetProto() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokeCustomExpr invokeCustomExpr = new InvokeCustomExpr(Value.VT.ADD, new Value[]{new ArrayExpr()}, "Method Name",
        proto, new MethodHandle(1, new Field("Owner", "Name", "Type")), new Object[]{Constant.Null});

    // Act and Assert
    assertSame(invokeCustomExpr.proto, invokeCustomExpr.getProto());
  }

  /**
   * Method under test: {@link InvokeCustomExpr#clone()}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    // Act
    InvokeCustomExpr actualCloneResult = Exprs
        .nInvokeCustom(new Value[]{nNullResult}, "Name", proto, new MethodHandle(1, field), new Object[]{Constant.Null})
        .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertEquals("InvokeCustomExpr(....)", actualCloneResult.toString0());
    assertEquals("Name", actualCloneResult.name);
    assertNull(actualCloneResult.getArgs());
    assertNull(value.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value).tag);
    assertNull(actualCloneResult.getName());
    assertNull(actualCloneResult.getOwner());
    assertNull(actualCloneResult.getRet());
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    MethodHandle methodHandle = actualCloneResult.handle;
    assertNull(methodHandle.getMethod());
    assertNull(actualCloneResult.method);
    assertEquals(1, methodHandle.getType());
    assertEquals(1, ops.length);
    Object[] objectArray = actualCloneResult.bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.INVOKE_CUSTOM, actualCloneResult.vt);
    assertSame(field, methodHandle.getField());
    assertSame(proto, actualCloneResult.getProto());
    Object object = nNullResult.value;
    assertSame(object, objectArray[0]);
    assertSame(object, ((Constant) value).value);
  }

  /**
   * Method under test: {@link InvokeCustomExpr#clone()}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    InvokeCustomExpr actualCloneResult = Exprs
        .nInvokeCustom(new Value[]{nNullResult}, "Name", proto, null, new Object[]{Constant.Null})
        .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertEquals("InvokeCustomExpr(....)", actualCloneResult.toString0());
    assertEquals("Name", actualCloneResult.name);
    assertNull(actualCloneResult.getArgs());
    assertNull(value.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value).tag);
    assertNull(actualCloneResult.getName());
    assertNull(actualCloneResult.getOwner());
    assertNull(actualCloneResult.getRet());
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertNull(actualCloneResult.method);
    assertNull(actualCloneResult.handle);
    assertEquals(1, ops.length);
    Object[] objectArray = actualCloneResult.bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.INVOKE_CUSTOM, actualCloneResult.vt);
    assertSame(proto, actualCloneResult.getProto());
    Object object = nNullResult.value;
    assertSame(object, objectArray[0]);
    assertSame(object, ((Constant) value).value);
  }

  /**
   * Method under test: {@link InvokeCustomExpr#clone()}
   */
  @Test
  public void testClone3() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokeCustomExpr nInvokeCustomResult = Exprs.nInvokeCustom(new Value[]{nNullResult}, "Name", proto,
        new MethodHandle(1, new Field("Owner", "Name", "Type")), new Object[]{Constant.Null});
    Proto proto2 = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    // Act
    InvokeCustomExpr actualCloneResult = Exprs
        .nInvokeCustom(new Value[]{nInvokeCustomResult}, "Name", proto2, new MethodHandle(1, field),
            new Object[]{Constant.Null})
        .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof InvokeCustomExpr);
    assertEquals("InvokeCustomExpr(....)", actualCloneResult.toString0());
    assertEquals("InvokeCustomExpr(....)", value.toString0());
    assertEquals("Name", actualCloneResult.name);
    assertEquals("Name", ((InvokeCustomExpr) value).name);
    assertNull(actualCloneResult.getArgs());
    assertNull(((InvokeCustomExpr) value).getArgs());
    assertNull(value2.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value2).tag);
    assertNull(((InvokeCustomExpr) value).tag);
    assertNull(actualCloneResult.getName());
    assertNull(((InvokeCustomExpr) value).getName());
    assertNull(actualCloneResult.getOwner());
    assertNull(((InvokeCustomExpr) value).getOwner());
    assertNull(actualCloneResult.getRet());
    assertNull(((InvokeCustomExpr) value).getRet());
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value2).valueType);
    assertNull(((InvokeCustomExpr) value).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value2.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value2.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value2.getOp2());
    assertNull(value.getOp2());
    MethodHandle methodHandle = actualCloneResult.handle;
    assertNull(methodHandle.getMethod());
    assertNull(actualCloneResult.method);
    assertNull(((InvokeCustomExpr) value).method);
    assertEquals(1, methodHandle.getType());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    Object[] objectArray = actualCloneResult.bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(ET.E0, ((Constant) value2).et);
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(ET.En, ((InvokeCustomExpr) value).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.INVOKE_CUSTOM, actualCloneResult.vt);
    assertEquals(Value.VT.INVOKE_CUSTOM, ((InvokeCustomExpr) value).vt);
    assertSame(field, methodHandle.getField());
    assertSame(proto2, actualCloneResult.getProto());
    assertSame(proto, ((InvokeCustomExpr) value).getProto());
    Object object = nNullResult.value;
    assertSame(object, objectArray[0]);
    assertSame(object, ((Constant) value2).value);
    assertSame(nInvokeCustomResult.bsmArgs, ((InvokeCustomExpr) value).bsmArgs);
    assertSame(nInvokeCustomResult.handle, ((InvokeCustomExpr) value).handle);
  }

  /**
   * Method under test: {@link InvokeCustomExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone4() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    InvokeCustomExpr nInvokeCustomResult = Exprs.nInvokeCustom(new Value[]{nNullResult}, "Name", proto,
        new MethodHandle(1, field), new Object[]{Constant.Null});

    // Act
    InvokeCustomExpr actualCloneResult = nInvokeCustomResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertEquals("InvokeCustomExpr(....)", actualCloneResult.toString0());
    assertEquals("Name", actualCloneResult.name);
    assertNull(actualCloneResult.getArgs());
    assertNull(value.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value).tag);
    assertNull(actualCloneResult.getName());
    assertNull(actualCloneResult.getOwner());
    assertNull(actualCloneResult.getRet());
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    MethodHandle methodHandle = actualCloneResult.handle;
    assertNull(methodHandle.getMethod());
    assertNull(actualCloneResult.method);
    assertEquals(1, methodHandle.getType());
    assertEquals(1, ops.length);
    Object[] objectArray = actualCloneResult.bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.INVOKE_CUSTOM, actualCloneResult.vt);
    assertSame(field, methodHandle.getField());
    assertSame(proto, actualCloneResult.getProto());
    Object object = nNullResult.value;
    assertSame(object, objectArray[0]);
    assertSame(object, ((Constant) value).value);
  }

  /**
   * Method under test: {@link InvokeCustomExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone5() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokeCustomExpr nInvokeCustomResult = Exprs.nInvokeCustom(new Value[]{nNullResult}, "Name", proto, null,
        new Object[]{Constant.Null});

    // Act
    InvokeCustomExpr actualCloneResult = nInvokeCustomResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertEquals("InvokeCustomExpr(....)", actualCloneResult.toString0());
    assertEquals("Name", actualCloneResult.name);
    assertNull(actualCloneResult.getArgs());
    assertNull(value.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value).tag);
    assertNull(actualCloneResult.getName());
    assertNull(actualCloneResult.getOwner());
    assertNull(actualCloneResult.getRet());
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value.getOp2());
    assertNull(actualCloneResult.method);
    assertNull(actualCloneResult.handle);
    assertEquals(1, ops.length);
    Object[] objectArray = actualCloneResult.bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    assertEquals(Value.VT.INVOKE_CUSTOM, actualCloneResult.vt);
    assertSame(proto, actualCloneResult.getProto());
    Object object = nNullResult.value;
    assertSame(object, objectArray[0]);
    assertSame(object, ((Constant) value).value);
  }

  /**
   * Method under test: {@link InvokeCustomExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone6() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokeCustomExpr nInvokeCustomResult = Exprs.nInvokeCustom(new Value[]{nNullResult}, "Name", proto,
        new MethodHandle(1, new Field("Owner", "Name", "Type")), new Object[]{Constant.Null});
    Proto proto2 = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    InvokeCustomExpr nInvokeCustomResult2 = Exprs.nInvokeCustom(new Value[]{nInvokeCustomResult}, "Name", proto2,
        new MethodHandle(1, field), new Object[]{Constant.Null});

    // Act
    InvokeCustomExpr actualCloneResult = nInvokeCustomResult2.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof InvokeCustomExpr);
    assertEquals("InvokeCustomExpr(....)", actualCloneResult.toString0());
    assertEquals("InvokeCustomExpr(....)", value.toString0());
    assertEquals("Name", actualCloneResult.name);
    assertEquals("Name", ((InvokeCustomExpr) value).name);
    assertNull(actualCloneResult.getArgs());
    assertNull(((InvokeCustomExpr) value).getArgs());
    assertNull(value2.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value2).tag);
    assertNull(((InvokeCustomExpr) value).tag);
    assertNull(actualCloneResult.getName());
    assertNull(((InvokeCustomExpr) value).getName());
    assertNull(actualCloneResult.getOwner());
    assertNull(((InvokeCustomExpr) value).getOwner());
    assertNull(actualCloneResult.getRet());
    assertNull(((InvokeCustomExpr) value).getRet());
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value2).valueType);
    assertNull(((InvokeCustomExpr) value).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value2.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value2.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value2.getOp2());
    assertNull(value.getOp2());
    MethodHandle methodHandle = actualCloneResult.handle;
    assertNull(methodHandle.getMethod());
    assertNull(actualCloneResult.method);
    assertNull(((InvokeCustomExpr) value).method);
    assertEquals(1, methodHandle.getType());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    Object[] objectArray = actualCloneResult.bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(ET.E0, ((Constant) value2).et);
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(ET.En, ((InvokeCustomExpr) value).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.INVOKE_CUSTOM, actualCloneResult.vt);
    assertEquals(Value.VT.INVOKE_CUSTOM, ((InvokeCustomExpr) value).vt);
    assertSame(field, methodHandle.getField());
    assertSame(proto2, actualCloneResult.getProto());
    assertSame(proto, ((InvokeCustomExpr) value).getProto());
    Object object = nNullResult.value;
    assertSame(object, objectArray[0]);
    assertSame(object, ((Constant) value2).value);
    assertSame(nInvokeCustomResult.bsmArgs, ((InvokeCustomExpr) value).bsmArgs);
    assertSame(nInvokeCustomResult.handle, ((InvokeCustomExpr) value).handle);
  }

  /**
   * Method under test: {@link InvokeCustomExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals("InvokeCustomExpr(....)",
        Exprs
            .nInvokeCustom(new Value[]{new ArrayExpr()}, "Name", proto,
                new MethodHandle(1, new Field("Owner", "Name", "Type")), new Object[]{Constant.Null})
            .toString0());
  }

  /**
   * Method under test:
   * {@link InvokeCustomExpr#InvokeCustomExpr(Value.VT, Value[], String, Proto, MethodHandle, Object[])}
   */
  @Test
  public void testNewInvokeCustomExpr() {
    // Arrange
    Value[] args = new Value[]{new ArrayExpr()};
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    // Act
    InvokeCustomExpr actualInvokeCustomExpr = new InvokeCustomExpr(Value.VT.ADD, args, "Method Name", proto,
        new MethodHandle(1, field), new Object[]{Constant.Null});

    // Assert
    assertEquals("InvokeCustomExpr(....)", actualInvokeCustomExpr.toString0());
    assertEquals("Method Name", actualInvokeCustomExpr.name);
    assertNull(actualInvokeCustomExpr.getArgs());
    assertNull(actualInvokeCustomExpr.tag);
    assertNull(actualInvokeCustomExpr.getName());
    assertNull(actualInvokeCustomExpr.getOwner());
    assertNull(actualInvokeCustomExpr.getRet());
    assertNull(actualInvokeCustomExpr.valueType);
    assertNull(actualInvokeCustomExpr.getOp());
    assertNull(actualInvokeCustomExpr.getOp1());
    assertNull(actualInvokeCustomExpr.getOp2());
    MethodHandle methodHandle = actualInvokeCustomExpr.handle;
    assertNull(methodHandle.getMethod());
    assertNull(actualInvokeCustomExpr.method);
    assertEquals(1, methodHandle.getType());
    assertEquals(1, actualInvokeCustomExpr.bsmArgs.length);
    assertEquals(ET.En, actualInvokeCustomExpr.et);
    assertEquals(Value.VT.ADD, actualInvokeCustomExpr.vt);
    assertSame(field, methodHandle.getField());
    assertSame(proto, actualInvokeCustomExpr.getProto());
    assertSame(args, actualInvokeCustomExpr.getOps());
  }

  /**
   * Method under test:
   * {@link InvokeCustomExpr#InvokeCustomExpr(Value.VT, Value[], String, Proto, MethodHandle, Object[])}
   */
  @Test
  public void testNewInvokeCustomExpr2() {
    // Arrange
    Value[] args = new Value[]{new ArrayExpr()};
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    InvokeCustomExpr actualInvokeCustomExpr = new InvokeCustomExpr(Value.VT.ADD, args, "Method Name", proto, null,
        new Object[]{Constant.Null});

    // Assert
    assertEquals("InvokeCustomExpr(....)", actualInvokeCustomExpr.toString0());
    assertEquals("Method Name", actualInvokeCustomExpr.name);
    assertNull(actualInvokeCustomExpr.getArgs());
    assertNull(actualInvokeCustomExpr.tag);
    assertNull(actualInvokeCustomExpr.getName());
    assertNull(actualInvokeCustomExpr.getOwner());
    assertNull(actualInvokeCustomExpr.getRet());
    assertNull(actualInvokeCustomExpr.valueType);
    assertNull(actualInvokeCustomExpr.getOp());
    assertNull(actualInvokeCustomExpr.getOp1());
    assertNull(actualInvokeCustomExpr.getOp2());
    assertNull(actualInvokeCustomExpr.method);
    assertNull(actualInvokeCustomExpr.handle);
    assertEquals(1, actualInvokeCustomExpr.bsmArgs.length);
    assertEquals(ET.En, actualInvokeCustomExpr.et);
    assertEquals(Value.VT.ADD, actualInvokeCustomExpr.vt);
    assertSame(proto, actualInvokeCustomExpr.getProto());
    assertSame(args, actualInvokeCustomExpr.getOps());
  }
}
