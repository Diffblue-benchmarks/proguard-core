package proguard.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ExtensionMatcherDiffblueTest {
  /**
   * Method under test: {@link ExtensionMatcher#matches(String, int, int)}
   */
  @Test
  public void testMatches() {
    // Arrange, Act and Assert
    assertFalse((new ExtensionMatcher("Extension")).matches("String", 1, 3));
    assertTrue((new ExtensionMatcher("")).matches("String", 1, 3));
  }
}
