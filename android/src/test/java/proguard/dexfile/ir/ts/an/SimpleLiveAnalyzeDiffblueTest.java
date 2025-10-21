package proguard.dexfile.ir.ts.an;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmts;

public class SimpleLiveAnalyzeDiffblueTest {
  /**
   * Test {@link SimpleLiveAnalyze#markUsed()}.
   *
   * <ul>
   *   <li>Given {@link SimpleLiveAnalyze#SimpleLiveAnalyze(IrMethod, boolean)} with method is
   *       {@link IrMethod} (default constructor) and reindexLocal is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#markUsed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set SimpleLiveAnalyze.markUsed()"})
  public void testMarkUsed_givenSimpleLiveAnalyzeWithMethodIsIrMethodAndReindexLocalIsTrue() {
    // Arrange, Act and Assert
    assertTrue((new SimpleLiveAnalyze(new IrMethod(), true)).markUsed().isEmpty());
  }

  /**
   * Test {@link SimpleLiveAnalyze#getLocalSize()}.
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#getLocalSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SimpleLiveAnalyze.getLocalSize()"})
  public void testGetLocalSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new SimpleLiveAnalyze(new IrMethod(), true)).getLocalSize());
  }

  /**
   * Test {@link SimpleLiveAnalyze#SimpleLiveAnalyze(IrMethod, boolean)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then return {@link BaseAnalyze#method} {@link IrMethod#args} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#SimpleLiveAnalyze(IrMethod, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleLiveAnalyze.<init>(IrMethod, boolean)"})
  public void testNewSimpleLiveAnalyze_whenIrMethod_thenReturnMethodArgsIsNull() {
    // Arrange
    IrMethod method = new IrMethod();

    // Act
    SimpleLiveAnalyze actualSimpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Assert
    IrMethod irMethod = actualSimpleLiveAnalyze.method;
    assertNull(irMethod.args);
    assertNull(irMethod.name);
    assertNull(irMethod.owner);
    assertNull(irMethod.ret);
    assertNull(irMethod.phiLabels);
    assertFalse(irMethod.isStatic);
    assertTrue(irMethod.locals.isEmpty());
    assertTrue(irMethod.traps.isEmpty());
    assertTrue(irMethod.vars.isEmpty());
    assertTrue(actualSimpleLiveAnalyze.aValues.isEmpty());
    assertSame(method.stmts, irMethod.stmts);
  }

  /**
   * Test {@link SimpleLiveAnalyze#onAssignLocal(Local, Value)}.
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#onAssignLocal(Local, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SimpleLiveValue SimpleLiveAnalyze.onAssignLocal(Local, Value)"})
  public void testOnAssignLocal() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    Local local = new Local();

    // Act
    SimpleLiveValue actualOnAssignLocalResult =
        simpleLiveAnalyze.onAssignLocal(local, new ArrayExpr());

    // Assert
    assertEquals('x', actualOnAssignLocalResult.toRsp());
    assertNull(actualOnAssignLocalResult.otherParents);
    assertNull(actualOnAssignLocalResult.parent);
    assertTrue(actualOnAssignLocalResult.used);
  }

  /**
   * Test {@link SimpleLiveAnalyze#onUseLocal(SimpleLiveValue, Local)} with {@code SimpleLiveValue},
   * {@code Local}.
   *
   * <ul>
   *   <li>Then {@link SimpleLiveValue} (default constructor) toRsp is {@code x}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#onUseLocal(SimpleLiveValue, Local)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SimpleLiveAnalyze.onUseLocal(SimpleLiveValue, Local)"})
  public void testOnUseLocalWithSimpleLiveValueLocal_thenSimpleLiveValueToRspIsX() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue aValue = new SimpleLiveValue();

    // Act
    simpleLiveAnalyze.onUseLocal(aValue, new Local());

    // Assert
    assertEquals('x', aValue.toRsp());
    assertTrue(aValue.used);
  }

  /**
   * Test {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)} with
   * {@code SimpleLiveValue[]}, {@code SimpleLiveValue[]}, {@code Stmt}, {@code Stmt}.
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[],
   * Stmt, Stmt)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "SimpleLiveValue[] SimpleLiveAnalyze.merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)"
  })
  public void testMergeWithSimpleLiveValueSimpleLiveValueStmtStmt() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue[] distFrame = new SimpleLiveValue[] {new SimpleLiveValue()};
    LabelStmt src = Stmts.nLabel();

    // Act and Assert
    assertSame(
        distFrame,
        simpleLiveAnalyze.merge(new SimpleLiveValue[] {null}, distFrame, src, Stmts.nLabel()));
  }

  /**
   * Test {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)} with
   * {@code SimpleLiveValue[]}, {@code SimpleLiveValue[]}, {@code Stmt}, {@code Stmt}.
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[],
   * Stmt, Stmt)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "SimpleLiveValue[] SimpleLiveAnalyze.merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)"
  })
  public void testMergeWithSimpleLiveValueSimpleLiveValueStmtStmt2() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue[] distFrame = new SimpleLiveValue[] {null};
    LabelStmt src = Stmts.nLabel();

    // Act and Assert
    assertSame(
        distFrame,
        simpleLiveAnalyze.merge(
            new SimpleLiveValue[] {new SimpleLiveValue()}, distFrame, src, Stmts.nLabel()));
  }

  /**
   * Test {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)} with
   * {@code SimpleLiveValue[]}, {@code SimpleLiveValue[]}, {@code Stmt}, {@code Stmt}.
   *
   * <ul>
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[],
   * Stmt, Stmt)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "SimpleLiveValue[] SimpleLiveAnalyze.merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)"
  })
  public void testMergeWithSimpleLiveValueSimpleLiveValueStmtStmt_thenReturnArrayLengthIsOne() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue simpleLiveValue = new SimpleLiveValue();
    LabelStmt src = Stmts.nLabel();

    // Act
    SimpleLiveValue[] actualMergeResult =
        simpleLiveAnalyze.merge(
            new SimpleLiveValue[] {new SimpleLiveValue()},
            new SimpleLiveValue[] {simpleLiveValue},
            src,
            Stmts.nLabel());

    // Assert
    assertEquals(1, actualMergeResult.length);
    assertSame(simpleLiveValue.otherParents, (actualMergeResult[0]).otherParents);
  }

  /**
   * Test {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)} with
   * {@code SimpleLiveValue[]}, {@code SimpleLiveValue[]}, {@code Stmt}, {@code Stmt}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#merge(SimpleLiveValue[], SimpleLiveValue[],
   * Stmt, Stmt)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "SimpleLiveValue[] SimpleLiveAnalyze.merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)"
  })
  public void testMergeWithSimpleLiveValueSimpleLiveValueStmtStmt_thenReturnArrayLengthIsZero() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    LabelStmt src = Stmts.nLabel();

    // Act and Assert
    assertEquals(
        0, simpleLiveAnalyze.merge(new SimpleLiveValue[] {null}, null, src, Stmts.nLabel()).length);
  }

  /**
   * Test {@link SimpleLiveAnalyze#newFrame(int)} with {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#newFrame(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SimpleLiveValue[] SimpleLiveAnalyze.newFrame(int)"})
  public void testNewFrameWithInt_whenThree_thenReturnFirstElementIsNull() {
    // Arrange and Act
    SimpleLiveValue[] actualNewFrameResult =
        (new SimpleLiveAnalyze(new IrMethod(), true)).newFrame(3);

    // Assert
    assertNull(actualNewFrameResult[0]);
    assertNull(actualNewFrameResult[1]);
    assertNull(actualNewFrameResult[2]);
    assertEquals(3, actualNewFrameResult.length);
  }

  /**
   * Test {@link SimpleLiveAnalyze#newValue()}.
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#newValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SimpleLiveValue SimpleLiveAnalyze.newValue()"})
  public void testNewValue() {
    // Arrange and Act
    SimpleLiveValue actualNewValueResult = (new SimpleLiveAnalyze(new IrMethod(), true)).newValue();

    // Assert
    assertEquals('.', actualNewValueResult.toRsp());
    assertNull(actualNewValueResult.otherParents);
    assertNull(actualNewValueResult.parent);
    assertFalse(actualNewValueResult.used);
  }
}
