package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.IrMethod;

class MultiArrayTransformerDiffblueTest {
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
  @DisplayName(
      "Test transformReportChanged(IrMethod); when IrMethod (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultiArrayTransformer.transformReportChanged(IrMethod)"})
  void testTransformReportChanged_whenIrMethod_thenReturnFalse() {
    // Arrange
    MultiArrayTransformer multiArrayTransformer = new MultiArrayTransformer();

    // Act and Assert
    assertFalse(multiArrayTransformer.transformReportChanged(new IrMethod()));
  }
}
