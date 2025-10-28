package proguard.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConstantStringFunctionDiffblueTest {
  /**
   * Method under test: {@link ConstantStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("String", (new ConstantStringFunction("String")).transform("String"));
  }
}
