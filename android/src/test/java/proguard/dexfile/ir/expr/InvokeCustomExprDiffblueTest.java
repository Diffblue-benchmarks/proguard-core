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

class InvokeCustomExprDiffblueTest {
  /**
   * Test {@link InvokeCustomExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link InvokeCustomExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvokeCustomExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {new ArrayExpr()}, "Name", proto, handle, new Object[] {Constant.Null});

    // Act
    nInvokeCustomResult.releaseMemory();

    // Assert
    assertNull(nInvokeCustomResult.bsmArgs);
    assertNull(nInvokeCustomResult.name);
    assertNull(nInvokeCustomResult.getOps());
    assertNull(nInvokeCustomResult.handle);
    assertNull(nInvokeCustomResult.getProto());
  }

  /**
   * Test {@link InvokeCustomExpr#getProto()}.
   *
   * <p>Method under test: {@link InvokeCustomExpr#getProto()}
   */
  @Test
  @DisplayName("Test getProto()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Proto InvokeCustomExpr.getProto()"})
  void testGetProto() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);
    Object[] bsmArgs = new Object[] {Constant.Null};

    InvokeCustomExpr invokeCustomExpr =
        new InvokeCustomExpr(VT.ADD, args, "Method Name", proto, handle, bsmArgs);

    // Act
    Proto actualProto = invokeCustomExpr.getProto();

    // Assert
    assertSame(invokeCustomExpr.proto, actualProto);
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
  @DisplayName(
      "Test new InvokeCustomExpr(VT, Value[], String, Proto, MethodHandle, Object[]); then return handle Method is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvokeCustomExpr.<init>(VT, Value[], String, Proto, MethodHandle, Object[])"
  })
  void testNewInvokeCustomExpr_thenReturnHandleMethodIsNull() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);
    Object[] bsmArgs = new Object[] {Constant.Null};

    // Act
    InvokeCustomExpr actualInvokeCustomExpr =
        new InvokeCustomExpr(VT.ADD, args, "Method Name", proto, handle, bsmArgs);

    // Assert
    MethodHandle methodHandle = actualInvokeCustomExpr.handle;
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
  @DisplayName(
      "Test new InvokeCustomExpr(VT, Value[], String, Proto, MethodHandle, Object[]); when 'null'; then return toString0 is 'InvokeCustomExpr(....)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvokeCustomExpr.<init>(VT, Value[], String, Proto, MethodHandle, Object[])"
  })
  void testNewInvokeCustomExpr_whenNull_thenReturnToString0IsInvokeCustomExpr() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Object[] bsmArgs = new Object[] {Constant.Null};

    // Act
    InvokeCustomExpr actualInvokeCustomExpr =
        new InvokeCustomExpr(VT.ADD, args, "Method Name", proto, null, bsmArgs);

    // Assert
    assertEquals("InvokeCustomExpr(....)", actualInvokeCustomExpr.toString0());
    assertEquals("Method Name", actualInvokeCustomExpr.name);
    assertNull(actualInvokeCustomExpr.tag);
    assertNull(actualInvokeCustomExpr.getName());
    assertNull(actualInvokeCustomExpr.getOwner());
    assertNull(actualInvokeCustomExpr.getRet());
    assertNull(actualInvokeCustomExpr.valueType);
    assertNull(actualInvokeCustomExpr.getArgs());
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
   * Test {@link InvokeCustomExpr#clone()}.
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone()"})
  void testClone() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {nNullResult}, "Name", proto, handle, new Object[] {Constant.Null});

    // Act and Assert
    Value[] ops = nInvokeCustomResult.clone().getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertNull(value.getOps());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link InvokeCustomExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {nNullResult}, "Name", proto, handle, new Object[] {Constant.Null});

    // Act and Assert
    Value[] ops = nInvokeCustomResult.clone(new LabelAndLocalMapper()).getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertNull(value.getOps());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link InvokeCustomExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper2() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {Exprs.nNull()}, "Name", proto, handle, new Object[] {Constant.Null});
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Field field2 = new Field("Owner", "Name", "Type");
    MethodHandle handle2 = new MethodHandle(1, field2);

    InvokeCustomExpr nInvokeCustomResult2 =
        Exprs.nInvokeCustom(
            new Value[] {nInvokeCustomResult},
            "Name",
            proto2,
            handle2,
            new Object[] {Constant.Null});

    // Act and Assert
    Value[] ops = nInvokeCustomResult2.clone(new LabelAndLocalMapper()).getOps();
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
    Object[] objectArray = ((InvokeCustomExpr) value).bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(VT.INVOKE_CUSTOM, ((InvokeCustomExpr) value).vt);
    assertSame(proto, ((InvokeCustomExpr) value).getProto());
    assertSame(nInvokeCustomResult.bsmArgs, objectArray);
    assertSame(nInvokeCustomResult.handle, ((InvokeCustomExpr) value).handle);
  }

  /**
   * Test {@link InvokeCustomExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper3() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {Exprs.nNull()}, "Name", proto, handle, new Object[] {Constant.Null});
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {nInvokeCustomResult},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Field field2 = new Field("Owner", "Name", "Type");
    MethodHandle handle2 = new MethodHandle(1, field2);

    InvokeCustomExpr nInvokeCustomResult2 =
        Exprs.nInvokeCustom(
            new Value[] {nInvokeInterfaceResult},
            "Name",
            proto2,
            handle2,
            new Object[] {Constant.Null});

    // Act and Assert
    Value[] ops = nInvokeCustomResult2.clone(new LabelAndLocalMapper()).getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    assertTrue(ops2[0] instanceof InvokeCustomExpr);
    assertTrue(value instanceof InvokeExpr);
    assertEquals("InvokeCustomExpr(....).Name()", value.toString0());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokeCustomExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code null.Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return first element toString0 is 'null.Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenReturnFirstElementToString0IsNullName() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {nInvokeInterfaceResult},
            "Name",
            proto,
            handle,
            new Object[] {Constant.Null});

    // Act and Assert
    Value[] ops = nInvokeCustomResult.clone(new LabelAndLocalMapper()).getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    assertTrue(ops2[0] instanceof Constant);
    assertTrue(value instanceof InvokeExpr);
    assertEquals("null.Name()", value.toString0());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokeCustomExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return {@link InvokeCustomExpr#handle} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return handle is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenReturnHandleIsNull() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {nNullResult}, "Name", proto, null, new Object[] {Constant.Null});

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
   * Test {@link InvokeCustomExpr#clone()}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code InvokeCustomExpr(....)}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return first element toString0 is 'InvokeCustomExpr(....)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone()"})
  void testClone_thenReturnFirstElementToString0IsInvokeCustomExpr() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {Exprs.nNull()}, "Name", proto, handle, new Object[] {Constant.Null});
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Field field2 = new Field("Owner", "Name", "Type");
    MethodHandle handle2 = new MethodHandle(1, field2);

    InvokeCustomExpr nInvokeCustomResult2 =
        Exprs.nInvokeCustom(
            new Value[] {nInvokeCustomResult},
            "Name",
            proto2,
            handle2,
            new Object[] {Constant.Null});

    // Act and Assert
    Value[] ops = nInvokeCustomResult2.clone().getOps();
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
    Object[] objectArray = ((InvokeCustomExpr) value).bsmArgs;
    assertEquals(1, objectArray.length);
    assertEquals(VT.INVOKE_CUSTOM, ((InvokeCustomExpr) value).vt);
    assertSame(proto, ((InvokeCustomExpr) value).getProto());
    assertSame(nInvokeCustomResult.bsmArgs, objectArray);
    assertSame(nInvokeCustomResult.handle, ((InvokeCustomExpr) value).handle);
  }

  /**
   * Test {@link InvokeCustomExpr#clone()}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code InvokeCustomExpr(....).Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone()}
   */
  @Test
  @DisplayName(
      "Test clone(); then return first element toString0 is 'InvokeCustomExpr(....).Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone()"})
  void testClone_thenReturnFirstElementToString0IsInvokeCustomExprName() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {Exprs.nNull()}, "Name", proto, handle, new Object[] {Constant.Null});
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {nInvokeCustomResult},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Field field2 = new Field("Owner", "Name", "Type");
    MethodHandle handle2 = new MethodHandle(1, field2);

    InvokeCustomExpr nInvokeCustomResult2 =
        Exprs.nInvokeCustom(
            new Value[] {nInvokeInterfaceResult},
            "Name",
            proto2,
            handle2,
            new Object[] {Constant.Null});

    // Act and Assert
    Value[] ops = nInvokeCustomResult2.clone().getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    assertTrue(ops2[0] instanceof InvokeCustomExpr);
    assertTrue(value instanceof InvokeExpr);
    assertEquals("InvokeCustomExpr(....).Name()", value.toString0());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokeCustomExpr#clone()}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code null.Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return first element toString0 is 'null.Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone()"})
  void testClone_thenReturnFirstElementToString0IsNullName() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {nInvokeInterfaceResult},
            "Name",
            proto,
            handle,
            new Object[] {Constant.Null});

    // Act and Assert
    Value[] ops = nInvokeCustomResult.clone().getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    assertTrue(ops2[0] instanceof Constant);
    assertTrue(value instanceof InvokeExpr);
    assertEquals("null.Name()", value.toString0());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokeCustomExpr#clone()}.
   *
   * <ul>
   *   <li>Then return {@link InvokeCustomExpr#handle} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeCustomExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return handle is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeCustomExpr InvokeCustomExpr.clone()"})
  void testClone_thenReturnHandleIsNull() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {nNullResult}, "Name", proto, null, new Object[] {Constant.Null});

    // Act
    InvokeCustomExpr actualCloneResult = nInvokeCustomResult.clone();

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
   * Test {@link InvokeCustomExpr#toString0()}.
   *
   * <p>Method under test: {@link InvokeCustomExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeCustomExpr.toString0()"})
  void testToString0() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);

    InvokeCustomExpr nInvokeCustomResult =
        Exprs.nInvokeCustom(
            new Value[] {new ArrayExpr()}, "Name", proto, handle, new Object[] {Constant.Null});

    // Act and Assert
    assertEquals("InvokeCustomExpr(....)", nInvokeCustomResult.toString0());
  }
}
