package proguard.dexfile.ir.ts.an;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
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
   * Test {@link SimpleLiveAnalyze#getLocalSize()}.
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#getLocalSize()}
   */
  @Test
  @DisplayName("Test getLocalSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SimpleLiveAnalyze.getLocalSize()"})
  void testGetLocalSize() {
    // Arrange, Act and Assert
    assertEquals(0, new SimpleLiveAnalyze(new IrMethod(), true).getLocalSize());
  }

  /**
   * Test {@link SimpleLiveAnalyze#SimpleLiveAnalyze(IrMethod, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link BaseAnalyze#method} {@link IrMethod#locals} is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#SimpleLiveAnalyze(IrMethod, boolean)}
   */
  @Test
  @DisplayName(
      "Test new SimpleLiveAnalyze(IrMethod, boolean); then return method locals is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleLiveAnalyze.<init>(IrMethod, boolean)"})
  void testNewSimpleLiveAnalyze_thenReturnMethodLocalsIsArrayList() {
    // Arrange
    ArrayList<Local> localList = new ArrayList<>();
    localList.add(new Local(-1));
    IrMethod method = new IrMethod();
    method.locals = localList;

    // Act and Assert
    assertSame(localList, new SimpleLiveAnalyze(method, false).method.locals);
  }

  /**
   * Test {@link SimpleLiveAnalyze#SimpleLiveAnalyze(IrMethod, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link BaseAnalyze#method} {@link IrMethod#locals} size is one.
   * </ul>
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#SimpleLiveAnalyze(IrMethod, boolean)}
   */
  @Test
  @DisplayName(
      "Test new SimpleLiveAnalyze(IrMethod, boolean); then return method locals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleLiveAnalyze.<init>(IrMethod, boolean)"})
  void testNewSimpleLiveAnalyze_thenReturnMethodLocalsSizeIsOne() {
    // Arrange
    ArrayList<Local> localList = new ArrayList<>();
    Local local = new Local(0);
    localList.add(local);
    IrMethod method = new IrMethod();
    method.locals = localList;

    // Act
    SimpleLiveAnalyze actualSimpleLiveAnalyze = new SimpleLiveAnalyze(method, false);

    // Assert
    List<Local> localList2 = actualSimpleLiveAnalyze.method.locals;
    assertEquals(1, localList2.size());
    assertEquals(1, actualSimpleLiveAnalyze.getLocalSize());
    assertSame(local, localList2.get(0));
  }

  /**
   * Test {@link SimpleLiveAnalyze#SimpleLiveAnalyze(IrMethod, boolean)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then return {@link BaseAnalyze#method} {@link IrMethod#name} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleLiveAnalyze#SimpleLiveAnalyze(IrMethod, boolean)}
   */
  @Test
  @DisplayName(
      "Test new SimpleLiveAnalyze(IrMethod, boolean); when IrMethod (default constructor); then return method name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleLiveAnalyze.<init>(IrMethod, boolean)"})
  void testNewSimpleLiveAnalyze_whenIrMethod_thenReturnMethodNameIsNull() {
    // Arrange
    IrMethod method = new IrMethod();

    // Act
    SimpleLiveAnalyze actualSimpleLiveAnalyze = new SimpleLiveAnalyze(method, true);

    // Assert
    IrMethod irMethod = actualSimpleLiveAnalyze.method;
    assertNull(irMethod.name);
    assertNull(irMethod.owner);
    assertNull(irMethod.ret);
    assertNull(irMethod.args);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleLiveValue SimpleLiveAnalyze.onAssignLocal(Local, Value)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleLiveAnalyze.onUseLocal(SimpleLiveValue, Local)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SimpleLiveValue[] SimpleLiveAnalyze.merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)"
  })
  void testMergeWithSimpleLiveValueSimpleLiveValueStmtStmt() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue[] distFrame = new SimpleLiveValue[] {null};
    LabelStmt src = Stmts.nLabel();

    // Act
    SimpleLiveValue[] actualMergeResult =
        simpleLiveAnalyze.merge(
            new SimpleLiveValue[] {new SimpleLiveValue()}, distFrame, src, Stmts.nLabel());

    // Assert
    assertSame(distFrame, actualMergeResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SimpleLiveValue[] SimpleLiveAnalyze.merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)"
  })
  void testMergeWithSimpleLiveValueSimpleLiveValueStmtStmt2() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    LabelStmt src = Stmts.nLabel();

    // Act and Assert
    assertEquals(
        0, simpleLiveAnalyze.merge(new SimpleLiveValue[] {}, null, src, Stmts.nLabel()).length);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SimpleLiveValue[] SimpleLiveAnalyze.merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)"
  })
  void testMergeWithSimpleLiveValueSimpleLiveValueStmtStmt3() {
    // Arrange
    SimpleLiveAnalyze simpleLiveAnalyze = new SimpleLiveAnalyze(new IrMethod(), true);
    SimpleLiveValue[] distFrame = new SimpleLiveValue[] {new SimpleLiveValue()};
    LabelStmt src = Stmts.nLabel();

    // Act
    SimpleLiveValue[] actualMergeResult =
        simpleLiveAnalyze.merge(new SimpleLiveValue[] {null}, distFrame, src, Stmts.nLabel());

    // Assert
    assertSame(distFrame, actualMergeResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SimpleLiveValue[] SimpleLiveAnalyze.merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)"
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
    assertSame(simpleLiveValue.otherParents, actualMergeResult[0].otherParents);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SimpleLiveValue[] SimpleLiveAnalyze.merge(SimpleLiveValue[], SimpleLiveValue[], Stmt, Stmt)"
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleLiveValue[] SimpleLiveAnalyze.newFrame(int)"})
  void testNewFrameWithInt_whenThree_thenReturnFirstElementIsNull() {
    // Arrange and Act
    SimpleLiveValue[] actualNewFrameResult =
        new SimpleLiveAnalyze(new IrMethod(), true).newFrame(3);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleLiveValue SimpleLiveAnalyze.newValue()"})
  void testNewValue() {
    // Arrange and Act
    SimpleLiveValue actualNewValueResult = new SimpleLiveAnalyze(new IrMethod(), true).newValue();

    // Assert
    assertEquals('.', actualNewValueResult.toRsp());
    assertNull(actualNewValueResult.otherParents);
    assertNull(actualNewValueResult.parent);
    assertFalse(actualNewValueResult.used);
  }
}
