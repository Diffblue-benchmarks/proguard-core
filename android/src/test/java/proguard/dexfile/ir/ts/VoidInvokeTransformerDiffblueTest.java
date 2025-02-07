package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.Local;

class VoidInvokeTransformerDiffblueTest {
  /**
   * Test {@link VoidInvokeTransformer#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Local#Local()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VoidInvokeTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transformReportChanged(IrMethod); given ArrayList() add Local(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.ir.ts.VoidInvokeTransformer.transformReportChanged(proguard.dexfile.ir.IrMethod)"
  })
  void testTransformReportChanged_givenArrayListAddLocal_thenReturnFalse() {
    // Arrange
    VoidInvokeTransformer voidInvokeTransformer = new VoidInvokeTransformer();

    ArrayList<Local> localList = new ArrayList<>();
    localList.add(new Local());
    IrMethod method = new IrMethod();
    method.locals = localList;

    // Act and Assert
    assertFalse(voidInvokeTransformer.transformReportChanged(method));
  }

  /**
   * Test {@link VoidInvokeTransformer#transformReportChanged(IrMethod)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VoidInvokeTransformer#transformReportChanged(IrMethod)}
   */
  @Test
  @DisplayName(
      "Test transformReportChanged(IrMethod); when IrMethod (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.dexfile.ir.ts.VoidInvokeTransformer.transformReportChanged(proguard.dexfile.ir.IrMethod)"
  })
  void testTransformReportChanged_whenIrMethod_thenReturnFalse() {
    // Arrange
    VoidInvokeTransformer voidInvokeTransformer = new VoidInvokeTransformer();

    // Act and Assert
    assertFalse(voidInvokeTransformer.transformReportChanged(new IrMethod()));
  }
}
