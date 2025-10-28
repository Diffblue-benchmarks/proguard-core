package proguard.dexfile.ir.ts;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.IrMethod;

public class UnSSATransformerDiffblueTest {
  /**
   * Method under test: {@link UnSSATransformer.LiveA#analyzeValue()}
   */
  @Test
  public void testLiveAAnalyzeValue() {
    // Arrange
    UnSSATransformer.LiveA liveA = new UnSSATransformer.LiveA(new IrMethod());

    // Act
    liveA.analyzeValue();

    // Assert
    assertNull(liveA.aValues);
  }

  /**
   * Method under test: {@link UnSSATransformer.LiveA#LiveA(IrMethod)}
   */
  @Test
  public void testLiveANewLiveA() {
    // Arrange, Act and Assert
    assertTrue((new UnSSATransformer.LiveA(new IrMethod())).aValues.isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link UnSSATransformer.RegAssign}
   */
  @Test
  public void testRegAssignNewRegAssign() {
    // Arrange, Act and Assert
    assertTrue((new UnSSATransformer.RegAssign()).excludes.isEmpty());
  }
}
