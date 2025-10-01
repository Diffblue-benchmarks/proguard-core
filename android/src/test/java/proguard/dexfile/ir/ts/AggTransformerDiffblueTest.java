package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.BinopExpr;
import proguard.dexfile.ir.expr.CastExpr;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.ir.expr.Exprs;
import proguard.dexfile.ir.expr.FilledArrayExpr;
import proguard.dexfile.ir.expr.InvokeCustomExpr;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.expr.Value.VT;
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.Stmt.ST;
import proguard.dexfile.ir.ts.AggTransformer.MergeResult;
import proguard.dexfile.ir.ts.AggTransformer.ReplaceX;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Proto;

class AggTransformerDiffblueTest {
  /**
   * Test MergeResult new {@link MergeResult} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MergeResult}
   */
  @Test
  @DisplayName("Test MergeResult new MergeResult (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MergeResult.<init>()"})
  void testMergeResultNewMergeResult() {
    // Arrange and Act
    MergeResult actualMergeResult = new MergeResult();

    // Assert
    assertNull(actualMergeResult.getMessage());
    assertNull(actualMergeResult.getCause());
    assertEquals(0, actualMergeResult.getSuppressed().length);
  }

  /**
   * Test ReplaceX new {@link ReplaceX} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ReplaceX}
   */
  @Test
  @DisplayName("Test ReplaceX new ReplaceX (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReplaceX.<init>()"})
  void testReplaceXNewReplaceX() {
    // Arrange and Act
    ReplaceX actualReplaceX = new ReplaceX();

    // Assert
    assertNull(actualReplaceX.local);
    assertNull(actualReplaceX.replaceWith);
  }

  /**
   * Test ReplaceX {@link ReplaceX#onAssign(Local, AssignStmt)}.
   *
   * <p>Method under test: {@link ReplaceX#onAssign(Local, AssignStmt)}
   */
  @Test
  @DisplayName("Test ReplaceX onAssign(Local, AssignStmt)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value ReplaceX.onAssign(Local, AssignStmt)"})
  void testReplaceXOnAssign() {
    // Arrange
    ReplaceX replaceX = new ReplaceX();
    Local v = new Local();
    ArrayExpr left = new ArrayExpr();
    AssignStmt as = new AssignStmt(ST.LOCAL_START, left, new ArrayExpr());

    // Act
    Value actualOnAssignResult = replaceX.onAssign(v, as);

    // Assert
    assertSame(v, actualOnAssignResult);
  }

  /**
   * Test ReplaceX {@link ReplaceX#onUse(Local)}.
   *
   * <ul>
   *   <li>When {@link Local#Local()}.
   *   <li>Then return {@link Local#Local()}.
   * </ul>
   *
   * <p>Method under test: {@link ReplaceX#onUse(Local)}
   */
  @Test
  @DisplayName("Test ReplaceX onUse(Local); when Local(); then return Local()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value ReplaceX.onUse(Local)"})
  void testReplaceXOnUse_whenLocal_thenReturnLocal() {
    // Arrange
    ReplaceX replaceX = new ReplaceX();
    Local v = new Local();

    // Act
    Value actualOnUseResult = replaceX.onUse(v);

    // Assert
    assertSame(v, actualOnUseResult);
  }

  /**
   * Test ReplaceX {@link ReplaceX#onUse(Local)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReplaceX#onUse(Local)}
   */
  @Test
  @DisplayName("Test ReplaceX onUse(Local); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value ReplaceX.onUse(Local)"})
  void testReplaceXOnUse_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ReplaceX().onUse(null));
  }

  /**
   * Test {@link AggTransformer#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Local#Local()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AggTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transformReportChanged(IrMethod); given ArrayList() add Local(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.transformReportChanged(IrMethod)"})
  void testTransformReportChanged_givenArrayListAddLocal_thenReturnFalse() {
    // Arrange
    AggTransformer aggTransformer = new AggTransformer();

    ArrayList<Local> localList = new ArrayList<>();
    localList.add(new Local());
    IrMethod method = new IrMethod();
    method.locals = localList;

    // Act and Assert
    assertFalse(aggTransformer.transformReportChanged(method));
  }

  /**
   * Test {@link AggTransformer#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AggTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transformReportChanged(IrMethod); when IrMethod (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.transformReportChanged(IrMethod)"})
  void testTransformReportChanged_whenIrMethod_thenReturnFalse() {
    // Arrange
    AggTransformer aggTransformer = new AggTransformer();

    // Act and Assert
    assertFalse(aggTransformer.transformReportChanged(new IrMethod()));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @DisplayName("Test isLocationInsensitive(Value) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  void testIsLocationInsensitiveWithOp() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();
    BinopExpr op = new BinopExpr(VT.ADD, op1, new ArrayExpr(), "Type");

    // Act and Assert
    assertFalse(AggTransformer.isLocationInsensitive(op));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @DisplayName("Test isLocationInsensitive(Value) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  void testIsLocationInsensitiveWithOp2() {
    // Arrange
    CastExpr op =
        new CastExpr(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org");

    // Act and Assert
    assertFalse(AggTransformer.isLocationInsensitive(op));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @DisplayName("Test isLocationInsensitive(Value) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  void testIsLocationInsensitiveWithOp3() {
    // Arrange
    Value[] datas = new Value[] {new ArrayExpr()};
    FilledArrayExpr op = new FilledArrayExpr(datas, "Type");

    // Act and Assert
    assertFalse(AggTransformer.isLocationInsensitive(op));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @DisplayName("Test isLocationInsensitive(Value) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  void testIsLocationInsensitiveWithOp4() {
    // Arrange
    Value[] args = new Value[] {new ArrayExpr()};
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);
    Object[] bsmArgs = new Object[] {Constant.Null};

    InvokeCustomExpr op = new InvokeCustomExpr(VT.ADD, args, "Method Name", proto, handle, bsmArgs);

    // Act and Assert
    assertFalse(AggTransformer.isLocationInsensitive(op));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @DisplayName("Test isLocationInsensitive(Value) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  void testIsLocationInsensitiveWithOp5() {
    // Arrange
    Constant op1 = Exprs.nNull();
    BinopExpr op = new BinopExpr(VT.ADD, op1, new ArrayExpr(), "Type");

    // Act and Assert
    assertFalse(AggTransformer.isLocationInsensitive(op));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @DisplayName("Test isLocationInsensitive(Value) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  void testIsLocationInsensitiveWithOp6() {
    // Arrange
    Value[] args = new Value[] {Exprs.nNull()};
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Field field = new Field("Owner", "Name", "Type");
    MethodHandle handle = new MethodHandle(1, field);
    Object[] bsmArgs = new Object[] {Constant.Null};

    InvokeCustomExpr op = new InvokeCustomExpr(VT.ADD, args, "Method Name", proto, handle, bsmArgs);

    // Act and Assert
    assertTrue(AggTransformer.isLocationInsensitive(op));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @DisplayName("Test isLocationInsensitive(Value) with 'op'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  void testIsLocationInsensitiveWithOp7() {
    // Arrange
    Constant op1 = Exprs.nNull();
    BinopExpr op = new BinopExpr(VT.ADD, op1, Exprs.nNull(), "Type");

    // Act and Assert
    assertTrue(AggTransformer.isLocationInsensitive(op));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <ul>
   *   <li>When {@link ArrayExpr#ArrayExpr()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @DisplayName("Test isLocationInsensitive(Value) with 'op'; when ArrayExpr(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  void testIsLocationInsensitiveWithOp_whenArrayExpr_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AggTransformer.isLocationInsensitive(new ArrayExpr()));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <ul>
   *   <li>When nNull.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @DisplayName("Test isLocationInsensitive(Value) with 'op'; when nNull; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  void testIsLocationInsensitiveWithOp_whenNNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AggTransformer.isLocationInsensitive(Exprs.nNull()));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(VT)} with {@code vt}.
   *
   * <ul>
   *   <li>When {@code ADD}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value.VT)}
   */
  @Test
  @DisplayName("Test isLocationInsensitive(VT) with 'vt'; when 'ADD'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value.VT)"})
  void testIsLocationInsensitiveWithVt_whenAdd_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AggTransformer.isLocationInsensitive(VT.ADD));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(VT)} with {@code vt}.
   *
   * <ul>
   *   <li>When {@code FIELD}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value.VT)}
   */
  @Test
  @DisplayName("Test isLocationInsensitive(VT) with 'vt'; when 'FIELD'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value.VT)"})
  void testIsLocationInsensitiveWithVt_whenField_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AggTransformer.isLocationInsensitive(VT.FIELD));
  }
}
