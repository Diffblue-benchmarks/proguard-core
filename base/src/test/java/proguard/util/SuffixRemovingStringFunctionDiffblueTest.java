package proguard.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SuffixRemovingStringFunctionDiffblueTest {
  /**
   * Method under test: {@link SuffixRemovingStringFunction#transform(String)}
   */
  @Test
  public void testTransform() {
    // Arrange, Act and Assert
    assertEquals("String", (new SuffixRemovingStringFunction("Suffix")).transform("String"));
    assertEquals("String", (new SuffixRemovingStringFunction("")).transform("String"));
  }
}
