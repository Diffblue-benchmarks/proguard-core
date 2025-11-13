package proguard.dexfile.ir.expr;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractInvokeExprDiffblueTest {
  /**
   * Test {@link AbstractInvokeExpr#releaseMemory()}.
   *
   * <p>Method under test: {@link AbstractInvokeExpr#releaseMemory()}
   */
  @Test
  @DisplayName("Test releaseMemory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractInvokeExpr.releaseMemory()"})
  void testReleaseMemory() {
    // Arrange
    InvokeExpr nInvokeNewResult =
        Exprs.nInvokeNew(new Value[] {new ArrayExpr()}, new String[] {"Argment Types"}, "Owner");

    // Act
    nInvokeNewResult.releaseMemory();

    // Assert
    assertTrue(nInvokeNewResult instanceof InvokeNewExpr);
    assertNull(nInvokeNewResult.getName());
    assertNull(nInvokeNewResult.getOwner());
    assertNull(nInvokeNewResult.getRet());
    assertNull(nInvokeNewResult.getArgs());
    assertNull(nInvokeNewResult.getOps());
    assertNull(((InvokeNewExpr) nInvokeNewResult).method);
    assertNull(nInvokeNewResult.getProto());
  }
}
