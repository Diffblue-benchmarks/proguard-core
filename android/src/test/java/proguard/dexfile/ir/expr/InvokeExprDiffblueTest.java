package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

class InvokeExprDiffblueTest {
  /**
   * Test {@link InvokeExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link InvokeExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvokeExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");

    // Act
    nInvokeNewResult.releaseMemory();

    // Assert
    assertTrue(nInvokeNewResult instanceof InvokeNewExpr);
    assertNull(nInvokeNewResult.getName());
    assertNull(nInvokeNewResult.getOwner());
    assertNull(nInvokeNewResult.getRet());
    assertNull(nInvokeNewResult.getArgs());
    assertNull(nInvokeNewResult.getOps());
    assertNull(((InvokeNewExpr) nInvokeNewResult).method);
    assertNull(nInvokeNewResult.getProto());
  }

  /**
   * Test {@link InvokeExpr#getProto()}.
   *
   * <ul>
   *   <li>Then return Desc is {@code (Argment Types)Owner}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#getProto()}
   */
  @Test
  @DisplayName("Test getProto(); then return Desc is '(Argment Types)Owner'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Proto InvokeExpr.getProto()"})
  void testGetProto_thenReturnDescIsArgmentTypesOwner() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");

    // Act
    Proto actualProto = nInvokeNewResult.getProto();

    // Assert
    assertEquals("(Argment Types)Owner", actualProto.getDesc());
    assertEquals("Owner", actualProto.getReturnType());
    assertArrayEquals(new String[] {"Argment Types"}, actualProto.getParameterTypes());
  }

  /**
   * Test {@link InvokeExpr#getProto()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#getProto()}
   */
  @Test
  @DisplayName("Test getProto(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Proto InvokeExpr.getProto()"})
  void testGetProto_thenReturnNull() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    InvokeExpr invokeExpr = new InvokeExpr(VT.ADD, args, null);

    // Act and Assert
    assertNull(invokeExpr.getProto());
  }

  /**
   * Test {@link InvokeExpr#InvokeExpr(VT, Value[], String, String, String[], String)}.
   *
   * <p>Method under test: {@link InvokeExpr#InvokeExpr(VT, Value[], String, String, String[],
   * String)}
   */
  @Test
  @DisplayName("Test new InvokeExpr(VT, Value[], String, String, String[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvokeExpr.<init>(VT, Value[], String, String, String[], String)"})
  void testNewInvokeExpr() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] argmentTypes = new String[] {"Argment Types"};

    // Act
    InvokeExpr actualInvokeExpr =
        new InvokeExpr(VT.ADD, args, "Owner Type", "Method Name", argmentTypes, "Return Type");

    // Assert
    assertEquals("Method Name", actualInvokeExpr.getName());
    assertEquals("Owner Type", actualInvokeExpr.getOwner());
    assertEquals("Return Type", actualInvokeExpr.getRet());
    assertEquals("null[null].Method Name()", actualInvokeExpr.toString0());
    assertNull(actualInvokeExpr.tag);
    assertNull(actualInvokeExpr.valueType);
    assertNull(actualInvokeExpr.getOp());
    assertNull(actualInvokeExpr.getOp1());
    assertNull(actualInvokeExpr.getOp2());
    Value[] ops = actualInvokeExpr.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, actualInvokeExpr.et);
    assertEquals(VT.ADD, actualInvokeExpr.vt);
    assertSame(argmentTypes, actualInvokeExpr.getArgs());
    assertSame(args, ops);
  }

  /**
   * Test {@link InvokeExpr#InvokeExpr(VT, Value[], Method)}.
   *
   * <p>Method under test: {@link InvokeExpr#InvokeExpr(VT, Value[], Method)}
   */
  @Test
  @DisplayName("Test new InvokeExpr(VT, Value[], Method)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvokeExpr.<init>(VT, Value[], Method)"})
  void testNewInvokeExpr2() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);

    // Act
    InvokeExpr actualInvokeExpr = new InvokeExpr(VT.ADD, args, method);

    // Assert
    assertEquals("Name", actualInvokeExpr.getName());
    assertEquals("Owner", actualInvokeExpr.getOwner());
    assertEquals("Return Type", actualInvokeExpr.getRet());
    assertEquals("null[null].Name()", actualInvokeExpr.toString0());
    assertNull(actualInvokeExpr.tag);
    assertNull(actualInvokeExpr.valueType);
    assertNull(actualInvokeExpr.getOp());
    assertNull(actualInvokeExpr.getOp1());
    assertNull(actualInvokeExpr.getOp2());
    assertEquals(1, actualInvokeExpr.getArgs().length);
    Value[] ops = actualInvokeExpr.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, actualInvokeExpr.et);
    assertEquals(VT.ADD, actualInvokeExpr.vt);
    assertSame(proto, actualInvokeExpr.getProto());
    assertSame(args, ops);
  }

  /**
   * Test {@link InvokeExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link InvokeExpr}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return InvokeExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnInvokeExpr() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(
            new Value[] {nInvokeInterfaceResult}, new String[] {"Argment Types"}, "Owner");

    // Act
    InvokeExpr actualCloneResult = nInvokeNewResult.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("null.Name()", value.toString0());
    assertEquals(1, ((InvokeExpr) value).getArgs().length);
    assertEquals(1, ops.length);
    assertEquals(VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokeExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return {@link InvokeExpr#method} Desc is {@code (Argment Types)Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return method Desc is '(Argment Types)Return Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenReturnMethodDescIsArgmentTypesReturnType() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");

    // Act
    InvokeExpr actualCloneResult = nInvokeInterfaceResult.clone(new LabelAndLocalMapper());

    // Assert
    Method method = actualCloneResult.method;
    assertEquals("(Argment Types)Return Type", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argment Types)Return Type", proto.getDesc());
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", method.getName());
    assertEquals("Return Type", actualCloneResult.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto.getReturnType());
    assertEquals("null.Name()", actualCloneResult.toString0());
    assertEquals(VT.INVOKE_INTERFACE, actualCloneResult.vt);
    assertSame(proto, method.getProto());
  }

  /**
   * Test {@link InvokeExpr#clone()}.
   *
   * <ul>
   *   <li>Then first element return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then first element return Constant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeExpr.clone()"})
  void testClone_thenFirstElementReturnConstant() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {nNullResult}, new String[] {"Argment Types"}, "Owner");

    // Act
    InvokeExpr actualCloneResult = nInvokeNewResult.clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertNull(value.getOps());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link InvokeExpr#clone()}.
   *
   * <ul>
   *   <li>Then first element return {@link FilledArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then first element return FilledArrayExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeExpr.clone()"})
  void testClone_thenFirstElementReturnFilledArrayExpr() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(
            new Value[] {Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()})},
            new String[] {"Argment Types"},
            "Owner");

    // Act
    InvokeExpr actualCloneResult = nInvokeNewResult.clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof FilledArrayExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertEquals("Element Type", ((FilledArrayExpr) value).type);
    assertEquals(1, ops.length);
    assertEquals(VT.FILLED_ARRAY, ((FilledArrayExpr) value).vt);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
  }

  /**
   * Test {@link InvokeExpr#clone()}.
   *
   * <ul>
   *   <li>Then first element return {@link InvokeExpr}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then first element return InvokeExpr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeExpr.clone()"})
  void testClone_thenFirstElementReturnInvokeExpr() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(
            new Value[] {nInvokeInterfaceResult}, new String[] {"Argment Types"}, "Owner");

    // Act
    InvokeExpr actualCloneResult = nInvokeNewResult.clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertEquals("Name", ((InvokeExpr) value).getName());
    assertEquals("Owner", ((InvokeExpr) value).getOwner());
    assertEquals("Return Type", ((InvokeExpr) value).getRet());
    assertEquals("null.Name()", value.toString0());
    assertEquals(1, ((InvokeExpr) value).getArgs().length);
    assertEquals(1, ops.length);
    assertEquals(VT.INVOKE_INTERFACE, ((InvokeExpr) value).vt);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokeExpr#clone()}.
   *
   * <ul>
   *   <li>Then return {@link InvokeExpr#method} Desc is {@code (Argment Types)Return Type}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return method Desc is '(Argment Types)Return Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeExpr.clone()"})
  void testClone_thenReturnMethodDescIsArgmentTypesReturnType() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");

    // Act
    InvokeExpr actualCloneResult = nInvokeInterfaceResult.clone();

    // Assert
    Method method = actualCloneResult.method;
    assertEquals("(Argment Types)Return Type", method.getDesc());
    Proto proto = actualCloneResult.getProto();
    assertEquals("(Argment Types)Return Type", proto.getDesc());
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Name", method.getName());
    assertEquals("Return Type", actualCloneResult.getRet());
    assertEquals("Return Type", method.getReturnType());
    assertEquals("Return Type", proto.getReturnType());
    assertEquals("null.Name()", actualCloneResult.toString0());
    assertEquals(VT.INVOKE_INTERFACE, actualCloneResult.vt);
    assertSame(proto, method.getProto());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.toString0()"})
  void testToString0() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] argumentTypes = new String[] {"new "};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "new ", "new ", argumentTypes, "new ");

    // Act and Assert
    assertEquals("null[null].new ()", invokeNewExpr.toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new double(null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new double(null[null])'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.toString0()"})
  void testToString0_thenReturnNewDoubleNullNull() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "D");

    // Act and Assert
    assertEquals("new double(null[null])", nInvokeNewResult.toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new (null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new (null[null])'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.toString0()"})
  void testToString0_thenReturnNewNullNull() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, null);

    // Act and Assert
    assertEquals("new (null[null])", nInvokeNewResult.toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new [](null[null]).new ()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new [](null[null]).new ()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.toString0()"})
  void testToString0_thenReturnNewNullNullNew() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"new "}, "[");
    Value[] args = new Value[] {nInvokeNewResult};
    String[] argumentTypes = new String[] {"new "};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "new ", "new ", argumentTypes, "new ");

    // Act and Assert
    assertEquals("new [](null[null]).new ()", invokeNewExpr.toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].new (new [][]{null[null]})}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].new (new [][]{null[null]})'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.toString0()"})
  void testToString0_thenReturnNullNullNewNewNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    String[] argumentTypes = new String[] {"new "};
    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(
            VT.ADD,
            new Value[] {arrayExpr, Exprs.nFilledArray("[", new Value[] {new ArrayExpr()})},
            "new ",
            "new ",
            argumentTypes,
            "new ");

    // Act and Assert
    assertEquals("null[null].new (new [][]{null[null]})", invokeNewExpr.toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].new (new [](null[null]))}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].new (new [](null[null]))'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.toString0()"})
  void testToString0_thenReturnNullNullNewNewNullNull2() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"new "}, "[");
    String[] argumentTypes = new String[] {"new "};
    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(
            VT.ADD,
            new Value[] {arrayExpr, nInvokeNewResult},
            "new ",
            "new ",
            argumentTypes,
            "new ");

    // Act and Assert
    assertEquals("null[null].new (new [](null[null]))", invokeNewExpr.toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].new (([])new [](null[null]))}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].new (([])new [](null[null]))'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.toString0()"})
  void testToString0_thenReturnNullNullNewNewNullNull3() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"new "}, "[");
    Proto proto = new Proto(new String[] {"[", "]"}, "new ");
    String[] parameterTypes = new String[] {"new "};
    Proto proto2 = new Proto(parameterTypes, "new ");
    Method method = new Method("new ", "new ", proto2);

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(new Value[] {arrayExpr, nInvokeNewResult}, proto, method);

    // Act and Assert
    assertEquals("null[null].new (([])new [](null[null]))", nInvokePolymorphicResult.toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].new (null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].new (null[null])'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.toString0()"})
  void testToString0_thenReturnNullNullNewNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    String[] argumentTypes = new String[] {"new "};
    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(
            VT.ADD,
            new Value[] {arrayExpr, new ArrayExpr()},
            "new ",
            "new ",
            argumentTypes,
            "new ");

    // Act and Assert
    assertEquals("null[null].new (null[null])", invokeNewExpr.toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code null[null].new (null[null],null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'null[null].new (null[null],null[null])'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.toString0()"})
  void testToString0_thenReturnNullNullNewNullNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    ArrayExpr arrayExpr2 = new ArrayExpr();
    String[] argumentTypes = new String[] {"new "};
    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(
            VT.ADD,
            new Value[] {arrayExpr, arrayExpr2, new ArrayExpr()},
            "new ",
            "new ",
            argumentTypes,
            "new ");

    // Act and Assert
    assertEquals("null[null].new (null[null],null[null])", invokeNewExpr.toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.toString0()"})
  void testToString02() {
    // Arrange
    Value[] args = new Value[] {Exprs.nFilledArray("[", new Value[] {new ArrayExpr()})};
    String[] argumentTypes = new String[] {"new "};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "new ", "new ", argumentTypes, "new ");

    // Act and Assert
    assertEquals("new [][]{null[null]}.new ()", invokeNewExpr.toString0());
  }

  /**
   * Test {@link InvokeExpr#getOwner()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#getOwner()}
   */
  @Test
  @DisplayName("Test getOwner(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.getOwner()"})
  void testGetOwner_thenReturnNull() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    InvokeExpr invokeExpr = new InvokeExpr(VT.ADD, args, null);

    // Act and Assert
    assertNull(invokeExpr.getOwner());
  }

  /**
   * Test {@link InvokeExpr#getOwner()}.
   *
   * <ul>
   *   <li>Then return {@code Owner}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#getOwner()}
   */
  @Test
  @DisplayName("Test getOwner(); then return 'Owner'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.getOwner()"})
  void testGetOwner_thenReturnOwner() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");

    // Act and Assert
    assertEquals("Owner", nInvokeNewResult.getOwner());
  }

  /**
   * Test {@link InvokeExpr#getRet()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#getRet()}
   */
  @Test
  @DisplayName("Test getRet(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.getRet()"})
  void testGetRet_thenReturnNull() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    InvokeExpr invokeExpr = new InvokeExpr(VT.ADD, args, null);

    // Act and Assert
    assertNull(invokeExpr.getRet());
  }

  /**
   * Test {@link InvokeExpr#getRet()}.
   *
   * <ul>
   *   <li>Then return {@code Owner}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#getRet()}
   */
  @Test
  @DisplayName("Test getRet(); then return 'Owner'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.getRet()"})
  void testGetRet_thenReturnOwner() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");

    // Act and Assert
    assertEquals("Owner", nInvokeNewResult.getRet());
  }

  /**
   * Test {@link InvokeExpr#getName()}.
   *
   * <ul>
   *   <li>Then return {@code <init>}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return '<init>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.getName()"})
  void testGetName_thenReturnInit() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");

    // Act and Assert
    assertEquals("<init>", nInvokeNewResult.getName());
  }

  /**
   * Test {@link InvokeExpr#getName()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeExpr.getName()"})
  void testGetName_thenReturnNull() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    InvokeExpr invokeExpr = new InvokeExpr(VT.ADD, args, null);

    // Act and Assert
    assertNull(invokeExpr.getName());
  }

  /**
   * Test {@link InvokeExpr#getArgs()}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code Argment Types}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#getArgs()}
   */
  @Test
  @DisplayName("Test getArgs(); then return array of String with 'Argment Types'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] InvokeExpr.getArgs()"})
  void testGetArgs_thenReturnArrayOfStringWithArgmentTypes() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");

    // Act and Assert
    assertArrayEquals(new String[] {"Argment Types"}, nInvokeNewResult.getArgs());
  }

  /**
   * Test {@link InvokeExpr#getArgs()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#getArgs()}
   */
  @Test
  @DisplayName("Test getArgs(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] InvokeExpr.getArgs()"})
  void testGetArgs_thenReturnNull() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    InvokeExpr invokeExpr = new InvokeExpr(VT.ADD, args, null);

    // Act and Assert
    assertNull(invokeExpr.getArgs());
  }
}
