package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
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
import proguard.dexfile.ir.stmt.AssignStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.MethodHandle;
import proguard.dexfile.reader.Proto;

public class AggTransformerDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link AggTransformer.MergeResult}
   */
  @Test
  public void testMergeResultNewMergeResult() {
    // Arrange and Act
    AggTransformer.MergeResult actualMergeResult = new AggTransformer.MergeResult();

    // Assert
    assertNull(actualMergeResult.getMessage());
    assertNull(actualMergeResult.getCause());
    assertEquals(0, actualMergeResult.getSuppressed().length);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AggTransformer.ReplaceX}
   */
  @Test
  public void testReplaceXNewReplaceX() {
    // Arrange and Act
    AggTransformer.ReplaceX actualReplaceX = new AggTransformer.ReplaceX();

    // Assert
    assertNull(actualReplaceX.local);
    assertNull(actualReplaceX.replaceWith);
  }

  /**
   * Method under test:
   * {@link AggTransformer.ReplaceX#onAssign(Local, AssignStmt)}
   */
  @Test
  public void testReplaceXOnAssign() {
    // Arrange
    AggTransformer.ReplaceX replaceX = new AggTransformer.ReplaceX();
    Local v = new Local();
    ArrayExpr left = new ArrayExpr();

    // Act and Assert
    assertSame(v, replaceX.onAssign(v, new AssignStmt(Stmt.ST.LOCAL_START, left, new ArrayExpr())));
  }

  /**
   * Method under test: {@link AggTransformer.ReplaceX#onUse(Local)}
   */
  @Test
  public void testReplaceXOnUse() {
    // Arrange
    AggTransformer.ReplaceX replaceX = new AggTransformer.ReplaceX();
    Local v = new Local();

    // Act and Assert
    assertSame(v, replaceX.onUse(v));
  }

  /**
   * Method under test: {@link AggTransformer.ReplaceX#onUse(Local)}
   */
  @Test
  public void testReplaceXOnUse2() {
    // Arrange, Act and Assert
    assertNull((new AggTransformer.ReplaceX()).onUse(null));
  }

  /**
   * Method under test: {@link AggTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged() {
    // Arrange
    AggTransformer aggTransformer = new AggTransformer();

    // Act and Assert
    assertFalse(aggTransformer.transformReportChanged(new IrMethod()));
  }

  /**
   * Method under test: {@link AggTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged2() {
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
   * Method under test: {@link AggTransformer#isLocationInsensitive(Value.VT)}
   */
  @Test
  public void testIsLocationInsensitive() {
    // Arrange, Act and Assert
    assertTrue(AggTransformer.isLocationInsensitive(Value.VT.ADD));
    assertFalse(AggTransformer.isLocationInsensitive(Value.VT.FIELD));
    assertFalse(AggTransformer.isLocationInsensitive(new ArrayExpr()));
    assertFalse(AggTransformer
        .isLocationInsensitive(new CastExpr(new ArrayExpr(), "jane.doe@example.org", "alice.liddell@example.org")));
    assertTrue(AggTransformer.isLocationInsensitive(Exprs.nNull()));
    assertFalse(AggTransformer.isLocationInsensitive(new FilledArrayExpr(new Value[]{new ArrayExpr()}, "Type")));
  }

  /**
   * Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  public void testIsLocationInsensitive2() {
    // Arrange
    ArrayExpr op1 = new ArrayExpr();

    // Act and Assert
    assertFalse(AggTransformer.isLocationInsensitive(new BinopExpr(Value.VT.ADD, op1, new ArrayExpr(), "Type")));
  }

  /**
   * Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  public void testIsLocationInsensitive3() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertFalse(AggTransformer.isLocationInsensitive(new InvokeCustomExpr(Value.VT.ADD, new Value[]{new ArrayExpr()},
        "Method Name", proto, new MethodHandle(1, new Field("Owner", "Name", "Type")), new Object[]{Constant.Null})));
  }

  /**
   * Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  public void testIsLocationInsensitive4() {
    // Arrange
    Constant op1 = Exprs.nNull();

    // Act and Assert
    assertFalse(AggTransformer.isLocationInsensitive(new BinopExpr(Value.VT.ADD, op1, new ArrayExpr(), "Type")));
  }

  /**
   * Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  public void testIsLocationInsensitive5() {
    // Arrange
    Proto proto = new Proto(new String[]{"Parameter Types"}, "Return Type");

    // Act and Assert
    assertTrue(AggTransformer.isLocationInsensitive(new InvokeCustomExpr(Value.VT.ADD, new Value[]{Exprs.nNull()},
        "Method Name", proto, new MethodHandle(1, new Field("Owner", "Name", "Type")), new Object[]{Constant.Null})));
  }

  /**
   * Method under test: {@link AggTransformer#isLocationInsensitive(Value)}
   */
  @Test
  public void testIsLocationInsensitive6() {
    // Arrange
    Constant op1 = Exprs.nNull();

    // Act and Assert
    assertTrue(AggTransformer.isLocationInsensitive(new BinopExpr(Value.VT.ADD, op1, Exprs.nNull(), "Type")));
  }
}
