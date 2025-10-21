package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;

public class CleanLabelDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CleanLabel.transform(IrMethod)"})
  public void testTransform_givenArrayList_whenIrMethodPhiLabelsIsArrayList() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CleanLabel.transform(IrMethod)"})
  public void testTransform_givenStmtListAddNLabel_thenIrMethodStmtsFirstIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CleanLabel.transform(IrMethod)"})
  public void testTransform_givenStmtListAddNLabel_thenIrMethodStmtsFirstIsNull2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CleanLabel.transform(IrMethod)"})
  public void testTransform_whenIrMethod_thenIrMethodStmtsSizeIsZero() {
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
