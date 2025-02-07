package proguard.dexfile.ir.stmt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.stmt.Stmt.ST;

class ReturnVoidStmtDiffblueTest {
  /**
   * Test new {@link ReturnVoidStmt} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ReturnVoidStmt}
   */
  @Test
  @DisplayName("Test new ReturnVoidStmt (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.stmt.ReturnVoidStmt.<init>()"})
  void testNewReturnVoidStmt() {
    // Arrange and Act
    ReturnVoidStmt actualReturnVoidStmt = new ReturnVoidStmt();

    // Assert
    assertNull(actualReturnVoidStmt.getOps());
    assertNull(actualReturnVoidStmt.frame);
    assertNull(actualReturnVoidStmt.exceptionHandlers);
    assertNull(actualReturnVoidStmt._cfg_froms);
    assertNull(actualReturnVoidStmt.getOp());
    assertNull(actualReturnVoidStmt.getOp1());
    assertNull(actualReturnVoidStmt.getOp2());
    assertNull(actualReturnVoidStmt.getNext());
    assertNull(actualReturnVoidStmt.getPre());
    assertNull(actualReturnVoidStmt._ts_default_next);
    assertNull(actualReturnVoidStmt.list);
    assertEquals(0, actualReturnVoidStmt.id);
    assertEquals(ET.E0, actualReturnVoidStmt.et);
    assertEquals(ST.RETURN_VOID, actualReturnVoidStmt.st);
    assertFalse(actualReturnVoidStmt.visited);
  }

  /**
   * Test {@link ReturnVoidStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link ReturnVoidStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @DisplayName("Test clone(LabelAndLocalMapper) with 'LabelAndLocalMapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.ir.stmt.Stmt proguard.dexfile.ir.stmt.ReturnVoidStmt.clone(proguard.dexfile.ir.LabelAndLocalMapper)"
  })
  void testCloneWithLabelAndLocalMapper() {
    // Arrange
    ReturnVoidStmt nReturnVoidResult = Stmts.nReturnVoid();

    // Act
    Stmt actualCloneResult = nReturnVoidResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof ReturnVoidStmt);
    assertNull(actualCloneResult.getOps());
    assertNull(((ReturnVoidStmt) actualCloneResult).frame);
    assertNull(((ReturnVoidStmt) actualCloneResult).exceptionHandlers);
    assertNull(((ReturnVoidStmt) actualCloneResult)._cfg_froms);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((ReturnVoidStmt) actualCloneResult)._ts_default_next);
    assertNull(((ReturnVoidStmt) actualCloneResult).list);
    assertEquals(0, ((ReturnVoidStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((ReturnVoidStmt) actualCloneResult).et);
    assertEquals(ST.RETURN_VOID, ((ReturnVoidStmt) actualCloneResult).st);
    assertFalse(((ReturnVoidStmt) actualCloneResult).visited);
  }

  /**
   * Test {@link ReturnVoidStmt#toString()}.
   *
   * <p>Method under test: {@link ReturnVoidStmt#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.dexfile.ir.stmt.ReturnVoidStmt.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("return", (new ReturnVoidStmt()).toString());
  }
}
