package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Proto;

public class InvokeCustomExprDiffblueTest {
  /**
   * Test {@link InvokeCustomExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link InvokeCustomExpr#releaseMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvokeCustomExpr.releaseMemory()"})
  public void testReleaseMemory() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {new ArrayExpr()},
            "Name",
            proto,
            new MethodHandle(1, new Field("Owner", "Name", "Type")),
            new Object[] {Constant.Null});

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
   * Test {@link InvokeCustomExpr#getProto()}.
   *
   * <p>Method under test: {@link InvokeCustomExpr#getProto()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Proto InvokeCustomExpr.getProto()"})
  public void testGetProto() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokeCustomExpr invokeCustomExpr =
        new InvokeCustomExpr(
            VT.ADD,
            new Value[] {new ArrayExpr()},
            "Method Name",
            proto,
            new MethodHandle(1, new Field("Owner", "Name", "Type")),
            new Object[] {Constant.Null});

    // Act and Assert
    assertSame(invokeCustomExpr.proto, invokeCustomExpr.getProto());
  }

  /**
   * Test {@link InvokeCustomExpr#InvokeCustomExpr(VT, Value[], String, Proto, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>Then return {@link InvokeCustomExpr#handle} Method is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#InvokeCustomExpr(VT, Value[], String, Proto,
   * MethodHandle, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InvokeCustomExpr.<init>(VT, Value[], String, Proto, MethodHandle, Object[])"
  })
  public void testNewInvokeCustomExpr_thenReturnHandleMethodIsNull() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    // Act and Assert
    MethodHandle methodHandle =
        (new InvokeCustomExpr(
                VT.ADD,
                new Value[] {new ArrayExpr()},
                "Method Name",
                proto,
                new MethodHandle(1, field),
                new Object[] {Constant.Null}))
            .handle;
    assertNull(methodHandle.getMethod());
    assertEquals(1, methodHandle.getType());
    assertSame(field, methodHandle.getField());
  }

  /**
   * Test {@link InvokeCustomExpr#InvokeCustomExpr(VT, Value[], String, Proto, MethodHandle,
   * Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return toString0 is {@code InvokeCustomExpr(....)}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#InvokeCustomExpr(VT, Value[], String, Proto,
   * MethodHandle, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void InvokeCustomExpr.<init>(VT, Value[], String, Proto, MethodHandle, Object[])"
  })
  public void testNewInvokeCustomExpr_whenNull_thenReturnToString0IsInvokeCustomExpr() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    InvokeCustomExpr actualInvokeCustomExpr =
        new InvokeCustomExpr(
            VT.ADD, args, "Method Name", proto, null, new Object[] {Constant.Null});

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
    Value[] ops = actualInvokeCustomExpr.getOps();
    assertEquals(1, ops.length);
    assertEquals(1, actualInvokeCustomExpr.bsmArgs.length);
    assertEquals(ET.En, actualInvokeCustomExpr.et);
    assertEquals(VT.ADD, actualInvokeCustomExpr.vt);
    assertSame(proto, actualInvokeCustomExpr.getProto());
    assertSame(args, ops);
  }

  /**
   * Test {@link InvokeCustomExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link InvokeCustomExpr}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenFirstElementReturnInvokeCustomExpr() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {Exprs.nNull()},
            "Name",
            proto,
            new MethodHandle(1, new Field("Owner", "Name", "Type")),
            new Object[] {Constant.Null});
    Proto proto2 = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokeCustomExpr nInvokeCustomResult2 =
        Exprs.nInvokeCustom(
            new Value[] {nInvokeCustomResult},
            "Name",
            proto2,
            new MethodHandle(1, new Field("Owner", "Name", "Type")),
            new Object[] {Constant.Null});

    // Act
    InvokeCustomExpr actualCloneResult = nInvokeCustomResult2.clone(new LabelAndLocalMapper());

    // Assert
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
    assertEquals(1, value.getOps().length);
    assertEquals(1, ops.length);
    Object[] objectArray = ((InvokeCustomExpr) value).bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(ET.En, ((InvokeCustomExpr) value).et);
    assertEquals(VT.INVOKE_CUSTOM, ((InvokeCustomExpr) value).vt);
    assertEquals(proto, actualCloneResult.getProto());
    assertSame(proto, ((InvokeCustomExpr) value).getProto());
    assertSame(nInvokeCustomResult.bsmArgs, objectArray);
    assertSame(nInvokeCustomResult.handle, ((InvokeCustomExpr) value).handle);
  }

  /**
   * Test {@link InvokeCustomExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return first element Ops is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenReturnFirstElementOpsIsNull() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {nNullResult},
            "Name",
            new Proto(new String[] {"Parameter Types"}, "Return Type"),
            null,
            new Object[] {Constant.Null});

    // Act
    InvokeCustomExpr actualCloneResult = nInvokeCustomResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertNull(value.getOps());
    assertNull(actualCloneResult.handle);
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link InvokeCustomExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return {@link InvokeCustomExpr#handle} Method is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenReturnHandleMethodIsNull() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {Exprs.nNull()},
            "Name",
            proto,
            new MethodHandle(1, field),
            new Object[] {Constant.Null});

    // Act
    InvokeCustomExpr actualCloneResult = nInvokeCustomResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    assertTrue(ops[0] instanceof Constant);
    MethodHandle methodHandle = actualCloneResult.handle;
    assertNull(methodHandle.getMethod());
    assertEquals(1, methodHandle.getType());
    assertEquals(1, ops.length);
    assertSame(field, methodHandle.getField());
  }

  /**
   * Test {@link InvokeCustomExpr#clone()}.
   *
   * <ul>
   *   <li>Then first element return {@link InvokeCustomExpr}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone()"})
  public void testClone_thenFirstElementReturnInvokeCustomExpr() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {Exprs.nNull()},
            "Name",
            proto,
            new MethodHandle(1, new Field("Owner", "Name", "Type")),
            new Object[] {Constant.Null});
    Proto proto2 = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    InvokeCustomExpr actualCloneResult =
        Exprs.nInvokeCustom(
                new Value[] {nInvokeCustomResult},
                "Name",
                proto2,
                new MethodHandle(1, new Field("Owner", "Name", "Type")),
                new Object[] {Constant.Null})
            .clone();

    // Assert
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
    assertEquals(1, value.getOps().length);
    assertEquals(1, ops.length);
    Object[] objectArray = ((InvokeCustomExpr) value).bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(ET.En, ((InvokeCustomExpr) value).et);
    assertEquals(VT.INVOKE_CUSTOM, ((InvokeCustomExpr) value).vt);
    assertEquals(proto, actualCloneResult.getProto());
    assertSame(proto, ((InvokeCustomExpr) value).getProto());
    assertSame(nInvokeCustomResult.bsmArgs, objectArray);
    assertSame(nInvokeCustomResult.handle, ((InvokeCustomExpr) value).handle);
  }

  /**
   * Test {@link InvokeCustomExpr#clone()}.
   *
   * <ul>
   *   <li>Then return first element Ops is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone()"})
  public void testClone_thenReturnFirstElementOpsIsNull() {
    // Arrange
    Constant nNullResult = Exprs.nNull();

    // Act
    InvokeCustomExpr actualCloneResult =
        Exprs.nInvokeCustom(
                new Value[] {nNullResult},
                "Name",
                new Proto(new String[] {"Parameter Types"}, "Return Type"),
                null,
                new Object[] {Constant.Null})
            .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertNull(value.getOps());
    assertNull(actualCloneResult.handle);
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link InvokeCustomExpr#clone()}.
   *
   * <ul>
   *   <li>Then return {@link InvokeCustomExpr#handle} Method is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone()"})
  public void testClone_thenReturnHandleMethodIsNull() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    Field field = new Field("Owner", "Name", "Type");

    // Act
    InvokeCustomExpr actualCloneResult =
        Exprs.nInvokeCustom(
                new Value[] {Exprs.nNull()},
                "Name",
                proto,
                new MethodHandle(1, field),
                new Object[] {Constant.Null})
            .clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    assertTrue(ops[0] instanceof Constant);
    MethodHandle methodHandle = actualCloneResult.handle;
    assertNull(methodHandle.getMethod());
    assertEquals(1, methodHandle.getType());
    assertEquals(1, ops.length);
    assertSame(field, methodHandle.getField());
  }

  /**
   * Test {@link InvokeCustomExpr#toString0()}.
   *
   * <p>Method under test: {@link InvokeCustomExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InvokeCustomExpr.toString0()"})
  public void testToString0() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(
        "InvokeCustomExpr(....)",
        Exprs.nInvokeCustom(
                new Value[] {new ArrayExpr()},
                "Name",
                proto,
                new MethodHandle(1, new Field("Owner", "Name", "Type")),
                new Object[] {Constant.Null})
            .toString0());
  }
}
