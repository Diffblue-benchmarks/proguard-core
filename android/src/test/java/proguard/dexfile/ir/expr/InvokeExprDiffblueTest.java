package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.expr.InvokeExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.Proto proguard.dexfile.ir.expr.InvokeExpr.getProto()"
  })
  void testGetProto_thenReturnDescIsArgmentTypesOwner() {
    // Arrange and Act
    Proto actualProto =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner")
            .getProto();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.Proto proguard.dexfile.ir.expr.InvokeExpr.getProto()"
  })
  void testGetProto_thenReturnNull() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");
    nInvokeNewResult.method = null;

    // Act and Assert
    assertNull(nInvokeNewResult.getProto());
  }

  /**
   * Test {@link InvokeExpr#InvokeExpr(VT, Value[], String, String, String[], String)}.
   *
   * <p>Method under test: {@link InvokeExpr#InvokeExpr(VT, Value[], String, String, String[],
   * String)}
   */
  @Test
  @DisplayName("Test new InvokeExpr(VT, Value[], String, String, String[], String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.expr.InvokeExpr.<init>(proguard.dexfile.ir.expr.Value$VT, proguard.dexfile.ir.expr.Value[], java.lang.String, java.lang.String, java.lang.String[], java.lang.String)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.expr.InvokeExpr.<init>(proguard.dexfile.ir.expr.Value$VT, proguard.dexfile.ir.expr.Value[], proguard.dexfile.reader.Method)"
  })
  void testNewInvokeExpr2() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    InvokeExpr actualInvokeExpr = new InvokeExpr(VT.ADD, args, new Method("Owner", "Name", proto));

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
   * <p>Method under test: {@link InvokeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.InvokeExpr proguard.dexfile.ir.expr.InvokeExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {Exprs.nNull()}, new String[] {"Argment Types"}, "Owner");

    // Act
    InvokeExpr actualCloneResult = nInvokeNewResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
  }

  /**
   * Test {@link InvokeExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link FilledArrayExpr}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return FilledArrayExpr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.InvokeExpr proguard.dexfile.ir.expr.InvokeExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnFilledArrayExpr() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(
            new Value[] {Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()})},
            new String[] {"Argment Types"},
            "Owner");

    // Act
    InvokeExpr actualCloneResult = nInvokeNewResult.clone(new LabelAndLocalMapper());

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.InvokeExpr proguard.dexfile.ir.expr.InvokeExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.InvokeExpr proguard.dexfile.ir.expr.InvokeExpr.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.InvokeExpr proguard.dexfile.ir.expr.InvokeExpr.clone()"
  })
  void testClone_thenFirstElementReturnConstant() {
    // Arrange
    Constant nNullResult = Exprs.nNull();

    // Act
    InvokeExpr actualCloneResult =
        Exprs.nInvokeNew(new Value[] {nNullResult}, new String[] {"Argment Types"}, "Owner")
            .clone();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.InvokeExpr proguard.dexfile.ir.expr.InvokeExpr.clone()"
  })
  void testClone_thenFirstElementReturnFilledArrayExpr() {
    // Arrange and Act
    InvokeExpr actualCloneResult =
        Exprs.nInvokeNew(
                new Value[] {Exprs.nFilledArray("Element Type", new Value[] {Exprs.nNull()})},
                new String[] {"Argment Types"},
                "Owner")
            .clone();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.InvokeExpr proguard.dexfile.ir.expr.InvokeExpr.clone()"
  })
  void testClone_thenFirstElementReturnInvokeExpr() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");

    // Act
    InvokeExpr actualCloneResult =
        Exprs.nInvokeNew(
                new Value[] {nInvokeInterfaceResult}, new String[] {"Argment Types"}, "Owner")
            .clone();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.expr.InvokeExpr proguard.dexfile.ir.expr.InvokeExpr.clone()"
  })
  void testClone_thenReturnMethodDescIsArgmentTypesReturnType() {
    // Arrange and Act
    InvokeExpr actualCloneResult =
        Exprs.nInvokeInterface(
                new Value[] {Exprs.nNull()},
                "Owner",
                "Name",
                new String[] {"Argment Types"},
                "Return Type")
            .clone();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString0() {
    // Arrange, Act and Assert
    assertEquals(
        "new (null[null])",
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, null)
            .toString0());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString0_thenReturnNewDoubleNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new double(null[null])",
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "D")
            .toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new float(null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new float(null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString0_thenReturnNewFloatNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new float(null[null])",
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "F")
            .toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new int(null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new int(null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString0_thenReturnNewIntNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new int(null[null])",
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "I")
            .toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new ((()null[null]))}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new ((()null[null]))'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString0_thenReturnNewNullNull() {
    // Arrange, Act and Assert
    assertEquals(
        "new ((()null[null]))",
        Exprs.nInvokeNew(
                new Value[] {Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "")},
                new String[] {"Argment Types"},
                null)
            .toString0());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString0_thenReturnNewNullNullNew() {
    // Arrange, Act and Assert
    assertEquals(
        "new [](null[null]).new ()",
        (new InvokeNewExpr(
                VT.ADD,
                new Value[] {
                  Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"new "}, "[")
                },
                "new ",
                "new ",
                new String[] {"new "},
                "new "))
            .toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code new (null[null],null[null])}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0(); then return 'new (null[null],null[null])'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString0_thenReturnNewNullNullNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();

    // Act and Assert
    assertEquals(
        "new (null[null],null[null])",
        Exprs.nInvokeNew(
                new Value[] {arrayExpr, new ArrayExpr()}, new String[] {"Argment Types"}, null)
            .toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString02() {
    // Arrange, Act and Assert
    assertEquals(
        "new (null[null])",
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "")
            .toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString03() {
    // Arrange, Act and Assert
    assertEquals(
        "null[null].new ()",
        (new InvokeNewExpr(
                VT.ADD,
                new Value[] {new ArrayExpr()},
                "new ",
                "new ",
                new String[] {"new "},
                "new "))
            .toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString04() {
    // Arrange
    Proto proto = new Proto(new String[] {"new "}, "new ");

    // Act and Assert
    assertEquals(
        "null[null].new ()",
        Exprs.nInvokePolymorphic(
                new Value[] {new ArrayExpr()},
                proto,
                new Method("new ", "new ", new Proto(new String[] {"new "}, "new ")))
            .toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString05() {
    // Arrange, Act and Assert
    assertEquals(
        "new [][]{null[null]}.new ()",
        (new InvokeNewExpr(
                VT.ADD,
                new Value[] {Exprs.nFilledArray("[", new Value[] {new ArrayExpr()})},
                "new ",
                "new ",
                new String[] {"new "},
                "new "))
            .toString0());
  }

  /**
   * Test {@link InvokeExpr#toString0()}.
   *
   * <p>Method under test: {@link InvokeExpr#toString0()}
   */
  @Test
  @DisplayName("Test toString0()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.toString0()"})
  void testToString06() {
    // Arrange
    Proto proto = new Proto(new String[] {"new "}, "new ");

    // Act and Assert
    assertEquals(
        "new [][]{null[null]}.new ()",
        Exprs.nInvokePolymorphic(
                new Value[] {Exprs.nFilledArray("[", new Value[] {new ArrayExpr()})},
                proto,
                new Method("new ", "new ", new Proto(new String[] {"new "}, "new ")))
            .toString0());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.getOwner()"})
  void testGetOwner_thenReturnNull() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");
    nInvokeNewResult.method = null;

    // Act and Assert
    assertNull(nInvokeNewResult.getOwner());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.getOwner()"})
  void testGetOwner_thenReturnOwner() {
    // Arrange, Act and Assert
    assertEquals(
        "Owner",
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner")
            .getOwner());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.getRet()"})
  void testGetRet_thenReturnNull() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");
    nInvokeNewResult.method = null;

    // Act and Assert
    assertNull(nInvokeNewResult.getRet());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.getRet()"})
  void testGetRet_thenReturnOwner() {
    // Arrange, Act and Assert
    assertEquals(
        "Owner",
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner")
            .getRet());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.getName()"})
  void testGetName_thenReturnInit() {
    // Arrange, Act and Assert
    assertEquals(
        "<init>",
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner")
            .getName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.expr.InvokeExpr.getName()"})
  void testGetName_thenReturnNull() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");
    nInvokeNewResult.method = null;

    // Act and Assert
    assertNull(nInvokeNewResult.getName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String[] proguard.dexfile.ir.expr.InvokeExpr.getArgs()"})
  void testGetArgs_thenReturnArrayOfStringWithArgmentTypes() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {"Argment Types"},
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner")
            .getArgs());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String[] proguard.dexfile.ir.expr.InvokeExpr.getArgs()"})
  void testGetArgs_thenReturnNull() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");
    nInvokeNewResult.method = null;

    // Act and Assert
    assertNull(nInvokeNewResult.getArgs());
  }
}
