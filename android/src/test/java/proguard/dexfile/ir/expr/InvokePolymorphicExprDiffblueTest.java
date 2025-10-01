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
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;

class InvokePolymorphicExprDiffblueTest {
  /**
   * Test {@link InvokePolymorphicExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvokePolymorphicExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {new ArrayExpr()}, proto, method);

    // Act
    nInvokePolymorphicResult.releaseMemory();

    // Assert
    assertNull(nInvokePolymorphicResult.getName());
    assertNull(nInvokePolymorphicResult.getOwner());
    assertNull(nInvokePolymorphicResult.getRet());
    assertNull(nInvokePolymorphicResult.getArgs());
    assertNull(nInvokePolymorphicResult.getOps());
    assertNull(nInvokePolymorphicResult.method);
    assertNull(nInvokePolymorphicResult.getProto());
  }

  /**
   * Test {@link InvokePolymorphicExpr#getProto()}.
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#getProto()}
   */
  @Test
  @DisplayName("Test getProto()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Proto InvokePolymorphicExpr.getProto()"})
  void testGetProto() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr invokePolymorphicExpr =
        new InvokePolymorphicExpr(VT.ADD, args, proto, method);

    // Act
    Proto actualProto = invokePolymorphicExpr.getProto();

    // Assert
    assertSame(invokePolymorphicExpr.proto, actualProto);
  }

  /**
   * Test {@link InvokePolymorphicExpr#InvokePolymorphicExpr(VT, Value[], Proto, Method)}.
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#InvokePolymorphicExpr(VT, Value[], Proto,
   * Method)}
   */
  @Test
  @DisplayName("Test new InvokePolymorphicExpr(VT, Value[], Proto, Method)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvokePolymorphicExpr.<init>(VT, Value[], Proto, Method)"})
  void testNewInvokePolymorphicExpr() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    // Act
    InvokePolymorphicExpr actualInvokePolymorphicExpr =
        new InvokePolymorphicExpr(VT.ADD, args, proto, method);

    // Assert
    assertEquals("Name", actualInvokePolymorphicExpr.getName());
    assertEquals("Owner", actualInvokePolymorphicExpr.getOwner());
    assertEquals("Return Type", actualInvokePolymorphicExpr.getRet());
    assertEquals("null[null].Name()", actualInvokePolymorphicExpr.toString0());
    assertNull(actualInvokePolymorphicExpr.tag);
    assertNull(actualInvokePolymorphicExpr.valueType);
    assertNull(actualInvokePolymorphicExpr.getOp());
    assertNull(actualInvokePolymorphicExpr.getOp1());
    assertNull(actualInvokePolymorphicExpr.getOp2());
    assertEquals(1, actualInvokePolymorphicExpr.getArgs().length);
    Value[] ops = actualInvokePolymorphicExpr.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, actualInvokePolymorphicExpr.et);
    assertEquals(VT.ADD, actualInvokePolymorphicExpr.vt);
    assertSame(proto, actualInvokePolymorphicExpr.getProto());
    assertSame(args, ops);
  }

  /**
   * Test {@link InvokePolymorphicExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return Constant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnConstant() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {nNullResult}, proto, method);

    // Act
    InvokePolymorphicExpr actualCloneResult =
        nInvokePolymorphicResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertEquals("null.Name()", actualCloneResult.toString0());
    assertNull(value.getOps());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link InvokePolymorphicExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code null.Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return first element toString0 is 'null.Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone(LabelAndLocalMapper)"})
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
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {nInvokeInterfaceResult}, proto, method);

    // Act
    InvokePolymorphicExpr actualCloneResult =
        nInvokePolymorphicResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeExpr);
    assertEquals("null.Name()", value.toString0());
    assertEquals("null.Name().Name()", actualCloneResult.toString0());
    assertEquals(1, ops.length);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokePolymorphicExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code null.Name().Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return first element toString0 is 'null.Name().Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenReturnFirstElementToString0IsNullNameName() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    InvokeExpr nInvokeInterfaceResult2 =
        Exprs.nInvokeInterface(
            new Value[] {nInvokeInterfaceResult},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {nInvokeInterfaceResult2}, proto, method);

    // Act
    InvokePolymorphicExpr actualCloneResult =
        nInvokePolymorphicResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeExpr);
    assertEquals("null.Name().Name()", value.toString0());
    assertEquals("null.Name().Name().Name()", actualCloneResult.toString0());
    assertEquals(1, ops.length);
    assertSame(nInvokeInterfaceResult2.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokePolymorphicExpr#clone()}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code null.Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return first element toString0 is 'null.Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone()"})
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
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {nInvokeInterfaceResult}, proto, method);

    // Act
    InvokePolymorphicExpr actualCloneResult = nInvokePolymorphicResult.clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    assertTrue(ops2[0] instanceof Constant);
    assertTrue(value instanceof InvokeExpr);
    assertEquals("null.Name()", value.toString0());
    assertEquals("null.Name().Name()", actualCloneResult.toString0());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokePolymorphicExpr#clone()}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code null.Name().Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return first element toString0 is 'null.Name().Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone()"})
  void testClone_thenReturnFirstElementToString0IsNullNameName() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    InvokeExpr nInvokeInterfaceResult2 =
        Exprs.nInvokeInterface(
            new Value[] {nInvokeInterfaceResult},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {nInvokeInterfaceResult2}, proto, method);

    // Act
    InvokePolymorphicExpr actualCloneResult = nInvokePolymorphicResult.clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    Value[] ops2 = value.getOps();
    assertTrue(ops2[0] instanceof InvokeExpr);
    assertTrue(value instanceof InvokeExpr);
    assertEquals("null.Name().Name()", value.toString0());
    assertEquals("null.Name().Name().Name()", actualCloneResult.toString0());
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    assertSame(nInvokeInterfaceResult2.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokePolymorphicExpr#clone()}.
   *
   * <ul>
   *   <li>Then return toString0 is {@code null.Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return toString0 is 'null.Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone()"})
  void testClone_thenReturnToString0IsNullName() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {nNullResult}, proto, method);

    // Act
    InvokePolymorphicExpr actualCloneResult = nInvokePolymorphicResult.clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertEquals("null.Name()", actualCloneResult.toString0());
    assertNull(value.getOps());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link InvokePolymorphicExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new [][]{null[null]}.Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new [][]{null[null]}.Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  void testToString0_thenReturnNewNullNullName() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(
            new Value[] {Exprs.nFilledArray("[", new Value[] {new ArrayExpr()})}, proto, method);

    // Act and Assert
    assertEquals("new [][]{null[null]}.Name()", nInvokePolymorphicResult.toString0());
  }

  /**
   * Test {@link InvokePolymorphicExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new [](null[null]).Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new [](null[null]).Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  void testToString0_thenReturnNewNullNullName2() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"["}, "[");
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {nInvokeNewResult}, proto, method);

    // Act and Assert
    assertEquals("new [](null[null]).Name()", nInvokePolymorphicResult.toString0());
  }

  /**
   * Test {@link InvokePolymorphicExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new [][]{null[null]}.[().Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new [][]{null[null]}.[().Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  void testToString0_thenReturnNewNullNullName3() {
    // Arrange
    Value[] args = new Value[] {Exprs.nFilledArray("[", new Value[] {new ArrayExpr()})};
    String[] argumentTypes = new String[] {"["};

    InvokeNewExpr invokeNewExpr = new InvokeNewExpr(VT.ADD, args, "[", "[", argumentTypes, "[");
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {invokeNewExpr}, proto, method);

    // Act and Assert
    assertEquals("new [][]{null[null]}.[().Name()", nInvokePolymorphicResult.toString0());
  }

  /**
   * Test {@link InvokePolymorphicExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new [](null[null],null[null]).Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new [](null[null],null[null]).Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  void testToString0_thenReturnNewNullNullNullNullName() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {arrayExpr, new ArrayExpr()}, new String[] {"["}, "[");
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {nInvokeNewResult}, proto, method);

    // Act and Assert
    assertEquals("new [](null[null],null[null]).Name()", nInvokePolymorphicResult.toString0());
  }

  /**
   * Test {@link InvokePolymorphicExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  void testToString0_thenReturnNullNullName() {
    // Arrange
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {new ArrayExpr()}, proto, method);

    // Act and Assert
    assertEquals("null[null].Name()", nInvokePolymorphicResult.toString0());
  }

  /**
   * Test {@link InvokePolymorphicExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].[().Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].[().Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  void testToString0_thenReturnNullNullName2() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] argumentTypes = new String[] {"["};

    InvokeNewExpr invokeNewExpr = new InvokeNewExpr(VT.ADD, args, "[", "[", argumentTypes, "[");
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {invokeNewExpr}, proto, method);

    // Act and Assert
    assertEquals("null[null].[().Name()", nInvokePolymorphicResult.toString0());
  }

  /**
   * Test {@link InvokePolymorphicExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].Name(([])new [][]{null[null]})}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].Name(([])new [][]{null[null]})'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  void testToString0_thenReturnNullNullNameNewNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    Proto proto = new Proto(new String[] {"[", "]"}, "Return Type");
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(
            new Value[] {arrayExpr, Exprs.nFilledArray("[", new Value[] {new ArrayExpr()})},
            proto,
            method);

    // Act and Assert
    assertEquals("null[null].Name(([])new [][]{null[null]})", nInvokePolymorphicResult.toString0());
  }

  /**
   * Test {@link InvokePolymorphicExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].Name(([])new [](null[null]))}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].Name(([])new [](null[null]))'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  void testToString0_thenReturnNullNullNameNewNullNull2() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"["}, "[");
    Proto proto = new Proto(new String[] {"[", "]"}, "Return Type");
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {arrayExpr, nInvokeNewResult}, proto, method);

    // Act and Assert
    assertEquals("null[null].Name(([])new [](null[null]))", nInvokePolymorphicResult.toString0());
  }

  /**
   * Test {@link InvokePolymorphicExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].Name(([])null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].Name(([])null[null])'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  void testToString0_thenReturnNullNullNameNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    Proto proto = new Proto(new String[] {"[", "]"}, "Return Type");
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {arrayExpr, new ArrayExpr()}, proto, method);

    // Act and Assert
    assertEquals("null[null].Name(([])null[null])", nInvokePolymorphicResult.toString0());
  }
}
