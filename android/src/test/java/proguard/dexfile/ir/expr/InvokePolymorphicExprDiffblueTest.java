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
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;

public class InvokePolymorphicExprDiffblueTest {
  /**
   * Test {@link InvokePolymorphicExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#releaseMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvokePolymorphicExpr.releaseMemory()"})
  public void testReleaseMemory() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(
            new Value[] {new ArrayExpr()},
            proto,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

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
   * Test {@link InvokePolymorphicExpr#getProto()}.
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#getProto()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Proto InvokePolymorphicExpr.getProto()"})
  public void testGetProto() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokePolymorphicExpr invokePolymorphicExpr =
        new InvokePolymorphicExpr(
            VT.ADD,
            new Value[] {new ArrayExpr()},
            proto,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act and Assert
    assertSame(invokePolymorphicExpr.proto, invokePolymorphicExpr.getProto());
  }

  /**
   * Test {@link InvokePolymorphicExpr#InvokePolymorphicExpr(VT, Value[], Proto, Method)}.
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#InvokePolymorphicExpr(VT, Value[], Proto,
   * Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InvokePolymorphicExpr.<init>(VT, Value[], Proto, Method)"})
  public void testNewInvokePolymorphicExpr() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    InvokePolymorphicExpr actualInvokePolymorphicExpr =
        new InvokePolymorphicExpr(
            VT.ADD,
            args,
            proto,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenFirstElementReturnConstant() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(
            new Value[] {nNullResult},
            proto,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenReturnFirstElementToString0IsNullName() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(
            new Value[] {nInvokeInterfaceResult},
            proto,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenReturnFirstElementToString0IsNullNameName() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {
              Exprs.nInvokeInterface(
                  new Value[] {Exprs.nNull()},
                  "Owner",
                  "Name",
                  new String[] {"Argment Types"},
                  "Return Type")
            },
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    InvokePolymorphicExpr nInvokePolymorphicResult =
        Exprs.nInvokePolymorphic(
            new Value[] {nInvokeInterfaceResult},
            proto,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

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
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone()"})
  public void testClone_thenReturnFirstElementToString0IsNullName() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {Exprs.nNull()},
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    InvokePolymorphicExpr actualCloneResult =
        Exprs.nInvokePolymorphic(
                new Value[] {nInvokeInterfaceResult},
                proto,
                new Method(
                    "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .clone();

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone()"})
  public void testClone_thenReturnFirstElementToString0IsNullNameName() {
    // Arrange
    InvokeExpr nInvokeInterfaceResult =
        Exprs.nInvokeInterface(
            new Value[] {
              Exprs.nInvokeInterface(
                  new Value[] {Exprs.nNull()},
                  "Owner",
                  "Name",
                  new String[] {"Argment Types"},
                  "Return Type")
            },
            "Owner",
            "Name",
            new String[] {"Argment Types"},
            "Return Type");
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    InvokePolymorphicExpr actualCloneResult =
        Exprs.nInvokePolymorphic(
                new Value[] {nInvokeInterfaceResult},
                proto,
                new Method(
                    "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .clone();

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
    assertSame(nInvokeInterfaceResult.method, ((InvokeExpr) value).method);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InvokePolymorphicExpr InvokePolymorphicExpr.clone()"})
  public void testClone_thenReturnToString0IsNullName() {
    // Arrange
    Constant nNullResult = Exprs.nNull();
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    InvokePolymorphicExpr actualCloneResult =
        Exprs.nInvokePolymorphic(
                new Value[] {nNullResult},
                proto,
                new Method(
                    "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .clone();

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
   *   <li>Then return {@code ((double)null[null]).Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  public void testToString0_thenReturnDoubleNullNullName() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(
        "((double)null[null]).Name()",
        Exprs.nInvokePolymorphic(
                new Value[] {Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "D")},
                proto,
                new Method(
                    "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .toString0());
  }

  /**
   * Test {@link InvokePolymorphicExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((float)null[null]).Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  public void testToString0_thenReturnFloatNullNullName() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(
        "((float)null[null]).Name()",
        Exprs.nInvokePolymorphic(
                new Value[] {Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "F")},
                proto,
                new Method(
                    "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .toString0());
  }

  /**
   * Test {@link InvokePolymorphicExpr#toString0()}.
   *
   * <ul>
   *   <li>Then return {@code ((int)null[null]).Name()}.
   * </ul>
   *
   * <p>Method under test: {@link InvokePolymorphicExpr#toString0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  public void testToString0_thenReturnIntNullNullName() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(
        "((int)null[null]).Name()",
        Exprs.nInvokePolymorphic(
                new Value[] {Exprs.nCast(new ArrayExpr(), "jane.doe@example.org", "I")},
                proto,
                new Method(
                    "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .toString0());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  public void testToString0_thenReturnNewNullNullName() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(
        "new [][]{null[null]}.Name()",
        Exprs.nInvokePolymorphic(
                new Value[] {Exprs.nFilledArray("[", new Value[] {new ArrayExpr()})},
                proto,
                new Method(
                    "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .toString0());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  public void testToString0_thenReturnNewNullNullName2() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(
        "new [](null[null]).Name()",
        Exprs.nInvokePolymorphic(
                new Value[] {
                  Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"["}, "[")
                },
                proto,
                new Method(
                    "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .toString0());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  public void testToString0_thenReturnNewNullNullNullNullName() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(
        "new [](null[null],null[null]).Name()",
        Exprs.nInvokePolymorphic(
                new Value[] {
                  Exprs.nInvokeNew(
                      new Value[] {arrayExpr, new ArrayExpr()}, new String[] {"["}, "[")
                },
                proto,
                new Method(
                    "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .toString0());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  public void testToString0_thenReturnNullNullName() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertEquals(
        "null[null].Name()",
        Exprs.nInvokePolymorphic(
                new Value[] {new ArrayExpr()},
                proto,
                new Method(
                    "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .toString0());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String InvokePolymorphicExpr.toString0()"})
  public void testToString0_thenReturnNullNullNameNullNull() {
    // Arrange
    ArrayExpr arrayExpr = new ArrayExpr();
    Proto proto = new Proto(new String[] {"["}, "Return Type");

    // Act and Assert
    assertEquals(
        "null[null].Name(([])null[null])",
        Exprs.nInvokePolymorphic(
                new Value[] {arrayExpr, new ArrayExpr()},
                proto,
                new Method(
                    "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")))
            .toString0());
  }
}
