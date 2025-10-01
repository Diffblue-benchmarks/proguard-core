package proguard.dexfile.ir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Local;
import proguard.dexfile.ir.stmt.LabelStmt;
import proguard.dexfile.ir.stmt.Stmts;

class LocalVarDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalVar.<init>(String, String, String, LabelStmt, LabelStmt, Local)",
    "String LocalVar.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LabelStmt start = Stmts.nLabel();
    LabelStmt end = Stmts.nLabel();

    // Act
    LocalVar actualLocalVar = new LocalVar("Name", "Type", "Signature", start, end, new Local());
    actualLocalVar.toString();

    // Assert
    Local local = actualLocalVar.reg;
    assertEquals("a0", local.toString0());
    assertNull(local.getOp());
    assertNull(local.getOp1());
    assertNull(local.getOp2());
    LabelStmt labelStmt = actualLocalVar.end;
    assertNull(labelStmt.getOp());
    LabelStmt labelStmt2 = actualLocalVar.start;
    assertNull(labelStmt2.getOp());
    assertNull(labelStmt.getOp1());
    assertNull(labelStmt2.getOp1());
    assertNull(labelStmt.getOp2());
    assertNull(labelStmt2.getOp2());
    assertNull(local.getOps());
    assertNull(labelStmt.getOps());
    assertNull(labelStmt2.getOps());
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
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalVar LocalVar.clone(LabelAndLocalMapper)"})
  void testCloneWithLabelAndLocalMapper_thenReturnName() {
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
