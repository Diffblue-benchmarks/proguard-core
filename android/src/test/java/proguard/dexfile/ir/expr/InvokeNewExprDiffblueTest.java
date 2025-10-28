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

public class InvokeNewExprDiffblueTest {
  /**
   * Method under test: {@link InvokeNewExpr#getClassName()}
   */
  @Test
  public void testGetClassName() {
    // Arrange, Act and Assert
    assertEquals("Owner", (new InvokeNewExpr(Value.VT.ADD, new Value[]{new ArrayExpr()}, "Owner Type", "Method Name",
        new String[]{"Argument Types"}, "Owner")).getClassName());
  }

  /**
   * Method under test: {@link InvokeNewExpr#clone()}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant nNullResult = Exprs.nNull();

    // Act
    InvokeExpr actualCloneResult = (new InvokeNewExpr(Value.VT.ADD, new Value[]{nNullResult}, "Owner Type",
        "Method Name", new String[]{"Argument Types"}, "Owner")).clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argument Types)Owner", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argument Types)Owner", proto.getDesc());
    assertEquals("Method Name", actualCloneResult.getName());
    assertEquals("Method Name", method.getName());
    assertEquals("Owner Type", actualCloneResult.getOwner());
    assertEquals("Owner Type", method.getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertEquals("null.Method Name()", actualCloneResult.toString0());
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
    assertEquals(Value.VT.ADD, ((InvokeNewExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto.getParameterTypes());
    assertSame(proto, method.getProto());
    assertSame(nNullResult.value, ((Constant) value).value);
    assertArrayEquals(new String[]{"Argument Types"}, args);
  }

  /**
   * Method under test: {@link InvokeNewExpr#clone()}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{nNullResult}, new String[]{"Argment Types"}, "Owner");

    // Act
    InvokeExpr actualCloneResult = (new InvokeNewExpr(Value.VT.ADD, new Value[]{nInvokeNewResult}, "Owner Type",
        "Method Name", new String[]{"Argument Types"}, "Owner")).clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertTrue(value instanceof InvokeNewExpr);
    Proto proto = ((InvokeNewExpr) value).getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argument Types)Owner", method.getDesc());
    Proto proto2 = actualCloneResult.getProto();
    assertEquals("(Argument Types)Owner", proto2.getDesc());
    assertEquals("<init>", ((InvokeNewExpr) value).getName());
    assertEquals("Method Name", actualCloneResult.getName());
    assertEquals("Method Name", method.getName());
    assertEquals("Owner Type", actualCloneResult.getOwner());
    assertEquals("Owner Type", method.getOwner());
    assertEquals("Owner", ((InvokeNewExpr) value).getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) value).getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", ((InvokeNewExpr) value).getClassName());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto2.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertNull(value2.getOps());
    assertNull(((Constant) value2).tag);
    assertNull(((InvokeNewExpr) actualCloneResult).tag);
    assertNull(((InvokeNewExpr) value).tag);
    assertNull(((Constant) value2).valueType);
    assertNull(((InvokeNewExpr) actualCloneResult).valueType);
    assertNull(((InvokeNewExpr) value).valueType);
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
    assertEquals(ET.En, ((InvokeNewExpr) actualCloneResult).et);
    assertEquals(ET.En, ((InvokeNewExpr) value).et);
    assertEquals(Value.VT.ADD, ((InvokeNewExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) value).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto2.getParameterTypes());
    String[] args2 = ((InvokeNewExpr) value).getArgs();
    assertSame(args2, proto.getParameterTypes());
    assertSame(proto2, method.getProto());
    assertSame(nNullResult.value, ((Constant) value2).value);
    assertSame(nInvokeNewResult.method, ((InvokeNewExpr) value).method);
    assertArrayEquals(new String[]{"Argment Types"}, args2);
    assertArrayEquals(new String[]{"Argument Types"}, args);
  }

  /**
   * Method under test: {@link InvokeNewExpr#clone()}
   */
  @Test
  public void testClone3() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeInterfaceResult = Exprs.nInvokeInterface(new Value[]{nNullResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");

    // Act
    InvokeExpr actualCloneResult = (new InvokeNewExpr(Value.VT.ADD, new Value[]{nInvokeInterfaceResult}, "Owner Type",
        "Method Name", new String[]{"Argument Types"}, "Owner")).clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Proto proto = ((InvokeExpr) value).getProto();
    assertEquals("(Argment Types)Return Type", proto.getDesc());
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argument Types)Owner", method.getDesc());
    Proto proto2 = actualCloneResult.getProto();
    assertEquals("(Argument Types)Owner", proto2.getDesc());
    assertEquals("Method Name", actualCloneResult.getName());
    assertEquals("Method Name", method.getName());
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Owner Type", actualCloneResult.getOwner());
    assertEquals("Owner Type", method.getOwner());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto2.getReturnType());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("Return Type", proto.getReturnType());
    assertEquals("null.Name()", value.toString0());
    assertEquals("null.Name().Method Name()", actualCloneResult.toString0());
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
    assertEquals(Value.VT.ADD, ((InvokeNewExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto2.getParameterTypes());
    String[] args2 = ((InvokeExpr) value).getArgs();
    assertSame(args2, proto.getParameterTypes());
    assertSame(proto2, method.getProto());
    assertSame(nNullResult.value, ((Constant) value2).value);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
    assertArrayEquals(new String[]{"Argment Types"}, args2);
    assertArrayEquals(new String[]{"Argument Types"}, args);
  }

  /**
   * Method under test: {@link InvokeNewExpr#clone()}
   */
  @Test
  public void testClone4() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{nNullResult}, new String[]{"Argment Types"}, "Owner");
    InvokeExpr nInvokeInterfaceResult = Exprs.nInvokeInterface(new Value[]{nInvokeNewResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");

    // Act
    InvokeExpr actualCloneResult = (new InvokeNewExpr(Value.VT.ADD, new Value[]{nInvokeInterfaceResult}, "Owner Type",
        "Method Name", new String[]{"Argument Types"}, "Owner")).clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    Value[] ops3 = value2.getOps();
    Value value3 = ops3[0];
    assertTrue(value3 instanceof Constant);
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertTrue(value2 instanceof InvokeNewExpr);
    Proto proto = ((InvokeNewExpr) value2).getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    Proto proto2 = ((InvokeExpr) value).getProto();
    assertEquals("(Argment Types)Return Type", proto2.getDesc());
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argument Types)Owner", method.getDesc());
    Proto proto3 = actualCloneResult.getProto();
    assertEquals("(Argument Types)Owner", proto3.getDesc());
    assertEquals("<init>", ((InvokeNewExpr) value2).getName());
    assertEquals("Method Name", actualCloneResult.getName());
    assertEquals("Method Name", method.getName());
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Owner Type", actualCloneResult.getOwner());
    assertEquals("Owner Type", method.getOwner());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Owner", ((InvokeNewExpr) value2).getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) value2).getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", ((InvokeNewExpr) value2).getClassName());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto3.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("Return Type", proto2.getReturnType());
    assertNull(value3.getOps());
    assertNull(((Constant) value3).tag);
    assertNull(((InvokeExpr) value).tag);
    assertNull(((InvokeNewExpr) actualCloneResult).tag);
    assertNull(((InvokeNewExpr) value2).tag);
    assertNull(((Constant) value3).valueType);
    assertNull(((InvokeExpr) value).valueType);
    assertNull(((InvokeNewExpr) actualCloneResult).valueType);
    assertNull(((InvokeNewExpr) value2).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value3.getOp());
    assertNull(value2.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value3.getOp1());
    assertNull(value2.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value3.getOp2());
    assertNull(value2.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops3.length);
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value3).et);
    assertEquals(ET.En, ((InvokeExpr) value).et);
    assertEquals(ET.En, ((InvokeNewExpr) actualCloneResult).et);
    assertEquals(ET.En, ((InvokeNewExpr) value2).et);
    assertEquals(Value.VT.ADD, ((InvokeNewExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) value3).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) value2).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto3.getParameterTypes());
    assertSame(proto3, method.getProto());
    assertSame(nNullResult.value, ((Constant) value3).value);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
    assertSame(nInvokeNewResult.method, ((InvokeNewExpr) value2).method);
    assertArrayEquals(new String[]{"Argment Types"}, ((InvokeExpr) value).getArgs());
    assertArrayEquals(new String[]{"Argment Types"}, ((InvokeNewExpr) value2).getArgs());
    assertArrayEquals(new String[]{"Argument Types"}, args);
  }

  /**
   * Method under test: {@link InvokeNewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone5() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeNewExpr invokeNewExpr = new InvokeNewExpr(Value.VT.ADD, new Value[]{nNullResult}, "Owner Type", "Method Name",
        new String[]{"Argument Types"}, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argument Types)Owner", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argument Types)Owner", proto.getDesc());
    assertEquals("Method Name", actualCloneResult.getName());
    assertEquals("Method Name", method.getName());
    assertEquals("Owner Type", actualCloneResult.getOwner());
    assertEquals("Owner Type", method.getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertEquals("null.Method Name()", actualCloneResult.toString0());
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
    assertEquals(Value.VT.ADD, ((InvokeNewExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) value).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto.getParameterTypes());
    assertSame(proto, method.getProto());
    assertSame(nNullResult.value, ((Constant) value).value);
    assertArrayEquals(new String[]{"Argument Types"}, args);
  }

  /**
   * Method under test: {@link InvokeNewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone6() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{nNullResult}, new String[]{"Argment Types"}, "Owner");
    InvokeNewExpr invokeNewExpr = new InvokeNewExpr(Value.VT.ADD, new Value[]{nInvokeNewResult}, "Owner Type",
        "Method Name", new String[]{"Argument Types"}, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertTrue(value instanceof InvokeNewExpr);
    Proto proto = ((InvokeNewExpr) value).getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argument Types)Owner", method.getDesc());
    Proto proto2 = actualCloneResult.getProto();
    assertEquals("(Argument Types)Owner", proto2.getDesc());
    assertEquals("<init>", ((InvokeNewExpr) value).getName());
    assertEquals("Method Name", actualCloneResult.getName());
    assertEquals("Method Name", method.getName());
    assertEquals("Owner Type", actualCloneResult.getOwner());
    assertEquals("Owner Type", method.getOwner());
    assertEquals("Owner", ((InvokeNewExpr) value).getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) value).getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", ((InvokeNewExpr) value).getClassName());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto2.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertNull(value2.getOps());
    assertNull(((Constant) value2).tag);
    assertNull(((InvokeNewExpr) actualCloneResult).tag);
    assertNull(((InvokeNewExpr) value).tag);
    assertNull(((Constant) value2).valueType);
    assertNull(((InvokeNewExpr) actualCloneResult).valueType);
    assertNull(((InvokeNewExpr) value).valueType);
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
    assertEquals(ET.En, ((InvokeNewExpr) actualCloneResult).et);
    assertEquals(ET.En, ((InvokeNewExpr) value).et);
    assertEquals(Value.VT.ADD, ((InvokeNewExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) value).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto2.getParameterTypes());
    String[] args2 = ((InvokeNewExpr) value).getArgs();
    assertSame(args2, proto.getParameterTypes());
    assertSame(proto2, method.getProto());
    assertSame(nNullResult.value, ((Constant) value2).value);
    assertSame(nInvokeNewResult.method, ((InvokeNewExpr) value).method);
    assertArrayEquals(new String[]{"Argment Types"}, args2);
    assertArrayEquals(new String[]{"Argument Types"}, args);
  }

  /**
   * Method under test: {@link InvokeNewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone7() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeInterfaceResult = Exprs.nInvokeInterface(new Value[]{nNullResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");
    InvokeNewExpr invokeNewExpr = new InvokeNewExpr(Value.VT.ADD, new Value[]{nInvokeInterfaceResult}, "Owner Type",
        "Method Name", new String[]{"Argument Types"}, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Proto proto = ((InvokeExpr) value).getProto();
    assertEquals("(Argment Types)Return Type", proto.getDesc());
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argument Types)Owner", method.getDesc());
    Proto proto2 = actualCloneResult.getProto();
    assertEquals("(Argument Types)Owner", proto2.getDesc());
    assertEquals("Method Name", actualCloneResult.getName());
    assertEquals("Method Name", method.getName());
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Owner Type", actualCloneResult.getOwner());
    assertEquals("Owner Type", method.getOwner());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto2.getReturnType());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("Return Type", proto.getReturnType());
    assertEquals("null.Name()", value.toString0());
    assertEquals("null.Name().Method Name()", actualCloneResult.toString0());
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
    assertEquals(Value.VT.ADD, ((InvokeNewExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto2.getParameterTypes());
    String[] args2 = ((InvokeExpr) value).getArgs();
    assertSame(args2, proto.getParameterTypes());
    assertSame(proto2, method.getProto());
    assertSame(nNullResult.value, ((Constant) value2).value);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
    assertArrayEquals(new String[]{"Argment Types"}, args2);
    assertArrayEquals(new String[]{"Argument Types"}, args);
  }

  /**
   * Method under test: {@link InvokeNewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone8() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeNewResult = Exprs.nInvokeNew(new Value[]{nNullResult}, new String[]{"Argment Types"}, "Owner");
    InvokeExpr nInvokeInterfaceResult = Exprs.nInvokeInterface(new Value[]{nInvokeNewResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");
    InvokeNewExpr invokeNewExpr = new InvokeNewExpr(Value.VT.ADD, new Value[]{nInvokeInterfaceResult}, "Owner Type",
        "Method Name", new String[]{"Argument Types"}, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    Value[] ops3 = value2.getOps();
    Value value3 = ops3[0];
    assertTrue(value3 instanceof Constant);
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertTrue(value2 instanceof InvokeNewExpr);
    Proto proto = ((InvokeNewExpr) value2).getProto();
    assertEquals("(Argment Types)Owner", proto.getDesc());
    Proto proto2 = ((InvokeExpr) value).getProto();
    assertEquals("(Argment Types)Return Type", proto2.getDesc());
    Method method = ((InvokeNewExpr) actualCloneResult).method;
    assertEquals("(Argument Types)Owner", method.getDesc());
    Proto proto3 = actualCloneResult.getProto();
    assertEquals("(Argument Types)Owner", proto3.getDesc());
    assertEquals("<init>", ((InvokeNewExpr) value2).getName());
    assertEquals("Method Name", actualCloneResult.getName());
    assertEquals("Method Name", method.getName());
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Owner Type", actualCloneResult.getOwner());
    assertEquals("Owner Type", method.getOwner());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Owner", ((InvokeNewExpr) value2).getOwner());
    assertEquals("Owner", actualCloneResult.getRet());
    assertEquals("Owner", ((InvokeNewExpr) value2).getRet());
    assertEquals("Owner", ((InvokeNewExpr) actualCloneResult).getClassName());
    assertEquals("Owner", ((InvokeNewExpr) value2).getClassName());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto3.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("Return Type", proto2.getReturnType());
    assertNull(value3.getOps());
    assertNull(((Constant) value3).tag);
    assertNull(((InvokeExpr) value).tag);
    assertNull(((InvokeNewExpr) actualCloneResult).tag);
    assertNull(((InvokeNewExpr) value2).tag);
    assertNull(((Constant) value3).valueType);
    assertNull(((InvokeExpr) value).valueType);
    assertNull(((InvokeNewExpr) actualCloneResult).valueType);
    assertNull(((InvokeNewExpr) value2).valueType);
    assertNull(actualCloneResult.getOp());
    assertNull(value3.getOp());
    assertNull(value2.getOp());
    assertNull(value.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(value3.getOp1());
    assertNull(value2.getOp1());
    assertNull(value.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(value3.getOp2());
    assertNull(value2.getOp2());
    assertNull(value.getOp2());
    assertEquals(1, ops3.length);
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value3).et);
    assertEquals(ET.En, ((InvokeExpr) value).et);
    assertEquals(ET.En, ((InvokeNewExpr) actualCloneResult).et);
    assertEquals(ET.En, ((InvokeNewExpr) value2).et);
    assertEquals(Value.VT.ADD, ((InvokeNewExpr) actualCloneResult).vt);
    assertEquals(Value.VT.CONSTANT, ((Constant) value3).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    assertEquals(Value.VT.INVOKE_NEW, ((InvokeNewExpr) value2).vt);
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(args, proto3.getParameterTypes());
    assertSame(proto3, method.getProto());
    assertSame(nNullResult.value, ((Constant) value3).value);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
    assertSame(nInvokeNewResult.method, ((InvokeNewExpr) value2).method);
    assertArrayEquals(new String[]{"Argment Types"}, ((InvokeExpr) value).getArgs());
    assertArrayEquals(new String[]{"Argment Types"}, ((InvokeNewExpr) value2).getArgs());
    assertArrayEquals(new String[]{"Argument Types"}, args);
  }

  /**
   * Method under test:
   * {@link InvokeNewExpr#InvokeNewExpr(Value.VT, Value[], String, String, String[], String)}
   */
  @Test
  public void testNewInvokeNewExpr() {
    // Arrange
    Value[] args = new Value[]{new ArrayExpr()};
    String[] argumentTypes = new String[]{"Argument Types"};

    // Act
    InvokeNewExpr actualInvokeNewExpr = new InvokeNewExpr(Value.VT.ADD, args, "Owner Type", "Method Name",
        argumentTypes, "Owner");

    // Assert
    Method method = actualInvokeNewExpr.method;
    assertEquals("(Argument Types)Owner", method.getDesc());
    Proto proto = actualInvokeNewExpr.getProto();
    assertEquals("(Argument Types)Owner", proto.getDesc());
    assertEquals("Method Name", actualInvokeNewExpr.getName());
    assertEquals("Method Name", method.getName());
    assertEquals("Owner Type", actualInvokeNewExpr.getOwner());
    assertEquals("Owner Type", method.getOwner());
    assertEquals("Owner", actualInvokeNewExpr.getRet());
    assertEquals("Owner", actualInvokeNewExpr.getClassName());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertEquals("null[null].Method Name()", actualInvokeNewExpr.toString0());
    assertNull(actualInvokeNewExpr.tag);
    assertNull(actualInvokeNewExpr.valueType);
    assertNull(actualInvokeNewExpr.getOp());
    assertNull(actualInvokeNewExpr.getOp1());
    assertNull(actualInvokeNewExpr.getOp2());
    assertEquals(ET.En, actualInvokeNewExpr.et);
    assertEquals(Value.VT.ADD, actualInvokeNewExpr.vt);
    assertSame(proto, method.getProto());
    String[] args2 = actualInvokeNewExpr.getArgs();
    assertSame(argumentTypes, args2);
    assertSame(argumentTypes, method.getParameterTypes());
    assertSame(argumentTypes, proto.getParameterTypes());
    assertSame(args, actualInvokeNewExpr.getOps());
    assertArrayEquals(new String[]{"Argument Types"}, args2);
  }

  /**
   * Method under test:
   * {@link InvokeNewExpr#InvokeNewExpr(Value.VT, Value[], String, String, String[], String, String)}
   */
  @Test
  public void testNewInvokeNewExpr2() {
    // Arrange
    Value[] args = new Value[]{new ArrayExpr()};
    String[] argumentTypes = new String[]{"Argument Types"};

    // Act
    InvokeNewExpr actualInvokeNewExpr = new InvokeNewExpr(Value.VT.ADD, args, "Owner Type", "Method Name",
        argumentTypes, "Owner", "Class Name");

    // Assert
    Method method = actualInvokeNewExpr.method;
    assertEquals("(Argument Types)Owner", method.getDesc());
    Proto proto = actualInvokeNewExpr.getProto();
    assertEquals("(Argument Types)Owner", proto.getDesc());
    assertEquals("Class Name", actualInvokeNewExpr.getClassName());
    assertEquals("Method Name", actualInvokeNewExpr.getName());
    assertEquals("Method Name", method.getName());
    assertEquals("Owner Type", actualInvokeNewExpr.getOwner());
    assertEquals("Owner Type", method.getOwner());
    assertEquals("Owner", actualInvokeNewExpr.getRet());
    assertEquals("Owner", method.getReturnType());
    assertEquals("Owner", proto.getReturnType());
    assertEquals("null[null].Method Name()", actualInvokeNewExpr.toString0());
    assertNull(actualInvokeNewExpr.tag);
    assertNull(actualInvokeNewExpr.valueType);
    assertNull(actualInvokeNewExpr.getOp());
    assertNull(actualInvokeNewExpr.getOp1());
    assertNull(actualInvokeNewExpr.getOp2());
    assertEquals(ET.En, actualInvokeNewExpr.et);
    assertEquals(Value.VT.ADD, actualInvokeNewExpr.vt);
    assertSame(proto, method.getProto());
    String[] args2 = actualInvokeNewExpr.getArgs();
    assertSame(argumentTypes, args2);
    assertSame(argumentTypes, method.getParameterTypes());
    assertSame(argumentTypes, proto.getParameterTypes());
    assertSame(args, actualInvokeNewExpr.getOps());
    assertArrayEquals(new String[]{"Argument Types"}, args2);
  }
}
