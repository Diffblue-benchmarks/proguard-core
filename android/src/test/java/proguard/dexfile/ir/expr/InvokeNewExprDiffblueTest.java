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
import proguard.dexfile.reader.Proto;

class InvokeNewExprDiffblueTest {
  /**
   * Test {@link InvokeNewExpr#InvokeNewExpr(VT, Value[], String, String, String[], String)}.
   *
   * <p>Method under test: {@link InvokeNewExpr#InvokeNewExpr(VT, Value[], String, String, String[],
   * String)}
   */
  @Test
  @DisplayName("Test new InvokeNewExpr(VT, Value[], String, String, String[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InvokeNewExpr.<init>(VT, Value[], String, String, String[], String)"})
  void testNewInvokeNewExpr() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] argumentTypes = new String[] {"Argument Types"};

    // Act
    InvokeNewExpr actualInvokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Assert
    assertEquals("Method Name", actualInvokeNewExpr.getName());
    assertEquals("Owner Type", actualInvokeNewExpr.getOwner());
    assertEquals("Owner", actualInvokeNewExpr.getRet());
    assertEquals("Owner", actualInvokeNewExpr.getClassName());
    assertEquals("null[null].Method Name()", actualInvokeNewExpr.toString0());
    assertNull(actualInvokeNewExpr.tag);
    assertNull(actualInvokeNewExpr.valueType);
    assertNull(actualInvokeNewExpr.getOp());
    assertNull(actualInvokeNewExpr.getOp1());
    assertNull(actualInvokeNewExpr.getOp2());
    Value[] ops = actualInvokeNewExpr.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, actualInvokeNewExpr.et);
    assertEquals(VT.ADD, actualInvokeNewExpr.vt);
    assertSame(argumentTypes, actualInvokeNewExpr.getArgs());
    assertSame(args, ops);
  }

  /**
   * Test {@link InvokeNewExpr#InvokeNewExpr(VT, Value[], String, String, String[], String,
   * String)}.
   *
   * <p>Method under test: {@link InvokeNewExpr#InvokeNewExpr(VT, Value[], String, String, String[],
   * String, String)}
   */
  @Test
  @DisplayName("Test new InvokeNewExpr(VT, Value[], String, String, String[], String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void InvokeNewExpr.<init>(VT, Value[], String, String, String[], String, String)"
  })
  void testNewInvokeNewExpr2() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] argumentTypes = new String[] {"Argument Types"};

    // Act
    InvokeNewExpr actualInvokeNewExpr =
        new InvokeNewExpr(
            VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner", "Class Name");

    // Assert
    assertEquals("Class Name", actualInvokeNewExpr.getClassName());
    assertEquals("Method Name", actualInvokeNewExpr.getName());
    assertEquals("Owner Type", actualInvokeNewExpr.getOwner());
    assertEquals("Owner", actualInvokeNewExpr.getRet());
    assertEquals("null[null].Method Name()", actualInvokeNewExpr.toString0());
    assertNull(actualInvokeNewExpr.tag);
    assertNull(actualInvokeNewExpr.valueType);
    assertNull(actualInvokeNewExpr.getOp());
    assertNull(actualInvokeNewExpr.getOp1());
    assertNull(actualInvokeNewExpr.getOp2());
    Value[] ops = actualInvokeNewExpr.getOps();
    assertEquals(1, ops.length);
    assertEquals(ET.En, actualInvokeNewExpr.et);
    assertEquals(VT.ADD, actualInvokeNewExpr.vt);
    assertSame(argumentTypes, actualInvokeNewExpr.getArgs());
    assertSame(args, ops);
  }

  /**
   * Test {@link InvokeNewExpr#getClassName()}.
   *
   * <p>Method under test: {@link InvokeNewExpr#getClassName()}
   */
  @Test
  @DisplayName("Test getClassName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String InvokeNewExpr.getClassName()"})
  void testGetClassName() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] argumentTypes = new String[] {"Argument Types"};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Act and Assert
    assertEquals("Owner", invokeNewExpr.getClassName());
  }

  /**
   * Test {@link InvokeNewExpr#clone()}.
   *
   * <p>Method under test: {@link InvokeNewExpr#clone()}
   */
  @Test
  @DisplayName("Test clone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeNewExpr.clone()"})
  void testClone() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {Exprs.nNull()}, new String[] {"Argment Types"}, "Owner");
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {nInvokeNewResult},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    Value[] args = new Value[] {nInvokeInterfaceResult};
    String[] argumentTypes = new String[] {"Argument Types"};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Value[] ops2 = value.getOps();
    assertTrue(ops2[0] instanceof InvokeNewExpr);
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokeNewExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link InvokeNewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeNewExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {Exprs.nNull()}, new String[] {"Argment Types"}, "Owner");
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {nInvokeNewResult},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    Value[] args = new Value[] {nInvokeInterfaceResult};
    String[] argumentTypes = new String[] {"Argument Types"};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Value[] ops2 = value.getOps();
    assertTrue(ops2[0] instanceof InvokeNewExpr);
    assertEquals(1, ops2.length);
    assertEquals(1, ops.length);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokeNewExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then first element return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeNewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then first element return Constant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeNewExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenFirstElementReturnConstant() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Value[] args = new Value[] {nNullResult};
    String[] argumentTypes = new String[] {"Argument Types"};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertEquals("null.Method Name()", actualCloneResult.toString0());
    assertNull(value.getOps());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link InvokeNewExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return first element Name is {@code <init>}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeNewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return first element Name is '<init>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeNewExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenReturnFirstElementNameIsInit() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {Exprs.nNull()}, new String[] {"Argment Types"}, "Owner");
    Value[] args = new Value[] {nInvokeNewResult};
    String[] argumentTypes = new String[] {"Argument Types"};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeNewExpr);
    assertEquals("<init>", ((InvokeNewExpr) value).getName());
    assertEquals("Owner", ((InvokeNewExpr) value).getRet());
    assertEquals("Owner", ((InvokeNewExpr) value).getClassName());
    assertEquals(1, ops.length);
    assertEquals(VT.INVOKE_NEW, ((InvokeNewExpr) value).vt);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nInvokeNewResult.method, ((InvokeNewExpr) value).method);
  }

  /**
   * Test {@link InvokeNewExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code null.Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeNewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return first element toString0 is 'null.Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeNewExpr.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenReturnFirstElementToString0IsNullName() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    Value[] args = new Value[] {nInvokeInterfaceResult};
    String[] argumentTypes = new String[] {"Argument Types"};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertEquals("null.Name()", value.toString0());
    assertEquals("null.Name().Method Name()", actualCloneResult.toString0());
    assertEquals(1, ops.length);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokeNewExpr#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code null.Name().Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeNewExpr#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName(
      "Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return first element toString0 is 'null.Name().Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeNewExpr.clone(LabelAndLocalMapper)"})
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
    Value[] args = new Value[] {nInvokeInterfaceResult2};
    String[] argumentTypes = new String[] {"Argument Types"};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone(new LabelAndLocalMapper());

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertEquals("null.Name().Name()", value.toString0());
    assertEquals("null.Name().Name().Method Name()", actualCloneResult.toString0());
    assertEquals(1, ops.length);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nInvokeInterfaceResult2.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokeNewExpr#clone()}.
   *
   * <ul>
   *   <li>Then first element return {@link Constant}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeNewExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then first element return Constant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeNewExpr.clone()"})
  void testClone_thenFirstElementReturnConstant() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Value[] args = new Value[] {nNullResult};
    String[] argumentTypes = new String[] {"Argument Types"};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof Constant);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertEquals("null.Method Name()", actualCloneResult.toString0());
    assertNull(value.getOps());
    assertEquals(1, ops.length);
    assertEquals(ET.E0, ((Constant) value).et);
    assertEquals(VT.CONSTANT, ((Constant) value).vt);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nNullResult.value, ((Constant) value).value);
  }

  /**
   * Test {@link InvokeNewExpr#clone()}.
   *
   * <ul>
   *   <li>Then return first element Name is {@code <init>}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeNewExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return first element Name is '<init>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeNewExpr.clone()"})
  void testClone_thenReturnFirstElementNameIsInit() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {Exprs.nNull()}, new String[] {"Argment Types"}, "Owner");
    Value[] args = new Value[] {nInvokeNewResult};
    String[] argumentTypes = new String[] {"Argument Types"};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone();

    // Assert
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeNewExpr);
    assertEquals("<init>", ((InvokeNewExpr) value).getName());
    assertEquals("Owner", ((InvokeNewExpr) value).getRet());
    assertEquals("Owner", ((InvokeNewExpr) value).getClassName());
    assertEquals(1, ops.length);
    assertEquals(VT.INVOKE_NEW, ((InvokeNewExpr) value).vt);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nInvokeNewResult.method, ((InvokeNewExpr) value).method);
  }

  /**
   * Test {@link InvokeNewExpr#clone()}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code null.Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeNewExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return first element toString0 is 'null.Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeNewExpr.clone()"})
  void testClone_thenReturnFirstElementToString0IsNullName() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    Value[] args = new Value[] {nInvokeInterfaceResult};
    String[] argumentTypes = new String[] {"Argument Types"};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertEquals("null.Name()", value.toString0());
    assertEquals("null.Name().Method Name()", actualCloneResult.toString0());
    assertEquals(1, ops.length);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
  }

  /**
   * Test {@link InvokeNewExpr#clone()}.
   *
   * <ul>
   *   <li>Then return first element toString0 is {@code null.Name().Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokeNewExpr#clone()}
   */
  @Test
  @DisplayName("Test clone(); then return first element toString0 is 'null.Name().Name()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InvokeExpr InvokeNewExpr.clone()"})
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
    Value[] args = new Value[] {nInvokeInterfaceResult2};
    String[] argumentTypes = new String[] {"Argument Types"};

    InvokeNewExpr invokeNewExpr =
        new InvokeNewExpr(VT.ADD, args, "Owner Type", "Method Name", argumentTypes, "Owner");

    // Act
    InvokeExpr actualCloneResult = invokeNewExpr.clone();

    // Assert
    Value[] ops = actualCloneResult.getOps();
    Value value = ops[0];
    assertTrue(value instanceof InvokeExpr);
    assertTrue(actualCloneResult instanceof InvokeNewExpr);
    assertEquals("null.Name().Name()", value.toString0());
    assertEquals("null.Name().Name().Method Name()", actualCloneResult.toString0());
    assertEquals(1, ops.length);
    Proto expectedProto = actualCloneResult.getProto();
    assertSame(expectedProto, ((InvokeNewExpr) actualCloneResult).method.getProto());
    assertSame(nInvokeInterfaceResult2.method, ((InvokeExpr) value).method);
  }
}
