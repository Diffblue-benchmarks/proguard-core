package proguard.dexfile.ir.ts;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.IrMethod;
import proguard.dexfile.ir.ts.UnSSATransformer.LiveA;
import proguard.dexfile.ir.ts.UnSSATransformer.RegAssign;
import proguard.dexfile.ir.ts.an.BaseAnalyze;

class UnSSATransformerDiffblueTest {
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
  @DisplayName(
      "Test LiveA analyzeValue(); then LiveA(IrMethod) with method is IrMethod (default constructor) aValues is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.ts.UnSSATransformer$LiveA.analyzeValue()"})
  void testLiveAAnalyzeValue_thenLiveAWithMethodIsIrMethodAValuesIsNull() {
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
  @DisplayName(
      "Test LiveA new LiveA(IrMethod); when IrMethod (default constructor); then return aValues Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.ir.ts.UnSSATransformer$LiveA.<init>(proguard.dexfile.ir.IrMethod)"
  })
  void testLiveANewLiveA_whenIrMethod_thenReturnAValuesEmpty() {
    // Arrange, Act and Assert
    assertTrue((new LiveA(new IrMethod())).aValues.isEmpty());
  }

  /**
   * Test RegAssign new {@link RegAssign} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link RegAssign}
   */
  @Test
  @DisplayName("Test RegAssign new RegAssign (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.dexfile.ir.ts.UnSSATransformer$RegAssign.<init>()"})
  void testRegAssignNewRegAssign() {
    // Arrange, Act and Assert
    assertTrue((new RegAssign()).excludes.isEmpty());
  }
}
