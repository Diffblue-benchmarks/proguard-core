package proguard.dexfile.ir.ts.an;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.ArrayExpr;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.expr.Value;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmt;
import proguard.dexfile.ir.stmt.Stmts;

class SimpleLiveAnalyzeDiffblueTest {
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
  @DisplayName(
      "Test markUsed(); given SimpleLiveAnalyze(IrMethod, boolean) with method is IrMethod (default constructor) and reindexLocal is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set proguard.dexfile.ir.ts.an.SimpleLiveAnalyze.markUsed()"})
  void testMarkUsed_givenSimpleLiveAnalyzeWithMethodIsIrMethodAndReindexLocalIsTrue() {
    // Arrange, Act and Assert
    assertTrue((new SimpleLiveAnalyze(new IrMethod(), true)).markUsed().isEmpty());
  }

  /**
   * Test {@link SimpleLiveAnalyze#getLocalSize()}.
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#getLocalSize()}
   */
  @Test
  @DisplayName("Test getLocalSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.dexfile.ir.ts.an.SimpleLiveAnalyze.getLocalSize()"})
  void testGetLocalSize() {
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
  @DisplayName(
      "Test new SimpleLiveAnalyze(IrMethod, boolean); when IrMethod (default constructor); then return method args is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.an.SimpleLiveAnalyze.<init>(proguard.dexfile.ir.IrMethod, boolean)"
  })
  void testNewSimpleLiveAnalyze_whenIrMethod_thenReturnMethodArgsIsNull() {
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
  @DisplayName("Test onAssignLocal(Local, Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.ts.an.SimpleLiveValue proguard.dexfile.ir.ts.an.SimpleLiveAnalyze.onAssignLocal(proguard.dexfile.ir.expr.Local, proguard.dexfile.ir.expr.Value)"
  })
  void testOnAssignLocal() {
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
  @DisplayName(
      "Test onUseLocal(SimpleLiveValue, Local) with 'SimpleLiveValue', 'Local'; then SimpleLiveValue (default constructor) toRsp is 'x'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.an.SimpleLiveAnalyze.onUseLocal(proguard.dexfile.ir.ts.an.SimpleLiveValue, proguard.dexfile.ir.expr.Local)"
  })
  void testOnUseLocalWithSimpleLiveValueLocal_thenSimpleLiveValueToRspIsX() {
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
  @DisplayName(
      "Test merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt) with 'SimpleLiveValue[]', 'SimpleLiveValue[]', 'Stmt', 'Stmt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.ts.an.SimpleLiveValue[] proguard.dexfile.ir.ts.an.SimpleLiveAnalyze.merge(proguard.dexfile.ir.ts.an.SimpleLiveValue[], proguard.dexfile.ir.ts.an.SimpleLiveValue[], proguard.dexfile.ir.stmt.Stmt, proguard.dexfile.ir.stmt.Stmt)"
  })
  void testMergeWithSimpleLiveValueSimpleLiveValueStmtStmt() {
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
  @DisplayName(
      "Test merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt) with 'SimpleLiveValue[]', 'SimpleLiveValue[]', 'Stmt', 'Stmt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.ts.an.SimpleLiveValue[] proguard.dexfile.ir.ts.an.SimpleLiveAnalyze.merge(proguard.dexfile.ir.ts.an.SimpleLiveValue[], proguard.dexfile.ir.ts.an.SimpleLiveValue[], proguard.dexfile.ir.stmt.Stmt, proguard.dexfile.ir.stmt.Stmt)"
  })
  void testMergeWithSimpleLiveValueSimpleLiveValueStmtStmt2() {
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
  @DisplayName(
      "Test merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt) with 'SimpleLiveValue[]', 'SimpleLiveValue[]', 'Stmt', 'Stmt'; then return array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.ts.an.SimpleLiveValue[] proguard.dexfile.ir.ts.an.SimpleLiveAnalyze.merge(proguard.dexfile.ir.ts.an.SimpleLiveValue[], proguard.dexfile.ir.ts.an.SimpleLiveValue[], proguard.dexfile.ir.stmt.Stmt, proguard.dexfile.ir.stmt.Stmt)"
  })
  void testMergeWithSimpleLiveValueSimpleLiveValueStmtStmt_thenReturnArrayLengthIsOne() {
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
  @DisplayName(
      "Test merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt) with 'SimpleLiveValue[]', 'SimpleLiveValue[]', 'Stmt', 'Stmt'; then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.ts.an.SimpleLiveValue[] proguard.dexfile.ir.ts.an.SimpleLiveAnalyze.merge(proguard.dexfile.ir.ts.an.SimpleLiveValue[], proguard.dexfile.ir.ts.an.SimpleLiveValue[], proguard.dexfile.ir.stmt.Stmt, proguard.dexfile.ir.stmt.Stmt)"
  })
  void testMergeWithSimpleLiveValueSimpleLiveValueStmtStmt_thenReturnArrayLengthIsZero() {
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
  @DisplayName("Test newFrame(int) with 'int'; when three; then return first element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.ts.an.SimpleLiveValue[] proguard.dexfile.ir.ts.an.SimpleLiveAnalyze.newFrame(int)"
  })
  void testNewFrameWithInt_whenThree_thenReturnFirstElementIsNull() {
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
  @DisplayName("Test newValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.ts.an.SimpleLiveValue proguard.dexfile.ir.ts.an.SimpleLiveAnalyze.newValue()"
  })
  void testNewValue() {
    // Arrange and Act
    SimpleLiveValue actualNewValueResult = (new SimpleLiveAnalyze(new IrMethod(), true)).newValue();

    // Assert
    assertEquals('.', actualNewValueResult.toRsp());
    assertNull(actualNewValueResult.otherParents);
    assertNull(actualNewValueResult.parent);
    assertFalse(actualNewValueResult.used);
  }
}
