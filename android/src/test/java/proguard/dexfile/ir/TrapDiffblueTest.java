package proguard.dexfile.ir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmts;

public class TrapDiffblueTest {
  /**
   * Test {@link Trap#Trap()}.
   *
   * <ul>
   *   <li>Then return {@link Trap#types} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Trap#Trap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Trap.<init>()",
    "void Trap.<init>(LabelStmt, LabelStmt, LabelStmt[], String[])"
  })
  public void testNewTrap_thenReturnTypesIsNull() {
    // Arrange and Act
    Trap actualTrap = new Trap();

    // Assert
    assertNull(actualTrap.types);
    assertNull(actualTrap.handlers);
    assertNull(actualTrap.end);
    assertNull(actualTrap.start);
  }

  /**
   * Test {@link Trap#Trap(LabelStmt, LabelStmt, LabelStmt[], String[])}.
   *
   * <ul>
   *   <li>When nLabel.
   *   <li>Then return {@link Trap#end} Ops is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Trap#Trap(LabelStmt, LabelStmt, LabelStmt[], String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Trap.<init>()",
    "void Trap.<init>(LabelStmt, LabelStmt, LabelStmt[], String[])"
  })
  public void testNewTrap_whenNLabel_thenReturnEndOpsIsNull() {
    // Arrange
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();

    // Act
    Trap actualTrap =
        new Trap(start, end, new LabelStmt[] {Stmts.nLabel()}, new String[] {"Types"});

    // Assert
    LabelStmt labelStmt = actualTrap.end;
    assertNull(labelStmt.getOps());
    LabelStmt labelStmt2 = actualTrap.start;
    assertNull(labelStmt2.getOps());
    assertNull(labelStmt.getOp());
    assertNull(labelStmt2.getOp());
    assertNull(labelStmt.getOp1());
    assertNull(labelStmt2.getOp1());
    assertNull(labelStmt.getOp2());
    assertNull(labelStmt2.getOp2());
    assertNull(labelStmt.getNext());
    assertNull(labelStmt2.getNext());
    assertNull(labelStmt.getPre());
    assertNull(labelStmt2.getPre());
  }

  /**
   * Test {@link Trap#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link Trap#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Trap Trap.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenReturnArrayLengthIsOne() {
    // Arrange
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();
    Trap trap = new Trap(start, end, new LabelStmt[] {Stmts.nLabel()}, new String[] {"Types"});
    LabelAndLocalMapper mapper = new LabelAndLocalMapper();

    // Act
    Trap actualCloneResult = trap.clone(mapper);

    // Assert
    assertEquals(1, actualCloneResult.handlers.length);
    assertEquals(1, actualCloneResult.types.length);
    assertEquals(3, mapper.labels.size());
  }
}
