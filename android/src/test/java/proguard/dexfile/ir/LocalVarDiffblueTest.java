package proguard.dexfile.ir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmts;

public class LocalVarDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocalVar#LocalVar(String, String, String, LabelStmt, LabelStmt, Local)}
   *   <li>{@link LocalVar#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVar.<init>(String, String, String, LabelStmt, LabelStmt, Local)",
    "String LocalVar.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();

    // Act
    LocalVar actualLocalVar = new LocalVar("Name", "Type", "Signature", start, end, new Local());
    actualLocalVar.toString();

    // Assert
    Local local = actualLocalVar.reg;
    assertEquals("a0", local.toString0());
    assertNull(local.getOps());
    LabelStmt labelStmt = actualLocalVar.end;
    assertNull(labelStmt.getOps());
    LabelStmt labelStmt2 = actualLocalVar.start;
    assertNull(labelStmt2.getOps());
    assertNull(local.getOp());
    assertNull(local.getOp1());
    assertNull(local.getOp2());
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
   * Test {@link LocalVar#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVar#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LocalVar LocalVar.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper_thenReturnName() {
    // Arrange
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();
    LocalVar localVar = new LocalVar("Name", "Type", "Signature", start, end, new Local());
    LabelAndLocalMapper map = new LabelAndLocalMapper();

    // Act
    LocalVar actualCloneResult = localVar.clone(map);

    // Assert
    assertEquals("Name", actualCloneResult.name);
    assertEquals("Signature", actualCloneResult.signature);
    assertEquals("Type", actualCloneResult.type);
    assertEquals(2, map.labels.size());
  }
}
