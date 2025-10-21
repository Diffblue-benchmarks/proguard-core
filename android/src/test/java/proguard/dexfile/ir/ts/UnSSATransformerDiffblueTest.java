package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.ts.UnSSATransformer.LiveA;
import proguard.dexfile.ir.ts.UnSSATransformer.RegAssign;
import proguard.dexfile.ir.ts.an.BaseAnalyze;

public class UnSSATransformerDiffblueTest {
  /**
   * Test LiveA {@link LiveA#analyzeValue()}.
   *
   * <ul>
   *   <li>Then {@link LiveA#LiveA(IrMethod)} with method is {@link IrMethod} (default constructor)
   *       {@link BaseAnalyze#aValues} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LiveA#analyzeValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LiveA.analyzeValue()"})
  public void testLiveAAnalyzeValue_thenLiveAWithMethodIsIrMethodAValuesIsNull() {
    // Arrange
    LiveA liveA = new LiveA(new IrMethod());

    // Act
    liveA.analyzeValue();

    // Assert
    assertNull(liveA.aValues);
  }

  /**
   * Test LiveA {@link LiveA#LiveA(IrMethod)}.
   *
   * <ul>
   *   <li>When {@link IrMethod} (default constructor).
   *   <li>Then return {@link BaseAnalyze#aValues} Empty.
   * </ul>
   *
   * <p>Method under test: {@link LiveA#LiveA(IrMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LiveA.<init>(IrMethod)"})
  public void testLiveANewLiveA_whenIrMethod_thenReturnAValuesEmpty() {
    // Arrange, Act and Assert
    assertTrue((new LiveA(new IrMethod())).aValues.isEmpty());
  }

  /**
   * Test RegAssign new {@link RegAssign} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link RegAssign}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RegAssign.<init>()"})
  public void testRegAssignNewRegAssign() {
    // Arrange, Act and Assert
    assertTrue((new RegAssign()).excludes.isEmpty());
  }
}
