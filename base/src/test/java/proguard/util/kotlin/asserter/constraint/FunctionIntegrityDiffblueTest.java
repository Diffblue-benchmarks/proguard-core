package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class FunctionIntegrityDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link FunctionIntegrity}
   */
  @Test
  public void testNewFunctionIntegrity() {
    // Arrange and Act
    FunctionIntegrity actualFunctionIntegrity = new FunctionIntegrity();

    // Assert
    assertNull(actualFunctionIntegrity.libraryClassPool);
    assertNull(actualFunctionIntegrity.programClassPool);
    assertNull(actualFunctionIntegrity.reporter);
  }
}
