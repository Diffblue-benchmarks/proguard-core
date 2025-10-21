package proguard.dexfile.ir.expr;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractInvokeExprDiffblueTest {
  /**
   * Test {@link AbstractInvokeExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link AbstractInvokeExpr#releaseMemory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractInvokeExpr.releaseMemory()"})
  public void testReleaseMemory() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");

    // Act
    nInvokeNewResult.releaseMemory();

    // Assert
    assertTrue(nInvokeNewResult instanceof InvokeNewExpr);
    assertNull(nInvokeNewResult.getArgs());
    assertNull(nInvokeNewResult.getOps());
    assertNull(nInvokeNewResult.getName());
    assertNull(nInvokeNewResult.getOwner());
    assertNull(nInvokeNewResult.getRet());
    assertNull(((InvokeNewExpr) nInvokeNewResult).method);
    assertNull(nInvokeNewResult.getProto());
  }
}
