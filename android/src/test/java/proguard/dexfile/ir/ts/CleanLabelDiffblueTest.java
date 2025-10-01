package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;

class CleanLabelDiffblueTest {
  /**
   * Test {@link CleanLabel#transform(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link IrMethod} (default constructor) {@link IrMethod#phiLabels} is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CleanLabel#transform(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transform(IrMethod); given ArrayList(); when IrMethod (default constructor) phiLabels is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanLabel.transform(IrMethod)"})
  void testTransform_givenArrayList_whenIrMethodPhiLabelsIsArrayList() {
    // Arrange
    CleanLabel cleanLabel = new CleanLabel();
    IrMethod irMethod = new IrMethod();
    irMethod.phiLabels = new ArrayList<>();

    // Act
    cleanLabel.transform(irMethod);

    // Assert that nothing has changed
    StmtList stmtList = irMethod.stmts;
    assertEquals(0, stmtList.getSize());
    assertFalse(stmtList.iterator().hasNext());
  }

  /**
   * Test {@link CleanLabel#transform(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nLabel.
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CleanLabel#transform(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transform(IrMethod); given StmtList (default constructor) add nLabel; then IrMethod (default constructor) stmts First is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanLabel.transform(IrMethod)"})
  void testTransform_givenStmtListAddNLabel_thenIrMethodStmtsFirstIsNull() {
    // Arrange
    CleanLabel cleanLabel = new CleanLabel();

    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    cleanLabel.transform(irMethod);

    // Assert
    StmtList stmtList2 = irMethod.stmts;
    assertNull(stmtList2.getFirst());
    assertNull(stmtList2.getLast());
    assertEquals(0, stmtList2.getSize());
    assertFalse(stmtList2.iterator().hasNext());
  }

  /**
   * Test {@link CleanLabel#transform(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link StmtList} (default constructor) add nLabel.
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} First is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CleanLabel#transform(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transform(IrMethod); given StmtList (default constructor) add nLabel; then IrMethod (default constructor) stmts First is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanLabel.transform(IrMethod)"})
  void testTransform_givenStmtListAddNLabel_thenIrMethodStmtsFirstIsNull2() {
    // Arrange
    CleanLabel cleanLabel = new CleanLabel();

    StmtList stmtList = new StmtList();
    stmtList.add(Stmts.nLabel());
    stmtList.add(Stmts.nLabel());
    IrMethod irMethod = new IrMethod();
    irMethod.stmts = stmtList;

    // Act
    cleanLabel.transform(irMethod);

    // Assert
    StmtList stmtList2 = irMethod.stmts;
    assertNull(stmtList2.getFirst());
    assertNull(stmtList2.getLast());
    assertEquals(0, stmtList2.getSize());
    assertFalse(stmtList2.iterator().hasNext());
  }

  /**
   * Test {@link CleanLabel#transform(IrMethod)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then {@link IrMethod} (default constructor) {@link IrMethod#stmts} Size is zero.
   * </ul>
   *
   * <p>Method under test: {@link CleanLabel#transform(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transform(IrMethod); when IrMethod (default constructor); then IrMethod (default constructor) stmts Size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CleanLabel.transform(IrMethod)"})
  void testTransform_whenIrMethod_thenIrMethodStmtsSizeIsZero() {
    // Arrange
    CleanLabel cleanLabel = new CleanLabel();
    IrMethod irMethod = new IrMethod();

    // Act
    cleanLabel.transform(irMethod);

    // Assert that nothing has changed
    StmtList stmtList = irMethod.stmts;
    assertEquals(0, stmtList.getSize());
    assertFalse(stmtList.iterator().hasNext());
  }
}
