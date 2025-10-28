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

public class InvokePolymorphicExprDiffblueTest {
  /**
   * Method under test: {@link InvokePolymorphicExpr#releaseMemory()}
   */
  @Test
  public void testReleaseMemory() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokePolymorphicExpr nInvokePolymorphicResult = Exprs.nInvokePolymorphic(new Value[]{new ArrayExpr()}, proto,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act
    nInvokePolymorphicResult.releaseMemory();

    // Assert
    assertNull(nInvokePolymorphicResult.getArgs());
    assertNull(nInvokePolymorphicResult.getOps());
    assertNull(nInvokePolymorphicResult.getName());
    assertNull(nInvokePolymorphicResult.getOwner());
    assertNull(nInvokePolymorphicResult.getRet());
    assertNull(nInvokePolymorphicResult.method);
    assertNull(nInvokePolymorphicResult.getProto());
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#getProto()}
   */
  @Test
  public void testGetProto() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokePolymorphicExpr invokePolymorphicExpr = new InvokePolymorphicExpr(Value.VT.ADD, new Value[]{new ArrayExpr()},
        proto, new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    // Act and Assert
    assertSame(invokePolymorphicExpr.proto, invokePolymorphicExpr.getProto());
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#clone()}
   */
  @Test
  public void testClone() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Proto proto2 = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    InvokePolymorphicExpr actualCloneResult = Exprs
        .nInvokePolymorphic(new Value[]{nNullResult}, proto, new Method("Owner", "Name", proto2))
        .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    Method method = actualCloneResult.method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualCloneResult.getRet());
    assertEquals("Return Type", method.getReturnType());
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
    assertEquals(Value.VT.INVOKE_POLYMORPHIC, actualCloneResult.vt);
    assertSame(proto, actualCloneResult.getProto());
    assertSame(proto2, method.getProto());
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(nNullResult.value, ((Constant) value).value);
    assertArrayEquals(new String[]{"Parameter Types"}, args);
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#clone()}
   */
  @Test
  public void testClone2() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeInterfaceResult = Exprs.nInvokeInterface(new Value[]{nNullResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Proto proto2 = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    InvokePolymorphicExpr actualCloneResult = Exprs
        .nInvokePolymorphic(new Value[]{nInvokeInterfaceResult}, proto, new Method("Owner", "Name", proto2))
        .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof InvokeExpr);
    Proto proto3 = ((InvokeExpr) value).getProto();
    assertEquals("(Argment Types)Return Type", proto3.getDesc());
    Method method = actualCloneResult.method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualCloneResult.getRet());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto3.getReturnType());
    assertEquals("null.Name()", value.toString0());
    assertEquals("null.Name().Name()", actualCloneResult.toString0());
    assertNull(value2.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value2).tag);
    assertNull(((InvokeExpr) value).tag);
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value2).valueType);
    assertNull(((InvokeExpr) value).valueType);
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
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(ET.En, ((InvokeExpr) value).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    assertEquals(Value.VT.INVOKE_POLYMORPHIC, actualCloneResult.vt);
    assertSame(proto, actualCloneResult.getProto());
    assertSame(proto2, method.getProto());
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    String[] args2 = ((InvokeExpr) value).getArgs();
    assertSame(args2, proto3.getParameterTypes());
    assertSame(nNullResult.value, ((Constant) value2).value);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
    assertArrayEquals(new String[]{"Argment Types"}, args2);
    assertArrayEquals(new String[]{"Parameter Types"}, args);
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#clone()}
   */
  @Test
  public void testClone3() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeInterfaceResult = Exprs.nInvokeInterface(new Value[]{nNullResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");
    InvokeExpr nInvokeInterfaceResult2 = Exprs.nInvokeInterface(new Value[]{nInvokeInterfaceResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Proto proto2 = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    InvokePolymorphicExpr actualCloneResult = Exprs
        .nInvokePolymorphic(new Value[]{nInvokeInterfaceResult2}, proto, new Method("Owner", "Name", proto2))
        .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    Value[] ops3 = value2.getOps();
    Value value3 = ops3[0];
    assertTrue(value3 instanceof Constant);
    assertTrue(value2 instanceof InvokeExpr);
    assertTrue(value instanceof InvokeExpr);
    Proto proto3 = ((InvokeExpr) value).getProto();
    assertEquals("(Argment Types)Return Type", proto3.getDesc());
    Method method = actualCloneResult.method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", ((InvokeExpr) value2).getName());
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", ((InvokeExpr) value2).getOwner());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualCloneResult.getRet());
    assertEquals("Return Type", ((InvokeExpr) value2).getRet());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto3.getReturnType());
    assertEquals("null.Name()", value2.toString0());
    assertEquals("null.Name().Name()", value.toString0());
    assertEquals("null.Name().Name().Name()", actualCloneResult.toString0());
    assertNull(value3.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value3).tag);
    assertNull(((InvokeExpr) value2).tag);
    assertNull(((InvokeExpr) value).tag);
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value3).valueType);
    assertNull(((InvokeExpr) value2).valueType);
    assertNull(((InvokeExpr) value).valueType);
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
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(ET.En, ((InvokeExpr) value2).et);
    assertEquals(ET.En, ((InvokeExpr) value).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value3).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value2).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    assertEquals(Value.VT.INVOKE_POLYMORPHIC, actualCloneResult.vt);
    assertEquals(((InvokeExpr) value2).getProto(), ((InvokeExpr) value2).getProto());
    assertSame(proto, actualCloneResult.getProto());
    assertSame(proto2, method.getProto());
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(nNullResult.value, ((Constant) value3).value);
    assertSame(nInvokeInterfaceResult2.method, ((InvokeExpr) value).method);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value2).method);
    assertArrayEquals(new String[]{"Argment Types"}, ((InvokeExpr) value2).getArgs());
    assertArrayEquals(new String[]{"Argment Types"}, ((InvokeExpr) value).getArgs());
    assertArrayEquals(new String[]{"Parameter Types"}, args);
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone4() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Proto proto2 = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokePolymorphicExpr nInvokePolymorphicResult = Exprs.nInvokePolymorphic(new Value[]{nNullResult}, proto,
        new Method("Owner", "Name", proto2));

    // Act
    InvokePolymorphicExpr actualCloneResult = nInvokePolymorphicResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    Method method = actualCloneResult.method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualCloneResult.getRet());
    assertEquals("Return Type", method.getReturnType());
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
    assertEquals(Value.VT.INVOKE_POLYMORPHIC, actualCloneResult.vt);
    assertSame(proto, actualCloneResult.getProto());
    assertSame(proto2, method.getProto());
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(nNullResult.value, ((Constant) value).value);
    assertArrayEquals(new String[]{"Parameter Types"}, args);
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone5() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeInterfaceResult = Exprs.nInvokeInterface(new Value[]{nNullResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Proto proto2 = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokePolymorphicExpr nInvokePolymorphicResult = Exprs.nInvokePolymorphic(new Value[]{nInvokeInterfaceResult},
        proto, new Method("Owner", "Name", proto2));

    // Act
    InvokePolymorphicExpr actualCloneResult = nInvokePolymorphicResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    assertTrue(value2 instanceof Constant);
    assertTrue(value instanceof InvokeExpr);
    Proto proto3 = ((InvokeExpr) value).getProto();
    assertEquals("(Argment Types)Return Type", proto3.getDesc());
    Method method = actualCloneResult.method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualCloneResult.getRet());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto3.getReturnType());
    assertEquals("null.Name()", value.toString0());
    assertEquals("null.Name().Name()", actualCloneResult.toString0());
    assertNull(value2.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value2).tag);
    assertNull(((InvokeExpr) value).tag);
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value2).valueType);
    assertNull(((InvokeExpr) value).valueType);
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
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(ET.En, ((InvokeExpr) value).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value2).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    assertEquals(Value.VT.INVOKE_POLYMORPHIC, actualCloneResult.vt);
    assertSame(proto, actualCloneResult.getProto());
    assertSame(proto2, method.getProto());
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    String[] args2 = ((InvokeExpr) value).getArgs();
    assertSame(args2, proto3.getParameterTypes());
    assertSame(nNullResult.value, ((Constant) value2).value);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
    assertArrayEquals(new String[]{"Argment Types"}, args2);
    assertArrayEquals(new String[]{"Parameter Types"}, args);
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  public void testClone6() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeInterfaceResult = Exprs.nInvokeInterface(new Value[]{nNullResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");
    InvokeExpr nInvokeInterfaceResult2 = Exprs.nInvokeInterface(new Value[]{nInvokeInterfaceResult}, "Owner", "Name",
        new String[]{"Argment Types"}, "Return Type");
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Proto proto2 = new Proto(new String[]{"Parameter Types"}, "Return Type");

    InvokePolymorphicExpr nInvokePolymorphicResult = Exprs.nInvokePolymorphic(new Value[]{nInvokeInterfaceResult2},
        proto, new Method("Owner", "Name", proto2));

    // Act
    InvokePolymorphicExpr actualCloneResult = nInvokePolymorphicResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    Value value2 = ops2[0];
    Value[] ops3 = value2.getOps();
    Value value3 = ops3[0];
    assertTrue(value3 instanceof Constant);
    assertTrue(value2 instanceof InvokeExpr);
    assertTrue(value instanceof InvokeExpr);
    Proto proto3 = ((InvokeExpr) value).getProto();
    assertEquals("(Argment Types)Return Type", proto3.getDesc());
    Method method = actualCloneResult.method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", ((InvokeExpr) value2).getName());
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualCloneResult.getOwner());
    assertEquals("Owner", ((InvokeExpr) value2).getOwner());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualCloneResult.getRet());
    assertEquals("Return Type", ((InvokeExpr) value2).getRet());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto3.getReturnType());
    assertEquals("null.Name()", value2.toString0());
    assertEquals("null.Name().Name()", value.toString0());
    assertEquals("null.Name().Name().Name()", actualCloneResult.toString0());
    assertNull(value3.getOps());
    assertNull(actualCloneResult.tag);
    assertNull(((Constant) value3).tag);
    assertNull(((InvokeExpr) value2).tag);
    assertNull(((InvokeExpr) value).tag);
    assertNull(actualCloneResult.valueType);
    assertNull(((Constant) value3).valueType);
    assertNull(((InvokeExpr) value2).valueType);
    assertNull(((InvokeExpr) value).valueType);
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
    assertEquals(ET.En, actualCloneResult.et);
    assertEquals(ET.En, ((InvokeExpr) value2).et);
    assertEquals(ET.En, ((InvokeExpr) value).et);
    assertEquals(Value.VT.CONSTANT, ((Constant) value3).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value2).vt);
    assertEquals(Value.VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    assertEquals(Value.VT.INVOKE_POLYMORPHIC, actualCloneResult.vt);
    assertEquals(((InvokeExpr) value2).getProto(), ((InvokeExpr) value2).getProto());
    assertSame(proto, actualCloneResult.getProto());
    assertSame(proto2, method.getProto());
    String[] args = actualCloneResult.getArgs();
    assertSame(args, method.getParameterTypes());
    assertSame(nNullResult.value, ((Constant) value3).value);
    assertSame(nInvokeInterfaceResult2.method, ((InvokeExpr) value).method);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value2).method);
    assertArrayEquals(new String[]{"Argment Types"}, ((InvokeExpr) value2).getArgs());
    assertArrayEquals(new String[]{"Argment Types"}, ((InvokeExpr) value).getArgs());
    assertArrayEquals(new String[]{"Parameter Types"}, args);
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  public void testToString0() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals("null[null].Name()",
        Exprs
            .nInvokePolymorphic(new Value[]{new ArrayExpr()}, proto,
                new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")))
            .toString0());
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  public void testToString02() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals("new [][]{null[null]}.Name()",
        Exprs
            .nInvokePolymorphic(new Value[]{Exprs.nFilledArray("[", new Value[]{new ArrayExpr()})}, proto,
                new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")))
            .toString0());
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  public void testToString03() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals("new [](null[null]).Name()",
        Exprs
            .nInvokePolymorphic(new Value[]{Exprs.nInvokeNew(new Value[]{new ArrayExpr()}, new String[]{"["}, "[")},
                proto, new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")))
            .toString0());
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  public void testToString04() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals("((double)null[null]).Name()",
        Exprs
            .nInvokePolymorphic(new Value[]{Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "D")}, proto,
                new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")))
            .toString0());
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  public void testToString05() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals("((float)null[null]).Name()",
        Exprs
            .nInvokePolymorphic(new Value[]{Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "F")}, proto,
                new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")))
            .toString0());
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  public void testToString06() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    Proto proto = new Proto(new String[]{"["}, "Return Type");

    // Act and Assert
    assertEquals("null[null].Name(([])null[null])",
        Exprs
            .nInvokePolymorphic(new Value[]{arrayExpr, new ArrayExpr()}, proto,
                new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")))
            .toString0());
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  public void testToString07() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals("new [](null[null],null[null]).Name()",
        Exprs
            .nInvokePolymorphic(
                new Value[]{Exprs.nInvokeNew(new Value[]{arrayExpr, new ArrayExpr()}, new String[]{"["}, "[")}, proto,
                new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")))
            .toString0());
  }

  /**
   * Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  public void testToString08() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals("((int)null[null]).Name()",
        Exprs
            .nInvokePolymorphic(new Value[]{Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "I")}, proto,
                new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")))
            .toString0());
  }

  /**
   * Method under test:
   * {@link InvokePolymorphicExpr#InvokePolymorphicExpr(Value.VT, Value[], Proto, Method)}
   */
  @Test
  public void testNewInvokePolymorphicExpr() {
    // Arrange
    Value[] args = new Value[]{new ArrayExpr()};
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    Proto proto2 = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act
    InvokePolymorphicExpr actualInvokePolymorphicExpr = new InvokePolymorphicExpr(Value.VT.ADD, args, proto,
        new Method("Owner", "Name", proto2));

    // Assert
    Method method = actualInvokePolymorphicExpr.method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", actualInvokePolymorphicExpr.getName());
    assertEquals("Name", method.getName());
    assertEquals("Owner", actualInvokePolymorphicExpr.getOwner());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", actualInvokePolymorphicExpr.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("null[null].Name()", actualInvokePolymorphicExpr.toString0());
    assertNull(actualInvokePolymorphicExpr.tag);
    assertNull(actualInvokePolymorphicExpr.valueType);
    assertNull(actualInvokePolymorphicExpr.getOp());
    assertNull(actualInvokePolymorphicExpr.getOp1());
    assertNull(actualInvokePolymorphicExpr.getOp2());
    assertEquals(ET.En, actualInvokePolymorphicExpr.et);
    assertEquals(Value.VT.ADD, actualInvokePolymorphicExpr.vt);
    assertSame(proto, actualInvokePolymorphicExpr.getProto());
    assertSame(proto2, method.getProto());
    String[] args2 = actualInvokePolymorphicExpr.getArgs();
    assertSame(args2, method.getParameterTypes());
    assertSame(args, actualInvokePolymorphicExpr.getOps());
    assertArrayEquals(new String[]{"Parameter Types"}, args2);
  }
}
