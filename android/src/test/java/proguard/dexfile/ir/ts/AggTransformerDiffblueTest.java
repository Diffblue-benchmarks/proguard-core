package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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

public class AggTransformerDiffblueTest {
  /**
   * Test MergeResult new {@link MergeResult} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MergeResult}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergeResult.<init>()"})
  public void testMergeResultNewMergeResult() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReplaceX.<init>()"})
  public void testReplaceXNewReplaceX() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReplaceX.onAssign(Local, AssignStmt)"})
  public void testReplaceXOnAssign() {
    // Arrange
    ReplaceX replaceX = new ReplaceX();
    Local v = new Local();
    ArrayExpr left = new ArrayExpr();

    // Act and Assert
    assertSame(v, replaceX.onAssign(v, new AssignStmt(ST.LOCAL_START, left, new ArrayExpr())));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReplaceX.onUse(Local)"})
  public void testReplaceXOnUse_whenLocal_thenReturnLocal() {
    // Arrange
    ReplaceX replaceX = new ReplaceX();
    Local v = new Local();

    // Act and Assert
    assertSame(v, replaceX.onUse(v));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReplaceX.onUse(Local)"})
  public void testReplaceXOnUse_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ReplaceX()).onUse(null));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged_givenArrayListAddLocal_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged_whenIrMethod_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  public void testIsLocationInsensitiveWithOp() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();

    // Act and Assert
    assertFalse(
        AggTransformer.isLocationInsensitive(new BinopExpr(VT.ADD, op1, new ArrayExpr(), "Type")));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  public void testIsLocationInsensitiveWithOp2() {
    // Arrange, Act and Assert
    assertFalse(
        AggTransformer.isLocationInsensitive(
            new CastExpr(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org")));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  public void testIsLocationInsensitiveWithOp3() {
    // Arrange, Act and Assert
    assertFalse(
        AggTransformer.isLocationInsensitive(
            new FilledArrayExpr(new Value[] {new ArrayExpr()}, "Type")));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  public void testIsLocationInsensitiveWithOp4() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertFalse(
        AggTransformer.isLocationInsensitive(
            new InvokeCustomExpr(
                VT.ADD,
                new Value[] {new ArrayExpr()},
                "Method Name",
                proto,
                new MethodHandle(1, new Field("Owner", "Name", "Type")),
                new Object[] {Constant.Null})));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  public void testIsLocationInsensitiveWithOp5() {
    // Arrange
    Constant op1 = Exprs.nNull();

    // Act and Assert
    assertFalse(
        AggTransformer.isLocationInsensitive(new BinopExpr(VT.ADD, op1, new ArrayExpr(), "Type")));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  public void testIsLocationInsensitiveWithOp6() {
    // Arrange
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act and Assert
    assertTrue(
        AggTransformer.isLocationInsensitive(
            new InvokeCustomExpr(
                VT.ADD,
                new Value[] {Exprs.nNull()},
                "Method Name",
                proto,
                new MethodHandle(1, new Field("Owner", "Name", "Type")),
                new Object[] {Constant.Null})));
  }

  /**
   * Test {@link AggTransformer#isLocationInsensitive(Value)} with {@code op}.
   *
   * <p>Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  public void testIsLocationInsensitiveWithOp7() {
    // Arrange
    Constant op1 = Exprs.nNull();

    // Act and Assert
    assertTrue(
        AggTransformer.isLocationInsensitive(new BinopExpr(VT.ADD, op1, Exprs.nNull(), "Type")));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  public void testIsLocationInsensitiveWithOp_whenArrayExpr_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value)"})
  public void testIsLocationInsensitiveWithOp_whenNNull_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value.VT)"})
  public void testIsLocationInsensitiveWithVt_whenAdd_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AggTransformer.isLocationInsensitive(Value.VT)"})
  public void testIsLocationInsensitiveWithVt_whenField_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AggTransformer.isLocationInsensitive(VT.FIELD));
  }
}
