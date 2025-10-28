package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertFalse;
import org.junit.Test;
import proguard.dexfile.ir.IrMethod;

public class MultiArrayTransformerDiffblueTest {
  /**
   * Method under test:
   * {@link MultiArrayTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  public void testTransformReportChanged() {
    // Arrange
    MultiArrayTransformer multiArrayTransformer = new MultiArrayTransformer();

    // Act and Assert
    assertFalse(multiArrayTransformer.transformReportChanged(new IrMethod()));
  }
}
