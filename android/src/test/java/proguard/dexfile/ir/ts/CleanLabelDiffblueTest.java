package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import org.junit.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.stmt.StmtList;
import proguard.dexfile.ir.stmt.Stmts;

public class CleanLabelDiffblueTest {
  /**
   * Method under test: {@link CleanLabel#transform(IrMethod)}
   */
  @Test
  public void testTransform() {
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

  /**
   * Method under test: {@link CleanLabel#transform(IrMethod)}
   */
  @Test
  public void testTransform2() {
    // Arrange
    CleanLabel cleanLabel = new CleanLabel();
    IrMethod irMethod = new IrMethod();
    irMethod.phiLabels = new ArrayList<>();

    // Act
    cleanLabel.transform(irMethod);

    // Assert
    StmtList stmtList = irMethod.stmts;
    assertNull(stmtList.getFirst());
    assertNull(stmtList.getLast());
    assertEquals(0, stmtList.getSize());
    assertFalse(stmtList.iterator().hasNext());
  }

  /**
   * Method under test: {@link CleanLabel#transform(IrMethod)}
   */
  @Test
  public void testTransform3() {
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
   * Method under test: {@link CleanLabel#transform(IrMethod)}
   */
  @Test
  public void testTransform4() {
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
}
