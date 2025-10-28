package proguard.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SuffixAddingStringFunctionDiffblueTest {
  /**
   * Method under test: {@link SuffixAddingStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("StringSuffix", (new SuffixAddingStringFunction("Suffix")).transform("String"));
  }
}
