package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.expr.Local;

public class VoidInvokeTransformerDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoidInvokeTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged_givenArrayListAddLocal_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean VoidInvokeTransformer.transformReportChanged(IrMethod)"})
  public void testTransformReportChanged_whenIrMethod_thenReturnFalse() {
    // Arrange
    VoidInvokeTransformer voidInvokeTransformer = new VoidInvokeTransformer();

    // Act and Assert
    assertFalse(voidInvokeTransformer.transformReportChanged(new IrMethod()));
  }
}
