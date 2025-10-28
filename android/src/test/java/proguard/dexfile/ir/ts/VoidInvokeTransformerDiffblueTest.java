package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import org.junit.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.Local;

public class VoidInvokeTransformerDiffblueTest {
  /**
   * Method under test:
   * {@link VoidInvokeTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged() {
    // Arrange
    VoidInvokeTransformer voidInvokeTransformer = new VoidInvokeTransformer();

    // Act and Assert
    assertFalse(voidInvokeTransformer.transformReportChanged(new IrMethod()));
  }

  /**
   * Method under test:
   * {@link VoidInvokeTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged2() {
    // Arrange
    VoidInvokeTransformer voidInvokeTransformer = new VoidInvokeTransformer();

    ArrayList<Local> localList = new ArrayList<>();
    localList.add(new Local());
    IrMethod method = new IrMethod();
    method.locals = localList;

    // Act and Assert
    assertFalse(voidInvokeTransformer.transformReportChanged(method));
  }
}
