package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.IrMethod;

public class MultiArrayTransformerDiffblueTest {
  /**
   * Test {@link MultiArrayTransformer#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultiArrayTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MultiArrayTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged_whenIrMethod_thenReturnFalse() {
    // Arrange
    MultiArrayTransformer multiArrayTransformer = new MultiArrayTransformer();

    // Act and Assert
    assertFalse(multiArrayTransformer.transformReportChanged(new IrMethod()));
  }
}
