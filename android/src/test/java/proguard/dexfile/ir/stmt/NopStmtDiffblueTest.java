package proguard.dexfile.ir.stmt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.ET;
import proguard.dexfile.ir.LabelAndLocalMapper;
import proguard.dexfile.ir.stmt.Stmt.ST;

public class NopStmtDiffblueTest {
  /**
   * Test new {@link NopStmt} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NopStmt}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NopStmt.<init>()"})
  public void testNewNopStmt() {
    // Arrange and Act
    NopStmt actualNopStmt = new NopStmt();

    // Assert
    assertNull(actualNopStmt.getOps());
    assertNull(actualNopStmt.frame);
    assertNull(actualNopStmt.exceptionHandlers);
    assertNull(actualNopStmt._cfg_froms);
    assertNull(actualNopStmt.getOp());
    assertNull(actualNopStmt.getOp1());
    assertNull(actualNopStmt.getOp2());
    assertNull(actualNopStmt.getNext());
    assertNull(actualNopStmt.getPre());
    assertNull(actualNopStmt._ts_default_next);
    assertNull(actualNopStmt.list);
    assertEquals(0, actualNopStmt.id);
    assertEquals(ET.E0, actualNopStmt.et);
    assertEquals(ST.NOP, actualNopStmt.st);
    assertFalse(actualNopStmt.visited);
  }

  /**
   * Test {@link NopStmt#clone(LabelAndLocalMapper)} with {@code LabelAndLocalMapper}.
   *
   * <p>Method under test: {@link NopStmt#clone(LabelAndLocalMapper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Stmt NopStmt.clone(LabelAndLocalMapper)"})
  public void testCloneWithLabelAndLocalMapper() {
    // Arrange
    NopStmt nNopResult = Stmts.nNop();

    // Act
    Stmt actualCloneResult = nNopResult.clone(new LabelAndLocalMapper());

    // Assert
    assertTrue(actualCloneResult instanceof NopStmt);
    assertNull(actualCloneResult.getOps());
    assertNull(((NopStmt) actualCloneResult).frame);
    assertNull(((NopStmt) actualCloneResult).exceptionHandlers);
    assertNull(((NopStmt) actualCloneResult)._cfg_froms);
    assertNull(actualCloneResult.getOp());
    assertNull(actualCloneResult.getOp1());
    assertNull(actualCloneResult.getOp2());
    assertNull(actualCloneResult.getNext());
    assertNull(actualCloneResult.getPre());
    assertNull(((NopStmt) actualCloneResult)._ts_default_next);
    assertNull(((NopStmt) actualCloneResult).list);
    assertEquals(0, ((NopStmt) actualCloneResult).id);
    assertEquals(ET.E0, ((NopStmt) actualCloneResult).et);
    assertEquals(ST.NOP, ((NopStmt) actualCloneResult).st);
    assertFalse(((NopStmt) actualCloneResult).visited);
  }

  /**
   * Test {@link NopStmt#toString()}.
   *
   * <p>Method under test: {@link NopStmt#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String NopStmt.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("NOP", (new NopStmt()).toString());
  }
}
